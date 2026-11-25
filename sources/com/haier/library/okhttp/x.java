package com.haier.library.okhttp;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes2.dex */
public final class x {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final u[] f27883e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final u[] f27884f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final x f27885g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final x f27886h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final x f27887i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final x f27888j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f27889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final boolean f27890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    final String[] f27891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    final String[] f27892d;

    static {
        u uVar = u.f27844n1;
        u uVar2 = u.f27847o1;
        u uVar3 = u.f27850p1;
        u uVar4 = u.f27853q1;
        u uVar5 = u.f27856r1;
        u uVar6 = u.Z0;
        u uVar7 = u.f27814d1;
        u uVar8 = u.f27805a1;
        u uVar9 = u.f27817e1;
        u uVar10 = u.f27835k1;
        u uVar11 = u.f27832j1;
        u[] uVarArr = {uVar, uVar2, uVar3, uVar4, uVar5, uVar6, uVar7, uVar8, uVar9, uVar10, uVar11};
        f27883e = uVarArr;
        u[] uVarArr2 = {uVar, uVar2, uVar3, uVar4, uVar5, uVar6, uVar7, uVar8, uVar9, uVar10, uVar11, u.K0, u.L0, u.f27828i0, u.f27831j0, u.G, u.K, u.f27833k};
        f27884f = uVarArr2;
        a aVarD = new a(true).d(uVarArr);
        i iVar = i.TLS_1_3;
        i iVar2 = i.TLS_1_2;
        f27885g = aVarD.c(iVar, iVar2).b(true).h();
        a aVarD2 = new a(true).d(uVarArr2);
        i iVar3 = i.TLS_1_0;
        f27886h = aVarD2.c(iVar, iVar2, i.TLS_1_1, iVar3).b(true).h();
        f27887i = new a(true).d(uVarArr2).c(iVar3).b(true).h();
        f27888j = new a(false).h();
    }

    x(a aVar) {
        this.f27889a = aVar.f27893a;
        this.f27891c = aVar.f27894b;
        this.f27892d = aVar.f27895c;
        this.f27890b = aVar.f27896d;
    }

    private x d(SSLSocket sSLSocket, boolean z7) {
        String[] strArrA = this.f27891c != null ? n.d.A(u.f27806b, sSLSocket.getEnabledCipherSuites(), this.f27891c) : sSLSocket.getEnabledCipherSuites();
        String[] strArrA2 = this.f27892d != null ? n.d.A(n.d.f27702q, sSLSocket.getEnabledProtocols(), this.f27892d) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int iF = n.d.f(u.f27806b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z7 && iF != -1) {
            strArrA = n.d.B(strArrA, supportedCipherSuites[iF]);
        }
        return new a(this).e(strArrA).g(strArrA2).h();
    }

    void a(SSLSocket sSLSocket, boolean z7) {
        x xVarD = d(sSLSocket, z7);
        String[] strArr = xVarD.f27892d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = xVarD.f27891c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public boolean b() {
        return this.f27889a;
    }

    public boolean c(SSLSocket sSLSocket) {
        if (!this.f27889a) {
            return false;
        }
        String[] strArr = this.f27892d;
        if (strArr != null && !n.d.G(n.d.f27702q, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f27891c;
        return strArr2 == null || n.d.G(u.f27806b, strArr2, sSLSocket.getEnabledCipherSuites());
    }

    @Nullable
    public List<u> e() {
        String[] strArr = this.f27891c;
        if (strArr != null) {
            return u.d(strArr);
        }
        return null;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof x)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        x xVar = (x) obj;
        boolean z7 = this.f27889a;
        if (z7 != xVar.f27889a) {
            return false;
        }
        return !z7 || (Arrays.equals(this.f27891c, xVar.f27891c) && Arrays.equals(this.f27892d, xVar.f27892d) && this.f27890b == xVar.f27890b);
    }

    @Nullable
    public List<i> f() {
        String[] strArr = this.f27892d;
        if (strArr != null) {
            return i.c(strArr);
        }
        return null;
    }

    public boolean g() {
        return this.f27890b;
    }

    public int hashCode() {
        if (this.f27889a) {
            return ((((527 + Arrays.hashCode(this.f27891c)) * 31) + Arrays.hashCode(this.f27892d)) * 31) + (!this.f27890b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f27889a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.f27891c != null ? e().toString() : "[all enabled]") + ", tlsVersions=" + (this.f27892d != null ? f().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.f27890b + ")";
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f27893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        String[] f27894b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        String[] f27895c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f27896d;

        a(boolean z7) {
            this.f27893a = z7;
        }

        public a a() {
            if (!this.f27893a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            this.f27894b = null;
            return this;
        }

        public a b(boolean z7) {
            if (!this.f27893a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.f27896d = z7;
            return this;
        }

        public a c(i... iVarArr) {
            if (!this.f27893a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[iVarArr.length];
            for (int i7 = 0; i7 < iVarArr.length; i7++) {
                strArr[i7] = iVarArr[i7].f27604a;
            }
            return g(strArr);
        }

        public a d(u... uVarArr) {
            if (!this.f27893a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[uVarArr.length];
            for (int i7 = 0; i7 < uVarArr.length; i7++) {
                strArr[i7] = uVarArr[i7].f27873a;
            }
            return e(strArr);
        }

        public a e(String... strArr) {
            if (!this.f27893a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.f27894b = (String[]) strArr.clone();
            return this;
        }

        public a f() {
            if (!this.f27893a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            this.f27895c = null;
            return this;
        }

        public a g(String... strArr) {
            if (!this.f27893a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.f27895c = (String[]) strArr.clone();
            return this;
        }

        public x h() {
            return new x(this);
        }

        public a(x xVar) {
            this.f27893a = xVar.f27889a;
            this.f27894b = xVar.f27891c;
            this.f27895c = xVar.f27892d;
            this.f27896d = xVar.f27890b;
        }
    }
}
