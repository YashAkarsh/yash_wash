package com.haier.uhome.config.service;

import android.text.TextUtils;
import com.haier.uhome.config.json.ConfigProtocol;
import com.haier.uhome.config.json.req.BleCfgSetSimpleParamReq;
import com.haier.uhome.config.json.req.BleConfigReq;
import com.haier.uhome.config.json.resp.BleConfigResp;
import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.base.json.BasicReq;
import com.haier.uhome.usdk.base.json.BasicResp;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f28554a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f28555b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f28556c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f28557d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f28558e = 5;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f28559f = -932;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f28560g = -933;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f28561h = -934;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f28562i = -935;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f28563j = -937;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f28564k = -940;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private g f28565l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private com.haier.uhome.usdk.base.api.k<com.haier.uhome.search.service.entity.d, d> f28566m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private AtomicInteger f28567n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private AtomicInteger f28568o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private AtomicBoolean f28569p;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static e f28574a = new e();

        private a() {
        }
    }

    private e() {
        this.f28567n = new AtomicInteger(0);
        this.f28568o = new AtomicInteger(0);
        this.f28569p = new AtomicBoolean(false);
        this.f28565l = g.a();
        ConfigProtocol.registerBle();
        com.haier.uhome.config.c.c.a().a(new com.haier.uhome.config.c.a() { // from class: com.haier.uhome.config.service.e.1
            @Override // com.haier.uhome.config.c.a, com.haier.uhome.config.c.f
            public void a(int i7, int i8, int i9) {
                if (e.this.f28567n.get() != i8 && e.this.f28566m != null) {
                    e.this.f28566m.a(new com.haier.uhome.search.service.entity.d(i8));
                }
                if (i8 == 3) {
                    e.this.f28568o.set(ErrorConst.ERR_USDK_BIND_DEVICE_TIMEOUT.getErrorId());
                } else if (i8 != 0 || i9 != 0) {
                    e.this.f28568o.set(i9);
                }
                e.this.f28567n.set(i8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        if (this.f28569p.compareAndSet(true, false)) {
            this.f28565l.b();
        }
    }

    public void b() {
        com.haier.uhome.usdk.base.d.f.a().b().post(new Runnable() { // from class: com.haier.uhome.config.service.y
            @Override // java.lang.Runnable
            public final void run() {
                this.f28707a.c();
            }
        });
    }

    public static e a() {
        return a.f28574a;
    }

    public void a(com.haier.uhome.config.a.b bVar, int i7, TraceNode traceNode, com.haier.uhome.usdk.base.api.k<com.haier.uhome.search.service.entity.d, d> kVar) {
        if (bVar == null) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) kVar, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        this.f28566m = kVar;
        BleCfgSetSimpleParamReq bleCfgSetSimpleParamReq = new BleCfgSetSimpleParamReq();
        bleCfgSetSimpleParamReq.setNativeSender(this.f28565l);
        bleCfgSetSimpleParamReq.setModule(com.haier.uhome.usdk.base.a.aq);
        bleCfgSetSimpleParamReq.setTraceId(traceNode.getTraceId());
        bleCfgSetSimpleParamReq.setBleDevId(bVar.a());
        bleCfgSetSimpleParamReq.setDevId(bVar.b());
        bleCfgSetSimpleParamReq.setTimeout(i7);
        a(bleCfgSetSimpleParamReq, bVar.b(), i7);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, int i7, TraceNode traceNode, long j7, long j8, int i8, com.haier.uhome.usdk.base.api.k<com.haier.uhome.search.service.entity.d, d> kVar) {
        this.f28566m = kVar;
        BleConfigReq bleConfigReq = new BleConfigReq();
        try {
            bleConfigReq.setBleDevId(str);
            bleConfigReq.setSsid(str3);
            bleConfigReq.setBssid(str4);
            bleConfigReq.setPassword(str5);
            bleConfigReq.setToken(str6);
            bleConfigReq.setTraceId(traceNode.getTraceId());
            bleConfigReq.setNativeSender(this.f28565l);
            bleConfigReq.setTimestamp(j7);
            bleConfigReq.setBindCode(j8);
            bleConfigReq.setBleType(i8);
            a(bleConfigReq, str2, i7);
        } catch (Exception e8) {
            e8.printStackTrace();
            a(ErrorConst.ERR_USDK_INVALID_PARAM.toError(), null);
        }
    }

    public void a(BasicReq basicReq, final String str, int i7) {
        this.f28567n.set(0);
        this.f28568o.set(ErrorConst.ERR_USDK_TIMEOUT.getErrorId());
        this.f28569p.set(true);
        com.haier.uhome.usdk.base.d.a.a().a(basicReq, i7, new com.haier.uhome.usdk.base.api.m() { // from class: com.haier.uhome.config.service.e.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            AtomicBoolean f28571a = new AtomicBoolean(false);

            private ErrorConst b(BleConfigResp bleConfigResp, boolean z7) {
                int errNo = bleConfigResp.getErrNo();
                if (errNo == e.f28564k) {
                    return ErrorConst.getErrorConstById(errNo);
                }
                if (errNo == e.f28563j) {
                    return z7 ? ErrorConst.RET_USDK_OK : ErrorConst.getErrorConstById(errNo);
                }
                switch (errNo) {
                    case e.f28562i /* -935 */:
                        return ErrorConst.getErrorConstById(bleConfigResp.getError());
                    case e.f28561h /* -934 */:
                    case e.f28560g /* -933 */:
                    case e.f28559f /* -932 */:
                        return ErrorConst.getErrorConstById(errNo);
                    default:
                        return ErrorConst.RET_USDK_OK;
                }
            }

            @Override // com.haier.uhome.usdk.base.api.m
            public void a(BasicResp basicResp) {
                e.this.f28569p.set(false);
                BleConfigResp bleConfigResp = (BleConfigResp) basicResp;
                e3.a.d(com.haier.uhome.config.a.E, "BLE", "ble config .server True errNo is %d", Integer.valueOf(bleConfigResp.getErrNo()));
                ErrorConst errorConstA = a(bleConfigResp, this.f28571a.get());
                ErrorConst errorConst = ErrorConst.ERR_USDK_TIMEOUT;
                if (errorConstA == errorConst && !com.haier.uhome.usdk.base.utils.a.c()) {
                    errorConstA = ErrorConst.ERR_USDK_BLE_IS_POWER_OFF;
                }
                if (errorConstA == errorConst) {
                    errorConstA = ErrorConst.ERR_USDK_SEND_CONFIG_REQ_TIMEOUT;
                }
                d dVar = new d();
                dVar.c(str);
                dVar.b(bleConfigResp.getUplusId());
                dVar.a(bleConfigResp.getChannel());
                dVar.d(bleConfigResp.getProductCode());
                dVar.a(bleConfigResp.getCompanyId());
                e.this.a(errorConstA.toError(), dVar);
            }

            @Override // com.haier.uhome.usdk.base.api.l
            public void onResp(BasicResp basicResp) {
                if (basicResp.getErrNo() == ErrorConst.ERR_USDK_TIMEOUT.getErrorId()) {
                    this.f28571a.set(true);
                    e.this.b();
                }
            }

            private ErrorConst a(BleConfigResp bleConfigResp, boolean z7) {
                ErrorConst errorConst = ErrorConst.RET_USDK_OK;
                if (errorConst.getErrorId() == bleConfigResp.getErrNo()) {
                    return errorConst;
                }
                ErrorConst errorConstB = b(bleConfigResp, z7);
                if (errorConstB != errorConst) {
                    return errorConstB;
                }
                int i8 = e.this.f28568o.get();
                if (i8 == 0) {
                    return ErrorConst.ERR_USDK_TIMEOUT;
                }
                return ErrorConst.getErrorConstById(i8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final uSDKError usdkerror, final d dVar) {
        final com.haier.uhome.usdk.base.api.k<com.haier.uhome.search.service.entity.d, d> kVar = this.f28566m;
        if (kVar == null) {
            e3.a.u(com.haier.uhome.config.a.E, "BLE", "startBind callback is null,so give up callback -result:" + usdkerror, new Object[0]);
        }
        if (dVar != null && !TextUtils.isEmpty(dVar.c())) {
            a(dVar.c());
        }
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.config.service.x
            @Override // java.lang.Runnable
            public final void run() {
                this.f28701a.a(usdkerror, dVar, kVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(uSDKError usdkerror, d dVar, com.haier.uhome.usdk.base.api.k kVar) {
        if (this.f28566m == null) {
            e3.a.u(com.haier.uhome.config.a.E, "BLE", "startBind callback is null,so give up callback -result:" + usdkerror, new Object[0]);
            return;
        }
        if (dVar == null && usdkerror.a(ErrorConst.RET_USDK_OK)) {
            uSDKError error = ErrorConst.ERR_INTERNAL.toError();
            error.a("wrong state: result == null");
            kVar.onFailure(error);
        } else {
            if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
                kVar.onSuccess(dVar);
            } else {
                kVar.onFailure(usdkerror);
            }
            this.f28566m = null;
        }
    }

    public void a(boolean z7) {
        if (z7) {
            this.f28566m = null;
        }
        b();
    }

    private void a(String str) {
        com.haier.uhome.search.b.f.a().a(str, 7);
    }
}
