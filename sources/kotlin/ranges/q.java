package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.g1;
import kotlin.jvm.internal.l0;
import kotlin.q2;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public class q extends p {
    public static final float A(float f8, float f9, float f10) {
        if (f9 <= f10) {
            if (f8 < f9) {
                return f9;
            }
            return f8 > f10 ? f10 : f8;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f10 + " is less than minimum " + f9 + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    @g1(version = "1.7")
    public static final long A0(@a7.d l lVar) {
        l0.p(lVar, "<this>");
        if (!lVar.isEmpty()) {
            return lVar.h();
        }
        throw new NoSuchElementException("Progression " + lVar + " is empty.");
    }

    @a7.d
    public static final k A1(int i7, short s7) {
        return new k(i7, s7 - 1);
    }

    public static int B(int i7, int i8, int i9) {
        if (i8 <= i9) {
            if (i7 < i8) {
                return i8;
            }
            return i7 > i9 ? i9 : i7;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i9 + " is less than minimum " + i8 + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    @g1(version = "1.7")
    @a7.e
    public static final Character B0(@a7.d a aVar) {
        l0.p(aVar, "<this>");
        if (aVar.isEmpty()) {
            return null;
        }
        return Character.valueOf(aVar.h());
    }

    @a7.d
    public static final k B1(short s7, byte b8) {
        return new k(s7, b8 - 1);
    }

    public static final int C(int i7, @a7.d g<Integer> range) {
        l0.p(range, "range");
        if (range instanceof f) {
            return ((Number) G(Integer.valueOf(i7), (f) range)).intValue();
        }
        if (!range.isEmpty()) {
            if (i7 < ((Number) range.d()).intValue()) {
                return ((Number) range.d()).intValue();
            }
            return i7 > ((Number) range.f()).intValue() ? ((Number) range.f()).intValue() : i7;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    @g1(version = "1.7")
    @a7.e
    public static final Integer C0(@a7.d i iVar) {
        l0.p(iVar, "<this>");
        if (iVar.isEmpty()) {
            return null;
        }
        return Integer.valueOf(iVar.h());
    }

    @a7.d
    public static final k C1(short s7, int i7) {
        return i7 <= Integer.MIN_VALUE ? k.f35034e.a() : new k(s7, i7 - 1);
    }

    public static long D(long j7, long j8, long j9) {
        if (j8 <= j9) {
            if (j7 < j8) {
                return j8;
            }
            return j7 > j9 ? j9 : j7;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j9 + " is less than minimum " + j8 + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    @g1(version = "1.7")
    @a7.e
    public static final Long D0(@a7.d l lVar) {
        l0.p(lVar, "<this>");
        if (lVar.isEmpty()) {
            return null;
        }
        return Long.valueOf(lVar.h());
    }

    @a7.d
    public static final k D1(short s7, short s8) {
        return new k(s7, s8 - 1);
    }

    public static long E(long j7, @a7.d g<Long> range) {
        l0.p(range, "range");
        if (range instanceof f) {
            return ((Number) G(Long.valueOf(j7), (f) range)).longValue();
        }
        if (!range.isEmpty()) {
            if (j7 < ((Number) range.d()).longValue()) {
                return ((Number) range.d()).longValue();
            }
            return j7 > ((Number) range.f()).longValue() ? ((Number) range.f()).longValue() : j7;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    @h5.h(name = "longRangeContains")
    public static final boolean E0(@a7.d g<Long> gVar, byte b8) {
        l0.p(gVar, "<this>");
        return gVar.a(Long.valueOf(b8));
    }

    @a7.d
    public static final n E1(byte b8, long j7) {
        return j7 <= Long.MIN_VALUE ? n.f35044e.a() : new n(b8, j7 - 1);
    }

    @a7.d
    public static final <T extends Comparable<? super T>> T F(@a7.d T t7, @a7.e T t8, @a7.e T t9) {
        l0.p(t7, "<this>");
        if (t8 == null || t9 == null) {
            if (t8 != null && t7.compareTo(t8) < 0) {
                return t8;
            }
            if (t9 != null && t7.compareTo(t9) > 0) {
                return t9;
            }
        } else {
            if (t8.compareTo(t9) > 0) {
                throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + t9 + " is less than minimum " + t8 + ClassUtils.PACKAGE_SEPARATOR_CHAR);
            }
            if (t7.compareTo(t8) < 0) {
                return t8;
            }
            if (t7.compareTo(t9) > 0) {
                return t9;
            }
        }
        return t7;
    }

    @kotlin.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @h5.h(name = "longRangeContains")
    public static final /* synthetic */ boolean F0(g gVar, double d8) {
        l0.p(gVar, "<this>");
        Long lO1 = o1(d8);
        if (lO1 != null) {
            return gVar.a(lO1);
        }
        return false;
    }

    @a7.d
    public static final n F1(int i7, long j7) {
        return j7 <= Long.MIN_VALUE ? n.f35044e.a() : new n(i7, j7 - 1);
    }

    @a7.d
    @g1(version = "1.1")
    public static final <T extends Comparable<? super T>> T G(@a7.d T t7, @a7.d f<T> range) {
        l0.p(t7, "<this>");
        l0.p(range, "range");
        if (!range.isEmpty()) {
            if (!range.b(t7, range.d()) || range.b(range.d(), t7)) {
                return (!range.b(range.f(), t7) || range.b(t7, range.f())) ? t7 : range.f();
            }
            return range.d();
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    @kotlin.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @h5.h(name = "longRangeContains")
    public static final /* synthetic */ boolean G0(g gVar, float f8) {
        l0.p(gVar, "<this>");
        Long lP1 = p1(f8);
        if (lP1 != null) {
            return gVar.a(lP1);
        }
        return false;
    }

    @a7.d
    public static final n G1(long j7, byte b8) {
        return new n(j7, ((long) b8) - 1);
    }

    @a7.d
    public static final <T extends Comparable<? super T>> T H(@a7.d T t7, @a7.d g<T> range) {
        l0.p(t7, "<this>");
        l0.p(range, "range");
        if (range instanceof f) {
            return (T) G(t7, (f) range);
        }
        if (!range.isEmpty()) {
            if (t7.compareTo(range.d()) < 0) {
                return (T) range.d();
            }
            return t7.compareTo(range.f()) > 0 ? (T) range.f() : t7;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    @h5.h(name = "longRangeContains")
    public static final boolean H0(@a7.d g<Long> gVar, int i7) {
        l0.p(gVar, "<this>");
        return gVar.a(Long.valueOf(i7));
    }

    @a7.d
    public static final n H1(long j7, int i7) {
        return new n(j7, ((long) i7) - 1);
    }

    public static final short I(short s7, short s8, short s9) {
        if (s8 <= s9) {
            if (s7 < s8) {
                return s8;
            }
            return s7 > s9 ? s9 : s7;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) s9) + " is less than minimum " + ((int) s8) + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    @h5.h(name = "longRangeContains")
    public static final boolean I0(@a7.d g<Long> gVar, short s7) {
        l0.p(gVar, "<this>");
        return gVar.a(Long.valueOf(s7));
    }

    @a7.d
    public static final n I1(long j7, long j8) {
        return j8 <= Long.MIN_VALUE ? n.f35044e.a() : new n(j7, j8 - 1);
    }

    @g1(version = "1.3")
    @kotlin.internal.f
    private static final boolean J(c cVar, Character ch) {
        l0.p(cVar, "<this>");
        return ch != null && cVar.m(ch.charValue());
    }

    @g1(version = "1.3")
    @kotlin.internal.f
    private static final char J0(c cVar) {
        l0.p(cVar, "<this>");
        return K0(cVar, kotlin.random.f.f34998a);
    }

    @a7.d
    public static final n J1(long j7, short s7) {
        return new n(j7, ((long) s7) - 1);
    }

    @g1(version = "1.3")
    @kotlin.internal.f
    private static final boolean K(k kVar, Integer num) {
        l0.p(kVar, "<this>");
        return num != null && kVar.m(num.intValue());
    }

    @g1(version = "1.3")
    public static final char K0(@a7.d c cVar, @a7.d kotlin.random.f random) {
        l0.p(cVar, "<this>");
        l0.p(random, "random");
        try {
            return (char) random.n(cVar.g(), cVar.h() + 1);
        } catch (IllegalArgumentException e8) {
            throw new NoSuchElementException(e8.getMessage());
        }
    }

    @a7.d
    public static final n K1(short s7, long j7) {
        return j7 <= Long.MIN_VALUE ? n.f35044e.a() : new n(s7, j7 - 1);
    }

    @g1(version = "1.3")
    @kotlin.internal.f
    private static final boolean L(n nVar, Long l7) {
        l0.p(nVar, "<this>");
        return l7 != null && nVar.m(l7.longValue());
    }

    @g1(version = "1.3")
    @kotlin.internal.f
    private static final int L0(k kVar) {
        l0.p(kVar, "<this>");
        return M0(kVar, kotlin.random.f.f34998a);
    }

    @kotlin.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @h5.h(name = "doubleRangeContains")
    public static final /* synthetic */ boolean M(g gVar, byte b8) {
        l0.p(gVar, "<this>");
        return gVar.a(Double.valueOf(b8));
    }

    @g1(version = "1.3")
    public static final int M0(@a7.d k kVar, @a7.d kotlin.random.f random) {
        l0.p(kVar, "<this>");
        l0.p(random, "random");
        try {
            return kotlin.random.g.h(random, kVar);
        } catch (IllegalArgumentException e8) {
            throw new NoSuchElementException(e8.getMessage());
        }
    }

    @h5.h(name = "doubleRangeContains")
    public static final boolean N(@a7.d g<Double> gVar, float f8) {
        l0.p(gVar, "<this>");
        return gVar.a(Double.valueOf(f8));
    }

    @g1(version = "1.3")
    @kotlin.internal.f
    private static final long N0(n nVar) {
        l0.p(nVar, "<this>");
        return O0(nVar, kotlin.random.f.f34998a);
    }

    @kotlin.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @h5.h(name = "doubleRangeContains")
    public static final /* synthetic */ boolean O(g gVar, int i7) {
        l0.p(gVar, "<this>");
        return gVar.a(Double.valueOf(i7));
    }

    @g1(version = "1.3")
    public static final long O0(@a7.d n nVar, @a7.d kotlin.random.f random) {
        l0.p(nVar, "<this>");
        l0.p(random, "random");
        try {
            return kotlin.random.g.i(random, nVar);
        } catch (IllegalArgumentException e8) {
            throw new NoSuchElementException(e8.getMessage());
        }
    }

    @kotlin.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @h5.h(name = "doubleRangeContains")
    public static final /* synthetic */ boolean P(g gVar, long j7) {
        l0.p(gVar, "<this>");
        return gVar.a(Double.valueOf(j7));
    }

    @g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final Character P0(c cVar) {
        l0.p(cVar, "<this>");
        return Q0(cVar, kotlin.random.f.f34998a);
    }

    @kotlin.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @h5.h(name = "doubleRangeContains")
    public static final /* synthetic */ boolean Q(g gVar, short s7) {
        l0.p(gVar, "<this>");
        return gVar.a(Double.valueOf(s7));
    }

    @g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final Character Q0(@a7.d c cVar, @a7.d kotlin.random.f random) {
        l0.p(cVar, "<this>");
        l0.p(random, "random");
        if (cVar.isEmpty()) {
            return null;
        }
        return Character.valueOf((char) random.n(cVar.g(), cVar.h() + 1));
    }

    @a7.d
    public static final a R(char c8, char c9) {
        return a.f35010d.a(c8, c9, -1);
    }

    @g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final Integer R0(k kVar) {
        l0.p(kVar, "<this>");
        return S0(kVar, kotlin.random.f.f34998a);
    }

    @a7.d
    public static final i S(byte b8, byte b9) {
        return i.f35026d.a(b8, b9, -1);
    }

    @g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final Integer S0(@a7.d k kVar, @a7.d kotlin.random.f random) {
        l0.p(kVar, "<this>");
        l0.p(random, "random");
        if (kVar.isEmpty()) {
            return null;
        }
        return Integer.valueOf(kotlin.random.g.h(random, kVar));
    }

    @a7.d
    public static final i T(byte b8, int i7) {
        return i.f35026d.a(b8, i7, -1);
    }

    @g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final Long T0(n nVar) {
        l0.p(nVar, "<this>");
        return U0(nVar, kotlin.random.f.f34998a);
    }

    @a7.d
    public static final i U(byte b8, short s7) {
        return i.f35026d.a(b8, s7, -1);
    }

    @g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final Long U0(@a7.d n nVar, @a7.d kotlin.random.f random) {
        l0.p(nVar, "<this>");
        l0.p(random, "random");
        if (nVar.isEmpty()) {
            return null;
        }
        return Long.valueOf(kotlin.random.g.i(random, nVar));
    }

    @a7.d
    public static final i V(int i7, byte b8) {
        return i.f35026d.a(i7, b8, -1);
    }

    @a7.d
    public static final a V0(@a7.d a aVar) {
        l0.p(aVar, "<this>");
        return a.f35010d.a(aVar.h(), aVar.g(), -aVar.j());
    }

    @a7.d
    public static i W(int i7, int i8) {
        return i.f35026d.a(i7, i8, -1);
    }

    @a7.d
    public static final i W0(@a7.d i iVar) {
        l0.p(iVar, "<this>");
        return i.f35026d.a(iVar.h(), iVar.g(), -iVar.j());
    }

    @a7.d
    public static final i X(int i7, short s7) {
        return i.f35026d.a(i7, s7, -1);
    }

    @a7.d
    public static final l X0(@a7.d l lVar) {
        l0.p(lVar, "<this>");
        return l.f35036d.a(lVar.h(), lVar.g(), -lVar.j());
    }

    @a7.d
    public static final i Y(short s7, byte b8) {
        return i.f35026d.a(s7, b8, -1);
    }

    @h5.h(name = "shortRangeContains")
    public static final boolean Y0(@a7.d g<Short> gVar, byte b8) {
        l0.p(gVar, "<this>");
        return gVar.a(Short.valueOf(b8));
    }

    @a7.d
    public static final i Z(short s7, int i7) {
        return i.f35026d.a(s7, i7, -1);
    }

    @kotlin.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @h5.h(name = "shortRangeContains")
    public static final /* synthetic */ boolean Z0(g gVar, double d8) {
        l0.p(gVar, "<this>");
        Short shQ1 = q1(d8);
        if (shQ1 != null) {
            return gVar.a(shQ1);
        }
        return false;
    }

    @a7.d
    public static final i a0(short s7, short s8) {
        return i.f35026d.a(s7, s8, -1);
    }

    @kotlin.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @h5.h(name = "shortRangeContains")
    public static final /* synthetic */ boolean a1(g gVar, float f8) {
        l0.p(gVar, "<this>");
        Short shR1 = r1(f8);
        if (shR1 != null) {
            return gVar.a(shR1);
        }
        return false;
    }

    @a7.d
    public static final l b0(byte b8, long j7) {
        return l.f35036d.a(b8, j7, -1L);
    }

    @h5.h(name = "shortRangeContains")
    public static final boolean b1(@a7.d g<Short> gVar, int i7) {
        l0.p(gVar, "<this>");
        Short shS1 = s1(i7);
        if (shS1 != null) {
            return gVar.a(shS1);
        }
        return false;
    }

    @a7.d
    public static final l c0(int i7, long j7) {
        return l.f35036d.a(i7, j7, -1L);
    }

    @h5.h(name = "shortRangeContains")
    public static final boolean c1(@a7.d g<Short> gVar, long j7) {
        l0.p(gVar, "<this>");
        Short shT1 = t1(j7);
        if (shT1 != null) {
            return gVar.a(shT1);
        }
        return false;
    }

    @a7.d
    public static final l d0(long j7, byte b8) {
        return l.f35036d.a(j7, b8, -1L);
    }

    @a7.d
    public static final a d1(@a7.d a aVar, int i7) {
        l0.p(aVar, "<this>");
        p.a(i7 > 0, Integer.valueOf(i7));
        a.C0437a c0437a = a.f35010d;
        char cG = aVar.g();
        char cH = aVar.h();
        if (aVar.j() <= 0) {
            i7 = -i7;
        }
        return c0437a.a(cG, cH, i7);
    }

    @a7.d
    public static final l e0(long j7, int i7) {
        return l.f35036d.a(j7, i7, -1L);
    }

    @a7.d
    public static i e1(@a7.d i iVar, int i7) {
        l0.p(iVar, "<this>");
        p.a(i7 > 0, Integer.valueOf(i7));
        i.a aVar = i.f35026d;
        int iG = iVar.g();
        int iH = iVar.h();
        if (iVar.j() <= 0) {
            i7 = -i7;
        }
        return aVar.a(iG, iH, i7);
    }

    @kotlin.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @h5.h(name = "byteRangeContains")
    public static final /* synthetic */ boolean f(g gVar, double d8) {
        l0.p(gVar, "<this>");
        Byte bG1 = g1(d8);
        if (bG1 != null) {
            return gVar.a(bG1);
        }
        return false;
    }

    @a7.d
    public static final l f0(long j7, long j8) {
        return l.f35036d.a(j7, j8, -1L);
    }

    @a7.d
    public static final l f1(@a7.d l lVar, long j7) {
        l0.p(lVar, "<this>");
        p.a(j7 > 0, Long.valueOf(j7));
        l.a aVar = l.f35036d;
        long jG = lVar.g();
        long jH = lVar.h();
        if (lVar.j() <= 0) {
            j7 = -j7;
        }
        return aVar.a(jG, jH, j7);
    }

    @kotlin.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @h5.h(name = "byteRangeContains")
    public static final /* synthetic */ boolean g(g gVar, float f8) {
        l0.p(gVar, "<this>");
        Byte bH1 = h1(f8);
        if (bH1 != null) {
            return gVar.a(bH1);
        }
        return false;
    }

    @a7.d
    public static final l g0(long j7, short s7) {
        return l.f35036d.a(j7, s7, -1L);
    }

    @a7.e
    public static final Byte g1(double d8) {
        boolean z7 = false;
        if (d8 <= 127.0d && -128.0d <= d8) {
            z7 = true;
        }
        if (z7) {
            return Byte.valueOf((byte) d8);
        }
        return null;
    }

    @h5.h(name = "byteRangeContains")
    public static final boolean h(@a7.d g<Byte> gVar, int i7) {
        l0.p(gVar, "<this>");
        Byte bI1 = i1(i7);
        if (bI1 != null) {
            return gVar.a(bI1);
        }
        return false;
    }

    @a7.d
    public static final l h0(short s7, long j7) {
        return l.f35036d.a(s7, j7, -1L);
    }

    @a7.e
    public static final Byte h1(float f8) {
        boolean z7 = false;
        if (f8 <= 127.0f && -128.0f <= f8) {
            z7 = true;
        }
        if (z7) {
            return Byte.valueOf((byte) f8);
        }
        return null;
    }

    @h5.h(name = "byteRangeContains")
    public static final boolean i(@a7.d g<Byte> gVar, long j7) {
        l0.p(gVar, "<this>");
        Byte bJ1 = j1(j7);
        if (bJ1 != null) {
            return gVar.a(bJ1);
        }
        return false;
    }

    @g1(version = "1.7")
    public static final char i0(@a7.d a aVar) {
        l0.p(aVar, "<this>");
        if (!aVar.isEmpty()) {
            return aVar.g();
        }
        throw new NoSuchElementException("Progression " + aVar + " is empty.");
    }

    @a7.e
    public static final Byte i1(int i7) {
        if (new k(-128, 127).m(i7)) {
            return Byte.valueOf((byte) i7);
        }
        return null;
    }

    @h5.h(name = "byteRangeContains")
    public static final boolean j(@a7.d g<Byte> gVar, short s7) {
        l0.p(gVar, "<this>");
        Byte bK1 = k1(s7);
        if (bK1 != null) {
            return gVar.a(bK1);
        }
        return false;
    }

    @g1(version = "1.7")
    public static final int j0(@a7.d i iVar) {
        l0.p(iVar, "<this>");
        if (!iVar.isEmpty()) {
            return iVar.g();
        }
        throw new NoSuchElementException("Progression " + iVar + " is empty.");
    }

    @a7.e
    public static final Byte j1(long j7) {
        if (new n(-128L, 127L).m(j7)) {
            return Byte.valueOf((byte) j7);
        }
        return null;
    }

    public static final byte k(byte b8, byte b9) {
        return b8 < b9 ? b9 : b8;
    }

    @g1(version = "1.7")
    public static final long k0(@a7.d l lVar) {
        l0.p(lVar, "<this>");
        if (!lVar.isEmpty()) {
            return lVar.g();
        }
        throw new NoSuchElementException("Progression " + lVar + " is empty.");
    }

    @a7.e
    public static final Byte k1(short s7) {
        if (x0(new k(-128, 127), s7)) {
            return Byte.valueOf((byte) s7);
        }
        return null;
    }

    public static final double l(double d8, double d9) {
        return d8 < d9 ? d9 : d8;
    }

    @g1(version = "1.7")
    @a7.e
    public static final Character l0(@a7.d a aVar) {
        l0.p(aVar, "<this>");
        if (aVar.isEmpty()) {
            return null;
        }
        return Character.valueOf(aVar.g());
    }

    @a7.e
    public static final Integer l1(double d8) {
        boolean z7 = false;
        if (d8 <= 2.147483647E9d && -2.147483648E9d <= d8) {
            z7 = true;
        }
        if (z7) {
            return Integer.valueOf((int) d8);
        }
        return null;
    }

    public static final float m(float f8, float f9) {
        return f8 < f9 ? f9 : f8;
    }

    @g1(version = "1.7")
    @a7.e
    public static final Integer m0(@a7.d i iVar) {
        l0.p(iVar, "<this>");
        if (iVar.isEmpty()) {
            return null;
        }
        return Integer.valueOf(iVar.g());
    }

    @a7.e
    public static final Integer m1(float f8) {
        boolean z7 = false;
        if (f8 <= 2.1474836E9f && -2.1474836E9f <= f8) {
            z7 = true;
        }
        if (z7) {
            return Integer.valueOf((int) f8);
        }
        return null;
    }

    public static int n(int i7, int i8) {
        return i7 < i8 ? i8 : i7;
    }

    @g1(version = "1.7")
    @a7.e
    public static final Long n0(@a7.d l lVar) {
        l0.p(lVar, "<this>");
        if (lVar.isEmpty()) {
            return null;
        }
        return Long.valueOf(lVar.g());
    }

    @a7.e
    public static final Integer n1(long j7) {
        if (new n(-2147483648L, 2147483647L).m(j7)) {
            return Integer.valueOf((int) j7);
        }
        return null;
    }

    public static long o(long j7, long j8) {
        return j7 < j8 ? j8 : j7;
    }

    @kotlin.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @h5.h(name = "floatRangeContains")
    public static final /* synthetic */ boolean o0(g gVar, byte b8) {
        l0.p(gVar, "<this>");
        return gVar.a(Float.valueOf(b8));
    }

    @a7.e
    public static final Long o1(double d8) {
        boolean z7 = false;
        if (d8 <= 9.223372036854776E18d && -9.223372036854776E18d <= d8) {
            z7 = true;
        }
        if (z7) {
            return Long.valueOf((long) d8);
        }
        return null;
    }

    @a7.d
    public static final <T extends Comparable<? super T>> T p(@a7.d T t7, @a7.d T minimumValue) {
        l0.p(t7, "<this>");
        l0.p(minimumValue, "minimumValue");
        return t7.compareTo(minimumValue) < 0 ? minimumValue : t7;
    }

    @h5.h(name = "floatRangeContains")
    public static final boolean p0(@a7.d g<Float> gVar, double d8) {
        l0.p(gVar, "<this>");
        return gVar.a(Float.valueOf((float) d8));
    }

    @a7.e
    public static final Long p1(float f8) {
        boolean z7 = false;
        if (f8 <= 9.223372E18f && -9.223372E18f <= f8) {
            z7 = true;
        }
        if (z7) {
            return Long.valueOf((long) f8);
        }
        return null;
    }

    public static final short q(short s7, short s8) {
        return s7 < s8 ? s8 : s7;
    }

    @kotlin.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @h5.h(name = "floatRangeContains")
    public static final /* synthetic */ boolean q0(g gVar, int i7) {
        l0.p(gVar, "<this>");
        return gVar.a(Float.valueOf(i7));
    }

    @a7.e
    public static final Short q1(double d8) {
        boolean z7 = false;
        if (d8 <= 32767.0d && -32768.0d <= d8) {
            z7 = true;
        }
        if (z7) {
            return Short.valueOf((short) d8);
        }
        return null;
    }

    public static final byte r(byte b8, byte b9) {
        return b8 > b9 ? b9 : b8;
    }

    @kotlin.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @h5.h(name = "floatRangeContains")
    public static final /* synthetic */ boolean r0(g gVar, long j7) {
        l0.p(gVar, "<this>");
        return gVar.a(Float.valueOf(j7));
    }

    @a7.e
    public static final Short r1(float f8) {
        boolean z7 = false;
        if (f8 <= 32767.0f && -32768.0f <= f8) {
            z7 = true;
        }
        if (z7) {
            return Short.valueOf((short) f8);
        }
        return null;
    }

    public static final double s(double d8, double d9) {
        return d8 > d9 ? d9 : d8;
    }

    @kotlin.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @h5.h(name = "floatRangeContains")
    public static final /* synthetic */ boolean s0(g gVar, short s7) {
        l0.p(gVar, "<this>");
        return gVar.a(Float.valueOf(s7));
    }

    @a7.e
    public static final Short s1(int i7) {
        if (new k(-32768, 32767).m(i7)) {
            return Short.valueOf((short) i7);
        }
        return null;
    }

    public static final float t(float f8, float f9) {
        return f8 > f9 ? f9 : f8;
    }

    @h5.h(name = "intRangeContains")
    public static final boolean t0(@a7.d g<Integer> gVar, byte b8) {
        l0.p(gVar, "<this>");
        return gVar.a(Integer.valueOf(b8));
    }

    @a7.e
    public static final Short t1(long j7) {
        if (new n(-32768L, 32767L).m(j7)) {
            return Short.valueOf((short) j7);
        }
        return null;
    }

    public static int u(int i7, int i8) {
        return i7 > i8 ? i8 : i7;
    }

    @kotlin.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @h5.h(name = "intRangeContains")
    public static final /* synthetic */ boolean u0(g gVar, double d8) {
        l0.p(gVar, "<this>");
        Integer numL1 = l1(d8);
        if (numL1 != null) {
            return gVar.a(numL1);
        }
        return false;
    }

    @a7.d
    public static final c u1(char c8, char c9) {
        return l0.t(c9, 0) <= 0 ? c.f35018e.a() : new c(c8, (char) (c9 - 1));
    }

    public static long v(long j7, long j8) {
        return j7 > j8 ? j8 : j7;
    }

    @kotlin.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @h5.h(name = "intRangeContains")
    public static final /* synthetic */ boolean v0(g gVar, float f8) {
        l0.p(gVar, "<this>");
        Integer numM1 = m1(f8);
        if (numM1 != null) {
            return gVar.a(numM1);
        }
        return false;
    }

    @a7.d
    public static final k v1(byte b8, byte b9) {
        return new k(b8, b9 - 1);
    }

    @a7.d
    public static final <T extends Comparable<? super T>> T w(@a7.d T t7, @a7.d T maximumValue) {
        l0.p(t7, "<this>");
        l0.p(maximumValue, "maximumValue");
        return t7.compareTo(maximumValue) > 0 ? maximumValue : t7;
    }

    @h5.h(name = "intRangeContains")
    public static final boolean w0(@a7.d g<Integer> gVar, long j7) {
        l0.p(gVar, "<this>");
        Integer numN1 = n1(j7);
        if (numN1 != null) {
            return gVar.a(numN1);
        }
        return false;
    }

    @a7.d
    public static final k w1(byte b8, int i7) {
        return i7 <= Integer.MIN_VALUE ? k.f35034e.a() : new k(b8, i7 - 1);
    }

    public static final short x(short s7, short s8) {
        return s7 > s8 ? s8 : s7;
    }

    @h5.h(name = "intRangeContains")
    public static final boolean x0(@a7.d g<Integer> gVar, short s7) {
        l0.p(gVar, "<this>");
        return gVar.a(Integer.valueOf(s7));
    }

    @a7.d
    public static final k x1(byte b8, short s7) {
        return new k(b8, s7 - 1);
    }

    public static final byte y(byte b8, byte b9, byte b10) {
        if (b9 <= b10) {
            if (b8 < b9) {
                return b9;
            }
            return b8 > b10 ? b10 : b8;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) b10) + " is less than minimum " + ((int) b9) + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    @g1(version = "1.7")
    public static final char y0(@a7.d a aVar) {
        l0.p(aVar, "<this>");
        if (!aVar.isEmpty()) {
            return aVar.h();
        }
        throw new NoSuchElementException("Progression " + aVar + " is empty.");
    }

    @a7.d
    public static final k y1(int i7, byte b8) {
        return new k(i7, b8 - 1);
    }

    public static final double z(double d8, double d9, double d10) {
        if (d9 <= d10) {
            if (d8 < d9) {
                return d9;
            }
            return d8 > d10 ? d10 : d8;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d10 + " is less than minimum " + d9 + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    @g1(version = "1.7")
    public static final int z0(@a7.d i iVar) {
        l0.p(iVar, "<this>");
        if (!iVar.isEmpty()) {
            return iVar.h();
        }
        throw new NoSuchElementException("Progression " + iVar + " is empty.");
    }

    @a7.d
    public static k z1(int i7, int i8) {
        return i8 <= Integer.MIN_VALUE ? k.f35034e.a() : new k(i7, i8 - 1);
    }
}
