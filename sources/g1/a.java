package g1;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import c.m0;
import c.o0;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
@c1.a
@com.google.android.gms.common.internal.y
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile int f33978a = -1;

    @o0
    @c1.a
    @Deprecated
    public static byte[] a(@m0 Context context, @m0 String str) throws PackageManager.NameNotFoundException {
        MessageDigest messageDigestB;
        PackageInfo packageInfoF = com.google.android.gms.common.wrappers.d.a(context).f(str, 64);
        Signature[] signatureArr = packageInfoF.signatures;
        if (signatureArr == null || signatureArr.length != 1 || (messageDigestB = b("SHA1")) == null) {
            return null;
        }
        return messageDigestB.digest(packageInfoF.signatures[0].toByteArray());
    }

    @o0
    public static MessageDigest b(@m0 String str) {
        for (int i7 = 0; i7 < 2; i7++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                if (messageDigest != null) {
                    return messageDigest;
                }
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }
}
