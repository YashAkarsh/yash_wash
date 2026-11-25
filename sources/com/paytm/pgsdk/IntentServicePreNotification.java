package com.paytm.pgsdk;

import android.app.IntentService;
import android.content.Intent;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public class IntentServicePreNotification extends IntentService {
    public IntentServicePreNotification() {
        super("IntentServicePreNotification");
    }

    /* JADX WARN: Code duplicated, block: B:21:0x003f  */
    public void a(String str) throws Throwable {
        Throwable th;
        HttpURLConnection httpURLConnection;
        Exception e8;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                try {
                    InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
                    int i7 = inputStreamReader.read();
                    while (i7 != -1) {
                        int i8 = inputStreamReader.read();
                        System.out.print((char) i7);
                        i7 = i8;
                    }
                } catch (Exception e9) {
                    e8 = e9;
                    e8.printStackTrace();
                    if (httpURLConnection == null) {
                        return;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Exception e10) {
            e8 = e10;
            httpURLConnection = null;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
        httpURLConnection.disconnect();
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) throws Throwable {
        if (intent != null) {
            a(intent.getExtras().getString("url"));
        }
    }
}
