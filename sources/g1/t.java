package g1;

import c.m0;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class t {
    private t() {
    }

    @c1.a
    public static int a(@m0 byte[] bArr, int i7, int i8, int i9) {
        int i10 = (i8 & (-4)) + i7;
        while (i7 < i10) {
            int i11 = ((bArr[i7] & 255) | ((bArr[i7 + 1] & 255) << 8) | ((bArr[i7 + 2] & 255) << 16) | (bArr[i7 + 3] << 24)) * (-862048943);
            int i12 = i9 ^ (((i11 << 15) | (i11 >>> 17)) * 461845907);
            i9 = (((i12 >>> 19) | (i12 << 13)) * 5) - 430675100;
            i7 += 4;
        }
        int i13 = i8 & 3;
        int i14 = 0;
        if (i13 == 1) {
            int i15 = ((bArr[i10] & 255) | i14) * (-862048943);
            i9 ^= ((i15 >>> 17) | (i15 << 15)) * 461845907;
        } else {
            if (i13 != 2) {
                i14 = i13 == 3 ? (bArr[i10 + 2] & 255) << 16 : 0;
            }
            i14 |= (bArr[i10 + 1] & 255) << 8;
            int i16 = ((bArr[i10] & 255) | i14) * (-862048943);
            i9 ^= ((i16 >>> 17) | (i16 << 15)) * 461845907;
        }
        int i17 = i9 ^ i8;
        int i18 = (i17 ^ (i17 >>> 16)) * (-2048144789);
        int i19 = (i18 ^ (i18 >>> 13)) * (-1028477387);
        return i19 ^ (i19 >>> 16);
    }
}
