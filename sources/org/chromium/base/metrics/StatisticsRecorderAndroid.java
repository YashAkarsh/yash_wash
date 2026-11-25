package org.chromium.base.metrics;

import x6.c;

/* JADX INFO: loaded from: classes3.dex */
@c("base::android")
public final class StatisticsRecorderAndroid {
    private StatisticsRecorderAndroid() {
    }

    public static String a(int i7) {
        return nativeToJson(i7);
    }

    private static native String nativeToJson(int i7);
}
