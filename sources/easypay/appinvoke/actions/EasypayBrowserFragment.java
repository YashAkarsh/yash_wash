package easypay.appinvoke.actions;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.JsonReader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import c.t0;
import com.facebook.GraphRequest;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import easypay.appinvoke.manager.Constants;
import easypay.appinvoke.manager.EasyPayHelper;
import easypay.appinvoke.manager.EasypayWebViewClient;
import easypay.appinvoke.manager.PaytmAssist;
import easypay.appinvoke.utils.AnalyticsService;
import easypay.appinvoke.utils.EasyPayConfigDownloader;
import easypay.appinvoke.widget.OtpEditText;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import paytm.assist.easypay.easypay.appinvoke.R;

/* JADX INFO: loaded from: classes2.dex */
@t0(api = 11)
public class EasypayBrowserFragment extends Fragment implements View.OnClickListener, x4.f, CompoundButton.OnCheckedChangeListener {
    private ImageView A0;
    private ImageView B0;
    private ImageView C0;
    private Map<String, String> D;
    private TextView D0;
    private LinearLayout E;
    private TextView E0;
    private CheckBox F;
    private TextView F0;
    private EditText G;
    private TextView G0;
    private EditText H;
    private Button H0;
    private LinearLayout I;
    private ConstraintLayout I0;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private GAEventManager f33609J;
    private ConstraintLayout J0;
    private String K;
    private CountDownTimer K0;
    private TextWatcher L0;
    private String M;
    OtpEditText M0;
    private Long N;
    private Long O;
    private RelativeLayout P;
    private EasyPayHelper Q;
    private HashMap<String, w4.g> R;
    private Button S;
    private ImageButton T;
    private ImageButton U;
    private TextView W;
    private TextView X;
    private TextView Y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InputStream f33610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private StringBuilder f33611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private w4.a f33612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private WebView f33613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AppCompatActivity f33614e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private easypay.appinvoke.actions.e f33615f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private easypay.appinvoke.actions.d f33616g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private easypay.appinvoke.actions.c f33617h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private easypay.appinvoke.actions.b f33618i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private easypay.appinvoke.actions.g f33619j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private easypay.appinvoke.actions.h f33620k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private easypay.appinvoke.actions.f f33621l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private easypay.appinvoke.actions.a f33622m;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private SharedPreferences f33625p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private SharedPreferences.Editor f33626q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private SharedPreferences f33627r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private EasypayWebViewClient f33628s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    boolean f33629t;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f33633x;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private HashMap<String, w4.g> f33623n = new HashMap<>();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private StringBuilder f33624o = new StringBuilder();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    boolean f33630u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    boolean f33631v = true;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f33632w = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f33634y = false;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f33635z = true;
    private boolean A = true;
    private boolean B = false;
    private boolean C = false;
    private String L = "";
    int V = 0;
    private TextView[] Z = new TextView[3];
    private BroadcastReceiver N0 = new b();

    class a extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f33636a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j7, long j8, String str) {
            super(j7, j8);
            this.f33636a = str;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            EasypayBrowserFragment.this.I0();
            if (EasypayBrowserFragment.this.f33609J != null) {
                EasypayBrowserFragment.this.f33609J.E(true);
                EasypayBrowserFragment.this.f33609J.t(false);
                EasypayBrowserFragment.this.f33609J.z(false, 0);
                EasypayBrowserFragment.this.f33609J.e(false);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j7) {
            String str;
            long j8 = j7 / 1000;
            if (j8 > 1) {
                str = this.f33636a + " " + j8 + " seconds";
            } else if (j8 == 1) {
                str = this.f33636a + " " + j8 + " second";
            } else {
                onFinish();
                str = "";
            }
            EasypayBrowserFragment.this.E0.setText(str);
        }
    }

    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (Constants.EASYPAY_ACTION_FILE_DOWNLOADED.equalsIgnoreCase(intent.getAction())) {
                EasypayBrowserFragment.this.l0();
            } else {
                EasypayBrowserFragment.this.k0();
            }
        }
    }

    class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.toString().equals(EasypayBrowserFragment.this.M)) {
                EasypayBrowserFragment.this.F0(false);
                EasypayBrowserFragment easypayBrowserFragment = EasypayBrowserFragment.this;
                easypayBrowserFragment.K0(false, easypayBrowserFragment.M);
            } else if (editable.toString().equals(EasypayBrowserFragment.this.L)) {
                EasypayBrowserFragment easypayBrowserFragment2 = EasypayBrowserFragment.this;
                easypayBrowserFragment2.F0(easypayBrowserFragment2.f33631v);
            } else {
                EasypayBrowserFragment.this.F0(true);
                EasypayBrowserFragment.this.K0(true, editable.toString());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            EasypayBrowserFragment easypayBrowserFragment = EasypayBrowserFragment.this;
            easypayBrowserFragment.f33630u = false;
            easypayBrowserFragment.I0.setVisibility(0);
            EasypayBrowserFragment.this.J0.setVisibility(8);
            EasypayBrowserFragment.this.s0();
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            EasypayBrowserFragment easypayBrowserFragment = EasypayBrowserFragment.this;
            easypayBrowserFragment.f33630u = true;
            if (easypayBrowserFragment.K0 != null) {
                EasypayBrowserFragment.this.K0.cancel();
            }
            EasypayBrowserFragment.this.I0.setVisibility(8);
            EasypayBrowserFragment.this.J0.setVisibility(0);
            if (EasypayBrowserFragment.this.f33609J != null) {
                EasypayBrowserFragment.this.f33609J.D(true);
            }
        }
    }

    class f extends com.google.gson.reflect.a<HashMap<String, String>> {
        f() {
        }
    }

    class g extends com.google.gson.reflect.a<HashMap<String, String>> {
        g() {
        }
    }

    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            EasypayBrowserFragment.this.t0("", 3);
        }
    }

    class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            EasypayBrowserFragment.this.t0("", 4);
        }
    }

    class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f33646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f33647b;

        j(int i7, String str) {
            this.f33646a = i7;
            this.f33647b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                int i7 = this.f33646a;
                if (i7 == 1) {
                    EasypayBrowserFragment.this.E.setVisibility(0);
                    if (EasypayBrowserFragment.this.F.getVisibility() == 0) {
                        EasypayBrowserFragment.this.F.setVisibility(8);
                        EasypayBrowserFragment easypayBrowserFragment = EasypayBrowserFragment.this;
                        easypayBrowserFragment.L = easypayBrowserFragment.H.getText().toString();
                    }
                    EasypayBrowserFragment.this.G.setVisibility(0);
                    EasypayBrowserFragment.this.T.setVisibility(0);
                    EasypayBrowserFragment.this.U.setVisibility(8);
                    EasypayBrowserFragment.this.H.setVisibility(8);
                    EasypayBrowserFragment.this.I.setVisibility(8);
                    if (EasypayBrowserFragment.this.S.getVisibility() != 0) {
                        EasypayBrowserFragment.this.S.setVisibility(0);
                    }
                    EasypayBrowserFragment.this.D0.setVisibility(0);
                    if (this.f33647b == null) {
                        return;
                    }
                    EasypayBrowserFragment.this.G.setText(this.f33647b);
                    return;
                }
                if (i7 == 0) {
                    if (EasypayBrowserFragment.this.G.getVisibility() == 0 || EasypayBrowserFragment.this.G.getVisibility() == 4) {
                        EasypayBrowserFragment.this.G.setVisibility(8);
                    }
                    if (EasypayBrowserFragment.this.D0.getVisibility() == 0 || EasypayBrowserFragment.this.D0.getVisibility() == 4) {
                        EasypayBrowserFragment.this.D0.setVisibility(8);
                    }
                    if (EasypayBrowserFragment.this.F.getVisibility() == 0 || EasypayBrowserFragment.this.F.getVisibility() == 4) {
                        EasypayBrowserFragment.this.F.setVisibility(8);
                    }
                    if (EasypayBrowserFragment.this.S.getVisibility() == 0 || EasypayBrowserFragment.this.S.getVisibility() == 4) {
                        EasypayBrowserFragment.this.S.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (i7 == 3) {
                    if (EasypayBrowserFragment.this.E == null || EasypayBrowserFragment.this.G == null) {
                        return;
                    }
                    EasypayBrowserFragment.this.G.setText("");
                    return;
                }
                if (i7 == 4) {
                    if (EasypayBrowserFragment.this.E != null) {
                        EasypayBrowserFragment.this.E.setVisibility(0);
                    }
                } else {
                    if (i7 != 5 || EasypayBrowserFragment.this.E == null) {
                        return;
                    }
                    EasypayBrowserFragment.this.E.setVisibility(8);
                }
            } catch (Exception e8) {
                e8.printStackTrace();
                easypay.appinvoke.utils.b.a("EXCEPTION", e8);
            }
        }
    }

    private void A0(boolean z7) {
        if (z7) {
            SharedPreferences sharedPreferences = this.f33614e.getApplicationContext().getSharedPreferences(Constants.BANKPREF, 0);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            String str = this.D.get("bank");
            String string = sharedPreferences.getString(Constants.USER_ID_NET_BANK_KEY, "");
            if (TextUtils.isEmpty(string)) {
                HashMap map = new HashMap();
                map.put(str, this.K);
                editorEdit.putString(Constants.USER_ID_NET_BANK_KEY, new com.google.gson.f().z(map));
                editorEdit.apply();
                return;
            }
            HashMap map2 = (HashMap) new com.google.gson.f().o(string, new f().getType());
            if (map2 == null || map2.containsKey(str)) {
                return;
            }
            map2.put(str, this.K);
            editorEdit.putString(Constants.USER_ID_NET_BANK_KEY, new com.google.gson.f().z(map2));
            editorEdit.apply();
        }
    }

    private void H0() {
        AppCompatActivity appCompatActivity = this.f33614e;
        if (appCompatActivity != null) {
            appCompatActivity.runOnUiThread(new d());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0() {
        w4.a aVar = this.f33612c;
        if (aVar == null || !this.f33632w) {
            return;
        }
        if (Constants.EASYPAY_PAYTYPE_CREDIT_CARD.equalsIgnoreCase(aVar.e()) || Constants.EASYPAY_PAYTYPE_DEBIT_CARD.equalsIgnoreCase(this.f33612c.e())) {
            this.f33616g.N(this.f33623n.get(Constants.SUBMIT_BTN));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0(boolean z7, String str) {
        if (str == null) {
            str = this.M;
        }
        int iX = this.f33618i.x();
        if (iX == 1) {
            if (z7) {
                this.I.setVisibility(0);
                this.Z[0].setVisibility(0);
                this.Z[0].setText(this.M);
            } else {
                this.I.setVisibility(8);
                this.Z[0].setVisibility(8);
            }
        } else if (iX > 1) {
            for (int i7 = 0; i7 < iX; i7++) {
                if (this.Z[i7].getText().equals(str)) {
                    this.Z[i7].setVisibility(8);
                } else if (!this.Z[i7].getText().equals("")) {
                    this.Z[i7].setVisibility(0);
                }
            }
        }
        F0(z7);
    }

    private void V(WebView webView, String str, w4.a aVar) {
        try {
            easypay.appinvoke.utils.b.a("In assistNewFlow():mdetailresponse=" + this.f33612c.a() + ":" + this.f33612c.f(), this);
            if (this.f33612c != null) {
                this.f33623n = new HashMap<>();
                ArrayList<w4.d> arrayListF = aVar.f();
                if (!aVar.e().equalsIgnoreCase(Constants.EASYPAY_PAYTYPE_CREDIT_CARD) && !aVar.e().equalsIgnoreCase(Constants.EASYPAY_PAYTYPE_DEBIT_CARD)) {
                    if (Constants.EASYPAY_PAYTYPE_NETBANKING.equalsIgnoreCase(aVar.e())) {
                        j0(str, aVar);
                        return;
                    }
                    return;
                }
                SharedPreferences sharedPreferences = this.f33614e.getSharedPreferences("com.paytm.com.paytm.pgsdk.easypay.appinvoke.PREFERENCE_FILE_KEY", 0);
                this.f33625p = sharedPreferences;
                this.f33633x = sharedPreferences.getBoolean("enableEasyPay", false);
                if (!this.f33634y) {
                    this.f33634y = true;
                }
                for (w4.d dVar : arrayListF) {
                    if (Z(dVar.b(), str)) {
                        GAEventManager gAEventManager = this.f33609J;
                        if (gAEventManager != null) {
                            gAEventManager.P(str);
                        }
                        ArrayList<w4.g> arrayListA = dVar.a();
                        if (arrayListA != null && !arrayListA.isEmpty()) {
                            for (w4.g gVar : arrayListA) {
                                this.f33623n.put(gVar.b(), gVar);
                                easypay.appinvoke.utils.b.a("Operation type: " + gVar.b(), this);
                            }
                        }
                    }
                }
                if (this.f33616g == null) {
                    easypay.appinvoke.utils.b.a("making object newotphelper", this);
                    this.f33616g = new easypay.appinvoke.actions.d(this.f33614e, webView, this, this.f33628s);
                }
                if (this.f33623n.size() <= 0) {
                    z0();
                    return;
                }
                easypay.appinvoke.utils.b.a("Easypay browser fragment:fire do action-Filler from web ", this);
                this.f33616g.J(this.f33623n);
                this.f33616g.A(Constants.FILLER_FROM_WEB);
            }
        } catch (Exception e8) {
            e8.printStackTrace();
            easypay.appinvoke.utils.b.a("EXCEPTION", e8);
        }
    }

    private void W() {
        this.A0.setOnClickListener(this);
        this.W.setOnClickListener(this);
        this.X.setOnClickListener(this);
        this.Y.setOnClickListener(this);
        this.D0.setOnClickListener(this);
        this.U.setOnClickListener(this);
        this.T.setOnClickListener(this);
        this.G0.setOnClickListener(this);
        this.F0.setOnClickListener(this);
        this.H0.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.C0.setOnClickListener(this);
        this.S.setOnClickListener(this);
        this.B0.setOnClickListener(this);
    }

    private boolean Z(String str, String str2) {
        return str2.contains(str);
    }

    private void a0() {
        this.F0.setVisibility(8);
        this.E0.setVisibility(8);
    }

    /* JADX WARN: Code duplicated, block: B:178:0x03a1 A[FALL_THROUGH] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v42 */
    private void b0(WebView webView, String str, String str2) {
        ArrayList<Map<String, String>> arrayListD0;
        String str3;
        String str4;
        Map<String, String> map;
        boolean z7;
        byte b8;
        String str5;
        String str6;
        ?? r7;
        SharedPreferences sharedPreferences;
        boolean z8 = true;
        try {
            arrayListD0 = d0(str);
            if (arrayListD0 != null) {
                try {
                    if (!arrayListD0.isEmpty() && (sharedPreferences = this.f33625p) != null) {
                        this.f33633x = sharedPreferences.getBoolean("enableEasyPay", false);
                        if (!this.f33634y) {
                            this.f33634y = true;
                        }
                    }
                } catch (Exception e8) {
                    e = e8;
                    e.printStackTrace();
                    easypay.appinvoke.utils.b.a("EXCEPTION", e);
                }
            }
        } catch (Exception e9) {
            e = e9;
            arrayListD0 = null;
        }
        if (arrayListD0 == null || arrayListD0.isEmpty()) {
            return;
        }
        Iterator<Map<String, String>> it = arrayListD0.iterator();
        while (it.hasNext()) {
            Map<String, String> next = it.next();
            if (next.get("active") == null || !next.get("active").equals(com.paytm.pgsdk.d.G)) {
                this.D = next;
                String str7 = next.get("selector");
                String str8 = next.get("customjs");
                if (str8 == null) {
                    str8 = "customJs=function(){};";
                }
                next.put("functionStart", "(function(){ try { " + str8);
                next.put("functionEnd", "}catch(e){ Android.logError(\" + element not found + \"); } })();");
                String str9 = next.get("msgPattern");
                String str10 = next.get("msgSender");
                String str11 = next.get("msgKeywords");
                String str12 = next.get("action");
                String str13 = next.get("selectorType");
                String str14 = next.get("buttonSelectorName");
                String str15 = next.get("userId");
                if (str13 != null) {
                    switch (str13.hashCode()) {
                        case -1548231387:
                            r7 = !str13.equals("tagname") ? -1 : 0;
                            break;
                        case -1349088399:
                            r7 = !str13.equals("custom") ? -1 : z8;
                            break;
                        case 3355:
                            r7 = !str13.equals("id") ? -1 : 2;
                            break;
                        case 3373707:
                            r7 = !str13.equals("name") ? -1 : 3;
                            break;
                        case 3556653:
                            r7 = !str13.equals(ViewHierarchyConstants.TEXT_KEY) ? -1 : 4;
                            break;
                        case 1216985755:
                            r7 = !str13.equals("password") ? -1 : 5;
                            break;
                        default:
                            r7 = -1;
                            break;
                    }
                    switch (r7) {
                        case 0:
                            str3 = "var fields = document.getElementsByTagName('" + str7 + "');if(fields.length == 0){Android.showLog('not found - ' + fields.length); throw 'error';}";
                            break;
                        case 1:
                            str3 = next.get("customSelector") + "if(fields.length == 0){Android.showLog('not found - ' + fields.length); throw 'error';}";
                            break;
                        case 2:
                            if (str12 == null) {
                                str3 = "";
                            } else if (str12.equals("netbanking") && !this.f33629t) {
                                str3 = "var field = document.getElementById('" + str15 + "'); var fields = field ? [field] : [];if(fields.length == 0){Android.showLog('not found - ' + fields.length); throw 'error';}";
                            } else {
                                str3 = "var field = document.getElementById('" + str7 + "'); var fields = field ? [field] : [];if(fields.length == 0){Android.showLog('not found - ' + fields.length); throw 'error';}";
                            }
                            break;
                        case 3:
                            if (str12 == null) {
                                str3 = "";
                            } else if (str12.contains("netbanking") && !this.f33629t) {
                                str3 = "var field = document.getElementsByName(" + str15 + "); var fields = field ? [field] : [];if(fields.length == 0){Android.showLog('not found - ' + fields.length); throw 'error';}";
                            } else {
                                str3 = "var fields = document.getElementsByName('" + str7 + "');if(fields.length == 0){Android.showLog('not found - ' + fields.length); throw 'error';}";
                            }
                            break;
                        case 4:
                        case 5:
                            str3 = "var fields = document.getElementsByName('" + str7 + "');if(fields.length == 0){Android.showLog('not found - ' + fields.length); throw 'error';}";
                            break;
                        default:
                            str3 = "";
                            break;
                    }
                } else {
                    str3 = "";
                }
                next.put(GraphRequest.FIELDS_PARAM, str3);
                if (str12 != null) {
                    switch (str12) {
                        case "proceedhelper":
                            b8 = 0;
                            break;
                        case "passwordtracker":
                            b8 = 1;
                            break;
                        case "radiohelper":
                            b8 = 2;
                            break;
                        case "customjs":
                            b8 = 3;
                            break;
                        case "otphelper":
                            b8 = 4;
                            break;
                        case "netbanking":
                            b8 = 5;
                            break;
                        default:
                            b8 = -1;
                            break;
                    }
                    String str16 = "time not captured";
                    switch (b8) {
                        case 0:
                            str4 = "";
                            map = next;
                            this.f33619j = new easypay.appinvoke.actions.g(this.f33614e, webView, this, map);
                            GAEventManager gAEventManager = this.f33609J;
                            if (gAEventManager != null) {
                                gAEventManager.w(str);
                            }
                            break;
                        case 1:
                            str4 = "";
                            map = next;
                            this.f33621l = new easypay.appinvoke.actions.f(this.f33614e, webView, this, map, str14);
                            GAEventManager gAEventManager2 = this.f33609J;
                            if (gAEventManager2 != null) {
                                gAEventManager2.M(str);
                            }
                            break;
                        case 2:
                            str4 = "";
                            map = next;
                            this.f33620k = new easypay.appinvoke.actions.h(this.f33614e, webView, this, map);
                            break;
                        case 3:
                            str4 = "";
                            map = next;
                            this.f33622m = new easypay.appinvoke.actions.a(this.f33614e, webView, this, map);
                            break;
                        case 4:
                            try {
                                if (this.f33615f == null) {
                                    if (this.f33609J != null) {
                                        if (this.N == null || this.O == null) {
                                            str5 = "time not captured";
                                        } else {
                                            str16 = "" + this.N + "";
                                            str5 = "" + this.O + "";
                                        }
                                        if (!TextUtils.isEmpty(str16) && !TextUtils.isEmpty(str5)) {
                                            this.f33609J.g(str16);
                                            this.f33609J.N(str5);
                                        }
                                    }
                                    str4 = "";
                                    map = next;
                                    try {
                                        this.f33615f = new easypay.appinvoke.actions.e(this.f33614e, webView, this, next, str10, str9, str11, this.f33628s);
                                    } catch (Exception e10) {
                                        e = e10;
                                        e.printStackTrace();
                                        easypay.appinvoke.utils.b.a("EXCEPTION", e);
                                    }
                                }
                            } catch (Exception e11) {
                                e = e11;
                                str4 = "";
                                map = next;
                            }
                            break;
                        case 5:
                            if (!this.f33629t) {
                                try {
                                    GAEventManager gAEventManager3 = this.f33609J;
                                    if (gAEventManager3 != null) {
                                        if (this.f33613d != null) {
                                            gAEventManager3.P(str);
                                        }
                                        if (this.N == null || this.O == null) {
                                            str6 = "time not captured";
                                        } else {
                                            str16 = "" + this.N + "";
                                            str6 = "" + this.O + "";
                                        }
                                        if (!TextUtils.isEmpty(str16) && !TextUtils.isEmpty(str6)) {
                                            this.f33609J.g(str16);
                                            this.f33609J.N(str6);
                                        }
                                    }
                                    easypay.appinvoke.actions.c cVar = this.f33617h;
                                    if (cVar == null || !cVar.f33703t) {
                                        this.f33617h = new easypay.appinvoke.actions.c(this.f33614e, webView, this, next, this.f33628s);
                                        GAEventManager gAEventManager4 = this.f33609J;
                                        if (gAEventManager4 != null) {
                                            gAEventManager4.M(str);
                                        }
                                    }
                                } catch (Exception e12) {
                                    e12.printStackTrace();
                                    easypay.appinvoke.utils.b.a("EXCEPTION", e12);
                                }
                                break;
                            }
                        default:
                            str4 = "";
                            map = next;
                            break;
                    }
                    return;
                }
                str4 = "";
                map = next;
                if (str2.equals("nbotphelper")) {
                    GAEventManager gAEventManager5 = this.f33609J;
                    if (gAEventManager5 != null) {
                        gAEventManager5.r(true);
                    }
                    t0(str4, 3);
                    if (this.f33615f != null) {
                        return;
                    }
                    z7 = true;
                    this.f33615f = new easypay.appinvoke.actions.e(this.f33614e, webView, this, map, str10, str9, str11, this.f33628s);
                } else {
                    z7 = true;
                }
                z8 = z7;
            }
        }
    }

    private void c0() {
        this.F0.setVisibility(0);
        this.E0.setVisibility(0);
    }

    private ArrayList<Map<String, String>> d0(String str) {
        ArrayList<Map<String, String>> arrayList = new ArrayList<>();
        try {
            this.f33633x = this.f33625p.getBoolean("enableEasyPay", false);
            return arrayList;
        } catch (Exception e8) {
            e8.printStackTrace();
            easypay.appinvoke.utils.b.a("EXCEPTION", e8);
            return arrayList;
        }
    }

    private void h0() {
        this.E = (LinearLayout) this.f33614e.findViewById(R.id.ll_nb_login);
        this.F = (CheckBox) this.f33614e.findViewById(R.id.cb_nb_userId);
        this.G = (EditText) this.f33614e.findViewById(R.id.et_nb_password);
        this.H = (EditText) this.f33614e.findViewById(R.id.et_nb_userIdCustomerId);
        this.I = (LinearLayout) this.f33614e.findViewById(R.id.ll_nb_user_id_Selector);
        this.P = (RelativeLayout) this.f33614e.findViewById(R.id.parentPanel);
        this.S = (Button) this.f33614e.findViewById(R.id.nb_bt_submit);
        this.W = (TextView) this.f33614e.findViewById(R.id.tv_user_id_one);
        this.X = (TextView) this.f33614e.findViewById(R.id.tv_user_id_two);
        this.Y = (TextView) this.f33614e.findViewById(R.id.tv_user_id_three);
        this.T = (ImageButton) this.f33614e.findViewById(R.id.nb_image_bt_previous);
        this.U = (ImageButton) this.f33614e.findViewById(R.id.nb_image_bt_next);
        this.D0 = (TextView) this.f33614e.findViewById(R.id.img_pwd_show);
        this.f33611b = new StringBuilder();
        this.L0 = new c();
        TextView[] textViewArr = this.Z;
        textViewArr[0] = this.W;
        textViewArr[1] = this.X;
        textViewArr[2] = this.Y;
        this.G.setText("");
        this.H.setText("");
        this.F.setOnCheckedChangeListener(this);
        this.F.setButtonDrawable(R.drawable.ic_checkbox_selected);
        this.H.addTextChangedListener(this.L0);
        Drawable drawable = this.f33614e.getBaseContext().getResources().getDrawable(R.drawable.ic_show_passcode);
        drawable.setBounds(0, 0, 24, 24);
        this.D0.setCompoundDrawables(drawable, null, null, null);
    }

    private void i0() {
        this.B0 = (ImageView) this.f33614e.findViewById(R.id.img_show_assist);
        this.G0 = (TextView) this.f33614e.findViewById(R.id.tv_detection_status);
        this.A0 = (ImageView) this.f33614e.findViewById(R.id.img_hide_assist);
        this.M0 = (OtpEditText) this.f33614e.findViewById(R.id.edit_text_otp);
        this.E0 = (TextView) this.f33614e.findViewById(R.id.tv_submit_otp_time);
        this.F0 = (TextView) this.f33614e.findViewById(R.id.tv_tap_to_pause);
        this.H0 = (Button) this.f33614e.findViewById(R.id.btn_submit_otp);
        this.I0 = (ConstraintLayout) this.f33614e.findViewById(R.id.cl_show_assist);
        this.J0 = (ConstraintLayout) this.f33614e.findViewById(R.id.cl_hide_assist);
        this.C0 = (ImageView) this.f33614e.findViewById(R.id.img_paytm_assist_banner);
    }

    @SuppressLint({"JavascriptInterface"})
    private void j0(String str, w4.a aVar) {
        this.R = new HashMap<>();
        for (w4.d dVar : aVar.f()) {
            if (str.contains(dVar.b())) {
                GAEventManager gAEventManager = this.f33609J;
                if (gAEventManager != null) {
                    gAEventManager.P(str);
                }
                ArrayList<w4.g> arrayListA = dVar.a();
                if (arrayListA != null && !arrayListA.isEmpty()) {
                    for (w4.g gVar : arrayListA) {
                        this.R.put(gVar.b(), gVar);
                    }
                    if (this.R.size() > 0) {
                        this.f33618i.C(this.R, this.f33612c);
                        return;
                    }
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0() {
        try {
            ArrayList<Map<String, String>> arrayListV0 = v0(Constants.EASY_PAY_CONFIG_PREF_KEY);
            if (arrayListV0 == null || arrayListV0.get(0) == null || arrayListV0.get(0).get("ttl") == null) {
                return;
            }
            long j7 = Long.parseLong(arrayListV0.get(0).get("ttl"));
            SharedPreferences.Editor editorEdit = this.f33614e.getSharedPreferences("com.paytm.com.paytm.pgsdk.easypay.appinvoke.PREFERENCE_FILE_KEY", 0).edit();
            this.f33626q = editorEdit;
            editorEdit.putLong("easypay_configuration_ttl", j7);
            this.f33626q.apply();
        } catch (Exception e8) {
            e8.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0() {
        try {
            w4.a aVar = (w4.a) new com.google.gson.f().n(this.f33614e.getSharedPreferences(Constants.EASYPAY_NEW_PREFERENCE_FILE, 0).getString(Constants.EASY_PAY_CONFIG_PREF_KEY, ""), w4.a.class);
            this.f33612c = aVar;
            if (aVar != null) {
                Iterator<w4.d> it = aVar.f().iterator();
                while (it.hasNext()) {
                    if (Z(it.next().b(), this.f33613d.getUrl())) {
                        WebView webView = this.f33613d;
                        X(webView, webView.getUrl());
                        return;
                    }
                }
            }
        } catch (Exception e8) {
            easypay.appinvoke.utils.b.a("EXCEPTION", e8);
        }
    }

    private void m0() {
        AppCompatActivity appCompatActivity = this.f33614e;
        if (appCompatActivity != null) {
            this.f33625p = appCompatActivity.getSharedPreferences("com.paytm.com.paytm.pgsdk.easypay.appinvoke.PREFERENCE_FILE_KEY", 0);
            this.f33627r = this.f33614e.getSharedPreferences("com.paytm.com.paytm.pgsdk.easypay.appinvoke.EVENTS_FILE", 0);
            W();
            Arrays.sort("kokookokok".toCharArray());
        }
    }

    private void p0() {
        AppCompatActivity appCompatActivity = this.f33614e;
        if (appCompatActivity != null) {
            appCompatActivity.runOnUiThread(new e());
        }
    }

    public static EasypayBrowserFragment q0() {
        Bundle bundle = new Bundle();
        EasypayBrowserFragment easypayBrowserFragment = new EasypayBrowserFragment();
        easypayBrowserFragment.setArguments(bundle);
        return easypayBrowserFragment;
    }

    private ArrayList<Map<String, String>> u0(JsonReader jsonReader) throws IOException {
        ArrayList<Map<String, String>> arrayList = new ArrayList<>();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(w0(jsonReader));
        }
        return arrayList;
    }

    private ArrayList<Map<String, String>> v0(String str) throws Exception {
        try {
            File fileStreamPath = this.f33614e.getFileStreamPath("easypay_configuration.json");
            if (fileStreamPath != null && fileStreamPath.exists()) {
                this.f33610a = this.f33614e.getApplicationContext().openFileInput("easypay_configuration.json");
            }
        } catch (Exception e8) {
            e8.printStackTrace();
        }
        JsonReader jsonReader = new JsonReader(new InputStreamReader(this.f33610a, StandardCharsets.UTF_8));
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (jsonReader.nextName().equals(str)) {
                    return u0(jsonReader);
                }
                jsonReader.skipValue();
            }
            jsonReader.endObject();
            return u0(jsonReader);
        } catch (Exception e9) {
            e9.printStackTrace();
            return null;
        } finally {
            jsonReader.close();
        }
    }

    private Map<String, String> w0(JsonReader jsonReader) throws IOException {
        HashMap map = new HashMap();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            map.put(jsonReader.nextName(), jsonReader.nextString());
        }
        jsonReader.endObject();
        return map;
    }

    private void x0(Bundle bundle) {
        if (bundle != null) {
            try {
                this.f33613d = PaytmAssist.getAssistInstance().getWebView();
            } catch (NullPointerException e8) {
                e8.printStackTrace();
                easypay.appinvoke.utils.b.a("EXCEPTION", e8);
            }
        }
    }

    void B0(String str) {
        F0(false);
        this.M = str;
    }

    void C0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.G0.setText(str);
    }

    void D0(ArrayList<String> arrayList) {
        int size = arrayList.size();
        for (int i7 = size - 1; i7 >= 0; i7 += -1) {
            this.Z[(size - i7) - 1].setText(arrayList.get(i7));
            easypay.appinvoke.utils.b.a("" + arrayList.get(i7) + " USER ID", this);
        }
    }

    void E0(boolean z7) {
        String string = getString(R.string.submit_time);
        easypay.appinvoke.utils.b.a("Timer called", this);
        try {
            CountDownTimer countDownTimer = this.K0;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            if (z7) {
                a0();
            } else {
                c0();
                this.K0 = new a(com.haier.uhome.ble.hal.a.b.a.f28248c, 1000L, string).start();
            }
        } catch (Exception e8) {
            e8.printStackTrace();
            easypay.appinvoke.utils.b.a("EXCEPTION", e8);
        }
    }

    void F0(boolean z7) {
        this.F.setChecked(z7);
    }

    void G0(String str) {
        this.H.setText(str);
    }

    void J0(int i7, boolean z7) {
        if (!z7) {
            this.I.setVisibility(8);
            for (int i8 = 0; i8 < i7; i8++) {
                this.Z[i8].setVisibility(8);
            }
            return;
        }
        this.I.setVisibility(0);
        for (int i9 = 0; i9 < 3; i9++) {
            if (i9 >= i7) {
                this.Z[i9].setVisibility(8);
            } else if (this.Z[i9].getText().equals(this.M)) {
                this.Z[i9].setVisibility(8);
            } else {
                this.Z[i9].setVisibility(0);
            }
        }
    }

    void L0(boolean z7) {
        this.C = z7;
    }

    void M0(int i7, Boolean bool) {
        try {
            View viewFindViewById = this.f33614e.findViewById(i7);
            View viewFindViewById2 = this.f33614e.findViewById(R.id.parentPanel);
            int i8 = bool.booleanValue() ? 0 : 8;
            viewFindViewById2.setVisibility(i8);
            if (bool.booleanValue() && i7 == R.id.otpHelper) {
                GAEventManager gAEventManager = this.f33609J;
                if (gAEventManager != null) {
                    gAEventManager.x(true);
                }
                viewFindViewById.setVisibility(i8);
                this.f33632w = true;
                return;
            }
            if (!bool.booleanValue() && i7 == R.id.otpHelper) {
                GAEventManager gAEventManager2 = this.f33609J;
                if (gAEventManager2 != null) {
                    gAEventManager2.x(false);
                }
                viewFindViewById.setVisibility(i8);
                return;
            }
            if (i7 == R.id.layout_netbanking && bool.booleanValue()) {
                PaytmAssist.getAssistInstance().getmEventMap().put("showPasswordClicked", Boolean.valueOf(this.A));
                GAEventManager gAEventManager3 = this.f33609J;
                if (gAEventManager3 != null) {
                    gAEventManager3.H(true);
                    this.f33609J.x(true);
                }
                this.P.setBackgroundColor(0);
                ((RelativeLayout) viewFindViewById.findViewById(i7)).setVisibility(0);
            }
        } catch (Exception e8) {
            e8.printStackTrace();
            easypay.appinvoke.utils.b.a("EXCEPTION", e8);
        }
    }

    @JavascriptInterface
    public void NbWatcher(String str, String str2) {
        Map<String, String> map;
        if (str == null || str2 == null || (map = this.D) == null || map.get("passwordId") == null || this.D.get("url") == null || this.D.get("userId") == null || this.D.isEmpty()) {
            return;
        }
        try {
            this.f33629t = false;
            StringBuilder sb = this.f33611b;
            sb.delete(0, sb.length());
            if (str.equals("101") || str.equals("1") || str.equals("110")) {
                if (str.equals("1") && str2.equals("2")) {
                    this.f33629t = true;
                    A0(this.f33635z);
                    b0(this.f33613d, this.D.get("url"), "nbotphelper");
                    this.f33629t = false;
                } else if (str.equals("1") && str2.equals("3")) {
                    sendEvent("confirmhelper", "", "");
                    A0(this.f33635z);
                } else if (str.equals("101")) {
                    if (str2.equals(this.D.get("userId"))) {
                        t0(this.f33611b.toString(), 0);
                    } else if (str2.equals(this.D.get("passwordId"))) {
                        t0("", 1);
                    }
                } else if (str.equals("110")) {
                    if (str2.equals("0")) {
                        this.f33614e.runOnUiThread(new h());
                    } else if (str2.equals("1")) {
                        this.f33614e.runOnUiThread(new i());
                    }
                }
            } else if (str2.equals(this.D.get("userId"))) {
                this.K = str;
                t0(this.f33611b.toString(), 0);
            } else if (str2.equals(this.D.get("passwordId"))) {
                this.f33611b.append(str);
                t0(str, 1);
            }
        } catch (NullPointerException e8) {
            e8.printStackTrace();
        }
    }

    public void X(WebView webView, String str) {
        AppCompatActivity appCompatActivity = this.f33614e;
        if (appCompatActivity == null || appCompatActivity.isFinishing()) {
            return;
        }
        try {
            String string = this.f33614e.getSharedPreferences(Constants.EASYPAY_NEW_PREFERENCE_FILE, 0).getString(Constants.EASY_PAY_CONFIG_PREF_KEY, "");
            easypay.appinvoke.utils.b.a("in checkAssistFlow Config json:" + string, this);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            w4.a aVar = (w4.a) new com.google.gson.f().n(string, w4.a.class);
            this.f33612c = aVar;
            if (aVar == null) {
                easypay.appinvoke.utils.b.a("imDetail resoinse Null", this);
                return;
            }
            if (!aVar.a().equalsIgnoreCase(PaytmAssist.getAssistInstance().geTxnBank())) {
                easypay.appinvoke.utils.b.a("Config JSON picked from cache doesn't have same bank name", this);
                GAEventManager gAEventManager = this.f33609J;
                if (gAEventManager != null) {
                    gAEventManager.x(false);
                    return;
                }
                return;
            }
            GAEventManager gAEventManager2 = this.f33609J;
            if (gAEventManager2 != null) {
                gAEventManager2.m(this.f33612c.c().booleanValue());
            }
            if (this.f33612c.c().booleanValue()) {
                this.B = true;
                V(webView, str, this.f33612c);
            } else {
                GAEventManager gAEventManager3 = this.f33609J;
                if (gAEventManager3 != null) {
                    gAEventManager3.x(false);
                }
            }
        } catch (Exception e8) {
            e8.printStackTrace();
            easypay.appinvoke.utils.b.a("EXCEPTION", e8);
        }
    }

    void Y() {
        this.M0.setText("");
        C0(this.f33614e.getString(R.string.waiting_for_otp_label, PaytmAssist.getAssistInstance().geTxnBank()));
    }

    public easypay.appinvoke.actions.d e0() {
        return this.f33616g;
    }

    void f0() {
        this.G.setVisibility(0);
        this.T.setVisibility(0);
        this.D0.setVisibility(0);
        this.S.setVisibility(0);
        this.U.setVisibility(8);
        this.F.setVisibility(8);
        this.f33631v = this.F.isChecked();
        this.L = this.H.getText().toString();
        this.H.setVisibility(8);
        this.I.setVisibility(8);
    }

    void g0() {
        this.E.setVisibility(0);
        this.G.setVisibility(8);
        this.T.setVisibility(8);
        this.D0.setVisibility(8);
        this.S.setVisibility(8);
        this.U.setVisibility(0);
        this.F.setVisibility(0);
        F0(this.f33631v);
        this.H.setVisibility(0);
        if (this.C) {
            this.I.setVisibility(0);
        } else {
            this.I.setVisibility(8);
        }
    }

    @Override // x4.f
    public void j(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
    }

    @Override // x4.f
    public void k(WebView webView, String str, Bitmap bitmap) {
        this.N = Long.valueOf(System.currentTimeMillis());
        easypay.appinvoke.utils.b.a("Start Called :" + this.N, this);
    }

    @JavascriptInterface
    public void logEvent(String str, String str2) {
        String str3 = str2 + "_" + str;
        int i7 = this.f33627r.getInt(str3, 0);
        SharedPreferences.Editor editorEdit = this.f33627r.edit();
        editorEdit.putInt(str3, i7 + 1);
        editorEdit.apply();
    }

    void n0() {
        ImageView imageView = this.B0;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        H0();
    }

    public void o0() {
        ImageView imageView = this.A0;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        p0();
    }

    @Override // androidx.fragment.app.Fragment
    @SuppressLint({"SetJavaScriptEnabled"})
    @TargetApi(21)
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        try {
            this.f33614e = (AppCompatActivity) getActivity();
            this.f33628s = PaytmAssist.getAssistInstance().getWebClientInstance();
            x0(getArguments());
            this.f33624o.append("|");
            i0();
            this.f33609J = PaytmAssist.getAssistInstance().getmAnalyticsManager();
            PaytmAssist.getAssistInstance().setFragmentResumed(false);
            PaytmAssist.getAssistInstance().setFragmentPaused(false);
            h0();
            WebView webView = this.f33613d;
            if (webView != null) {
                webView.getSettings().setDomStorageEnabled(true);
                this.f33613d.getSettings().setJavaScriptEnabled(true);
                this.f33613d.getSettings().setMixedContentMode(0);
                WebView.setWebContentsDebuggingEnabled(true);
                this.Q = PaytmAssist.getAssistInstance().getEasyPayHelper();
            }
            EasypayWebViewClient easypayWebViewClient = this.f33628s;
            if (easypayWebViewClient != null) {
                easypayWebViewClient.addAssistWebClientListener(this);
            }
            this.f33618i = new easypay.appinvoke.actions.b(null, this.f33613d, this.f33614e, null);
            m0();
            IntentFilter intentFilter = new IntentFilter(Constants.EASYPAY_ACTION_OLD_FILE_DOWNLOADED);
            intentFilter.addAction(Constants.EASYPAY_ACTION_FILE_DOWNLOADED);
            try {
                this.f33614e.registerReceiver(this.N0, intentFilter);
            } catch (Exception e8) {
                e8.printStackTrace();
                easypay.appinvoke.utils.b.a("EXCEPTION", e8);
            }
        } catch (Exception e9) {
            e9.printStackTrace();
            easypay.appinvoke.utils.b.a("EXCEPTION", e9);
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z7) {
        CheckBox checkBox;
        this.f33631v = z7;
        if (!z7 || (checkBox = this.F) == null) {
            CheckBox checkBox2 = this.F;
            if (checkBox2 != null) {
                checkBox2.setButtonDrawable(R.drawable.ic_checkbox_unselected);
                this.f33635z = false;
            }
            PaytmAssist.getAssistInstance().getmEventMap().put("rememberUserId", "UnChecked");
            return;
        }
        checkBox.setButtonDrawable(R.drawable.ic_checkbox_selected);
        this.f33635z = true;
        SharedPreferences.Editor editorEdit = this.f33614e.getSharedPreferences(Constants.BANKPREF, 0).edit();
        this.f33626q = editorEdit;
        editorEdit.putString(Constants.USER_ID_NET_BANK_KEY, "abcd");
        this.f33626q.apply();
        PaytmAssist.getAssistInstance().getmEventMap().put("rememberUserId", "Checked");
    }

    @Override // android.view.View.OnClickListener
    @TargetApi(19)
    public void onClick(View view) {
        easypay.appinvoke.actions.b bVar;
        try {
            if (view.getId() == R.id.img_hide_assist) {
                p0();
                return;
            }
            if (view.getId() == R.id.img_show_assist) {
                H0();
                return;
            }
            if (view.getId() == R.id.img_paytm_assist_banner) {
                this.B0.performClick();
                return;
            }
            if (view.getId() == R.id.tv_detection_status) {
                this.A0.performClick();
                return;
            }
            if (view.getId() == R.id.tv_user_id_one) {
                this.f33618i.E(this.W.getText().toString());
                B0(this.W.getText().toString());
                K0(false, this.M);
                return;
            }
            if (view.getId() == R.id.tv_user_id_two) {
                this.f33618i.E(this.X.getText().toString());
                B0(this.X.getText().toString());
                K0(false, this.M);
                return;
            }
            if (view.getId() == R.id.tv_user_id_three) {
                this.f33618i.E(this.Y.getText().toString());
                B0(this.Y.getText().toString());
                return;
            }
            if (view.getId() == R.id.nb_bt_submit) {
                if (!this.B || (bVar = this.f33618i) == null) {
                    this.G.setText("");
                    return;
                }
                bVar.w(Constants.SUBMIT_BTN, this.R.get(Constants.SUBMIT_BTN));
                GAEventManager gAEventManager = this.f33609J;
                if (gAEventManager != null) {
                    gAEventManager.K(this.f33631v);
                    this.f33609J.C(this.A ? false : true);
                    this.f33609J.A(true);
                    return;
                }
                return;
            }
            if (view.getId() == R.id.nb_image_bt_next) {
                this.f33618i.w(Constants.NEXT_BTN, this.R.get(Constants.NEXT_BTN));
                return;
            }
            if (view.getId() == R.id.nb_image_bt_previous) {
                this.f33618i.w(Constants.PREVIOUS_BTN, this.R.get(Constants.PREVIOUS_BTN));
                return;
            }
            if (view.getId() == R.id.tv_tap_to_pause) {
                try {
                    PaytmAssist.getAssistInstance().getmEventMap().put("pauseBtnClicked", Boolean.TRUE);
                    GAEventManager gAEventManager2 = this.f33609J;
                    if (gAEventManager2 != null) {
                        gAEventManager2.e(true);
                    }
                    CountDownTimer countDownTimer = this.K0;
                    if (countDownTimer != null) {
                        countDownTimer.cancel();
                    }
                    s0();
                    return;
                } catch (Exception e8) {
                    e8.printStackTrace();
                    easypay.appinvoke.utils.b.a("EXCEPTION", e8);
                    return;
                }
            }
            if (view.getId() == R.id.btn_submit_otp) {
                GAEventManager gAEventManager3 = this.f33609J;
                if (gAEventManager3 != null) {
                    gAEventManager3.z(true, 1);
                    this.f33609J.E(false);
                }
                CountDownTimer countDownTimer2 = this.K0;
                if (countDownTimer2 != null) {
                    countDownTimer2.cancel();
                }
                I0();
                return;
            }
            if (view.getId() == R.id.img_pwd_show) {
                try {
                    PaytmAssist.getAssistInstance().getmEventMap().put("showPasswordClicked", Boolean.valueOf(this.A));
                    if (this.A) {
                        Drawable drawable = this.f33614e.getBaseContext().getResources().getDrawable(R.drawable.ic_hide_passcode);
                        drawable.setBounds(0, 0, 24, 24);
                        this.D0.setCompoundDrawables(drawable, null, null, null);
                        this.D0.setText(getString(R.string.hide));
                        this.G.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                        this.A = false;
                    } else {
                        Drawable drawable2 = this.f33614e.getBaseContext().getResources().getDrawable(R.drawable.ic_show_passcode);
                        drawable2.setBounds(0, 0, 24, 24);
                        this.D0.setCompoundDrawables(drawable2, null, null, null);
                        this.D0.setText(getString(R.string.show));
                        this.G.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        EditText editText = this.G;
                        editText.setSelection(editText.getText().length());
                        this.A = true;
                    }
                    return;
                } catch (Exception e9) {
                    e9.printStackTrace();
                    return;
                }
            }
            return;
            e.printStackTrace();
        } catch (NullPointerException e10) {
            e10.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.easypay_browser_frag_revamp, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        EditText editText = this.H;
        if (editText != null) {
            editText.removeTextChangedListener(this.L0);
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        BroadcastReceiver broadcastReceiver;
        super.onDestroyView();
        try {
            if (this.N != null && this.O != null) {
                String str = "" + this.N + "";
                String str2 = "" + this.O + "";
                easypay.appinvoke.utils.b.a(str + str2 + " Check", this);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    this.f33609J.g(str);
                    this.f33609J.N(str2);
                    this.f33609J.l(PaytmAssist.getAssistInstance().getmEventMap());
                }
            } else if (!TextUtils.isEmpty("time not captured") && !TextUtils.isEmpty("time not captured")) {
                this.f33609J.g("time not captured");
                this.f33609J.N("time not captured");
            }
            GAEventManager gAEventManager = this.f33609J;
            if (gAEventManager != null) {
                gAEventManager.B(this.f33624o);
                if (this.f33609J.R() != null) {
                    Intent intent = new Intent(this.f33614e, (Class<?>) AnalyticsService.class);
                    intent.putExtra("data", this.f33609J.R());
                    AnalyticsService.l(this.f33614e.getBaseContext(), intent);
                }
            }
            easypay.appinvoke.actions.f fVar = this.f33621l;
            if (fVar != null) {
                fVar.n();
            }
            AppCompatActivity appCompatActivity = this.f33614e;
            if (appCompatActivity != null && (broadcastReceiver = this.N0) != null) {
                appCompatActivity.unregisterReceiver(broadcastReceiver);
            }
            AppCompatActivity appCompatActivity2 = this.f33614e;
            if (appCompatActivity2 != null) {
                easypay.appinvoke.actions.e eVar = this.f33615f;
                if (eVar != null) {
                    BroadcastReceiver broadcastReceiver2 = eVar.f33779z;
                    if (broadcastReceiver2 != null) {
                        appCompatActivity2.unregisterReceiver(broadcastReceiver2);
                    }
                    BroadcastReceiver broadcastReceiver3 = this.f33615f.f33778y;
                    if (broadcastReceiver3 != null) {
                        this.f33614e.unregisterReceiver(broadcastReceiver3);
                    }
                    easypay.appinvoke.actions.e eVar2 = this.f33615f;
                    EasypayWebViewClient easypayWebViewClient = eVar2.f33754a;
                    if (easypayWebViewClient != null) {
                        easypayWebViewClient.removeAssistWebClientListener(eVar2);
                    }
                }
                easypay.appinvoke.actions.d dVar = this.f33616g;
                if (dVar != null) {
                    dVar.P();
                }
            }
            PaytmAssist.getAssistInstance().setFragmentResumed(false);
            PaytmAssist.getAssistInstance().setFragmentPaused(false);
        } catch (NullPointerException e8) {
            e8.printStackTrace();
            easypay.appinvoke.utils.b.a("EXCEPTION", e8);
        } catch (Exception e9) {
            e9.printStackTrace();
            easypay.appinvoke.utils.b.a("EXCEPTION", e9);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        PaytmAssist.getAssistInstance().setFragmentResumed(false);
        PaytmAssist.getAssistInstance().setFragmentPaused(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        PaytmAssist.getAssistInstance().setFragmentResumed(true);
        PaytmAssist.getAssistInstance().setFragmentPaused(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        CountDownTimer countDownTimer = this.K0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        s0();
    }

    @Override // x4.f
    public void r(WebView webView, String str) {
    }

    void r0(int i7, Object obj) {
        if (isAdded() && i7 == 155) {
            this.f33616g = new easypay.appinvoke.actions.d(this.f33614e, this.f33613d, PaytmAssist.getAssistInstance().getFragment(), this.f33628s);
            if (this.R.size() > 0) {
                this.f33616g.J(this.R);
                easypay.appinvoke.utils.b.a("NB OTP Flow Started" + obj, this);
                this.Q.successEvent(Constants.OTP_FILLER_WEB_SUCCESS, "");
            }
        }
    }

    void s0() {
        this.F0.setVisibility(8);
        this.E0.setVisibility(8);
    }

    @JavascriptInterface
    public void sendBnkDtlToApp(String str) {
        HashMap map = (HashMap) new com.google.gson.f().o(str, new g().getType());
        Intent intent = new Intent(this.f33614e, (Class<?>) EasyPayConfigDownloader.class);
        intent.putExtra(Constants.EXTRA_BANK_REQ_JSON, str);
        EasyPayConfigDownloader.n(this.f33614e.getBaseContext(), intent);
        String str2 = map.get(Constants.EXTRA_BANK_CODE) + "-" + map.get("payType");
        PaytmAssist.getAssistInstance().setTxnBank(map.get(Constants.EXTRA_BANK_CODE).toString());
        PaytmAssist.getAssistInstance().setTxnPayType(map.get("payType").toString().toLowerCase());
        String lowerCase = str2.toLowerCase();
        GAEventManager gAEventManager = this.f33609J;
        if (gAEventManager != null) {
            gAEventManager.y(lowerCase);
            this.f33609J.f(lowerCase);
            if (lowerCase.contains("atm") || lowerCase.contains("idebit") || lowerCase.contains(Constants.EASYPAY_PAYTYPE_ATM) || lowerCase.contains("Idebit")) {
                this.f33609J.n(true);
            }
        }
    }

    @JavascriptInterface
    public void sendEvent(String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setAction("com.paytm.com.paytm.pgsdk.easypay.appinvoke.CUSTOM_EVENT");
        intent.putExtra("eventName", str);
        intent.putExtra("data0", str2);
        intent.putExtra("data1", str3);
        this.f33614e.sendBroadcast(intent);
    }

    @JavascriptInterface
    public void showLog(String str) {
        if (str.equals("not found -Net Banking js Injection")) {
            t0("", 0);
        } else {
            if (!str.equals("not found - 0") || TextUtils.isEmpty(PaytmAssist.getAssistInstance().getLastLoadedUrl())) {
                return;
            }
            b0(this.f33613d, PaytmAssist.getAssistInstance().getLastLoadedUrl(), "");
        }
    }

    void t0(String str, int i7) {
        this.f33614e.runOnUiThread(new j(i7, str));
    }

    @Override // x4.f
    public void y(WebView webView, String str) {
        this.O = Long.valueOf(System.currentTimeMillis());
        StringBuilder sb = this.f33624o;
        if (sb != null) {
            sb.append(str);
            this.f33624o.append("|");
        }
        l0();
    }

    void y0() {
        RelativeLayout relativeLayout = this.P;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    @Override // x4.f
    public boolean z(WebView webView, Object obj) {
        return false;
    }

    public void z0() {
        easypay.appinvoke.actions.e eVar = this.f33615f;
        if (eVar != null) {
            eVar.A();
            this.f33615f = null;
        }
        easypay.appinvoke.actions.g gVar = this.f33619j;
        if (gVar != null) {
            gVar.c();
            this.f33619j = null;
        }
        easypay.appinvoke.actions.h hVar = this.f33620k;
        if (hVar != null) {
            hVar.e();
            this.f33620k = null;
        }
        easypay.appinvoke.actions.f fVar = this.f33621l;
        if (fVar != null) {
            fVar.i();
            this.f33621l = null;
        }
        if (this.f33622m != null) {
            this.f33622m = null;
        }
    }
}
