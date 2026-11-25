package androidx.test.runner.screenshot;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import c.g1;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
final class TakeScreenshotCallable implements Callable<Bitmap> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10533b = "TakeScreenshotCallable";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<View> f10534a;

    @g1
    static class Factory {
        Factory() {
        }

        Callable<Bitmap> a(View view) {
            return new TakeScreenshotCallable(view);
        }
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap call() {
        this.f10534a.get().setDrawingCacheEnabled(true);
        try {
            return Bitmap.createBitmap(this.f10534a.get().getDrawingCache());
        } catch (OutOfMemoryError e8) {
            Log.e(f10533b, "Out of memory exception while trying to take a screenshot.", e8);
            return null;
        } finally {
            this.f10534a.get().setDrawingCacheEnabled(false);
        }
    }

    private TakeScreenshotCallable(View view) {
        this.f10534a = new WeakReference<>(view);
    }
}
