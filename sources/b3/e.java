package b3;

import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.apache.commons.codec.binary.Base64;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f11288a = "RSA";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f11289b = "SHA1withRSA";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f11290c = 117;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f11291d = 128;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f11292e = "SHA";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f11293f = "MD5";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f11294g = "RSA/ECB/PKCS1Padding";

    public static byte[] a(byte[] bArr, byte[] bArr2) throws Exception {
        PrivateKey privateKeyGeneratePrivate = KeyFactory.getInstance(f11288a).generatePrivate(new PKCS8EncodedKeySpec(Base64.decodeBase64(bArr)));
        Cipher cipher = Cipher.getInstance(f11294g);
        cipher.init(2, privateKeyGeneratePrivate);
        int length = bArr2.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int i9 = length - i7;
            if (i9 <= 0) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
            byte[] bArrDoFinal = i9 > 128 ? cipher.doFinal(bArr2, i7, 128) : cipher.doFinal(bArr2, i7, i9);
            byteArrayOutputStream.write(bArrDoFinal, 0, bArrDoFinal.length);
            i8++;
            i7 = i8 * 128;
        }
    }

    public static byte[] b(String str, byte[] bArr) throws Exception {
        byte[] bArrDecodeBase64 = Base64.decodeBase64(str.getBytes());
        Cipher cipher = Cipher.getInstance(f11294g);
        cipher.init(1, KeyFactory.getInstance(f11288a).generatePublic(new X509EncodedKeySpec(bArrDecodeBase64)));
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int i9 = length - i7;
            if (i9 <= 0) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
            byte[] bArrDoFinal = i9 > f11290c ? cipher.doFinal(bArr, i7, f11290c) : cipher.doFinal(bArr, i7, i9);
            byteArrayOutputStream.write(bArrDoFinal, 0, bArrDoFinal.length);
            i8++;
            i7 = i8 * f11290c;
        }
    }

    public static byte[] c(byte[] bArr) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(bArr);
        return messageDigest.digest();
    }

    public static byte[] d(String str, byte[] bArr) throws Exception {
        PrivateKey privateKeyGeneratePrivate = KeyFactory.getInstance(f11288a).generatePrivate(new PKCS8EncodedKeySpec(Base64.decodeBase64(str.getBytes())));
        Signature signature = Signature.getInstance(f11289b);
        signature.initSign(privateKeyGeneratePrivate);
        signature.update(bArr);
        return signature.sign();
    }

    public static boolean e(String str, byte[] bArr, byte[] bArr2) throws Exception {
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(f11288a).generatePublic(new X509EncodedKeySpec(Base64.decodeBase64(str.getBytes())));
        Signature signature = Signature.getInstance(f11289b);
        signature.initVerify(publicKeyGeneratePublic);
        signature.update(bArr);
        return signature.verify(bArr2);
    }
}
