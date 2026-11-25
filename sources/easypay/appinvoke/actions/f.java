package easypay.appinvoke.actions;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.webkit.WebView;
import android.widget.EditText;
import com.facebook.GraphRequest;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextWatcher f33797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Activity f33798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WebView f33799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private EasypayBrowserFragment f33800d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, String> f33801e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f33802f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private EditText f33807k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f33808l;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f33803g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Boolean f33804h = Boolean.FALSE;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f33805i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f33806j = "";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    BroadcastReceiver f33809m = new a();

    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle extras = intent.getExtras();
            String string = extras.getString("eventName");
            string.hashCode();
            switch (string) {
                case "activatePasswordHelper":
                    f.this.g(extras.getString("data0"));
                    f.this.f33800d.logEvent("activated", (String) f.this.f33801e.get("id"));
                    break;
                case "togglePassword":
                    f.this.m();
                    f.this.f33800d.logEvent("togglePassword", (String) f.this.f33801e.get("id"));
                    break;
                case "submitPassword":
                    f.this.l();
                    break;
            }
        }
    }

    class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            f.this.f33803g = "";
            String str = f.this.f33802f + "if(fields.length){fields[0].value='';};";
            f.this.f33799c.loadUrl((("javascript:" + ((String) f.this.f33801e.get("functionStart"))) + str) + ((String) f.this.f33801e.get("functionEnd")));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        }
    }

    public f(Activity activity, WebView webView, EasypayBrowserFragment easypayBrowserFragment, Map<String, String> map, String str) {
        this.f33798b = activity;
        this.f33800d = easypayBrowserFragment;
        this.f33801e = map;
        this.f33799c = webView;
        this.f33808l = str;
        this.f33798b.registerReceiver(this.f33809m, new IntentFilter("com.paytm.com.paytm.pgsdk.easypay.appinvoke.CUSTOM_EVENT"));
        this.f33802f = this.f33801e.get(GraphRequest.FIELDS_PARAM);
        webView.loadUrl("javascript:" + this.f33801e.get("functionStart") + this.f33802f + (this.f33802f + "var a=fields; for(var i=0;i<a.length;i++){if(a[i].type=='password'){a[i].blur();Android.showLog(\"input type is password\");a[i].addEventListener('input', function(e){Android.logTempData(this.value)}); a[i].addEventListener('focus', function(){Android.sendEvent('activatePasswordHelper', true, 0);Android.logTempData(this.value);});}}") + this.f33801e.get("functionEnd"));
        b bVar = new b();
        this.f33797a = bVar;
        this.f33807k.addTextChangedListener(bVar);
    }

    private void k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.f33799c.loadUrl("javascript:" + (("(function(){l=document.getElementsByName('" + this.f33808l) + "');e=document.createEvent('HTMLEvents');e.initEvent('click',true,true);l[0].dispatchEvent(e);})()"));
        g(com.paytm.pgsdk.d.G);
    }

    public void g(String str) {
    }

    public void h(String str) {
        this.f33803g = str;
        j();
    }

    public void i() {
        try {
            BroadcastReceiver broadcastReceiver = this.f33809m;
            if (broadcastReceiver != null) {
                this.f33798b.unregisterReceiver(broadcastReceiver);
            }
        } catch (Exception e8) {
            e8.printStackTrace();
        }
        this.f33807k.setText("");
    }

    public void j() {
        if (!this.f33804h.booleanValue()) {
            this.f33807k.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.f33806j = "Show";
        } else {
            this.f33807k.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this.f33805i = this.f33803g;
            this.f33806j = "Hide";
        }
    }

    public void m() {
        this.f33804h = Boolean.valueOf(!this.f33804h.booleanValue());
        j();
    }

    public void n() {
        BroadcastReceiver broadcastReceiver;
        Activity activity = this.f33798b;
        if (activity == null || (broadcastReceiver = this.f33809m) == null) {
            return;
        }
        activity.unregisterReceiver(broadcastReceiver);
    }
}
