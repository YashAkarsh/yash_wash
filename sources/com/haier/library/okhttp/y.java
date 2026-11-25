package com.haier.library.okhttp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class y {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Pattern f27897j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Pattern f27898k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Pattern f27899l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Pattern f27900m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f27901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f27902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f27903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f27904d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f27905e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f27906f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f27907g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f27908h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f27909i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        String f27910a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        String f27911b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        String f27913d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f27915f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f27916g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f27917h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f27918i;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f27912c = 253402300799999L;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        String f27914e = "/";

        private a d(String str, boolean z7) {
            if (str == null) {
                throw new NullPointerException("domain == null");
            }
            String strI = n.d.i(str);
            if (strI != null) {
                this.f27913d = strI;
                this.f27918i = z7;
                return this;
            }
            throw new IllegalArgumentException("unexpected domain: " + str);
        }

        public a a() {
            this.f27915f = true;
            return this;
        }

        public a b(long j7) {
            if (j7 <= 0) {
                j7 = Long.MIN_VALUE;
            }
            if (j7 > 253402300799999L) {
                j7 = 253402300799999L;
            }
            this.f27912c = j7;
            this.f27917h = true;
            return this;
        }

        public a c(String str) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (!str.trim().equals(str)) {
                throw new IllegalArgumentException("name is not trimmed");
            }
            this.f27910a = str;
            return this;
        }

        public a e() {
            this.f27916g = true;
            return this;
        }

        public a f(String str) {
            if (str == null) {
                throw new NullPointerException("value == null");
            }
            if (!str.trim().equals(str)) {
                throw new IllegalArgumentException("value is not trimmed");
            }
            this.f27911b = str;
            return this;
        }

        public a g(String str) {
            return d(str, false);
        }

        public y h() {
            return new y(this);
        }

        public a i(String str) {
            return d(str, true);
        }

        public a j(String str) {
            if (!str.startsWith("/")) {
                throw new IllegalArgumentException("path must start with '/'");
            }
            this.f27914e = str;
            return this;
        }
    }

    private y(String str, String str2, long j7, String str3, String str4, boolean z7, boolean z8, boolean z9, boolean z10) {
        this.f27901a = str;
        this.f27902b = str2;
        this.f27903c = j7;
        this.f27904d = str3;
        this.f27905e = str4;
        this.f27906f = z7;
        this.f27907g = z8;
        this.f27909i = z9;
        this.f27908h = z10;
    }

    private static int a(String str, int i7, int i8, boolean z7) {
        while (i7 < i8) {
            char cCharAt = str.charAt(i7);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || (cCharAt >= '0' && cCharAt <= '9') || ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == ':'))) == (!z7)) {
                return i7;
            }
            i7++;
        }
        return i8;
    }

    private static long b(String str) {
        try {
            long j7 = Long.parseLong(str);
            if (j7 <= 0) {
                return Long.MIN_VALUE;
            }
            return j7;
        } catch (NumberFormatException e8) {
            if (str.matches("-?\\d+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e8;
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0081  */
    private static long c(String str, int i7, int i8) {
        int iA = a(str, i7, i8, false);
        Matcher matcher = f27900m.matcher(str);
        int i9 = -1;
        int i10 = -1;
        int i11 = -1;
        int iIndexOf = -1;
        int i12 = -1;
        int i13 = -1;
        while (iA < i8) {
            int iA2 = a(str, iA + 1, i8, true);
            matcher.region(iA, iA2);
            if (i10 == -1 && matcher.usePattern(f27900m).matches()) {
                i10 = Integer.parseInt(matcher.group(1));
                i12 = Integer.parseInt(matcher.group(2));
                i13 = Integer.parseInt(matcher.group(3));
            } else if (i11 == -1 && matcher.usePattern(f27899l).matches()) {
                i11 = Integer.parseInt(matcher.group(1));
            } else if (iIndexOf == -1) {
                Pattern pattern = f27898k;
                if (matcher.usePattern(pattern).matches()) {
                    iIndexOf = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                } else if (i9 != -1 && matcher.usePattern(f27897j).matches()) {
                    i9 = Integer.parseInt(matcher.group(1));
                }
            } else if (i9 != -1) {
            }
            iA = a(str, iA2 + 1, i8, false);
        }
        if (i9 >= 70 && i9 <= 99) {
            i9 += 1900;
        }
        if (i9 >= 0 && i9 <= 69) {
            i9 += 2000;
        }
        if (i9 < 1601) {
            throw new IllegalArgumentException();
        }
        if (iIndexOf == -1) {
            throw new IllegalArgumentException();
        }
        if (i11 < 1 || i11 > 31) {
            throw new IllegalArgumentException();
        }
        if (i10 < 0 || i10 > 23) {
            throw new IllegalArgumentException();
        }
        if (i12 < 0 || i12 > 59) {
            throw new IllegalArgumentException();
        }
        if (i13 < 0 || i13 > 59) {
            throw new IllegalArgumentException();
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(n.d.f27701p);
        gregorianCalendar.setLenient(false);
        gregorianCalendar.set(1, i9);
        gregorianCalendar.set(2, iIndexOf - 1);
        gregorianCalendar.set(5, i11);
        gregorianCalendar.set(11, i10);
        gregorianCalendar.set(12, i12);
        gregorianCalendar.set(13, i13);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTimeInMillis();
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00c0 A[PHI: r0
      0x00c0: PHI (r0v16 long) = (r0v2 long), (r0v6 long) binds: [B:42:0x00be, B:53:0x00e1] A[DONT_GENERATE, DONT_INLINE]] */
    @Nullable
    static y d(long j7, h0 h0Var, String str) {
        long j8;
        y yVar;
        String str2;
        String strSubstring;
        int length = str.length();
        char c8 = ';';
        int iC = n.d.c(str, 0, length, ';');
        char c9 = '=';
        int iC2 = n.d.c(str, 0, iC, '=');
        if (iC2 == iC) {
            return null;
        }
        String strH = n.d.H(str, 0, iC2);
        if (strH.isEmpty() || n.d.C(strH) != -1) {
            return null;
        }
        String strH2 = n.d.H(str, iC2 + 1, iC);
        if (n.d.C(strH2) != -1) {
            return null;
        }
        int i7 = iC + 1;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        String strL = null;
        boolean z10 = true;
        long jB = -1;
        long jC = 253402300799999L;
        String str3 = null;
        while (i7 < length) {
            int iC3 = n.d.c(str, i7, length, c8);
            int iC4 = n.d.c(str, i7, iC3, c9);
            String strH3 = n.d.H(str, i7, iC4);
            String strH4 = iC4 < iC3 ? n.d.H(str, iC4 + 1, iC3) : "";
            if (strH3.equalsIgnoreCase("expires")) {
                try {
                    jC = c(strH4, 0, strH4.length());
                    z9 = true;
                } catch (NumberFormatException | IllegalArgumentException unused) {
                }
            } else if (strH3.equalsIgnoreCase("max-age")) {
                jB = b(strH4);
                z9 = true;
            } else if (strH3.equalsIgnoreCase("domain")) {
                strL = l(strH4);
                z10 = false;
            } else if (strH3.equalsIgnoreCase("path")) {
                str3 = strH4;
            } else if (strH3.equalsIgnoreCase("secure")) {
                z7 = true;
            } else if (strH3.equalsIgnoreCase("httponly")) {
                z8 = true;
            }
            i7 = iC3 + 1;
            c8 = ';';
            c9 = '=';
        }
        long j9 = Long.MIN_VALUE;
        if (jB == Long.MIN_VALUE) {
            j8 = j9;
        } else if (jB != -1) {
            j9 = j7 + (jB <= 9223372036854775L ? jB * 1000 : Long.MAX_VALUE);
            if (j9 < j7 || j9 > 253402300799999L) {
                j8 = 253402300799999L;
            } else {
                j8 = j9;
            }
        } else {
            j8 = jC;
        }
        String strF = h0Var.F();
        if (strL == null) {
            str2 = strF;
            yVar = null;
        } else {
            if (!j(strF, strL)) {
                return null;
            }
            yVar = null;
            str2 = strL;
        }
        if (strF.length() != str2.length() && com.haier.library.okhttp.b.k.a.a().b(str2) == null) {
            return yVar;
        }
        if (str3 == null || !str3.startsWith("/")) {
            String strI = h0Var.I();
            int iLastIndexOf = strI.lastIndexOf(47);
            strSubstring = iLastIndexOf != 0 ? strI.substring(0, iLastIndexOf) : "/";
        } else {
            strSubstring = str3;
        }
        return new y(strH, strH2, j8, str2, strSubstring, z7, z8, z10, z9);
    }

    @Nullable
    public static y e(h0 h0Var, String str) {
        return d(System.currentTimeMillis(), h0Var, str);
    }

    public static List<y> h(h0 h0Var, g0 g0Var) {
        List<String> listL = g0Var.l(com.google.common.net.c.f22173u0);
        int size = listL.size();
        ArrayList arrayList = null;
        for (int i7 = 0; i7 < size; i7++) {
            y yVarE = e(h0Var, listL.get(i7));
            if (yVarE != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(yVarE);
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    private static boolean j(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !n.d.I(str);
    }

    private static String l(String str) {
        if (str.endsWith(com.alibaba.android.arouter.utils.b.f12515h)) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(com.alibaba.android.arouter.utils.b.f12515h)) {
            str = str.substring(1);
        }
        String strI = n.d.i(str);
        if (strI != null) {
            return strI;
        }
        throw new IllegalArgumentException();
    }

    private static boolean m(h0 h0Var, String str) {
        String strI = h0Var.I();
        if (strI.equals(str)) {
            return true;
        }
        if (strI.startsWith(str)) {
            return str.endsWith("/") || strI.charAt(str.length()) == '/';
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return yVar.f27901a.equals(this.f27901a) && yVar.f27902b.equals(this.f27902b) && yVar.f27904d.equals(this.f27904d) && yVar.f27905e.equals(this.f27905e) && yVar.f27903c == this.f27903c && yVar.f27906f == this.f27906f && yVar.f27907g == this.f27907g && yVar.f27908h == this.f27908h && yVar.f27909i == this.f27909i;
    }

    public String f() {
        return this.f27901a;
    }

    String g(boolean z7) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f27901a);
        sb.append('=');
        sb.append(this.f27902b);
        if (this.f27908h) {
            if (this.f27903c == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(com.haier.library.okhttp.b.e.d.a(new Date(this.f27903c)));
            }
        }
        if (!this.f27909i) {
            sb.append("; domain=");
            if (z7) {
                sb.append(com.alibaba.android.arouter.utils.b.f12515h);
            }
            sb.append(this.f27904d);
        }
        sb.append("; path=");
        sb.append(this.f27905e);
        if (this.f27906f) {
            sb.append("; secure");
        }
        if (this.f27907g) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public int hashCode() {
        int iHashCode = (((((((527 + this.f27901a.hashCode()) * 31) + this.f27902b.hashCode()) * 31) + this.f27904d.hashCode()) * 31) + this.f27905e.hashCode()) * 31;
        long j7 = this.f27903c;
        return ((((((((iHashCode + ((int) (j7 ^ (j7 >>> 32)))) * 31) + (!this.f27906f ? 1 : 0)) * 31) + (!this.f27907g ? 1 : 0)) * 31) + (!this.f27908h ? 1 : 0)) * 31) + (!this.f27909i ? 1 : 0);
    }

    public boolean i(h0 h0Var) {
        if ((this.f27909i ? h0Var.F().equals(this.f27904d) : j(h0Var.F(), this.f27904d)) && m(h0Var, this.f27905e)) {
            return !this.f27906f || h0Var.w();
        }
        return false;
    }

    public String k() {
        return this.f27902b;
    }

    public boolean n() {
        return this.f27908h;
    }

    public long o() {
        return this.f27903c;
    }

    public boolean p() {
        return this.f27909i;
    }

    public String q() {
        return this.f27904d;
    }

    public String r() {
        return this.f27905e;
    }

    public boolean s() {
        return this.f27907g;
    }

    public boolean t() {
        return this.f27906f;
    }

    public String toString() {
        return g(false);
    }

    y(a aVar) {
        String str = aVar.f27910a;
        if (str != null) {
            String str2 = aVar.f27911b;
            if (str2 != null) {
                String str3 = aVar.f27913d;
                if (str3 != null) {
                    this.f27901a = str;
                    this.f27902b = str2;
                    this.f27903c = aVar.f27912c;
                    this.f27904d = str3;
                    this.f27905e = aVar.f27914e;
                    this.f27906f = aVar.f27915f;
                    this.f27907g = aVar.f27916g;
                    this.f27908h = aVar.f27917h;
                    this.f27909i = aVar.f27918i;
                    return;
                }
                throw new NullPointerException("builder.domain == null");
            }
            throw new NullPointerException("builder.value == null");
        }
        throw new NullPointerException("builder.name == null");
    }
}
