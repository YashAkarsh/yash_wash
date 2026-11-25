package s2;

import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.google.gson.f;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.js_api.BaseJsBean;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.haier.globalwasher.modle.js_api.b {
    public a(BaseActivity baseActivity, WebView webView) {
        super(baseActivity, webView);
    }

    @JavascriptInterface
    public String getTokenId() {
        return u2.a.c();
    }

    @JavascriptInterface
    public void showLoginView(String str) {
        com.haier.globalwasher.modle.utils.login.a.a(this.f24503b, this.f24502a, ((BaseJsBean) new f().n(str, BaseJsBean.class)).getCallBackMethodName());
    }
}
