package com.haier.uhome.usdk.bind;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.haier.uhome.account.api.Const;
import com.haier.uhome.account.api.CustomReqInfo;
import com.haier.uhome.account.api.HttpRequestType;
import com.haier.uhome.account.api.interfaces.IAccountListener;
import com.haier.uhome.account.api.uAccount;
import com.haier.uhome.account.model.RespCommonModel;
import com.haier.uhome.trace.api.DITraceNode;
import com.haier.uhome.trace.api.Trace;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.api.uSDKDeviceManager;
import com.haier.uhome.usdk.api.uSDKDeviceNetTypeConst;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.VersionManager;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
class m extends k implements ICallback<com.haier.uhome.usdk.api.w> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f31633a = 5;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f31634b = 1000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f31635c = 5000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f31636f = 32;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f31637g = 64;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f31638h = "onSuccess";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f31639i = "onFailure";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f31640j = "onCallback";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f31641k = "1900018";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f31642l = "1900019";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f31643m = "1900020";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f31644n = "1900021";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f31645o = 100;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f31646p = 101;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f31647q = 102;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int f31648r = 103;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private CameraQRCodeBindInfo f31649s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f31650t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f31651u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private IBindCallback<com.haier.uhome.usdk.api.w> f31652v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private IBindCallback<com.haier.uhome.usdk.api.w> f31653w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Class<?> f31654x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f31655y;

    static class a implements ICallback<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WeakReference<m> f31664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f31665b;

        a(m mVar) {
            this.f31664a = new WeakReference<>(mVar);
        }

        @Override // com.haier.uhome.usdk.base.api.ICallback
        public void onFailure(uSDKError usdkerror) {
            if (this.f31665b) {
                e3.a.e("Camera bind retry open user time window fail = %s", usdkerror);
            } else {
                e3.a.e("Camera bind open user time window fail = %s", usdkerror);
            }
            final m mVar = this.f31664a.get();
            if (mVar == null) {
                e3.a.v("Camera bind origin bind object has release!", new Object[0]);
            } else if (mVar.c()) {
                e3.a.v("Camera bind open user time window failure, but already timeout!", new Object[0]);
            } else {
                this.f31665b = true;
                com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.usdk.bind.b1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f31510a.a(mVar);
                    }
                }, 500L, TimeUnit.MILLISECONDS);
            }
        }

        @Override // com.haier.uhome.usdk.base.api.ICallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r7) {
            if (this.f31665b) {
                e3.a.e("Camera bind retry open user time window success!", new Object[0]);
            } else {
                e3.a.e("Camera bind open user time window success!", new Object[0]);
            }
            m mVar = this.f31664a.get();
            if (mVar == null) {
                e3.a.v("Camera bind origin bind object has release!", new Object[0]);
            } else if (mVar.c()) {
                e3.a.v("Camera bind open user time window success, but already timeout!", new Object[0]);
            } else {
                mVar.k();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(m mVar) {
            mVar.a((ICallback<Void>) this);
        }
    }

    m(CameraQRCodeBindInfo cameraQRCodeBindInfo) {
        super(cameraQRCodeBindInfo);
        a(true);
        b(false);
        this.f31649s = cameraQRCodeBindInfo;
        this.f31654x = com.haier.uhome.a.a.a();
    }

    private String e(Object obj) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return (String) obj.getClass().getDeclaredMethod("getErrorCode", new Class[0]).invoke(obj, new Object[0]);
    }

    private String f(Object obj) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return (String) obj.getClass().getDeclaredMethod("getErrorInfo", new Class[0]).invoke(obj, new Object[0]);
    }

    private void j() {
        e3.a.e("Camera bind by https start!", new Object[0]);
        if (c()) {
            e3.a.v("Camera bind by https already total timeout!", new Object[0]);
            return;
        }
        this.f31655y = 100;
        final long jCurrentTimeMillis = System.currentTimeMillis();
        new com.haier.uhome.usdk.base.utils.e<CameraQRCodeInfo>(f31635c, 1000L) { // from class: com.haier.uhome.usdk.bind.m.1
            @Override // com.haier.uhome.usdk.base.utils.e
            public void a(long j7) {
                final com.haier.uhome.usdk.base.api.c cVar = new com.haier.uhome.usdk.base.api.c();
                cVar.a(ErrorConst.ERR_USDK_NETWORK_EXCEPTION.toError());
                m mVar = m.this;
                mVar.a(mVar.f31649s, new ICallback<CameraQRCodeInfo>() { // from class: com.haier.uhome.usdk.bind.m.1.1
                    @Override // com.haier.uhome.usdk.base.api.ICallback
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onSuccess(CameraQRCodeInfo cameraQRCodeInfo) {
                        com.haier.uhome.usdk.base.api.c cVar2 = cVar;
                        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
                        cVar2.a(errorConst.toError());
                        cVar.a(cameraQRCodeInfo);
                        cVar.a("img", m.this.a(cameraQRCodeInfo.getImg()));
                        b(cVar);
                        m.this.b(errorConst.toError());
                    }

                    @Override // com.haier.uhome.usdk.base.api.ICallback
                    public void onFailure(uSDKError usdkerror) {
                        m.this.b(usdkerror);
                        cVar.a(usdkerror);
                        String description = usdkerror.getDescription();
                        if (m.f31641k.equals(description) || m.f31642l.equals(description) || m.f31643m.equals(description)) {
                            j();
                        }
                        b(cVar);
                    }
                });
            }

            @Override // com.haier.uhome.usdk.base.utils.e
            /* JADX INFO: renamed from: a */
            public void d(com.haier.uhome.usdk.base.api.c<CameraQRCodeInfo> cVar) {
                if (!ErrorConst.RET_USDK_OK.toError().a(cVar.b()) && !ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR.toError().a(cVar.b())) {
                    com.haier.uhome.usdk.base.utils.b.a((ICallback) m.this.f31653w, cVar.b());
                    return;
                }
                if (cVar.c() != null) {
                    ((com.haier.uhome.usdk.bind.a) m.this.f31652v).a((Bitmap) cVar.a("img"));
                    m mVar = m.this;
                    mVar.a((IBindCallback<com.haier.uhome.usdk.api.w>) mVar.f31653w, cVar.c().getBindCode(), jCurrentTimeMillis);
                } else if (!m.f31641k.equals(cVar.b().getDescription())) {
                    com.haier.uhome.usdk.base.utils.b.a((ICallback) m.this.f31653w, cVar.b());
                } else {
                    m mVar2 = m.this;
                    mVar2.a((ICallback<Void>) new a(mVar2));
                }
            }
        }.a();
    }

    @Override // com.haier.uhome.usdk.bind.k
    public uSDKError g() {
        uSDKError error = ErrorConst.RET_USDK_OK.toError();
        CameraQRCodeBindInfo cameraQRCodeBindInfo = this.f31649s;
        if (cameraQRCodeBindInfo == null) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter uSDKSoftApConfigInfo is null", new Object[0]);
            uSDKError error2 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error2.a("bindInfo=null");
            return error2;
        }
        String password = cameraQRCodeBindInfo.getPassword();
        if (!TextUtils.isEmpty(password) && (password.length() > 64 || password.length() < 8)) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter password : " + password, new Object[0]);
            uSDKError error3 = ErrorConst.ERR_USDK_PASSWORD_LENGTH_INVALID.toError();
            error3.a("password=" + password);
            return error3;
        }
        if (TextUtils.isEmpty(password)) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter password is null ", new Object[0]);
            uSDKError error4 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error4.a("password不能为空");
            return error4;
        }
        String ssid = this.f31649s.getSsid();
        if (!com.haier.uhome.usdk.base.utils.f.b(ssid)) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter ssid : " + ssid, new Object[0]);
            uSDKError error5 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error5.a("ssid不能为空或者格式不正确");
            return error5;
        }
        if (TextUtils.isEmpty(this.f31649s.getProductCode())) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter productCode is null ", new Object[0]);
            uSDKError error6 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error6.a("productCode不能为空");
            return error6;
        }
        try {
            if (Integer.parseInt(this.f31649s.getQRCodeImgSize()) < 0) {
                e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter QRCodeImgSize < 0 ", new Object[0]);
                uSDKError error7 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
                error7.a("QRCodeImgSize < 0");
                return error7;
            }
            String uplusID = this.f31649s.getUplusID();
            if (TextUtils.isEmpty(uplusID) || !(uplusID.length() == 32 || uplusID.length() == 64)) {
                uSDKError error8 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
                error8.a("uplusID = " + uplusID);
                return error8;
            }
            int timeout = this.f31649s.getTimeout();
            if (timeout > 0 && timeout <= 300) {
                a(this.f31649s.getTimeout(), TimeUnit.SECONDS);
                return error;
            }
            uSDKError error9 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error9.a("timeout = " + timeout);
            return error9;
        } catch (Exception unused) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter QRCodeImgSize is not int ", new Object[0]);
            uSDKError error10 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error10.a("QRCodeImgSize非数字");
            return error10;
        }
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void h() {
        com.haier.uhome.control.cloud.api.d dVarE = uSDKDeviceManager.getSingleInstance().e();
        if (dVarE != null) {
            dVarE.a(r(), w() ? m() : 0L, 0, 5, t(), null);
        }
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void i() {
        if (this.f31649s.getAppCsNode() == null) {
            return;
        }
        a(com.haier.uhome.trace.api.b.a().a(this.f31649s.getProductCode(), this.f31649s.getBSSID(), this.f31649s.getQRCodeImgSize(), this.f31649s.getSsid(), this.f31649s.getTimeout(), this.f31649s.getUplusID(), this.f31649s.getPassword(), this.f31649s.getAppCsNode()));
    }

    @Override // com.haier.uhome.usdk.base.api.ICallback
    public void onFailure(uSDKError usdkerror) {
        e3.a.e("Camera device founded fail error = %s", usdkerror);
        if (b()) {
            this.f31653w.onFailure(usdkerror);
        }
    }

    private uSDKError d(Object obj) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        uSDKError error = ErrorConst.ERR_USDK_CAMERA_SDK_COMMON_ERROR.toError();
        String strE = e(obj);
        String strF = f(obj);
        error.a(strE);
        error.setDescription(strF);
        return error;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.f31654x == null) {
            this.f31652v.onFailure(ErrorConst.ERR_USDK_CREATE_SECURITY_SDK_BIND_CLASS_FAIL.toError());
            return;
        }
        e3.a.e("Camera bind by inner sdk start!", new Object[0]);
        if (c()) {
            e3.a.v("Camera bind by inner sdk already total timeout!", new Object[0]);
            return;
        }
        this.f31655y = 102;
        int iA = (int) a(TimeUnit.SECONDS);
        try {
            Object objInvoke = this.f31654x.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            Class<?> clsA = com.haier.uhome.a.a.a("ihcCallback");
            Class<?> clsA2 = com.haier.uhome.a.a.a("deviceCallback");
            this.f31654x.getDeclaredMethod("bindDevice", String.class, String.class, String.class, Integer.TYPE, clsA, clsA2).invoke(objInvoke, this.f31649s.getSsid(), this.f31649s.getPassword(), this.f31649s.getUplusID(), Integer.valueOf(iA), a(clsA), b(clsA2));
        } catch (Exception e8) {
            e3.a.g("Camera bind got error", e8);
        }
    }

    @Override // com.haier.uhome.usdk.bind.k
    public void c(@c.m0 IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        this.f31652v = iBindCallback;
        super.c(iBindCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object b(Object obj, Method method, Object[] objArr) throws Throwable {
        String name = method.getName();
        e3.a.e("HCCallback proxy method = %s", name);
        if (!f31640j.equals(name)) {
            return null;
        }
        a(objArr[0]);
        return null;
    }

    private void c(Object obj) {
        e3.a.e("Camera bind by inner sdk fail : %s", obj);
        if (b()) {
            try {
                this.f31653w.onFailure(d(obj));
            } catch (Exception e8) {
                e3.a.v("onCameraBindFailure excp -> %s", e8);
            }
        }
    }

    private Object b(Class<?> cls) {
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.haier.uhome.usdk.bind.z0
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                return this.f31958a.a(obj, method, objArr);
            }
        });
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        this.f31653w = iBindCallback;
        j();
    }

    private void b(Object obj) {
        e3.a.e("Camera bind by inner sdk success : %s", obj);
        if (b()) {
            try {
                String str = (String) obj.getClass().getDeclaredMethod("getDeviceId", new Class[0]).invoke(obj, new Object[0]);
                long jM = w() ? m() : 0L;
                e3.a.e("Reflect deviceId = %s", str);
                this.f31655y = 103;
                uSDKDevice device = uSDKDeviceManager.getSingleInstance().getDevice(str);
                if (device != null && device.isNetTypeContain(uSDKDeviceNetTypeConst.NET_REMOTE)) {
                    com.haier.uhome.usdk.api.w wVar = new com.haier.uhome.usdk.api.w();
                    wVar.a(device);
                    wVar.a("");
                    this.f31653w.onSuccess(wVar);
                    return;
                }
                com.haier.uhome.usdk.c.f.a().a(str, a(TimeUnit.MILLISECONDS), true, jM, 0, u(), this);
            } catch (Exception e8) {
                e3.a.g("onCameraBindSuccess excp -> %s", e8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CameraQRCodeBindInfo cameraQRCodeBindInfo, final ICallback<CameraQRCodeInfo> iCallback) {
        this.f31650t = System.currentTimeMillis();
        String str = "https://" + com.haier.uhome.usdk.base.service.e.a().d() + Const.DOC_GET_SCAN_QRCODE;
        CustomReqInfo customReqInfo = new CustomReqInfo();
        customReqInfo.setUrl(str);
        customReqInfo.setRequestType(HttpRequestType.POST);
        customReqInfo.setHttps(true);
        customReqInfo.setTimeout(5L);
        customReqInfo.setNotFixResult(false);
        String traceId = cameraQRCodeBindInfo.getAppCsNode() != null ? cameraQRCodeBindInfo.getAppCsNode().getTraceId() : "";
        HashMap map = new HashMap();
        map.put("accessToken", com.haier.uhome.usdk.base.service.e.a().g());
        map.put("apiVersion", "v1");
        map.put(TraceProtocolConst.PRO_TRACE_ID, traceId);
        customReqInfo.setHeaders(map);
        HashMap map2 = new HashMap();
        map2.put("sn", traceId);
        map2.put("pwd", cameraQRCodeBindInfo.getPassword());
        map2.put("typeId", cameraQRCodeBindInfo.getUplusID());
        map2.put("productCode", cameraQRCodeBindInfo.getProductCode());
        map2.put(y2.a.C, cameraQRCodeBindInfo.getSsid());
        map2.put("bssid", cameraQRCodeBindInfo.getBSSID());
        map2.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, cameraQRCodeBindInfo.getQRCodeImgSize());
        map2.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, cameraQRCodeBindInfo.getQRCodeImgSize());
        customReqInfo.setBody(map2);
        uAccount.getSingleInstance().sendCustomRequest(com.haier.uhome.usdk.base.service.e.a().b(), customReqInfo, new IAccountListener<String>() { // from class: com.haier.uhome.usdk.bind.m.2
            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponseSuccess(String str2) {
                e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.f28377J, "getScanQrcodeByHttp response<%s> success", str2);
                CameraQRCodeInfo cameraQRCodeInfo = new CameraQRCodeInfo();
                try {
                    com.haier.library.json.e eVarT = com.haier.library.json.a.t(str2);
                    com.haier.library.json.e eVarL0 = eVarT != null ? eVarT.L0(MessengerShareContentUtility.ATTACHMENT_PAYLOAD) : null;
                    if (eVarL0 != null) {
                        cameraQRCodeInfo = (CameraQRCodeInfo) com.haier.library.json.a.z(eVarL0.toString(), CameraQRCodeInfo.class);
                    }
                    iCallback.onSuccess(cameraQRCodeInfo);
                } catch (Exception e8) {
                    e8.printStackTrace();
                    uSDKError error = ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR.toError();
                    error.a(e8.getMessage());
                    iCallback.onFailure(error);
                }
            }

            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            public void onHttpError(RespCommonModel respCommonModel) {
                e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.f28377J, "getBindCodeOnceByHttp onHttpError <%s>", respCommonModel.toString());
                uSDKError error = ErrorConst.ERR_USDK_NETWORK_EXCEPTION.toError();
                error.setDescription(respCommonModel.getRetCode());
                error.a(respCommonModel.getRetInfo());
                iCallback.onFailure(error);
            }

            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            public void onResponseFailed(RespCommonModel respCommonModel) {
                e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.f28377J, "getBindCodeOnceByHttp  onResponseFailed<%s>", respCommonModel.toString());
                uSDKError error = ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR.toError();
                error.setDescription(respCommonModel.getRetCode());
                error.a(respCommonModel.getRetInfo());
                iCallback.onFailure(error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(uSDKError usdkerror) {
        if (this.f31649s.getAppCsNode() == null) {
            return;
        }
        Trace traceCreateDITrace = Trace.createDITrace();
        if (traceCreateDITrace == null) {
            e3.a.v("diRespCloudDeviceBindResult:diTrace is empty,so return", new Object[0]);
            return;
        }
        int code = usdkerror.getCode();
        String str = code + "";
        if (code == 0) {
            str = "00000";
        }
        DITraceNode dITraceNode = new DITraceNode(com.haier.uhome.trace.b.b.f30244a, Const.DOC_GET_SCAN_QRCODE, "", str, VersionManager.getInstance().getSDKVersion());
        HashMap map = new HashMap();
        map.put("productCode", this.f31649s.getProductCode());
        map.put("BSSID", this.f31649s.getBSSID());
        map.put(y2.a.C, this.f31649s.getSsid());
        map.put("typeID", this.f31649s.getUplusID());
        map.put("password", com.haier.library.common.util.a.i(this.f31649s.getPassword()));
        dITraceNode.add("sys", com.haier.uhome.trace.b.e.USDK.name());
        dITraceNode.add(TraceProtocolConst.PRO_PROTOCOL, com.haier.uhome.usdk.base.a.av);
        dITraceNode.add(TraceProtocolConst.PRO_IPM, com.haier.library.json.a.Z(map));
        dITraceNode.add(TraceProtocolConst.PRO_SPAN, (System.currentTimeMillis() - this.f31650t) + "");
        traceCreateDITrace.addDITraceNode(this.f31649s.getAppCsNode().getTraceId(), dITraceNode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap a(String str) {
        try {
            byte[] bArrDecode = Base64.decode(str.split(",")[1], 0);
            return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
        } catch (Exception e8) {
            e8.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback, long j7, long j8) {
        com.haier.uhome.usdk.c.f.a().a("", j7, 1, e(), u(), w(), j8, q(), new ICallback<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.m.3
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
                if (wVar != null) {
                    if (wVar.a() != null) {
                        m.this.f31651u = wVar.a().getDeviceId();
                    }
                    iBindCallback.onSuccess(wVar);
                }
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                if (usdkerror.a(ErrorConst.ERR_USDK_TIMEOUT) || usdkerror.a(ErrorConst.ERR_USDK_DEVICE_LOCAL_NOT_EXIST_AND_GET_BIND_RESULT_TIMEOUT)) {
                    ErrorConst errorConst = ErrorConst.ERR_USDK_BIND_DEVICE_TIMEOUT;
                    usdkerror.setCode(errorConst.getErrorId());
                    usdkerror.setDescription(errorConst.getErrorInfo());
                }
                iBindCallback.onFailure(usdkerror);
            }
        });
    }

    private Object a(Class<?> cls) {
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.haier.uhome.usdk.bind.a1
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                return this.f31492a.b(obj, method, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object a(Object obj, Method method, Object[] objArr) throws Throwable {
        String name = method.getName();
        e3.a.e("IHCBindDeviceCallback proxy method = %s", name);
        if (f31638h.equals(name)) {
            b(objArr[0]);
            return null;
        }
        if (!f31639i.equals(name)) {
            return null;
        }
        c(objArr[0]);
        return null;
    }

    public void a(Object obj) {
        if (c()) {
            e3.a.v("Camera bind by inner sdk qrcode return timeout in total time!", new Object[0]);
            return;
        }
        e3.a.e("Camera bind by inner sdk qrcode result = %s", obj);
        try {
            String strE = e(obj);
            Field declaredField = com.haier.uhome.a.a.a("errorResult").getDeclaredField(s0.c.f40302p);
            if (!declaredField.isAccessible()) {
                declaredField.setAccessible(true);
            }
            String strE2 = e(declaredField.get(null));
            Object objInvoke = obj.getClass().getDeclaredMethod("getResultData", new Class[0]).invoke(obj, new Object[0]);
            if (strE2.equals(strE)) {
                ((com.haier.uhome.usdk.bind.a) this.f31652v).a((Bitmap) objInvoke);
            } else {
                this.f31653w.onFailure(d(obj));
            }
        } catch (Exception e8) {
            e3.a.g("Camera bind by onCallback error", e8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ICallback<Void> iCallback) {
        this.f31655y = 101;
        com.haier.uhome.control.cloud.service.c.l().a((Trace) null, iCallback);
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(ICallback<com.haier.uhome.usdk.api.w> iCallback, uSDKError usdkerror) {
        if (iCallback == null) {
            e3.a.o(String.format("bindDevice error = %s ,but callback is null", usdkerror), new Object[0]);
        } else {
            iCallback.onFailure(usdkerror);
        }
    }

    @Override // com.haier.uhome.usdk.base.api.ICallback
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
        e3.a.e("Camera device founded! deviceID = %s", wVar.a().getDeviceId());
        if (b()) {
            this.f31653w.onSuccess(wVar);
        }
    }

    @Override // com.haier.uhome.usdk.bind.k, com.haier.library.common.util.m
    protected void a() {
        uSDKError error;
        e3.a.e("Camera bind timeout!", new Object[0]);
        int i7 = this.f31655y;
        if (i7 < 101) {
            return;
        }
        if (i7 == 101) {
            error = ErrorConst.ERR_USDK_OPENING_BINDING_TIME_WINDOW_TIMEOUT.toError();
        } else if (i7 == 102) {
            error = ErrorConst.ERR_USDK_SECURITY_SIDE_BINDING_TIMEOUT.toError();
        } else if (i7 == 103) {
            error = ErrorConst.ERR_USDK_DEVICE_VERIFY_FAILED.toError();
        } else {
            error = ErrorConst.ERR_USDK_BIND_DEVICE_TIMEOUT.toError();
        }
        this.f31652v.onFailure(error);
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(int i7) {
        d();
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(uSDKError usdkerror) {
        if (this.f31649s.getAppCsNode() == null) {
            return;
        }
        String str = usdkerror.getExtendedInfo().get(TraceProtocolConst.PRO_PROTOCOL);
        if (str == null || str.isEmpty()) {
            str = "local";
        }
        com.haier.uhome.trace.api.b.a().e(usdkerror.getCode(), this.f31651u, u(), str);
    }
}
