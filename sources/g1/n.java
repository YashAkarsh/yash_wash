package g1;

import c.m0;

/* JADX INFO: loaded from: classes.dex */
@c1.a
@com.google.android.gms.common.internal.y
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f34014a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f34015b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    @c1.a
    @m0
    public static String a(@m0 byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length + length];
        int i7 = 0;
        for (byte b8 : bArr) {
            int i8 = b8 & 255;
            int i9 = i7 + 1;
            char[] cArr2 = f34015b;
            cArr[i7] = cArr2[i8 >>> 4];
            i7 = i9 + 1;
            cArr[i9] = cArr2[i8 & 15];
        }
        return new String(cArr);
    }

    @c1.a
    @m0
    public static String b(@m0 byte[] bArr) {
        return c(bArr, false);
    }

    @c1.a
    @m0
    public static String c(@m0 byte[] bArr, boolean z7) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length + length);
        for (int i7 = 0; i7 < length && (!z7 || i7 != length - 1 || (bArr[i7] & 255) != 0); i7++) {
            char[] cArr = f34014a;
            sb.append(cArr[(bArr[i7] & 240) >>> 4]);
            sb.append(cArr[bArr[i7] & com.google.common.base.c.f19317q]);
        }
        return sb.toString();
    }

    @c1.a
    @m0
    public static byte[] d(@m0 String str) throws IllegalArgumentException {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("Hex string has odd number of characters");
        }
        byte[] bArr = new byte[length / 2];
        int i7 = 0;
        while (i7 < length) {
            int i8 = i7 + 2;
            bArr[i7 / 2] = (byte) Integer.parseInt(str.substring(i7, i8), 16);
            i7 = i8;
        }
        return bArr;
    }
}
