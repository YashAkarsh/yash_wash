package com.haier.library.okhttp;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: loaded from: classes2.dex */
public final class s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final s f27792c = new a().b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<b> f27793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final com.haier.library.okhttp.b.l.c f27794b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<b> f27795a = new ArrayList();

        public a a(String str, String... strArr) {
            if (str == null) {
                throw new NullPointerException("pattern == null");
            }
            for (String str2 : strArr) {
                this.f27795a.add(new b(str, str2));
            }
            return this;
        }

        public s b() {
            return new s(new LinkedHashSet(this.f27795a), null);
        }
    }

    static final class b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final String f27796e = "*.";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f27797a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f27798b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f27799c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final com.haier.library.a.j f27800d;

        b(String str, String str2) {
            String strF;
            this.f27797a = str;
            if (str.startsWith(f27796e)) {
                strF = h0.D("http://" + str.substring(2)).F();
            } else {
                strF = h0.D("http://" + str).F();
            }
            this.f27798b = strF;
            if (str2.startsWith("sha1/")) {
                this.f27799c = "sha1/";
                this.f27800d = com.haier.library.a.j.B(str2.substring(5));
            } else {
                if (!str2.startsWith("sha256/")) {
                    throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + str2);
                }
                this.f27799c = "sha256/";
                this.f27800d = com.haier.library.a.j.B(str2.substring(7));
            }
            if (this.f27800d != null) {
                return;
            }
            throw new IllegalArgumentException("pins must be base64: " + str2);
        }

        boolean a(String str) {
            if (!this.f27797a.startsWith(f27796e)) {
                return str.equals(this.f27798b);
            }
            int iIndexOf = str.indexOf(46);
            if ((str.length() - iIndexOf) - 1 == this.f27798b.length()) {
                String str2 = this.f27798b;
                if (str.regionMatches(false, iIndexOf + 1, str2, 0, str2.length())) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.f27797a.equals(bVar.f27797a) && this.f27799c.equals(bVar.f27799c) && this.f27800d.equals(bVar.f27800d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f27797a.hashCode()) * 31) + this.f27799c.hashCode()) * 31) + this.f27800d.hashCode();
        }

        public String toString() {
            return this.f27799c + this.f27800d.C();
        }
    }

    s(Set<b> set, @Nullable com.haier.library.okhttp.b.l.c cVar) {
        this.f27793a = set;
        this.f27794b = cVar;
    }

    static com.haier.library.a.j a(X509Certificate x509Certificate) {
        return com.haier.library.a.j.m(x509Certificate.getPublicKey().getEncoded()).K();
    }

    public static String c(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + g((X509Certificate) certificate).C();
    }

    static com.haier.library.a.j g(X509Certificate x509Certificate) {
        return com.haier.library.a.j.m(x509Certificate.getPublicKey().getEncoded()).O();
    }

    s b(@Nullable com.haier.library.okhttp.b.l.c cVar) {
        return n.d.y(this.f27794b, cVar) ? this : new s(this.f27793a, cVar);
    }

    List<b> d(String str) {
        List<b> listEmptyList = Collections.emptyList();
        for (b bVar : this.f27793a) {
            if (bVar.a(str)) {
                if (listEmptyList.isEmpty()) {
                    listEmptyList = new ArrayList<>();
                }
                listEmptyList.add(bVar);
            }
        }
        return listEmptyList;
    }

    public void e(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<b> listD = d(str);
        if (listD.isEmpty()) {
            return;
        }
        com.haier.library.okhttp.b.l.c cVar = this.f27794b;
        if (cVar != null) {
            list = cVar.c(list, str);
        }
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i7);
            int size2 = listD.size();
            com.haier.library.a.j jVarG = null;
            com.haier.library.a.j jVarA = null;
            for (int i8 = 0; i8 < size2; i8++) {
                b bVar = listD.get(i8);
                if (bVar.f27799c.equals("sha256/")) {
                    if (jVarG == null) {
                        jVarG = g(x509Certificate);
                    }
                    if (bVar.f27800d.equals(jVarG)) {
                        return;
                    }
                } else {
                    if (!bVar.f27799c.equals("sha1/")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + bVar.f27799c);
                    }
                    if (jVarA == null) {
                        jVarA = a(x509Certificate);
                    }
                    if (bVar.f27800d.equals(jVarA)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i9 = 0; i9 < size3; i9++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i9);
            sb.append("\n    ");
            sb.append(c(x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size4 = listD.size();
        for (int i10 = 0; i10 < size4; i10++) {
            b bVar2 = listD.get(i10);
            sb.append("\n    ");
            sb.append(bVar2);
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof s) {
            s sVar = (s) obj;
            if (n.d.y(this.f27794b, sVar.f27794b) && this.f27793a.equals(sVar.f27793a)) {
                return true;
            }
        }
        return false;
    }

    public void f(String str, Certificate... certificateArr) throws SSLPeerUnverifiedException {
        e(str, Arrays.asList(certificateArr));
    }

    public int hashCode() {
        com.haier.library.okhttp.b.l.c cVar = this.f27794b;
        return ((cVar != null ? cVar.hashCode() : 0) * 31) + this.f27793a.hashCode();
    }
}
