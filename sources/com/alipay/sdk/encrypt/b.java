package com.alipay.sdk.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static String a(int i7, String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "DES");
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(i7, secretKeySpec);
            byte[] bArrDoFinal = cipher.doFinal(i7 == 2 ? a.d(str) : str.getBytes("UTF-8"));
            return i7 == 2 ? new String(bArrDoFinal) : a.b(bArrDoFinal);
        } catch (Exception e8) {
            com.alipay.sdk.util.d.d(e8);
            return null;
        }
    }

    public static String b(String str, String str2) {
        return a(1, str, str2);
    }

    public static String c(String str, String str2) {
        return a(2, str, str2);
    }
}
