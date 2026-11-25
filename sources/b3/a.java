package b3;

import android.util.Base64;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f11286a = "DES";

    public static String a() {
        try {
            return b(y2.a.f40615z);
        } catch (Exception e8) {
            e8.printStackTrace();
            return "";
        }
    }

    public static String b(String str) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(com.haier.library.json.a.f26647d);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
        return Base64.encodeToString(c((y2.a.A + simpleDateFormat.parse(simpleDateFormat.format(new Date())).getTime()).getBytes(), str.getBytes()), 0);
    }

    private static byte[] c(byte[] bArr, byte[] bArr2) throws Exception {
        SecureRandom secureRandom = new SecureRandom();
        SecretKey secretKeyGenerateSecret = SecretKeyFactory.getInstance(f11286a).generateSecret(new DESKeySpec(bArr2));
        Cipher cipher = Cipher.getInstance(f11286a);
        cipher.init(1, secretKeyGenerateSecret, secureRandom);
        return cipher.doFinal(bArr);
    }
}
