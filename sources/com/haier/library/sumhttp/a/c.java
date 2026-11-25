package com.haier.library.sumhttp.a;

import com.haier.library.sumhttp.response.e;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f27926a = new b(com.haier.library.sumhttp.a.a.BLE, 60);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile b f27927b;

    static class a implements m3.a<e> {
        a() {
        }

        @Override // m3.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(e eVar) {
            e3.a.e("Get device strategy success, response = %s", eVar.f());
            if (!eVar.c()) {
                b unused = c.f27927b = c.f27926a;
                return;
            }
            o3.e eVarF = eVar.f();
            if (eVarF == null) {
                b unused2 = c.f27927b = c.f27926a;
            } else {
                b unused3 = c.f27927b = c.e(eVarF);
            }
        }

        @Override // m3.a
        public void onError(Exception exc) {
            e3.a.g("Get device strategy error", exc);
            b unused = c.f27927b = c.f27926a;
        }
    }

    public static void c() {
        com.haier.library.sumhttp.request.a.h().f(new a());
    }

    public static synchronized b d() {
        if (f27927b == null) {
            return f27926a;
        }
        return f27927b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static b e(o3.e eVar) {
        com.haier.library.sumhttp.a.a aVarA = com.haier.library.sumhttp.a.a.a(eVar.a());
        return aVarA != null ? new b(aVarA, eVar.b()) : f27926a;
    }
}
