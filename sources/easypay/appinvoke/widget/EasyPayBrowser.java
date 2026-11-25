package easypay.appinvoke.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import easypay.appinvoke.manager.Constants;
import easypay.appinvoke.manager.EasypayWebViewClient;
import v4.a;

/* JADX INFO: loaded from: classes2.dex */
public class EasyPayBrowser extends WebView {
    public EasyPayBrowser(Context context) {
        super(context);
    }

    public void a(Object obj) {
        addJavascriptInterface(obj, Constants.JsString);
    }

    @Override // android.webkit.WebView
    @SuppressLint({"JavascriptInterface"})
    public void addJavascriptInterface(Object obj, String str) throws IllegalArgumentException {
        if (!str.equals(Constants.JsString)) {
            throw new IllegalArgumentException("Cannot use String other than JsString");
        }
        super.addJavascriptInterface(obj, str);
    }

    @Override // android.webkit.WebView
    public void removeJavascriptInterface(String str) {
        if (!str.equals(Constants.JsString)) {
            throw new IllegalArgumentException("Cannot use String other than JsString");
        }
        super.removeJavascriptInterface(str);
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) throws IllegalArgumentException {
        if (!(webChromeClient instanceof a)) {
            throw new IllegalArgumentException("WebviewClient doesn't extends from EasypayWebChromeClient");
        }
        super.setWebChromeClient(webChromeClient);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) throws IllegalArgumentException {
        if (!(webViewClient instanceof EasypayWebViewClient)) {
            throw new IllegalArgumentException("WebViewClient doesn't extends from EasyPayWebViewClient");
        }
        super.setWebViewClient(webViewClient);
    }

    public EasyPayBrowser(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
