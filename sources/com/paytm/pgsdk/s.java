package com.paytm.pgsdk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import c.o0;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class s {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f33093p = "net.one97.paytm";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f33094q = "paytm_invoke";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f33095r = "auth_code";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f33096s = "content://net.one97.paytm.trustlogin.TrustInfo/user/token";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private l f33097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private i f33098b;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f33105i;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f33099c = "https://securegw.paytm.in/theia/api/v1/showPaymentPage";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f33100d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f33101e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f33102f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f33103g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f33104h = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Activity f33106j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Integer f33107k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f33108l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f33109m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final BroadcastReceiver f33110n = new a();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f33111o = true;

    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (d.H.equals(intent.getAction())) {
                androidx.localbroadcastmanager.content.a.b(context.getApplicationContext()).f(s.this.f33110n);
                boolean booleanExtra = intent.getBooleanExtra(d.f32997J, false);
                if (s.this.f33106j == null || s.this.f33107k == null) {
                    return;
                }
                if (booleanExtra) {
                    s sVar = s.this;
                    sVar.z(sVar.f33106j, s.this.f33107k.intValue());
                    return;
                } else {
                    s sVar2 = s.this;
                    sVar2.y(sVar2.f33106j);
                    return;
                }
            }
            if (d.I.equalsIgnoreCase(intent.getAction())) {
                androidx.localbroadcastmanager.content.a.b(context.getApplicationContext()).f(s.this.f33110n);
                if (!intent.getBooleanExtra(d.L, false)) {
                    s sVar3 = s.this;
                    sVar3.E(sVar3.f33106j, s.this.f33107k.intValue(), s.this.f33109m);
                    return;
                }
                boolean booleanExtra2 = intent.getBooleanExtra(d.K, false);
                if (s.this.f33106j == null || s.this.f33107k == null) {
                    return;
                }
                if (booleanExtra2) {
                    s sVar4 = s.this;
                    sVar4.z(sVar4.f33106j, s.this.f33107k.intValue());
                } else {
                    s sVar5 = s.this;
                    sVar5.y(sVar5.f33106j);
                }
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f33113a;

        b(Activity activity) {
            this.f33113a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            s.this.y(this.f33113a);
        }
    }

    public s(i iVar, l lVar) {
        if (iVar == null) {
            throw new IllegalArgumentException("Transaction params cannot be null");
        }
        this.f33097a = lVar;
        this.f33098b = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(Activity activity, int i7, String str) {
        if (!TextUtils.isEmpty(g(activity, str))) {
            z(activity, i7);
        } else if (this.f33108l) {
            new Handler().postDelayed(new b(activity), 2500L);
        } else {
            y(activity);
        }
    }

    private int F(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 1;
        }
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        int i7 = 0;
        while (i7 < strArrSplit.length && i7 < strArrSplit2.length && strArrSplit[i7].equalsIgnoreCase(strArrSplit2[i7])) {
            i7++;
        }
        return (i7 >= strArrSplit.length || i7 >= strArrSplit2.length) ? Integer.signum(strArrSplit.length - strArrSplit2.length) : Integer.signum(Integer.valueOf(strArrSplit[i7]).compareTo(Integer.valueOf(strArrSplit2[i7])));
    }

    @o0
    private String g(Context context, String str) {
        if (!n(context) && this.f33100d) {
            return null;
        }
        this.f33108l = false;
        Cursor cursorJ = j(context, str);
        String strH = h(cursorJ);
        if (cursorJ != null && TextUtils.isEmpty(strH)) {
            return null;
        }
        if (cursorJ == null || TextUtils.isEmpty(strH)) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(f33093p, "net.one97.paytm.nativesdk.InvokePaytmTransparentActivity"));
                if (intent.resolveActivity(context.getPackageManager()) != null) {
                    this.f33108l = true;
                    context.startActivity(intent);
                    strH = h(j(context, str));
                }
            } catch (Exception e8) {
                p.k(e8);
            }
        }
        if (TextUtils.isEmpty(strH)) {
            p.a("Auth Code is EMPTY");
        } else {
            p.a("Auth Code: " + strH);
        }
        return strH;
    }

    @o0
    private String h(@o0 Cursor cursor) {
        String string;
        if (cursor == null) {
            return null;
        }
        cursor.moveToFirst();
        do {
            string = cursor.getString(cursor.getColumnIndex(f33095r));
            p.a("Found Authtoken credential as " + string);
        } while (cursor.moveToNext());
        cursor.close();
        return string;
    }

    @o0
    private Cursor j(Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("client_id", str);
            jSONObject.put("isTrusted", true);
            jSONObject.put("shouldMatchMobile", false);
            jSONObject.put("package", "net.one97.paytm.nativesdk");
        } catch (JSONException e8) {
            e8.printStackTrace();
        }
        return context.getContentResolver().query(Uri.parse(f33096s), null, jSONObject.toString(), null, null);
    }

    private HashMap<String, Object> k() {
        HashMap<String, Object> map = new HashMap<>();
        String str = this.f33105i;
        if (str != null && !str.isEmpty()) {
            map.put("hybridPlatform", this.f33105i);
        }
        if (map.isEmpty()) {
            return null;
        }
        return map;
    }

    private String l(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(f33093p, 0).versionName;
        } catch (Exception e8) {
            com.paytm.pgsdk.a.e().f(d.f33011n, e8.getMessage());
            p.a("Paytm app not installed");
            return null;
        }
    }

    private boolean m() {
        return this.f33111o;
    }

    private boolean n(Context context) {
        try {
            context.getPackageManager().getPackageInfo(f33093p, 0);
            com.paytm.pgsdk.a.e().h(d.f33014q, d.f33011n, d.A, "true");
            return true;
        } catch (Exception unused) {
            com.paytm.pgsdk.a.e().h(d.f33014q, d.f33011n, d.A, d.G);
            p.a("Paytm app not installed");
            return false;
        }
    }

    private boolean o() {
        return this.f33102f;
    }

    private void x(Activity activity, int i7) {
        double d8;
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        HashMap<String, String> mapA = this.f33098b.a();
        String str = mapA.get(d.f33000c);
        try {
            d8 = Double.parseDouble(str);
        } catch (NumberFormatException e8) {
            com.paytm.pgsdk.a.e().f(d.f33011n, e8.getMessage());
            d8 = 0.0d;
        }
        bundle.putBoolean("nativeSdkEnabled", true);
        bundle.putString("orderid", mapA.get(d.f32998a));
        bundle.putString("txnToken", mapA.get(d.f33007j));
        bundle.putString("mid", mapA.get("MID"));
        bundle.putDouble("nativeSdkForMerchantAmount", d8);
        String strL = l(activity);
        com.paytm.pgsdk.a.e().j(d.f33020w, d.f33011n, com.paytm.pgsdk.a.e().c(this.f33098b), strL);
        try {
            if (F(strL, "8.6.0") < 0) {
                intent.setComponent(new ComponentName(f33093p, "net.one97.paytm.AJRJarvisSplash"));
            } else {
                intent.setComponent(new ComponentName(f33093p, "net.one97.paytm.AJRRechargePaymentActivity"));
                intent.putExtra("enable_paytm_invoke", true);
                intent.putExtra(f33094q, true);
                intent.putExtra(com.haier.globalwasher.presenter.o.f25216w, str);
                intent.putExtra("nativeSdkEnabled", true);
                intent.putExtra("orderid", mapA.get(d.f32998a));
                intent.putExtra("txnToken", mapA.get(d.f33007j));
                intent.putExtra("mid", mapA.get("MID"));
                intent.addFlags(134217728);
            }
            intent.putExtra("isFromAIO", true);
            intent.putExtra("paymentmode", 2);
            intent.putExtra("bill", bundle);
            intent.putExtra("isFromAIO", true);
            HashMap<String, Object> mapK = k();
            if (mapK != null) {
                intent.putExtra("extraParams", mapK);
            }
            com.paytm.pgsdk.a.e().i(d.f33015r, d.f33011n, "status", "success", strL);
            try {
                activity.startActivityForResult(intent, i7);
            } catch (Exception unused) {
                com.paytm.pgsdk.a.e().i(d.f33015r, d.f33011n, "status", d.E, strL);
                y(activity);
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Context context) {
        j jVarI = j.i(this.f33098b, this.f33099c);
        jVarI.n(this.f33098b, null);
        jVarI.p(m());
        jVarI.q(context, true, this.f33097a);
    }

    public void A(Activity activity, int i7, String str) {
        com.paytm.pgsdk.a.e().g(d.f33013p, "", com.paytm.pgsdk.a.e().c(this.f33098b));
        String strL = l(activity);
        if (!p.i(activity) || !this.f33100d || F(strL, str) < 0) {
            if (!this.f33101e) {
                this.f33097a.c("Some Error Occurred in Selected payment Flow . Please  enableRedirectionFlow true ");
                p.a("No payment flow opted");
                return;
            } else {
                com.paytm.pgsdk.a.e().h(d.f33015r, d.f33011n, "status", d.E);
                com.paytm.pgsdk.a.e().g(d.f33019v, d.f33012o, com.paytm.pgsdk.a.e().c(this.f33098b));
                y(activity);
                return;
            }
        }
        if ((!o() || F(strL, "8.10.8") >= 0) && ((!this.f33103g || F(strL, "9.0.0") >= 0) && (!this.f33104h || F(strL, "9.10.0") >= 0))) {
            x(activity, i7);
        } else {
            y(activity);
        }
    }

    public void B(Activity activity, boolean z7, String str, String str2, int i7) {
        boolean zN = n(activity);
        if (TextUtils.isEmpty(str) || !zN || !this.f33100d || !z7) {
            z(activity, i7);
            return;
        }
        this.f33106j = activity;
        this.f33107k = Integer.valueOf(i7);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(d.H);
        androidx.localbroadcastmanager.content.a.b(activity.getApplicationContext()).c(this.f33110n, intentFilter);
        Intent intent = new Intent(activity, (Class<?>) AioMatchUserActivity.class);
        intent.putExtra(d.M, str);
        intent.putExtra(d.N, str2);
        activity.startActivity(intent);
    }

    public void C(Activity activity, String str, int i7) {
        if (!n(activity) || !this.f33100d) {
            z(activity, i7);
            return;
        }
        this.f33106j = activity;
        this.f33107k = Integer.valueOf(i7);
        this.f33109m = str;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(d.I);
        androidx.localbroadcastmanager.content.a.b(activity.getApplicationContext()).c(this.f33110n, intentFilter);
        Intent intent = new Intent(activity, (Class<?>) AioMatchUserActivity.class);
        intent.putExtra(AioMatchUserActivity.f32925f, true);
        activity.startActivity(intent);
    }

    public void D(Activity activity, int i7) {
        A(activity, i7, "8.12.8");
    }

    public String i() {
        return this.f33105i;
    }

    public void p(boolean z7) {
        this.f33100d = z7;
    }

    public void q(String str) {
        this.f33105i = str;
        com.paytm.pgsdk.a.e().k(str);
    }

    public void r(boolean z7) {
        this.f33104h = z7;
    }

    public void s(boolean z7) {
        this.f33111o = z7;
    }

    public void t(boolean z7) {
        this.f33103g = z7;
    }

    public void u(boolean z7) {
        this.f33101e = z7;
    }

    public void v(String str) {
        this.f33099c = str;
    }

    public void w(boolean z7) {
        this.f33102f = z7;
    }

    public void z(Activity activity, int i7) {
        A(activity, i7, "0.0.0");
    }

    public s() {
    }
}
