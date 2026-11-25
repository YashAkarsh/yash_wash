package com.haier.library.okhttp;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class h0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final char[] f27568j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final String f27569k = " \"':;<=>@[]^`{}|/\\?#";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final String f27570l = " \"':;<=>@[]^`{}|/\\?#";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final String f27571m = " \"<>^`{}|/\\?#";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final String f27572n = "[]";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final String f27573o = " \"'<>#";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final String f27574p = " \"'<>#&=";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    static final String f27575q = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    static final String f27576r = "\\^`{|}";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    static final String f27577s = " \"':;<=>@[]^`{}|/\\?#&!$(),~";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    static final String f27578t = "";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    static final String f27579u = " \"#<>\\^`{|}";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f27580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f27581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f27582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final String f27583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f27584e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<String> f27585f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private final List<String> f27586g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private final String f27587h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f27588i;

    public static final class a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        static final String f27589i = "Invalid URL host";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        String f27590a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        String f27593d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final List<String> f27595f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        List<String> f27596g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        String f27597h;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f27591b = "";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f27592c = "";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f27594e = -1;

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f27595f = arrayList;
            arrayList.add("");
        }

        private void M(String str) {
            for (int size = this.f27596g.size() - 2; size >= 0; size -= 2) {
                if (str.equals(this.f27596g.get(size))) {
                    this.f27596g.remove(size + 1);
                    this.f27596g.remove(size);
                    if (this.f27596g.isEmpty()) {
                        this.f27596g = null;
                        return;
                    }
                }
            }
        }

        private boolean N(String str) {
            return str.equals(com.alibaba.android.arouter.utils.b.f12515h) || str.equalsIgnoreCase("%2e");
        }

        private boolean O(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private a g(String str, boolean z7) {
            int i7 = 0;
            do {
                int iD = n.d.d(str, i7, str.length(), "/\\");
                i(str, i7, iD, iD < str.length(), z7);
                i7 = iD + 1;
            } while (i7 <= str.length());
            return this;
        }

        private void h(String str, int i7, int i8) {
            if (i7 == i8) {
                return;
            }
            char cCharAt = str.charAt(i7);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.f27595f.clear();
                this.f27595f.add("");
                i7++;
            } else {
                List<String> list = this.f27595f;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i9 = i7;
                if (i9 >= i8) {
                    return;
                }
                i7 = n.d.d(str, i9, i8, "/\\");
                boolean z7 = i7 < i8;
                i(str, i9, i7, z7, true);
                if (z7) {
                    i7++;
                }
            }
        }

        private void i(String str, int i7, int i8, boolean z7, boolean z8) {
            String strE = h0.e(str, i7, i8, " \"<>^`{}|/\\?#", z8, false, false, true, null);
            if (N(strE)) {
                return;
            }
            if (O(strE)) {
                w();
                return;
            }
            List<String> list = this.f27595f;
            if (list.get(list.size() - 1).isEmpty()) {
                List<String> list2 = this.f27595f;
                list2.set(list2.size() - 1, strE);
            } else {
                this.f27595f.add(strE);
            }
            if (z7) {
                this.f27595f.add("");
            }
        }

        private static int j(String str, int i7, int i8) {
            if (i8 - i7 < 2) {
                return -1;
            }
            char cCharAt = str.charAt(i7);
            if ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z')) {
                while (true) {
                    i7++;
                    if (i7 >= i8) {
                        break;
                    }
                    char cCharAt2 = str.charAt(i7);
                    if (cCharAt2 < 'a' || cCharAt2 > 'z') {
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            if (cCharAt2 < '0' || cCharAt2 > '9') {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i7;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private static int p(String str, int i7, int i8) {
            int i9 = 0;
            while (i7 < i8) {
                char cCharAt = str.charAt(i7);
                if (cCharAt != '\\' && cCharAt != '/') {
                    break;
                }
                i9++;
                i7++;
            }
            return i9;
        }

        private static int t(String str, int i7, int i8) {
            while (i7 < i8) {
                char cCharAt = str.charAt(i7);
                if (cCharAt == ':') {
                    return i7;
                }
                if (cCharAt == '[') {
                    do {
                        i7++;
                        if (i7 >= i8) {
                            break;
                        }
                    } while (str.charAt(i7) != ']');
                }
                i7++;
            }
            return i8;
        }

        private void w() {
            List<String> list = this.f27595f;
            if (!list.remove(list.size() - 1).isEmpty() || this.f27595f.isEmpty()) {
                this.f27595f.add("");
            } else {
                List<String> list2 = this.f27595f;
                list2.set(list2.size() - 1, "");
            }
        }

        private static String y(String str, int i7, int i8) {
            return n.d.i(h0.f(str, i7, i8, false));
        }

        private static int z(String str, int i7, int i8) {
            try {
                int i9 = Integer.parseInt(h0.e(str, i7, i8, "", false, false, false, true, null));
                if (i9 <= 0 || i9 > 65535) {
                    return -1;
                }
                return i9;
            } catch (NumberFormatException unused) {
            }
        }

        public a A(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String strY = y(str, 0, str.length());
            if (strY != null) {
                this.f27593d = strY;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        public a B(String str) {
            if (str == null) {
                throw new NullPointerException("pathSegment == null");
            }
            i(str, 0, str.length(), false, false);
            return this;
        }

        public a C(String str) {
            if (str != null) {
                return g(str, false);
            }
            throw new NullPointerException("pathSegments == null");
        }

        public a D(String str) {
            if (str == null) {
                throw new NullPointerException("encodedPathSegment == null");
            }
            i(str, 0, str.length(), false, true);
            return this;
        }

        public a E(String str) {
            if (str != null) {
                return g(str, true);
            }
            throw new NullPointerException("encodedPathSegments == null");
        }

        public a F(String str) {
            if (str == null) {
                throw new NullPointerException("encodedPath == null");
            }
            if (str.startsWith("/")) {
                h(str, 0, str.length());
                return this;
            }
            throw new IllegalArgumentException("unexpected encodedPath: " + str);
        }

        public a G(@Nullable String str) {
            this.f27596g = str != null ? h0.r(h0.g(str, " \"'<>#", false, false, true, true)) : null;
            return this;
        }

        public a H(@Nullable String str) {
            this.f27596g = str != null ? h0.r(h0.g(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public a I(String str) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (this.f27596g == null) {
                return this;
            }
            M(h0.g(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
            return this;
        }

        public a J(String str) {
            if (str == null) {
                throw new NullPointerException("encodedName == null");
            }
            if (this.f27596g == null) {
                return this;
            }
            M(h0.g(str, " \"'<>#&=", true, false, true, true));
            return this;
        }

        public a K(@Nullable String str) {
            this.f27597h = str != null ? h0.g(str, "", false, false, false, false) : null;
            return this;
        }

        public a L(@Nullable String str) {
            this.f27597h = str != null ? h0.g(str, "", true, false, false, false) : null;
            return this;
        }

        int a() {
            int i7 = this.f27594e;
            return i7 != -1 ? i7 : h0.a(this.f27590a);
        }

        public a b(int i7) {
            if (i7 > 0 && i7 <= 65535) {
                this.f27594e = i7;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i7);
        }

        public a c(int i7, String str) {
            if (str == null) {
                throw new NullPointerException("pathSegment == null");
            }
            String strE = h0.e(str, 0, str.length(), " \"<>^`{}|/\\?#", false, false, false, true, null);
            if (!N(strE) && !O(strE)) {
                this.f27595f.set(i7, strE);
                return this;
            }
            throw new IllegalArgumentException("unexpected path segment: " + str);
        }

        a d(@Nullable h0 h0Var, String str) {
            int iD;
            int i7;
            int iB = n.d.b(str, 0, str.length());
            int iD2 = n.d.D(str, iB, str.length());
            int iJ = j(str, iB, iD2);
            if (iJ != -1) {
                if (str.regionMatches(true, iB, "https:", 0, 6)) {
                    this.f27590a = j0.b.f34226a;
                    iB += 6;
                } else {
                    if (!str.regionMatches(true, iB, "http:", 0, 5)) {
                        throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, iJ) + "'");
                    }
                    this.f27590a = com.haier.uhome.usdk.base.a.av;
                    iB += 5;
                }
            } else {
                if (h0Var == null) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                this.f27590a = h0Var.f27580a;
            }
            int iP = p(str, iB, iD2);
            char c8 = '?';
            char c9 = '#';
            if (iP >= 2 || h0Var == null || !h0Var.f27580a.equals(this.f27590a)) {
                boolean z7 = false;
                boolean z8 = false;
                int i8 = iB + iP;
                while (true) {
                    iD = n.d.d(str, i8, iD2, "@/\\?#");
                    byte bCharAt = iD != iD2 ? str.charAt(iD) : (byte) -1;
                    if (bCharAt == -1 || bCharAt == c9 || bCharAt == 47 || bCharAt == 92 || bCharAt == c8) {
                        break;
                    }
                    if (bCharAt == 64) {
                        if (z7) {
                            i7 = iD;
                            this.f27592c += "%40" + h0.e(str, i8, i7, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        } else {
                            int iC = n.d.c(str, i8, iD, ':');
                            i7 = iD;
                            String strE = h0.e(str, i8, iC, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z8) {
                                strE = this.f27591b + "%40" + strE;
                            }
                            this.f27591b = strE;
                            if (iC != i7) {
                                this.f27592c = h0.e(str, iC + 1, i7, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z7 = true;
                            }
                            z8 = true;
                        }
                        i8 = i7 + 1;
                    }
                    c8 = '?';
                    c9 = '#';
                }
                int iT = t(str, i8, iD);
                int i9 = iT + 1;
                if (i9 < iD) {
                    this.f27593d = y(str, i8, iT);
                    int iZ = z(str, i9, iD);
                    this.f27594e = iZ;
                    if (iZ == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str.substring(i9, iD) + kotlin.text.h0.f35376b);
                    }
                } else {
                    this.f27593d = y(str, i8, iT);
                    this.f27594e = h0.a(this.f27590a);
                }
                if (this.f27593d == null) {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str.substring(i8, iT) + kotlin.text.h0.f35376b);
                }
                iB = iD;
            } else {
                this.f27591b = h0Var.y();
                this.f27592c = h0Var.C();
                this.f27593d = h0Var.f27583d;
                this.f27594e = h0Var.f27584e;
                this.f27595f.clear();
                this.f27595f.addAll(h0Var.J());
                if (iB == iD2 || str.charAt(iB) == '#') {
                    H(h0Var.L());
                }
            }
            int iD3 = n.d.d(str, iB, iD2, "?#");
            h(str, iB, iD3);
            if (iD3 < iD2 && str.charAt(iD3) == '?') {
                int iC2 = n.d.c(str, iD3, iD2, '#');
                this.f27596g = h0.r(h0.e(str, iD3 + 1, iC2, " \"'<>#", true, false, true, true, null));
                iD3 = iC2;
            }
            if (iD3 < iD2 && str.charAt(iD3) == '#') {
                this.f27597h = h0.e(str, 1 + iD3, iD2, "", true, false, false, false, null);
            }
            return this;
        }

        public a e(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase(com.haier.uhome.usdk.base.a.av)) {
                this.f27590a = com.haier.uhome.usdk.base.a.av;
            } else {
                if (!str.equalsIgnoreCase(j0.b.f34226a)) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                this.f27590a = j0.b.f34226a;
            }
            return this;
        }

        public a f(String str, @Nullable String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (this.f27596g == null) {
                this.f27596g = new ArrayList();
            }
            this.f27596g.add(h0.g(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
            this.f27596g.add(str2 != null ? h0.g(str2, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true) : null);
            return this;
        }

        a k() {
            int size = this.f27595f.size();
            for (int i7 = 0; i7 < size; i7++) {
                this.f27595f.set(i7, h0.g(this.f27595f.get(i7), "[]", true, true, false, true));
            }
            List<String> list = this.f27596g;
            if (list != null) {
                int size2 = list.size();
                for (int i8 = 0; i8 < size2; i8++) {
                    String str = this.f27596g.get(i8);
                    if (str != null) {
                        this.f27596g.set(i8, h0.g(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.f27597h;
            if (str2 != null) {
                this.f27597h = h0.g(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public a l(int i7) {
            this.f27595f.remove(i7);
            if (this.f27595f.isEmpty()) {
                this.f27595f.add("");
            }
            return this;
        }

        public a m(int i7, String str) {
            if (str == null) {
                throw new NullPointerException("encodedPathSegment == null");
            }
            String strE = h0.e(str, 0, str.length(), " \"<>^`{}|/\\?#", true, false, false, true, null);
            this.f27595f.set(i7, strE);
            if (!N(strE) && !O(strE)) {
                return this;
            }
            throw new IllegalArgumentException("unexpected path segment: " + str);
        }

        public a n(String str) {
            if (str == null) {
                throw new NullPointerException("username == null");
            }
            this.f27591b = h0.g(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public a o(String str, @Nullable String str2) {
            if (str == null) {
                throw new NullPointerException("encodedName == null");
            }
            if (this.f27596g == null) {
                this.f27596g = new ArrayList();
            }
            this.f27596g.add(h0.g(str, " \"'<>#&=", true, false, true, true));
            this.f27596g.add(str2 != null ? h0.g(str2, " \"'<>#&=", true, false, true, true) : null);
            return this;
        }

        public a q(String str) {
            if (str == null) {
                throw new NullPointerException("encodedUsername == null");
            }
            this.f27591b = h0.g(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            return this;
        }

        public a r(String str, @Nullable String str2) {
            I(str);
            f(str, str2);
            return this;
        }

        public h0 s() {
            if (this.f27590a == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.f27593d != null) {
                return new h0(this);
            }
            throw new IllegalStateException("host == null");
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.f27590a;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (!this.f27591b.isEmpty() || !this.f27592c.isEmpty()) {
                sb.append(this.f27591b);
                if (!this.f27592c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f27592c);
                }
                sb.append('@');
            }
            String str2 = this.f27593d;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
                    sb.append('[');
                    sb.append(this.f27593d);
                    sb.append(']');
                } else {
                    sb.append(this.f27593d);
                }
            }
            if (this.f27594e != -1 || this.f27590a != null) {
                int iA = a();
                String str3 = this.f27590a;
                if (str3 == null || iA != h0.a(str3)) {
                    sb.append(':');
                    sb.append(iA);
                }
            }
            h0.n(sb, this.f27595f);
            if (this.f27596g != null) {
                sb.append('?');
                h0.s(sb, this.f27596g);
            }
            if (this.f27597h != null) {
                sb.append('#');
                sb.append(this.f27597h);
            }
            return sb.toString();
        }

        public a u(String str) {
            if (str == null) {
                throw new NullPointerException("password == null");
            }
            this.f27592c = h0.g(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public a v(String str, @Nullable String str2) {
            J(str);
            o(str, str2);
            return this;
        }

        public a x(String str) {
            if (str == null) {
                throw new NullPointerException("encodedPassword == null");
            }
            this.f27592c = h0.g(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            return this;
        }
    }

    h0(a aVar) {
        this.f27580a = aVar.f27590a;
        this.f27581b = i(aVar.f27591b, false);
        this.f27582c = i(aVar.f27592c, false);
        this.f27583d = aVar.f27593d;
        this.f27584e = aVar.a();
        this.f27585f = k(aVar.f27595f, false);
        List<String> list = aVar.f27596g;
        this.f27586g = list != null ? k(list, true) : null;
        String str = aVar.f27597h;
        this.f27587h = str != null ? i(str, false) : null;
        this.f27588i = aVar.toString();
    }

    @Nullable
    public static h0 B(String str) {
        try {
            return D(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static h0 D(String str) {
        return new a().d(null, str).s();
    }

    public static int a(String str) {
        if (str.equals(com.haier.uhome.usdk.base.a.av)) {
            return 80;
        }
        return str.equals(j0.b.f34226a) ? 443 : -1;
    }

    @Nullable
    public static h0 b(URI uri) {
        return B(uri.toString());
    }

    @Nullable
    public static h0 c(URL url) {
        return B(url.toString());
    }

    static String e(String str, int i7, int i8, String str2, boolean z7, boolean z8, boolean z9, boolean z10, Charset charset) {
        int iCharCount = i7;
        while (iCharCount < i8) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt >= 32 && iCodePointAt != 127 && (iCodePointAt < 128 || !z10)) {
                if (str2.indexOf(iCodePointAt) == -1 && ((iCodePointAt != 37 || (z7 && (!z8 || o(str, iCharCount, i8)))) && (iCodePointAt != 43 || !z9))) {
                    iCharCount += Character.charCount(iCodePointAt);
                }
            }
            com.haier.library.a.g gVar = new com.haier.library.a.g();
            gVar.b(str, i7, iCharCount);
            l(gVar, str, iCharCount, i8, str2, z7, z8, z9, z10, charset);
            return gVar.T();
        }
        return str.substring(i7, i8);
    }

    static String f(String str, int i7, int i8, boolean z7) {
        for (int i9 = i7; i9 < i8; i9++) {
            char cCharAt = str.charAt(i9);
            if (cCharAt == '%' || (cCharAt == '+' && z7)) {
                com.haier.library.a.g gVar = new com.haier.library.a.g();
                gVar.b(str, i7, i9);
                m(gVar, str, i9, i8, z7);
                return gVar.T();
            }
        }
        return str.substring(i7, i8);
    }

    static String g(String str, String str2, boolean z7, boolean z8, boolean z9, boolean z10) {
        return e(str, 0, str.length(), str2, z7, z8, z9, z10, null);
    }

    static String h(String str, String str2, boolean z7, boolean z8, boolean z9, boolean z10, Charset charset) {
        return e(str, 0, str.length(), str2, z7, z8, z9, z10, charset);
    }

    static String i(String str, boolean z7) {
        return f(str, 0, str.length(), z7);
    }

    private List<String> k(List<String> list, boolean z7) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i7 = 0; i7 < size; i7++) {
            String str = list.get(i7);
            arrayList.add(str != null ? i(str, z7) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static void l(com.haier.library.a.g gVar, String str, int i7, int i8, String str2, boolean z7, boolean z8, boolean z9, boolean z10, Charset charset) {
        com.haier.library.a.g gVar2 = null;
        while (i7 < i8) {
            int iCodePointAt = str.codePointAt(i7);
            if (!z7 || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z9) {
                    gVar.b(z7 ? "+" : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z10) || str2.indexOf(iCodePointAt) != -1 || (iCodePointAt == 37 && (!z7 || (z8 && !o(str, i7, i8)))))) {
                    if (gVar2 == null) {
                        gVar2 = new com.haier.library.a.g();
                    }
                    if (charset == null || charset.equals(n.d.f27695j)) {
                        gVar2.O1(iCodePointAt);
                    } else {
                        gVar2.W(str, i7, Character.charCount(iCodePointAt) + i7, charset);
                    }
                    while (!gVar2.g()) {
                        int iJ = gVar2.j() & 255;
                        gVar.y1(37);
                        char[] cArr = f27568j;
                        gVar.y1(cArr[(iJ >> 4) & 15]);
                        gVar.y1(cArr[iJ & 15]);
                    }
                } else {
                    gVar.O1(iCodePointAt);
                }
            }
            i7 += Character.charCount(iCodePointAt);
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0039  */
    static void m(com.haier.library.a.g gVar, String str, int i7, int i8, boolean z7) {
        int i9;
        while (i7 < i8) {
            int iCodePointAt = str.codePointAt(i7);
            if (iCodePointAt == 37 && (i9 = i7 + 2) < i8) {
                int iA = n.d.a(str.charAt(i7 + 1));
                int iA2 = n.d.a(str.charAt(i9));
                if (iA == -1 || iA2 == -1) {
                    gVar.O1(iCodePointAt);
                } else {
                    gVar.y1((iA << 4) + iA2);
                    i7 = i9;
                }
            } else if (iCodePointAt == 43 && z7) {
                gVar.y1(32);
            } else {
                gVar.O1(iCodePointAt);
            }
            i7 += Character.charCount(iCodePointAt);
        }
    }

    static void n(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            sb.append('/');
            sb.append(list.get(i7));
        }
    }

    static boolean o(String str, int i7, int i8) {
        int i9 = i7 + 2;
        return i9 < i8 && str.charAt(i7) == '%' && n.d.a(str.charAt(i7 + 1)) != -1 && n.d.a(str.charAt(i9)) != -1;
    }

    static List<String> r(String str) {
        ArrayList arrayList = new ArrayList();
        int i7 = 0;
        while (i7 <= str.length()) {
            int iIndexOf = str.indexOf(38, i7);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i7);
            if (iIndexOf2 == -1 || iIndexOf2 > iIndexOf) {
                arrayList.add(str.substring(i7, iIndexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i7, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            }
            i7 = iIndexOf + 1;
        }
        return arrayList;
    }

    static void s(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i7 = 0; i7 < size; i7 += 2) {
            String str = list.get(i7);
            String str2 = list.get(i7 + 1);
            if (i7 > 0) {
                sb.append(kotlin.text.h0.f35378d);
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    public String A() {
        return this.f27581b;
    }

    public String C() {
        if (this.f27582c.isEmpty()) {
            return "";
        }
        return this.f27588i.substring(this.f27588i.indexOf(58, this.f27580a.length() + 3) + 1, this.f27588i.indexOf(64));
    }

    public String E() {
        return this.f27582c;
    }

    public String F() {
        return this.f27583d;
    }

    public int G() {
        return this.f27584e;
    }

    public int H() {
        return this.f27585f.size();
    }

    public String I() {
        int iIndexOf = this.f27588i.indexOf(47, this.f27580a.length() + 3);
        String str = this.f27588i;
        return this.f27588i.substring(iIndexOf, n.d.d(str, iIndexOf, str.length(), "?#"));
    }

    public List<String> J() {
        int iIndexOf = this.f27588i.indexOf(47, this.f27580a.length() + 3);
        String str = this.f27588i;
        int iD = n.d.d(str, iIndexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iD) {
            int i7 = iIndexOf + 1;
            int iC = n.d.c(this.f27588i, i7, iD, '/');
            arrayList.add(this.f27588i.substring(i7, iC));
            iIndexOf = iC;
        }
        return arrayList;
    }

    public List<String> K() {
        return this.f27585f;
    }

    @Nullable
    public String L() {
        if (this.f27586g == null) {
            return null;
        }
        int iIndexOf = this.f27588i.indexOf(63) + 1;
        String str = this.f27588i;
        return this.f27588i.substring(iIndexOf, n.d.c(str, iIndexOf, str.length(), '#'));
    }

    @Nullable
    public String M() {
        if (this.f27586g == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        s(sb, this.f27586g);
        return sb.toString();
    }

    public int N() {
        List<String> list = this.f27586g;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public Set<String> O() {
        if (this.f27586g == null) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size = this.f27586g.size();
        for (int i7 = 0; i7 < size; i7 += 2) {
            linkedHashSet.add(this.f27586g.get(i7));
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    @Nullable
    public String P() {
        if (this.f27587h == null) {
            return null;
        }
        return this.f27588i.substring(this.f27588i.indexOf(35) + 1);
    }

    @Nullable
    public String Q() {
        return this.f27587h;
    }

    public String R() {
        return z("/...").n("").u("").s().toString();
    }

    public a S() {
        a aVar = new a();
        aVar.f27590a = this.f27580a;
        aVar.f27591b = y();
        aVar.f27592c = C();
        aVar.f27593d = this.f27583d;
        aVar.f27594e = this.f27584e != a(this.f27580a) ? this.f27584e : -1;
        aVar.f27595f.clear();
        aVar.f27595f.addAll(J());
        aVar.H(L());
        aVar.f27597h = P();
        return aVar;
    }

    @Nullable
    public String T() {
        if (n.d.I(this.f27583d)) {
            return null;
        }
        return com.haier.library.okhttp.b.k.a.a().b(this.f27583d);
    }

    public String d(int i7) {
        List<String> list = this.f27586g;
        if (list != null) {
            return list.get(i7 * 2);
        }
        throw new IndexOutOfBoundsException();
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof h0) && ((h0) obj).f27588i.equals(this.f27588i);
    }

    public int hashCode() {
        return this.f27588i.hashCode();
    }

    public URL j() {
        try {
            return new URL(this.f27588i);
        } catch (MalformedURLException e8) {
            throw new RuntimeException(e8);
        }
    }

    public String p(int i7) {
        List<String> list = this.f27586g;
        if (list != null) {
            return list.get((i7 * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    public URI q() {
        String string = S().k().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e8) {
            try {
                return URI.create(string.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e8);
            }
        }
    }

    public String t() {
        return this.f27580a;
    }

    public String toString() {
        return this.f27588i;
    }

    @Nullable
    public String u(String str) {
        List<String> list = this.f27586g;
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i7 = 0; i7 < size; i7 += 2) {
            if (str.equals(this.f27586g.get(i7))) {
                return this.f27586g.get(i7 + 1);
            }
        }
        return null;
    }

    public List<String> v(String str) {
        if (this.f27586g == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = this.f27586g.size();
        for (int i7 = 0; i7 < size; i7 += 2) {
            if (str.equals(this.f27586g.get(i7))) {
                arrayList.add(this.f27586g.get(i7 + 1));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public boolean w() {
        return this.f27580a.equals(j0.b.f34226a);
    }

    @Nullable
    public h0 x(String str) {
        a aVarZ = z(str);
        if (aVarZ != null) {
            return aVarZ.s();
        }
        return null;
    }

    public String y() {
        if (this.f27581b.isEmpty()) {
            return "";
        }
        int length = this.f27580a.length() + 3;
        String str = this.f27588i;
        return this.f27588i.substring(length, n.d.d(str, length, str.length(), ":@"));
    }

    @Nullable
    public a z(String str) {
        try {
            return new a().d(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
