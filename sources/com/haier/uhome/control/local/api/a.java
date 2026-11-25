package com.haier.uhome.control.local.api;

import com.haier.uhome.control.cloud.api.FOTAInfo;
import com.haier.uhome.control.cloud.api.FOTAStatusInfo;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.s;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends com.haier.uhome.control.base.api.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.haier.uhome.control.cloud.api.g f29304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f29305c;

    protected a(String str, String str2, String str3, String str4) {
        super(str, str3, str4);
        this.f29303a = str2;
    }

    public String J() {
        return this.f29303a;
    }

    @Override // com.haier.uhome.control.base.api.a
    /* JADX INFO: renamed from: K */
    public abstract com.haier.uhome.control.local.e.a s();

    public synchronized boolean L() {
        return this.f29305c;
    }

    public void a(int i7, ICallback<FOTAInfo> iCallback) {
        s().a(X(), i7, iCallback);
    }

    public void b(int i7, ICallback<com.haier.uhome.control.local.b.c> iCallback) {
        a("", i7, iCallback);
    }

    public synchronized void f(boolean z7) {
        this.f29305c = z7;
    }

    public String G() {
        return com.haier.uhome.usdk.base.api.q.BLE_CAE_DEV_EPP_SAFE.name();
    }

    public void a(ICallback<com.haier.uhome.control.local.b.c> iCallback) {
        a("", 0, iCallback);
    }

    public void b(String str, ICallback<com.haier.uhome.control.local.b.c> iCallback) {
        a(str, 1, iCallback);
    }

    private void a(String str, int i7, ICallback<com.haier.uhome.control.local.b.c> iCallback) {
        s().a(X(), this.f29303a, G(), str, "", i7, iCallback);
    }

    public void a(com.haier.uhome.control.local.b.a aVar, s sVar) {
        aVar.b(J());
        aVar.a(X());
        aVar.d(G());
        s().a(aVar, sVar);
    }

    public void a(s sVar) {
        s().a(X(), sVar);
    }

    public void a(String str, int i7, int i8) {
        s().a(X(), str, i7, i8);
    }

    public void a(com.haier.uhome.control.cloud.api.g gVar) {
        this.f29304b = gVar;
    }

    public void a(final FOTAStatusInfo fOTAStatusInfo) {
        final com.haier.uhome.control.cloud.api.g gVar = this.f29304b;
        if (gVar == null) {
            e3.a.v("Ble ota: notify status but listener is null", new Object[0]);
        } else {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.local.api.j
                @Override // java.lang.Runnable
                public final void run() {
                    gVar.onFOTAStatus(fOTAStatusInfo);
                }
            });
        }
    }

    public void a(com.haier.uhome.control.cloud.api.f fVar, s sVar) {
        com.haier.uhome.control.cloud.service.c.l().a(15, X(), fVar, sVar);
    }

    public void a(Map<String, Object> map, m3.a<com.haier.library.sumhttp.response.c> aVar) {
        s().a(map, aVar);
    }
}
