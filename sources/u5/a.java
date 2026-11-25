package u5;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f40413c = 9;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0549a f40414d = new C0549a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f40415b;

    /* JADX INFO: renamed from: u5.a$a, reason: collision with other inner class name */
    public static final class C0549a {
        private C0549a() {
        }

        public /* synthetic */ C0549a(w wVar) {
            this();
        }
    }

    public a(@a7.d e trustRootIndex) {
        l0.p(trustRootIndex, "trustRootIndex");
        this.f40415b = trustRootIndex;
    }

    private final boolean b(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!l0.g(x509Certificate.getIssuerDN(), x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    @Override // u5.c
    @a7.d
    public List<Certificate> a(@a7.d List<? extends Certificate> chain, @a7.d String hostname) throws SSLPeerUnverifiedException {
        X509Certificate x509Certificate;
        l0.p(chain, "chain");
        l0.p(hostname, "hostname");
        ArrayDeque arrayDeque = new ArrayDeque(chain);
        ArrayList arrayList = new ArrayList();
        Object objRemoveFirst = arrayDeque.removeFirst();
        l0.o(objRemoveFirst, "queue.removeFirst()");
        arrayList.add(objRemoveFirst);
        boolean z7 = false;
        for (int i7 = 0; i7 < 9; i7++) {
            Object obj = arrayList.get(arrayList.size() - 1);
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
            X509Certificate x509Certificate2 = (X509Certificate) obj;
            X509Certificate x509CertificateA = this.f40415b.a(x509Certificate2);
            if (x509CertificateA != null) {
                if (arrayList.size() > 1 || (!l0.g(x509Certificate2, x509CertificateA))) {
                    arrayList.add(x509CertificateA);
                }
                if (b(x509CertificateA, x509CertificateA)) {
                    return arrayList;
                }
                z7 = true;
            } else {
                Iterator it = arrayDeque.iterator();
                l0.o(it, "queue.iterator()");
                do {
                    if (!it.hasNext()) {
                        if (z7) {
                            return arrayList;
                        }
                        throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate2);
                    }
                    Object next = it.next();
                    if (next == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                    }
                    x509Certificate = (X509Certificate) next;
                } while (!b(x509Certificate2, x509Certificate));
                it.remove();
                arrayList.add(x509Certificate);
            }
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    public boolean equals(@a7.e Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof a) && l0.g(((a) obj).f40415b, this.f40415b);
    }

    public int hashCode() {
        return this.f40415b.hashCode();
    }
}
