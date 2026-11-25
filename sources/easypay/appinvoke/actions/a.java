package easypay.appinvoke.actions;

import android.app.Activity;
import android.webkit.WebView;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Activity f33650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    WebView f33651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    EasypayBrowserFragment f33652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Map<String, String> f33653d;

    public a(Activity activity, WebView webView, EasypayBrowserFragment easypayBrowserFragment, Map<String, String> map) {
        this.f33650a = activity;
        this.f33652c = easypayBrowserFragment;
        this.f33653d = map;
        this.f33651b = webView;
        this.f33651b.loadUrl("javascript:" + this.f33653d.get("functionStart") + this.f33653d.get("functionEnd"));
    }
}
