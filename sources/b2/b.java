package b2;

import com.google.zxing.datamatrix.encoder.e;
import com.google.zxing.datamatrix.encoder.i;
import com.google.zxing.datamatrix.encoder.j;
import com.google.zxing.datamatrix.encoder.k;
import com.google.zxing.datamatrix.encoder.l;
import com.google.zxing.f;
import com.google.zxing.g;
import com.google.zxing.v;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements v {
    private static com.google.zxing.common.b c(com.google.zxing.qrcode.encoder.b bVar, int i7, int i8) {
        com.google.zxing.common.b bVar2;
        int iE = bVar.e();
        int iD = bVar.d();
        int iMax = Math.max(i7, iE);
        int iMax2 = Math.max(i8, iD);
        int iMin = Math.min(iMax / iE, iMax2 / iD);
        int i9 = (iMax - (iE * iMin)) / 2;
        int i10 = (iMax2 - (iD * iMin)) / 2;
        if (i8 < iD || i7 < iE) {
            bVar2 = new com.google.zxing.common.b(iE, iD);
            i9 = 0;
            i10 = 0;
        } else {
            bVar2 = new com.google.zxing.common.b(i7, i8);
        }
        bVar2.e();
        int i11 = 0;
        while (i11 < iD) {
            int i12 = i9;
            int i13 = 0;
            while (i13 < iE) {
                if (bVar.b(i13, i11) == 1) {
                    bVar2.v(i12, i10, iMin, iMin);
                }
                i13++;
                i12 += iMin;
            }
            i11++;
            i10 += iMin;
        }
        return bVar2;
    }

    private static com.google.zxing.common.b d(e eVar, k kVar, int i7, int i8) {
        int i9 = kVar.i();
        int iH = kVar.h();
        com.google.zxing.qrcode.encoder.b bVar = new com.google.zxing.qrcode.encoder.b(kVar.k(), kVar.j());
        int i10 = 0;
        for (int i11 = 0; i11 < iH; i11++) {
            if (i11 % kVar.f23701e == 0) {
                int i12 = 0;
                for (int i13 = 0; i13 < kVar.k(); i13++) {
                    bVar.h(i12, i10, i13 % 2 == 0);
                    i12++;
                }
                i10++;
            }
            int i14 = 0;
            for (int i15 = 0; i15 < i9; i15++) {
                if (i15 % kVar.f23700d == 0) {
                    bVar.h(i14, i10, true);
                    i14++;
                }
                bVar.h(i14, i10, eVar.e(i15, i11));
                i14++;
                int i16 = kVar.f23700d;
                if (i15 % i16 == i16 - 1) {
                    bVar.h(i14, i10, i11 % 2 == 0);
                    i14++;
                }
            }
            i10++;
            int i17 = kVar.f23701e;
            if (i11 % i17 == i17 - 1) {
                int i18 = 0;
                for (int i19 = 0; i19 < kVar.k(); i19++) {
                    bVar.h(i18, i10, true);
                    i18++;
                }
                i10++;
            }
        }
        return c(bVar, i7, i8);
    }

    @Override // com.google.zxing.v
    public com.google.zxing.common.b a(String str, com.google.zxing.a aVar, int i7, int i8) {
        return b(str, aVar, i7, i8, null);
    }

    @Override // com.google.zxing.v
    public com.google.zxing.common.b b(String str, com.google.zxing.a aVar, int i7, int i8, Map<g, ?> map) {
        f fVar;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (aVar != com.google.zxing.a.DATA_MATRIX) {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got ".concat(String.valueOf(aVar)));
        }
        if (i7 < 0 || i8 < 0) {
            throw new IllegalArgumentException("Requested dimensions can't be negative: " + i7 + 'x' + i8);
        }
        l lVar = l.FORCE_NONE;
        f fVar2 = null;
        if (map != null) {
            l lVar2 = (l) map.get(g.DATA_MATRIX_SHAPE);
            if (lVar2 != null) {
                lVar = lVar2;
            }
            f fVar3 = (f) map.get(g.MIN_SIZE);
            if (fVar3 == null) {
                fVar3 = null;
            }
            fVar = (f) map.get(g.MAX_SIZE);
            if (fVar == null) {
                fVar = null;
            }
            fVar2 = fVar3;
        } else {
            fVar = null;
        }
        String strC = j.c(str, lVar, fVar2, fVar);
        k kVarO = k.o(strC.length(), lVar, fVar2, fVar, true);
        e eVar = new e(i.c(strC, kVarO), kVarO.i(), kVarO.h());
        eVar.k();
        return d(eVar, kVarO, i7, i8);
    }
}
