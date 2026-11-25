package com.alipay.sdk.widget;

import android.R;
import android.content.Context;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class WebViewWindow extends LinearLayout {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Handler f13830k = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImageView f13831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f13832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ImageView f13833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ProgressBar f13834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WebView f13835e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f13836f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b f13837g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private c f13838h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private View.OnClickListener f13839i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final float f13840j;

    public interface a {
        boolean a(WebViewWindow webViewWindow, String str, String str2, String str3, JsPromptResult jsPromptResult);

        void e(WebViewWindow webViewWindow, String str);
    }

    public interface b {
        boolean b(WebViewWindow webViewWindow, SslErrorHandler sslErrorHandler, SslError sslError);

        boolean c(WebViewWindow webViewWindow, String str);

        boolean f(WebViewWindow webViewWindow, int i7, String str, String str2);

        boolean g(WebViewWindow webViewWindow, String str);
    }

    public interface c {
        void d(WebViewWindow webViewWindow);

        void h(WebViewWindow webViewWindow);
    }

    public WebViewWindow(Context context) {
        this(context, null);
    }

    private int a(int i7) {
        return (int) (i7 * this.f13840j);
    }

    private void d(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setBackgroundColor(-218103809);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        ImageView imageView = new ImageView(context);
        this.f13831a = imageView;
        imageView.setOnClickListener(this.f13839i);
        this.f13831a.setScaleType(ImageView.ScaleType.CENTER);
        this.f13831a.setImageDrawable(com.alipay.sdk.util.l.a(com.alipay.sdk.util.l.f13813a, context));
        this.f13831a.setPadding(a(12), 0, a(12), 0);
        linearLayout.addView(this.f13831a, new LinearLayout.LayoutParams(-2, -2));
        View view = new View(context);
        view.setBackgroundColor(-2500135);
        linearLayout.addView(view, new LinearLayout.LayoutParams(a(1), a(25)));
        TextView textView = new TextView(context);
        this.f13832b = textView;
        textView.setTextColor(-15658735);
        this.f13832b.setTextSize(17.0f);
        this.f13832b.setMaxLines(1);
        this.f13832b.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(a(17), 0, 0, 0);
        layoutParams.weight = 1.0f;
        linearLayout.addView(this.f13832b, layoutParams);
        ImageView imageView2 = new ImageView(context);
        this.f13833c = imageView2;
        imageView2.setOnClickListener(this.f13839i);
        this.f13833c.setScaleType(ImageView.ScaleType.CENTER);
        this.f13833c.setImageDrawable(com.alipay.sdk.util.l.a(com.alipay.sdk.util.l.f13814b, context));
        this.f13833c.setPadding(a(12), 0, a(12), 0);
        linearLayout.addView(this.f13833c, new LinearLayout.LayoutParams(-2, -2));
        addView(linearLayout, new LinearLayout.LayoutParams(-1, a(48)));
    }

    private void j(Context context) {
        ProgressBar progressBar = new ProgressBar(context, null, R.style.Widget.ProgressBar.Horizontal);
        this.f13834d = progressBar;
        progressBar.setProgressDrawable(context.getResources().getDrawable(R.drawable.progress_horizontal));
        this.f13834d.setMax(100);
        this.f13834d.setBackgroundColor(-218103809);
        addView(this.f13834d, new LinearLayout.LayoutParams(-1, a(2)));
    }

    private void l(Context context) {
        WebView webView = new WebView(context);
        this.f13835e = webView;
        webView.setVerticalScrollbarOverlay(true);
        e(this.f13835e, context);
        WebSettings settings = this.f13835e.getSettings();
        settings.setUseWideViewPort(true);
        settings.setAppCacheMaxSize(5242880L);
        settings.setAppCachePath(context.getCacheDir().getAbsolutePath());
        settings.setAllowFileAccess(true);
        settings.setAppCacheEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(-1);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        try {
            this.f13835e.removeJavascriptInterface("searchBoxJavaBridge_");
            this.f13835e.removeJavascriptInterface("accessibility");
            this.f13835e.removeJavascriptInterface("accessibilityTraversal");
        } catch (Exception unused) {
        }
        addView(this.f13835e, new LinearLayout.LayoutParams(-1, -1));
    }

    public void c() {
        removeAllViews();
        this.f13835e.removeAllViews();
        this.f13835e.setWebViewClient(null);
        this.f13835e.setWebChromeClient(null);
        this.f13835e.destroy();
    }

    protected void e(WebView webView, Context context) {
        webView.getSettings().setUserAgentString(webView.getSettings().getUserAgentString() + " AlipaySDK(" + context.getPackageName() + "/" + com.alipay.sdk.util.o.F(context) + "/15.6.8)");
    }

    public void f(String str) {
        this.f13835e.loadUrl(str);
    }

    public void g(String str, byte[] bArr) {
        this.f13835e.postUrl(str, bArr);
    }

    public ImageView getBackButton() {
        return this.f13831a;
    }

    public ProgressBar getProgressbar() {
        return this.f13834d;
    }

    public ImageView getRefreshButton() {
        return this.f13833c;
    }

    public TextView getTitle() {
        return this.f13832b;
    }

    public String getUrl() {
        return this.f13835e.getUrl();
    }

    public WebView getWebView() {
        return this.f13835e;
    }

    public void setChromeProxy(a aVar) {
        this.f13836f = aVar;
        if (aVar == null) {
            this.f13835e.setWebChromeClient(null);
        } else {
            this.f13835e.setWebChromeClient(new s(this));
        }
    }

    public void setWebClientProxy(b bVar) {
        this.f13837g = bVar;
        if (bVar == null) {
            this.f13835e.setWebViewClient(null);
        } else {
            this.f13835e.setWebViewClient(new t(this));
        }
    }

    public void setWebEventProxy(c cVar) {
        this.f13838h = cVar;
    }

    public WebViewWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13839i = new q(this);
        this.f13840j = context.getResources().getDisplayMetrics().density;
        setOrientation(1);
        d(context);
        j(context);
        l(context);
    }
}
