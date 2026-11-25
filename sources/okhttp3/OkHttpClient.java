package okhttp3;

import a7.d;
import a7.e;
import androidx.constraintlayout.core.motion.utils.w;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.x;
import com.haier.library.sumhttp.plugin.h;
import i5.l;
import java.net.Proxy;
import java.net.ProxySelector;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.b1;
import kotlin.collections.d0;
import kotlin.collections.g0;
import kotlin.i0;
import kotlin.jvm.internal.l0;
import kotlin.k;
import kotlin.m;
import okhttp3.internal.connection.i;
import u5.c;

/* JADX INFO: loaded from: classes3.dex */
@i0(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 \u008d\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u008e\u0001\u008d\u0001B\u0014\b\u0000\u0012\u0007\u0010\u0089\u0001\u001a\u00020\u000e¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001B\u000b\b\u0016¢\u0006\u0006\b\u008a\u0001\u0010\u008c\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u000f\u0010\u0013\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0017\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0007¢\u0006\u0004\b\u001d\u0010\u001bJ\u000f\u0010\"\u001a\u00020\u001fH\u0007¢\u0006\u0004\b \u0010!J\u000f\u0010&\u001a\u00020#H\u0007¢\u0006\u0004\b$\u0010%J\u000f\u0010*\u001a\u00020'H\u0007¢\u0006\u0004\b(\u0010)J\u000f\u0010,\u001a\u00020#H\u0007¢\u0006\u0004\b+\u0010%J\u000f\u0010.\u001a\u00020#H\u0007¢\u0006\u0004\b-\u0010%J\u000f\u00102\u001a\u00020/H\u0007¢\u0006\u0004\b0\u00101J\u0011\u00106\u001a\u0004\u0018\u000103H\u0007¢\u0006\u0004\b4\u00105J\u000f\u0010:\u001a\u000207H\u0007¢\u0006\u0004\b8\u00109J\u0011\u0010>\u001a\u0004\u0018\u00010;H\u0007¢\u0006\u0004\b<\u0010=J\u000f\u0010B\u001a\u00020?H\u0007¢\u0006\u0004\b@\u0010AJ\u000f\u0010D\u001a\u00020'H\u0007¢\u0006\u0004\bC\u0010)J\u000f\u0010H\u001a\u00020EH\u0007¢\u0006\u0004\bF\u0010GJ\u000f\u0010L\u001a\u00020IH\u0007¢\u0006\u0004\bJ\u0010KJ\u0015\u0010O\u001a\b\u0012\u0004\u0012\u00020M0\u0018H\u0007¢\u0006\u0004\bN\u0010\u001bJ\u0015\u0010R\u001a\b\u0012\u0004\u0012\u00020P0\u0018H\u0007¢\u0006\u0004\bQ\u0010\u001bJ\u000f\u0010V\u001a\u00020SH\u0007¢\u0006\u0004\bT\u0010UJ\u000f\u0010Z\u001a\u00020WH\u0007¢\u0006\u0004\bX\u0010YJ\u000f\u0010^\u001a\u00020[H\u0007¢\u0006\u0004\b\\\u0010]J\u000f\u0010`\u001a\u00020[H\u0007¢\u0006\u0004\b_\u0010]J\u000f\u0010b\u001a\u00020[H\u0007¢\u0006\u0004\ba\u0010]J\u000f\u0010d\u001a\u00020[H\u0007¢\u0006\u0004\bc\u0010]J\u000f\u0010f\u001a\u00020[H\u0007¢\u0006\u0004\be\u0010]R\u0017\u0010\u0013\u001a\u00020\u00108G¢\u0006\f\n\u0004\b\u0013\u0010g\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00148G¢\u0006\f\n\u0004\b\u0017\u0010h\u001a\u0004\b\u0017\u0010\u0016R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188G¢\u0006\f\n\u0004\b\u001c\u0010i\u001a\u0004\b\u001c\u0010\u001bR\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188G¢\u0006\f\n\u0004\b\u001e\u0010i\u001a\u0004\b\u001e\u0010\u001bR\u0017\u0010\"\u001a\u00020\u001f8G¢\u0006\f\n\u0004\b\"\u0010j\u001a\u0004\b\"\u0010!R\u0017\u0010&\u001a\u00020#8G¢\u0006\f\n\u0004\b&\u0010k\u001a\u0004\b&\u0010%R\u0017\u0010*\u001a\u00020'8G¢\u0006\f\n\u0004\b*\u0010l\u001a\u0004\b*\u0010)R\u0017\u0010,\u001a\u00020#8G¢\u0006\f\n\u0004\b,\u0010k\u001a\u0004\b,\u0010%R\u0017\u0010.\u001a\u00020#8G¢\u0006\f\n\u0004\b.\u0010k\u001a\u0004\b.\u0010%R\u0017\u00102\u001a\u00020/8G¢\u0006\f\n\u0004\b2\u0010m\u001a\u0004\b2\u00101R\u0019\u00106\u001a\u0004\u0018\u0001038G¢\u0006\f\n\u0004\b6\u0010n\u001a\u0004\b6\u00105R\u0017\u0010:\u001a\u0002078G¢\u0006\f\n\u0004\b:\u0010o\u001a\u0004\b:\u00109R\u0019\u0010>\u001a\u0004\u0018\u00010;8G¢\u0006\f\n\u0004\b>\u0010p\u001a\u0004\b>\u0010=R\u0017\u0010B\u001a\u00020?8G¢\u0006\f\n\u0004\bB\u0010q\u001a\u0004\bB\u0010AR\u0017\u0010D\u001a\u00020'8G¢\u0006\f\n\u0004\bD\u0010l\u001a\u0004\bD\u0010)R\u0017\u0010H\u001a\u00020E8G¢\u0006\f\n\u0004\bH\u0010r\u001a\u0004\bH\u0010GR\u0016\u0010s\u001a\u0004\u0018\u00010I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010tR\u0019\u0010v\u001a\u0004\u0018\u00010u8G¢\u0006\f\n\u0004\bv\u0010w\u001a\u0004\bv\u0010xR\u001d\u0010O\u001a\b\u0012\u0004\u0012\u00020M0\u00188G¢\u0006\f\n\u0004\bO\u0010i\u001a\u0004\bO\u0010\u001bR\u001d\u0010R\u001a\b\u0012\u0004\u0012\u00020P0\u00188G¢\u0006\f\n\u0004\bR\u0010i\u001a\u0004\bR\u0010\u001bR\u0017\u0010V\u001a\u00020S8G¢\u0006\f\n\u0004\bV\u0010y\u001a\u0004\bV\u0010UR\u0017\u0010Z\u001a\u00020W8G¢\u0006\f\n\u0004\bZ\u0010z\u001a\u0004\bZ\u0010YR\u0019\u0010|\u001a\u0004\u0018\u00010{8G¢\u0006\f\n\u0004\b|\u0010}\u001a\u0004\b|\u0010~R\u0017\u0010^\u001a\u00020[8G¢\u0006\f\n\u0004\b^\u0010\u007f\u001a\u0004\b^\u0010]R\u0017\u0010`\u001a\u00020[8G¢\u0006\f\n\u0004\b`\u0010\u007f\u001a\u0004\b`\u0010]R\u0017\u0010b\u001a\u00020[8G¢\u0006\f\n\u0004\bb\u0010\u007f\u001a\u0004\bb\u0010]R\u0017\u0010d\u001a\u00020[8G¢\u0006\f\n\u0004\bd\u0010\u007f\u001a\u0004\bd\u0010]R\u0017\u0010f\u001a\u00020[8G¢\u0006\f\n\u0004\bf\u0010\u007f\u001a\u0004\bf\u0010]R\u001d\u0010\u0081\u0001\u001a\u00030\u0080\u00018G¢\u0006\u0010\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0081\u0001\u0010\u0083\u0001R\u001d\u0010\u0085\u0001\u001a\u00030\u0084\u00018\u0006¢\u0006\u0010\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0011\u0010L\u001a\u00020I8G¢\u0006\u0006\u001a\u0004\bL\u0010K¨\u0006\u008f\u0001"}, d2 = {"Lokhttp3/OkHttpClient;", "", "Lokhttp3/Call$Factory;", "Lokhttp3/WebSocket$Factory;", "Lkotlin/l2;", "verifyClientState", "Lokhttp3/Request;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lokhttp3/Call;", "newCall", "Lokhttp3/WebSocketListener;", x.a.f15818a, "Lokhttp3/WebSocket;", "newWebSocket", "Lokhttp3/OkHttpClient$Builder;", "newBuilder", "Lokhttp3/Dispatcher;", "-deprecated_dispatcher", "()Lokhttp3/Dispatcher;", "dispatcher", "Lokhttp3/ConnectionPool;", "-deprecated_connectionPool", "()Lokhttp3/ConnectionPool;", "connectionPool", "", "Lokhttp3/Interceptor;", "-deprecated_interceptors", "()Ljava/util/List;", "interceptors", "-deprecated_networkInterceptors", "networkInterceptors", "Lokhttp3/EventListener$Factory;", "-deprecated_eventListenerFactory", "()Lokhttp3/EventListener$Factory;", "eventListenerFactory", "", "-deprecated_retryOnConnectionFailure", "()Z", "retryOnConnectionFailure", "Lokhttp3/Authenticator;", "-deprecated_authenticator", "()Lokhttp3/Authenticator;", "authenticator", "-deprecated_followRedirects", "followRedirects", "-deprecated_followSslRedirects", "followSslRedirects", "Lokhttp3/CookieJar;", "-deprecated_cookieJar", "()Lokhttp3/CookieJar;", "cookieJar", "Lokhttp3/Cache;", "-deprecated_cache", "()Lokhttp3/Cache;", "cache", "Lokhttp3/Dns;", "-deprecated_dns", "()Lokhttp3/Dns;", com.haier.uhome.trace.b.b.f30245b, "Ljava/net/Proxy;", "-deprecated_proxy", "()Ljava/net/Proxy;", "proxy", "Ljava/net/ProxySelector;", "-deprecated_proxySelector", "()Ljava/net/ProxySelector;", "proxySelector", "-deprecated_proxyAuthenticator", "proxyAuthenticator", "Ljavax/net/SocketFactory;", "-deprecated_socketFactory", "()Ljavax/net/SocketFactory;", "socketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "-deprecated_sslSocketFactory", "()Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Lokhttp3/ConnectionSpec;", "-deprecated_connectionSpecs", "connectionSpecs", "Lokhttp3/Protocol;", "-deprecated_protocols", "protocols", "Ljavax/net/ssl/HostnameVerifier;", "-deprecated_hostnameVerifier", "()Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "Lokhttp3/CertificatePinner;", "-deprecated_certificatePinner", "()Lokhttp3/CertificatePinner;", "certificatePinner", "", "-deprecated_callTimeoutMillis", "()I", "callTimeoutMillis", "-deprecated_connectTimeoutMillis", "connectTimeoutMillis", "-deprecated_readTimeoutMillis", "readTimeoutMillis", "-deprecated_writeTimeoutMillis", "writeTimeoutMillis", "-deprecated_pingIntervalMillis", "pingIntervalMillis", "Lokhttp3/Dispatcher;", "Lokhttp3/ConnectionPool;", "Ljava/util/List;", "Lokhttp3/EventListener$Factory;", "Z", "Lokhttp3/Authenticator;", "Lokhttp3/CookieJar;", "Lokhttp3/Cache;", "Lokhttp3/Dns;", "Ljava/net/Proxy;", "Ljava/net/ProxySelector;", "Ljavax/net/SocketFactory;", "sslSocketFactoryOrNull", "Ljavax/net/ssl/SSLSocketFactory;", "Ljavax/net/ssl/X509TrustManager;", "x509TrustManager", "Ljavax/net/ssl/X509TrustManager;", "()Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/HostnameVerifier;", "Lokhttp3/CertificatePinner;", "Lu5/c;", "certificateChainCleaner", "Lu5/c;", "()Lu5/c;", "I", "", "minWebSocketMessageToCompress", "J", "()J", "Lokhttp3/internal/connection/i;", "routeDatabase", "Lokhttp3/internal/connection/i;", "getRouteDatabase", "()Lokhttp3/internal/connection/i;", "builder", "<init>", "(Lokhttp3/OkHttpClient$Builder;)V", "()V", "Companion", "Builder", "okhttp"}, k = 1, mv = {1, 4, 0})
public class OkHttpClient implements Cloneable, Call.Factory, WebSocket.Factory {

    @d
    private final Authenticator authenticator;

    @e
    private final Cache cache;
    private final int callTimeoutMillis;

    @e
    private final c certificateChainCleaner;

    @d
    private final CertificatePinner certificatePinner;
    private final int connectTimeoutMillis;

    @d
    private final ConnectionPool connectionPool;

    @d
    private final List<ConnectionSpec> connectionSpecs;

    @d
    private final CookieJar cookieJar;

    @d
    private final Dispatcher dispatcher;

    @d
    private final Dns dns;

    @d
    private final EventListener.Factory eventListenerFactory;
    private final boolean followRedirects;
    private final boolean followSslRedirects;

    @d
    private final HostnameVerifier hostnameVerifier;

    @d
    private final List<Interceptor> interceptors;
    private final long minWebSocketMessageToCompress;

    @d
    private final List<Interceptor> networkInterceptors;
    private final int pingIntervalMillis;

    @d
    private final List<Protocol> protocols;

    @e
    private final Proxy proxy;

    @d
    private final Authenticator proxyAuthenticator;

    @d
    private final ProxySelector proxySelector;
    private final int readTimeoutMillis;
    private final boolean retryOnConnectionFailure;

    @d
    private final i routeDatabase;

    @d
    private final SocketFactory socketFactory;
    private final SSLSocketFactory sslSocketFactoryOrNull;
    private final int writeTimeoutMillis;

    @e
    private final X509TrustManager x509TrustManager;
    public static final Companion Companion = new Companion(null);

    @d
    private static final List<Protocol> DEFAULT_PROTOCOLS = okhttp3.internal.d.z(Protocol.HTTP_2, Protocol.HTTP_1_1);

    @d
    private static final List<ConnectionSpec> DEFAULT_CONNECTION_SPECS = okhttp3.internal.d.z(ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT);

    @i0(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b]\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\bÉ\u0001\u0010Ê\u0001B\u0014\b\u0010\u0012\u0007\u0010Ë\u0001\u001a\u00020J¢\u0006\u0006\bÉ\u0001\u0010Ì\u0001J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0007J8\u0010\n\u001a\u00020\u00002#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000bH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0007J8\u0010\u0015\u001a\u00020\u00002#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000bH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0013J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001bJ\u000e\u0010!\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u001bJ\u000e\u0010#\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\"J\u0010\u0010%\u001a\u00020\u00002\b\u0010%\u001a\u0004\u0018\u00010$J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010'\u001a\u00020&J\u0010\u0010)\u001a\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010(J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010+\u001a\u00020*J\u000e\u0010,\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u001dJ\u000e\u0010.\u001a\u00020\u00002\u0006\u0010.\u001a\u00020-J\u0010\u00100\u001a\u00020\u00002\u0006\u00100\u001a\u00020/H\u0007J\u0016\u00100\u001a\u00020\u00002\u0006\u00100\u001a\u00020/2\u0006\u00102\u001a\u000201J\u0014\u00105\u001a\u00020\u00002\f\u00105\u001a\b\u0012\u0004\u0012\u00020403J\u0014\u00107\u001a\u00020\u00002\f\u00107\u001a\b\u0012\u0004\u0012\u00020603J\u000e\u00109\u001a\u00020\u00002\u0006\u00109\u001a\u000208J\u000e\u0010;\u001a\u00020\u00002\u0006\u0010;\u001a\u00020:J\u0016\u0010@\u001a\u00020\u00002\u0006\u0010=\u001a\u00020<2\u0006\u0010?\u001a\u00020>J\u0010\u0010@\u001a\u00020\u00002\u0006\u0010B\u001a\u00020AH\u0007J\u0016\u0010C\u001a\u00020\u00002\u0006\u0010=\u001a\u00020<2\u0006\u0010?\u001a\u00020>J\u0010\u0010C\u001a\u00020\u00002\u0006\u0010B\u001a\u00020AH\u0007J\u0016\u0010D\u001a\u00020\u00002\u0006\u0010=\u001a\u00020<2\u0006\u0010?\u001a\u00020>J\u0010\u0010D\u001a\u00020\u00002\u0006\u0010B\u001a\u00020AH\u0007J\u0016\u0010E\u001a\u00020\u00002\u0006\u0010=\u001a\u00020<2\u0006\u0010?\u001a\u00020>J\u0010\u0010E\u001a\u00020\u00002\u0006\u0010B\u001a\u00020AH\u0007J\u0016\u0010G\u001a\u00020\u00002\u0006\u0010F\u001a\u00020<2\u0006\u0010?\u001a\u00020>J\u0010\u0010G\u001a\u00020\u00002\u0006\u0010B\u001a\u00020AH\u0007J\u000e\u0010I\u001a\u00020\u00002\u0006\u0010H\u001a\u00020<J\u0006\u0010K\u001a\u00020JR\"\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010\u0005\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010V\u001a\u0004\bW\u0010XR \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0014\u0010V\u001a\u0004\bY\u0010XR\"\u0010\u001a\u001a\u00020\u00198\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\"\u0010\u001c\u001a\u00020\u001b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010\u001e\u001a\u00020\u001d8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\"\u0010\u001f\u001a\u00020\u001b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010_\u001a\u0004\bi\u0010a\"\u0004\bj\u0010cR\"\u0010!\u001a\u00020\u001b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b!\u0010_\u001a\u0004\bk\u0010a\"\u0004\bl\u0010cR\"\u0010#\u001a\u00020\"8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b#\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR$\u0010%\u001a\u0004\u0018\u00010$8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b%\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\"\u0010'\u001a\u00020&8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b'\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R%\u0010)\u001a\u0004\u0018\u00010(8\u0000@\u0000X\u0080\u000e¢\u0006\u0013\n\u0004\b)\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R)\u0010+\u001a\u0004\u0018\u00010*8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b+\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R$\u0010,\u001a\u00020\u001d8\u0000@\u0000X\u0080\u000e¢\u0006\u0014\n\u0004\b,\u0010d\u001a\u0005\b\u0086\u0001\u0010f\"\u0005\b\u0087\u0001\u0010hR'\u0010.\u001a\u00020-8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b.\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R+\u0010\u008d\u0001\u001a\u0004\u0018\u00010/8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R+\u0010\u0093\u0001\u001a\u0004\u0018\u0001018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R+\u00105\u001a\b\u0012\u0004\u0012\u000204038\u0000@\u0000X\u0080\u000e¢\u0006\u0015\n\u0004\b5\u0010V\u001a\u0005\b\u0099\u0001\u0010X\"\u0006\b\u009a\u0001\u0010\u009b\u0001R+\u00107\u001a\b\u0012\u0004\u0012\u000206038\u0000@\u0000X\u0080\u000e¢\u0006\u0015\n\u0004\b7\u0010V\u001a\u0005\b\u009c\u0001\u0010X\"\u0006\b\u009d\u0001\u0010\u009b\u0001R'\u00109\u001a\u0002088\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b9\u0010\u009e\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R'\u0010;\u001a\u00020:8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b;\u0010£\u0001\u001a\u0006\b¤\u0001\u0010¥\u0001\"\u0006\b¦\u0001\u0010§\u0001R,\u0010©\u0001\u001a\u0005\u0018\u00010¨\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b©\u0001\u0010ª\u0001\u001a\u0006\b«\u0001\u0010¬\u0001\"\u0006\b\u00ad\u0001\u0010®\u0001R(\u0010@\u001a\u00030¯\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b@\u0010°\u0001\u001a\u0006\b±\u0001\u0010²\u0001\"\u0006\b³\u0001\u0010´\u0001R(\u0010C\u001a\u00030¯\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\bC\u0010°\u0001\u001a\u0006\bµ\u0001\u0010²\u0001\"\u0006\b¶\u0001\u0010´\u0001R(\u0010D\u001a\u00030¯\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\bD\u0010°\u0001\u001a\u0006\b·\u0001\u0010²\u0001\"\u0006\b¸\u0001\u0010´\u0001R(\u0010E\u001a\u00030¯\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\bE\u0010°\u0001\u001a\u0006\b¹\u0001\u0010²\u0001\"\u0006\bº\u0001\u0010´\u0001R(\u0010G\u001a\u00030¯\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\bG\u0010°\u0001\u001a\u0006\b»\u0001\u0010²\u0001\"\u0006\b¼\u0001\u0010´\u0001R'\u0010I\u001a\u00020<8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\bI\u0010½\u0001\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0006\bÀ\u0001\u0010Á\u0001R,\u0010Ã\u0001\u001a\u0005\u0018\u00010Â\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÃ\u0001\u0010Ä\u0001\u001a\u0006\bÅ\u0001\u0010Æ\u0001\"\u0006\bÇ\u0001\u0010È\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006Í\u0001"}, d2 = {"Lokhttp3/OkHttpClient$Builder;", "", "Lokhttp3/Dispatcher;", "dispatcher", "Lokhttp3/ConnectionPool;", "connectionPool", "", "Lokhttp3/Interceptor;", "interceptors", "interceptor", "addInterceptor", "Lkotlin/Function1;", "Lokhttp3/Interceptor$Chain;", "Lkotlin/v0;", "name", "chain", "Lokhttp3/Response;", "block", "-addInterceptor", "(Li5/l;)Lokhttp3/OkHttpClient$Builder;", "networkInterceptors", "addNetworkInterceptor", "-addNetworkInterceptor", "Lokhttp3/EventListener;", "eventListener", "Lokhttp3/EventListener$Factory;", "eventListenerFactory", "", "retryOnConnectionFailure", "Lokhttp3/Authenticator;", "authenticator", "followRedirects", "followProtocolRedirects", "followSslRedirects", "Lokhttp3/CookieJar;", "cookieJar", "Lokhttp3/Cache;", "cache", "Lokhttp3/Dns;", com.haier.uhome.trace.b.b.f30245b, "Ljava/net/Proxy;", "proxy", "Ljava/net/ProxySelector;", "proxySelector", "proxyAuthenticator", "Ljavax/net/SocketFactory;", "socketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "", "Lokhttp3/ConnectionSpec;", "connectionSpecs", "Lokhttp3/Protocol;", "protocols", "Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "Lokhttp3/CertificatePinner;", "certificatePinner", "", com.alipay.sdk.data.a.f13674p, "Ljava/util/concurrent/TimeUnit;", "unit", "callTimeout", "Ljava/time/Duration;", w.h.f3144b, "connectTimeout", "readTimeout", "writeTimeout", "interval", "pingInterval", "bytes", "minWebSocketMessageToCompress", "Lokhttp3/OkHttpClient;", "build", "Lokhttp3/Dispatcher;", "getDispatcher$okhttp", "()Lokhttp3/Dispatcher;", "setDispatcher$okhttp", "(Lokhttp3/Dispatcher;)V", "Lokhttp3/ConnectionPool;", "getConnectionPool$okhttp", "()Lokhttp3/ConnectionPool;", "setConnectionPool$okhttp", "(Lokhttp3/ConnectionPool;)V", "Ljava/util/List;", "getInterceptors$okhttp", "()Ljava/util/List;", "getNetworkInterceptors$okhttp", "Lokhttp3/EventListener$Factory;", "getEventListenerFactory$okhttp", "()Lokhttp3/EventListener$Factory;", "setEventListenerFactory$okhttp", "(Lokhttp3/EventListener$Factory;)V", "Z", "getRetryOnConnectionFailure$okhttp", "()Z", "setRetryOnConnectionFailure$okhttp", "(Z)V", "Lokhttp3/Authenticator;", "getAuthenticator$okhttp", "()Lokhttp3/Authenticator;", "setAuthenticator$okhttp", "(Lokhttp3/Authenticator;)V", "getFollowRedirects$okhttp", "setFollowRedirects$okhttp", "getFollowSslRedirects$okhttp", "setFollowSslRedirects$okhttp", "Lokhttp3/CookieJar;", "getCookieJar$okhttp", "()Lokhttp3/CookieJar;", "setCookieJar$okhttp", "(Lokhttp3/CookieJar;)V", "Lokhttp3/Cache;", "getCache$okhttp", "()Lokhttp3/Cache;", "setCache$okhttp", "(Lokhttp3/Cache;)V", "Lokhttp3/Dns;", "getDns$okhttp", "()Lokhttp3/Dns;", "setDns$okhttp", "(Lokhttp3/Dns;)V", "Ljava/net/Proxy;", "getProxy$okhttp", "()Ljava/net/Proxy;", "setProxy$okhttp", "(Ljava/net/Proxy;)V", "Ljava/net/ProxySelector;", "getProxySelector$okhttp", "()Ljava/net/ProxySelector;", "setProxySelector$okhttp", "(Ljava/net/ProxySelector;)V", "getProxyAuthenticator$okhttp", "setProxyAuthenticator$okhttp", "Ljavax/net/SocketFactory;", "getSocketFactory$okhttp", "()Ljavax/net/SocketFactory;", "setSocketFactory$okhttp", "(Ljavax/net/SocketFactory;)V", "sslSocketFactoryOrNull", "Ljavax/net/ssl/SSLSocketFactory;", "getSslSocketFactoryOrNull$okhttp", "()Ljavax/net/ssl/SSLSocketFactory;", "setSslSocketFactoryOrNull$okhttp", "(Ljavax/net/ssl/SSLSocketFactory;)V", "x509TrustManagerOrNull", "Ljavax/net/ssl/X509TrustManager;", "getX509TrustManagerOrNull$okhttp", "()Ljavax/net/ssl/X509TrustManager;", "setX509TrustManagerOrNull$okhttp", "(Ljavax/net/ssl/X509TrustManager;)V", "getConnectionSpecs$okhttp", "setConnectionSpecs$okhttp", "(Ljava/util/List;)V", "getProtocols$okhttp", "setProtocols$okhttp", "Ljavax/net/ssl/HostnameVerifier;", "getHostnameVerifier$okhttp", "()Ljavax/net/ssl/HostnameVerifier;", "setHostnameVerifier$okhttp", "(Ljavax/net/ssl/HostnameVerifier;)V", "Lokhttp3/CertificatePinner;", "getCertificatePinner$okhttp", "()Lokhttp3/CertificatePinner;", "setCertificatePinner$okhttp", "(Lokhttp3/CertificatePinner;)V", "Lu5/c;", "certificateChainCleaner", "Lu5/c;", "getCertificateChainCleaner$okhttp", "()Lu5/c;", "setCertificateChainCleaner$okhttp", "(Lu5/c;)V", "", "I", "getCallTimeout$okhttp", "()I", "setCallTimeout$okhttp", "(I)V", "getConnectTimeout$okhttp", "setConnectTimeout$okhttp", "getReadTimeout$okhttp", "setReadTimeout$okhttp", "getWriteTimeout$okhttp", "setWriteTimeout$okhttp", "getPingInterval$okhttp", "setPingInterval$okhttp", "J", "getMinWebSocketMessageToCompress$okhttp", "()J", "setMinWebSocketMessageToCompress$okhttp", "(J)V", "Lokhttp3/internal/connection/i;", "routeDatabase", "Lokhttp3/internal/connection/i;", "getRouteDatabase$okhttp", "()Lokhttp3/internal/connection/i;", "setRouteDatabase$okhttp", "(Lokhttp3/internal/connection/i;)V", "<init>", "()V", "okHttpClient", "(Lokhttp3/OkHttpClient;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Builder {

        @d
        private Authenticator authenticator;

        @e
        private Cache cache;
        private int callTimeout;

        @e
        private c certificateChainCleaner;

        @d
        private CertificatePinner certificatePinner;
        private int connectTimeout;

        @d
        private ConnectionPool connectionPool;

        @d
        private List<ConnectionSpec> connectionSpecs;

        @d
        private CookieJar cookieJar;

        @d
        private Dispatcher dispatcher;

        @d
        private Dns dns;

        @d
        private EventListener.Factory eventListenerFactory;
        private boolean followRedirects;
        private boolean followSslRedirects;

        @d
        private HostnameVerifier hostnameVerifier;

        @d
        private final List<Interceptor> interceptors;
        private long minWebSocketMessageToCompress;

        @d
        private final List<Interceptor> networkInterceptors;
        private int pingInterval;

        @d
        private List<? extends Protocol> protocols;

        @e
        private Proxy proxy;

        @d
        private Authenticator proxyAuthenticator;

        @e
        private ProxySelector proxySelector;
        private int readTimeout;
        private boolean retryOnConnectionFailure;

        @e
        private i routeDatabase;

        @d
        private SocketFactory socketFactory;

        @e
        private SSLSocketFactory sslSocketFactoryOrNull;
        private int writeTimeout;

        @e
        private X509TrustManager x509TrustManagerOrNull;

        public Builder() {
            this.dispatcher = new Dispatcher();
            this.connectionPool = new ConnectionPool();
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.eventListenerFactory = okhttp3.internal.d.e(EventListener.NONE);
            this.retryOnConnectionFailure = true;
            Authenticator authenticator = Authenticator.NONE;
            this.authenticator = authenticator;
            this.followRedirects = true;
            this.followSslRedirects = true;
            this.cookieJar = CookieJar.NO_COOKIES;
            this.dns = Dns.SYSTEM;
            this.proxyAuthenticator = authenticator;
            SocketFactory socketFactory = SocketFactory.getDefault();
            l0.o(socketFactory, "SocketFactory.getDefault()");
            this.socketFactory = socketFactory;
            Companion companion = OkHttpClient.Companion;
            this.connectionSpecs = companion.getDEFAULT_CONNECTION_SPECS$okhttp();
            this.protocols = companion.getDEFAULT_PROTOCOLS$okhttp();
            this.hostnameVerifier = u5.d.f40420c;
            this.certificatePinner = CertificatePinner.DEFAULT;
            this.connectTimeout = h.f27948e;
            this.readTimeout = h.f27948e;
            this.writeTimeout = h.f27948e;
            this.minWebSocketMessageToCompress = 1024L;
        }

        @d
        @h5.h(name = "-addInterceptor")
        /* JADX INFO: renamed from: -addInterceptor, reason: not valid java name */
        public final Builder m112addInterceptor(@d final l<? super Interceptor.Chain, Response> block) {
            l0.p(block, "block");
            return addInterceptor(new Interceptor() { // from class: okhttp3.OkHttpClient$Builder$addInterceptor$2
                @Override // okhttp3.Interceptor
                @d
                public final Response intercept(@d Interceptor.Chain chain) {
                    l0.p(chain, "chain");
                    return (Response) block.z(chain);
                }
            });
        }

        @d
        @h5.h(name = "-addNetworkInterceptor")
        /* JADX INFO: renamed from: -addNetworkInterceptor, reason: not valid java name */
        public final Builder m113addNetworkInterceptor(@d final l<? super Interceptor.Chain, Response> block) {
            l0.p(block, "block");
            return addNetworkInterceptor(new Interceptor() { // from class: okhttp3.OkHttpClient$Builder$addNetworkInterceptor$2
                @Override // okhttp3.Interceptor
                @d
                public final Response intercept(@d Interceptor.Chain chain) {
                    l0.p(chain, "chain");
                    return (Response) block.z(chain);
                }
            });
        }

        @d
        public final Builder addInterceptor(@d Interceptor interceptor) {
            l0.p(interceptor, "interceptor");
            this.interceptors.add(interceptor);
            return this;
        }

        @d
        public final Builder addNetworkInterceptor(@d Interceptor interceptor) {
            l0.p(interceptor, "interceptor");
            this.networkInterceptors.add(interceptor);
            return this;
        }

        @d
        public final Builder authenticator(@d Authenticator authenticator) {
            l0.p(authenticator, "authenticator");
            this.authenticator = authenticator;
            return this;
        }

        @d
        public final OkHttpClient build() {
            return new OkHttpClient(this);
        }

        @d
        public final Builder cache(@e Cache cache) {
            this.cache = cache;
            return this;
        }

        @d
        public final Builder callTimeout(long j7, @d TimeUnit unit) {
            l0.p(unit, "unit");
            this.callTimeout = okhttp3.internal.d.j(com.alipay.sdk.data.a.f13674p, j7, unit);
            return this;
        }

        @d
        public final Builder certificatePinner(@d CertificatePinner certificatePinner) {
            l0.p(certificatePinner, "certificatePinner");
            if (!l0.g(certificatePinner, this.certificatePinner)) {
                this.routeDatabase = null;
            }
            this.certificatePinner = certificatePinner;
            return this;
        }

        @d
        public final Builder connectTimeout(long j7, @d TimeUnit unit) {
            l0.p(unit, "unit");
            this.connectTimeout = okhttp3.internal.d.j(com.alipay.sdk.data.a.f13674p, j7, unit);
            return this;
        }

        @d
        public final Builder connectionPool(@d ConnectionPool connectionPool) {
            l0.p(connectionPool, "connectionPool");
            this.connectionPool = connectionPool;
            return this;
        }

        @d
        public final Builder connectionSpecs(@d List<ConnectionSpec> connectionSpecs) {
            l0.p(connectionSpecs, "connectionSpecs");
            if (!l0.g(connectionSpecs, this.connectionSpecs)) {
                this.routeDatabase = null;
            }
            this.connectionSpecs = okhttp3.internal.d.c0(connectionSpecs);
            return this;
        }

        @d
        public final Builder cookieJar(@d CookieJar cookieJar) {
            l0.p(cookieJar, "cookieJar");
            this.cookieJar = cookieJar;
            return this;
        }

        @d
        public final Builder dispatcher(@d Dispatcher dispatcher) {
            l0.p(dispatcher, "dispatcher");
            this.dispatcher = dispatcher;
            return this;
        }

        @d
        public final Builder dns(@d Dns dns) {
            l0.p(dns, "dns");
            if (!l0.g(dns, this.dns)) {
                this.routeDatabase = null;
            }
            this.dns = dns;
            return this;
        }

        @d
        public final Builder eventListener(@d EventListener eventListener) {
            l0.p(eventListener, "eventListener");
            this.eventListenerFactory = okhttp3.internal.d.e(eventListener);
            return this;
        }

        @d
        public final Builder eventListenerFactory(@d EventListener.Factory eventListenerFactory) {
            l0.p(eventListenerFactory, "eventListenerFactory");
            this.eventListenerFactory = eventListenerFactory;
            return this;
        }

        @d
        public final Builder followRedirects(boolean z7) {
            this.followRedirects = z7;
            return this;
        }

        @d
        public final Builder followSslRedirects(boolean z7) {
            this.followSslRedirects = z7;
            return this;
        }

        @d
        public final Authenticator getAuthenticator$okhttp() {
            return this.authenticator;
        }

        @e
        public final Cache getCache$okhttp() {
            return this.cache;
        }

        public final int getCallTimeout$okhttp() {
            return this.callTimeout;
        }

        @e
        public final c getCertificateChainCleaner$okhttp() {
            return this.certificateChainCleaner;
        }

        @d
        public final CertificatePinner getCertificatePinner$okhttp() {
            return this.certificatePinner;
        }

        public final int getConnectTimeout$okhttp() {
            return this.connectTimeout;
        }

        @d
        public final ConnectionPool getConnectionPool$okhttp() {
            return this.connectionPool;
        }

        @d
        public final List<ConnectionSpec> getConnectionSpecs$okhttp() {
            return this.connectionSpecs;
        }

        @d
        public final CookieJar getCookieJar$okhttp() {
            return this.cookieJar;
        }

        @d
        public final Dispatcher getDispatcher$okhttp() {
            return this.dispatcher;
        }

        @d
        public final Dns getDns$okhttp() {
            return this.dns;
        }

        @d
        public final EventListener.Factory getEventListenerFactory$okhttp() {
            return this.eventListenerFactory;
        }

        public final boolean getFollowRedirects$okhttp() {
            return this.followRedirects;
        }

        public final boolean getFollowSslRedirects$okhttp() {
            return this.followSslRedirects;
        }

        @d
        public final HostnameVerifier getHostnameVerifier$okhttp() {
            return this.hostnameVerifier;
        }

        @d
        public final List<Interceptor> getInterceptors$okhttp() {
            return this.interceptors;
        }

        public final long getMinWebSocketMessageToCompress$okhttp() {
            return this.minWebSocketMessageToCompress;
        }

        @d
        public final List<Interceptor> getNetworkInterceptors$okhttp() {
            return this.networkInterceptors;
        }

        public final int getPingInterval$okhttp() {
            return this.pingInterval;
        }

        @d
        public final List<Protocol> getProtocols$okhttp() {
            return this.protocols;
        }

        @e
        public final Proxy getProxy$okhttp() {
            return this.proxy;
        }

        @d
        public final Authenticator getProxyAuthenticator$okhttp() {
            return this.proxyAuthenticator;
        }

        @e
        public final ProxySelector getProxySelector$okhttp() {
            return this.proxySelector;
        }

        public final int getReadTimeout$okhttp() {
            return this.readTimeout;
        }

        public final boolean getRetryOnConnectionFailure$okhttp() {
            return this.retryOnConnectionFailure;
        }

        @e
        public final i getRouteDatabase$okhttp() {
            return this.routeDatabase;
        }

        @d
        public final SocketFactory getSocketFactory$okhttp() {
            return this.socketFactory;
        }

        @e
        public final SSLSocketFactory getSslSocketFactoryOrNull$okhttp() {
            return this.sslSocketFactoryOrNull;
        }

        public final int getWriteTimeout$okhttp() {
            return this.writeTimeout;
        }

        @e
        public final X509TrustManager getX509TrustManagerOrNull$okhttp() {
            return this.x509TrustManagerOrNull;
        }

        @d
        public final Builder hostnameVerifier(@d HostnameVerifier hostnameVerifier) {
            l0.p(hostnameVerifier, "hostnameVerifier");
            if (!l0.g(hostnameVerifier, this.hostnameVerifier)) {
                this.routeDatabase = null;
            }
            this.hostnameVerifier = hostnameVerifier;
            return this;
        }

        @d
        public final List<Interceptor> interceptors() {
            return this.interceptors;
        }

        @d
        public final Builder minWebSocketMessageToCompress(long j7) {
            if (j7 >= 0) {
                this.minWebSocketMessageToCompress = j7;
                return this;
            }
            throw new IllegalArgumentException(("minWebSocketMessageToCompress must be positive: " + j7).toString());
        }

        @d
        public final List<Interceptor> networkInterceptors() {
            return this.networkInterceptors;
        }

        @d
        public final Builder pingInterval(long j7, @d TimeUnit unit) {
            l0.p(unit, "unit");
            this.pingInterval = okhttp3.internal.d.j("interval", j7, unit);
            return this;
        }

        @d
        public final Builder protocols(@d List<? extends Protocol> protocols) {
            l0.p(protocols, "protocols");
            List listT5 = g0.T5(protocols);
            Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            if (!(listT5.contains(protocol) || listT5.contains(Protocol.HTTP_1_1))) {
                throw new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + listT5).toString());
            }
            if (!(!listT5.contains(protocol) || listT5.size() <= 1)) {
                throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + listT5).toString());
            }
            if (!(!listT5.contains(Protocol.HTTP_1_0))) {
                throw new IllegalArgumentException(("protocols must not contain http/1.0: " + listT5).toString());
            }
            if (!(!listT5.contains(null))) {
                throw new IllegalArgumentException("protocols must not contain null".toString());
            }
            listT5.remove(Protocol.SPDY_3);
            if (!l0.g(listT5, this.protocols)) {
                this.routeDatabase = null;
            }
            List<? extends Protocol> listUnmodifiableList = Collections.unmodifiableList(listT5);
            l0.o(listUnmodifiableList, "Collections.unmodifiableList(protocolsCopy)");
            this.protocols = listUnmodifiableList;
            return this;
        }

        @d
        public final Builder proxy(@e Proxy proxy) {
            if (!l0.g(proxy, this.proxy)) {
                this.routeDatabase = null;
            }
            this.proxy = proxy;
            return this;
        }

        @d
        public final Builder proxyAuthenticator(@d Authenticator proxyAuthenticator) {
            l0.p(proxyAuthenticator, "proxyAuthenticator");
            if (!l0.g(proxyAuthenticator, this.proxyAuthenticator)) {
                this.routeDatabase = null;
            }
            this.proxyAuthenticator = proxyAuthenticator;
            return this;
        }

        @d
        public final Builder proxySelector(@d ProxySelector proxySelector) {
            l0.p(proxySelector, "proxySelector");
            if (!l0.g(proxySelector, this.proxySelector)) {
                this.routeDatabase = null;
            }
            this.proxySelector = proxySelector;
            return this;
        }

        @d
        public final Builder readTimeout(long j7, @d TimeUnit unit) {
            l0.p(unit, "unit");
            this.readTimeout = okhttp3.internal.d.j(com.alipay.sdk.data.a.f13674p, j7, unit);
            return this;
        }

        @d
        public final Builder retryOnConnectionFailure(boolean z7) {
            this.retryOnConnectionFailure = z7;
            return this;
        }

        public final void setAuthenticator$okhttp(@d Authenticator authenticator) {
            l0.p(authenticator, "<set-?>");
            this.authenticator = authenticator;
        }

        public final void setCache$okhttp(@e Cache cache) {
            this.cache = cache;
        }

        public final void setCallTimeout$okhttp(int i7) {
            this.callTimeout = i7;
        }

        public final void setCertificateChainCleaner$okhttp(@e c cVar) {
            this.certificateChainCleaner = cVar;
        }

        public final void setCertificatePinner$okhttp(@d CertificatePinner certificatePinner) {
            l0.p(certificatePinner, "<set-?>");
            this.certificatePinner = certificatePinner;
        }

        public final void setConnectTimeout$okhttp(int i7) {
            this.connectTimeout = i7;
        }

        public final void setConnectionPool$okhttp(@d ConnectionPool connectionPool) {
            l0.p(connectionPool, "<set-?>");
            this.connectionPool = connectionPool;
        }

        public final void setConnectionSpecs$okhttp(@d List<ConnectionSpec> list) {
            l0.p(list, "<set-?>");
            this.connectionSpecs = list;
        }

        public final void setCookieJar$okhttp(@d CookieJar cookieJar) {
            l0.p(cookieJar, "<set-?>");
            this.cookieJar = cookieJar;
        }

        public final void setDispatcher$okhttp(@d Dispatcher dispatcher) {
            l0.p(dispatcher, "<set-?>");
            this.dispatcher = dispatcher;
        }

        public final void setDns$okhttp(@d Dns dns) {
            l0.p(dns, "<set-?>");
            this.dns = dns;
        }

        public final void setEventListenerFactory$okhttp(@d EventListener.Factory factory) {
            l0.p(factory, "<set-?>");
            this.eventListenerFactory = factory;
        }

        public final void setFollowRedirects$okhttp(boolean z7) {
            this.followRedirects = z7;
        }

        public final void setFollowSslRedirects$okhttp(boolean z7) {
            this.followSslRedirects = z7;
        }

        public final void setHostnameVerifier$okhttp(@d HostnameVerifier hostnameVerifier) {
            l0.p(hostnameVerifier, "<set-?>");
            this.hostnameVerifier = hostnameVerifier;
        }

        public final void setMinWebSocketMessageToCompress$okhttp(long j7) {
            this.minWebSocketMessageToCompress = j7;
        }

        public final void setPingInterval$okhttp(int i7) {
            this.pingInterval = i7;
        }

        public final void setProtocols$okhttp(@d List<? extends Protocol> list) {
            l0.p(list, "<set-?>");
            this.protocols = list;
        }

        public final void setProxy$okhttp(@e Proxy proxy) {
            this.proxy = proxy;
        }

        public final void setProxyAuthenticator$okhttp(@d Authenticator authenticator) {
            l0.p(authenticator, "<set-?>");
            this.proxyAuthenticator = authenticator;
        }

        public final void setProxySelector$okhttp(@e ProxySelector proxySelector) {
            this.proxySelector = proxySelector;
        }

        public final void setReadTimeout$okhttp(int i7) {
            this.readTimeout = i7;
        }

        public final void setRetryOnConnectionFailure$okhttp(boolean z7) {
            this.retryOnConnectionFailure = z7;
        }

        public final void setRouteDatabase$okhttp(@e i iVar) {
            this.routeDatabase = iVar;
        }

        public final void setSocketFactory$okhttp(@d SocketFactory socketFactory) {
            l0.p(socketFactory, "<set-?>");
            this.socketFactory = socketFactory;
        }

        public final void setSslSocketFactoryOrNull$okhttp(@e SSLSocketFactory sSLSocketFactory) {
            this.sslSocketFactoryOrNull = sSLSocketFactory;
        }

        public final void setWriteTimeout$okhttp(int i7) {
            this.writeTimeout = i7;
        }

        public final void setX509TrustManagerOrNull$okhttp(@e X509TrustManager x509TrustManager) {
            this.x509TrustManagerOrNull = x509TrustManager;
        }

        @d
        public final Builder socketFactory(@d SocketFactory socketFactory) {
            l0.p(socketFactory, "socketFactory");
            if (!(!(socketFactory instanceof SSLSocketFactory))) {
                throw new IllegalArgumentException("socketFactory instanceof SSLSocketFactory".toString());
            }
            if (!l0.g(socketFactory, this.socketFactory)) {
                this.routeDatabase = null;
            }
            this.socketFactory = socketFactory;
            return this;
        }

        @d
        @k(level = m.ERROR, message = "Use the sslSocketFactory overload that accepts a X509TrustManager.")
        public final Builder sslSocketFactory(@d SSLSocketFactory sslSocketFactory) {
            l0.p(sslSocketFactory, "sslSocketFactory");
            if (!l0.g(sslSocketFactory, this.sslSocketFactoryOrNull)) {
                this.routeDatabase = null;
            }
            this.sslSocketFactoryOrNull = sslSocketFactory;
            okhttp3.internal.platform.k.a aVar = okhttp3.internal.platform.k.f38284e;
            X509TrustManager x509TrustManagerS = aVar.g().s(sslSocketFactory);
            if (x509TrustManagerS != null) {
                this.x509TrustManagerOrNull = x509TrustManagerS;
                okhttp3.internal.platform.k kVarG = aVar.g();
                X509TrustManager x509TrustManager = this.x509TrustManagerOrNull;
                l0.m(x509TrustManager);
                this.certificateChainCleaner = kVarG.d(x509TrustManager);
                return this;
            }
            throw new IllegalStateException("Unable to extract the trust manager on " + aVar.g() + ", sslSocketFactory is " + sslSocketFactory.getClass());
        }

        @d
        public final Builder writeTimeout(long j7, @d TimeUnit unit) {
            l0.p(unit, "unit");
            this.writeTimeout = okhttp3.internal.d.j(com.alipay.sdk.data.a.f13674p, j7, unit);
            return this;
        }

        @d
        @z6.a
        public final Builder callTimeout(@d Duration duration) {
            l0.p(duration, "duration");
            callTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @d
        @z6.a
        public final Builder connectTimeout(@d Duration duration) {
            l0.p(duration, "duration");
            connectTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @d
        @z6.a
        public final Builder pingInterval(@d Duration duration) {
            l0.p(duration, "duration");
            pingInterval(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @d
        @z6.a
        public final Builder readTimeout(@d Duration duration) {
            l0.p(duration, "duration");
            readTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @d
        @z6.a
        public final Builder writeTimeout(@d Duration duration) {
            l0.p(duration, "duration");
            writeTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @d
        public final Builder sslSocketFactory(@d SSLSocketFactory sslSocketFactory, @d X509TrustManager trustManager) {
            l0.p(sslSocketFactory, "sslSocketFactory");
            l0.p(trustManager, "trustManager");
            if ((!l0.g(sslSocketFactory, this.sslSocketFactoryOrNull)) || (!l0.g(trustManager, this.x509TrustManagerOrNull))) {
                this.routeDatabase = null;
            }
            this.sslSocketFactoryOrNull = sslSocketFactory;
            this.certificateChainCleaner = c.f40417a.a(trustManager);
            this.x509TrustManagerOrNull = trustManager;
            return this;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(@d OkHttpClient okHttpClient) {
            this();
            l0.p(okHttpClient, "okHttpClient");
            this.dispatcher = okHttpClient.dispatcher();
            this.connectionPool = okHttpClient.connectionPool();
            d0.o0(this.interceptors, okHttpClient.interceptors());
            d0.o0(this.networkInterceptors, okHttpClient.networkInterceptors());
            this.eventListenerFactory = okHttpClient.eventListenerFactory();
            this.retryOnConnectionFailure = okHttpClient.retryOnConnectionFailure();
            this.authenticator = okHttpClient.authenticator();
            this.followRedirects = okHttpClient.followRedirects();
            this.followSslRedirects = okHttpClient.followSslRedirects();
            this.cookieJar = okHttpClient.cookieJar();
            this.cache = okHttpClient.cache();
            this.dns = okHttpClient.dns();
            this.proxy = okHttpClient.proxy();
            this.proxySelector = okHttpClient.proxySelector();
            this.proxyAuthenticator = okHttpClient.proxyAuthenticator();
            this.socketFactory = okHttpClient.socketFactory();
            this.sslSocketFactoryOrNull = okHttpClient.sslSocketFactoryOrNull;
            this.x509TrustManagerOrNull = okHttpClient.x509TrustManager();
            this.connectionSpecs = okHttpClient.connectionSpecs();
            this.protocols = okHttpClient.protocols();
            this.hostnameVerifier = okHttpClient.hostnameVerifier();
            this.certificatePinner = okHttpClient.certificatePinner();
            this.certificateChainCleaner = okHttpClient.certificateChainCleaner();
            this.callTimeout = okHttpClient.callTimeoutMillis();
            this.connectTimeout = okHttpClient.connectTimeoutMillis();
            this.readTimeout = okHttpClient.readTimeoutMillis();
            this.writeTimeout = okHttpClient.writeTimeoutMillis();
            this.pingInterval = okHttpClient.pingIntervalMillis();
            this.minWebSocketMessageToCompress = okHttpClient.minWebSocketMessageToCompress();
            this.routeDatabase = okHttpClient.getRouteDatabase();
        }
    }

    @i0(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Lokhttp3/OkHttpClient$Companion;", "", "()V", "DEFAULT_CONNECTION_SPECS", "", "Lokhttp3/ConnectionSpec;", "getDEFAULT_CONNECTION_SPECS$okhttp", "()Ljava/util/List;", "DEFAULT_PROTOCOLS", "Lokhttp3/Protocol;", "getDEFAULT_PROTOCOLS$okhttp", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        @d
        public final List<ConnectionSpec> getDEFAULT_CONNECTION_SPECS$okhttp() {
            return OkHttpClient.DEFAULT_CONNECTION_SPECS;
        }

        @d
        public final List<Protocol> getDEFAULT_PROTOCOLS$okhttp() {
            return OkHttpClient.DEFAULT_PROTOCOLS;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.w wVar) {
            this();
        }
    }

    public OkHttpClient(@d Builder builder) {
        ProxySelector proxySelector$okhttp;
        l0.p(builder, "builder");
        this.dispatcher = builder.getDispatcher$okhttp();
        this.connectionPool = builder.getConnectionPool$okhttp();
        this.interceptors = okhttp3.internal.d.c0(builder.getInterceptors$okhttp());
        this.networkInterceptors = okhttp3.internal.d.c0(builder.getNetworkInterceptors$okhttp());
        this.eventListenerFactory = builder.getEventListenerFactory$okhttp();
        this.retryOnConnectionFailure = builder.getRetryOnConnectionFailure$okhttp();
        this.authenticator = builder.getAuthenticator$okhttp();
        this.followRedirects = builder.getFollowRedirects$okhttp();
        this.followSslRedirects = builder.getFollowSslRedirects$okhttp();
        this.cookieJar = builder.getCookieJar$okhttp();
        this.cache = builder.getCache$okhttp();
        this.dns = builder.getDns$okhttp();
        this.proxy = builder.getProxy$okhttp();
        if (builder.getProxy$okhttp() != null) {
            proxySelector$okhttp = t5.a.f40386a;
        } else {
            proxySelector$okhttp = builder.getProxySelector$okhttp();
            proxySelector$okhttp = proxySelector$okhttp == null ? ProxySelector.getDefault() : proxySelector$okhttp;
            if (proxySelector$okhttp == null) {
                proxySelector$okhttp = t5.a.f40386a;
            }
        }
        this.proxySelector = proxySelector$okhttp;
        this.proxyAuthenticator = builder.getProxyAuthenticator$okhttp();
        this.socketFactory = builder.getSocketFactory$okhttp();
        List<ConnectionSpec> connectionSpecs$okhttp = builder.getConnectionSpecs$okhttp();
        this.connectionSpecs = connectionSpecs$okhttp;
        this.protocols = builder.getProtocols$okhttp();
        this.hostnameVerifier = builder.getHostnameVerifier$okhttp();
        this.callTimeoutMillis = builder.getCallTimeout$okhttp();
        this.connectTimeoutMillis = builder.getConnectTimeout$okhttp();
        this.readTimeoutMillis = builder.getReadTimeout$okhttp();
        this.writeTimeoutMillis = builder.getWriteTimeout$okhttp();
        this.pingIntervalMillis = builder.getPingInterval$okhttp();
        this.minWebSocketMessageToCompress = builder.getMinWebSocketMessageToCompress$okhttp();
        i routeDatabase$okhttp = builder.getRouteDatabase$okhttp();
        this.routeDatabase = routeDatabase$okhttp == null ? new i() : routeDatabase$okhttp;
        boolean z7 = true;
        if (!(connectionSpecs$okhttp instanceof Collection) || !connectionSpecs$okhttp.isEmpty()) {
            Iterator<T> it = connectionSpecs$okhttp.iterator();
            while (it.hasNext()) {
                if (((ConnectionSpec) it.next()).isTls()) {
                    z7 = false;
                    break;
                }
            }
        }
        if (z7) {
            this.sslSocketFactoryOrNull = null;
            this.certificateChainCleaner = null;
            this.x509TrustManager = null;
            this.certificatePinner = CertificatePinner.DEFAULT;
        } else if (builder.getSslSocketFactoryOrNull$okhttp() != null) {
            this.sslSocketFactoryOrNull = builder.getSslSocketFactoryOrNull$okhttp();
            c certificateChainCleaner$okhttp = builder.getCertificateChainCleaner$okhttp();
            l0.m(certificateChainCleaner$okhttp);
            this.certificateChainCleaner = certificateChainCleaner$okhttp;
            X509TrustManager x509TrustManagerOrNull$okhttp = builder.getX509TrustManagerOrNull$okhttp();
            l0.m(x509TrustManagerOrNull$okhttp);
            this.x509TrustManager = x509TrustManagerOrNull$okhttp;
            CertificatePinner certificatePinner$okhttp = builder.getCertificatePinner$okhttp();
            l0.m(certificateChainCleaner$okhttp);
            this.certificatePinner = certificatePinner$okhttp.withCertificateChainCleaner$okhttp(certificateChainCleaner$okhttp);
        } else {
            okhttp3.internal.platform.k.a aVar = okhttp3.internal.platform.k.f38284e;
            X509TrustManager x509TrustManagerR = aVar.g().r();
            this.x509TrustManager = x509TrustManagerR;
            okhttp3.internal.platform.k kVarG = aVar.g();
            l0.m(x509TrustManagerR);
            this.sslSocketFactoryOrNull = kVarG.q(x509TrustManagerR);
            c.a aVar2 = c.f40417a;
            l0.m(x509TrustManagerR);
            c cVarA = aVar2.a(x509TrustManagerR);
            this.certificateChainCleaner = cVarA;
            CertificatePinner certificatePinner$okhttp2 = builder.getCertificatePinner$okhttp();
            l0.m(cVarA);
            this.certificatePinner = certificatePinner$okhttp2.withCertificateChainCleaner$okhttp(cVarA);
        }
        verifyClientState();
    }

    private final void verifyClientState() {
        boolean z7;
        List<Interceptor> list = this.interceptors;
        if (list == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        }
        if (!(!list.contains(null))) {
            throw new IllegalStateException(("Null interceptor: " + this.interceptors).toString());
        }
        List<Interceptor> list2 = this.networkInterceptors;
        if (list2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        }
        if (!(!list2.contains(null))) {
            throw new IllegalStateException(("Null network interceptor: " + this.networkInterceptors).toString());
        }
        List<ConnectionSpec> list3 = this.connectionSpecs;
        if (!(list3 instanceof Collection) || !list3.isEmpty()) {
            Iterator<T> it = list3.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z7 = true;
                    break;
                } else if (((ConnectionSpec) it.next()).isTls()) {
                    z7 = false;
                    break;
                }
            }
        } else {
            z7 = true;
            break;
        }
        if (!z7) {
            if (this.sslSocketFactoryOrNull == null) {
                throw new IllegalStateException("sslSocketFactory == null".toString());
            }
            if (this.certificateChainCleaner == null) {
                throw new IllegalStateException("certificateChainCleaner == null".toString());
            }
            if (this.x509TrustManager == null) {
                throw new IllegalStateException("x509TrustManager == null".toString());
            }
            return;
        }
        if (!(this.sslSocketFactoryOrNull == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(this.certificateChainCleaner == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(this.x509TrustManager == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!l0.g(this.certificatePinner, CertificatePinner.DEFAULT)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "authenticator", imports = {}))
    @h5.h(name = "-deprecated_authenticator")
    /* JADX INFO: renamed from: -deprecated_authenticator, reason: not valid java name */
    public final Authenticator m86deprecated_authenticator() {
        return this.authenticator;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "cache", imports = {}))
    @e
    @h5.h(name = "-deprecated_cache")
    /* JADX INFO: renamed from: -deprecated_cache, reason: not valid java name */
    public final Cache m87deprecated_cache() {
        return this.cache;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "callTimeoutMillis", imports = {}))
    @h5.h(name = "-deprecated_callTimeoutMillis")
    /* JADX INFO: renamed from: -deprecated_callTimeoutMillis, reason: not valid java name */
    public final int m88deprecated_callTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "certificatePinner", imports = {}))
    @h5.h(name = "-deprecated_certificatePinner")
    /* JADX INFO: renamed from: -deprecated_certificatePinner, reason: not valid java name */
    public final CertificatePinner m89deprecated_certificatePinner() {
        return this.certificatePinner;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "connectTimeoutMillis", imports = {}))
    @h5.h(name = "-deprecated_connectTimeoutMillis")
    /* JADX INFO: renamed from: -deprecated_connectTimeoutMillis, reason: not valid java name */
    public final int m90deprecated_connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "connectionPool", imports = {}))
    @h5.h(name = "-deprecated_connectionPool")
    /* JADX INFO: renamed from: -deprecated_connectionPool, reason: not valid java name */
    public final ConnectionPool m91deprecated_connectionPool() {
        return this.connectionPool;
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "connectionSpecs", imports = {}))
    @h5.h(name = "-deprecated_connectionSpecs")
    /* JADX INFO: renamed from: -deprecated_connectionSpecs, reason: not valid java name */
    public final List<ConnectionSpec> m92deprecated_connectionSpecs() {
        return this.connectionSpecs;
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "cookieJar", imports = {}))
    @h5.h(name = "-deprecated_cookieJar")
    /* JADX INFO: renamed from: -deprecated_cookieJar, reason: not valid java name */
    public final CookieJar m93deprecated_cookieJar() {
        return this.cookieJar;
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "dispatcher", imports = {}))
    @h5.h(name = "-deprecated_dispatcher")
    /* JADX INFO: renamed from: -deprecated_dispatcher, reason: not valid java name */
    public final Dispatcher m94deprecated_dispatcher() {
        return this.dispatcher;
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = com.haier.uhome.trace.b.b.f30245b, imports = {}))
    @h5.h(name = "-deprecated_dns")
    /* JADX INFO: renamed from: -deprecated_dns, reason: not valid java name */
    public final Dns m95deprecated_dns() {
        return this.dns;
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "eventListenerFactory", imports = {}))
    @h5.h(name = "-deprecated_eventListenerFactory")
    /* JADX INFO: renamed from: -deprecated_eventListenerFactory, reason: not valid java name */
    public final EventListener.Factory m96deprecated_eventListenerFactory() {
        return this.eventListenerFactory;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "followRedirects", imports = {}))
    @h5.h(name = "-deprecated_followRedirects")
    /* JADX INFO: renamed from: -deprecated_followRedirects, reason: not valid java name */
    public final boolean m97deprecated_followRedirects() {
        return this.followRedirects;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "followSslRedirects", imports = {}))
    @h5.h(name = "-deprecated_followSslRedirects")
    /* JADX INFO: renamed from: -deprecated_followSslRedirects, reason: not valid java name */
    public final boolean m98deprecated_followSslRedirects() {
        return this.followSslRedirects;
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "hostnameVerifier", imports = {}))
    @h5.h(name = "-deprecated_hostnameVerifier")
    /* JADX INFO: renamed from: -deprecated_hostnameVerifier, reason: not valid java name */
    public final HostnameVerifier m99deprecated_hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "interceptors", imports = {}))
    @h5.h(name = "-deprecated_interceptors")
    /* JADX INFO: renamed from: -deprecated_interceptors, reason: not valid java name */
    public final List<Interceptor> m100deprecated_interceptors() {
        return this.interceptors;
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "networkInterceptors", imports = {}))
    @h5.h(name = "-deprecated_networkInterceptors")
    /* JADX INFO: renamed from: -deprecated_networkInterceptors, reason: not valid java name */
    public final List<Interceptor> m101deprecated_networkInterceptors() {
        return this.networkInterceptors;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "pingIntervalMillis", imports = {}))
    @h5.h(name = "-deprecated_pingIntervalMillis")
    /* JADX INFO: renamed from: -deprecated_pingIntervalMillis, reason: not valid java name */
    public final int m102deprecated_pingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "protocols", imports = {}))
    @h5.h(name = "-deprecated_protocols")
    /* JADX INFO: renamed from: -deprecated_protocols, reason: not valid java name */
    public final List<Protocol> m103deprecated_protocols() {
        return this.protocols;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "proxy", imports = {}))
    @e
    @h5.h(name = "-deprecated_proxy")
    /* JADX INFO: renamed from: -deprecated_proxy, reason: not valid java name */
    public final Proxy m104deprecated_proxy() {
        return this.proxy;
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "proxyAuthenticator", imports = {}))
    @h5.h(name = "-deprecated_proxyAuthenticator")
    /* JADX INFO: renamed from: -deprecated_proxyAuthenticator, reason: not valid java name */
    public final Authenticator m105deprecated_proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "proxySelector", imports = {}))
    @h5.h(name = "-deprecated_proxySelector")
    /* JADX INFO: renamed from: -deprecated_proxySelector, reason: not valid java name */
    public final ProxySelector m106deprecated_proxySelector() {
        return this.proxySelector;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "readTimeoutMillis", imports = {}))
    @h5.h(name = "-deprecated_readTimeoutMillis")
    /* JADX INFO: renamed from: -deprecated_readTimeoutMillis, reason: not valid java name */
    public final int m107deprecated_readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "retryOnConnectionFailure", imports = {}))
    @h5.h(name = "-deprecated_retryOnConnectionFailure")
    /* JADX INFO: renamed from: -deprecated_retryOnConnectionFailure, reason: not valid java name */
    public final boolean m108deprecated_retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "socketFactory", imports = {}))
    @h5.h(name = "-deprecated_socketFactory")
    /* JADX INFO: renamed from: -deprecated_socketFactory, reason: not valid java name */
    public final SocketFactory m109deprecated_socketFactory() {
        return this.socketFactory;
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "sslSocketFactory", imports = {}))
    @h5.h(name = "-deprecated_sslSocketFactory")
    /* JADX INFO: renamed from: -deprecated_sslSocketFactory, reason: not valid java name */
    public final SSLSocketFactory m110deprecated_sslSocketFactory() {
        return sslSocketFactory();
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "writeTimeoutMillis", imports = {}))
    @h5.h(name = "-deprecated_writeTimeoutMillis")
    /* JADX INFO: renamed from: -deprecated_writeTimeoutMillis, reason: not valid java name */
    public final int m111deprecated_writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    @d
    @h5.h(name = "authenticator")
    public final Authenticator authenticator() {
        return this.authenticator;
    }

    @e
    @h5.h(name = "cache")
    public final Cache cache() {
        return this.cache;
    }

    @h5.h(name = "callTimeoutMillis")
    public final int callTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    @e
    @h5.h(name = "certificateChainCleaner")
    public final c certificateChainCleaner() {
        return this.certificateChainCleaner;
    }

    @d
    @h5.h(name = "certificatePinner")
    public final CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    @d
    public Object clone() {
        return super.clone();
    }

    @h5.h(name = "connectTimeoutMillis")
    public final int connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @d
    @h5.h(name = "connectionPool")
    public final ConnectionPool connectionPool() {
        return this.connectionPool;
    }

    @d
    @h5.h(name = "connectionSpecs")
    public final List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    @d
    @h5.h(name = "cookieJar")
    public final CookieJar cookieJar() {
        return this.cookieJar;
    }

    @d
    @h5.h(name = "dispatcher")
    public final Dispatcher dispatcher() {
        return this.dispatcher;
    }

    @d
    @h5.h(name = com.haier.uhome.trace.b.b.f30245b)
    public final Dns dns() {
        return this.dns;
    }

    @d
    @h5.h(name = "eventListenerFactory")
    public final EventListener.Factory eventListenerFactory() {
        return this.eventListenerFactory;
    }

    @h5.h(name = "followRedirects")
    public final boolean followRedirects() {
        return this.followRedirects;
    }

    @h5.h(name = "followSslRedirects")
    public final boolean followSslRedirects() {
        return this.followSslRedirects;
    }

    @d
    public final i getRouteDatabase() {
        return this.routeDatabase;
    }

    @d
    @h5.h(name = "hostnameVerifier")
    public final HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @d
    @h5.h(name = "interceptors")
    public final List<Interceptor> interceptors() {
        return this.interceptors;
    }

    @h5.h(name = "minWebSocketMessageToCompress")
    public final long minWebSocketMessageToCompress() {
        return this.minWebSocketMessageToCompress;
    }

    @d
    @h5.h(name = "networkInterceptors")
    public final List<Interceptor> networkInterceptors() {
        return this.networkInterceptors;
    }

    @d
    public Builder newBuilder() {
        return new Builder(this);
    }

    @Override // okhttp3.Call.Factory
    @d
    public Call newCall(@d Request request) {
        l0.p(request, "request");
        return new okhttp3.internal.connection.e(this, request, false);
    }

    @Override // okhttp3.WebSocket.Factory
    @d
    public WebSocket newWebSocket(@d Request request, @d WebSocketListener listener) {
        l0.p(request, "request");
        l0.p(listener, "listener");
        okhttp3.internal.ws.e eVar = new okhttp3.internal.ws.e(okhttp3.internal.concurrent.d.f37734h, request, listener, new Random(), this.pingIntervalMillis, null, this.minWebSocketMessageToCompress);
        eVar.o(this);
        return eVar;
    }

    @h5.h(name = "pingIntervalMillis")
    public final int pingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    @d
    @h5.h(name = "protocols")
    public final List<Protocol> protocols() {
        return this.protocols;
    }

    @e
    @h5.h(name = "proxy")
    public final Proxy proxy() {
        return this.proxy;
    }

    @d
    @h5.h(name = "proxyAuthenticator")
    public final Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @d
    @h5.h(name = "proxySelector")
    public final ProxySelector proxySelector() {
        return this.proxySelector;
    }

    @h5.h(name = "readTimeoutMillis")
    public final int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @h5.h(name = "retryOnConnectionFailure")
    public final boolean retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    @d
    @h5.h(name = "socketFactory")
    public final SocketFactory socketFactory() {
        return this.socketFactory;
    }

    @d
    @h5.h(name = "sslSocketFactory")
    public final SSLSocketFactory sslSocketFactory() {
        SSLSocketFactory sSLSocketFactory = this.sslSocketFactoryOrNull;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory;
        }
        throw new IllegalStateException("CLEARTEXT-only client");
    }

    @h5.h(name = "writeTimeoutMillis")
    public final int writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    @e
    @h5.h(name = "x509TrustManager")
    public final X509TrustManager x509TrustManager() {
        return this.x509TrustManager;
    }

    public OkHttpClient() {
        this(new Builder());
    }
}
