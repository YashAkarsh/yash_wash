package v4;

import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import easypay.appinvoke.actions.EasypayBrowserFragment;

/* JADX INFO: loaded from: classes2.dex */
public class a extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private EasypayBrowserFragment f40431a;

    public a(EasypayBrowserFragment easypayBrowserFragment) {
        this.f40431a = easypayBrowserFragment;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return false;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        if (!str.equals("https://secure4.arcot.com/acspage/cap?RID=40147&VAA=B")) {
            return super.onJsBeforeUnload(webView, str, str2, jsResult);
        }
        jsResult.confirm();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return false;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return false;
    }
}
