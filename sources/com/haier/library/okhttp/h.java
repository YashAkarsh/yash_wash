package com.haier.library.okhttp;

import java.net.InetSocketAddress;
import java.net.Proxy;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final c f27565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Proxy f27566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final InetSocketAddress f27567c;

    public h(c cVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (cVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.f27565a = cVar;
        this.f27566b = proxy;
        this.f27567c = inetSocketAddress;
    }

    public c a() {
        return this.f27565a;
    }

    public Proxy b() {
        return this.f27566b;
    }

    public InetSocketAddress c() {
        return this.f27567c;
    }

    public boolean d() {
        return this.f27565a.f27509i != null && this.f27566b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (hVar.f27565a.equals(this.f27565a) && hVar.f27566b.equals(this.f27566b) && hVar.f27567c.equals(this.f27567c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f27565a.hashCode()) * 31) + this.f27566b.hashCode()) * 31) + this.f27567c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f27567c + com.alipay.sdk.util.j.f13808d;
    }
}
