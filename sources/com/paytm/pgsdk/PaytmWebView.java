package com.paytm.pgsdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import c.o0;
import easypay.appinvoke.manager.EasypayWebViewClient;
import easypay.appinvoke.manager.PaytmAssist;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(21)
public class PaytmWebView extends WebView implements x4.f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f32956e = "HTMLOUT";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f32957f = "javascript:window.HTMLOUT.processResponse(document.getElementById('response').value);";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f32958g = "Y";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f32959h = "01";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f32960i = "/CAS/Response";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f32961j = "theia/paytmCallback";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f32962k = 105;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f32963l = "javascript:window.upiIntent.setUpiIntentApps(";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PaytmPGActivity f32964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f32965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HashMap<String, ResolveInfo> f32966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicBoolean f32967d;

    class a extends WebChromeClient {
        a() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            p.a("JavaScript Alert " + str);
            return super.onJsAlert(webView, str, str2, jsResult);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PaytmWebView.this.f32964a.f32934e.setVisibility(0);
            p.a("Progress dialog started");
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PaytmWebView.this.f32964a.f32934e.setVisibility(8);
            p.a("Progress dialog ended");
        }
    }

    class d implements Callback {

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Response f32972a;

            a(Response response) {
                this.f32972a = response;
            }

            @Override // java.lang.Runnable
            public void run() {
                l lVarM = j.h().m();
                try {
                    if (this.f32972a.code() == 200 && this.f32972a.body() != null) {
                        a4.b bVar = (a4.b) new com.google.gson.f().n(this.f32972a.body().string(), a4.b.class);
                        if (bVar.a() != null && bVar.a().a() != null) {
                            try {
                                lVarM.h(PaytmWebView.this.m(new com.google.gson.f().z(bVar.a().a())));
                            } catch (Exception unused) {
                                lVarM.h(null);
                            }
                            ((Activity) PaytmWebView.this.getContext()).finish();
                            return;
                        }
                    }
                } catch (Exception unused2) {
                }
                lVarM.h(null);
                ((Activity) PaytmWebView.this.getContext()).finish();
            }
        }

        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                l lVarM = j.h().m();
                if (lVarM != null) {
                    lVarM.h(null);
                }
                ((Activity) PaytmWebView.this.getContext()).finish();
            }
        }

        d() {
        }

        @Override // okhttp3.Callback
        public void onFailure(@a7.d Call call, @a7.d IOException iOException) {
            ((Activity) PaytmWebView.this.getContext()).runOnUiThread(new b());
        }

        @Override // okhttp3.Callback
        public void onResponse(@a7.d Call call, @a7.d Response response) throws IOException {
            ((Activity) PaytmWebView.this.getContext()).runOnUiThread(new a(response));
        }
    }

    public class e {

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f32976a;

            a(String str) {
                this.f32976a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                PaytmWebView.this.loadUrl(this.f32976a);
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ l f32978a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Bundle f32979b;

            b(l lVar, Bundle bundle) {
                this.f32978a = lVar;
                this.f32979b = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (this.f32978a != null) {
                        com.paytm.pgsdk.a.e().h(com.paytm.pgsdk.d.f33017t, com.paytm.pgsdk.d.f33012o, "status", "success");
                        this.f32978a.h(this.f32979b);
                    }
                } catch (Exception e8) {
                    com.paytm.pgsdk.a.e().h(com.paytm.pgsdk.d.f33017t, com.paytm.pgsdk.d.f33012o, "status", com.paytm.pgsdk.d.E);
                    com.paytm.pgsdk.a.e().f(com.paytm.pgsdk.d.f33012o, e8.getMessage());
                    p.k(e8);
                    l lVar = this.f32978a;
                    if (lVar != null) {
                        lVar.e(0, e8.getMessage(), PaytmWebView.this.getUrl());
                    }
                }
                ((Activity) PaytmWebView.this.getContext()).finish();
            }
        }

        public e() {
        }

        private synchronized void a(Bundle bundle) {
            try {
                ((Activity) PaytmWebView.this.getContext()).runOnUiThread(new b(j.h().m(), bundle));
            } catch (Exception e8) {
                com.paytm.pgsdk.a.e().h(com.paytm.pgsdk.d.f33017t, com.paytm.pgsdk.d.f33012o, "status", com.paytm.pgsdk.d.E);
                com.paytm.pgsdk.a.e().f(com.paytm.pgsdk.d.f33012o, e8.getMessage());
                p.k(e8);
                if (j.h() != null && j.h().m() != null) {
                    j.h().m().e(0, e8.getMessage(), PaytmWebView.this.getUrl());
                }
                ((Activity) PaytmWebView.this.getContext()).finish();
            }
        }

        @JavascriptInterface
        public synchronized void inVokeUpiFlow(String str) {
            try {
                if (PaytmWebView.this.f32964a != null) {
                    PaytmWebView paytmWebView = PaytmWebView.this;
                    PaytmWebView.this.post(new a("javascript:window.upiIntent.setUpiIntentApps('" + paytmWebView.i(paytmWebView.f32964a) + "')"));
                }
            } catch (Exception e8) {
                com.paytm.pgsdk.a.e().f(com.paytm.pgsdk.d.f33012o, e8.getMessage());
                p.k(e8);
            }
        }

        @JavascriptInterface
        public synchronized void postMobileNum(String str) {
        }

        @JavascriptInterface
        public synchronized void processResponse(String str) {
            try {
                p.a("Merchant Response is " + str);
                Bundle bundleM = PaytmWebView.this.m(str);
                String str2 = j.h().f33068a.a().get(com.paytm.pgsdk.d.f33005h);
                a(bundleM);
                if (TextUtils.isEmpty(str2)) {
                    p.a("Returning the response back to Merchant Application");
                    l lVarM = j.h().m();
                    if (lVarM != null) {
                        com.paytm.pgsdk.a.e().h(com.paytm.pgsdk.d.f33017t, com.paytm.pgsdk.d.f33012o, "status", "success");
                        lVarM.f("no callback url", null);
                    }
                } else {
                    com.paytm.pgsdk.a.e().h(com.paytm.pgsdk.d.f33017t, com.paytm.pgsdk.d.f33012o, "status", com.paytm.pgsdk.d.E);
                    p.a("Merchant Specific URL is present, So posting all parameters to Merchant specific URL");
                }
            } catch (Exception e8) {
                com.paytm.pgsdk.a.e().h(com.paytm.pgsdk.d.f33017t, com.paytm.pgsdk.d.f33012o, "status", com.paytm.pgsdk.d.E);
                com.paytm.pgsdk.a.e().f(com.paytm.pgsdk.d.f33012o, e8.getMessage());
                p.k(e8);
            }
        }

        @JavascriptInterface
        public synchronized void saveMobileNum(String str) {
        }

        @JavascriptInterface
        public synchronized void upiAppClicked(String str, String str2) {
            try {
                if (PaytmWebView.this.f32964a != null) {
                    PaytmWebView.this.f32964a.getPackageManager();
                    Intent intent = new Intent("android.intent.action.VIEW");
                    if (!PaytmWebView.this.f32966c.isEmpty()) {
                        ActivityInfo activityInfo = ((ResolveInfo) PaytmWebView.this.f32966c.get(str)).activityInfo;
                        ComponentName componentName = new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name);
                        new Uri.Builder().scheme("upi").authority("pay");
                        intent.setData(Uri.parse(Uri.parse(str2).buildUpon().toString()));
                        intent.setComponent(componentName);
                        p.a("App click package:" + str);
                        p.a("App click deeplink:" + str2.toString());
                        PaytmWebView.this.f32964a.startActivityForResult(intent, 105);
                    }
                }
            } catch (Exception e8) {
                com.paytm.pgsdk.a.e().f(com.paytm.pgsdk.d.f33012o, e8.getMessage());
                p.k(e8);
            }
        }
    }

    private class f extends EasypayWebViewClient {
        public f() {
            super(PaytmWebView.this.f32964a);
        }

        @Override // android.webkit.WebViewClient
        public void onFormResubmission(WebView webView, Message message, Message message2) {
            super.onFormResubmission(webView, message, message2);
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageCommitVisible(WebView webView, String str) {
            p.a("onPageCommitVisible" + str);
            super.onPageCommitVisible(webView, str);
        }

        /* JADX WARN: Code duplicated, block: B:45:0x0162 A[Catch: all -> 0x017b, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x000d, B:7:0x0013, B:10:0x001d, B:12:0x0029, B:24:0x00a3, B:26:0x00ab, B:27:0x00cb, B:39:0x0127, B:41:0x012f, B:42:0x0152, B:36:0x00fe, B:38:0x0106, B:43:0x0153, B:45:0x0162, B:46:0x0172, B:13:0x003d, B:15:0x0059, B:17:0x0067, B:18:0x007a, B:20:0x0082, B:21:0x008f, B:23:0x0097, B:32:0x00d3, B:34:0x00ec, B:35:0x00fb), top: B:55:0x0001, inners: #0 }] */
        @Override // easypay.appinvoke.manager.EasypayWebViewClient, android.webkit.WebViewClient
        public synchronized void onPageFinished(WebView webView, String str) {
            Intent intent;
            PaytmPGActivity paytmPGActivity;
            if (!PaytmWebView.this.f32964a.isFinishing()) {
                if (j.h() != null && j.h().f33068a != null) {
                    HashMap<String, String> mapA = j.h().f33068a.a();
                    if (mapA != null) {
                        p.a("page finish url" + str);
                        try {
                            try {
                                p.a("Page finished loading " + str);
                                if (mapA.get(com.paytm.pgsdk.d.f33005h) != null && str.contains(mapA.get(com.paytm.pgsdk.d.f33005h))) {
                                    p.a("Merchant specific Callback Url is finished loading. Extract data now. ");
                                    PaytmWebView.this.f32965b = true;
                                    PaytmWebView.this.loadUrl(PaytmWebView.f32957f);
                                } else if (str.endsWith(PaytmWebView.f32960i) || str.contains(PaytmWebView.f32961j)) {
                                    p.a("CAS Callback Url is finished loading. Extract data now. ");
                                    PaytmWebView.this.loadUrl(PaytmWebView.f32957f);
                                }
                                if (mapA.get("postnotificationurl") != null) {
                                    intent = new Intent(PaytmWebView.this.f32964a, (Class<?>) IntentServicePostNotification.class);
                                    intent.putExtra("url", mapA.get("postnotificationurl"));
                                    paytmPGActivity = PaytmWebView.this.f32964a;
                                    paytmPGActivity.startService(intent);
                                }
                            } catch (Exception e8) {
                                com.paytm.pgsdk.a.e().f(com.paytm.pgsdk.d.f33012o, e8.getMessage());
                                if (str.equals(j.h().f33071d)) {
                                    com.paytm.pgsdk.a.e().h(com.paytm.pgsdk.d.f33016s, com.paytm.pgsdk.d.f33012o, "status", com.paytm.pgsdk.d.E);
                                }
                                p.k(e8);
                                if (mapA.get("postnotificationurl") != null) {
                                    intent = new Intent(PaytmWebView.this.f32964a, (Class<?>) IntentServicePostNotification.class);
                                    intent.putExtra("url", mapA.get("postnotificationurl"));
                                    paytmPGActivity = PaytmWebView.this.f32964a;
                                } else {
                                    super.onPageFinished(webView, str);
                                    if (str.equals(j.h().f33071d)) {
                                        com.paytm.pgsdk.a.e().h(com.paytm.pgsdk.d.f33016s, com.paytm.pgsdk.d.f33012o, "status", com.paytm.pgsdk.d.E);
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            if (mapA.get("postnotificationurl") != null) {
                                Intent intent2 = new Intent(PaytmWebView.this.f32964a, (Class<?>) IntentServicePostNotification.class);
                                intent2.putExtra("url", mapA.get("postnotificationurl"));
                                PaytmWebView.this.f32964a.startService(intent2);
                            }
                            throw th;
                        }
                    }
                    super.onPageFinished(webView, str);
                    if (str.equals(j.h().f33071d)) {
                        com.paytm.pgsdk.a.e().h(com.paytm.pgsdk.d.f33016s, com.paytm.pgsdk.d.f33012o, "status", com.paytm.pgsdk.d.E);
                    }
                }
                p.a("Transaction cancelled before loading web com.paytm.pgsdk.view completely.");
            }
        }

        @Override // easypay.appinvoke.manager.EasypayWebViewClient, android.webkit.WebViewClient
        public synchronized void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            PaytmWebView.this.g(str);
        }

        @Override // easypay.appinvoke.manager.EasypayWebViewClient, android.webkit.WebViewClient
        public synchronized void onReceivedError(WebView webView, int i7, String str, String str2) {
            p.a("Error occured while loading url " + str2);
            com.paytm.pgsdk.a.e().f(com.paytm.pgsdk.d.f33012o, "Error occurred while loading url " + str2);
            super.onReceivedError(webView, i7, str, str2);
            if (str2.equals(j.h().f33071d)) {
                com.paytm.pgsdk.a.e().h(com.paytm.pgsdk.d.f33016s, com.paytm.pgsdk.d.f33012o, "status", com.paytm.pgsdk.d.E);
            }
            p.a("Error code is " + i7 + "Description is " + str);
            if (i7 == -6) {
                ((Activity) PaytmWebView.this.getContext()).finish();
                l lVarM = j.h().m();
                if (lVarM != null) {
                    lVarM.e(i7, str, str2);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            p.a("onReceivedHttpError" + webResourceRequest.getUrl());
            com.paytm.pgsdk.a.e().f(com.paytm.pgsdk.d.f33012o, "onReceivedHttpError " + webResourceRequest.getUrl());
            if (webResourceRequest.getUrl().toString().equals(j.h().f33071d)) {
                com.paytm.pgsdk.a.e().h(com.paytm.pgsdk.d.f33016s, com.paytm.pgsdk.d.f33012o, "status", com.paytm.pgsdk.d.E);
            }
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }

        @Override // easypay.appinvoke.manager.EasypayWebViewClient, android.webkit.WebViewClient
        public synchronized void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            p.a("SSL Error occured " + sslError.toString());
            com.paytm.pgsdk.a.e().f(com.paytm.pgsdk.d.f33012o, "SSL Error occurred " + sslError.getUrl());
            if (sslError.getUrl().equals(j.h().f33071d)) {
                com.paytm.pgsdk.a.e().h(com.paytm.pgsdk.d.f33016s, com.paytm.pgsdk.d.f33012o, "status", com.paytm.pgsdk.d.E);
            }
            p.a("SSL Handler is " + sslErrorHandler);
            if (sslErrorHandler != null) {
                sslErrorHandler.cancel();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            super.onUnhandledKeyEvent(webView, keyEvent);
        }

        @Override // android.webkit.WebViewClient
        @o0
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            PaytmWebView.this.g(webResourceRequest.getUrl().toString());
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            return super.shouldOverrideKeyEvent(webView, keyEvent);
        }

        @Override // easypay.appinvoke.manager.EasypayWebViewClient, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }

        @Override // easypay.appinvoke.manager.EasypayWebViewClient, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            p.a("shouldOverrideUrlLoading" + str);
            return super.shouldOverrideUrlLoading(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            p.a("onReceivedError" + webResourceRequest.getUrl());
            com.paytm.pgsdk.a.e().f(com.paytm.pgsdk.d.f33012o, "onReceivedError " + webResourceRequest.getUrl());
            if (webResourceRequest.getUrl().toString().equals(j.h().f33071d)) {
                com.paytm.pgsdk.a.e().h(com.paytm.pgsdk.d.f33016s, com.paytm.pgsdk.d.f33012o, "status", com.paytm.pgsdk.d.E);
            }
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }
    }

    public interface g {
        void a(String str);
    }

    public PaytmWebView(Context context, Bundle bundle) {
        super(context);
        this.f32967d = new AtomicBoolean(false);
        this.f32964a = (PaytmPGActivity) context;
        this.f32966c = new HashMap<>();
        setWebChromeClient(new a());
        getSettings().setJavaScriptEnabled(true);
        getSettings().setMixedContentMode(0);
        addJavascriptInterface(new e(), f32956e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str) {
        HashMap<String, String> mapA;
        if (TextUtils.isEmpty(str) || j.h().f33068a == null || (mapA = j.h().f33068a.a()) == null || mapA.get(com.paytm.pgsdk.d.f33005h) == null || mapA.get(com.paytm.pgsdk.d.f33005h).contains(f32961j) || !str.contains(mapA.get(com.paytm.pgsdk.d.f33005h))) {
            return;
        }
        p.a("Merchant specific Callback Url is finished loading. Extract data now. ");
        this.f32965b = true;
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String i(Context context) {
        String strZ = "";
        if (context == null) {
            return "";
        }
        try {
            com.google.gson.f fVar = new com.google.gson.f();
            HashMap map = new HashMap();
            Uri.Builder builder = new Uri.Builder();
            builder.scheme("upi").authority("pay");
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(builder.toString()));
            PackageManager packageManager = context.getPackageManager();
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 0)) {
                map.put(resolveInfo.loadLabel(packageManager).toString(), resolveInfo.activityInfo.packageName);
                this.f32966c.put(resolveInfo.activityInfo.packageName, resolveInfo);
            }
            strZ = fVar.z(map);
            p.a("Upi App List" + strZ);
            return strZ;
        } catch (Exception e8) {
            com.paytm.pgsdk.a.e().f(com.paytm.pgsdk.d.f33012o, e8.getMessage());
            e8.printStackTrace();
            return strZ;
        }
    }

    private synchronized boolean l(Bundle bundle) {
        boolean z7;
        z7 = false;
        if (bundle != null) {
            try {
                if (bundle.size() > 0 && bundle.containsKey(com.paytm.pgsdk.g.f33038l) && bundle.getString(com.paytm.pgsdk.g.f33038l).equalsIgnoreCase(f32958g)) {
                    z7 = true;
                }
            } catch (Exception e8) {
                com.paytm.pgsdk.a.e().f(com.paytm.pgsdk.d.f33012o, e8.getMessage());
                p.k(e8);
            }
        }
        return z7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Bundle m(String str) {
        Bundle bundle;
        p.a("Parsing the Merchant Response");
        bundle = new Bundle();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() > 0) {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    String string = jSONObject.getString(next);
                    p.a(next + " = " + string);
                    bundle.putString(next, string);
                }
            }
        } catch (Exception e8) {
            com.paytm.pgsdk.a.e().f(com.paytm.pgsdk.d.f33012o, e8.getMessage());
            p.a("Error while parsing the Merchant Response");
            p.k(e8);
        }
        return bundle;
    }

    private synchronized void n() {
        try {
            ((Activity) getContext()).runOnUiThread(new b());
        } catch (Exception e8) {
            com.paytm.pgsdk.a.e().f(com.paytm.pgsdk.d.f33012o, e8.getMessage());
            p.k(e8);
        }
    }

    private synchronized void o() {
        try {
            ((Activity) getContext()).runOnUiThread(new c());
        } catch (Exception e8) {
            com.paytm.pgsdk.a.e().f(com.paytm.pgsdk.d.f33012o, e8.getMessage());
            p.k(e8);
        }
    }

    public void h() {
        if (this.f32967d.get()) {
            return;
        }
        this.f32967d.set(true);
        j jVarH = j.h();
        String strL = j.l();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put("txnToken", jVarH.f33068a.a().get(com.paytm.pgsdk.d.f33007j));
            jSONObject3.put("mid", jVarH.f33068a.a().get("MID"));
            jSONObject3.put("orderId", jVarH.f33068a.a().get(com.paytm.pgsdk.d.f32998a));
            jSONObject3.put("isCallbackUrlRequired", true);
            jSONObject.put(com.paytm.pgsdk.d.V, jSONObject3);
            jSONObject.put(com.paytm.pgsdk.d.U, jSONObject2);
            Request requestBuild = new Request.Builder().url(strL).header(com.alipay.sdk.packet.e.f13726f, "application/json").header(com.google.common.net.c.f22146h, "application/json").post(RequestBody.create(MediaType.parse("application/json"), jSONObject.toString().getBytes())).build();
            OkHttpClient.Builder builderNewBuilder = new OkHttpClient().newBuilder();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            builderNewBuilder.connectTimeout(30L, timeUnit).writeTimeout(30L, timeUnit).readTimeout(30L, timeUnit).build().newCall(requestBuild).enqueue(new d());
        } catch (Exception e8) {
            l lVarM = j.h().m();
            if (lVarM != null) {
                lVarM.h(null);
            }
            com.paytm.pgsdk.a.e().f(com.paytm.pgsdk.d.f33012o, e8.getMessage());
        }
    }

    @Override // x4.f
    public void j(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        com.paytm.pgsdk.a.e().f(com.paytm.pgsdk.d.f33012o, "Error occurred while loading url " + sslError.getUrl());
        p.a("Error occured while loading url " + sslError.getUrl());
        if (sslError.getUrl().equals(j.h().f33071d)) {
            com.paytm.pgsdk.a.e().h(com.paytm.pgsdk.d.f33016s, com.paytm.pgsdk.d.f33012o, "status", com.paytm.pgsdk.d.E);
        }
    }

    @Override // x4.f
    public void k(WebView webView, String str, Bitmap bitmap) {
        p.a("Wc Page Start " + str);
        g(str);
    }

    @Override // x4.f
    public void r(WebView webView, String str) {
        g(str);
    }

    public void setWebCLientCallBacks() {
        setWebViewClient(PaytmAssist.getAssistInstance().getWebClientInstance());
        PaytmAssist.getAssistInstance().getWebClientInstance().addAssistWebClientListener(this);
    }

    @Override // x4.f
    public void y(WebView webView, String str) {
        Intent intent;
        p.a("Wc Page finsih " + str);
        if (this.f32964a.isFinishing()) {
            return;
        }
        if (j.h() == null || j.h().f33068a == null) {
            p.a("Transaction cancelled before loading web com.paytm.pgsdk.view completely.");
            return;
        }
        HashMap<String, String> mapA = j.h().f33068a.a();
        if (mapA != null) {
            p.a("page finish url" + str);
            try {
                try {
                    p.a("Page finished loading " + str);
                    if (mapA.get(com.paytm.pgsdk.d.f33005h) != null && str.contains(mapA.get(com.paytm.pgsdk.d.f33005h))) {
                        p.a("Merchant specific Callback Url is finished loading. Extract data now. ");
                        this.f32965b = true;
                        loadUrl(f32957f);
                    } else if (str.endsWith(f32960i) || str.contains(f32961j)) {
                        p.a("CAS Callback Url is finished loading. Extract data now. ");
                        loadUrl(f32957f);
                    }
                    if (mapA.get("postnotificationurl") != null) {
                        intent = new Intent(this.f32964a, (Class<?>) IntentServicePostNotification.class);
                        intent.putExtra("url", mapA.get("postnotificationurl"));
                        this.f32964a.startService(intent);
                    }
                } catch (Exception e8) {
                    com.paytm.pgsdk.a.e().f(com.paytm.pgsdk.d.f33012o, e8.getMessage());
                    if (str.equals(j.h().f33071d)) {
                        com.paytm.pgsdk.a.e().h(com.paytm.pgsdk.d.f33016s, com.paytm.pgsdk.d.f33012o, "status", com.paytm.pgsdk.d.E);
                    }
                    p.k(e8);
                    if (mapA.get("postnotificationurl") != null) {
                        intent = new Intent(this.f32964a, (Class<?>) IntentServicePostNotification.class);
                    }
                }
            } catch (Throwable th) {
                if (mapA.get("postnotificationurl") != null) {
                    Intent intent2 = new Intent(this.f32964a, (Class<?>) IntentServicePostNotification.class);
                    intent2.putExtra("url", mapA.get("postnotificationurl"));
                    this.f32964a.startService(intent2);
                }
                throw th;
            }
        }
        if (str.equals(j.h().f33071d)) {
            com.paytm.pgsdk.a.e().h(com.paytm.pgsdk.d.f33016s, com.paytm.pgsdk.d.f33012o, "status", com.paytm.pgsdk.d.E);
        }
    }

    @Override // x4.f
    public boolean z(WebView webView, Object obj) {
        return false;
    }
}
