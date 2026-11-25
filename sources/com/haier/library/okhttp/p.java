package com.haier.library.okhttp;

import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final p f27769n = new a().a().i();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final p f27770o = new a().e().d(Integer.MAX_VALUE, TimeUnit.SECONDS).i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f27771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f27772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f27773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f27774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f27775e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f27776f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f27777g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f27778h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f27779i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f27780j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f27781k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f27782l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    String f27783m;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f27784a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f27785b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f27786c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f27787d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f27788e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f27789f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f27790g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f27791h;

        public a a() {
            this.f27784a = true;
            return this;
        }

        public a b(int i7, TimeUnit timeUnit) {
            if (i7 >= 0) {
                long seconds = timeUnit.toSeconds(i7);
                this.f27786c = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxAge < 0: " + i7);
        }

        public a c() {
            this.f27785b = true;
            return this;
        }

        public a d(int i7, TimeUnit timeUnit) {
            if (i7 >= 0) {
                long seconds = timeUnit.toSeconds(i7);
                this.f27787d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i7);
        }

        public a e() {
            this.f27789f = true;
            return this;
        }

        public a f(int i7, TimeUnit timeUnit) {
            if (i7 >= 0) {
                long seconds = timeUnit.toSeconds(i7);
                this.f27788e = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("minFresh < 0: " + i7);
        }

        public a g() {
            this.f27790g = true;
            return this;
        }

        public a h() {
            this.f27791h = true;
            return this;
        }

        public p i() {
            return new p(this);
        }
    }

    private p(boolean z7, boolean z8, int i7, int i8, boolean z9, boolean z10, boolean z11, int i9, int i10, boolean z12, boolean z13, boolean z14, @Nullable String str) {
        this.f27771a = z7;
        this.f27772b = z8;
        this.f27773c = i7;
        this.f27774d = i8;
        this.f27775e = z9;
        this.f27776f = z10;
        this.f27777g = z11;
        this.f27778h = i9;
        this.f27779i = i10;
        this.f27780j = z12;
        this.f27781k = z13;
        this.f27782l = z14;
        this.f27783m = str;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0041  */
    /* JADX WARN: Code duplicated, block: B:28:0x0099  */
    /* JADX WARN: Code duplicated, block: B:31:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:37:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:38:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:40:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:43:0x00da  */
    /* JADX WARN: Code duplicated, block: B:44:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:46:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:49:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:50:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:52:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:53:0x0104  */
    /* JADX WARN: Code duplicated, block: B:55:0x010c  */
    /* JADX WARN: Code duplicated, block: B:56:0x0112  */
    /* JADX WARN: Code duplicated, block: B:58:0x011b  */
    /* JADX WARN: Code duplicated, block: B:59:0x011e  */
    /* JADX WARN: Code duplicated, block: B:61:0x0126  */
    /* JADX WARN: Code duplicated, block: B:62:0x0129  */
    /* JADX WARN: Code duplicated, block: B:64:0x0131  */
    /* JADX WARN: Code duplicated, block: B:87:0x0133 A[SYNTHETIC] */
    public static p a(g0 g0Var) {
        int i7;
        int iC;
        String strTrim;
        int iC2;
        String strTrim2;
        int iA = g0Var.a();
        boolean z7 = true;
        String str = null;
        boolean z8 = false;
        boolean z9 = false;
        int iN = -1;
        int iN2 = -1;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        int iN3 = -1;
        int iN4 = -1;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        for (int i8 = 0; i8 < iA; i8++) {
            String strD = g0Var.d(i8);
            String strH = g0Var.h(i8);
            if (strD.equalsIgnoreCase(com.google.common.net.c.f22132a)) {
                if (str == null) {
                    str = strH;
                }
                for (i7 = 0; i7 < strH.length(); i7 = iC2) {
                    iC = com.haier.library.okhttp.b.e.e.c(strH, i7, "=,;");
                    strTrim = strH.substring(i7, iC).trim();
                    if (iC != strH.length() || strH.charAt(iC) == ',' || strH.charAt(iC) == ';') {
                        iC2 = iC + 1;
                        strTrim2 = null;
                    } else {
                        int iB = com.haier.library.okhttp.b.e.e.b(strH, iC + 1);
                        if (iB >= strH.length() || strH.charAt(iB) != '\"') {
                            iC2 = com.haier.library.okhttp.b.e.e.c(strH, iB, ",;");
                            strTrim2 = strH.substring(iB, iC2).trim();
                        } else {
                            int i9 = iB + 1;
                            int iC3 = com.haier.library.okhttp.b.e.e.c(strH, i9, "\"");
                            strTrim2 = strH.substring(i9, iC3);
                            iC2 = iC3 + 1;
                        }
                    }
                    if ("no-cache".equalsIgnoreCase(strTrim)) {
                        z8 = true;
                    } else if ("no-store".equalsIgnoreCase(strTrim)) {
                        z9 = true;
                    } else if ("max-age".equalsIgnoreCase(strTrim)) {
                        iN = com.haier.library.okhttp.b.e.e.n(strTrim2, -1);
                    } else if ("s-maxage".equalsIgnoreCase(strTrim)) {
                        iN2 = com.haier.library.okhttp.b.e.e.n(strTrim2, -1);
                    } else if ("private".equalsIgnoreCase(strTrim)) {
                        z10 = true;
                    } else if ("public".equalsIgnoreCase(strTrim)) {
                        z11 = true;
                    } else if ("must-revalidate".equalsIgnoreCase(strTrim)) {
                        z12 = true;
                    } else if ("max-stale".equalsIgnoreCase(strTrim)) {
                        iN3 = com.haier.library.okhttp.b.e.e.n(strTrim2, Integer.MAX_VALUE);
                    } else if ("min-fresh".equalsIgnoreCase(strTrim)) {
                        iN4 = com.haier.library.okhttp.b.e.e.n(strTrim2, -1);
                    } else if ("only-if-cached".equalsIgnoreCase(strTrim)) {
                        z13 = true;
                    } else if ("no-transform".equalsIgnoreCase(strTrim)) {
                        z14 = true;
                    } else if ("immutable".equalsIgnoreCase(strTrim)) {
                        z15 = true;
                    }
                }
            } else {
                if (strD.equalsIgnoreCase(com.google.common.net.c.f22140e)) {
                }
            }
            z7 = false;
            while (i7 < strH.length()) {
                iC = com.haier.library.okhttp.b.e.e.c(strH, i7, "=,;");
                strTrim = strH.substring(i7, iC).trim();
                if (iC != strH.length()) {
                    iC2 = iC + 1;
                    strTrim2 = null;
                } else {
                    iC2 = iC + 1;
                    strTrim2 = null;
                }
                if ("no-cache".equalsIgnoreCase(strTrim)) {
                    z8 = true;
                } else if ("no-store".equalsIgnoreCase(strTrim)) {
                    z9 = true;
                } else if ("max-age".equalsIgnoreCase(strTrim)) {
                    iN = com.haier.library.okhttp.b.e.e.n(strTrim2, -1);
                } else if ("s-maxage".equalsIgnoreCase(strTrim)) {
                    iN2 = com.haier.library.okhttp.b.e.e.n(strTrim2, -1);
                } else if ("private".equalsIgnoreCase(strTrim)) {
                    z10 = true;
                } else if ("public".equalsIgnoreCase(strTrim)) {
                    z11 = true;
                } else if ("must-revalidate".equalsIgnoreCase(strTrim)) {
                    z12 = true;
                } else if ("max-stale".equalsIgnoreCase(strTrim)) {
                    iN3 = com.haier.library.okhttp.b.e.e.n(strTrim2, Integer.MAX_VALUE);
                } else if ("min-fresh".equalsIgnoreCase(strTrim)) {
                    iN4 = com.haier.library.okhttp.b.e.e.n(strTrim2, -1);
                } else if ("only-if-cached".equalsIgnoreCase(strTrim)) {
                    z13 = true;
                } else if ("no-transform".equalsIgnoreCase(strTrim)) {
                    z14 = true;
                } else if ("immutable".equalsIgnoreCase(strTrim)) {
                    z15 = true;
                }
            }
        }
        return new p(z8, z9, iN, iN2, z10, z11, z12, iN3, iN4, z13, z14, z15, !z7 ? null : str);
    }

    private String n() {
        StringBuilder sb = new StringBuilder();
        if (this.f27771a) {
            sb.append("no-cache, ");
        }
        if (this.f27772b) {
            sb.append("no-store, ");
        }
        if (this.f27773c != -1) {
            sb.append("max-age=");
            sb.append(this.f27773c);
            sb.append(", ");
        }
        if (this.f27774d != -1) {
            sb.append("s-maxage=");
            sb.append(this.f27774d);
            sb.append(", ");
        }
        if (this.f27775e) {
            sb.append("private, ");
        }
        if (this.f27776f) {
            sb.append("public, ");
        }
        if (this.f27777g) {
            sb.append("must-revalidate, ");
        }
        if (this.f27778h != -1) {
            sb.append("max-stale=");
            sb.append(this.f27778h);
            sb.append(", ");
        }
        if (this.f27779i != -1) {
            sb.append("min-fresh=");
            sb.append(this.f27779i);
            sb.append(", ");
        }
        if (this.f27780j) {
            sb.append("only-if-cached, ");
        }
        if (this.f27781k) {
            sb.append("no-transform, ");
        }
        if (this.f27782l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public boolean b() {
        return this.f27771a;
    }

    public boolean c() {
        return this.f27772b;
    }

    public int d() {
        return this.f27773c;
    }

    public int e() {
        return this.f27774d;
    }

    public boolean f() {
        return this.f27775e;
    }

    public boolean g() {
        return this.f27776f;
    }

    public boolean h() {
        return this.f27777g;
    }

    public int i() {
        return this.f27778h;
    }

    public int j() {
        return this.f27779i;
    }

    public boolean k() {
        return this.f27780j;
    }

    public boolean l() {
        return this.f27781k;
    }

    public boolean m() {
        return this.f27782l;
    }

    public String toString() {
        String str = this.f27783m;
        if (str != null) {
            return str;
        }
        String strN = n();
        this.f27783m = strN;
        return strN;
    }

    p(a aVar) {
        this.f27771a = aVar.f27784a;
        this.f27772b = aVar.f27785b;
        this.f27773c = aVar.f27786c;
        this.f27774d = -1;
        this.f27775e = false;
        this.f27776f = false;
        this.f27777g = false;
        this.f27778h = aVar.f27787d;
        this.f27779i = aVar.f27788e;
        this.f27780j = aVar.f27789f;
        this.f27781k = aVar.f27790g;
        this.f27782l = aVar.f27791h;
    }
}
