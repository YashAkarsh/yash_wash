package kotlin.time;

import java.util.Collection;
import java.util.Iterator;
import kotlin.b1;
import kotlin.collections.u0;
import kotlin.g1;
import kotlin.jvm.internal.l0;
import kotlin.q2;
import kotlin.text.b0;
import kotlin.text.c0;
import kotlin.text.e0;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f35463a = 1000000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f35464b = 4611686018426999999L;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f35465c = 4611686018427387903L;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f35466d = 4611686018426L;

    public static final long A(int i7) {
        return m0(i7, g.MICROSECONDS);
    }

    public static final long B(long j7) {
        return n0(j7, g.MICROSECONDS);
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @kotlin.l(warningSince = "1.5")
    @k
    public static /* synthetic */ void C(double d8) {
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @kotlin.l(warningSince = "1.5")
    @k
    public static /* synthetic */ void D(int i7) {
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @kotlin.l(warningSince = "1.5")
    @k
    public static /* synthetic */ void E(long j7) {
    }

    public static final long F(double d8) {
        return l0(d8, g.MILLISECONDS);
    }

    public static final long G(int i7) {
        return m0(i7, g.MILLISECONDS);
    }

    public static final long H(long j7) {
        return n0(j7, g.MILLISECONDS);
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @kotlin.l(warningSince = "1.5")
    @k
    public static /* synthetic */ void I(double d8) {
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @kotlin.l(warningSince = "1.5")
    @k
    public static /* synthetic */ void J(int i7) {
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @kotlin.l(warningSince = "1.5")
    @k
    public static /* synthetic */ void K(long j7) {
    }

    public static final long L(double d8) {
        return l0(d8, g.MINUTES);
    }

    public static final long M(int i7) {
        return m0(i7, g.MINUTES);
    }

    public static final long N(long j7) {
        return n0(j7, g.MINUTES);
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @kotlin.l(warningSince = "1.5")
    @k
    public static /* synthetic */ void O(double d8) {
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @kotlin.l(warningSince = "1.5")
    @k
    public static /* synthetic */ void P(int i7) {
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @kotlin.l(warningSince = "1.5")
    @k
    public static /* synthetic */ void Q(long j7) {
    }

    public static final long R(double d8) {
        return l0(d8, g.NANOSECONDS);
    }

    public static final long S(int i7) {
        return m0(i7, g.NANOSECONDS);
    }

    public static final long T(long j7) {
        return n0(j7, g.NANOSECONDS);
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @kotlin.l(warningSince = "1.5")
    @k
    public static /* synthetic */ void U(double d8) {
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @kotlin.l(warningSince = "1.5")
    @k
    public static /* synthetic */ void V(int i7) {
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @kotlin.l(warningSince = "1.5")
    @k
    public static /* synthetic */ void W(long j7) {
    }

    public static final long X(double d8) {
        return l0(d8, g.SECONDS);
    }

    public static final long Y(int i7) {
        return m0(i7, g.SECONDS);
    }

    public static final long Z(long j7) {
        return n0(j7, g.SECONDS);
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @kotlin.l(warningSince = "1.5")
    @k
    public static /* synthetic */ void a0(double d8) {
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @kotlin.l(warningSince = "1.5")
    @k
    public static /* synthetic */ void b0(int i7) {
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @kotlin.l(warningSince = "1.5")
    @k
    public static /* synthetic */ void c0(long j7) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long d0(long j7) {
        return j7 * ((long) 1000000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long e0(long j7) {
        return j7 / ((long) 1000000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:170:0x00a6 A[EDGE_INSN: B:170:0x00a6->B:49:0x00a6 BREAK  A[LOOP:1: B:36:0x006c->B:47:0x009a], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x009a A[LOOP:1: B:36:0x006c->B:47:0x009a, LOOP_END] */
    public static final long f0(String str, boolean z7) {
        int i7;
        int i8;
        boolean z8;
        int length = str.length();
        if (length == 0) {
            throw new IllegalArgumentException("The string is empty");
        }
        d.a aVar = d.f35456b;
        long jW = aVar.W();
        char cCharAt = str.charAt(0);
        boolean z9 = true;
        int length2 = (cCharAt == '+' || cCharAt == '-') ? 1 : 0;
        boolean z10 = length2 > 0;
        boolean z11 = z10 && c0.d5(str, '-', false, 2, null);
        if (length <= length2) {
            throw new IllegalArgumentException("No components");
        }
        char c8 = '0';
        if (str.charAt(length2) == 'P') {
            int i9 = length2 + 1;
            if (i9 == length) {
                throw new IllegalArgumentException();
            }
            boolean z12 = false;
            g gVar = null;
            while (i9 < length) {
                if (str.charAt(i9) != 'T') {
                    int i10 = i9;
                    while (true) {
                        if (i10 >= str.length()) {
                            i8 = length;
                            break;
                        }
                        char cCharAt2 = str.charAt(i10);
                        if (!new kotlin.ranges.c(c8, '9').m(cCharAt2)) {
                            i8 = length;
                            if (!c0.U2("+-.", cCharAt2, false, 2, null)) {
                                z8 = false;
                            }
                            if (z8) {
                                break;
                            }
                            i10++;
                            length = i8;
                            c8 = '0';
                        } else {
                            i8 = length;
                        }
                        z8 = true;
                        if (z8) {
                            break;
                            break;
                        }
                        i10++;
                        length = i8;
                        c8 = '0';
                    }
                    l0.n(str, "null cannot be cast to non-null type java.lang.String");
                    String strSubstring = str.substring(i9, i10);
                    l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    if (strSubstring.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    int length3 = i9 + strSubstring.length();
                    if (length3 < 0 || length3 > c0.i3(str)) {
                        throw new IllegalArgumentException("Missing unit for value " + strSubstring);
                    }
                    char cCharAt3 = str.charAt(length3);
                    i9 = length3 + 1;
                    g gVarF = j.f(cCharAt3, z12);
                    if (gVar != null && gVar.compareTo(gVarF) <= 0) {
                        throw new IllegalArgumentException("Unexpected order of duration components");
                    }
                    int iQ3 = c0.q3(strSubstring, ClassUtils.PACKAGE_SEPARATOR_CHAR, 0, false, 6, null);
                    if (gVarF != g.SECONDS || iQ3 <= 0) {
                        jW = d.d0(jW, n0(g0(strSubstring), gVarF));
                    } else {
                        l0.n(strSubstring, "null cannot be cast to non-null type java.lang.String");
                        String strSubstring2 = strSubstring.substring(0, iQ3);
                        l0.o(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                        long jD0 = d.d0(jW, n0(g0(strSubstring2), gVarF));
                        l0.n(strSubstring, "null cannot be cast to non-null type java.lang.String");
                        String strSubstring3 = strSubstring.substring(iQ3);
                        l0.o(strSubstring3, "this as java.lang.String).substring(startIndex)");
                        jW = d.d0(jD0, l0(Double.parseDouble(strSubstring3), gVarF));
                    }
                    gVar = gVarF;
                    length = i8;
                    c8 = '0';
                    z9 = true;
                } else {
                    if (z12 || (i9 = i9 + 1) == length) {
                        throw new IllegalArgumentException();
                    }
                    z12 = z9;
                }
            }
        } else {
            if (z7) {
                throw new IllegalArgumentException();
            }
            String str2 = "null cannot be cast to non-null type java.lang.String";
            String str3 = "this as java.lang.String).substring(startIndex)";
            if (b0.d2(str, length2, "Infinity", 0, Math.max(length - length2, 8), true)) {
                jW = aVar.q();
            } else {
                boolean z13 = !z10;
                if (z10 && str.charAt(length2) == '(' && e0.t7(str) == ')') {
                    length2++;
                    int i11 = length - 1;
                    if (length2 == i11) {
                        throw new IllegalArgumentException("No components");
                    }
                    i7 = i11;
                    z13 = true;
                } else {
                    i7 = length;
                }
                boolean z14 = false;
                g gVar2 = null;
                while (length2 < i7) {
                    if (z14 && z13) {
                        while (length2 < str.length()) {
                            if (!(str.charAt(length2) == ' ')) {
                                break;
                            }
                            length2++;
                        }
                    }
                    int i12 = length2;
                    while (i12 < str.length()) {
                        char cCharAt4 = str.charAt(i12);
                        if (!(new kotlin.ranges.c('0', '9').m(cCharAt4) || cCharAt4 == '.')) {
                            break;
                        }
                        i12++;
                    }
                    String str4 = str2;
                    l0.n(str, str4);
                    String strSubstring4 = str.substring(length2, i12);
                    l0.o(strSubstring4, "this as java.lang.String…ing(startIndex, endIndex)");
                    if (strSubstring4.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    int length4 = length2 + strSubstring4.length();
                    int i13 = length4;
                    while (i13 < str.length()) {
                        if (!new kotlin.ranges.c('a', 'z').m(str.charAt(i13))) {
                            break;
                        }
                        i13++;
                    }
                    l0.n(str, str4);
                    String strSubstring5 = str.substring(length4, i13);
                    l0.o(strSubstring5, "this as java.lang.String…ing(startIndex, endIndex)");
                    length2 = length4 + strSubstring5.length();
                    g gVarG = j.g(strSubstring5);
                    if (gVar2 != null && gVar2.compareTo(gVarG) <= 0) {
                        throw new IllegalArgumentException("Unexpected order of duration components");
                    }
                    int iQ4 = c0.q3(strSubstring4, ClassUtils.PACKAGE_SEPARATOR_CHAR, 0, false, 6, null);
                    if (iQ4 > 0) {
                        l0.n(strSubstring4, str4);
                        String strSubstring6 = strSubstring4.substring(0, iQ4);
                        l0.o(strSubstring6, "this as java.lang.String…ing(startIndex, endIndex)");
                        long jD1 = d.d0(jW, n0(Long.parseLong(strSubstring6), gVarG));
                        l0.n(strSubstring4, str4);
                        String strSubstring7 = strSubstring4.substring(iQ4);
                        String str5 = str3;
                        l0.o(strSubstring7, str5);
                        jW = d.d0(jD1, l0(Double.parseDouble(strSubstring7), gVarG));
                        if (length2 < i7) {
                            throw new IllegalArgumentException("Fractional component must be last");
                        }
                        str3 = str5;
                    } else {
                        jW = d.d0(jW, n0(Long.parseLong(strSubstring4), gVarG));
                    }
                    str2 = str4;
                    gVar2 = gVarG;
                    z14 = true;
                }
            }
        }
        return z11 ? d.t0(jW) : jW;
    }

    private static final long g0(String str) {
        boolean z7;
        int length = str.length();
        int i7 = (length <= 0 || !c0.U2("+-", str.charAt(0), false, 2, null)) ? 0 : 1;
        if (length - i7 > 16) {
            Iterable kVar = new kotlin.ranges.k(i7, c0.i3(str));
            if (!(kVar instanceof Collection) || !((Collection) kVar).isEmpty()) {
                Iterator it = kVar.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z7 = true;
                        break;
                    }
                    if (!new kotlin.ranges.c('0', '9').m(str.charAt(((u0) it).b()))) {
                        z7 = false;
                        break;
                    }
                }
            } else {
                z7 = true;
                break;
            }
            if (z7) {
                return str.charAt(0) == '-' ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
        }
        if (b0.u2(str, "+", false, 2, null)) {
            str = e0.A6(str, 1);
        }
        return Long.parseLong(str);
    }

    private static final int h0(String str, int i7, i5.l<? super Character, Boolean> lVar) {
        while (i7 < str.length() && lVar.z(Character.valueOf(str.charAt(i7))).booleanValue()) {
            i7++;
        }
        return i7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long i(long j7, int i7) {
        return d.i((j7 << 1) + ((long) i7));
    }

    private static final String i0(String str, int i7, i5.l<? super Character, Boolean> lVar) {
        int i8 = i7;
        while (i8 < str.length() && lVar.z(Character.valueOf(str.charAt(i8))).booleanValue()) {
            i8++;
        }
        l0.n(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(i7, i8);
        l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long j(long j7) {
        return d.i((j7 << 1) + 1);
    }

    @g1(version = i2.a.f34096f)
    @q2(markerClass = {k.class})
    @kotlin.internal.f
    private static final long j0(double d8, long j7) {
        return d.e0(j7, d8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long k(long j7) {
        return new kotlin.ranges.n(-4611686018426L, f35466d).m(j7) ? l(d0(j7)) : j(kotlin.ranges.q.D(j7, -4611686018427387903L, f35465c));
    }

    @g1(version = i2.a.f34096f)
    @q2(markerClass = {k.class})
    @kotlin.internal.f
    private static final long k0(int i7, long j7) {
        return d.f0(j7, i7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long l(long j7) {
        return d.i(j7 << 1);
    }

    @g1(version = i2.a.f34096f)
    @q2(markerClass = {k.class})
    public static final long l0(double d8, @a7.d g unit) {
        l0.p(unit, "unit");
        double dA = i.a(d8, unit, g.NANOSECONDS);
        if (!(!Double.isNaN(dA))) {
            throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
        }
        long jK0 = kotlin.math.d.K0(dA);
        return new kotlin.ranges.n(-4611686018426999999L, f35464b).m(jK0) ? l(jK0) : k(kotlin.math.d.K0(i.a(d8, unit, g.MILLISECONDS)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long m(long j7) {
        return new kotlin.ranges.n(-4611686018426999999L, f35464b).m(j7) ? l(j7) : j(e0(j7));
    }

    @g1(version = i2.a.f34096f)
    @q2(markerClass = {k.class})
    public static final long m0(int i7, @a7.d g unit) {
        l0.p(unit, "unit");
        return unit.compareTo(g.SECONDS) <= 0 ? l(i.c(i7, unit, g.NANOSECONDS)) : n0(i7, unit);
    }

    public static final long n(double d8) {
        return l0(d8, g.DAYS);
    }

    @g1(version = i2.a.f34096f)
    @q2(markerClass = {k.class})
    public static final long n0(long j7, @a7.d g unit) {
        l0.p(unit, "unit");
        g gVar = g.NANOSECONDS;
        long jC = i.c(f35464b, gVar, unit);
        return new kotlin.ranges.n(-jC, jC).m(j7) ? l(i.c(j7, unit, gVar)) : j(kotlin.ranges.q.D(i.b(j7, unit, g.MILLISECONDS), -4611686018427387903L, f35465c));
    }

    public static final long o(int i7) {
        return m0(i7, g.DAYS);
    }

    public static final long p(long j7) {
        return n0(j7, g.DAYS);
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @kotlin.l(warningSince = "1.5")
    @k
    public static /* synthetic */ void q(double d8) {
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @kotlin.l(warningSince = "1.5")
    @k
    public static /* synthetic */ void r(int i7) {
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @kotlin.l(warningSince = "1.5")
    @k
    public static /* synthetic */ void s(long j7) {
    }

    public static final long t(double d8) {
        return l0(d8, g.HOURS);
    }

    public static final long u(int i7) {
        return m0(i7, g.HOURS);
    }

    public static final long v(long j7) {
        return n0(j7, g.HOURS);
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @kotlin.l(warningSince = "1.5")
    @k
    public static /* synthetic */ void w(double d8) {
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @kotlin.l(warningSince = "1.5")
    @k
    public static /* synthetic */ void x(int i7) {
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @b1(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @kotlin.l(warningSince = "1.5")
    @k
    public static /* synthetic */ void y(long j7) {
    }

    public static final long z(double d8) {
        return l0(d8, g.MICROSECONDS);
    }
}
