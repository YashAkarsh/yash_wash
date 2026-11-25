package easypay.appinvoke.actions;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.CheckBox;
import easypay.appinvoke.manager.Constants;
import easypay.appinvoke.manager.EasyPayHelper;
import easypay.appinvoke.manager.EasypayWebViewClient;
import easypay.appinvoke.manager.PaytmAssist;
import java.util.ArrayList;
import java.util.HashMap;
import paytm.assist.easypay.easypay.appinvoke.R;

/* JADX INFO: loaded from: classes2.dex */
class b implements x4.f, x4.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, w4.g> f33654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f33655b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CheckBox f33657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Activity f33658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private WebView f33659f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private EasypayBrowserFragment f33660g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private StringBuilder f33661h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private GAEventManager f33662i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private w4.g f33663j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f33656c = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f33664k = 0;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ w4.g f33665a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f33666b;

        a(w4.g gVar, String str) {
            this.f33665a = gVar;
            this.f33666b = str;
        }

        /* JADX WARN: Code duplicated, block: B:36:0x0074  */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // java.lang.Runnable
        public void run() {
            byte b8;
            w4.g gVar = this.f33665a;
            if (gVar == null || TextUtils.isEmpty(gVar.c())) {
                return;
            }
            try {
                String str = this.f33666b;
                switch (str.hashCode()) {
                    case -2086665488:
                        if (!str.equals(Constants.NEXT_BTN)) {
                            b8 = -1;
                        } else {
                            b8 = 2;
                        }
                        break;
                    case -1590453867:
                        if (!str.equals(Constants.SUBMIT_BTN)) {
                            b8 = -1;
                        } else {
                            b8 = 1;
                        }
                        break;
                    case -469982381:
                        if (!str.equals(Constants.AUTOFILL_USERID)) {
                            b8 = -1;
                        } else {
                            b8 = 8;
                        }
                        break;
                    case -83625758:
                        if (!str.equals(Constants.READ_OTP)) {
                            b8 = -1;
                        } else {
                            b8 = 0;
                        }
                        break;
                    case 64933036:
                        if (!str.equals(Constants.PASSWORD_INPUT_REGISTER)) {
                            b8 = -1;
                        } else {
                            b8 = 7;
                        }
                        break;
                    case 1110972755:
                        if (!str.equals(Constants.FILLER_FROM_CODE)) {
                            b8 = -1;
                        } else {
                            b8 = 4;
                        }
                        break;
                    case 1201244404:
                        if (!str.equals(Constants.PREVIOUS_BTN)) {
                            b8 = -1;
                        } else {
                            b8 = 3;
                        }
                        break;
                    case 1559877390:
                        if (!str.equals(Constants.FILLER_FROM_WEB)) {
                            b8 = -1;
                        } else {
                            b8 = 5;
                        }
                        break;
                    case 1881123402:
                        if (!str.equals(Constants.PASSWORD_FINDER)) {
                            b8 = -1;
                        } else {
                            b8 = 6;
                        }
                        break;
                    default:
                        b8 = -1;
                        break;
                }
                switch (b8) {
                    case 1:
                        easypay.appinvoke.utils.b.a("Action  SUBMIT_BTN", this);
                        b.this.A(this.f33665a.c());
                        if (b.this.f33660g != null && b.this.f33660g.isAdded()) {
                            b.this.f33660g.t0("", 3);
                            break;
                        }
                        break;
                    case 2:
                        easypay.appinvoke.utils.b.a("Action  NEXT_BTN", this);
                        b.this.A(this.f33665a.c());
                        break;
                    case 3:
                        b.this.A(this.f33665a.c());
                        break;
                    case 4:
                    default:
                        break;
                    case 5:
                        easypay.appinvoke.utils.b.a(" called Action FILLER_FROM_WEB ", this);
                        b.this.A(this.f33665a.c());
                        break;
                    case 6:
                    case 7:
                        b.this.A(this.f33665a.c());
                        break;
                    case 8:
                        easypay.appinvoke.utils.b.a("Inside AUTOFILL_USERID", this);
                        b.this.f33663j = this.f33665a;
                        b.this.u();
                        break;
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: easypay.appinvoke.actions.b$b, reason: collision with other inner class name */
    class RunnableC0407b implements Runnable {

        /* JADX INFO: renamed from: easypay.appinvoke.actions.b$b$a */
        class a extends com.google.gson.reflect.a<HashMap<String, ArrayList<String>>> {
            a() {
            }
        }

        /* JADX INFO: renamed from: easypay.appinvoke.actions.b$b$b, reason: collision with other inner class name */
        class RunnableC0408b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f33670a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ArrayList f33671b;

            RunnableC0408b(String str, ArrayList arrayList) {
                this.f33670a = str;
                this.f33671b = arrayList;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f33660g.B0(this.f33670a);
                if (b.this.f33664k <= 1) {
                    b.this.f33660g.J0(b.this.f33664k, false);
                    b.this.f33660g.L0(false);
                } else {
                    b.this.f33660g.J0(b.this.f33664k, true);
                    b.this.f33660g.L0(true);
                    b.this.f33660g.D0(this.f33671b);
                }
            }
        }

        /* JADX INFO: renamed from: easypay.appinvoke.actions.b$b$c */
        class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ArrayList f33673a;

            c(ArrayList arrayList) {
                this.f33673a = arrayList;
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                bVar.v((String) this.f33673a.get(bVar.f33664k - 1));
                b.this.f33660g.f0();
            }
        }

        RunnableC0407b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String string = new easypay.appinvoke.utils.c(b.this.f33658e.getApplicationContext(), "PaytmAsist").getString(Constants.USER_ID_NET_BANK_KEY, "");
            easypay.appinvoke.utils.b.a("inside fetch USerID" + string, this);
            try {
                HashMap map = (HashMap) new com.google.gson.f().o(string, new a().getType());
                if (map != null) {
                    easypay.appinvoke.utils.b.a("inside fetch USerID", this);
                    ArrayList arrayList = (ArrayList) map.get(b.this.f33655b);
                    if (arrayList != null) {
                        b.this.f33664k = arrayList.size();
                        if (b.this.f33664k > 0) {
                            String str = (String) arrayList.get(b.this.f33664k - 1);
                            if (b.this.f33658e != null && !b.this.f33658e.isFinishing()) {
                                b.this.f33658e.runOnUiThread(new RunnableC0408b(str, arrayList));
                            }
                            if (b.this.f33658e == null || b.this.f33658e.isFinishing()) {
                                return;
                            }
                            b.this.f33658e.runOnUiThread(new c(arrayList));
                        }
                    }
                }
            } catch (Exception e8) {
                e8.printStackTrace();
            }
        }
    }

    class c implements ValueCallback<String> {
        c() {
        }

        @Override // android.webkit.ValueCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f33676a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f33677b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f33678c;

        d(int i7, String str, String str2) {
            this.f33676a = i7;
            this.f33677b = str;
            this.f33678c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i7 = this.f33676a;
            if (i7 == 106) {
                b bVar = b.this;
                bVar.w(Constants.PASSWORD_FINDER, (w4.g) bVar.f33654a.get(Constants.PASSWORD_FINDER));
            }
            if (i7 == 108) {
                if (b.this.f33660g.e0() != null) {
                    b.this.f33660g.e0().H("");
                    return;
                }
                return;
            }
            if (i7 == 157) {
                if (b.this.f33657d == null || !b.this.f33657d.isChecked()) {
                    return;
                }
                b.this.B(this.f33678c);
                return;
            }
            switch (i7) {
                case 151:
                    b.this.f33661h.append(this.f33677b);
                    b.this.f33660g.t0(this.f33677b, 1);
                    break;
                case Constants.ACTION_UID_VIEWER /* 152 */:
                    if (!Constants.IS_RELEASE_8_1_0) {
                        b.this.f33660g.g0();
                        b.this.f33660g.M0(R.id.layout_netbanking, Boolean.TRUE);
                        b.this.f33660g.G0(this.f33677b);
                        b.this.f33660g.V++;
                        if (!b.this.f33656c) {
                            b.this.f33656c = true;
                            easypay.appinvoke.utils.b.a("Autofill called", this);
                            b bVar2 = b.this;
                            bVar2.w(Constants.AUTOFILL_USERID, (w4.g) bVar2.f33654a.get(Constants.AUTOFILL_USERID));
                        }
                    } else {
                        b.this.f33660g.t0(this.f33677b, 0);
                    }
                    break;
                case 153:
                    b.this.f33660g.t0(this.f33677b, 3);
                    break;
                default:
                    switch (i7) {
                        case 159:
                            b.this.f33660g.f0();
                            break;
                        case 160:
                            b.this.f33660g.g0();
                            if (b.this.f33664k > 0) {
                                b.this.f33660g.L0(true);
                            }
                            break;
                        case 161:
                            b.this.f33660g.t0("", 5);
                            break;
                    }
                    break;
            }
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = b.this;
            bVar.w(Constants.PASSWORD_FINDER, (w4.g) bVar.f33654a.get(Constants.PASSWORD_FINDER));
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f33681a;

        f(int i7) {
            this.f33681a = i7;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i7 = this.f33681a;
            if (i7 == 154) {
                b.this.f33660g.M0(R.id.layout_netbanking, Boolean.TRUE);
                b.this.f33660g.t0("", 1);
            } else {
                if (i7 != 156) {
                    return;
                }
                b.this.f33660g.M0(R.id.layout_netbanking, Boolean.TRUE);
                b.this.f33660g.t0("", 1);
            }
        }
    }

    class g extends com.google.gson.reflect.a<HashMap<String, ArrayList<String>>> {
        g() {
        }
    }

    @SuppressLint({"AddJavascriptInterface"})
    b(HashMap<String, w4.g> map, WebView webView, Activity activity, w4.a aVar) {
        if (map != null) {
            try {
                this.f33654a = map;
            } catch (Exception e8) {
                e8.printStackTrace();
                easypay.appinvoke.utils.b.a("EXCEPTION", e8);
                return;
            }
        }
        if (aVar != null) {
            this.f33655b = aVar.a();
        }
        this.f33659f = webView;
        this.f33658e = activity;
        this.f33657d = (CheckBox) activity.findViewById(R.id.cb_nb_userId);
        EasyPayHelper easyPayHelper = PaytmAssist.getAssistInstance().getEasyPayHelper();
        this.f33662i = PaytmAssist.getAssistInstance().getmAnalyticsManager();
        this.f33660g = PaytmAssist.getAssistInstance().getFragment();
        easyPayHelper.addJsCallListener(this);
        PaytmAssist.getAssistInstance().getmAnalyticsManager().h(true);
        EasypayWebViewClient webClientInstance = PaytmAssist.getAssistInstance().getWebClientInstance();
        PaytmAssist.getAssistInstance().getmAnalyticsManager().d(webView.getUrl());
        this.f33662i.h(true);
        webClientInstance.addAssistWebClientListener(this);
        this.f33661h = new StringBuilder();
        this.f33660g.F0(true);
        PaytmAssist.getAssistInstance().getmEventMap().put("rememberUserId", "Checked");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String str) {
        try {
            if (this.f33659f == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f33659f.evaluateJavascript(str, new c());
        } catch (Exception e8) {
            e8.printStackTrace();
            easypay.appinvoke.utils.b.a("EXCEPTION", e8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(String str) {
        String strZ;
        try {
            EasypayBrowserFragment easypayBrowserFragment = this.f33660g;
            if (easypayBrowserFragment == null || easypayBrowserFragment.f33631v) {
                easypay.appinvoke.utils.c cVar = new easypay.appinvoke.utils.c(this.f33658e.getApplicationContext(), "PaytmAsist");
                easypay.appinvoke.utils.c.a aVarEdit = cVar.edit();
                String str2 = this.f33655b;
                HashMap map = (HashMap) new com.google.gson.f().o(cVar.getString(Constants.USER_ID_NET_BANK_KEY, ""), new g().getType());
                com.google.gson.f fVar = new com.google.gson.f();
                if (map != null) {
                    ArrayList arrayList = (ArrayList) map.get(this.f33655b);
                    if (arrayList != null) {
                        if (arrayList.contains(str)) {
                            arrayList.remove(str);
                            arrayList.add(str);
                        } else if (arrayList.size() == 3) {
                            arrayList.remove(0);
                            arrayList.add(str);
                        } else {
                            arrayList.add(str);
                        }
                        map.put(str2, arrayList);
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(str);
                        map.put(str2, arrayList2);
                    }
                    strZ = fVar.z(map);
                } else {
                    HashMap map2 = new HashMap();
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(str);
                    map2.put(str2, arrayList3);
                    strZ = fVar.z(map2);
                }
                aVarEdit.putString(Constants.USER_ID_NET_BANK_KEY, strZ);
                aVarEdit.apply();
            }
        } catch (Exception e8) {
            e8.printStackTrace();
            easypay.appinvoke.utils.b.a("EXCEPTION", e8);
        }
    }

    private void D(int i7) {
        try {
            Activity activity = this.f33658e;
            if (activity == null || this.f33660g == null) {
                return;
            }
            activity.runOnUiThread(new f(i7));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        easypay.appinvoke.utils.b.a("inside fetch USerID before run", this);
        new Thread(new RunnableC0407b()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str) {
        String strC = this.f33663j.c();
        try {
            int iIndexOf = strC.indexOf("''");
            StringBuilder sb = new StringBuilder();
            int i7 = iIndexOf + 1;
            sb.append(strC.substring(0, i7));
            sb.append(str);
            sb.append(strC.substring(i7));
            String string = sb.toString();
            easypay.appinvoke.utils.b.a("Autofill JS After UserId" + string, this);
            EasypayBrowserFragment easypayBrowserFragment = this.f33660g;
            if (easypayBrowserFragment != null && easypayBrowserFragment.isAdded()) {
                this.f33660g.G0(str);
            }
            easypay.appinvoke.utils.b.a("autofill js:" + string, this);
            A(string);
            GAEventManager gAEventManager = this.f33662i;
            if (gAEventManager != null) {
                gAEventManager.q(true);
            }
        } catch (Exception e8) {
            GAEventManager gAEventManager2 = this.f33662i;
            if (gAEventManager2 != null) {
                gAEventManager2.q(false);
            }
            e8.printStackTrace();
            easypay.appinvoke.utils.b.a("EXCEPTION", e8);
        }
    }

    void C(HashMap<String, w4.g> map, w4.a aVar) {
        if (map != null) {
            try {
                this.f33654a = map;
            } catch (Exception e8) {
                e8.printStackTrace();
                easypay.appinvoke.utils.b.a("EXCEPTION", e8);
                return;
            }
        }
        if (aVar != null) {
            this.f33655b = aVar.a();
        }
        HashMap<String, w4.g> map2 = this.f33654a;
        if (map2 == null || !map2.containsKey(Constants.FILLER_FROM_WEB)) {
            return;
        }
        w(Constants.FILLER_FROM_WEB, this.f33654a.get(Constants.FILLER_FROM_WEB));
    }

    void E(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        v(str);
    }

    @Override // x4.e
    public void a(String str, String str2, int i7) {
        try {
            if (i7 == 100) {
                w(Constants.SUBMIT_BTN, this.f33654a.get(Constants.SUBMIT_BTN));
            } else if (i7 != 106) {
                switch (i7) {
                    case 154:
                        D(154);
                        w(Constants.PASSWORD_INPUT_REGISTER, this.f33654a.get(Constants.PASSWORD_INPUT_REGISTER));
                        break;
                    case Constants.ACTION_START_NB_OTP /* 155 */:
                        EasypayBrowserFragment easypayBrowserFragment = this.f33660g;
                        if (easypayBrowserFragment != null) {
                            easypayBrowserFragment.r0(Constants.ACTION_START_NB_OTP, "START OTP FROM NET BANKING");
                        }
                        break;
                    case Constants.ACTION_DELAY_PASSWORD_FOUND /* 156 */:
                        new Handler().postDelayed(new e(), 500L);
                        break;
                    default:
                        return;
                }
            } else {
                w(Constants.PASSWORD_FINDER, this.f33654a.get(Constants.PASSWORD_FINDER));
            }
        } catch (Exception unused) {
        }
    }

    @Override // x4.e
    public void b(String str, String str2, int i7) {
        try {
            this.f33658e.runOnUiThread(new d(i7, str2, str));
        } catch (Exception unused) {
        }
    }

    @Override // x4.f
    public void j(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
    }

    @Override // x4.f
    public void k(WebView webView, String str, Bitmap bitmap) {
    }

    @Override // x4.f
    public void r(WebView webView, String str) {
    }

    void w(String str, w4.g gVar) {
        try {
            Activity activity = this.f33658e;
            if (activity != null) {
                activity.runOnUiThread(new a(gVar, str));
            }
        } catch (Exception unused) {
        }
    }

    int x() {
        return this.f33664k;
    }

    @Override // x4.f
    public void y(WebView webView, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                EasypayBrowserFragment easypayBrowserFragment = this.f33660g;
                if (easypayBrowserFragment != null) {
                    easypayBrowserFragment.t0("", 4);
                    this.f33660g.t0("", 4);
                }
            } else {
                EasypayBrowserFragment easypayBrowserFragment2 = this.f33660g;
                if (easypayBrowserFragment2 != null) {
                    easypayBrowserFragment2.t0("", 3);
                }
            }
        } catch (Exception e8) {
            e8.printStackTrace();
            easypay.appinvoke.utils.b.a("EXCEPTION", e8);
        }
    }

    @Override // x4.f
    public boolean z(WebView webView, Object obj) {
        return false;
    }
}
