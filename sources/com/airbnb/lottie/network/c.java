package com.airbnb.lottie.network;

import android.content.Context;
import androidx.core.util.s;
import c.h1;
import c.o0;
import com.airbnb.lottie.f;
import com.airbnb.lottie.g;
import com.airbnb.lottie.n;
import com.haier.uhome.account.api.Const;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f12169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f12170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    private final b f12171c;

    private c(Context context, String str, @o0 String str2) {
        Context applicationContext = context.getApplicationContext();
        this.f12169a = applicationContext;
        this.f12170b = str;
        if (str2 == null) {
            this.f12171c = null;
        } else {
            this.f12171c = new b(applicationContext);
        }
    }

    @h1
    @o0
    private f a() {
        s<a, InputStream> sVarB;
        b bVar = this.f12171c;
        if (bVar == null || (sVarB = bVar.b(this.f12170b)) == null) {
            return null;
        }
        a aVar = sVarB.f6387a;
        InputStream inputStream = sVarB.f6388b;
        n<f> nVarB = aVar == a.ZIP ? g.B(new ZipInputStream(inputStream), this.f12170b) : g.k(inputStream, this.f12170b);
        if (nVarB.b() != null) {
            return nVarB.b();
        }
        return null;
    }

    @h1
    private n<f> b() {
        try {
            return c();
        } catch (IOException e8) {
            return new n<>((Throwable) e8);
        }
    }

    @h1
    private n<f> c() throws IOException {
        com.airbnb.lottie.utils.f.a("Fetching " + this.f12170b);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f12170b).openConnection();
        httpURLConnection.setRequestMethod(Const.HTTP_REQUEST_TYPE_GET);
        try {
            httpURLConnection.connect();
            if (httpURLConnection.getErrorStream() == null && httpURLConnection.getResponseCode() == 200) {
                n<f> nVarG = g(httpURLConnection);
                StringBuilder sb = new StringBuilder();
                sb.append("Completed fetch from network. Success: ");
                sb.append(nVarG.b() != null);
                com.airbnb.lottie.utils.f.a(sb.toString());
                return nVarG;
            }
            return new n<>((Throwable) new IllegalArgumentException("Unable to fetch " + this.f12170b + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + f(httpURLConnection)));
        } catch (Exception e8) {
            return new n<>((Throwable) e8);
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public static n<f> e(Context context, String str, @o0 String str2) {
        return new c(context, str, str2).d();
    }

    private String f(HttpURLConnection httpURLConnection) throws IOException {
        httpURLConnection.getResponseCode();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    try {
                        String line = bufferedReader.readLine();
                        if (line != null) {
                            sb.append(line);
                            sb.append('\n');
                        } else {
                            try {
                                break;
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Exception e8) {
                        throw e8;
                    }
                } catch (Throwable th) {
                    bufferedReader.close();
                    throw th;
                }
                bufferedReader.close();
            } catch (Exception unused2) {
            }
            throw th;
        }
        bufferedReader.close();
        return sb.toString();
    }

    @o0
    private n<f> g(HttpURLConnection httpURLConnection) throws IOException {
        a aVar;
        n<f> nVarK;
        String contentType = httpURLConnection.getContentType();
        if (contentType == null) {
            contentType = "application/json";
        }
        if (contentType.contains("application/zip")) {
            com.airbnb.lottie.utils.f.a("Handling zip response.");
            aVar = a.ZIP;
            b bVar = this.f12171c;
            nVarK = bVar == null ? g.B(new ZipInputStream(httpURLConnection.getInputStream()), null) : g.B(new ZipInputStream(new FileInputStream(bVar.g(this.f12170b, httpURLConnection.getInputStream(), aVar))), this.f12170b);
        } else {
            com.airbnb.lottie.utils.f.a("Received json response.");
            aVar = a.JSON;
            b bVar2 = this.f12171c;
            nVarK = bVar2 == null ? g.k(httpURLConnection.getInputStream(), null) : g.k(new FileInputStream(new File(bVar2.g(this.f12170b, httpURLConnection.getInputStream(), aVar).getAbsolutePath())), this.f12170b);
        }
        if (this.f12171c != null && nVarK.b() != null) {
            this.f12171c.f(this.f12170b, aVar);
        }
        return nVarK;
    }

    @h1
    public n<f> d() {
        f fVarA = a();
        if (fVarA != null) {
            return new n<>(fVarA);
        }
        com.airbnb.lottie.utils.f.a("Animation for " + this.f12170b + " not found in cache. Fetching from network.");
        return b();
    }
}
