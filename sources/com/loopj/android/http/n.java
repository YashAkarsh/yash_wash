package com.loopj.android.http;

import android.os.SystemClock;
import com.haier.uhome.account.api.Const;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import javax.net.ssl.SSLException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes2.dex */
class n implements HttpRequestRetryHandler {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static HashSet<Class<?>> f32568c = new HashSet<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static HashSet<Class<?>> f32569d = new HashSet<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f32570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f32571b;

    static {
        f32568c.add(NoHttpResponseException.class);
        f32568c.add(UnknownHostException.class);
        f32568c.add(SocketException.class);
        f32569d.add(InterruptedIOException.class);
        f32569d.add(SSLException.class);
    }

    public n(int i7, int i8) {
        this.f32570a = i7;
        this.f32571b = i8;
    }

    protected boolean a(HashSet<Class<?>> hashSet, Throwable th) {
        Iterator<Class<?>> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().isInstance(th)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.http.client.HttpRequestRetryHandler
    public boolean retryRequest(IOException iOException, int i7, HttpContext httpContext) {
        boolean z7;
        Boolean bool = (Boolean) httpContext.getAttribute("http.request_sent");
        if (bool != null) {
            bool.booleanValue();
        }
        if (i7 <= this.f32570a && !a(f32569d, iOException)) {
            a(f32568c, iOException);
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            HttpUriRequest httpUriRequest = (HttpUriRequest) httpContext.getAttribute("http.request");
            if (httpUriRequest == null) {
                return false;
            }
            z7 = !httpUriRequest.getMethod().equals(Const.HTTP_REQUEST_TYPE_POST);
        }
        if (z7) {
            SystemClock.sleep(this.f32571b);
        } else {
            iOException.printStackTrace();
        }
        return z7;
    }
}
