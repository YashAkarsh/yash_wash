package easypay.appinvoke.utils;

import android.content.Context;
import android.content.Intent;
import androidx.core.app.JobIntentService;
import c.m0;
import easypay.appinvoke.manager.Constants;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes2.dex */
public class AnalyticsService extends JobIntentService {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static int f33841m = 123;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected HashMap<String, Object> f33842l;

    public static void l(Context context, Intent intent) {
        JobIntentService.d(context, AnalyticsService.class, f33841m, intent);
    }

    @Override // androidx.core.app.JobIntentService
    protected void h(@m0 Intent intent) {
        if (intent != null) {
            try {
                this.f33842l = (HashMap) intent.getSerializableExtra("data");
            } catch (Exception e8) {
                e8.printStackTrace();
                b.a("EXCEPTION", e8);
            }
            if (this.f33842l != null) {
                try {
                    MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
                    OkHttpClient okHttpClient = new OkHttpClient();
                    String strZ = new com.google.gson.g().d().z(this.f33842l);
                    b.a("analytics log map-json:" + strZ, this);
                    e.c("AssistAna", "analytics service :Map" + strZ);
                    if (okHttpClient.newCall(new Request.Builder().url(Constants.EventUrl).post(RequestBody.create(mediaType, strZ)).build()).execute().body() != null) {
                        stopSelf();
                    }
                } catch (Exception e9) {
                    e9.printStackTrace();
                    b.a("EXCEPTION", e9);
                }
            }
        }
    }

    @Override // androidx.core.app.JobIntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
    }
}
