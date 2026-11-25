package com.haier.library.okhttp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class k0 extends g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final j0 f27613f = j0.a("multipart/mixed");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final j0 f27614g = j0.a("multipart/alternative");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final j0 f27615h = j0.a("multipart/digest");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final j0 f27616i = j0.a("multipart/parallel");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final j0 f27617j = j0.a("multipart/form-data");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final byte[] f27618k = {58, 32};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final byte[] f27619l = {com.google.common.base.c.f19315o, 10};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final byte[] f27620m = {45, 45};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.haier.library.a.j f27621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j0 f27622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j0 f27623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<b> f27624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f27625e = -1;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.haier.library.a.j f27626a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private j0 f27627b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<b> f27628c;

        public a() {
            this(UUID.randomUUID().toString());
        }

        public a a(g gVar) {
            return d(b.b(gVar));
        }

        public a b(@Nullable g0 g0Var, g gVar) {
            return d(b.c(g0Var, gVar));
        }

        public a c(j0 j0Var) {
            if (j0Var == null) {
                throw new NullPointerException("type == null");
            }
            if (j0Var.b().equals("multipart")) {
                this.f27627b = j0Var;
                return this;
            }
            throw new IllegalArgumentException("multipart != " + j0Var);
        }

        public a d(b bVar) {
            if (bVar == null) {
                throw new NullPointerException("part == null");
            }
            this.f27628c.add(bVar);
            return this;
        }

        public a e(String str, String str2) {
            return d(b.d(str, str2));
        }

        public a f(String str, @Nullable String str2, g gVar) {
            return d(b.e(str, str2, gVar));
        }

        public k0 g() {
            if (this.f27628c.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new k0(this.f27626a, this.f27627b, this.f27628c);
        }

        public a(String str) {
            this.f27627b = k0.f27613f;
            this.f27628c = new ArrayList();
            this.f27626a = com.haier.library.a.j.i(str);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        final g0 f27629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final g f27630b;

        private b(@Nullable g0 g0Var, g gVar) {
            this.f27629a = g0Var;
            this.f27630b = gVar;
        }

        public static b b(g gVar) {
            return c(null, gVar);
        }

        public static b c(@Nullable g0 g0Var, g gVar) {
            if (gVar == null) {
                throw new NullPointerException("body == null");
            }
            if (g0Var != null && g0Var.e("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (g0Var == null || g0Var.e(com.google.common.net.c.f22134b) == null) {
                return new b(g0Var, gVar);
            }
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        }

        public static b d(String str, String str2) {
            return e(str, null, g.c(null, str2));
        }

        public static b e(String str, @Nullable String str2, g gVar) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            StringBuilder sb = new StringBuilder("form-data; name=");
            k0.l(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                k0.l(sb, str2);
            }
            return c(new g0.a().g("Content-Disposition", sb.toString()).e(), gVar);
        }

        @Nullable
        public g0 a() {
            return this.f27629a;
        }

        public g f() {
            return this.f27630b;
        }
    }

    k0(com.haier.library.a.j jVar, j0 j0Var, List<b> list) {
        this.f27621a = jVar;
        this.f27622b = j0Var;
        this.f27623c = j0.a(j0Var + "; boundary=" + jVar.o());
        this.f27624d = n.d.m(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long i(@Nullable com.haier.library.a.h hVar, boolean z7) throws IOException {
        com.haier.library.a.g gVar;
        if (z7) {
            hVar = new com.haier.library.a.g();
            gVar = hVar;
        } else {
            gVar = 0;
        }
        int size = this.f27624d.size();
        long j7 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            b bVar = this.f27624d.get(i7);
            g0 g0Var = bVar.f27629a;
            g gVar2 = bVar.f27630b;
            hVar.K1(f27620m);
            hVar.B(this.f27621a);
            hVar.K1(f27619l);
            if (g0Var != null) {
                int iA = g0Var.a();
                for (int i8 = 0; i8 < iA; i8++) {
                    hVar.b(g0Var.d(i8)).K1(f27618k).b(g0Var.h(i8)).K1(f27619l);
                }
            }
            j0 j0VarG = gVar2.g();
            if (j0VarG != null) {
                hVar.b("Content-Type: ").b(j0VarG.toString()).K1(f27619l);
            }
            long jH = gVar2.h();
            if (jH != -1) {
                hVar.b("Content-Length: ").n(jH).K1(f27619l);
            } else if (z7) {
                gVar.h2();
                return -1L;
            }
            byte[] bArr = f27619l;
            hVar.K1(bArr);
            if (z7) {
                j7 += jH;
            } else {
                gVar2.f(hVar);
            }
            hVar.K1(bArr);
        }
        byte[] bArr2 = f27620m;
        hVar.K1(bArr2);
        hVar.B(this.f27621a);
        hVar.K1(bArr2);
        hVar.K1(f27619l);
        if (!z7) {
            return j7;
        }
        long jY0 = j7 + gVar.Y0();
        gVar.h2();
        return jY0;
    }

    static StringBuilder l(StringBuilder sb, String str) {
        sb.append(kotlin.text.h0.f35376b);
        int length = str.length();
        for (int i7 = 0; i7 < length; i7++) {
            char cCharAt = str.charAt(i7);
            if (cCharAt == '\n') {
                sb.append("%0A");
            } else if (cCharAt == '\r') {
                sb.append("%0D");
            } else if (cCharAt != '\"') {
                sb.append(cCharAt);
            } else {
                sb.append("%22");
            }
        }
        sb.append(kotlin.text.h0.f35376b);
        return sb;
    }

    @Override // com.haier.library.okhttp.g
    public void f(com.haier.library.a.h hVar) throws IOException {
        i(hVar, false);
    }

    @Override // com.haier.library.okhttp.g
    public j0 g() {
        return this.f27623c;
    }

    @Override // com.haier.library.okhttp.g
    public long h() throws IOException {
        long j7 = this.f27625e;
        if (j7 != -1) {
            return j7;
        }
        long jI = i(null, true);
        this.f27625e = jI;
        return jI;
    }

    public j0 j() {
        return this.f27622b;
    }

    public b k(int i7) {
        return this.f27624d.get(i7);
    }

    public String m() {
        return this.f27621a.o();
    }

    public int n() {
        return this.f27624d.size();
    }

    public List<b> o() {
        return this.f27624d;
    }
}
