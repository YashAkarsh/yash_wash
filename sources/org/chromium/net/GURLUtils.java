package org.chromium.net;

/* JADX INFO: loaded from: classes3.dex */
@x6.c("net")
public final class GURLUtils {
    public static String a(String str) {
        return nativeGetOrigin(str);
    }

    public static String b(String str) {
        return nativeGetScheme(str);
    }

    private static native String nativeGetOrigin(String str);

    private static native String nativeGetScheme(String str);
}
