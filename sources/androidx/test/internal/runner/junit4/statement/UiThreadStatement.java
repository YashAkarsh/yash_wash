package androidx.test.internal.runner.junit4.statement;

import android.os.Looper;
import android.util.Log;
import androidx.test.platform.app.InstrumentationRegistry;
import java.lang.annotation.Annotation;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.runners.model.d;
import org.junit.runners.model.j;

/* JADX INFO: loaded from: classes.dex */
public class UiThreadStatement extends j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f10152c = "UiThreadStatement";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f10153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f10154b;

    public UiThreadStatement(j base, boolean runOnUiThread) {
        this.f10153a = base;
        this.f10154b = runOnUiThread;
    }

    private static boolean c(d method, Class<? extends Annotation> annotationClass) {
        return (annotationClass == null || method.getAnnotation(annotationClass) == null) ? false : true;
    }

    private static Class<? extends Annotation> e(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static void f(final Runnable runnable) throws Throwable {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Log.w(f10152c, "Already on the UI thread, this method should not be called from the main application thread");
            runnable.run();
            return;
        }
        FutureTask futureTask = new FutureTask(runnable, null);
        InstrumentationRegistry.b().runOnMainSync(futureTask);
        try {
            futureTask.get();
        } catch (ExecutionException e8) {
            throw e8.getCause();
        }
    }

    public static boolean g(d method) {
        Class<? extends Annotation> clsE = e("android.test.UiThreadTest");
        if (c(method, clsE)) {
            return true;
        }
        return c(method, clsE) || c(method, e("androidx.test.annotation.UiThreadTest"));
    }

    @Override // org.junit.runners.model.j
    public void a() throws Throwable {
        if (!this.f10154b) {
            this.f10153a.a();
            return;
        }
        final AtomicReference atomicReference = new AtomicReference();
        f(new Runnable() { // from class: androidx.test.internal.runner.junit4.statement.UiThreadStatement.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UiThreadStatement.this.f10153a.a();
                } catch (Throwable th) {
                    atomicReference.set(th);
                }
            }
        });
        Throwable th = (Throwable) atomicReference.get();
        if (th != null) {
            throw th;
        }
    }

    public boolean d() {
        return this.f10154b;
    }
}
