package c2;

import com.google.zxing.common.b;
import com.google.zxing.d;
import com.google.zxing.e;
import com.google.zxing.h;
import com.google.zxing.m;
import com.google.zxing.maxicode.decoder.c;
import com.google.zxing.p;
import com.google.zxing.r;
import com.google.zxing.s;
import com.google.zxing.t;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final t[] f11520b = new t[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f11521c = 30;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f11522d = 33;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f11523a = new c();

    private static b c(b bVar) throws m {
        int[] iArrL = bVar.l();
        if (iArrL == null) {
            throw m.a();
        }
        int i7 = iArrL[0];
        int i8 = iArrL[1];
        int i9 = iArrL[2];
        int i10 = iArrL[3];
        b bVar2 = new b(30, 33);
        for (int i11 = 0; i11 < 33; i11++) {
            int i12 = (((i11 * i10) + (i10 / 2)) / 33) + i8;
            for (int i13 = 0; i13 < 30; i13++) {
                if (bVar.j(((((i13 * i9) + (i9 / 2)) + (((i11 & 1) * i9) / 2)) / 30) + i7, i12)) {
                    bVar2.u(i13, i11);
                }
            }
        }
        return bVar2;
    }

    @Override // com.google.zxing.p
    public r a(com.google.zxing.c cVar, Map<e, ?> map) throws m, d, h {
        if (map == null || !map.containsKey(e.PURE_BARCODE)) {
            throw m.a();
        }
        com.google.zxing.common.e eVarC = this.f11523a.c(c(cVar.b()), map);
        r rVar = new r(eVarC.j(), eVarC.g(), f11520b, com.google.zxing.a.MAXICODE);
        String strB = eVarC.b();
        if (strB != null) {
            rVar.j(s.ERROR_CORRECTION_LEVEL, strB);
        }
        return rVar;
    }

    @Override // com.google.zxing.p
    public r b(com.google.zxing.c cVar) throws m, d, h {
        return a(cVar, null);
    }

    @Override // com.google.zxing.p
    public void reset() {
    }
}
