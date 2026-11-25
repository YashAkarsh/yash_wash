package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.sdk.util.m;
import com.alipay.sdk.util.o;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AuthTask {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final Object f13547c = com.alipay.sdk.util.f.class;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f13548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.alipay.sdk.widget.a f13549b;

    public AuthTask(Activity activity) {
        this.f13548a = activity;
        m0.b.a().b(this.f13548a, com.alipay.sdk.data.c.g());
        com.alipay.sdk.app.statistic.a.a(activity);
        this.f13549b = new com.alipay.sdk.widget.a(activity, com.alipay.sdk.widget.a.f13843k);
    }

    private com.alipay.sdk.util.f.a a() {
        return new b(this);
    }

    private String b(Activity activity, String str) {
        String strA = new m0.a(this.f13548a).a(str);
        List<com.alipay.sdk.data.a.C0156a> listL = com.alipay.sdk.data.a.m().l();
        if (!com.alipay.sdk.data.a.m().f13688f || listL == null) {
            listL = j.f13608d;
        }
        if (!o.r(this.f13548a, listL)) {
            com.alipay.sdk.app.statistic.a.d(com.alipay.sdk.app.statistic.c.f13638l, com.alipay.sdk.app.statistic.c.Z, "");
            return e(activity, strA);
        }
        String strD = new com.alipay.sdk.util.f(activity, a()).d(strA);
        if (!TextUtils.equals(strD, com.alipay.sdk.util.f.f13791i) && !TextUtils.equals(strD, com.alipay.sdk.util.f.f13792j)) {
            return TextUtils.isEmpty(strD) ? k.f() : strD;
        }
        com.alipay.sdk.app.statistic.a.d(com.alipay.sdk.app.statistic.c.f13638l, com.alipay.sdk.app.statistic.c.Y, "");
        return e(activity, strA);
    }

    private String c(l0.b bVar) {
        String[] strArrG = bVar.g();
        Bundle bundle = new Bundle();
        bundle.putString("url", strArrG[0]);
        Intent intent = new Intent(this.f13548a, (Class<?>) H5AuthActivity.class);
        intent.putExtras(bundle);
        this.f13548a.startActivity(intent);
        Object obj = f13547c;
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException unused) {
                return k.f();
            }
        }
        String strA = k.a();
        return TextUtils.isEmpty(strA) ? k.f() : strA;
    }

    private String e(Activity activity, String str) {
        l lVarD;
        f();
        try {
            try {
                try {
                    List<l0.b> listB = l0.b.b(new com.alipay.sdk.packet.impl.a().b(activity, str).c().optJSONObject(j0.c.f34239c).optJSONObject(j0.c.f34240d));
                    g();
                    for (int i7 = 0; i7 < listB.size(); i7++) {
                        if (listB.get(i7).e() == l0.a.WapPay) {
                            String strC = c(listB.get(i7));
                            g();
                            return strC;
                        }
                    }
                } catch (IOException e8) {
                    l lVarD2 = l.d(l.NETWORK_ERROR.a());
                    com.alipay.sdk.app.statistic.a.g("net", e8);
                    g();
                    lVarD = lVarD2;
                }
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.e(com.alipay.sdk.app.statistic.c.f13638l, com.alipay.sdk.app.statistic.c.F, th);
            }
            g();
            lVarD = null;
            if (lVarD == null) {
                lVarD = l.d(l.FAILED.a());
            }
            return k.b(lVarD.a(), lVarD.e(), "");
        } catch (Throwable th2) {
            g();
            throw th2;
        }
    }

    private void f() {
        com.alipay.sdk.widget.a aVar = this.f13549b;
        if (aVar != null) {
            aVar.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.alipay.sdk.widget.a aVar = this.f13549b;
        if (aVar != null) {
            aVar.i();
        }
    }

    public synchronized String auth(String str, boolean z7) {
        String strF;
        Activity activity;
        if (z7) {
            f();
            m0.b.a().b(this.f13548a, com.alipay.sdk.data.c.g());
            strF = k.f();
            j.b("");
            try {
                try {
                    strF = b(this.f13548a, str);
                    com.alipay.sdk.data.a.m().b(this.f13548a);
                    g();
                    activity = this.f13548a;
                } catch (Exception e8) {
                    com.alipay.sdk.util.d.d(e8);
                    com.alipay.sdk.data.a.m().b(this.f13548a);
                    g();
                    activity = this.f13548a;
                }
                com.alipay.sdk.app.statistic.a.h(activity, str);
            } catch (Throwable th) {
                com.alipay.sdk.data.a.m().b(this.f13548a);
                g();
                com.alipay.sdk.app.statistic.a.h(this.f13548a, str);
                throw th;
            }
        } else {
            m0.b.a().b(this.f13548a, com.alipay.sdk.data.c.g());
            strF = k.f();
            j.b("");
            strF = b(this.f13548a, str);
            com.alipay.sdk.data.a.m().b(this.f13548a);
            g();
            activity = this.f13548a;
            com.alipay.sdk.app.statistic.a.h(activity, str);
        }
        throw th;
        return strF;
    }

    public synchronized Map<String, String> authV2(String str, boolean z7) {
        return m.c(auth(str, z7));
    }
}
