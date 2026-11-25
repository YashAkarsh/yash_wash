package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.a2;
import kotlin.g1;
import kotlin.g2;
import kotlin.jvm.internal.l0;
import kotlin.o2;
import kotlin.q2;
import kotlin.s1;
import kotlin.w1;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
class y {
    @g1(version = "1.7")
    public static final int A(@a7.d r rVar) {
        l0.p(rVar, "<this>");
        if (!rVar.isEmpty()) {
            return rVar.g();
        }
        throw new NoSuchElementException("Progression " + rVar + " is empty.");
    }

    @g1(version = "1.7")
    public static final long B(@a7.d u uVar) {
        l0.p(uVar, "<this>");
        if (!uVar.isEmpty()) {
            return uVar.g();
        }
        throw new NoSuchElementException("Progression " + uVar + " is empty.");
    }

    @g1(version = "1.7")
    @a7.e
    public static final w1 C(@a7.d r rVar) {
        l0.p(rVar, "<this>");
        if (rVar.isEmpty()) {
            return null;
        }
        return w1.b(rVar.g());
    }

    @g1(version = "1.7")
    @a7.e
    public static final a2 D(@a7.d u uVar) {
        l0.p(uVar, "<this>");
        if (uVar.isEmpty()) {
            return null;
        }
        return a2.b(uVar.g());
    }

    @g1(version = "1.7")
    public static final int E(@a7.d r rVar) {
        l0.p(rVar, "<this>");
        if (!rVar.isEmpty()) {
            return rVar.h();
        }
        throw new NoSuchElementException("Progression " + rVar + " is empty.");
    }

    @g1(version = "1.7")
    public static final long F(@a7.d u uVar) {
        l0.p(uVar, "<this>");
        if (!uVar.isEmpty()) {
            return uVar.h();
        }
        throw new NoSuchElementException("Progression " + uVar + " is empty.");
    }

    @g1(version = "1.7")
    @a7.e
    public static final w1 G(@a7.d r rVar) {
        l0.p(rVar, "<this>");
        if (rVar.isEmpty()) {
            return null;
        }
        return w1.b(rVar.h());
    }

    @g1(version = "1.7")
    @a7.e
    public static final a2 H(@a7.d u uVar) {
        l0.p(uVar, "<this>");
        if (uVar.isEmpty()) {
            return null;
        }
        return a2.b(uVar.h());
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    @kotlin.internal.f
    private static final int I(t tVar) {
        l0.p(tVar, "<this>");
        return J(tVar, kotlin.random.f.f34998a);
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final int J(@a7.d t tVar, @a7.d kotlin.random.f random) {
        l0.p(tVar, "<this>");
        l0.p(random, "random");
        try {
            return kotlin.random.h.h(random, tVar);
        } catch (IllegalArgumentException e8) {
            throw new NoSuchElementException(e8.getMessage());
        }
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    @kotlin.internal.f
    private static final long K(w wVar) {
        l0.p(wVar, "<this>");
        return L(wVar, kotlin.random.f.f34998a);
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final long L(@a7.d w wVar, @a7.d kotlin.random.f random) {
        l0.p(wVar, "<this>");
        l0.p(random, "random");
        try {
            return kotlin.random.h.l(random, wVar);
        } catch (IllegalArgumentException e8) {
            throw new NoSuchElementException(e8.getMessage());
        }
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.s.class, kotlin.t.class})
    @kotlin.internal.f
    private static final w1 M(t tVar) {
        l0.p(tVar, "<this>");
        return N(tVar, kotlin.random.f.f34998a);
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.s.class, kotlin.t.class})
    @a7.e
    public static final w1 N(@a7.d t tVar, @a7.d kotlin.random.f random) {
        l0.p(tVar, "<this>");
        l0.p(random, "random");
        if (tVar.isEmpty()) {
            return null;
        }
        return w1.b(kotlin.random.h.h(random, tVar));
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.s.class, kotlin.t.class})
    @kotlin.internal.f
    private static final a2 O(w wVar) {
        l0.p(wVar, "<this>");
        return P(wVar, kotlin.random.f.f34998a);
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.s.class, kotlin.t.class})
    @a7.e
    public static final a2 P(@a7.d w wVar, @a7.d kotlin.random.f random) {
        l0.p(wVar, "<this>");
        l0.p(random, "random");
        if (wVar.isEmpty()) {
            return null;
        }
        return a2.b(kotlin.random.h.l(random, wVar));
    }

    @a7.d
    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final r Q(@a7.d r rVar) {
        l0.p(rVar, "<this>");
        return r.f35046d.a(rVar.h(), rVar.g(), -rVar.j());
    }

    @a7.d
    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final u R(@a7.d u uVar) {
        l0.p(uVar, "<this>");
        return u.f35056d.a(uVar.h(), uVar.g(), -uVar.j());
    }

    @a7.d
    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final r S(@a7.d r rVar, int i7) {
        l0.p(rVar, "<this>");
        p.a(i7 > 0, Integer.valueOf(i7));
        r.a aVar = r.f35046d;
        int iG = rVar.g();
        int iH = rVar.h();
        if (rVar.j() <= 0) {
            i7 = -i7;
        }
        return aVar.a(iG, iH, i7);
    }

    @a7.d
    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final u T(@a7.d u uVar, long j7) {
        l0.p(uVar, "<this>");
        p.a(j7 > 0, Long.valueOf(j7));
        u.a aVar = u.f35056d;
        long jG = uVar.g();
        long jH = uVar.h();
        if (uVar.j() <= 0) {
            j7 = -j7;
        }
        return aVar.a(jG, jH, j7);
    }

    @a7.d
    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final t U(short s7, short s8) {
        int i7 = s8 & g2.f34732d;
        return l0.t(i7, 0) <= 0 ? t.f35054e.a() : new t(w1.h(s7 & g2.f34732d), w1.h(w1.h(i7) - 1), null);
    }

    @a7.d
    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final t V(int i7, int i8) {
        return o2.c(i8, 0) <= 0 ? t.f35054e.a() : new t(i7, w1.h(i8 - 1), null);
    }

    @a7.d
    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final t W(byte b8, byte b9) {
        int i7 = b9 & 255;
        return l0.t(i7, 0) <= 0 ? t.f35054e.a() : new t(w1.h(b8 & 255), w1.h(w1.h(i7) - 1), null);
    }

    @a7.d
    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final w X(long j7, long j8) {
        return o2.g(j8, 0L) <= 0 ? w.f35064e.a() : new w(j7, a2.h(j8 - a2.h(((long) 1) & 4294967295L)), null);
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final short a(short s7, short s8) {
        return l0.t(s7 & g2.f34732d, 65535 & s8) < 0 ? s8 : s7;
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final int b(int i7, int i8) {
        return o2.c(i7, i8) < 0 ? i8 : i7;
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final byte c(byte b8, byte b9) {
        return l0.t(b8 & 255, b9 & 255) < 0 ? b9 : b8;
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final long d(long j7, long j8) {
        return o2.g(j7, j8) < 0 ? j8 : j7;
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final short e(short s7, short s8) {
        return l0.t(s7 & g2.f34732d, 65535 & s8) > 0 ? s8 : s7;
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final int f(int i7, int i8) {
        return o2.c(i7, i8) > 0 ? i8 : i7;
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final byte g(byte b8, byte b9) {
        return l0.t(b8 & 255, b9 & 255) > 0 ? b9 : b8;
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final long h(long j7, long j8) {
        return o2.g(j7, j8) > 0 ? j8 : j7;
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final long i(long j7, @a7.d g<a2> range) {
        l0.p(range, "range");
        if (range instanceof f) {
            return ((a2) q.G(a2.b(j7), (f) range)).g0();
        }
        if (!range.isEmpty()) {
            if (o2.g(j7, ((a2) range.d()).g0()) < 0) {
                return ((a2) range.d()).g0();
            }
            return o2.g(j7, ((a2) range.f()).g0()) > 0 ? ((a2) range.f()).g0() : j7;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final short j(short s7, short s8, short s9) {
        int i7 = s8 & g2.f34732d;
        int i8 = s9 & g2.f34732d;
        if (l0.t(i7, i8) <= 0) {
            int i9 = 65535 & s7;
            if (l0.t(i9, i7) < 0) {
                return s8;
            }
            return l0.t(i9, i8) > 0 ? s9 : s7;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) g2.Z(s9)) + " is less than minimum " + ((Object) g2.Z(s8)) + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final int k(int i7, int i8, int i9) {
        if (o2.c(i8, i9) <= 0) {
            if (o2.c(i7, i8) < 0) {
                return i8;
            }
            return o2.c(i7, i9) > 0 ? i9 : i7;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) w1.b0(i9)) + " is less than minimum " + ((Object) w1.b0(i8)) + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final byte l(byte b8, byte b9, byte b10) {
        int i7 = b9 & 255;
        int i8 = b10 & 255;
        if (l0.t(i7, i8) <= 0) {
            int i9 = b8 & 255;
            if (l0.t(i9, i7) < 0) {
                return b9;
            }
            return l0.t(i9, i8) > 0 ? b10 : b8;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) s1.Z(b10)) + " is less than minimum " + ((Object) s1.Z(b9)) + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final long m(long j7, long j8, long j9) {
        if (o2.g(j8, j9) <= 0) {
            if (o2.g(j7, j8) < 0) {
                return j8;
            }
            return o2.g(j7, j9) > 0 ? j9 : j7;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) a2.b0(j9)) + " is less than minimum " + ((Object) a2.b0(j8)) + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final int n(int i7, @a7.d g<w1> range) {
        l0.p(range, "range");
        if (range instanceof f) {
            return ((w1) q.G(w1.b(i7), (f) range)).g0();
        }
        if (!range.isEmpty()) {
            if (o2.c(i7, ((w1) range.d()).g0()) < 0) {
                return ((w1) range.d()).g0();
            }
            return o2.c(i7, ((w1) range.f()).g0()) > 0 ? ((w1) range.f()).g0() : i7;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final boolean o(@a7.d t contains, byte b8) {
        l0.p(contains, "$this$contains");
        return contains.l(w1.h(b8 & 255));
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    @kotlin.internal.f
    private static final boolean p(w contains, a2 a2Var) {
        l0.p(contains, "$this$contains");
        return a2Var != null && contains.l(a2Var.g0());
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final boolean q(@a7.d w contains, int i7) {
        l0.p(contains, "$this$contains");
        return contains.l(a2.h(((long) i7) & 4294967295L));
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final boolean r(@a7.d w contains, byte b8) {
        l0.p(contains, "$this$contains");
        return contains.l(a2.h(((long) b8) & 255));
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final boolean s(@a7.d t contains, short s7) {
        l0.p(contains, "$this$contains");
        return contains.l(w1.h(s7 & g2.f34732d));
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    @kotlin.internal.f
    private static final boolean t(t contains, w1 w1Var) {
        l0.p(contains, "$this$contains");
        return w1Var != null && contains.l(w1Var.g0());
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final boolean u(@a7.d t contains, long j7) {
        l0.p(contains, "$this$contains");
        return a2.h(j7 >>> 32) == 0 && contains.l(w1.h((int) j7));
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final boolean v(@a7.d w contains, short s7) {
        l0.p(contains, "$this$contains");
        return contains.l(a2.h(((long) s7) & okhttp3.internal.ws.g.f38386s));
    }

    @a7.d
    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final r w(short s7, short s8) {
        return r.f35046d.a(w1.h(s7 & g2.f34732d), w1.h(s8 & g2.f34732d), -1);
    }

    @a7.d
    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final r x(int i7, int i8) {
        return r.f35046d.a(i7, i8, -1);
    }

    @a7.d
    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final r y(byte b8, byte b9) {
        return r.f35046d.a(w1.h(b8 & 255), w1.h(b9 & 255), -1);
    }

    @a7.d
    @g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    public static final u z(long j7, long j8) {
        return u.f35056d.a(j7, j8, -1L);
    }
}
