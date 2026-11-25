package com.google.zxing.common.reedsolomon;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f23617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<b> f23618b;

    public d(a aVar) {
        this.f23617a = aVar;
        ArrayList arrayList = new ArrayList();
        this.f23618b = arrayList;
        arrayList.add(new b(aVar, new int[]{1}));
    }

    private b a(int i7) {
        if (i7 >= this.f23618b.size()) {
            List<b> list = this.f23618b;
            b bVarI = list.get(list.size() - 1);
            for (int size = this.f23618b.size(); size <= i7; size++) {
                a aVar = this.f23617a;
                bVarI = bVarI.i(new b(aVar, new int[]{1, aVar.c((size - 1) + aVar.d())}));
                this.f23618b.add(bVarI);
            }
        }
        return this.f23618b.get(i7);
    }

    public void b(int[] iArr, int i7) {
        if (i7 == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i7;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        b bVarA = a(i7);
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        int[] iArrE = new b(this.f23617a, iArr2).j(i7, 1).b(bVarA)[1].e();
        int length2 = i7 - iArrE.length;
        for (int i8 = 0; i8 < length2; i8++) {
            iArr[length + i8] = 0;
        }
        System.arraycopy(iArrE, 0, iArr, length + length2, iArrE.length);
    }
}
