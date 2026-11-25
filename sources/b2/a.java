package b2;

import com.google.zxing.c;
import com.google.zxing.common.g;
import com.google.zxing.datamatrix.decoder.d;
import com.google.zxing.e;
import com.google.zxing.h;
import com.google.zxing.m;
import com.google.zxing.p;
import com.google.zxing.r;
import com.google.zxing.s;
import com.google.zxing.t;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final t[] f11284b = new t[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f11285a = new d();

    private static com.google.zxing.common.b c(com.google.zxing.common.b bVar) throws m {
        int[] iArrP = bVar.p();
        int[] iArrK = bVar.k();
        if (iArrP == null || iArrK == null) {
            throw m.a();
        }
        int iD = d(iArrP, bVar);
        int i7 = iArrP[1];
        int i8 = iArrK[1];
        int i9 = iArrP[0];
        int i10 = ((iArrK[0] - i9) + 1) / iD;
        int i11 = ((i8 - i7) + 1) / iD;
        if (i10 <= 0 || i11 <= 0) {
            throw m.a();
        }
        int i12 = iD / 2;
        int i13 = i7 + i12;
        int i14 = i9 + i12;
        com.google.zxing.common.b bVar2 = new com.google.zxing.common.b(i10, i11);
        for (int i15 = 0; i15 < i11; i15++) {
            int i16 = (i15 * iD) + i13;
            for (int i17 = 0; i17 < i10; i17++) {
                if (bVar.j((i17 * iD) + i14, i16)) {
                    bVar2.u(i17, i15);
                }
            }
        }
        return bVar2;
    }

    private static int d(int[] iArr, com.google.zxing.common.b bVar) throws m {
        int iQ = bVar.q();
        int i7 = iArr[0];
        int i8 = iArr[1];
        while (i7 < iQ && bVar.j(i7, i8)) {
            i7++;
        }
        if (i7 == iQ) {
            throw m.a();
        }
        int i9 = i7 - iArr[0];
        if (i9 != 0) {
            return i9;
        }
        throw m.a();
    }

    @Override // com.google.zxing.p
    public r a(c cVar, Map<e, ?> map) throws m, com.google.zxing.d, h {
        t[] tVarArrB;
        com.google.zxing.common.e eVarB;
        if (map == null || !map.containsKey(e.PURE_BARCODE)) {
            g gVarC = new com.google.zxing.datamatrix.detector.a(cVar.b()).c();
            com.google.zxing.common.e eVarB2 = this.f11285a.b(gVarC.a());
            tVarArrB = gVarC.b();
            eVarB = eVarB2;
        } else {
            eVarB = this.f11285a.b(c(cVar.b()));
            tVarArrB = f11284b;
        }
        r rVar = new r(eVarB.j(), eVarB.g(), tVarArrB, com.google.zxing.a.DATA_MATRIX);
        List<byte[]> listA = eVarB.a();
        if (listA != null) {
            rVar.j(s.BYTE_SEGMENTS, listA);
        }
        String strB = eVarB.b();
        if (strB != null) {
            rVar.j(s.ERROR_CORRECTION_LEVEL, strB);
        }
        return rVar;
    }

    @Override // com.google.zxing.p
    public r b(c cVar) throws m, com.google.zxing.d, h {
        return a(cVar, null);
    }

    @Override // com.google.zxing.p
    public void reset() {
    }
}
