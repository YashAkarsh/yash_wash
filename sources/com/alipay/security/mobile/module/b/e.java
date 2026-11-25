package com.alipay.security.mobile.module.b;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static e f13906a = new e();

    private e() {
    }

    public static e a() {
        return f13906a;
    }

    private static String b(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    public static boolean c(Context context) {
        boolean z7;
        int length;
        try {
            if (!Build.HARDWARE.contains("goldfish") && !Build.PRODUCT.contains(ServerProtocol.DIALOG_PARAM_SDK_VERSION) && !Build.FINGERPRINT.contains(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    String deviceId = telephonyManager.getDeviceId();
                    if (deviceId != null && (length = deviceId.length()) != 0) {
                        int i7 = 0;
                        while (true) {
                            if (i7 >= length) {
                                z7 = true;
                                break;
                            }
                            if (!Character.isWhitespace(deviceId.charAt(i7)) && deviceId.charAt(i7) != '0') {
                                z7 = false;
                                break;
                            }
                            i7++;
                        }
                    } else {
                        z7 = true;
                        break;
                    }
                    if (z7) {
                        return true;
                    }
                }
                return o0.a.d(Settings.Secure.getString(context.getContentResolver(), "android_id"));
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String d() {
        return "android";
    }

    public static boolean e() {
        String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        for (int i7 = 0; i7 < 5; i7++) {
            try {
                if (new File(strArr[i7] + "su").exists()) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static String f() {
        return Build.BOARD;
    }

    public static String g() {
        return Build.BRAND;
    }

    public static String h() {
        return Build.DEVICE;
    }

    public static String i() {
        return Build.DISPLAY;
    }

    public static String j() {
        return Build.VERSION.INCREMENTAL;
    }

    public static String k() {
        return Build.MANUFACTURER;
    }

    public static String l() {
        return Build.MODEL;
    }

    public static String m() {
        return Build.PRODUCT;
    }

    public static String n() {
        return Build.VERSION.RELEASE;
    }

    public static String o() {
        return Build.VERSION.SDK;
    }

    public static String p() {
        return Build.TAGS;
    }

    public static String q() {
        return b("ro.kernel.qemu", "0");
    }
}
