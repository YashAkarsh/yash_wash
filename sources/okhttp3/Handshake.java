package okhttp3;

import a7.d;
import a7.e;
import h5.h;
import h5.l;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.b1;
import kotlin.collections.g0;
import kotlin.collections.y;
import kotlin.collections.z;
import kotlin.d0;
import kotlin.f0;
import kotlin.i0;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.w;
import kotlin.k;
import kotlin.m;

/* JADX INFO: loaded from: classes3.dex */
@i0(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 *2\u00020\u0001:\u0001*B;\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0012\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0&¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¢\u0006\u0004\b\u0013\u0010\rJ\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0004\b\u0015\u0010\u0011J\u0013\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8GX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u000e\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b\u0005\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b\t\u0010\bR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0007¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b\u0014\u0010\rR\u0018\u0010%\u001a\u00020\u001c*\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u000f8G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u000f8G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0011¨\u0006+"}, d2 = {"Lokhttp3/Handshake;", "", "Lokhttp3/TlsVersion;", "-deprecated_tlsVersion", "()Lokhttp3/TlsVersion;", "tlsVersion", "Lokhttp3/CipherSuite;", "-deprecated_cipherSuite", "()Lokhttp3/CipherSuite;", "cipherSuite", "", "Ljava/security/cert/Certificate;", "-deprecated_peerCertificates", "()Ljava/util/List;", "peerCertificates", "Ljava/security/Principal;", "-deprecated_peerPrincipal", "()Ljava/security/Principal;", "peerPrincipal", "-deprecated_localCertificates", "localCertificates", "-deprecated_localPrincipal", "localPrincipal", "other", "", "equals", "", "hashCode", "", "toString", "peerCertificates$delegate", "Lkotlin/d0;", "Lokhttp3/TlsVersion;", "Lokhttp3/CipherSuite;", "Ljava/util/List;", "getName", "(Ljava/security/cert/Certificate;)Ljava/lang/String;", "name", "Lkotlin/Function0;", "peerCertificatesFn", "<init>", "(Lokhttp3/TlsVersion;Lokhttp3/CipherSuite;Ljava/util/List;Li5/a;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Handshake {
    public static final Companion Companion = new Companion(null);

    @d
    private final CipherSuite cipherSuite;

    @d
    private final List<Certificate> localCertificates;

    @d
    private final d0 peerCertificates$delegate;

    @d
    private final TlsVersion tlsVersion;

    @i0(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0007J4\u0010\u0003\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0007J\u0011\u0010\u0010\u001a\u00020\u0004*\u00020\u0006H\u0007¢\u0006\u0002\b\u0003J!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r*\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lokhttp3/Handshake$Companion;", "", "()V", "get", "Lokhttp3/Handshake;", "sslSession", "Ljavax/net/ssl/SSLSession;", "-deprecated_get", "tlsVersion", "Lokhttp3/TlsVersion;", "cipherSuite", "Lokhttp3/CipherSuite;", "peerCertificates", "", "Ljava/security/cert/Certificate;", "localCertificates", "handshake", "toImmutableList", "", "([Ljava/security/cert/Certificate;)Ljava/util/List;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        private final List<Certificate> toImmutableList(Certificate[] certificateArr) {
            return certificateArr != null ? okhttp3.internal.d.z((Certificate[]) Arrays.copyOf(certificateArr, certificateArr.length)) : y.F();
        }

        @d
        @k(level = m.ERROR, message = "moved to extension function", replaceWith = @b1(expression = "sslSession.handshake()", imports = {}))
        @h(name = "-deprecated_get")
        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final Handshake m49deprecated_get(@d SSLSession sslSession) throws IOException {
            l0.p(sslSession, "sslSession");
            return get(sslSession);
        }

        @d
        @h(name = "get")
        @l
        public final Handshake get(@d SSLSession handshake) throws IOException {
            List<Certificate> listF;
            l0.p(handshake, "$this$handshake");
            String cipherSuite = handshake.getCipherSuite();
            if (cipherSuite == null) {
                throw new IllegalStateException("cipherSuite == null".toString());
            }
            int iHashCode = cipherSuite.hashCode();
            if (iHashCode == 1019404634 ? cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") : iHashCode == 1208658923 && cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
                throw new IOException("cipherSuite == " + cipherSuite);
            }
            CipherSuite cipherSuiteForJavaName = CipherSuite.Companion.forJavaName(cipherSuite);
            String protocol = handshake.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null".toString());
            }
            if (l0.g("NONE", protocol)) {
                throw new IOException("tlsVersion == NONE");
            }
            TlsVersion tlsVersionForJavaName = TlsVersion.Companion.forJavaName(protocol);
            try {
                listF = toImmutableList(handshake.getPeerCertificates());
            } catch (SSLPeerUnverifiedException unused) {
                listF = y.F();
            }
            return new Handshake(tlsVersionForJavaName, cipherSuiteForJavaName, toImmutableList(handshake.getLocalCertificates()), new Handshake$Companion$handshake$1(listF));
        }

        public /* synthetic */ Companion(w wVar) {
            this();
        }

        @d
        @l
        public final Handshake get(@d TlsVersion tlsVersion, @d CipherSuite cipherSuite, @d List<? extends Certificate> peerCertificates, @d List<? extends Certificate> localCertificates) {
            l0.p(tlsVersion, "tlsVersion");
            l0.p(cipherSuite, "cipherSuite");
            l0.p(peerCertificates, "peerCertificates");
            l0.p(localCertificates, "localCertificates");
            return new Handshake(tlsVersion, cipherSuite, okhttp3.internal.d.c0(localCertificates), new Handshake$Companion$get$1(okhttp3.internal.d.c0(peerCertificates)));
        }
    }

    /* JADX INFO: renamed from: okhttp3.Handshake$peerCertificates$2, reason: invalid class name */
    @i0(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Ljava/security/cert/Certificate;", "invoke"}, k = 3, mv = {1, 4, 0})
    static final class AnonymousClass2 extends n0 implements i5.a<List<? extends Certificate>> {
        final /* synthetic */ i5.a $peerCertificatesFn;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(i5.a aVar) {
            super(0);
            this.$peerCertificatesFn = aVar;
        }

        @Override // i5.a
        @d
        public final List<? extends Certificate> invoke() {
            try {
                return (List) this.$peerCertificatesFn.invoke();
            } catch (SSLPeerUnverifiedException unused) {
                return y.F();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Handshake(@d TlsVersion tlsVersion, @d CipherSuite cipherSuite, @d List<? extends Certificate> localCertificates, @d i5.a<? extends List<? extends Certificate>> peerCertificatesFn) {
        l0.p(tlsVersion, "tlsVersion");
        l0.p(cipherSuite, "cipherSuite");
        l0.p(localCertificates, "localCertificates");
        l0.p(peerCertificatesFn, "peerCertificatesFn");
        this.tlsVersion = tlsVersion;
        this.cipherSuite = cipherSuite;
        this.localCertificates = localCertificates;
        this.peerCertificates$delegate = f0.a(new AnonymousClass2(peerCertificatesFn));
    }

    @d
    @h(name = "get")
    @l
    public static final Handshake get(@d SSLSession sSLSession) throws IOException {
        return Companion.get(sSLSession);
    }

    private final String getName(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return ((X509Certificate) certificate).getSubjectDN().toString();
        }
        String type = certificate.getType();
        l0.o(type, "type");
        return type;
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "cipherSuite", imports = {}))
    @h(name = "-deprecated_cipherSuite")
    /* JADX INFO: renamed from: -deprecated_cipherSuite, reason: not valid java name */
    public final CipherSuite m43deprecated_cipherSuite() {
        return this.cipherSuite;
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "localCertificates", imports = {}))
    @h(name = "-deprecated_localCertificates")
    /* JADX INFO: renamed from: -deprecated_localCertificates, reason: not valid java name */
    public final List<Certificate> m44deprecated_localCertificates() {
        return this.localCertificates;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "localPrincipal", imports = {}))
    @e
    @h(name = "-deprecated_localPrincipal")
    /* JADX INFO: renamed from: -deprecated_localPrincipal, reason: not valid java name */
    public final Principal m45deprecated_localPrincipal() {
        return localPrincipal();
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "peerCertificates", imports = {}))
    @h(name = "-deprecated_peerCertificates")
    /* JADX INFO: renamed from: -deprecated_peerCertificates, reason: not valid java name */
    public final List<Certificate> m46deprecated_peerCertificates() {
        return peerCertificates();
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "peerPrincipal", imports = {}))
    @e
    @h(name = "-deprecated_peerPrincipal")
    /* JADX INFO: renamed from: -deprecated_peerPrincipal, reason: not valid java name */
    public final Principal m47deprecated_peerPrincipal() {
        return peerPrincipal();
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "tlsVersion", imports = {}))
    @h(name = "-deprecated_tlsVersion")
    /* JADX INFO: renamed from: -deprecated_tlsVersion, reason: not valid java name */
    public final TlsVersion m48deprecated_tlsVersion() {
        return this.tlsVersion;
    }

    @d
    @h(name = "cipherSuite")
    public final CipherSuite cipherSuite() {
        return this.cipherSuite;
    }

    public boolean equals(@e Object obj) {
        if (obj instanceof Handshake) {
            Handshake handshake = (Handshake) obj;
            if (handshake.tlsVersion == this.tlsVersion && l0.g(handshake.cipherSuite, this.cipherSuite) && l0.g(handshake.peerCertificates(), peerCertificates()) && l0.g(handshake.localCertificates, this.localCertificates)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((527 + this.tlsVersion.hashCode()) * 31) + this.cipherSuite.hashCode()) * 31) + peerCertificates().hashCode()) * 31) + this.localCertificates.hashCode();
    }

    @d
    @h(name = "localCertificates")
    public final List<Certificate> localCertificates() {
        return this.localCertificates;
    }

    @e
    @h(name = "localPrincipal")
    public final Principal localPrincipal() {
        Object objB2 = g0.B2(this.localCertificates);
        if (!(objB2 instanceof X509Certificate)) {
            objB2 = null;
        }
        X509Certificate x509Certificate = (X509Certificate) objB2;
        if (x509Certificate != null) {
            return x509Certificate.getSubjectX500Principal();
        }
        return null;
    }

    @d
    @h(name = "peerCertificates")
    public final List<Certificate> peerCertificates() {
        return (List) this.peerCertificates$delegate.getValue();
    }

    @e
    @h(name = "peerPrincipal")
    public final Principal peerPrincipal() {
        Object objB2 = g0.B2(peerCertificates());
        if (!(objB2 instanceof X509Certificate)) {
            objB2 = null;
        }
        X509Certificate x509Certificate = (X509Certificate) objB2;
        if (x509Certificate != null) {
            return x509Certificate.getSubjectX500Principal();
        }
        return null;
    }

    @d
    @h(name = "tlsVersion")
    public final TlsVersion tlsVersion() {
        return this.tlsVersion;
    }

    @d
    public String toString() {
        List<Certificate> listPeerCertificates = peerCertificates();
        ArrayList arrayList = new ArrayList(z.Z(listPeerCertificates, 10));
        Iterator<T> it = listPeerCertificates.iterator();
        while (it.hasNext()) {
            arrayList.add(getName((Certificate) it.next()));
        }
        String string = arrayList.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("Handshake{");
        sb.append("tlsVersion=");
        sb.append(this.tlsVersion);
        sb.append(' ');
        sb.append("cipherSuite=");
        sb.append(this.cipherSuite);
        sb.append(' ');
        sb.append("peerCertificates=");
        sb.append(string);
        sb.append(' ');
        sb.append("localCertificates=");
        List<Certificate> list = this.localCertificates;
        ArrayList arrayList2 = new ArrayList(z.Z(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(getName((Certificate) it2.next()));
        }
        sb.append(arrayList2);
        sb.append('}');
        return sb.toString();
    }

    @d
    @l
    public static final Handshake get(@d TlsVersion tlsVersion, @d CipherSuite cipherSuite, @d List<? extends Certificate> list, @d List<? extends Certificate> list2) {
        return Companion.get(tlsVersion, cipherSuite, list, list2);
    }
}
