package androidx.core.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final n0 f6219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final char f6220e = 8234;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final char f6221f = 8235;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final char f6222g = 8236;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final char f6223h = 8206;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final char f6224i = 8207;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f6225j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f6226k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f6227l = "";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f6228m = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f6229n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final a f6230o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final a f6231p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f6232q = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int f6233r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f6234s = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f6235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f6236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final n0 f6237c;

    private static class b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final int f6241f = 1792;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final byte[] f6242g = new byte[f6241f];

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CharSequence f6243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f6244b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f6245c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f6246d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private char f6247e;

        static {
            for (int i7 = 0; i7 < f6241f; i7++) {
                f6242g[i7] = Character.getDirectionality(i7);
            }
        }

        b(CharSequence charSequence, boolean z7) {
            this.f6243a = charSequence;
            this.f6244b = z7;
            this.f6245c = charSequence.length();
        }

        private static byte c(char c8) {
            return c8 < f6241f ? f6242g[c8] : Character.getDirectionality(c8);
        }

        private byte f() {
            char cCharAt;
            int i7 = this.f6246d;
            do {
                int i8 = this.f6246d;
                if (i8 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f6243a;
                int i9 = i8 - 1;
                this.f6246d = i9;
                cCharAt = charSequence.charAt(i9);
                this.f6247e = cCharAt;
                if (cCharAt == '&') {
                    return com.google.common.base.c.f19314n;
                }
            } while (cCharAt != ';');
            this.f6246d = i7;
            this.f6247e = ';';
            return com.google.common.base.c.f19315o;
        }

        private byte g() {
            char cCharAt;
            do {
                int i7 = this.f6246d;
                if (i7 >= this.f6245c) {
                    return com.google.common.base.c.f19314n;
                }
                CharSequence charSequence = this.f6243a;
                this.f6246d = i7 + 1;
                cCharAt = charSequence.charAt(i7);
                this.f6247e = cCharAt;
            } while (cCharAt != ';');
            return com.google.common.base.c.f19314n;
        }

        private byte h() {
            char cCharAt;
            int i7 = this.f6246d;
            while (true) {
                int i8 = this.f6246d;
                if (i8 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f6243a;
                int i9 = i8 - 1;
                this.f6246d = i9;
                char cCharAt2 = charSequence.charAt(i9);
                this.f6247e = cCharAt2;
                if (cCharAt2 == '<') {
                    return com.google.common.base.c.f19314n;
                }
                if (cCharAt2 == '>') {
                    break;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i10 = this.f6246d;
                        if (i10 <= 0) {
                            break;
                        }
                        CharSequence charSequence2 = this.f6243a;
                        int i11 = i10 - 1;
                        this.f6246d = i11;
                        cCharAt = charSequence2.charAt(i11);
                        this.f6247e = cCharAt;
                    } while (cCharAt != cCharAt2);
                }
            }
            this.f6246d = i7;
            this.f6247e = kotlin.text.h0.f35380f;
            return com.google.common.base.c.f19315o;
        }

        private byte i() {
            char cCharAt;
            int i7 = this.f6246d;
            while (true) {
                int i8 = this.f6246d;
                if (i8 >= this.f6245c) {
                    this.f6246d = i7;
                    this.f6247e = kotlin.text.h0.f35379e;
                    return com.google.common.base.c.f19315o;
                }
                CharSequence charSequence = this.f6243a;
                this.f6246d = i8 + 1;
                char cCharAt2 = charSequence.charAt(i8);
                this.f6247e = cCharAt2;
                if (cCharAt2 == '>') {
                    return com.google.common.base.c.f19314n;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i9 = this.f6246d;
                        if (i9 >= this.f6245c) {
                            break;
                        }
                        CharSequence charSequence2 = this.f6243a;
                        this.f6246d = i9 + 1;
                        cCharAt = charSequence2.charAt(i9);
                        this.f6247e = cCharAt;
                    } while (cCharAt != cCharAt2);
                }
            }
        }

        byte a() {
            char cCharAt = this.f6243a.charAt(this.f6246d - 1);
            this.f6247e = cCharAt;
            if (Character.isLowSurrogate(cCharAt)) {
                int iCodePointBefore = Character.codePointBefore(this.f6243a, this.f6246d);
                this.f6246d -= Character.charCount(iCodePointBefore);
                return Character.getDirectionality(iCodePointBefore);
            }
            this.f6246d--;
            byte bC = c(this.f6247e);
            if (!this.f6244b) {
                return bC;
            }
            char c8 = this.f6247e;
            if (c8 == '>') {
                return h();
            }
            return c8 == ';' ? f() : bC;
        }

        byte b() {
            char cCharAt = this.f6243a.charAt(this.f6246d);
            this.f6247e = cCharAt;
            if (Character.isHighSurrogate(cCharAt)) {
                int iCodePointAt = Character.codePointAt(this.f6243a, this.f6246d);
                this.f6246d += Character.charCount(iCodePointAt);
                return Character.getDirectionality(iCodePointAt);
            }
            this.f6246d++;
            byte bC = c(this.f6247e);
            if (!this.f6244b) {
                return bC;
            }
            char c8 = this.f6247e;
            if (c8 == '<') {
                return i();
            }
            return c8 == '&' ? g() : bC;
        }

        int d() {
            this.f6246d = 0;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (this.f6246d < this.f6245c && i7 == 0) {
                byte b8 = b();
                if (b8 != 0) {
                    if (b8 == 1 || b8 == 2) {
                        if (i9 == 0) {
                            return 1;
                        }
                    } else if (b8 != 9) {
                        switch (b8) {
                            case 14:
                            case 15:
                                i9++;
                                i8 = -1;
                                continue;
                            case 16:
                            case 17:
                                i9++;
                                i8 = 1;
                                continue;
                            case 18:
                                i9--;
                                i8 = 0;
                                continue;
                        }
                    }
                } else if (i9 == 0) {
                    return -1;
                }
                i7 = i9;
            }
            if (i7 == 0) {
                return 0;
            }
            if (i8 != 0) {
                return i8;
            }
            while (this.f6246d > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i7 == i9) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i7 == i9) {
                            return 1;
                        }
                        break;
                    case 18:
                        i9++;
                        continue;
                    default:
                        continue;
                }
                i9--;
            }
            return 0;
        }

        int e() {
            this.f6246d = this.f6245c;
            int i7 = 0;
            while (true) {
                int i8 = i7;
                while (this.f6246d > 0) {
                    byte bA = a();
                    if (bA == 0) {
                        if (i7 == 0) {
                            return -1;
                        }
                        if (i8 == 0) {
                        }
                    } else if (bA == 1 || bA == 2) {
                        if (i7 == 0) {
                            return 1;
                        }
                        if (i8 == 0) {
                        }
                    } else if (bA != 9) {
                        switch (bA) {
                            case 14:
                            case 15:
                                if (i8 == i7) {
                                    return -1;
                                }
                                i7--;
                                break;
                            case 16:
                            case 17:
                                if (i8 == i7) {
                                    return 1;
                                }
                                i7--;
                                break;
                            case 18:
                                i7++;
                                break;
                            default:
                                if (i8 != 0) {
                                }
                                break;
                        }
                    } else {
                        continue;
                    }
                }
                return 0;
            }
        }
    }

    static {
        n0 n0Var = o0.f6282c;
        f6219d = n0Var;
        f6225j = Character.toString(f6223h);
        f6226k = Character.toString(f6224i);
        f6230o = new a(false, 2, n0Var);
        f6231p = new a(true, 2, n0Var);
    }

    a(boolean z7, int i7, n0 n0Var) {
        this.f6235a = z7;
        this.f6236b = i7;
        this.f6237c = n0Var;
    }

    private static int a(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    private static int b(CharSequence charSequence) {
        return new b(charSequence, false).e();
    }

    public static a c() {
        return new C0072a().a();
    }

    public static a d(Locale locale) {
        return new C0072a(locale).a();
    }

    public static a e(boolean z7) {
        return new C0072a(z7).a();
    }

    static boolean j(Locale locale) {
        return p0.b(locale) == 1;
    }

    private String k(CharSequence charSequence, n0 n0Var) {
        boolean zB = n0Var.b(charSequence, 0, charSequence.length());
        if (!this.f6235a && (zB || b(charSequence) == 1)) {
            return f6225j;
        }
        if (this.f6235a) {
            return (!zB || b(charSequence) == -1) ? f6226k : "";
        }
        return "";
    }

    private String l(CharSequence charSequence, n0 n0Var) {
        boolean zB = n0Var.b(charSequence, 0, charSequence.length());
        if (!this.f6235a && (zB || a(charSequence) == 1)) {
            return f6225j;
        }
        if (this.f6235a) {
            return (!zB || a(charSequence) == -1) ? f6226k : "";
        }
        return "";
    }

    public boolean f() {
        return (this.f6236b & 2) != 0;
    }

    public boolean g(CharSequence charSequence) {
        return this.f6237c.b(charSequence, 0, charSequence.length());
    }

    public boolean h(String str) {
        return g(str);
    }

    public boolean i() {
        return this.f6235a;
    }

    public CharSequence m(CharSequence charSequence) {
        return o(charSequence, this.f6237c, true);
    }

    public CharSequence n(CharSequence charSequence, n0 n0Var) {
        return o(charSequence, n0Var, true);
    }

    public CharSequence o(CharSequence charSequence, n0 n0Var, boolean z7) {
        if (charSequence == null) {
            return null;
        }
        boolean zB = n0Var.b(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (f() && z7) {
            spannableStringBuilder.append((CharSequence) l(charSequence, zB ? o0.f6281b : o0.f6280a));
        }
        if (zB != this.f6235a) {
            spannableStringBuilder.append(zB ? f6221f : f6220e);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append(f6222g);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z7) {
            spannableStringBuilder.append((CharSequence) k(charSequence, zB ? o0.f6281b : o0.f6280a));
        }
        return spannableStringBuilder;
    }

    public CharSequence p(CharSequence charSequence, boolean z7) {
        return o(charSequence, this.f6237c, z7);
    }

    public String q(String str) {
        return s(str, this.f6237c, true);
    }

    public String r(String str, n0 n0Var) {
        return s(str, n0Var, true);
    }

    public String s(String str, n0 n0Var, boolean z7) {
        if (str == null) {
            return null;
        }
        return o(str, n0Var, z7).toString();
    }

    public String t(String str, boolean z7) {
        return s(str, this.f6237c, z7);
    }

    /* JADX INFO: renamed from: androidx.core.text.a$a, reason: collision with other inner class name */
    public static final class C0072a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f6238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f6239b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private n0 f6240c;

        public C0072a() {
            c(a.j(Locale.getDefault()));
        }

        private static a b(boolean z7) {
            return z7 ? a.f6231p : a.f6230o;
        }

        private void c(boolean z7) {
            this.f6238a = z7;
            this.f6240c = a.f6219d;
            this.f6239b = 2;
        }

        public a a() {
            return (this.f6239b == 2 && this.f6240c == a.f6219d) ? b(this.f6238a) : new a(this.f6238a, this.f6239b, this.f6240c);
        }

        public C0072a d(n0 n0Var) {
            this.f6240c = n0Var;
            return this;
        }

        public C0072a e(boolean z7) {
            if (z7) {
                this.f6239b |= 2;
            } else {
                this.f6239b &= -3;
            }
            return this;
        }

        public C0072a(boolean z7) {
            c(z7);
        }

        public C0072a(Locale locale) {
            c(a.j(locale));
        }
    }
}
