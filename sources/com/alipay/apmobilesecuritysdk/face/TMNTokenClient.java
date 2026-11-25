package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper;
import com.haier.uhome.nfc.service.HttpHelper;
import j0.b;
import java.util.HashMap;
import o0.a;

/* JADX INFO: loaded from: classes.dex */
public class TMNTokenClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static TMNTokenClient f13540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f13541b;

    public interface InitResultListener {
        void onResult(String str, int i7);
    }

    private TMNTokenClient(Context context) {
        this.f13541b = null;
        if (context == null) {
            throw new IllegalArgumentException("TMNTokenClient initialization error: context is null.");
        }
        this.f13541b = context;
    }

    public static TMNTokenClient getInstance(Context context) {
        if (f13540a == null) {
            synchronized (TMNTokenClient.class) {
                if (f13540a == null) {
                    f13540a = new TMNTokenClient(context);
                }
            }
        }
        return f13540a;
    }

    public void intiToken(final String str, String str2, String str3, final InitResultListener initResultListener) {
        if (a.d(str) && initResultListener != null) {
            initResultListener.onResult("", 2);
        }
        if (a.d(str2) && initResultListener != null) {
            initResultListener.onResult("", 3);
        }
        final HashMap map = new HashMap();
        map.put(b.f34232g, UtdidWrapper.getUtdid(this.f13541b));
        map.put("tid", "");
        map.put("userId", "");
        map.put("appName", str);
        map.put("appKeyClient", str2);
        map.put("appchannel", "openapi");
        map.put("sessionId", str3);
        map.put("rpcVersion", HttpHelper.b.f29530c);
        com.alipay.apmobilesecuritysdk.f.b.a().a(new Runnable() { // from class: com.alipay.apmobilesecuritysdk.face.TMNTokenClient.1
            @Override // java.lang.Runnable
            public void run() {
                int iA = new com.alipay.apmobilesecuritysdk.a.a(TMNTokenClient.this.f13541b).a(map);
                InitResultListener initResultListener2 = initResultListener;
                if (initResultListener2 == null) {
                    return;
                }
                if (iA != 0) {
                    initResultListener2.onResult("", iA);
                } else {
                    initResultListener.onResult(com.alipay.apmobilesecuritysdk.a.a.a(TMNTokenClient.this.f13541b, str), 0);
                }
            }
        });
    }
}
