package org.chromium.net.urlconnection;

import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import org.chromium.net.o;

/* JADX INFO: loaded from: classes3.dex */
class e extends URLStreamHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o f39570a;

    public e(o oVar) {
        this.f39570a = oVar;
    }

    @Override // java.net.URLStreamHandler
    public URLConnection openConnection(URL url) throws IOException {
        return this.f39570a.f(url);
    }

    @Override // java.net.URLStreamHandler
    public URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        return this.f39570a.t(url, proxy);
    }
}
