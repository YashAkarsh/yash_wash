package com.google.zxing.qrcode.encoder;

import com.alibaba.fastjson.asm.j;
import com.google.zxing.w;
import easypay.appinvoke.manager.Constants;

/* JADX INFO: loaded from: classes2.dex */
final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[][] f24217a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[][] f24218b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[][] f24219c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, Constants.ACTION_SUBMIT_CLICKED, -1, -1}, new int[]{6, 32, 58, 84, Constants.LOG_ERROR_OTP, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, Constants.ACTION_SUBMIT_CLICKED, 132, 158}, new int[]{6, 32, 58, 84, Constants.LOG_ERROR_OTP, 136, j.L}, new int[]{6, 26, 54, 82, Constants.LOG_ERROR_OTP, 138, j.O}, new int[]{6, 30, 58, 86, 114, 142, 170}};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[][] f24220d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f24221e = 7973;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f24222f = 1335;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f24223g = 21522;

    private e() {
    }

    static void a(com.google.zxing.common.a aVar, com.google.zxing.qrcode.decoder.f fVar, com.google.zxing.qrcode.decoder.j jVar, int i7, b bVar) throws w {
        c(bVar);
        d(jVar, bVar);
        l(fVar, i7, bVar);
        s(jVar, bVar);
        f(aVar, i7, bVar);
    }

    static int b(int i7, int i8) {
        if (i8 == 0) {
            throw new IllegalArgumentException("0 polynomial");
        }
        int iN = n(i8);
        int iN2 = i7 << (iN - 1);
        while (n(iN2) >= iN) {
            iN2 ^= i8 << (n(iN2) - iN);
        }
        return iN2;
    }

    static void c(b bVar) {
        bVar.a((byte) -1);
    }

    static void d(com.google.zxing.qrcode.decoder.j jVar, b bVar) throws w {
        j(bVar);
        e(bVar);
        r(jVar, bVar);
        k(bVar);
    }

    private static void e(b bVar) throws w {
        if (bVar.b(8, bVar.d() - 8) == 0) {
            throw new w();
        }
        bVar.g(8, bVar.d() - 8, 1);
    }

    static void f(com.google.zxing.common.a aVar, int i7, b bVar) throws w {
        boolean zK;
        int iE = bVar.e() - 1;
        int iD = bVar.d() - 1;
        int i8 = 0;
        int i9 = -1;
        while (iE > 0) {
            if (iE == 6) {
                iE--;
            }
            while (iD >= 0 && iD < bVar.d()) {
                for (int i10 = 0; i10 < 2; i10++) {
                    int i11 = iE - i10;
                    if (o(bVar.b(i11, iD))) {
                        if (i8 < aVar.o()) {
                            zK = aVar.k(i8);
                            i8++;
                        } else {
                            zK = false;
                        }
                        if (i7 != -1 && d.f(i7, i11, iD)) {
                            zK = !zK;
                        }
                        bVar.h(i11, iD, zK);
                    }
                }
                iD += i9;
            }
            i9 = -i9;
            iD += i9;
            iE -= 2;
        }
        if (i8 == aVar.o()) {
            return;
        }
        throw new w("Not all bits consumed: " + i8 + '/' + aVar.o());
    }

    private static void g(int i7, int i8, b bVar) throws w {
        for (int i9 = 0; i9 < 8; i9++) {
            int i10 = i7 + i9;
            if (!o(bVar.b(i10, i8))) {
                throw new w();
            }
            bVar.g(i10, i8, 0);
        }
    }

    private static void h(int i7, int i8, b bVar) {
        for (int i9 = 0; i9 < 5; i9++) {
            int[] iArr = f24218b[i9];
            for (int i10 = 0; i10 < 5; i10++) {
                bVar.g(i7 + i10, i8 + i9, iArr[i10]);
            }
        }
    }

    private static void i(int i7, int i8, b bVar) {
        for (int i9 = 0; i9 < 7; i9++) {
            int[] iArr = f24217a[i9];
            for (int i10 = 0; i10 < 7; i10++) {
                bVar.g(i7 + i10, i8 + i9, iArr[i10]);
            }
        }
    }

    private static void j(b bVar) throws w {
        int length = f24217a[0].length;
        i(0, 0, bVar);
        i(bVar.e() - length, 0, bVar);
        i(0, bVar.e() - length, bVar);
        g(0, 7, bVar);
        g(bVar.e() - 8, 7, bVar);
        g(0, bVar.e() - 8, bVar);
        m(7, 0, bVar);
        m((bVar.d() - 7) - 1, 0, bVar);
        m(7, bVar.d() - 7, bVar);
    }

    private static void k(b bVar) {
        int i7 = 8;
        while (i7 < bVar.e() - 8) {
            int i8 = i7 + 1;
            int i9 = i8 % 2;
            if (o(bVar.b(i7, 6))) {
                bVar.g(i7, 6, i9);
            }
            if (o(bVar.b(6, i7))) {
                bVar.g(6, i7, i9);
            }
            i7 = i8;
        }
    }

    static void l(com.google.zxing.qrcode.decoder.f fVar, int i7, b bVar) throws w {
        com.google.zxing.common.a aVar = new com.google.zxing.common.a();
        p(fVar, i7, aVar);
        for (int i8 = 0; i8 < aVar.o(); i8++) {
            boolean zK = aVar.k((aVar.o() - 1) - i8);
            int[] iArr = f24220d[i8];
            bVar.h(iArr[0], iArr[1], zK);
            if (i8 < 8) {
                bVar.h((bVar.e() - i8) - 1, 8, zK);
            } else {
                bVar.h(8, (bVar.d() - 7) + (i8 - 8), zK);
            }
        }
    }

    private static void m(int i7, int i8, b bVar) throws w {
        for (int i9 = 0; i9 < 7; i9++) {
            int i10 = i8 + i9;
            if (!o(bVar.b(i7, i10))) {
                throw new w();
            }
            bVar.g(i7, i10, 0);
        }
    }

    static int n(int i7) {
        return 32 - Integer.numberOfLeadingZeros(i7);
    }

    private static boolean o(int i7) {
        return i7 == -1;
    }

    static void p(com.google.zxing.qrcode.decoder.f fVar, int i7, com.google.zxing.common.a aVar) throws w {
        if (!f.f(i7)) {
            throw new w("Invalid mask pattern");
        }
        int iB = (fVar.b() << 3) | i7;
        aVar.c(iB, 5);
        aVar.c(b(iB, f24222f), 10);
        com.google.zxing.common.a aVar2 = new com.google.zxing.common.a();
        aVar2.c(f24223g, 15);
        aVar.x(aVar2);
        if (aVar.o() == 15) {
            return;
        }
        throw new w("should not happen but we got: " + aVar.o());
    }

    static void q(com.google.zxing.qrcode.decoder.j jVar, com.google.zxing.common.a aVar) throws w {
        aVar.c(jVar.j(), 6);
        aVar.c(b(jVar.j(), f24221e), 12);
        if (aVar.o() == 18) {
            return;
        }
        throw new w("should not happen but we got: " + aVar.o());
    }

    private static void r(com.google.zxing.qrcode.decoder.j jVar, b bVar) {
        if (jVar.j() < 2) {
            return;
        }
        int[] iArr = f24219c[jVar.j() - 1];
        for (int i7 : iArr) {
            if (i7 >= 0) {
                for (int i8 : iArr) {
                    if (i8 >= 0 && o(bVar.b(i8, i7))) {
                        h(i8 - 2, i7 - 2, bVar);
                    }
                }
            }
        }
    }

    static void s(com.google.zxing.qrcode.decoder.j jVar, b bVar) throws w {
        if (jVar.j() < 7) {
            return;
        }
        com.google.zxing.common.a aVar = new com.google.zxing.common.a();
        q(jVar, aVar);
        int i7 = 17;
        for (int i8 = 0; i8 < 6; i8++) {
            for (int i9 = 0; i9 < 3; i9++) {
                boolean zK = aVar.k(i7);
                i7--;
                bVar.h(i8, (bVar.d() - 11) + i9, zK);
                bVar.h((bVar.d() - 11) + i9, i8, zK);
            }
        }
    }
}
