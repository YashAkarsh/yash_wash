package com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static boolean a(byte[] bArr) {
        if (bArr == null || bArr.length < 3) {
            return false;
        }
        int i7 = bArr[bArr.length - 1] == com.haier.hailicommontlib.mvp.model.utils.c.l(85) ? 2 : 1;
        int iD = 0;
        for (int i8 = 2; i8 < bArr.length - i7; i8++) {
            iD += com.haier.hailicommontlib.mvp.model.utils.h.d(bArr[i8]);
        }
        return com.haier.hailicommontlib.mvp.model.utils.c.l(com.haier.hailicommontlib.mvp.model.utils.c.b(iD)) == bArr[bArr.length - i7];
    }

    public static byte[] b(int i7, int... iArr) {
        int iB;
        int i8;
        byte[] bArr;
        int length;
        int i9;
        int iP = com.haier.hailicommontlib.mvp.model.utils.h.p(i7);
        if (iArr == null || iArr.length <= 0) {
            iB = com.haier.hailicommontlib.mvp.model.utils.c.b(iP) & 255;
            i8 = iB == 255 ? 1 : 0;
            bArr = new byte[11 + i8];
            length = 0;
        } else {
            length = iArr.length + 8;
            int iP2 = iP + length;
            ArrayList arrayList = new ArrayList();
            int i10 = 0;
            while (true) {
                if (i10 >= iArr.length) {
                    break;
                }
                iP2 += com.haier.hailicommontlib.mvp.model.utils.h.p(iArr[i10]);
                if (iArr[i10] == 255) {
                    arrayList.add(Integer.valueOf(10 + i10 + 1 + arrayList.size()));
                    iP2 += com.haier.hailicommontlib.mvp.model.utils.h.p(85);
                }
                i10++;
            }
            iB = com.haier.hailicommontlib.mvp.model.utils.c.b(iP2) & 255;
            i8 = iB == 255 ? 1 : 0;
            int size = arrayList.size() + 10 + iArr.length + 1 + i8;
            bArr = new byte[size];
            int i11 = 0;
            int i12 = 0;
            for (i9 = 10; i9 < (size - 1) - i8; i9++) {
                if (arrayList.size() <= i11 || i9 != ((Integer) arrayList.get(i11)).intValue()) {
                    bArr[i9] = com.haier.hailicommontlib.mvp.model.utils.c.l(iArr[i12]);
                    i12++;
                } else {
                    bArr[i9] = com.haier.hailicommontlib.mvp.model.utils.c.l(85);
                    i11++;
                }
            }
        }
        byte bL = com.haier.hailicommontlib.mvp.model.utils.c.l(255);
        bArr[1] = bL;
        bArr[0] = bL;
        bArr[2] = com.haier.hailicommontlib.mvp.model.utils.c.l(com.haier.hailicommontlib.mvp.model.utils.c.b(length));
        bArr[8] = 0;
        bArr[7] = 0;
        bArr[6] = 0;
        bArr[5] = 0;
        bArr[4] = 0;
        bArr[3] = 0;
        bArr[9] = com.haier.hailicommontlib.mvp.model.utils.c.l(i7);
        if (i8 != 0) {
            bArr[bArr.length - 2] = com.haier.hailicommontlib.mvp.model.utils.c.l(iB);
            bArr[bArr.length - 1] = com.haier.hailicommontlib.mvp.model.utils.c.l(85);
        } else {
            bArr[bArr.length - 1] = com.haier.hailicommontlib.mvp.model.utils.c.l(iB);
        }
        return bArr;
    }
}
