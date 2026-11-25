package com.haier.uhome.search.service;

import c.m0;
import com.haier.uhome.search.json.SearchProtocol;
import com.haier.uhome.search.json.notify.UnconnectedDevInfo;
import com.haier.uhome.usdk.base.api.ErrorConst;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a implements com.haier.uhome.search.b.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f29787a = 15000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int f29788b = 4;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int f29789c = 5;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int f29790d = 6;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final com.haier.library.common.util.j<String, com.haier.library.sumhttp.response.i> f29791f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected e f29792e = e.a();

    static {
        SearchProtocol.register();
        f29791f = new com.haier.library.common.util.s();
    }

    a() {
        com.haier.uhome.search.b.f.a().a(this);
    }

    void a(List<UnconnectedDevInfo> list) {
    }

    protected void b(com.haier.uhome.search.service.entity.b bVar) {
    }

    protected void c(String str, int i7) {
    }

    protected void d(String str, int i7) {
    }

    private String d(com.haier.uhome.search.service.entity.b bVar) {
        int iT = bVar.t();
        if (iT == 1) {
            return "Ble";
        }
        if (iT == 2) {
            return "SoftAp";
        }
        if (iT == 3) {
            return com.haier.uhome.search.a.f29686g;
        }
        if (iT != 4) {
            return iT != 5 ? "" : "Mesh";
        }
        return "New direct";
    }

    @Override // com.haier.uhome.search.b.e
    public void a(String str, com.haier.uhome.usdk.base.api.f fVar) {
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29682c, "notifyControlDeviceUpdate deviceInfo: %s ", fVar);
        b(str, fVar);
    }

    protected void b(com.haier.uhome.search.service.entity.c cVar) {
    }

    void c(com.haier.uhome.search.service.entity.b bVar) {
        e3.a.e("%s search: handle config device --> %s", d(bVar), bVar);
    }

    protected void b(com.haier.uhome.search.service.entity.d dVar) {
    }

    @Override // com.haier.uhome.search.b.e
    public void a(String str, String str2, int i7) {
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29682c, "notifyControlDeviceDelete devId:%s module:%s reason:%d", str2, str, Integer.valueOf(i7));
        b(str, str2, i7);
    }

    protected void b(String str, int i7, String str2, int i8, int i9) {
    }

    protected void b(String str, com.haier.uhome.usdk.base.api.f fVar) {
    }

    @Override // com.haier.uhome.search.b.e
    public void a(String str, int i7, String str2, int i8, int i9) {
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29681b, "notifySmartConfigACK, devId %s seedId %d", str, Integer.valueOf(i7));
        b(str, i7, str2, i8, i9);
    }

    protected void b(String str, String str2, int i7) {
    }

    protected void b(String str, String str2, String str3, String str4, int i7, String str5, String str6, int i8, String str7, int i9) {
    }

    @Override // com.haier.uhome.search.b.e
    public void a(com.haier.uhome.search.service.entity.b bVar) {
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "notifyConfigDeviceFound, devId = %s,%s,%s,%s, protocolVers = %s, productCode = %s", bVar.a(), bVar.c(), bVar.b(), bVar.k(), bVar.j(), bVar.f());
        b(bVar);
    }

    @Override // com.haier.uhome.search.b.e
    public void b(String str, int i7) {
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "notifyDirectLinkConfigDelete", new Object[0]);
        d(str, i7);
    }

    public com.haier.library.sumhttp.response.i b(String str) {
        e3.a.e("Base scan: short product = %s", str);
        if (com.haier.library.common.util.c.m(str)) {
            e3.a.v("Base scan: shortProduct is empty!", new Object[0]);
            return null;
        }
        com.haier.library.common.util.j<String, com.haier.library.sumhttp.response.i> jVar = f29791f;
        synchronized (jVar) {
            com.haier.library.sumhttp.response.i iVar = jVar.get(str);
            if (iVar != null && iVar.c() != null) {
                e3.a.v("Base scan: ProductInfo cache hit product info is %s!", iVar.toString());
                return iVar;
            }
            if (iVar == null) {
                iVar = new com.haier.library.sumhttp.response.i();
                jVar.put(str, iVar);
            }
            if (!iVar.e()) {
                iVar.i(true);
                a(str, iVar);
            }
            return null;
        }
    }

    @Override // com.haier.uhome.search.b.e
    public void a(String str, int i7) {
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "notifyConfigDeviceDel, devId:%s reason : %d", str, Integer.valueOf(i7));
        c(str, i7);
    }

    @Override // com.haier.uhome.search.b.e
    public void a(String str, String str2, String str3, String str4, int i7, String str5, String str6, int i8, String str7, int i9) {
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "notifyNewDirectLinkConfigUpdate", new Object[0]);
        b(str, str2, str3, str4, i7, str5, str6, i8, str7, i9);
    }

    @Override // com.haier.uhome.search.b.e
    public void a(com.haier.uhome.search.service.entity.d dVar) {
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "notifyDeviceBleEvent: %s", dVar);
        b(dVar);
    }

    @Override // com.haier.uhome.search.b.e
    public void a(com.haier.uhome.search.service.entity.i iVar) {
        if (iVar.b() != ErrorConst.RET_USDK_OK.getErrorId()) {
            e3.a.u("SEARCH", com.haier.uhome.search.a.f29686g, "notify error so give up! error = %d", Integer.valueOf(iVar.b()));
        } else {
            a(iVar.c());
        }
    }

    @Override // com.haier.uhome.search.b.e
    public void a(com.haier.uhome.search.service.entity.c cVar) {
        b(cVar);
    }

    private void a(@m0 final String str, @m0 final com.haier.library.sumhttp.response.i iVar) {
        com.haier.library.sumhttp.request.a.h().t(str, new m3.a<com.haier.library.sumhttp.response.k>() { // from class: com.haier.uhome.search.service.a.1
            @Override // m3.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.library.sumhttp.response.k kVar) {
                e3.a.h("Base scan find longCode success %s", kVar);
                iVar.i(false);
                if (kVar == null || !kVar.h()) {
                    return;
                }
                iVar.f(kVar.f().a());
                iVar.g(kVar.f().b());
                iVar.h(kVar.f().c());
                iVar.j(kVar.f().d());
                a.f29791f.put(str, iVar);
            }

            @Override // m3.a
            public void onError(Exception exc) {
                e3.a.g("Base scan find longCode error %s", exc);
                iVar.i(false);
            }
        });
    }

    int a() {
        return com.haier.library.sumhttp.a.c.d().a() == com.haier.library.sumhttp.a.a.SOFT_AP ? 8 : 1;
    }

    static void b(com.haier.uhome.search.a.j<Void> jVar, int i7) {
        if (jVar != null) {
            jVar.b(i7);
        }
    }

    static void a(com.haier.uhome.search.a.j<Void> jVar, int i7) {
        if (jVar != null) {
            jVar.a(i7);
        }
    }
}
