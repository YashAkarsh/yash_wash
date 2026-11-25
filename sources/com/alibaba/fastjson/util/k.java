package com.alibaba.fastjson.util;

import java.lang.ref.SoftReference;
import java.nio.charset.CharsetDecoder;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f13362a = 1024;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f13363b = 10;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f13364c = 131072;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f13365d = 17;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f13368g = 1024;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f13369h = 10;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f13370i = 131072;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f13371j = 17;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final /* synthetic */ boolean f13373l = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ThreadLocal<SoftReference<char[]>> f13366e = new ThreadLocal<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ThreadLocal<CharsetDecoder> f13367f = new ThreadLocal<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final ThreadLocal<SoftReference<byte[]>> f13372k = new ThreadLocal<>();

    private static char[] a(int i7) {
        if (i7 > 131072) {
            return new char[i7];
        }
        char[] cArr = new char[e(10, 17, i7)];
        f13366e.set(new SoftReference<>(cArr));
        return cArr;
    }

    private static byte[] b(int i7) {
        if (i7 > 131072) {
            return new byte[i7];
        }
        byte[] bArr = new byte[e(10, 17, i7)];
        f13372k.set(new SoftReference<>(bArr));
        return bArr;
    }

    public static void c() {
        f13372k.set(null);
    }

    public static void d() {
        f13366e.set(null);
    }

    private static int e(int i7, int i8, int i9) {
        return (i9 >>> i7) <= 0 ? 1 << i7 : 1 << (32 - Integer.numberOfLeadingZeros(i9 - 1));
    }

    public static byte[] f(int i7) {
        SoftReference<byte[]> softReference = f13372k.get();
        if (softReference == null) {
            return b(i7);
        }
        byte[] bArr = softReference.get();
        if (bArr == null) {
            return b(i7);
        }
        return bArr.length < i7 ? b(i7) : bArr;
    }

    public static char[] g(int i7) {
        SoftReference<char[]> softReference = f13366e.get();
        if (softReference == null) {
            return a(i7);
        }
        char[] cArr = softReference.get();
        if (cArr == null) {
            return a(i7);
        }
        return cArr.length < i7 ? a(i7) : cArr;
    }

    public static CharsetDecoder h() {
        ThreadLocal<CharsetDecoder> threadLocal = f13367f;
        CharsetDecoder charsetDecoder = threadLocal.get();
        if (charsetDecoder != null) {
            return charsetDecoder;
        }
        m mVar = new m();
        threadLocal.set(mVar);
        return mVar;
    }
}
