package easypay.appinvoke.actions;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.SmsMessage;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.GraphRequest;
import com.haier.uhome.mesh.bridge.RtkCoreMeshWrapper;
import easypay.appinvoke.manager.EasypayWebViewClient;
import easypay.appinvoke.manager.PaytmAssist;
import java.util.Map;
import java.util.Timer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import paytm.assist.easypay.easypay.appinvoke.R;

/* JADX INFO: loaded from: classes2.dex */
public class e implements x4.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f33755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Activity f33756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private WebView f33757d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private EasypayBrowserFragment f33758e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, String> f33759f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f33760g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextWatcher f33761h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private EditText f33762i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Timer f33763j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f33765l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private EditText f33766m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f33767n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private TextView f33768o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Timer f33769p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f33770q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f33771r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f33772s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Boolean f33773t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f33775v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f33777x;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Boolean f33764k = Boolean.FALSE;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f33776w = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public BroadcastReceiver f33778y = new c();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    BroadcastReceiver f33779z = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EasypayWebViewClient f33754a = PaytmAssist.getAssistInstance().getWebClientInstance();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private GAEventManager f33774u = PaytmAssist.getAssistInstance().getmAnalyticsManager();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (TextUtils.isEmpty(e.this.f33767n)) {
                    return;
                }
                e.this.f33766m.setText(e.this.f33767n);
                e.this.f33766m.setSelection(e.this.f33766m.getText().length());
            } catch (NullPointerException unused) {
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f33758e.M0(R.id.otpHelper, Boolean.FALSE);
        }
    }

    class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle extras;
            try {
                if (!intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED") || (extras = intent.getExtras()) == null) {
                    return;
                }
                Object[] objArr = (Object[]) extras.get("pdus");
                SmsMessage[] smsMessageArr = objArr != null ? new SmsMessage[objArr.length] : null;
                if (smsMessageArr != null) {
                    for (int i7 = 0; i7 < smsMessageArr.length; i7++) {
                        SmsMessage smsMessageCreateFromPdu = SmsMessage.createFromPdu((byte[]) objArr[i7]);
                        smsMessageArr[i7] = smsMessageCreateFromPdu;
                        e.this.u(smsMessageArr[i7].getMessageBody(), smsMessageCreateFromPdu.getOriginatingAddress());
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    class d extends BroadcastReceiver {
        d() {
        }

        /* JADX WARN: Code duplicated, block: B:19:0x003f  */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            byte b8;
            try {
                String string = intent.getExtras().getString("eventName");
                if (string != null) {
                    switch (string.hashCode()) {
                        case -51042937:
                            if (!string.equals("focusOtpField")) {
                                b8 = -1;
                            } else {
                                b8 = 0;
                            }
                            break;
                        case 853955742:
                            if (!string.equals("approveOtp")) {
                                b8 = -1;
                            } else {
                                b8 = 2;
                            }
                            break;
                        case 1392020230:
                            if (!string.equals("activateOtpHelper")) {
                                b8 = -1;
                            } else {
                                b8 = 1;
                            }
                            break;
                        case 2018704624:
                            if (!string.equals("resendOtp")) {
                                b8 = -1;
                            } else {
                                b8 = 3;
                            }
                            break;
                        default:
                            b8 = -1;
                            break;
                    }
                    if (b8 == 0) {
                        ((InputMethodManager) e.this.f33756c.getSystemService("input_method")).showSoftInput(e.this.f33762i, 1);
                        return;
                    }
                    if (b8 == 1) {
                        e.this.o();
                        return;
                    }
                    if (b8 == 2) {
                        e.this.p();
                    } else {
                        if (b8 != 3) {
                            return;
                        }
                        e.this.x();
                        e.this.f33758e.logEvent("resendOTP", (String) e.this.f33759f.get("id"));
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: easypay.appinvoke.actions.e$e, reason: collision with other inner class name */
    class ViewOnFocusChangeListenerC0412e implements View.OnFocusChangeListener {
        ViewOnFocusChangeListenerC0412e() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z7) {
            if (z7) {
                e.this.f33766m.setHint("");
            } else {
                e.this.f33766m.setHint("Enter OTP");
            }
        }
    }

    class f implements Runnable {

        class a implements Runnable {

            /* JADX INFO: renamed from: easypay.appinvoke.actions.e$f$a$a, reason: collision with other inner class name */
            class C0413a implements ValueCallback<String> {
                C0413a() {
                }

                @Override // android.webkit.ValueCallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onReceiveValue(String str) {
                }
            }

            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.f33757d.evaluateJavascript(e.this.f33770q, new C0413a());
            }
        }

        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f33757d.post(new a());
        }
    }

    class g implements Runnable {

        class a implements Runnable {

            /* JADX INFO: renamed from: easypay.appinvoke.actions.e$g$a$a, reason: collision with other inner class name */
            class C0414a implements ValueCallback<String> {
                C0414a() {
                }

                @Override // android.webkit.ValueCallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onReceiveValue(String str) {
                }
            }

            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.f33757d.evaluateJavascript(e.this.f33770q, new C0414a());
            }
        }

        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f33757d.post(new a());
        }
    }

    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e.this.f33758e.M0(R.id.otpHelper, Boolean.TRUE);
            } catch (Exception unused) {
            }
        }
    }

    class i implements TextWatcher {
        i() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String string = editable.toString();
            string.length();
            String str = e.this.f33760g + "if(fields.length){fields[0].value='" + string + "';};";
            e.this.f33757d.loadUrl((("javascript:" + ((String) e.this.f33759f.get("functionStart"))) + str) + ((String) e.this.f33759f.get("functionEnd")));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        }
    }

    class j implements Runnable {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.f33766m.setHint("Enter OTP");
                if (TextUtils.isEmpty(e.this.f33766m.getText())) {
                    e.this.f33768o.setText("Message not detected,Enter OTP Manually");
                }
            }
        }

        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f33756c != null) {
                e.this.f33756c.runOnUiThread(new a());
            }
        }
    }

    class k implements Runnable {

        class a implements ValueCallback<String> {
            a() {
            }

            @Override // android.webkit.ValueCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(String str) {
            }
        }

        k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String str = (String) e.this.f33759f.get("receivedOtp");
                e.this.f33777x = true;
                if (e.this.f33774u != null) {
                    e.this.f33774u.b(true);
                }
                e.this.f33768o.setText("OTP detected, press submit to continue");
                if (e.this.f33768o != null) {
                    e.this.f33766m.setText(str);
                    e.this.f33766m.setSelection(str.length());
                    e.this.f33766m.setTypeface(null, 1);
                }
                e.this.f33757d.evaluateJavascript("javascript:" + ("autoFillOtp('" + str + "');"), new a());
            } catch (NullPointerException | Exception unused) {
            }
        }
    }

    public e(Activity activity, WebView webView, EasypayBrowserFragment easypayBrowserFragment, Map<String, String> map, String str, String str2, String str3, EasypayWebViewClient easypayWebViewClient) {
        this.f33756c = activity;
        this.f33758e = easypayBrowserFragment;
        this.f33771r = str;
        this.f33772s = str3;
        this.f33759f = map;
        this.f33757d = webView;
        try {
            EditText editText = this.f33766m;
            if (editText != null) {
                editText.setOnFocusChangeListener(new ViewOnFocusChangeListenerC0412e());
                View currentFocus = this.f33758e.getActivity().getCurrentFocus();
                InputMethodManager inputMethodManager = (InputMethodManager) this.f33758e.getActivity().getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                }
            }
        } catch (NullPointerException unused) {
        }
        if (easypayWebViewClient != null) {
            easypayWebViewClient.addAssistWebClientListener(this);
        }
        try {
            this.f33756c.registerReceiver(this.f33779z, new IntentFilter("com.paytm.com.paytm.pgsdk.easypay.appinvoke.CUSTOM_EVENT"));
            this.f33765l = true;
        } catch (Exception unused2) {
        }
        if (this.f33757d != null) {
            this.f33770q = "javascript:";
            this.f33770q += " document.addEventListener(\"DOMContentLoaded\", Android.sendEvent('FIRE ELEMENT', 0, 0), false);";
            new Handler().postDelayed(new f(), 20L);
        }
    }

    private boolean B() {
        if (!PaytmAssist.isEasyPayEnabled) {
            return false;
        }
        this.f33756c.registerReceiver(this.f33778y, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
        return true;
    }

    private void q(Activity activity) {
        if (activity != null) {
            try {
                Cursor cursorQuery = activity.getContentResolver().query(Uri.parse("content://sms/inbox"), null, "date>=?", new String[]{EasypayWebViewClient.smsTrackingTime + ""}, null);
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        u(cursorQuery.getString(cursorQuery.getColumnIndex(com.paytm.pgsdk.d.V)), cursorQuery.getString(cursorQuery.getColumnIndex("address")));
                    }
                }
            } catch (NullPointerException unused) {
            }
        }
    }

    private boolean s(String str) {
        if (TextUtils.isEmpty(this.f33772s)) {
            return true;
        }
        String[] strArrSplit = this.f33772s.split(",");
        if (strArrSplit.length > 0) {
            String strReplaceAll = str.replaceAll(" ", "").replaceAll("-", "");
            for (String str2 : strArrSplit) {
                if (strReplaceAll != null && strReplaceAll.toLowerCase().contains(str2.toLowerCase())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean t(String str) {
        if (TextUtils.isEmpty(this.f33771r)) {
            return true;
        }
        String[] strArrSplit = this.f33771r.split(",");
        if (strArrSplit.length > 0) {
            for (String str2 : strArrSplit) {
                if (str != null && str.toLowerCase().contains(str2.toLowerCase())) {
                    GAEventManager gAEventManager = this.f33774u;
                    if (gAEventManager == null) {
                        return true;
                    }
                    gAEventManager.J(str2.toUpperCase());
                    return true;
                }
            }
        }
        return false;
    }

    public void A() {
        TextView textView;
        this.f33758e.M0(R.id.otpHelper, Boolean.FALSE);
        C(Boolean.TRUE);
        try {
            Activity activity = this.f33756c;
            if (activity == null || (textView = this.f33768o) == null) {
                return;
            }
            textView.setText(activity.getString(R.string.wait_otp));
        } catch (Exception e8) {
            easypay.appinvoke.utils.e.c("kanish", "exception" + e8.getStackTrace());
        }
    }

    public void C(Boolean bool) {
    }

    @Override // x4.f
    public void j(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
    }

    @Override // x4.f
    public void k(WebView webView, String str, Bitmap bitmap) {
    }

    public void o() {
        this.f33756c.runOnUiThread(new h());
        Activity activity = this.f33756c;
        if (activity == null && activity.isFinishing()) {
            return;
        }
        i iVar = new i();
        this.f33761h = iVar;
        try {
            EditText editText = this.f33766m;
            if (editText != null) {
                editText.addTextChangedListener(iVar);
                new Handler().postDelayed(new j(), RtkCoreMeshWrapper.RTK_PROV_CONNECT_TIMEOUT);
            }
            q(this.f33756c);
            if (!this.f33773t.booleanValue()) {
                this.f33773t = Boolean.valueOf(B());
            }
        } catch (Exception unused) {
        }
        this.f33764k = Boolean.TRUE;
    }

    public void p() {
        GAEventManager gAEventManager = this.f33774u;
        if (gAEventManager != null) {
            gAEventManager.i(true);
        }
        String str = "javascript:";
        if (this.f33759f.get("action").equals("otphelper")) {
            str = "javascript:Android.showLog('approve otp- '+ typeof(autoSubmitForm));autoSubmitForm();";
        } else if (this.f33759f.get("submitJs") != null) {
            str = "javascript:" + this.f33759f.get("submitJs");
            this.f33758e.f33629t = false;
        } else if (this.f33759f.get("customjs") != null) {
            str = "javascript:" + this.f33759f.get("customjs");
        }
        this.f33757d.evaluateJavascript(str, null);
        this.f33775v = !this.f33759f.get("bank").equals("sbi-nb");
    }

    @Override // x4.f
    public void r(WebView webView, String str) {
    }

    public void u(String str, String str2) {
        if (t(str2) && s(str)) {
            Pattern patternCompile = Pattern.compile("\\b\\d{6}\\b");
            Pattern patternCompile2 = Pattern.compile("\\b\\d{4}\\b");
            Pattern patternCompile3 = Pattern.compile("(|^)\\d{8}");
            Matcher matcher = patternCompile.matcher(str);
            patternCompile2.matcher(str);
            patternCompile3.matcher(str);
            if (matcher.find()) {
                Timer timer = this.f33763j;
                if (timer != null) {
                    timer.cancel();
                }
                this.f33759f.put("receivedOtp", matcher.group(0));
                this.f33756c.runOnUiThread(new k());
            }
        }
    }

    public void v() {
        this.f33755b = true;
        this.f33760g = this.f33759f.get(GraphRequest.FIELDS_PARAM);
        this.f33770q += this.f33759f.get("functionStart") + (this.f33760g + "var a = fields; if(a.length&&!(fields[0].offsetParent == null)){Android.sendEvent('activateOtpHelper', 0, 0); var aa=a; autoFillOtp=function(value){ aa[0].value = value; }; }") + "if(fields.length){ fields[0].addEventListener('input', function(e){Android.logTempData(this.value)});}" + this.f33759f.get("functionEnd");
        new Handler().postDelayed(new g(), 20L);
    }

    public void w(String str) {
        this.f33767n = str;
        this.f33756c.runOnUiThread(new a());
    }

    public void x() {
        this.f33757d.loadUrl("javascript:Android.showLog('resend otp- '+ typeof(autoResendOtp));autoResendOtp();");
        C(Boolean.TRUE);
    }

    @Override // x4.f
    public void y(WebView webView, String str) {
        easypay.appinvoke.utils.e.c("otphelper", "otp helper Wc page finish" + str);
        if (this.f33775v) {
            this.f33756c.runOnUiThread(new b());
        }
    }

    @Override // x4.f
    public boolean z(WebView webView, Object obj) {
        return false;
    }
}
