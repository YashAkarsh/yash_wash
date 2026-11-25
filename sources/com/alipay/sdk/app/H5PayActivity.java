package com.alipay.sdk.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import com.alipay.sdk.util.o;

/* JADX INFO: loaded from: classes.dex */
public class H5PayActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.alipay.sdk.widget.g f13550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f13551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f13552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f13553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f13554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f13555f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f13556g;

    private void b() {
        try {
            super.requestWindowFeature(1);
        } catch (Throwable th) {
            com.alipay.sdk.util.d.d(th);
        }
    }

    public void a() {
        Object obj = PayTask.f13568g;
        synchronized (obj) {
            try {
                obj.notify();
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.app.Activity
    public void finish() {
        a();
        super.finish();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        com.alipay.sdk.widget.g gVar = this.f13550a;
        if (gVar instanceof com.alipay.sdk.widget.h) {
            gVar.l();
            return;
        }
        if (!gVar.l()) {
            super.onBackPressed();
        }
        k.c(k.f());
        finish();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        b();
        super.onCreate(bundle);
        try {
            Bundle extras = getIntent().getExtras();
            String string = extras.getString("url", null);
            this.f13551b = string;
            if (!o.D(string)) {
                finish();
                return;
            }
            this.f13553d = extras.getString("cookie", null);
            this.f13552c = extras.getString("method", null);
            this.f13554e = extras.getString("title", null);
            this.f13556g = extras.getString("version", "v1");
            this.f13555f = extras.getBoolean("backisexit", false);
            try {
                if ("v2".equals(this.f13556g)) {
                    com.alipay.sdk.widget.j jVar = new com.alipay.sdk.widget.j(this);
                    setContentView(jVar);
                    jVar.o(this.f13554e, this.f13552c, this.f13555f);
                    jVar.j(this.f13551b);
                    this.f13550a = jVar;
                    return;
                }
                com.alipay.sdk.widget.h hVar = new com.alipay.sdk.widget.h(this);
                this.f13550a = hVar;
                setContentView(hVar);
                this.f13550a.k(this.f13551b, this.f13553d);
                this.f13550a.j(this.f13551b);
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.e(com.alipay.sdk.app.statistic.c.f13638l, "GetInstalledAppEx", th);
                finish();
            }
        } catch (Exception unused) {
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.alipay.sdk.widget.g gVar = this.f13550a;
        if (gVar != null) {
            gVar.i();
        }
    }
}
