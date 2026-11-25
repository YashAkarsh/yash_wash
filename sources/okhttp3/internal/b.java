package okhttp3.internal;

import a7.e;
import h5.h;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.l0;
import okhttp3.Cache;
import okhttp3.ConnectionSpec;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes3.dex */
@h(name = "Internal")
public final class b {
    @a7.d
    public static final Headers.Builder a(@a7.d Headers.Builder builder, @a7.d String line) {
        l0.p(builder, "builder");
        l0.p(line, "line");
        return builder.addLenient$okhttp(line);
    }

    @a7.d
    public static final Headers.Builder b(@a7.d Headers.Builder builder, @a7.d String name, @a7.d String value) {
        l0.p(builder, "builder");
        l0.p(name, "name");
        l0.p(value, "value");
        return builder.addLenient$okhttp(name, value);
    }

    public static final void c(@a7.d ConnectionSpec connectionSpec, @a7.d SSLSocket sslSocket, boolean z7) throws CloneNotSupportedException {
        l0.p(connectionSpec, "connectionSpec");
        l0.p(sslSocket, "sslSocket");
        connectionSpec.apply$okhttp(sslSocket, z7);
    }

    @e
    public static final Response d(@a7.d Cache cache, @a7.d Request request) {
        l0.p(cache, "cache");
        l0.p(request, "request");
        return cache.get$okhttp(request);
    }

    @a7.d
    public static final String e(@a7.d Cookie cookie, boolean z7) {
        l0.p(cookie, "cookie");
        return cookie.toString$okhttp(z7);
    }

    @e
    public static final Cookie f(long j7, @a7.d HttpUrl url, @a7.d String setCookie) {
        l0.p(url, "url");
        l0.p(setCookie, "setCookie");
        return Cookie.Companion.parse$okhttp(j7, url, setCookie);
    }
}
