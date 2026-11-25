package com.google.zxing.oned.rss;

import com.google.zxing.m;
import com.google.zxing.oned.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends r {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f23879g = 0.2f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final float f23880h = 0.45f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f23881i = 0.7916667f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final float f23882j = 0.89285713f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f23884b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int[] f23887e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int[] f23888f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f23883a = new int[4];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float[] f23885c = new float[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float[] f23886d = new float[4];

    protected a() {
        int[] iArr = new int[8];
        this.f23884b = iArr;
        this.f23887e = new int[iArr.length / 2];
        this.f23888f = new int[iArr.length / 2];
    }

    @Deprecated
    protected static int h(int[] iArr) {
        return a2.a.d(iArr);
    }

    protected static void i(int[] iArr, float[] fArr) {
        int i7 = 0;
        float f8 = fArr[0];
        for (int i8 = 1; i8 < iArr.length; i8++) {
            float f9 = fArr[i8];
            if (f9 < f8) {
                i7 = i8;
                f8 = f9;
            }
        }
        iArr[i7] = iArr[i7] - 1;
    }

    protected static void p(int[] iArr, float[] fArr) {
        int i7 = 0;
        float f8 = fArr[0];
        for (int i8 = 1; i8 < iArr.length; i8++) {
            float f9 = fArr[i8];
            if (f9 > f8) {
                i7 = i8;
                f8 = f9;
            }
        }
        iArr[i7] = iArr[i7] + 1;
    }

    protected static boolean q(int[] iArr) {
        int i7 = iArr[0] + iArr[1];
        float f8 = i7 / ((iArr[2] + i7) + iArr[3]);
        if (f8 >= f23881i && f8 <= f23882j) {
            int i8 = Integer.MAX_VALUE;
            int i9 = Integer.MIN_VALUE;
            for (int i10 : iArr) {
                if (i10 > i9) {
                    i9 = i10;
                }
                if (i10 < i8) {
                    i8 = i10;
                }
            }
            if (i9 < i8 * 10) {
                return true;
            }
        }
        return false;
    }

    protected static int r(int[] iArr, int[][] iArr2) throws m {
        for (int i7 = 0; i7 < iArr2.length; i7++) {
            if (r.e(iArr, iArr2[i7], f23880h) < 0.2f) {
                return i7;
            }
        }
        throw m.a();
    }

    protected final int[] j() {
        return this.f23884b;
    }

    protected final int[] k() {
        return this.f23883a;
    }

    protected final int[] l() {
        return this.f23888f;
    }

    protected final float[] m() {
        return this.f23886d;
    }

    protected final int[] n() {
        return this.f23887e;
    }

    protected final float[] o() {
        return this.f23885c;
    }
}
