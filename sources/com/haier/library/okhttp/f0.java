package com.haier.library.okhttp;

import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes2.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f27551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u f27552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<Certificate> f27553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<Certificate> f27554d;

    private f0(i iVar, u uVar, List<Certificate> list, List<Certificate> list2) {
        this.f27551a = iVar;
        this.f27552b = uVar;
        this.f27553c = list;
        this.f27554d = list2;
    }

    public static f0 b(i iVar, u uVar, List<Certificate> list, List<Certificate> list2) {
        if (iVar == null) {
            throw new NullPointerException("tlsVersion == null");
        }
        if (uVar != null) {
            return new f0(iVar, uVar, n.d.m(list), n.d.m(list2));
        }
        throw new NullPointerException("cipherSuite == null");
    }

    public static f0 c(SSLSession sSLSession) throws IOException {
        Certificate[] peerCertificates;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        if ("SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
        u uVarA = u.a(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        i iVarA = i.a(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            peerCertificates = null;
        }
        List listN = peerCertificates != null ? n.d.n(peerCertificates) : Collections.emptyList();
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new f0(iVarA, uVarA, listN, localCertificates != null ? n.d.n(localCertificates) : Collections.emptyList());
    }

    public i a() {
        return this.f27551a;
    }

    public u d() {
        return this.f27552b;
    }

    public List<Certificate> e() {
        return this.f27553c;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return this.f27551a.equals(f0Var.f27551a) && this.f27552b.equals(f0Var.f27552b) && this.f27553c.equals(f0Var.f27553c) && this.f27554d.equals(f0Var.f27554d);
    }

    @Nullable
    public Principal f() {
        if (this.f27553c.isEmpty()) {
            return null;
        }
        return ((X509Certificate) this.f27553c.get(0)).getSubjectX500Principal();
    }

    public List<Certificate> g() {
        return this.f27554d;
    }

    @Nullable
    public Principal h() {
        if (this.f27554d.isEmpty()) {
            return null;
        }
        return ((X509Certificate) this.f27554d.get(0)).getSubjectX500Principal();
    }

    public int hashCode() {
        return ((((((527 + this.f27551a.hashCode()) * 31) + this.f27552b.hashCode()) * 31) + this.f27553c.hashCode()) * 31) + this.f27554d.hashCode();
    }
}
