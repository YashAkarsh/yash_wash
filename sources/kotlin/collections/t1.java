package kotlin.collections;

import kotlin.b2;
import kotlin.g2;
import kotlin.h2;
import kotlin.o2;
import kotlin.x1;

/* JADX INFO: loaded from: classes2.dex */
public final class t1 {
    @kotlin.t
    private static final int a(long[] jArr, int i7, int i8) {
        long jM = b2.m(jArr, (i7 + i8) / 2);
        while (i7 <= i8) {
            while (o2.g(b2.m(jArr, i7), jM) < 0) {
                i7++;
            }
            while (o2.g(b2.m(jArr, i8), jM) > 0) {
                i8--;
            }
            if (i7 <= i8) {
                long jM2 = b2.m(jArr, i7);
                b2.u(jArr, i7, b2.m(jArr, i8));
                b2.u(jArr, i8, jM2);
                i7++;
                i8--;
            }
        }
        return i7;
    }

    @kotlin.t
    private static final int b(byte[] bArr, int i7, int i8) {
        int i9;
        byte bM = kotlin.t1.m(bArr, (i7 + i8) / 2);
        while (i7 <= i8) {
            while (true) {
                i9 = bM & 255;
                if (kotlin.jvm.internal.l0.t(kotlin.t1.m(bArr, i7) & 255, i9) >= 0) {
                    break;
                }
                i7++;
            }
            while (kotlin.jvm.internal.l0.t(kotlin.t1.m(bArr, i8) & 255, i9) > 0) {
                i8--;
            }
            if (i7 <= i8) {
                byte bM2 = kotlin.t1.m(bArr, i7);
                kotlin.t1.u(bArr, i7, kotlin.t1.m(bArr, i8));
                kotlin.t1.u(bArr, i8, bM2);
                i7++;
                i8--;
            }
        }
        return i7;
    }

    @kotlin.t
    private static final int c(short[] sArr, int i7, int i8) {
        int i9;
        short sM = h2.m(sArr, (i7 + i8) / 2);
        while (i7 <= i8) {
            while (true) {
                int iM = h2.m(sArr, i7) & g2.f34732d;
                i9 = sM & g2.f34732d;
                if (kotlin.jvm.internal.l0.t(iM, i9) >= 0) {
                    break;
                }
                i7++;
            }
            while (kotlin.jvm.internal.l0.t(h2.m(sArr, i8) & g2.f34732d, i9) > 0) {
                i8--;
            }
            if (i7 <= i8) {
                short sM2 = h2.m(sArr, i7);
                h2.u(sArr, i7, h2.m(sArr, i8));
                h2.u(sArr, i8, sM2);
                i7++;
                i8--;
            }
        }
        return i7;
    }

    @kotlin.t
    private static final int d(int[] iArr, int i7, int i8) {
        int iM = x1.m(iArr, (i7 + i8) / 2);
        while (i7 <= i8) {
            while (o2.c(x1.m(iArr, i7), iM) < 0) {
                i7++;
            }
            while (o2.c(x1.m(iArr, i8), iM) > 0) {
                i8--;
            }
            if (i7 <= i8) {
                int iM2 = x1.m(iArr, i7);
                x1.u(iArr, i7, x1.m(iArr, i8));
                x1.u(iArr, i8, iM2);
                i7++;
                i8--;
            }
        }
        return i7;
    }

    @kotlin.t
    private static final void e(long[] jArr, int i7, int i8) {
        int iA = a(jArr, i7, i8);
        int i9 = iA - 1;
        if (i7 < i9) {
            e(jArr, i7, i9);
        }
        if (iA < i8) {
            e(jArr, iA, i8);
        }
    }

    @kotlin.t
    private static final void f(byte[] bArr, int i7, int i8) {
        int iB = b(bArr, i7, i8);
        int i9 = iB - 1;
        if (i7 < i9) {
            f(bArr, i7, i9);
        }
        if (iB < i8) {
            f(bArr, iB, i8);
        }
    }

    @kotlin.t
    private static final void g(short[] sArr, int i7, int i8) {
        int iC = c(sArr, i7, i8);
        int i9 = iC - 1;
        if (i7 < i9) {
            g(sArr, i7, i9);
        }
        if (iC < i8) {
            g(sArr, iC, i8);
        }
    }

    @kotlin.t
    private static final void h(int[] iArr, int i7, int i8) {
        int iD = d(iArr, i7, i8);
        int i9 = iD - 1;
        if (i7 < i9) {
            h(iArr, i7, i9);
        }
        if (iD < i8) {
            h(iArr, iD, i8);
        }
    }

    @kotlin.t
    public static final void i(@a7.d long[] array, int i7, int i8) {
        kotlin.jvm.internal.l0.p(array, "array");
        e(array, i7, i8 - 1);
    }

    @kotlin.t
    public static final void j(@a7.d byte[] array, int i7, int i8) {
        kotlin.jvm.internal.l0.p(array, "array");
        f(array, i7, i8 - 1);
    }

    @kotlin.t
    public static final void k(@a7.d short[] array, int i7, int i8) {
        kotlin.jvm.internal.l0.p(array, "array");
        g(array, i7, i8 - 1);
    }

    @kotlin.t
    public static final void l(@a7.d int[] array, int i7, int i8) {
        kotlin.jvm.internal.l0.p(array, "array");
        h(array, i7, i8 - 1);
    }
}
