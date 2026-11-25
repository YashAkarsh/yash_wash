package okhttp3.internal.cache;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import kotlin.text.b0;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.f;
import okhttp3.internal.http.h;
import okio.a0;
import okio.m;
import okio.m0;
import okio.n;
import okio.o;
import okio.o0;
import okio.q0;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Interceptor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0500a f37618b = new C0500a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.e
    private final Cache f37619a;

    /* JADX INFO: renamed from: okhttp3.internal.cache.a$a, reason: collision with other inner class name */
    public static final class C0500a {
        private C0500a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Headers c(Headers headers, Headers headers2) {
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            for (int i7 = 0; i7 < size; i7++) {
                String strName = headers.name(i7);
                String strValue = headers.value(i7);
                if ((!b0.K1(com.google.common.net.c.f22144g, strName, true) || !b0.u2(strValue, "1", false, 2, null)) && (d(strName) || !e(strName) || headers2.get(strName) == null)) {
                    builder.addLenient$okhttp(strName, strValue);
                }
            }
            int size2 = headers2.size();
            for (int i8 = 0; i8 < size2; i8++) {
                String strName2 = headers2.name(i8);
                if (!d(strName2) && e(strName2)) {
                    builder.addLenient$okhttp(strName2, headers2.value(i8));
                }
            }
            return builder.build();
        }

        private final boolean d(String str) {
            return b0.K1(com.google.common.net.c.f22134b, str, true) || b0.K1(com.google.common.net.c.X, str, true) || b0.K1("Content-Type", str, true);
        }

        private final boolean e(String str) {
            return (b0.K1(com.google.common.net.c.f22160o, str, true) || b0.K1("Keep-Alive", str, true) || b0.K1(com.google.common.net.c.f22161o0, str, true) || b0.K1(com.google.common.net.c.F, str, true) || b0.K1(com.google.common.net.c.K, str, true) || b0.K1("Trailers", str, true) || b0.K1(com.google.common.net.c.f22183z0, str, true) || b0.K1(com.google.common.net.c.L, str, true)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Response f(Response response) {
            return (response != null ? response.body() : null) != null ? response.newBuilder().body(null).build() : response;
        }

        public /* synthetic */ C0500a(w wVar) {
            this();
        }
    }

    public static final class b implements o0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f37620a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ o f37621b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ okhttp3.internal.cache.b f37622c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ n f37623d;

        b(o oVar, okhttp3.internal.cache.b bVar, n nVar) {
            this.f37621b = oVar;
            this.f37622c = bVar;
            this.f37623d = nVar;
        }

        @Override // okio.o0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.f37620a && !okhttp3.internal.d.t(this, 100, TimeUnit.MILLISECONDS)) {
                this.f37620a = true;
                this.f37622c.abort();
            }
            this.f37621b.close();
        }

        @Override // okio.o0
        public long read(@a7.d m sink, long j7) throws IOException {
            l0.p(sink, "sink");
            try {
                long j8 = this.f37621b.read(sink, j7);
                if (j8 != -1) {
                    sink.Q(this.f37623d.p(), sink.B1() - j8, j8);
                    this.f37623d.b0();
                    return j8;
                }
                if (!this.f37620a) {
                    this.f37620a = true;
                    this.f37623d.close();
                }
                return -1L;
            } catch (IOException e8) {
                if (!this.f37620a) {
                    this.f37620a = true;
                    this.f37622c.abort();
                }
                throw e8;
            }
        }

        @Override // okio.o0
        @a7.d
        public q0 timeout() {
            return this.f37621b.timeout();
        }
    }

    public a(@a7.e Cache cache) {
        this.f37619a = cache;
    }

    private final Response a(okhttp3.internal.cache.b bVar, Response response) throws IOException {
        if (bVar == null) {
            return response;
        }
        m0 m0VarBody = bVar.body();
        ResponseBody responseBodyBody = response.body();
        l0.m(responseBodyBody);
        b bVar2 = new b(responseBodyBody.source(), bVar, a0.c(m0VarBody));
        return response.newBuilder().body(new h(Response.header$default(response, "Content-Type", null, 2, null), response.body().contentLength(), a0.d(bVar2))).build();
    }

    @a7.e
    public final Cache b() {
        return this.f37619a;
    }

    @Override // okhttp3.Interceptor
    @a7.d
    public Response intercept(@a7.d Interceptor.Chain chain) throws IOException {
        EventListener eventListenerO;
        ResponseBody responseBodyBody;
        ResponseBody responseBodyBody2;
        ResponseBody responseBodyBody3;
        l0.p(chain, "chain");
        Call call = chain.call();
        Cache cache = this.f37619a;
        Response response = cache != null ? cache.get$okhttp(chain.request()) : null;
        c cVarB = new c.b(System.currentTimeMillis(), chain.request(), response).b();
        Request requestB = cVarB.b();
        Response responseA = cVarB.a();
        Cache cache2 = this.f37619a;
        if (cache2 != null) {
            cache2.trackResponse$okhttp(cVarB);
        }
        okhttp3.internal.connection.e eVar = (okhttp3.internal.connection.e) (call instanceof okhttp3.internal.connection.e ? call : null);
        if (eVar == null || (eventListenerO = eVar.o()) == null) {
            eventListenerO = EventListener.NONE;
        }
        if (response != null && responseA == null && (responseBodyBody3 = response.body()) != null) {
            okhttp3.internal.d.l(responseBodyBody3);
        }
        if (requestB == null && responseA == null) {
            Response responseBuild = new Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(androidx.constraintlayout.core.motion.utils.w.g.f3135l).message("Unsatisfiable Request (only-if-cached)").body(okhttp3.internal.d.f37856c).sentRequestAtMillis(-1L).receivedResponseAtMillis(System.currentTimeMillis()).build();
            eventListenerO.satisfactionFailure(call, responseBuild);
            return responseBuild;
        }
        if (requestB == null) {
            l0.m(responseA);
            Response responseBuild2 = responseA.newBuilder().cacheResponse(f37618b.f(responseA)).build();
            eventListenerO.cacheHit(call, responseBuild2);
            return responseBuild2;
        }
        if (responseA != null) {
            eventListenerO.cacheConditionalHit(call, responseA);
        } else if (this.f37619a != null) {
            eventListenerO.cacheMiss(call);
        }
        try {
            Response responseProceed = chain.proceed(requestB);
            if (responseProceed == null && response != null && (responseBodyBody2 = response.body()) != null) {
                okhttp3.internal.d.l(responseBodyBody2);
            }
            if (responseA != null) {
                if (responseProceed != null && responseProceed.code() == 304) {
                    Response.Builder builderNewBuilder = responseA.newBuilder();
                    C0500a c0500a = f37618b;
                    Response responseBuild3 = builderNewBuilder.headers(c0500a.c(responseA.headers(), responseProceed.headers())).sentRequestAtMillis(responseProceed.sentRequestAtMillis()).receivedResponseAtMillis(responseProceed.receivedResponseAtMillis()).cacheResponse(c0500a.f(responseA)).networkResponse(c0500a.f(responseProceed)).build();
                    ResponseBody responseBodyBody4 = responseProceed.body();
                    l0.m(responseBodyBody4);
                    responseBodyBody4.close();
                    Cache cache3 = this.f37619a;
                    l0.m(cache3);
                    cache3.trackConditionalCacheHit$okhttp();
                    this.f37619a.update$okhttp(responseA, responseBuild3);
                    eventListenerO.cacheHit(call, responseBuild3);
                    return responseBuild3;
                }
                ResponseBody responseBodyBody5 = responseA.body();
                if (responseBodyBody5 != null) {
                    okhttp3.internal.d.l(responseBodyBody5);
                }
            }
            l0.m(responseProceed);
            Response.Builder builderNewBuilder2 = responseProceed.newBuilder();
            C0500a c0500a2 = f37618b;
            Response responseBuild4 = builderNewBuilder2.cacheResponse(c0500a2.f(responseA)).networkResponse(c0500a2.f(responseProceed)).build();
            if (this.f37619a != null) {
                if (okhttp3.internal.http.e.c(responseBuild4) && c.f37624c.a(responseBuild4, requestB)) {
                    Response responseA2 = a(this.f37619a.put$okhttp(responseBuild4), responseBuild4);
                    if (responseA != null) {
                        eventListenerO.cacheMiss(call);
                    }
                    return responseA2;
                }
                if (f.f37879a.a(requestB.method())) {
                    try {
                        this.f37619a.remove$okhttp(requestB);
                    } catch (IOException unused) {
                    }
                }
            }
            return responseBuild4;
        } catch (Throwable th) {
            if (response != null && (responseBodyBody = response.body()) != null) {
                okhttp3.internal.d.l(responseBodyBody);
            }
            throw th;
        }
    }
}
