package com.google.common.primitives;

import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte f22372a = 64;

    private enum a implements Comparator<byte[]> {
        INSTANCE;

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            int iMin = Math.min(bArr.length, bArr2.length);
            for (int i7 = 0; i7 < iMin; i7++) {
                int iB = h0.b(bArr[i7], bArr2[i7]);
                if (iB != 0) {
                    return iB;
                }
            }
            return bArr.length - bArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "SignedBytes.lexicographicalComparator()";
        }
    }

    private h0() {
    }

    public static byte a(long j7) {
        byte b8 = (byte) j7;
        com.google.common.base.e0.p(((long) b8) == j7, "Out of range: %s", j7);
        return b8;
    }

    public static int b(byte b8, byte b9) {
        return b8 - b9;
    }

    public static String c(String str, byte... bArr) {
        com.google.common.base.e0.E(str);
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 5);
        sb.append((int) bArr[0]);
        for (int i7 = 1; i7 < bArr.length; i7++) {
            sb.append(str);
            sb.append((int) bArr[i7]);
        }
        return sb.toString();
    }

    public static Comparator<byte[]> d() {
        return a.INSTANCE;
    }

    public static byte e(byte... bArr) {
        com.google.common.base.e0.d(bArr.length > 0);
        byte b8 = bArr[0];
        for (int i7 = 1; i7 < bArr.length; i7++) {
            byte b9 = bArr[i7];
            if (b9 > b8) {
                b8 = b9;
            }
        }
        return b8;
    }

    public static byte f(byte... bArr) {
        com.google.common.base.e0.d(bArr.length > 0);
        byte b8 = bArr[0];
        for (int i7 = 1; i7 < bArr.length; i7++) {
            byte b9 = bArr[i7];
            if (b9 < b8) {
                b8 = b9;
            }
        }
        return b8;
    }

    public static byte g(long j7) {
        if (j7 > 127) {
            return (byte) 127;
        }
        if (j7 < -128) {
            return (byte) -128;
        }
        return (byte) j7;
    }

    public static void h(byte[] bArr) {
        com.google.common.base.e0.E(bArr);
        i(bArr, 0, bArr.length);
    }

    public static void i(byte[] bArr, int i7, int i8) {
        com.google.common.base.e0.E(bArr);
        com.google.common.base.e0.f0(i7, i8, bArr.length);
        Arrays.sort(bArr, i7, i8);
        b.n(bArr, i7, i8);
    }
}
