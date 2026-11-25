package org.chromium.base;

import c.f1;
import org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes3.dex */
@x6.c("base::android")
@x6.e
public class JavaExceptionReporter implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final /* synthetic */ boolean f38678d = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f38679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f38680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f38681c;

    private JavaExceptionReporter(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, boolean z7) {
        this.f38679a = uncaughtExceptionHandler;
        this.f38680b = z7;
    }

    @f1
    public static void a(String str) {
        nativeReportJavaStackTrace(PiiElider.sanitizeStacktrace(str));
    }

    @CalledByNative
    private static void installHandler(boolean z7) {
        Thread.setDefaultUncaughtExceptionHandler(new JavaExceptionReporter(Thread.getDefaultUncaughtExceptionHandler(), z7));
    }

    private static native void nativeReportJavaException(boolean z7, Throwable th);

    private static native void nativeReportJavaStackTrace(String str);

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (!this.f38681c) {
            this.f38681c = true;
            nativeReportJavaException(this.f38680b, th);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f38679a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
