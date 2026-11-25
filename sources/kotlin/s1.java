package kotlin;

/* JADX INFO: loaded from: classes2.dex */
@h5.f
@g1(version = "1.5")
@q2(markerClass = {t.class})
public final class s1 implements Comparable<s1> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    public static final a f35096b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte f35097c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte f35098d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f35099e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f35100f = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte f35101a;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
            this();
        }

        private a() {
        }
    }

    @a1
    private /* synthetic */ s1(byte b8) {
        this.f35101a = b8;
    }

    @kotlin.internal.f
    private static final int A(byte b8, short s7) {
        return w1.h(w1.h(b8 & 255) - w1.h(s7 & g2.f34732d));
    }

    @kotlin.internal.f
    private static final byte B(byte b8, byte b9) {
        return h((byte) o2.e(w1.h(b8 & 255), w1.h(b9 & 255)));
    }

    @kotlin.internal.f
    private static final long C(byte b8, long j7) {
        return o2.i(a2.h(((long) b8) & 255), j7);
    }

    @kotlin.internal.f
    private static final int D(byte b8, int i7) {
        return o2.e(w1.h(b8 & 255), i7);
    }

    @kotlin.internal.f
    private static final short E(byte b8, short s7) {
        return g2.h((short) o2.e(w1.h(b8 & 255), w1.h(s7 & g2.f34732d)));
    }

    @kotlin.internal.f
    private static final byte F(byte b8, byte b9) {
        return h((byte) (b8 | b9));
    }

    @kotlin.internal.f
    private static final int G(byte b8, byte b9) {
        return w1.h(w1.h(b8 & 255) + w1.h(b9 & 255));
    }

    @kotlin.internal.f
    private static final long H(byte b8, long j7) {
        return a2.h(a2.h(((long) b8) & 255) + j7);
    }

    @kotlin.internal.f
    private static final int I(byte b8, int i7) {
        return w1.h(w1.h(b8 & 255) + i7);
    }

    @kotlin.internal.f
    private static final int J(byte b8, short s7) {
        return w1.h(w1.h(b8 & 255) + w1.h(s7 & g2.f34732d));
    }

    @kotlin.internal.f
    private static final kotlin.ranges.t K(byte b8, byte b9) {
        return new kotlin.ranges.t(w1.h(b8 & 255), w1.h(b9 & 255), null);
    }

    @kotlin.internal.f
    private static final int L(byte b8, byte b9) {
        return o2.e(w1.h(b8 & 255), w1.h(b9 & 255));
    }

    @kotlin.internal.f
    private static final long M(byte b8, long j7) {
        return o2.i(a2.h(((long) b8) & 255), j7);
    }

    @kotlin.internal.f
    private static final int N(byte b8, int i7) {
        return o2.e(w1.h(b8 & 255), i7);
    }

    @kotlin.internal.f
    private static final int O(byte b8, short s7) {
        return o2.e(w1.h(b8 & 255), w1.h(s7 & g2.f34732d));
    }

    @kotlin.internal.f
    private static final int P(byte b8, byte b9) {
        return w1.h(w1.h(b8 & 255) * w1.h(b9 & 255));
    }

    @kotlin.internal.f
    private static final long Q(byte b8, long j7) {
        return a2.h(a2.h(((long) b8) & 255) * j7);
    }

    @kotlin.internal.f
    private static final int R(byte b8, int i7) {
        return w1.h(w1.h(b8 & 255) * i7);
    }

    @kotlin.internal.f
    private static final int S(byte b8, short s7) {
        return w1.h(w1.h(b8 & 255) * w1.h(s7 & g2.f34732d));
    }

    @kotlin.internal.f
    private static final byte T(byte b8) {
        return b8;
    }

    @kotlin.internal.f
    private static final double U(byte b8) {
        return b8 & 255;
    }

    @kotlin.internal.f
    private static final float V(byte b8) {
        return b8 & 255;
    }

    @kotlin.internal.f
    private static final int W(byte b8) {
        return b8 & 255;
    }

    @kotlin.internal.f
    private static final long X(byte b8) {
        return ((long) b8) & 255;
    }

    @kotlin.internal.f
    private static final short Y(byte b8) {
        return (short) (b8 & 255);
    }

    @a7.d
    public static String Z(byte b8) {
        return String.valueOf(b8 & 255);
    }

    @kotlin.internal.f
    private static final byte a(byte b8, byte b9) {
        return h((byte) (b8 & b9));
    }

    @kotlin.internal.f
    private static final byte a0(byte b8) {
        return b8;
    }

    public static final /* synthetic */ s1 b(byte b8) {
        return new s1(b8);
    }

    @kotlin.internal.f
    private static final int b0(byte b8) {
        return w1.h(b8 & 255);
    }

    @kotlin.internal.f
    private int c(byte b8) {
        return kotlin.jvm.internal.l0.t(e0() & 255, b8 & 255);
    }

    @kotlin.internal.f
    private static final long c0(byte b8) {
        return a2.h(((long) b8) & 255);
    }

    @kotlin.internal.f
    private static int d(byte b8, byte b9) {
        return kotlin.jvm.internal.l0.t(b8 & 255, b9 & 255);
    }

    @kotlin.internal.f
    private static final short d0(byte b8) {
        return g2.h((short) (b8 & 255));
    }

    @kotlin.internal.f
    private static final int e(byte b8, long j7) {
        return o2.g(a2.h(((long) b8) & 255), j7);
    }

    @kotlin.internal.f
    private static final int f(byte b8, int i7) {
        return o2.c(w1.h(b8 & 255), i7);
    }

    @kotlin.internal.f
    private static final byte f0(byte b8, byte b9) {
        return h((byte) (b8 ^ b9));
    }

    @kotlin.internal.f
    private static final int g(byte b8, short s7) {
        return kotlin.jvm.internal.l0.t(b8 & 255, s7 & g2.f34732d);
    }

    @a1
    public static byte h(byte b8) {
        return b8;
    }

    @kotlin.internal.f
    private static final byte i(byte b8) {
        return h((byte) (b8 - 1));
    }

    @kotlin.internal.f
    private static final int j(byte b8, byte b9) {
        return o2.d(w1.h(b8 & 255), w1.h(b9 & 255));
    }

    @kotlin.internal.f
    private static final long k(byte b8, long j7) {
        return o2.h(a2.h(((long) b8) & 255), j7);
    }

    @kotlin.internal.f
    private static final int l(byte b8, int i7) {
        return o2.d(w1.h(b8 & 255), i7);
    }

    @kotlin.internal.f
    private static final int m(byte b8, short s7) {
        return o2.d(w1.h(b8 & 255), w1.h(s7 & g2.f34732d));
    }

    public static boolean n(byte b8, Object obj) {
        return (obj instanceof s1) && b8 == ((s1) obj).e0();
    }

    public static final boolean o(byte b8, byte b9) {
        return b8 == b9;
    }

    @kotlin.internal.f
    private static final int p(byte b8, byte b9) {
        return o2.d(w1.h(b8 & 255), w1.h(b9 & 255));
    }

    @kotlin.internal.f
    private static final long q(byte b8, long j7) {
        return o2.h(a2.h(((long) b8) & 255), j7);
    }

    @kotlin.internal.f
    private static final int r(byte b8, int i7) {
        return o2.d(w1.h(b8 & 255), i7);
    }

    @kotlin.internal.f
    private static final int s(byte b8, short s7) {
        return o2.d(w1.h(b8 & 255), w1.h(s7 & g2.f34732d));
    }

    @a1
    public static /* synthetic */ void t() {
    }

    public static int u(byte b8) {
        return b8;
    }

    @kotlin.internal.f
    private static final byte v(byte b8) {
        return h((byte) (b8 + 1));
    }

    @kotlin.internal.f
    private static final byte w(byte b8) {
        return h((byte) (~b8));
    }

    @kotlin.internal.f
    private static final int x(byte b8, byte b9) {
        return w1.h(w1.h(b8 & 255) - w1.h(b9 & 255));
    }

    @kotlin.internal.f
    private static final long y(byte b8, long j7) {
        return a2.h(a2.h(((long) b8) & 255) - j7);
    }

    @kotlin.internal.f
    private static final int z(byte b8, int i7) {
        return w1.h(w1.h(b8 & 255) - i7);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(s1 s1Var) {
        return kotlin.jvm.internal.l0.t(e0() & 255, s1Var.e0() & 255);
    }

    public final /* synthetic */ byte e0() {
        return this.f35101a;
    }

    public boolean equals(Object obj) {
        return n(this.f35101a, obj);
    }

    public int hashCode() {
        return u(this.f35101a);
    }

    @a7.d
    public String toString() {
        return Z(this.f35101a);
    }
}
