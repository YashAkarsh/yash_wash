package kotlin.collections.unsigned;

import h5.h;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.a2;
import kotlin.b1;
import kotlin.b2;
import kotlin.collections.p;
import kotlin.collections.u0;
import kotlin.g1;
import kotlin.g2;
import kotlin.h2;
import kotlin.internal.f;
import kotlin.jvm.internal.l0;
import kotlin.k;
import kotlin.l;
import kotlin.o2;
import kotlin.s1;
import kotlin.t;
import kotlin.t0;
import kotlin.t1;
import kotlin.w1;
import kotlin.x1;

/* JADX INFO: loaded from: classes2.dex */
class b {

    public static final class a extends kotlin.collections.c<w1> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int[] f34622b;

        a(int[] iArr) {
            this.f34622b = iArr;
        }

        @Override // kotlin.collections.c, kotlin.collections.a
        public int a() {
            return x1.o(this.f34622b);
        }

        public boolean b(int i7) {
            return x1.h(this.f34622b, i7);
        }

        @Override // kotlin.collections.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof w1) {
                return b(((w1) obj).g0());
            }
            return false;
        }

        public int d(int i7) {
            return x1.m(this.f34622b, i7);
        }

        public int f(int i7) {
            return p.hg(this.f34622b, i7);
        }

        public int g(int i7) {
            return p.li(this.f34622b, i7);
        }

        @Override // kotlin.collections.c, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i7) {
            return w1.b(d(i7));
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof w1) {
                return f(((w1) obj).g0());
            }
            return -1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return x1.s(this.f34622b);
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof w1) {
                return g(((w1) obj).g0());
            }
            return -1;
        }
    }

    /* JADX INFO: renamed from: kotlin.collections.unsigned.b$b, reason: collision with other inner class name */
    public static final class C0426b extends kotlin.collections.c<a2> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long[] f34623b;

        C0426b(long[] jArr) {
            this.f34623b = jArr;
        }

        @Override // kotlin.collections.c, kotlin.collections.a
        public int a() {
            return b2.o(this.f34623b);
        }

        public boolean b(long j7) {
            return b2.h(this.f34623b, j7);
        }

        @Override // kotlin.collections.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof a2) {
                return b(((a2) obj).g0());
            }
            return false;
        }

        public long d(int i7) {
            return b2.m(this.f34623b, i7);
        }

        public int f(long j7) {
            return p.ig(this.f34623b, j7);
        }

        public int g(long j7) {
            return p.mi(this.f34623b, j7);
        }

        @Override // kotlin.collections.c, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i7) {
            return a2.b(d(i7));
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof a2) {
                return f(((a2) obj).g0());
            }
            return -1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return b2.s(this.f34623b);
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof a2) {
                return g(((a2) obj).g0());
            }
            return -1;
        }
    }

    public static final class c extends kotlin.collections.c<s1> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ byte[] f34624b;

        c(byte[] bArr) {
            this.f34624b = bArr;
        }

        @Override // kotlin.collections.c, kotlin.collections.a
        public int a() {
            return t1.o(this.f34624b);
        }

        public boolean b(byte b8) {
            return t1.h(this.f34624b, b8);
        }

        @Override // kotlin.collections.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof s1) {
                return b(((s1) obj).e0());
            }
            return false;
        }

        public byte d(int i7) {
            return t1.m(this.f34624b, i7);
        }

        public int f(byte b8) {
            return p.dg(this.f34624b, b8);
        }

        public int g(byte b8) {
            return p.hi(this.f34624b, b8);
        }

        @Override // kotlin.collections.c, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i7) {
            return s1.b(d(i7));
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof s1) {
                return f(((s1) obj).e0());
            }
            return -1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return t1.s(this.f34624b);
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof s1) {
                return g(((s1) obj).e0());
            }
            return -1;
        }
    }

    public static final class d extends kotlin.collections.c<g2> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ short[] f34625b;

        d(short[] sArr) {
            this.f34625b = sArr;
        }

        @Override // kotlin.collections.c, kotlin.collections.a
        public int a() {
            return h2.o(this.f34625b);
        }

        public boolean b(short s7) {
            return h2.h(this.f34625b, s7);
        }

        @Override // kotlin.collections.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof g2) {
                return b(((g2) obj).e0());
            }
            return false;
        }

        public short d(int i7) {
            return h2.m(this.f34625b, i7);
        }

        public int f(short s7) {
            return p.kg(this.f34625b, s7);
        }

        public int g(short s7) {
            return p.oi(this.f34625b, s7);
        }

        @Override // kotlin.collections.c, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i7) {
            return g2.b(d(i7));
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof g2) {
                return f(((g2) obj).e0());
            }
            return -1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return h2.s(this.f34625b);
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof g2) {
                return g(((g2) obj).e0());
            }
            return -1;
        }
    }

    @g1(version = "1.3")
    @k(message = "Use maxWithOrNull instead.", replaceWith = @b1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    @t
    public static final /* synthetic */ g2 A(short[] maxWith, Comparator comparator) {
        l0.p(maxWith, "$this$maxWith");
        l0.p(comparator, "comparator");
        return kotlin.collections.unsigned.c.M6(maxWith, comparator);
    }

    @g1(version = "1.3")
    @k(message = "Use maxWithOrNull instead.", replaceWith = @b1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    @t
    public static final /* synthetic */ a2 B(long[] maxWith, Comparator comparator) {
        l0.p(maxWith, "$this$maxWith");
        l0.p(comparator, "comparator");
        return kotlin.collections.unsigned.c.N6(maxWith, comparator);
    }

    @g1(version = "1.3")
    @k(message = "Use minOrNull instead.", replaceWith = @b1(expression = "this.minOrNull()", imports = {}))
    @l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    @t
    public static final /* synthetic */ w1 C(int[] min) {
        l0.p(min, "$this$min");
        return kotlin.collections.unsigned.c.G7(min);
    }

    @g1(version = "1.3")
    @k(message = "Use minOrNull instead.", replaceWith = @b1(expression = "this.minOrNull()", imports = {}))
    @l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    @t
    public static final /* synthetic */ s1 D(byte[] min) {
        l0.p(min, "$this$min");
        return kotlin.collections.unsigned.c.H7(min);
    }

    @g1(version = "1.3")
    @k(message = "Use minOrNull instead.", replaceWith = @b1(expression = "this.minOrNull()", imports = {}))
    @l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    @t
    public static final /* synthetic */ a2 E(long[] min) {
        l0.p(min, "$this$min");
        return kotlin.collections.unsigned.c.I7(min);
    }

    @g1(version = "1.3")
    @k(message = "Use minOrNull instead.", replaceWith = @b1(expression = "this.minOrNull()", imports = {}))
    @l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    @t
    public static final /* synthetic */ g2 F(short[] min) {
        l0.p(min, "$this$min");
        return kotlin.collections.unsigned.c.J7(min);
    }

    @g1(version = "1.3")
    @k(message = "Use minByOrNull instead.", replaceWith = @b1(expression = "this.minByOrNull(selector)", imports = {}))
    @l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    @t
    @f
    private static final /* synthetic */ <R extends Comparable<? super R>> s1 G(byte[] minBy, i5.l<? super s1, ? extends R> selector) {
        l0.p(minBy, "$this$minBy");
        l0.p(selector, "selector");
        if (t1.s(minBy)) {
            return null;
        }
        byte bM = t1.m(minBy, 0);
        int iRe = p.Re(minBy);
        if (iRe != 0) {
            R rZ = selector.z(s1.b(bM));
            u0 it = new kotlin.ranges.k(1, iRe).iterator();
            while (it.hasNext()) {
                byte bM2 = t1.m(minBy, it.b());
                R rZ2 = selector.z(s1.b(bM2));
                if (rZ.compareTo(rZ2) > 0) {
                    bM = bM2;
                    rZ = rZ2;
                }
            }
        }
        return s1.b(bM);
    }

    @g1(version = "1.3")
    @k(message = "Use minByOrNull instead.", replaceWith = @b1(expression = "this.minByOrNull(selector)", imports = {}))
    @l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    @t
    @f
    private static final /* synthetic */ <R extends Comparable<? super R>> a2 H(long[] minBy, i5.l<? super a2, ? extends R> selector) {
        l0.p(minBy, "$this$minBy");
        l0.p(selector, "selector");
        if (b2.s(minBy)) {
            return null;
        }
        long jM = b2.m(minBy, 0);
        int iWe = p.We(minBy);
        if (iWe != 0) {
            R rZ = selector.z(a2.b(jM));
            u0 it = new kotlin.ranges.k(1, iWe).iterator();
            while (it.hasNext()) {
                long jM2 = b2.m(minBy, it.b());
                R rZ2 = selector.z(a2.b(jM2));
                if (rZ.compareTo(rZ2) > 0) {
                    jM = jM2;
                    rZ = rZ2;
                }
            }
        }
        return a2.b(jM);
    }

    @g1(version = "1.3")
    @k(message = "Use minByOrNull instead.", replaceWith = @b1(expression = "this.minByOrNull(selector)", imports = {}))
    @l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    @t
    @f
    private static final /* synthetic */ <R extends Comparable<? super R>> w1 I(int[] minBy, i5.l<? super w1, ? extends R> selector) {
        l0.p(minBy, "$this$minBy");
        l0.p(selector, "selector");
        if (x1.s(minBy)) {
            return null;
        }
        int iM = x1.m(minBy, 0);
        int iVe = p.Ve(minBy);
        if (iVe != 0) {
            R rZ = selector.z(w1.b(iM));
            u0 it = new kotlin.ranges.k(1, iVe).iterator();
            while (it.hasNext()) {
                int iM2 = x1.m(minBy, it.b());
                R rZ2 = selector.z(w1.b(iM2));
                if (rZ.compareTo(rZ2) > 0) {
                    iM = iM2;
                    rZ = rZ2;
                }
            }
        }
        return w1.b(iM);
    }

    @g1(version = "1.3")
    @k(message = "Use minByOrNull instead.", replaceWith = @b1(expression = "this.minByOrNull(selector)", imports = {}))
    @l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    @t
    @f
    private static final /* synthetic */ <R extends Comparable<? super R>> g2 J(short[] minBy, i5.l<? super g2, ? extends R> selector) {
        l0.p(minBy, "$this$minBy");
        l0.p(selector, "selector");
        if (h2.s(minBy)) {
            return null;
        }
        short sM = h2.m(minBy, 0);
        int iYe = p.Ye(minBy);
        if (iYe != 0) {
            R rZ = selector.z(g2.b(sM));
            u0 it = new kotlin.ranges.k(1, iYe).iterator();
            while (it.hasNext()) {
                short sM2 = h2.m(minBy, it.b());
                R rZ2 = selector.z(g2.b(sM2));
                if (rZ.compareTo(rZ2) > 0) {
                    sM = sM2;
                    rZ = rZ2;
                }
            }
        }
        return g2.b(sM);
    }

    @g1(version = "1.3")
    @k(message = "Use minWithOrNull instead.", replaceWith = @b1(expression = "this.minWithOrNull(comparator)", imports = {}))
    @l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    @t
    public static final /* synthetic */ s1 K(byte[] minWith, Comparator comparator) {
        l0.p(minWith, "$this$minWith");
        l0.p(comparator, "comparator");
        return kotlin.collections.unsigned.c.O7(minWith, comparator);
    }

    @g1(version = "1.3")
    @k(message = "Use minWithOrNull instead.", replaceWith = @b1(expression = "this.minWithOrNull(comparator)", imports = {}))
    @l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    @t
    public static final /* synthetic */ w1 L(int[] minWith, Comparator comparator) {
        l0.p(minWith, "$this$minWith");
        l0.p(comparator, "comparator");
        return kotlin.collections.unsigned.c.P7(minWith, comparator);
    }

    @g1(version = "1.3")
    @k(message = "Use minWithOrNull instead.", replaceWith = @b1(expression = "this.minWithOrNull(comparator)", imports = {}))
    @l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    @t
    public static final /* synthetic */ g2 M(short[] minWith, Comparator comparator) {
        l0.p(minWith, "$this$minWith");
        l0.p(comparator, "comparator");
        return kotlin.collections.unsigned.c.Q7(minWith, comparator);
    }

    @g1(version = "1.3")
    @k(message = "Use minWithOrNull instead.", replaceWith = @b1(expression = "this.minWithOrNull(comparator)", imports = {}))
    @l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    @t
    public static final /* synthetic */ a2 N(long[] minWith, Comparator comparator) {
        l0.p(minWith, "$this$minWith");
        l0.p(comparator, "comparator");
        return kotlin.collections.unsigned.c.R7(minWith, comparator);
    }

    @g1(version = "1.4")
    @t
    @h(name = "sumOfBigDecimal")
    @t0
    @f
    private static final BigDecimal O(byte[] sumOf, i5.l<? super s1, ? extends BigDecimal> selector) {
        l0.p(sumOf, "$this$sumOf");
        l0.p(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        l0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        int iO = t1.o(sumOf);
        for (int i7 = 0; i7 < iO; i7++) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.z(s1.b(t1.m(sumOf, i7))));
            l0.o(bigDecimalValueOf, "this.add(other)");
        }
        return bigDecimalValueOf;
    }

    @g1(version = "1.4")
    @t
    @h(name = "sumOfBigDecimal")
    @t0
    @f
    private static final BigDecimal P(int[] sumOf, i5.l<? super w1, ? extends BigDecimal> selector) {
        l0.p(sumOf, "$this$sumOf");
        l0.p(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        l0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        int iO = x1.o(sumOf);
        for (int i7 = 0; i7 < iO; i7++) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.z(w1.b(x1.m(sumOf, i7))));
            l0.o(bigDecimalValueOf, "this.add(other)");
        }
        return bigDecimalValueOf;
    }

    @g1(version = "1.4")
    @t
    @h(name = "sumOfBigDecimal")
    @t0
    @f
    private static final BigDecimal Q(long[] sumOf, i5.l<? super a2, ? extends BigDecimal> selector) {
        l0.p(sumOf, "$this$sumOf");
        l0.p(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        l0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        int iO = b2.o(sumOf);
        for (int i7 = 0; i7 < iO; i7++) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.z(a2.b(b2.m(sumOf, i7))));
            l0.o(bigDecimalValueOf, "this.add(other)");
        }
        return bigDecimalValueOf;
    }

    @g1(version = "1.4")
    @t
    @h(name = "sumOfBigDecimal")
    @t0
    @f
    private static final BigDecimal R(short[] sumOf, i5.l<? super g2, ? extends BigDecimal> selector) {
        l0.p(sumOf, "$this$sumOf");
        l0.p(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        l0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        int iO = h2.o(sumOf);
        for (int i7 = 0; i7 < iO; i7++) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.z(g2.b(h2.m(sumOf, i7))));
            l0.o(bigDecimalValueOf, "this.add(other)");
        }
        return bigDecimalValueOf;
    }

    @g1(version = "1.4")
    @t
    @h(name = "sumOfBigInteger")
    @t0
    @f
    private static final BigInteger S(byte[] sumOf, i5.l<? super s1, ? extends BigInteger> selector) {
        l0.p(sumOf, "$this$sumOf");
        l0.p(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        l0.o(bigIntegerValueOf, "valueOf(this.toLong())");
        int iO = t1.o(sumOf);
        for (int i7 = 0; i7 < iO; i7++) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.z(s1.b(t1.m(sumOf, i7))));
            l0.o(bigIntegerValueOf, "this.add(other)");
        }
        return bigIntegerValueOf;
    }

    @g1(version = "1.4")
    @t
    @h(name = "sumOfBigInteger")
    @t0
    @f
    private static final BigInteger T(int[] sumOf, i5.l<? super w1, ? extends BigInteger> selector) {
        l0.p(sumOf, "$this$sumOf");
        l0.p(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        l0.o(bigIntegerValueOf, "valueOf(this.toLong())");
        int iO = x1.o(sumOf);
        for (int i7 = 0; i7 < iO; i7++) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.z(w1.b(x1.m(sumOf, i7))));
            l0.o(bigIntegerValueOf, "this.add(other)");
        }
        return bigIntegerValueOf;
    }

    @g1(version = "1.4")
    @t
    @h(name = "sumOfBigInteger")
    @t0
    @f
    private static final BigInteger U(long[] sumOf, i5.l<? super a2, ? extends BigInteger> selector) {
        l0.p(sumOf, "$this$sumOf");
        l0.p(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        l0.o(bigIntegerValueOf, "valueOf(this.toLong())");
        int iO = b2.o(sumOf);
        for (int i7 = 0; i7 < iO; i7++) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.z(a2.b(b2.m(sumOf, i7))));
            l0.o(bigIntegerValueOf, "this.add(other)");
        }
        return bigIntegerValueOf;
    }

    @g1(version = "1.4")
    @t
    @h(name = "sumOfBigInteger")
    @t0
    @f
    private static final BigInteger V(short[] sumOf, i5.l<? super g2, ? extends BigInteger> selector) {
        l0.p(sumOf, "$this$sumOf");
        l0.p(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        l0.o(bigIntegerValueOf, "valueOf(this.toLong())");
        int iO = h2.o(sumOf);
        for (int i7 = 0; i7 < iO; i7++) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.z(g2.b(h2.m(sumOf, i7))));
            l0.o(bigIntegerValueOf, "this.add(other)");
        }
        return bigIntegerValueOf;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<w1> a(@a7.d int[] asList) {
        l0.p(asList, "$this$asList");
        return new a(asList);
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<s1> b(@a7.d byte[] asList) {
        l0.p(asList, "$this$asList");
        return new c(asList);
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<a2> c(@a7.d long[] asList) {
        l0.p(asList, "$this$asList");
        return new C0426b(asList);
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<g2> d(@a7.d short[] asList) {
        l0.p(asList, "$this$asList");
        return new d(asList);
    }

    @g1(version = "1.3")
    @t
    public static final int e(@a7.d int[] binarySearch, int i7, int i8, int i9) {
        l0.p(binarySearch, "$this$binarySearch");
        kotlin.collections.c.f34509a.d(i8, i9, x1.o(binarySearch));
        int i10 = i9 - 1;
        while (i8 <= i10) {
            int i11 = (i8 + i10) >>> 1;
            int iC = o2.c(binarySearch[i11], i7);
            if (iC < 0) {
                i8 = i11 + 1;
            } else {
                if (iC <= 0) {
                    return i11;
                }
                i10 = i11 - 1;
            }
        }
        return -(i8 + 1);
    }

    public static /* synthetic */ int f(int[] iArr, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i8 = 0;
        }
        if ((i10 & 4) != 0) {
            i9 = x1.o(iArr);
        }
        return e(iArr, i7, i8, i9);
    }

    @g1(version = "1.3")
    @t
    public static final int g(@a7.d short[] binarySearch, short s7, int i7, int i8) {
        l0.p(binarySearch, "$this$binarySearch");
        kotlin.collections.c.f34509a.d(i7, i8, h2.o(binarySearch));
        int i9 = s7 & g2.f34732d;
        int i10 = i8 - 1;
        while (i7 <= i10) {
            int i11 = (i7 + i10) >>> 1;
            int iC = o2.c(binarySearch[i11], i9);
            if (iC < 0) {
                i7 = i11 + 1;
            } else {
                if (iC <= 0) {
                    return i11;
                }
                i10 = i11 - 1;
            }
        }
        return -(i7 + 1);
    }

    public static /* synthetic */ int h(short[] sArr, short s7, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = h2.o(sArr);
        }
        return g(sArr, s7, i7, i8);
    }

    @g1(version = "1.3")
    @t
    public static final int i(@a7.d long[] binarySearch, long j7, int i7, int i8) {
        l0.p(binarySearch, "$this$binarySearch");
        kotlin.collections.c.f34509a.d(i7, i8, b2.o(binarySearch));
        int i9 = i8 - 1;
        while (i7 <= i9) {
            int i10 = (i7 + i9) >>> 1;
            int iG = o2.g(binarySearch[i10], j7);
            if (iG < 0) {
                i7 = i10 + 1;
            } else {
                if (iG <= 0) {
                    return i10;
                }
                i9 = i10 - 1;
            }
        }
        return -(i7 + 1);
    }

    public static /* synthetic */ int j(long[] jArr, long j7, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = b2.o(jArr);
        }
        return i(jArr, j7, i7, i8);
    }

    @g1(version = "1.3")
    @t
    public static final int k(@a7.d byte[] binarySearch, byte b8, int i7, int i8) {
        l0.p(binarySearch, "$this$binarySearch");
        kotlin.collections.c.f34509a.d(i7, i8, t1.o(binarySearch));
        int i9 = b8 & 255;
        int i10 = i8 - 1;
        while (i7 <= i10) {
            int i11 = (i7 + i10) >>> 1;
            int iC = o2.c(binarySearch[i11], i9);
            if (iC < 0) {
                i7 = i11 + 1;
            } else {
                if (iC <= 0) {
                    return i11;
                }
                i10 = i11 - 1;
            }
        }
        return -(i7 + 1);
    }

    public static /* synthetic */ int l(byte[] bArr, byte b8, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = t1.o(bArr);
        }
        return k(bArr, b8, i7, i8);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final byte m(byte[] elementAt, int i7) {
        l0.p(elementAt, "$this$elementAt");
        return t1.m(elementAt, i7);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final short n(short[] elementAt, int i7) {
        l0.p(elementAt, "$this$elementAt");
        return h2.m(elementAt, i7);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int o(int[] elementAt, int i7) {
        l0.p(elementAt, "$this$elementAt");
        return x1.m(elementAt, i7);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final long p(long[] elementAt, int i7) {
        l0.p(elementAt, "$this$elementAt");
        return b2.m(elementAt, i7);
    }

    @g1(version = "1.3")
    @k(message = "Use maxOrNull instead.", replaceWith = @b1(expression = "this.maxOrNull()", imports = {}))
    @l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    @t
    public static final /* synthetic */ w1 q(int[] max) {
        l0.p(max, "$this$max");
        return kotlin.collections.unsigned.c.C6(max);
    }

    @g1(version = "1.3")
    @k(message = "Use maxOrNull instead.", replaceWith = @b1(expression = "this.maxOrNull()", imports = {}))
    @l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    @t
    public static final /* synthetic */ s1 r(byte[] max) {
        l0.p(max, "$this$max");
        return kotlin.collections.unsigned.c.D6(max);
    }

    @g1(version = "1.3")
    @k(message = "Use maxOrNull instead.", replaceWith = @b1(expression = "this.maxOrNull()", imports = {}))
    @l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    @t
    public static final /* synthetic */ a2 s(long[] max) {
        l0.p(max, "$this$max");
        return kotlin.collections.unsigned.c.E6(max);
    }

    @g1(version = "1.3")
    @k(message = "Use maxOrNull instead.", replaceWith = @b1(expression = "this.maxOrNull()", imports = {}))
    @l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    @t
    public static final /* synthetic */ g2 t(short[] max) {
        l0.p(max, "$this$max");
        return kotlin.collections.unsigned.c.F6(max);
    }

    @g1(version = "1.3")
    @k(message = "Use maxByOrNull instead.", replaceWith = @b1(expression = "this.maxByOrNull(selector)", imports = {}))
    @l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    @t
    @f
    private static final /* synthetic */ <R extends Comparable<? super R>> s1 u(byte[] maxBy, i5.l<? super s1, ? extends R> selector) {
        l0.p(maxBy, "$this$maxBy");
        l0.p(selector, "selector");
        if (t1.s(maxBy)) {
            return null;
        }
        byte bM = t1.m(maxBy, 0);
        int iRe = p.Re(maxBy);
        if (iRe != 0) {
            R rZ = selector.z(s1.b(bM));
            u0 it = new kotlin.ranges.k(1, iRe).iterator();
            while (it.hasNext()) {
                byte bM2 = t1.m(maxBy, it.b());
                R rZ2 = selector.z(s1.b(bM2));
                if (rZ.compareTo(rZ2) < 0) {
                    bM = bM2;
                    rZ = rZ2;
                }
            }
        }
        return s1.b(bM);
    }

    @g1(version = "1.3")
    @k(message = "Use maxByOrNull instead.", replaceWith = @b1(expression = "this.maxByOrNull(selector)", imports = {}))
    @l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    @t
    @f
    private static final /* synthetic */ <R extends Comparable<? super R>> a2 v(long[] maxBy, i5.l<? super a2, ? extends R> selector) {
        l0.p(maxBy, "$this$maxBy");
        l0.p(selector, "selector");
        if (b2.s(maxBy)) {
            return null;
        }
        long jM = b2.m(maxBy, 0);
        int iWe = p.We(maxBy);
        if (iWe != 0) {
            R rZ = selector.z(a2.b(jM));
            u0 it = new kotlin.ranges.k(1, iWe).iterator();
            while (it.hasNext()) {
                long jM2 = b2.m(maxBy, it.b());
                R rZ2 = selector.z(a2.b(jM2));
                if (rZ.compareTo(rZ2) < 0) {
                    jM = jM2;
                    rZ = rZ2;
                }
            }
        }
        return a2.b(jM);
    }

    @g1(version = "1.3")
    @k(message = "Use maxByOrNull instead.", replaceWith = @b1(expression = "this.maxByOrNull(selector)", imports = {}))
    @l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    @t
    @f
    private static final /* synthetic */ <R extends Comparable<? super R>> w1 w(int[] maxBy, i5.l<? super w1, ? extends R> selector) {
        l0.p(maxBy, "$this$maxBy");
        l0.p(selector, "selector");
        if (x1.s(maxBy)) {
            return null;
        }
        int iM = x1.m(maxBy, 0);
        int iVe = p.Ve(maxBy);
        if (iVe != 0) {
            R rZ = selector.z(w1.b(iM));
            u0 it = new kotlin.ranges.k(1, iVe).iterator();
            while (it.hasNext()) {
                int iM2 = x1.m(maxBy, it.b());
                R rZ2 = selector.z(w1.b(iM2));
                if (rZ.compareTo(rZ2) < 0) {
                    iM = iM2;
                    rZ = rZ2;
                }
            }
        }
        return w1.b(iM);
    }

    @g1(version = "1.3")
    @k(message = "Use maxByOrNull instead.", replaceWith = @b1(expression = "this.maxByOrNull(selector)", imports = {}))
    @l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    @t
    @f
    private static final /* synthetic */ <R extends Comparable<? super R>> g2 x(short[] maxBy, i5.l<? super g2, ? extends R> selector) {
        l0.p(maxBy, "$this$maxBy");
        l0.p(selector, "selector");
        if (h2.s(maxBy)) {
            return null;
        }
        short sM = h2.m(maxBy, 0);
        int iYe = p.Ye(maxBy);
        if (iYe != 0) {
            R rZ = selector.z(g2.b(sM));
            u0 it = new kotlin.ranges.k(1, iYe).iterator();
            while (it.hasNext()) {
                short sM2 = h2.m(maxBy, it.b());
                R rZ2 = selector.z(g2.b(sM2));
                if (rZ.compareTo(rZ2) < 0) {
                    sM = sM2;
                    rZ = rZ2;
                }
            }
        }
        return g2.b(sM);
    }

    @g1(version = "1.3")
    @k(message = "Use maxWithOrNull instead.", replaceWith = @b1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    @t
    public static final /* synthetic */ s1 y(byte[] maxWith, Comparator comparator) {
        l0.p(maxWith, "$this$maxWith");
        l0.p(comparator, "comparator");
        return kotlin.collections.unsigned.c.K6(maxWith, comparator);
    }

    @g1(version = "1.3")
    @k(message = "Use maxWithOrNull instead.", replaceWith = @b1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    @t
    public static final /* synthetic */ w1 z(int[] maxWith, Comparator comparator) {
        l0.p(maxWith, "$this$maxWith");
        l0.p(comparator, "comparator");
        return kotlin.collections.unsigned.c.L6(maxWith, comparator);
    }
}
