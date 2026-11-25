package okhttp3.internal.cache;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import kotlin.text.b0;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.time.DateUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f37624c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.e
    private final Request f37625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.e
    private final Response f37626b;

    public static final class a {
        private a() {
        }

        /* JADX WARN: Code duplicated, block: B:24:0x003b  */
        public final boolean a(@a7.d Response response, @a7.d Request request) {
            l0.p(response, "response");
            l0.p(request, "request");
            int iCode = response.code();
            if (iCode != 200 && iCode != 410 && iCode != 414 && iCode != 501 && iCode != 203 && iCode != 204) {
                if (iCode == 307) {
                    if (Response.header$default(response, com.google.common.net.c.f22151j0, null, 2, null) == null && response.cacheControl().maxAgeSeconds() == -1 && !response.cacheControl().isPublic() && !response.cacheControl().isPrivate()) {
                        return false;
                    }
                } else if (iCode != 308 && iCode != 404 && iCode != 405) {
                    switch (iCode) {
                        case 300:
                        case 301:
                            break;
                        case 302:
                            if (Response.header$default(response, com.google.common.net.c.f22151j0, null, 2, null) == null) {
                                return false;
                            }
                            break;
                        default:
                            return false;
                    }
                }
            }
            return (response.cacheControl().noStore() || request.cacheControl().noStore()) ? false : true;
        }

        public /* synthetic */ a(w wVar) {
            this();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Date f37627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f37628b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Date f37629c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f37630d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Date f37631e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f37632f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f37633g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f37634h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f37635i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final long f37636j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @a7.d
        private final Request f37637k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final Response f37638l;

        public b(long j7, @a7.d Request request, @a7.e Response response) {
            l0.p(request, "request");
            this.f37636j = j7;
            this.f37637k = request;
            this.f37638l = response;
            this.f37635i = -1;
            if (response != null) {
                this.f37632f = response.sentRequestAtMillis();
                this.f37633g = response.receivedResponseAtMillis();
                Headers headers = response.headers();
                int size = headers.size();
                for (int i7 = 0; i7 < size; i7++) {
                    String strName = headers.name(i7);
                    String strValue = headers.value(i7);
                    if (b0.K1(strName, com.google.common.net.c.f22138d, true)) {
                        this.f37627a = okhttp3.internal.http.c.a(strValue);
                        this.f37628b = strValue;
                    } else if (b0.K1(strName, com.google.common.net.c.f22151j0, true)) {
                        this.f37631e = okhttp3.internal.http.c.a(strValue);
                    } else if (b0.K1(strName, com.google.common.net.c.f22153k0, true)) {
                        this.f37629c = okhttp3.internal.http.c.a(strValue);
                        this.f37630d = strValue;
                    } else if (b0.K1(strName, com.google.common.net.c.f22149i0, true)) {
                        this.f37634h = strValue;
                    } else if (b0.K1(strName, com.google.common.net.c.U, true)) {
                        this.f37635i = okhttp3.internal.d.f0(strValue, -1);
                    }
                }
            }
        }

        private final long a() {
            Date date = this.f37627a;
            long jMax = date != null ? Math.max(0L, this.f37633g - date.getTime()) : 0L;
            int i7 = this.f37635i;
            if (i7 != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i7));
            }
            long j7 = this.f37633g;
            return jMax + (j7 - this.f37632f) + (this.f37636j - j7);
        }

        private final c c() {
            String str;
            if (this.f37638l == null) {
                return new c(this.f37637k, null);
            }
            if (this.f37637k.isHttps() && this.f37638l.handshake() == null) {
                return new c(this.f37637k, null);
            }
            if (!c.f37624c.a(this.f37638l, this.f37637k)) {
                return new c(this.f37637k, null);
            }
            CacheControl cacheControl = this.f37637k.cacheControl();
            if (cacheControl.noCache() || f(this.f37637k)) {
                return new c(this.f37637k, null);
            }
            CacheControl cacheControl2 = this.f37638l.cacheControl();
            long jA = a();
            long jD = d();
            if (cacheControl.maxAgeSeconds() != -1) {
                jD = Math.min(jD, TimeUnit.SECONDS.toMillis(cacheControl.maxAgeSeconds()));
            }
            long millis = 0;
            long millis2 = cacheControl.minFreshSeconds() != -1 ? TimeUnit.SECONDS.toMillis(cacheControl.minFreshSeconds()) : 0L;
            if (!cacheControl2.mustRevalidate() && cacheControl.maxStaleSeconds() != -1) {
                millis = TimeUnit.SECONDS.toMillis(cacheControl.maxStaleSeconds());
            }
            if (!cacheControl2.noCache()) {
                long j7 = millis2 + jA;
                if (j7 < millis + jD) {
                    Response.Builder builderNewBuilder = this.f37638l.newBuilder();
                    if (j7 >= jD) {
                        builderNewBuilder.addHeader(com.google.common.net.c.f22144g, "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (jA > DateUtils.MILLIS_PER_DAY && g()) {
                        builderNewBuilder.addHeader(com.google.common.net.c.f22144g, "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new c(null, builderNewBuilder.build());
                }
            }
            String str2 = this.f37634h;
            if (str2 != null) {
                str = com.google.common.net.c.f22182z;
            } else {
                if (this.f37629c != null) {
                    str2 = this.f37630d;
                } else {
                    if (this.f37627a == null) {
                        return new c(this.f37637k, null);
                    }
                    str2 = this.f37628b;
                }
                str = com.google.common.net.c.f22180y;
            }
            Headers.Builder builderNewBuilder2 = this.f37637k.headers().newBuilder();
            l0.m(str2);
            builderNewBuilder2.addLenient$okhttp(str, str2);
            return new c(this.f37637k.newBuilder().headers(builderNewBuilder2.build()).build(), this.f37638l);
        }

        private final long d() {
            Response response = this.f37638l;
            l0.m(response);
            CacheControl cacheControl = response.cacheControl();
            if (cacheControl.maxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis(cacheControl.maxAgeSeconds());
            }
            Date date = this.f37631e;
            if (date != null) {
                Date date2 = this.f37627a;
                long time = date.getTime() - (date2 != null ? date2.getTime() : this.f37633g);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f37629c == null || this.f37638l.request().url().query() != null) {
                return 0L;
            }
            Date date3 = this.f37627a;
            long time2 = date3 != null ? date3.getTime() : this.f37632f;
            Date date4 = this.f37629c;
            l0.m(date4);
            long time3 = time2 - date4.getTime();
            if (time3 > 0) {
                return time3 / ((long) 10);
            }
            return 0L;
        }

        private final boolean f(Request request) {
            return (request.header(com.google.common.net.c.f22180y) == null && request.header(com.google.common.net.c.f22182z) == null) ? false : true;
        }

        private final boolean g() {
            Response response = this.f37638l;
            l0.m(response);
            return response.cacheControl().maxAgeSeconds() == -1 && this.f37631e == null;
        }

        @a7.d
        public final c b() {
            c cVarC = c();
            return (cVarC.b() == null || !this.f37637k.cacheControl().onlyIfCached()) ? cVarC : new c(null, null);
        }

        @a7.d
        public final Request e() {
            return this.f37637k;
        }
    }

    public c(@a7.e Request request, @a7.e Response response) {
        this.f37625a = request;
        this.f37626b = response;
    }

    @a7.e
    public final Response a() {
        return this.f37626b;
    }

    @a7.e
    public final Request b() {
        return this.f37625a;
    }
}
