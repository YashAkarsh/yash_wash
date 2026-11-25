package com.google.zxing.qrcode.detector;

import com.google.zxing.m;
import com.google.zxing.t;
import com.google.zxing.u;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f24192f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected static final int f24193g = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected static final int f24194h = 97;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.zxing.common.b f24195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<d> f24196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f24197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f24198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final u f24199e;

    private static final class b implements Serializable, Comparator<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f24200a;

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            int iCompare = Integer.compare(dVar2.h(), dVar.h());
            return iCompare == 0 ? Float.compare(Math.abs(dVar.i() - this.f24200a), Math.abs(dVar2.i() - this.f24200a)) : iCompare;
        }

        private b(float f8) {
            this.f24200a = f8;
        }
    }

    private static final class c implements Serializable, Comparator<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f24201a;

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            return Float.compare(Math.abs(dVar2.i() - this.f24201a), Math.abs(dVar.i() - this.f24201a));
        }

        private c(float f8) {
            this.f24201a = f8;
        }
    }

    public e(com.google.zxing.common.b bVar) {
        this(bVar, null);
    }

    private static float a(int[] iArr, int i7) {
        return ((i7 - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    private boolean c(int i7, int i8) {
        int i9;
        int i10;
        int i11;
        int[] iArrJ = j();
        int i12 = 0;
        while (i7 >= i12 && i8 >= i12 && this.f24195a.j(i8 - i12, i7 - i12)) {
            iArrJ[2] = iArrJ[2] + 1;
            i12++;
        }
        if (iArrJ[2] == 0) {
            return false;
        }
        while (i7 >= i12 && i8 >= i12 && !this.f24195a.j(i8 - i12, i7 - i12)) {
            iArrJ[1] = iArrJ[1] + 1;
            i12++;
        }
        if (iArrJ[1] == 0) {
            return false;
        }
        while (i7 >= i12 && i8 >= i12 && this.f24195a.j(i8 - i12, i7 - i12)) {
            iArrJ[0] = iArrJ[0] + 1;
            i12++;
        }
        if (iArrJ[0] == 0) {
            return false;
        }
        int iM = this.f24195a.m();
        int iQ = this.f24195a.q();
        int i13 = 1;
        while (true) {
            int i14 = i7 + i13;
            if (i14 >= iM || (i11 = i8 + i13) >= iQ || !this.f24195a.j(i11, i14)) {
                break;
            }
            iArrJ[2] = iArrJ[2] + 1;
            i13++;
        }
        while (true) {
            int i15 = i7 + i13;
            if (i15 >= iM || (i10 = i8 + i13) >= iQ || this.f24195a.j(i10, i15)) {
                break;
            }
            iArrJ[3] = iArrJ[3] + 1;
            i13++;
        }
        if (iArrJ[3] == 0) {
            return false;
        }
        while (true) {
            int i16 = i7 + i13;
            if (i16 >= iM || (i9 = i8 + i13) >= iQ || !this.f24195a.j(i9, i16)) {
                break;
            }
            iArrJ[4] = iArrJ[4] + 1;
            i13++;
        }
        if (iArrJ[4] == 0) {
            return false;
        }
        return i(iArrJ);
    }

    private float d(int i7, int i8, int i9, int i10) {
        int i11;
        int i12;
        int i13;
        com.google.zxing.common.b bVar = this.f24195a;
        int iQ = bVar.q();
        int[] iArrJ = j();
        int i14 = i7;
        while (i14 >= 0 && bVar.j(i14, i8)) {
            iArrJ[2] = iArrJ[2] + 1;
            i14--;
        }
        if (i14 < 0) {
            return Float.NaN;
        }
        while (i14 >= 0 && !bVar.j(i14, i8)) {
            int i15 = iArrJ[1];
            if (i15 > i9) {
                break;
            }
            iArrJ[1] = i15 + 1;
            i14--;
        }
        if (i14 >= 0 && iArrJ[1] <= i9) {
            while (i14 >= 0 && bVar.j(i14, i8) && (i13 = iArrJ[0]) <= i9) {
                iArrJ[0] = i13 + 1;
                i14--;
            }
            if (iArrJ[0] > i9) {
                return Float.NaN;
            }
            int i16 = i7 + 1;
            while (i16 < iQ && bVar.j(i16, i8)) {
                iArrJ[2] = iArrJ[2] + 1;
                i16++;
            }
            if (i16 == iQ) {
                return Float.NaN;
            }
            while (i16 < iQ && !bVar.j(i16, i8) && (i12 = iArrJ[3]) < i9) {
                iArrJ[3] = i12 + 1;
                i16++;
            }
            if (i16 != iQ && iArrJ[3] < i9) {
                while (i16 < iQ && bVar.j(i16, i8) && (i11 = iArrJ[4]) < i9) {
                    iArrJ[4] = i11 + 1;
                    i16++;
                }
                int i17 = iArrJ[4];
                if (i17 < i9 && Math.abs(((((iArrJ[0] + iArrJ[1]) + iArrJ[2]) + iArrJ[3]) + i17) - i10) * 5 < i10 && h(iArrJ)) {
                    return a(iArrJ, i16);
                }
            }
        }
        return Float.NaN;
    }

    private float e(int i7, int i8, int i9, int i10) {
        int i11;
        int i12;
        int i13;
        com.google.zxing.common.b bVar = this.f24195a;
        int iM = bVar.m();
        int[] iArrJ = j();
        int i14 = i7;
        while (i14 >= 0 && bVar.j(i8, i14)) {
            iArrJ[2] = iArrJ[2] + 1;
            i14--;
        }
        if (i14 < 0) {
            return Float.NaN;
        }
        while (i14 >= 0 && !bVar.j(i8, i14)) {
            int i15 = iArrJ[1];
            if (i15 > i9) {
                break;
            }
            iArrJ[1] = i15 + 1;
            i14--;
        }
        if (i14 >= 0 && iArrJ[1] <= i9) {
            while (i14 >= 0 && bVar.j(i8, i14) && (i13 = iArrJ[0]) <= i9) {
                iArrJ[0] = i13 + 1;
                i14--;
            }
            if (iArrJ[0] > i9) {
                return Float.NaN;
            }
            int i16 = i7 + 1;
            while (i16 < iM && bVar.j(i8, i16)) {
                iArrJ[2] = iArrJ[2] + 1;
                i16++;
            }
            if (i16 == iM) {
                return Float.NaN;
            }
            while (i16 < iM && !bVar.j(i8, i16) && (i12 = iArrJ[3]) < i9) {
                iArrJ[3] = i12 + 1;
                i16++;
            }
            if (i16 != iM && iArrJ[3] < i9) {
                while (i16 < iM && bVar.j(i8, i16) && (i11 = iArrJ[4]) < i9) {
                    iArrJ[4] = i11 + 1;
                    i16++;
                }
                int i17 = iArrJ[4];
                if (i17 < i9 && Math.abs(((((iArrJ[0] + iArrJ[1]) + iArrJ[2]) + iArrJ[3]) + i17) - i10) * 5 < i10 * 2 && h(iArrJ)) {
                    return a(iArrJ, i16);
                }
            }
        }
        return Float.NaN;
    }

    private int g() {
        if (this.f24196b.size() <= 1) {
            return 0;
        }
        d dVar = null;
        for (d dVar2 : this.f24196b) {
            if (dVar2.h() >= 2) {
                if (dVar != null) {
                    this.f24197c = true;
                    return ((int) (Math.abs(dVar.c() - dVar2.c()) - Math.abs(dVar.d() - dVar2.d()))) / 2;
                }
                dVar = dVar2;
            }
        }
        return 0;
    }

    protected static boolean h(int[] iArr) {
        int i7 = 0;
        for (int i8 = 0; i8 < 5; i8++) {
            int i9 = iArr[i8];
            if (i9 == 0) {
                return false;
            }
            i7 += i9;
        }
        if (i7 < 7) {
            return false;
        }
        float f8 = i7 / 7.0f;
        float f9 = f8 / 2.0f;
        return Math.abs(f8 - ((float) iArr[0])) < f9 && Math.abs(f8 - ((float) iArr[1])) < f9 && Math.abs((f8 * 3.0f) - ((float) iArr[2])) < 3.0f * f9 && Math.abs(f8 - ((float) iArr[3])) < f9 && Math.abs(f8 - ((float) iArr[4])) < f9;
    }

    protected static boolean i(int[] iArr) {
        int i7 = 0;
        for (int i8 = 0; i8 < 5; i8++) {
            int i9 = iArr[i8];
            if (i9 == 0) {
                return false;
            }
            i7 += i9;
        }
        if (i7 < 7) {
            return false;
        }
        float f8 = i7 / 7.0f;
        float f9 = f8 / 1.333f;
        return Math.abs(f8 - ((float) iArr[0])) < f9 && Math.abs(f8 - ((float) iArr[1])) < f9 && Math.abs((f8 * 3.0f) - ((float) iArr[2])) < 3.0f * f9 && Math.abs(f8 - ((float) iArr[3])) < f9 && Math.abs(f8 - ((float) iArr[4])) < f9;
    }

    private int[] j() {
        b(this.f24198d);
        return this.f24198d;
    }

    private boolean o() {
        int size = this.f24196b.size();
        float fAbs = 0.0f;
        int i7 = 0;
        float fI = 0.0f;
        for (d dVar : this.f24196b) {
            if (dVar.h() >= 2) {
                i7++;
                fI += dVar.i();
            }
        }
        if (i7 < 3) {
            return false;
        }
        float f8 = fI / size;
        Iterator<d> it = this.f24196b.iterator();
        while (it.hasNext()) {
            fAbs += Math.abs(it.next().i() - f8);
        }
        return fAbs <= fI * 0.05f;
    }

    private d[] p() throws m {
        int size = this.f24196b.size();
        if (size < 3) {
            throw m.a();
        }
        float fI = 0.0f;
        if (size > 3) {
            Iterator<d> it = this.f24196b.iterator();
            float f8 = 0.0f;
            float f9 = 0.0f;
            while (it.hasNext()) {
                float fI2 = it.next().i();
                f8 += fI2;
                f9 += fI2 * fI2;
            }
            float f10 = size;
            float f11 = f8 / f10;
            float fSqrt = (float) Math.sqrt((f9 / f10) - (f11 * f11));
            Collections.sort(this.f24196b, new c(f11));
            float fMax = Math.max(0.2f * f11, fSqrt);
            int i7 = 0;
            while (i7 < this.f24196b.size() && this.f24196b.size() > 3) {
                if (Math.abs(this.f24196b.get(i7).i() - f11) > fMax) {
                    this.f24196b.remove(i7);
                    i7--;
                }
                i7++;
            }
        }
        if (this.f24196b.size() > 3) {
            Iterator<d> it2 = this.f24196b.iterator();
            while (it2.hasNext()) {
                fI += it2.next().i();
            }
            Collections.sort(this.f24196b, new b(fI / this.f24196b.size()));
            List<d> list = this.f24196b;
            list.subList(3, list.size()).clear();
        }
        return new d[]{this.f24196b.get(0), this.f24196b.get(1), this.f24196b.get(2)};
    }

    protected final void b(int[] iArr) {
        for (int i7 = 0; i7 < iArr.length; i7++) {
            iArr[i7] = 0;
        }
    }

    final f f(Map<com.google.zxing.e, ?> map) throws m {
        boolean z7 = map != null && map.containsKey(com.google.zxing.e.TRY_HARDER);
        int iM = this.f24195a.m();
        int iQ = this.f24195a.q();
        int i7 = (iM * 3) / 388;
        if (i7 < 3 || z7) {
            i7 = 3;
        }
        int[] iArr = new int[5];
        int i8 = i7 - 1;
        boolean zO = false;
        while (i8 < iM && !zO) {
            b(iArr);
            int i9 = 0;
            int i10 = 0;
            while (i9 < iQ) {
                if (this.f24195a.j(i9, i8)) {
                    if ((i10 & 1) == 1) {
                        i10++;
                    }
                    iArr[i10] = iArr[i10] + 1;
                } else if ((i10 & 1) != 0) {
                    iArr[i10] = iArr[i10] + 1;
                } else if (i10 != 4) {
                    i10++;
                    iArr[i10] = iArr[i10] + 1;
                } else if (h(iArr) && m(iArr, i8, i9)) {
                    if (this.f24197c) {
                        zO = o();
                    } else {
                        int iG = g();
                        int i11 = iArr[2];
                        if (iG > i11) {
                            i8 += (iG - i11) - 2;
                            i9 = iQ - 1;
                        }
                    }
                    b(iArr);
                    i7 = 2;
                    i10 = 0;
                } else {
                    q(iArr);
                    i10 = 3;
                }
                i9++;
            }
            if (h(iArr) && m(iArr, i8, iQ)) {
                i7 = iArr[0];
                if (this.f24197c) {
                    zO = o();
                }
            }
            i8 += i7;
        }
        d[] dVarArrP = p();
        t.e(dVarArrP);
        return new f(dVarArrP);
    }

    protected final com.google.zxing.common.b k() {
        return this.f24195a;
    }

    protected final List<d> l() {
        return this.f24196b;
    }

    protected final boolean m(int[] iArr, int i7, int i8) {
        boolean z7 = false;
        int i9 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int iA = (int) a(iArr, i8);
        float fE = e(i7, iA, iArr[2], i9);
        if (!Float.isNaN(fE)) {
            int i10 = (int) fE;
            float fD = d(iA, i10, iArr[2], i9);
            if (!Float.isNaN(fD) && c(i10, (int) fD)) {
                float f8 = i9 / 7.0f;
                for (int i11 = 0; i11 < this.f24196b.size(); i11++) {
                    d dVar = this.f24196b.get(i11);
                    if (dVar.f(f8, fE, fD)) {
                        this.f24196b.set(i11, dVar.g(fE, fD, f8));
                        z7 = true;
                        break;
                    }
                }
                if (!z7) {
                    d dVar2 = new d(fD, fE, f8);
                    this.f24196b.add(dVar2);
                    u uVar = this.f24199e;
                    if (uVar != null) {
                        uVar.a(dVar2);
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Deprecated
    protected final boolean n(int[] iArr, int i7, int i8, boolean z7) {
        return m(iArr, i7, i8);
    }

    protected final void q(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    public e(com.google.zxing.common.b bVar, u uVar) {
        this.f24195a = bVar;
        this.f24196b = new ArrayList();
        this.f24198d = new int[5];
        this.f24199e = uVar;
    }
}
