package com.haier.uhome.usdk.base.api;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f31116a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f31117b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f31118c = 4;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f31119d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f31120e = 16;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f31121f = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f31122g = 10;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f31123h = -2;

    public static boolean a(int i7) {
        return 8 == i7;
    }

    public static boolean b(int i7) {
        return (i7 & 8) != 0;
    }

    public static boolean c(int i7) {
        return 10 == i7;
    }

    public static boolean d(int i7) {
        return (i7 & 8) != 0 && (i7 & 2) == 0;
    }

    public static boolean e(int i7) {
        return a(i7, 4) && !a(i7, 1);
    }

    public static boolean f(int i7) {
        return a(i7, 8) || a(i7, 10);
    }

    public static boolean a(int i7, int i8) {
        return (i7 & i8) != 0;
    }
}
