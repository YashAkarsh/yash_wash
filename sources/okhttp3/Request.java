package okhttp3;

import a7.e;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.common.net.c;
import com.haier.globalwasher.mvp_api.volley.toolbox.h;
import com.haier.uhome.account.api.Const;
import com.paytm.pgsdk.d;
import h5.i;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.b1;
import kotlin.collections.c1;
import kotlin.collections.y;
import kotlin.i0;
import kotlin.jvm.internal.l0;
import kotlin.k;
import kotlin.m;
import kotlin.text.b0;
import kotlin.u0;
import okhttp3.internal.http.f;

/* JADX INFO: loaded from: classes3.dex */
@i0(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001*BA\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0016\u0010\n\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\u0010\rJ\u000f\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\b\u001bJ\r\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\b\u001cJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u0005J\r\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\u001fJ\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050 2\u0006\u0010\u001e\u001a\u00020\u0005J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\b!J\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u0004\u0018\u00010\u0001J#\u0010$\u001a\u0004\u0018\u0001H%\"\u0004\b\u0000\u0010%2\u000e\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u0002H%0\f¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u0005H\u0016J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b)R\u0015\u0010\b\u001a\u0004\u0018\u00010\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0013\u0010\u0006\u001a\u00020\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0017R$\u0010\n\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u00020\u00010\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u001a¨\u0006+"}, d2 = {"Lokhttp3/Request;", "", "url", "Lokhttp3/HttpUrl;", "method", "", "headers", "Lokhttp3/Headers;", d.V, "Lokhttp3/RequestBody;", "tags", "", "Ljava/lang/Class;", "(Lokhttp3/HttpUrl;Ljava/lang/String;Lokhttp3/Headers;Lokhttp3/RequestBody;Ljava/util/Map;)V", "()Lokhttp3/RequestBody;", "cacheControl", "Lokhttp3/CacheControl;", "()Lokhttp3/CacheControl;", "()Lokhttp3/Headers;", "isHttps", "", "()Z", "lazyCacheControl", "()Ljava/lang/String;", "getTags$okhttp", "()Ljava/util/Map;", "()Lokhttp3/HttpUrl;", "-deprecated_body", "-deprecated_cacheControl", "header", "name", "-deprecated_headers", "", "-deprecated_method", "newBuilder", "Lokhttp3/Request$Builder;", ViewHierarchyConstants.TAG_KEY, "T", "type", "(Ljava/lang/Class;)Ljava/lang/Object;", "toString", "-deprecated_url", "Builder", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Request {

    @e
    private final RequestBody body;

    @a7.d
    private final Headers headers;
    private CacheControl lazyCacheControl;

    @a7.d
    private final String method;

    @a7.d
    private final Map<Class<?>, Object> tags;

    @a7.d
    private final HttpUrl url;

    @i0(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0013H\u0016J\b\u0010(\u001a\u00020\u0004H\u0016J\u0010\u0010)\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*H\u0016J\u0014\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0017J\b\u0010,\u001a\u00020\u0000H\u0016J\b\u0010-\u001a\u00020\u0000H\u0016J\u0018\u0010.\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0013H\u0016J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020/H\u0016J\u001a\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u00100\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u00101\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u00102\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u00103\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0013H\u0016J-\u00104\u001a\u00020\u0000\"\u0004\b\u0000\u001052\u000e\u00106\u001a\n\u0012\u0006\b\u0000\u0012\u0002H50\u001a2\b\u00104\u001a\u0004\u0018\u0001H5H\u0016¢\u0006\u0002\u00107J\u0012\u00104\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u00010\u0001H\u0016J\u0010\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u000208H\u0016J\u0010\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0013H\u0016J\u0010\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u0018\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a\u0012\u0004\u0012\u00020\u00010\u0019X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u00069"}, d2 = {"Lokhttp3/Request$Builder;", "", "()V", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lokhttp3/Request;", "(Lokhttp3/Request;)V", d.V, "Lokhttp3/RequestBody;", "getBody$okhttp", "()Lokhttp3/RequestBody;", "setBody$okhttp", "(Lokhttp3/RequestBody;)V", "headers", "Lokhttp3/Headers$Builder;", "getHeaders$okhttp", "()Lokhttp3/Headers$Builder;", "setHeaders$okhttp", "(Lokhttp3/Headers$Builder;)V", "method", "", "getMethod$okhttp", "()Ljava/lang/String;", "setMethod$okhttp", "(Ljava/lang/String;)V", "tags", "", "Ljava/lang/Class;", "getTags$okhttp", "()Ljava/util/Map;", "setTags$okhttp", "(Ljava/util/Map;)V", "url", "Lokhttp3/HttpUrl;", "getUrl$okhttp", "()Lokhttp3/HttpUrl;", "setUrl$okhttp", "(Lokhttp3/HttpUrl;)V", "addHeader", "name", "value", "build", "cacheControl", "Lokhttp3/CacheControl;", "delete", "get", d.U, "header", "Lokhttp3/Headers;", "patch", "post", "put", "removeHeader", ViewHierarchyConstants.TAG_KEY, "T", "type", "(Ljava/lang/Class;Ljava/lang/Object;)Lokhttp3/Request$Builder;", "Ljava/net/URL;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static class Builder {

        @e
        private RequestBody body;

        @a7.d
        private Headers.Builder headers;

        @a7.d
        private String method;

        @a7.d
        private Map<Class<?>, Object> tags;

        @e
        private HttpUrl url;

        public Builder() {
            this.tags = new LinkedHashMap();
            this.method = Const.HTTP_REQUEST_TYPE_GET;
            this.headers = new Headers.Builder();
        }

        public static /* synthetic */ Builder delete$default(Builder builder, RequestBody requestBody, int i7, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
            }
            if ((i7 & 1) != 0) {
                requestBody = okhttp3.internal.d.f37857d;
            }
            return builder.delete(requestBody);
        }

        @a7.d
        public Builder addHeader(@a7.d String name, @a7.d String value) {
            l0.p(name, "name");
            l0.p(value, "value");
            this.headers.add(name, value);
            return this;
        }

        @a7.d
        public Request build() {
            HttpUrl httpUrl = this.url;
            if (httpUrl != null) {
                return new Request(httpUrl, this.method, this.headers.build(), this.body, okhttp3.internal.d.d0(this.tags));
            }
            throw new IllegalStateException("url == null".toString());
        }

        @a7.d
        public Builder cacheControl(@a7.d CacheControl cacheControl) {
            l0.p(cacheControl, "cacheControl");
            String string = cacheControl.toString();
            return string.length() == 0 ? removeHeader(c.f22132a) : header(c.f22132a, string);
        }

        @a7.d
        @i
        public final Builder delete() {
            return delete$default(this, null, 1, null);
        }

        @a7.d
        public Builder get() {
            return method(Const.HTTP_REQUEST_TYPE_GET, null);
        }

        @e
        public final RequestBody getBody$okhttp() {
            return this.body;
        }

        @a7.d
        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        @a7.d
        public final String getMethod$okhttp() {
            return this.method;
        }

        @a7.d
        public final Map<Class<?>, Object> getTags$okhttp() {
            return this.tags;
        }

        @e
        public final HttpUrl getUrl$okhttp() {
            return this.url;
        }

        @a7.d
        public Builder head() {
            return method("HEAD", null);
        }

        @a7.d
        public Builder header(@a7.d String name, @a7.d String value) {
            l0.p(name, "name");
            l0.p(value, "value");
            this.headers.set(name, value);
            return this;
        }

        @a7.d
        public Builder headers(@a7.d Headers headers) {
            l0.p(headers, "headers");
            this.headers = headers.newBuilder();
            return this;
        }

        @a7.d
        public Builder method(@a7.d String method, @e RequestBody requestBody) {
            l0.p(method, "method");
            if (!(method.length() > 0)) {
                throw new IllegalArgumentException("method.isEmpty() == true".toString());
            }
            if (requestBody == null) {
                if (!(true ^ f.e(method))) {
                    throw new IllegalArgumentException(("method " + method + " must have a request body.").toString());
                }
            } else if (!f.b(method)) {
                throw new IllegalArgumentException(("method " + method + " must not have a request body.").toString());
            }
            this.method = method;
            this.body = requestBody;
            return this;
        }

        @a7.d
        public Builder patch(@a7.d RequestBody body) {
            l0.p(body, "body");
            return method(h.a.f24990a, body);
        }

        @a7.d
        public Builder post(@a7.d RequestBody body) {
            l0.p(body, "body");
            return method(Const.HTTP_REQUEST_TYPE_POST, body);
        }

        @a7.d
        public Builder put(@a7.d RequestBody body) {
            l0.p(body, "body");
            return method("PUT", body);
        }

        @a7.d
        public Builder removeHeader(@a7.d String name) {
            l0.p(name, "name");
            this.headers.removeAll(name);
            return this;
        }

        public final void setBody$okhttp(@e RequestBody requestBody) {
            this.body = requestBody;
        }

        public final void setHeaders$okhttp(@a7.d Headers.Builder builder) {
            l0.p(builder, "<set-?>");
            this.headers = builder;
        }

        public final void setMethod$okhttp(@a7.d String str) {
            l0.p(str, "<set-?>");
            this.method = str;
        }

        public final void setTags$okhttp(@a7.d Map<Class<?>, Object> map) {
            l0.p(map, "<set-?>");
            this.tags = map;
        }

        public final void setUrl$okhttp(@e HttpUrl httpUrl) {
            this.url = httpUrl;
        }

        @a7.d
        public Builder tag(@e Object obj) {
            return tag(Object.class, obj);
        }

        @a7.d
        public Builder url(@a7.d HttpUrl url) {
            l0.p(url, "url");
            this.url = url;
            return this;
        }

        @a7.d
        @i
        public Builder delete(@e RequestBody requestBody) {
            return method("DELETE", requestBody);
        }

        @a7.d
        public <T> Builder tag(@a7.d Class<? super T> type, @e T t7) {
            l0.p(type, "type");
            if (t7 == null) {
                this.tags.remove(type);
            } else {
                if (this.tags.isEmpty()) {
                    this.tags = new LinkedHashMap();
                }
                Map<Class<?>, Object> map = this.tags;
                T tCast = type.cast(t7);
                l0.m(tCast);
                map.put(type, tCast);
            }
            return this;
        }

        @a7.d
        public Builder url(@a7.d String url) {
            l0.p(url, "url");
            if (b0.s2(url, "ws:", true)) {
                StringBuilder sb = new StringBuilder();
                sb.append("http:");
                String strSubstring = url.substring(3);
                l0.o(strSubstring, "(this as java.lang.String).substring(startIndex)");
                sb.append(strSubstring);
                url = sb.toString();
            } else if (b0.s2(url, "wss:", true)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("https:");
                String strSubstring2 = url.substring(4);
                l0.o(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                sb2.append(strSubstring2);
                url = sb2.toString();
            }
            return url(HttpUrl.Companion.get(url));
        }

        public Builder(@a7.d Request request) {
            Map<Class<?>, Object> mapJ0;
            l0.p(request, "request");
            this.tags = new LinkedHashMap();
            this.url = request.url();
            this.method = request.method();
            this.body = request.body();
            if (request.getTags$okhttp().isEmpty()) {
                mapJ0 = new LinkedHashMap<>();
            } else {
                mapJ0 = c1.J0(request.getTags$okhttp());
            }
            this.tags = mapJ0;
            this.headers = request.headers().newBuilder();
        }

        @a7.d
        public Builder url(@a7.d URL url) {
            l0.p(url, "url");
            HttpUrl.Companion companion = HttpUrl.Companion;
            String string = url.toString();
            l0.o(string, "url.toString()");
            return url(companion.get(string));
        }
    }

    public Request(@a7.d HttpUrl url, @a7.d String method, @a7.d Headers headers, @e RequestBody requestBody, @a7.d Map<Class<?>, ? extends Object> tags) {
        l0.p(url, "url");
        l0.p(method, "method");
        l0.p(headers, "headers");
        l0.p(tags, "tags");
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.body = requestBody;
        this.tags = tags;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = d.V, imports = {}))
    @e
    @h5.h(name = "-deprecated_body")
    /* JADX INFO: renamed from: -deprecated_body, reason: not valid java name */
    public final RequestBody m114deprecated_body() {
        return this.body;
    }

    @a7.d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "cacheControl", imports = {}))
    @h5.h(name = "-deprecated_cacheControl")
    /* JADX INFO: renamed from: -deprecated_cacheControl, reason: not valid java name */
    public final CacheControl m115deprecated_cacheControl() {
        return cacheControl();
    }

    @a7.d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "headers", imports = {}))
    @h5.h(name = "-deprecated_headers")
    /* JADX INFO: renamed from: -deprecated_headers, reason: not valid java name */
    public final Headers m116deprecated_headers() {
        return this.headers;
    }

    @a7.d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "method", imports = {}))
    @h5.h(name = "-deprecated_method")
    /* JADX INFO: renamed from: -deprecated_method, reason: not valid java name */
    public final String m117deprecated_method() {
        return this.method;
    }

    @a7.d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "url", imports = {}))
    @h5.h(name = "-deprecated_url")
    /* JADX INFO: renamed from: -deprecated_url, reason: not valid java name */
    public final HttpUrl m118deprecated_url() {
        return this.url;
    }

    @e
    @h5.h(name = d.V)
    public final RequestBody body() {
        return this.body;
    }

    @a7.d
    @h5.h(name = "cacheControl")
    public final CacheControl cacheControl() {
        CacheControl cacheControl = this.lazyCacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl cacheControl2 = CacheControl.Companion.parse(this.headers);
        this.lazyCacheControl = cacheControl2;
        return cacheControl2;
    }

    @a7.d
    public final Map<Class<?>, Object> getTags$okhttp() {
        return this.tags;
    }

    @e
    public final String header(@a7.d String name) {
        l0.p(name, "name");
        return this.headers.get(name);
    }

    @a7.d
    @h5.h(name = "headers")
    public final Headers headers() {
        return this.headers;
    }

    public final boolean isHttps() {
        return this.url.isHttps();
    }

    @a7.d
    @h5.h(name = "method")
    public final String method() {
        return this.method;
    }

    @a7.d
    public final Builder newBuilder() {
        return new Builder(this);
    }

    @e
    public final Object tag() {
        return tag(Object.class);
    }

    @a7.d
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.method);
        sb.append(", url=");
        sb.append(this.url);
        if (this.headers.size() != 0) {
            sb.append(", headers=[");
            int i7 = 0;
            for (u0<? extends String, ? extends String> u0Var : this.headers) {
                int i8 = i7 + 1;
                if (i7 < 0) {
                    y.X();
                }
                u0<? extends String, ? extends String> u0Var2 = u0Var;
                String strA = u0Var2.a();
                String strB = u0Var2.b();
                if (i7 > 0) {
                    sb.append(", ");
                }
                sb.append(strA);
                sb.append(':');
                sb.append(strB);
                i7 = i8;
            }
            sb.append(']');
        }
        if (!this.tags.isEmpty()) {
            sb.append(", tags=");
            sb.append(this.tags);
        }
        sb.append('}');
        String string = sb.toString();
        l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @a7.d
    @h5.h(name = "url")
    public final HttpUrl url() {
        return this.url;
    }

    @a7.d
    public final List<String> headers(@a7.d String name) {
        l0.p(name, "name");
        return this.headers.values(name);
    }

    @e
    public final <T> T tag(@a7.d Class<? extends T> type) {
        l0.p(type, "type");
        return type.cast(this.tags.get(type));
    }
}
