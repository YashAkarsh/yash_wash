package kotlin.text;

import kotlin.a2;
import kotlin.g1;
import kotlin.g2;
import kotlin.jvm.internal.l0;
import kotlin.o2;
import kotlin.q2;
import kotlin.s1;
import kotlin.w1;

/* JADX INFO: loaded from: classes2.dex */
@h5.h(name = "UStringsKt")
public final class i0 {
    @a7.d
    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final String a(long j7, int i7) {
        return o2.l(j7, d.a(i7));
    }

    @a7.d
    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final String b(byte b8, int i7) {
        String string = Integer.toString(b8 & 255, d.a(i7));
        l0.o(string, "toString(this, checkRadix(radix))");
        return string;
    }

    @a7.d
    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final String c(int i7, int i8) {
        String string = Long.toString(((long) i7) & 4294967295L, d.a(i8));
        l0.o(string, "toString(this, checkRadix(radix))");
        return string;
    }

    @a7.d
    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final String d(short s7, int i7) {
        String string = Integer.toString(s7 & g2.f34732d, d.a(i7));
        l0.o(string, "toString(this, checkRadix(radix))");
        return string;
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final byte e(@a7.d String str) {
        l0.p(str, "<this>");
        s1 s1VarG = g(str);
        if (s1VarG != null) {
            return s1VarG.e0();
        }
        a0.U0(str);
        throw new kotlin.y();
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final byte f(@a7.d String str, int i7) {
        l0.p(str, "<this>");
        s1 s1VarH = h(str, i7);
        if (s1VarH != null) {
            return s1VarH.e0();
        }
        a0.U0(str);
        throw new kotlin.y();
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    @a7.e
    public static final s1 g(@a7.d String str) {
        l0.p(str, "<this>");
        return h(str, 10);
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    @a7.e
    public static final s1 h(@a7.d String str, int i7) {
        l0.p(str, "<this>");
        w1 w1VarL = l(str, i7);
        if (w1VarL == null) {
            return null;
        }
        int iG0 = w1VarL.g0();
        if (o2.c(iG0, w1.h(255)) > 0) {
            return null;
        }
        return s1.b(s1.h((byte) iG0));
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final int i(@a7.d String str) {
        l0.p(str, "<this>");
        w1 w1VarK = k(str);
        if (w1VarK != null) {
            return w1VarK.g0();
        }
        a0.U0(str);
        throw new kotlin.y();
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final int j(@a7.d String str, int i7) {
        l0.p(str, "<this>");
        w1 w1VarL = l(str, i7);
        if (w1VarL != null) {
            return w1VarL.g0();
        }
        a0.U0(str);
        throw new kotlin.y();
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    @a7.e
    public static final w1 k(@a7.d String str) {
        l0.p(str, "<this>");
        return l(str, 10);
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    @a7.e
    public static final w1 l(@a7.d String str, int i7) {
        int i8;
        l0.p(str, "<this>");
        d.a(i7);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i9 = 0;
        char cCharAt = str.charAt(0);
        if (l0.t(cCharAt, 48) < 0) {
            i8 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        } else {
            i8 = 0;
        }
        int iH = w1.h(i7);
        int iD = 119304647;
        while (i8 < length) {
            int iB = d.b(str.charAt(i8), i7);
            if (iB < 0) {
                return null;
            }
            if (o2.c(i9, iD) > 0) {
                if (iD == 119304647) {
                    iD = o2.d(-1, iH);
                    if (o2.c(i9, iD) > 0) {
                    }
                }
                return null;
            }
            int iH2 = w1.h(i9 * iH);
            int iH3 = w1.h(w1.h(iB) + iH2);
            if (o2.c(iH3, iH2) < 0) {
                return null;
            }
            i8++;
            i9 = iH3;
        }
        return w1.b(i9);
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final long m(@a7.d String str) {
        l0.p(str, "<this>");
        a2 a2VarO = o(str);
        if (a2VarO != null) {
            return a2VarO.g0();
        }
        a0.U0(str);
        throw new kotlin.y();
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final long n(@a7.d String str, int i7) {
        l0.p(str, "<this>");
        a2 a2VarP = p(str, i7);
        if (a2VarP != null) {
            return a2VarP.g0();
        }
        a0.U0(str);
        throw new kotlin.y();
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    @a7.e
    public static final a2 o(@a7.d String str) {
        l0.p(str, "<this>");
        return p(str, 10);
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    @a7.e
    public static final a2 p(@a7.d String str, int i7) {
        l0.p(str, "<this>");
        d.a(i7);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i8 = 0;
        char cCharAt = str.charAt(0);
        if (l0.t(cCharAt, 48) < 0) {
            i8 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        }
        long jH = a2.h(i7);
        long j7 = 0;
        long jH2 = 512409557603043100L;
        while (i8 < length) {
            int iB = d.b(str.charAt(i8), i7);
            if (iB < 0) {
                return null;
            }
            if (o2.g(j7, jH2) > 0) {
                if (jH2 == 512409557603043100L) {
                    jH2 = o2.h(-1L, jH);
                    if (o2.g(j7, jH2) > 0) {
                    }
                }
                return null;
            }
            long jH3 = a2.h(j7 * jH);
            long jH4 = a2.h(a2.h(((long) w1.h(iB)) & 4294967295L) + jH3);
            if (o2.g(jH4, jH3) < 0) {
                return null;
            }
            i8++;
            j7 = jH4;
        }
        return a2.b(j7);
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final short q(@a7.d String str) {
        l0.p(str, "<this>");
        g2 g2VarS = s(str);
        if (g2VarS != null) {
            return g2VarS.e0();
        }
        a0.U0(str);
        throw new kotlin.y();
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final short r(@a7.d String str, int i7) {
        l0.p(str, "<this>");
        g2 g2VarT = t(str, i7);
        if (g2VarT != null) {
            return g2VarT.e0();
        }
        a0.U0(str);
        throw new kotlin.y();
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    @a7.e
    public static final g2 s(@a7.d String str) {
        l0.p(str, "<this>");
        return t(str, 10);
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    @a7.e
    public static final g2 t(@a7.d String str, int i7) {
        l0.p(str, "<this>");
        w1 w1VarL = l(str, i7);
        if (w1VarL == null) {
            return null;
        }
        int iG0 = w1VarL.g0();
        if (o2.c(iG0, w1.h(65535)) > 0) {
            return null;
        }
        return g2.b(g2.h((short) iG0));
    }
}
