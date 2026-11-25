package com.paytm.pgsdk;

import android.os.Build;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile a f32982e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f32983a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f32984b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f32985c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MediaType f32986d = MediaType.get("application/json; charset=utf-8");

    /* JADX INFO: renamed from: com.paytm.pgsdk.a$a, reason: collision with other inner class name */
    class C0401a implements Callback {
        C0401a() {
        }

        @Override // okhttp3.Callback
        public void onFailure(@a7.d Call call, @a7.d IOException iOException) {
        }

        @Override // okhttp3.Callback
        public void onResponse(@a7.d Call call, @a7.d Response response) throws IOException {
            ResponseBody responseBodyBody = response.body();
            if (responseBodyBody != null) {
                responseBodyBody.close();
            }
        }
    }

    private a() {
    }

    public static void a() {
        if (f32982e != null) {
            f32982e = null;
        }
    }

    private String d(String str, String str2, String str3, String str4) {
        String str5 = Build.MANUFACTURER + "-" + Build.MODEL;
        String strValueOf = String.valueOf(System.currentTimeMillis());
        String strValueOf2 = String.valueOf(Build.VERSION.SDK_INT);
        String str6 = this.f32983a;
        if (str6 == null) {
            str6 = "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("eventType", d.f33010m);
            jSONObject.put("mid", this.f32984b);
            jSONObject.put("orderId", this.f32985c);
            jSONObject.put("deviceModel", str5);
            jSONObject.put("os", "android");
            jSONObject.put(com.haier.globalwasher.presenter.e.f25114s, strValueOf2);
            jSONObject.put("timestamp", strValueOf);
            jSONObject.put("flow", str2);
            jSONObject.put("sdkVersion", "AIO_1.0");
            jSONObject.put("platform", "SDK");
            jSONObject.put("deviceType", "SmartPhone");
            jSONObject.put("eventCategory", d.f33010m);
            jSONObject.put("eventAction", str);
            jSONObject.put("eventLabel", str3);
            jSONObject.put(d.f33023z, str6);
            if (!str4.isEmpty()) {
                jSONObject.put("PaytmAppVersion", "Android_" + str4);
            }
            jSONObject.put("env", "allinone_sdk_prod");
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public static a e() {
        if (f32982e == null) {
            synchronized (a.class) {
                if (f32982e == null) {
                    f32982e = new a();
                }
            }
        }
        return f32982e;
    }

    public String b() {
        return this.f32983a;
    }

    public String c(i iVar) {
        if (iVar != null && iVar.a() != null) {
            this.f32984b = iVar.a().get("MID");
            this.f32985c = iVar.a().get(d.f32998a);
        }
        return "mid=" + this.f32984b + "^orderId=" + this.f32985c + "^" + d.f33023z + "=" + this.f32983a;
    }

    public void f(String str, String str2) {
        h(d.f33018u, str, d.C, str2);
    }

    public void g(String str, String str2, String str3) {
        j(str, str2, str3, "");
    }

    public void h(String str, String str2, String str3, String str4) {
        g(str, str2, str3 + "=" + str4);
    }

    public void i(String str, String str2, String str3, String str4, String str5) {
        j(str, str2, str3 + "=" + str4, str5);
    }

    public void j(String str, String str2, String str3, String str4) {
        OkHttpClient.Builder builderNewBuilder = new OkHttpClient().newBuilder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient okHttpClientBuild = builderNewBuilder.connectTimeout(30L, timeUnit).writeTimeout(30L, timeUnit).readTimeout(30L, timeUnit).build();
        HttpUrl.Builder builderAddPathSegment = new HttpUrl.Builder().scheme(j0.b.f34226a).host("securegw.paytm.in").addPathSegment("ui").addPathSegment("logger");
        okHttpClientBuild.newCall(new Request.Builder().url(builderAddPathSegment.build()).post(RequestBody.create(d(str, str2, str3, str4), this.f32986d)).build()).enqueue(new C0401a());
    }

    public void k(String str) {
        this.f32983a = str;
    }
}
