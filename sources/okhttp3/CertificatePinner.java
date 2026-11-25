package okhttp3;

import a7.d;
import com.facebook.share.internal.MessengerShareContentUtility;
import h5.e;
import h5.l;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.b1;
import kotlin.collections.g0;
import kotlin.collections.y;
import kotlin.collections.z;
import kotlin.i0;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t1;
import kotlin.jvm.internal.w;
import kotlin.k;
import kotlin.text.b0;
import kotlin.text.c0;
import okio.p;
import org.apache.commons.lang3.ClassUtils;
import u5.c;

/* JADX INFO: loaded from: classes3.dex */
@i0(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\b\r\u0018\u0000 &2\u00020\u0001:\u0003'&(B#\b\u0000\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00100\u001c\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b$\u0010%J\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\tH\u0000¢\u0006\u0004\b\f\u0010\rJ+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u000e\"\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\u000fJ\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0017\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0016R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00100\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b\"\u0010#¨\u0006)"}, d2 = {"Lokhttp3/CertificatePinner;", "", "", "hostname", "", "Ljava/security/cert/Certificate;", "peerCertificates", "Lkotlin/l2;", "check", "Lkotlin/Function0;", "Ljava/security/cert/X509Certificate;", "cleanedPeerCertificatesFn", "check$okhttp", "(Ljava/lang/String;Li5/a;)V", "", "(Ljava/lang/String;[Ljava/security/cert/Certificate;)V", "Lokhttp3/CertificatePinner$Pin;", "findMatchingPins", "Lu5/c;", "certificateChainCleaner", "withCertificateChainCleaner$okhttp", "(Lu5/c;)Lokhttp3/CertificatePinner;", "withCertificateChainCleaner", "other", "", "equals", "", "hashCode", "", "pins", "Ljava/util/Set;", "getPins", "()Ljava/util/Set;", "Lu5/c;", "getCertificateChainCleaner$okhttp", "()Lu5/c;", "<init>", "(Ljava/util/Set;Lu5/c;)V", "Companion", "Builder", "Pin", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class CertificatePinner {
    public static final Companion Companion = new Companion(null);

    @d
    @e
    public static final CertificatePinner DEFAULT = new Builder().build();

    @a7.e
    private final c certificateChainCleaner;

    @d
    private final Set<Pin> pins;

    @i0(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J'\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u000b\"\u00020\n¢\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u000eR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lokhttp3/CertificatePinner$Builder;", "", "()V", "pins", "", "Lokhttp3/CertificatePinner$Pin;", "getPins", "()Ljava/util/List;", "add", "pattern", "", "", "(Ljava/lang/String;[Ljava/lang/String;)Lokhttp3/CertificatePinner$Builder;", "build", "Lokhttp3/CertificatePinner;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Builder {

        @d
        private final List<Pin> pins = new ArrayList();

        @d
        public final Builder add(@d String pattern, @d String... pins) {
            l0.p(pattern, "pattern");
            l0.p(pins, "pins");
            for (String str : pins) {
                this.pins.add(new Pin(pattern, str));
            }
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @d
        public final CertificatePinner build() {
            return new CertificatePinner(g0.V5(this.pins), null, 2, 0 == true ? 1 : 0);
        }

        @d
        public final List<Pin> getPins() {
            return this.pins;
        }
    }

    @i0(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0007J\f\u0010\u0005\u001a\u00020\u0003*\u00020\u0002H\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lokhttp3/CertificatePinner$Companion;", "", "Ljava/security/cert/X509Certificate;", "Lokio/p;", "sha1Hash", "sha256Hash", "Ljava/security/cert/Certificate;", "certificate", "", "pin", "Lokhttp3/CertificatePinner;", MessengerShareContentUtility.PREVIEW_DEFAULT, "Lokhttp3/CertificatePinner;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        @d
        @l
        public final String pin(@d Certificate certificate) {
            l0.p(certificate, "certificate");
            if (!(certificate instanceof X509Certificate)) {
                throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
            }
            return "sha256/" + sha256Hash((X509Certificate) certificate).d();
        }

        @d
        @l
        public final p sha1Hash(@d X509Certificate sha1Hash) {
            l0.p(sha1Hash, "$this$sha1Hash");
            p.a aVar = p.f38508f;
            PublicKey publicKey = sha1Hash.getPublicKey();
            l0.o(publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            l0.o(encoded, "publicKey.encoded");
            return p.a.p(aVar, encoded, 0, 0, 3, null).X();
        }

        @d
        @l
        public final p sha256Hash(@d X509Certificate sha256Hash) {
            l0.p(sha256Hash, "$this$sha256Hash");
            p.a aVar = p.f38508f;
            PublicKey publicKey = sha256Hash.getPublicKey();
            l0.o(publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            l0.o(encoded, "publicKey.encoded");
            return p.a.p(aVar, encoded, 0, 0, 3, null).Y();
        }

        public /* synthetic */ Companion(w wVar) {
            this();
        }
    }

    @i0(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0013\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\fH\u0016R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lokhttp3/CertificatePinner$Pin;", "", "", "hostname", "", "matchesHostname", "Ljava/security/cert/X509Certificate;", "certificate", "matchesCertificate", "toString", "other", "equals", "", "hashCode", "pattern", "Ljava/lang/String;", "getPattern", "()Ljava/lang/String;", "hashAlgorithm", "getHashAlgorithm", "Lokio/p;", "hash", "Lokio/p;", "getHash", "()Lokio/p;", "pin", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Pin {

        @d
        private final p hash;

        @d
        private final String hashAlgorithm;

        @d
        private final String pattern;

        public Pin(@d String pattern, @d String pin) {
            l0.p(pattern, "pattern");
            l0.p(pin, "pin");
            if (!((b0.u2(pattern, "*.", false, 2, null) && c0.r3(pattern, "*", 1, false, 4, null) == -1) || (b0.u2(pattern, "**.", false, 2, null) && c0.r3(pattern, "*", 2, false, 4, null) == -1) || c0.r3(pattern, "*", 0, false, 6, null) == -1)) {
                throw new IllegalArgumentException(("Unexpected pattern: " + pattern).toString());
            }
            String strE = okhttp3.internal.a.e(pattern);
            if (strE == null) {
                throw new IllegalArgumentException("Invalid pattern: " + pattern);
            }
            this.pattern = strE;
            if (b0.u2(pin, "sha1/", false, 2, null)) {
                this.hashAlgorithm = "sha1";
                p.a aVar = p.f38508f;
                String strSubstring = pin.substring(5);
                l0.o(strSubstring, "(this as java.lang.String).substring(startIndex)");
                p pVarH = aVar.h(strSubstring);
                if (pVarH != null) {
                    this.hash = pVarH;
                    return;
                }
                throw new IllegalArgumentException("Invalid pin hash: " + pin);
            }
            if (!b0.u2(pin, "sha256/", false, 2, null)) {
                throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + pin);
            }
            this.hashAlgorithm = "sha256";
            p.a aVar2 = p.f38508f;
            String strSubstring2 = pin.substring(7);
            l0.o(strSubstring2, "(this as java.lang.String).substring(startIndex)");
            p pVarH2 = aVar2.h(strSubstring2);
            if (pVarH2 != null) {
                this.hash = pVarH2;
                return;
            }
            throw new IllegalArgumentException("Invalid pin hash: " + pin);
        }

        public boolean equals(@a7.e Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Pin)) {
                return false;
            }
            Pin pin = (Pin) obj;
            return ((l0.g(this.pattern, pin.pattern) ^ true) || (l0.g(this.hashAlgorithm, pin.hashAlgorithm) ^ true) || (l0.g(this.hash, pin.hash) ^ true)) ? false : true;
        }

        @d
        public final p getHash() {
            return this.hash;
        }

        @d
        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        @d
        public final String getPattern() {
            return this.pattern;
        }

        public int hashCode() {
            return (((this.pattern.hashCode() * 31) + this.hashAlgorithm.hashCode()) * 31) + this.hash.hashCode();
        }

        public final boolean matchesCertificate(@d X509Certificate certificate) {
            l0.p(certificate, "certificate");
            String str = this.hashAlgorithm;
            int iHashCode = str.hashCode();
            if (iHashCode != -903629273) {
                if (iHashCode == 3528965 && str.equals("sha1")) {
                    return l0.g(this.hash, CertificatePinner.Companion.sha1Hash(certificate));
                }
            } else if (str.equals("sha256")) {
                return l0.g(this.hash, CertificatePinner.Companion.sha256Hash(certificate));
            }
            return false;
        }

        public final boolean matchesHostname(@d String hostname) {
            l0.p(hostname, "hostname");
            if (b0.u2(this.pattern, "**.", false, 2, null)) {
                int length = this.pattern.length() - 3;
                int length2 = hostname.length() - length;
                if (!b0.f2(hostname, hostname.length() - length, this.pattern, 3, length, false, 16, null)) {
                    return false;
                }
                if (length2 != 0 && hostname.charAt(length2 - 1) != '.') {
                    return false;
                }
            } else {
                if (!b0.u2(this.pattern, "*.", false, 2, null)) {
                    return l0.g(hostname, this.pattern);
                }
                int length3 = this.pattern.length() - 1;
                int length4 = hostname.length() - length3;
                if (!b0.f2(hostname, hostname.length() - length3, this.pattern, 1, length3, false, 16, null) || c0.E3(hostname, ClassUtils.PACKAGE_SEPARATOR_CHAR, length4 - 1, false, 4, null) != -1) {
                    return false;
                }
            }
            return true;
        }

        @d
        public String toString() {
            return this.hashAlgorithm + '/' + this.hash.d();
        }
    }

    /* JADX INFO: renamed from: okhttp3.CertificatePinner$check$1, reason: invalid class name */
    @i0(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Ljava/security/cert/X509Certificate;", "invoke"}, k = 3, mv = {1, 4, 0})
    static final class AnonymousClass1 extends n0 implements i5.a<List<? extends X509Certificate>> {
        final /* synthetic */ String $hostname;
        final /* synthetic */ List $peerCertificates;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(List list, String str) {
            super(0);
            this.$peerCertificates = list;
            this.$hostname = str;
        }

        @Override // i5.a
        @d
        public final List<? extends X509Certificate> invoke() {
            List<Certificate> listA;
            c certificateChainCleaner$okhttp = CertificatePinner.this.getCertificateChainCleaner$okhttp();
            if (certificateChainCleaner$okhttp == null || (listA = certificateChainCleaner$okhttp.a(this.$peerCertificates, this.$hostname)) == null) {
                listA = this.$peerCertificates;
            }
            ArrayList arrayList = new ArrayList(z.Z(listA, 10));
            for (Certificate certificate : listA) {
                if (certificate == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                }
                arrayList.add((X509Certificate) certificate);
            }
            return arrayList;
        }
    }

    public CertificatePinner(@d Set<Pin> pins, @a7.e c cVar) {
        l0.p(pins, "pins");
        this.pins = pins;
        this.certificateChainCleaner = cVar;
    }

    @d
    @l
    public static final String pin(@d Certificate certificate) {
        return Companion.pin(certificate);
    }

    @d
    @l
    public static final p sha1Hash(@d X509Certificate x509Certificate) {
        return Companion.sha1Hash(x509Certificate);
    }

    @d
    @l
    public static final p sha256Hash(@d X509Certificate x509Certificate) {
        return Companion.sha256Hash(x509Certificate);
    }

    public final void check(@d String hostname, @d List<? extends Certificate> peerCertificates) throws SSLPeerUnverifiedException {
        l0.p(hostname, "hostname");
        l0.p(peerCertificates, "peerCertificates");
        check$okhttp(hostname, new AnonymousClass1(peerCertificates, hostname));
    }

    public final void check$okhttp(@d String hostname, @d i5.a<? extends List<? extends X509Certificate>> cleanedPeerCertificatesFn) throws SSLPeerUnverifiedException {
        l0.p(hostname, "hostname");
        l0.p(cleanedPeerCertificatesFn, "cleanedPeerCertificatesFn");
        List<Pin> listFindMatchingPins = findMatchingPins(hostname);
        if (listFindMatchingPins.isEmpty()) {
            return;
        }
        List<? extends X509Certificate> listInvoke = cleanedPeerCertificatesFn.invoke();
        for (X509Certificate x509Certificate : listInvoke) {
            p pVarSha256Hash = null;
            p pVarSha1Hash = null;
            for (Pin pin : listFindMatchingPins) {
                String hashAlgorithm = pin.getHashAlgorithm();
                int iHashCode = hashAlgorithm.hashCode();
                if (iHashCode != -903629273) {
                    if (iHashCode != 3528965 || !hashAlgorithm.equals("sha1")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + pin.getHashAlgorithm());
                    }
                    if (pVarSha1Hash == null) {
                        pVarSha1Hash = Companion.sha1Hash(x509Certificate);
                    }
                    if (l0.g(pin.getHash(), pVarSha1Hash)) {
                        return;
                    }
                } else {
                    if (!hashAlgorithm.equals("sha256")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + pin.getHashAlgorithm());
                    }
                    if (pVarSha256Hash == null) {
                        pVarSha256Hash = Companion.sha256Hash(x509Certificate);
                    }
                    if (l0.g(pin.getHash(), pVarSha256Hash)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : listInvoke) {
            sb.append("\n    ");
            sb.append(Companion.pin(x509Certificate2));
            sb.append(": ");
            Principal subjectDN = x509Certificate2.getSubjectDN();
            l0.o(subjectDN, "element.subjectDN");
            sb.append(subjectDN.getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(hostname);
        sb.append(":");
        for (Pin pin2 : listFindMatchingPins) {
            sb.append("\n    ");
            sb.append(pin2);
        }
        String string = sb.toString();
        l0.o(string, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(string);
    }

    public boolean equals(@a7.e Object obj) {
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (l0.g(certificatePinner.pins, this.pins) && l0.g(certificatePinner.certificateChainCleaner, this.certificateChainCleaner)) {
                return true;
            }
        }
        return false;
    }

    @d
    public final List<Pin> findMatchingPins(@d String hostname) {
        l0.p(hostname, "hostname");
        Set<Pin> set = this.pins;
        List<Pin> listF = y.F();
        for (Object obj : set) {
            if (((Pin) obj).matchesHostname(hostname)) {
                if (listF.isEmpty()) {
                    listF = new ArrayList<>();
                }
                t1.g(listF).add(obj);
            }
        }
        return listF;
    }

    @a7.e
    public final c getCertificateChainCleaner$okhttp() {
        return this.certificateChainCleaner;
    }

    @d
    public final Set<Pin> getPins() {
        return this.pins;
    }

    public int hashCode() {
        int iHashCode = (1517 + this.pins.hashCode()) * 41;
        c cVar = this.certificateChainCleaner;
        return iHashCode + (cVar != null ? cVar.hashCode() : 0);
    }

    @d
    public final CertificatePinner withCertificateChainCleaner$okhttp(@d c certificateChainCleaner) {
        l0.p(certificateChainCleaner, "certificateChainCleaner");
        return l0.g(this.certificateChainCleaner, certificateChainCleaner) ? this : new CertificatePinner(this.pins, certificateChainCleaner);
    }

    public /* synthetic */ CertificatePinner(Set set, c cVar, int i7, w wVar) {
        this(set, (i7 & 2) != 0 ? null : cVar);
    }

    @k(message = "replaced with {@link #check(String, List)}.", replaceWith = @b1(expression = "check(hostname, peerCertificates.toList())", imports = {}))
    public final void check(@d String hostname, @d Certificate... peerCertificates) throws SSLPeerUnverifiedException {
        l0.p(hostname, "hostname");
        l0.p(peerCertificates, "peerCertificates");
        check(hostname, kotlin.collections.p.kz(peerCertificates));
    }
}
