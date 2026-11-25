package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Looper;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f14933a = "0123456789abcdef".toCharArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f14934b = new char[64];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char[] f14935c = new char[40];

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f14936a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f14936a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14936a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14936a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14936a[Bitmap.Config.ARGB_8888.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private i() {
    }

    public static void a() {
        if (!j()) {
            throw new IllegalArgumentException("YOu must call this method on a background thread");
        }
    }

    public static void b() {
        if (!k()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    private static String c(byte[] bArr, char[] cArr) {
        for (int i7 = 0; i7 < bArr.length; i7++) {
            int i8 = bArr[i7] & 255;
            int i9 = i7 * 2;
            char[] cArr2 = f14933a;
            cArr[i9] = cArr2[i8 >>> 4];
            cArr[i9 + 1] = cArr2[i8 & 15];
        }
        return new String(cArr);
    }

    public static <T> Queue<T> d(int i7) {
        return new ArrayDeque(i7);
    }

    public static int e(int i7, int i8, Bitmap.Config config) {
        return i7 * i8 * g(config);
    }

    @TargetApi(19)
    public static int f(Bitmap bitmap) {
        try {
            return bitmap.getAllocationByteCount();
        } catch (NullPointerException unused) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }
    }

    private static int g(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i7 = a.f14936a[config.ordinal()];
        if (i7 != 1) {
            return (i7 == 2 || i7 == 3) ? 2 : 4;
        }
        return 1;
    }

    @Deprecated
    public static int h(Bitmap bitmap) {
        return f(bitmap);
    }

    public static <T> List<T> i(Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static boolean j() {
        return !k();
    }

    public static boolean k() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private static boolean l(int i7) {
        return i7 > 0 || i7 == Integer.MIN_VALUE;
    }

    public static boolean m(int i7, int i8) {
        return l(i7) && l(i8);
    }

    public static String n(byte[] bArr) {
        String strC;
        char[] cArr = f14935c;
        synchronized (cArr) {
            strC = c(bArr, cArr);
        }
        return strC;
    }

    public static String o(byte[] bArr) {
        String strC;
        char[] cArr = f14934b;
        synchronized (cArr) {
            strC = c(bArr, cArr);
        }
        return strC;
    }
}
