package easypay.appinvoke.actions;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.haier.uhome.mesh.bridge.RtkCoreMeshWrapper;
import easypay.appinvoke.manager.Constants;
import easypay.appinvoke.manager.EasypayWebViewClient;
import easypay.appinvoke.manager.PaytmAssist;
import easypay.appinvoke.widget.OtpEditText;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import paytm.assist.easypay.easypay.appinvoke.R;

/* JADX INFO: loaded from: classes2.dex */
public class d implements x4.f, x4.e, TextWatcher, x4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private EasypayWebViewClient f33727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Activity f33728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WebView f33729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private EasypayBrowserFragment f33730d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private GAEventManager f33732f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f33733g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f33734h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private w4.g f33737k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f33738l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f33740n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f33741o;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HashMap<String, w4.g> f33731e = new HashMap<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f33735i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final BroadcastReceiver f33736j = new a();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f33739m = false;

    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                easypay.appinvoke.utils.b.a("Otp message received", this);
                if (intent != null) {
                    if (intent.getAction() != null) {
                        d.this.f33738l = true;
                    }
                    if (intent.getAction() == null || !intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
                        return;
                    }
                    String str = "";
                    for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                        String displayOriginatingAddress = smsMessage.getDisplayOriginatingAddress();
                        str = str + smsMessage.getMessageBody();
                        easypay.appinvoke.utils.b.a("Calling checkSms from broadcast receiver", this);
                        d.this.x(str, displayOriginatingAddress);
                    }
                }
            } catch (Exception e8) {
                e8.printStackTrace();
                easypay.appinvoke.utils.b.a("EXCEPTION", e8);
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f33743a;

        b(String str) {
            this.f33743a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f33730d == null || !d.this.f33730d.isResumed()) {
                return;
            }
            easypay.appinvoke.utils.b.a("Show Log Called :Minimizing Assist:Reason = " + this.f33743a, this);
            d.this.f33730d.y0();
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f33745a;

        c(int i7) {
            this.f33745a = i7;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                easypay.appinvoke.utils.b.a("insideSuccessEvent : Event value passed = " + this.f33745a, this);
                d.this.v();
                if (androidx.core.content.d.a(d.this.f33728b, "android.permission.READ_SMS") == 0) {
                    if (d.this.f33731e.get(Constants.READ_OTP) == null) {
                        easypay.appinvoke.utils.b.a("Reading existing messages.", this);
                        if (!d.this.f33741o) {
                            d dVar = d.this;
                            dVar.w(dVar.f33728b);
                        }
                    } else {
                        easypay.appinvoke.utils.b.a("Reading current message.", this);
                        d.this.A(Constants.READ_OTP);
                    }
                }
                d.this.A(Constants.SUBMIT_BTN);
                d.this.A(Constants.FILLER_FROM_CODE);
                d.this.A(Constants.RESEND_BTN);
            } catch (Exception e8) {
                easypay.appinvoke.utils.b.a("Any Exception in OTP Flow" + e8.getMessage(), this);
                e8.printStackTrace();
                easypay.appinvoke.utils.b.a("EXCEPTION", e8);
            }
        }
    }

    /* JADX INFO: renamed from: easypay.appinvoke.actions.d$d, reason: collision with other inner class name */
    class C0410d implements ValueCallback<String> {
        C0410d() {
        }

        @Override // android.webkit.ValueCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
        }
    }

    class e implements Runnable {

        class a implements Runnable {

            /* JADX INFO: renamed from: easypay.appinvoke.actions.d$e$a$a, reason: collision with other inner class name */
            class RunnableC0411a implements Runnable {
                RunnableC0411a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.f33728b != null) {
                        easypay.appinvoke.utils.b.a("About to fire OTP not detcted ", this);
                        if (d.this.f33728b.isFinishing() || !d.this.f33730d.isAdded() || d.this.f33738l) {
                            return;
                        }
                        easypay.appinvoke.utils.b.a("OTP not detcted ", this);
                        d.this.E();
                    }
                }
            }

            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f33728b != null) {
                    d.this.f33728b.runOnUiThread(new RunnableC0411a());
                }
            }
        }

        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (d.this.f33730d == null || !d.this.f33730d.isAdded()) {
                    return;
                }
                easypay.appinvoke.utils.b.a("Activating otphelper", this);
                d.this.f33730d.C0(d.this.f33728b.getString(R.string.waiting_for_otp_label, PaytmAssist.getAssistInstance().geTxnBank()));
                d.this.f33730d.M0(R.id.otpHelper, Boolean.TRUE);
                new Handler().postDelayed(new a(), RtkCoreMeshWrapper.RTK_PROV_CONNECT_TIMEOUT);
            } catch (Exception e8) {
                e8.printStackTrace();
                easypay.appinvoke.utils.b.a("EXCEPTION", e8);
            }
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
            try {
                d.this.f33730d.C0(d.this.f33728b.getString(R.string.otp_detected));
                d.this.f33734h = true;
                if (d.this.f33730d.M0 != null) {
                    d.this.f33730d.M0.setText(d.this.f33733g);
                    if (d.this.f33732f != null) {
                        d.this.f33732f.k(true);
                    }
                }
                d.this.f33730d.E0(d.this.f33740n);
            } catch (Exception e8) {
                e8.printStackTrace();
                easypay.appinvoke.utils.b.a("EXCEPTION", e8);
            }
        }
    }

    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            EasypayWebViewClient.smsTrackingTime = System.currentTimeMillis();
            d.this.f33730d.Y();
            d.this.f33730d.M0(R.id.otpHelper, Boolean.FALSE);
        }
    }

    d(Activity activity, WebView webView, EasypayBrowserFragment easypayBrowserFragment, EasypayWebViewClient easypayWebViewClient) {
        if (activity != null) {
            try {
                this.f33728b = activity;
                this.f33730d = easypayBrowserFragment;
                this.f33729c = webView;
                if (easypayWebViewClient == null) {
                    this.f33727a = PaytmAssist.getAssistInstance().getWebClientInstance();
                } else {
                    this.f33727a = easypayWebViewClient;
                }
                PaytmAssist.getAssistInstance().getEasyPayHelper().addJsCallListener(this);
                this.f33732f = PaytmAssist.getAssistInstance().getmAnalyticsManager();
                PaytmAssist.getAssistInstance().registerSMSCallBack(this);
            } catch (Exception e8) {
                e8.printStackTrace();
                easypay.appinvoke.utils.b.a("EXCEPTION", e8);
            }
            EasypayWebViewClient easypayWebViewClient2 = this.f33727a;
            if (easypayWebViewClient2 != null) {
                easypayWebViewClient2.addAssistWebClientListener(this);
            }
        }
    }

    private void B() {
        try {
            easypay.appinvoke.utils.b.a("After Sms :fill otp on assist:isAssistVisible" + this.f33730d.f33632w, this);
            if (this.f33728b != null && this.f33730d.isAdded() && this.f33730d.f33632w) {
                this.f33728b.runOnUiThread(new g());
            } else {
                GAEventManager gAEventManager = this.f33732f;
                if (gAEventManager != null) {
                    gAEventManager.k(false);
                }
            }
        } catch (Exception e8) {
            e8.printStackTrace();
            easypay.appinvoke.utils.b.a("EXCEPTION", e8);
        }
    }

    private void C(String str, String str2, String str3) {
        easypay.appinvoke.utils.b.a("Filler from Code " + str3, this);
        String strReplace = str2.replace(str, str3);
        easypay.appinvoke.utils.b.a("Filler from Code " + strReplace, this);
        WebView webView = this.f33729c;
        if (webView != null) {
            webView.loadUrl(strReplace);
        }
    }

    private void D(String str) {
        JSONObject jSONObject;
        OtpEditText otpEditText = this.f33730d.M0;
        if ((otpEditText != null ? otpEditText.getTag() : null) != null) {
            w4.g gVar = (w4.g) this.f33730d.M0.getTag();
            try {
                jSONObject = new JSONObject(gVar.a());
            } catch (JSONException e8) {
                e8.printStackTrace();
                easypay.appinvoke.utils.b.a("EXCEPTION", e8);
                jSONObject = null;
            }
            C(((w4.b) new com.google.gson.f().n(jSONObject != null ? jSONObject.toString() : null, w4.b.class)).b(), gVar.c(), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        try {
            EasypayBrowserFragment easypayBrowserFragment = this.f33730d;
            if (easypayBrowserFragment != null && easypayBrowserFragment.isVisible() && this.f33730d.isAdded() && this.f33730d.getUserVisibleHint()) {
                this.f33730d.C0(this.f33728b.getString(R.string.otp_could_not_detcted));
                GAEventManager gAEventManager = this.f33732f;
                if (gAEventManager != null) {
                    gAEventManager.O(false);
                }
                this.f33730d.s0();
            }
        } catch (Exception e8) {
            e8.printStackTrace();
            easypay.appinvoke.utils.b.a("EXCEPTION", e8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            try {
                Object[] objArr = (Object[]) extras.get("pdus");
                SmsMessage[] smsMessageArr = objArr != null ? new SmsMessage[objArr.length] : null;
                if (smsMessageArr != null) {
                    for (int i7 = 0; i7 < smsMessageArr.length; i7++) {
                        SmsMessage smsMessageCreateFromPdu = SmsMessage.createFromPdu((byte[]) objArr[i7]);
                        smsMessageArr[i7] = smsMessageCreateFromPdu;
                        x(smsMessageArr[i7].getMessageBody(), smsMessageCreateFromPdu.getOriginatingAddress());
                    }
                }
            } catch (Exception e8) {
                e8.printStackTrace();
                easypay.appinvoke.utils.b.a("EXCEPTION", e8);
            }
        }
    }

    private boolean G() {
        return androidx.core.content.d.a(this.f33728b, "android.permission.READ_SMS") == 0 && androidx.core.content.d.a(this.f33728b, "android.permission.RECEIVE_SMS") == 0;
    }

    private void I() {
        try {
            if (androidx.core.app.b.M(this.f33728b, "android.permission.READ_SMS")) {
                return;
            }
            androidx.core.app.b.G(this.f33728b, new String[]{"android.permission.READ_SMS", "android.permission.RECEIVE_SMS"}, 102);
        } catch (Exception unused) {
        }
    }

    private void K(w4.g gVar) {
        try {
            EasypayBrowserFragment easypayBrowserFragment = this.f33730d;
            if (easypayBrowserFragment != null && easypayBrowserFragment.isVisible() && this.f33730d.isAdded()) {
                this.f33737k = gVar;
                if (this.f33730d.M0 != null) {
                    easypay.appinvoke.utils.b.a("Text Watcher", this);
                    this.f33730d.M0.addTextChangedListener(this);
                    this.f33730d.M0.setTag(gVar);
                }
            }
        } catch (Exception e8) {
            e8.printStackTrace();
            easypay.appinvoke.utils.b.a("EXCEPTION", e8);
        }
    }

    private void L(String str) {
        try {
            Activity activity = this.f33728b;
            if (activity != null) {
                activity.runOnUiThread(new b(str));
            }
        } catch (Exception e8) {
            e8.printStackTrace();
            easypay.appinvoke.utils.b.a("EXCEPTION", e8);
        }
    }

    private void M() {
        if (PaytmAssist.isEasyPayEnabled) {
            if (!G()) {
                I();
            }
            this.f33728b.registerReceiver(this.f33736j, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
        }
    }

    private void O(int i7) {
        this.f33728b.runOnUiThread(new c(i7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        try {
            Activity activity = this.f33728b;
            if (activity != null) {
                activity.runOnUiThread(new e());
            }
        } catch (Exception e8) {
            e8.printStackTrace();
            easypay.appinvoke.utils.b.a("EXCEPTION", e8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(Activity activity) {
        if (activity == null) {
            easypay.appinvoke.utils.b.a("activity is null", this);
            return;
        }
        try {
            Cursor cursorQuery = activity.getContentResolver().query(Telephony.Sms.Inbox.CONTENT_URI, null, "date>=?", new String[]{EasypayWebViewClient.smsTrackingTime + ""}, null);
            if (cursorQuery != null) {
                while (cursorQuery.moveToNext()) {
                    x(cursorQuery.getString(cursorQuery.getColumnIndex(com.paytm.pgsdk.d.V)), cursorQuery.getString(cursorQuery.getColumnIndex("address")));
                }
            } else {
                easypay.appinvoke.utils.b.a("cursor is null", this);
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (NullPointerException e8) {
            e8.printStackTrace();
            easypay.appinvoke.utils.b.a("EXCEPTION", e8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, String str2) {
        this.f33735i++;
        easypay.appinvoke.utils.b.a("Check sms called: " + this.f33735i + " time", this);
        easypay.appinvoke.utils.b.a("Message received: " + str + "\n From:" + str2, this);
        Matcher matcher = Pattern.compile("\\d{6}").matcher(str);
        if (!matcher.find()) {
            GAEventManager gAEventManager = this.f33732f;
            if (gAEventManager != null) {
                gAEventManager.b(false);
                return;
            }
            return;
        }
        Matcher matcher2 = Pattern.compile("\\d{6}").matcher(matcher.group(0));
        if (!matcher2.find()) {
            E();
            return;
        }
        String strGroup = matcher2.group(0);
        this.f33733g = strGroup;
        if (this.f33739m) {
            D(strGroup);
        }
        easypay.appinvoke.utils.b.a("OTP found: " + this.f33733g, this);
        this.f33738l = true;
        GAEventManager gAEventManager2 = this.f33732f;
        if (gAEventManager2 != null) {
            gAEventManager2.b(true);
            this.f33732f.O(true);
        }
        B();
    }

    void A(String str) {
        w4.g gVar = this.f33731e.get(str);
        if (gVar == null || TextUtils.isEmpty(gVar.a())) {
            return;
        }
        str.hashCode();
        if (str.equals(Constants.READ_OTP)) {
            w(this.f33728b);
            return;
        }
        if (str.equals(Constants.FILLER_FROM_WEB)) {
            easypay.appinvoke.utils.b.a("New otphelper:FILLER_FROM_WEB", this);
            String strC = gVar.c();
            if (this.f33729c == null || TextUtils.isEmpty(strC)) {
                return;
            }
            this.f33729c.evaluateJavascript(strC, new C0410d());
        }
    }

    void H(String str) {
        EasypayBrowserFragment easypayBrowserFragment;
        if (this.f33728b == null || (easypayBrowserFragment = this.f33730d) == null || !easypayBrowserFragment.isAdded()) {
            return;
        }
        this.f33733g = str;
    }

    public void J(HashMap<String, w4.g> map) {
        this.f33731e = map;
        M();
        K(this.f33731e.get(Constants.FILLER_FROM_CODE));
    }

    void N(w4.g gVar) {
        if (PaytmAssist.getAssistInstance().isFragmentPaused() || this.f33730d.f33630u) {
            return;
        }
        try {
            if (gVar == null) {
                GAEventManager gAEventManager = this.f33732f;
                if (gAEventManager != null) {
                    gAEventManager.i(false);
                    return;
                }
                return;
            }
            String strC = gVar.c();
            GAEventManager gAEventManager2 = this.f33732f;
            if (gAEventManager2 != null) {
                gAEventManager2.i(true);
            }
            this.f33729c.evaluateJavascript(strC, new f());
            this.f33741o = true;
        } catch (Exception e8) {
            e8.printStackTrace();
            easypay.appinvoke.utils.b.a("EXCEPTION", e8);
        }
    }

    void P() {
        Activity activity = this.f33728b;
        if (activity != null) {
            activity.unregisterReceiver(this.f33736j);
        }
    }

    @Override // x4.e
    public void a(String str, String str2, int i7) {
        if (i7 == 300) {
            try {
                this.f33740n = true;
            } catch (Exception e8) {
                e8.printStackTrace();
                easypay.appinvoke.utils.b.a("EXCEPTION", e8);
            }
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        JSONObject jSONObject;
        GAEventManager gAEventManager;
        OtpEditText otpEditText;
        GAEventManager gAEventManager2;
        if (this.f33737k != null) {
            try {
                String string = editable.toString();
                easypay.appinvoke.utils.b.a("Text Change:" + string, this);
                try {
                    if (string.length() > 5) {
                        if (!this.f33734h && (gAEventManager2 = this.f33732f) != null) {
                            gAEventManager2.t(true);
                        }
                        if (this.f33734h && (otpEditText = this.f33730d.M0) != null) {
                            otpEditText.setTypeface(null, 1);
                        }
                        if (!this.f33734h && (gAEventManager = this.f33732f) != null) {
                            gAEventManager.t(true);
                        }
                    } else {
                        OtpEditText otpEditText2 = this.f33730d.M0;
                        if (otpEditText2 != null) {
                            otpEditText2.setTypeface(null, 0);
                        }
                    }
                    OtpEditText otpEditText3 = this.f33730d.M0;
                    if (otpEditText3 != null) {
                        w4.g gVar = (w4.g) otpEditText3.getTag();
                        try {
                            jSONObject = new JSONObject(gVar.a());
                        } catch (JSONException e8) {
                            e8.printStackTrace();
                            jSONObject = null;
                        }
                        C(((w4.b) new com.google.gson.f().n(jSONObject != null ? jSONObject.toString() : null, w4.b.class)).b(), gVar.c(), string);
                        return;
                    }
                    return;
                } catch (NullPointerException e9) {
                    e9.printStackTrace();
                    return;
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            e10.printStackTrace();
        }
    }

    @Override // x4.e
    public void b(String str, String str2, int i7) {
        try {
            if (i7 == 158) {
                EasypayBrowserFragment easypayBrowserFragment = this.f33730d;
                if (easypayBrowserFragment != null) {
                    easypayBrowserFragment.Y();
                }
            } else if (i7 == 201) {
                this.f33739m = true;
            } else if (i7 == 221) {
                EasypayBrowserFragment easypayBrowserFragment2 = this.f33730d;
                if (easypayBrowserFragment2 != null) {
                    easypayBrowserFragment2.o0();
                }
            } else if (i7 != 222) {
                switch (i7) {
                    case Constants.OTP_FILLER_WEB_SUCCESS /* 107 */:
                        easypay.appinvoke.utils.b.a("Success Event called", this);
                        O(i7);
                        break;
                    case 108:
                        H(str2);
                        break;
                    case 109:
                        L(str2);
                        break;
                    default:
                        return;
                }
            } else {
                EasypayBrowserFragment easypayBrowserFragment3 = this.f33730d;
                if (easypayBrowserFragment3 != null) {
                    easypayBrowserFragment3.n0();
                }
            }
        } catch (Exception e8) {
            e8.printStackTrace();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
    }

    @Override // x4.f
    public void j(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
    }

    @Override // x4.f
    public void k(WebView webView, String str, Bitmap bitmap) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
    }

    @Override // x4.b
    public void p(String str) {
        x(str, "na");
    }

    @Override // x4.f
    public void r(WebView webView, String str) {
    }

    @Override // x4.f
    public void y(WebView webView, String str) {
        try {
            if (this.f33728b == null || this.f33730d == null || !str.contains("transactionStatus")) {
                return;
            }
            this.f33728b.runOnUiThread(new h());
        } catch (Exception e8) {
            easypay.appinvoke.utils.b.a("EXCEPTION", e8);
        }
    }

    @Override // x4.f
    public boolean z(WebView webView, Object obj) {
        return false;
    }
}
