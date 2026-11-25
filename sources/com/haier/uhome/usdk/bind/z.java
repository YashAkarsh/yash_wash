package com.haier.uhome.usdk.bind;

import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.haier.uhome.config.entity.ConfigResult;
import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.api.uSDKDeviceManager;
import com.haier.uhome.usdk.api.uSDKErrorConst;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class z extends k implements com.haier.uhome.control.cloud.a.o, aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f31928a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SoftApBindInfo f31929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.haier.uhome.config.a.f f31930c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.haier.uhome.usdk.c.b f31931f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f31932g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TraceNode f31933h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.haier.uhome.usdk.bind.a.a f31934i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private j f31935j;

    public z(SoftApBindInfo softApBindInfo) {
        super(softApBindInfo);
        this.f31929b = softApBindInfo;
        this.f31932g = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean A() {
        return this.f31931f.c();
    }

    private com.haier.uhome.usdk.api.x<com.haier.uhome.usdk.c.b> f(final IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        com.haier.uhome.usdk.api.x<com.haier.uhome.usdk.c.b> xVar = new com.haier.uhome.usdk.api.x<>();
        if (k()) {
            xVar.a(ErrorConst.ERR_USDK_DEVICE_CONFIG_IN_PROGRESS.toError());
            return xVar;
        }
        com.haier.uhome.usdk.c.b bVar = new com.haier.uhome.usdk.c.b(new com.haier.uhome.usdk.c.b.a() { // from class: com.haier.uhome.usdk.bind.z.1
            @Override // com.haier.uhome.usdk.c.b.a
            public void a(com.haier.uhome.usdk.api.w wVar, uSDKError usdkerror) {
                if (uSDKErrorConst.RET_USDK_OK.getErrorId() == usdkerror.getCode()) {
                    iBindCallback.onSuccess(wVar);
                } else {
                    iBindCallback.onFailure(usdkerror);
                }
            }

            @Override // com.haier.uhome.usdk.c.b.a
            public com.haier.uhome.usdk.bind.a.b a() {
                if (z.this.f31930c == null) {
                    return null;
                }
                ConfigResult configResultV = z.this.f31930c.v();
                com.haier.uhome.usdk.bind.a.a aVar = z.this.f31934i;
                if (configResultV == null) {
                    configResultV = ConfigResult.createDefault();
                }
                return new com.haier.uhome.usdk.bind.a.b(aVar, configResultV);
            }
        }, this.f31929b.getSsid(), this.f31929b.getTimeout(), this.f31929b.isTimerValidInBackground());
        this.f31931f = bVar;
        xVar.a(bVar);
        xVar.a(ErrorConst.RET_USDK_OK.toError());
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z() {
        this.f31935j.onFailure(ErrorConst.ERR_INTERNAL.toError());
        this.f31935j.a();
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void e(IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        a(false, iBindCallback);
    }

    @Override // com.haier.uhome.usdk.bind.k
    public uSDKError g() {
        uSDKError error = ErrorConst.RET_USDK_OK.toError();
        if (this.f31932g && TextUtils.isEmpty(com.haier.uhome.usdk.base.service.e.a().g())) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "token is null", new Object[0]);
            return ErrorConst.ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST.toError();
        }
        SoftApBindInfo softApBindInfo = this.f31929b;
        if (softApBindInfo == null) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter uSDKSoftApConfigInfo is null", new Object[0]);
            uSDKError error2 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error2.a("bindInfo=null");
            return error2;
        }
        String password = softApBindInfo.getPassword();
        if (k.d(password)) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter password : " + password, new Object[0]);
            uSDKError error3 = ErrorConst.ERR_USDK_PASSWORD_LENGTH_INVALID.toError();
            error3.a("password=" + password);
            return error3;
        }
        StringBuilder sb = new StringBuilder();
        if (this.f31929b.getMainGatewayPort() < 0) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter port : " + this.f31929b.getMainGatewayPort(), new Object[0]);
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append(",port=");
            sb.append(this.f31929b.getMainGatewayPort());
        }
        String ssid = this.f31929b.getSsid();
        if (!com.haier.uhome.usdk.base.utils.f.b(ssid)) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter ssid : " + ssid, new Object[0]);
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append(",ssid=");
            sb.append(ssid);
        }
        int i7 = this.f31932g ? 180 : 120;
        if (this.f31929b.getTimeout() < 30 || this.f31929b.getTimeout() > i7) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter timeout :" + this.f31929b.getTimeout(), new Object[0]);
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append(",timeout=");
            sb.append(this.f31929b.getTimeout());
        }
        String bssid = this.f31929b.getBssid();
        if (!TextUtils.isEmpty(bssid) && bssid.length() != 12) {
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append(", bssid=");
            sb.append(bssid);
        }
        if (this.f31932g) {
            String iotDeviceSSID = this.f31929b.getIotDeviceSSID();
            if (TextUtils.isEmpty(iotDeviceSSID)) {
                error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
                sb.append(", iotDevSsid=");
                sb.append(iotDeviceSSID);
            }
        }
        if (!error.a(ErrorConst.ERR_USDK_INVALID_PARAM)) {
            return super.g();
        }
        error.a(sb.toString().replaceFirst(",", ""));
        return error;
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void h() {
        com.haier.uhome.control.cloud.api.d dVarE = uSDKDeviceManager.getSingleInstance().e();
        if (dVarE != null) {
            dVarE.a(r(), w() ? m() : 0L, 0, 5, t(), 0L, System.currentTimeMillis() - this.f31930c.u(), (ICallback<com.haier.uhome.control.base.a>) null);
        }
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void i() {
        a(this.f31929b == null ? com.haier.uhome.trace.api.b.a().f(null) : com.haier.uhome.trace.api.b.a().a(this.f31929b.getSsid(), this.f31929b.getPassword(), this.f31929b.getBssid(), this.f31929b.isSecurity(), this.f31929b.isTimerValidInBackground(), this.f31929b.getUplusIds(), this.f31929b.getTimeout(), this.f31929b.getMainGatewayDomain(), this.f31929b.getMainGatewayPort(), this.f31929b.getCountry(), this.f31929b.getIotDevBssid(), this.f31929b.getAppCsNode()));
    }

    @Override // com.haier.uhome.usdk.bind.aa
    public void j() {
        com.haier.uhome.control.cloud.a.b.a().b(this);
    }

    private void a(final com.haier.uhome.usdk.c.b bVar, final IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        if (this.f31932g) {
            a(iBindCallback, BindProgress.CONNECT_DEVICE);
        }
        bVar.a(uSDKErrorConst.ERR_USDK_TIMEOUT_WITHOUT_GETCONFIGINFO_ACK.toError());
        this.f31933h = com.haier.uhome.trace.api.b.a().c(u());
        com.haier.uhome.usdk.base.api.c<com.haier.uhome.config.a.f> cVarA = a(bVar);
        if (!cVarA.b().a(ErrorConst.RET_USDK_OK)) {
            bVar.onFailure(cVarA.b());
            com.haier.uhome.trace.api.b.a().a(cVarA.b().getCode(), r(), (String) null, (Integer) null, this.f31933h);
            return;
        }
        com.haier.uhome.config.a.f fVarC = cVarA.c();
        this.f31930c = fVarC;
        b(fVarC.r());
        com.haier.uhome.trace.api.b.a().a(0, this.f31930c.g(), this.f31932g ? String.valueOf(this.f31930c.p()) : null, (Integer) cVarA.a(TraceProtocolConst.PRO_CONFIG_SCM), this.f31933h);
        if (!com.haier.library.common.util.u.h(this.f31929b.getUplusIds()) && !a(this.f31929b.getUplusIds(), this.f31930c.e())) {
            bVar.onFailure(uSDKErrorConst.ERR_USDK_DEVICE_UPLUSID_NOT_MATCH.toError());
            return;
        }
        a(this.f31930c.g(), this.f31930c.e());
        b(this.f31930c.g());
        IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback2 = new IBindCallback<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.z.2
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
                bVar.onSuccess(wVar);
            }

            @Override // com.haier.uhome.usdk.bind.IBindResultCallback
            public void notifyProgress(BindProgress bindProgress, String str, String str2) {
                iBindCallback.notifyProgress(bindProgress, str, str2);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                bVar.onFailure(usdkerror);
            }

            @Override // com.haier.uhome.usdk.bind.IBindCallback, com.haier.uhome.usdk.bind.ISoftApResultCallback
            public void switchNetworkNotify() {
                iBindCallback.switchNetworkNotify();
            }
        };
        if (!this.f31932g) {
            e(iBindCallback2);
        } else if (this.f31930c.p() != 2) {
            e(iBindCallback2);
        } else {
            bVar.a(true);
            d(iBindCallback2);
        }
    }

    private boolean k() {
        com.haier.uhome.usdk.c.b bVar = this.f31931f;
        return bVar != null && bVar.d();
    }

    private boolean l() {
        String strH = com.haier.library.common.util.w.h(com.haier.uhome.usdk.base.service.e.a().b());
        String iotDeviceSSID = this.f31929b.getIotDeviceSSID();
        if (com.haier.library.common.util.w.f26618d.equals(strH)) {
            e3.a.o("get ssid return %s,so return true in iot ssid check", strH);
            return true;
        }
        if (this.f31932g) {
            if (strH == null) {
                return false;
            }
            return com.haier.library.common.util.c.q(strH, "\"").equals(com.haier.library.common.util.c.q(iotDeviceSSID, "\""));
        }
        e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "currentSSID<%s>, iotDevSsid<%s>", strH, this.f31929b.getSsid());
        if (strH == null) {
            return false;
        }
        return strH.startsWith(com.haier.uhome.usdk.base.a.T) || strH.startsWith("\"U-");
    }

    private com.haier.uhome.usdk.base.api.c<com.haier.uhome.config.a.f> n() {
        final com.haier.library.common.thread.g gVar = new com.haier.library.common.thread.g();
        final com.haier.uhome.usdk.base.api.c cVar = new com.haier.uhome.usdk.base.api.c();
        cVar.a(ErrorConst.ERR_USDK_TIMEOUT.toError());
        return (com.haier.uhome.usdk.base.api.c) gVar.b(new Runnable() { // from class: com.haier.uhome.usdk.bind.v1
            @Override // java.lang.Runnable
            public final void run() {
                this.f31848a.a(gVar, cVar);
            }
        }, cVar, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        e3.a.e("SoftAp bind: open wifi state notify ret = %d", Integer.valueOf(com.haier.uhome.search.service.f.c().c(r())));
    }

    private void y() {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.bind.w1
            @Override // java.lang.Runnable
            public final void run() {
                this.f31869a.z();
            }
        });
    }

    @Override // com.haier.uhome.usdk.bind.aa
    public uSDKError b(uSDKError usdkerror) {
        uSDKError usdkerrorA = com.haier.uhome.usdk.c.c.a(this.f31934i);
        return usdkerrorA != null ? usdkerrorA : usdkerror;
    }

    public void c(boolean z7) {
        this.f31932g = z7;
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void d(IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        a(true, iBindCallback);
    }

    @Override // com.haier.uhome.usdk.bind.k
    public void a(IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        final j jVar = new j(this, iBindCallback);
        com.haier.uhome.control.cloud.a.b.a().a(this);
        com.haier.uhome.usdk.api.x<com.haier.uhome.usdk.c.b> xVarF = f(jVar);
        if (!xVarF.a().a(ErrorConst.RET_USDK_OK)) {
            a(jVar, xVarF.a());
            return;
        }
        this.f31935j = jVar;
        final com.haier.uhome.usdk.c.b bVarB = xVarF.b();
        com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.usdk.bind.z1
            @Override // java.lang.Runnable
            public final void run() {
                this.f31959a.a(bVarB, jVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.haier.uhome.usdk.c.b bVar, j jVar) {
        a(bVar, (IBindCallback<com.haier.uhome.usdk.api.w>) jVar);
    }

    private boolean a(List<String> list, String str) {
        boolean z7 = false;
        if (!com.haier.library.common.util.u.h(list)) {
            for (String str2 : list) {
                if (str2 != null && str2.equalsIgnoreCase(str)) {
                    z7 = true;
                    break;
                }
            }
            return z7;
        }
        e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "uplusID not set to config", new Object[0]);
        return true;
    }

    private com.haier.uhome.usdk.base.api.c<ConfigResult> a(final com.haier.uhome.config.a.f fVar, final boolean z7, com.haier.uhome.usdk.c.b bVar) {
        ErrorConst errorConst;
        final com.haier.uhome.usdk.base.api.c<ConfigResult> cVar = new com.haier.uhome.usdk.base.api.c<>();
        while (!bVar.c()) {
            final com.haier.library.common.thread.g gVar = new com.haier.library.common.thread.g();
            ErrorConst errorConst2 = (ErrorConst) gVar.b(new Runnable() { // from class: com.haier.uhome.usdk.bind.y1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f31923a.a(fVar, z7, cVar, gVar);
                }
            }, ErrorConst.ERR_USDK_TIMEOUT, 15000L);
            e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "sync configDeviceBySoftAp result= %s", errorConst2);
            if (errorConst2 == ErrorConst.RET_USDK_OK) {
                errorConst = errorConst2;
            } else {
                bVar.a(errorConst2.toError());
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException unused) {
                    e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "retrySoftApConfig sleep Interrupted", new Object[0]);
                    Thread.currentThread().interrupt();
                }
                if (!l()) {
                    if (errorConst2.getErrorId() == -954) {
                        bVar.b();
                        errorConst = ErrorConst.RET_USDK_OK;
                    } else {
                        errorConst = ErrorConst.ERR_USDK_CURRENT_SSID_IS_NOT_IOT;
                    }
                }
            }
            cVar.a(errorConst.toError());
            return cVar;
        }
        errorConst = ErrorConst.ERR_USDK_TIMEOUT;
        cVar.a(errorConst.toError());
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.haier.uhome.config.a.f fVar, boolean z7, final com.haier.uhome.usdk.base.api.c cVar, final com.haier.library.common.thread.g gVar) {
        com.haier.uhome.config.a.c.a().a(fVar, z7, false, this.f31933h, new ICallback<ConfigResult>() { // from class: com.haier.uhome.usdk.bind.z.3
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(ConfigResult configResult) {
                cVar.a(configResult);
                gVar.a(ErrorConst.RET_USDK_OK);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                String strB = usdkerror.b(com.haier.uhome.usdk.base.a.bb);
                if (com.haier.library.common.util.c.m(strB)) {
                    cVar.a(ConfigResult.createDefault());
                } else {
                    cVar.a((ConfigResult) com.haier.library.json.a.z(strB, ConfigResult.class));
                }
                gVar.a(ErrorConst.getErrorConstById(usdkerror.getCode()));
            }
        });
    }

    private com.haier.uhome.usdk.base.api.c<com.haier.uhome.config.a.f> a(com.haier.uhome.usdk.c.b bVar) {
        com.haier.uhome.usdk.base.api.c<com.haier.uhome.config.a.f> cVar = new com.haier.uhome.usdk.base.api.c<>();
        cVar.a(ErrorConst.ERR_USDK_TIMEOUT.toError());
        while (!bVar.c()) {
            cVar = n();
            if (cVar.b().a(ErrorConst.RET_USDK_OK)) {
                break;
            }
            bVar.a(cVar.b());
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException unused) {
                e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "retryGetConfigInfo sleep Interrupted", new Object[0]);
                Thread.currentThread().interrupt();
            }
            if (!l()) {
                cVar.a(ErrorConst.ERR_USDK_CURRENT_SSID_IS_NOT_IOT.toError());
                break;
            }
        }
        if (cVar.b().a(ErrorConst.RET_USDK_OK) && bVar.c()) {
            cVar.a(ErrorConst.ERR_USDK_TIMEOUT.toError());
        }
        e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "retry get config info end result=" + cVar.b(), new Object[0]);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final com.haier.library.common.thread.g gVar, final com.haier.uhome.usdk.base.api.c cVar) {
        com.haier.uhome.config.a.c.a().a(false, this.f31933h, new ICallback<com.haier.uhome.usdk.base.api.c<com.haier.uhome.config.a.f>>() { // from class: com.haier.uhome.usdk.bind.z.4
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.usdk.base.api.c<com.haier.uhome.config.a.f> cVar2) {
                gVar.a(cVar2);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                cVar.a(usdkerror);
                gVar.a(cVar);
            }
        });
    }

    private void a(final boolean z7, final IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        a(z7);
        this.f31930c.e(this.f31929b.getSsid());
        this.f31930c.f(this.f31929b.getBssid());
        this.f31930c.g(this.f31929b.getPassword());
        this.f31930c.a(this.f31929b.getMainGatewayDomain());
        this.f31930c.a(this.f31929b.getMainGatewayPort());
        this.f31930c.h(this.f31929b.getCountry());
        this.f31931f.a(r());
        this.f31931f.a(uSDKErrorConst.ERR_USDK_TIMEOUT_WITHOUT_SOFTAPCONFIG_ACK.toError());
        boolean zIsSecurity = this.f31929b.isSecurity();
        if (z7) {
            this.f31930c.i(com.haier.uhome.usdk.base.service.e.a().g());
            zIsSecurity = true;
        }
        if (this.f31932g) {
            a(iBindCallback, BindProgress.SEND_CONFIG_INFO);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f31930c.b(jCurrentTimeMillis / 1000);
        this.f31930c.c(jCurrentTimeMillis);
        if (this.f31932g) {
            this.f31930c.a(m());
        } else {
            this.f31930c.a(0L);
        }
        this.f31933h = com.haier.uhome.trace.api.b.a().a(r(), zIsSecurity, this.f31933h);
        com.haier.uhome.usdk.base.api.c<ConfigResult> cVarA = a(this.f31930c, zIsSecurity, this.f31931f);
        if (cVarA.a() != ErrorConst.RET_USDK_OK) {
            com.haier.uhome.trace.api.b.a().a(cVarA.b().getCode(), r(), (Integer) null, this.f31933h);
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iBindCallback, cVarA.b());
            return;
        }
        this.f31930c.a(cVarA.c());
        com.haier.uhome.trace.api.b.a().a(0, r(), Integer.valueOf(cVarA.c().getConfigMode()), this.f31933h);
        this.f31931f.a();
        if (l()) {
            e3.a.e("send soft ap config info success, so disconnect with iot ssid", new Object[0]);
            WifiManager wifiManager = (WifiManager) com.haier.uhome.usdk.base.service.e.a().b().getApplicationContext().getSystemService("wifi");
            if (wifiManager != null) {
                wifiManager.disconnect();
                wifiManager.reconnect();
            }
        }
        com.haier.library.common.thread.a aVarB = com.haier.library.common.thread.a.b();
        iBindCallback.getClass();
        aVarB.c(new m0(iBindCallback));
        final com.haier.uhome.usdk.api.x xVar = new com.haier.uhome.usdk.api.x();
        xVar.a(iBindCallback);
        com.haier.uhome.usdk.c.f.a().b(r(), new com.haier.uhome.usdk.a.b() { // from class: com.haier.uhome.usdk.bind.x1
            @Override // com.haier.uhome.usdk.a.b
            public final boolean isTimeout() {
                return this.f31894a.A();
            }
        }, new ICallback<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.z.5
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
                e3.a.e("SoftAp config local find %s", wVar.a().getDeviceId());
                if (!z.this.f31932g) {
                    com.haier.uhome.usdk.base.utils.b.a(iBindCallback, wVar);
                    return;
                }
                z.this.o();
                if (z7) {
                    return;
                }
                s.a().c();
                z.this.a((IBindResultCallback<com.haier.uhome.usdk.api.w>) xVar.b(), BindProgress.BIND_DEVICE);
                z.this.a(wVar, new ICallback<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.z.5.1
                    @Override // com.haier.uhome.usdk.base.api.ICallback
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onSuccess(com.haier.uhome.usdk.api.w wVar2) {
                        com.haier.uhome.usdk.base.utils.b.a((ICallback<com.haier.uhome.usdk.api.w>) xVar.b(), wVar2);
                        xVar.a((Object) null);
                    }

                    @Override // com.haier.uhome.usdk.base.api.ICallback
                    public void onFailure(uSDKError usdkerror) {
                        com.haier.uhome.usdk.base.utils.b.b((ICallback) xVar.b(), usdkerror);
                        xVar.a((Object) null);
                    }
                });
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                e3.a.e("SoftAp config local find error<%s>", usdkerror.toString());
                if (z.this.f31932g) {
                    return;
                }
                com.haier.uhome.usdk.base.utils.b.a((ICallback) iBindCallback, usdkerror);
            }
        });
        if (!this.f31932g) {
            e3.a.e("SoftAp config not needed binding,waiting local find ~", new Object[0]);
            return;
        }
        if (z7) {
            a(iBindCallback, BindProgress.BIND_DEVICE);
            String strR = r();
            long jE = this.f31931f.e();
            com.haier.uhome.usdk.c.f.a().a(strR, w() ? m() : 0L, 0, jE - com.haier.uhome.ble.hal.a.b.a.f28246a, u(), w(), this.f31930c.u(), q(), new ICallback<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.z.6
                @Override // com.haier.uhome.usdk.base.api.ICallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
                    iBindCallback.onSuccess(wVar);
                }

                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onFailure(uSDKError usdkerror) {
                    iBindCallback.onFailure(usdkerror);
                }
            });
            return;
        }
        s.a().a(r(), s(), "dName", m(), 0, true, this.f31931f.e() - 6000, this.f31933h, new IBindCallback<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.z.7
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
                com.haier.uhome.usdk.base.utils.b.a((ICallback<com.haier.uhome.usdk.api.w>) xVar.b(), wVar);
                xVar.a((Object) null);
                com.haier.uhome.usdk.c.f.a().b(z.this.r());
            }

            @Override // com.haier.uhome.usdk.bind.IBindResultCallback
            public void notifyProgress(BindProgress bindProgress, String str, String str2) {
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                com.haier.uhome.usdk.base.utils.b.b((ICallback) xVar.b(), usdkerror);
                xVar.a((Object) null);
                com.haier.uhome.usdk.c.f.a().b(z.this.r());
            }

            @Override // com.haier.uhome.usdk.bind.IBindCallback, com.haier.uhome.usdk.bind.ISoftApResultCallback
            public void switchNetworkNotify() {
            }
        });
    }

    @Override // com.haier.uhome.control.cloud.a.o
    public void a(int i7, int i8) {
        this.f31934i = com.haier.uhome.usdk.c.c.a(i8);
        e3.a.e("SoftAp bind: notify bind state: %d, stateCode: %d", Integer.valueOf(i7), Integer.valueOf(i8));
        if (com.haier.uhome.usdk.c.c.a(i7, i8)) {
            if (this.f31935j != null) {
                y();
            }
            com.haier.uhome.usdk.c.b bVar = this.f31931f;
            if (bVar != null) {
                bVar.onFailure(ErrorConst.ERR_INTERNAL.toError());
            }
        }
    }

    @Override // com.haier.uhome.control.cloud.a.o
    public boolean a(String str) {
        com.haier.uhome.config.a.f fVar;
        return (com.haier.library.common.util.c.m(str) || (fVar = this.f31930c) == null || !com.haier.library.common.util.c.c(str, fVar.g())) ? false : true;
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(com.haier.uhome.usdk.api.w wVar, final ICallback<com.haier.uhome.usdk.api.w> iCallback) {
        s.a().a(wVar.a().getDeviceId(), wVar.a().getUplusId(), m(), 0, this.f31931f.e(), this.f31933h, new ICallback<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.z.8
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.usdk.api.w wVar2) {
                com.haier.uhome.usdk.base.utils.b.a((ICallback<com.haier.uhome.usdk.api.w>) iCallback, wVar2);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
            }
        });
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(uSDKError usdkerror) {
        uSDKDevice device = uSDKDeviceManager.getSingleInstance().getDevice(r());
        int securityVersion = device != null ? device.getSecurityVersion() : -1;
        String str = usdkerror.getExtendedInfo().get(TraceProtocolConst.PRO_PROTOCOL);
        if (str == null || str.isEmpty()) {
            str = "local";
        }
        com.haier.uhome.trace.api.b.a().a(usdkerror.getCode(), r(), securityVersion, u(), str);
    }
}
