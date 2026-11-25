package q2;

import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.js_api.b;

/* JADX INFO: loaded from: classes2.dex */
public class a extends b {
    public a(BaseActivity baseActivity, WebView webView) {
        super(baseActivity, webView);
    }

    @JavascriptInterface
    public void showShareView(String str) {
    }
}
