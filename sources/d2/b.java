package d2;

import com.google.zxing.e;
import com.google.zxing.m;
import com.google.zxing.p;
import com.google.zxing.q;
import com.google.zxing.r;
import com.google.zxing.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f33448b = 100;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f33449c = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p f33450a;

    public b(p pVar) {
        this.f33450a = pVar;
    }

    private void a(com.google.zxing.c cVar, Map<e, ?> map, List<r> list, int i7, int i8, int i9) {
        boolean z7;
        float f8;
        int i10;
        int i11;
        if (i9 > 4) {
            return;
        }
        try {
            r rVarA = this.f33450a.a(cVar, map);
            Iterator<r> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().g().equals(rVarA.g())) {
                        z7 = true;
                        break;
                    }
                } else {
                    z7 = false;
                    break;
                }
            }
            if (!z7) {
                list.add(b(rVarA, i7, i8));
            }
            t[] tVarArrF = rVarA.f();
            if (tVarArrF == null || tVarArrF.length == 0) {
                return;
            }
            int iE = cVar.e();
            int iD = cVar.d();
            float f9 = iE;
            float f10 = 0.0f;
            float f11 = iD;
            float f12 = 0.0f;
            for (t tVar : tVarArrF) {
                if (tVar != null) {
                    float fC = tVar.c();
                    float fD = tVar.d();
                    if (fC < f9) {
                        f9 = fC;
                    }
                    if (fD < f11) {
                        f11 = fD;
                    }
                    if (fC > f12) {
                        f12 = fC;
                    }
                    if (fD > f10) {
                        f10 = fD;
                    }
                }
            }
            if (f9 > 100.0f) {
                f8 = f12;
                a(cVar.a(0, 0, (int) f9, iD), map, list, i7, i8, i9 + 1);
            } else {
                f8 = f12;
            }
            if (f11 > 100.0f) {
                i10 = iE;
                a(cVar.a(0, 0, i10, (int) f11), map, list, i7, i8, i9 + 1);
            } else {
                i10 = iE;
            }
            float f13 = f8;
            if (f13 < i10 - 100) {
                int i12 = (int) f13;
                i11 = iD;
                a(cVar.a(i12, 0, i10 - i12, i11), map, list, i7 + i12, i8, i9 + 1);
            } else {
                i11 = iD;
            }
            if (f10 < i11 - 100) {
                int i13 = (int) f10;
                a(cVar.a(0, i13, i10, i11 - i13), map, list, i7, i8 + i13, i9 + 1);
            }
        } catch (q unused) {
        }
    }

    private static r b(r rVar, int i7, int i8) {
        t[] tVarArrF = rVar.f();
        if (tVarArrF == null) {
            return rVar;
        }
        t[] tVarArr = new t[tVarArrF.length];
        for (int i9 = 0; i9 < tVarArrF.length; i9++) {
            t tVar = tVarArrF[i9];
            if (tVar != null) {
                tVarArr[i9] = new t(tVar.c() + i7, tVar.d() + i8);
            }
        }
        r rVar2 = new r(rVar.g(), rVar.d(), rVar.c(), tVarArr, rVar.b(), rVar.h());
        rVar2.i(rVar.e());
        return rVar2;
    }

    @Override // d2.c
    public r[] c(com.google.zxing.c cVar) throws m {
        return d(cVar, null);
    }

    @Override // d2.c
    public r[] d(com.google.zxing.c cVar, Map<e, ?> map) throws m {
        ArrayList arrayList = new ArrayList();
        a(cVar, map, arrayList, 0, 0, 0);
        if (arrayList.isEmpty()) {
            throw m.a();
        }
        return (r[]) arrayList.toArray(new r[arrayList.size()]);
    }
}
