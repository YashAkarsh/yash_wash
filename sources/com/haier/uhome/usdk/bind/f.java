package com.haier.uhome.usdk.bind;

import com.haier.uhome.config.json.ProtocolConst;
import com.haier.uhome.trace.api.DITraceNode;
import com.haier.uhome.trace.api.Trace;
import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.VersionManager;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.scanner.ConfigType;
import com.haier.uhome.usdk.scanner.ConfigurableDevice;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
class f extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f31554a = 2;

    /* JADX INFO: renamed from: com.haier.uhome.usdk.bind.f$1, reason: invalid class name */
    class AnonymousClass1 implements m3.a<com.haier.library.sumhttp.response.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.haier.uhome.config.entity.a f31555a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f31556b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f31557c;

        AnonymousClass1(com.haier.uhome.config.entity.a aVar, Map map, long j7) {
            this.f31555a = aVar;
            this.f31556b = map;
            this.f31557c = j7;
        }

        @Override // m3.a
        public void onError(Exception exc) {
            if (f.this.c()) {
                e3.a.v("BLE bind: query bind code and session error already timeout!", new Object[0]);
            } else if (com.haier.library.sumhttp.request.a.l(exc)) {
                final com.haier.uhome.config.entity.a aVar = this.f31555a;
                com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.usdk.bind.p0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f31709a.a(aVar);
                    }
                }, 1L);
            } else {
                f.this.a(com.haier.library.json.a.Z(this.f31556b), (com.haier.library.sumhttp.response.b) null, System.currentTimeMillis() - this.f31557c);
                f.this.b(ErrorConst.ERR_USDK_NETWORK_EXCEPTION.toError());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(com.haier.uhome.config.entity.a aVar) {
            f.this.a(aVar);
        }

        @Override // m3.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(com.haier.library.sumhttp.response.b bVar) {
            f.this.a(com.haier.library.json.a.Z(this.f31556b), bVar, System.currentTimeMillis() - this.f31557c);
            e3.a.e("BLE bind: query bind code and session success %s", bVar);
            if (f.this.c()) {
                e3.a.v("BLE bind: query bind code and session success already timeout!", new Object[0]);
                return;
            }
            if (!bVar.c()) {
                e3.a.v("BLE bind: query bind code and session failure!", new Object[0]);
                f.this.b(ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR.toError());
                return;
            }
            o3.b bVarF = bVar.f();
            this.f31555a.a(bVarF.a().longValue());
            this.f31555a.g(bVarF.c());
            this.f31555a.a(com.haier.uhome.usdk.base.utils.f.f(bVarF.b()));
            this.f31555a.f(bVarF.d());
            f.this.b(bVarF.a().longValue());
            f.super.a(this.f31555a);
        }
    }

    f(WithoutWifiBindInfo withoutWifiBindInfo) {
        super(withoutWifiBindInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(com.haier.uhome.usdk.api.w wVar) {
        super.a(wVar);
    }

    @Override // com.haier.uhome.usdk.bind.h, com.haier.uhome.config.a.e
    public void a_(int i7) {
        super.a_(i7);
        Trace traceCreateDITrace = Trace.createDITrace();
        if (traceCreateDITrace == null) {
            e3.a.v("BLE bind: diTrace is empty, so return!", new Object[0]);
            return;
        }
        DITraceNode dITraceNode = new DITraceNode(com.haier.uhome.trace.b.b.f30244a, ProtocolConst.NOTIFY_MODULE_CONFIG_STATE, r(), String.valueOf(i7), VersionManager.getInstance().getSDKVersion());
        dITraceNode.add("sys", com.haier.uhome.trace.b.e.USDK.name());
        dITraceNode.add(TraceProtocolConst.PRO_APP_ID, com.haier.uhome.usdk.base.service.e.a().i());
        dITraceNode.add(TraceProtocolConst.PRO_DEVICE_ID, r());
        dITraceNode.add(TraceProtocolConst.PRO_PROTOCOL, "local");
        dITraceNode.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        dITraceNode.add(TraceProtocolConst.PRO_TOKEN, com.haier.uhome.usdk.base.service.e.a().g());
        dITraceNode.add(TraceProtocolConst.PRO_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
        traceCreateDITrace.addDITraceNode(dITraceNode);
    }

    @Override // com.haier.uhome.usdk.bind.h, com.haier.uhome.usdk.bind.k
    protected uSDKError g() {
        uSDKError usdkerrorG = super.g();
        if ((ConfigType.BIND_WITHOUT_WIFI.getMask() & o().getAllConfigTypes()) != 0) {
            return usdkerrorG;
        }
        e3.a.h("BLE bind: configurableDevice is not BLE device!", new Object[0]);
        uSDKError error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
        error.a("ConfigurableDevice is not BLE device!");
        return error;
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void i() {
        TraceNode traceNodeE;
        BaseBleBindInfo baseBleBindInfoN = n();
        if (baseBleBindInfoN != null) {
            ConfigurableDevice configurableDeviceO = o();
            traceNodeE = com.haier.uhome.trace.api.b.a().a(configurableDeviceO == null ? r() : configurableDeviceO.getDevId(), baseBleBindInfoN.getTimeout(), a(configurableDeviceO), baseBleBindInfoN.getAppCsNode());
        } else {
            traceNodeE = com.haier.uhome.trace.api.b.a().e(null);
        }
        a(traceNodeE);
    }

    @Override // com.haier.uhome.usdk.bind.h
    boolean k() {
        return false;
    }

    @Override // com.haier.uhome.usdk.bind.h
    int l() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.haier.uhome.usdk.bind.h
    public void a(com.haier.uhome.config.entity.a aVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        HashMap map = new HashMap(4);
        map.put("mac", aVar.o());
        map.put("appTypeName", o().getAppTypeName());
        map.put("keyVersion", o().getExtendInfo().getKeyVer());
        e3.a.e("BLE bind: query sessionKey and bindCode request param %s", map);
        com.haier.library.sumhttp.request.a.h().m(map, new AnonymousClass1(aVar, map, jCurrentTimeMillis));
    }

    @Override // com.haier.uhome.usdk.bind.h
    protected void a(final com.haier.uhome.usdk.api.w wVar) {
        if (a(TimeUnit.SECONDS) > 2) {
            e3.a.e("BLE bind: invoke client and stop ble config delay!", new Object[0]);
            com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.usdk.bind.o0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f31693a.b(wVar);
                }
            }, 2L);
        } else {
            super.a(wVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.haier.library.sumhttp.response.b bVar, long j7) {
        Trace traceCreateDITrace = Trace.createDITrace();
        if (traceCreateDITrace == null) {
            e3.a.v("BLE bind: diTrace is empty, so return!", new Object[0]);
            return;
        }
        DITraceNode dITraceNode = new DITraceNode(com.haier.uhome.trace.b.b.f30244a, l3.a.f37428k, r(), bVar == null ? String.valueOf(ErrorConst.ERR_USDK_NETWORK_EXCEPTION.getErrorId()) : bVar.a(), VersionManager.getInstance().getSDKVersion());
        dITraceNode.add(TraceProtocolConst.PRO_IPM, str);
        dITraceNode.add(TraceProtocolConst.PRO_RRT, bVar == null ? "" : com.haier.library.json.a.Z(bVar));
        dITraceNode.add("sys", com.haier.uhome.trace.b.e.USDK.name());
        dITraceNode.add(TraceProtocolConst.PRO_APP_ID, com.haier.uhome.usdk.base.service.e.a().i());
        dITraceNode.add(TraceProtocolConst.PRO_DEVICE_ID, r());
        dITraceNode.add(TraceProtocolConst.PRO_SPAN, String.valueOf(j7));
        dITraceNode.add(TraceProtocolConst.PRO_PROTOCOL, com.haier.uhome.usdk.base.a.av);
        dITraceNode.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        dITraceNode.add(TraceProtocolConst.PRO_TOKEN, com.haier.uhome.usdk.base.service.e.a().g());
        dITraceNode.add(TraceProtocolConst.PRO_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
        traceCreateDITrace.addDITraceNode(dITraceNode);
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(uSDKError usdkerror) {
        String str = usdkerror.getExtendedInfo().get(TraceProtocolConst.PRO_PROTOCOL);
        if (com.haier.library.common.util.c.j(str)) {
            str = "local";
        }
        com.haier.uhome.trace.api.b.a().c(usdkerror.getCode(), r(), u(), str);
    }
}
