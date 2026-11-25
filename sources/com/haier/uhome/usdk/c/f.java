package com.haier.uhome.usdk.c;

import android.text.TextUtils;
import c.m0;
import com.haier.uhome.control.base.json.RouterSsidPasswordEvent;
import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.api.uSDKDeviceManager;
import com.haier.uhome.usdk.api.uSDKDeviceNetTypeConst;
import com.haier.uhome.usdk.api.uSDKErrorConst;
import com.haier.uhome.usdk.api.w;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.bind.RetryBindDeviceHandler;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f32002a = 2000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.haier.uhome.usdk.c.a<String, a> f32003b = new com.haier.uhome.usdk.c.a<String, a>() { // from class: com.haier.uhome.usdk.c.f.1
        @Override // com.haier.uhome.usdk.c.a
        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void c(String str, a aVar) {
            uSDKError usdkerrorA = aVar.a();
            if (usdkerrorA == null) {
                usdkerrorA = ErrorConst.ERR_USDK_TIMEOUT.toError();
            }
            aVar.f32052e.onFailure(usdkerrorA);
            e3.a.e("NewDeviceFind remote device<%s> timeout", str);
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.haier.uhome.usdk.c.a<String, a> f32004c = new com.haier.uhome.usdk.c.a<String, a>() { // from class: com.haier.uhome.usdk.c.f.5
        @Override // com.haier.uhome.usdk.c.a
        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void c(String str, a aVar) {
            aVar.f32052e.onFailure(uSDKErrorConst.ERR_USDK_TIMEOUT.toError());
            e3.a.e("NewDeviceFind local device<%s> timeout", str);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.haier.uhome.usdk.base.utils.e f32005d;

    private class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f32049b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private uSDKDeviceNetTypeConst f32050c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private com.haier.uhome.usdk.a.b f32051d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private ICallback<w> f32052e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private uSDKError f32053f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f32054g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f32055h;

        public String toString() {
            return "MapItemInfo{deviceId='" + this.f32049b + "', netType=" + this.f32050c + ", timeout=" + this.f32051d + ", callback=" + this.f32052e + ", sdkError=" + this.f32053f + ", prot='" + this.f32054g + "', bindCode=" + this.f32055h + '}';
        }

        private a(String str, uSDKDeviceNetTypeConst usdkdevicenettypeconst, com.haier.uhome.usdk.a.b bVar, long j7, ICallback<w> iCallback) {
            this.f32049b = str;
            this.f32050c = usdkdevicenettypeconst;
            this.f32051d = bVar;
            this.f32055h = j7;
            this.f32052e = iCallback;
        }

        public String b() {
            return this.f32054g;
        }

        public long c() {
            return this.f32055h;
        }

        public uSDKError a() {
            return this.f32053f;
        }

        public void a(uSDKError usdkerror) {
            this.f32053f = usdkerror;
        }

        public void a(String str) {
            this.f32054g = str;
        }

        public void a(int i7) {
            this.f32055h = i7;
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static f f32056a = new f();

        private b() {
        }
    }

    protected f() {
        d();
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        a aVarC = c(str);
        if (aVarC == null) {
            return;
        }
        a(aVarC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        a aVarRemove = this.f32004c.remove(str);
        if (aVarRemove == null && (aVarRemove = a(str, this.f32004c)) != null) {
            aVarRemove.f32049b = str;
        }
        if (aVarRemove == null) {
            return;
        }
        a(aVarRemove);
    }

    private uSDKDevice f(String str) {
        return a().a(str, uSDKDeviceNetTypeConst.NET_LOCAL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str) {
        a(str, new com.haier.uhome.usdk.a.c(1000L), uSDKDeviceNetTypeConst.NET_REMOTE, com.haier.uhome.usdk.base.a.au, new ICallback<w>() { // from class: com.haier.uhome.usdk.c.f.4
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(w wVar) {
                if (wVar.a() != null) {
                    RouterSsidPasswordEvent routerSsidPasswordEvent = new RouterSsidPasswordEvent();
                    routerSsidPasswordEvent.setProgress(3);
                    routerSsidPasswordEvent.setState(1);
                    routerSsidPasswordEvent.setStateCode(1000);
                    wVar.a().updateRouterProgress(routerSsidPasswordEvent);
                }
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                e3.a.e("bleUpdateRouterProgress find uSDKDevice error is %s", usdkerror.toString());
            }
        });
    }

    private a c(String str) {
        a aVarRemove = this.f32003b.remove(str);
        if (aVarRemove == null && (aVarRemove = a(str, this.f32003b)) != null) {
            aVarRemove.f32049b = str;
        }
        return aVarRemove;
    }

    private void d() {
        com.haier.uhome.control.cloud.a.h.a().a(new com.haier.uhome.control.cloud.a.a() { // from class: com.haier.uhome.usdk.c.f.9
            @Override // com.haier.uhome.control.cloud.a.a, com.haier.uhome.control.cloud.a.p
            public void a(String str, int i7, String str2, int i8) {
                a aVar = (a) f.this.f32003b.get(str);
                e3.a.e("NewDeviceFind notifyCloudDeviceAdd devId = %s, itemInfo = %s", str, aVar);
                if (aVar != null && aVar.f32055h == 0) {
                    f.this.d(str);
                }
                f.this.g(str);
            }

            @Override // com.haier.uhome.control.cloud.a.a, com.haier.uhome.control.cloud.a.p
            public void a(String str, int i7, int i8) {
                e3.a.e("NewDeviceFind notifyCloudDeviceDel devId = %s", str);
            }
        });
    }

    public void b(String str) {
        this.f32004c.remove(str);
    }

    private a a(String str, com.haier.uhome.usdk.c.a<String, a> aVar) {
        for (String str2 : aVar.keySet()) {
            if (str.endsWith(str2)) {
                a aVarRemove = aVar.remove(str2);
                e3.a.d("NewDeviceFind local device<%s> with postfix<%s>", str, str2, new Object[0]);
                return aVarRemove;
            }
        }
        return null;
    }

    private void c() {
        com.haier.uhome.search.a.n.a().a(new com.haier.uhome.search.a.g() { // from class: com.haier.uhome.usdk.c.f.8
            @Override // com.haier.uhome.search.a.g
            public /* synthetic */ void a(com.haier.uhome.search.service.entity.d dVar) {
                com.haier.uhome.search.a.p.a(this, dVar);
            }

            @Override // com.haier.uhome.search.a.g
            public void onDeviceAdd(String str, com.haier.uhome.usdk.base.api.f fVar) {
                if ("local".equals(str)) {
                    f.this.e(fVar.b());
                }
            }

            @Override // com.haier.uhome.search.a.g
            public void onDeviceDel(String str, com.haier.uhome.usdk.base.api.f fVar, int i7) {
                e3.a.e("nothing to do ~", new Object[0]);
            }

            @Override // com.haier.uhome.search.a.g
            public void onDeviceUpdate(String str, com.haier.uhome.usdk.base.api.f fVar) {
                f.this.e(fVar.b());
            }
        });
    }

    public void b(final String str, final long j7, final int i7, long j8, final TraceNode traceNode, final boolean z7, final long j9, long j10, final ICallback<w> iCallback) {
        final long jL;
        final com.haier.uhome.control.cloud.api.d dVarE = uSDKDeviceManager.getSingleInstance().e();
        if (dVarE == null) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST.toError());
            return;
        }
        if (j10 == -1) {
            com.haier.uhome.usdk.base.api.f fVarA = com.haier.uhome.usdk.base.api.g.a().a(str);
            jL = fVarA != null ? fVarA.l() : 0L;
        } else {
            jL = j10;
        }
        com.haier.uhome.usdk.base.utils.e<com.haier.uhome.control.base.a> eVar = new com.haier.uhome.usdk.base.utils.e<com.haier.uhome.control.base.a>(j8, 2000L) { // from class: com.haier.uhome.usdk.c.f.11
            @Override // com.haier.uhome.usdk.base.utils.e
            public void a(long j11) {
                ErrorConst errorConst = ErrorConst.ERR_USDK_TIMEOUT;
                final com.haier.uhome.usdk.base.api.c cVar = new com.haier.uhome.usdk.base.api.c(errorConst.toError());
                if (j11 <= 0) {
                    cVar.a(errorConst.toError());
                    b(cVar);
                    return;
                }
                f fVar = f.this;
                com.haier.uhome.control.cloud.api.d dVar = dVarE;
                String str2 = str;
                long j12 = j7;
                int i8 = i7;
                TraceNode traceNode2 = traceNode;
                fVar.a(dVar, str2, j12, i8, traceNode2 != null ? traceNode2.getTraceId() : "", com.haier.uhome.usdk.base.utils.f.a(j11, 5000L), z7, j9, System.currentTimeMillis(), jL, new ICallback<com.haier.uhome.control.base.a>() { // from class: com.haier.uhome.usdk.c.f.11.1
                    @Override // com.haier.uhome.usdk.base.api.ICallback
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onSuccess(com.haier.uhome.control.base.a aVar) {
                        if (aVar.b() == 1) {
                            cVar.a(ErrorConst.RET_USDK_OK.toError());
                            cVar.a(aVar);
                        } else {
                            uSDKError error = ErrorConst.ERR_USDK_TIMEOUT.toError();
                            HashMap<String, String> map = new HashMap<>(1);
                            map.put(TraceProtocolConst.PRO_PROTOCOL, aVar.a());
                            error.a(map);
                            cVar.a(error);
                        }
                        b(cVar);
                    }

                    @Override // com.haier.uhome.usdk.base.api.ICallback
                    public void onFailure(uSDKError usdkerror) {
                        cVar.a(usdkerror);
                        b(cVar);
                    }
                });
            }

            @Override // com.haier.uhome.usdk.base.utils.e
            /* JADX INFO: renamed from: a */
            public void d(com.haier.uhome.usdk.base.api.c<com.haier.uhome.control.base.a> cVar) {
                e3.a.e("retryQueryBindResultImpl finish result = " + cVar, new Object[0]);
                if (!cVar.b().a(ErrorConst.RET_USDK_OK) || cVar.c() == null) {
                    com.haier.uhome.usdk.base.utils.b.a(iCallback, f.this.b(str, cVar.b()));
                    return;
                }
                uSDKDevice usdkdeviceA = uSDKDeviceManager.getSingleInstance().a(cVar.c().c(), cVar.c().d(), uSDKDeviceNetTypeConst.NET_REMOTE);
                w wVar = new w();
                wVar.a(usdkdeviceA);
                wVar.a(cVar.c().a());
                com.haier.uhome.usdk.base.utils.b.a((ICallback<w>) iCallback, wVar);
            }
        };
        this.f32005d = eVar;
        eVar.a();
    }

    /* JADX INFO: renamed from: com.haier.uhome.usdk.c.f$10, reason: invalid class name */
    class AnonymousClass10 extends com.haier.uhome.usdk.base.utils.e.a<uSDKDevice> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        uSDKError f32007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f32008b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f32009c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f32010d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f32011e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass10(long j7, long j8, String str, long j9, int i7, String str2) {
            super(j7, j8);
            this.f32008b = str;
            this.f32009c = j9;
            this.f32010d = i7;
            this.f32011e = str2;
            this.f32007a = null;
        }

        @Override // com.haier.uhome.usdk.base.utils.e
        public void a(long j7) {
            com.haier.uhome.control.cloud.api.d dVarE = uSDKDeviceManager.getSingleInstance().e();
            if (dVarE == null) {
                e();
            } else if (f.this.f32003b.containsKey(this.f32008b)) {
                final int iMin = Math.min(5, (int) (j7 / 1000));
                dVarE.a(this.f32008b, this.f32009c, this.f32010d, iMin, this.f32011e, new ICallback<com.haier.uhome.control.base.a>() { // from class: com.haier.uhome.usdk.c.f.10.1
                    @Override // com.haier.uhome.usdk.base.api.ICallback
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onSuccess(com.haier.uhome.control.base.a aVar) {
                        String strA = aVar.a();
                        e3.a.e("reqCloudDeviceBindResult onSuccess Protocol : %s", strA);
                        a aVar2 = (a) f.this.f32003b.get(AnonymousClass10.this.f32008b);
                        if (aVar2 != null) {
                            aVar2.a(strA);
                        }
                        AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                        if (anonymousClass10.f32009c == 0) {
                            anonymousClass10.f32007a = ErrorConst.RET_USDK_OK.toError();
                        } else if (aVar.b() == 1) {
                            uSDKDevice usdkdeviceA = uSDKDeviceManager.getSingleInstance().a(aVar.c(), aVar.d(), uSDKDeviceNetTypeConst.NET_REMOTE);
                            a aVar3 = (a) f.this.f32003b.remove(AnonymousClass10.this.f32008b);
                            if (aVar3 != null) {
                                e3.a.e("reqCloudDeviceBindResult onSuccess DeviceId : %s", usdkdeviceA.getDeviceId());
                                w wVar = new w();
                                wVar.a(usdkdeviceA);
                                wVar.a(strA);
                                aVar3.f32052e.onSuccess(wVar);
                                AnonymousClass10.this.i();
                                return;
                            }
                        } else {
                            AnonymousClass10.this.f32007a = ErrorConst.ERR_USDK_TIMEOUT.toError();
                        }
                        HashMap<String, String> map = new HashMap<>(1);
                        map.put(TraceProtocolConst.PRO_PROTOCOL, strA);
                        uSDKError usdkerror = AnonymousClass10.this.f32007a;
                        if (usdkerror != null) {
                            usdkerror.a(map);
                        }
                        AnonymousClass10.this.l();
                    }

                    @Override // com.haier.uhome.usdk.base.api.ICallback
                    public void onFailure(uSDKError usdkerror) {
                        a aVar = (a) f.this.f32003b.get(AnonymousClass10.this.f32008b);
                        if (aVar != null) {
                            aVar.a(usdkerror.getExtendedInfo().get(TraceProtocolConst.PRO_PROTOCOL));
                        }
                        if (iMin >= 5 || AnonymousClass10.this.f32007a == null) {
                            AnonymousClass10.this.f32007a = usdkerror;
                        }
                        AnonymousClass10.this.l();
                    }
                });
            } else {
                this.f32007a = null;
                e();
            }
        }

        @Override // com.haier.uhome.usdk.base.utils.e
        /* JADX INFO: renamed from: a */
        public void d(com.haier.uhome.usdk.base.api.c<uSDKDevice> cVar) {
            uSDKError usdkerror = this.f32007a;
            if (usdkerror != null) {
                f.this.a(this.f32008b, usdkerror);
            }
        }
    }

    public void a(final String str, long j7, final uSDKDeviceNetTypeConst usdkdevicenettypeconst, final ICallback<uSDKDevice> iCallback) {
        new com.haier.uhome.usdk.base.utils.e<uSDKDevice>(j7, 1000L) { // from class: com.haier.uhome.usdk.c.f.6
            @Override // com.haier.uhome.usdk.base.utils.e
            public void a(long j8) {
                uSDKDevice usdkdeviceA = f.a().a(str, usdkdevicenettypeconst);
                if (usdkdeviceA == null) {
                    b(new com.haier.uhome.usdk.base.api.c(ErrorConst.ERR_USDK_TIMEOUT.toError()));
                    return;
                }
                com.haier.uhome.usdk.base.api.c cVar = new com.haier.uhome.usdk.base.api.c(ErrorConst.RET_USDK_OK.toError());
                cVar.a(usdkdeviceA);
                b(cVar);
            }

            @Override // com.haier.uhome.usdk.base.utils.e
            /* JADX INFO: renamed from: a */
            public void d(com.haier.uhome.usdk.base.api.c<uSDKDevice> cVar) {
                if (iCallback == null) {
                    return;
                }
                if (cVar.b().a(ErrorConst.RET_USDK_OK) && cVar.c() != null) {
                    iCallback.onSuccess(cVar.c());
                } else {
                    iCallback.onFailure(cVar.b());
                }
            }
        }.a();
    }

    public void b() {
        com.haier.uhome.usdk.base.utils.e eVar = this.f32005d;
        if (eVar != null) {
            eVar.i();
        }
    }

    private void a(String str, com.haier.uhome.usdk.a.b bVar, long j7, ICallback<w> iCallback) {
        com.haier.uhome.usdk.c.a<String, a> aVar = this.f32003b;
        uSDKDeviceNetTypeConst usdkdevicenettypeconst = uSDKDeviceNetTypeConst.NET_REMOTE;
        aVar.a(str, new a(str, usdkdevicenettypeconst, bVar, j7, iCallback), bVar);
        e3.a.e("NewDeviceFind waitForNewRemoteDevice for device<%s>", str);
        uSDKDevice device = uSDKDeviceManager.getSingleInstance().getDevice(str);
        if (device == null || !device.isNetTypeContain(usdkdevicenettypeconst)) {
            return;
        }
        e3.a.e("NewDeviceFind waitForNewRemoteDevice for device<%s> but it already with a old exist", str);
    }

    private void b(@m0 String str, com.haier.uhome.usdk.a.b bVar, long j7, ICallback<w> iCallback) {
        a(str, bVar, j7, iCallback);
    }

    public void b(@m0 String str, com.haier.uhome.usdk.a.b bVar, ICallback<w> iCallback) {
        a aVarRemove;
        com.haier.uhome.usdk.c.a<String, a> aVar = this.f32004c;
        uSDKDeviceNetTypeConst usdkdevicenettypeconst = uSDKDeviceNetTypeConst.NET_LOCAL;
        aVar.a(str, new a(str, usdkdevicenettypeconst, bVar, 0L, iCallback), bVar);
        e3.a.e("NewDeviceFind findDeviceLocalEase put device<%s> to wait map", str);
        uSDKDevice usdkdeviceA = a(str, usdkdevicenettypeconst);
        if (usdkdeviceA == null || (aVarRemove = this.f32004c.remove(str)) == null) {
            return;
        }
        w wVar = new w();
        wVar.a(usdkdeviceA);
        wVar.a(aVarRemove.b());
        e3.a.e("NewDeviceFind findDeviceLocalEase direct gotDevice<%s> ", str);
        aVarRemove.f32052e.onSuccess(wVar);
    }

    public static f a() {
        return b.f32056a;
    }

    public uSDKDevice a(String str, uSDKDeviceNetTypeConst usdkdevicenettypeconst) {
        uSDKDevice device = uSDKDeviceManager.getSingleInstance().getDevice(str);
        if (usdkdevicenettypeconst == null || device == null || device.isNetTypeContain(usdkdevicenettypeconst)) {
            return device;
        }
        return null;
    }

    public void a(String str) {
        this.f32003b.remove(str);
    }

    public uSDKDevice a(@m0 String str, com.haier.uhome.usdk.a.b bVar, uSDKDeviceNetTypeConst usdkdevicenettypeconst) {
        uSDKDevice usdkdeviceA;
        while (true) {
            usdkdeviceA = a(str, usdkdevicenettypeconst);
            if (usdkdeviceA != null || bVar.isTimeout()) {
                break;
            }
            try {
                Thread.sleep(200L);
            } catch (InterruptedException e8) {
                e3.a.e("findDeviceWithNetTypeSync get excp %s", e8);
                Thread.currentThread().interrupt();
            }
        }
        return usdkdeviceA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKError b(String str, uSDKError usdkerror) {
        if (-10003 == usdkerror.getCode() || -25001 == usdkerror.getCode() || -25071 == usdkerror.getCode() || 1900001 == usdkerror.getCode() || 20202 == usdkerror.getCode() || -40000 == usdkerror.getCode() || -40004 == usdkerror.getCode() || usdkerror.getCode() == 0) {
            if (TextUtils.isEmpty(str)) {
                ErrorConst errorConst = ErrorConst.ERR_USDK_DEVICE_LOCAL_NOT_EXIST_AND_GET_BIND_RESULT_TIMEOUT;
                usdkerror.setCode(errorConst.toError().getCode());
                usdkerror.setDescription(errorConst.toError().getDescription());
            } else if (f(str) != null) {
                ErrorConst errorConst2 = ErrorConst.ERR_USDK_BIND_TIMEOUT_NEED_RETRY_BIND;
                usdkerror.setCode(errorConst2.toError().getCode());
                usdkerror.setDescription(errorConst2.toError().getDescription());
                usdkerror.a(String.valueOf(ErrorConst.ERR_USDK_DEVICE_LOCAL_EXIST_AND_GET_BIND_RESULT_TIMEOUT.getErrorId()));
            } else {
                ErrorConst errorConst3 = ErrorConst.ERR_USDK_DEVICE_LOCAL_NOT_EXIST_AND_GET_BIND_RESULT_TIMEOUT;
                usdkerror.setCode(errorConst3.toError().getCode());
                usdkerror.setDescription(errorConst3.toError().getDescription());
            }
        }
        return usdkerror;
    }

    private void a(a aVar) {
        a(aVar.f32049b, aVar.f32051d, aVar.f32050c, aVar.b(), aVar.f32052e);
    }

    private void a(@m0 final String str, final com.haier.uhome.usdk.a.b bVar, final uSDKDeviceNetTypeConst usdkdevicenettypeconst, final String str2, final ICallback<w> iCallback) {
        if (iCallback == null) {
            return;
        }
        if (bVar.isTimeout()) {
            a(uSDKErrorConst.ERR_USDK_TIMEOUT.toError(), iCallback);
        } else {
            new com.haier.library.common.thread.m<Void, uSDKDevice, uSDKDevice>() { // from class: com.haier.uhome.usdk.c.f.7
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.haier.library.common.thread.m
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public uSDKDevice doInBackground(Void... voidArr) {
                    return f.this.a(str, bVar, usdkdevicenettypeconst);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.haier.library.common.thread.m
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onPostExecute(uSDKDevice usdkdevice) {
                    if (usdkdevice == null) {
                        e3.a.o("NewDeviceFind find device<%s> fail netType:%s", str, usdkdevicenettypeconst);
                        iCallback.onFailure(uSDKErrorConst.ERR_USDK_DEVICE_NOT_FOUND.toError());
                        return;
                    }
                    e3.a.e("NewDeviceFind find device<%s> success netType:%s, protocol : %s", str, usdkdevicenettypeconst, str2);
                    w wVar = new w();
                    wVar.a(usdkdevice);
                    wVar.a(str2);
                    iCallback.onSuccess(wVar);
                }
            }.execute(new Void[0]);
        }
    }

    private void a(final uSDKError usdkerror, final ICallback<w> iCallback) {
        if (iCallback == null) {
            return;
        }
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.c.o
            @Override // java.lang.Runnable
            public final void run() {
                iCallback.onFailure(usdkerror);
            }
        });
    }

    private void a(String str, long j7, int i7, long j8, String str2) {
        new AnonymousClass10(j8, 2000L, str, j7, i7, str2).a();
    }

    public void a(String str, long j7, int i7, long j8, TraceNode traceNode, boolean z7, long j9, long j10, ICallback<w> iCallback) {
        RetryBindDeviceHandler.getSingleInstance().a(str).b(true).a(j7).a(i7).a(traceNode).a(false).b(j9);
        b(str, j7, i7, j8, traceNode, z7, j9, j10, iCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.haier.uhome.control.cloud.api.d dVar, String str, long j7, int i7, String str2, int i8, boolean z7, long j8, long j9, long j10, final ICallback<com.haier.uhome.control.base.a> iCallback) {
        dVar.a(str, j7, i7, i8, str2, j10, !z7 ? j9 - j8 : 0L, new ICallback<com.haier.uhome.control.base.a>() { // from class: com.haier.uhome.usdk.c.f.12
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.control.base.a aVar) {
                e3.a.e("queryBindResultOnce onSuccess result<%s>", aVar.toString());
                iCallback.onSuccess(aVar);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                e3.a.e("queryBindResultOnce error<%s>", usdkerror.toString());
                iCallback.onFailure(usdkerror);
            }
        });
    }

    public void a(@m0 String str, com.haier.uhome.usdk.a.b bVar, ICallback<w> iCallback) {
        a(str, bVar, uSDKDeviceNetTypeConst.NET_LOCAL, (String) null, iCallback);
    }

    public void a(@m0 String str, long j7, boolean z7, long j8, int i7, TraceNode traceNode, final ICallback<w> iCallback) {
        RetryBindDeviceHandler.getSingleInstance().a(str).b(z7).a(j8).a(i7).a(traceNode).a(false).b(System.currentTimeMillis());
        b(str, new com.haier.uhome.usdk.a.b(j7) { // from class: com.haier.uhome.usdk.c.f.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            long f32029a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f32030b;

            {
                this.f32030b = j7;
                this.f32029a = j7 + System.currentTimeMillis();
            }

            @Override // com.haier.uhome.usdk.a.b
            public boolean isTimeout() {
                return System.currentTimeMillis() > this.f32029a;
            }
        }, j8, new ICallback<w>() { // from class: com.haier.uhome.usdk.c.f.3
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(w wVar) {
                com.haier.uhome.usdk.base.utils.b.a((ICallback<w>) iCallback, wVar);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
            }
        });
        if (z7) {
            a(str, j8, i7, j7 - 2000, traceNode != null ? traceNode.getTraceId() : "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, uSDKError usdkerror) {
        e3.a.e("callFinish errorCode = " + usdkerror.getCode(), new Object[0]);
        String str2 = usdkerror.getExtendedInfo().get(TraceProtocolConst.PRO_PROTOCOL);
        new HashMap(1).put(TraceProtocolConst.PRO_PROTOCOL, str2);
        uSDKError usdkerrorB = b(str, usdkerror);
        e3.a.e("NewDeviceFind callFinish error = " + usdkerrorB.toString(), new Object[0]);
        a aVar = this.f32003b.get(str);
        if (aVar != null) {
            aVar.a(usdkerrorB);
            aVar.a(str2);
        }
    }
}
