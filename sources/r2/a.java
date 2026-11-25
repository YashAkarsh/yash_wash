package r2;

import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.google.gson.f;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.js_api.b;
import com.haier.globalwasher.modle.js_api.ui.UIControlBean;
import com.haier.globalwasher.modle.utils.d0;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.view.activity.WebActivity;

/* JADX INFO: loaded from: classes2.dex */
public class a extends b {
    public a(BaseActivity baseActivity, WebView webView) {
        super(baseActivity, webView);
    }

    @JavascriptInterface
    public void closeWindow() {
        BaseActivity baseActivity = this.f24503b;
        if (!(baseActivity instanceof WebActivity) || baseActivity.isFinishing()) {
            return;
        }
        this.f24503b.finish();
    }

    @JavascriptInterface
    public void openNewWindow(String str) {
        q.c("openNewWeb", str);
        UIControlBean uIControlBean = (UIControlBean) new f().n(str, UIControlBean.class);
        q.c("openNewWeb", uIControlBean.toString());
        if (!d0.j(uIControlBean.getUrl())) {
            WebActivity.j0(this.f24503b, uIControlBean.getTitle(), uIControlBean.getUrl());
            return;
        }
        String callBackMethodName = uIControlBean.getCallBackMethodName();
        o2.a aVar = o2.a.MISS_PARAMETER;
        a(callBackMethodName, b(aVar.b(), aVar.c(), null));
    }
}
