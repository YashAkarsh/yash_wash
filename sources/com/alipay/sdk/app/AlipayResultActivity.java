package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.util.m;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AlipayResultActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f13546a = new ConcurrentHashMap<>();

    public interface a {
        void a(int i7, String str, String str2);
    }

    private void a(String str, Bundle bundle) {
        a aVarRemove = f13546a.remove(str);
        if (aVarRemove == null) {
            finish();
            return;
        }
        try {
            aVarRemove.a(bundle.getInt("endCode"), bundle.getString(m.f13817b), bundle.getString(m.f13818c));
        } finally {
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            com.alipay.sdk.app.statistic.a.d(com.alipay.sdk.app.statistic.c.f13638l, "BSPReturned", "");
            Intent intent = getIntent();
            try {
                String stringExtra = intent.getStringExtra("session");
                Bundle bundleExtra = intent.getBundleExtra(m.f13818c);
                String stringExtra2 = intent.getStringExtra("scene");
                com.alipay.sdk.app.statistic.a.d(com.alipay.sdk.app.statistic.c.f13638l, "BSPSession", stringExtra);
                if (TextUtils.equals("mqpSchemePay", stringExtra2)) {
                    a(stringExtra, bundleExtra);
                    return;
                }
                if ((TextUtils.isEmpty(stringExtra) || bundleExtra == null) && intent.getData() != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(Base64.decode(intent.getData().getQuery(), 2), "UTF-8"));
                        JSONObject jSONObject2 = jSONObject.getJSONObject(m.f13818c);
                        stringExtra = jSONObject.getString("session");
                        com.alipay.sdk.app.statistic.a.d(com.alipay.sdk.app.statistic.c.f13638l, "BSPUriSession", stringExtra);
                        Bundle bundle2 = new Bundle();
                        try {
                            Iterator<String> itKeys = jSONObject2.keys();
                            while (itKeys.hasNext()) {
                                String next = itKeys.next();
                                bundle2.putString(next, jSONObject2.getString(next));
                            }
                            bundleExtra = bundle2;
                        } catch (Throwable th) {
                            th = th;
                            bundleExtra = bundle2;
                            com.alipay.sdk.app.statistic.a.e(com.alipay.sdk.app.statistic.c.f13638l, "BSPResEx", th);
                            com.alipay.sdk.app.statistic.a.e(com.alipay.sdk.app.statistic.c.f13638l, com.alipay.sdk.app.statistic.c.f13635j0, th);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                if (TextUtils.isEmpty(stringExtra) || bundleExtra == null) {
                    com.alipay.sdk.app.statistic.a.h(this, "");
                    finish();
                } else {
                    try {
                        a(stringExtra, bundleExtra);
                    } finally {
                        com.alipay.sdk.app.statistic.a.h(this, "");
                        finish();
                    }
                }
            } catch (Throwable th3) {
                com.alipay.sdk.app.statistic.a.e(com.alipay.sdk.app.statistic.c.f13638l, "BSPSerError", th3);
                com.alipay.sdk.app.statistic.a.e(com.alipay.sdk.app.statistic.c.f13638l, com.alipay.sdk.app.statistic.c.f13634i0, th3);
                finish();
            }
        } catch (Throwable unused) {
            finish();
        }
    }
}
