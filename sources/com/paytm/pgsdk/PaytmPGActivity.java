package com.paytm.pgsdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.http.SslError;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.n2;
import easypay.appinvoke.actions.EasypayBrowserFragment;
import easypay.appinvoke.manager.EasypayWebViewClient;
import easypay.appinvoke.manager.PaytmAssist;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class PaytmPGActivity extends AppCompatActivity implements x4.f, x4.b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f32928s = "Some error occured while initializing UI of Payment Gateway Activity";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final int f32929t = 101;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int f32930u = 121;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f32931v = 105;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int f32932w = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile FrameLayout f32933d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected volatile ProgressBar f32934e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile PaytmWebView f32935f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile Bundle f32936g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Dialog f32937h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f32938i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f32939j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private PaytmAssist f32940k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Activity f32941l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Context f32942m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f32943n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f32944o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private EasypayWebViewClient f32945p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private BroadcastReceiver f32946q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f32947r;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            p.a("User pressed back button which is present in Header Bar.");
            PaytmPGActivity.this.g0();
        }
    }

    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i7) {
            PaytmPGActivity.this.h0();
        }
    }

    class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i7) {
            try {
                if (PaytmPGActivity.this.f32937h == null || !PaytmPGActivity.this.f32937h.isShowing()) {
                    return;
                }
                PaytmPGActivity.this.f32937h.dismiss();
            } catch (Exception e8) {
                p.k(e8);
            }
        }
    }

    class d implements com.paytm.pgsdk.b<a4.b> {

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a4.b f32952a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ l f32953b;

            a(a4.b bVar, l lVar) {
                this.f32952a = bVar;
                this.f32953b = lVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f32953b.h(p.b(new com.google.gson.f().z(this.f32952a.a().a())));
            }
        }

        d() {
        }

        @Override // com.paytm.pgsdk.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@a7.d a4.b bVar) {
            l lVarM = j.h().m();
            try {
                if (bVar.a().a() != null) {
                    PaytmPGActivity.this.runOnUiThread(new a(bVar, lVarM));
                } else {
                    lVarM.h(null);
                }
            } catch (Exception unused) {
                lVarM.h(null);
            }
            PaytmPGActivity.this.finish();
        }

        @Override // com.paytm.pgsdk.b
        public void onError() {
            j.h().m().h(null);
            PaytmPGActivity.this.finish();
        }
    }

    class e extends BroadcastReceiver {
        e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                easypay.appinvoke.utils.b.a("Otp message received", this);
                if (intent == null || intent.getAction() == null || !intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
                    return;
                }
                String str = "";
                for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                    str = str + smsMessage.getMessageBody();
                    easypay.appinvoke.utils.b.a("Calling checkSms from broadcast receiver", this);
                    PaytmPGActivity.this.i0(PaytmPGActivity.this.m0(str));
                }
            } catch (Exception e8) {
                com.paytm.pgsdk.a.e().f(com.paytm.pgsdk.d.f33012o, e8.getMessage());
                e8.printStackTrace();
                easypay.appinvoke.utils.b.a("EXCEPTION", e8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g0() {
        p.a("Displaying Confirmation Dialog");
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.CancelDialogeTheme);
        builder.setTitle("Cancel Transaction");
        builder.setMessage("Are you sure you want to cancel transaction");
        builder.setPositiveButton("Yes", new b());
        builder.setNegativeButton("No", new c());
        AlertDialog alertDialogCreate = builder.create();
        this.f32937h = alertDialogCreate;
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0() {
        k.a().b(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(String str) {
        this.f32935f.loadUrl("javascript:if(document.getElementById('inp')){document.getElementById('inp').focus();setTimeout(function(){document.getElementById('inp').value='" + str + "'},0);}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            try {
                Object[] objArr = (Object[]) extras.get("pdus");
                SmsMessage[] smsMessageArr = objArr != null ? new SmsMessage[objArr.length] : null;
                if (smsMessageArr != null) {
                    for (int i7 = 0; i7 < smsMessageArr.length; i7++) {
                        SmsMessage smsMessageCreateFromPdu = SmsMessage.createFromPdu((byte[]) objArr[i7]);
                        smsMessageArr[i7] = smsMessageCreateFromPdu;
                        smsMessageCreateFromPdu.getOriginatingAddress();
                        i0(m0(smsMessageArr[i7].getMessageBody()));
                    }
                }
            } catch (Exception e8) {
                com.paytm.pgsdk.a.e().f(com.paytm.pgsdk.d.f33012o, e8.getMessage());
                e8.printStackTrace();
                easypay.appinvoke.utils.b.a("EXCEPTION", e8);
            }
        }
    }

    @SuppressLint({"ResourceType"})
    private synchronized boolean k0() {
        try {
            if (getIntent() != null) {
                this.f32938i = getIntent().getBooleanExtra("HIDE_HEADER", false);
                this.f32939j = getIntent().getBooleanExtra("SEND_ALL_CHECKSUM_RESPONSE_PARAMETERS_TO_PG_SERVER", false);
                this.f32943n = getIntent().getStringExtra("mid");
                this.f32944o = getIntent().getStringExtra("orderId");
                this.f32947r = getIntent().getBooleanExtra(com.paytm.pgsdk.d.f33008k, true);
                p.a("Assist Enabled");
            }
            p.a("Hide Header " + this.f32938i);
            p.a("Initializing the UI of Transaction Page...");
            RelativeLayout relativeLayout = new RelativeLayout(this);
            RelativeLayout relativeLayout2 = new RelativeLayout(this);
            relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            relativeLayout2.setId(1);
            relativeLayout2.setBackgroundColor(Color.parseColor("#bdbdbd"));
            Button button = new Button(this, null, android.R.attr.buttonStyleSmall);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(15);
            layoutParams.leftMargin = (int) (getResources().getDisplayMetrics().density * 5.0f);
            button.setOnClickListener(new a());
            button.setLayoutParams(layoutParams);
            button.setText("Cancel");
            TextView textView = new TextView(this);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13);
            textView.setLayoutParams(layoutParams2);
            textView.setTextColor(n2.f6743t);
            textView.setText("Paytm Payments");
            relativeLayout2.addView(button);
            relativeLayout2.addView(textView);
            RelativeLayout relativeLayout3 = new RelativeLayout(this);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams3.addRule(3, relativeLayout2.getId());
            relativeLayout3.setLayoutParams(layoutParams3);
            this.f32935f = new PaytmWebView(this, this.f32936g);
            this.f32940k = PaytmAssist.getAssistInstance();
            this.f32933d = new FrameLayout(this, null);
            this.f32935f.setVisibility(8);
            this.f32935f.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.f32934e = new ProgressBar(this, null, android.R.attr.progressBarStyleSmall);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(13);
            this.f32934e.setLayoutParams(layoutParams4);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams5.addRule(12);
            this.f32933d.setId(101);
            this.f32933d.setLayoutParams(layoutParams5);
            relativeLayout3.addView(this.f32935f);
            relativeLayout3.addView(this.f32933d);
            relativeLayout.addView(relativeLayout2);
            relativeLayout.addView(relativeLayout3);
            if (this.f32938i) {
                relativeLayout2.setVisibility(8);
            }
            setContentView(relativeLayout);
            o0();
            p.a("Initialized UI of Transaction Page.");
        } catch (Exception e8) {
            com.paytm.pgsdk.a.e().f(com.paytm.pgsdk.d.f33012o, e8.getMessage());
            p.a("Some exception occurred while initializing UI.");
            p.k(e8);
            return false;
        }
        return true;
    }

    private boolean l0() {
        if (getSupportFragmentManager().p0(101) != null) {
            return getSupportFragmentManager().p0(101).isAdded();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String m0(String str) {
        if (str == null || str.isEmpty()) {
            easypay.appinvoke.utils.b.a("Message received is either null or empty", this);
            return "";
        }
        Matcher matcher = Pattern.compile("\\d{6}").matcher(str);
        if (!matcher.find()) {
            return "";
        }
        Matcher matcher2 = Pattern.compile("\\d{6}").matcher(matcher.group(0));
        if (!matcher2.find()) {
            return "";
        }
        String strGroup = matcher2.group(0);
        easypay.appinvoke.utils.b.a("OTP found: " + strGroup, this);
        return strGroup;
    }

    private void n0(String str) {
        EasypayBrowserFragment easypayBrowserFragment = (EasypayBrowserFragment) getSupportFragmentManager().p0(101);
        if (easypayBrowserFragment == null || easypayBrowserFragment.e0() == null) {
            return;
        }
        PaytmAssist.getAssistInstance().registerSMSCallBack(easypayBrowserFragment.e0());
        PaytmAssist.getAssistInstance().setAppSMSCallback(str);
    }

    private void o0() {
        if (!TextUtils.isEmpty(this.f32943n) && !TextUtils.isEmpty(this.f32944o)) {
            this.f32940k.startConfigAssist(this, Boolean.valueOf(this.f32947r), Boolean.valueOf(this.f32947r), Integer.valueOf(this.f32933d.getId()), this.f32935f, this, this.f32944o, this.f32943n);
            this.f32935f.setWebCLientCallBacks();
            this.f32940k.startAssist();
        }
        EasypayWebViewClient webClientInstance = this.f32940k.getWebClientInstance();
        this.f32945p = webClientInstance;
        if (webClientInstance == null) {
            p.a("EasyPayWebView Client:mwebViewClient Null");
        } else {
            p.a("EasyPayWebView Client:mwebViewClient");
            this.f32945p.addAssistWebClientListener(this);
        }
    }

    private void p0() {
        this.f32946q = new e();
        registerReceiver(this.f32946q, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
    }

    private synchronized void q0() {
        p.a("Starting the Process...");
        this.f32941l = (Activity) this.f32942m;
        if (getIntent() != null && getIntent().getBundleExtra("Parameters") != null) {
            this.f32936g = getIntent().getBundleExtra("Parameters");
            if (this.f32936g != null && this.f32936g.size() > 0) {
                if (j.h() != null && this.f32935f != null) {
                    this.f32935f.setId(121);
                    this.f32935f.setVisibility(0);
                    this.f32935f.postUrl(j.h().f33071d, p.g(this.f32936g).getBytes());
                    this.f32935f.requestFocus(130);
                    if (j.h().f33068a == null || j.h().f33068a.a() == null) {
                        l lVarM = j.h().m();
                        if (lVarM != null) {
                            lVarM.f("Transaction failed due to invaild parameters", null);
                        }
                        finish();
                    } else if (j.h().f33068a.a().get("prenotificationurl") != null) {
                        Intent intent = new Intent(getApplicationContext(), (Class<?>) IntentServicePreNotification.class);
                        intent.putExtra("url", j.h().f33068a.a().get("prenotificationurl"));
                        getApplicationContext().startService(intent);
                    }
                } else if (this.f32935f == null) {
                    l lVarM2 = j.h().m();
                    if (lVarM2 != null) {
                        lVarM2.f(com.paytm.pgsdk.d.Y, null);
                    }
                    finish();
                }
            }
        }
    }

    @Override // x4.f
    public void j(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        p.a("Pg Activity:OnWcSslError");
    }

    @Override // x4.f
    public void k(WebView webView, String str, Bitmap bitmap) {
        p.a("Pg Activity:OnWcPageStart");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i7, int i8, Intent intent) {
        super.onActivityResult(i7, i8, intent);
        if (i7 != 105) {
            return;
        }
        String str = "javascript:window.upiIntent.intentAppClosed(" + i8 + ");";
        this.f32935f.loadUrl(str);
        p.a("Js for acknowldgement" + str);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        g0();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected synchronized void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        if (bundle != null) {
            if (j.h() != null && j.h().m() != null) {
                j.h().m().c("Please retry with valid parameters");
            }
            finish();
        }
        if (this.f32947r && androidx.core.content.d.a(this, "android.permission.RECEIVE_SMS") == 0 && androidx.core.content.d.a(this, "android.permission.READ_SMS") == 0) {
            p0();
        }
        if (k0()) {
            this.f32942m = this;
            q0();
        } else {
            finish();
            l lVarM = j.h().m();
            if (lVarM != null) {
                lVarM.b(f32928s);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected synchronized void onDestroy() {
        BroadcastReceiver broadcastReceiver;
        try {
            if (this.f32947r && (broadcastReceiver = this.f32946q) != null) {
                unregisterReceiver(broadcastReceiver);
            }
            j.h().s();
            k.c();
            PaytmAssist paytmAssist = this.f32940k;
            if (paytmAssist != null) {
                paytmAssist.removeAssist();
            }
        } catch (Exception e8) {
            com.paytm.pgsdk.a.e().f(com.paytm.pgsdk.d.f33012o, e8.getMessage());
            j.h().s();
            p.a("Some exception occurred while destroying the PaytmPGActivity.");
            p.k(e8);
        }
        super.onDestroy();
        com.paytm.pgsdk.a.a();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // x4.b
    public void p(String str) {
        p.a("SMS received:" + str);
    }

    @Override // x4.f
    public void r(WebView webView, String str) {
    }

    @Override // x4.f
    public void y(WebView webView, String str) {
        p.a("Pg Activity:OnWcPageFinish");
    }

    @Override // x4.f
    public boolean z(WebView webView, Object obj) {
        return false;
    }
}
