package f2;

import com.google.zxing.c;
import com.google.zxing.e;
import com.google.zxing.m;
import com.google.zxing.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f33891c = 0.42f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f33892d = 0.8f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f33895g = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f33896h = 5;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f33897i = 25;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f33898j = 5;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f33899k = 10;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f33889a = {0, 4, 1, 5};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f33890b = {6, 2, 7, 3};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f33893e = {8, 1, 1, 1, 1, 1, 1, 3};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f33894f = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    private a() {
    }

    private static void a(t[] tVarArr, t[] tVarArr2, int[] iArr) {
        for (int i7 = 0; i7 < iArr.length; i7++) {
            tVarArr[iArr[i7]] = tVarArr2[i7];
        }
    }

    public static b b(c cVar, Map<e, ?> map, boolean z7) throws m {
        com.google.zxing.common.b bVarB = cVar.b();
        List<t[]> listC = c(z7, bVarB);
        if (listC.isEmpty()) {
            bVarB = bVarB.clone();
            bVarB.t();
            listC = c(z7, bVarB);
        }
        return new b(bVarB, listC);
    }

    private static List<t[]> c(boolean z7, com.google.zxing.common.b bVar) {
        int iC;
        float fD;
        ArrayList<t[]> arrayList = new ArrayList();
        int iMax = 0;
        int i7 = 0;
        loop0: while (true) {
            int i8 = i7;
            while (iMax < bVar.m()) {
                t[] tVarArrF = f(bVar, iMax, i7);
                if (tVarArrF[0] == null && tVarArrF[3] == null) {
                    if (i8 == 0) {
                        break;
                    }
                    for (t[] tVarArr : arrayList) {
                        t tVar = tVarArr[1];
                        if (tVar != null) {
                            iMax = (int) Math.max(iMax, tVar.d());
                        }
                        t tVar2 = tVarArr[3];
                        if (tVar2 != null) {
                            iMax = Math.max(iMax, (int) tVar2.d());
                        }
                    }
                    iMax += 5;
                    i7 = 0;
                } else {
                    arrayList.add(tVarArrF);
                    if (!z7) {
                        break loop0;
                    }
                    t tVar3 = tVarArrF[2];
                    if (tVar3 != null) {
                        iC = (int) tVar3.c();
                        fD = tVarArrF[2].d();
                    } else {
                        iC = (int) tVarArrF[4].c();
                        fD = tVarArrF[4].d();
                    }
                    iMax = (int) fD;
                    i7 = iC;
                    i8 = 1;
                }
            }
            break loop0;
        }
        return arrayList;
    }

    private static int[] d(com.google.zxing.common.b bVar, int i7, int i8, int i9, boolean z7, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i10 = 0;
        while (bVar.j(i7, i8) && i7 > 0) {
            int i11 = i10 + 1;
            if (i10 >= 3) {
                break;
            }
            i7--;
            i10 = i11;
        }
        int length = iArr.length;
        boolean z8 = z7;
        int i12 = 0;
        int i13 = i7;
        while (i7 < i9) {
            if (bVar.j(i7, i8) != z8) {
                iArr2[i12] = iArr2[i12] + 1;
            } else {
                if (i12 != length - 1) {
                    i12++;
                } else {
                    if (g(iArr2, iArr, f33892d) < f33891c) {
                        return new int[]{i13, i7};
                    }
                    i13 += iArr2[0] + iArr2[1];
                    int i14 = i12 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i14);
                    iArr2[i14] = 0;
                    iArr2[i12] = 0;
                    i12--;
                }
                iArr2[i12] = 1;
                z8 = !z8;
            }
            i7++;
        }
        if (i12 != length - 1 || g(iArr2, iArr, f33892d) >= f33891c) {
            return null;
        }
        return new int[]{i13, i7 - 1};
    }

    private static t[] e(com.google.zxing.common.b bVar, int i7, int i8, int i9, int i10, int[] iArr) {
        boolean z7;
        int i11;
        int i12;
        int i13;
        t[] tVarArr = new t[4];
        int[] iArr2 = new int[iArr.length];
        int i14 = i9;
        while (true) {
            if (i14 >= i7) {
                z7 = false;
                break;
            }
            int[] iArrD = d(bVar, i10, i14, i8, false, iArr, iArr2);
            if (iArrD != null) {
                int i15 = i14;
                int[] iArr3 = iArrD;
                int i16 = i15;
                while (true) {
                    if (i16 <= 0) {
                        i13 = i16;
                        break;
                    }
                    int i17 = i16 - 1;
                    int[] iArrD2 = d(bVar, i10, i17, i8, false, iArr, iArr2);
                    if (iArrD2 == null) {
                        i13 = i17 + 1;
                        break;
                    }
                    iArr3 = iArrD2;
                    i16 = i17;
                }
                float f8 = i13;
                tVarArr[0] = new t(iArr3[0], f8);
                tVarArr[1] = new t(iArr3[1], f8);
                z7 = true;
                i14 = i13;
                break;
            }
            i14 += 5;
        }
        int i18 = i14 + 1;
        if (z7) {
            int[] iArr4 = {(int) tVarArr[0].c(), (int) tVarArr[1].c()};
            int i19 = i18;
            int i20 = 0;
            while (true) {
                if (i19 >= i7) {
                    i11 = i20;
                    i12 = i19;
                    break;
                }
                i11 = i20;
                i12 = i19;
                int[] iArrD3 = d(bVar, iArr4[0], i19, i8, false, iArr, iArr2);
                if (iArrD3 != null && Math.abs(iArr4[0] - iArrD3[0]) < 5 && Math.abs(iArr4[1] - iArrD3[1]) < 5) {
                    iArr4 = iArrD3;
                    i20 = 0;
                } else {
                    if (i11 > 25) {
                        break;
                    }
                    i20 = i11 + 1;
                }
                i19 = i12 + 1;
            }
            i18 = i12 - (i11 + 1);
            float f9 = i18;
            tVarArr[2] = new t(iArr4[0], f9);
            tVarArr[3] = new t(iArr4[1], f9);
        }
        if (i18 - i14 < 10) {
            Arrays.fill(tVarArr, (Object) null);
        }
        return tVarArr;
    }

    private static t[] f(com.google.zxing.common.b bVar, int i7, int i8) {
        int iM = bVar.m();
        int iQ = bVar.q();
        t[] tVarArr = new t[8];
        a(tVarArr, e(bVar, iM, iQ, i7, i8, f33893e), f33889a);
        t tVar = tVarArr[4];
        if (tVar != null) {
            i8 = (int) tVar.c();
            i7 = (int) tVarArr[4].d();
        }
        a(tVarArr, e(bVar, iM, iQ, i7, i8, f33894f), f33890b);
        return tVarArr;
    }

    private static float g(int[] iArr, int[] iArr2, float f8) {
        int length = iArr.length;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < length; i9++) {
            i7 += iArr[i9];
            i8 += iArr2[i9];
        }
        if (i7 < i8) {
            return Float.POSITIVE_INFINITY;
        }
        float f9 = i7;
        float f10 = f9 / i8;
        float f11 = f8 * f10;
        float f12 = 0.0f;
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = iArr[i10];
            float f13 = iArr2[i10] * f10;
            float f14 = i11;
            float f15 = f14 > f13 ? f14 - f13 : f13 - f14;
            if (f15 > f11) {
                return Float.POSITIVE_INFINITY;
            }
            f12 += f15;
        }
        return f12 / f9;
    }
}
