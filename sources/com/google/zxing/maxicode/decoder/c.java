package com.google.zxing.maxicode.decoder;

import com.google.zxing.common.reedsolomon.e;
import com.google.zxing.d;
import com.google.zxing.h;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f23764b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f23765c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f23766d = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.zxing.common.reedsolomon.c f23767a = new com.google.zxing.common.reedsolomon.c(com.google.zxing.common.reedsolomon.a.f23606o);

    private void a(byte[] bArr, int i7, int i8, int i9, int i10) throws d {
        int i11 = i8 + i9;
        int i12 = i10 == 0 ? 1 : 2;
        int[] iArr = new int[i11 / i12];
        for (int i13 = 0; i13 < i11; i13++) {
            if (i10 == 0 || i13 % 2 == i10 - 1) {
                iArr[i13 / i12] = bArr[i13 + i7] & 255;
            }
        }
        try {
            this.f23767a.a(iArr, i9 / i12);
            for (int i14 = 0; i14 < i8; i14++) {
                if (i10 == 0 || i14 % 2 == i10 - 1) {
                    bArr[i14 + i7] = (byte) iArr[i14 / i12];
                }
            }
        } catch (e unused) {
            throw d.a();
        }
    }

    public com.google.zxing.common.e b(com.google.zxing.common.b bVar) throws d, h {
        return c(bVar, null);
    }

    public com.google.zxing.common.e c(com.google.zxing.common.b bVar, Map<com.google.zxing.e, ?> map) throws d, h {
        byte[] bArr;
        byte[] bArrA = new a(bVar).a();
        a(bArrA, 0, 10, 10, 0);
        int i7 = bArrA[0] & com.google.common.base.c.f19317q;
        if (i7 == 2 || i7 == 3 || i7 == 4) {
            a(bArrA, 20, 84, 40, 1);
            a(bArrA, 20, 84, 40, 2);
            bArr = new byte[94];
        } else {
            if (i7 != 5) {
                throw h.a();
            }
            a(bArrA, 20, 68, 56, 1);
            a(bArrA, 20, 68, 56, 2);
            bArr = new byte[78];
        }
        System.arraycopy(bArrA, 0, bArr, 0, 10);
        System.arraycopy(bArrA, 20, bArr, 10, bArr.length - 10);
        return b.a(bArr, i7);
    }
}
