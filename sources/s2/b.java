package s2;

import android.webkit.WebView;
import com.google.gson.f;
import com.haier.globalwasher.modle.js_api.d;
import com.haier.globalwasher.mvp_api.moudle.BaseBeen;

/* JADX INFO: loaded from: classes2.dex */
public class b extends d {
    public b(WebView webView, String str) {
        super(webView, str);
    }

    public void c() {
        BaseBeen baseBeen = new BaseBeen();
        o2.a aVar = o2.a.LOGIN_CANCEL;
        baseBeen.setRetCode(aVar.b());
        baseBeen.setRetInfo(aVar.c());
        a(this.f24505b, new f().z(baseBeen));
    }

    public void d(String str) {
        a(this.f24505b, str);
    }
}
