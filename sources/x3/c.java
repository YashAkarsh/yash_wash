package x3;

import com.nostra13.universalimageloader.utils.d;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes2.dex */
public class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f40573a = "MD5";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f40574b = 36;

    private byte[] b(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e8) {
            d.d(e8);
            return null;
        }
    }

    @Override // x3.a
    public String a(String str) {
        return new BigInteger(b(str.getBytes())).abs().toString(36);
    }
}
