package com.haier.library.a;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public final class u extends AbstractList<j> implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final j[] f26309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int[] f26310b;

    private u(j[] jVarArr, int[] iArr) {
        this.f26309a = jVarArr;
        this.f26310b = iArr;
    }

    private static int a(g gVar) {
        return (int) (gVar.Y0() / 4);
    }

    public static u d(j... jVarArr) {
        if (jVarArr.length == 0) {
            return new u(new j[0], new int[]{0, -1});
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(jVarArr));
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            arrayList2.add(-1);
        }
        for (int i8 = 0; i8 < arrayList.size(); i8++) {
            arrayList2.set(Collections.binarySearch(arrayList, jVarArr[i8]), Integer.valueOf(i8));
        }
        if (((j) arrayList.get(0)).Z() == 0) {
            throw new IllegalArgumentException("the empty byte string is not a supported option");
        }
        int i9 = 0;
        while (i9 < arrayList.size()) {
            j jVar = (j) arrayList.get(i9);
            int i10 = i9 + 1;
            int i11 = i10;
            while (i11 < arrayList.size()) {
                j jVar2 = (j) arrayList.get(i11);
                if (!jVar2.M(jVar)) {
                    break;
                }
                if (jVar2.Z() == jVar.Z()) {
                    throw new IllegalArgumentException("duplicate option: " + jVar2);
                }
                if (((Integer) arrayList2.get(i11)).intValue() > ((Integer) arrayList2.get(i9)).intValue()) {
                    arrayList.remove(i11);
                    arrayList2.remove(i11);
                } else {
                    i11++;
                }
            }
            i9 = i10;
        }
        g gVar = new g();
        f(0L, gVar, 0, arrayList, 0, arrayList.size(), arrayList2);
        int iA = a(gVar);
        int[] iArr = new int[iA];
        for (int i12 = 0; i12 < iA; i12++) {
            iArr[i12] = gVar.l();
        }
        if (gVar.g()) {
            return new u((j[]) jVarArr.clone(), iArr);
        }
        throw new AssertionError();
    }

    private static void f(long j7, g gVar, int i7, List<j> list, int i8, int i9, List<Integer> list2) {
        int iIntValue;
        int i10;
        int i11;
        int i12;
        if (i8 >= i9) {
            throw new AssertionError();
        }
        for (int i13 = i8; i13 < i9; i13++) {
            if (list.get(i13).Z() < i7) {
                throw new AssertionError();
            }
        }
        j jVar = list.get(i8);
        j jVar2 = list.get(i9 - 1);
        if (i7 == jVar.Z()) {
            int i14 = i8 + 1;
            i10 = i14;
            iIntValue = list2.get(i8).intValue();
            jVar = list.get(i14);
        } else {
            iIntValue = -1;
            i10 = i8;
        }
        if (jVar.x(i7) == jVar2.x(i7)) {
            int iMin = Math.min(jVar.Z(), jVar2.Z());
            int i15 = 0;
            for (int i16 = i7; i16 < iMin && jVar.x(i16) == jVar2.x(i16); i16++) {
                i15++;
            }
            long jA = 1 + j7 + ((long) a(gVar)) + 2 + ((long) i15);
            gVar.z0(-i15);
            gVar.z0(iIntValue);
            int i17 = i7;
            while (true) {
                i11 = i7 + i15;
                if (i17 >= i11) {
                    break;
                }
                gVar.z0(jVar.x(i17) & 255);
                i17++;
            }
            if (i10 + 1 == i9) {
                if (i11 != list.get(i10).Z()) {
                    throw new AssertionError();
                }
                gVar.z0(list2.get(i10).intValue());
                return;
            } else {
                g gVar2 = new g();
                gVar.z0((int) ((((long) a(gVar2)) + jA) * (-1)));
                f(jA, gVar2, i11, list, i10, i9, list2);
                gVar.I1(gVar2, gVar2.Y0());
                return;
            }
        }
        int i18 = 1;
        for (int i19 = i10 + 1; i19 < i9; i19++) {
            if (list.get(i19 - 1).x(i7) != list.get(i19).x(i7)) {
                i18++;
            }
        }
        long jA2 = j7 + ((long) a(gVar)) + 2 + ((long) (i18 * 2));
        gVar.z0(i18);
        gVar.z0(iIntValue);
        for (int i20 = i10; i20 < i9; i20++) {
            byte bX = list.get(i20).x(i7);
            if (i20 == i10 || bX != list.get(i20 - 1).x(i7)) {
                gVar.z0(bX & 255);
            }
        }
        g gVar3 = new g();
        int i21 = i10;
        while (i21 < i9) {
            byte bX2 = list.get(i21).x(i7);
            int i22 = i21 + 1;
            int i23 = i22;
            while (true) {
                if (i23 >= i9) {
                    i12 = i9;
                    break;
                } else {
                    if (bX2 != list.get(i23).x(i7)) {
                        i12 = i23;
                        break;
                    }
                    i23++;
                }
            }
            if (i22 == i12 && i7 + 1 == list.get(i21).Z()) {
                gVar.z0(list2.get(i21).intValue());
            } else {
                gVar.z0((int) ((((long) a(gVar3)) + jA2) * (-1)));
                f(jA2, gVar3, i7 + 1, list, i21, i12, list2);
            }
            gVar3 = gVar3;
            i21 = i12;
        }
        g gVar4 = gVar3;
        gVar.I1(gVar4, gVar4.Y0());
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public j get(int i7) {
        return this.f26309a[i7];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f26309a.length;
    }
}
