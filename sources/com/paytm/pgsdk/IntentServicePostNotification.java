package com.paytm.pgsdk;

import android.app.IntentService;
import android.content.Intent;
import android.text.TextUtils;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public class IntentServicePostNotification extends IntentService {
    public IntentServicePostNotification() {
        super("IntentServicePostNotification");
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0046  */
    public void a(String str) throws Throwable {
        Throwable th;
        HttpURLConnection httpURLConnection;
        Exception e8;
        if (TextUtils.isEmpty(str)) {
            return;
        }
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
        if (intent == null || intent.getExtras() == null) {
            return;
        }
        a(intent.getExtras().getString("url"));
    }
}
