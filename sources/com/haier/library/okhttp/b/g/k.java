package com.haier.library.okhttp.b.g;

import androidx.core.view.g2;
import easypay.appinvoke.manager.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f27331b = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, g2.f6582r, g2.f6583s, 4090, 8185, 21, 248, 2042, g2.f6584t, g2.f6585u, 249, 2043, androidx.recyclerview.widget.m.f.f9644c, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, g2.f6586v, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, Constants.ACTION_SUBMIT_BTN_USER_PWD_NB, 104, 105, Constants.ACTION_SUBMIT_CLICKED, Constants.OTP_FILLER_WEB_SUCCESS, 108, 109, Constants.LOG_ERROR_OTP, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, Constants.OTP_VIEW_GONE, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final byte[] f27332c = {com.google.common.base.c.f19315o, com.google.common.base.c.A, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.B, com.google.common.base.c.H, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.H, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.H, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, 6, 10, 10, com.google.common.base.c.f19314n, com.google.common.base.c.f19315o, 6, 8, com.google.common.base.c.f19313m, 10, 10, 8, com.google.common.base.c.f19313m, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, com.google.common.base.c.f19317q, 6, com.google.common.base.c.f19314n, 10, com.google.common.base.c.f19315o, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, com.google.common.base.c.f19315o, 19, com.google.common.base.c.f19315o, com.google.common.base.c.f19316p, 6, com.google.common.base.c.f19317q, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, com.google.common.base.c.f19317q, com.google.common.base.c.f19313m, com.google.common.base.c.f19316p, com.google.common.base.c.f19315o, com.google.common.base.c.F, com.google.common.base.c.f19324x, com.google.common.base.c.f19326z, com.google.common.base.c.f19324x, com.google.common.base.c.f19324x, com.google.common.base.c.f19326z, com.google.common.base.c.f19326z, com.google.common.base.c.f19326z, com.google.common.base.c.A, com.google.common.base.c.f19326z, com.google.common.base.c.A, com.google.common.base.c.A, com.google.common.base.c.A, com.google.common.base.c.A, com.google.common.base.c.A, com.google.common.base.c.B, com.google.common.base.c.A, com.google.common.base.c.B, com.google.common.base.c.B, com.google.common.base.c.f19326z, com.google.common.base.c.A, com.google.common.base.c.B, com.google.common.base.c.A, com.google.common.base.c.A, com.google.common.base.c.A, com.google.common.base.c.A, com.google.common.base.c.f19325y, com.google.common.base.c.f19326z, com.google.common.base.c.A, com.google.common.base.c.f19326z, com.google.common.base.c.A, com.google.common.base.c.A, com.google.common.base.c.B, com.google.common.base.c.f19326z, com.google.common.base.c.f19325y, com.google.common.base.c.f19324x, com.google.common.base.c.f19326z, com.google.common.base.c.f19326z, com.google.common.base.c.A, com.google.common.base.c.A, com.google.common.base.c.f19325y, com.google.common.base.c.A, com.google.common.base.c.f19326z, com.google.common.base.c.f19326z, com.google.common.base.c.B, com.google.common.base.c.f19325y, com.google.common.base.c.f19326z, com.google.common.base.c.A, com.google.common.base.c.A, com.google.common.base.c.f19325y, com.google.common.base.c.f19325y, com.google.common.base.c.f19326z, com.google.common.base.c.f19325y, com.google.common.base.c.A, com.google.common.base.c.f19326z, com.google.common.base.c.A, com.google.common.base.c.A, com.google.common.base.c.f19324x, com.google.common.base.c.f19326z, com.google.common.base.c.f19326z, com.google.common.base.c.f19326z, com.google.common.base.c.A, com.google.common.base.c.f19326z, com.google.common.base.c.f19326z, com.google.common.base.c.A, com.google.common.base.c.D, com.google.common.base.c.D, com.google.common.base.c.f19324x, 19, com.google.common.base.c.f19326z, com.google.common.base.c.A, com.google.common.base.c.f19326z, com.google.common.base.c.C, com.google.common.base.c.D, com.google.common.base.c.D, com.google.common.base.c.D, com.google.common.base.c.E, com.google.common.base.c.E, com.google.common.base.c.D, com.google.common.base.c.B, com.google.common.base.c.C, 19, com.google.common.base.c.f19325y, com.google.common.base.c.D, com.google.common.base.c.E, com.google.common.base.c.E, com.google.common.base.c.D, com.google.common.base.c.E, com.google.common.base.c.B, com.google.common.base.c.f19325y, com.google.common.base.c.f19325y, com.google.common.base.c.D, com.google.common.base.c.D, com.google.common.base.c.F, com.google.common.base.c.E, com.google.common.base.c.E, com.google.common.base.c.E, com.google.common.base.c.f19324x, com.google.common.base.c.B, com.google.common.base.c.f19324x, com.google.common.base.c.f19325y, com.google.common.base.c.f19326z, com.google.common.base.c.f19325y, com.google.common.base.c.f19325y, com.google.common.base.c.A, com.google.common.base.c.f19326z, com.google.common.base.c.f19326z, com.google.common.base.c.C, com.google.common.base.c.C, com.google.common.base.c.B, com.google.common.base.c.B, com.google.common.base.c.D, com.google.common.base.c.A, com.google.common.base.c.D, com.google.common.base.c.E, com.google.common.base.c.D, com.google.common.base.c.D, com.google.common.base.c.E, com.google.common.base.c.E, com.google.common.base.c.E, com.google.common.base.c.E, com.google.common.base.c.E, com.google.common.base.c.F, com.google.common.base.c.E, com.google.common.base.c.E, com.google.common.base.c.E, com.google.common.base.c.E, com.google.common.base.c.E, com.google.common.base.c.D};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final k f27333d = new k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f27334a = new a();

    private k() {
        f();
    }

    public static k b() {
        return f27333d;
    }

    private void c(int i7, int i8, byte b8) {
        a aVar = new a(i7, b8);
        a aVar2 = this.f27334a;
        while (b8 > 8) {
            b8 = (byte) (b8 - 8);
            int i9 = (i8 >>> b8) & 255;
            a[] aVarArr = aVar2.f27335a;
            if (aVarArr == null) {
                throw new IllegalStateException("invalid dictionary: prefix not unique");
            }
            if (aVarArr[i9] == null) {
                aVarArr[i9] = new a();
            }
            aVar2 = aVar2.f27335a[i9];
        }
        int i10 = 8 - b8;
        int i11 = (i8 << i10) & 255;
        int i12 = 1 << i10;
        for (int i13 = i11; i13 < i11 + i12; i13++) {
            aVar2.f27335a[i13] = aVar;
        }
    }

    private void f() {
        int i7 = 0;
        while (true) {
            byte[] bArr = f27332c;
            if (i7 >= bArr.length) {
                return;
            }
            c(i7, f27331b[i7], bArr[i7]);
            i7++;
        }
    }

    int a(com.haier.library.a.j jVar) {
        long j7 = 0;
        for (int i7 = 0; i7 < jVar.Z(); i7++) {
            j7 += (long) f27332c[jVar.x(i7) & 255];
        }
        return (int) ((j7 + 7) >> 3);
    }

    void d(com.haier.library.a.j jVar, com.haier.library.a.h hVar) throws IOException {
        long j7 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < jVar.Z(); i8++) {
            int iX = jVar.x(i8) & 255;
            int i9 = f27331b[iX];
            byte b8 = f27332c[iX];
            j7 = (j7 << b8) | ((long) i9);
            i7 += b8;
            while (i7 >= 8) {
                i7 -= 8;
                hVar.y1((int) (j7 >> i7));
            }
        }
        if (i7 > 0) {
            hVar.y1((int) ((j7 << (8 - i7)) | ((long) (255 >>> i7))));
        }
    }

    byte[] e(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a aVar = this.f27334a;
        int i7 = 0;
        int i8 = 0;
        for (byte b8 : bArr) {
            i7 = (i7 << 8) | (b8 & 255);
            i8 += 8;
            while (i8 >= 8) {
                aVar = aVar.f27335a[(i7 >>> (i8 - 8)) & 255];
                if (aVar.f27335a == null) {
                    byteArrayOutputStream.write(aVar.f27336b);
                    i8 -= aVar.f27337c;
                    aVar = this.f27334a;
                } else {
                    i8 -= 8;
                }
            }
        }
        while (i8 > 0) {
            a aVar2 = aVar.f27335a[(i7 << (8 - i8)) & 255];
            if (aVar2.f27335a != null || aVar2.f27337c > i8) {
                break;
            }
            byteArrayOutputStream.write(aVar2.f27336b);
            i8 -= aVar2.f27337c;
            aVar = this.f27334a;
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a[] f27335a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f27336b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f27337c;

        a() {
            this.f27335a = new a[256];
            this.f27336b = 0;
            this.f27337c = 0;
        }

        a(int i7, int i8) {
            this.f27335a = null;
            this.f27336b = i7;
            int i9 = i8 & 7;
            this.f27337c = i9 == 0 ? 8 : i9;
        }
    }
}
