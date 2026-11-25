package com.haier.uhome.control.noumenon.service;

import com.haier.uhome.control.base.api.DeviceStatus;
import com.haier.uhome.control.base.api.r;
import com.haier.uhome.control.base.json.req.DeviceAttrReadReq;
import com.haier.uhome.control.base.json.req.DeviceAttrWriteReq;
import com.haier.uhome.control.base.json.req.DeviceOperReq;
import com.haier.uhome.trace.api.Trace;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.o;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b extends com.haier.uhome.control.base.c.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.haier.uhome.control.noumenon.service.a f29477c;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f29478a = new b();

        private a() {
        }
    }

    public static b l() {
        return a.f29478a;
    }

    @Override // com.haier.uhome.control.base.c.a
    protected void a(String str, o oVar) {
    }

    @Override // com.haier.uhome.control.base.c.a
    protected DeviceAttrReadReq b() {
        com.haier.uhome.control.noumenon.b.a.a aVar = new com.haier.uhome.control.noumenon.b.a.a();
        aVar.setFrom(3);
        return aVar;
    }

    @Override // com.haier.uhome.control.base.c.a
    protected DeviceAttrWriteReq c() {
        com.haier.uhome.control.noumenon.b.a.b bVar = new com.haier.uhome.control.noumenon.b.a.b();
        bVar.setFrom(3);
        return bVar;
    }

    @Override // com.haier.uhome.control.base.c.a
    protected DeviceOperReq d() {
        com.haier.uhome.control.noumenon.b.a.c cVar = new com.haier.uhome.control.noumenon.b.a.c();
        cVar.setFrom(3);
        return cVar;
    }

    @Override // com.haier.uhome.control.base.c.a
    protected boolean e() {
        return true;
    }

    @Override // com.haier.uhome.control.base.c.a
    public String f() {
        return com.haier.uhome.usdk.base.a.ar;
    }

    private b() {
        this.f29477c = com.haier.uhome.control.noumenon.service.a.a();
        com.haier.uhome.control.noumenon.b.a.a();
    }

    @Override // com.haier.uhome.control.base.c.a
    public void a(String str, String str2, List<Integer> list, String str3, int i7, Trace trace, ICallback<String> iCallback) {
        a(this.f29477c, str, str2, list, str3, i7, trace, iCallback);
    }

    @Override // com.haier.uhome.control.base.c.a
    protected uSDKError f(com.haier.uhome.control.base.api.a aVar) {
        if (aVar == null) {
            return ErrorConst.ERR_INTERNAL.toError();
        }
        return (aVar.n() == DeviceStatus.STATUS_READY || aVar.n() == DeviceStatus.STATUS_CONNECTED) ? ErrorConst.RET_USDK_OK.toError() : ErrorConst.ERR_USDK_DEVICE_NOT_CONNECTED.toError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(o oVar) {
        oVar.onCallback(ErrorConst.ERR_USDK_INVALID_PARAM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(o oVar) {
        com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_USDK_DEVICE_NOT_LOCAL);
    }

    @Override // com.haier.uhome.control.base.c.a
    public void a(String str, String str2, List<Integer> list, String str3, String str4, int i7, Trace trace, ICallback<Void> iCallback) {
        a(this.f29477c, str, str2, list, str3, str4, i7, trace, iCallback);
    }

    @Override // com.haier.uhome.control.base.c.a
    public void a(String str, String str2, List<Integer> list, String str3, List<com.haier.uhome.control.base.api.c> list2, int i7, Trace trace, String str4, ICallback<Void> iCallback) {
        a(this.f29477c, str, str2, list, str3, list2, i7, trace, str4, iCallback);
    }

    public void b(String str, final o oVar) {
        final ErrorConst errorConstA = a(str, false, false);
        if (errorConstA != ErrorConst.RET_USDK_OK) {
            if (oVar != null) {
                com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.noumenon.service.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        oVar.onCallback(errorConstA);
                    }
                });
                return;
            } else {
                e3.a.v("disConnectDevice callback is null,so give up callback", new Object[0]);
                return;
            }
        }
        com.haier.uhome.control.noumenon.b.a.d dVar = new com.haier.uhome.control.noumenon.b.a.d();
        try {
            dVar.setNativeSender(this.f29477c);
            dVar.setDevId(str);
            dVar.setType(1);
            dVar.setFrom(3);
            a(b(str), dVar, oVar);
        } catch (Exception e8) {
            e3.a.h("disConnectDevice Error" + e8.getMessage(), new Object[0]);
            if (oVar != null) {
                com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.noumenon.service.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.b(oVar);
                    }
                });
            } else {
                e3.a.v("disConnectDevice callback is null,so give up callback", new Object[0]);
            }
        }
    }

    @Override // com.haier.uhome.control.base.c.a, com.haier.uhome.control.base.c.c
    public void a(String str, int i7, Trace trace, ICallback<r> iCallback) {
        a(this.f29477c, str, i7, trace, iCallback);
    }

    public void a(final o oVar) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.noumenon.service.e
            @Override // java.lang.Runnable
            public final void run() {
                b.d(oVar);
            }
        });
    }

    public void a(String str, boolean z7, final o oVar) {
        final ErrorConst errorConstA = a(str, z7, true);
        if (errorConstA != ErrorConst.RET_USDK_OK) {
            if (oVar != null) {
                com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.noumenon.service.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        oVar.onCallback(errorConstA);
                    }
                });
                return;
            } else {
                e3.a.v("connectDevice callback is null,so give up callback", new Object[0]);
                return;
            }
        }
        com.haier.uhome.control.noumenon.b.a.d dVar = new com.haier.uhome.control.noumenon.b.a.d();
        try {
            dVar.setNativeSender(this.f29477c);
            dVar.setDevId(str);
            dVar.setType(0);
            dVar.setFrom(3);
            b(b(str), dVar, oVar);
        } catch (Exception e8) {
            e3.a.h("connectDevice Error" + e8.getMessage(), new Object[0]);
            if (oVar != null) {
                com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.noumenon.service.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.c(oVar);
                    }
                });
            } else {
                e3.a.v("connectDevice callback is null,so give up callback", new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(o oVar) {
        oVar.onCallback(ErrorConst.ERR_USDK_INVALID_PARAM);
    }

    protected ErrorConst a(String str, boolean z7, boolean z8) {
        com.haier.uhome.control.base.api.a aVarB = b(str);
        if (aVarB == null) {
            e3.a.h("try to connect a not find device<id=%s>!!", str);
            return ErrorConst.ERR_USDK_DEVICE_NOT_FOUND;
        }
        if (z8) {
            if (aVarB.A()) {
                e3.a.e("try connect connected device id : %s, return ok", str);
                return ErrorConst.RET_USDK_OK;
            }
            aVarB.a(z7);
        } else if (!aVarB.A()) {
            e3.a.e("try disconnect device id : %s, return ok", str);
            return ErrorConst.RET_USDK_OK;
        }
        return ErrorConst.RET_USDK_OK;
    }
}
