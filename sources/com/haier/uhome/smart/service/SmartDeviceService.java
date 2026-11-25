package com.haier.uhome.smart.service;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.haier.library.common.b.r;
import com.haier.library.common.thread.m;
import com.haier.library.common.util.v;
import com.haier.library.common.util.w;
import com.haier.library.okhttp.j0;
import com.haier.uhome.smart.ConstSmartDevice;
import com.haier.uhome.smart.api.AbsSmartDevice;
import com.haier.uhome.smart.api.AnnexDevice;
import com.haier.uhome.smart.api.BaseSmartRsp;
import com.haier.uhome.smart.api.CommunicationProtocol;
import com.haier.uhome.smart.api.DeviceGroup.DeviceGroupReqType;
import com.haier.uhome.smart.api.MessagePush;
import com.haier.uhome.smart.api.MessageStatusAck;
import com.haier.uhome.smart.api.OtaMode;
import com.haier.uhome.smart.api.RegisterResult;
import com.haier.uhome.smart.api.ResourceFile;
import com.haier.uhome.smart.api.SDKState;
import com.haier.uhome.smart.api.SlaveDevice;
import com.haier.uhome.smart.api.SmartDevice;
import com.haier.uhome.smart.api.SmartDevicePair;
import com.haier.uhome.smart.api.SmartOpRsp;
import com.haier.uhome.smart.api.SmartReadRsp;
import com.haier.uhome.smart.api.StartOption;
import com.haier.uhome.smart.api.interfaces.IDeviceGroupListener;
import com.haier.uhome.smart.api.interfaces.IScanListener;
import com.haier.uhome.smart.api.interfaces.ISmartDeviceBindStatusListener;
import com.haier.uhome.smart.api.interfaces.ISmartDeviceListener;
import com.haier.uhome.smart.api.interfaces.ISmartDeviceManagerListener;
import com.haier.uhome.smart.api.interfaces.ISmartDeviceOtaListener;
import com.haier.uhome.smart.api.interfaces.ISmartDevicePairingListener;
import com.haier.uhome.smart.api.interfaces.ISmartDeviceResourceListener;
import com.haier.uhome.smart.handler.AbsSmartDeviceNotifier;
import com.haier.uhome.smart.handler.ISmartBindNotifier;
import com.haier.uhome.smart.handler.ISmartDeviceGroupNotifier;
import com.haier.uhome.smart.handler.ISmartDeviceNotifier;
import com.haier.uhome.smart.handler.ISmartDeviceOtaNotifer;
import com.haier.uhome.smart.handler.SmartDeviceNotifier;
import com.haier.uhome.smart.json.Pair;
import com.haier.uhome.smart.json.SmartProtocol;
import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.o;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class SmartDeviceService implements ISmartBindNotifier, ISmartDeviceGroupNotifier {
    private boolean adding;
    private AuthInfo mAuthInfo;
    private ConcurrentHashMap<String, String> mBindWindowInfo;
    private int mCloudState;
    private Context mContext;
    private com.haier.library.common.b.e mIConnectStatusObserver;
    private IDeviceGroupListener mIDeviceGroupListener;
    private IScanListener mIScanListener;
    private ISmartDeviceGroupNotifier mISmartDeviceGroupNotifier;
    private String mMac;
    private CopyOnWriteArrayList<ISmartDeviceManagerListener> mManagerListenerList;
    private NativeService mNativeService;
    private ConcurrentHashMap<String, AbsSmartDevice> mOnlineDevices;
    private SmartConfig mSmartConfig;
    private ISmartDeviceNotifier mSmartDeviceNotifier;
    private ISmartDeviceOtaNotifer mSmartDeviceOtaNotifer;
    private ConcurrentHashMap<String, SmartDevice> mSmartDevices;
    private SDKState mState;
    private final Object obj;

    /* JADX INFO: Access modifiers changed from: private */
    class AuthInfo {
        private String authToken;
        private int authType;

        /* JADX INFO: Access modifiers changed from: private */
        public String getAuthToken() {
            return this.authToken;
        }

        private int getAuthType() {
            return this.authType;
        }

        private boolean tokenEquals(String str, String str2) {
            if (str == null || str2 == null) {
                return false;
            }
            return str.equals(str2);
        }

        public boolean equals(Object obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            AuthInfo authInfo = (AuthInfo) obj;
            if (authInfo.authType != this.authType) {
                return false;
            }
            return tokenEquals(authInfo.authToken, this.authToken);
        }

        public int hashCode() {
            return 527 + (TextUtils.isEmpty(this.authToken) ? 0 : this.authToken.hashCode()) + this.authType;
        }

        private AuthInfo(int i7, String str) {
            this.authType = i7;
            this.authToken = str;
        }
    }

    private static class SingletonFactory {
        private static SmartDeviceService sInstance = new SmartDeviceService();

        private SingletonFactory() {
        }
    }

    private final class SmartConfig {
        String authKey;
        String devId;
        String devIdPrefix;
        String serverType;
        String typeId;

        private SmartConfig() {
        }

        public String toString() {
            return "SmartConfig{devIdPrefix=" + this.devIdPrefix + ", devId=" + this.devId + ", typeId=" + this.typeId + ", authKey=" + this.authKey + ", serverType=" + this.serverType + '}';
        }
    }

    private String binaryToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i7 = 0; i7 < bArr.length; i7++) {
            sb.append(String.valueOf("0123456789abcdef".charAt((bArr[i7] & 240) >> 4)));
            sb.append(String.valueOf("0123456789abcdef".charAt(bArr[i7] & com.google.common.base.c.f19317q)));
        }
        return sb.toString();
    }

    private boolean checkParamisOk(SmartDevice smartDevice) {
        if (smartDevice == null) {
            e3.a.h("device is null.", new Object[0]);
            return false;
        }
        if (smartDevice.getHwVersion() == null || smartDevice.getHwVersion().length() <= 0 || smartDevice.getHwVersion().length() > 16) {
            e3.a.h("device hwVersion is invalid.", new Object[0]);
            return false;
        }
        if (!isDeviceVersionOk(smartDevice.getHwVersion())) {
            e3.a.h("device hwVersion<%s> is invalid.", smartDevice.getHwVersion());
            return false;
        }
        if (smartDevice.getSwVersion() == null || smartDevice.getSwVersion().length() <= 0 || smartDevice.getSwVersion().length() > 16) {
            e3.a.h("device swVersion is invalid.", new Object[0]);
            return false;
        }
        if (!isDeviceVersionOk(smartDevice.getSwVersion())) {
            e3.a.h("device swVersion<%s> is invalid.", smartDevice.getSwVersion());
            return false;
        }
        if (!TextUtils.isEmpty(smartDevice.getUplusId()) && smartDevice.getUplusId().matches(ConstSmartDevice.REGEX_UPLUSID)) {
            return true;
        }
        e3.a.h("device uplusId is invalid.", new Object[0]);
        return false;
    }

    private void delAnnexDevice(AbsSmartDevice absSmartDevice) {
        for (AbsSmartDevice absSmartDevice2 : getOnlineDeviceList()) {
            if ((absSmartDevice2 instanceof AnnexDevice) && ((AnnexDevice) absSmartDevice2).getParentId().equals(absSmartDevice.getDeviceId())) {
                tryDelDevice(absSmartDevice2.getDeviceId());
                this.mOnlineDevices.remove(absSmartDevice2.getDeviceId());
                notifyDeviceDel(absSmartDevice2.getDeviceId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delDeviceInner(AbsSmartDevice absSmartDevice) {
        if (absSmartDevice == null) {
            return;
        }
        for (AbsSmartDevice absSmartDevice2 : getOnlineDeviceList()) {
            if ((absSmartDevice2 instanceof SlaveDevice) && ((SlaveDevice) absSmartDevice2).getParentId().equals(absSmartDevice.getDeviceId())) {
                delAnnexDevice(absSmartDevice2);
                tryDelDevice(absSmartDevice2.getDeviceId());
                this.mOnlineDevices.remove(absSmartDevice2.getDeviceId());
                notifyDeviceDel(absSmartDevice2.getDeviceId());
            } else if ((absSmartDevice2 instanceof AnnexDevice) && ((AnnexDevice) absSmartDevice2).getParentId().equals(absSmartDevice.getDeviceId())) {
                tryDelDevice(absSmartDevice2.getDeviceId());
                this.mOnlineDevices.remove(absSmartDevice2.getDeviceId());
                notifyDeviceDel(absSmartDevice2.getDeviceId());
            }
        }
    }

    private String fixDevId(String str) {
        if (!TextUtils.isEmpty(str) && str.matches(ConstSmartDevice.REGEX_FULL_DEV_ID)) {
            int length = str.length();
            if (length <= 16) {
                return getDevIdPrefix() + str.toUpperCase();
            }
            String devIdPrefix = getDevIdPrefix();
            if (str.startsWith(devIdPrefix)) {
                return str;
            }
            int i7 = length - 16;
            if (devIdPrefix.endsWith(str.substring(i7).toUpperCase())) {
                return getDevIdPrefix() + str.substring(i7).toUpperCase();
            }
        }
        return null;
    }

    private String fixDeviceId(String str) {
        SmartDevice deviceById = getDeviceById(str);
        AbsSmartDevice onlineDeviceById = getOnlineDeviceById(str);
        if (deviceById != null) {
            return deviceById.getDevId();
        }
        if (onlineDeviceById != null) {
            return onlineDeviceById.getDeviceId();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<SmartDevicePair> genSmartDevicePair(ArrayList<Pair> arrayList) {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        ArrayList arrayList2 = new ArrayList();
        for (Pair pair : arrayList) {
            arrayList2.add(new SmartDevicePair(pair.getName(), pair.getValue()));
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getClientId() {
        String strZ = com.haier.library.common.util.f.z(this.mContext);
        if (!TextUtils.isEmpty(strZ)) {
            e3.a.e("getClientId<%s>", strZ);
            return strZ.replace(":", "").toUpperCase();
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(com.haier.uhome.usdk.base.service.e.a().k().getBytes());
            byte[] bArrDigest = messageDigest.digest();
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (int i7 = 0; i7 < bArrDigest.length; i7++) {
                sb.append(cArr[(bArrDigest[i7] & 240) >>> 4]);
                sb.append(cArr[bArrDigest[i7] & com.google.common.base.c.f19317q]);
            }
            return sb.substring(10, 22);
        } catch (NoSuchAlgorithmException e8) {
            e3.a.h("getClientId NoSuchAlgorithmException <%s>", e8.getMessage());
            return null;
        }
    }

    public static SmartDeviceService getInstance() {
        return SingletonFactory.sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPairJson(List<SmartDevicePair> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        com.haier.library.json.b bVar = new com.haier.library.json.b(list.size());
        for (SmartDevicePair smartDevicePair : list) {
            com.haier.library.json.e eVar = new com.haier.library.json.e(2);
            String name = smartDevicePair.getName();
            String str = "";
            if (TextUtils.isEmpty(name)) {
                name = "";
            }
            eVar.put("name", name);
            String value = smartDevicePair.getValue();
            if (!TextUtils.isEmpty(value)) {
                str = value;
            }
            eVar.put("value", str);
            bVar.add(eVar);
        }
        return bVar.k();
    }

    private String getSign(String str, String str2, String str3, String str4) {
        try {
            try {
                String path = new URL(str4).getPath();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(path);
                stringBuffer.append(str);
                stringBuffer.append(str2);
                stringBuffer.append(str3);
                return binaryToHexString(MessageDigest.getInstance("SHA-256").digest(stringBuffer.toString().getBytes("utf-8")));
            } catch (UnsupportedEncodingException e8) {
                e3.a.g("getSign UnsupportedEncodingException exception<%s>", e8.getCause());
                e8.printStackTrace();
                return "";
            } catch (MalformedURLException e9) {
                e3.a.g("getSign MalformedURLException exception<%s>", e9.getCause());
                e9.printStackTrace();
                return "";
            } catch (NoSuchAlgorithmException e10) {
                e3.a.g("getSign NoSuchAlgorithmException exception<%s>", e10.getCause());
                e10.printStackTrace();
                return "";
            }
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerUSDKReq(final String str, final String str2, final int i7, final int i8) {
        new m<Void, Void, Void>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.36
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public Void doInBackground(Void... voidArr) {
                AckService.getInstance().sendReqAck(str, str2, i7, i8);
                return null;
            }
        }.execute(new Void[0]);
    }

    private boolean isDeviceVersionOk(String str) {
        if (str == null || str.length() <= 0) {
            e3.a.h("deviceVersion is invalid.", new Object[0]);
            return false;
        }
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit == null || strArrSplit.length <= 0) {
            e3.a.h("deviceVersion<%s> is invalid.", str);
            return false;
        }
        for (String str2 : strArrSplit) {
            try {
                int iIntValue = Integer.valueOf(str2).intValue();
                if (iIntValue < 0 || iIntValue > 1000) {
                    e3.a.h("deviceVersion<%s> is invalid.", str);
                    return false;
                }
            } catch (NumberFormatException e8) {
                e8.printStackTrace();
                e3.a.h("deviceVersion<%s> is invalid.", str);
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addListener$0() {
        Iterator<SmartDevice> it = getDeviceList().iterator();
        while (it.hasNext()) {
            notifyDeviceAdd(it.next().getDevId());
        }
        Iterator<AbsSmartDevice> it2 = getOnlineDeviceList().iterator();
        while (it2.hasNext()) {
            notifyDeviceAdd(it2.next().getDeviceId());
        }
        AuthInfo authInfo = this.mAuthInfo;
        if (authInfo != null) {
            notifyDeviceAuthToken(authInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$9(com.haier.library.common.b.a aVar) {
        if (aVar.h()) {
            int iA = aVar.a();
            if (iA == 1 || iA == 9) {
                refreshNetwork(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$notifyDeviceAdd$1(ISmartDeviceManagerListener iSmartDeviceManagerListener, String str) {
        e3.a.e("notifyDeviceAdd to <%s> with <%s>", iSmartDeviceManagerListener, str);
        iSmartDeviceManagerListener.onDeviceAdd(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$notifyDeviceAuthToken$3(ISmartDeviceManagerListener iSmartDeviceManagerListener, AuthInfo authInfo) {
        e3.a.e("notifyDeviceAuthToken to <%s> with st<%d> token<%s>", iSmartDeviceManagerListener, Integer.valueOf(authInfo.authType), authInfo.authToken);
        iSmartDeviceManagerListener.onAuthToken(authInfo.authType, authInfo.authToken);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$notifyDeviceDel$2(ISmartDeviceManagerListener iSmartDeviceManagerListener, String str) {
        e3.a.e("notifyDeviceDel to <%s> with <%s>", iSmartDeviceManagerListener, str);
        iSmartDeviceManagerListener.onDeviceRemove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$tryAddDeviceRelation$10(String str, String str2, AbsSmartDeviceNotifier[] absSmartDeviceNotifierArr, final com.haier.library.common.thread.g gVar) {
        e3.a.e(String.format("tryAddDeviceRelation devId<%s> traceId<%s>", str, str2), new Object[0]);
        int iAddDeviceRelation = this.mNativeService.addDeviceRelation(str, TextUtils.isEmpty(str2) ? "" : str2);
        e3.a.e(String.format("tryAddDeviceRelation devId<%s> traceId<%s> ret<%d>", str, str2, Integer.valueOf(iAddDeviceRelation)), new Object[0]);
        if (iAddDeviceRelation == ErrorConst.RET_USDK_OK.getErrorId()) {
            absSmartDeviceNotifierArr[0] = new AbsSmartDeviceNotifier() { // from class: com.haier.uhome.smart.service.SmartDeviceService.40
                @Override // com.haier.uhome.smart.handler.AbsSmartDeviceNotifier, com.haier.uhome.smart.handler.ISmartDeviceNotifier
                public void notifyDeviceRelationResult(String str3, int i7) {
                    e3.a.e("notifyDeviceRelationResult " + str3 + " result <%d>", Integer.valueOf(i7));
                    if (i7 == 0) {
                        gVar.a(ErrorConst.RET_USDK_OK.toError());
                        return;
                    }
                    uSDKError usdkerror = new uSDKError(i7);
                    usdkerror.a("ugw error");
                    gVar.a(usdkerror);
                }
            };
            SmartDeviceNotifier.getInstance().addNotifier(absSmartDeviceNotifierArr[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$tryBindDevice$6(String str, String str2, TraceNode traceNode, double d8, AbsSmartDeviceNotifier[] absSmartDeviceNotifierArr, final com.haier.library.common.thread.g gVar) {
        int iC = com.haier.uhome.usdk.base.c.f.a().c();
        e3.a.d("SMARTDEVICE", "bindDevice", "tryBindDevice devId<%s> token<%s> traceId<%s> timeout<%d> sn<%d>", str, str2, traceNode.getTraceId(), Double.valueOf(d8), Integer.valueOf(iC));
        int iBindDevice = this.mNativeService.bindDevice(str, str2, traceNode.getTraceId(), d8, iC);
        e3.a.d("SMARTDEVICE", "bindDevice", "tryBindDevice devId<%s> token<%s> traceId<%s> timeout<%d> sn<%d> ret<%d>", str, str2, traceNode.getTraceId(), Double.valueOf(d8), Integer.valueOf(iC), Integer.valueOf(iBindDevice));
        if (iBindDevice == ErrorConst.RET_USDK_OK.getErrorId()) {
            absSmartDeviceNotifierArr[0] = new AbsSmartDeviceNotifier() { // from class: com.haier.uhome.smart.service.SmartDeviceService.11
                @Override // com.haier.uhome.smart.handler.AbsSmartDeviceNotifier, com.haier.uhome.smart.handler.ISmartDeviceNotifier
                public void notifyDeviceBindResult(String str3, int i7, int i8, int i9) {
                    e3.a.e("notifyDeviceBindResult " + str3 + " result <%d>", Integer.valueOf(i8));
                    if (i8 == 0) {
                        gVar.a(ErrorConst.RET_USDK_OK);
                    } else {
                        gVar.a(ErrorConst.ERR_INTERNAL);
                    }
                }
            };
            SmartDeviceNotifier.getInstance().addNotifier(absSmartDeviceNotifierArr[0]);
        }
        com.haier.uhome.trace.api.b.a().g(iBindDevice, str, traceNode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$tryBindSlaveDevice$7(String str, String str2, AbsSmartDeviceNotifier[] absSmartDeviceNotifierArr, final com.haier.library.common.thread.g gVar) {
        e3.a.d("", "", "tryBindSlaveDevice devId<%s> traceId<%s>", str, str2);
        NativeService nativeService = this.mNativeService;
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        int iBindSlaveDevice = nativeService.bindSlaveDevice(str, str2);
        e3.a.d("", "", "tryBindSlaveDevice ret<%d>", Integer.valueOf(iBindSlaveDevice));
        if (iBindSlaveDevice == ErrorConst.RET_USDK_OK.getErrorId()) {
            absSmartDeviceNotifierArr[0] = new AbsSmartDeviceNotifier() { // from class: com.haier.uhome.smart.service.SmartDeviceService.25
                @Override // com.haier.uhome.smart.handler.AbsSmartDeviceNotifier, com.haier.uhome.smart.handler.ISmartDeviceNotifier
                public void notifySlaveDeviceBindResult(String str3, int i7) {
                    e3.a.e("notifySlaveDeviceBindResult " + str3 + " result <%d>", Integer.valueOf(i7));
                    if (i7 == 0) {
                        gVar.a(ErrorConst.RET_USDK_OK.toError());
                        return;
                    }
                    uSDKError usdkerror = new uSDKError(i7);
                    usdkerror.a("ugw error");
                    gVar.a(usdkerror);
                }
            };
            SmartDeviceNotifier.getInstance().addNotifier(absSmartDeviceNotifierArr[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$tryGetBindQRCode$4(SmartDevice smartDevice, com.haier.uhome.usdk.base.api.c cVar, com.haier.library.common.thread.g gVar) {
        e3.a.e("tryGetBindQRCode deviceId : " + smartDevice.getDevId() + " uplusId ： " + smartDevice.getUplusId(), new Object[0]);
        String bindQRCode = this.mNativeService.getBindQRCode(smartDevice.getDevId(), smartDevice.getUplusId());
        StringBuilder sb = new StringBuilder();
        sb.append("tryGetBindQRCode qrCodeInfo : ");
        sb.append(bindQRCode);
        e3.a.e(sb.toString(), new Object[0]);
        if (TextUtils.isEmpty(bindQRCode)) {
            cVar.a((Object) null);
            cVar.a(ErrorConst.ERR_INTERNAL);
        } else {
            cVar.a(ErrorConst.RET_USDK_OK);
            cVar.a(new String(Base64.decode(bindQRCode.getBytes(), 2)));
        }
        gVar.a(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$tryGetBindQRCode$5(AbsSmartDevice absSmartDevice, com.haier.uhome.usdk.base.api.c cVar, com.haier.library.common.thread.g gVar) {
        e3.a.e("tryGetBindQRCode deviceId : " + absSmartDevice.getDeviceId() + " uplusId ： " + absSmartDevice.getUplusId(), new Object[0]);
        String bindQRCode = this.mNativeService.getBindQRCode(absSmartDevice.getDeviceId(), absSmartDevice.getUplusId());
        StringBuilder sb = new StringBuilder();
        sb.append("tryGetBindQRCode qrCodeInfo : ");
        sb.append(bindQRCode);
        e3.a.e(sb.toString(), new Object[0]);
        if (TextUtils.isEmpty(bindQRCode)) {
            cVar.a((Object) null);
            cVar.a(ErrorConst.ERR_INTERNAL);
        } else {
            cVar.a(ErrorConst.RET_USDK_OK);
            cVar.a(new String(Base64.decode(bindQRCode.getBytes(), 2)));
        }
        gVar.a(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$tryUnBindSlaveDevice$8(String str, String str2, AbsSmartDeviceNotifier[] absSmartDeviceNotifierArr, final com.haier.library.common.thread.g gVar) {
        e3.a.d("", "", "tryUnBindSlaveDevice devId<%s> traceId<%s>", str, str2);
        int iUnBindSlaveDevice = this.mNativeService.unBindSlaveDevice(str, str2);
        e3.a.d("", "", "tryUnBindSlaveDevice ret<%d>", Integer.valueOf(iUnBindSlaveDevice));
        if (iUnBindSlaveDevice == ErrorConst.RET_USDK_OK.getErrorId()) {
            absSmartDeviceNotifierArr[0] = new AbsSmartDeviceNotifier() { // from class: com.haier.uhome.smart.service.SmartDeviceService.27
                @Override // com.haier.uhome.smart.handler.AbsSmartDeviceNotifier, com.haier.uhome.smart.handler.ISmartDeviceNotifier
                public void notifySlaveDeviceUnbindResult(String str3, int i7) {
                    e3.a.e("notifySlaveDeviceUnbindResult " + str3 + " result <%d>", Integer.valueOf(i7));
                    if (i7 == 0) {
                        gVar.a(ErrorConst.RET_USDK_OK.toError());
                        return;
                    }
                    uSDKError usdkerror = new uSDKError(i7);
                    usdkerror.a("ugw error");
                    gVar.a(usdkerror);
                }
            };
            SmartDeviceNotifier.getInstance().addNotifier(absSmartDeviceNotifierArr[0]);
        }
    }

    private void notifyCloudState(int i7) {
        for (ISmartDeviceManagerListener iSmartDeviceManagerListener : this.mManagerListenerList) {
            e3.a.e("notifyCloudState to <%s> with <%d>", iSmartDeviceManagerListener, Integer.valueOf(i7));
            iSmartDeviceManagerListener.onCloudState(i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDeviceAdd(final String str) {
        for (final ISmartDeviceManagerListener iSmartDeviceManagerListener : this.mManagerListenerList) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.smart.service.k
                @Override // java.lang.Runnable
                public final void run() {
                    SmartDeviceService.lambda$notifyDeviceAdd$1(iSmartDeviceManagerListener, str);
                }
            });
        }
    }

    private void notifyDeviceAuthToken(final AuthInfo authInfo) {
        if (authInfo == null) {
            e3.a.v("notifyDeviceAuthToken with null info", new Object[0]);
            return;
        }
        for (final ISmartDeviceManagerListener iSmartDeviceManagerListener : this.mManagerListenerList) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.smart.service.j
                @Override // java.lang.Runnable
                public final void run() {
                    SmartDeviceService.lambda$notifyDeviceAuthToken$3(iSmartDeviceManagerListener, authInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDeviceDel(final String str) {
        for (final ISmartDeviceManagerListener iSmartDeviceManagerListener : this.mManagerListenerList) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.smart.service.g
                @Override // java.lang.Runnable
                public final void run() {
                    SmartDeviceService.lambda$notifyDeviceDel$2(iSmartDeviceManagerListener, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void opRsp(final String str, final String str2, final SmartOpRsp smartOpRsp, final int i7) {
        new m<Void, Void, Void>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.35
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public Void doInBackground(Void... voidArr) {
                SmartOpRsp smartOpRsp2;
                if (SDKState.STATE_STARTED != SmartDeviceService.this.getState()) {
                    e3.a.e("SmartDeviceService opRsp failed , sdk not start!", new Object[0]);
                    return null;
                }
                int i8 = i7;
                if (i8 == 3) {
                    AckService.getInstance().sendOpAck(str, str2, smartOpRsp);
                } else if (i8 == 8 && (smartOpRsp2 = smartOpRsp) != null) {
                    String pairJson = SmartDeviceService.this.getPairJson(smartOpRsp2.getPairList());
                    e3.a.e("SmartDeviceService opRsp <%s,%d,%s,%s> ", str, Integer.valueOf(smartOpRsp.getReqSn()), pairJson, Integer.valueOf(smartOpRsp.getResult()));
                    e3.a.e("SmartDeviceService opRsp <%s,%d,%s,%s> ret : %d", str, Integer.valueOf(smartOpRsp.getReqSn()), pairJson, Integer.valueOf(smartOpRsp.getResult()), Integer.valueOf(SmartDeviceService.this.mNativeService.opRsp(str, smartOpRsp.getReqSn(), pairJson, smartOpRsp.getResult())));
                }
                return null;
            }
        }.execute(new Void[0]);
    }

    private ErrorConst parseBindWindResult(long j7, String str, String str2) {
        e3.a.o("parseBindWindResult remainTime:%d,devId:%s,sn:%s", Long.valueOf(j7), str, str2);
        long jCurrentTimeMillis = System.currentTimeMillis() + j7;
        while (true) {
            String strRemove = this.mBindWindowInfo.remove(str2);
            if (!TextUtils.isEmpty(strRemove) && strRemove.endsWith(str)) {
                return ErrorConst.getErrorConstById(Integer.parseInt(strRemove.split("@")[0]));
            }
            if (jCurrentTimeMillis - System.currentTimeMillis() < 0) {
                e3.a.o("bind widows error , not find key : %s ", str2);
                return ErrorConst.ERR_USDK_TIMEOUT;
            }
            SystemClock.sleep(500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readRsp(final String str, final String str2, final SmartReadRsp smartReadRsp, final int i7) {
        new m<Void, Void, Void>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.33
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public Void doInBackground(Void... voidArr) {
                SmartReadRsp smartReadRsp2;
                if (SDKState.STATE_STARTED != SmartDeviceService.this.getState()) {
                    e3.a.e("SmartDeviceService readRsp failed , sdk not start!", new Object[0]);
                    return null;
                }
                int i8 = i7;
                if (i8 == 3) {
                    AckService.getInstance().sendReadAck(str, str2, smartReadRsp);
                } else if (i8 == 8 && (smartReadRsp2 = smartReadRsp) != null) {
                    e3.a.e("SmartDeviceService readRsp <%s,%d%s%d> ", str, Integer.valueOf(smartReadRsp2.getReqSn()), smartReadRsp.getValue(), Integer.valueOf(smartReadRsp.getResult()));
                    e3.a.e("SmartDeviceService readRsp <%s,%d%s%d> ret : ", str, Integer.valueOf(smartReadRsp.getReqSn()), smartReadRsp.getValue(), Integer.valueOf(smartReadRsp.getResult()), Integer.valueOf(SmartDeviceService.this.mNativeService.readRsp(str, smartReadRsp.getReqSn(), TextUtils.isEmpty(smartReadRsp.getValue()) ? "" : smartReadRsp.getValue(), smartReadRsp.getResult())));
                }
                return null;
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registNeworkListener() {
        com.haier.library.common.b.h.a().b(this.mContext, this.mIConnectStatusObserver);
    }

    private void reportStatus(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new SmartDevicePair(str2, str3));
        tryReportStatus(str, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.haier.uhome.usdk.base.api.c<String> tryAddDevice(SmartDevice smartDevice) {
        com.haier.uhome.usdk.base.api.c<String> cVar = new com.haier.uhome.usdk.base.api.c<>();
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.h("tryAddDevice server is not running", new Object[0]);
            cVar.a(ErrorConst.ERR_USDK_UNSTARTED);
            cVar.a((String) null);
            return cVar;
        }
        if (!checkParamisOk(smartDevice)) {
            e3.a.h("tryAddDevice param is invalid", new Object[0]);
            cVar.a(ErrorConst.ERR_USDK_INVALID_PARAM);
            cVar.a((String) null);
            return cVar;
        }
        synchronized (this) {
            if (this.adding) {
                e3.a.h("tryAddDevice error, add is going", new Object[0]);
                cVar.a(ErrorConst.ERR_USDK_UGW_DEVICE_ADDING);
                cVar.a((String) null);
                return cVar;
            }
            this.adding = true;
            String uplusId = smartDevice.getUplusId();
            String swVersion = smartDevice.getSwVersion();
            String hwVersion = smartDevice.getHwVersion();
            String swType = smartDevice.getSwType();
            String hwType = smartDevice.getHwType();
            String key = smartDevice.getKey();
            String devId = smartDevice.getDevId();
            if (TextUtils.isEmpty(swType) || TextUtils.isEmpty(hwType)) {
                e3.a.h("tryAddDevice st or ht is invalid", new Object[0]);
                cVar.a(ErrorConst.ERR_USDK_INVALID_PARAM);
                cVar.a((String) null);
                this.adding = false;
                return cVar;
            }
            if (TextUtils.isEmpty(devId) || !devId.matches(ConstSmartDevice.REGEX_MAC)) {
                e3.a.h("tryAddDevice mac is invalid", new Object[0]);
                cVar.a(ErrorConst.ERR_USDK_INVALID_PARAM);
                cVar.a((String) null);
                this.adding = false;
                return cVar;
            }
            e3.a.d("SMARTDEVICE", "addDevice", "tryAddDevice <%s,%s,%s,%s,%s,%s,%s>", devId, uplusId, swVersion, hwVersion, swType, hwType, key);
            String strAddDevice = this.mNativeService.addDevice(devId, uplusId, swVersion, hwVersion, swType, hwType, key);
            this.adding = false;
            if (TextUtils.isEmpty(strAddDevice)) {
                e3.a.h("tryAddDevice mac is invalid", new Object[0]);
                cVar.a(ErrorConst.ERR_INTERNAL);
                cVar.a((String) null);
                return cVar;
            }
            String str = new String(Base64.decode(strAddDevice.getBytes(), 2));
            e3.a.d("SMARTDEVICE", "addDevice", "tryAddDevice <%s,%s,%s,%s,%s,%s,%s> ret %s", devId, uplusId, swVersion, hwVersion, swType, hwType, key, str);
            if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase(devId)) {
                cVar.a(ErrorConst.RET_USDK_OK);
                cVar.a(str);
                return cVar;
            }
            ErrorConst errorConst = ErrorConst.ERR_INTERNAL;
            e3.a.h("tryAddDevice deviceId is invalid", new Object[0]);
            cVar.a(errorConst);
            cVar.a((String) null);
            return cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.haier.uhome.usdk.base.api.c<String> tryAddDeviceByRandomPrefix(SmartDevice smartDevice, boolean z7) {
        com.haier.uhome.usdk.base.api.c<String> cVar = new com.haier.uhome.usdk.base.api.c<>();
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.e("tryAddDeviceByRandomPrefix server is not running", new Object[0]);
            cVar.a(ErrorConst.ERR_USDK_UNSTARTED);
            cVar.a((String) null);
            return cVar;
        }
        if (!checkParamisOk(smartDevice)) {
            e3.a.h("tryAddDeviceByRandomPrefix param is invalid", new Object[0]);
            cVar.a(ErrorConst.ERR_USDK_INVALID_PARAM);
            cVar.a((String) null);
            return cVar;
        }
        String devId = smartDevice.getDevId();
        if (devId == null || !devId.matches(ConstSmartDevice.REGEX_SUB_AUTH_DEV_ID)) {
            e3.a.h("tryAddDeviceByRandomPrefix device devId<%s> is invalid.", devId);
            cVar.a(ErrorConst.ERR_USDK_INVALID_PARAM);
            cVar.a((String) null);
            return cVar;
        }
        String str = getDevIdPrefix() + devId;
        if (str == null) {
            e3.a.h("tryAddDeviceByRandomPrefix error, device devId<%s> is invalid.", devId);
            cVar.a(ErrorConst.ERR_USDK_DEVICE_NOT_FOUND);
            cVar.a((String) null);
            return cVar;
        }
        if (getDeviceById(str) != null) {
            e3.a.h("tryAddDeviceByRandomPrefix error, device devId<%s> device already added.", str);
            cVar.a(ErrorConst.ERR_USDK_UGW_DEVICE_ALREADY_ADD);
            cVar.a((String) null);
            return cVar;
        }
        synchronized (this) {
            if (this.adding) {
                e3.a.h("tryAddDeviceByRandomPrefix error, add is going", new Object[0]);
                cVar.a(ErrorConst.ERR_USDK_UGW_DEVICE_ADDING);
                cVar.a((String) null);
                return cVar;
            }
            this.adding = true;
            String uplusId = smartDevice.getUplusId();
            String swVersion = smartDevice.getSwVersion();
            String hwVersion = smartDevice.getHwVersion();
            String key = smartDevice.getKey();
            e3.a.d("SMARTDEVICE", "addDeviceByRandomPrefix", "tryAddDeviceByRandomPrefix <%s,%s,%s,%s,%s,%s>", str, uplusId, swVersion, hwVersion, key, Boolean.valueOf(z7));
            String strAddDeviceByRandomPrefix = this.mNativeService.addDeviceByRandomPrefix(str, uplusId, swVersion, hwVersion, key, z7);
            e3.a.d("SMARTDEVICE", "addDeviceByRandomPrefix", "tryAddDeviceByRandomPrefix <%s,%s,%s,%s,%s,%s> ret %s.", str, uplusId, swVersion, hwVersion, key, Boolean.valueOf(z7), strAddDeviceByRandomPrefix);
            this.adding = false;
            if (TextUtils.isEmpty(strAddDeviceByRandomPrefix) || !strAddDeviceByRandomPrefix.equalsIgnoreCase(str)) {
                cVar.a(ErrorConst.ERR_INTERNAL);
                cVar.a((String) null);
                return cVar;
            }
            cVar.a(ErrorConst.RET_USDK_OK);
            cVar.a(strAddDeviceByRandomPrefix);
            return cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKError tryAddDeviceRelation(final String str, final String str2) {
        uSDKError error = ErrorConst.ERR_USDK_TIMEOUT.toError();
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.h("tryAddDeviceRelation error, server is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED.toError();
        }
        if (getOnlineDeviceById(str) == null) {
            e3.a.h("tryAddDeviceRelation error parentDevice<%s> not online", new Object[0]);
            return ErrorConst.ERR_USDK_DEVICE_NOT_FOUND.toError();
        }
        final AbsSmartDeviceNotifier[] absSmartDeviceNotifierArr = new AbsSmartDeviceNotifier[1];
        final com.haier.library.common.thread.g gVar = new com.haier.library.common.thread.g();
        uSDKError usdkerror = (uSDKError) gVar.b(new Runnable() { // from class: com.haier.uhome.smart.service.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f30184a.lambda$tryAddDeviceRelation$10(str, str2, absSmartDeviceNotifierArr, gVar);
            }
        }, error, 5000L);
        SmartDeviceNotifier.getInstance().removeNotifier(absSmartDeviceNotifierArr[0]);
        return usdkerror;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.haier.uhome.usdk.base.api.c<String> tryAddSlaveDevice(SmartDevice smartDevice) {
        com.haier.uhome.usdk.base.api.c<String> cVar = new com.haier.uhome.usdk.base.api.c<>();
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.h("tryAddSlaveDevice server is not running", new Object[0]);
            cVar.a(ErrorConst.ERR_USDK_UNSTARTED);
            cVar.a((String) null);
            return cVar;
        }
        if (TextUtils.isEmpty(this.mMac)) {
            e3.a.h("tryAddSlaveDevice fail reason not add host", new Object[0]);
            cVar.a(ErrorConst.ERR_USDK_UGW_HOST_DEVICE_NOT_ADD);
            cVar.a((String) null);
            return cVar;
        }
        if (!checkParamisOk(smartDevice)) {
            e3.a.h("tryAddSlaveDevice param is invalid", new Object[0]);
            cVar.a(ErrorConst.ERR_USDK_INVALID_PARAM);
            cVar.a((String) null);
            return cVar;
        }
        String devId = smartDevice.getDevId();
        if (TextUtils.isEmpty(devId) || !devId.matches(ConstSmartDevice.REGEX_SUB_AUTH_DEV_ID)) {
            e3.a.h("tryAddSlaveDevice devId is invalid", new Object[0]);
            cVar.a(ErrorConst.ERR_USDK_INVALID_PARAM);
            cVar.a((String) null);
            return cVar;
        }
        synchronized (this) {
            if (this.adding) {
                e3.a.h("tryAddSlaveDevice error, add is going", new Object[0]);
                cVar.a(ErrorConst.ERR_USDK_UGW_DEVICE_ADDING);
                cVar.a((String) null);
                return cVar;
            }
            this.adding = true;
            String str = this.mMac + devId;
            String uplusId = smartDevice.getUplusId();
            String swVersion = smartDevice.getSwVersion();
            String hwVersion = smartDevice.getHwVersion();
            String swType = smartDevice.getSwType();
            String hwType = smartDevice.getHwType();
            String key = smartDevice.getKey();
            if (TextUtils.isEmpty(swType) || TextUtils.isEmpty(hwType)) {
                e3.a.h("tryAddSlaveDevice st or ht is invalid", new Object[0]);
                cVar.a(ErrorConst.ERR_USDK_INVALID_PARAM);
                cVar.a((String) null);
                this.adding = false;
                return cVar;
            }
            e3.a.d("SMARTDEVICE", "addSlaveDevice", "tryAddSlaveDevice <%s,%s,%s,%s,%s,%s,%s>", str, uplusId, swVersion, hwVersion, swType, hwType, key);
            String strAddSlaveDevice = this.mNativeService.addSlaveDevice(str, uplusId, swVersion, hwVersion, swType, hwType, key);
            this.adding = false;
            if (TextUtils.isEmpty(strAddSlaveDevice)) {
                e3.a.h("tryAddSlaveDevice retBase64 is empty", new Object[0]);
                cVar.a(ErrorConst.ERR_INTERNAL);
                cVar.a((String) null);
                return cVar;
            }
            String str2 = new String(Base64.decode(strAddSlaveDevice.getBytes(), 2));
            e3.a.d("SMARTDEVICE", "addSlaveDevice", "tryAddSlaveDevice <%s,%s,%s,%s,%s,%s,%s> ret %s", devId, uplusId, swVersion, hwVersion, swType, hwType, str2);
            if (!TextUtils.isEmpty(str2) && str2.equalsIgnoreCase(str)) {
                cVar.a(ErrorConst.RET_USDK_OK);
                cVar.a(str2);
                return cVar;
            }
            e3.a.h("device id <%s> is not matched", str);
            cVar.a(ErrorConst.ERR_INTERNAL);
            cVar.a((String) null);
            return cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ErrorConst tryBindDevice(final String str, final String str2, final double d8, TraceNode traceNode) {
        ErrorConst errorConst = ErrorConst.ERR_USDK_TIMEOUT;
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.e("tryBindDevice error, server is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED;
        }
        if (TextUtils.isEmpty(str)) {
            e3.a.e("tryBindDevice devId is null", new Object[0]);
            return ErrorConst.ERR_USDK_INVALID_PARAM;
        }
        if (TextUtils.isEmpty(str2)) {
            e3.a.e("tryBindDevice error connect to gateway first", new Object[0]);
            return ErrorConst.ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST;
        }
        if (d8 > 120.0d || d8 < 20.0d) {
            e3.a.h("tryBindDevice timeout<%s> is invalid.", Double.valueOf(d8));
            return ErrorConst.ERR_USDK_INVALID_PARAM;
        }
        final TraceNode traceNodeG = com.haier.uhome.trace.api.b.a().g(str, traceNode);
        if (traceNodeG.getTraceId() == null) {
            e3.a.e("tryBindDevice traceId is null", new Object[0]);
            return ErrorConst.ERR_USDK_INVALID_PARAM;
        }
        final AbsSmartDeviceNotifier[] absSmartDeviceNotifierArr = new AbsSmartDeviceNotifier[1];
        final com.haier.library.common.thread.g gVar = new com.haier.library.common.thread.g();
        ErrorConst errorConst2 = (ErrorConst) gVar.b(new Runnable() { // from class: com.haier.uhome.smart.service.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f30204a.lambda$tryBindDevice$6(str, str2, traceNodeG, d8, absSmartDeviceNotifierArr, gVar);
            }
        }, errorConst, (long) (1000.0d * d8));
        SmartDeviceNotifier.getInstance().removeNotifier(absSmartDeviceNotifierArr[0]);
        return errorConst2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKError tryBindSlaveDevice(final String str, final String str2) {
        uSDKError error = ErrorConst.ERR_USDK_TIMEOUT.toError();
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.h("tryBindSlaveDevice error, server is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED.toError();
        }
        if (TextUtils.isEmpty(fixDeviceId(str))) {
            e3.a.h("tryBindSlaveDevice error, device devId<%s> is invalid.", str);
            return ErrorConst.ERR_USDK_DEVICE_NOT_FOUND.toError();
        }
        final AbsSmartDeviceNotifier[] absSmartDeviceNotifierArr = new AbsSmartDeviceNotifier[1];
        final com.haier.library.common.thread.g gVar = new com.haier.library.common.thread.g();
        uSDKError usdkerror = (uSDKError) gVar.b(new Runnable() { // from class: com.haier.uhome.smart.service.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f30193a.lambda$tryBindSlaveDevice$7(str, str2, absSmartDeviceNotifierArr, gVar);
            }
        }, error, 5000L);
        SmartDeviceNotifier.getInstance().removeNotifier(absSmartDeviceNotifierArr[0]);
        return usdkerror;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ErrorConst tryBindWindow(String str, int i7) {
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.e("tryBindWindow server is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED;
        }
        if (i7 > 120 || i7 < 5) {
            e3.a.e("tryBindWindow error, timeout invalid <%d>", Integer.valueOf(i7));
            return ErrorConst.ERR_USDK_INVALID_PARAM;
        }
        String strFixDeviceId = fixDeviceId(str);
        if (TextUtils.isEmpty(strFixDeviceId)) {
            e3.a.h("tryBindWindow error, device devId<%s> is invalid.", str);
            return ErrorConst.ERR_USDK_DEVICE_NOT_FOUND;
        }
        String strValueOf = String.valueOf(com.haier.uhome.usdk.base.c.f.a().c());
        long jCurrentTimeMillis = System.currentTimeMillis();
        e3.a.d("tryBindWindow <%s,%s> ", strFixDeviceId, strValueOf, new Object[0]);
        int iBindWindow = this.mNativeService.bindWindow(strFixDeviceId, strValueOf);
        e3.a.d("tryBindWindow <%s,%s> ret %d. ", strFixDeviceId, strValueOf, Integer.valueOf(iBindWindow));
        return ((long) (i7 * 1000)) - (System.currentTimeMillis() - jCurrentTimeMillis) <= 0 ? ErrorConst.ERR_USDK_TIMEOUT : ErrorConst.getErrorConstById(iBindWindow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ErrorConst tryBusinessUp(String str, String str2, byte[] bArr) {
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.h("tryBusinessUp error, server is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED;
        }
        SmartDevice deviceById = getDeviceById(str);
        if (deviceById == null) {
            e3.a.h("tryBusinessUp error, device devId<%s> is invalid.", str);
            return ErrorConst.ERR_USDK_DEVICE_NOT_FOUND;
        }
        String devId = deviceById.getDevId();
        e3.a.d("tryBusinessUp <%s,%s> ", devId, str2, new Object[0]);
        int iBusinessUp = this.mNativeService.businessUp(devId, str2, bArr, bArr.length);
        e3.a.d("tryBusinessUp <%s,%s> ret %d. ", devId, str2, Integer.valueOf(iBusinessUp));
        return ErrorConst.getErrorConstById(iBusinessUp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.haier.uhome.usdk.base.api.c<String> tryDelDevice(String str) {
        com.haier.uhome.usdk.base.api.c<String> cVar = new com.haier.uhome.usdk.base.api.c<>();
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.e("tryDelDevice error, server is not running", new Object[0]);
            cVar.a(ErrorConst.ERR_USDK_UNSTARTED);
            cVar.a((String) null);
            return cVar;
        }
        String strFixDeviceId = fixDeviceId(str);
        if (TextUtils.isEmpty(strFixDeviceId)) {
            e3.a.h("tryDelDevice error, device devId<%s> is invalid.", str);
            cVar.a(ErrorConst.ERR_USDK_DEVICE_NOT_FOUND);
            cVar.a((String) null);
            return cVar;
        }
        e3.a.e("tryDelDevice fixedDevId <%s>", strFixDeviceId);
        int iDelDevice = this.mNativeService.delDevice(strFixDeviceId);
        e3.a.e("tryDelDevice fixedDevId <%s> ret %d", strFixDeviceId, Integer.valueOf(iDelDevice));
        cVar.a(ErrorConst.getErrorConstById(iDelDevice));
        cVar.a(strFixDeviceId);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKError tryDeviceGroupOnline(String str, String str2, String str3) {
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.h("tryDeviceGroupOnline error, server is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED.toError();
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            e3.a.f("tryDeviceGroupOnline param invalid groupId<%s> uplusId<%s> devKey<%s>", str, str2, str3);
            return ErrorConst.ERR_USDK_INVALID_PARAM.toError();
        }
        e3.a.d("tryDeviceGroupOnline groupId<%s> uplusId<%s> devKey<%s>", str, str2, str3);
        int iAddGroupDev = this.mNativeService.addGroupDev(str, str2);
        e3.a.d("tryDeviceGroupOnline groupId<%s> uplusId<%s> devKey<%s> ret<%d>", str, str2, str3, Integer.valueOf(iAddGroupDev));
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        if (iAddGroupDev == errorConst.getErrorId()) {
            return errorConst.toError();
        }
        uSDKError usdkerror = new uSDKError(iAddGroupDev);
        usdkerror.a("ugw error");
        return usdkerror;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKError tryDeviceGroupRsp(DeviceGroupReqType deviceGroupReqType, String str, int i7, int i8) {
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.h("tryDeviceGroupRsp error, server is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED.toError();
        }
        e3.a.d("tryDeviceGroupRsp reqType<%s> devId<%s> sn<%d> errNo<%d>", deviceGroupReqType.name(), str, Integer.valueOf(i7), Integer.valueOf(i8));
        int iGroupControlRsp = this.mNativeService.groupControlRsp(deviceGroupReqType.ordinal(), str, i7, i8);
        e3.a.d("tryDeviceGroupRsp reqType<%s> devId<%s> sn<%d> errNo<%d> ret<%d>", deviceGroupReqType.name(), str, Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(iGroupControlRsp));
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        if (iGroupControlRsp == errorConst.getErrorId()) {
            return errorConst.toError();
        }
        uSDKError usdkerror = new uSDKError(iGroupControlRsp);
        usdkerror.a("ugw error");
        return usdkerror;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: tryFetchGroupMember, reason: merged with bridge method [inline-methods] */
    public void lambda$fetchGroupMember$11(String str, ICallback<List<String>> iCallback) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final com.haier.uhome.usdk.base.api.c cVar = new com.haier.uhome.usdk.base.api.c();
        cVar.a(ErrorConst.ERR_USDK_TIMEOUT.toError());
        this.mISmartDeviceGroupNotifier = new ISmartDeviceGroupNotifier() { // from class: com.haier.uhome.smart.service.SmartDeviceService.54
            @Override // com.haier.uhome.smart.handler.ISmartDeviceGroupNotifier
            public void notifyDeviceGroupControl(int i7, int i8, String str2, String str3) {
            }

            @Override // com.haier.uhome.smart.handler.ISmartDeviceGroupNotifier
            public void notifyGroupMember(String str2, int i7, List<String> list) {
                ErrorConst errorConst = ErrorConst.RET_USDK_OK;
                if (i7 == errorConst.getErrorId()) {
                    cVar.a(errorConst.toError());
                    cVar.a(list);
                } else {
                    cVar.b().setCode(i7);
                    cVar.b().setDescription("group member error");
                }
                countDownLatch.countDown();
            }
        };
        SmartDeviceNotifier.getInstance().addGroupNotifier(this.mISmartDeviceGroupNotifier);
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.h("tryFetchGroupMember error, server is not running", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.b((ICallback) iCallback, ErrorConst.ERR_USDK_UNSTARTED.toError());
            return;
        }
        if (TextUtils.isEmpty(str)) {
            e3.a.h("tryFetchGroupMember groupId<%s> is invalid", str);
            com.haier.uhome.usdk.base.utils.b.b((ICallback) iCallback, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        e3.a.e("tryFetchGroupMember groupId<%s>", str);
        int iGroupFetchDeviceList = this.mNativeService.groupFetchDeviceList(str);
        e3.a.e("tryFetchGroupMember groupId<%s> ret<%d>", str, Integer.valueOf(iGroupFetchDeviceList));
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        if (iGroupFetchDeviceList != errorConst.getErrorId()) {
            uSDKError usdkerror = new uSDKError(iGroupFetchDeviceList);
            usdkerror.a("ugw error");
            com.haier.uhome.usdk.base.utils.b.b((ICallback) iCallback, usdkerror);
        } else {
            wait(countDownLatch);
            if (cVar.b().getCode() == errorConst.getErrorId()) {
                com.haier.uhome.usdk.base.utils.b.b(iCallback, cVar.c());
            } else {
                com.haier.uhome.usdk.base.utils.b.b((ICallback) iCallback, cVar.b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.haier.uhome.usdk.base.api.c<String> tryGetBindQRCode(final SmartDevice smartDevice, double d8) {
        final com.haier.uhome.usdk.base.api.c<String> cVar = new com.haier.uhome.usdk.base.api.c<>();
        cVar.a(ErrorConst.ERR_USDK_TIMEOUT);
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.e("tryGetBindQRCode error, server is not running", new Object[0]);
            cVar.a(ErrorConst.ERR_USDK_UNSTARTED);
            cVar.a((String) null);
            return cVar;
        }
        if (d8 <= 120.0d && d8 >= 10.0d) {
            final com.haier.library.common.thread.g gVar = new com.haier.library.common.thread.g();
            gVar.b(new Runnable() { // from class: com.haier.uhome.smart.service.l
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30220a.lambda$tryGetBindQRCode$4(smartDevice, cVar, gVar);
                }
            }, cVar, (long) (d8 * 1000.0d));
            return cVar;
        }
        e3.a.h("tryGetBindQRCode timeout<%s> is invalid.", Double.valueOf(d8));
        cVar.a(ErrorConst.ERR_USDK_INVALID_PARAM);
        cVar.a((String) null);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKError tryInitIotVideo(String str, String str2) {
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.h("tryInitIotVideo error, server is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED.toError();
        }
        if (getOnlineDeviceById(str) == null) {
            e3.a.h("tryInitIotVideo error parentDevice<%s> not online", new Object[0]);
            return ErrorConst.ERR_USDK_DEVICE_NOT_FOUND.toError();
        }
        e3.a.d("tryInitIotVideo <%s, %s>", str, str2, new Object[0]);
        int iInitIotVideo = this.mNativeService.initIotVideo(str, str2);
        e3.a.e("tryInitIotVideo ret<%d>", Integer.valueOf(iInitIotVideo));
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        if (iInitIotVideo == errorConst.getErrorId()) {
            return errorConst.toError();
        }
        uSDKError usdkerror = new uSDKError(iInitIotVideo);
        usdkerror.a("ugw error");
        return usdkerror;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKError tryMcsServerInit(String str, String str2) {
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.h("tryMcsServerInit error, server is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED.toError();
        }
        e3.a.d("tryMcsServerInit devId<%s> path<%s>", str, str2, new Object[0]);
        int iMcsServerInit = this.mNativeService.mcsServerInit(str, str2);
        e3.a.d("tryMcsServerInit devId<%s> path<%s> ret<%d>", str, str2, Integer.valueOf(iMcsServerInit));
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        if (iMcsServerInit == errorConst.getErrorId()) {
            return errorConst.toError();
        }
        uSDKError usdkerror = new uSDKError(iMcsServerInit);
        usdkerror.a("ugw error");
        return usdkerror;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKError tryMessagePushInit() {
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.h("tryMessagePushInit error, server is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED.toError();
        }
        e3.a.e("tryMessagePushInit", new Object[0]);
        int iMessagePushInit = this.mNativeService.messagePushInit();
        e3.a.e("tryMessagePushInit ret<%d>", Integer.valueOf(iMessagePushInit));
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        if (iMessagePushInit == errorConst.getErrorId()) {
            return errorConst.toError();
        }
        uSDKError usdkerror = new uSDKError(iMessagePushInit);
        usdkerror.a("ugw error");
        return usdkerror;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKError tryOtaFinish(String str, String str2, int i7) {
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.h("tryOtaFinish error, server is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED.toError();
        }
        if (TextUtils.isEmpty(str2)) {
            e3.a.h("tryOtaFinish upgradeSn<%s> is invalid", str2);
            return ErrorConst.ERR_USDK_INVALID_PARAM.toError();
        }
        if (TextUtils.isEmpty(fixDeviceId(str))) {
            e3.a.h("tryOtaFinish error, device devId<%s> is invalid.", str);
            return ErrorConst.ERR_USDK_DEVICE_NOT_FOUND.toError();
        }
        e3.a.e(String.format("tryOtaFinish devId %s, upgradeSn %s, errorNum %d", str, str2, Integer.valueOf(i7)), new Object[0]);
        int iOtaFinish = this.mNativeService.otaFinish(str, str2, i7);
        e3.a.e(String.format("tryOtaFinish devId %s, upgradeSn %s, errorNum %d, ret %d", str, str2, Integer.valueOf(i7), Integer.valueOf(iOtaFinish)), new Object[0]);
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        if (iOtaFinish == errorConst.getErrorId()) {
            return errorConst.toError();
        }
        uSDKError error = ErrorConst.ERR_INTERNAL.toError();
        error.a("ugw error:" + iOtaFinish);
        return error;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKError tryOtaInit(int i7) {
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.h("tryOtaInit error, server is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED.toError();
        }
        e3.a.e("tryOtaInit upgrading %d", Integer.valueOf(i7));
        int iOtaInit = this.mNativeService.otaInit(i7);
        e3.a.e("tryOtaInit upgrading %d, ret %d", Integer.valueOf(i7), Integer.valueOf(iOtaInit));
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        if (iOtaInit == errorConst.getErrorId()) {
            return errorConst.toError();
        }
        uSDKError error = ErrorConst.ERR_INTERNAL.toError();
        error.a("ugw error:" + iOtaInit);
        return error;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKError tryQueryBindStatus(String str, int i7, int i8) {
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.h("tryQueryBindStatus error, server is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED.toError();
        }
        e3.a.e("tryQueryBindStatus devId<%s> sn<%d> timeout<%d>", str, Integer.valueOf(i7), Integer.valueOf(i8));
        int iQueryBindStatus = this.mNativeService.queryBindStatus(str, i7, i8);
        e3.a.e("tryQueryBindStatus devId<%s> sn<%d> timeout<%d> ret<%d>", str, Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(iQueryBindStatus));
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        if (iQueryBindStatus == errorConst.getErrorId()) {
            return errorConst.toError();
        }
        uSDKError usdkerror = new uSDKError(iQueryBindStatus);
        usdkerror.a("ugw error");
        return usdkerror;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ErrorConst tryRefreshMdns() {
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.h("tryRefreshMdns error, server is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED;
        }
        e3.a.e("tryRefreshMdns ", new Object[0]);
        int iRefreshMdns = this.mNativeService.refreshMdns();
        e3.a.e("tryRefreshMdns <%s>", Integer.valueOf(iRefreshMdns));
        return ErrorConst.getErrorConstById(iRefreshMdns);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKError tryRefreshNetwork() {
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.h("tryRefreshNetwork error, server is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED.toError();
        }
        int iRefreshNetwork = this.mNativeService.refreshNetwork();
        e3.a.e("tryRefreshNetwork ret<%d>", Integer.valueOf(iRefreshNetwork));
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        if (iRefreshNetwork == errorConst.getErrorId()) {
            return errorConst.toError();
        }
        uSDKError usdkerror = new uSDKError(iRefreshNetwork);
        usdkerror.a("ugw error");
        return usdkerror;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKError tryRegisteDeviceGroupListener(IDeviceGroupListener iDeviceGroupListener) {
        this.mIDeviceGroupListener = iDeviceGroupListener;
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.h("tryRegisteDeviceGroupListener error, server is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED.toError();
        }
        if (iDeviceGroupListener == null) {
            e3.a.h("tryRegisteDeviceGroupListener listener is null", new Object[0]);
            return ErrorConst.ERR_USDK_INVALID_PARAM.toError();
        }
        e3.a.e("tryRegisteDeviceGroupListener listener<%s>", iDeviceGroupListener);
        int iGroupControlInit = this.mNativeService.groupControlInit();
        e3.a.e("tryRegisteDeviceGroupListener listener<%s> ret<%d>", iDeviceGroupListener, Integer.valueOf(iGroupControlInit));
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        if (iGroupControlInit == errorConst.getErrorId()) {
            return errorConst.toError();
        }
        uSDKError usdkerror = new uSDKError(iGroupControlInit);
        usdkerror.a("ugw error");
        return usdkerror;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKError tryRegisterDownloadOtapkgCb(String str, String str2, String str3, String str4) {
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.h("tryRegisterDownloadOtapkgCb error, server is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED.toError();
        }
        e3.a.e(String.format("tryRegisterDownloadOtapkgCb path<%s> downloadParam<%s> startParam<%s> finishParam<%s>", str, str2, str3, str4), new Object[0]);
        int iRegisterDownloadOtapkgCb = this.mNativeService.registerDownloadOtapkgCb(str, str2, str3, str4);
        e3.a.e(String.format("tryRegisterDownloadOtapkgCb path<%s> downloadParam<%s> startParam<%s> finishParam<%s> ret<%d>", str, str2, str3, str4, Integer.valueOf(iRegisterDownloadOtapkgCb)), new Object[0]);
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        if (iRegisterDownloadOtapkgCb == errorConst.getErrorId()) {
            return errorConst.toError();
        }
        uSDKError error = ErrorConst.ERR_INTERNAL.toError();
        error.a("ugw error:" + iRegisterDownloadOtapkgCb);
        return error;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKError tryRegisterMessagePush(MessagePush messagePush) {
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.h("tryRegisterMessagePush error, server is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED.toError();
        }
        if (messagePush == null) {
            e3.a.h("tryRegisterMessagePush messagePush error", new Object[0]);
            return ErrorConst.ERR_USDK_INVALID_PARAM.toError();
        }
        if (TextUtils.isEmpty(fixDeviceId(messagePush.getDevId()))) {
            e3.a.h("tryRegisterMessagePush error, device devId<%s> is invalid.", messagePush.getDevId());
            return ErrorConst.ERR_USDK_DEVICE_NOT_FOUND.toError();
        }
        String traceId = (messagePush.getCSNode() == null || TextUtils.isEmpty(messagePush.getCSNode().getTraceId())) ? "" : messagePush.getCSNode().getTraceId();
        e3.a.e("tryRegisterMessagePush messagePush<%s>", messagePush.toString());
        int iRegisterMessagePush = this.mNativeService.registerMessagePush(messagePush.getDevId(), traceId, messagePush.getTimezone(), messagePush.getLanguage(), messagePush.getSn(), messagePush.getStype().value(), messagePush.getAction().value());
        e3.a.e("tryRegisterMessagePush messagePush<%s> ret<%d>", messagePush.toString(), Integer.valueOf(iRegisterMessagePush));
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        if (iRegisterMessagePush == errorConst.getErrorId()) {
            return errorConst.toError();
        }
        uSDKError usdkerror = new uSDKError(iRegisterMessagePush);
        usdkerror.a("ugw error");
        return usdkerror;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKError tryRegisterResource(String str, String str2) {
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.h("tryRegisterResource error, server is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED.toError();
        }
        if (TextUtils.isEmpty(str2)) {
            e3.a.h("tryRegisterResource resName<%s> is invalid", str2);
            return ErrorConst.ERR_USDK_INVALID_PARAM.toError();
        }
        if (TextUtils.isEmpty(fixDeviceId(str))) {
            e3.a.h("tryRegisterResource error, device devId<%s> is invalid.", str);
            return ErrorConst.ERR_USDK_DEVICE_NOT_FOUND.toError();
        }
        e3.a.d("", "", "tryRegisterResource devId<%s> resName<%s>", str, str2);
        int iRegisterResource = this.mNativeService.registerResource(str, str2);
        e3.a.d("", "", "tryRegisterResource devId<%s> resName<%s> ret<%d>", str, str2, Integer.valueOf(iRegisterResource));
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        if (iRegisterResource == errorConst.getErrorId()) {
            return errorConst.toError();
        }
        uSDKError usdkerror = new uSDKError(iRegisterResource);
        usdkerror.a("ugw error");
        return usdkerror;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ErrorConst tryReportAlarm(String str, List<SmartDevicePair> list) {
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.e("tryReportAlarm error, server is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED;
        }
        if (list == null || list.isEmpty()) {
            e3.a.h("tryReportAlarm error, pairList<%s> is invalid.", list);
            return ErrorConst.ERR_USDK_INVALID_PARAM;
        }
        String strFixDeviceId = fixDeviceId(str);
        if (TextUtils.isEmpty(strFixDeviceId)) {
            e3.a.h("tryReportAlarm error, device devId<%s> is invalid.", str);
            return ErrorConst.ERR_USDK_DEVICE_NOT_FOUND;
        }
        AckService.getInstance().sendAlarmNotify(strFixDeviceId, list);
        String pairJson = getPairJson(list);
        e3.a.d("tryReportAlarm fixedDevId <%s> json <%s>", strFixDeviceId, pairJson, new Object[0]);
        int iReportAlarm = this.mNativeService.reportAlarm(strFixDeviceId, pairJson);
        e3.a.d("tryReportAlarm fixedDevId <%s> json <%s> ret <%d>.", strFixDeviceId, pairJson, Integer.valueOf(iReportAlarm));
        return ErrorConst.getErrorConstById(iReportAlarm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ErrorConst tryReportBigData(String str, String str2, String str3) {
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.e("tryReportBigData error, server is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED;
        }
        String strFixDeviceId = fixDeviceId(str);
        if (TextUtils.isEmpty(strFixDeviceId)) {
            e3.a.h("tryReportBigData error, device devId<%s> device already added.", str);
            return ErrorConst.ERR_USDK_DEVICE_NOT_FOUND;
        }
        AckService.getInstance().sendBigDataNotify(strFixDeviceId, str2, str3);
        e3.a.d("tryReportBigData <%s,%s,%s> ", strFixDeviceId, str2, str3);
        int iReportBigData = this.mNativeService.reportBigData(strFixDeviceId, str2, str3, str3.length());
        e3.a.d("tryReportBigData <%s,%s,%s> ret %d. ", strFixDeviceId, str2, str3, Integer.valueOf(iReportBigData));
        return ErrorConst.getErrorConstById(iReportBigData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKError tryReportBindProcess(int i7, String str, String str2, String str3, int i8, String str4) {
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.h("tryReportBindProcess error, server is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED.toError();
        }
        if (getOnlineDeviceById(str) == null) {
            e3.a.h("tryReportBindProcess error parentDevice<%s> not online", new Object[0]);
            return ErrorConst.ERR_USDK_DEVICE_NOT_FOUND.toError();
        }
        e3.a.e(String.format("tryReportBindProcess errNo<%d> devId<%s> uplusId<%s> upCodeT<%s> process<%d> bindSn<%s>", Integer.valueOf(i7), str, str2, str3, Integer.valueOf(i8), str4), new Object[0]);
        int iReportBindProcess = this.mNativeService.reportBindProcess(i7, str, str2, str3, i8, str4);
        e3.a.e(String.format("tryReportBindProcess errNo<%d> devId<%s> uplusId<%s> upCodeT<%s> process<%d> bindSn<%s> ret<%d>", Integer.valueOf(i7), str, str2, str3, Integer.valueOf(i8), str4, Integer.valueOf(iReportBindProcess)), new Object[0]);
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        if (iReportBindProcess == errorConst.getErrorId()) {
            return errorConst.toError();
        }
        uSDKError usdkerror = new uSDKError(iReportBindProcess);
        usdkerror.a("ugw error");
        return usdkerror;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKError tryReportMessageStatus(MessageStatusAck messageStatusAck) {
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.h("tryReportMessageStatus error, server is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED.toError();
        }
        if (messageStatusAck == null) {
            e3.a.h("tryReportMessageStatus messageStatus is null", new Object[0]);
            return ErrorConst.ERR_USDK_INVALID_PARAM.toError();
        }
        if (TextUtils.isEmpty(fixDeviceId(messageStatusAck.getDevId()))) {
            e3.a.h("tryReportMessageStatus error, device devId<%s> is invalid.", messageStatusAck.getDevId());
            return ErrorConst.ERR_USDK_DEVICE_NOT_FOUND.toError();
        }
        e3.a.e("tryReportMessageStatus messageStatus<%s>", messageStatusAck.toString());
        int iReportMessageStatus = this.mNativeService.reportMessageStatus(messageStatusAck.getDevId(), TextUtils.isEmpty(messageStatusAck.getPushId()) ? "" : messageStatusAck.getPushId(), TextUtils.isEmpty(messageStatusAck.getMessageId()) ? "" : messageStatusAck.getMessageId(), messageStatusAck.getReadTime(), messageStatusAck.getStatus().value());
        e3.a.e("tryReportMessageStatus ret<%d>", Integer.valueOf(iReportMessageStatus));
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        if (iReportMessageStatus == errorConst.getErrorId()) {
            return errorConst.toError();
        }
        uSDKError usdkerror = new uSDKError(iReportMessageStatus);
        usdkerror.a("ugw error");
        return usdkerror;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKError tryReportResource(String str, String str2, byte[] bArr, int i7) {
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.h("tryReportResource error, server is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED.toError();
        }
        if (TextUtils.isEmpty(str2)) {
            e3.a.h("tryReportResource resName<%s> is invalid", str2);
            return ErrorConst.ERR_USDK_INVALID_PARAM.toError();
        }
        if (bArr == null || bArr.length == 0) {
            e3.a.h("tryReportResource resource is null", new Object[0]);
            return ErrorConst.ERR_USDK_INVALID_PARAM.toError();
        }
        if (TextUtils.isEmpty(fixDeviceId(str))) {
            e3.a.h("tryReportResource error, device devId<%s> is invalid.", str);
            return ErrorConst.ERR_USDK_DEVICE_NOT_FOUND.toError();
        }
        String str3 = new String(bArr);
        e3.a.d("", "", "tryReportResource devId<%s> resName<%s> resource<%s> length<%d>", str, str2, str3, Integer.valueOf(i7));
        int iReportResource = this.mNativeService.reportResource(str, str2, str3, i7);
        e3.a.d("", "", "tryReportResource devId<%s> resName<%s> ret<%d>", str, str2, Integer.valueOf(iReportResource));
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        if (iReportResource == errorConst.getErrorId()) {
            return errorConst.toError();
        }
        uSDKError usdkerror = new uSDKError(iReportResource);
        usdkerror.a("ugw error");
        return usdkerror;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ErrorConst tryReportStatus(String str, List<SmartDevicePair> list) {
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.e("tryReportStatus error, server is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED;
        }
        if (list == null || list.isEmpty()) {
            e3.a.h("tryReportStatus error, pairList<%s> is invalid.", list);
            return ErrorConst.ERR_USDK_INVALID_PARAM;
        }
        String strFixDeviceId = fixDeviceId(str);
        if (TextUtils.isEmpty(strFixDeviceId)) {
            e3.a.h("tryReportStatus error, device devId<%s> is invalid.", str);
            return ErrorConst.ERR_USDK_DEVICE_NOT_FOUND;
        }
        AckService.getInstance().sendAttrNotify(strFixDeviceId, list);
        String pairJson = getPairJson(list);
        e3.a.d("tryReportStatus fixedDevId <%s> json <%s>", strFixDeviceId, pairJson, new Object[0]);
        int iReportStatus = this.mNativeService.reportStatus(strFixDeviceId, pairJson);
        e3.a.d("tryReportStatus fixedDevId <%s> json <%s> ret <%d>: ", strFixDeviceId, pairJson, Integer.valueOf(iReportStatus));
        return ErrorConst.getErrorConstById(iReportStatus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ErrorConst tryRestartDevGW() {
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.h("tryRefreshMdns error, server is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED;
        }
        e3.a.e("tryRestartDevGW ", new Object[0]);
        int iRestartDevGW = this.mNativeService.restartDevGW();
        e3.a.e("tryRestartDevGW <%s>", Integer.valueOf(iRestartDevGW));
        return ErrorConst.getErrorConstById(iRestartDevGW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKError trySetOtaMode(String str, OtaMode otaMode) {
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.h("trySetOtaMode error, server is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED.toError();
        }
        if (TextUtils.isEmpty(fixDeviceId(str))) {
            e3.a.h("trySetOtaMode error, device devId<%s> is invalid.", str);
            return ErrorConst.ERR_USDK_DEVICE_NOT_FOUND.toError();
        }
        e3.a.e(String.format("trySetOtaMode devId %s, mode %s", str, otaMode.name()), new Object[0]);
        int otaMode2 = this.mNativeService.setOtaMode(str, otaMode);
        e3.a.e(String.format("trySetOtaMode devId %s, mode %s ret %d", str, otaMode.name(), Integer.valueOf(otaMode2)), new Object[0]);
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        if (otaMode2 == errorConst.getErrorId()) {
            return errorConst.toError();
        }
        uSDKError error = ErrorConst.ERR_INTERNAL.toError();
        error.a("ugw error:" + otaMode2);
        return error;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKError tryStartPairingRsp(int i7, int i8) {
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.h("tryStartPairingRsp error, server is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED.toError();
        }
        e3.a.e(String.format("tryStartPairingRsp sn<%d> errNo<%d>", Integer.valueOf(i7), Integer.valueOf(i8)), new Object[0]);
        int iStartPairingRsp = this.mNativeService.startPairingRsp(i7, i8);
        e3.a.e(String.format("tryStartPairingRsp sn<%d> errNo<%d> ret<%d>", Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(iStartPairingRsp)), new Object[0]);
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        if (iStartPairingRsp == errorConst.getErrorId()) {
            return errorConst.toError();
        }
        uSDKError usdkerror = new uSDKError(iStartPairingRsp);
        usdkerror.a("ugw error");
        return usdkerror;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ErrorConst tryStartService(Context context, String str, int i7) {
        SDKState sDKState = SDKState.STATE_STARTED;
        if (sDKState == getState()) {
            e3.a.e("tryStartService server is already running", new Object[0]);
            return ErrorConst.RET_USDK_OK;
        }
        if (context != null && (context instanceof Application)) {
            synchronized (this.obj) {
                SDKState sDKState2 = SDKState.STATE_STARTING;
                if (sDKState2 == getState()) {
                    e3.a.e("SDK is starting : " + Process.myPid(), new Object[0]);
                    return ErrorConst.ERR_USDK_STARTING;
                }
                setState(sDKState2);
                this.mContext = context;
                w.k(context);
                if (this.mSmartConfig == null) {
                    this.mSmartConfig = new SmartConfig();
                }
                this.mSmartConfig.devIdPrefix = com.haier.library.common.util.f.d(this.mContext);
                String strB = v.b(this.mContext, com.haier.uhome.usdk.base.a.P);
                SmartConfig smartConfig = this.mSmartConfig;
                if (TextUtils.isEmpty(strB)) {
                    strB = "default";
                }
                smartConfig.serverType = strB;
                e3.a.e("Init SmartConfig : " + this.mSmartConfig.toString(), new Object[0]);
                File file = new File(String.format("%s/%s", this.mContext.getFilesDir().getAbsolutePath(), com.haier.uhome.usdk.base.a.O));
                if (!file.exists()) {
                    file.mkdirs();
                }
                if (TextUtils.isEmpty(this.mSmartConfig.devIdPrefix)) {
                    e3.a.h("tryStartService hostMac is invalid", new Object[0]);
                    setState(SDKState.STATE_UNSTART);
                    return ErrorConst.ERR_USDK_INVALID_PARAM;
                }
                e3.a.d("", "", "SmartDeviceService tryStartService <%s, %s>", file.getPath(), this.mSmartConfig.devIdPrefix);
                int iInit = this.mNativeService.init(str, i7, file.getPath(), this.mSmartConfig.devIdPrefix);
                e3.a.e("SmartDeviceService tryStartService  ret %d ", Integer.valueOf(iInit));
                ErrorConst errorConstById = ErrorConst.getErrorConstById(iInit);
                if (errorConstById != ErrorConst.RET_USDK_OK) {
                    sDKState = SDKState.STATE_UNSTART;
                }
                setState(sDKState);
                return errorConstById;
            }
        }
        e3.a.h("tryStartService context is invalid.", new Object[0]);
        return ErrorConst.ERR_USDK_INVALID_PARAM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKError tryStartWifiScanDevice(int i7) {
        uSDKError error = ErrorConst.RET_USDK_OK.toError();
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.e("tryStartWifiScanDevice error, server is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED.toError();
        }
        e3.a.e("tryStartWifiScanDevice", new Object[0]);
        int iStartWifiScanDevice = this.mNativeService.startWifiScanDevice(i7);
        e3.a.e("tryStartWifiScanDevice ret<%s>", Integer.valueOf(iStartWifiScanDevice));
        if (iStartWifiScanDevice == 0) {
            return error;
        }
        uSDKError error2 = ErrorConst.ERR_INTERNAL.toError();
        error2.a("ret = " + iStartWifiScanDevice);
        return error2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ErrorConst tryStopService() {
        if (getState() != SDKState.STATE_STARTED) {
            e3.a.e("tryStopService server is already stopped", new Object[0]);
            return ErrorConst.RET_USDK_OK;
        }
        for (SmartDevice smartDevice : getDeviceList()) {
            tryDelDevice(smartDevice.getDevId());
            this.mSmartDevices.remove(smartDevice.getDevId());
            notifyDeviceDel(smartDevice.getDevId());
        }
        for (AbsSmartDevice absSmartDevice : getOnlineDeviceList()) {
            tryDelDevice(absSmartDevice.getDeviceId());
            this.mOnlineDevices.remove(absSmartDevice.getDeviceId());
            notifyDeviceDel(absSmartDevice.getDeviceId());
        }
        w.f();
        unRegistNetworkListener();
        e3.a.e("SmartDeviceService tryStopService", new Object[0]);
        int iRelease = this.mNativeService.release();
        e3.a.e("SmartDeviceService tryStopService ret %d", Integer.valueOf(iRelease));
        ErrorConst errorConstById = ErrorConst.getErrorConstById(iRelease);
        setState(errorConstById == ErrorConst.RET_USDK_OK ? SDKState.STATE_UNSTART : SDKState.STATE_STARTED);
        return errorConstById;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKError tryStopWifiScanDevice() {
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.e("tryStopWifiScanDevice error, server is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED.toError();
        }
        e3.a.e("tryStopWifiScanDevice", new Object[0]);
        int iStopWifiScanDevice = this.mNativeService.stopWifiScanDevice();
        e3.a.e("tryStopWifiScanDevice ret<%s>", Integer.valueOf(iStopWifiScanDevice));
        uSDKError error = ErrorConst.RET_USDK_OK.toError();
        if (iStopWifiScanDevice == 0) {
            return error;
        }
        uSDKError error2 = ErrorConst.ERR_INTERNAL.toError();
        error2.a("ret = " + iStopWifiScanDevice);
        return error2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKError tryUnBindSlaveDevice(final String str, final String str2) {
        uSDKError error = ErrorConst.ERR_USDK_TIMEOUT.toError();
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.h("tryUnBindSlaveDevice error, server is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED.toError();
        }
        if (TextUtils.isEmpty(fixDeviceId(str))) {
            e3.a.h("tryUnBindSlaveDevice error, device devId<%s> is invalid.", str);
            return ErrorConst.ERR_USDK_DEVICE_NOT_FOUND.toError();
        }
        final AbsSmartDeviceNotifier[] absSmartDeviceNotifierArr = new AbsSmartDeviceNotifier[1];
        final com.haier.library.common.thread.g gVar = new com.haier.library.common.thread.g();
        uSDKError usdkerror = (uSDKError) gVar.b(new Runnable() { // from class: com.haier.uhome.smart.service.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f30211a.lambda$tryUnBindSlaveDevice$8(str, str2, absSmartDeviceNotifierArr, gVar);
            }
        }, error, 5000L);
        SmartDeviceNotifier.getInstance().removeNotifier(absSmartDeviceNotifierArr[0]);
        return usdkerror;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKError tryUnregisterMessagePush(String str, String str2, int i7) {
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.h("tryUnregisterMessagePush error, server is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED.toError();
        }
        if (TextUtils.isEmpty(fixDeviceId(str))) {
            e3.a.h("tryUnregisterMessagePush error, device devId<%s> is invalid.", str);
            return ErrorConst.ERR_USDK_DEVICE_NOT_FOUND.toError();
        }
        if (TextUtils.isEmpty(str2)) {
            e3.a.h("tryUnregisterMessagePush pushId<%s> is invalid", str2);
            return ErrorConst.ERR_USDK_INVALID_PARAM.toError();
        }
        e3.a.d("", "", "tryUnregisterMessagePush devId<%s> pushId<%s> sn<%d>", str, str2, Integer.valueOf(i7));
        int iUnRegisterMessagePush = this.mNativeService.unRegisterMessagePush(str, str2, i7);
        e3.a.d("", "", "tryUnregisterMessagePush devId<%s> pushId<%s> sn<%d> ret<%d>", str, str2, Integer.valueOf(i7), Integer.valueOf(iUnRegisterMessagePush));
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        if (iUnRegisterMessagePush == errorConst.getErrorId()) {
            return errorConst.toError();
        }
        uSDKError usdkerror = new uSDKError(iUnRegisterMessagePush);
        usdkerror.a("ugw error");
        return usdkerror;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.haier.uhome.usdk.base.api.c<ResourceFile> tryUploadResource(String str, String str2, j0 j0Var, String str3, int i7) {
        com.haier.uhome.usdk.base.api.c<ResourceFile> cVar = new com.haier.uhome.usdk.base.api.c<>();
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.h("tryUploadResource error, server is not running", new Object[0]);
            cVar.a(ErrorConst.ERR_USDK_UNSTARTED.toError());
            return cVar;
        }
        if (getOnlineDeviceById(str) == null) {
            e3.a.h("tryUploadResource error onLineDevice<%s> not found", str);
            cVar.a(ErrorConst.ERR_USDK_DEVICE_NOT_FOUND.toError());
            return cVar;
        }
        if (TextUtils.isEmpty(str2) || i7 <= 0) {
            e3.a.h("tryUploadResource resourcePath<%s> expiryTime<%d>", str2, Integer.valueOf(i7));
            cVar.a(ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return cVar;
        }
        File file = new File(str2);
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        map2.put("uploadClientId", str);
        map2.put("fileCreator", str3);
        map2.put("fileHash", com.haier.library.common.util.a.g(file));
        map2.put("expiryTime", Integer.valueOf(i7));
        String strValueOf = String.valueOf(System.currentTimeMillis());
        String strB = v.b(this.mContext, "APP_ID");
        map.put("sign", getSign(strB, v.b(this.mContext, "APP_KEY"), strValueOf, "https://resource.haier.net/rsservice/v1/union/upload"));
        map.put("appId", strB);
        map.put("timestamp", strValueOf);
        String strZ = com.haier.library.json.a.Z(map2);
        e3.a.d("tryUploadResource header<%s> body<%s>", map.toString(), strZ, new Object[0]);
        e3.a.e("tryUploadResource body<%s>", com.haier.library.json.a.Z(map2));
        com.haier.library.okhttp.a aVarT = com.haier.library.okhttp.api.e.n(15L, TimeUnit.SECONDS, false).t("https://resource.haier.net/rsservice/v1/union/upload", map, strZ, file, j0Var);
        String strQ = "";
        if (aVarT == null || !aVarT.Q()) {
            uSDKError error = ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR.toError();
            error.a(aVarT != null ? aVarT.g0() : "");
            cVar.a(error);
            return cVar;
        }
        try {
            strQ = aVarT.b().Q();
        } catch (IOException e8) {
            e8.printStackTrace();
        }
        e3.a.e("tryUploadResource response<%s>", strQ);
        ResourceFile resourceFile = new ResourceFile();
        try {
            com.haier.library.json.e eVarT = com.haier.library.json.a.t(strQ);
            com.haier.library.json.e eVarL0 = eVarT != null ? eVarT.L0(MessengerShareContentUtility.ATTACHMENT_PAYLOAD) : null;
            if (eVarL0 != null) {
                resourceFile = (ResourceFile) com.haier.library.json.a.z(eVarL0.toString(), ResourceFile.class);
            }
            cVar.a(ErrorConst.RET_USDK_OK.toError());
            cVar.a(resourceFile);
            return cVar;
        } catch (Exception e9) {
            e9.printStackTrace();
            cVar.a(ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR.toError());
            return cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKError tryunRegisterResource(String str, String str2) {
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.h("tryunRegisterResource error, server is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED.toError();
        }
        if (TextUtils.isEmpty(str2)) {
            e3.a.h("tryunRegisterResource resName<%s> is invalid", str2);
            return ErrorConst.ERR_USDK_INVALID_PARAM.toError();
        }
        if (TextUtils.isEmpty(fixDeviceId(str))) {
            e3.a.h("tryunRegisterResource error, device devId<%s> is invalid.", str);
            return ErrorConst.ERR_USDK_DEVICE_NOT_FOUND.toError();
        }
        e3.a.d("", "", "tryunRegisterResource devId<%s> resName<%s>", str, str2);
        int iUnRegisterResource = this.mNativeService.unRegisterResource(str, str2);
        e3.a.d("", "", "tryunRegisterResource devId<%s> resName<%s> ret<%d>", str, str2, Integer.valueOf(iUnRegisterResource));
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        if (iUnRegisterResource == errorConst.getErrorId()) {
            return errorConst.toError();
        }
        uSDKError usdkerror = new uSDKError(iUnRegisterResource);
        usdkerror.a("ugw error");
        return usdkerror;
    }

    private void unRegistNetworkListener() {
        com.haier.library.common.b.h.a().d(this.mContext, this.mIConnectStatusObserver);
    }

    private void wait(CountDownLatch countDownLatch) {
        try {
            e3.a.e("await count reached zero ? %s", Boolean.valueOf(countDownLatch.await(6L, TimeUnit.SECONDS)));
        } catch (InterruptedException e8) {
            e3.a.g("latch get excp %s ", e8);
            Thread.currentThread().interrupt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeRsp(final String str, final BaseSmartRsp baseSmartRsp, final int i7) {
        new m<Void, Void, Void>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.34
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public Void doInBackground(Void... voidArr) {
                BaseSmartRsp baseSmartRsp2;
                if (SDKState.STATE_STARTED != SmartDeviceService.this.getState()) {
                    e3.a.e("SmartDeviceService writeRsp failed , sdk not start!", new Object[0]);
                    return null;
                }
                int i8 = i7;
                if (i8 == 3) {
                    AckService.getInstance().sendWriteAck(str, baseSmartRsp);
                } else if (i8 == 8 && (baseSmartRsp2 = baseSmartRsp) != null) {
                    e3.a.e("SmartDeviceService writeRsp <%s,%d,%s>", str, Integer.valueOf(baseSmartRsp2.getReqSn()), Integer.valueOf(baseSmartRsp.getResult()));
                    e3.a.e("SmartDeviceService writeRsp <%s,%d,%s> ret %d: ", str, Integer.valueOf(baseSmartRsp.getReqSn()), Integer.valueOf(baseSmartRsp.getResult()), Integer.valueOf(SmartDeviceService.this.mNativeService.writeRsp(str, baseSmartRsp.getReqSn(), baseSmartRsp.getResult())));
                }
                return null;
            }
        }.execute(new Void[0]);
    }

    public void addDevice(final SmartDevice smartDevice, final com.haier.uhome.usdk.base.api.i<String> iVar) {
        new m<Void, Void, com.haier.uhome.usdk.base.api.c<String>>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public com.haier.uhome.usdk.base.api.c<String> doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryAddDevice(smartDevice);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(com.haier.uhome.usdk.base.api.c<String> cVar) {
                if (ErrorConst.RET_USDK_OK == cVar.a()) {
                    SmartDeviceService.this.mMac = cVar.c();
                    smartDevice.setDevId(SmartDeviceService.this.mMac);
                    SmartDeviceService.this.mSmartDevices.put(SmartDeviceService.this.mMac, smartDevice);
                    SmartDeviceService smartDeviceService = SmartDeviceService.this;
                    smartDeviceService.notifyDeviceAdd(smartDeviceService.mMac);
                }
                com.haier.uhome.usdk.base.api.i iVar2 = iVar;
                if (iVar2 == null) {
                    e3.a.o("addDevice callback is null,so give up this callback.", new Object[0]);
                } else {
                    iVar2.onCallback(cVar);
                }
            }
        }.execute(new Void[0]);
    }

    public void addDeviceByRandomPrefix(final SmartDevice smartDevice, final boolean z7, final com.haier.uhome.usdk.base.api.i<String> iVar) {
        new m<Void, Void, com.haier.uhome.usdk.base.api.c<String>>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public com.haier.uhome.usdk.base.api.c<String> doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryAddDeviceByRandomPrefix(smartDevice, z7);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(com.haier.uhome.usdk.base.api.c<String> cVar) {
                if (ErrorConst.RET_USDK_OK == cVar.a()) {
                    smartDevice.setDevId(cVar.c());
                    SmartDeviceService.this.mSmartDevices.put(cVar.c(), smartDevice);
                    SmartDeviceService.this.notifyDeviceAdd(cVar.c());
                }
                com.haier.uhome.usdk.base.api.i iVar2 = iVar;
                if (iVar2 == null) {
                    e3.a.o("addDevice callback is null,so give up this callback.", new Object[0]);
                } else {
                    iVar2.onCallback(cVar);
                }
            }
        }.execute(new Void[0]);
    }

    public void addDeviceRelation(final String str, final String str2, final ICallback<Void> iCallback) {
        new m<Void, Void, uSDKError>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.41
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public uSDKError doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryAddDeviceRelation(str, str2);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(uSDKError usdkerror) {
                if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
                    com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
                } else {
                    com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
                }
            }
        }.execute(new Void[0]);
    }

    public synchronized void addListener(ISmartDeviceManagerListener iSmartDeviceManagerListener) {
        if (iSmartDeviceManagerListener == null) {
            return;
        }
        e3.a.e("SmartDeviceService addListener", new Object[0]);
        this.mManagerListenerList.add(iSmartDeviceManagerListener);
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.smart.service.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f30183a.lambda$addListener$0();
            }
        });
    }

    public void addSlaveDevice(final SmartDevice smartDevice, final com.haier.uhome.usdk.base.api.i<String> iVar) {
        new m<Void, Void, com.haier.uhome.usdk.base.api.c<String>>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public com.haier.uhome.usdk.base.api.c<String> doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryAddSlaveDevice(smartDevice);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(com.haier.uhome.usdk.base.api.c<String> cVar) {
                if (ErrorConst.RET_USDK_OK == cVar.a()) {
                    smartDevice.setDevId(cVar.c());
                    SmartDeviceService.this.mSmartDevices.put(cVar.c(), smartDevice);
                    SmartDeviceService.this.notifyDeviceAdd(cVar.c());
                }
                com.haier.uhome.usdk.base.api.i iVar2 = iVar;
                if (iVar2 == null) {
                    e3.a.o("addSlaveDevice callback is null,so give up this callback.", new Object[0]);
                } else {
                    iVar2.onCallback(cVar);
                }
            }
        }.execute(new Void[0]);
    }

    public void annexDeviceOnline(String str, String str2, String str3, String str4, String str5, String str6, boolean z7, String str7, ICallback<String> iCallback) {
        uSDKError error = ErrorConst.RET_USDK_OK.toError();
        e3.a.d("", "", "annexDeviceOnline<%s, %s, %s, %s, %s, %s, %s, %s>", str, str2, str3, str4, str5, str6, Boolean.valueOf(z7), str7);
        String strAnnexDeviceOnline = this.mNativeService.annexDeviceOnline(str, str2, str3, str4, str5, str6, z7, str7);
        e3.a.d("", "", "annexDeviceOnline<%s, %s, %s, %s, %s, %s, %s, %s> ret<%s>", str, str2, str3, str4, str5, str6, Boolean.valueOf(z7), str7, strAnnexDeviceOnline);
        if (!TextUtils.isEmpty(strAnnexDeviceOnline)) {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, strAnnexDeviceOnline);
            notifyDeviceAdd(strAnnexDeviceOnline);
        } else {
            error.setCode(ErrorConst.ERR_INTERNAL.getErrorId());
            error.a("ugw error");
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, error);
        }
    }

    public void bindDevice(final String str, final String str2, final double d8, final o oVar) {
        final TraceNode traceNodeA = com.haier.uhome.trace.api.b.a().a(str2, d8, (TraceNode) null);
        new m<Void, Void, ErrorConst>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.12
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public ErrorConst doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryBindDevice(str2, str, d8, traceNodeA);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(ErrorConst errorConst) {
                com.haier.uhome.trace.api.b.a().h(errorConst.getErrorId(), errorConst == ErrorConst.RET_USDK_OK ? str2 : "", traceNodeA);
                o oVar2 = oVar;
                if (oVar2 == null) {
                    e3.a.o("bindDevice callback is null,so give up this callback.", new Object[0]);
                } else {
                    oVar2.onCallback(errorConst);
                }
            }
        }.execute(new Void[0]);
    }

    public void bindSlaveDevice(final String str, final TraceNode traceNode, final ICallback<Void> iCallback) {
        new m<Void, Void, uSDKError>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.26
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public uSDKError doInBackground(Void... voidArr) {
                SmartDeviceService smartDeviceService = SmartDeviceService.this;
                String str2 = str;
                TraceNode traceNode2 = traceNode;
                return smartDeviceService.tryBindSlaveDevice(str2, traceNode2 != null ? traceNode2.getTraceId() : null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(uSDKError usdkerror) {
                if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
                    com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
                } else {
                    com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
                }
            }
        }.execute(new Void[0]);
    }

    public void bindWindow(final String str, final int i7, final o oVar) {
        new m<Void, Void, ErrorConst>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.18
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public ErrorConst doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryBindWindow(str, i7);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(ErrorConst errorConst) {
                o oVar2 = oVar;
                if (oVar2 == null) {
                    e3.a.o("bindWindow callback is null,so give up this callback.", new Object[0]);
                } else {
                    oVar2.onCallback(errorConst);
                }
            }
        }.execute(new Void[0]);
    }

    public void businessUp(final String str, final String str2, final byte[] bArr, final o oVar) {
        new m<Void, Void, ErrorConst>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.19
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public ErrorConst doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryBusinessUp(str, str2, bArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(ErrorConst errorConst) {
                o oVar2 = oVar;
                if (oVar2 == null) {
                    e3.a.o("businessUp callback is null,so give up this callback.", new Object[0]);
                } else {
                    oVar2.onCallback(errorConst);
                }
            }
        }.execute(new Void[0]);
    }

    public void delDevice(final String str, final com.haier.uhome.usdk.base.api.i<String> iVar) {
        new m<Void, Void, com.haier.uhome.usdk.base.api.c<String>>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.8
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public com.haier.uhome.usdk.base.api.c<String> doInBackground(Void... voidArr) {
                SmartDeviceService smartDeviceService = SmartDeviceService.this;
                smartDeviceService.delDeviceInner(smartDeviceService.getOnlineDeviceById(str));
                return SmartDeviceService.this.tryDelDevice(str);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(com.haier.uhome.usdk.base.api.c<String> cVar) {
                if (ErrorConst.RET_USDK_OK == cVar.a()) {
                    SmartDeviceService.this.mSmartDevices.remove(str);
                    SmartDeviceService.this.notifyDeviceDel(str);
                    SmartDeviceService.this.mOnlineDevices.remove(str);
                    SmartDeviceService.this.notifyDeviceDel(str);
                }
                com.haier.uhome.usdk.base.api.i iVar2 = iVar;
                if (iVar2 == null) {
                    e3.a.o("delDevice callback is null,so give up this callback.", new Object[0]);
                } else {
                    iVar2.onCallback(cVar);
                }
            }
        }.execute(new Void[0]);
    }

    public void deviceGroupOnline(final String str, final String str2, final String str3, final ICallback<Void> iCallback) {
        new m<Void, Void, uSDKError>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.52
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public uSDKError doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryDeviceGroupOnline(str, str2, str3);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(uSDKError usdkerror) {
                if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
                    com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
                } else {
                    com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
                }
            }
        }.execute(new Void[0]);
    }

    public void deviceGroupRsp(final DeviceGroupReqType deviceGroupReqType, final String str, final int i7, final int i8, final ICallback<Void> iCallback) {
        new m<Void, Void, uSDKError>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.53
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public uSDKError doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryDeviceGroupRsp(deviceGroupReqType, str, i7, i8);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(uSDKError usdkerror) {
                if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
                    com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
                } else {
                    com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
                }
            }
        }.execute(new Void[0]);
    }

    public void fetchGroupMember(final String str, final ICallback<List<String>> iCallback) {
        m.execute(new Runnable() { // from class: com.haier.uhome.smart.service.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f30198a.lambda$fetchGroupMember$11(str, iCallback);
            }
        });
    }

    public void gatewayDeviceOnline(String str, String str2, String str3, String str4, String str5, boolean z7, String str6, ICallback<String> iCallback) {
        uSDKError error = ErrorConst.RET_USDK_OK.toError();
        e3.a.d("", "", "gatewayDeviceOnline<%s, %s, %s, %s, %s, %s, %s>", str, str2, str3, str4, str5, Boolean.valueOf(z7), str6);
        String strGatewayDeviceOnline = this.mNativeService.gatewayDeviceOnline(str, str2, str3, str4, str5, z7, str6);
        e3.a.d("", "", "gatewayDeviceOnline<%s, %s, %s, %s, %s, %s, %s> ret<%s>", str, str2, str3, str4, str5, Boolean.valueOf(z7), str6, strGatewayDeviceOnline);
        if (!TextUtils.isEmpty(strGatewayDeviceOnline)) {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, strGatewayDeviceOnline);
            notifyDeviceAdd(strGatewayDeviceOnline);
        } else {
            error.setCode(ErrorConst.ERR_INTERNAL.getErrorId());
            error.a("ugw error");
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, error);
        }
    }

    public void gatewayVoiceDeviceOnline(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z7, String str10, ICallback<String> iCallback) {
        uSDKError error = ErrorConst.RET_USDK_OK.toError();
        e3.a.d("", "", "gatewayVoiceDeviceOnline<%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s>", str, str2, str3, str4, str5, str6, str7, str8, str9, Boolean.valueOf(z7), str10);
        String strGatewayVoiceDeviceOnline = this.mNativeService.gatewayVoiceDeviceOnline(str, str2, str3, str4, str5, str6, str7, str7, str9, z7, str10);
        e3.a.d("", "", "gatewayVoiceDeviceOnline<%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s> ret<%s>", str, str2, str3, str4, str5, str6, str7, str8, str9, Boolean.valueOf(z7), str10, strGatewayVoiceDeviceOnline);
        if (!TextUtils.isEmpty(strGatewayVoiceDeviceOnline)) {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, strGatewayVoiceDeviceOnline);
            notifyDeviceAdd(strGatewayVoiceDeviceOnline);
        } else {
            error.setCode(ErrorConst.ERR_INTERNAL.getErrorId());
            error.a("ugw error");
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, error);
        }
    }

    public void generalDeviceOnline(String str, String str2, String str3, String str4, String str5, boolean z7, String str6, ICallback<String> iCallback) {
        uSDKError error = ErrorConst.RET_USDK_OK.toError();
        e3.a.d("", "", "generalDeviceOnline<%s, %s, %s, %s, %s, %s, %s>", str, str2, str3, str4, str5, Boolean.valueOf(z7), str6);
        String strGeneralDeviceOnline = this.mNativeService.generalDeviceOnline(str, str2, str3, str4, str5, z7, str6);
        e3.a.d("", "", "generalDeviceOnline<%s, %s, %s, %s, %s, %s, %s> ret<%s>", str, str2, str3, str4, str5, Boolean.valueOf(z7), str6, strGeneralDeviceOnline);
        if (!TextUtils.isEmpty(strGeneralDeviceOnline)) {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, strGeneralDeviceOnline);
            notifyDeviceAdd(strGeneralDeviceOnline);
        } else {
            error.setCode(ErrorConst.ERR_INTERNAL.getErrorId());
            error.a("ugw error");
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, error);
        }
    }

    public void generalVoiceDeviceOnline(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z7, String str10, ICallback<String> iCallback) {
        uSDKError error = ErrorConst.RET_USDK_OK.toError();
        e3.a.d("", "", "generalVoiceDeviceOnline<%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s>", str, str2, str3, str4, str5, str6, str7, str8, str9, Boolean.valueOf(z7), str10);
        String strGeneralVoiceDeviceOnline = this.mNativeService.generalVoiceDeviceOnline(str, str2, str3, str4, str5, str6, str7, str7, str9, z7, str10);
        e3.a.d("", "", "generalVoiceDeviceOnline<%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s> ret<%s>", str, str2, str3, str4, str5, str6, str7, str8, str9, Boolean.valueOf(z7), str10, strGeneralVoiceDeviceOnline);
        if (!TextUtils.isEmpty(strGeneralVoiceDeviceOnline)) {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, strGeneralVoiceDeviceOnline);
            notifyDeviceAdd(strGeneralVoiceDeviceOnline);
        } else {
            error.setCode(ErrorConst.ERR_INTERNAL.getErrorId());
            error.a("ugw error");
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, error);
        }
    }

    public String getAuthToken() {
        AuthInfo authInfo = this.mAuthInfo;
        if (authInfo == null) {
            return null;
        }
        return authInfo.getAuthToken();
    }

    public void getBindQRCode(final SmartDevice smartDevice, final double d8, final com.haier.uhome.usdk.base.api.i<String> iVar) {
        new m<Void, Void, com.haier.uhome.usdk.base.api.c<String>>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.9
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public com.haier.uhome.usdk.base.api.c<String> doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryGetBindQRCode(smartDevice, d8);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(com.haier.uhome.usdk.base.api.c<String> cVar) {
                com.haier.uhome.usdk.base.api.i iVar2 = iVar;
                if (iVar2 == null) {
                    e3.a.o("getBindQRCode callback is null,so give up this callback.", new Object[0]);
                } else {
                    iVar2.onCallback(cVar);
                }
            }
        }.execute(new Void[0]);
    }

    public int getCloudState() {
        return this.mCloudState;
    }

    public String getDevIdPrefix() {
        SmartConfig smartConfig = this.mSmartConfig;
        return smartConfig == null ? "" : smartConfig.devIdPrefix;
    }

    public SmartDevice getDeviceById(String str) {
        if (str == null) {
            e3.a.h("getDeviceById error,devId<%s> is invalid.", str);
            return null;
        }
        for (SmartDevice smartDevice : getDeviceList()) {
            if (!TextUtils.isEmpty(smartDevice.getDevId()) && smartDevice.getDevId().endsWith(str)) {
                return smartDevice;
            }
        }
        e3.a.h("getDeviceById error,not found device<%s> in device map.", str);
        return null;
    }

    public ArrayList<SmartDevice> getDeviceList() {
        return new ArrayList<>(this.mSmartDevices.values());
    }

    public AbsSmartDevice getOnlineDeviceById(String str) {
        if (TextUtils.isEmpty(str)) {
            e3.a.h("getOnlineDeviceById error devId<%s> is invalid!", str);
            return null;
        }
        for (AbsSmartDevice absSmartDevice : getOnlineDeviceList()) {
            if (!TextUtils.isEmpty(absSmartDevice.getDeviceId()) && absSmartDevice.getDeviceId().endsWith(str)) {
                return absSmartDevice;
            }
        }
        e3.a.h("getOnlineDeviceById error,not found device<%s> in device map.", str);
        return null;
    }

    public ArrayList<AbsSmartDevice> getOnlineDeviceList() {
        return new ArrayList<>(this.mOnlineDevices.values());
    }

    public SDKState getState() {
        return this.mState;
    }

    public void groupDeviceOnline(String str, String str2, String str3, ICallback<String> iCallback) {
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        uSDKError error = errorConst.toError();
        e3.a.d("groupDeviceOnline groupId<%s> uplusId<%s> devKey<%s>", str, str2, str3);
        int iAddGroupDev = this.mNativeService.addGroupDev(str, str2);
        e3.a.d("groupDeviceOnline groupId<%s> uplusId<%s> devKey<%s> ret<%d>", str, str2, str3, Integer.valueOf(iAddGroupDev));
        if (iAddGroupDev == errorConst.getErrorId()) {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, str);
            notifyDeviceAdd(str);
        } else {
            error.setCode(ErrorConst.ERR_INTERNAL.getErrorId());
            error.a("ugw error");
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, error);
        }
    }

    public void initIotVideo(final String str, final String str2, final ICallback iCallback) {
        new m<Void, Void, uSDKError>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.43
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public uSDKError doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryInitIotVideo(str, str2);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(uSDKError usdkerror) {
                if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
                    com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
                } else {
                    com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
                }
            }
        }.execute(new Void[0]);
    }

    public void mcsServerInit(final String str, final ICallback<Void> iCallback) {
        new m<Void, Void, uSDKError>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.49
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public uSDKError doInBackground(Void... voidArr) {
                SmartDeviceService smartDeviceService = SmartDeviceService.this;
                return smartDeviceService.tryMcsServerInit(str, smartDeviceService.mContext.getFilesDir().getPath());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(uSDKError usdkerror) {
                if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
                    com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
                } else {
                    com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
                }
            }
        }.execute(new Void[0]);
    }

    public void messagePushInit(final ICallback<Void> iCallback) {
        new m<Void, Void, uSDKError>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.46
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public uSDKError doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryMessagePushInit();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(uSDKError usdkerror) {
                if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
                    com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
                } else {
                    com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
                }
            }
        }.execute(new Void[0]);
    }

    @Override // com.haier.uhome.smart.handler.ISmartBindNotifier
    public void notifyConfigProgress(int i7, int i8) {
    }

    @Override // com.haier.uhome.smart.handler.ISmartBindNotifier
    public void notifyConfigResult(int i7, int i8) {
    }

    @Override // com.haier.uhome.smart.handler.ISmartDeviceGroupNotifier
    public void notifyDeviceGroupControl(int i7, int i8, String str, String str2) {
        IDeviceGroupListener iDeviceGroupListener = this.mIDeviceGroupListener;
        if (iDeviceGroupListener != null) {
            iDeviceGroupListener.onDeviceGroupReqCallback(DeviceGroupReqType.getInstance(i7), i8, str, str2);
        }
    }

    @Override // com.haier.uhome.smart.handler.ISmartDeviceGroupNotifier
    public void notifyGroupMember(String str, int i7, List<String> list) {
        ISmartDeviceGroupNotifier iSmartDeviceGroupNotifier = this.mISmartDeviceGroupNotifier;
        if (iSmartDeviceGroupNotifier != null) {
            iSmartDeviceGroupNotifier.notifyGroupMember(str, i7, list);
        }
    }

    @Override // com.haier.uhome.smart.handler.ISmartBindNotifier
    public void notifyWifiAddDevice(String str, String str2, int i7, int i8, int i9) {
        IScanListener iScanListener;
        if (i9 == 8 && (iScanListener = this.mIScanListener) != null) {
            iScanListener.notifyWifiDeviceAdd(str, str2, i7, i8);
        }
    }

    @Override // com.haier.uhome.smart.handler.ISmartBindNotifier
    public void notifyWifiDelDevice(String str, int i7) {
        IScanListener iScanListener;
        if (i7 == 8 && (iScanListener = this.mIScanListener) != null) {
            iScanListener.notifyWifiDeviceDel(str);
        }
    }

    @Override // com.haier.uhome.smart.handler.ISmartBindNotifier
    public void notifyWifiScanStatus(int i7, int i8) {
        IScanListener iScanListener;
        if (i8 == 8 && (iScanListener = this.mIScanListener) != null) {
            iScanListener.notifyWifiScanStatus(i7);
        }
    }

    public void otaFinish(final String str, final String str2, final int i7, final ICallback<Void> iCallback) {
        new m<Void, Void, uSDKError>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.31
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public uSDKError doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryOtaFinish(str, str2, i7);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(uSDKError usdkerror) {
                if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
                    com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
                } else {
                    com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
                }
            }
        }.execute(new Void[0]);
    }

    public void otaInit(final int i7, final ICallback<Void> iCallback) {
        new m<Void, Void, uSDKError>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.32
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public uSDKError doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryOtaInit(i7);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(uSDKError usdkerror) {
                if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
                    com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
                } else {
                    com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
                }
            }
        }.execute(new Void[0]);
    }

    public void putDeviceToMap(AbsSmartDevice absSmartDevice) {
        e3.a.e("putDeviceToMap devid <%s>", absSmartDevice.getDeviceId());
        this.mOnlineDevices.put(absSmartDevice.getDeviceId(), absSmartDevice);
    }

    public void queryBindStatus(final String str, final int i7, final int i8, final ICallback<Void> iCallback) {
        new m<Void, Void, uSDKError>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.50
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public uSDKError doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryQueryBindStatus(str, i7, i8);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(uSDKError usdkerror) {
                if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
                    com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
                } else {
                    com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
                }
            }
        }.execute(new Void[0]);
    }

    public void refreshMdns(final o oVar) {
        new m<Void, Void, ErrorConst>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.20
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public ErrorConst doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryRefreshMdns();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(ErrorConst errorConst) {
                o oVar2 = oVar;
                if (oVar2 == null) {
                    e3.a.o("refreshMdns callback is null,so give up this callback.", new Object[0]);
                } else {
                    oVar2.onCallback(errorConst);
                }
            }
        }.execute(new Void[0]);
    }

    public void refreshNetwork(final ICallback<Void> iCallback) {
        new m<Void, Void, uSDKError>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.38
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public uSDKError doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryRefreshNetwork();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(uSDKError usdkerror) {
                if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
                    com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
                } else {
                    com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
                }
            }
        }.execute(new Void[0]);
    }

    public void registeDeviceGroupListener(final IDeviceGroupListener iDeviceGroupListener, final ICallback<Void> iCallback) {
        new m<Void, Void, uSDKError>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.51
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public uSDKError doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryRegisteDeviceGroupListener(iDeviceGroupListener);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(uSDKError usdkerror) {
                if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
                    com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
                } else {
                    com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
                }
            }
        }.execute(new Void[0]);
    }

    public void registerAnnexDevice(String str, String str2, String str3, String str4, ICallback<RegisterResult> iCallback) {
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        uSDKError error = errorConst.toError();
        e3.a.d("", "", "registerAnnexDevice<%s, %s, %s, %s>", str, str2, str3, str4);
        RegisterResult registerResultRegisterAnnexDevice = this.mNativeService.registerAnnexDevice(str, str2, str3, str4);
        e3.a.d("", "", "registerAnnexDevice<%s, %s, %s, %s> ret<%s>", str, str2, str3, str4, registerResultRegisterAnnexDevice.toString());
        if (registerResultRegisterAnnexDevice.getUgwCode() == errorConst.getErrorId()) {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, registerResultRegisterAnnexDevice);
            return;
        }
        error.setCode(ErrorConst.ERR_INTERNAL.getErrorId());
        error.a(String.valueOf(registerResultRegisterAnnexDevice.getUgwCode()));
        com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, error);
    }

    public void registerDownloadOtapkgCb(final String str, final String str2, final String str3, final String str4, final ICallback<Void> iCallback) {
        new m<Void, Void, uSDKError>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.29
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public uSDKError doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryRegisterDownloadOtapkgCb(str, str2, str3, str4);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(uSDKError usdkerror) {
                if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
                    com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
                } else {
                    com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
                }
            }
        }.execute(new Void[0]);
    }

    public void registerGatewayDevice(String str, String str2, String str3, String str4, ICallback<RegisterResult> iCallback) {
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        uSDKError error = errorConst.toError();
        e3.a.d("", "", "registerGatewayDevice<%s, %s, %s, %s>", str, str2, str3, str4);
        RegisterResult registerResultRegisterGatewayDevice = this.mNativeService.registerGatewayDevice(str, str2, str3, str4);
        e3.a.d("", "", "registerGatewayDevice<%s, %s, %s, %s> ret<%s>", str, str2, str3, str4, registerResultRegisterGatewayDevice.toString());
        if (registerResultRegisterGatewayDevice.getUgwCode() == errorConst.getErrorId()) {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, registerResultRegisterGatewayDevice);
            return;
        }
        error.setCode(ErrorConst.ERR_INTERNAL.getErrorId());
        error.a(String.valueOf(registerResultRegisterGatewayDevice.getUgwCode()));
        com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, error);
    }

    public void registerGatewayVoiceDevice(String str, String str2, String str3, String str4, ICallback<RegisterResult> iCallback) {
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        uSDKError error = errorConst.toError();
        e3.a.d("", "", "registerGatewayVoiceDevice<%s, %s, %s, %s>", str, str2, str3, str4);
        RegisterResult registerResultRegisterGatewayVoiceDevice = this.mNativeService.registerGatewayVoiceDevice(str, str2, str3, str4);
        e3.a.d("", "", "registerGatewayVoiceDevice<%s, %s, %s, %s> ret<%s>", str, str2, str3, str4, registerResultRegisterGatewayVoiceDevice.toString());
        if (registerResultRegisterGatewayVoiceDevice.getUgwCode() == errorConst.getErrorId()) {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, registerResultRegisterGatewayVoiceDevice);
            return;
        }
        error.setCode(ErrorConst.ERR_INTERNAL.getErrorId());
        error.a(String.valueOf(registerResultRegisterGatewayVoiceDevice.getUgwCode()));
        com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, error);
    }

    public void registerGeneralDevice(String str, String str2, String str3, String str4, ICallback<RegisterResult> iCallback) {
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        uSDKError error = errorConst.toError();
        e3.a.d("", "", "registerGeneralDevice<%s, %s, %s, %s>", str, str2, str3, str4);
        RegisterResult registerResultRegisterGeneralDevice = this.mNativeService.registerGeneralDevice(str, str2, str3, str4);
        e3.a.d("", "", "registerGeneralDevice<%s, %s, %s, %s> ret<%s>", str, str2, str3, str4, registerResultRegisterGeneralDevice.toString());
        if (registerResultRegisterGeneralDevice.getUgwCode() == errorConst.getErrorId()) {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, registerResultRegisterGeneralDevice);
            return;
        }
        error.setCode(ErrorConst.ERR_INTERNAL.getErrorId());
        error.a(String.valueOf(registerResultRegisterGeneralDevice.getUgwCode()));
        com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, error);
    }

    public void registerGeneralVoiceDevice(String str, String str2, String str3, String str4, ICallback<RegisterResult> iCallback) {
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        uSDKError error = errorConst.toError();
        e3.a.d("", "", "registerGeneralVoiceDevice<%s, %s, %s, %s>", str, str2, str3, str4);
        RegisterResult registerResultRegisterGeneralVoiceDevice = this.mNativeService.registerGeneralVoiceDevice(str, str2, str3, str4);
        e3.a.d("", "", "registerGeneralVoiceDevice<%s, %s, %s, %s> ret<%s>", str, str2, str3, str4, registerResultRegisterGeneralVoiceDevice.toString());
        if (registerResultRegisterGeneralVoiceDevice.getUgwCode() == errorConst.getErrorId()) {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, registerResultRegisterGeneralVoiceDevice);
            return;
        }
        error.setCode(ErrorConst.ERR_INTERNAL.getErrorId());
        error.a(String.valueOf(registerResultRegisterGeneralVoiceDevice.getUgwCode()));
        com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, error);
    }

    public void registerMessagePush(final MessagePush messagePush, final ICallback<Void> iCallback) {
        new m<Void, Void, uSDKError>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.44
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public uSDKError doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryRegisterMessagePush(messagePush);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(uSDKError usdkerror) {
                if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
                    com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
                } else {
                    com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
                }
            }
        }.execute(new Void[0]);
    }

    public void registerResource(final String str, final String str2, final ICallback<Void> iCallback) {
        new m<Void, Void, uSDKError>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.22
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public uSDKError doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryRegisterResource(str, str2);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(uSDKError usdkerror) {
                if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
                    com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
                } else {
                    com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
                }
            }
        }.execute(new Void[0]);
    }

    public void registerSlaveDevice(String str, String str2, String str3, String str4, ICallback<RegisterResult> iCallback) {
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        uSDKError error = errorConst.toError();
        e3.a.d("", "", "registerSlaveDevice<%s, %s, %s, %s>", str, str2, str3, str4);
        RegisterResult registerResultRegisterSlaveDevice = this.mNativeService.registerSlaveDevice(str, str2, str3, str4);
        e3.a.d("", "", "registerSlaveDevice<%s, %s, %s, %s> ret<%s>", str, str2, str3, str4, registerResultRegisterSlaveDevice.toString());
        if (registerResultRegisterSlaveDevice.getUgwCode() == errorConst.getErrorId()) {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, registerResultRegisterSlaveDevice);
            return;
        }
        error.setCode(ErrorConst.ERR_INTERNAL.getErrorId());
        error.a(String.valueOf(registerResultRegisterSlaveDevice.getUgwCode()));
        com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, error);
    }

    public synchronized void removeListener(ISmartDeviceManagerListener iSmartDeviceManagerListener) {
        if (iSmartDeviceManagerListener == null) {
            return;
        }
        this.mManagerListenerList.remove(iSmartDeviceManagerListener);
    }

    public void reportAlarm(final String str, final List<SmartDevicePair> list, final o oVar) {
        new m<Void, Void, ErrorConst>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.16
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public ErrorConst doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryReportAlarm(str, list);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(ErrorConst errorConst) {
                o oVar2 = oVar;
                if (oVar2 == null) {
                    e3.a.o("reportAlarm callback is null,so give up this callback.", new Object[0]);
                } else {
                    oVar2.onCallback(errorConst);
                }
            }
        }.execute(new Void[0]);
    }

    public void reportBigData(final String str, final String str2, final String str3, final o oVar) {
        new m<Void, Void, ErrorConst>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.17
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public ErrorConst doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryReportBigData(str, str2, str3);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(ErrorConst errorConst) {
                o oVar2 = oVar;
                if (oVar2 == null) {
                    e3.a.o("reportBigData callback is null,so give up this callback.", new Object[0]);
                } else {
                    oVar2.onCallback(errorConst);
                }
            }
        }.execute(new Void[0]);
    }

    public void reportBindProcess(final int i7, final String str, final String str2, final String str3, final int i8, final String str4, final ICallback<Void> iCallback) {
        new m<Void, Void, uSDKError>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.42
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public uSDKError doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryReportBindProcess(i7, str, str2, str3, i8, str4);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(uSDKError usdkerror) {
                if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
                    com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
                } else {
                    com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
                }
            }
        }.execute(new Void[0]);
    }

    public void reportMessageStatus(final MessageStatusAck messageStatusAck, final ICallback<Void> iCallback) {
        new m<Void, Void, uSDKError>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.47
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public uSDKError doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryReportMessageStatus(messageStatusAck);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(uSDKError usdkerror) {
                if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
                    com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
                } else {
                    com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
                }
            }
        }.execute(new Void[0]);
    }

    public void reportResource(final String str, final String str2, final byte[] bArr, final int i7, final ICallback<Void> iCallback) {
        new m<Void, Void, uSDKError>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.24
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public uSDKError doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryReportResource(str, str2, bArr, i7);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(uSDKError usdkerror) {
                if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
                    com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
                } else {
                    com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
                }
            }
        }.execute(new Void[0]);
    }

    public void restartDevGW(final o oVar) {
        new m<Void, Void, ErrorConst>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.21
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public ErrorConst doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryRestartDevGW();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(ErrorConst errorConst) {
                o oVar2 = oVar;
                if (oVar2 == null) {
                    e3.a.o("restartDevGW callback is null,so give up this callback.", new Object[0]);
                } else {
                    oVar2.onCallback(errorConst);
                }
            }
        }.execute(new Void[0]);
    }

    public uSDKError sendIotAudio(String str, byte[] bArr, int i7, long j7, int i8) {
        if (getOnlineDeviceById(str) == null) {
            e3.a.h("sendIotAudio error device<%s> not online", str);
            return ErrorConst.ERR_USDK_DEVICE_NOT_FOUND.toError();
        }
        int iSendIotAudio = this.mNativeService.sendIotAudio(bArr, i7, j7, i8);
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        if (iSendIotAudio == errorConst.getErrorId()) {
            return errorConst.toError();
        }
        uSDKError usdkerror = new uSDKError(iSendIotAudio);
        usdkerror.a("ugw error");
        return usdkerror;
    }

    public uSDKError sendIotVideo(String str, byte[] bArr, int i7, long j7, int i8) {
        if (getOnlineDeviceById(str) == null) {
            e3.a.h("sendIotVideo error device<%s> not online", str);
            return ErrorConst.ERR_USDK_DEVICE_NOT_FOUND.toError();
        }
        int iSendIotVideo = this.mNativeService.sendIotVideo(bArr, i7, j7, i8);
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        if (iSendIotVideo == errorConst.getErrorId()) {
            return errorConst.toError();
        }
        uSDKError usdkerror = new uSDKError(iSendIotVideo);
        usdkerror.a("ugw error");
        return usdkerror;
    }

    public void setAuthToken(AuthInfo authInfo) {
        AuthInfo authInfo2 = this.mAuthInfo;
        if (authInfo == authInfo2) {
            e3.a.o("device authToken not change!", new Object[0]);
        } else if (authInfo2 != null && authInfo2.equals(authInfo)) {
            e3.a.o("device authToken not change!", new Object[0]);
        } else {
            this.mAuthInfo = authInfo;
            notifyDeviceAuthToken(authInfo);
        }
    }

    protected void setCloudState(int i7) {
        if (i7 == this.mCloudState) {
            e3.a.o("CloudState not change!", new Object[0]);
        } else {
            this.mCloudState = i7;
            notifyCloudState(i7);
        }
    }

    public void setOtaMode(final String str, final OtaMode otaMode, final ICallback<Void> iCallback) {
        new m<Void, Void, uSDKError>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.30
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public uSDKError doInBackground(Void... voidArr) {
                return SmartDeviceService.this.trySetOtaMode(str, otaMode);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(uSDKError usdkerror) {
                if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
                    com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
                } else {
                    com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
                }
            }
        }.execute(new Void[0]);
    }

    protected void setState(SDKState sDKState) {
        if (sDKState == this.mState) {
            e3.a.o("SDKState not change!", new Object[0]);
        } else {
            this.mState = sDKState;
        }
    }

    public void setWifiScannerListener(IScanListener iScanListener) {
        this.mIScanListener = iScanListener;
    }

    public void slaveDeviceOnline(String str, String str2, String str3, String str4, String str5, String str6, boolean z7, CommunicationProtocol communicationProtocol, String str7, ICallback<String> iCallback) {
        uSDKError error = ErrorConst.RET_USDK_OK.toError();
        e3.a.d("", "", "slaveDeviceOnline<%s, %s, %s, %s, %s, %s, %s, %d, %s>", str, str2, str3, str4, str5, str6, Boolean.valueOf(z7), Integer.valueOf(communicationProtocol.getValue()), str7);
        String strSlaveDeviceOnline = this.mNativeService.slaveDeviceOnline(str, str2, str3, str4, str5, str6, z7, communicationProtocol.getValue(), str7);
        e3.a.d("", "", "slaveDeviceOnline<%s, %s, %s, %s, %s, %s, %s, %d, %s> ret<%s>", str, str2, str3, str4, str5, str6, Boolean.valueOf(z7), Integer.valueOf(communicationProtocol.getValue()), str7, strSlaveDeviceOnline);
        if (!TextUtils.isEmpty(strSlaveDeviceOnline)) {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, strSlaveDeviceOnline);
            notifyDeviceAdd(strSlaveDeviceOnline);
        } else {
            error.setCode(ErrorConst.ERR_INTERNAL.getErrorId());
            error.a("ugw error");
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, error);
        }
    }

    public void startPairingRsp(final int i7, final int i8, final ICallback<Void> iCallback) {
        new m<Void, Void, uSDKError>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.39
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public uSDKError doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryStartPairingRsp(i7, i8);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(uSDKError usdkerror) {
                if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
                    com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
                } else {
                    com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
                }
            }
        }.execute(new Void[0]);
    }

    public void startService(final Context context, final String str, final int i7, final o oVar) {
        new m<Void, Void, ErrorConst>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public ErrorConst doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryStartService(context, str, i7);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(ErrorConst errorConst) {
                if (errorConst == ErrorConst.RET_USDK_OK) {
                    SmartDeviceService.this.registNeworkListener();
                }
                o oVar2 = oVar;
                if (oVar2 == null) {
                    e3.a.o("startService callback is null,so give up this callback.", new Object[0]);
                } else {
                    oVar2.onCallback(errorConst);
                }
            }
        }.execute(new Void[0]);
    }

    public void startWifiScanDevice(final int i7, final ICallback<Void> iCallback) {
        new m<Void, Void, uSDKError>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.13
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public uSDKError doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryStartWifiScanDevice(i7);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(uSDKError usdkerror) {
                if (iCallback == null) {
                    e3.a.o("startWifiScanDevice callback is null,so give up this callback.", new Object[0]);
                } else if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
                    iCallback.onSuccess(null);
                } else {
                    iCallback.onFailure(usdkerror);
                }
            }
        }.execute(new Void[0]);
    }

    public void stopService(final o oVar) {
        new m<Void, Void, ErrorConst>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public ErrorConst doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryStopService();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(ErrorConst errorConst) {
                if (ErrorConst.RET_USDK_OK == errorConst) {
                    Iterator<SmartDevice> it = SmartDeviceService.this.getDeviceList().iterator();
                    while (it.hasNext()) {
                        SmartDeviceService.this.notifyDeviceDel(it.next().getDevId());
                    }
                    SmartDeviceService.this.mSmartDevices.clear();
                    SmartDeviceService.this.mOnlineDevices.clear();
                    SmartDeviceService.this.mMac = null;
                    SmartDeviceService.this.setCloudState(0);
                    SmartDeviceService.this.mSmartConfig = null;
                }
                o oVar2 = oVar;
                if (oVar2 == null) {
                    e3.a.o("stopService callback is null,so give up this callback.", new Object[0]);
                } else {
                    oVar2.onCallback(errorConst);
                }
            }
        }.execute(new Void[0]);
    }

    public void stopWifiScanDevice(final ICallback<Void> iCallback) {
        new m<Void, Void, uSDKError>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.14
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public uSDKError doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryStopWifiScanDevice();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(uSDKError usdkerror) {
                if (iCallback == null) {
                    e3.a.o("stopWifiScanDevice callback is null,so give up this callback.", new Object[0]);
                } else if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
                    iCallback.onSuccess(null);
                } else {
                    iCallback.onFailure(usdkerror);
                }
            }
        }.execute(new Void[0]);
    }

    public void unBindSlaveDevice(final String str, final TraceNode traceNode, final ICallback<Void> iCallback) {
        new m<Void, Void, uSDKError>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.28
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public uSDKError doInBackground(Void... voidArr) {
                SmartDeviceService smartDeviceService = SmartDeviceService.this;
                String str2 = str;
                TraceNode traceNode2 = traceNode;
                return smartDeviceService.tryUnBindSlaveDevice(str2, traceNode2 != null ? traceNode2.getTraceId() : null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(uSDKError usdkerror) {
                if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
                    com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
                } else {
                    com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
                }
            }
        }.execute(new Void[0]);
    }

    public void unRegisterMessagePush(final String str, final String str2, final int i7, final ICallback<Void> iCallback) {
        new m<Void, Void, uSDKError>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.45
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public uSDKError doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryUnregisterMessagePush(str, str2, i7);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(uSDKError usdkerror) {
                if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
                    com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
                } else {
                    com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
                }
            }
        }.execute(new Void[0]);
    }

    public void unRegisterResource(final String str, final String str2, final ICallback<Void> iCallback) {
        new m<Void, Void, uSDKError>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.23
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public uSDKError doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryunRegisterResource(str, str2);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(uSDKError usdkerror) {
                if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
                    com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
                } else {
                    com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
                }
            }
        }.execute(new Void[0]);
    }

    public void uploadResource(final String str, final String str2, final j0 j0Var, final String str3, final int i7, final ICallback<ResourceFile> iCallback) {
        new m<Void, Void, com.haier.uhome.usdk.base.api.c<ResourceFile>>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.48
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public com.haier.uhome.usdk.base.api.c<ResourceFile> doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryUploadResource(str, str2, j0Var, str3, i7);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(com.haier.uhome.usdk.base.api.c<ResourceFile> cVar) {
                if (cVar.b().a(ErrorConst.RET_USDK_OK)) {
                    com.haier.uhome.usdk.base.utils.b.a((ICallback<ResourceFile>) iCallback, cVar.c());
                } else {
                    com.haier.uhome.usdk.base.utils.b.a(iCallback, cVar.b());
                }
            }
        }.execute(new Void[0]);
    }

    private SmartDeviceService() {
        this.obj = new Object();
        this.mSmartDeviceNotifier = new ISmartDeviceNotifier() { // from class: com.haier.uhome.smart.service.SmartDeviceService.1
            @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
            public void notifyDeviceAuthToken(int i7, String str, int i8) {
                SmartDeviceService.this.setAuthToken(new AuthInfo(i7, str));
            }

            @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
            public void notifyDeviceBindResult(String str, int i7, int i8, int i9) {
                ISmartDeviceListener listener;
                e3.a.e("notifyDeviceBindResult " + str + " result <%d>", Integer.valueOf(i8));
                if (i9 != 8) {
                    return;
                }
                SmartDevice deviceById = SmartDeviceService.this.getDeviceById(str);
                if (deviceById != null && (listener = deviceById.getListener()) != null) {
                    listener.onDeviceBindCallback(str, i7, i8);
                }
                AbsSmartDevice onlineDeviceById = SmartDeviceService.this.getOnlineDeviceById(str);
                if (onlineDeviceById == null) {
                    e3.a.v("onLineDevice <%s> not found ,so ignore this bind msg.", str);
                }
                for (ISmartDeviceListener iSmartDeviceListener : onlineDeviceById.getSmartDeviceListerner()) {
                    if (iSmartDeviceListener != null) {
                        iSmartDeviceListener.onDeviceBindCallback(str, i7, i8);
                    }
                }
            }

            @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
            public void notifyDeviceBindStatus(String str, int i7) {
                if (i7 != 8) {
                    return;
                }
                AbsSmartDevice onlineDeviceById = SmartDeviceService.this.getOnlineDeviceById(str);
                if (onlineDeviceById == null) {
                    e3.a.v("onLineDevice<%s> not found ,so ignore this bind status msg.", str);
                    return;
                }
                List<ISmartDeviceBindStatusListener> smartDeviceBindStatusListener = onlineDeviceById.getSmartDeviceBindStatusListener();
                if (smartDeviceBindStatusListener == null) {
                    e3.a.v("notifyDeviceBindStatus bindStatusListeners is null", new Object[0]);
                    return;
                }
                for (ISmartDeviceBindStatusListener iSmartDeviceBindStatusListener : smartDeviceBindStatusListener) {
                    if (iSmartDeviceBindStatusListener != null) {
                        iSmartDeviceBindStatusListener.onDeviceBindStatus(str);
                    }
                }
            }

            @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
            public void notifyDeviceBindWindow(String str, String str2, int i7, int i8) {
                e3.a.u("SmartDevice notifyDeviceBindWindoww,devId <%s>,sn<%s>,err<%d>", str, str2, Integer.valueOf(i7));
                if (SmartDeviceService.this.getDeviceById(str) != null) {
                    SmartDeviceService.this.mBindWindowInfo.put(str2, i7 + "@" + str);
                }
                if (SmartDeviceService.this.getOnlineDeviceById(str) == null) {
                    e3.a.v("onLineDevice <%s> not found ,so ignore this bind window.", str);
                    return;
                }
                SmartDeviceService.this.mBindWindowInfo.put(str2, i7 + "@" + str);
            }

            @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
            public void notifyDeviceBusinessDown(String str, String str2, byte[] bArr, int i7) {
                ISmartDeviceListener listener;
                SmartDevice deviceById = SmartDeviceService.this.getDeviceById(str);
                if (deviceById != null && (listener = deviceById.getListener()) != null) {
                    listener.onBusinessDown(str, str2, bArr);
                }
                AbsSmartDevice onlineDeviceById = SmartDeviceService.this.getOnlineDeviceById(str);
                if (onlineDeviceById == null) {
                    e3.a.v("onLineDevice <%s> not found ,so ignore this business down.", str);
                    return;
                }
                for (ISmartDeviceListener iSmartDeviceListener : onlineDeviceById.getSmartDeviceListerner()) {
                    if (iSmartDeviceListener != null) {
                        iSmartDeviceListener.onBusinessDown(str, str2, bArr);
                    }
                }
            }

            @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
            public void notifyDeviceCloudMsg(String str, int i7, int i8, int i9) {
                ISmartDeviceListener listener;
                SmartDevice deviceById = SmartDeviceService.this.getDeviceById(str);
                if (deviceById != null && (listener = deviceById.getListener()) != null) {
                    listener.onCloudMsg(str, i7, i8);
                }
                AbsSmartDevice onlineDeviceById = SmartDeviceService.this.getOnlineDeviceById(str);
                if (onlineDeviceById == null) {
                    e3.a.v("AbsSmartDevice <%s> not found ,so ignore this cloud msg.", str);
                }
                for (ISmartDeviceListener iSmartDeviceListener : onlineDeviceById.getSmartDeviceListerner()) {
                    if (iSmartDeviceListener != null) {
                        iSmartDeviceListener.onCloudMsg(str, i7, i8);
                    }
                }
            }

            @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
            public void notifyDeviceCloudState(int i7, int i8) {
                SmartDeviceService.this.setCloudState(i7);
            }

            @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
            public void notifyDeviceDepairing(String str, String str2, int i7) {
                if (i7 != 8) {
                    return;
                }
                AbsSmartDevice onlineDeviceById = SmartDeviceService.this.getOnlineDeviceById(str2);
                if (onlineDeviceById == null) {
                    e3.a.v("onLineDevice<%s> not found ,so ignore this RegisterRes msg.", str2);
                    return;
                }
                CopyOnWriteArrayList<ISmartDevicePairingListener> smartDevicePairingListeners = onlineDeviceById.getSmartDevicePairingListeners();
                if (smartDevicePairingListeners == null) {
                    e3.a.v("notifyDeviceDepairing pairingListeners is null", new Object[0]);
                    return;
                }
                for (ISmartDevicePairingListener iSmartDevicePairingListener : smartDevicePairingListeners) {
                    if (iSmartDevicePairingListener != null) {
                        iSmartDevicePairingListener.onDeviceDepairing(str, str2);
                    }
                }
            }

            @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
            public void notifyDeviceGetLocalKey(String str, String str2, int i7, int i8, int i9, int i10) {
            }

            @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
            public void notifyDeviceOp(String str, int i7, String str2, ArrayList<Pair> arrayList, int i8) {
                ISmartDeviceListener listener;
                SmartDevice deviceById = SmartDeviceService.this.getDeviceById(str);
                if (deviceById != null && (listener = deviceById.getListener()) != null) {
                    SmartDeviceService.this.opRsp(str, str2, listener.onDeviceOpCallback(str, i7, str2, SmartDeviceService.this.genSmartDevicePair(arrayList)), i8);
                }
                AbsSmartDevice onlineDeviceById = SmartDeviceService.this.getOnlineDeviceById(str);
                if (onlineDeviceById == null) {
                    e3.a.v("onLineDevice <%s> not found ,so ignore this device op.", str);
                    return;
                }
                for (ISmartDeviceListener iSmartDeviceListener : onlineDeviceById.getSmartDeviceListerner()) {
                    if (iSmartDeviceListener != null) {
                        SmartDeviceService.this.opRsp(str, str2, iSmartDeviceListener.onDeviceOpCallback(str, i7, str2, SmartDeviceService.this.genSmartDevicePair(arrayList)), i8);
                    }
                }
            }

            @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
            public void notifyDevicePairing(String str, int i7, String str2, String str3, String str4, int i8) {
                if (i8 != 8) {
                    return;
                }
                SmartDeviceService smartDeviceService = SmartDeviceService.this;
                AbsSmartDevice onlineDeviceById = smartDeviceService.getOnlineDeviceById(smartDeviceService.getClientId());
                if (onlineDeviceById == null) {
                    e3.a.v("gatewayDevice<%s> not found ,so ignore this RegisterRes msg.", SmartDeviceService.this.getClientId());
                    return;
                }
                CopyOnWriteArrayList<ISmartDevicePairingListener> smartDevicePairingListeners = onlineDeviceById.getSmartDevicePairingListeners();
                if (smartDevicePairingListeners == null) {
                    e3.a.v("notifyDevicePairing pairingListeners is null", new Object[0]);
                    return;
                }
                for (ISmartDevicePairingListener iSmartDevicePairingListener : smartDevicePairingListeners) {
                    if (iSmartDevicePairingListener != null) {
                        iSmartDevicePairingListener.onDevicePairing(str, i7, str2, str3, str4);
                    }
                }
            }

            @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
            public void notifyDeviceRead(String str, int i7, String str2, int i8) {
                ISmartDeviceListener listener;
                SmartDevice deviceById = SmartDeviceService.this.getDeviceById(str);
                if (deviceById != null && (listener = deviceById.getListener()) != null) {
                    SmartDeviceService.this.readRsp(str, str2, listener.onDeviceReadCallback(str, i7, str2), i8);
                }
                AbsSmartDevice onlineDeviceById = SmartDeviceService.this.getOnlineDeviceById(str);
                if (onlineDeviceById == null) {
                    e3.a.v("onLineDevice <%s> not found ,so ignore this device read.", str);
                    return;
                }
                for (ISmartDeviceListener iSmartDeviceListener : onlineDeviceById.getSmartDeviceListerner()) {
                    if (iSmartDeviceListener != null) {
                        SmartDeviceService.this.readRsp(str, str2, iSmartDeviceListener.onDeviceReadCallback(str, i7, str2), i8);
                    }
                }
            }

            @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
            public void notifyDeviceRegisterRes(String str, String str2, int i7) {
                if (i7 != 8) {
                    return;
                }
                AbsSmartDevice onlineDeviceById = SmartDeviceService.this.getOnlineDeviceById(str);
                if (onlineDeviceById == null) {
                    e3.a.v("onLineDevice <%s> not found ,so ignore this RegisterRes msg.", str);
                    return;
                }
                for (ISmartDeviceResourceListener iSmartDeviceResourceListener : onlineDeviceById.getSmartDeviceResourceListener()) {
                    if (iSmartDeviceResourceListener != null) {
                        iSmartDeviceResourceListener.onRegisterRes(str, str2);
                    }
                }
            }

            @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
            public void notifyDeviceRelationResult(String str, int i7) {
            }

            @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
            public void notifyDeviceResChannalStatus(String str, int i7, int i8) {
                if (i8 != 8) {
                    return;
                }
                AbsSmartDevice onlineDeviceById = SmartDeviceService.this.getOnlineDeviceById(str);
                if (onlineDeviceById == null) {
                    e3.a.v("onLineDevice <%s> not found ,so ignore this ResChannalStatus msg.", str);
                    return;
                }
                for (ISmartDeviceResourceListener iSmartDeviceResourceListener : onlineDeviceById.getSmartDeviceResourceListener()) {
                    if (iSmartDeviceResourceListener != null) {
                        iSmartDeviceResourceListener.onResChannelStatus(str, i7);
                    }
                }
            }

            @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
            public void notifyDeviceUnbindStatus(String str, int i7) {
                if (i7 != 8) {
                    return;
                }
                AbsSmartDevice onlineDeviceById = SmartDeviceService.this.getOnlineDeviceById(str);
                if (onlineDeviceById == null) {
                    e3.a.v("onLineDevice<%s> not found ,so ignore this unbind status msg.", str);
                    return;
                }
                List<ISmartDeviceBindStatusListener> smartDeviceBindStatusListener = onlineDeviceById.getSmartDeviceBindStatusListener();
                if (smartDeviceBindStatusListener == null) {
                    e3.a.v("notifyDeviceUnbindStatus bindStatusListeners is null", new Object[0]);
                    return;
                }
                for (ISmartDeviceBindStatusListener iSmartDeviceBindStatusListener : smartDeviceBindStatusListener) {
                    if (iSmartDeviceBindStatusListener != null) {
                        iSmartDeviceBindStatusListener.onDeviceUnbindStatus(str);
                    }
                }
            }

            @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
            public void notifyDeviceWrite(String str, int i7, String str2, String str3, int i8) {
                ISmartDeviceListener listener;
                SmartDevice deviceById = SmartDeviceService.this.getDeviceById(str);
                if (deviceById != null && (listener = deviceById.getListener()) != null) {
                    SmartDeviceService.this.writeRsp(str, listener.onDeviceWriteCallback(str, i7, str2, str3), i8);
                }
                AbsSmartDevice onlineDeviceById = SmartDeviceService.this.getOnlineDeviceById(str);
                if (onlineDeviceById == null) {
                    e3.a.v("onLineDevice <%s> not found ,so ignore this device write.", str);
                    return;
                }
                for (ISmartDeviceListener iSmartDeviceListener : onlineDeviceById.getSmartDeviceListerner()) {
                    if (iSmartDeviceListener != null) {
                        SmartDeviceService.this.writeRsp(str, iSmartDeviceListener.onDeviceWriteCallback(str, i7, str2, str3), i8);
                    }
                }
            }

            @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
            public void notifyQueryDeviceBindStatus(String str, int i7, int i8, int i9, int i10) {
                if (i10 != 8) {
                    return;
                }
                AbsSmartDevice onlineDeviceById = SmartDeviceService.this.getOnlineDeviceById(str);
                if (onlineDeviceById == null) {
                    e3.a.v("onLineDevice<%s> not found ,so ignore this query bind status msg.", str);
                    return;
                }
                List<ISmartDeviceBindStatusListener> smartDeviceBindStatusListener = onlineDeviceById.getSmartDeviceBindStatusListener();
                if (smartDeviceBindStatusListener == null) {
                    e3.a.v("notifyQueryDeviceBindStatus bindStatusListeners is null", new Object[0]);
                    return;
                }
                for (ISmartDeviceBindStatusListener iSmartDeviceBindStatusListener : smartDeviceBindStatusListener) {
                    if (iSmartDeviceBindStatusListener != null) {
                        iSmartDeviceBindStatusListener.onQueryDeviceBindStatus(str, i7, i8, i9);
                    }
                }
            }

            @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
            public void notifySlaveDeviceBindResult(String str, int i7) {
            }

            @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
            public void notifySlaveDeviceUnbindResult(String str, int i7) {
            }

            @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
            public void notifyUSDKReq(String str, int i7, int i8, int i9) {
                if (i9 != 3) {
                    return;
                }
                SmartDeviceService.this.handlerUSDKReq(str, str, i7, i8);
            }
        };
        this.mSmartDeviceOtaNotifer = new ISmartDeviceOtaNotifer() { // from class: com.haier.uhome.smart.service.SmartDeviceService.2
            @Override // com.haier.uhome.smart.handler.ISmartDeviceOtaNotifer
            public void notifyDeviceOtaDownload(String str, String str2, String str3, String str4, int i7) {
                if (i7 != 8) {
                    return;
                }
                AbsSmartDevice onlineDeviceById = SmartDeviceService.this.getOnlineDeviceById(str);
                if (onlineDeviceById == null) {
                    e3.a.v("onLineDevice <%s> not found ,so ignore this ota download msg.", str);
                    return;
                }
                for (ISmartDeviceOtaListener iSmartDeviceOtaListener : onlineDeviceById.getSmartDeviceOtaListeners()) {
                    if (iSmartDeviceOtaListener != null) {
                        iSmartDeviceOtaListener.onOtaDownload(str, str2, str3, str4);
                    }
                }
            }

            @Override // com.haier.uhome.smart.handler.ISmartDeviceOtaNotifer
            public void notifyDeviceOtaDownloadFinish(String str, String str2, int i7, String str3, int i8) {
                if (i8 != 8) {
                    return;
                }
                AbsSmartDevice onlineDeviceById = SmartDeviceService.this.getOnlineDeviceById(str);
                if (onlineDeviceById == null) {
                    e3.a.v("onLineDevice <%s> not found ,so ignore this ota download finish msg.", str);
                    return;
                }
                for (ISmartDeviceOtaListener iSmartDeviceOtaListener : onlineDeviceById.getSmartDeviceOtaListeners()) {
                    if (iSmartDeviceOtaListener != null) {
                        iSmartDeviceOtaListener.onOtaDownloadFinish(str, str2, i7, str3);
                    }
                }
            }

            @Override // com.haier.uhome.smart.handler.ISmartDeviceOtaNotifer
            public void notifyDeviceOtaDownloadStart(String str, String str2, String str3, String str4, int i7) {
                if (i7 != 8) {
                    return;
                }
                AbsSmartDevice onlineDeviceById = SmartDeviceService.this.getOnlineDeviceById(str);
                if (onlineDeviceById == null) {
                    e3.a.v("onLineDevice <%s> not found ,so ignore this ota download start msg.", str);
                    return;
                }
                for (ISmartDeviceOtaListener iSmartDeviceOtaListener : onlineDeviceById.getSmartDeviceOtaListeners()) {
                    if (iSmartDeviceOtaListener != null) {
                        iSmartDeviceOtaListener.onOtaDownloadStart(str, str2, str3, str4);
                    }
                }
            }
        };
        this.mIConnectStatusObserver = new com.haier.library.common.b.e() { // from class: com.haier.uhome.smart.service.f
            @Override // com.haier.library.common.b.e
            public /* synthetic */ void a(r rVar) {
                com.haier.library.common.b.b.a(this, rVar);
            }

            @Override // com.haier.library.common.b.e
            public final void a(com.haier.library.common.b.a aVar) {
                this.f30201a.lambda$new$9(aVar);
            }
        };
        this.mNativeService = NativeService.getInstance();
        setState(SDKState.STATE_UNSTART);
        this.mSmartDevices = new ConcurrentHashMap<>();
        this.mOnlineDevices = new ConcurrentHashMap<>();
        this.mBindWindowInfo = new ConcurrentHashMap<>();
        this.mManagerListenerList = new CopyOnWriteArrayList<>();
        SmartProtocol.register();
        SmartDeviceNotifier.getInstance().addNotifier(this.mSmartDeviceNotifier);
        SmartDeviceNotifier.getInstance().addNotifier(this);
        SmartDeviceNotifier.getInstance().addOtaNotifier(this.mSmartDeviceOtaNotifer);
        SmartDeviceNotifier.getInstance().addGroupNotifier(this);
    }

    public void getBindQRCode(final AbsSmartDevice absSmartDevice, final double d8, final com.haier.uhome.usdk.base.api.i<String> iVar) {
        new m<Void, Void, com.haier.uhome.usdk.base.api.c<String>>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.10
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public com.haier.uhome.usdk.base.api.c<String> doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryGetBindQRCode(absSmartDevice, d8);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(com.haier.uhome.usdk.base.api.c<String> cVar) {
                com.haier.uhome.usdk.base.api.i iVar2 = iVar;
                if (iVar2 == null) {
                    e3.a.o("getBindQRCode callback is null,so give up this callback.", new Object[0]);
                } else {
                    iVar2.onCallback(cVar);
                }
            }
        }.execute(new Void[0]);
    }

    public void startService(final StartOption startOption, final ICallback<Void> iCallback) {
        uSDKError error = ErrorConst.RET_USDK_OK.toError();
        if (SDKState.STATE_STARTED == getState()) {
            e3.a.e("Smartdevice server is already running", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a(iCallback, (Object) null);
            return;
        }
        e3.a.d("", "", "startService<%s>", startOption.toString());
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(startOption.getDomain())) {
            e3.a.h("startService domain<%s> is invalid", startOption.getDomain());
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append(" domain=");
            sb.append(startOption.getDomain());
        }
        if (startOption.getPort() < 0) {
            e3.a.h("startService port<%d> is invalid", Integer.valueOf(startOption.getPort()));
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append(" port=");
            sb.append(startOption.getPort());
        }
        if (startOption.getRootCA() < 0) {
            e3.a.h("startService rootCA<%d> is invalid", Integer.valueOf(startOption.getRootCA()));
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append(" rootCA=");
            sb.append(startOption.getRootCA());
        }
        if (startOption.getContext() == null) {
            e3.a.h("startService context is invalid", startOption.getContext());
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append(" context=");
            sb.append(startOption.getContext());
        }
        this.mContext = startOption.getContext();
        final File file = new File(String.format("%s/%s", this.mContext.getFilesDir().getAbsolutePath(), com.haier.uhome.usdk.base.a.O));
        if (!file.exists()) {
            file.mkdirs();
        }
        if (error.a(ErrorConst.ERR_USDK_INVALID_PARAM)) {
            error.a(sb.toString());
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, error);
        } else {
            final String clientId = getClientId();
            new m<Void, Void, Void>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.37
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.haier.library.common.thread.m
                public Void doInBackground(Void... voidArr) {
                    int iStartService = SmartDeviceService.this.mNativeService.startService(startOption.getDomain(), startOption.getPort(), file.getPath(), startOption.getNetCardName(), startOption.getRootCA(), clientId, startOption.getAuthPath());
                    e3.a.d("", "", "startService<%s, %s> ret<%d>", startOption.toString(), clientId, Integer.valueOf(iStartService));
                    if (iStartService == ErrorConst.RET_USDK_OK.getErrorId()) {
                        com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
                        SmartDeviceService.this.setState(SDKState.STATE_STARTED);
                        SmartDeviceService.this.registNeworkListener();
                    } else {
                        ErrorConst errorConst = ErrorConst.ERR_INTERNAL;
                        errorConst.toError().a("ugw error ret:" + iStartService);
                        com.haier.uhome.usdk.base.utils.b.a(iCallback, errorConst.toError());
                        SmartDeviceService.this.setState(SDKState.STATE_UNSTART);
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    public void reportStatus(final String str, final List<SmartDevicePair> list, final o oVar) {
        new m<Void, Void, ErrorConst>() { // from class: com.haier.uhome.smart.service.SmartDeviceService.15
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public ErrorConst doInBackground(Void... voidArr) {
                return SmartDeviceService.this.tryReportStatus(str, list);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public void onPostExecute(ErrorConst errorConst) {
                o oVar2 = oVar;
                if (oVar2 == null) {
                    e3.a.o("reportStatus callback is null,so give up this callback.", new Object[0]);
                } else {
                    oVar2.onCallback(errorConst);
                }
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.haier.uhome.usdk.base.api.c<String> tryGetBindQRCode(final AbsSmartDevice absSmartDevice, double d8) {
        final com.haier.uhome.usdk.base.api.c<String> cVar = new com.haier.uhome.usdk.base.api.c<>();
        cVar.a(ErrorConst.ERR_USDK_TIMEOUT);
        if (SDKState.STATE_STARTED != getState()) {
            e3.a.e("tryGetBindQRCode error, server is not running", new Object[0]);
            cVar.a(ErrorConst.ERR_USDK_UNSTARTED);
            cVar.a((String) null);
            return cVar;
        }
        if (d8 <= 120.0d && d8 >= 10.0d) {
            final com.haier.library.common.thread.g gVar = new com.haier.library.common.thread.g();
            gVar.b(new Runnable() { // from class: com.haier.uhome.smart.service.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30189a.lambda$tryGetBindQRCode$5(absSmartDevice, cVar, gVar);
                }
            }, cVar, (long) (d8 * 1000.0d));
            return cVar;
        }
        e3.a.h("tryGetBindQRCode timeout<%s> is invalid.", Double.valueOf(d8));
        cVar.a(ErrorConst.ERR_USDK_INVALID_PARAM);
        cVar.a((String) null);
        return cVar;
    }
}
