package com.loopj.android.http;

import android.util.Log;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes2.dex */
class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AbstractHttpClient f32488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HttpContext f32489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HttpUriRequest f32490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final m f32491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f32492e;

    public b(AbstractHttpClient abstractHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, m mVar) {
        this.f32488a = abstractHttpClient;
        this.f32489b = httpContext;
        this.f32490c = httpUriRequest;
        this.f32491d = mVar;
    }

    private void a() throws IOException {
        m mVar;
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        if (this.f32490c.getURI().getScheme() == null) {
            throw new MalformedURLException("No valid URI scheme was provided");
        }
        HttpResponse httpResponseExecute = this.f32488a.execute(this.f32490c, this.f32489b);
        if (Thread.currentThread().isInterrupted() || (mVar = this.f32491d) == null) {
            return;
        }
        mVar.d(httpResponseExecute);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0074  */
    /* JADX WARN: Code duplicated, block: B:32:0x007a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x0009 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    private void b() throws IOException {
        IOException iOException;
        boolean zRetryRequest;
        m mVar;
        HttpRequestRetryHandler httpRequestRetryHandler = this.f32488a.getHttpRequestRetryHandler();
        IOException e8 = null;
        boolean zRetryRequest2 = true;
        while (zRetryRequest2) {
            try {
                try {
                    try {
                        a();
                        return;
                    } catch (NullPointerException e9) {
                        iOException = new IOException("NPE in HttpClient: " + e9.getMessage());
                        int i7 = this.f32492e + 1;
                        this.f32492e = i7;
                        zRetryRequest = httpRequestRetryHandler.retryRequest(iOException, i7, this.f32489b);
                        IOException iOException2 = iOException;
                        zRetryRequest2 = zRetryRequest;
                        e8 = iOException2;
                        if (!zRetryRequest2 && (mVar = this.f32491d) != null) {
                            mVar.j();
                        }
                    }
                } catch (IOException e10) {
                    e8 = e10;
                    try {
                        int i8 = this.f32492e + 1;
                        this.f32492e = i8;
                        zRetryRequest2 = httpRequestRetryHandler.retryRequest(e8, i8, this.f32489b);
                        if (!zRetryRequest2) {
                        }
                    } catch (Exception e11) {
                        Log.e("AsyncHttpRequest", "Unhandled exception origin cause", e11);
                        throw new IOException("Unhandled exception: " + e11.getMessage());
                    }
                }
            } catch (UnknownHostException e12) {
                iOException = new IOException("UnknownHostException exception: " + e12.getMessage());
                if (this.f32492e > 0) {
                    int i9 = this.f32492e + 1;
                    this.f32492e = i9;
                    if (httpRequestRetryHandler.retryRequest(iOException, i9, this.f32489b)) {
                        zRetryRequest = true;
                    } else {
                        zRetryRequest = false;
                    }
                } else {
                    zRetryRequest = false;
                }
                IOException iOException3 = iOException;
                zRetryRequest2 = zRetryRequest;
                e8 = iOException3;
                if (!zRetryRequest2) {
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        m mVar = this.f32491d;
        if (mVar != null) {
            mVar.f();
        }
        try {
            b();
        } catch (IOException e8) {
            if (this.f32491d != null) {
                this.f32491d.g(0, null, null, e8);
            }
        }
        m mVar2 = this.f32491d;
        if (mVar2 != null) {
            mVar2.h();
        }
    }
}
