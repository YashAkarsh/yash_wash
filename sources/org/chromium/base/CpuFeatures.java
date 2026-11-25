package org.chromium.base;

/* JADX INFO: loaded from: classes3.dex */
@x6.c("base::android")
public abstract class CpuFeatures {
    public static int a() {
        return nativeGetCoreCount();
    }

    public static long b() {
        return nativeGetCpuFeatures();
    }

    private static native int nativeGetCoreCount();

    private static native long nativeGetCpuFeatures();
}
