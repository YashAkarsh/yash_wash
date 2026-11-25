package com.alipay.sdk.widget;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.haier.uhome.account.api.Const;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class j extends g implements WebViewWindow.a, WebViewWindow.b, WebViewWindow.c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f13862h = "sdk_result_code:";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f13863i = "alipayjsbridge://";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f13864j = "onBack";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f13865k = "setTitle";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f13866l = "onRefresh";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f13867m = "showBackButton";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f13868n = "onExit";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f13869o = "onLoadJs";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f13870p = "callNativeFunc";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f13871q = "back";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f13872r = "title";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f13873s = "refresh";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f13874t = "backButton";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f13875u = "refreshButton";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f13876v = "exit";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f13877w = "action";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f13878x = "pushWindow";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f13879y = "h5JsFuncCallback";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f13880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f13881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f13882d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f13883e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private WebViewWindow f13884f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private u f13885g;

    /* JADX INFO: Access modifiers changed from: private */
    abstract class a implements Animation.AnimationListener {
        private a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        /* synthetic */ a(j jVar, k kVar) {
            this();
        }
    }

    public j(Activity activity) {
        super(activity);
        this.f13880b = true;
        this.f13881c = Const.HTTP_REQUEST_TYPE_GET;
        this.f13882d = false;
        this.f13884f = null;
        this.f13885g = new u();
        u();
    }

    private void n(String str, String str2, String str3) {
        JSONObject jSONObjectZ = com.alipay.sdk.util.o.z(str3);
        if ("title".equals(str) && jSONObjectZ.has("title")) {
            this.f13884f.getTitle().setText(jSONObjectZ.optString("title", ""));
            return;
        }
        if (f13873s.equals(str)) {
            this.f13884f.getWebView().reload();
            return;
        }
        if (f13871q.equals(str)) {
            w();
            return;
        }
        if (f13876v.equals(str)) {
            com.alipay.sdk.app.k.c(jSONObjectZ.optString(com.alipay.sdk.util.m.f13818c, null));
            p(jSONObjectZ.optBoolean("success", false));
            return;
        }
        if (f13874t.equals(str)) {
            this.f13884f.getBackButton().setVisibility(jSONObjectZ.optBoolean("show", true) ? 0 : 4);
            return;
        }
        if (f13875u.equals(str)) {
            this.f13884f.getRefreshButton().setVisibility(jSONObjectZ.optBoolean("show", true) ? 0 : 4);
        } else {
            if (!f13878x.equals(str) || jSONObjectZ.optString("url", null) == null) {
                return;
            }
            t(jSONObjectZ.optString("url"), jSONObjectZ.optString("title", ""));
        }
    }

    private void p(boolean z7) {
        com.alipay.sdk.app.k.d(z7);
        this.f13858a.finish();
    }

    private void r(String str) {
        Map<String, String> mapW = com.alipay.sdk.util.o.w(str);
        if (str.startsWith(f13870p)) {
            n(mapW.get("func"), mapW.get("cbId"), mapW.get("data"));
            return;
        }
        if (str.startsWith(f13864j)) {
            w();
            return;
        }
        if (str.startsWith(f13865k) && mapW.containsKey("title")) {
            this.f13884f.getTitle().setText(mapW.get("title"));
            return;
        }
        if (str.startsWith(f13866l)) {
            this.f13884f.getWebView().reload();
            return;
        }
        if (str.startsWith(f13867m) && mapW.containsKey("bshow")) {
            this.f13884f.getBackButton().setVisibility(TextUtils.equals("true", mapW.get("bshow")) ? 0 : 4);
        } else if (str.startsWith(f13868n)) {
            com.alipay.sdk.app.k.c(mapW.get(com.alipay.sdk.util.m.f13818c));
            p(TextUtils.equals("true", mapW.get("bsucc")));
        } else if (str.startsWith(f13869o)) {
            this.f13884f.f("javascript:(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n");
        }
    }

    private boolean t(String str, String str2) {
        WebViewWindow webViewWindow = this.f13884f;
        try {
            WebViewWindow webViewWindow2 = new WebViewWindow(this.f13858a);
            this.f13884f = webViewWindow2;
            webViewWindow2.setChromeProxy(this);
            this.f13884f.setWebClientProxy(this);
            this.f13884f.setWebEventProxy(this);
            if (!TextUtils.isEmpty(str2)) {
                this.f13884f.getTitle().setText(str2);
            }
            this.f13882d = true;
            this.f13885g.b(webViewWindow);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new m(this, webViewWindow, str));
            this.f13884f.setAnimation(translateAnimation);
            addView(this.f13884f);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean u() {
        try {
            WebViewWindow webViewWindow = new WebViewWindow(this.f13858a);
            this.f13884f = webViewWindow;
            webViewWindow.setChromeProxy(this);
            this.f13884f.setWebClientProxy(this);
            this.f13884f.setWebEventProxy(this);
            addView(this.f13884f);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void v() {
        if (this.f13880b) {
            this.f13858a.finish();
        } else {
            this.f13884f.f("javascript:window.AlipayJSBridge.callListener('h5BackAction');");
        }
    }

    private void w() {
        WebView webView = this.f13884f.getWebView();
        if (webView.canGoBack()) {
            webView.goBack();
            return;
        }
        u uVar = this.f13885g;
        if (uVar == null || uVar.c()) {
            p(false);
        } else {
            x();
        }
    }

    private boolean x() {
        if (this.f13885g.c()) {
            this.f13858a.finish();
        } else {
            this.f13882d = true;
            WebViewWindow webViewWindow = this.f13884f;
            this.f13884f = this.f13885g.a();
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new l(this, webViewWindow));
            webViewWindow.setAnimation(translateAnimation);
            removeView(webViewWindow);
            addView(this.f13884f);
        }
        return true;
    }

    @Override // com.alipay.sdk.widget.WebViewWindow.a
    public boolean a(WebViewWindow webViewWindow, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (str2.startsWith("<head>") && str2.contains(f13862h)) {
            this.f13858a.runOnUiThread(new k(this));
        }
        jsPromptResult.cancel();
        return true;
    }

    @Override // com.alipay.sdk.widget.WebViewWindow.b
    public boolean b(WebViewWindow webViewWindow, SslErrorHandler sslErrorHandler, SslError sslError) {
        com.alipay.sdk.app.statistic.a.d("net", com.alipay.sdk.app.statistic.c.B, "2-" + sslError);
        if (!this.f13883e) {
            this.f13858a.runOnUiThread(new n(this, sslErrorHandler));
            return true;
        }
        sslErrorHandler.proceed();
        this.f13883e = false;
        return true;
    }

    @Override // com.alipay.sdk.widget.WebViewWindow.b
    public boolean c(WebViewWindow webViewWindow, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith(f13863i)) {
            r(str.substring(17));
            return true;
        }
        if (TextUtils.equals(str, j0.a.f34217m)) {
            p(false);
            return true;
        }
        if (str.startsWith("http://") || str.startsWith("https://")) {
            this.f13884f.f(str);
            return true;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            this.f13858a.startActivity(intent);
            return true;
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.g(com.alipay.sdk.app.statistic.c.f13638l, th);
            return true;
        }
    }

    @Override // com.alipay.sdk.widget.WebViewWindow.c
    public void d(WebViewWindow webViewWindow) {
        webViewWindow.getWebView().reload();
        webViewWindow.getRefreshButton().setVisibility(4);
    }

    @Override // com.alipay.sdk.widget.WebViewWindow.a
    public void e(WebViewWindow webViewWindow, String str) {
        if (str.startsWith(com.haier.uhome.usdk.base.a.av) || webViewWindow.getUrl().endsWith(str)) {
            return;
        }
        this.f13884f.getTitle().setText(str);
    }

    @Override // com.alipay.sdk.widget.WebViewWindow.b
    public boolean f(WebViewWindow webViewWindow, int i7, String str, String str2) {
        com.alipay.sdk.app.statistic.a.d("net", com.alipay.sdk.app.statistic.c.B, "onReceivedError:" + str2);
        webViewWindow.getRefreshButton().setVisibility(0);
        return false;
    }

    @Override // com.alipay.sdk.widget.WebViewWindow.b
    public boolean g(WebViewWindow webViewWindow, String str) {
        webViewWindow.f("javascript:window.prompt('<head>'+document.getElementsByTagName('html')[0].innerHTML+'</head>');(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n;window.AlipayJSBridge.callListener('h5PageFinished');");
        webViewWindow.getRefreshButton().setVisibility(0);
        return true;
    }

    @Override // com.alipay.sdk.widget.WebViewWindow.c
    public void h(WebViewWindow webViewWindow) {
        v();
    }

    @Override // com.alipay.sdk.widget.g
    public void i() {
        this.f13884f.c();
        this.f13885g.d();
    }

    @Override // com.alipay.sdk.widget.g
    public void j(String str) {
        if (Const.HTTP_REQUEST_TYPE_POST.equals(this.f13881c)) {
            this.f13884f.g(str, null);
        } else {
            this.f13884f.f(str);
        }
    }

    @Override // com.alipay.sdk.widget.g
    public boolean l() {
        if (this.f13882d) {
            return true;
        }
        v();
        return true;
    }

    public void o(String str, String str2, boolean z7) {
        this.f13881c = str2;
        this.f13884f.getTitle().setText(str);
        this.f13880b = z7;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f13882d) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
