package androidx.test.runner.screenshot;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import android.view.View;
import androidx.test.InstrumentationRegistry;
import androidx.test.annotation.Beta;
import androidx.test.internal.util.Checks;
import c.g1;
import c.m0;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
@Beta
public final class Screenshot {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f10529a = Build.VERSION.SDK_INT;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static UiAutomationWrapper f10530b = new UiAutomationWrapper();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Set<ScreenCaptureProcessor> f10531c = new HashSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static TakeScreenshotCallable.Factory f10532d = new TakeScreenshotCallable.Factory();

    static final class ScreenShotException extends RuntimeException {
        ScreenShotException(Throwable cause) {
            super(cause);
        }
    }

    public static void a(Set<ScreenCaptureProcessor> screenCaptureProcessors) {
        f10531c.addAll(screenCaptureProcessors);
    }

    public static ScreenCapture b() throws ScreenShotException {
        try {
            return e(null);
        } catch (IOException e8) {
            throw new ScreenShotException(e8);
        } catch (InterruptedException e9) {
            throw new ScreenShotException(e9);
        } catch (NullPointerException e10) {
            throw new IllegalStateException(e10);
        } catch (ExecutionException e11) {
            throw new ScreenShotException(e11);
        }
    }

    public static ScreenCapture c(@m0 Activity activity) throws ScreenShotException {
        Checks.g(activity, "activity cannot be null!");
        try {
            return e(activity.getWindow().getDecorView().getRootView());
        } catch (IOException e8) {
            throw new ScreenShotException(e8);
        } catch (InterruptedException e9) {
            throw new ScreenShotException(e9);
        } catch (ExecutionException e10) {
            throw new ScreenShotException(e10);
        }
    }

    public static ScreenCapture d(@m0 View view) throws ScreenShotException {
        Checks.g(view, "view cannot be null!");
        try {
            return e(view);
        } catch (IOException e8) {
            throw new ScreenShotException(e8);
        } catch (InterruptedException e9) {
            throw new ScreenShotException(e9);
        } catch (ExecutionException e10) {
            throw new ScreenShotException(e10);
        }
    }

    private static ScreenCapture e(View targetView) throws ExecutionException, InterruptedException, IOException {
        return new ScreenCapture((targetView != null || f10529a < 18) ? g(targetView) : f()).i(f10531c);
    }

    private static Bitmap f() {
        return f10530b.a();
    }

    private static Bitmap g(@m0 final View view) throws ExecutionException, InterruptedException {
        Checks.g(view, "Taking view based screenshot requires using either takeScreenshot(view) or takeScreenshot(activity) where view and activity are non-null.");
        FutureTask futureTask = new FutureTask(f10532d.a(view));
        if (Looper.myLooper() == Looper.getMainLooper()) {
            futureTask.run();
        } else {
            InstrumentationRegistry.c().runOnMainSync(futureTask);
        }
        return (Bitmap) futureTask.get();
    }

    @g1
    static void h(int sdkInt) {
        f10529a = sdkInt;
    }

    public static void i(Set<ScreenCaptureProcessor> screenCaptureProcessors) {
        f10531c = screenCaptureProcessors;
    }

    @g1
    static void j(TakeScreenshotCallable.Factory factory) {
        f10532d = factory;
    }

    @g1
    static void k(UiAutomationWrapper wrapper) {
        f10530b = wrapper;
    }
}
