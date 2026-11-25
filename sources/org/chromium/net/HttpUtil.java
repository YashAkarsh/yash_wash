package org.chromium.net;

/* JADX INFO: loaded from: classes3.dex */
@x6.c("net")
public final class HttpUtil {
    public static boolean a(String str, String str2) {
        return nativeIsAllowedHeader(str, str2);
    }

    private static native boolean nativeIsAllowedHeader(String str, String str2);
}
