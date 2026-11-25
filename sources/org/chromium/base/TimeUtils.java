package org.chromium.base;

/* JADX INFO: loaded from: classes3.dex */
@x6.c("base::android")
@x6.e
public class TimeUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38735a = 1000000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f38736b = 60;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f38737c = 3600;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f38738d = 86400;

    private TimeUtils() {
    }

    public static native long nativeGetTimeTicksNowUs();
}
