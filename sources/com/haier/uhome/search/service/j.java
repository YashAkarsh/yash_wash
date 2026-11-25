package com.haier.uhome.search.service;

import com.haier.uhome.usdk.base.api.uSDKError;

/* JADX INFO: loaded from: classes2.dex */
public class j extends com.haier.uhome.search.service.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f30005f = -601;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.haier.uhome.search.a.a f30006g;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static j f30007a = new j();

        private a() {
        }
    }

    public static j c() {
        return a.f30007a;
    }

    public void a(final com.haier.library.common.thread.e eVar, final com.haier.uhome.search.a.a aVar, final com.haier.uhome.usdk.base.api.s sVar) {
        final uSDKError usdkerrorA = a(aVar);
        if (usdkerrorA.getCode() != -601) {
            sVar.onCallback(usdkerrorA);
            e3.a.e("SmartLink: open smart link ret error = %s!", usdkerrorA);
        } else if (eVar.isTimeout()) {
            sVar.onCallback(usdkerrorA);
            e3.a.v("SmartLink: try open smart link but already timeout!", new Object[0]);
        } else {
            e3.a.e("SmartLink: try open smart link!", new Object[0]);
            com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.search.service.h0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f29960a.b(usdkerrorA, eVar, aVar, sVar);
                }
            }, 1L);
        }
    }

    public uSDKError d() {
        int iC = this.f29792e.c();
        if (iC == 0) {
            this.f30006g = null;
        }
        return com.haier.uhome.usdk.base.utils.c.a(iC);
    }

    private j() {
    }

    @Override // com.haier.uhome.search.service.a
    protected void b(String str, int i7, String str2, int i8, int i9) {
        com.haier.uhome.search.a.a aVar = this.f30006g;
        if (aVar != null) {
            aVar.onReceive(str, i7, str2, i8, i9);
        } else {
            e3.a.v("handleSmartConfigACK seedId = %d,but receiver is null!", Integer.valueOf(i7));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(uSDKError usdkerror, com.haier.library.common.thread.e eVar, com.haier.uhome.search.a.a aVar, com.haier.uhome.usdk.base.api.s sVar) {
        if (eVar.isTimeout()) {
            sVar.onCallback(usdkerror);
            e3.a.v("SmartLink: try open smart link schedule but already timeout!", new Object[0]);
        } else {
            f.c().d();
            a(eVar, aVar, sVar);
        }
    }

    private uSDKError a(com.haier.uhome.search.a.a aVar) {
        int iB = this.f29792e.b();
        if (iB == 0) {
            this.f30006g = aVar;
        }
        return com.haier.uhome.usdk.base.utils.c.a(iB);
    }
}
