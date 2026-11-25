package org.chromium.base;

/* JADX INFO: loaded from: classes3.dex */
@x6.e
public class FieldTrialList {
    private FieldTrialList() {
    }

    public static String a(String str) {
        return nativeFindFullName(str);
    }

    public static String b(String str, String str2) {
        return nativeGetVariationParameter(str, str2);
    }

    public static void c() {
        nativeLogActiveTrials();
    }

    public static boolean d(String str) {
        return nativeTrialExists(str);
    }

    private static native String nativeFindFullName(String str);

    private static native String nativeGetVariationParameter(String str, String str2);

    private static native void nativeLogActiveTrials();

    private static native boolean nativeTrialExists(String str);
}
