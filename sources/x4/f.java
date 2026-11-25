package x4;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes2.dex */
public interface f {
    void j(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError);

    void k(WebView webView, String str, Bitmap bitmap);

    void r(WebView webView, String str);

    void y(WebView webView, String str);

    boolean z(WebView webView, Object obj);
}
