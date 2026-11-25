package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import kotlin.collections.y;
import kotlin.jvm.internal.l0;
import kotlin.text.b0;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.a0;
import okio.v;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CookieJar f37867a;

    public a(@a7.d CookieJar cookieJar) {
        l0.p(cookieJar, "cookieJar");
        this.f37867a = cookieJar;
    }

    private final String a(List<Cookie> list) {
        StringBuilder sb = new StringBuilder();
        int i7 = 0;
        for (Object obj : list) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                y.X();
            }
            Cookie cookie = (Cookie) obj;
            if (i7 > 0) {
                sb.append("; ");
            }
            sb.append(cookie.name());
            sb.append('=');
            sb.append(cookie.value());
            i7 = i8;
        }
        String string = sb.toString();
        l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @Override // okhttp3.Interceptor
    @a7.d
    public Response intercept(@a7.d Interceptor.Chain chain) throws IOException {
        ResponseBody responseBodyBody;
        l0.p(chain, "chain");
        Request request = chain.request();
        Request.Builder builderNewBuilder = request.newBuilder();
        RequestBody requestBodyBody = request.body();
        if (requestBodyBody != null) {
            MediaType mediaTypeContentType = requestBodyBody.contentType();
            if (mediaTypeContentType != null) {
                builderNewBuilder.header("Content-Type", mediaTypeContentType.toString());
            }
            long jContentLength = requestBodyBody.contentLength();
            if (jContentLength != -1) {
                builderNewBuilder.header(com.google.common.net.c.f22134b, String.valueOf(jContentLength));
                builderNewBuilder.removeHeader(com.google.common.net.c.f22183z0);
            } else {
                builderNewBuilder.header(com.google.common.net.c.f22183z0, "chunked");
                builderNewBuilder.removeHeader(com.google.common.net.c.f22134b);
            }
        }
        boolean z7 = false;
        if (request.header(com.google.common.net.c.f22174v) == null) {
            builderNewBuilder.header(com.google.common.net.c.f22174v, okhttp3.internal.d.b0(request.url(), false, 1, null));
        }
        if (request.header(com.google.common.net.c.f22160o) == null) {
            builderNewBuilder.header(com.google.common.net.c.f22160o, "Keep-Alive");
        }
        if (request.header(com.google.common.net.c.f22150j) == null && request.header(com.google.common.net.c.G) == null) {
            builderNewBuilder.header(com.google.common.net.c.f22150j, "gzip");
            z7 = true;
        }
        List<Cookie> listLoadForRequest = this.f37867a.loadForRequest(request.url());
        if (!listLoadForRequest.isEmpty()) {
            builderNewBuilder.header(com.google.common.net.c.f22162p, a(listLoadForRequest));
        }
        if (request.header(com.google.common.net.c.M) == null) {
            builderNewBuilder.header(com.google.common.net.c.M, okhttp3.internal.d.f37863j);
        }
        Response responseProceed = chain.proceed(builderNewBuilder.build());
        e.g(this.f37867a, request.url(), responseProceed.headers());
        Response.Builder builderRequest = responseProceed.newBuilder().request(request);
        if (z7 && b0.K1("gzip", Response.header$default(responseProceed, com.google.common.net.c.X, null, 2, null), true) && e.c(responseProceed) && (responseBodyBody = responseProceed.body()) != null) {
            v vVar = new v(responseBodyBody.source());
            builderRequest.headers(responseProceed.headers().newBuilder().removeAll(com.google.common.net.c.X).removeAll(com.google.common.net.c.f22134b).build());
            builderRequest.body(new h(Response.header$default(responseProceed, "Content-Type", null, 2, null), -1L, a0.d(vVar)));
        }
        return builderRequest.build();
    }
}
