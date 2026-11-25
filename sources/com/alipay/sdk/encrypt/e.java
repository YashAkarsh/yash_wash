package com.alipay.sdk.encrypt;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f13715a = "RSA";

    /* JADX WARN: Code duplicated, block: B:35:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0052: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:83), block:B:28:0x0052 */
    public static byte[] a(String str, String str2) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        byte[] byteArray = null;
        byteArray = null;
        byteArray = null;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            try {
                try {
                    PublicKey publicKeyB = b(f13715a, str2);
                    Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                    cipher.init(1, publicKeyB);
                    byte[] bytes = str.getBytes("UTF-8");
                    int blockSize = cipher.getBlockSize();
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    for (int i7 = 0; i7 < bytes.length; i7 += blockSize) {
                        try {
                            byteArrayOutputStream.write(cipher.doFinal(bytes, i7, bytes.length - i7 < blockSize ? bytes.length - i7 : blockSize));
                        } catch (Exception e8) {
                            e = e8;
                            com.alipay.sdk.util.d.d(e);
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return byteArray;
                        }
                    }
                    byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream3 = byteArrayOutputStream2;
                    if (byteArrayOutputStream3 != null) {
                        try {
                            byteArrayOutputStream3.close();
                        } catch (IOException e9) {
                            com.alipay.sdk.util.d.d(e9);
                        }
                    }
                    throw th;
                }
            } catch (Exception e10) {
                e = e10;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (byteArrayOutputStream3 != null) {
                    byteArrayOutputStream3.close();
                }
                throw th;
            }
        } catch (IOException e11) {
            com.alipay.sdk.util.d.d(e11);
        }
        return byteArray;
    }

    private static PublicKey b(String str, String str2) throws Exception {
        return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(a.d(str2)));
    }
}
