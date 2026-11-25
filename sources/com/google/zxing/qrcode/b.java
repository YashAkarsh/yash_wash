package com.google.zxing.qrcode;

import com.google.zxing.g;
import com.google.zxing.qrcode.encoder.c;
import com.google.zxing.qrcode.encoder.f;
import com.google.zxing.v;
import com.google.zxing.w;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f24123a = 4;

    private static com.google.zxing.common.b c(f fVar, int i7, int i8, int i9) {
        com.google.zxing.qrcode.encoder.b bVarC = fVar.c();
        if (bVarC == null) {
            throw new IllegalStateException();
        }
        int iE = bVarC.e();
        int iD = bVarC.d();
        int i10 = i9 << 1;
        int i11 = iE + i10;
        int i12 = i10 + iD;
        int iMax = Math.max(i7, i11);
        int iMax2 = Math.max(i8, i12);
        int iMin = Math.min(iMax / i11, iMax2 / i12);
        int i13 = (iMax - (iE * iMin)) / 2;
        int i14 = (iMax2 - (iD * iMin)) / 2;
        com.google.zxing.common.b bVar = new com.google.zxing.common.b(iMax, iMax2);
        int i15 = 0;
        while (i15 < iD) {
            int i16 = 0;
            int i17 = i13;
            while (i16 < iE) {
                if (bVarC.b(i16, i15) == 1) {
                    bVar.v(i17, i14, iMin, iMin);
                }
                i16++;
                i17 += iMin;
            }
            i15++;
            i14 += iMin;
        }
        return bVar;
    }

    @Override // com.google.zxing.v
    public com.google.zxing.common.b a(String str, com.google.zxing.a aVar, int i7, int i8) throws w {
        return b(str, aVar, i7, i8, null);
    }

    @Override // com.google.zxing.v
    public com.google.zxing.common.b b(String str, com.google.zxing.a aVar, int i7, int i8, Map<g, ?> map) throws w {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (aVar != com.google.zxing.a.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got ".concat(String.valueOf(aVar)));
        }
        if (i7 < 0 || i8 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i7 + 'x' + i8);
        }
        com.google.zxing.qrcode.decoder.f fVarValueOf = com.google.zxing.qrcode.decoder.f.L;
        int i9 = 4;
        if (map != null) {
            g gVar = g.ERROR_CORRECTION;
            if (map.containsKey(gVar)) {
                fVarValueOf = com.google.zxing.qrcode.decoder.f.valueOf(map.get(gVar).toString());
            }
            g gVar2 = g.MARGIN;
            if (map.containsKey(gVar2)) {
                i9 = Integer.parseInt(map.get(gVar2).toString());
            }
        }
        return c(c.p(str, fVarValueOf, map), i7, i8, i9);
    }
}
