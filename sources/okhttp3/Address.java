package okhttp3;

import a7.d;
import a7.e;
import com.alipay.sdk.util.j;
import h5.h;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.b1;
import kotlin.i0;
import kotlin.jvm.internal.l0;
import kotlin.k;
import kotlin.m;

/* JADX INFO: loaded from: classes3.dex */
@i0(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0015\u0012\u0006\u0010\u0019\u001a\u00020\u001a¢\u0006\u0002\u0010\u001bJ\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\b(J\u0013\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0015H\u0007¢\u0006\u0002\b)J\r\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\b*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0015\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u00020\u0000H\u0000¢\u0006\u0002\b0J\b\u00101\u001a\u00020\u0005H\u0016J\u000f\u0010\f\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0002\b2J\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0007¢\u0006\u0002\b3J\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0002\b4J\r\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0002\b5J\r\u0010\u0019\u001a\u00020\u001aH\u0007¢\u0006\u0002\b6J\r\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b7J\u000f\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0002\b8J\b\u00109\u001a\u00020\u0003H\u0016J\r\u0010%\u001a\u00020&H\u0007¢\u0006\u0002\b:R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001cR\u0019\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00158G¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u001dR\u0013\u0010\u0006\u001a\u00020\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u001eR\u0015\u0010\f\u001a\u0004\u0018\u00010\r8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001fR\u0019\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158G¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u001dR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010 R\u0013\u0010\u0010\u001a\u00020\u00118\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010!R\u0013\u0010\u0019\u001a\u00020\u001a8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\"R\u0013\u0010\b\u001a\u00020\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010#R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010$R\u0013\u0010%\u001a\u00020&8G¢\u0006\b\n\u0000\u001a\u0004\b%\u0010'¨\u0006;"}, d2 = {"Lokhttp3/Address;", "", "uriHost", "", "uriPort", "", com.haier.uhome.trace.b.b.f30245b, "Lokhttp3/Dns;", "socketFactory", "Ljavax/net/SocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "hostnameVerifier", "Ljavax/net/ssl/HostnameVerifier;", "certificatePinner", "Lokhttp3/CertificatePinner;", "proxyAuthenticator", "Lokhttp3/Authenticator;", "proxy", "Ljava/net/Proxy;", "protocols", "", "Lokhttp3/Protocol;", "connectionSpecs", "Lokhttp3/ConnectionSpec;", "proxySelector", "Ljava/net/ProxySelector;", "(Ljava/lang/String;ILokhttp3/Dns;Ljavax/net/SocketFactory;Ljavax/net/ssl/SSLSocketFactory;Ljavax/net/ssl/HostnameVerifier;Lokhttp3/CertificatePinner;Lokhttp3/Authenticator;Ljava/net/Proxy;Ljava/util/List;Ljava/util/List;Ljava/net/ProxySelector;)V", "()Lokhttp3/CertificatePinner;", "()Ljava/util/List;", "()Lokhttp3/Dns;", "()Ljavax/net/ssl/HostnameVerifier;", "()Ljava/net/Proxy;", "()Lokhttp3/Authenticator;", "()Ljava/net/ProxySelector;", "()Ljavax/net/SocketFactory;", "()Ljavax/net/ssl/SSLSocketFactory;", "url", "Lokhttp3/HttpUrl;", "()Lokhttp3/HttpUrl;", "-deprecated_certificatePinner", "-deprecated_connectionSpecs", "-deprecated_dns", "equals", "", "other", "equalsNonHost", "that", "equalsNonHost$okhttp", "hashCode", "-deprecated_hostnameVerifier", "-deprecated_protocols", "-deprecated_proxy", "-deprecated_proxyAuthenticator", "-deprecated_proxySelector", "-deprecated_socketFactory", "-deprecated_sslSocketFactory", "toString", "-deprecated_url", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Address {

    @e
    private final CertificatePinner certificatePinner;

    @d
    private final List<ConnectionSpec> connectionSpecs;

    @d
    private final Dns dns;

    @e
    private final HostnameVerifier hostnameVerifier;

    @d
    private final List<Protocol> protocols;

    @e
    private final Proxy proxy;

    @d
    private final Authenticator proxyAuthenticator;

    @d
    private final ProxySelector proxySelector;

    @d
    private final SocketFactory socketFactory;

    @e
    private final SSLSocketFactory sslSocketFactory;

    @d
    private final HttpUrl url;

    public Address(@d String uriHost, int i7, @d Dns dns, @d SocketFactory socketFactory, @e SSLSocketFactory sSLSocketFactory, @e HostnameVerifier hostnameVerifier, @e CertificatePinner certificatePinner, @d Authenticator proxyAuthenticator, @e Proxy proxy, @d List<? extends Protocol> protocols, @d List<ConnectionSpec> connectionSpecs, @d ProxySelector proxySelector) {
        l0.p(uriHost, "uriHost");
        l0.p(dns, "dns");
        l0.p(socketFactory, "socketFactory");
        l0.p(proxyAuthenticator, "proxyAuthenticator");
        l0.p(protocols, "protocols");
        l0.p(connectionSpecs, "connectionSpecs");
        l0.p(proxySelector, "proxySelector");
        this.dns = dns;
        this.socketFactory = socketFactory;
        this.sslSocketFactory = sSLSocketFactory;
        this.hostnameVerifier = hostnameVerifier;
        this.certificatePinner = certificatePinner;
        this.proxyAuthenticator = proxyAuthenticator;
        this.proxy = proxy;
        this.proxySelector = proxySelector;
        this.url = new HttpUrl.Builder().scheme(sSLSocketFactory != null ? j0.b.f34226a : com.haier.uhome.usdk.base.a.av).host(uriHost).port(i7).build();
        this.protocols = okhttp3.internal.d.c0(protocols);
        this.connectionSpecs = okhttp3.internal.d.c0(connectionSpecs);
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "certificatePinner", imports = {}))
    @e
    @h(name = "-deprecated_certificatePinner")
    /* JADX INFO: renamed from: -deprecated_certificatePinner, reason: not valid java name */
    public final CertificatePinner m2deprecated_certificatePinner() {
        return this.certificatePinner;
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "connectionSpecs", imports = {}))
    @h(name = "-deprecated_connectionSpecs")
    /* JADX INFO: renamed from: -deprecated_connectionSpecs, reason: not valid java name */
    public final List<ConnectionSpec> m3deprecated_connectionSpecs() {
        return this.connectionSpecs;
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = com.haier.uhome.trace.b.b.f30245b, imports = {}))
    @h(name = "-deprecated_dns")
    /* JADX INFO: renamed from: -deprecated_dns, reason: not valid java name */
    public final Dns m4deprecated_dns() {
        return this.dns;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "hostnameVerifier", imports = {}))
    @e
    @h(name = "-deprecated_hostnameVerifier")
    /* JADX INFO: renamed from: -deprecated_hostnameVerifier, reason: not valid java name */
    public final HostnameVerifier m5deprecated_hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "protocols", imports = {}))
    @h(name = "-deprecated_protocols")
    /* JADX INFO: renamed from: -deprecated_protocols, reason: not valid java name */
    public final List<Protocol> m6deprecated_protocols() {
        return this.protocols;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "proxy", imports = {}))
    @e
    @h(name = "-deprecated_proxy")
    /* JADX INFO: renamed from: -deprecated_proxy, reason: not valid java name */
    public final Proxy m7deprecated_proxy() {
        return this.proxy;
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "proxyAuthenticator", imports = {}))
    @h(name = "-deprecated_proxyAuthenticator")
    /* JADX INFO: renamed from: -deprecated_proxyAuthenticator, reason: not valid java name */
    public final Authenticator m8deprecated_proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "proxySelector", imports = {}))
    @h(name = "-deprecated_proxySelector")
    /* JADX INFO: renamed from: -deprecated_proxySelector, reason: not valid java name */
    public final ProxySelector m9deprecated_proxySelector() {
        return this.proxySelector;
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "socketFactory", imports = {}))
    @h(name = "-deprecated_socketFactory")
    /* JADX INFO: renamed from: -deprecated_socketFactory, reason: not valid java name */
    public final SocketFactory m10deprecated_socketFactory() {
        return this.socketFactory;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "sslSocketFactory", imports = {}))
    @e
    @h(name = "-deprecated_sslSocketFactory")
    /* JADX INFO: renamed from: -deprecated_sslSocketFactory, reason: not valid java name */
    public final SSLSocketFactory m11deprecated_sslSocketFactory() {
        return this.sslSocketFactory;
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "url", imports = {}))
    @h(name = "-deprecated_url")
    /* JADX INFO: renamed from: -deprecated_url, reason: not valid java name */
    public final HttpUrl m12deprecated_url() {
        return this.url;
    }

    @e
    @h(name = "certificatePinner")
    public final CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    @d
    @h(name = "connectionSpecs")
    public final List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    @d
    @h(name = com.haier.uhome.trace.b.b.f30245b)
    public final Dns dns() {
        return this.dns;
    }

    public boolean equals(@e Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            if (l0.g(this.url, address.url) && equalsNonHost$okhttp(address)) {
                return true;
            }
        }
        return false;
    }

    public final boolean equalsNonHost$okhttp(@d Address that) {
        l0.p(that, "that");
        return l0.g(this.dns, that.dns) && l0.g(this.proxyAuthenticator, that.proxyAuthenticator) && l0.g(this.protocols, that.protocols) && l0.g(this.connectionSpecs, that.connectionSpecs) && l0.g(this.proxySelector, that.proxySelector) && l0.g(this.proxy, that.proxy) && l0.g(this.sslSocketFactory, that.sslSocketFactory) && l0.g(this.hostnameVerifier, that.hostnameVerifier) && l0.g(this.certificatePinner, that.certificatePinner) && this.url.port() == that.url.port();
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.url.hashCode()) * 31) + this.dns.hashCode()) * 31) + this.proxyAuthenticator.hashCode()) * 31) + this.protocols.hashCode()) * 31) + this.connectionSpecs.hashCode()) * 31) + this.proxySelector.hashCode()) * 31) + Objects.hashCode(this.proxy)) * 31) + Objects.hashCode(this.sslSocketFactory)) * 31) + Objects.hashCode(this.hostnameVerifier)) * 31) + Objects.hashCode(this.certificatePinner);
    }

    @e
    @h(name = "hostnameVerifier")
    public final HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @d
    @h(name = "protocols")
    public final List<Protocol> protocols() {
        return this.protocols;
    }

    @e
    @h(name = "proxy")
    public final Proxy proxy() {
        return this.proxy;
    }

    @d
    @h(name = "proxyAuthenticator")
    public final Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @d
    @h(name = "proxySelector")
    public final ProxySelector proxySelector() {
        return this.proxySelector;
    }

    @d
    @h(name = "socketFactory")
    public final SocketFactory socketFactory() {
        return this.socketFactory;
    }

    @e
    @h(name = "sslSocketFactory")
    public final SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    @d
    public String toString() {
        StringBuilder sb;
        Object obj;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Address{");
        sb2.append(this.url.host());
        sb2.append(':');
        sb2.append(this.url.port());
        sb2.append(", ");
        if (this.proxy != null) {
            sb = new StringBuilder();
            sb.append("proxy=");
            obj = this.proxy;
        } else {
            sb = new StringBuilder();
            sb.append("proxySelector=");
            obj = this.proxySelector;
        }
        sb.append(obj);
        sb2.append(sb.toString());
        sb2.append(j.f13808d);
        return sb2.toString();
    }

    @d
    @h(name = "url")
    public final HttpUrl url() {
        return this.url;
    }
}
