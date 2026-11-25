package easypay.appinvoke.actions;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.GraphRequest;
import easypay.appinvoke.manager.Constants;
import easypay.appinvoke.manager.EasypayWebViewClient;
import easypay.appinvoke.manager.PaytmAssist;
import java.util.HashMap;
import java.util.Map;
import paytm.assist.easypay.easypay.appinvoke.R;

/* JADX INFO: loaded from: classes2.dex */
public class c implements x4.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f33684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    EasypayWebViewClient f33685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f33686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CheckBox f33687d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private EditText f33688e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Button f33689f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextView f33690g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextWatcher f33691h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Activity f33692i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private WebView f33693j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private EasypayBrowserFragment f33694k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Map<String, String> f33695l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f33696m;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private EditText f33701r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f33702s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f33703t;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f33697n = "";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Boolean f33698o = Boolean.FALSE;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f33699p = "";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f33700q = "";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    BroadcastReceiver f33704u = new i();

    class a implements ValueCallback<String> {
        a() {
        }

        @Override // android.webkit.ValueCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
        }
    }

    class b implements ValueCallback<String> {
        b() {
        }

        @Override // android.webkit.ValueCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
        }
    }

    /* JADX INFO: renamed from: easypay.appinvoke.actions.c$c, reason: collision with other inner class name */
    class C0409c implements ValueCallback<String> {
        C0409c() {
        }

        @Override // android.webkit.ValueCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
        }
    }

    class d implements ValueCallback<String> {
        d() {
        }

        @Override // android.webkit.ValueCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
        }
    }

    class e extends com.google.gson.reflect.a<HashMap<String, String>> {
        e() {
        }
    }

    class f implements ValueCallback<String> {
        f() {
        }

        @Override // android.webkit.ValueCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    class h implements ValueCallback<String> {
        h() {
        }

        @Override // android.webkit.ValueCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
        }
    }

    class i extends BroadcastReceiver {
        i() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String string;
            Bundle extras = intent.getExtras();
            if (extras == null || (string = extras.getString("eventName")) == null) {
                return;
            }
            switch (string) {
                case "activatePasswordHelper":
                    c.this.o(extras.getString("data0"));
                    c.this.f33694k.logEvent("activated", (String) c.this.f33695l.get("id"));
                    break;
                case "nbLoginSubmit":
                    c.this.B();
                    c cVar = c.this;
                    cVar.a((String) cVar.f33695l.get("submitLogin"), "submitLogin");
                    break;
                case "activateNetBankingHelper":
                    c.this.o(extras.getString("data0"));
                    c.this.f33694k.logEvent("activated", (String) c.this.f33695l.get("id"));
                    break;
                case "confirmhelper":
                    c.this.s();
                    break;
                case "nbConfirmSubmit":
                    c.this.q();
                    break;
                case "userIdInputHelper":
                    c.this.f33694k.logEvent("negtbanking userid", (String) c.this.f33695l.get("id"));
                    break;
                case "submitPassword":
                    c.this.F();
                    break;
            }
        }
    }

    class j implements Runnable {

        class a implements ValueCallback<String> {
            a() {
            }

            @Override // android.webkit.ValueCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(String str) {
            }
        }

        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f33693j.evaluateJavascript(c.this.f33686c, new a());
        }
    }

    class k implements TextWatcher {
        k() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        }
    }

    class l implements Runnable {

        class a implements ValueCallback<String> {
            a() {
            }

            @Override // android.webkit.ValueCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(String str) {
            }
        }

        l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f33693j.evaluateJavascript("javascript:(function() { try {" + ((String) c.this.f33695l.get("confirmJs")) + "}catch(e){Android.showLog('net banking confirm page error');}}());", new a());
        }
    }

    class m implements TextWatcher {
        m() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        }
    }

    class n implements ValueCallback<String> {
        n() {
        }

        @Override // android.webkit.ValueCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
        }
    }

    class o implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f33721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f33722b;

        class a implements ValueCallback<String> {
            a() {
            }

            @Override // android.webkit.ValueCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(String str) {
            }
        }

        o(int i7, String str) {
            this.f33721a = i7;
            this.f33722b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String strSubstring = c.this.f33693j.getUrl().substring(0, this.f33721a);
            StringBuilder sb = new StringBuilder();
            sb.append("javascript:");
            sb.append("(function() { try {");
            if (((String) c.this.f33695l.get("selectorType")).equals("name")) {
                sb.append("var x=document.getElementsByName('");
            } else if (((String) c.this.f33695l.get("selectorType")).equals("id")) {
                sb.append("var x=document.getElementById('");
            }
            if (TextUtils.isEmpty((CharSequence) c.this.f33695l.get("nextelement"))) {
                sb.append((String) c.this.f33695l.get("selector"));
            } else {
                sb.append((String) c.this.f33695l.get("nextelement"));
            }
            sb.append("');");
            sb.append("if(");
            sb.append("x");
            sb.append("!=null)");
            sb.append("{Android.NbWatcher(1,2)}");
            sb.append("else{Android.NbWatcher(1,4)}");
            sb.append("}catch(e){Android.showLog('not found -Net Banking js Injection');}}());");
            c.this.f33693j.evaluateJavascript(sb.toString(), new a());
            if (strSubstring.equals(this.f33722b)) {
                return;
            }
            c.this.f33694k.M0(R.id.layout_netbanking, Boolean.FALSE);
        }
    }

    class p implements Runnable {
        p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                c.this.f33694k.M0(R.id.layout_netbanking, Boolean.TRUE);
                PaytmAssist.getAssistInstance().getmAnalyticsManager().H(true);
                PaytmAssist.getAssistInstance().getmAnalyticsManager().d(c.this.f33693j.getUrl());
                c.this.G();
                c cVar = c.this;
                cVar.p((String) cVar.f33695l.get("userNameInject"));
                c.this.v();
                c cVar2 = c.this;
                cVar2.a((String) cVar2.f33695l.get("userInputjs"), (String) c.this.f33695l.get("passwordInputJs"));
            } catch (Exception e8) {
                e8.printStackTrace();
                easypay.appinvoke.utils.b.a("EXCEPTION", e8);
            }
        }
    }

    class q implements Runnable {
        q() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.E();
        }
    }

    public c(Activity activity, WebView webView, EasypayBrowserFragment easypayBrowserFragment, Map<String, String> map, EasypayWebViewClient easypayWebViewClient) {
        PaytmAssist.getAssistInstance().getmAnalyticsManager().h(true);
        this.f33692i = activity;
        this.f33694k = easypayBrowserFragment;
        this.f33695l = map;
        this.f33693j = webView;
        this.f33685b = PaytmAssist.getAssistInstance().getWebClientInstance();
        try {
            this.f33692i.registerReceiver(this.f33704u, new IntentFilter("com.paytm.com.paytm.pgsdk.easypay.appinvoke.CUSTOM_EVENT"));
        } catch (Exception e8) {
            e8.printStackTrace();
            easypay.appinvoke.utils.b.a("EXCEPTION", e8);
        }
        this.f33686c = "javascript:";
        if (easypayWebViewClient != null) {
            easypayWebViewClient.addAssistWebClientListener(this);
        }
        try {
            this.f33696m = this.f33695l.get(GraphRequest.FIELDS_PARAM);
            CheckBox checkBox = (CheckBox) this.f33692i.findViewById(R.id.cb_nb_userId);
            this.f33687d = checkBox;
            checkBox.setButtonDrawable(R.drawable.ic_checkbox_selected);
            this.f33688e = (EditText) this.f33692i.findViewById(R.id.et_nb_password);
            this.f33689f = (Button) this.f33692i.findViewById(R.id.nb_bt_submit);
            this.f33690g = (TextView) this.f33692i.findViewById(R.id.img_pwd_show);
            this.f33686c += this.f33695l.get("functionStart") + this.f33696m + "else{Android.sendEvent('activateNetBankingHelper', true, 0);}" + this.f33695l.get("functionEnd");
            this.f33693j.post(new j());
        } catch (NullPointerException unused) {
        }
        this.f33691h = new k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String B() {
        return "Android.NbWatcher(login_submkitted,check url);";
    }

    private void C() {
        String str = this.f33695l.get("url");
        new Handler().postDelayed(new o(str.length(), str), 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        this.f33693j.loadUrl("javascript:" + (("(function(){l=document.getElementsByName('" + this.f33702s) + "');e=document.createEvent('HTMLEvents');e.initEvent('click',true,true);l[0].dispatchEvent(e);})()"));
        o(com.paytm.pgsdk.d.G);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        StringBuilder sb = new StringBuilder();
        sb.append("javascript:");
        sb.append("(function() { try {");
        if (!TextUtils.isEmpty(this.f33695l.get("istabpage"))) {
            sb.append(this.f33695l.get("uwtabdetect"));
        }
        sb.append("}catch(e){Android.showLog('not found -could not inject user name');}}());");
        this.f33693j.getSettings().setDomStorageEnabled(true);
        this.f33693j.getSettings().setJavaScriptEnabled(true);
        this.f33684a = true;
        this.f33693j.evaluateJavascript(sb.toString(), new a());
        I();
    }

    private void I() {
        if (this.f33693j != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("javascript:");
            sb.append("(function() { try {");
            if (!TextUtils.isEmpty(this.f33695l.get("istabpage"))) {
                sb.append(this.f33695l.get("wtabdetect"));
            }
            sb.append("}catch(e){Android.showLog('not found -could not inject user name');}}());");
            this.f33693j.getSettings().setDomStorageEnabled(true);
            this.f33693j.getSettings().setJavaScriptEnabled(true);
            this.f33684a = true;
            this.f33693j.evaluateJavascript(sb.toString(), new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (this.f33695l.get("bank").equals("hdfc-nb")) {
            sb.append("javascript:");
            sb.append(str);
            sb.append(str2);
        } else {
            sb.append("javascript:");
            sb.append("(function() { try {");
            sb.append(str);
            sb.append(str2);
            sb.append("}catch(e){Android.showLog('not found -Net Banking js Injection');}}());");
        }
        this.f33693j.getSettings().setDomStorageEnabled(true);
        this.f33693j.getSettings().setJavaScriptEnabled(true);
        this.f33684a = true;
        this.f33693j.evaluateJavascript(sb.toString(), new n());
        if (str2.equals("submitLogin")) {
            this.f33694k.t0("", 3);
            this.f33703t = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences sharedPreferences = this.f33692i.getApplicationContext().getSharedPreferences(Constants.BANKPREF, 0);
        String str2 = "";
        if (sharedPreferences != null) {
            HashMap map = (HashMap) new com.google.gson.f().o(sharedPreferences.getString(Constants.USER_ID_NET_BANK_KEY, ""), new e().getType());
            if (map == null || !map.containsKey(this.f33695l.get("bank"))) {
                return;
            }
            str2 = "'" + ((String) map.get(this.f33695l.get("bank"))) + "'";
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f33693j.getSettings().setDomStorageEnabled(true);
        this.f33693j.getSettings().setJavaScriptEnabled(true);
        this.f33684a = true;
        this.f33693j.evaluateJavascript("javascript:(function() { try {" + str + str2 + "}catch(e){Android.showLog('not found -could not inject user name');}}());", new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        Handler handler = new Handler();
        if (TextUtils.isEmpty(this.f33695l.get("confirmJs"))) {
            return;
        }
        handler.postDelayed(new l(), 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        u();
    }

    private void t(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("javascript:");
        sb.append("(function() { try {var y=");
        if (this.f33695l.get("selectorType").equals("id")) {
            sb.append("document.getElementById('");
        } else if (this.f33695l.get("selectorType").equals("name")) {
            sb.append("document.getElementsByName('");
        }
        sb.append(str);
        sb.append("')");
        sb.append(".value;");
        sb.append("Android.NbWatcher(y,99)");
        sb.append("}catch(e){Android.showLog('not found -Net Banking js Injection');}}());");
        this.f33693j.getSettings().setDomStorageEnabled(true);
        this.f33693j.getSettings().setJavaScriptEnabled(true);
        this.f33684a = true;
        this.f33693j.evaluateJavascript(sb.toString(), new h());
    }

    private void u() {
        try {
            this.f33692i.findViewById(R.id.layout_netbanking).setVisibility(0);
            this.f33687d.setVisibility(8);
            this.f33688e.setVisibility(8);
            this.f33690g.setVisibility(8);
            this.f33689f.setVisibility(8);
        } catch (NullPointerException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        StringBuilder sb = new StringBuilder();
        sb.append("javascript:");
        sb.append("(function() { try {");
        if (!TextUtils.isEmpty(this.f33695l.get("activeInputJS"))) {
            sb.append(this.f33695l.get("activeInputJS"));
        }
        sb.append("}catch(e){Android.showLog('not found -could not inject user name');}}());");
        this.f33693j.getSettings().setDomStorageEnabled(true);
        this.f33693j.getSettings().setJavaScriptEnabled(true);
        this.f33684a = true;
        this.f33693j.evaluateJavascript(sb.toString(), new C0409c());
        w();
    }

    private void w() {
        StringBuilder sb = new StringBuilder();
        sb.append("javascript:");
        sb.append("(function() { try {");
        if (!TextUtils.isEmpty(this.f33695l.get("activepwjs"))) {
            sb.append(this.f33695l.get("activepwjs"));
        }
        sb.append("}catch(e){Android.showLog('not found -could not inject user name');}}());");
        this.f33693j.getSettings().setDomStorageEnabled(true);
        this.f33693j.getSettings().setJavaScriptEnabled(true);
        this.f33684a = true;
        this.f33693j.evaluateJavascript(sb.toString(), new d());
    }

    private void x(CheckBox checkBox) {
        if (checkBox != null) {
            checkBox.addTextChangedListener(new m());
        }
    }

    public void A(String str) {
        this.f33697n = str;
        E();
    }

    public void D() {
        try {
            BroadcastReceiver broadcastReceiver = this.f33704u;
            if (broadcastReceiver != null) {
                this.f33692i.unregisterReceiver(broadcastReceiver);
            }
        } catch (Exception e8) {
            e8.printStackTrace();
            easypay.appinvoke.utils.b.a("EXCEPTION", e8);
        }
        this.f33701r.setText("");
    }

    public void E() {
        if (this.f33698o.booleanValue()) {
            this.f33701r.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this.f33699p = this.f33697n;
            this.f33700q = "Hide";
        } else {
            this.f33701r.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.f33700q = "Show";
        }
        this.f33692i.runOnUiThread(new g());
    }

    public void H() {
        BroadcastReceiver broadcastReceiver;
        Activity activity = this.f33692i;
        if (activity == null || (broadcastReceiver = this.f33704u) == null) {
            return;
        }
        activity.unregisterReceiver(broadcastReceiver);
    }

    @Override // x4.f
    public void j(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
    }

    @Override // x4.f
    public void k(WebView webView, String str, Bitmap bitmap) {
    }

    public void o(String str) {
        if (str.equals("true")) {
            this.f33692i.runOnUiThread(new p());
        } else {
            this.f33697n = "";
            this.f33692i.runOnUiThread(new q());
        }
    }

    @Override // x4.f
    public void r(WebView webView, String str) {
    }

    @Override // x4.f
    public void y(WebView webView, String str) {
        if (this.f33703t && (TextUtils.isEmpty(this.f33695l.get("nextsburl")) || str.contains(this.f33695l.get("nextsburl")))) {
            C();
            this.f33703t = false;
        }
        if (str.contains(this.f33695l.get("url"))) {
            EasypayBrowserFragment easypayBrowserFragment = this.f33694k;
            if (easypayBrowserFragment != null) {
                easypayBrowserFragment.t0("", 4);
                return;
            }
            return;
        }
        EasypayBrowserFragment easypayBrowserFragment2 = this.f33694k;
        if (easypayBrowserFragment2 != null) {
            easypayBrowserFragment2.t0("", 3);
        }
    }

    @Override // x4.f
    public boolean z(WebView webView, Object obj) {
        return false;
    }
}
