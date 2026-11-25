package com.google.zxing.datamatrix.detector;

import com.google.zxing.common.g;
import com.google.zxing.common.i;
import com.google.zxing.m;
import com.google.zxing.t;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.zxing.common.b f23652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a2.c f23653b;

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final t f23654a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final t f23655b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f23656c;

        t a() {
            return this.f23654a;
        }

        t b() {
            return this.f23655b;
        }

        int c() {
            return this.f23656c;
        }

        public String toString() {
            return this.f23654a + "/" + this.f23655b + '/' + this.f23656c;
        }

        private b(t tVar, t tVar2, int i7) {
            this.f23654a = tVar;
            this.f23655b = tVar2;
            this.f23656c = i7;
        }
    }

    private static final class c implements Serializable, Comparator<b> {
        private c() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            return bVar.c() - bVar2.c();
        }
    }

    public a(com.google.zxing.common.b bVar) throws m {
        this.f23652a = bVar;
        this.f23653b = new a2.c(bVar);
    }

    private t a(t tVar, t tVar2, t tVar3, t tVar4, int i7) {
        float f8 = i7;
        float fD = d(tVar, tVar2) / f8;
        float fD2 = d(tVar3, tVar4);
        t tVar5 = new t(tVar4.c() + (((tVar4.c() - tVar3.c()) / fD2) * fD), tVar4.d() + (fD * ((tVar4.d() - tVar3.d()) / fD2)));
        float fD3 = d(tVar, tVar3) / f8;
        float fD4 = d(tVar2, tVar4);
        t tVar6 = new t(tVar4.c() + (((tVar4.c() - tVar2.c()) / fD4) * fD3), tVar4.d() + (fD3 * ((tVar4.d() - tVar2.d()) / fD4)));
        if (f(tVar5)) {
            return (f(tVar6) && Math.abs(h(tVar3, tVar5).c() - h(tVar2, tVar5).c()) > Math.abs(h(tVar3, tVar6).c() - h(tVar2, tVar6).c())) ? tVar6 : tVar5;
        }
        if (f(tVar6)) {
            return tVar6;
        }
        return null;
    }

    private t b(t tVar, t tVar2, t tVar3, t tVar4, int i7, int i8) {
        float fD = d(tVar, tVar2) / i7;
        float fD2 = d(tVar3, tVar4);
        t tVar5 = new t(tVar4.c() + (((tVar4.c() - tVar3.c()) / fD2) * fD), tVar4.d() + (fD * ((tVar4.d() - tVar3.d()) / fD2)));
        float fD3 = d(tVar, tVar3) / i8;
        float fD4 = d(tVar2, tVar4);
        t tVar6 = new t(tVar4.c() + (((tVar4.c() - tVar2.c()) / fD4) * fD3), tVar4.d() + (fD3 * ((tVar4.d() - tVar2.d()) / fD4)));
        if (f(tVar5)) {
            return (f(tVar6) && Math.abs(i7 - h(tVar3, tVar5).c()) + Math.abs(i8 - h(tVar2, tVar5).c()) > Math.abs(i7 - h(tVar3, tVar6).c()) + Math.abs(i8 - h(tVar2, tVar6).c())) ? tVar6 : tVar5;
        }
        if (f(tVar6)) {
            return tVar6;
        }
        return null;
    }

    private static int d(t tVar, t tVar2) {
        return a2.a.c(t.b(tVar, tVar2));
    }

    private static void e(Map<t, Integer> map, t tVar) {
        Integer num = map.get(tVar);
        map.put(tVar, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    private boolean f(t tVar) {
        return tVar.c() >= 0.0f && tVar.c() < ((float) this.f23652a.q()) && tVar.d() > 0.0f && tVar.d() < ((float) this.f23652a.m());
    }

    private static com.google.zxing.common.b g(com.google.zxing.common.b bVar, t tVar, t tVar2, t tVar3, t tVar4, int i7, int i8) throws m {
        float f8 = i7 - 0.5f;
        float f9 = i8 - 0.5f;
        return i.b().c(bVar, i7, i8, 0.5f, 0.5f, f8, 0.5f, f8, f9, 0.5f, f9, tVar.c(), tVar.d(), tVar4.c(), tVar4.d(), tVar3.c(), tVar3.d(), tVar2.c(), tVar2.d());
    }

    private b h(t tVar, t tVar2) {
        int iC = (int) tVar.c();
        int iD = (int) tVar.d();
        int iC2 = (int) tVar2.c();
        int iD2 = (int) tVar2.d();
        int i7 = 0;
        boolean z7 = Math.abs(iD2 - iD) > Math.abs(iC2 - iC);
        if (z7) {
            iD = iC;
            iC = iD;
            iD2 = iC2;
            iC2 = iD2;
        }
        int iAbs = Math.abs(iC2 - iC);
        int iAbs2 = Math.abs(iD2 - iD);
        int i8 = (-iAbs) / 2;
        int i9 = iD < iD2 ? 1 : -1;
        int i10 = iC >= iC2 ? -1 : 1;
        boolean zJ = this.f23652a.j(z7 ? iD : iC, z7 ? iC : iD);
        while (iC != iC2) {
            boolean zJ2 = this.f23652a.j(z7 ? iD : iC, z7 ? iC : iD);
            if (zJ2 != zJ) {
                i7++;
                zJ = zJ2;
            }
            i8 += iAbs2;
            if (i8 > 0) {
                if (iD == iD2) {
                    break;
                }
                iD += i9;
                i8 -= iAbs;
            }
            iC += i10;
        }
        return new b(tVar, tVar2, i7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g c() throws m {
        t tVar;
        t tVar2;
        com.google.zxing.common.b bVarG;
        t[] tVarArrC = this.f23653b.c();
        t tVar3 = tVarArrC[0];
        t tVar4 = tVarArrC[1];
        t tVar5 = tVarArrC[2];
        t tVar6 = tVarArrC[3];
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(h(tVar3, tVar4));
        arrayList.add(h(tVar3, tVar5));
        arrayList.add(h(tVar4, tVar6));
        arrayList.add(h(tVar5, tVar6));
        t tVar7 = null;
        Collections.sort(arrayList, new c());
        b bVar = (b) arrayList.get(0);
        b bVar2 = (b) arrayList.get(1);
        HashMap map = new HashMap();
        e(map, bVar.a());
        e(map, bVar.b());
        e(map, bVar2.a());
        e(map, bVar2.b());
        t tVar8 = null;
        t tVar9 = null;
        for (Map.Entry entry : map.entrySet()) {
            t tVar10 = (t) entry.getKey();
            if (((Integer) entry.getValue()).intValue() == 2) {
                tVar8 = tVar10;
            } else if (tVar7 == null) {
                tVar7 = tVar10;
            } else {
                tVar9 = tVar10;
            }
        }
        if (tVar7 == null || tVar8 == null || tVar9 == null) {
            throw m.a();
        }
        t[] tVarArr = {tVar7, tVar8, tVar9};
        t.e(tVarArr);
        t tVar11 = tVarArr[0];
        t tVar12 = tVarArr[1];
        t tVar13 = tVarArr[2];
        if (!map.containsKey(tVar3)) {
            tVar = tVar3;
        } else if (map.containsKey(tVar4)) {
            tVar = !map.containsKey(tVar5) ? tVar5 : tVar6;
        } else {
            tVar = tVar4;
        }
        int iC = h(tVar13, tVar).c();
        int iC2 = h(tVar11, tVar).c();
        if ((iC & 1) == 1) {
            iC++;
        }
        int i7 = iC + 2;
        if ((iC2 & 1) == 1) {
            iC2++;
        }
        int i8 = iC2 + 2;
        if (i7 * 4 >= i8 * 7 || i8 * 4 >= i7 * 7) {
            tVar2 = tVar13;
            t tVarB = b(tVar12, tVar11, tVar13, tVar, i7, i8);
            if (tVarB != null) {
                tVar = tVarB;
            }
            int iC3 = h(tVar2, tVar).c();
            int iC4 = h(tVar11, tVar).c();
            if ((iC3 & 1) == 1) {
                iC3++;
            }
            int i9 = iC3;
            if ((iC4 & 1) == 1) {
                iC4++;
            }
            bVarG = g(this.f23652a, tVar2, tVar12, tVar11, tVar, i9, iC4);
        } else {
            t tVarA = a(tVar12, tVar11, tVar13, tVar, Math.min(i8, i7));
            if (tVarA != null) {
                tVar = tVarA;
            }
            int iMax = Math.max(h(tVar13, tVar).c(), h(tVar11, tVar).c()) + 1;
            if ((iMax & 1) == 1) {
                iMax++;
            }
            int i10 = iMax;
            bVarG = g(this.f23652a, tVar13, tVar12, tVar11, tVar, i10, i10);
            tVar2 = tVar13;
        }
        return new g(bVarG, new t[]{tVar2, tVar12, tVar11, tVar});
    }
}
