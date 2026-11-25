package kotlin.time;

import kotlin.a1;
import kotlin.b1;
import kotlin.g1;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import kotlin.q2;
import kotlin.text.c0;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
@h5.f
@g1(version = i2.a.f34096f)
@q2(markerClass = {k.class})
public final class d implements Comparable<d> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    public static final a f35456b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f35457c = i(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f35458d = f.j(f.f35465c);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f35459e = f.j(-4611686018427387903L);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f35460a;

    public static final class a {
        public /* synthetic */ a(w wVar) {
            this();
        }

        @kotlin.internal.f
        public static /* synthetic */ void A(double d8) {
        }

        @kotlin.internal.f
        public static /* synthetic */ void B(int i7) {
        }

        @kotlin.internal.f
        public static /* synthetic */ void C(long j7) {
        }

        private final long D(double d8) {
            return f.l0(d8, g.MINUTES);
        }

        private final long E(int i7) {
            return f.m0(i7, g.MINUTES);
        }

        private final long F(long j7) {
            return f.n0(j7, g.MINUTES);
        }

        @kotlin.internal.f
        public static /* synthetic */ void G(double d8) {
        }

        @kotlin.internal.f
        public static /* synthetic */ void H(int i7) {
        }

        @kotlin.internal.f
        public static /* synthetic */ void I(long j7) {
        }

        private final long K(double d8) {
            return f.l0(d8, g.NANOSECONDS);
        }

        private final long L(int i7) {
            return f.m0(i7, g.NANOSECONDS);
        }

        private final long M(long j7) {
            return f.n0(j7, g.NANOSECONDS);
        }

        @kotlin.internal.f
        public static /* synthetic */ void N(double d8) {
        }

        @kotlin.internal.f
        public static /* synthetic */ void O(int i7) {
        }

        @kotlin.internal.f
        public static /* synthetic */ void P(long j7) {
        }

        private final long Q(double d8) {
            return f.l0(d8, g.SECONDS);
        }

        private final long R(int i7) {
            return f.m0(i7, g.SECONDS);
        }

        private final long S(long j7) {
            return f.n0(j7, g.SECONDS);
        }

        @kotlin.internal.f
        public static /* synthetic */ void T(double d8) {
        }

        @kotlin.internal.f
        public static /* synthetic */ void U(int i7) {
        }

        @kotlin.internal.f
        public static /* synthetic */ void V(long j7) {
        }

        private final long e(double d8) {
            return f.l0(d8, g.DAYS);
        }

        private final long f(int i7) {
            return f.m0(i7, g.DAYS);
        }

        private final long g(long j7) {
            return f.n0(j7, g.DAYS);
        }

        @kotlin.internal.f
        public static /* synthetic */ void h(double d8) {
        }

        @kotlin.internal.f
        public static /* synthetic */ void i(int i7) {
        }

        @kotlin.internal.f
        public static /* synthetic */ void j(long j7) {
        }

        private final long k(double d8) {
            return f.l0(d8, g.HOURS);
        }

        private final long l(int i7) {
            return f.m0(i7, g.HOURS);
        }

        private final long m(long j7) {
            return f.n0(j7, g.HOURS);
        }

        @kotlin.internal.f
        public static /* synthetic */ void n(double d8) {
        }

        @kotlin.internal.f
        public static /* synthetic */ void o(int i7) {
        }

        @kotlin.internal.f
        public static /* synthetic */ void p(long j7) {
        }

        private final long r(double d8) {
            return f.l0(d8, g.MICROSECONDS);
        }

        private final long s(int i7) {
            return f.m0(i7, g.MICROSECONDS);
        }

        private final long t(long j7) {
            return f.n0(j7, g.MICROSECONDS);
        }

        @kotlin.internal.f
        public static /* synthetic */ void u(double d8) {
        }

        @kotlin.internal.f
        public static /* synthetic */ void v(int i7) {
        }

        @kotlin.internal.f
        public static /* synthetic */ void w(long j7) {
        }

        private final long x(double d8) {
            return f.l0(d8, g.MILLISECONDS);
        }

        private final long y(int i7) {
            return f.m0(i7, g.MILLISECONDS);
        }

        private final long z(long j7) {
            return f.n0(j7, g.MILLISECONDS);
        }

        public final long J() {
            return d.f35459e;
        }

        public final long W() {
            return d.f35457c;
        }

        @g1(version = "1.5")
        @kotlin.k(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @kotlin.l(warningSince = i2.a.f34096f)
        @k
        public final long X(double d8) {
            return f.l0(d8, g.HOURS);
        }

        @g1(version = "1.5")
        @kotlin.k(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @kotlin.l(warningSince = i2.a.f34096f)
        @k
        public final long Y(int i7) {
            return f.m0(i7, g.HOURS);
        }

        @g1(version = "1.5")
        @kotlin.k(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @kotlin.l(warningSince = i2.a.f34096f)
        @k
        public final long Z(long j7) {
            return f.n0(j7, g.HOURS);
        }

        @k
        public final double a(double d8, @a7.d g sourceUnit, @a7.d g targetUnit) {
            l0.p(sourceUnit, "sourceUnit");
            l0.p(targetUnit, "targetUnit");
            return i.a(d8, sourceUnit, targetUnit);
        }

        @g1(version = "1.5")
        @kotlin.k(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @kotlin.l(warningSince = i2.a.f34096f)
        @k
        public final long a0(double d8) {
            return f.l0(d8, g.MICROSECONDS);
        }

        @g1(version = "1.5")
        @kotlin.k(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @kotlin.l(warningSince = i2.a.f34096f)
        @k
        public final long b(double d8) {
            return f.l0(d8, g.DAYS);
        }

        @g1(version = "1.5")
        @kotlin.k(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @kotlin.l(warningSince = i2.a.f34096f)
        @k
        public final long b0(int i7) {
            return f.m0(i7, g.MICROSECONDS);
        }

        @g1(version = "1.5")
        @kotlin.k(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @kotlin.l(warningSince = i2.a.f34096f)
        @k
        public final long c(int i7) {
            return f.m0(i7, g.DAYS);
        }

        @g1(version = "1.5")
        @kotlin.k(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @kotlin.l(warningSince = i2.a.f34096f)
        @k
        public final long c0(long j7) {
            return f.n0(j7, g.MICROSECONDS);
        }

        @g1(version = "1.5")
        @kotlin.k(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @kotlin.l(warningSince = i2.a.f34096f)
        @k
        public final long d(long j7) {
            return f.n0(j7, g.DAYS);
        }

        @g1(version = "1.5")
        @kotlin.k(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @kotlin.l(warningSince = i2.a.f34096f)
        @k
        public final long d0(double d8) {
            return f.l0(d8, g.MILLISECONDS);
        }

        @g1(version = "1.5")
        @kotlin.k(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @kotlin.l(warningSince = i2.a.f34096f)
        @k
        public final long e0(int i7) {
            return f.m0(i7, g.MILLISECONDS);
        }

        @g1(version = "1.5")
        @kotlin.k(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @kotlin.l(warningSince = i2.a.f34096f)
        @k
        public final long f0(long j7) {
            return f.n0(j7, g.MILLISECONDS);
        }

        @g1(version = "1.5")
        @kotlin.k(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @kotlin.l(warningSince = i2.a.f34096f)
        @k
        public final long g0(double d8) {
            return f.l0(d8, g.MINUTES);
        }

        @g1(version = "1.5")
        @kotlin.k(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @kotlin.l(warningSince = i2.a.f34096f)
        @k
        public final long h0(int i7) {
            return f.m0(i7, g.MINUTES);
        }

        @g1(version = "1.5")
        @kotlin.k(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @kotlin.l(warningSince = i2.a.f34096f)
        @k
        public final long i0(long j7) {
            return f.n0(j7, g.MINUTES);
        }

        @g1(version = "1.5")
        @kotlin.k(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @kotlin.l(warningSince = i2.a.f34096f)
        @k
        public final long j0(double d8) {
            return f.l0(d8, g.NANOSECONDS);
        }

        @g1(version = "1.5")
        @kotlin.k(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @kotlin.l(warningSince = i2.a.f34096f)
        @k
        public final long k0(int i7) {
            return f.m0(i7, g.NANOSECONDS);
        }

        @g1(version = "1.5")
        @kotlin.k(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @kotlin.l(warningSince = i2.a.f34096f)
        @k
        public final long l0(long j7) {
            return f.n0(j7, g.NANOSECONDS);
        }

        public final long m0(@a7.d String value) {
            l0.p(value, "value");
            try {
                return f.f0(value, false);
            } catch (IllegalArgumentException e8) {
                throw new IllegalArgumentException("Invalid duration string format: '" + value + "'.", e8);
            }
        }

        public final long n0(@a7.d String value) {
            l0.p(value, "value");
            try {
                return f.f0(value, true);
            } catch (IllegalArgumentException e8) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e8);
            }
        }

        @a7.e
        public final d o0(@a7.d String value) {
            l0.p(value, "value");
            try {
                return d.f(f.f0(value, true));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @a7.e
        public final d p0(@a7.d String value) {
            l0.p(value, "value");
            try {
                return d.f(f.f0(value, false));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public final long q() {
            return d.f35458d;
        }

        @g1(version = "1.5")
        @kotlin.k(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @kotlin.l(warningSince = i2.a.f34096f)
        @k
        public final long q0(double d8) {
            return f.l0(d8, g.SECONDS);
        }

        @g1(version = "1.5")
        @kotlin.k(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @kotlin.l(warningSince = i2.a.f34096f)
        @k
        public final long r0(int i7) {
            return f.m0(i7, g.SECONDS);
        }

        @g1(version = "1.5")
        @kotlin.k(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @kotlin.l(warningSince = i2.a.f34096f)
        @k
        public final long s0(long j7) {
            return f.n0(j7, g.SECONDS);
        }

        private a() {
        }
    }

    private /* synthetic */ d(long j7) {
        this.f35460a = j7;
    }

    public static final double A(long j7) {
        return k0(j7, g.MINUTES);
    }

    @kotlin.k(message = "Use inWholeNanoseconds property instead or convert toDouble(NANOSECONDS) if a double value is required.", replaceWith = @b1(expression = "toDouble(DurationUnit.NANOSECONDS)", imports = {}))
    @k
    public static /* synthetic */ void B() {
    }

    public static final double C(long j7) {
        return k0(j7, g.NANOSECONDS);
    }

    @kotlin.k(message = "Use inWholeSeconds property instead or convert toDouble(SECONDS) if a double value is required.", replaceWith = @b1(expression = "toDouble(DurationUnit.SECONDS)", imports = {}))
    @k
    public static /* synthetic */ void D() {
    }

    public static final double E(long j7) {
        return k0(j7, g.SECONDS);
    }

    public static final long F(long j7) {
        return n0(j7, g.DAYS);
    }

    public static final long G(long j7) {
        return n0(j7, g.HOURS);
    }

    public static final long H(long j7) {
        return n0(j7, g.MICROSECONDS);
    }

    public static final long I(long j7) {
        return (X(j7) && W(j7)) ? U(j7) : n0(j7, g.MILLISECONDS);
    }

    public static final long J(long j7) {
        return n0(j7, g.MINUTES);
    }

    public static final long K(long j7) {
        long jU = U(j7);
        if (Y(j7)) {
            return jU;
        }
        if (jU > 9223372036854L) {
            return Long.MAX_VALUE;
        }
        if (jU < -9223372036854L) {
            return Long.MIN_VALUE;
        }
        return f.d0(jU);
    }

    public static final long L(long j7) {
        return n0(j7, g.SECONDS);
    }

    @a1
    public static /* synthetic */ void M() {
    }

    public static final int N(long j7) {
        if (Z(j7)) {
            return 0;
        }
        return (int) (J(j7) % ((long) 60));
    }

    @a1
    public static /* synthetic */ void O() {
    }

    public static final int P(long j7) {
        if (Z(j7)) {
            return 0;
        }
        return (int) (X(j7) ? f.d0(U(j7) % ((long) 1000)) : U(j7) % ((long) 1000000000));
    }

    @a1
    public static /* synthetic */ void Q() {
    }

    public static final int R(long j7) {
        if (Z(j7)) {
            return 0;
        }
        return (int) (L(j7) % ((long) 60));
    }

    private static final g S(long j7) {
        return Y(j7) ? g.NANOSECONDS : g.MILLISECONDS;
    }

    private static final int T(long j7) {
        return ((int) j7) & 1;
    }

    private static final long U(long j7) {
        return j7 >> 1;
    }

    public static int V(long j7) {
        return (int) (j7 ^ (j7 >>> 32));
    }

    public static final boolean W(long j7) {
        return !Z(j7);
    }

    private static final boolean X(long j7) {
        return (((int) j7) & 1) == 1;
    }

    private static final boolean Y(long j7) {
        return (((int) j7) & 1) == 0;
    }

    public static final boolean Z(long j7) {
        return j7 == f35458d || j7 == f35459e;
    }

    public static final boolean a0(long j7) {
        return j7 < 0;
    }

    public static final boolean b0(long j7) {
        return j7 > 0;
    }

    public static final long c0(long j7, long j8) {
        return d0(j7, t0(j8));
    }

    private static final long d(long j7, long j8, long j9) {
        long jE0 = f.e0(j9);
        long j10 = j8 + jE0;
        if (!new kotlin.ranges.n(-4611686018426L, 4611686018426L).m(j10)) {
            return f.j(kotlin.ranges.q.D(j10, -4611686018427387903L, f.f35465c));
        }
        return f.l(f.d0(j10) + (j9 - f.d0(jE0)));
    }

    public static final long d0(long j7, long j8) {
        if (Z(j7)) {
            if (W(j8) || (j8 ^ j7) >= 0) {
                return j7;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        if (Z(j8)) {
            return j8;
        }
        if ((((int) j7) & 1) != (((int) j8) & 1)) {
            return X(j7) ? d(j7, U(j7), U(j8)) : d(j7, U(j8), U(j7));
        }
        long jU = U(j7) + U(j8);
        return Y(j7) ? f.m(jU) : f.k(jU);
    }

    private static final void e(long j7, StringBuilder sb, int i7, int i8, int i9, String str, boolean z7) {
        sb.append(i7);
        if (i8 != 0) {
            sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            String strT3 = c0.T3(String.valueOf(i8), i9, '0');
            int i10 = -1;
            int length = strT3.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i11 = length - 1;
                    if (strT3.charAt(length) != '0') {
                        i10 = length;
                        break;
                    } else if (i11 < 0) {
                        break;
                    } else {
                        length = i11;
                    }
                }
            }
            int i12 = i10 + 1;
            if (z7 || i12 >= 3) {
                sb.append((CharSequence) strT3, 0, ((i12 + 2) / 3) * 3);
                l0.o(sb, "this.append(value, startIndex, endIndex)");
            } else {
                sb.append((CharSequence) strT3, 0, i12);
                l0.o(sb, "this.append(value, startIndex, endIndex)");
            }
        }
        sb.append(str);
    }

    public static final long e0(long j7, double d8) {
        int iI0 = kotlin.math.d.I0(d8);
        if (((double) iI0) == d8) {
            return f0(j7, iI0);
        }
        g gVarS = S(j7);
        return f.l0(k0(j7, gVarS) * d8, gVarS);
    }

    public static final /* synthetic */ d f(long j7) {
        return new d(j7);
    }

    public static final long f0(long j7, int i7) {
        if (Z(j7)) {
            if (i7 != 0) {
                return i7 > 0 ? j7 : t0(j7);
            }
            throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        }
        if (i7 == 0) {
            return f35457c;
        }
        long jU = U(j7);
        long j8 = i7;
        long j9 = jU * j8;
        if (!Y(j7)) {
            if (j9 / j8 == jU) {
                return f.j(kotlin.ranges.q.E(j9, new kotlin.ranges.n(-4611686018427387903L, f.f35465c)));
            }
            return kotlin.math.d.T(jU) * kotlin.math.d.S(i7) > 0 ? f35458d : f35459e;
        }
        if (new kotlin.ranges.n(-2147483647L, 2147483647L).m(jU)) {
            return f.l(j9);
        }
        if (j9 / j8 == jU) {
            return f.m(j9);
        }
        long jE0 = f.e0(jU);
        long j10 = jE0 * j8;
        long jE1 = f.e0((jU - f.d0(jE0)) * j8) + j10;
        if (j10 / j8 != jE0 || (jE1 ^ j10) < 0) {
            return kotlin.math.d.T(jU) * kotlin.math.d.S(i7) > 0 ? f35458d : f35459e;
        }
        return f.j(kotlin.ranges.q.E(jE1, new kotlin.ranges.n(-4611686018427387903L, f.f35465c)));
    }

    public static final <T> T g0(long j7, @a7.d i5.p<? super Long, ? super Integer, ? extends T> action) {
        l0.p(action, "action");
        return action.a0(Long.valueOf(L(j7)), Integer.valueOf(P(j7)));
    }

    public static int h(long j7, long j8) {
        long j9 = j7 ^ j8;
        if (j9 < 0 || (((int) j9) & 1) == 0) {
            return l0.u(j7, j8);
        }
        int i7 = (((int) j7) & 1) - (((int) j8) & 1);
        return a0(j7) ? -i7 : i7;
    }

    public static final <T> T h0(long j7, @a7.d i5.q<? super Long, ? super Integer, ? super Integer, ? extends T> action) {
        l0.p(action, "action");
        return action.v(Long.valueOf(J(j7)), Integer.valueOf(R(j7)), Integer.valueOf(P(j7)));
    }

    public static long i(long j7) {
        if (e.d()) {
            if (Y(j7)) {
                if (!new kotlin.ranges.n(-4611686018426999999L, f.f35464b).m(U(j7))) {
                    throw new AssertionError(U(j7) + " ns is out of nanoseconds range");
                }
            } else {
                if (!new kotlin.ranges.n(-4611686018427387903L, f.f35465c).m(U(j7))) {
                    throw new AssertionError(U(j7) + " ms is out of milliseconds range");
                }
                if (new kotlin.ranges.n(-4611686018426L, 4611686018426L).m(U(j7))) {
                    throw new AssertionError(U(j7) + " ms is denormalized");
                }
            }
        }
        return j7;
    }

    public static final <T> T i0(long j7, @a7.d i5.r<? super Long, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        l0.p(action, "action");
        return action.K(Long.valueOf(G(j7)), Integer.valueOf(N(j7)), Integer.valueOf(R(j7)), Integer.valueOf(P(j7)));
    }

    public static final double j(long j7, long j8) {
        g gVar = (g) kotlin.comparisons.c.O(S(j7), S(j8));
        return k0(j7, gVar) / k0(j8, gVar);
    }

    public static final <T> T j0(long j7, @a7.d i5.s<? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        l0.p(action, "action");
        return action.d0(Long.valueOf(F(j7)), Integer.valueOf(q(j7)), Integer.valueOf(N(j7)), Integer.valueOf(R(j7)), Integer.valueOf(P(j7)));
    }

    public static final long k(long j7, double d8) {
        int iI0 = kotlin.math.d.I0(d8);
        if ((((double) iI0) == d8) && iI0 != 0) {
            return l(j7, iI0);
        }
        g gVarS = S(j7);
        return f.l0(k0(j7, gVarS) / d8, gVarS);
    }

    public static final double k0(long j7, @a7.d g unit) {
        l0.p(unit, "unit");
        if (j7 == f35458d) {
            return Double.POSITIVE_INFINITY;
        }
        if (j7 == f35459e) {
            return Double.NEGATIVE_INFINITY;
        }
        return i.a(U(j7), S(j7), unit);
    }

    public static final long l(long j7, int i7) {
        if (i7 == 0) {
            if (b0(j7)) {
                return f35458d;
            }
            if (a0(j7)) {
                return f35459e;
            }
            throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
        }
        if (Y(j7)) {
            return f.l(U(j7) / ((long) i7));
        }
        if (Z(j7)) {
            return f0(j7, kotlin.math.d.S(i7));
        }
        long j8 = i7;
        long jU = U(j7) / j8;
        if (!new kotlin.ranges.n(-4611686018426L, 4611686018426L).m(jU)) {
            return f.j(jU);
        }
        return f.l(f.d0(jU) + (f.d0(U(j7) - (jU * j8)) / j8));
    }

    public static final int l0(long j7, @a7.d g unit) {
        l0.p(unit, "unit");
        return (int) kotlin.ranges.q.D(n0(j7, unit), -2147483648L, 2147483647L);
    }

    public static boolean m(long j7, Object obj) {
        return (obj instanceof d) && j7 == ((d) obj).u0();
    }

    @a7.d
    public static final String m0(long j7) {
        StringBuilder sb = new StringBuilder();
        if (a0(j7)) {
            sb.append('-');
        }
        sb.append("PT");
        long jO = o(j7);
        long jG = G(jO);
        int iN = N(jO);
        int iR = R(jO);
        int iP = P(jO);
        if (Z(j7)) {
            jG = 9999999999999L;
        }
        boolean z7 = true;
        boolean z8 = jG != 0;
        boolean z9 = (iR == 0 && iP == 0) ? false : true;
        if (iN == 0 && (!z9 || !z8)) {
            z7 = false;
        }
        if (z8) {
            sb.append(jG);
            sb.append('H');
        }
        if (z7) {
            sb.append(iN);
            sb.append('M');
        }
        if (z9 || (!z8 && !z7)) {
            e(j7, sb, iR, iP, 9, "S", true);
        }
        String string = sb.toString();
        l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static final boolean n(long j7, long j8) {
        return j7 == j8;
    }

    public static final long n0(long j7, @a7.d g unit) {
        l0.p(unit, "unit");
        if (j7 == f35458d) {
            return Long.MAX_VALUE;
        }
        if (j7 == f35459e) {
            return Long.MIN_VALUE;
        }
        return i.b(U(j7), S(j7), unit);
    }

    public static final long o(long j7) {
        return a0(j7) ? t0(j7) : j7;
    }

    @kotlin.k(message = "Use inWholeMilliseconds property instead.", replaceWith = @b1(expression = "this.inWholeMilliseconds", imports = {}))
    @k
    public static final long o0(long j7) {
        return I(j7);
    }

    @a1
    public static /* synthetic */ void p() {
    }

    @kotlin.k(message = "Use inWholeNanoseconds property instead.", replaceWith = @b1(expression = "this.inWholeNanoseconds", imports = {}))
    @k
    public static final long p0(long j7) {
        return K(j7);
    }

    public static final int q(long j7) {
        if (Z(j7)) {
            return 0;
        }
        return (int) (G(j7) % ((long) 24));
    }

    @a7.d
    public static String q0(long j7) {
        if (j7 == 0) {
            return "0s";
        }
        if (j7 == f35458d) {
            return "Infinity";
        }
        if (j7 == f35459e) {
            return "-Infinity";
        }
        boolean zA0 = a0(j7);
        StringBuilder sb = new StringBuilder();
        if (zA0) {
            sb.append('-');
        }
        long jO = o(j7);
        long jF = F(jO);
        int iQ = q(jO);
        int iN = N(jO);
        int iR = R(jO);
        int iP = P(jO);
        int i7 = 0;
        boolean z7 = jF != 0;
        boolean z8 = iQ != 0;
        boolean z9 = iN != 0;
        boolean z10 = (iR == 0 && iP == 0) ? false : true;
        if (z7) {
            sb.append(jF);
            sb.append('d');
            i7 = 1;
        }
        if (z8 || (z7 && (z9 || z10))) {
            int i8 = i7 + 1;
            if (i7 > 0) {
                sb.append(' ');
            }
            sb.append(iQ);
            sb.append('h');
            i7 = i8;
        }
        if (z9 || (z10 && (z8 || z7))) {
            int i9 = i7 + 1;
            if (i7 > 0) {
                sb.append(' ');
            }
            sb.append(iN);
            sb.append('m');
            i7 = i9;
        }
        if (z10) {
            int i10 = i7 + 1;
            if (i7 > 0) {
                sb.append(' ');
            }
            if (iR != 0 || z7 || z8 || z9) {
                e(j7, sb, iR, iP, 9, "s", false);
            } else if (iP >= 1000000) {
                e(j7, sb, iP / 1000000, iP % 1000000, 6, "ms", false);
            } else if (iP >= 1000) {
                e(j7, sb, iP / 1000, iP % 1000, 3, "us", false);
            } else {
                sb.append(iP);
                sb.append("ns");
            }
            i7 = i10;
        }
        if (zA0 && i7 > 1) {
            sb.insert(1, '(').append(')');
        }
        String string = sb.toString();
        l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @kotlin.k(message = "Use inWholeDays property instead or convert toDouble(DAYS) if a double value is required.", replaceWith = @b1(expression = "toDouble(DurationUnit.DAYS)", imports = {}))
    @k
    public static /* synthetic */ void r() {
    }

    @a7.d
    public static final String r0(long j7, @a7.d g unit, int i7) {
        l0.p(unit, "unit");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("decimals must be not negative, but was " + i7).toString());
        }
        double dK0 = k0(j7, unit);
        if (Double.isInfinite(dK0)) {
            return String.valueOf(dK0);
        }
        return e.b(dK0, kotlin.ranges.q.u(i7, 12)) + j.h(unit);
    }

    public static final double s(long j7) {
        return k0(j7, g.DAYS);
    }

    public static /* synthetic */ String s0(long j7, g gVar, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = 0;
        }
        return r0(j7, gVar, i7);
    }

    @kotlin.k(message = "Use inWholeHours property instead or convert toDouble(HOURS) if a double value is required.", replaceWith = @b1(expression = "toDouble(DurationUnit.HOURS)", imports = {}))
    @k
    public static /* synthetic */ void t() {
    }

    public static final long t0(long j7) {
        return f.i(-U(j7), ((int) j7) & 1);
    }

    public static final double u(long j7) {
        return k0(j7, g.HOURS);
    }

    @kotlin.k(message = "Use inWholeMicroseconds property instead or convert toDouble(MICROSECONDS) if a double value is required.", replaceWith = @b1(expression = "toDouble(DurationUnit.MICROSECONDS)", imports = {}))
    @k
    public static /* synthetic */ void v() {
    }

    public static final double w(long j7) {
        return k0(j7, g.MICROSECONDS);
    }

    @kotlin.k(message = "Use inWholeMilliseconds property instead or convert toDouble(MILLISECONDS) if a double value is required.", replaceWith = @b1(expression = "toDouble(DurationUnit.MILLISECONDS)", imports = {}))
    @k
    public static /* synthetic */ void x() {
    }

    public static final double y(long j7) {
        return k0(j7, g.MILLISECONDS);
    }

    @kotlin.k(message = "Use inWholeMinutes property instead or convert toDouble(MINUTES) if a double value is required.", replaceWith = @b1(expression = "toDouble(DurationUnit.MINUTES)", imports = {}))
    @k
    public static /* synthetic */ void z() {
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(d dVar) {
        return g(dVar.u0());
    }

    public boolean equals(Object obj) {
        return m(this.f35460a, obj);
    }

    public int g(long j7) {
        return h(this.f35460a, j7);
    }

    public int hashCode() {
        return V(this.f35460a);
    }

    @a7.d
    public String toString() {
        return q0(this.f35460a);
    }

    public final /* synthetic */ long u0() {
        return this.f35460a;
    }
}
