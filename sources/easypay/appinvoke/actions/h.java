package easypay.appinvoke.actions;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import com.facebook.GraphRequest;
import java.util.Map;
import paytm.assist.easypay.easypay.appinvoke.R;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Activity f33821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    WebView f33822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    EasypayBrowserFragment f33823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    CheckBox f33824d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    CheckBox f33825e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Map<String, String> f33826f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    String f33827g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    String f33830j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    String f33831k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    String f33828h = "0";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    String f33829i = "1";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    BroadcastReceiver f33832l = new a();

    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle extras = intent.getExtras();
            String string = extras.getString("eventName");
            string.hashCode();
            switch (string) {
                case "submit":
                    h.this.d();
                    break;
                case "selectRadioOption":
                    h.this.f(extras.getString("data0"));
                    break;
                case "activateRadioHelper":
                    h.this.b();
                    h hVar = h.this;
                    hVar.f33823c.logEvent("activated", hVar.f33826f.get("id"));
                    break;
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    class c extends WebViewClient {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        c() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (!TextUtils.isEmpty(h.this.f33827g) && !str.equals(h.this.f33827g)) {
                h.this.f33821a.runOnUiThread(new a());
            }
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    public h(Activity activity, WebView webView, EasypayBrowserFragment easypayBrowserFragment, Map<String, String> map) {
        this.f33821a = activity;
        this.f33823c = easypayBrowserFragment;
        this.f33826f = map;
        this.f33822b = webView;
        IntentFilter intentFilter = new IntentFilter("com.paytm.com.paytm.pgsdk.easypay.appinvoke.CUSTOM_EVENT");
        this.f33827g = webView.getUrl();
        this.f33821a.registerReceiver(this.f33832l, intentFilter);
        this.f33821a.runOnUiThread(new b());
        this.f33826f.get(GraphRequest.FIELDS_PARAM);
        easypay.appinvoke.utils.e.a("radiohelper", "inside radiohelper constructor");
        this.f33825e = (CheckBox) easypayBrowserFragment.getView().findViewById(R.id.cb_do_not_send_otp);
        this.f33824d = (CheckBox) easypayBrowserFragment.getView().findViewById(R.id.cb_send_otp);
    }

    private void c(String str) {
        this.f33822b.getSettings().setJavaScriptEnabled(true);
        this.f33822b.getSettings().setDomStorageEnabled(true);
        this.f33822b.loadUrl("javascript:(function (){(function (){return document.passwdForm.otpDestinationOption[" + str + "].checked=true ;})();return pwdBaseOtpChannelSelected(1); })();");
        this.f33822b.setWebViewClient(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.f33824d.isChecked()) {
            c("0");
        }
        if (this.f33825e.isChecked()) {
            c("1");
        }
    }

    public void b() {
    }

    public void e() {
        BroadcastReceiver broadcastReceiver;
        try {
            Activity activity = this.f33821a;
            if (activity == null || (broadcastReceiver = this.f33832l) == null) {
                return;
            }
            activity.unregisterReceiver(broadcastReceiver);
        } catch (Exception unused) {
        }
    }

    public void f(String str) {
        String str2;
        if (str.equals("1")) {
            str2 = this.f33826f.get("value1");
            this.f33823c.logEvent("selectedOption1", this.f33826f.get("id"));
        } else {
            str2 = this.f33826f.get("value2");
            this.f33823c.logEvent("selectedOption2", this.f33826f.get("id"));
        }
        this.f33822b.loadUrl("javascript:" + ("if(typeof(autoSelectRadio) != 'undefined'){autoSelectRadio('" + str2 + "');}"));
    }
}
