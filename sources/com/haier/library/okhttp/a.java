package com.haier.library.okhttp;

import java.io.Closeable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final f f26876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final d f26877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f26878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final String f26879d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    final f0 f26880e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final g0 f26881f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    final b f26882g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    final a f26883h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    final a f26884i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    final a f26885j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final long f26886k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final long f26887l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private volatile p f26888m;

    a(C0352a c0352a) {
        this.f26876a = c0352a.f26889a;
        this.f26877b = c0352a.f26890b;
        this.f26878c = c0352a.f26891c;
        this.f26879d = c0352a.f26892d;
        this.f26880e = c0352a.f26893e;
        this.f26881f = c0352a.f26894f.e();
        this.f26882g = c0352a.f26895g;
        this.f26883h = c0352a.f26896h;
        this.f26884i = c0352a.f26897i;
        this.f26885j = c0352a.f26898j;
        this.f26886k = c0352a.f26899k;
        this.f26887l = c0352a.f26900l;
    }

    @Nullable
    public f0 C() {
        return this.f26880e;
    }

    @Nullable
    public String E(String str) {
        return F(str, null);
    }

    @Nullable
    public String F(String str, @Nullable String str2) {
        String strE = this.f26881f.e(str);
        return strE != null ? strE : str2;
    }

    public g0 G() {
        return this.f26881f;
    }

    public List<String> H(String str) {
        return this.f26881f.l(str);
    }

    public boolean K() {
        int i7 = this.f26878c;
        if (i7 == 307 || i7 == 308) {
            return true;
        }
        switch (i7) {
            case 300:
            case 301:
            case 302:
            case 303:
                return true;
            default:
                return false;
        }
    }

    public boolean Q() {
        int i7 = this.f26878c;
        return i7 >= 200 && i7 < 300;
    }

    @Nullable
    public b b() {
        return this.f26882g;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        b bVar = this.f26882g;
        if (bVar == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        bVar.close();
    }

    public p e() {
        p pVar = this.f26888m;
        if (pVar != null) {
            return pVar;
        }
        p pVarA = p.a(this.f26881f);
        this.f26888m = pVarA;
        return pVarA;
    }

    public String g0() {
        return this.f26879d;
    }

    @Nullable
    public a h0() {
        return this.f26883h;
    }

    public C0352a l0() {
        return new C0352a(this);
    }

    public b o0(long j7) throws IOException {
        com.haier.library.a.i iVarK = this.f26882g.K();
        iVarK.b(j7);
        com.haier.library.a.g gVarClone = iVarK.c().clone();
        if (gVarClone.Y0() > j7) {
            com.haier.library.a.g gVar = new com.haier.library.a.g();
            gVar.I1(gVarClone, j7);
            gVarClone.h2();
            gVarClone = gVar;
        }
        return b.E(this.f26882g.C(), gVarClone.Y0(), gVarClone);
    }

    @Nullable
    public a p0() {
        return this.f26885j;
    }

    @Nullable
    public a q() {
        return this.f26884i;
    }

    public List<t> r() {
        String str;
        int i7 = this.f26878c;
        if (i7 == 401) {
            str = com.google.common.net.c.B0;
        } else {
            if (i7 != 407) {
                return Collections.emptyList();
            }
            str = com.google.common.net.c.f22161o0;
        }
        return com.haier.library.okhttp.b.e.e.i(G(), str);
    }

    public d r0() {
        return this.f26877b;
    }

    public long s0() {
        return this.f26887l;
    }

    public String toString() {
        return "Response{protocol=" + this.f26877b + ", code=" + this.f26878c + ", message=" + this.f26879d + ", url=" + this.f26876a.a() + '}';
    }

    public int u() {
        return this.f26878c;
    }

    public f v0() {
        return this.f26876a;
    }

    public long x0() {
        return this.f26886k;
    }

    /* JADX INFO: renamed from: com.haier.library.okhttp.a$a, reason: collision with other inner class name */
    public static class C0352a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        f f26889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        d f26890b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f26891c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f26892d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        f0 f26893e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        g0.a f26894f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        b f26895g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        a f26896h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        a f26897i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Nullable
        a f26898j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        long f26899k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        long f26900l;

        public C0352a() {
            this.f26891c = -1;
            this.f26894f = new g0.a();
        }

        private void l(String str, a aVar) {
            if (aVar.f26882g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (aVar.f26883h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (aVar.f26884i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (aVar.f26885j == null) {
                return;
            }
            throw new IllegalArgumentException(str + ".priorResponse != null");
        }

        private void r(a aVar) {
            if (aVar.f26882g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public C0352a a(int i7) {
            this.f26891c = i7;
            return this;
        }

        public C0352a b(long j7) {
            this.f26899k = j7;
            return this;
        }

        public C0352a c(@Nullable a aVar) {
            if (aVar != null) {
                l("networkResponse", aVar);
            }
            this.f26896h = aVar;
            return this;
        }

        public C0352a d(@Nullable b bVar) {
            this.f26895g = bVar;
            return this;
        }

        public C0352a e(d dVar) {
            this.f26890b = dVar;
            return this;
        }

        public C0352a f(f fVar) {
            this.f26889a = fVar;
            return this;
        }

        public C0352a g(@Nullable f0 f0Var) {
            this.f26893e = f0Var;
            return this;
        }

        public C0352a h(g0 g0Var) {
            this.f26894f = g0Var.m();
            return this;
        }

        public C0352a i(String str) {
            this.f26892d = str;
            return this;
        }

        public C0352a j(String str, String str2) {
            this.f26894f.k(str, str2);
            return this;
        }

        public a k() {
            if (this.f26889a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.f26890b == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.f26891c >= 0) {
                if (this.f26892d != null) {
                    return new a(this);
                }
                throw new IllegalStateException("message == null");
            }
            throw new IllegalStateException("code < 0: " + this.f26891c);
        }

        public C0352a m(long j7) {
            this.f26900l = j7;
            return this;
        }

        public C0352a n(@Nullable a aVar) {
            if (aVar != null) {
                l("cacheResponse", aVar);
            }
            this.f26897i = aVar;
            return this;
        }

        public C0352a o(String str) {
            this.f26894f.i(str);
            return this;
        }

        public C0352a p(String str, String str2) {
            this.f26894f.c(str, str2);
            return this;
        }

        public C0352a q(@Nullable a aVar) {
            if (aVar != null) {
                r(aVar);
            }
            this.f26898j = aVar;
            return this;
        }

        C0352a(a aVar) {
            this.f26891c = -1;
            this.f26889a = aVar.f26876a;
            this.f26890b = aVar.f26877b;
            this.f26891c = aVar.f26878c;
            this.f26892d = aVar.f26879d;
            this.f26893e = aVar.f26880e;
            this.f26894f = aVar.f26881f.m();
            this.f26895g = aVar.f26882g;
            this.f26896h = aVar.f26883h;
            this.f26897i = aVar.f26884i;
            this.f26898j = aVar.f26885j;
            this.f26899k = aVar.f26886k;
            this.f26900l = aVar.f26887l;
        }
    }
}
