package com.haier.globalwasher.view.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.PermissionRequest;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.o0;
import c.t0;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.utils.d0;
import com.haier.globalwasher.modle.utils.n0;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.presenter.y;
import com.haier.globalwasher.view.custom_view.webview.MyWebView;
import com.haier.globalwasher.view.fragment.e;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class WebActivity extends BaseActivity implements p2.a {
    private static final int C = 99;
    private static final int D = 100;
    private ValueCallback<Uri[]> A;
    TextView B;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private y f25464u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    MyWebView f25465v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    e f25466w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    String f25467x = "webFragment";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    com.haier.globalwasher.modle.js_api.c f25468y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private ValueCallback<Uri> f25469z;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WebActivity.this.W();
            WebActivity.this.onBackPressed();
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RelativeLayout f25471a;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) b.this.f25471a.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.topMargin = n0.g(WebActivity.this);
                }
            }
        }

        b(RelativeLayout relativeLayout) {
            this.f25471a = relativeLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            WebActivity.this.runOnUiThread(new a());
        }
    }

    class c extends WebChromeClient {

        class a extends WebViewClient {
            a() {
            }

            @Override // android.webkit.WebViewClient
            @o0
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
                q.c(WebActivity.this.f25467x, "shouldInterceptRequest");
                if (requestHeaders != null) {
                    q.c(WebActivity.this.f25467x, "shouldInterceptRequest.headers!=null");
                    for (Map.Entry<String, String> entry : requestHeaders.entrySet()) {
                        q.c(WebActivity.this.f25467x, entry.getKey() + "--->" + entry.getValue());
                        System.out.println(entry.getKey() + "--->" + entry.getValue());
                    }
                }
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (TextUtils.isEmpty(str)) {
                    return true;
                }
                WebActivity.j0(WebActivity.this, "", str);
                return true;
            }
        }

        c() {
        }

        public void a(ValueCallback<Uri> valueCallback) {
            WebActivity.this.f25469z = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("image/*");
            WebActivity.this.startActivityForResult(Intent.createChooser(intent, "请上传图片"), 99);
        }

        public void b(ValueCallback<Uri> valueCallback, String str) {
            WebActivity.this.f25469z = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("image/*");
            WebActivity.this.startActivityForResult(Intent.createChooser(intent, "请上传图片"), 99);
        }

        public void c(ValueCallback<Uri> valueCallback, String str, String str2) {
            WebActivity.this.f25469z = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("image/*");
            WebActivity.this.startActivityForResult(Intent.createChooser(intent, "请上传图片"), 99);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z7, boolean z8, Message message) {
            WebView webView2 = new WebView(webView.getContext());
            webView2.setWebViewClient(new a());
            ((WebView.WebViewTransport) message.obj).setWebView(webView2);
            message.sendToTarget();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            callback.invoke(str, true, false);
            super.onGeolocationPermissionsShowPrompt(str, callback);
        }

        @Override // android.webkit.WebChromeClient
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            super.onPermissionRequest(permissionRequest);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i7) {
            super.onProgressChanged(webView, i7);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedIcon(WebView webView, Bitmap bitmap) {
            super.onReceivedIcon(webView, bitmap);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            WebActivity.this.k0(str);
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            super.onShowCustomView(view, customViewCallback);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            WebActivity.this.A = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("image/*");
            Intent intent2 = new Intent("android.intent.action.CHOOSER");
            intent2.putExtra("android.intent.extra.INTENT", intent);
            intent2.putExtra("android.intent.extra.TITLE", "请上传图片");
            WebActivity.this.startActivityForResult(intent2, 100);
            return true;
        }
    }

    public static void j0(BaseActivity baseActivity, String str, String str2) {
        Intent intent = new Intent(baseActivity, (Class<?>) WebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("title", str + "");
        bundle.putString(y.f25407e, str2);
        intent.putExtra(y.f25405c, bundle);
        baseActivity.startActivity(intent);
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void a() {
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_web;
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void d() {
        U(false);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rly_top_view);
        ImageView imageView = (ImageView) findViewById(R.id.iv_back_image);
        imageView.setOnClickListener(new a());
        this.B = (TextView) findViewById(R.id.toolbar_title);
        Intent intent = getIntent();
        Bundle bundleExtra = intent.getBundleExtra(y.f25405c);
        String stringExtra = intent.getStringExtra("title");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.B.setText(stringExtra);
        this.f25465v = (MyWebView) findViewById(R.id.myweb);
        i0();
        String string = bundleExtra.getString(y.f25407e);
        if (d0.j(string)) {
            this.f25465v.loadUrl(string);
        }
        imageView.post(new b(relativeLayout));
    }

    @Override // com.haier.globalwasher.mvp_api.view.a
    public void e() {
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public com.haier.globalwasher.mvp_api.presenter.b f() {
        y yVar = new y();
        this.f25464u = yVar;
        return yVar;
    }

    @SuppressLint({"JavascriptInterface"})
    public void i0() {
        this.f25465v.requestFocusFromTouch();
        WebSettings settings = this.f25465v.getSettings();
        q.c(this.f25467x, "getUserAgentString=" + settings.getUserAgentString());
        settings.setMixedContentMode(0);
        settings.setAllowFileAccess(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.supportMultipleWindows();
        settings.setDatabaseEnabled(true);
        settings.setSupportMultipleWindows(true);
        settings.setGeolocationEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setDefaultTextEncodingName("utf-8");
        settings.setBlockNetworkImage(false);
        settings.setGeolocationDatabasePath(getApplicationContext().getDir("database", 0).getPath());
        this.f25465v.addJavascriptInterface(new com.haier.globalwasher.modle.js_api.a(this, this.f25465v), "AndroidJSApi");
        WebView.setWebContentsDebuggingEnabled(true);
        this.f25465v.setWebChromeClient(new c());
        this.f25465v.setWebViewClient(new d());
    }

    public void k0(String str) {
        if (str == null || str.equals("about:blank")) {
            return;
        }
        TextView textView = this.B;
        if ("null".equals(str)) {
            str = "";
        }
        textView.setText(str);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i7, int i8, @o0 Intent intent) {
        super.onActivityResult(i7, i8, intent);
        if (this.f25468y != null) {
            q.c("LoginAction", "WEBACTIVITY  toLogin   data=" + intent);
            this.f25468y.onActivityResult(i7, i8, intent);
        }
        if (i7 == 99) {
            if (this.f25469z == null) {
                return;
            }
            this.f25469z.onReceiveValue((intent == null || i8 != -1) ? null : intent.getData());
            this.f25469z = null;
            return;
        }
        if (i7 != 100 || this.A == null) {
            return;
        }
        Uri data = (intent == null || i8 != -1) ? null : intent.getData();
        if (data != null) {
            this.A.onReceiveValue(new Uri[]{data});
        } else {
            this.A.onReceiveValue(new Uri[0]);
        }
        this.A = null;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        MyWebView myWebView = this.f25465v;
        if (myWebView == null) {
            super.onBackPressed();
        } else if (myWebView.canGoBack()) {
            this.f25465v.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.haier.globalwasher.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        MyWebView myWebView = this.f25465v;
        if (myWebView != null) {
            myWebView.destroy();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i7, KeyEvent keyEvent) {
        MyWebView myWebView;
        if (i7 != 4 || (myWebView = this.f25465v) == null || !myWebView.canGoBack()) {
            return super.onKeyUp(i7, keyEvent);
        }
        this.f25465v.goBack();
        return true;
    }

    @Override // p2.a
    public void w(com.haier.globalwasher.modle.js_api.c cVar) {
        this.f25468y = cVar;
    }

    class d extends WebViewClient {
        d() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i7, String str, String str2) {
            super.onReceivedError(webView, i7, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.cancel();
        }

        @Override // android.webkit.WebViewClient
        public void onScaleChanged(WebView webView, float f8, float f9) {
            super.onScaleChanged(webView, f8, f9);
            WebActivity.this.f25465v.requestFocus();
            WebActivity.this.f25465v.requestFocusFromTouch();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            return super.shouldOverrideKeyEvent(webView, keyEvent);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            q.c(WebActivity.this.f25467x, "===" + str);
            if (str.startsWith("weixin://wap/pay?")) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                WebActivity.this.startActivity(intent);
                return true;
            }
            if (str.startsWith("tel:")) {
                WebActivity.this.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(str)));
                return true;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                return false;
            }
            webView.loadUrl(str);
            return true;
        }

        @Override // android.webkit.WebViewClient
        @t0(api = 21)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            webView.loadUrl(webResourceRequest.getUrl().toString());
            return true;
        }
    }
}
