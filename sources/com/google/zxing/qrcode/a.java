package com.google.zxing.qrcode;

import com.google.zxing.c;
import com.google.zxing.common.g;
import com.google.zxing.d;
import com.google.zxing.h;
import com.google.zxing.m;
import com.google.zxing.p;
import com.google.zxing.qrcode.decoder.e;
import com.google.zxing.qrcode.decoder.i;
import com.google.zxing.r;
import com.google.zxing.s;
import com.google.zxing.t;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a implements p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final t[] f24121b = new t[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f24122a = new e();

    private static com.google.zxing.common.b e(com.google.zxing.common.b bVar) throws m {
        int[] iArrP = bVar.p();
        int[] iArrK = bVar.k();
        if (iArrP == null || iArrK == null) {
            throw m.a();
        }
        float fG = g(iArrP, bVar);
        int i7 = iArrP[1];
        int i8 = iArrK[1];
        int i9 = iArrP[0];
        int i10 = iArrK[0];
        if (i9 >= i10 || i7 >= i8) {
            throw m.a();
        }
        int i11 = i8 - i7;
        if (i11 != i10 - i9 && (i10 = i9 + i11) >= bVar.q()) {
            throw m.a();
        }
        int iRound = Math.round(((i10 - i9) + 1) / fG);
        int iRound2 = Math.round((i11 + 1) / fG);
        if (iRound <= 0 || iRound2 <= 0) {
            throw m.a();
        }
        if (iRound2 != iRound) {
            throw m.a();
        }
        int i12 = (int) (fG / 2.0f);
        int i13 = i7 + i12;
        int i14 = i9 + i12;
        int i15 = (((int) ((iRound - 1) * fG)) + i14) - i10;
        if (i15 > 0) {
            if (i15 > i12) {
                throw m.a();
            }
            i14 -= i15;
        }
        int i16 = (((int) ((iRound2 - 1) * fG)) + i13) - i8;
        if (i16 > 0) {
            if (i16 > i12) {
                throw m.a();
            }
            i13 -= i16;
        }
        com.google.zxing.common.b bVar2 = new com.google.zxing.common.b(iRound, iRound2);
        for (int i17 = 0; i17 < iRound2; i17++) {
            int i18 = ((int) (i17 * fG)) + i13;
            for (int i19 = 0; i19 < iRound; i19++) {
                if (bVar.j(((int) (i19 * fG)) + i14, i18)) {
                    bVar2.u(i19, i17);
                }
            }
        }
        return bVar2;
    }

    private static float g(int[] iArr, com.google.zxing.common.b bVar) throws m {
        int iM = bVar.m();
        int iQ = bVar.q();
        int i7 = iArr[0];
        boolean z7 = true;
        int i8 = iArr[1];
        int i9 = 0;
        while (i7 < iQ && i8 < iM) {
            if (z7 != bVar.j(i7, i8)) {
                i9++;
                if (i9 == 5) {
                    break;
                }
                z7 = !z7;
            }
            i7++;
            i8++;
        }
        if (i7 == iQ || i8 == iM) {
            throw m.a();
        }
        return (i7 - iArr[0]) / 7.0f;
    }

    @Override // com.google.zxing.p
    public final r a(c cVar, Map<com.google.zxing.e, ?> map) throws m, d, h {
        t[] tVarArrB;
        com.google.zxing.common.e eVarC;
        if (map == null || !map.containsKey(com.google.zxing.e.PURE_BARCODE)) {
            g gVarF = new com.google.zxing.qrcode.detector.c(cVar.b()).f(map);
            com.google.zxing.common.e eVarC2 = this.f24122a.c(gVarF.a(), map);
            tVarArrB = gVarF.b();
            eVarC = eVarC2;
        } else {
            eVarC = this.f24122a.c(e(cVar.b()), map);
            tVarArrB = f24121b;
        }
        if (eVarC.f() instanceof i) {
            ((i) eVarC.f()).a(tVarArrB);
        }
        r rVar = new r(eVarC.j(), eVarC.g(), tVarArrB, com.google.zxing.a.QR_CODE);
        List<byte[]> listA = eVarC.a();
        if (listA != null) {
            rVar.j(s.BYTE_SEGMENTS, listA);
        }
        String strB = eVarC.b();
        if (strB != null) {
            rVar.j(s.ERROR_CORRECTION_LEVEL, strB);
        }
        if (eVarC.k()) {
            rVar.j(s.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(eVarC.i()));
            rVar.j(s.STRUCTURED_APPEND_PARITY, Integer.valueOf(eVarC.h()));
        }
        return rVar;
    }

    @Override // com.google.zxing.p
    public r b(c cVar) throws m, d, h {
        return a(cVar, null);
    }

    protected final e f() {
        return this.f24122a;
    }

    @Override // com.google.zxing.p
    public void reset() {
    }
}
