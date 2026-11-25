package u5;

import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<X500Principal, Set<X509Certificate>> f40416a;

    public b(@a7.d X509Certificate... caCerts) {
        l0.p(caCerts, "caCerts");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (X509Certificate x509Certificate : caCerts) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            l0.o(subjectX500Principal, "caCert.subjectX500Principal");
            Object linkedHashSet = linkedHashMap.get(subjectX500Principal);
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet();
                linkedHashMap.put(subjectX500Principal, linkedHashSet);
            }
            ((Set) linkedHashSet).add(x509Certificate);
        }
        this.f40416a = linkedHashMap;
    }

    @Override // u5.e
    @a7.e
    public X509Certificate a(@a7.d X509Certificate cert) {
        boolean z7;
        l0.p(cert, "cert");
        Set<X509Certificate> set = this.f40416a.get(cert.getIssuerX500Principal());
        Object obj = null;
        if (set == null) {
            return null;
        }
        for (Object obj2 : set) {
            try {
                cert.verify(((X509Certificate) obj2).getPublicKey());
                z7 = true;
            } catch (Exception unused) {
                z7 = false;
            }
            if (z7) {
                obj = obj2;
                break;
            }
        }
        return (X509Certificate) obj;
    }

    public boolean equals(@a7.e Object obj) {
        return obj == this || ((obj instanceof b) && l0.g(((b) obj).f40416a, this.f40416a));
    }

    public int hashCode() {
        return this.f40416a.hashCode();
    }
}
