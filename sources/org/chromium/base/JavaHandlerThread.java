package org.chromium.base;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes3.dex */
@x6.c("base::android")
@x6.e
public class JavaHandlerThread {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final /* synthetic */ boolean f38682c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HandlerThread f38683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Throwable f38684b;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f38685a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f38686b;

        a(long j7, long j8) {
            this.f38685a = j7;
            this.f38686b = j8;
        }

        @Override // java.lang.Runnable
        public void run() {
            JavaHandlerThread.this.nativeInitializeThread(this.f38685a, this.f38686b);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f38688a;

        b(long j7) {
            this.f38688a = j7;
        }

        @Override // java.lang.Runnable
        public void run() {
            JavaHandlerThread.this.f38683a.quit();
            JavaHandlerThread.this.nativeOnLooperStopped(this.f38688a);
        }
    }

    class c implements Thread.UncaughtExceptionHandler {
        c() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            JavaHandlerThread.this.f38684b = th;
        }
    }

    public JavaHandlerThread(String str, int i7) {
        this.f38683a = new HandlerThread(str, i7);
    }

    @CalledByNative
    private static JavaHandlerThread create(String str, int i7) {
        return new JavaHandlerThread(str, i7);
    }

    private boolean f() {
        return this.f38683a.getState() != Thread.State.NEW;
    }

    @CalledByNative
    private Throwable getUncaughtExceptionIfAny() {
        return this.f38684b;
    }

    @CalledByNative
    private boolean isAlive() {
        return this.f38683a.isAlive();
    }

    @CalledByNative
    private void joinThread() {
        boolean z7 = false;
        while (!z7) {
            try {
                this.f38683a.join();
                z7 = true;
            } catch (InterruptedException unused) {
            }
        }
    }

    @CalledByNative
    private void listenForUncaughtExceptionsForTesting() {
        this.f38683a.setUncaughtExceptionHandler(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeInitializeThread(long j7, long j8);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnLooperStopped(long j7);

    @CalledByNative
    private void quitThreadSafely(long j7) {
        new Handler(this.f38683a.getLooper()).post(new b(j7));
        this.f38683a.getLooper().quitSafely();
    }

    @CalledByNative
    private void startAndInitialize(long j7, long j8) {
        g();
        new Handler(this.f38683a.getLooper()).post(new a(j7, j8));
    }

    public Looper e() {
        return this.f38683a.getLooper();
    }

    public void g() {
        if (f()) {
            return;
        }
        this.f38683a.start();
    }
}
