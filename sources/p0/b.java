package p0;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static String a(String str) {
        try {
            if (o0.a.d(str)) {
                return null;
            }
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b8 : bArrDigest) {
                sb.append(String.format("%02x", Byte.valueOf(b8)));
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
