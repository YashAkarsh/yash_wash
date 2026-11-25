package com.nostra13.universalimageloader.core.download;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public class a implements c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f32772d = 5000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f32773e = 20000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected static final int f32774f = 32768;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected static final String f32775g = "@#&=*+-_.,:!?()/~'%";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected static final int f32776h = 5;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f32777i = "UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Context f32778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final int f32779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final int f32780c;

    /* JADX INFO: renamed from: com.nostra13.universalimageloader.core.download.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0400a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f32781a;

        static {
            int[] iArr = new int[c.a.values().length];
            f32781a = iArr;
            try {
                iArr[c.a.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32781a[c.a.HTTPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32781a[c.a.FILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32781a[c.a.CONTENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32781a[c.a.ASSETS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32781a[c.a.DRAWABLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32781a[c.a.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public a(Context context) {
        this.f32778a = context.getApplicationContext();
        this.f32779b = 5000;
        this.f32780c = 20000;
    }

    @Override // com.nostra13.universalimageloader.core.download.c
    public InputStream a(String str, Object obj) throws IOException {
        switch (C0400a.f32781a[c.a.c(str).ordinal()]) {
            case 1:
            case 2:
                return g(str, obj);
            case 3:
                return f(str, obj);
            case 4:
                return d(str, obj);
            case 5:
                return c(str, obj);
            case 6:
                return e(str, obj);
            default:
                return h(str, obj);
        }
    }

    protected HttpURLConnection b(String str, Object obj) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Uri.encode(str, f32775g)).openConnection();
        httpURLConnection.setConnectTimeout(this.f32779b);
        httpURLConnection.setReadTimeout(this.f32780c);
        return httpURLConnection;
    }

    protected InputStream c(String str, Object obj) throws IOException {
        return this.f32778a.getAssets().open(c.a.ASSETS.b(str));
    }

    protected InputStream d(String str, Object obj) throws FileNotFoundException {
        return this.f32778a.getContentResolver().openInputStream(Uri.parse(str));
    }

    protected InputStream e(String str, Object obj) {
        Bitmap bitmap = ((BitmapDrawable) this.f32778a.getResources().getDrawable(Integer.parseInt(c.a.DRAWABLE.b(str)))).getBitmap();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    protected InputStream f(String str, Object obj) throws IOException {
        String strB = c.a.FILE.b(str);
        return new com.nostra13.universalimageloader.core.assist.a(new BufferedInputStream(new FileInputStream(strB), 32768), new File(strB).length());
    }

    protected InputStream g(String str, Object obj) throws IOException {
        HttpURLConnection httpURLConnectionB = b(str, obj);
        for (int i7 = 0; httpURLConnectionB.getResponseCode() / 100 == 3 && i7 < 5; i7++) {
            httpURLConnectionB = b(httpURLConnectionB.getHeaderField(com.google.common.net.c.f22157m0), obj);
        }
        try {
            return new com.nostra13.universalimageloader.core.assist.a(new BufferedInputStream(httpURLConnectionB.getInputStream(), 32768), httpURLConnectionB.getContentLength());
        } catch (IOException e8) {
            com.nostra13.universalimageloader.utils.c.d(httpURLConnectionB.getErrorStream());
            throw e8;
        }
    }

    protected InputStream h(String str, Object obj) throws IOException {
        throw new UnsupportedOperationException(String.format(f32777i, str));
    }

    public a(Context context, int i7, int i8) {
        this.f32778a = context.getApplicationContext();
        this.f32779b = i7;
        this.f32780c = i8;
    }
}
