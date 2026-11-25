package okio;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
@h5.h(name = "-Base64")
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private static final byte[] f38419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private static final byte[] f38420b;

    static {
        p.a aVar = p.f38508f;
        f38419a = aVar.l("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").o();
        f38420b = aVar.l("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").o();
    }

    @a7.e
    public static final byte[] a(@a7.d String decodeBase64ToArray) {
        int i7;
        char cCharAt;
        kotlin.jvm.internal.l0.p(decodeBase64ToArray, "$this$decodeBase64ToArray");
        int length = decodeBase64ToArray.length();
        while (length > 0 && ((cCharAt = decodeBase64ToArray.charAt(length - 1)) == '=' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == ' ' || cCharAt == '\t')) {
            length--;
        }
        int i8 = (int) ((((long) length) * 6) / 8);
        byte[] bArr = new byte[i8];
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            char cCharAt2 = decodeBase64ToArray.charAt(i12);
            if ('A' <= cCharAt2 && 'Z' >= cCharAt2) {
                i7 = cCharAt2 - 'A';
            } else if ('a' <= cCharAt2 && 'z' >= cCharAt2) {
                i7 = cCharAt2 - 'G';
            } else if ('0' <= cCharAt2 && '9' >= cCharAt2) {
                i7 = cCharAt2 + 4;
            } else if (cCharAt2 == '+' || cCharAt2 == '-') {
                i7 = 62;
            } else {
                if (cCharAt2 == '/' || cCharAt2 == '_') {
                    i7 = 63;
                } else if (cCharAt2 != '\n' && cCharAt2 != '\r' && cCharAt2 != ' ' && cCharAt2 != '\t') {
                    return null;
                }
            }
            i10 = (i10 << 6) | i7;
            i9++;
            if (i9 % 4 == 0) {
                int i13 = i11 + 1;
                bArr[i11] = (byte) (i10 >> 16);
                int i14 = i13 + 1;
                bArr[i13] = (byte) (i10 >> 8);
                bArr[i14] = (byte) i10;
                i11 = i14 + 1;
            }
        }
        int i15 = i9 % 4;
        if (i15 == 1) {
            return null;
        }
        if (i15 == 2) {
            bArr[i11] = (byte) ((i10 << 12) >> 16);
            i11++;
        } else if (i15 == 3) {
            int i16 = i10 << 6;
            int i17 = i11 + 1;
            bArr[i11] = (byte) (i16 >> 16);
            i11 = i17 + 1;
            bArr[i17] = (byte) (i16 >> 8);
        }
        if (i11 == i8) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i11);
        kotlin.jvm.internal.l0.o(bArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        return bArrCopyOf;
    }

    @a7.d
    public static final String b(@a7.d byte[] encodeBase64, @a7.d byte[] map) {
        kotlin.jvm.internal.l0.p(encodeBase64, "$this$encodeBase64");
        kotlin.jvm.internal.l0.p(map, "map");
        byte[] bArr = new byte[((encodeBase64.length + 2) / 3) * 4];
        int length = encodeBase64.length - (encodeBase64.length % 3);
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            int i9 = i7 + 1;
            byte b8 = encodeBase64[i7];
            int i10 = i9 + 1;
            byte b9 = encodeBase64[i9];
            int i11 = i10 + 1;
            byte b10 = encodeBase64[i10];
            int i12 = i8 + 1;
            bArr[i8] = map[(b8 & 255) >> 2];
            int i13 = i12 + 1;
            bArr[i12] = map[((b8 & 3) << 4) | ((b9 & 255) >> 4)];
            int i14 = i13 + 1;
            bArr[i13] = map[((b9 & com.google.common.base.c.f19317q) << 2) | ((b10 & 255) >> 6)];
            i8 = i14 + 1;
            bArr[i14] = map[b10 & r0.f38528a];
            i7 = i11;
        }
        int length2 = encodeBase64.length - length;
        if (length2 == 1) {
            byte b11 = encodeBase64[i7];
            int i15 = i8 + 1;
            bArr[i8] = map[(b11 & 255) >> 2];
            int i16 = i15 + 1;
            bArr[i15] = map[(b11 & 3) << 4];
            byte b12 = (byte) 61;
            bArr[i16] = b12;
            bArr[i16 + 1] = b12;
        } else if (length2 == 2) {
            int i17 = i7 + 1;
            byte b13 = encodeBase64[i7];
            byte b14 = encodeBase64[i17];
            int i18 = i8 + 1;
            bArr[i8] = map[(b13 & 255) >> 2];
            int i19 = i18 + 1;
            bArr[i18] = map[((b13 & 3) << 4) | ((b14 & 255) >> 4)];
            bArr[i19] = map[(b14 & com.google.common.base.c.f19317q) << 2];
            bArr[i19 + 1] = (byte) 61;
        }
        return i.c(bArr);
    }

    public static /* synthetic */ String c(byte[] bArr, byte[] bArr2, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            bArr2 = f38419a;
        }
        return b(bArr, bArr2);
    }

    @a7.d
    public static final byte[] d() {
        return f38419a;
    }

    @a7.d
    public static final byte[] e() {
        return f38420b;
    }
}
