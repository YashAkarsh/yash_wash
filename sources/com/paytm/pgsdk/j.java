package com.paytm.pgsdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f33058n = "https://pguat.paytm.com/oltp/HANDLER_INTERNAL/TXNSTATUS";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f33059o = "https://secure.paytm.in/oltp/HANDLER_INTERNAL/TXNSTATUS";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f33060p = "https://pguat.paytm.com:8448/CAS/ChecksumGenerator";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f33061q = "https://secure.paytm.in/oltp-web/generateChecksum";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f33062r = "https://pguat.paytm.com/oltp/HANDLER_INTERNAL/CANCEL_TXN";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f33063s = "https://secure.paytm.in/oltp/HANDLER_INTERNAL/CANCEL_TXN";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f33064t = "https://pguat.paytm.com/oltp-web/processTransaction";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f33065u = "https://secure.paytm.in/oltp-web/processTransaction";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static volatile j f33066v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static String f33067w = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile i f33068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile f f33069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected volatile String f33070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected volatile String f33071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected volatile m f33072e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected volatile o f33073f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile boolean f33074g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile String f33075h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile l f33076i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f33077j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f33078k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f33079l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f33080m = true;

    public static String a() {
        return "https://" + d() + d.W;
    }

    private ApplicationInfo c(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        } catch (Exception e8) {
            a.e().f(d.f33012o, e8.getMessage());
            p.a(e8.getLocalizedMessage());
            return null;
        }
    }

    private static String d() {
        if (!TextUtils.isEmpty(h().f33071d)) {
            try {
                return new URL(h().f33071d).getHost();
            } catch (MalformedURLException unused) {
            }
        }
        return "securegw.paytm.in";
    }

    public static synchronized j f() {
        j jVarH;
        jVarH = h();
        jVarH.f33070c = "https://securegw.paytm.in/theia/closeOrder";
        jVarH.f33071d = "https://securegw-preprod.paytm.in/theia/processTransaction";
        q.a().e(true);
        return jVarH;
    }

    public static synchronized j g() {
        j jVarH;
        jVarH = h();
        jVarH.f33070c = "https://securegw.paytm.in/theia/closeOrder";
        jVarH.f33071d = "https://securegw.paytm.in/theia/processTransaction";
        q.a().e(true);
        return jVarH;
    }

    public static synchronized j h() {
        try {
            if (f33066v == null) {
                p.a("Creating an instance of Paytm PG Service...");
                f33066v = new j();
                p.a("Created a new instance of Paytm PG Service.");
            }
        } catch (Exception e8) {
            a.e().f(d.f33012o, e8.getMessage());
            p.k(e8);
        }
        return f33066v;
    }

    public static synchronized j i(i iVar, String str) {
        j jVarH;
        HashMap<String, String> mapA = iVar.a();
        if (TextUtils.isEmpty(str)) {
            str = "https://securegw.paytm.in/theia/api/v1/showPaymentPage";
        }
        String str2 = mapA.get(d.f32998a);
        String str3 = mapA.get("MID");
        jVarH = h();
        jVarH.f33071d = str + "?mid=" + str3 + "&orderId=" + str2;
        q.a().e(true);
        return jVarH;
    }

    public static synchronized j j(String str) {
        j jVarH;
        jVarH = h();
        jVarH.f33075h = f33058n;
        if (TextUtils.isEmpty(str)) {
            jVarH.f33071d = "https://securegw-stage.paytm.in/theia/processTransaction";
            f33067w = jVarH.f33071d;
        } else {
            jVarH.f33071d = str;
            f33067w = jVarH.f33071d;
        }
        q.a().e(false);
        return jVarH;
    }

    public static synchronized j k() {
        j jVarH;
        jVarH = h();
        jVarH.f33071d = "https://securegw-stage.paytm.in/theia/api/v1/showPaymentPage";
        return jVarH;
    }

    public static String l() {
        return "https://" + d() + d.X;
    }

    private boolean o() {
        return this.f33080m;
    }

    public void b(Context context) {
        ApplicationInfo applicationInfoC = c(context);
        if (applicationInfoC == null) {
            e.f(false);
            return;
        }
        int i7 = applicationInfoC.flags & 2;
        applicationInfoC.flags = i7;
        e.f(i7 != 0);
    }

    public String e() {
        return this.f33078k;
    }

    public l m() {
        return this.f33076i == null ? q.a().b() : this.f33076i;
    }

    public synchronized void n(i iVar, f fVar) {
        this.f33068a = iVar;
        if (this.f33068a.a() != null) {
            this.f33077j = this.f33068a.a().get("MID");
            this.f33078k = this.f33068a.a().get(d.f32998a);
            this.f33079l = this.f33068a.a().get(d.f33007j);
        }
        this.f33069b = fVar;
    }

    public void p(boolean z7) {
        this.f33080m = z7;
    }

    public synchronized void q(Context context, boolean z7, l lVar) {
        try {
            b(context);
            if (!p.h(context)) {
                s();
                lVar.d();
            } else if (this.f33074g) {
                p.a("Service is already running.");
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("mid", this.f33077j);
                bundle.putString("orderId", this.f33078k);
                bundle.putString("txnToken", this.f33079l);
                p.a("Starting the Service...");
                Intent intent = new Intent(context, (Class<?>) PaytmPGActivity.class);
                intent.putExtra("mid", this.f33077j);
                intent.putExtra("orderId", this.f33078k);
                intent.putExtra("Parameters", bundle);
                intent.putExtra("HIDE_HEADER", z7);
                intent.putExtra(d.f33008k, o());
                this.f33074g = true;
                this.f33076i = lVar;
                q.a().d(lVar);
                ((Activity) context).startActivity(intent);
                p.a("Service Started.");
            }
        } catch (Exception e8) {
            a.e().f(d.f33012o, e8.getMessage());
            s();
            p.k(e8);
        }
    }

    public synchronized void r(Context context, boolean z7, boolean z8, l lVar) {
        try {
            b(context);
            if (!p.h(context)) {
                s();
                lVar.d();
            } else {
                if (this.f33068a != null && (this.f33068a.a() == null || this.f33068a.a().size() <= 0)) {
                    lVar.f("Invalid Params passed", null);
                    return;
                }
                if (this.f33074g) {
                    p.a("Service is already running.");
                } else {
                    Bundle bundle = new Bundle();
                    if (this.f33068a != null) {
                        for (Map.Entry<String, String> entry : this.f33068a.a().entrySet()) {
                            p.a(entry.getKey() + " = " + entry.getValue());
                            bundle.putString(entry.getKey(), entry.getValue());
                        }
                    }
                    p.a("Starting the Service...");
                    Intent intent = new Intent(context, (Class<?>) PaytmPGActivity.class);
                    intent.putExtra("mid", this.f33077j);
                    intent.putExtra("orderId", this.f33078k);
                    intent.putExtra("Parameters", bundle);
                    intent.putExtra("HIDE_HEADER", z7);
                    intent.putExtra(d.f33008k, o());
                    intent.putExtra("SEND_ALL_CHECKSUM_RESPONSE_PARAMETERS_TO_PG_SERVER", z8);
                    this.f33074g = true;
                    this.f33076i = lVar;
                    q.a().d(lVar);
                    ((Activity) context).startActivity(intent);
                    p.a("Service Started.");
                }
            }
        } catch (Exception e8) {
            a.e().f(d.f33012o, e8.getMessage());
            s();
            p.k(e8);
        }
    }

    protected synchronized void s() {
        f33066v = null;
        p.a("Service Stopped.");
    }
}
