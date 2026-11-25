package com.loopj.android.http;

import android.content.Context;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes2.dex */
public class q extends a {
    public q() {
        super(false, 80, 443);
    }

    @Override // com.loopj.android.http.a
    protected k N(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, m mVar, Context context) {
        if (str != null) {
            httpUriRequest.addHeader("Content-Type", str);
        }
        mVar.e(true);
        new b(defaultHttpClient, httpContext, httpUriRequest, mVar).run();
        return new k(null);
    }

    public q(int i7) {
        super(false, i7, 443);
    }

    public q(int i7, int i8) {
        super(false, i7, i8);
    }

    public q(boolean z7, int i7, int i8) {
        super(z7, i7, i8);
    }

    public q(SchemeRegistry schemeRegistry) {
        super(schemeRegistry);
    }
}
