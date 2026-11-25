package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.p;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class g implements com.bumptech.glide.load.data.c<InputStream> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f14199f = "HttpUrlFetcher";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f14200g = 5;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final c f14201h = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.model.d f14202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f14203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HttpURLConnection f14204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private InputStream f14205d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f14206e;

    private static class b implements c {
        private b() {
        }

        @Override // com.bumptech.glide.load.data.g.c
        public HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    interface c {
        HttpURLConnection a(URL url) throws IOException;
    }

    public g(com.bumptech.glide.load.model.d dVar) {
        this(dVar, f14201h);
    }

    private InputStream d(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f14205d = com.bumptech.glide.util.b.c(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable(f14199f, 3)) {
                Log.d(f14199f, "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.f14205d = httpURLConnection.getInputStream();
        }
        return this.f14205d;
    }

    private InputStream f(URL url, int i7, URL url2, Map<String, String> map) throws IOException {
        if (i7 >= 5) {
            throw new IOException("Too many (> 5) redirects!");
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new IOException("In re-direct loop");
                }
            } catch (URISyntaxException unused) {
            }
        }
        this.f14204c = this.f14203b.a(url);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.f14204c.addRequestProperty(entry.getKey(), entry.getValue());
        }
        this.f14204c.setConnectTimeout(com.haier.globalwasher.mvp_api.volley.d.f24821e);
        this.f14204c.setReadTimeout(com.haier.globalwasher.mvp_api.volley.d.f24821e);
        this.f14204c.setUseCaches(false);
        this.f14204c.setDoInput(true);
        this.f14204c.connect();
        if (this.f14206e) {
            return null;
        }
        int responseCode = this.f14204c.getResponseCode();
        int i8 = responseCode / 100;
        if (i8 == 2) {
            return d(this.f14204c);
        }
        if (i8 == 3) {
            String headerField = this.f14204c.getHeaderField(com.google.common.net.c.f22157m0);
            if (TextUtils.isEmpty(headerField)) {
                throw new IOException("Received empty or null redirect url");
            }
            return f(new URL(url, headerField), i7 + 1, url, map);
        }
        if (responseCode == -1) {
            throw new IOException("Unable to retrieve response code from HttpUrlConnection.");
        }
        throw new IOException("Request failed " + responseCode + ": " + this.f14204c.getResponseMessage());
    }

    @Override // com.bumptech.glide.load.data.c
    public String a() {
        return this.f14202a.a();
    }

    @Override // com.bumptech.glide.load.data.c
    public void b() {
        InputStream inputStream = this.f14205d;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f14204c;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    @Override // com.bumptech.glide.load.data.c
    public void cancel() {
        this.f14206e = true;
    }

    @Override // com.bumptech.glide.load.data.c
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public InputStream c(p pVar) throws Exception {
        return f(this.f14202a.f(), 0, null, this.f14202a.b());
    }

    g(com.bumptech.glide.load.model.d dVar, c cVar) {
        this.f14202a = dVar;
        this.f14203b = cVar;
    }
}
