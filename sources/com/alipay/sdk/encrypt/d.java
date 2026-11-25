package com.alipay.sdk.encrypt;

import android.text.TextUtils;
import java.security.SecureRandom;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes.dex */
class d {
    d() {
    }

    static byte[] a(Cipher cipher, String str) {
        SecureRandom secureRandom = new SecureRandom();
        int blockSize = cipher.getBlockSize();
        if (TextUtils.isEmpty(str)) {
            str = String.valueOf(secureRandom.nextDouble());
        }
        int i7 = blockSize * 2;
        byte[] bArr = new byte[i7];
        byte[] bArr2 = new byte[blockSize];
        secureRandom.nextBytes(bArr2);
        for (int i8 = 1; i8 < i7; i8++) {
            byte bCodePointAt = (byte) (str.codePointAt(i8 % str.length()) & 127);
            bArr[i8] = bCodePointAt;
            if (i8 >= blockSize) {
                bArr[i8] = (byte) (bArr[0] & bCodePointAt);
            }
        }
        System.arraycopy(bArr, blockSize, bArr2, 0, blockSize);
        return bArr2;
    }
}
