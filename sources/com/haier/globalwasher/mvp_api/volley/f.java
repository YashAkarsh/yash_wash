package com.haier.globalwasher.mvp_api.volley;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes2.dex */
class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f24835a = "0123456789ABCDEF".toCharArray();

    f() {
    }

    private static String a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i7 = 0; i7 < bArr.length; i7++) {
            int i8 = bArr[i7] & 255;
            int i9 = i7 * 2;
            char[] cArr2 = f24835a;
            cArr[i9] = cArr2[i8 >>> 4];
            cArr[i9 + 1] = cArr2[i8 & 15];
        }
        return new String(cArr);
    }

    public static String b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] bytes = str.getBytes("UTF-8");
            messageDigest.update(bytes, 0, bytes.length);
            return a(messageDigest.digest());
        } catch (UnsupportedEncodingException e8) {
            e8.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e9) {
            e9.printStackTrace();
            return null;
        }
    }
}
