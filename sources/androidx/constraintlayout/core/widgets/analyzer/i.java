package androidx.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f3477a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f3478b = false;

    public static o a(androidx.constraintlayout.core.widgets.e eVar, int i7, ArrayList<o> arrayList, o oVar) {
        int iL2;
        int i8 = i7 == 0 ? eVar.S0 : eVar.T0;
        if (i8 != -1 && (oVar == null || i8 != oVar.f3498b)) {
            for (int i9 = 0; i9 < arrayList.size(); i9++) {
                o oVar2 = arrayList.get(i9);
                if (oVar2.f() == i8) {
                    if (oVar != null) {
                        oVar.m(i7, oVar2);
                        arrayList.remove(oVar);
                    }
                    oVar = oVar2;
                    break;
                }
            }
        } else if (i8 != -1) {
            return oVar;
        }
        if (oVar == null) {
            if ((eVar instanceof androidx.constraintlayout.core.widgets.j) && (iL2 = ((androidx.constraintlayout.core.widgets.j) eVar).l2(i7)) != -1) {
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    o oVar3 = arrayList.get(i10);
                    if (oVar3.f() == iL2) {
                        oVar = oVar3;
                        break;
                    }
                }
            }
            if (oVar == null) {
                oVar = new o(i7);
            }
            arrayList.add(oVar);
        }
        if (oVar.a(eVar)) {
            if (eVar instanceof androidx.constraintlayout.core.widgets.h) {
                androidx.constraintlayout.core.widgets.h hVar = (androidx.constraintlayout.core.widgets.h) eVar;
                hVar.l2().d(hVar.m2() == 0 ? 1 : 0, arrayList, oVar);
            }
            if (i7 == 0) {
                eVar.S0 = oVar.f();
                eVar.Q.d(i7, arrayList, oVar);
                eVar.S.d(i7, arrayList, oVar);
            } else {
                eVar.T0 = oVar.f();
                eVar.R.d(i7, arrayList, oVar);
                eVar.U.d(i7, arrayList, oVar);
                eVar.T.d(i7, arrayList, oVar);
            }
            eVar.X.d(i7, arrayList, oVar);
        }
        return oVar;
    }

    private static o b(ArrayList<o> arrayList, int i7) {
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            o oVar = arrayList.get(i8);
            if (i7 == oVar.f3498b) {
                return oVar;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:179:0x0356  */
    public static boolean c(androidx.constraintlayout.core.widgets.f fVar, b.InterfaceC0040b interfaceC0040b) {
        o oVar;
        boolean z7;
        boolean z8;
        o oVar2;
        ArrayList<androidx.constraintlayout.core.widgets.e> arrayListL2 = fVar.l2();
        int size = arrayListL2.size();
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            androidx.constraintlayout.core.widgets.e eVar = arrayListL2.get(i8);
            if (!d(fVar.H(), fVar.j0(), eVar.H(), eVar.j0()) || (eVar instanceof androidx.constraintlayout.core.widgets.g)) {
                return false;
            }
        }
        androidx.constraintlayout.core.f fVar2 = fVar.G1;
        if (fVar2 != null) {
            fVar2.Q++;
        }
        int i9 = 0;
        ArrayList arrayList = null;
        ArrayList<androidx.constraintlayout.core.widgets.j> arrayList2 = null;
        ArrayList arrayList3 = null;
        ArrayList<androidx.constraintlayout.core.widgets.j> arrayList4 = null;
        ArrayList arrayList5 = null;
        ArrayList arrayList6 = null;
        while (i9 < size) {
            androidx.constraintlayout.core.widgets.e eVar2 = arrayListL2.get(i9);
            if (!d(fVar.H(), fVar.j0(), eVar2.H(), eVar2.j0())) {
                androidx.constraintlayout.core.widgets.f.R2(i7, eVar2, interfaceC0040b, fVar.f3669f2, b.a.f3424k);
            }
            boolean z9 = eVar2 instanceof androidx.constraintlayout.core.widgets.h;
            if (z9) {
                androidx.constraintlayout.core.widgets.h hVar = (androidx.constraintlayout.core.widgets.h) eVar2;
                if (hVar.m2() == 0) {
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                    }
                    arrayList3.add(hVar);
                }
                if (hVar.m2() == 1) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(hVar);
                }
            }
            if (eVar2 instanceof androidx.constraintlayout.core.widgets.j) {
                if (eVar2 instanceof androidx.constraintlayout.core.widgets.a) {
                    androidx.constraintlayout.core.widgets.a aVar = (androidx.constraintlayout.core.widgets.a) eVar2;
                    if (aVar.r2() == 0) {
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        arrayList2.add(aVar);
                    }
                    if (aVar.r2() == 1) {
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        arrayList4.add(aVar);
                    }
                } else {
                    androidx.constraintlayout.core.widgets.j jVar = (androidx.constraintlayout.core.widgets.j) eVar2;
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    arrayList2.add(jVar);
                    if (arrayList4 == null) {
                        arrayList4 = new ArrayList();
                    }
                    arrayList4.add(jVar);
                }
            }
            if (eVar2.Q.f3558f == null && eVar2.S.f3558f == null && !z9 && !(eVar2 instanceof androidx.constraintlayout.core.widgets.a)) {
                if (arrayList5 == null) {
                    arrayList5 = new ArrayList();
                }
                arrayList5.add(eVar2);
            }
            if (eVar2.R.f3558f == null && eVar2.T.f3558f == null && eVar2.U.f3558f == null && !z9 && !(eVar2 instanceof androidx.constraintlayout.core.widgets.a)) {
                if (arrayList6 == null) {
                    arrayList6 = new ArrayList();
                }
                arrayList6.add(eVar2);
            }
            i9++;
            i7 = 0;
        }
        ArrayList<o> arrayList7 = new ArrayList<>();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                a((androidx.constraintlayout.core.widgets.h) it.next(), 0, arrayList7, null);
            }
        }
        o oVar3 = null;
        int i10 = 0;
        if (arrayList2 != null) {
            for (androidx.constraintlayout.core.widgets.j jVar2 : arrayList2) {
                o oVarA = a(jVar2, i10, arrayList7, oVar3);
                jVar2.k2(arrayList7, i10, oVarA);
                oVarA.c(arrayList7);
                oVar3 = null;
                i10 = 0;
            }
        }
        androidx.constraintlayout.core.widgets.d dVarR = fVar.r(androidx.constraintlayout.core.widgets.d.b.LEFT);
        if (dVarR.e() != null) {
            Iterator<androidx.constraintlayout.core.widgets.d> it2 = dVarR.e().iterator();
            while (it2.hasNext()) {
                a(it2.next().f3556d, 0, arrayList7, null);
            }
        }
        androidx.constraintlayout.core.widgets.d dVarR2 = fVar.r(androidx.constraintlayout.core.widgets.d.b.RIGHT);
        if (dVarR2.e() != null) {
            Iterator<androidx.constraintlayout.core.widgets.d> it3 = dVarR2.e().iterator();
            while (it3.hasNext()) {
                a(it3.next().f3556d, 0, arrayList7, null);
            }
        }
        androidx.constraintlayout.core.widgets.d dVarR3 = fVar.r(androidx.constraintlayout.core.widgets.d.b.CENTER);
        if (dVarR3.e() != null) {
            Iterator<androidx.constraintlayout.core.widgets.d> it4 = dVarR3.e().iterator();
            while (it4.hasNext()) {
                a(it4.next().f3556d, 0, arrayList7, null);
            }
        }
        o oVar4 = null;
        if (arrayList5 != null) {
            Iterator it5 = arrayList5.iterator();
            while (it5.hasNext()) {
                a((androidx.constraintlayout.core.widgets.e) it5.next(), 0, arrayList7, null);
            }
        }
        if (arrayList3 != null) {
            Iterator it6 = arrayList3.iterator();
            while (it6.hasNext()) {
                a((androidx.constraintlayout.core.widgets.h) it6.next(), 1, arrayList7, null);
            }
        }
        int i11 = 1;
        if (arrayList4 != null) {
            for (androidx.constraintlayout.core.widgets.j jVar3 : arrayList4) {
                o oVarA2 = a(jVar3, i11, arrayList7, oVar4);
                jVar3.k2(arrayList7, i11, oVarA2);
                oVarA2.c(arrayList7);
                oVar4 = null;
                i11 = 1;
            }
        }
        androidx.constraintlayout.core.widgets.d dVarR4 = fVar.r(androidx.constraintlayout.core.widgets.d.b.TOP);
        if (dVarR4.e() != null) {
            Iterator<androidx.constraintlayout.core.widgets.d> it7 = dVarR4.e().iterator();
            while (it7.hasNext()) {
                a(it7.next().f3556d, 1, arrayList7, null);
            }
        }
        androidx.constraintlayout.core.widgets.d dVarR5 = fVar.r(androidx.constraintlayout.core.widgets.d.b.BASELINE);
        if (dVarR5.e() != null) {
            Iterator<androidx.constraintlayout.core.widgets.d> it8 = dVarR5.e().iterator();
            while (it8.hasNext()) {
                a(it8.next().f3556d, 1, arrayList7, null);
            }
        }
        androidx.constraintlayout.core.widgets.d dVarR6 = fVar.r(androidx.constraintlayout.core.widgets.d.b.BOTTOM);
        if (dVarR6.e() != null) {
            Iterator<androidx.constraintlayout.core.widgets.d> it9 = dVarR6.e().iterator();
            while (it9.hasNext()) {
                a(it9.next().f3556d, 1, arrayList7, null);
            }
        }
        androidx.constraintlayout.core.widgets.d dVarR7 = fVar.r(androidx.constraintlayout.core.widgets.d.b.CENTER);
        if (dVarR7.e() != null) {
            Iterator<androidx.constraintlayout.core.widgets.d> it10 = dVarR7.e().iterator();
            while (it10.hasNext()) {
                a(it10.next().f3556d, 1, arrayList7, null);
            }
        }
        if (arrayList6 != null) {
            Iterator it11 = arrayList6.iterator();
            while (it11.hasNext()) {
                a((androidx.constraintlayout.core.widgets.e) it11.next(), 1, arrayList7, null);
            }
        }
        for (int i12 = 0; i12 < size; i12++) {
            androidx.constraintlayout.core.widgets.e eVar3 = arrayListL2.get(i12);
            if (eVar3.Q0()) {
                o oVarB = b(arrayList7, eVar3.S0);
                o oVarB2 = b(arrayList7, eVar3.T0);
                if (oVarB != null && oVarB2 != null) {
                    oVarB.m(0, oVarB2);
                    oVarB2.o(2);
                    arrayList7.remove(oVarB);
                }
            }
        }
        if (arrayList7.size() <= 1) {
            return false;
        }
        if (fVar.H() == androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT) {
            oVar = null;
            int i13 = 0;
            for (o oVar5 : arrayList7) {
                if (oVar5.g() != 1) {
                    oVar5.n(false);
                    int iL = oVar5.l(fVar.I2(), 0);
                    if (iL > i13) {
                        oVar = oVar5;
                        i13 = iL;
                    }
                }
            }
            if (oVar != null) {
                fVar.D1(androidx.constraintlayout.core.widgets.e.b.FIXED);
                fVar.c2(i13);
                oVar.n(true);
            } else {
                oVar = null;
            }
        } else {
            oVar = null;
        }
        if (fVar.j0() == androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT) {
            o oVar6 = null;
            int i14 = 0;
            for (o oVar7 : arrayList7) {
                if (oVar7.g() != 0) {
                    oVar7.n(false);
                    int iL2 = oVar7.l(fVar.I2(), 1);
                    if (iL2 > i14) {
                        oVar6 = oVar7;
                        i14 = iL2;
                    }
                }
            }
            z7 = false;
            z8 = true;
            if (oVar6 != null) {
                fVar.Y1(androidx.constraintlayout.core.widgets.e.b.FIXED);
                fVar.y1(i14);
                oVar6.n(true);
                oVar2 = oVar6;
            }
            return (oVar == null || oVar2 != null) ? z8 : z7;
        }
        z7 = false;
        z8 = true;
        oVar2 = null;
        if (oVar == null) {
        }
    }

    public static boolean d(androidx.constraintlayout.core.widgets.e.b bVar, androidx.constraintlayout.core.widgets.e.b bVar2, androidx.constraintlayout.core.widgets.e.b bVar3, androidx.constraintlayout.core.widgets.e.b bVar4) {
        androidx.constraintlayout.core.widgets.e.b bVar5;
        androidx.constraintlayout.core.widgets.e.b bVar6;
        androidx.constraintlayout.core.widgets.e.b bVar7 = androidx.constraintlayout.core.widgets.e.b.FIXED;
        return (bVar3 == bVar7 || bVar3 == (bVar6 = androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT) || (bVar3 == androidx.constraintlayout.core.widgets.e.b.MATCH_PARENT && bVar != bVar6)) || (bVar4 == bVar7 || bVar4 == (bVar5 = androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT) || (bVar4 == androidx.constraintlayout.core.widgets.e.b.MATCH_PARENT && bVar2 != bVar5));
    }
}
