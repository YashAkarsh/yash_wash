package g1;

import android.util.Base64;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public final class c {
    @c1.a
    @m0
    public static byte[] a(@m0 String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    @c1.a
    @m0
    public static byte[] b(@m0 String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 10);
    }

    @c1.a
    @m0
    public static byte[] c(@m0 String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 11);
    }

    @c1.a
    @m0
    public static String d(@m0 byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 0);
    }

    @c1.a
    @m0
    public static String e(@m0 byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 10);
    }

    @c1.a
    @m0
    public static String f(@m0 byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 11);
    }
}
