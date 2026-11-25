package com.google.zxing.multi.qrcode.detector;

import com.google.zxing.m;
import com.google.zxing.qrcode.detector.d;
import com.google.zxing.qrcode.detector.e;
import com.google.zxing.qrcode.detector.f;
import com.google.zxing.t;
import com.google.zxing.u;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class b extends e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final f[] f23771i = new f[0];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final float f23772j = 180.0f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final float f23773k = 9.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final float f23774l = 0.05f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final float f23775m = 0.5f;

    /* JADX INFO: renamed from: com.google.zxing.multi.qrcode.detector.b$b, reason: collision with other inner class name */
    private static final class C0313b implements Serializable, Comparator<d> {
        private C0313b() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            double dI = dVar2.i() - dVar.i();
            if (dI < 0.0d) {
                return -1;
            }
            return dI > 0.0d ? 1 : 0;
        }
    }

    b(com.google.zxing.common.b bVar) {
        super(bVar);
    }

    private d[][] s() throws m {
        char c8;
        char c9;
        List<d> listL = l();
        int size = listL.size();
        int i7 = 3;
        if (size < 3) {
            throw m.a();
        }
        char c10 = 2;
        char c11 = 0;
        if (size == 3) {
            return new d[][]{new d[]{listL.get(0), listL.get(1), listL.get(2)}};
        }
        Collections.sort(listL, new C0313b());
        ArrayList arrayList = new ArrayList();
        int i8 = 0;
        while (i8 < size - 2) {
            d dVar = listL.get(i8);
            if (dVar != null) {
                int i9 = i8 + 1;
                while (i9 < size - 1) {
                    d dVar2 = listL.get(i9);
                    if (dVar2 == null) {
                        c8 = c10;
                        break;
                        break;
                    }
                    float fI = (dVar.i() - dVar2.i()) / Math.min(dVar.i(), dVar2.i());
                    float fAbs = Math.abs(dVar.i() - dVar2.i());
                    float f8 = 0.5f;
                    float f9 = f23774l;
                    if (fAbs > 0.5f && fI >= f23774l) {
                        break;
                    }
                    int i10 = i9 + 1;
                    while (true) {
                        if (i10 >= size) {
                            c8 = c10;
                            break;
                        }
                        d dVar3 = listL.get(i10);
                        if (dVar3 != null) {
                            float fI2 = (dVar2.i() - dVar3.i()) / Math.min(dVar2.i(), dVar3.i());
                            if (Math.abs(dVar2.i() - dVar3.i()) > f8 && fI2 >= f9) {
                                c8 = 2;
                                break;
                            }
                            d[] dVarArr = new d[i7];
                            dVarArr[c11] = dVar;
                            dVarArr[1] = dVar2;
                            c9 = 2;
                            dVarArr[2] = dVar3;
                            t.e(dVarArr);
                            f fVar = new f(dVarArr);
                            float fB = t.b(fVar.b(), fVar.a());
                            float fB2 = t.b(fVar.c(), fVar.a());
                            float fB3 = t.b(fVar.b(), fVar.c());
                            float fI3 = (fB + fB3) / (dVar.i() * 2.0f);
                            if (fI3 <= 180.0f && fI3 >= f23773k && Math.abs((fB - fB3) / Math.min(fB, fB3)) < 0.1f) {
                                float fSqrt = (float) Math.sqrt((fB * fB) + (fB3 * fB3));
                                if (Math.abs((fB2 - fSqrt) / Math.min(fB2, fSqrt)) < 0.1f) {
                                    arrayList.add(dVarArr);
                                }
                            }
                        } else {
                            c9 = c10;
                        }
                        i10++;
                        c10 = c9;
                        i7 = 3;
                        c11 = 0;
                        f8 = 0.5f;
                        f9 = f23774l;
                    }
                    i9++;
                    c10 = c8;
                    i7 = 3;
                    c11 = 0;
                }
            }
            i8++;
            c10 = c10;
            i7 = 3;
            c11 = 0;
        }
        if (arrayList.isEmpty()) {
            throw m.a();
        }
        return (d[][]) arrayList.toArray(new d[arrayList.size()][]);
    }

    public f[] r(Map<com.google.zxing.e, ?> map) throws m {
        boolean z7 = map != null && map.containsKey(com.google.zxing.e.TRY_HARDER);
        com.google.zxing.common.b bVarK = k();
        int iM = bVarK.m();
        int iQ = bVarK.q();
        int i7 = (iM * 3) / 388;
        if (i7 < 3 || z7) {
            i7 = 3;
        }
        int[] iArr = new int[5];
        for (int i8 = i7 - 1; i8 < iM; i8 += i7) {
            b(iArr);
            int i9 = 0;
            for (int i10 = 0; i10 < iQ; i10++) {
                if (bVarK.j(i10, i8)) {
                    if ((i9 & 1) == 1) {
                        i9++;
                    }
                    iArr[i9] = iArr[i9] + 1;
                } else if ((i9 & 1) != 0) {
                    iArr[i9] = iArr[i9] + 1;
                } else if (i9 != 4) {
                    i9++;
                    iArr[i9] = iArr[i9] + 1;
                } else if (e.h(iArr) && m(iArr, i8, i10)) {
                    b(iArr);
                    i9 = 0;
                } else {
                    q(iArr);
                    i9 = 3;
                }
            }
            if (e.h(iArr)) {
                m(iArr, i8, iQ);
            }
        }
        d[][] dVarArrS = s();
        ArrayList arrayList = new ArrayList();
        for (d[] dVarArr : dVarArrS) {
            t.e(dVarArr);
            arrayList.add(new f(dVarArr));
        }
        return arrayList.isEmpty() ? f23771i : (f[]) arrayList.toArray(new f[arrayList.size()]);
    }

    b(com.google.zxing.common.b bVar, u uVar) {
        super(bVar, uVar);
    }
}
