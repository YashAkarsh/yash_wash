package okhttp3.internal.http;

import com.haier.uhome.account.api.Const;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.collections.g0;
import kotlin.collections.y;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import kotlin.text.o;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.Route;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements Interceptor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f37893b = 20;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f37894c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OkHttpClient f37895a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(w wVar) {
            this();
        }
    }

    public j(@a7.d OkHttpClient client) {
        l0.p(client, "client");
        this.f37895a = client;
    }

    private final Request a(Response response, String str) {
        String strHeader$default;
        HttpUrl httpUrlResolve;
        if (!this.f37895a.followRedirects() || (strHeader$default = Response.header$default(response, com.google.common.net.c.f22157m0, null, 2, null)) == null || (httpUrlResolve = response.request().url().resolve(strHeader$default)) == null) {
            return null;
        }
        if (!l0.g(httpUrlResolve.scheme(), response.request().url().scheme()) && !this.f37895a.followSslRedirects()) {
            return null;
        }
        Request.Builder builderNewBuilder = response.request().newBuilder();
        if (f.b(str)) {
            int iCode = response.code();
            f fVar = f.f37879a;
            boolean z7 = fVar.d(str) || iCode == 308 || iCode == 307;
            if (!fVar.c(str) || iCode == 308 || iCode == 307) {
                builderNewBuilder.method(str, z7 ? response.request().body() : null);
            } else {
                builderNewBuilder.method(Const.HTTP_REQUEST_TYPE_GET, null);
            }
            if (!z7) {
                builderNewBuilder.removeHeader(com.google.common.net.c.f22183z0);
                builderNewBuilder.removeHeader(com.google.common.net.c.f22134b);
                builderNewBuilder.removeHeader("Content-Type");
            }
        }
        if (!okhttp3.internal.d.i(response.request().url(), httpUrlResolve)) {
            builderNewBuilder.removeHeader(com.google.common.net.c.f22158n);
        }
        return builderNewBuilder.url(httpUrlResolve).build();
    }

    private final Request b(Response response, okhttp3.internal.connection.c cVar) throws IOException {
        okhttp3.internal.connection.f fVarH;
        Route route = (cVar == null || (fVarH = cVar.h()) == null) ? null : fVarH.route();
        int iCode = response.code();
        String strMethod = response.request().method();
        if (iCode != 307 && iCode != 308) {
            if (iCode == 401) {
                return this.f37895a.authenticator().authenticate(route, response);
            }
            if (iCode == 421) {
                RequestBody requestBodyBody = response.request().body();
                if ((requestBodyBody != null && requestBodyBody.isOneShot()) || cVar == null || !cVar.k()) {
                    return null;
                }
                cVar.h().B();
                return response.request();
            }
            if (iCode == 503) {
                Response responsePriorResponse = response.priorResponse();
                if ((responsePriorResponse == null || responsePriorResponse.code() != 503) && f(response, Integer.MAX_VALUE) == 0) {
                    return response.request();
                }
                return null;
            }
            if (iCode == 407) {
                l0.m(route);
                if (route.proxy().type() == Proxy.Type.HTTP) {
                    return this.f37895a.proxyAuthenticator().authenticate(route, response);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (iCode == 408) {
                if (!this.f37895a.retryOnConnectionFailure()) {
                    return null;
                }
                RequestBody requestBodyBody2 = response.request().body();
                if (requestBodyBody2 != null && requestBodyBody2.isOneShot()) {
                    return null;
                }
                Response responsePriorResponse2 = response.priorResponse();
                if ((responsePriorResponse2 == null || responsePriorResponse2.code() != 408) && f(response, 0) <= 0) {
                    return response.request();
                }
                return null;
            }
            switch (iCode) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        return a(response, strMethod);
    }

    private final boolean c(IOException iOException, boolean z7) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            return (iOException instanceof SocketTimeoutException) && !z7;
        }
        return (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private final boolean d(IOException iOException, okhttp3.internal.connection.e eVar, Request request, boolean z7) {
        if (this.f37895a.retryOnConnectionFailure()) {
            return !(z7 && e(iOException, request)) && c(iOException, z7) && eVar.y();
        }
        return false;
    }

    private final boolean e(IOException iOException, Request request) {
        RequestBody requestBodyBody = request.body();
        return (requestBodyBody != null && requestBodyBody.isOneShot()) || (iOException instanceof FileNotFoundException);
    }

    private final int f(Response response, int i7) {
        String strHeader$default = Response.header$default(response, com.google.common.net.c.f22165q0, null, 2, null);
        if (strHeader$default == null) {
            return i7;
        }
        if (!new o("\\d+").k(strHeader$default)) {
            return Integer.MAX_VALUE;
        }
        Integer numValueOf = Integer.valueOf(strHeader$default);
        l0.o(numValueOf, "Integer.valueOf(header)");
        return numValueOf.intValue();
    }

    @Override // okhttp3.Interceptor
    @a7.d
    public Response intercept(@a7.d Interceptor.Chain chain) throws IOException {
        Response responseProceed;
        l0.p(chain, "chain");
        g gVar = (g) chain;
        Request requestG = gVar.g();
        okhttp3.internal.connection.e eVarC = gVar.c();
        List listF = y.F();
        int i7 = 0;
        Response response = null;
        while (true) {
            boolean z7 = true;
            while (true) {
                eVarC.j(requestG, z7);
                try {
                    if (eVarC.isCanceled()) {
                        throw new IOException("Canceled");
                    }
                    try {
                        responseProceed = gVar.proceed(requestG);
                    } catch (IOException e8) {
                        if (!d(e8, eVarC, requestG, !(e8 instanceof okhttp3.internal.http2.a))) {
                            throw okhttp3.internal.d.j0(e8, listF);
                        }
                        listF = g0.z4(listF, e8);
                        eVarC.k(true);
                        z7 = false;
                    } catch (okhttp3.internal.connection.j e9) {
                        if (!d(e9.c(), eVarC, requestG, false)) {
                            throw okhttp3.internal.d.j0(e9.b(), listF);
                        }
                        listF = g0.z4(listF, e9.b());
                        eVarC.k(true);
                        z7 = false;
                    }
                    eVarC.k(true);
                    z7 = false;
                } catch (Throwable th) {
                    eVarC.k(true);
                    throw th;
                }
            }
            if (response != null) {
                responseProceed = responseProceed.newBuilder().priorResponse(response.newBuilder().body(null).build()).build();
            }
            response = responseProceed;
            okhttp3.internal.connection.c cVarQ = eVarC.q();
            Request requestB = b(response, cVarQ);
            if (requestB == null) {
                if (cVarQ != null && cVarQ.l()) {
                    eVarC.B();
                }
                eVarC.k(false);
                return response;
            }
            RequestBody requestBodyBody = requestB.body();
            if (requestBodyBody != null && requestBodyBody.isOneShot()) {
                eVarC.k(false);
                return response;
            }
            ResponseBody responseBodyBody = response.body();
            if (responseBodyBody != null) {
                okhttp3.internal.d.l(responseBodyBody);
            }
            i7++;
            if (i7 > 20) {
                throw new ProtocolException("Too many follow-up requests: " + i7);
            }
            eVarC.k(true);
            requestG = requestB;
        }
    }
}
