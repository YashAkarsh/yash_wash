package com.alipay.sdk.packet.impl;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends com.alipay.sdk.packet.e {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f13742t = "log_v";

    @Override // com.alipay.sdk.packet.e
    public com.alipay.sdk.packet.b b(Context context, String str) throws Throwable {
        return d(context, str, "https://mcgw.alipay.com/sdklog.do", true);
    }

    @Override // com.alipay.sdk.packet.e
    protected String e(String str, JSONObject jSONObject) {
        return str;
    }

    @Override // com.alipay.sdk.packet.e
    protected Map<String, String> h(boolean z7, String str) {
        HashMap map = new HashMap();
        map.put(com.alipay.sdk.packet.e.f13723c, String.valueOf(z7));
        map.put(com.alipay.sdk.packet.e.f13726f, "application/octet-stream");
        map.put(com.alipay.sdk.packet.e.f13729i, "CBC");
        return map;
    }

    @Override // com.alipay.sdk.packet.e
    protected JSONObject i() throws JSONException {
        return null;
    }

    @Override // com.alipay.sdk.packet.e
    protected String n() throws JSONException {
        HashMap<String, String> map = new HashMap<>();
        map.put(com.alipay.sdk.packet.e.f13731k, "/sdk/log");
        map.put(com.alipay.sdk.packet.e.f13732l, y2.a.f40614y);
        HashMap<String, String> map2 = new HashMap<>();
        map2.put(f13742t, "1.0");
        return f(map, map2);
    }
}
