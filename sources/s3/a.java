package s3;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f40322a = "AES";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f40323b = "AES/ECB/PKCS7Padding";

    public static byte[] a(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher cipher = Cipher.getInstance(f40323b);
        cipher.init(2, new SecretKeySpec(bArr2, f40322a));
        return cipher.doFinal(bArr);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher cipher = Cipher.getInstance(f40323b);
        cipher.init(1, new SecretKeySpec(bArr2, f40322a));
        return cipher.doFinal(bArr);
    }
}
