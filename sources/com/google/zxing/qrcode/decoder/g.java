package com.google.zxing.qrcode.decoder;

/* JADX INFO: loaded from: classes2.dex */
final class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f24150c = 21522;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[][] f24151d = {new int[]{f24150c, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f24152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte f24153b;

    private g(int i7) {
        this.f24152a = f.a((i7 >> 3) & 3);
        this.f24153b = (byte) (i7 & 7);
    }

    static g a(int i7, int i8) {
        g gVarB = b(i7, i8);
        return gVarB != null ? gVarB : b(i7 ^ f24150c, i8 ^ f24150c);
    }

    private static g b(int i7, int i8) {
        int iE;
        int i9 = Integer.MAX_VALUE;
        int i10 = 0;
        for (int[] iArr : f24151d) {
            int i11 = iArr[0];
            if (i11 == i7 || i11 == i8) {
                return new g(iArr[1]);
            }
            int iE2 = e(i7, i11);
            if (iE2 < i9) {
                i10 = iArr[1];
                i9 = iE2;
            }
            if (i7 != i8 && (iE = e(i8, i11)) < i9) {
                i10 = iArr[1];
                i9 = iE;
            }
        }
        if (i9 <= 3) {
            return new g(i10);
        }
        return null;
    }

    static int e(int i7, int i8) {
        return Integer.bitCount(i7 ^ i8);
    }

    byte c() {
        return this.f24153b;
    }

    f d() {
        return this.f24152a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f24152a == gVar.f24152a && this.f24153b == gVar.f24153b;
    }

    public int hashCode() {
        return (this.f24152a.ordinal() << 3) | this.f24153b;
    }
}
