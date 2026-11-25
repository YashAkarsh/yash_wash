package com.google.zxing.datamatrix.encoder;

import com.facebook.internal.FacebookRequestErrorClassification;
import easypay.appinvoke.manager.Constants;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f23672c = 301;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f23670a = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[][] f23671b = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, 134, 240, 92, 254}, new int[]{28, 24, com.alibaba.fastjson.asm.j.Z, com.alibaba.fastjson.asm.j.O, 223, 248, 116, 255, Constants.LOG_ERROR_OTP, 61}, new int[]{175, 138, 205, 12, 194, 168, 39, 245, 60, 97, 120}, new int[]{41, 153, 158, 91, 61, 42, 142, 213, 97, com.alibaba.fastjson.asm.j.T, 100, 242}, new int[]{Constants.ACTION_DELAY_PASSWORD_FOUND, 97, com.alibaba.fastjson.asm.j.f12606c0, 252, 95, 9, Constants.ACTION_SAVE_CUST_ID, 119, 138, 45, 18, 186, 83, com.alibaba.fastjson.asm.j.Z}, new int[]{83, 195, 100, 39, com.alibaba.fastjson.asm.j.f12604b0, 75, 66, 61, 241, 213, 109, 129, 94, 254, 225, 48, 90, com.alibaba.fastjson.asm.j.f12604b0}, new int[]{15, 195, 244, 9, 233, 71, 168, 2, com.alibaba.fastjson.asm.j.f12604b0, 160, 153, 145, 253, 79, 108, 82, 27, 174, 186, 172}, new int[]{52, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 88, 205, 109, 39, com.alibaba.fastjson.asm.j.R, 21, Constants.ACTION_START_NB_OTP, 197, 251, 223, Constants.ACTION_START_NB_OTP, 21, 5, 172, 254, 124, 12, com.alibaba.fastjson.asm.j.V, com.alibaba.fastjson.asm.j.Y, 96, 50, com.alibaba.fastjson.asm.j.f12608d0}, new int[]{211, 231, 43, 97, 71, 96, Constants.ACTION_SUBMIT_BTN_USER_PWD_NB, 174, 37, 151, 170, 53, 75, 34, 249, Constants.OTP_VIEW_GONE, 17, 138, Constants.LOG_ERROR_OTP, 213, 141, 136, 120, 151, 233, 168, 93, 255}, new int[]{245, 127, 242, 218, 130, androidx.recyclerview.widget.m.f.f9644c, com.alibaba.fastjson.asm.j.L, com.alibaba.fastjson.asm.j.V, 102, 120, 84, 179, 220, 251, 80, com.alibaba.fastjson.asm.j.W, 229, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, 175, com.alibaba.fastjson.asm.j.Y, 59, 25, 225, 98, 81, 112}, new int[]{77, com.alibaba.fastjson.asm.j.f12608d0, 137, 31, 19, 38, 22, 153, 247, 105, 122, 2, 245, d4.d.f33486i, 242, 8, 175, 95, 100, 9, com.alibaba.fastjson.asm.j.P, 105, 214, 111, 57, Constants.OTP_VIEW_GONE, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, 150, com.alibaba.fastjson.asm.j.S, 226, 5, 9, 5}, new int[]{245, 132, 172, 223, 96, 32, 117, 22, 238, d4.d.f33486i, 238, 231, 205, com.alibaba.fastjson.asm.j.f12604b0, 237, 87, 191, Constants.ACTION_SUBMIT_CLICKED, 16, 147, 118, 23, 37, 90, 170, 205, 131, 88, 120, 100, 66, 138, 186, 240, 82, 44, com.alibaba.fastjson.asm.j.R, 87, com.alibaba.fastjson.asm.j.f12602a0, 147, 160, 175, 69, 213, 92, 253, 225, 19}, new int[]{175, 9, 223, 238, 12, 17, 220, 208, 100, 29, 175, 170, 230, com.alibaba.fastjson.asm.j.f12606c0, 215, 235, 150, 159, 36, 223, 38, 200, 132, 54, 228, 146, 218, 234, 117, 203, 29, 232, 144, 238, 22, 150, Constants.ACTION_READ_OTP_VIA_WEB, 117, 62, 207, Constants.ACTION_NB_REMOVE_LOADER, 13, 137, 245, 127, 67, 247, 28, Constants.ACTION_START_NB_OTP, 43, 203, Constants.OTP_FILLER_WEB_SUCCESS, 233, 53, 143, 46}, new int[]{242, 93, com.alibaba.fastjson.asm.j.Q, 50, 144, 210, 39, 118, 202, com.alibaba.fastjson.asm.j.f12604b0, Constants.ACTION_READ_OTP_VIA_WEB, 189, 143, 108, 196, 37, com.alibaba.fastjson.asm.j.Z, 112, 134, 230, 245, 63, 197, FacebookRequestErrorClassification.EC_INVALID_TOKEN, androidx.recyclerview.widget.m.f.f9644c, Constants.ACTION_SUBMIT_CLICKED, com.alibaba.fastjson.asm.j.Z, Constants.EASY_PAY_MINIMIZE_ASSIST, 175, 64, 114, 71, 161, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, 130, com.alibaba.fastjson.asm.j.f12604b0, 17, 163, 31, com.alibaba.fastjson.asm.j.R, 170, 4, Constants.OTP_FILLER_WEB_SUCCESS, 232, 7, 94, com.alibaba.fastjson.asm.j.O, 224, 124, 86, 47, 11, 204}, new int[]{220, 228, 173, 89, 251, com.alibaba.fastjson.asm.j.D, 159, 56, 89, 33, 147, 244, 154, 36, 73, 127, 213, 136, 248, 180, 234, 197, 158, com.alibaba.fastjson.asm.j.S, 68, 122, 93, 213, 15, 160, 227, 236, 66, 139, 153, com.alibaba.fastjson.asm.j.Z, 202, com.alibaba.fastjson.asm.j.P, 179, 25, 220, 232, 96, 210, 231, 136, 223, 239, com.alibaba.fastjson.asm.j.V, 241, 59, 52, 172, 25, 49, 232, 211, 189, 64, 54, 108, 153, 132, 63, 96, Constants.ACTION_SUBMIT_BTN_USER_PWD_NB, 82, 186}};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f23673d = new int[256];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f23674e = new int[255];

    static {
        int i7 = 1;
        for (int i8 = 0; i8 < 255; i8++) {
            f23674e[i8] = i7;
            f23673d[i7] = i8;
            i7 <<= 1;
            if (i7 >= 256) {
                i7 ^= 301;
            }
        }
    }

    private i() {
    }

    private static String a(CharSequence charSequence, int i7) {
        return b(charSequence, 0, charSequence.length(), i7);
    }

    private static String b(CharSequence charSequence, int i7, int i8, int i9) {
        int i10;
        int i11;
        int i12 = 0;
        while (true) {
            int[] iArr = f23670a;
            if (i12 >= iArr.length) {
                i12 = -1;
                break;
            }
            if (iArr[i12] == i9) {
                break;
            }
            i12++;
        }
        if (i12 < 0) {
            throw new IllegalArgumentException("Illegal number of error correction codewords specified: ".concat(String.valueOf(i9)));
        }
        int[] iArr2 = f23671b[i12];
        char[] cArr = new char[i9];
        for (int i13 = 0; i13 < i9; i13++) {
            cArr[i13] = 0;
        }
        for (int i14 = i7; i14 < i7 + i8; i14++) {
            int i15 = i9 - 1;
            int iCharAt = cArr[i15] ^ charSequence.charAt(i14);
            while (i15 > 0) {
                if (iCharAt == 0 || (i11 = iArr2[i15]) == 0) {
                    cArr[i15] = cArr[i15 - 1];
                } else {
                    char c8 = cArr[i15 - 1];
                    int[] iArr3 = f23674e;
                    int[] iArr4 = f23673d;
                    cArr[i15] = (char) (iArr3[(iArr4[iCharAt] + iArr4[i11]) % 255] ^ c8);
                }
                i15--;
            }
            if (iCharAt == 0 || (i10 = iArr2[0]) == 0) {
                cArr[0] = 0;
            } else {
                int[] iArr5 = f23674e;
                int[] iArr6 = f23673d;
                cArr[0] = (char) iArr5[(iArr6[iCharAt] + iArr6[i10]) % 255];
            }
        }
        char[] cArr2 = new char[i9];
        for (int i16 = 0; i16 < i9; i16++) {
            cArr2[i16] = cArr[(i9 - i16) - 1];
        }
        return String.valueOf(cArr2);
    }

    public static String c(String str, k kVar) {
        if (str.length() != kVar.b()) {
            throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
        }
        StringBuilder sb = new StringBuilder(kVar.b() + kVar.d());
        sb.append(str);
        int iG = kVar.g();
        if (iG == 1) {
            sb.append(a(str, kVar.d()));
        } else {
            sb.setLength(sb.capacity());
            int[] iArr = new int[iG];
            int[] iArr2 = new int[iG];
            int[] iArr3 = new int[iG];
            int i7 = 0;
            while (i7 < iG) {
                int i8 = i7 + 1;
                iArr[i7] = kVar.c(i8);
                iArr2[i7] = kVar.e(i8);
                iArr3[i7] = 0;
                if (i7 > 0) {
                    iArr3[i7] = iArr3[i7 - 1] + iArr[i7];
                }
                i7 = i8;
            }
            for (int i9 = 0; i9 < iG; i9++) {
                StringBuilder sb2 = new StringBuilder(iArr[i9]);
                for (int i10 = i9; i10 < kVar.b(); i10 += iG) {
                    sb2.append(str.charAt(i10));
                }
                String strA = a(sb2.toString(), iArr2[i9]);
                int i11 = i9;
                int i12 = 0;
                while (i11 < iArr2[i9] * iG) {
                    sb.setCharAt(kVar.b() + i11, strA.charAt(i12));
                    i11 += iG;
                    i12++;
                }
            }
        }
        return sb.toString();
    }
}
