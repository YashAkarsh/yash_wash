package com.google.zxing.oned;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s implements com.google.zxing.v {
    protected static int c(boolean[] zArr, int i7, int[] iArr, boolean z7) {
        int i8 = 0;
        for (int i9 : iArr) {
            int i10 = 0;
            while (i10 < i9) {
                zArr[i7] = z7;
                i10++;
                i7++;
            }
            i8 += i9;
            z7 = !z7;
        }
        return i8;
    }

    private static com.google.zxing.common.b f(boolean[] zArr, int i7, int i8, int i9) {
        int length = zArr.length;
        int i10 = i9 + length;
        int iMax = Math.max(i7, i10);
        int iMax2 = Math.max(1, i8);
        int i11 = iMax / i10;
        int i12 = (iMax - (length * i11)) / 2;
        com.google.zxing.common.b bVar = new com.google.zxing.common.b(iMax, iMax2);
        int i13 = 0;
        while (i13 < length) {
            if (zArr[i13]) {
                bVar.v(i12, 0, i11, iMax2);
            }
            i13++;
            i12 += i11;
        }
        return bVar;
    }

    @Override // com.google.zxing.v
    public final com.google.zxing.common.b a(String str, com.google.zxing.a aVar, int i7, int i8) throws com.google.zxing.w {
        return b(str, aVar, i7, i8, null);
    }

    @Override // com.google.zxing.v
    public com.google.zxing.common.b b(String str, com.google.zxing.a aVar, int i7, int i8, Map<com.google.zxing.g, ?> map) throws com.google.zxing.w {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (i7 < 0 || i8 < 0) {
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i7 + 'x' + i8);
        }
        int iE = e();
        if (map != null) {
            com.google.zxing.g gVar = com.google.zxing.g.MARGIN;
            if (map.containsKey(gVar)) {
                iE = Integer.parseInt(map.get(gVar).toString());
            }
        }
        return f(d(str), i7, i8, iE);
    }

    public abstract boolean[] d(String str);

    public int e() {
        return 10;
    }
}
