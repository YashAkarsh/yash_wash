package com.airbnb.lottie;

import androidx.core.os.r0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f11761a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f11762b = "LOTTIE";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f11763c = 20;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f11764d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String[] f11765e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static long[] f11766f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f11767g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int f11768h;

    public static void a(String str) {
        if (f11764d) {
            int i7 = f11767g;
            if (i7 == 20) {
                f11768h++;
                return;
            }
            f11765e[i7] = str;
            f11766f[i7] = System.nanoTime();
            r0.b(str);
            f11767g++;
        }
    }

    public static float b(String str) {
        int i7 = f11768h;
        if (i7 > 0) {
            f11768h = i7 - 1;
            return 0.0f;
        }
        if (!f11764d) {
            return 0.0f;
        }
        int i8 = f11767g - 1;
        f11767g = i8;
        if (i8 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (str.equals(f11765e[i8])) {
            r0.d();
            return (System.nanoTime() - f11766f[f11767g]) / 1000000.0f;
        }
        throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f11765e[f11767g] + com.alibaba.android.arouter.utils.b.f12515h);
    }

    public static void c(boolean z7) {
        if (f11764d == z7) {
            return;
        }
        f11764d = z7;
        if (z7) {
            f11765e = new String[20];
            f11766f = new long[20];
        }
    }
}
