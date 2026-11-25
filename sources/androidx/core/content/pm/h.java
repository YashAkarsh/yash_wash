package androidx.core.content.pm;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    @c.t0(28)
    private static class a {
        private a() {
        }

        @c.o0
        @c.t
        static Signature[] a(@c.m0 SigningInfo signingInfo) {
            return signingInfo.getApkContentsSigners();
        }

        @c.t
        static long b(PackageInfo packageInfo) {
            return packageInfo.getLongVersionCode();
        }

        @c.o0
        @c.t
        static Signature[] c(@c.m0 SigningInfo signingInfo) {
            return signingInfo.getSigningCertificateHistory();
        }

        @c.t
        static boolean d(@c.m0 SigningInfo signingInfo) {
            return signingInfo.hasMultipleSigners();
        }

        @c.t
        static boolean e(@c.m0 PackageManager packageManager, @c.m0 String str, @c.m0 byte[] bArr, int i7) {
            return packageManager.hasSigningCertificate(str, bArr, i7);
        }
    }

    private h() {
    }

    private static boolean a(@c.m0 byte[][] bArr, @c.m0 byte[] bArr2) {
        for (byte[] bArr3 : bArr) {
            if (Arrays.equals(bArr2, bArr3)) {
                return true;
            }
        }
        return false;
    }

    private static byte[] b(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA256").digest(bArr);
        } catch (NoSuchAlgorithmException e8) {
            throw new RuntimeException("Device doesn't support SHA256 cert checking", e8);
        }
    }

    public static long c(@c.m0 PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? a.b(packageInfo) : packageInfo.versionCode;
    }

    @c.m0
    public static List<Signature> d(@c.m0 PackageManager packageManager, @c.m0 String str) throws PackageManager.NameNotFoundException {
        Signature[] signatureArrA;
        if (Build.VERSION.SDK_INT >= 28) {
            SigningInfo signingInfo = packageManager.getPackageInfo(str, 134217728).signingInfo;
            signatureArrA = a.d(signingInfo) ? a.a(signingInfo) : a.c(signingInfo);
        } else {
            signatureArrA = packageManager.getPackageInfo(str, 64).signatures;
        }
        return signatureArrA == null ? Collections.emptyList() : Arrays.asList(signatureArrA);
    }

    public static boolean e(@c.m0 PackageManager packageManager, @c.m0 String str, @c.m0 @c.y0(min = 1) Map<byte[], Integer> map, boolean z7) throws PackageManager.NameNotFoundException {
        byte[][] bArr;
        if (map.isEmpty()) {
            return false;
        }
        Set<byte[]> setKeySet = map.keySet();
        for (byte[] bArr2 : setKeySet) {
            if (bArr2 == null) {
                throw new IllegalArgumentException("Cert byte array cannot be null when verifying " + str);
            }
            Integer num = map.get(bArr2);
            if (num == null) {
                throw new IllegalArgumentException("Type must be specified for cert when verifying " + str);
            }
            int iIntValue = num.intValue();
            if (iIntValue != 0 && iIntValue != 1) {
                throw new IllegalArgumentException("Unsupported certificate type " + num + " when verifying " + str);
            }
        }
        List<Signature> listD = d(packageManager, str);
        if (!z7 && Build.VERSION.SDK_INT >= 28) {
            for (byte[] bArr3 : setKeySet) {
                if (!a.e(packageManager, str, bArr3, map.get(bArr3).intValue())) {
                    return false;
                }
            }
            return true;
        }
        if (listD.size() != 0 && map.size() <= listD.size() && (!z7 || map.size() == listD.size())) {
            if (map.containsValue(1)) {
                bArr = new byte[listD.size()][];
                for (int i7 = 0; i7 < listD.size(); i7++) {
                    bArr[i7] = b(listD.get(i7).toByteArray());
                }
            } else {
                bArr = null;
            }
            Iterator<byte[]> it = setKeySet.iterator();
            if (it.hasNext()) {
                byte[] next = it.next();
                Integer num2 = map.get(next);
                int iIntValue2 = num2.intValue();
                if (iIntValue2 != 0) {
                    if (iIntValue2 != 1) {
                        throw new IllegalArgumentException("Unsupported certificate type " + num2);
                    }
                    if (!a(bArr, next)) {
                        return false;
                    }
                } else if (!listD.contains(new Signature(next))) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}
