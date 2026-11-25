package org.chromium.net.urlconnection;

import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import org.chromium.net.o;

/* JADX INFO: loaded from: classes3.dex */
public class h implements URLStreamHandlerFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o f39579a;

    public h(o oVar) {
        if (oVar == null) {
            throw new NullPointerException("CronetEngine is null.");
        }
        this.f39579a = oVar;
    }

    @Override // java.net.URLStreamHandlerFactory
    public URLStreamHandler createURLStreamHandler(String str) {
        if (com.haier.uhome.usdk.base.a.av.equals(str) || j0.b.f34226a.equals(str)) {
            return new e(this.f39579a);
        }
        return null;
    }
}
