package com.haier.library.a;

import java.nio.charset.Charset;
import kotlin.g2;

/* JADX INFO: loaded from: classes2.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f26245a = Charset.forName("UTF-8");

    private c() {
    }

    public static int a(int i7) {
        return ((i7 & 255) << 24) | (((-16777216) & i7) >>> 24) | ((16711680 & i7) >>> 8) | ((65280 & i7) << 8);
    }

    public static long b(long j7) {
        return ((j7 & 255) << 56) | (((-72057594037927936L) & j7) >>> 56) | ((71776119061217280L & j7) >>> 40) | ((280375465082880L & j7) >>> 24) | ((1095216660480L & j7) >>> 8) | ((4278190080L & j7) << 8) | ((16711680 & j7) << 24) | ((65280 & j7) << 40);
    }

    public static short c(short s7) {
        int i7 = s7 & g2.f34732d;
        return (short) (((i7 & 255) << 8) | ((65280 & i7) >>> 8));
    }

    public static void d(long j7, long j8, long j9) {
        if ((j8 | j9) < 0 || j8 > j7 || j7 - j8 < j9) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", Long.valueOf(j7), Long.valueOf(j8), Long.valueOf(j9)));
        }
    }

    public static void e(Throwable th) throws Throwable {
        g(th);
    }

    public static boolean f(byte[] bArr, int i7, byte[] bArr2, int i8, int i9) {
        for (int i10 = 0; i10 < i9; i10++) {
            if (bArr[i10 + i7] != bArr2[i10 + i8]) {
                return false;
            }
        }
        return true;
    }

    private static <T extends Throwable> void g(Throwable th) throws Throwable {
        throw th;
    }
}
