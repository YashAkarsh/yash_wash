package com.google.common.math;

import com.google.common.base.e0;
import com.google.common.primitives.c0;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public final class j {

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f22108a;

        public c a(int i7) {
            return new c(this.f22108a, i7);
        }

        public d b(Collection<Integer> collection) {
            return new d(this.f22108a, c0.B(collection));
        }

        public d c(int... iArr) {
            return new d(this.f22108a, (int[]) iArr.clone());
        }

        private b(int i7) {
            e0.e(i7 > 0, "Quantile scale must be positive");
            this.f22108a = i7;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f22109a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f22110b;

        public double a(Collection<? extends Number> collection) {
            return e(com.google.common.primitives.e.z(collection));
        }

        public double b(double... dArr) {
            return e((double[]) dArr.clone());
        }

        public double c(int... iArr) {
            return e(j.l(iArr));
        }

        public double d(long... jArr) {
            return e(j.m(jArr));
        }

        public double e(double... dArr) {
            e0.e(dArr.length > 0, "Cannot calculate quantiles of an empty dataset");
            if (j.j(dArr)) {
                return Double.NaN;
            }
            long length = ((long) this.f22110b) * ((long) (dArr.length - 1));
            int iG = (int) f.g(length, this.f22109a, RoundingMode.DOWN);
            int i7 = (int) (length - (((long) iG) * ((long) this.f22109a)));
            j.u(iG, dArr, 0, dArr.length - 1);
            if (i7 == 0) {
                return dArr[iG];
            }
            int i8 = iG + 1;
            j.u(i8, dArr, i8, dArr.length - 1);
            return j.k(dArr[iG], dArr[i8], i7, this.f22109a);
        }

        private c(int i7, int i8) {
            j.h(i8, i7);
            this.f22109a = i7;
            this.f22110b = i8;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f22111a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int[] f22112b;

        public Map<Integer, Double> a(Collection<? extends Number> collection) {
            return e(com.google.common.primitives.e.z(collection));
        }

        public Map<Integer, Double> b(double... dArr) {
            return e((double[]) dArr.clone());
        }

        public Map<Integer, Double> c(int... iArr) {
            return e(j.l(iArr));
        }

        public Map<Integer, Double> d(long... jArr) {
            return e(j.m(jArr));
        }

        public Map<Integer, Double> e(double... dArr) {
            int i7 = 0;
            e0.e(dArr.length > 0, "Cannot calculate quantiles of an empty dataset");
            if (j.j(dArr)) {
                HashMap map = new HashMap();
                int[] iArr = this.f22112b;
                int length = iArr.length;
                while (i7 < length) {
                    map.put(Integer.valueOf(iArr[i7]), Double.valueOf(Double.NaN));
                    i7++;
                }
                return Collections.unmodifiableMap(map);
            }
            int[] iArr2 = this.f22112b;
            int[] iArr3 = new int[iArr2.length];
            int[] iArr4 = new int[iArr2.length];
            int[] iArr5 = new int[iArr2.length * 2];
            int i8 = 0;
            int i9 = 0;
            while (true) {
                int[] iArr6 = this.f22112b;
                if (i8 >= iArr6.length) {
                    break;
                }
                long length2 = ((long) iArr6[i8]) * ((long) (dArr.length - 1));
                int iG = (int) f.g(length2, this.f22111a, RoundingMode.DOWN);
                int i10 = (int) (length2 - (((long) iG) * ((long) this.f22111a)));
                iArr3[i8] = iG;
                iArr4[i8] = i10;
                iArr5[i9] = iG;
                i9++;
                if (i10 != 0) {
                    iArr5[i9] = iG + 1;
                    i9++;
                }
                i8++;
            }
            Arrays.sort(iArr5, 0, i9);
            j.t(iArr5, 0, i9 - 1, dArr, 0, dArr.length - 1);
            HashMap map2 = new HashMap();
            while (true) {
                int[] iArr7 = this.f22112b;
                if (i7 >= iArr7.length) {
                    return Collections.unmodifiableMap(map2);
                }
                int i11 = iArr3[i7];
                int i12 = iArr4[i7];
                if (i12 == 0) {
                    map2.put(Integer.valueOf(iArr7[i7]), Double.valueOf(dArr[i11]));
                } else {
                    map2.put(Integer.valueOf(iArr7[i7]), Double.valueOf(j.k(dArr[i11], dArr[i11 + 1], i12, this.f22111a)));
                }
                i7++;
            }
        }

        private d(int i7, int[] iArr) {
            for (int i8 : iArr) {
                j.h(i8, i7);
            }
            this.f22111a = i7;
            this.f22112b = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(int i7, int i8) {
        if (i7 < 0 || i7 > i8) {
            throw new IllegalArgumentException("Quantile indexes must be between 0 and the scale, which is " + i8);
        }
    }

    private static int i(int[] iArr, int i7, int i8, int i9, int i10) {
        if (i7 == i8) {
            return i7;
        }
        int i11 = i9 + i10;
        int i12 = i11 >>> 1;
        while (i8 > i7 + 1) {
            int i13 = (i7 + i8) >>> 1;
            int i14 = iArr[i13];
            if (i14 > i12) {
                i8 = i13;
            } else {
                if (i14 >= i12) {
                    return i13;
                }
                i7 = i13;
            }
        }
        return (i11 - iArr[i7]) - iArr[i8] > 0 ? i8 : i7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean j(double... dArr) {
        for (double d8 : dArr) {
            if (Double.isNaN(d8)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double k(double d8, double d9, double d10, double d11) {
        if (d8 == Double.NEGATIVE_INFINITY) {
            return d9 == Double.POSITIVE_INFINITY ? Double.NaN : Double.NEGATIVE_INFINITY;
        }
        if (d9 == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }
        return d8 + (((d9 - d8) * d10) / d11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double[] l(int[] iArr) {
        int length = iArr.length;
        double[] dArr = new double[length];
        for (int i7 = 0; i7 < length; i7++) {
            dArr[i7] = iArr[i7];
        }
        return dArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double[] m(long[] jArr) {
        int length = jArr.length;
        double[] dArr = new double[length];
        for (int i7 = 0; i7 < length; i7++) {
            dArr[i7] = jArr[i7];
        }
        return dArr;
    }

    public static c n() {
        return s(2).a(1);
    }

    private static void o(double[] dArr, int i7, int i8) {
        int i9 = (i7 + i8) >>> 1;
        double d8 = dArr[i8];
        double d9 = dArr[i9];
        boolean z7 = d8 < d9;
        double d10 = dArr[i7];
        boolean z8 = d9 < d10;
        boolean z9 = d8 < d10;
        if (z7 == z8) {
            v(dArr, i9, i7);
        } else if (z7 != z9) {
            v(dArr, i7, i8);
        }
    }

    private static int p(double[] dArr, int i7, int i8) {
        o(dArr, i7, i8);
        double d8 = dArr[i7];
        int i9 = i8;
        while (i8 > i7) {
            if (dArr[i8] > d8) {
                v(dArr, i9, i8);
                i9--;
            }
            i8--;
        }
        v(dArr, i7, i9);
        return i9;
    }

    public static b q() {
        return s(100);
    }

    public static b r() {
        return s(4);
    }

    public static b s(int i7) {
        return new b(i7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void t(int[] iArr, int i7, int i8, double[] dArr, int i9, int i10) {
        int i11 = i(iArr, i7, i8, i9, i10);
        int i12 = iArr[i11];
        u(i12, dArr, i9, i10);
        int i13 = i11 - 1;
        while (i13 >= i7 && iArr[i13] == i12) {
            i13--;
        }
        if (i13 >= i7) {
            t(iArr, i7, i13, dArr, i9, i12 - 1);
        }
        int i14 = i11 + 1;
        while (i14 <= i8 && iArr[i14] == i12) {
            i14++;
        }
        if (i14 <= i8) {
            t(iArr, i14, i8, dArr, i12 + 1, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void u(int i7, double[] dArr, int i8, int i9) {
        if (i7 != i8) {
            while (i9 > i8) {
                int iP = p(dArr, i8, i9);
                if (iP >= i7) {
                    i9 = iP - 1;
                }
                if (iP <= i7) {
                    i8 = iP + 1;
                }
            }
            return;
        }
        int i10 = i8;
        for (int i11 = i8 + 1; i11 <= i9; i11++) {
            if (dArr[i10] > dArr[i11]) {
                i10 = i11;
            }
        }
        if (i10 != i8) {
            v(dArr, i10, i8);
        }
    }

    private static void v(double[] dArr, int i7, int i8) {
        double d8 = dArr[i7];
        dArr[i7] = dArr[i8];
        dArr[i8] = d8;
    }
}
