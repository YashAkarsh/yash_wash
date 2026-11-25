package y6;

import android.annotation.TargetApi;
import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Process;
import android.view.ActionMode;
import android.view.ViewConfiguration;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import org.chromium.base.annotations.DoNotInline;

/* JADX INFO: loaded from: classes3.dex */
@DoNotInline
@TargetApi(23)
public final class a {
    private a() {
    }

    public static int a(ActionMode actionMode) {
        return actionMode.getType();
    }

    public static Network b(ConnectivityManager connectivityManager) {
        return connectivityManager.getActiveNetwork();
    }

    public static Network c(ConnectivityManager connectivityManager) {
        return connectivityManager.getBoundNetworkForProcess();
    }

    public static long d() {
        return ViewConfiguration.getDefaultActionModeHideDuration();
    }

    public static long e(Network network) {
        return network.getNetworkHandle();
    }

    public static NetworkInfo f(ConnectivityManager connectivityManager, Network network) {
        return connectivityManager.getNetworkInfo(network);
    }

    public static void g(ActionMode actionMode, long j7) {
        actionMode.hide(j7);
    }

    public static void h(ActionMode actionMode) {
        actionMode.invalidateContentRect();
    }

    public static boolean i(Activity activity, String str) {
        return activity.getPackageManager().isPermissionRevokedByPolicy(str, activity.getPackageName());
    }

    public static boolean j() {
        return Process.is64Bit();
    }

    public static void k(WebViewClient webViewClient, WebView webView, String str) {
        webViewClient.onPageCommitVisible(webView, str);
    }

    public static void l(ActionMode actionMode, boolean z7) {
        actionMode.onWindowFocusChanged(z7);
    }

    public static void m(Activity activity, String[] strArr, int i7) {
        activity.requestPermissions(strArr, i7);
    }

    public static boolean n(Activity activity, String str) {
        return activity.shouldShowRequestPermissionRationale(str);
    }
}
