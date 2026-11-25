package org.chromium.base;

/* JADX INFO: loaded from: classes3.dex */
@x6.c("base::android")
public abstract class PathService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38696a = 3;

    private PathService() {
    }

    public static void a(int i7, String str) {
        nativeOverride(i7, str);
    }

    private static native void nativeOverride(int i7, String str);
}
