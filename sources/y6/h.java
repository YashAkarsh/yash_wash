package y6;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.view.PointerIcon;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import org.chromium.base.annotations.DoNotInline;

/* JADX INFO: loaded from: classes3.dex */
@DoNotInline
@TargetApi(24)
public final class h {
    private h() {
    }

    public static PointerIcon a(Bitmap bitmap, float f8, float f9) {
        return PointerIcon.create(bitmap, f8, f9);
    }

    public static JobInfo b(JobScheduler jobScheduler, int i7) {
        return jobScheduler.getPendingJob(i7);
    }

    public static void c(MediaCodec.CryptoInfo cryptoInfo, int i7, int i8) {
        g.a();
        cryptoInfo.setPattern(f.a(i7, i8));
    }

    public static void d(View view, PointerIcon pointerIcon) {
        view.setPointerIcon(pointerIcon);
    }

    public static void e(Activity activity, boolean z7, ComponentName componentName) throws PackageManager.NameNotFoundException {
        activity.setVrModeEnabled(z7, componentName);
    }

    public static boolean f(WebViewClient webViewClient, WebView webView, WebResourceRequest webResourceRequest) {
        return webViewClient.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    public static boolean g(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i7) {
        return view.startDragAndDrop(clipData, dragShadowBuilder, obj, i7);
    }
}
