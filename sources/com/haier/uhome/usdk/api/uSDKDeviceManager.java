package com.haier.uhome.usdk.api;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.haier.uhome.account.api.CustomReqInfo;
import com.haier.uhome.account.api.HttpRequestType;
import com.haier.uhome.account.api.interfaces.IAccountListener;
import com.haier.uhome.account.api.uAccount;
import com.haier.uhome.account.model.RespCommonModel;
import com.haier.uhome.account.model.RespModel;
import com.haier.uhome.account.model.uacmodel.UacDevice;
import com.haier.uhome.account.model.uacmodel.UacDeviceModulesInfo;
import com.haier.uhome.account.model.uacmodel.UacModulesInfoItem;
import com.haier.uhome.config.entity.ConfigResult;
import com.haier.uhome.control.base.api.DeviceStatus;
import com.haier.uhome.control.base.json.DeviceTokenInfo;
import com.haier.uhome.control.base.json.RouterSsidPasswordEvent;
import com.haier.uhome.mesh.api.model.MeshDeviceNode;
import com.haier.uhome.smart.api.AbsSmartDevice;
import com.haier.uhome.smart.api.SmartDevice;
import com.haier.uhome.smart.api.SmartDeviceManager;
import com.haier.uhome.smart.api.interfaces.ISmartDeviceManagerListener;
import com.haier.uhome.trace.api.DITraceNode;
import com.haier.uhome.trace.api.Trace;
import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.api.interfaces.IDeviceScanListener;
import com.haier.uhome.usdk.api.interfaces.IuSDKCallback;
import com.haier.uhome.usdk.api.interfaces.IuSDKConfigCallback;
import com.haier.uhome.usdk.api.interfaces.IuSDKDeviceManagerListener;
import com.haier.uhome.usdk.api.interfaces.IuSDKResultCallback;
import com.haier.uhome.usdk.api.interfaces.IuSDKSmartLinkCallback;
import com.haier.uhome.usdk.api.interfaces.IuSDKSoftApCallback;
import com.haier.uhome.usdk.api.interfaces.IuSDKSoftApDeviceConfigInfoCallback;
import com.haier.uhome.usdk.base.annotation.Keep;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.VersionManager;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.bind.SmartLinkBindInfo;
import com.haier.uhome.usdk.bind.SoftApBindInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class uSDKDeviceManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    uSDKUserInfo f30816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, uSDKDevice> f30817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ArrayList<uSDKDeviceTypeConst> f30818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.haier.uhome.control.cloud.api.d f30819d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AtomicBoolean f30820e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AtomicBoolean f30821f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private IuSDKDeviceManagerListener f30822g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AtomicBoolean f30823h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f30824i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f30825j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f30826k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile a f30827l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private com.haier.uhome.usdk.c.d<w> f30828m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.haier.uhome.control.local.d.e f30829n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final com.haier.uhome.usdk.api.a f30830o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ISmartDeviceManagerListener f30831p;

    /* JADX INFO: renamed from: com.haier.uhome.usdk.api.uSDKDeviceManager$19, reason: invalid class name */
    static /* synthetic */ class AnonymousClass19 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f30866a;

        static {
            int[] iArr = new int[com.haier.uhome.control.cloud.api.b.values().length];
            f30866a = iArr;
            try {
                iArr[com.haier.uhome.control.cloud.api.b.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30866a[com.haier.uhome.control.cloud.api.b.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30866a[com.haier.uhome.control.cloud.api.b.UNCONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f30866a[com.haier.uhome.control.cloud.api.b.CONNECT_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private enum a {
        STATE_NO,
        STATE_USER,
        STATE_SDK
    }

    static class b implements ICallback<ConfigResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ICallback<Integer> f30913a;

        b(ICallback<Integer> iCallback) {
            this.f30913a = iCallback;
        }

        @Override // com.haier.uhome.usdk.base.api.ICallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(ConfigResult configResult) {
            this.f30913a.onSuccess(Integer.valueOf(configResult.getConfigMode()));
        }

        @Override // com.haier.uhome.usdk.base.api.ICallback
        public void onFailure(uSDKError usdkerror) {
            this.f30913a.onFailure(usdkerror);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private uSDKErrorConst f30915b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private uSDKDeviceConfigInfo f30916c;

        private c() {
        }
    }

    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static uSDKDeviceManager f30917a = new uSDKDeviceManager();

        private d() {
        }
    }

    public static uSDKDeviceManager getSingleInstance() {
        return d.f30917a;
    }

    @Keep
    @Deprecated
    public void bindDevice(uSDKDevice usdkdevice, String str, int i7, IuSDKCallback iuSDKCallback) {
        bindDevice(usdkdevice, str, i7, null, iuSDKCallback);
    }

    @Deprecated
    public void configDeviceByNoPassword(String str, int i7, IuSDKConfigCallback iuSDKConfigCallback) {
        configDeviceByNoPassword(str, null, i7, iuSDKConfigCallback);
    }

    @com.haier.uhome.usdk.base.annotation.a
    @Deprecated
    public void configDeviceBySmartLink(String str, String str2, IuSDKSmartLinkCallback iuSDKSmartLinkCallback) {
        configDeviceBySmartLink(str, str2, 60, iuSDKSmartLinkCallback);
    }

    @Keep
    @Deprecated
    public void configDeviceBySoftAp(uSDKSoftApConfigInfo usdksoftapconfiginfo, IuSDKSoftApCallback iuSDKSoftApCallback) {
        configDeviceBySoftAp(usdksoftapconfiginfo, null, iuSDKSoftApCallback);
    }

    @Keep
    @Deprecated
    public void connectToCloud(uSDKUserInfo usdkuserinfo, final ICallback<Void> iCallback) {
        if (usdkuserinfo == null) {
            e3.a.h("connectToCloud with null uSDKUserInfo", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        if (TextUtils.isEmpty(usdkuserinfo.getUserToken())) {
            e3.a.h("connectToCloud with null token", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        String strG = com.haier.uhome.usdk.base.service.e.a().g();
        if (this.f30827l == a.STATE_USER && strG != null && !strG.equals(usdkuserinfo.getUserToken())) {
            e3.a.f("tryConnectToGateway error,last mToken = %s & token = %s", strG, usdkuserinfo.getUserToken(), new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, uSDKErrorConst.ERR_USDK_GATEWAY_IS_CONNECTED.toError());
        } else {
            com.haier.uhome.usdk.base.service.e.a().b(usdkuserinfo.getUserToken());
            com.haier.uhome.usdk.base.service.e.a().a(usdkuserinfo.getUserID());
            com.haier.uhome.trace.api.a.a("connectToCloud", iCallback);
            connectToGateway(com.haier.uhome.usdk.base.service.e.a().g(), com.haier.uhome.usdk.base.service.e.a().n(), com.haier.uhome.usdk.base.service.e.a().o(), new com.haier.uhome.usdk.b.f(new IuSDKCallback() { // from class: com.haier.uhome.usdk.api.b5
                @Override // com.haier.uhome.usdk.api.interfaces.IuSDKCallback
                public final void onCallback(uSDKErrorConst usdkerrorconst) {
                    uSDKDeviceManager.b(iCallback, usdkerrorconst);
                }
            }));
        }
    }

    @Deprecated
    public void connectToGateway(final String str, final String str2, final int i7, final IuSDKCallback iuSDKCallback) {
        e3.a.e("start connectToGateway. token is " + str + ",  domain is " + str2 + ",  port is " + i7, new Object[0]);
        com.haier.uhome.trace.api.a.a("connectToCloudOld", iuSDKCallback, str);
        new com.haier.library.common.thread.m<Void, Void, uSDKErrorConst>() { // from class: com.haier.uhome.usdk.api.uSDKDeviceManager.12
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public uSDKErrorConst doInBackground(Void... voidArr) {
                return uSDKDeviceManager.this.a(str, str2, i7);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(uSDKErrorConst usdkerrorconst) {
                if (uSDKErrorConst.RET_USDK_OK == usdkerrorconst) {
                    uSDKManager.getSingleInstance().a(com.haier.uhome.usdk.base.service.e.a().k(), true);
                    uSDKDeviceManager.this.f30827l = a.STATE_USER;
                }
                IuSDKCallback iuSDKCallback2 = iuSDKCallback;
                if (iuSDKCallback2 != null) {
                    iuSDKCallback2.onCallback(usdkerrorconst);
                } else {
                    e3.a.v("connectToGateway callback is null, so give up this callback.", new Object[0]);
                }
            }
        }.execute(new Void[0]);
    }

    @Keep
    @Deprecated
    public void disconnectToCloud(final ICallback<Void> iCallback) {
        com.haier.uhome.trace.api.a.a("disconnectToCloud", iCallback);
        disconnectToGateway(new com.haier.uhome.usdk.b.f(new IuSDKCallback() { // from class: com.haier.uhome.usdk.api.u5
            @Override // com.haier.uhome.usdk.api.interfaces.IuSDKCallback
            public final void onCallback(uSDKErrorConst usdkerrorconst) {
                uSDKDeviceManager.a(iCallback, usdkerrorconst);
            }
        }));
    }

    @Deprecated
    public void disconnectToGateway(final IuSDKCallback iuSDKCallback) {
        com.haier.uhome.trace.api.a.a("disconnectToCloudOld", iuSDKCallback);
        e3.a.e("start disconnectToGateway.", new Object[0]);
        new com.haier.library.common.thread.m<Void, Void, uSDKErrorConst>() { // from class: com.haier.uhome.usdk.api.uSDKDeviceManager.20
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public uSDKErrorConst doInBackground(Void... voidArr) {
                return uSDKDeviceManager.this.p();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(uSDKErrorConst usdkerrorconst) {
                if (uSDKErrorConst.RET_USDK_OK == usdkerrorconst) {
                    uSDKDeviceManager.this.f30827l = a.STATE_NO;
                    uSDKDeviceManager.this.a(Trace.createDITrace(), uSDKDeviceManager.this.u(), String.valueOf(usdkerrorconst.getErrorId()));
                }
                IuSDKCallback iuSDKCallback2 = iuSDKCallback;
                if (iuSDKCallback2 != null) {
                    iuSDKCallback2.onCallback(usdkerrorconst);
                } else {
                    e3.a.v("disconnectToGateway is null,so give up this callback.", new Object[0]);
                }
            }
        }.execute(new Void[0]);
    }

    public void getAuthDeviceList(final IuSDKResultCallback<ArrayList<uSDKDevice>> iuSDKResultCallback) {
        if (!uSDKManager.getSingleInstance().a()) {
            e3.a.h("sdk is not start,please start first!", new Object[0]);
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.u4
                @Override // java.lang.Runnable
                public final void run() {
                    uSDKDeviceManager.c(iuSDKResultCallback);
                }
            });
        } else {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                e3.a.h("tryDisconnectToGateway error, this thread is UI Thread!", new Object[0]);
                com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.v4
                    @Override // java.lang.Runnable
                    public final void run() {
                        uSDKDeviceManager.b(iuSDKResultCallback);
                    }
                });
                return;
            }
            String strG = com.haier.uhome.usdk.base.service.e.a().g();
            Context contextB = com.haier.uhome.usdk.base.service.e.a().b();
            if (TextUtils.isEmpty(strG)) {
                com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.w4
                    @Override // java.lang.Runnable
                    public final void run() {
                        uSDKDeviceManager.a(iuSDKResultCallback);
                    }
                });
            } else {
                com.haier.uhome.control.base.c.d.a().a(contextB, strG, new com.haier.uhome.control.base.api.j() { // from class: com.haier.uhome.usdk.api.x4
                    @Override // com.haier.uhome.control.base.api.j
                    public final void onDeviceTokenInfoList(ErrorConst errorConst, DeviceTokenInfo[] deviceTokenInfoArr) {
                        this.f31014a.a(iuSDKResultCallback, errorConst, deviceTokenInfoArr);
                    }
                });
            }
        }
    }

    public uSDKCloudConnectionState getCloudConnectionState() {
        return uSDKCloudConnectionState.getInstance(u().name());
    }

    @Keep
    public ArrayList<ConfigurableDevice> getConfigurableDeviceList() {
        return com.haier.library.common.util.u.a(com.haier.uhome.search.a.l.a().b(), new com.haier.library.common.util.p() { // from class: com.haier.uhome.usdk.api.c5
            @Override // com.haier.library.common.util.p
            public final Object transform(Object obj) {
                return this.f30478a.a((com.haier.uhome.search.a.k) obj);
            }
        });
    }

    public uSDKDevice getDevice(String str) {
        if (!TextUtils.isEmpty(str)) {
            String upperCase = str.toUpperCase();
            uSDKDevice usdkdevice = this.f30817b.get(upperCase);
            if (usdkdevice != null) {
                return usdkdevice;
            }
            for (Map.Entry<String, uSDKDevice> entry : this.f30817b.entrySet()) {
                String key = entry.getKey();
                if (key != null && key.endsWith(upperCase)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public ArrayList<uSDKDevice> getDeviceList() {
        ArrayList<uSDKDevice> arrayListA;
        synchronized (this.f30817b) {
            arrayListA = z.a((ArrayList<uSDKDevice>) com.haier.library.common.util.u.b(new ArrayList(this.f30817b.values()), new com.haier.library.common.util.u.c() { // from class: com.haier.uhome.usdk.api.s4
                @Override // com.haier.library.common.util.u.c
                public final boolean a(Object obj) {
                    return this.f30725a.d((uSDKDevice) obj);
                }
            }), this.f30818c);
        }
        return arrayListA;
    }

    public IuSDKDeviceManagerListener getDeviceManagerListener() {
        return this.f30822g;
    }

    public ArrayList<uSDKDeviceTypeConst> getInterestedDeviceTypes() {
        return new ArrayList<>(this.f30818c);
    }

    @com.haier.uhome.usdk.base.annotation.a
    public void getSmartLinkConfigErrorInfo(final String str, final IuSDKCallback iuSDKCallback) {
        new com.haier.library.common.thread.m<Void, Void, uSDKErrorConst>() { // from class: com.haier.uhome.usdk.api.uSDKDeviceManager.9
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public uSDKErrorConst doInBackground(Void... voidArr) {
                return uSDKDeviceManager.this.f(str);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(uSDKErrorConst usdkerrorconst) {
                IuSDKCallback iuSDKCallback2 = iuSDKCallback;
                if (iuSDKCallback2 == null) {
                    e3.a.o("getSmartLinkConfigErrorInfo callback is null,so give up this callback.", new Object[0]);
                } else {
                    iuSDKCallback2.onCallback(usdkerrorconst);
                }
            }
        }.execute(new Void[0]);
    }

    @Deprecated
    public void getSoftApDeviceConfigInfo(IuSDKSoftApDeviceConfigInfoCallback iuSDKSoftApDeviceConfigInfoCallback) {
        getSoftApDeviceConfigInfo(null, iuSDKSoftApDeviceConfigInfoCallback);
    }

    @Keep
    public void initUserGateWayDomain(String str, int i7) {
        this.f30825j = str;
        this.f30826k = i7;
    }

    @Keep
    protected l makeBestConnect() {
        return k();
    }

    @Keep
    public void refreshDeviceList(ICallback<Void> iCallback) {
        if (!uSDKManager.getSingleInstance().a()) {
            e3.a.h("refreshDeviceList : sdk is not start,please start first!", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_UNSTARTED.toError());
            return;
        }
        com.haier.uhome.control.cloud.api.d dVar = this.f30819d;
        if (dVar == null) {
            e3.a.h("refreshDeviceList : user is null!", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_NOT_SUPPORT.toError());
        } else {
            dVar.a();
            com.haier.uhome.usdk.base.utils.b.a(iCallback, (Object) null);
        }
    }

    public void setDeviceManagerListener(IuSDKDeviceManagerListener iuSDKDeviceManagerListener) {
        e3.a.e("setDeviceManagerListener <%s>", iuSDKDeviceManagerListener);
        this.f30822g = iuSDKDeviceManagerListener;
    }

    @Deprecated
    public void setDeviceScanListener(final IDeviceScanListener iDeviceScanListener) {
        e3.a.e("setDeviceScanListener <%s>", iDeviceScanListener);
        com.haier.uhome.search.a.l.a().a(new com.haier.uhome.search.a.e() { // from class: com.haier.uhome.usdk.api.uSDKDeviceManager.10
            @Override // com.haier.uhome.search.a.e
            public void a(com.haier.uhome.search.a.k kVar) {
                e3.a.e("SearchManager onDeviceScanned:" + kVar.i(), new Object[0]);
                IDeviceScanListener iDeviceScanListener2 = iDeviceScanListener;
                if (iDeviceScanListener2 != null) {
                    iDeviceScanListener2.onDeviceScanned(uSDKDeviceManager.this.a(kVar));
                }
            }

            @Override // com.haier.uhome.search.a.e
            public void b(com.haier.uhome.search.a.k kVar) {
                e3.a.e("SearchManager onDeviceRemoved:" + kVar.i(), new Object[0]);
                IDeviceScanListener iDeviceScanListener2 = iDeviceScanListener;
                if (iDeviceScanListener2 != null) {
                    iDeviceScanListener2.onDeviceRemoved(uSDKDeviceManager.this.a(kVar));
                }
            }
        });
    }

    public void setInterestedDeviceTypes(ArrayList<uSDKDeviceTypeConst> arrayList) {
        this.f30818c.clear();
        if (arrayList != null) {
            this.f30818c.addAll(arrayList);
        }
    }

    @Keep
    public void setKeepLocalOnline(boolean z7) {
        e3.a.e("setKeepLocalOnline %s", Boolean.valueOf(z7));
        this.f30821f.set(z7);
    }

    @Keep
    public uSDKError setUserInfo(uSDKUserInfo usdkuserinfo) {
        com.haier.uhome.trace.api.a.a(usdkuserinfo, com.haier.uhome.usdk.base.service.e.a().g());
        if (!uSDKManager.getSingleInstance().a()) {
            e3.a.h("setUserInfo: sdk is not start,please start first!", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED.toError();
        }
        if (usdkuserinfo != null && com.haier.library.common.util.c.j(usdkuserinfo.getUserToken())) {
            e3.a.h("setUserInfo: with null token", new Object[0]);
            return ErrorConst.ERR_USDK_INVALID_PARAM.toError();
        }
        this.f30816a = usdkuserinfo;
        n();
        return uSDKError.RET_USDK_OK;
    }

    @Keep
    public void startBleSearch(ICallback<Void> iCallback) {
        if (uSDKManager.getSingleInstance().a()) {
            com.haier.uhome.search.a.n.a().e(iCallback);
        } else {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, uSDKErrorConst.ERR_USDK_UNSTARTED.toError());
        }
    }

    @com.haier.uhome.usdk.base.annotation.a
    @Deprecated
    public void startScanConfigurableDevice(Context context, final IuSDKCallback iuSDKCallback) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.p5
            @Override // java.lang.Runnable
            public final void run() {
                uSDKDeviceManager.b(iuSDKCallback);
            }
        });
    }

    @Keep
    public void stopBindDevice(final uSDKDevice usdkdevice, final IuSDKCallback iuSDKCallback) {
        new com.haier.library.common.thread.m<Void, Void, uSDKErrorConst>() { // from class: com.haier.uhome.usdk.api.uSDKDeviceManager.16
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public uSDKErrorConst doInBackground(Void... voidArr) {
                return uSDKDeviceManager.this.c(usdkdevice);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(uSDKErrorConst usdkerrorconst) {
                IuSDKCallback iuSDKCallback2 = iuSDKCallback;
                if (iuSDKCallback2 != null) {
                    iuSDKCallback2.onCallback(usdkerrorconst);
                }
            }
        }.execute(new Void[0]);
    }

    @Keep
    public void stopBleSearch(ICallback<Void> iCallback) {
        if (uSDKManager.getSingleInstance().a()) {
            com.haier.uhome.search.a.n.a().f(iCallback);
        } else {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, uSDKErrorConst.ERR_USDK_UNSTARTED.toError());
        }
    }

    @Deprecated
    public void stopNoPasswordConfig(final IuSDKCallback iuSDKCallback) {
        new com.haier.library.common.thread.m<Void, Void, uSDKErrorConst>() { // from class: com.haier.uhome.usdk.api.uSDKDeviceManager.13
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public uSDKErrorConst doInBackground(Void... voidArr) {
                return uSDKDeviceManager.this.v();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(uSDKErrorConst usdkerrorconst) {
                IuSDKCallback iuSDKCallback2 = iuSDKCallback;
                if (iuSDKCallback2 == null) {
                    e3.a.n(com.haier.uhome.config.a.E, com.haier.uhome.config.a.H, "stopNoPasswordConfig callback is null,so give up this callback.", new Object[0]);
                } else {
                    iuSDKCallback2.onCallback(usdkerrorconst);
                }
            }
        }.execute(new Void[0]);
    }

    @com.haier.uhome.usdk.base.annotation.a
    @Deprecated
    public void stopScanConfigurableDevice(final IuSDKCallback iuSDKCallback) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.y5
            @Override // java.lang.Runnable
            public final void run() {
                uSDKDeviceManager.a(iuSDKCallback);
            }
        });
    }

    @com.haier.uhome.usdk.base.annotation.a
    public void stopSmartLinkConfig(IuSDKCallback iuSDKCallback) {
        t();
        com.haier.uhome.usdk.c.d<w> dVar = this.f30828m;
        if (dVar == null) {
            a(iuSDKCallback, uSDKErrorConst.RET_USDK_OK);
        } else {
            dVar.onFailure(ErrorConst.ERR_USDK_CONFIG_BE_CANCELED.toError());
            a(iuSDKCallback, uSDKErrorConst.RET_USDK_OK);
        }
    }

    @Keep
    public void unbindDevice(final uSDKDevice usdkdevice, final int i7, final IuSDKCallback iuSDKCallback) {
        new com.haier.library.common.thread.m<Void, Void, uSDKErrorConst>() { // from class: com.haier.uhome.usdk.api.uSDKDeviceManager.17
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public uSDKErrorConst doInBackground(Void... voidArr) {
                return uSDKDeviceManager.this.a(usdkdevice, i7);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(uSDKErrorConst usdkerrorconst) {
                IuSDKCallback iuSDKCallback2 = iuSDKCallback;
                if (iuSDKCallback2 != null) {
                    iuSDKCallback2.onCallback(usdkerrorconst);
                }
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: renamed from: com.haier.uhome.usdk.api.uSDKDeviceManager$23, reason: invalid class name */
    class AnonymousClass23 implements ISmartDeviceManagerListener {
        AnonymousClass23() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(String str, uSDKErrorConst usdkerrorconst) {
            if (uSDKErrorConst.RET_USDK_OK == usdkerrorconst) {
                uSDKDeviceManager.this.a(str, new IuSDKCallback() { // from class: com.haier.uhome.usdk.api.f6
                    @Override // com.haier.uhome.usdk.api.interfaces.IuSDKCallback
                    public final void onCallback(uSDKErrorConst usdkerrorconst2) {
                        uSDKDeviceManager.AnonymousClass23.a(usdkerrorconst2);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(uSDKErrorConst usdkerrorconst) {
            e3.a.e("onAuthToken connectToGateway result <%s>", usdkerrorconst.getValue());
        }

        @Override // com.haier.uhome.smart.api.interfaces.ISmartDeviceManagerListener
        public void onAuthToken(int i7, final String str) {
            e3.a.e("onAuthToken connectToGateway authToken<%s>", str);
            if (uSDKDeviceManager.this.f30827l == a.STATE_NO) {
                if (i7 == 0) {
                    e3.a.v("invoke direct auth before authed", new Object[0]);
                    return;
                } else {
                    uSDKDeviceManager.this.a(str, new IuSDKCallback() { // from class: com.haier.uhome.usdk.api.d6
                        @Override // com.haier.uhome.usdk.api.interfaces.IuSDKCallback
                        public final void onCallback(uSDKErrorConst usdkerrorconst) {
                            uSDKDeviceManager.AnonymousClass23.b(usdkerrorconst);
                        }
                    });
                    return;
                }
            }
            if (uSDKDeviceManager.this.f30827l != a.STATE_USER && uSDKDeviceManager.this.f30827l == a.STATE_SDK) {
                if (i7 != 1) {
                    if (i7 == 0) {
                        uSDKDeviceManager.this.disconnectToGateway(new com.haier.uhome.usdk.b.e(null));
                    }
                } else if (str == null || !str.equalsIgnoreCase(com.haier.uhome.usdk.base.service.e.a().g())) {
                    uSDKDeviceManager.this.disconnectToGateway(new com.haier.uhome.usdk.b.e(new IuSDKCallback() { // from class: com.haier.uhome.usdk.api.e6
                        @Override // com.haier.uhome.usdk.api.interfaces.IuSDKCallback
                        public final void onCallback(uSDKErrorConst usdkerrorconst) {
                            this.f30519a.a(str, usdkerrorconst);
                        }
                    }));
                } else {
                    e3.a.e("onAuthToken REVOKE_AUTH_LOGOUT_LOGIN but token unchanged so return direct", new Object[0]);
                }
            }
        }

        @Override // com.haier.uhome.smart.api.interfaces.ISmartDeviceManagerListener
        public void onCloudState(int i7) {
        }

        @Override // com.haier.uhome.smart.api.interfaces.ISmartDeviceManagerListener
        public void onDeviceAdd(String str) {
            String devIdPrefix = SmartDeviceManager.getInstance().getDevIdPrefix();
            if (TextUtils.isEmpty(uSDKDeviceManager.this.f30824i) || (!TextUtils.isEmpty(devIdPrefix) && !uSDKDeviceManager.this.f30824i.equals(devIdPrefix))) {
                uSDKDeviceManager.this.f30824i = devIdPrefix;
                e3.a.e("onDeviceAdd mSmartDevicePrifix : " + uSDKDeviceManager.this.f30824i, new Object[0]);
            }
            e3.a.e("uSDKDeviceManager : onDeviceAdd " + str, new Object[0]);
            uSDKDeviceManager.this.d(str);
        }

        @Override // com.haier.uhome.smart.api.interfaces.ISmartDeviceManagerListener
        public void onDeviceRemove(String str) {
            String devIdPrefix = SmartDeviceManager.getInstance().getDevIdPrefix();
            if (TextUtils.isEmpty(uSDKDeviceManager.this.f30824i) || (!TextUtils.isEmpty(devIdPrefix) && !uSDKDeviceManager.this.f30824i.equals(devIdPrefix))) {
                uSDKDeviceManager.this.f30824i = devIdPrefix;
                e3.a.e("onDeviceRemove mSmartDevicePrifix : " + uSDKDeviceManager.this.f30824i, new Object[0]);
            }
            e3.a.e("uSDKDeviceManager : onDeviceRemove " + str, new Object[0]);
            uSDKDevice usdkdevice = (uSDKDevice) uSDKDeviceManager.this.f30817b.get(str);
            if (usdkdevice != null) {
                usdkdevice.updateControlDevice(null, uSDKDeviceNetTypeConst.NET_NOUMENON);
                return;
            }
            e3.a.h("device map have no this device" + str, new Object[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(uSDKErrorConst usdkerrorconst) {
            e3.a.e("onAuthToken connectToGateway result <%s>", usdkerrorconst.getValue());
        }
    }

    private uSDKDeviceManager() {
        this.f30831p = new AnonymousClass23();
        this.f30817b = new ConcurrentHashMap<>();
        this.f30820e = new AtomicBoolean(false);
        this.f30821f = new AtomicBoolean(false);
        this.f30823h = new AtomicBoolean(false);
        this.f30818c = new ArrayList<>();
        this.f30827l = a.STATE_NO;
        k();
        r();
        q();
        j();
        this.f30830o = new com.haier.uhome.usdk.api.a(this);
    }

    private l k() {
        return VersionManager.getInstance().isSmartDevice() ? new m() : new j();
    }

    private synchronized uSDKError l() {
        final com.haier.uhome.control.cloud.api.d dVar = this.f30819d;
        if (dVar == null) {
            e3.a.o("tryDisconnectToCloud: try stop user but CloudUser is null so return", new Object[0]);
            m();
            return ErrorConst.RET_USDK_OK.toError();
        }
        com.haier.uhome.usdk.b.c.a().b();
        final com.haier.library.common.thread.g gVar = new com.haier.library.common.thread.g();
        Runnable runnable = new Runnable() { // from class: com.haier.uhome.usdk.api.y4
            @Override // java.lang.Runnable
            public final void run() {
                this.f31024a.d(dVar, gVar);
            }
        };
        uSDKErrorConst usdkerrorconst = uSDKErrorConst.ERR_USDK_TIMEOUT;
        gVar.b(runnable, usdkerrorconst, 5200L);
        uSDKErrorConst usdkerrorconst2 = (uSDKErrorConst) gVar.b(new Runnable() { // from class: com.haier.uhome.usdk.api.z4
            @Override // java.lang.Runnable
            public final void run() {
                this.f31035a.c(dVar, gVar);
            }
        }, usdkerrorconst, 5200L);
        if (uSDKErrorConst.RET_USDK_OK == usdkerrorconst2) {
            this.f30827l = a.STATE_NO;
            a(Trace.createDITrace(), u(), String.valueOf(usdkerrorconst2.getErrorId()));
        }
        return usdkerrorconst2.toError();
    }

    private void m() {
        for (uSDKDevice usdkdevice : getDeviceList()) {
            usdkdevice.updateControlDevice(null, uSDKDeviceNetTypeConst.NET_MESH);
            usdkdevice.updateControlDevice(null, uSDKDeviceNetTypeConst.NET_REMOTE);
        }
        com.haier.uhome.usdk.base.service.e.a().b((String) null);
        com.haier.uhome.usdk.base.service.e.a().a((String) null);
        this.f30819d = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        com.haier.library.common.thread.k.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.n5
            @Override // java.lang.Runnable
            public final void run() {
                this.f30658a.w();
            }
        });
    }

    private synchronized uSDKError o() {
        uSDKUserInfo usdkuserinfo = this.f30816a;
        com.haier.uhome.usdk.base.service.e eVarA = com.haier.uhome.usdk.base.service.e.a();
        if (usdkuserinfo == null) {
            uSDKError usdkerrorL = l();
            e3.a.e("setUserInfo: with null uif, disconnect to cloud %s", usdkerrorL);
            return usdkerrorL;
        }
        String userToken = usdkuserinfo.getUserToken();
        String strG = eVarA.g();
        if (com.haier.library.common.util.c.j(strG)) {
            uSDKError usdkerrorB = b(userToken, usdkuserinfo.getUserID());
            e3.a.e("setUserInfo: old token not exist, connect to cloud %s", usdkerrorB);
            return usdkerrorB;
        }
        if (!com.haier.library.common.util.c.c(strG, userToken)) {
            uSDKError usdkerrorL2 = l();
            if (!usdkerrorL2.a(ErrorConst.RET_USDK_OK)) {
                return usdkerrorL2;
            }
            uSDKError usdkerrorB2 = b(userToken, usdkuserinfo.getUserID());
            e3.a.e("setUserInfo: old token and new token not equals, connect to cloud with new %s", usdkerrorB2);
            return usdkerrorB2;
        }
        com.haier.uhome.control.cloud.api.d dVar = this.f30819d;
        if (dVar == null) {
            return b(userToken, usdkuserinfo.getUserID());
        }
        dVar.a();
        e3.a.e("setUserInfo: old token and new token equals, refresh device list!", new Object[0]);
        return ErrorConst.RET_USDK_OK.toError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized uSDKErrorConst p() {
        if (!uSDKManager.getSingleInstance().a()) {
            e3.a.h("sdk is not start,please start first!", new Object[0]);
            return uSDKErrorConst.ERR_USDK_UNSTARTED;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            e3.a.h("tryDisconnectToGateway error, this thread is UI Thread!", new Object[0]);
            return uSDKErrorConst.ERR_USDK_RUN_TIME_CONSUMING_OPERATION_ON_MAIN_THREAD;
        }
        final com.haier.uhome.control.cloud.api.d dVar = this.f30819d;
        if (dVar != null) {
            com.haier.uhome.usdk.b.c.a().b();
            final com.haier.library.common.thread.g gVar = new com.haier.library.common.thread.g();
            Runnable runnable = new Runnable() { // from class: com.haier.uhome.usdk.api.h5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30578a.b(dVar, gVar);
                }
            };
            uSDKErrorConst usdkerrorconst = uSDKErrorConst.ERR_USDK_TIMEOUT;
            gVar.b(runnable, usdkerrorconst, 5200L);
            return (uSDKErrorConst) gVar.b(new Runnable() { // from class: com.haier.uhome.usdk.api.i5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30586a.a(dVar, gVar);
                }
            }, usdkerrorconst, 5200L);
        }
        e3.a.o("try stop user but CloudUser is null so return", new Object[0]);
        for (uSDKDevice usdkdevice : getDeviceList()) {
            usdkdevice.updateControlDevice(null, uSDKDeviceNetTypeConst.NET_MESH);
            usdkdevice.updateControlDevice(null, uSDKDeviceNetTypeConst.NET_REMOTE);
        }
        com.haier.uhome.usdk.base.service.e.a().b((String) null);
        return uSDKErrorConst.RET_USDK_OK;
    }

    private void q() {
        com.haier.uhome.control.local.e.c.l().a(new com.haier.uhome.control.local.api.f() { // from class: com.haier.uhome.usdk.api.uSDKDeviceManager.21
            @Override // com.haier.uhome.control.local.api.f
            public void a(String str, List<Integer> list) {
                uSDKDevice device = uSDKDeviceManager.this.getDevice(str);
                if (device == null) {
                    e3.a.h("sub device add to a null main device!", new Object[0]);
                    return;
                }
                if (com.haier.library.common.util.u.h(list)) {
                    e3.a.h("onSubdeviceAdd a null subDeviceList!", new Object[0]);
                    return;
                }
                Iterator<Integer> it = list.iterator();
                while (it.hasNext()) {
                    uSDKDeviceManager.this.a(com.haier.uhome.control.base.c.a(str, it.next().intValue()), device.getUplusId(), uSDKDeviceNetTypeConst.NET_LOCAL);
                }
            }

            @Override // com.haier.uhome.control.local.api.f
            public void b(String str, List<Integer> list) {
                if (com.haier.library.common.util.u.h(list)) {
                    e3.a.h("onSubdeviceDel a null subDeviceList!", new Object[0]);
                    return;
                }
                Iterator<Integer> it = list.iterator();
                while (it.hasNext()) {
                    uSDKDevice device = uSDKDeviceManager.this.getDevice(com.haier.uhome.control.base.c.a(str, it.next().intValue()));
                    if (device != null) {
                        device.updateControlDevice(null, uSDKDeviceNetTypeConst.NET_LOCAL);
                    }
                }
            }

            @Override // com.haier.uhome.control.local.api.f
            public void a(String str, String str2, String str3) {
                uSDKDevice.a aVar = new uSDKDevice.a(str, str2, str3);
                aVar.a(uSDKDeviceManager.this.a(str));
                uSDKDeviceManager.this.a(aVar, uSDKDeviceNetTypeConst.NET_BLE);
            }
        });
    }

    private void r() {
        com.haier.uhome.search.a.n.a().a(new com.haier.uhome.search.a.g() { // from class: com.haier.uhome.usdk.api.uSDKDeviceManager.22
            @Override // com.haier.uhome.search.a.g
            public void a(com.haier.uhome.search.service.entity.d dVar) {
                e3.a.e("onDeviceBleEvent event : " + dVar.toString(), new Object[0]);
                String strC = dVar.c();
                uSDKDevice device = uSDKDeviceManager.this.getDevice(strC);
                if (device == null) {
                    e3.a.v("onDeviceBleEvent event : device not found!", new Object[0]);
                } else {
                    device.updateDeviceBleEventState(dVar);
                    com.haier.uhome.control.cloud.a.b.a().a(strC, dVar.k(), dVar.h());
                }
            }

            @Override // com.haier.uhome.search.a.g
            public void onDeviceAdd(String str, com.haier.uhome.usdk.base.api.f fVar) {
                uSDKDeviceNetTypeConst usdkdevicenettypeconst;
                e3.a.e("onDeviceAdd device : " + fVar.toString(), new Object[0]);
                if (com.haier.uhome.usdk.base.a.aq.equalsIgnoreCase(str)) {
                    usdkdevicenettypeconst = uSDKDeviceNetTypeConst.NET_BLE;
                } else {
                    if (!"local".equalsIgnoreCase(str)) {
                        return;
                    }
                    usdkdevicenettypeconst = uSDKDeviceNetTypeConst.NET_LOCAL;
                    if (fVar.b() != null && uSDKDeviceManager.this.getDevice(fVar.b()) != null) {
                        RouterSsidPasswordEvent routerSsidPasswordEvent = new RouterSsidPasswordEvent();
                        routerSsidPasswordEvent.setProgress(3);
                        routerSsidPasswordEvent.setState(1);
                        routerSsidPasswordEvent.setStateCode(1000);
                        uSDKDevice device = uSDKDeviceManager.this.getDevice(fVar.b());
                        if (device != null) {
                            device.updateRouterProgress(routerSsidPasswordEvent);
                        }
                    }
                }
                uSDKDevice usdkdeviceA = uSDKDeviceManager.this.a(fVar, usdkdevicenettypeconst);
                usdkdeviceA.setOffLineReason(usdkdeviceA.module2NetType(str), 0);
                uSDKDeviceManager.this.b(fVar.b());
            }

            @Override // com.haier.uhome.search.a.g
            public void onDeviceDel(String str, com.haier.uhome.usdk.base.api.f fVar, int i7) {
                uSDKDeviceNetTypeConst usdkdevicenettypeconst;
                uSDKDevice usdkdevice = (uSDKDevice) uSDKDeviceManager.this.f30817b.get(fVar.b());
                if (usdkdevice == null) {
                    e3.a.h("onDeviceDel device map have no this device" + fVar.toString(), new Object[0]);
                    return;
                }
                usdkdevice.setOffLineReason(usdkdevice.module2NetType(str), i7);
                if (com.haier.uhome.usdk.base.a.aq.equalsIgnoreCase(str)) {
                    usdkdevicenettypeconst = uSDKDeviceNetTypeConst.NET_BLE;
                } else {
                    if (!"local".equalsIgnoreCase(str)) {
                        return;
                    }
                    usdkdevicenettypeconst = uSDKDeviceNetTypeConst.NET_LOCAL;
                    usdkdevice.setOffLineReason(uSDKDeviceNetTypeConst.NET_REMOTE, i7);
                }
                usdkdevice.updateControlDevice(null, usdkdevicenettypeconst);
                e3.a.e("deviceId:%s offLine reason:%d", usdkdevice.getDeviceId(), Integer.valueOf(i7));
                uSDKDeviceManager.this.b(usdkdevice.getDeviceId());
            }

            @Override // com.haier.uhome.search.a.g
            public void onDeviceUpdate(String str, com.haier.uhome.usdk.base.api.f fVar) {
                uSDKDeviceNetTypeConst usdkdevicenettypeconst;
                uSDKDevice usdkdevice = (uSDKDevice) uSDKDeviceManager.this.f30817b.get(fVar.b());
                if (usdkdevice == null) {
                    e3.a.v("onDeviceUpdate device map have no this device" + fVar.toString(), new Object[0]);
                    return;
                }
                if (com.haier.uhome.usdk.base.a.aq.equalsIgnoreCase(str)) {
                    usdkdevicenettypeconst = uSDKDeviceNetTypeConst.NET_BLE;
                } else if (!"local".equalsIgnoreCase(str)) {
                    return;
                } else {
                    usdkdevicenettypeconst = uSDKDeviceNetTypeConst.NET_LOCAL;
                }
                usdkdevice.setOffLineReason(uSDKDeviceNetTypeConst.NET_BLE, 0);
                usdkdevice.setOffLineReason(uSDKDeviceNetTypeConst.NET_LOCAL, 0);
                uSDKDeviceManager.this.b(uSDKDeviceManager.this.a(fVar, usdkdevicenettypeconst).getDeviceId());
            }
        });
    }

    private void s() {
        com.haier.uhome.control.cloud.api.d dVar = this.f30819d;
        if (dVar == null) {
            return;
        }
        dVar.a(new com.haier.uhome.control.cloud.api.i() { // from class: com.haier.uhome.usdk.api.uSDKDeviceManager.26
            @Override // com.haier.uhome.control.cloud.api.i
            public void a(String str, String str2, String str3) {
                uSDKDeviceManager.this.a(str2, str3, uSDKDeviceNetTypeConst.NET_REMOTE);
                com.haier.uhome.usdk.api.c.a().a(str, str2);
                uSDKDeviceManager.this.b(str2);
            }

            @Override // com.haier.uhome.control.cloud.api.i
            public void b(String str) {
                com.haier.uhome.usdk.api.c.a().b(str);
            }

            @Override // com.haier.uhome.control.cloud.api.i
            public void a(String str, String str2) {
                uSDKDevice device = uSDKDeviceManager.this.getDevice(str2);
                if (device == null) {
                    e3.a.h("unbind can not find device<%s>", str2);
                    return;
                }
                device.updateControlDevice(null, uSDKDeviceNetTypeConst.NET_MESH);
                device.updateControlDevice(null, uSDKDeviceNetTypeConst.NET_REMOTE);
                com.haier.uhome.usdk.api.c.a().b(str, str2);
                uSDKDeviceManager.this.b(str2);
                com.haier.uhome.usdk.base.api.f fVarA = com.haier.uhome.usdk.base.api.g.a().a(str2);
                if (fVarA == null || fVarA.s() == null) {
                    return;
                }
                fVarA.s().a((String) null);
            }

            @Override // com.haier.uhome.control.cloud.api.i
            public void a(String str) {
                for (String str2 : uSDKDeviceManager.this.f30817b.keySet()) {
                    uSDKDevice device = uSDKDeviceManager.this.getDevice(str2);
                    if (device == null) {
                        e3.a.h("onInvalidToken can not find device<%s>", str2);
                        return;
                    }
                    device.invalidToken();
                }
                com.haier.uhome.usdk.api.c.a().a(str);
            }

            @Override // com.haier.uhome.control.cloud.api.i
            public void a(com.haier.uhome.control.cloud.api.b bVar, int i7) {
                com.haier.uhome.usdk.api.c.a().a(uSDKCloudConnectionState.getInstance(bVar.name()));
                uSDKDeviceManager.this.a(Trace.createDITrace(), bVar, String.valueOf(i7));
                if (bVar == com.haier.uhome.control.cloud.api.b.CONNECTED) {
                    uSDKDeviceManager.this.f30830o.a((ICallback<Void>) null);
                }
                Iterator<uSDKDevice> it = uSDKDeviceManager.this.getDeviceList().iterator();
                while (it.hasNext()) {
                    it.next().onCloudStateChange();
                }
            }

            @Override // com.haier.uhome.control.cloud.api.i
            public void a(String str, int i7, String str2, int i8) {
                uSDKDevice usdkdeviceA = uSDKDeviceManager.this.a(str, str2, uSDKDeviceNetTypeConst.NET_REMOTE);
                if (usdkdeviceA != null) {
                    com.haier.uhome.search.service.entity.d dVar2 = new com.haier.uhome.search.service.entity.d(i8, 34);
                    dVar2.b(usdkdeviceA.getDeviceId());
                    dVar2.a(1);
                    dVar2.a(System.currentTimeMillis());
                    usdkdeviceA.updateDeviceBleEventState(dVar2);
                }
            }

            @Override // com.haier.uhome.control.cloud.api.i
            public void a(String str, int i7, boolean z7, String str2) {
                uSDKDeviceManager.this.f30830o.a(new MeshDeviceNode(i7, null, 1), (ICallback<Void>) null);
                uSDKDevice.a aVar = new uSDKDevice.a(str, str2, z.a(str));
                aVar.a(i7);
                uSDKDeviceManager.this.a(aVar, uSDKDeviceNetTypeConst.NET_MESH);
                if (uSDKDeviceManager.this.e(str)) {
                    uSDKDevice.a aVar2 = new uSDKDevice.a(str, str2, z.a(str));
                    aVar2.a(i7);
                    uSDKDeviceManager.this.a(aVar2, uSDKDeviceNetTypeConst.NET_LOCAL_GATEWAY);
                }
            }

            @Override // com.haier.uhome.control.cloud.api.i
            public void a(String str, int i7, int i8) {
                uSDKDevice device = uSDKDeviceManager.this.getDevice(str);
                if (device != null) {
                    if (uSDKDeviceManager.this.e(str)) {
                        device.updateControlDevice(null, uSDKDeviceNetTypeConst.NET_LOCAL_GATEWAY);
                    }
                    device.updateControlDevice(null, uSDKDeviceNetTypeConst.NET_MESH);
                    device.updateControlDevice(null, uSDKDeviceNetTypeConst.NET_REMOTE);
                    return;
                }
                e3.a.h("notifyCloudDeviceDel can not find device<%s>", str);
            }
        });
    }

    private void t() {
        com.haier.uhome.config.a.c.a().b();
        com.haier.uhome.search.a.n.a().f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.haier.uhome.control.cloud.api.b u() {
        com.haier.uhome.control.cloud.api.b bVarC;
        com.haier.uhome.control.cloud.api.d dVar = this.f30819d;
        return (dVar == null || (bVarC = dVar.c()) == null) ? com.haier.uhome.control.cloud.api.b.UNCONNECTED : bVarC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKErrorConst v() {
        a(true);
        if (!uSDKManager.getSingleInstance().a()) {
            return uSDKErrorConst.ERR_USDK_UNSTARTED;
        }
        final com.haier.library.common.thread.g gVar = new com.haier.library.common.thread.g();
        return (uSDKErrorConst) gVar.b(new Runnable() { // from class: com.haier.uhome.usdk.api.e5
            @Override // java.lang.Runnable
            public final void run() {
                uSDKDeviceManager.a(gVar);
            }
        }, uSDKErrorConst.ERR_USDK_TIMEOUT, 5200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w() {
        uSDKError usdkerrorO = o();
        if (usdkerrorO.a(ErrorConst.RET_USDK_OK)) {
            return;
        }
        e3.a.v("cloudConnectOrDisconnect return %s so try again 5 seconds later", usdkerrorO);
        com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.usdk.api.g5
            @Override // java.lang.Runnable
            public final void run() {
                this.f30563a.n();
            }
        }, 5L, TimeUnit.SECONDS);
    }

    @Keep
    public void bindDevice(final uSDKDevice usdkdevice, final String str, final int i7, TraceNode traceNode, final IuSDKCallback iuSDKCallback) {
        final TraceNode traceNodeA = com.haier.uhome.trace.api.b.a().a(usdkdevice == null ? "" : usdkdevice.getDeviceId(), str, i7, traceNode);
        new com.haier.library.common.thread.m<Void, Void, uSDKErrorConst>() { // from class: com.haier.uhome.usdk.api.uSDKDeviceManager.15
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public uSDKErrorConst doInBackground(Void... voidArr) {
                int i8 = i7;
                if (i8 >= 20 && i8 <= 120) {
                    return uSDKDeviceManager.this.a(usdkdevice, str, i8, traceNodeA);
                }
                e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.f28377J, "timeout is invalid", new Object[0]);
                return uSDKErrorConst.ERR_USDK_INVALID_PARAM;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(uSDKErrorConst usdkerrorconst) {
                com.haier.uhome.trace.api.b bVarA = com.haier.uhome.trace.api.b.a();
                int errorId = usdkerrorconst.getErrorId();
                uSDKDevice usdkdevice2 = usdkdevice;
                bVarA.d(errorId, usdkdevice2 == null ? "" : usdkdevice2.getDeviceId(), traceNodeA);
                e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.f28377J, "bindDevice result<%s>", usdkerrorconst);
                IuSDKCallback iuSDKCallback2 = iuSDKCallback;
                if (iuSDKCallback2 != null) {
                    iuSDKCallback2.onCallback(usdkerrorconst);
                }
            }
        }.execute(new Void[0]);
    }

    @Deprecated
    public void configDeviceByNoPassword(String str, String str2, int i7, IuSDKConfigCallback iuSDKConfigCallback) {
        configDeviceByNoPassword(str, str2, i7, null, iuSDKConfigCallback);
    }

    @com.haier.uhome.usdk.base.annotation.a
    @Deprecated
    public void configDeviceBySmartLink(String str, String str2, int i7, IuSDKSmartLinkCallback iuSDKSmartLinkCallback) {
        configDeviceBySmartLink(str, str2, null, i7, iuSDKSmartLinkCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Keep
    public void configDeviceBySoftAp(uSDKSoftApConfigInfo usdksoftapconfiginfo, TraceNode traceNode, final IuSDKSoftApCallback iuSDKSoftApCallback) {
        SoftApBindInfo softApBindInfoBuild;
        final TraceNode traceNodeA;
        if (usdksoftapconfiginfo == null) {
            traceNodeA = com.haier.uhome.trace.api.b.a().a(null, false, false, null, 0, null, 0, null, traceNode);
            softApBindInfoBuild = new SoftApBindInfo.Builder().build();
        } else {
            TraceNode traceNodeA2 = com.haier.uhome.trace.api.b.a().a(usdksoftapconfiginfo.getSsid(), usdksoftapconfiginfo.isSecurity(), usdksoftapconfiginfo.isTimerValidInBackground(), usdksoftapconfiginfo.getUplusIDList(), usdksoftapconfiginfo.getTimeout(), usdksoftapconfiginfo.getMainGatewayDomain(), usdksoftapconfiginfo.getMainGatewayPort(), usdksoftapconfiginfo.getCountry(), traceNode);
            softApBindInfoBuild = ((SoftApBindInfo.Builder) ((SoftApBindInfo.Builder) new SoftApBindInfo.Builder().routerInfo(usdksoftapconfiginfo.getSsid(), null, usdksoftapconfiginfo.getPassword()).timeout(usdksoftapconfiginfo.getTimeout())).security(usdksoftapconfiginfo.isSecurity()).csNode(traceNode)).timerValidInBackground(usdksoftapconfiginfo.isTimerValidInBackground()).mainGateway(usdksoftapconfiginfo.getMainGatewayDomain(), usdksoftapconfiginfo.getMainGatewayPort()).country(usdksoftapconfiginfo.getCountry()).build();
            traceNodeA = traceNodeA2;
        }
        com.haier.uhome.usdk.bind.z zVar = new com.haier.uhome.usdk.bind.z(softApBindInfoBuild);
        zVar.c(false);
        zVar.a(traceNodeA);
        final uSDKError usdkerrorG = zVar.g();
        if (uSDKState.STATE_STARTED != uSDKManager.getSingleInstance().getSDKState()) {
            usdkerrorG = ErrorConst.ERR_USDK_UNSTARTED.toError();
        }
        if (usdkerrorG.a(ErrorConst.RET_USDK_OK)) {
            zVar.a(new com.haier.uhome.usdk.bind.a<w>() { // from class: com.haier.uhome.usdk.api.uSDKDeviceManager.2
                @Override // com.haier.uhome.usdk.base.api.ICallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(w wVar) {
                    com.haier.uhome.trace.api.b.a().c(0, wVar.a().getDeviceId(), wVar.a().getSecurityVersion(), traceNodeA);
                    IuSDKSoftApCallback iuSDKSoftApCallback2 = iuSDKSoftApCallback;
                    if (iuSDKSoftApCallback2 != null) {
                        iuSDKSoftApCallback2.onSoftApConfigCallback(wVar.a(), uSDKErrorConst.RET_USDK_OK);
                    } else {
                        e3.a.h("callback is null", new Object[0]);
                    }
                }

                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onFailure(uSDKError usdkerror) {
                    com.haier.uhome.trace.api.b.a().c(usdkerror.getCode(), (String) null, 0, traceNodeA);
                    IuSDKSoftApCallback iuSDKSoftApCallback2 = iuSDKSoftApCallback;
                    if (iuSDKSoftApCallback2 != null) {
                        iuSDKSoftApCallback2.onSoftApConfigCallback(null, uSDKErrorConst.getErrorConst(ErrorConst.getErrorConstById(usdkerror.getCode())));
                    } else {
                        e3.a.h("callback is null", new Object[0]);
                    }
                }

                @Override // com.haier.uhome.usdk.bind.a, com.haier.uhome.usdk.bind.IBindCallback, com.haier.uhome.usdk.bind.ISoftApResultCallback
                public void switchNetworkNotify() {
                    IuSDKSoftApCallback iuSDKSoftApCallback2 = iuSDKSoftApCallback;
                    if (iuSDKSoftApCallback2 != null) {
                        iuSDKSoftApCallback2.sendConfigInfoSuccess();
                    } else {
                        e3.a.h("callback is null", new Object[0]);
                    }
                }
            });
        } else {
            com.haier.uhome.trace.api.b.a().c(usdkerrorG.getCode(), (String) null, 0, traceNodeA);
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.v5
                @Override // java.lang.Runnable
                public final void run() {
                    uSDKDeviceManager.a(iuSDKSoftApCallback, usdkerrorG);
                }
            });
        }
    }

    @Deprecated
    public void getSoftApDeviceConfigInfo(TraceNode traceNode, final IuSDKSoftApDeviceConfigInfoCallback iuSDKSoftApDeviceConfigInfoCallback) {
        final TraceNode traceNodeB = com.haier.uhome.trace.api.b.a().b(traceNode);
        new com.haier.library.common.thread.m<Void, Void, c>() { // from class: com.haier.uhome.usdk.api.uSDKDeviceManager.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public c doInBackground(Void... voidArr) {
                return uSDKDeviceManager.this.a(traceNodeB);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(c cVar) {
                com.haier.uhome.trace.api.b.a().a(cVar.f30915b.getErrorId(), cVar.f30916c == null ? null : cVar.f30916c.getMac(), traceNodeB);
                IuSDKSoftApDeviceConfigInfoCallback iuSDKSoftApDeviceConfigInfoCallback2 = iuSDKSoftApDeviceConfigInfoCallback;
                if (iuSDKSoftApDeviceConfigInfoCallback2 == null) {
                    e3.a.n(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "getSoftApDeviceConfigInfo callback is null,so give up this callback.", new Object[0]);
                } else {
                    iuSDKSoftApDeviceConfigInfoCallback2.onSoftApDeviceConfigInfoCallback(cVar.f30915b, cVar.f30916c);
                }
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(String str) {
        if (str == null) {
            return;
        }
        this.f30817b.remove(str);
    }

    private void j() {
        a().a(new com.haier.uhome.control.local.d.a() { // from class: com.haier.uhome.usdk.api.uSDKDeviceManager.1
            @Override // com.haier.uhome.control.local.d.a
            public void a(com.haier.uhome.control.local.d.c cVar, com.haier.uhome.control.base.api.a aVar) {
                String strA = uSDKDeviceManager.this.a(cVar.a());
                if (TextUtils.isEmpty(strA)) {
                    e3.a.o("mesh device %d on gateway %s, but no this mesh device", Integer.valueOf(cVar.a()), aVar.X());
                    return;
                }
                uSDKDevice.a aVar2 = new uSDKDevice.a(strA, null, null);
                aVar2.a(cVar.a());
                e3.a.d("mesh gateway device<%s> onProxyOn to %s-%d", aVar.X(), strA, Integer.valueOf(cVar.a()));
                uSDKDeviceManager.this.a(aVar2, uSDKDeviceNetTypeConst.NET_LOCAL_GATEWAY).addLocalGateway((com.haier.uhome.control.local.api.h) aVar);
            }

            @Override // com.haier.uhome.control.local.d.a
            public void b(com.haier.uhome.control.local.d.c cVar, com.haier.uhome.control.base.api.a aVar) {
                uSDKDeviceManager usdkdevicemanager = uSDKDeviceManager.this;
                uSDKDevice device = usdkdevicemanager.getDevice(usdkdevicemanager.a(cVar.a()));
                if (device != null) {
                    device.rmLocalGateway((com.haier.uhome.control.local.api.h) aVar);
                    return;
                }
                e3.a.n("proxyUp gateway<%s> to <%s> but can not find device", aVar.X(), "" + cVar, new Object[0]);
            }
        });
    }

    @Deprecated
    public void configDeviceByNoPassword(String str, final String str2, final int i7, TraceNode traceNode, final IuSDKConfigCallback iuSDKConfigCallback) {
        final TraceNode traceNodeA = com.haier.uhome.trace.api.b.a().a(str, str2, i7, traceNode);
        if (!TextUtils.isEmpty(str)) {
            str = str.toUpperCase();
        }
        final String str3 = str;
        new com.haier.library.common.thread.m<Void, Void, APSmartConfigResult>() { // from class: com.haier.uhome.usdk.api.uSDKDeviceManager.11
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public APSmartConfigResult doInBackground(Void... voidArr) {
                return uSDKDeviceManager.this.b(str3, str2, i7);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(APSmartConfigResult aPSmartConfigResult) {
                uSDKDevice device = aPSmartConfigResult.getDevice();
                com.haier.uhome.trace.api.b.a().c(aPSmartConfigResult.getResultError().getErrorId(), device == null ? "" : device.getDeviceId(), device == null ? -1 : device.getSecurityVersion(), aPSmartConfigResult.getScm(), traceNodeA);
                if (iuSDKConfigCallback == null) {
                    e3.a.n(com.haier.uhome.config.a.E, com.haier.uhome.config.a.H, "configDeviceByNoPassword callback is null,so give up this callback.", new Object[0]);
                } else {
                    e3.a.n(com.haier.uhome.config.a.E, com.haier.uhome.config.a.H, "configDeviceByNoPassword return<%s>,device is <%s>", aPSmartConfigResult.getResultError(), aPSmartConfigResult.getDevice());
                    iuSDKConfigCallback.onConfigCallback(aPSmartConfigResult.getDevice(), aPSmartConfigResult.getResultError());
                }
            }
        }.execute(new Void[0]);
    }

    @com.haier.uhome.usdk.base.annotation.a
    @Deprecated
    public void configDeviceBySmartLink(String str, String str2, String str3, IuSDKSmartLinkCallback iuSDKSmartLinkCallback) {
        configDeviceBySmartLink(str, str2, str3, 60, iuSDKSmartLinkCallback);
    }

    protected boolean h() {
        return this.f30821f.get();
    }

    public com.haier.uhome.control.base.a.c i() {
        return this.f30830o.e();
    }

    /* JADX INFO: renamed from: com.haier.uhome.usdk.api.uSDKDeviceManager$4, reason: invalid class name */
    class AnonymousClass4 implements ICallback<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ APSmartConfigResult f30890a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IuSDKSoftApCallback f30891b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f30892c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.haier.library.common.thread.g f30893d;

        AnonymousClass4(APSmartConfigResult aPSmartConfigResult, IuSDKSoftApCallback iuSDKSoftApCallback, boolean z7, com.haier.library.common.thread.g gVar) {
            this.f30890a = aPSmartConfigResult;
            this.f30891b = iuSDKSoftApCallback;
            this.f30892c = z7;
            this.f30893d = gVar;
        }

        @Override // com.haier.uhome.usdk.base.api.ICallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Integer num) {
            this.f30890a.setResultError(uSDKErrorConst.RET_USDK_OK);
            this.f30890a.setDevice(null);
            com.haier.library.common.thread.a aVarB = com.haier.library.common.thread.a.b();
            final IuSDKSoftApCallback iuSDKSoftApCallback = this.f30891b;
            final boolean z7 = this.f30892c;
            aVarB.c(new Runnable() { // from class: com.haier.uhome.usdk.api.g6
                @Override // java.lang.Runnable
                public final void run() {
                    uSDKDeviceManager.AnonymousClass4.a(iuSDKSoftApCallback, z7);
                }
            });
            this.f30893d.a(this.f30890a);
        }

        @Override // com.haier.uhome.usdk.base.api.ICallback
        public void onFailure(uSDKError usdkerror) {
            this.f30890a.setResultError(uSDKErrorConst.getErrorConst(ErrorConst.getErrorConstById(usdkerror.getCode())));
            this.f30890a.setDevice(null);
            this.f30893d.a(this.f30890a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(IuSDKSoftApCallback iuSDKSoftApCallback, boolean z7) {
            if (iuSDKSoftApCallback == null || !z7) {
                return;
            }
            iuSDKSoftApCallback.sendConfigInfoSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(com.haier.uhome.control.cloud.api.d dVar, final com.haier.library.common.thread.g gVar) {
        dVar.a(new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.t4
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                this.f30739a.e(gVar, errorConst);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(com.haier.uhome.control.cloud.api.d dVar, final com.haier.library.common.thread.g gVar) {
        dVar.c(new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.b6
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                this.f30465a.f(gVar, errorConst);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(com.haier.library.common.thread.g gVar, ErrorConst errorConst) {
        if (gVar.a() == null || gVar.a() != uSDKErrorConst.ERR_USDK_TIMEOUT) {
            m();
            gVar.a(uSDKErrorConst.getErrorConst(errorConst));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(com.haier.library.common.thread.g gVar, ErrorConst errorConst) {
        if (ErrorConst.RET_USDK_OK != errorConst || this.f30819d == null) {
            e3.a.h("tryDisconnectToCloud: cloudUser stop fail!! error = " + errorConst, new Object[0]);
        }
        gVar.a(uSDKErrorConst.getErrorConst(errorConst));
    }

    @com.haier.uhome.usdk.base.annotation.a
    @Deprecated
    public void configDeviceBySmartLink(String str, String str2, String str3, int i7, IuSDKSmartLinkCallback iuSDKSmartLinkCallback) {
        configDeviceBySmartLink(str, str2, str3, i7, false, iuSDKSmartLinkCallback);
    }

    protected void g() {
        f();
        if (VersionManager.getInstance().isSmartDevice()) {
            SmartDeviceManager.getInstance().removeListener(this.f30831p);
            this.f30824i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(final com.haier.library.common.thread.g gVar) {
        gVar.getClass();
        disconnectToGateway(new com.haier.uhome.usdk.b.e(new IuSDKCallback() { // from class: com.haier.uhome.usdk.api.c6
            @Override // com.haier.uhome.usdk.api.interfaces.IuSDKCallback
            public final void onCallback(uSDKErrorConst usdkerrorconst) {
                gVar.a(usdkerrorconst);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(com.haier.library.common.thread.g gVar, ErrorConst errorConst) {
        if (ErrorConst.RET_USDK_OK != errorConst || this.f30819d == null) {
            e3.a.h("cloudUser stop fail!! error = " + errorConst, new Object[0]);
        }
        gVar.a(uSDKErrorConst.getErrorConst(errorConst));
    }

    public com.haier.uhome.usdk.api.a b() {
        return this.f30830o;
    }

    @com.haier.uhome.usdk.base.annotation.a
    @Deprecated
    public void configDeviceBySmartLink(String str, String str2, String str3, int i7, boolean z7, IuSDKSmartLinkCallback iuSDKSmartLinkCallback) {
        configDeviceBySmartLink(str, str2, str3, (String) null, z7, i7, iuSDKSmartLinkCallback);
    }

    @Deprecated
    public void connectToGateway(String str, String str2, int i7, List<uSDKDeviceInfo> list, IuSDKCallback iuSDKCallback) {
        connectToGateway(str, str2, i7, iuSDKCallback);
    }

    private synchronized uSDKError b(String str, String str2) {
        String strN = com.haier.uhome.usdk.base.service.e.a().n();
        int iO = com.haier.uhome.usdk.base.service.e.a().o();
        if (!com.haier.library.common.util.c.j(strN) && !com.haier.library.common.util.c.j(str) && iO >= 1) {
            if (this.f30827l == a.STATE_SDK) {
                e3.a.o("tryConnectToCloud: user token cover the auth token", new Object[0]);
                uSDKError usdkerrorL = l();
                if (uSDKError.RET_USDK_OK.equals(usdkerrorL)) {
                    e3.a.h("tryConnectToCloud: user token cover the auth token fail!! error code : " + usdkerrorL, new Object[0]);
                    return uSDKErrorConst.ERR_INTERNAL.toError();
                }
            }
            if (this.f30819d == null) {
                String strG = com.haier.uhome.usdk.base.service.e.a().g();
                String strE = com.haier.uhome.usdk.base.service.e.a().e();
                try {
                    com.haier.uhome.usdk.base.service.e.a().b(str);
                    com.haier.uhome.usdk.base.service.e.a().a(str2);
                    this.f30819d = com.haier.uhome.control.cloud.api.d.a(com.haier.uhome.usdk.base.service.e.a().f(), str, strN, iO);
                    s();
                } catch (Exception e8) {
                    e3.a.g("tryConnectToCloud: exception -> %s", e8);
                    com.haier.uhome.usdk.base.service.e.a().b(strG);
                    com.haier.uhome.usdk.base.service.e.a().a(strE);
                    return ErrorConst.ERR_USDK_INVALID_PARAM.toError();
                }
            }
            com.haier.uhome.usdk.b.c.a().a(strN);
            uSDKManager.getSingleInstance().a(com.haier.uhome.usdk.base.service.e.a().k(), true);
            this.f30827l = a.STATE_USER;
            return uSDKError.RET_USDK_OK;
        }
        e3.a.h("tryConnectToCloud: token, domain, port or remoteDevices is null or empty", new Object[0]);
        return uSDKErrorConst.ERR_USDK_INVALID_PARAM.toError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(com.haier.library.common.thread.g gVar, ErrorConst errorConst) {
        if (gVar.a() == null || gVar.a() != uSDKErrorConst.ERR_USDK_TIMEOUT) {
            for (uSDKDevice usdkdevice : getDeviceList()) {
                usdkdevice.updateControlDevice(null, uSDKDeviceNetTypeConst.NET_MESH);
                usdkdevice.updateControlDevice(null, uSDKDeviceNetTypeConst.NET_REMOTE);
            }
            com.haier.uhome.usdk.base.service.e.a().b((String) null);
            this.f30819d = null;
            gVar.a(uSDKErrorConst.getErrorConst(errorConst));
        }
    }

    @Keep
    @Deprecated
    public void configDeviceBySmartLink(String str, String str2, String str3, String str4, boolean z7, int i7, IuSDKSmartLinkCallback iuSDKSmartLinkCallback) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str4)) {
            arrayList.add(str4);
        }
        configDeviceBySmartLink(str, str2, str3, z7, arrayList, i7, iuSDKSmartLinkCallback);
    }

    public ArrayList<uSDKDevice> getDeviceList(uSDKDeviceTypeConst usdkdevicetypeconst) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(usdkdevicetypeconst);
        return z.a(getDeviceList(), (ArrayList<uSDKDeviceTypeConst>) arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(String str) {
        com.haier.uhome.usdk.base.api.f fVarA = com.haier.uhome.usdk.base.api.g.a().a(str);
        return (fVarA == null || fVarA.s() == null || !fVarA.s().c()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKErrorConst f(String str) {
        String str2;
        if (!uSDKManager.getSingleInstance().a()) {
            return uSDKErrorConst.ERR_USDK_UNSTARTED;
        }
        com.haier.uhome.usdk.base.utils.f.a aVarA = com.haier.uhome.usdk.base.utils.f.a(str);
        if (aVarA == null || com.haier.uhome.usdk.base.api.h.UNKNOWN == aVarA.a()) {
            str2 = "^(((U|GE)-)|(Haier-u))([0-9A-Z]+)([0-9A-Z]{4})$";
        } else {
            str2 = "^(((U|GE)-)|(Haier-u))" + aVarA.a().c() + "([0-9A-Z]{4})$";
        }
        String strH = com.haier.library.common.util.w.h(com.haier.uhome.usdk.base.service.e.a().b());
        if (!strH.matches(str2)) {
            e3.a.h("tryGetSmartLinkConfigErrorInfo error,type is %s,but ssid is %s", aVarA, strH);
            return uSDKErrorConst.ERR_USDK_SSID_NOT_MATCHING;
        }
        final com.haier.library.common.thread.g gVar = new com.haier.library.common.thread.g();
        return (uSDKErrorConst) gVar.b(new Runnable() { // from class: com.haier.uhome.usdk.api.k5
            @Override // java.lang.Runnable
            public final void run() {
                uSDKDeviceManager.b(gVar);
            }
        }, uSDKErrorConst.ERR_USDK_TIMEOUT, 5200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        SmartDevice deviceById = SmartDeviceManager.getInstance().getDeviceById(str);
        if (deviceById != null) {
            a(str, deviceById.getUplusId(), uSDKDeviceNetTypeConst.NET_NOUMENON);
        } else {
            e3.a.h("get smart device<%s> from SmartDeviceManager fail!!", str);
        }
        AbsSmartDevice onlineDeviceById = SmartDeviceManager.getInstance().getOnlineDeviceById(str);
        if (onlineDeviceById != null) {
            a(str, onlineDeviceById.getUplusId(), uSDKDeviceNetTypeConst.NET_NOUMENON);
        } else {
            e3.a.h("get online device<%s> from SmartDeviceManager fail!!", str);
        }
    }

    public com.haier.uhome.control.cloud.api.d e() {
        return this.f30819d;
    }

    @Keep
    @Deprecated
    public void configDeviceBySmartLink(String str, String str2, String str3, boolean z7, ArrayList<String> arrayList, int i7, IuSDKSmartLinkCallback iuSDKSmartLinkCallback) {
        configDeviceBySmartLink(str, str2, str3, z7, arrayList, i7, null, iuSDKSmartLinkCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Keep
    public void configDeviceBySmartLink(String str, String str2, String str3, boolean z7, ArrayList<String> arrayList, int i7, TraceNode traceNode, final IuSDKSmartLinkCallback iuSDKSmartLinkCallback) {
        final TraceNode traceNodeA = com.haier.uhome.trace.api.b.a().a(str, str3, z7, arrayList, i7, traceNode);
        final com.haier.uhome.usdk.c.d<w> dVar = new com.haier.uhome.usdk.c.d<>(new ICallback<w>() { // from class: com.haier.uhome.usdk.api.uSDKDeviceManager.5
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(w wVar) {
                uSDKDeviceManager.this.f30823h.set(false);
                uSDKDeviceManager.this.f30828m = null;
                com.haier.uhome.trace.api.b bVarA = com.haier.uhome.trace.api.b.a();
                uSDKErrorConst usdkerrorconst = uSDKErrorConst.RET_USDK_OK;
                bVarA.a(usdkerrorconst.getErrorId(), wVar.a().getDeviceId(), wVar.a().getSecurityVersion(), traceNodeA);
                IuSDKSmartLinkCallback iuSDKSmartLinkCallback2 = iuSDKSmartLinkCallback;
                if (iuSDKSmartLinkCallback2 != null) {
                    iuSDKSmartLinkCallback2.onSmartLinkCallback(wVar.a(), usdkerrorconst);
                }
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                if (!usdkerror.a(ErrorConst.ERR_USDK_DEVICE_CONFIG_IN_PROGRESS)) {
                    uSDKDeviceManager.this.f30823h.set(false);
                    uSDKDeviceManager.this.f30828m = null;
                }
                com.haier.uhome.trace.api.b.a().a(usdkerror.getCode(), (String) null, -1, traceNodeA);
                IuSDKSmartLinkCallback iuSDKSmartLinkCallback2 = iuSDKSmartLinkCallback;
                if (iuSDKSmartLinkCallback2 != null) {
                    iuSDKSmartLinkCallback2.onSmartLinkCallback(null, uSDKErrorConst.getErrorConst(ErrorConst.getErrorConstById(usdkerror.getCode())));
                }
            }
        });
        if (!this.f30823h.compareAndSet(false, true)) {
            dVar.onFailure(uSDKErrorConst.ERR_USDK_DEVICE_CONFIG_IN_PROGRESS.toError());
            return;
        }
        this.f30828m = dVar;
        if (!uSDKManager.getSingleInstance().a()) {
            dVar.onFailure(ErrorConst.ERR_USDK_UNSTARTED.toError());
            return;
        }
        if (i7 >= 30 && i7 <= 120) {
            if (!TextUtils.isEmpty(str2) && (str2.length() > 64 || str2.length() < 8)) {
                e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter password : " + str2, new Object[0]);
                dVar.onFailure(ErrorConst.ERR_USDK_PASSWORD_LENGTH_INVALID.toError());
                return;
            }
            if (!com.haier.uhome.usdk.base.utils.f.b(str)) {
                e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter ssid : " + str, new Object[0]);
                dVar.onFailure(ErrorConst.ERR_USDK_INVALID_PARAM.toError());
                return;
            }
            if (!com.haier.library.common.util.u.h(arrayList)) {
                for (String str4 : new ArrayList(arrayList)) {
                    if (!TextUtils.isEmpty(str4) && str4.length() != 32 && str4.length() != 64) {
                        dVar.onFailure(ErrorConst.ERR_USDK_INVALID_PARAM.toError());
                        return;
                    }
                }
            }
            com.haier.uhome.usdk.bind.y yVar = new com.haier.uhome.usdk.bind.y(((SmartLinkBindInfo.Builder) ((SmartLinkBindInfo.Builder) new SmartLinkBindInfo.Builder().routerInfo(str, str2).deviceId(str3).uplusIds(arrayList).timeout(i7)).csNode(traceNode)).security(z7).build());
            yVar.c(false);
            yVar.a(traceNodeA);
            yVar.b(new com.haier.uhome.usdk.bind.a<w>() { // from class: com.haier.uhome.usdk.api.uSDKDeviceManager.6
                @Override // com.haier.uhome.usdk.base.api.ICallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(w wVar) {
                    dVar.onSuccess(wVar);
                }

                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onFailure(uSDKError usdkerror) {
                    dVar.onFailure(usdkerror);
                }
            });
            return;
        }
        e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.F, "illegal parameter timeout :" + i7, new Object[0]);
        dVar.onFailure(ErrorConst.ERR_USDK_INVALID_PARAM.toError());
    }

    private x<List<uSDKDeviceInfo>> c(final String str) {
        final x<List<uSDKDeviceInfo>> xVar = new x<>();
        xVar.a(ErrorConst.ERR_USDK_DEVICE_NOT_FOUND.toError());
        final com.haier.library.common.thread.g gVar = new com.haier.library.common.thread.g();
        gVar.b(new Runnable() { // from class: com.haier.uhome.usdk.api.z5
            @Override // java.lang.Runnable
            public final void run() {
                this.f31038a.a(str, xVar, gVar);
            }
        }, xVar, 5200L);
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean d(uSDKDevice usdkdevice) {
        return !a(usdkdevice);
    }

    List<uSDKDevice> d() {
        return new ArrayList(this.f30817b.values());
    }

    private uSDKDevice d(String str, String str2) {
        String strB;
        e3.a.d(com.haier.uhome.config.a.E, str, "findMatchDeviceByDevId %s", str2);
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        Iterator<com.haier.uhome.usdk.base.api.f> it = com.haier.uhome.search.a.n.a().c().iterator();
        while (true) {
            if (!it.hasNext()) {
                strB = null;
                break;
            }
            com.haier.uhome.usdk.base.api.f next = it.next();
            if (next.b() != null && next.b().toUpperCase().endsWith(str2.toUpperCase())) {
                strB = next.b();
                break;
            }
        }
        if (strB == null) {
            e3.a.d(com.haier.uhome.config.a.E, str, "findMatchDeviceByDevId %s, not found in search list", str2);
            return null;
        }
        return getSingleInstance().getDevice(strB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z7) {
        this.f30820e.set(z7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(int i7) {
        String strA = com.haier.uhome.usdk.base.api.g.a().a(i7);
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        List<uSDKDevice> listD = d();
        if (com.haier.library.common.util.u.h(listD)) {
            return strA;
        }
        for (uSDKDevice usdkdevice : listD) {
            if (usdkdevice.getElementAddr() == i7) {
                return usdkdevice.getDeviceId();
            }
        }
        return strA;
    }

    protected void c() {
        SmartDeviceManager.getInstance().addListener(this.f30831p);
    }

    protected void f() {
        ArrayList<uSDKDevice> arrayList = new ArrayList(this.f30817b.values());
        this.f30817b.clear();
        for (final uSDKDevice usdkdevice : arrayList) {
            usdkdevice.disconnect(new com.haier.uhome.usdk.b.e(new IuSDKCallback() { // from class: com.haier.uhome.usdk.api.d5
                @Override // com.haier.uhome.usdk.api.interfaces.IuSDKCallback
                public final void onCallback(uSDKErrorConst usdkerrorconst) {
                    uSDKDeviceManager.a(usdkdevice, usdkerrorconst);
                }
            }));
        }
    }

    private uSDKDevice.a c(String str, String str2) {
        return new uSDKDevice.a(str, str2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(IuSDKResultCallback iuSDKResultCallback) {
        if (iuSDKResultCallback != null) {
            iuSDKResultCallback.onFail(uSDKErrorConst.ERR_USDK_UNSTARTED);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized uSDKErrorConst c(uSDKDevice usdkdevice) {
        try {
            if (usdkdevice == null) {
                return uSDKErrorConst.ERR_USDK_INVALID_PARAM;
            }
            if (com.haier.uhome.usdk.bind.s.a().b().get(usdkdevice.getDeviceId()) != null) {
                com.haier.uhome.usdk.bind.s.a().b().put(usdkdevice.getDeviceId(), new AtomicBoolean(true));
                return uSDKErrorConst.RET_USDK_OK;
            }
            return uSDKErrorConst.ERR_USDK_DEVICE_IS_NOT_IN_BINDING;
        } catch (Throwable th) {
            throw th;
        }
    }

    com.haier.uhome.control.local.d.d a() {
        com.haier.uhome.control.local.d.d dVar = (com.haier.uhome.control.local.d.d) this.f30829n;
        if (dVar != null) {
            return dVar;
        }
        com.haier.uhome.control.local.d.d dVarA = com.haier.uhome.control.local.d.d.a();
        this.f30829n = dVarA;
        return dVarA;
    }

    private uSDKDevice.a a(com.haier.uhome.usdk.base.api.f fVar) {
        if (fVar == null) {
            e3.a.h("parse a NULL DeviceInfo 2 uSDKDeviceBaseInfo!!", new Object[0]);
            return null;
        }
        return new uSDKDevice.a(fVar.b(), fVar.c(), fVar.r().f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(ICallback iCallback, uSDKErrorConst usdkerrorconst) {
        if (usdkerrorconst == uSDKErrorConst.RET_USDK_OK) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
        } else {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerrorconst.toError());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized uSDKErrorConst a(String str, String str2, int i7) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && i7 >= 1) {
            if (!uSDKManager.getSingleInstance().a()) {
                e3.a.h("tryConnectToGateway : sdk is not start,please start first!", new Object[0]);
                return uSDKErrorConst.ERR_USDK_UNSTARTED;
            }
            if (Looper.getMainLooper() == Looper.myLooper()) {
                e3.a.h("checkConditions error, this thread is UI Thread!", new Object[0]);
                return uSDKErrorConst.ERR_USDK_RUN_TIME_CONSUMING_OPERATION_ON_MAIN_THREAD;
            }
            if (this.f30827l == a.STATE_SDK) {
                e3.a.o("user token cover the auth token", new Object[0]);
                final com.haier.library.common.thread.g gVar = new com.haier.library.common.thread.g();
                uSDKErrorConst usdkerrorconst = (uSDKErrorConst) gVar.b(new Runnable() { // from class: com.haier.uhome.usdk.api.m5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f30647a.c(gVar);
                    }
                }, uSDKErrorConst.ERR_USDK_TIMEOUT, 5200L);
                if (uSDKErrorConst.RET_USDK_OK != usdkerrorconst) {
                    e3.a.h("user token cover the auth token fail!! error code : " + usdkerrorconst, new Object[0]);
                    return uSDKErrorConst.ERR_INTERNAL;
                }
            }
            String strG = com.haier.uhome.usdk.base.service.e.a().g();
            if (this.f30827l == a.STATE_USER && strG != null && !strG.equals(str)) {
                e3.a.f("tryConnectToGateway error,last mToken = %s & token = %s", strG, str, new Object[0]);
                return uSDKErrorConst.ERR_USDK_GATEWAY_IS_CONNECTED;
            }
            com.haier.uhome.control.cloud.api.d dVar = this.f30819d;
            if (dVar != null && strG != null && strG.equals(str)) {
                dVar.a();
            }
            if (this.f30819d == null) {
                try {
                    com.haier.uhome.usdk.base.service.e.a().b(str);
                    this.f30819d = com.haier.uhome.control.cloud.api.d.a(com.haier.uhome.usdk.base.service.e.a().f(), str, str2, i7);
                    s();
                } catch (Exception e8) {
                    e3.a.g("tryConnectGateway exception -> %s", e8);
                    return uSDKErrorConst.ERR_USDK_INVALID_PARAM;
                }
            }
            com.haier.uhome.usdk.b.c.a().a(str2);
            return uSDKErrorConst.RET_USDK_OK;
        }
        e3.a.h("token, domain, port or remoteDevices is null or empty", new Object[0]);
        return uSDKErrorConst.ERR_USDK_INVALID_PARAM;
    }

    @Deprecated
    public void configDeviceBySoftAp(uSDKDeviceConfigInfo usdkdeviceconfiginfo, boolean z7, int i7, IuSDKSoftApCallback iuSDKSoftApCallback) {
        configDeviceBySoftAp(usdkdeviceconfiginfo, z7, i7, null, iuSDKSoftApCallback);
    }

    @Deprecated
    public void configDeviceBySoftAp(uSDKDeviceConfigInfo usdkdeviceconfiginfo, boolean z7, int i7, TraceNode traceNode, IuSDKSoftApCallback iuSDKSoftApCallback) {
        configDeviceBySoftAp(usdkdeviceconfiginfo, z7, true, i7, traceNode, iuSDKSoftApCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(com.haier.uhome.control.cloud.api.d dVar, final com.haier.library.common.thread.g gVar) {
        dVar.c(new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.j5
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                this.f30599a.d(gVar, errorConst);
            }
        });
    }

    @Deprecated
    private void configDeviceBySoftAp(uSDKDeviceConfigInfo usdkdeviceconfiginfo, boolean z7, boolean z8, int i7, TraceNode traceNode, IuSDKSoftApCallback iuSDKSoftApCallback) {
        configDeviceBySoftAp(usdkdeviceconfiginfo, z7, z8, false, i7, traceNode, iuSDKSoftApCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        uSDKDevice device = getDevice(str);
        if (device == null || device.getNetType() != uSDKDeviceNetTypeConst.NET_LOCAL) {
            return;
        }
        device.checkModuleOTAStatus();
    }

    @Deprecated
    private void configDeviceBySoftAp(final uSDKDeviceConfigInfo usdkdeviceconfiginfo, final boolean z7, final boolean z8, final boolean z9, final int i7, TraceNode traceNode, final IuSDKSoftApCallback iuSDKSoftApCallback) {
        final TraceNode traceNodeA = com.haier.uhome.trace.api.b.a().a(usdkdeviceconfiginfo.getApSsid(), usdkdeviceconfiginfo.getMac(), z7, i7, usdkdeviceconfiginfo.getMainGatewayDomain(), usdkdeviceconfiginfo.getMainGatewayPort(), usdkdeviceconfiginfo.getCountry(), traceNode);
        new com.haier.library.common.thread.m<Void, Void, APSmartConfigResult>() { // from class: com.haier.uhome.usdk.api.uSDKDeviceManager.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public APSmartConfigResult doInBackground(Void... voidArr) {
                return uSDKDeviceManager.this.a(usdkdeviceconfiginfo, z7, z8, z9, i7, traceNodeA, iuSDKSoftApCallback);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(APSmartConfigResult aPSmartConfigResult) {
                uSDKDevice device = aPSmartConfigResult.getDevice();
                com.haier.uhome.trace.api.b.a().b(aPSmartConfigResult.getResultError().getErrorId(), device == null ? null : device.getDeviceId(), device == null ? -1 : device.getSecurityVersion(), traceNodeA);
                if (iuSDKSoftApCallback == null) {
                    e3.a.n(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "configDeviceBySoftap callback is null,so give up this callback.", new Object[0]);
                } else {
                    e3.a.n(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "configDeviceBySoftap return<%s>,device is <%s>", aPSmartConfigResult.getResultError(), aPSmartConfigResult.getDevice());
                    iuSDKSoftApCallback.onSoftApConfigCallback(aPSmartConfigResult.getDevice(), aPSmartConfigResult.getResultError());
                }
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(final com.haier.library.common.thread.g gVar) {
        com.haier.uhome.config.a.c.a().c(new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.x5
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                uSDKDeviceManager.b(gVar, errorConst);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(com.haier.library.common.thread.g gVar, ErrorConst errorConst) {
        gVar.a(uSDKErrorConst.getErrorConst(errorConst));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(IuSDKCallback iuSDKCallback) {
        if (iuSDKCallback != null) {
            iuSDKCallback.onCallback(uSDKErrorConst.getErrorConst(ErrorConst.RET_USDK_OK));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public APSmartConfigResult b(final String str, final String str2, final int i7) {
        final APSmartConfigResult aPSmartConfigResult = new APSmartConfigResult();
        if (!uSDKManager.getSingleInstance().a()) {
            aPSmartConfigResult.setResultError(uSDKErrorConst.ERR_USDK_UNSTARTED);
            return aPSmartConfigResult;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        final com.haier.library.common.thread.g gVar = new com.haier.library.common.thread.g();
        gVar.b(new Runnable() { // from class: com.haier.uhome.usdk.api.l5
            @Override // java.lang.Runnable
            public final void run() {
                this.f30633a.a(str, str2, i7, aPSmartConfigResult, gVar);
            }
        }, Boolean.FALSE, (((long) i7) * 1000) + 200);
        int iCurrentTimeMillis = i7 - ((int) ((System.currentTimeMillis() - jCurrentTimeMillis) / 1000));
        if (iCurrentTimeMillis <= 0) {
            aPSmartConfigResult.setResultError(uSDKErrorConst.ERR_USDK_TIMEOUT);
            return aPSmartConfigResult;
        }
        a(com.haier.uhome.config.a.H, iCurrentTimeMillis, str, aPSmartConfigResult);
        return aPSmartConfigResult;
    }

    private void b(uSDKDevice usdkdevice) {
        if (usdkdevice == null) {
            return;
        }
        usdkdevice.setDeviceDelListener(new com.haier.uhome.usdk.api.interfaces.d() { // from class: com.haier.uhome.usdk.api.a6
            @Override // com.haier.uhome.usdk.api.interfaces.d
            public final void onDeviceDel(String str) {
                this.f30440a.g(str);
            }
        });
        this.f30817b.put(usdkdevice.getDeviceId(), usdkdevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(IuSDKResultCallback iuSDKResultCallback) {
        if (iuSDKResultCallback != null) {
            iuSDKResultCallback.onFail(uSDKErrorConst.ERR_USDK_RUN_TIME_CONSUMING_OPERATION_ON_MAIN_THREAD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(ICallback iCallback, uSDKErrorConst usdkerrorconst) {
        if (usdkerrorconst == uSDKErrorConst.RET_USDK_OK) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
        } else {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerrorconst.toError());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.haier.uhome.control.cloud.api.d dVar, final com.haier.library.common.thread.g gVar) {
        dVar.a(new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.a5
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                this.f30438a.c(gVar, errorConst);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKDevice a(@c.m0 com.haier.uhome.usdk.base.api.f fVar, uSDKDeviceNetTypeConst usdkdevicenettypeconst) {
        return a(a(fVar), usdkdevicenettypeconst);
    }

    public uSDKDevice a(@c.m0 String str, String str2, uSDKDeviceNetTypeConst usdkdevicenettypeconst) {
        return a(c(str, str2), usdkdevicenettypeconst);
    }

    List<uSDKDevice> a(String str, String str2) {
        if (TextUtils.isEmpty(str) || !com.haier.uhome.control.base.c.d(str2)) {
            return null;
        }
        ArrayList<uSDKDevice> deviceList = getDeviceList();
        if (com.haier.library.common.util.u.h(deviceList)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (uSDKDevice usdkdevice : deviceList) {
            String strA = com.haier.uhome.control.base.c.a(usdkdevice.getDeviceId());
            if (!TextUtils.isEmpty(strA) && str.equals(strA)) {
                arrayList.add(usdkdevice);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public uSDKDevice a(@c.m0 uSDKDevice.a aVar, uSDKDeviceNetTypeConst usdkdevicenettypeconst) {
        boolean z7;
        List<uSDKDevice> listA;
        synchronized (this.f30817b) {
            boolean z8 = true;
            if (usdkdevicenettypeconst == null) {
                e3.a.o("try enhanceDevice<%s> but no update", aVar);
                z7 = false;
            } else {
                z7 = true;
            }
            if (aVar.a() == null || aVar.b() == null) {
                e3.a.o("try enhanceDevice<%s> with some param problem!!", aVar);
            }
            uSDKDevice device = getDevice(aVar.a());
            if (device == null) {
                device = uSDKDevice.createDevice(aVar.a(), aVar.b());
                if (device == null) {
                    e3.a.h("createDevice return null", new Object[0]);
                    return null;
                }
                if (com.haier.uhome.control.base.c.d(aVar.b()) && com.haier.uhome.control.base.c.a(aVar.a()) == null && (listA = a(device.getDeviceId(), device.getUplusId())) != null) {
                    for (uSDKDevice usdkdevice : listA) {
                        device.addSubDevice(usdkdevice.getDeviceId(), usdkdevice);
                    }
                }
                String strA = com.haier.uhome.control.base.c.a(aVar.a());
                if (!TextUtils.isEmpty(strA)) {
                    device.setMainDeviceId(strA);
                }
            } else {
                z8 = false;
            }
            if (z7) {
                device.lambda$updateControlDevice$1(aVar, usdkdevicenettypeconst);
            }
            if (z8) {
                b(device);
            }
            return device;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DeviceStatus a(String str) {
        com.haier.uhome.control.cloud.api.c cVarA;
        com.haier.uhome.control.cloud.api.d dVarE = e();
        if (dVarE == null || (cVarA = dVarE.a(str)) == null) {
            return null;
        }
        DeviceStatus deviceStatusN = cVarA.n();
        DeviceStatus deviceStatus = DeviceStatus.STATUS_CONNECTED;
        if (deviceStatus == deviceStatusN || DeviceStatus.STATUS_CONNECTING == deviceStatusN) {
            return deviceStatus;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final IuSDKCallback iuSDKCallback) {
        new com.haier.library.common.thread.m<Void, Void, uSDKErrorConst>() { // from class: com.haier.uhome.usdk.api.uSDKDeviceManager.24
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public uSDKErrorConst doInBackground(Void... voidArr) {
                uSDKDeviceManager usdkdevicemanager = uSDKDeviceManager.this;
                return usdkdevicemanager.a(str, usdkdevicemanager.f30825j, uSDKDeviceManager.this.f30826k);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(uSDKErrorConst usdkerrorconst) {
                e3.a.e("connectToGateway result<%s>", usdkerrorconst);
                if (usdkerrorconst == uSDKErrorConst.RET_USDK_OK) {
                    uSDKDeviceManager.this.f30827l = a.STATE_SDK;
                }
                IuSDKCallback iuSDKCallback2 = iuSDKCallback;
                if (iuSDKCallback2 != null) {
                    iuSDKCallback2.onCallback(usdkerrorconst);
                }
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, final x xVar, final com.haier.library.common.thread.g gVar) {
        CustomReqInfo customReqInfo = new CustomReqInfo();
        customReqInfo.setUrl("https://uhome.haier.net:6503/openapi/v2/device/queryList");
        HashMap map = new HashMap();
        map.put("mainType", "");
        map.put("typeId", "");
        customReqInfo.setBody(map);
        customReqInfo.setToken(str);
        customReqInfo.setRequestType(HttpRequestType.POST);
        customReqInfo.setHttps(true);
        customReqInfo.setNotUwsType(true);
        customReqInfo.setTimeout(15L);
        uAccount.getSingleInstance().sendCustomRequest(com.haier.uhome.usdk.base.service.e.a().b(), customReqInfo, new IAccountListener<String>() { // from class: com.haier.uhome.usdk.api.uSDKDeviceManager.25
            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponseSuccess(String str2) {
                int i7 = 0;
                e3.a.e("getAuthDeviceList sucess data<%s>", str2);
                ArrayList arrayList = new ArrayList();
                UacDevice[] devices = ((RespModel) com.haier.library.json.a.z(str2, RespModel.class)).getDevices();
                int length = devices.length;
                int i8 = 0;
                while (i8 < length) {
                    UacDevice uacDevice = devices[i8];
                    UacDeviceModulesInfo[] deviceModules = uacDevice.getDeviceModules();
                    int length2 = deviceModules.length;
                    String value = "";
                    int i9 = i7;
                    while (i9 < length2) {
                        UacModulesInfoItem[] moduleInfos = deviceModules[i9].getModuleInfos();
                        int length3 = moduleInfos.length;
                        for (int i10 = i7; i10 < length3; i10++) {
                            UacModulesInfoItem uacModulesInfoItem = moduleInfos[i10];
                            if ("softwareType".equals(uacModulesInfoItem.getKey())) {
                                value = uacModulesInfoItem.getValue();
                                break;
                            }
                        }
                        i9++;
                        i7 = 0;
                    }
                    arrayList.add(new uSDKDeviceInfo(uacDevice.getId(), uacDevice.getTypeInfo().getTypeId(), value, false));
                    i8++;
                    i7 = 0;
                }
                xVar.a(ErrorConst.RET_USDK_OK.toError());
                xVar.a(arrayList);
                gVar.a(xVar);
            }

            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            public void onHttpError(RespCommonModel respCommonModel) {
                e3.a.e("getAuthDeviceList onHttpError <%s>", respCommonModel.toString());
                xVar.a(ErrorConst.ERR_USDK_DEVICE_NOT_FOUND.toError());
                xVar.a((Object) null);
                gVar.a(xVar);
            }

            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            public void onResponseFailed(RespCommonModel respCommonModel) {
                e3.a.e("getAuthDeviceList onResponseFailed <%s>", respCommonModel.toString());
                xVar.a(ErrorConst.ERR_USDK_DEVICE_NOT_FOUND.toError());
                xVar.a((Object) null);
                gVar.a(xVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Trace trace, com.haier.uhome.control.cloud.api.b bVar, String str) {
        String str2;
        if (trace != null) {
            int i7 = AnonymousClass19.f30866a[bVar.ordinal()];
            if (i7 == 1) {
                str2 = "Connected";
            } else if (i7 != 2) {
                str2 = "Unconnect";
                if (i7 != 3 && i7 == 4) {
                    str2 = "ConnectFailed";
                }
            } else {
                str2 = "Connecting";
            }
            DITraceNode dITraceNode = new DITraceNode("common", str2, "", str, VersionManager.getInstance().getSDKVersion());
            dITraceNode.add("sys", com.haier.uhome.trace.b.e.USDK.name());
            trace.addDITraceNode(dITraceNode);
        }
    }

    private boolean a(uSDKDevice usdkdevice) {
        if (usdkdevice == null) {
            return true;
        }
        return usdkdevice.isHideDevice();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(IuSDKSoftApCallback iuSDKSoftApCallback, uSDKError usdkerror) {
        if (iuSDKSoftApCallback != null) {
            iuSDKSoftApCallback.onSoftApConfigCallback(null, uSDKErrorConst.getErrorConst(ErrorConst.getErrorConstById(usdkerror.getCode())));
        } else {
            e3.a.h("callback is null", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public APSmartConfigResult a(uSDKDeviceConfigInfo usdkdeviceconfiginfo, final boolean z7, final boolean z8, boolean z9, int i7, final TraceNode traceNode, final IuSDKSoftApCallback iuSDKSoftApCallback) {
        final APSmartConfigResult aPSmartConfigResult = new APSmartConfigResult();
        if (!uSDKManager.getSingleInstance().a()) {
            aPSmartConfigResult.setResultError(uSDKErrorConst.ERR_USDK_UNSTARTED);
            return aPSmartConfigResult;
        }
        if (i7 >= (z9 ? 5 : 30) && i7 <= 120) {
            if (!com.haier.uhome.usdk.base.utils.f.b(usdkdeviceconfiginfo.getApSsid())) {
                e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "illegal parameter ssid :" + usdkdeviceconfiginfo.getApSsid(), new Object[0]);
                aPSmartConfigResult.setResultError(uSDKErrorConst.ERR_USDK_INVALID_PARAM);
                return aPSmartConfigResult;
            }
            aPSmartConfigResult.setResultError(uSDKErrorConst.ERR_USDK_TIMEOUT);
            final com.haier.uhome.config.a.f deviceConfigInfo = usdkdeviceconfiginfo.getDeviceConfigInfo();
            long jCurrentTimeMillis = System.currentTimeMillis();
            final com.haier.library.common.thread.g gVar = new com.haier.library.common.thread.g();
            gVar.b(new Runnable() { // from class: com.haier.uhome.usdk.api.s5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30726a.a(deviceConfigInfo, z7, traceNode, aPSmartConfigResult, iuSDKSoftApCallback, z8, gVar);
                }
            }, aPSmartConfigResult, (((long) i7) * 1000) + 200);
            if (aPSmartConfigResult.getResultError() == uSDKErrorConst.RET_USDK_OK && z8) {
                a(deviceConfigInfo.j(), deviceConfigInfo.g(), i7 - ((int) ((System.currentTimeMillis() - jCurrentTimeMillis) / 1000)), aPSmartConfigResult);
            }
            return aPSmartConfigResult;
        }
        e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "illegal parameter timeout :" + i7, new Object[0]);
        aPSmartConfigResult.setResultError(uSDKErrorConst.ERR_USDK_INVALID_PARAM);
        return aPSmartConfigResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.haier.uhome.config.a.f fVar, boolean z7, TraceNode traceNode, APSmartConfigResult aPSmartConfigResult, IuSDKSoftApCallback iuSDKSoftApCallback, boolean z8, com.haier.library.common.thread.g gVar) {
        com.haier.uhome.config.a.c.a().a(fVar, z7, true, traceNode, (ICallback<ConfigResult>) new b(new AnonymousClass4(aPSmartConfigResult, iuSDKSoftApCallback, z8, gVar)));
    }

    private void a(String str, String str2, int i7, APSmartConfigResult aPSmartConfigResult) {
        e3.a.n(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "parseSoftApConfigResult deviceId<%s> ", str2);
        long jCurrentTimeMillis = System.currentTimeMillis() + (((long) i7) * 1000);
        while (true) {
            uSDKDevice usdkdeviceD = d(com.haier.uhome.config.a.G, str2);
            if (usdkdeviceD != null) {
                aPSmartConfigResult.setResultError(uSDKErrorConst.RET_USDK_OK);
                aPSmartConfigResult.setDevice(usdkdeviceD);
                e3.a.n(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "parseSoftApConfigResult RET_USDK_OK", new Object[0]);
                return;
            } else {
                if (jCurrentTimeMillis - System.currentTimeMillis() < 0) {
                    if (!str.contentEquals(com.haier.library.common.util.w.h(com.haier.uhome.usdk.base.service.e.a().b()))) {
                        aPSmartConfigResult.setDevice(null);
                        aPSmartConfigResult.setResultError(uSDKErrorConst.ERR_USDK_CONFIG_OK_BUT_NETWORK_NOT_SWITCH_TO_CONFIG_SSID);
                        e3.a.n(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "parseSoftApConfigResult ERR_USDK_CONFIG_OK_BUT_NETWORK_NOT_SWITCH_TO_CONFIG_SSID", new Object[0]);
                        return;
                    } else {
                        aPSmartConfigResult.setDevice(null);
                        aPSmartConfigResult.setResultError(uSDKErrorConst.ERR_USDK_CONFIG_OK_BUT_NOT_FIND_DEVICE);
                        e3.a.n(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "parseSoftApConfigResult ERR_USDK_CONFIG_OK_BUT_NOT_FIND_DEVICE", new Object[0]);
                        return;
                    }
                }
                SystemClock.sleep(500L);
            }
        }
    }

    private void a(String str, int i7, String str2, APSmartConfigResult aPSmartConfigResult) {
        long jCurrentTimeMillis = System.currentTimeMillis() + ((long) (i7 * 1000));
        while (true) {
            uSDKDevice usdkdeviceD = d(str, str2);
            if (this.f30820e.get()) {
                aPSmartConfigResult.setResultError(uSDKErrorConst.ERR_USDK_CONFIG_BE_CANCELED);
                return;
            }
            if (usdkdeviceD != null) {
                if (!VersionManager.getInstance().isInt()) {
                    e3.a.n(com.haier.uhome.config.a.E, str, "find config device :" + usdkdeviceD, new Object[0]);
                }
                aPSmartConfigResult.setDevice(usdkdeviceD);
                aPSmartConfigResult.setResultError(uSDKErrorConst.RET_USDK_OK);
                return;
            }
            if (jCurrentTimeMillis - System.currentTimeMillis() < 0) {
                if (!VersionManager.getInstance().isInt()) {
                    e3.a.n(com.haier.uhome.config.a.E, str, "config not find dev " + str2, new Object[0]);
                }
                aPSmartConfigResult.setResultError(uSDKErrorConst.ERR_USDK_CONFIG_OK_BUT_NOT_FIND_DEVICE);
                return;
            }
            SystemClock.sleep(500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c a(final TraceNode traceNode) {
        final c cVar = new c();
        if (!uSDKManager.getSingleInstance().a()) {
            cVar.f30915b = uSDKErrorConst.ERR_USDK_UNSTARTED;
            return cVar;
        }
        cVar.f30915b = uSDKErrorConst.ERR_USDK_TIMEOUT;
        final com.haier.library.common.thread.g gVar = new com.haier.library.common.thread.g();
        return (c) gVar.b(new Runnable() { // from class: com.haier.uhome.usdk.api.w5
            @Override // java.lang.Runnable
            public final void run() {
                this.f31005a.a(traceNode, cVar, gVar);
            }
        }, cVar, 5200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(TraceNode traceNode, final c cVar, final com.haier.library.common.thread.g gVar) {
        com.haier.uhome.config.a.c.a().a(true, traceNode, new ICallback<com.haier.uhome.usdk.base.api.c<com.haier.uhome.config.a.f>>() { // from class: com.haier.uhome.usdk.api.uSDKDeviceManager.8
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.usdk.base.api.c<com.haier.uhome.config.a.f> cVar2) {
                cVar.f30916c = new uSDKDeviceConfigInfo(cVar2.c());
                cVar.f30915b = uSDKErrorConst.RET_USDK_OK;
                gVar.a(cVar);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                cVar.f30915b = uSDKErrorConst.getErrorConst(ErrorConst.getErrorConstById(usdkerror.getCode()));
                gVar.a(cVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ConfigurableDevice a(com.haier.uhome.search.a.k kVar) {
        return new ConfigurableDevice(kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(IuSDKCallback iuSDKCallback) {
        if (iuSDKCallback != null) {
            iuSDKCallback.onCallback(uSDKErrorConst.getErrorConst(ErrorConst.RET_USDK_OK));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(final com.haier.library.common.thread.g gVar) {
        com.haier.uhome.config.a.c.a().d(new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.t5
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                uSDKDeviceManager.a(gVar, errorConst);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.haier.library.common.thread.g gVar, ErrorConst errorConst) {
        gVar.a(uSDKErrorConst.getErrorConst(errorConst));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2, int i7, final APSmartConfigResult aPSmartConfigResult, final com.haier.library.common.thread.g gVar) {
        com.haier.uhome.config.a.c.a().a(str, str2, i7, new ICallback<com.haier.uhome.usdk.base.api.c<String>>() { // from class: com.haier.uhome.usdk.api.uSDKDeviceManager.14
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.usdk.base.api.c<String> cVar) {
                uSDKDeviceManager.this.a(false);
                aPSmartConfigResult.setScm((String) cVar.a(TraceProtocolConst.PRO_CONFIG_SCM));
                gVar.a(Boolean.TRUE);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                if (!usdkerror.a(ErrorConst.ERR_USDK_DEVICE_CONFIG_IN_PROGRESS)) {
                    uSDKDeviceManager.this.a(false);
                }
                aPSmartConfigResult.setResultError(uSDKErrorConst.getErrorConst(ErrorConst.getErrorConstById(usdkerror.getCode())));
                gVar.a(Boolean.TRUE);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(uSDKDevice usdkdevice, uSDKErrorConst usdkerrorconst) {
        if (usdkerrorconst != uSDKErrorConst.RET_USDK_OK) {
            e3.a.h("clearDeviceMap: disconnect device id=%s fail err=$d", usdkdevice.getDeviceId(), Integer.valueOf(usdkerrorconst.getErrorId()));
        }
        usdkdevice.destroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(IuSDKResultCallback iuSDKResultCallback) {
        if (iuSDKResultCallback != null) {
            iuSDKResultCallback.onFail(uSDKErrorConst.ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(IuSDKResultCallback iuSDKResultCallback, ErrorConst errorConst, DeviceTokenInfo[] deviceTokenInfoArr) {
        if (errorConst.equals(ErrorConst.RET_USDK_OK)) {
            ArrayList arrayList = new ArrayList();
            for (DeviceTokenInfo deviceTokenInfo : deviceTokenInfoArr) {
                String deviceId = deviceTokenInfo.getDeviceId();
                uSDKDevice device = getDevice(deviceId);
                if (device != null) {
                    arrayList.add(device);
                } else {
                    e3.a.o("new uSDKDevice()", new Object[0]);
                    arrayList.add(new uSDKDevice(deviceId));
                }
            }
            iuSDKResultCallback.onSuccess(arrayList);
            return;
        }
        iuSDKResultCallback.onFail(uSDKErrorConst.getErrorConst(errorConst));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKErrorConst a(uSDKDevice usdkdevice, String str, int i7, TraceNode traceNode) {
        if (usdkdevice == null) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.f28377J, "device is null", new Object[0]);
            return uSDKErrorConst.ERR_USDK_INVALID_PARAM;
        }
        if (com.haier.uhome.usdk.bind.s.a().b().get(usdkdevice.getDeviceId()) != null) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.f28377J, "bind device cancelled", new Object[0]);
            return uSDKErrorConst.ERR_USDK_DEVICE_IS_IN_BINDING;
        }
        String strG = com.haier.uhome.usdk.base.service.e.a().g();
        if (TextUtils.isEmpty(strG)) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.f28377J, "bind token is null", new Object[0]);
            return uSDKErrorConst.ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST;
        }
        com.haier.uhome.usdk.bind.s.a().b().put(usdkdevice.getDeviceId(), new AtomicBoolean(false));
        long jCurrentTimeMillis = System.currentTimeMillis() + (((long) i7) * 1000);
        com.haier.uhome.usdk.base.api.c<String> cVarRetryGetDeviceBindInfo = usdkdevice.retryGetDeviceBindInfo(strG, i7, traceNode);
        if (cVarRetryGetDeviceBindInfo.b().a(ErrorConst.RET_USDK_OK)) {
            cVarRetryGetDeviceBindInfo.a(com.haier.uhome.usdk.bind.s.a().a(usdkdevice.getDeviceId(), str, cVarRetryGetDeviceBindInfo.c(), jCurrentTimeMillis, (TraceNode) cVarRetryGetDeviceBindInfo.a("node")));
        }
        com.haier.uhome.usdk.bind.s.a().b().remove(usdkdevice.getDeviceId());
        return uSDKErrorConst.getErrorConst(ErrorConst.getErrorConstById(cVarRetryGetDeviceBindInfo.b().getCode()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKErrorConst a(final uSDKDevice usdkdevice, final int i7) {
        if (usdkdevice == null) {
            return uSDKErrorConst.ERR_USDK_INVALID_PARAM;
        }
        if (i7 >= 20 && i7 <= 120) {
            uSDKErrorConst usdkerrorconst = uSDKErrorConst.ERR_USDK_TIMEOUT;
            final com.haier.library.common.thread.g gVar = new com.haier.library.common.thread.g();
            return (uSDKErrorConst) gVar.b(new Runnable() { // from class: com.haier.uhome.usdk.api.o5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30678a.a(usdkdevice, i7, gVar);
                }
            }, usdkerrorconst, (((long) i7) * 1000) + 200);
        }
        return uSDKErrorConst.ERR_USDK_INVALID_PARAM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(uSDKDevice usdkdevice, int i7, final com.haier.library.common.thread.g gVar) {
        com.haier.uhome.usdk.bind.s.a().a(usdkdevice.getDeviceId(), i7, com.haier.uhome.usdk.base.service.e.a().g(), new IuSDKResultCallback<String>() { // from class: com.haier.uhome.usdk.api.uSDKDeviceManager.18
            @Override // com.haier.uhome.usdk.api.interfaces.IuSDKResultCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(String str) {
                e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.f28377J, "tryUnbindDevice onBindCallback  ok %s", str);
                gVar.a(uSDKErrorConst.RET_USDK_OK);
                e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.f28377J, "unbindDevice receiveUnbind msg", new Object[0]);
            }

            @Override // com.haier.uhome.usdk.api.interfaces.IuSDKResultCallback
            public void onFail(uSDKErrorConst usdkerrorconst) {
                e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.f28377J, "tryUnbindDevice onBindCallback error %d", Integer.valueOf(usdkerrorconst.getErrorId()));
                gVar.a(usdkerrorconst);
            }
        });
    }

    private void a(final IuSDKCallback iuSDKCallback, final uSDKErrorConst usdkerrorconst) {
        if (iuSDKCallback == null || usdkerrorconst == null) {
            return;
        }
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.f5
            @Override // java.lang.Runnable
            public final void run() {
                iuSDKCallback.onCallback(usdkerrorconst);
            }
        });
    }

    private void a(final IuSDKResultCallback iuSDKResultCallback, final uSDKErrorConst usdkerrorconst) {
        if (iuSDKResultCallback == null || usdkerrorconst == null) {
            return;
        }
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.r5
            @Override // java.lang.Runnable
            public final void run() {
                iuSDKResultCallback.onFail(usdkerrorconst);
            }
        });
    }

    private <T> void a(final IuSDKResultCallback<T> iuSDKResultCallback, final T t7) {
        if (iuSDKResultCallback == null || t7 == null) {
            return;
        }
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.q5
            @Override // java.lang.Runnable
            public final void run() {
                iuSDKResultCallback.onSuccess(t7);
            }
        });
    }

    public void a(ICallback<Void> iCallback, int i7) {
        this.f30830o.a(iCallback, i7);
    }
}
