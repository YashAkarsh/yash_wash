package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.a.a;
import com.alipay.apmobilesecuritysdk.e.d;
import com.alipay.apmobilesecuritysdk.e.g;
import com.alipay.apmobilesecuritysdk.e.h;
import com.alipay.apmobilesecuritysdk.e.i;
import com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper;
import com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper;
import com.haier.uhome.nfc.service.HttpHelper;
import j0.b;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class APSecuritySdk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static APSecuritySdk f13533a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Object f13534c = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f13535b;

    public interface InitResultListener {
        void onResult(TokenResult tokenResult);
    }

    public class TokenResult {
        public String apdid;
        public String apdidToken;
        public String clientKey;
        public String umidToken;

        public TokenResult() {
        }
    }

    private APSecuritySdk(Context context) {
        this.f13535b = context;
    }

    public static APSecuritySdk getInstance(Context context) {
        if (f13533a == null) {
            synchronized (f13534c) {
                if (f13533a == null) {
                    f13533a = new APSecuritySdk(context);
                }
            }
        }
        return f13533a;
    }

    public static String getUtdid(Context context) {
        return UtdidWrapper.getUtdid(context);
    }

    public String getApdidToken() {
        String strA = a.a(this.f13535b, "");
        if (o0.a.d(strA)) {
            initToken(0, new HashMap(), null);
        }
        return strA;
    }

    public String getSdkName() {
        return "APPSecuritySDK-ALIPAYSDK";
    }

    public String getSdkVersion() {
        return "3.4.0.201910161639";
    }

    public synchronized TokenResult getTokenResult() {
        TokenResult tokenResult;
        tokenResult = new TokenResult();
        try {
            tokenResult.apdidToken = a.a(this.f13535b, "");
            tokenResult.clientKey = h.f(this.f13535b);
            tokenResult.apdid = a.a(this.f13535b);
            tokenResult.umidToken = UmidSdkWrapper.getSecurityToken(this.f13535b);
            if (o0.a.d(tokenResult.apdid) || o0.a.d(tokenResult.apdidToken) || o0.a.d(tokenResult.clientKey)) {
                initToken(0, new HashMap(), null);
            }
        } catch (Throwable unused) {
        }
        return tokenResult;
    }

    public void initToken(int i7, Map<String, String> map, final InitResultListener initResultListener) {
        com.alipay.apmobilesecuritysdk.b.a.a().a(i7);
        String strB = h.b(this.f13535b);
        String strC = com.alipay.apmobilesecuritysdk.b.a.a().c();
        if (o0.a.g(strB) && !o0.a.e(strB, strC)) {
            com.alipay.apmobilesecuritysdk.e.a.a(this.f13535b);
            d.a(this.f13535b);
            g.a(this.f13535b);
            i.h();
        }
        if (!o0.a.e(strB, strC)) {
            h.c(this.f13535b, strC);
        }
        String strC2 = o0.a.c(map, b.f34232g, "");
        String strC3 = o0.a.c(map, "tid", "");
        String strC4 = o0.a.c(map, "userId", "");
        if (o0.a.d(strC2)) {
            strC2 = UtdidWrapper.getUtdid(this.f13535b);
        }
        final HashMap map2 = new HashMap();
        map2.put(b.f34232g, strC2);
        map2.put("tid", strC3);
        map2.put("userId", strC4);
        map2.put("appName", "");
        map2.put("appKeyClient", "");
        map2.put("appchannel", "");
        map2.put("rpcVersion", HttpHelper.b.f29530c);
        com.alipay.apmobilesecuritysdk.f.b.a().a(new Runnable() { // from class: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.1
            @Override // java.lang.Runnable
            public void run() {
                new a(APSecuritySdk.this.f13535b).a(map2);
                InitResultListener initResultListener2 = initResultListener;
                if (initResultListener2 != null) {
                    initResultListener2.onResult(APSecuritySdk.this.getTokenResult());
                }
            }
        });
    }
}
