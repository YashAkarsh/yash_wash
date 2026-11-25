package com.paytm.pgsdk;

import c.m0;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static k f33081a;

    class a implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f33082a;

        a(b bVar) {
            this.f33082a = bVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(@m0 Call call, @m0 IOException iOException) {
            this.f33082a.onError();
        }

        @Override // okhttp3.Callback
        public void onResponse(@m0 Call call, @m0 Response response) throws IOException {
            ResponseBody responseBodyBody = response.body();
            if (responseBodyBody != null) {
                try {
                    this.f33082a.onSuccess((a4.b) new com.google.gson.f().n(responseBodyBody.string(), a4.b.class));
                    responseBodyBody.close();
                } catch (Exception e8) {
                    p.k(e8);
                    this.f33082a.onError();
                }
            }
        }
    }

    public static synchronized k a() {
        if (f33081a == null) {
            f33081a = new k();
        }
        return f33081a;
    }

    public static void c() {
        f33081a = null;
    }

    public void b(b<a4.b> bVar) {
        String str;
        String str2;
        String str3;
        i iVar = j.h().f33068a;
        if (iVar == null || iVar.a() == null) {
            str = null;
            str2 = null;
            str3 = null;
        } else {
            str = iVar.a().get("MID");
            str3 = iVar.a().get(d.f32998a);
            str2 = iVar.a().get(d.f33007j);
        }
        if (str == null || str3 == null) {
            bVar.onError();
            return;
        }
        String str4 = j.a() + "?orderId=" + str3 + "&mid=" + str;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("mid", str);
            jSONObject3.put("orderId", str3);
            jSONObject2.put(d.Q, d.f33007j);
            if (str2 != null) {
                jSONObject2.put(d.R, str2);
            }
            jSONObject2.put("version", "v2");
            jSONObject2.put(d.T, System.currentTimeMillis());
            jSONObject.put(d.U, jSONObject2);
            jSONObject.put(d.V, jSONObject3);
        } catch (JSONException e8) {
            e8.printStackTrace();
        }
        Request requestBuild = new Request.Builder().url(str4).header(com.alipay.sdk.packet.e.f13726f, "application/json").header(com.google.common.net.c.f22146h, "application/json").post(RequestBody.create(MediaType.parse("application/json"), jSONObject.toString().getBytes())).build();
        OkHttpClient.Builder builderNewBuilder = new OkHttpClient().newBuilder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builderNewBuilder.connectTimeout(30L, timeUnit).writeTimeout(30L, timeUnit).readTimeout(30L, timeUnit).build().newCall(requestBuild).enqueue(new a(bVar));
    }
}
