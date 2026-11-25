package com.facebook.devicerequests.internal;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import androidx.core.view.n2;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.Utility;
import com.google.zxing.a;
import com.google.zxing.common.b;
import com.google.zxing.g;
import com.google.zxing.l;
import com.google.zxing.w;
import java.util.EnumMap;
import java.util.HashMap;
import org.apache.commons.lang3.ClassUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DeviceRequestsHelper {
    static final String DEVICE_INFO_DEVICE = "device";
    static final String DEVICE_INFO_MODEL = "model";
    public static final String DEVICE_INFO_PARAM = "device_info";
    public static final String DEVICE_TARGET_USER_ID = "target_user_id";
    static final String SDK_FLAVOR = "android";
    static final String SDK_HEADER = "fbsdk";
    static final String SERVICE_TYPE = "_fb._tcp.";
    private static final String TAG = "com.facebook.devicerequests.internal.DeviceRequestsHelper";
    private static HashMap<String, NsdManager.RegistrationListener> deviceRequestsListeners = new HashMap<>();

    public static void cleanUpAdvertisementService(String str) {
        cleanUpAdvertisementServiceImpl(str);
    }

    @TargetApi(16)
    private static void cleanUpAdvertisementServiceImpl(String str) {
        NsdManager.RegistrationListener registrationListener = deviceRequestsListeners.get(str);
        if (registrationListener != null) {
            try {
                ((NsdManager) FacebookSdk.getApplicationContext().getSystemService("servicediscovery")).unregisterService(registrationListener);
            } catch (IllegalArgumentException e8) {
                Utility.logd(TAG, e8);
            }
            deviceRequestsListeners.remove(str);
        }
    }

    public static Bitmap generateQRCode(String str) {
        EnumMap enumMap = new EnumMap(g.class);
        enumMap.put(g.MARGIN, 2);
        Bitmap bitmapCreateBitmap = null;
        try {
            b bVarB = new l().b(str, a.QR_CODE, 200, 200, enumMap);
            int iM = bVarB.m();
            int iQ = bVarB.q();
            int[] iArr = new int[iM * iQ];
            for (int i7 = 0; i7 < iM; i7++) {
                int i8 = i7 * iQ;
                for (int i9 = 0; i9 < iQ; i9++) {
                    iArr[i8 + i9] = bVarB.j(i9, i7) ? n2.f6743t : -1;
                }
            }
            bitmapCreateBitmap = Bitmap.createBitmap(iQ, iM, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.setPixels(iArr, 0, iQ, 0, 0, iQ, iM);
            return bitmapCreateBitmap;
        } catch (w unused) {
            return bitmapCreateBitmap;
        }
    }

    public static String getDeviceInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device", Build.DEVICE);
            jSONObject.put("model", Build.MODEL);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public static boolean isAvailable() {
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        return appSettingsWithoutQuery != null && appSettingsWithoutQuery.getSmartLoginOptions().contains(SmartLoginOption.Enabled);
    }

    public static boolean startAdvertisementService(String str) {
        if (isAvailable()) {
            return startAdvertisementServiceImpl(str);
        }
        return false;
    }

    @TargetApi(16)
    private static boolean startAdvertisementServiceImpl(final String str) {
        if (deviceRequestsListeners.containsKey(str)) {
            return true;
        }
        final String str2 = String.format("%s_%s_%s", SDK_HEADER, String.format("%s-%s", "android", FacebookSdk.getSdkVersion().replace(ClassUtils.PACKAGE_SEPARATOR_CHAR, '|')), str);
        NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
        nsdServiceInfo.setServiceType(SERVICE_TYPE);
        nsdServiceInfo.setServiceName(str2);
        nsdServiceInfo.setPort(80);
        NsdManager nsdManager = (NsdManager) FacebookSdk.getApplicationContext().getSystemService("servicediscovery");
        NsdManager.RegistrationListener registrationListener = new NsdManager.RegistrationListener() { // from class: com.facebook.devicerequests.internal.DeviceRequestsHelper.1
            @Override // android.net.nsd.NsdManager.RegistrationListener
            public void onRegistrationFailed(NsdServiceInfo nsdServiceInfo2, int i7) {
                DeviceRequestsHelper.cleanUpAdvertisementService(str);
            }

            @Override // android.net.nsd.NsdManager.RegistrationListener
            public void onServiceRegistered(NsdServiceInfo nsdServiceInfo2) {
                if (str2.equals(nsdServiceInfo2.getServiceName())) {
                    return;
                }
                DeviceRequestsHelper.cleanUpAdvertisementService(str);
            }

            @Override // android.net.nsd.NsdManager.RegistrationListener
            public void onServiceUnregistered(NsdServiceInfo nsdServiceInfo2) {
            }

            @Override // android.net.nsd.NsdManager.RegistrationListener
            public void onUnregistrationFailed(NsdServiceInfo nsdServiceInfo2, int i7) {
            }
        };
        deviceRequestsListeners.put(str, registrationListener);
        nsdManager.registerService(nsdServiceInfo, 1, registrationListener);
        return true;
    }
}
