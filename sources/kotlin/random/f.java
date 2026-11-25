package kotlin.random;

import java.io.Serializable;
import kotlin.g1;
import kotlin.internal.m;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import kotlin.ranges.k;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
@g1(version = "1.3")
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final a f34998a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private static final f f34999b = m.f34747a.b();

    public static final class a extends f implements Serializable {

        /* JADX INFO: renamed from: kotlin.random.f$a$a, reason: collision with other inner class name */
        private static final class C0436a implements Serializable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @a7.d
            public static final C0436a f35000a = new C0436a();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private static final long f35001b = 0;

            private C0436a() {
            }

            private final Object readResolve() {
                return f.f34998a;
            }
        }

        public /* synthetic */ a(w wVar) {
            this();
        }

        private final Object writeReplace() {
            return C0436a.f35000a;
        }

        @Override // kotlin.random.f
        public int b(int i7) {
            return f.f34999b.b(i7);
        }

        @Override // kotlin.random.f
        public boolean c() {
            return f.f34999b.c();
        }

        @Override // kotlin.random.f
        @a7.d
        public byte[] d(int i7) {
            return f.f34999b.d(i7);
        }

        @Override // kotlin.random.f
        @a7.d
        public byte[] e(@a7.d byte[] array) {
            l0.p(array, "array");
            return f.f34999b.e(array);
        }

        @Override // kotlin.random.f
        @a7.d
        public byte[] f(@a7.d byte[] array, int i7, int i8) {
            l0.p(array, "array");
            return f.f34999b.f(array, i7, i8);
        }

        @Override // kotlin.random.f
        public double h() {
            return f.f34999b.h();
        }

        @Override // kotlin.random.f
        public double i(double d8) {
            return f.f34999b.i(d8);
        }

        @Override // kotlin.random.f
        public double j(double d8, double d9) {
            return f.f34999b.j(d8, d9);
        }

        @Override // kotlin.random.f
        public float k() {
            return f.f34999b.k();
        }

        @Override // kotlin.random.f
        public int l() {
            return f.f34999b.l();
        }

        @Override // kotlin.random.f
        public int m(int i7) {
            return f.f34999b.m(i7);
        }

        @Override // kotlin.random.f
        public int n(int i7, int i8) {
            return f.f34999b.n(i7, i8);
        }

        @Override // kotlin.random.f
        public long o() {
            return f.f34999b.o();
        }

        @Override // kotlin.random.f
        public long p(long j7) {
            return f.f34999b.p(j7);
        }

        @Override // kotlin.random.f
        public long q(long j7, long j8) {
            return f.f34999b.q(j7, j8);
        }

        private a() {
        }
    }

    public static /* synthetic */ byte[] g(f fVar, byte[] bArr, int i7, int i8, int i9, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
        }
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = bArr.length;
        }
        return fVar.f(bArr, i7, i8);
    }

    public abstract int b(int i7);

    public boolean c() {
        return b(1) != 0;
    }

    @a7.d
    public byte[] d(int i7) {
        return e(new byte[i7]);
    }

    @a7.d
    public byte[] e(@a7.d byte[] array) {
        l0.p(array, "array");
        return f(array, 0, array.length);
    }

    @a7.d
    public byte[] f(@a7.d byte[] array, int i7, int i8) {
        l0.p(array, "array");
        if (!(new k(0, array.length).m(i7) && new k(0, array.length).m(i8))) {
            throw new IllegalArgumentException(("fromIndex (" + i7 + ") or toIndex (" + i8 + ") are out of range: 0.." + array.length + ClassUtils.PACKAGE_SEPARATOR_CHAR).toString());
        }
        if (!(i7 <= i8)) {
            throw new IllegalArgumentException(("fromIndex (" + i7 + ") must be not greater than toIndex (" + i8 + ").").toString());
        }
        int i9 = (i8 - i7) / 4;
        for (int i10 = 0; i10 < i9; i10++) {
            int iL = l();
            array[i7] = (byte) iL;
            array[i7 + 1] = (byte) (iL >>> 8);
            array[i7 + 2] = (byte) (iL >>> 16);
            array[i7 + 3] = (byte) (iL >>> 24);
            i7 += 4;
        }
        int i11 = i8 - i7;
        int iB = b(i11 * 8);
        for (int i12 = 0; i12 < i11; i12++) {
            array[i7 + i12] = (byte) (iB >>> (i12 * 8));
        }
        return array;
    }

    public double h() {
        return e.d(b(26), b(27));
    }

    public double i(double d8) {
        return j(0.0d, d8);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003d  */
    public double j(double d8, double d9) {
        double dH;
        g.d(d8, d9);
        double d10 = d9 - d8;
        if (Double.isInfinite(d10)) {
            if ((Double.isInfinite(d8) || Double.isNaN(d8)) ? false : true) {
                if ((Double.isInfinite(d9) || Double.isNaN(d9)) ? false : true) {
                    double d11 = 2;
                    double dH2 = h() * ((d9 / d11) - (d8 / d11));
                    dH = d8 + dH2 + dH2;
                } else {
                    dH = d8 + (h() * d10);
                }
            } else {
                dH = d8 + (h() * d10);
            }
        } else {
            dH = d8 + (h() * d10);
        }
        return dH >= d9 ? Math.nextAfter(d9, Double.NEGATIVE_INFINITY) : dH;
    }

    public float k() {
        return b(24) / 1.6777216E7f;
    }

    public int l() {
        return b(32);
    }

    public int m(int i7) {
        return n(0, i7);
    }

    public int n(int i7, int i8) {
        int iL;
        int i9;
        int iB;
        int iL2;
        boolean z7;
        g.e(i7, i8);
        int i10 = i8 - i7;
        if (i10 > 0 || i10 == Integer.MIN_VALUE) {
            if (((-i10) & i10) == i10) {
                iB = b(g.g(i10));
            } else {
                do {
                    iL = l() >>> 1;
                    i9 = iL % i10;
                } while ((iL - i9) + (i10 - 1) < 0);
                iB = i9;
            }
            return i7 + iB;
        }
        do {
            iL2 = l();
            z7 = false;
            if (i7 <= iL2 && iL2 < i8) {
                z7 = true;
            }
        } while (!z7);
        return iL2;
    }

    public long o() {
        return (((long) l()) << 32) + ((long) l());
    }

    public long p(long j7) {
        return q(0L, j7);
    }

    public long q(long j7, long j8) {
        long jO;
        boolean z7;
        long jO2;
        long j9;
        long jB;
        int iL;
        g.f(j7, j8);
        long j10 = j8 - j7;
        if (j10 <= 0) {
            do {
                jO = o();
                z7 = false;
                if (j7 <= jO && jO < j8) {
                    z7 = true;
                }
            } while (!z7);
            return jO;
        }
        if (((-j10) & j10) == j10) {
            int i7 = (int) j10;
            int i8 = (int) (j10 >>> 32);
            if (i7 != 0) {
                iL = b(g.g(i7));
            } else if (i8 == 1) {
                iL = l();
            } else {
                jB = (((long) b(g.g(i8))) << 32) + (((long) l()) & 4294967295L);
            }
            jB = ((long) iL) & 4294967295L;
        } else {
            do {
                jO2 = o() >>> 1;
                j9 = jO2 % j10;
            } while ((jO2 - j9) + (j10 - 1) < 0);
            jB = j9;
        }
        return j7 + jB;
    }
}
