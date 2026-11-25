package com.haier.library.okhttp;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final h0 f27501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final c0 f27502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final SocketFactory f27503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final n f27504d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final List<d> f27505e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final List<x> f27506f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final ProxySelector f27507g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    final Proxy f27508h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    final SSLSocketFactory f27509i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    final HostnameVerifier f27510j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    final s f27511k;

    public c(String str, int i7, c0 c0Var, SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, @Nullable s sVar, n nVar, @Nullable Proxy proxy, List<d> list, List<x> list2, ProxySelector proxySelector) {
        this.f27501a = new h0.a().e(sSLSocketFactory != null ? j0.b.f34226a : com.haier.uhome.usdk.base.a.av).A(str).b(i7).s();
        if (c0Var == null) {
            throw new NullPointerException("dns == null");
        }
        this.f27502b = c0Var;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.f27503c = socketFactory;
        if (nVar == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.f27504d = nVar;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.f27505e = n.d.m(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f27506f = n.d.m(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.f27507g = proxySelector;
        this.f27508h = proxy;
        this.f27509i = sSLSocketFactory;
        this.f27510j = hostnameVerifier;
        this.f27511k = sVar;
    }

    public h0 a() {
        return this.f27501a;
    }

    boolean b(c cVar) {
        return this.f27502b.equals(cVar.f27502b) && this.f27504d.equals(cVar.f27504d) && this.f27505e.equals(cVar.f27505e) && this.f27506f.equals(cVar.f27506f) && this.f27507g.equals(cVar.f27507g) && n.d.y(this.f27508h, cVar.f27508h) && n.d.y(this.f27509i, cVar.f27509i) && n.d.y(this.f27510j, cVar.f27510j) && n.d.y(this.f27511k, cVar.f27511k) && a().G() == cVar.a().G();
    }

    public c0 c() {
        return this.f27502b;
    }

    public SocketFactory d() {
        return this.f27503c;
    }

    public n e() {
        return this.f27504d;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f27501a.equals(cVar.f27501a) && b(cVar)) {
                return true;
            }
        }
        return false;
    }

    public List<d> f() {
        return this.f27505e;
    }

    public List<x> g() {
        return this.f27506f;
    }

    public ProxySelector h() {
        return this.f27507g;
    }

    public int hashCode() {
        int iHashCode = (((((((((((527 + this.f27501a.hashCode()) * 31) + this.f27502b.hashCode()) * 31) + this.f27504d.hashCode()) * 31) + this.f27505e.hashCode()) * 31) + this.f27506f.hashCode()) * 31) + this.f27507g.hashCode()) * 31;
        Proxy proxy = this.f27508h;
        int iHashCode2 = (iHashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f27509i;
        int iHashCode3 = (iHashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.f27510j;
        int iHashCode4 = (iHashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        s sVar = this.f27511k;
        return iHashCode4 + (sVar != null ? sVar.hashCode() : 0);
    }

    @Nullable
    public Proxy i() {
        return this.f27508h;
    }

    @Nullable
    public SSLSocketFactory j() {
        return this.f27509i;
    }

    @Nullable
    public HostnameVerifier k() {
        return this.f27510j;
    }

    @Nullable
    public s l() {
        return this.f27511k;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f27501a.F());
        sb.append(":");
        sb.append(this.f27501a.G());
        if (this.f27508h != null) {
            sb.append(", proxy=");
            sb.append(this.f27508h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f27507g);
        }
        sb.append(com.alipay.sdk.util.j.f13808d);
        return sb.toString();
    }
}
