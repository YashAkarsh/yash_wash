package com.haier.library.okhttp.api;

import android.os.Handler;
import android.os.Looper;
import com.haier.library.okhttp.e0;
import com.haier.library.okhttp.g0;
import com.haier.library.okhttp.h0;
import com.haier.library.okhttp.j0;
import com.haier.library.okhttp.k0;
import com.haier.library.okhttp.l0;
import com.haier.library.okhttp.q;
import com.haier.library.okhttp.r;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j0 f26917c = j0.d("application/json; charset=utf-8");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<String, e> f26918d = new WeakHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private l0 f26919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Handler f26920b;

    class a implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f26921a;

        a(b bVar) {
            this.f26921a = bVar;
        }

        @Override // com.haier.library.okhttp.r
        public void a(q qVar, IOException iOException) {
            e3.a.e("handRequest IOException<%s>", iOException.getMessage());
            e.this.y(null, iOException, this.f26921a);
        }

        @Override // com.haier.library.okhttp.r
        public void b(q qVar, com.haier.library.okhttp.a aVar) throws IOException {
            e3.a.e("handRequest onResponse<%s>", aVar);
            try {
                if (qVar.K()) {
                    e.this.y(aVar, new Exception("request canceled"), this.f26921a);
                    return;
                }
                if (aVar.Q()) {
                    b bVar = this.f26921a;
                    if (bVar == null) {
                        return;
                    }
                    e.this.z(aVar, bVar.parseNetworkResponse(aVar), this.f26921a);
                    return;
                }
                int iU = aVar.u();
                e.this.y(aVar, new Exception("request failed,error code is " + iU), this.f26921a);
            } catch (Exception e8) {
                e.this.y(aVar, e8, this.f26921a);
            }
        }
    }

    private e(long j7, TimeUnit timeUnit, boolean z7) {
        l0.b bVarW = new l0.b().w(j7, timeUnit);
        if (z7) {
            bVarW.h(new com.haier.library.okhttp.a.a());
        }
        this.f26919a = bVarW.G();
        this.f26920b = new Handler(Looper.getMainLooper());
    }

    private static String e(long j7, boolean z7) {
        return String.format(Locale.ENGLISH, "%d:%d", Long.valueOf(j7), Integer.valueOf(z7 ? 1 : 0));
    }

    public static e m(long j7, TimeUnit timeUnit) {
        return n(j7, timeUnit, true);
    }

    public static e n(long j7, TimeUnit timeUnit, boolean z7) {
        e eVar;
        String strE = e(timeUnit.toMillis(j7), z7);
        Map<String, e> map = f26918d;
        synchronized (map) {
            eVar = map.get(strE);
            if (eVar == null) {
                eVar = new e(j7, timeUnit, z7);
                map.put(strE, eVar);
            }
        }
        return eVar;
    }

    private com.haier.library.okhttp.a o(com.haier.library.okhttp.f fVar) {
        try {
            return this.f26919a.a(fVar).b();
        } catch (IOException e8) {
            e3.a.h("HttpDns exception<%s>", e8.toString());
            e8.printStackTrace();
            return null;
        }
    }

    private void p(b bVar, com.haier.library.okhttp.f fVar) {
        a aVar = new a(bVar);
        e3.a.e("handRequest <%s>", fVar.toString());
        this.f26919a.a(fVar).p0(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(final com.haier.library.okhttp.a aVar, final Exception exc, final b bVar) {
        if (bVar == null) {
            return;
        }
        this.f26920b.post(new Runnable() { // from class: com.haier.library.okhttp.api.c
            @Override // java.lang.Runnable
            public final void run() {
                bVar.onError(aVar, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final com.haier.library.okhttp.a aVar, final Object obj, final b bVar) {
        if (bVar == null) {
            return;
        }
        this.f26920b.post(new Runnable() { // from class: com.haier.library.okhttp.api.d
            @Override // java.lang.Runnable
            public final void run() {
                bVar.onResponse(aVar, obj);
            }
        });
    }

    public void f(String str, Map<String, String> map, Map<String, String> map2, b bVar) {
        com.haier.library.okhttp.f.a aVar = new com.haier.library.okhttp.f.a();
        aVar.h(str);
        if (map != null && !map.isEmpty()) {
            aVar.d(g0.b(map));
        }
        if (map2 != null) {
            e0.a aVar2 = new e0.a();
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                aVar2.a(entry.getKey(), entry.getValue());
            }
            aVar.m(aVar2.b());
        }
        p(bVar, aVar.s());
    }

    public void g(String str, Map<String, String> map, String str2, b bVar) {
        com.haier.library.okhttp.f.a aVar = new com.haier.library.okhttp.f.a();
        aVar.h(str);
        if (map != null && !map.isEmpty()) {
            aVar.d(g0.b(map));
        }
        if (str2 != null) {
            aVar.m(com.haier.library.okhttp.g.c(f26917c, str2));
        }
        p(bVar, aVar.s());
    }

    public File h(String str, String str2, String str3) throws Exception {
        com.haier.library.okhttp.a aVarB = this.f26919a.a(new com.haier.library.okhttp.f.a().h(str).s()).b();
        if (!aVarB.Q()) {
            return null;
        }
        File file = new File(str2, str3);
        InputStream inputStreamB = aVarB.b().b();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bArr = new byte[8192];
        while (true) {
            int i7 = inputStreamB.read(bArr);
            if (i7 == -1) {
                fileOutputStream.close();
                aVarB.b().close();
                return file;
            }
            fileOutputStream.write(bArr, 0, i7);
            fileOutputStream.flush();
        }
    }

    public void i(String str, Map<String, String> map, b bVar) {
        com.haier.library.okhttp.f.a aVar = new com.haier.library.okhttp.f.a();
        aVar.h(str);
        if (map != null && !map.isEmpty()) {
            aVar.d(g0.b(map));
        }
        p(bVar, aVar.s());
    }

    public l0 j() {
        return this.f26919a;
    }

    public Handler k() {
        return this.f26920b;
    }

    public com.haier.library.okhttp.a l(String str) {
        h0 h0VarS = new h0.a().e(j0.b.f34226a).A(com.haier.library.okhttp.a.b.f26903e).f("ws_domain", str).f("ws_ret_type", "json").s();
        e3.a.e("HttpDns httpUrl<%s>", h0VarS);
        return o(new com.haier.library.okhttp.f.a().e(h0VarS).a().s());
    }

    public void s(String str, Map<String, String> map, Map<String, String> map2, b bVar) {
        com.haier.library.okhttp.f.a aVar = new com.haier.library.okhttp.f.a();
        aVar.h(str);
        if (map != null && !map.isEmpty()) {
            aVar.d(g0.b(map));
        }
        if (map2 != null) {
            e0.a aVar2 = new e0.a();
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                aVar2.a(entry.getKey(), entry.getValue());
            }
            aVar.b(aVar2.b());
        }
        p(bVar, aVar.s());
    }

    public com.haier.library.okhttp.a t(String str, Map<String, String> map, String str2, File file, j0 j0Var) {
        com.haier.library.okhttp.f.a aVar = new com.haier.library.okhttp.f.a();
        aVar.h(str);
        if (map != null && !map.isEmpty()) {
            aVar.d(g0.b(map));
        }
        if (str2 != null) {
            aVar.b(new k0.a().c(k0.f27617j).f("file", file.getName(), com.haier.library.okhttp.g.b(j0Var, file)).e("fileInfo", str2).g());
        }
        return o(aVar.s());
    }

    public void u(String str, Map<String, String> map, String str2, b bVar) {
        com.haier.library.okhttp.f.a aVar = new com.haier.library.okhttp.f.a();
        aVar.h(str);
        if (map != null && !map.isEmpty()) {
            aVar.d(g0.b(map));
        }
        if (str2 != null) {
            aVar.b(com.haier.library.okhttp.g.c(f26917c, str2));
        }
        p(bVar, aVar.s());
    }

    public com.haier.library.okhttp.a v(String str, Map<String, String> map, byte[] bArr, j0 j0Var) {
        com.haier.library.okhttp.f.a aVar = new com.haier.library.okhttp.f.a();
        aVar.h(str);
        if (map != null && !map.isEmpty()) {
            aVar.d(g0.b(map));
        }
        if (bArr != null) {
            aVar.b(com.haier.library.okhttp.g.d(j0Var, bArr));
        }
        return o(aVar.s());
    }

    public void w(String str, Map<String, String> map, byte[] bArr, j0 j0Var, b bVar) {
        com.haier.library.okhttp.f.a aVar = new com.haier.library.okhttp.f.a();
        aVar.h(str);
        if (map != null && !map.isEmpty()) {
            aVar.d(g0.b(map));
        }
        if (bArr != null) {
            aVar.b(com.haier.library.okhttp.g.d(j0Var, bArr));
        }
        p(bVar, aVar.s());
    }

    public void x(String str, Map<String, String> map, byte[] bArr, j0 j0Var, r rVar) {
        com.haier.library.okhttp.f.a aVarH = new com.haier.library.okhttp.f.a().h(str);
        if (map != null && map.size() > 0) {
            aVarH.d(g0.b(map));
        }
        if (bArr == null || bArr.length == 0) {
            e3.a.h("Post proto buffer data empty!", new Object[0]);
        } else {
            this.f26919a.a(aVarH.b(com.haier.library.okhttp.g.d(j0Var, bArr)).s()).p0(rVar);
        }
    }
}
