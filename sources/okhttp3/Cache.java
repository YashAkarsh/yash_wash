package okhttp3;

import a7.d;
import a7.e;
import com.facebook.share.internal.ShareConstants;
import com.google.common.net.c;
import com.haier.uhome.account.api.Const;
import com.haier.uhome.account.api.RetInfoContent;
import h5.h;
import h5.l;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;
import kotlin.b1;
import kotlin.collections.n1;
import kotlin.collections.y;
import kotlin.i0;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.s1;
import kotlin.jvm.internal.w;
import kotlin.k;
import kotlin.l2;
import kotlin.m;
import kotlin.text.b0;
import kotlin.text.c0;
import kotlin.text.h0;
import okhttp3.internal.http.f;
import okio.a0;
import okio.m0;
import okio.n;
import okio.o;
import okio.o0;
import okio.p;
import okio.r;
import okio.s;

/* JADX INFO: loaded from: classes3.dex */
@i0(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010)\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0004LKMNB!\b\u0000\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u0010&\u001a\u00020$\u0012\u0006\u0010G\u001a\u00020F¢\u0006\u0004\bH\u0010IB\u0019\b\u0016\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u0010&\u001a\u00020$¢\u0006\u0004\bH\u0010JJ\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0018\u00010\u0003R\u00020\u0004H\u0002J\u0019\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\nH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nH\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u001b\u001a\u00020\u0006J\u0006\u0010\u001c\u001a\u00020\u0006J\u0006\u0010\u001d\u001a\u00020\u0006J\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eJ\u0006\u0010\"\u001a\u00020!J\u0006\u0010#\u001a\u00020!J\u0006\u0010%\u001a\u00020$J\u0006\u0010&\u001a\u00020$J\b\u0010'\u001a\u00020\u0006H\u0016J\b\u0010(\u001a\u00020\u0006H\u0016J\u000f\u0010,\u001a\u00020)H\u0007¢\u0006\u0004\b*\u0010+J\u0017\u00101\u001a\u00020\u00062\u0006\u0010.\u001a\u00020-H\u0000¢\u0006\u0004\b/\u00100J\u000f\u00104\u001a\u00020\u0006H\u0000¢\u0006\u0004\b2\u00103J\u0006\u00105\u001a\u00020!J\u0006\u00106\u001a\u00020!J\u0006\u00107\u001a\u00020!R\u001a\u00108\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\"\u0010#\u001a\u00020!8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b#\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010\"\u001a\u00020!8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\"\u0010<\u001a\u0004\bA\u0010>\"\u0004\bB\u0010@R\u0016\u00105\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010<R\u0016\u00106\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010<R\u0016\u00107\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010<R\u0011\u0010D\u001a\u00020C8F¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0011\u0010,\u001a\u00020)8G¢\u0006\u0006\u001a\u0004\b,\u0010+¨\u0006O"}, d2 = {"Lokhttp3/Cache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "Lokhttp3/internal/cache/d$b;", "Lokhttp3/internal/cache/d;", "editor", "Lkotlin/l2;", "abortQuietly", "Lokhttp3/Request;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lokhttp3/Response;", "get$okhttp", "(Lokhttp3/Request;)Lokhttp3/Response;", "get", "response", "Lokhttp3/internal/cache/b;", "put$okhttp", "(Lokhttp3/Response;)Lokhttp3/internal/cache/b;", "put", "remove$okhttp", "(Lokhttp3/Request;)V", "remove", "cached", "network", "update$okhttp", "(Lokhttp3/Response;Lokhttp3/Response;)V", "update", "initialize", "delete", "evictAll", "", "", "urls", "", "writeAbortCount", "writeSuccessCount", "", "size", "maxSize", "flush", "close", "Ljava/io/File;", "-deprecated_directory", "()Ljava/io/File;", "directory", "Lokhttp3/internal/cache/c;", "cacheStrategy", "trackResponse$okhttp", "(Lokhttp3/internal/cache/c;)V", "trackResponse", "trackConditionalCacheHit$okhttp", "()V", "trackConditionalCacheHit", "networkCount", "hitCount", "requestCount", "cache", "Lokhttp3/internal/cache/d;", "getCache$okhttp", "()Lokhttp3/internal/cache/d;", "I", "getWriteSuccessCount$okhttp", "()I", "setWriteSuccessCount$okhttp", "(I)V", "getWriteAbortCount$okhttp", "setWriteAbortCount$okhttp", "", "isClosed", "()Z", "Lokhttp3/internal/io/a;", "fileSystem", "<init>", "(Ljava/io/File;JLokhttp3/internal/io/a;)V", "(Ljava/io/File;J)V", "Companion", "CacheResponseBody", "Entry", "RealCacheRequest", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Cache implements Closeable, Flushable {
    public static final Companion Companion = new Companion(null);
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;

    @d
    private final okhttp3.internal.cache.d cache;
    private int hitCount;
    private int networkCount;
    private int requestCount;
    private int writeAbortCount;
    private int writeSuccessCount;

    @i0(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B'\u0012\n\u0010\f\u001a\u00060\nR\u00020\u000b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00060\nR\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011¨\u0006\u0014"}, d2 = {"Lokhttp3/Cache$CacheResponseBody;", "Lokhttp3/ResponseBody;", "Lokhttp3/MediaType;", "contentType", "", "contentLength", "Lokio/o;", ShareConstants.FEED_SOURCE_PARAM, "bodySource", "Lokio/o;", "Lokhttp3/internal/cache/d$d;", "Lokhttp3/internal/cache/d;", "snapshot", "Lokhttp3/internal/cache/d$d;", "getSnapshot", "()Lokhttp3/internal/cache/d$d;", "", "Ljava/lang/String;", "<init>", "(Lokhttp3/internal/cache/d$d;Ljava/lang/String;Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    private static final class CacheResponseBody extends ResponseBody {
        private final o bodySource;
        private final String contentLength;
        private final String contentType;

        @d
        private final okhttp3.internal.cache.d.C0501d snapshot;

        public CacheResponseBody(@d okhttp3.internal.cache.d.C0501d snapshot, @e String str, @e String str2) {
            l0.p(snapshot, "snapshot");
            this.snapshot = snapshot;
            this.contentType = str;
            this.contentLength = str2;
            final o0 o0VarE = snapshot.e(1);
            this.bodySource = a0.d(new s(o0VarE) { // from class: okhttp3.Cache.CacheResponseBody.1
                @Override // okio.s, okio.o0, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    CacheResponseBody.this.getSnapshot().close();
                    super.close();
                }
            });
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            String str = this.contentLength;
            if (str != null) {
                return okhttp3.internal.d.e0(str, -1L);
            }
            return -1L;
        }

        @Override // okhttp3.ResponseBody
        @e
        public MediaType contentType() {
            String str = this.contentType;
            if (str != null) {
                return MediaType.Companion.parse(str);
            }
            return null;
        }

        @d
        public final okhttp3.internal.cache.d.C0501d getSnapshot() {
            return this.snapshot;
        }

        @Override // okhttp3.ResponseBody
        @d
        public o source() {
            return this.bodySource;
        }
    }

    @i0(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0007J\u0017\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015J\n\u0010\u0019\u001a\u00020\u0017*\u00020\u0012J\n\u0010\b\u001a\u00020\u0002*\u00020\u0012R\u0014\u0010\u001a\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001b¨\u0006!"}, d2 = {"Lokhttp3/Cache$Companion;", "", "Lokhttp3/Headers;", "", "", "varyFields", "requestHeaders", "responseHeaders", "varyHeaders", "Lokhttp3/HttpUrl;", "url", RetInfoContent.BindKEY_ISNULL, "Lokio/o;", ShareConstants.FEED_SOURCE_PARAM, "", "readInt$okhttp", "(Lokio/o;)I", "readInt", "Lokhttp3/Response;", "cachedResponse", "cachedRequest", "Lokhttp3/Request;", "newRequest", "", "varyMatches", "hasVaryAll", "ENTRY_BODY", "I", "ENTRY_COUNT", "ENTRY_METADATA", "VERSION", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        private final Set<String> varyFields(Headers headers) {
            int size = headers.size();
            TreeSet treeSet = null;
            for (int i7 = 0; i7 < size; i7++) {
                if (b0.K1(c.A0, headers.name(i7), true)) {
                    String strValue = headers.value(i7);
                    if (treeSet == null) {
                        treeSet = new TreeSet(b0.S1(s1.f34921a));
                    }
                    for (String str : c0.S4(strValue, new char[]{','}, false, 0, 6, null)) {
                        if (str == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                        treeSet.add(c0.E5(str).toString());
                    }
                }
            }
            return treeSet != null ? treeSet : n1.k();
        }

        public final boolean hasVaryAll(@d Response hasVaryAll) {
            l0.p(hasVaryAll, "$this$hasVaryAll");
            return varyFields(hasVaryAll.headers()).contains("*");
        }

        @d
        @l
        public final String key(@d HttpUrl url) {
            l0.p(url, "url");
            return p.f38508f.l(url.toString()).N().t();
        }

        public final int readInt$okhttp(@d o source) throws IOException {
            l0.p(source, "source");
            try {
                long jC0 = source.c0();
                String strX0 = source.X0();
                if (jC0 >= 0 && jC0 <= Integer.MAX_VALUE) {
                    if (!(strX0.length() > 0)) {
                        return (int) jC0;
                    }
                }
                throw new IOException("expected an int but was \"" + jC0 + strX0 + h0.f35376b);
            } catch (NumberFormatException e8) {
                throw new IOException(e8.getMessage());
            }
        }

        @d
        public final Headers varyHeaders(@d Response varyHeaders) {
            l0.p(varyHeaders, "$this$varyHeaders");
            Response responseNetworkResponse = varyHeaders.networkResponse();
            l0.m(responseNetworkResponse);
            return varyHeaders(responseNetworkResponse.request().headers(), varyHeaders.headers());
        }

        public final boolean varyMatches(@d Response cachedResponse, @d Headers cachedRequest, @d Request newRequest) {
            l0.p(cachedResponse, "cachedResponse");
            l0.p(cachedRequest, "cachedRequest");
            l0.p(newRequest, "newRequest");
            Set<String> setVaryFields = varyFields(cachedResponse.headers());
            if ((setVaryFields instanceof Collection) && setVaryFields.isEmpty()) {
                return true;
            }
            for (String str : setVaryFields) {
                if (!l0.g(cachedRequest.values(str), newRequest.headers(str))) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Companion(w wVar) {
            this();
        }

        private final Headers varyHeaders(Headers headers, Headers headers2) {
            Set<String> setVaryFields = varyFields(headers2);
            if (setVaryFields.isEmpty()) {
                return okhttp3.internal.d.f37855b;
            }
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            for (int i7 = 0; i7 < size; i7++) {
                String strName = headers.name(i7);
                if (setVaryFields.contains(strName)) {
                    builder.add(strName, headers.value(i7));
                }
            }
            return builder.build();
        }
    }

    @i0(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0011\u001a\u00060\u000fR\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0018\u0010\u0011\u001a\u00060\u000fR\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lokhttp3/Cache$RealCacheRequest;", "Lokhttp3/internal/cache/b;", "Lkotlin/l2;", "abort", "Lokio/m0;", com.paytm.pgsdk.d.V, "cacheOut", "Lokio/m0;", "", "done", "Z", "getDone", "()Z", "setDone", "(Z)V", "Lokhttp3/internal/cache/d$b;", "Lokhttp3/internal/cache/d;", "editor", "Lokhttp3/internal/cache/d$b;", "<init>", "(Lokhttp3/Cache;Lokhttp3/internal/cache/d$b;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    private final class RealCacheRequest implements okhttp3.internal.cache.b {
        private final m0 body;
        private final m0 cacheOut;
        private boolean done;
        private final okhttp3.internal.cache.d.b editor;
        final /* synthetic */ Cache this$0;

        public RealCacheRequest(@d Cache cache, okhttp3.internal.cache.d.b editor) {
            l0.p(editor, "editor");
            this.this$0 = cache;
            this.editor = editor;
            m0 m0VarF = editor.f(1);
            this.cacheOut = m0VarF;
            this.body = new r(m0VarF) { // from class: okhttp3.Cache.RealCacheRequest.1
                @Override // okio.r, okio.m0, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    synchronized (RealCacheRequest.this.this$0) {
                        if (RealCacheRequest.this.getDone()) {
                            return;
                        }
                        RealCacheRequest.this.setDone(true);
                        Cache cache2 = RealCacheRequest.this.this$0;
                        cache2.setWriteSuccessCount$okhttp(cache2.getWriteSuccessCount$okhttp() + 1);
                        super.close();
                        RealCacheRequest.this.editor.b();
                    }
                }
            };
        }

        @Override // okhttp3.internal.cache.b
        public void abort() {
            synchronized (this.this$0) {
                if (this.done) {
                    return;
                }
                this.done = true;
                Cache cache = this.this$0;
                cache.setWriteAbortCount$okhttp(cache.getWriteAbortCount$okhttp() + 1);
                okhttp3.internal.d.l(this.cacheOut);
                try {
                    this.editor.a();
                } catch (IOException unused) {
                }
            }
        }

        @Override // okhttp3.internal.cache.b
        @d
        public m0 body() {
            return this.body;
        }

        public final boolean getDone() {
            return this.done;
        }

        public final void setDone(boolean z7) {
            this.done = z7;
        }
    }

    /* JADX INFO: renamed from: okhttp3.Cache$urls$1, reason: invalid class name */
    @i0(d1 = {"\u0000'\n\u0000\n\u0002\u0010)\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0002J\t\u0010\u0005\u001a\u00020\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u001e\u0010\n\u001a\f\u0012\b\u0012\u00060\bR\u00020\t0\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"okhttp3/Cache$urls$1", "", "", "", "hasNext", "next", "Lkotlin/l2;", "remove", "Lokhttp3/internal/cache/d$d;", "Lokhttp3/internal/cache/d;", "delegate", "Ljava/util/Iterator;", "nextUrl", "Ljava/lang/String;", "canRemove", "Z", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class AnonymousClass1 implements Iterator<String>, j5.d {
        private boolean canRemove;
        private final Iterator<okhttp3.internal.cache.d.C0501d> delegate;
        private String nextUrl;

        AnonymousClass1() {
            this.delegate = Cache.this.getCache$okhttp().z1();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextUrl != null) {
                return true;
            }
            this.canRemove = false;
            while (this.delegate.hasNext()) {
                try {
                    okhttp3.internal.cache.d.C0501d next = this.delegate.next();
                    try {
                        continue;
                        this.nextUrl = a0.d(next.e(0)).X0();
                        kotlin.io.c.a(next, null);
                        return true;
                    } catch (Throwable th) {
                        try {
                            continue;
                            throw th;
                        } catch (Throwable th2) {
                            kotlin.io.c.a(next, th);
                            throw th2;
                        }
                    }
                } catch (IOException unused) {
                }
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.canRemove) {
                throw new IllegalStateException("remove() before next()".toString());
            }
            this.delegate.remove();
        }

        @Override // java.util.Iterator
        @d
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String str = this.nextUrl;
            l0.m(str);
            this.nextUrl = null;
            this.canRemove = true;
            return str;
        }
    }

    public Cache(@d File directory, long j7, @d okhttp3.internal.io.a fileSystem) {
        l0.p(directory, "directory");
        l0.p(fileSystem, "fileSystem");
        this.cache = new okhttp3.internal.cache.d(fileSystem, directory, VERSION, 2, j7, okhttp3.internal.concurrent.d.f37734h);
    }

    private final void abortQuietly(okhttp3.internal.cache.d.b bVar) {
        if (bVar != null) {
            try {
                bVar.a();
            } catch (IOException unused) {
            }
        }
    }

    @d
    @l
    public static final String key(@d HttpUrl httpUrl) {
        return Companion.key(httpUrl);
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "directory", imports = {}))
    @h(name = "-deprecated_directory")
    /* JADX INFO: renamed from: -deprecated_directory, reason: not valid java name */
    public final File m13deprecated_directory() {
        return this.cache.s0();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.cache.close();
    }

    public final void delete() throws IOException {
        this.cache.Q();
    }

    @d
    @h(name = "directory")
    public final File directory() {
        return this.cache.s0();
    }

    public final void evictAll() throws IOException {
        this.cache.o0();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.cache.flush();
    }

    @e
    public final Response get$okhttp(@d Request request) {
        l0.p(request, "request");
        try {
            okhttp3.internal.cache.d.C0501d c0501dP0 = this.cache.p0(Companion.key(request.url()));
            if (c0501dP0 != null) {
                try {
                    Entry entry = new Entry(c0501dP0.e(0));
                    Response response = entry.response(c0501dP0);
                    if (entry.matches(request, response)) {
                        return response;
                    }
                    ResponseBody responseBodyBody = response.body();
                    if (responseBodyBody != null) {
                        okhttp3.internal.d.l(responseBodyBody);
                    }
                    return null;
                } catch (IOException unused) {
                    okhttp3.internal.d.l(c0501dP0);
                }
            }
        } catch (IOException unused2) {
        }
        return null;
    }

    @d
    public final okhttp3.internal.cache.d getCache$okhttp() {
        return this.cache;
    }

    public final int getWriteAbortCount$okhttp() {
        return this.writeAbortCount;
    }

    public final int getWriteSuccessCount$okhttp() {
        return this.writeSuccessCount;
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final void initialize() throws IOException {
        this.cache.J0();
    }

    public final boolean isClosed() {
        return this.cache.isClosed();
    }

    public final long maxSize() {
        return this.cache.G0();
    }

    public final synchronized int networkCount() {
        return this.networkCount;
    }

    @e
    public final okhttp3.internal.cache.b put$okhttp(@d Response response) {
        okhttp3.internal.cache.d.b bVarL0;
        l0.p(response, "response");
        String strMethod = response.request().method();
        if (f.f37879a.a(response.request().method())) {
            try {
                remove$okhttp(response.request());
            } catch (IOException unused) {
            }
            return null;
        }
        if (!l0.g(strMethod, Const.HTTP_REQUEST_TYPE_GET)) {
            return null;
        }
        Companion companion = Companion;
        if (companion.hasVaryAll(response)) {
            return null;
        }
        Entry entry = new Entry(response);
        try {
            bVarL0 = okhttp3.internal.cache.d.l0(this.cache, companion.key(response.request().url()), 0L, 2, null);
            if (bVarL0 == null) {
                return null;
            }
            try {
                entry.writeTo(bVarL0);
                return new RealCacheRequest(this, bVarL0);
            } catch (IOException unused2) {
                abortQuietly(bVarL0);
                return null;
            }
        } catch (IOException unused3) {
            bVarL0 = null;
        }
    }

    public final void remove$okhttp(@d Request request) throws IOException {
        l0.p(request, "request");
        this.cache.d1(Companion.key(request.url()));
    }

    public final synchronized int requestCount() {
        return this.requestCount;
    }

    public final void setWriteAbortCount$okhttp(int i7) {
        this.writeAbortCount = i7;
    }

    public final void setWriteSuccessCount$okhttp(int i7) {
        this.writeSuccessCount = i7;
    }

    public final long size() throws IOException {
        return this.cache.w1();
    }

    public final synchronized void trackConditionalCacheHit$okhttp() {
        this.hitCount++;
    }

    public final synchronized void trackResponse$okhttp(@d okhttp3.internal.cache.c cacheStrategy) {
        l0.p(cacheStrategy, "cacheStrategy");
        this.requestCount++;
        if (cacheStrategy.b() != null) {
            this.networkCount++;
        } else if (cacheStrategy.a() != null) {
            this.hitCount++;
        }
    }

    public final void update$okhttp(@d Response cached, @d Response network) {
        okhttp3.internal.cache.d.b bVarB;
        l0.p(cached, "cached");
        l0.p(network, "network");
        Entry entry = new Entry(network);
        ResponseBody responseBodyBody = cached.body();
        if (responseBodyBody == null) {
            throw new NullPointerException("null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody");
        }
        try {
            bVarB = ((CacheResponseBody) responseBodyBody).getSnapshot().b();
            if (bVarB != null) {
                try {
                    entry.writeTo(bVarB);
                    bVarB.b();
                } catch (IOException unused) {
                    abortQuietly(bVarB);
                }
            }
        } catch (IOException unused2) {
            bVarB = null;
        }
    }

    @d
    public final Iterator<String> urls() throws IOException {
        return new AnonymousClass1();
    }

    public final synchronized int writeAbortCount() {
        return this.writeAbortCount;
    }

    public final synchronized int writeSuccessCount() {
        return this.writeSuccessCount;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Cache(@d File directory, long j7) {
        this(directory, j7, okhttp3.internal.io.a.f38217a);
        l0.p(directory, "directory");
    }

    @i0(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000 52\u00020\u0001:\u00015B\u0011\b\u0016\u0012\u0006\u00101\u001a\u000200¢\u0006\u0004\b2\u00103B\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b2\u00104J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0012\u0010\u000f\u001a\u00020\n2\n\u0010\u000e\u001a\u00060\fR\u00020\rJ\u0016\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012J\u0012\u0010\u0013\u001a\u00020\u00122\n\u0010\u0017\u001a\u00060\u0016R\u00020\rR\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010\u001aR\u0014\u0010&\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010\u001dR\u0016\u0010(\u001a\u0004\u0018\u00010'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010,R\u0014\u0010.\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00066"}, d2 = {"Lokhttp3/Cache$Entry;", "", "Lokio/o;", ShareConstants.FEED_SOURCE_PARAM, "", "Ljava/security/cert/Certificate;", "readCertificateList", "Lokio/n;", "sink", "certificates", "Lkotlin/l2;", "writeCertList", "Lokhttp3/internal/cache/d$b;", "Lokhttp3/internal/cache/d;", "editor", "writeTo", "Lokhttp3/Request;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lokhttp3/Response;", "response", "", "matches", "Lokhttp3/internal/cache/d$d;", "snapshot", "", "url", "Ljava/lang/String;", "Lokhttp3/Headers;", "varyHeaders", "Lokhttp3/Headers;", "requestMethod", "Lokhttp3/Protocol;", "protocol", "Lokhttp3/Protocol;", "", "code", "I", ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "responseHeaders", "Lokhttp3/Handshake;", "handshake", "Lokhttp3/Handshake;", "", "sentRequestMillis", "J", "receivedResponseMillis", "isHttps", "()Z", "Lokio/o0;", "rawSource", "<init>", "(Lokio/o0;)V", "(Lokhttp3/Response;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
    private static final class Entry {
        public static final Companion Companion = new Companion(null);
        private static final String RECEIVED_MILLIS;
        private static final String SENT_MILLIS;
        private final int code;
        private final Handshake handshake;
        private final String message;
        private final Protocol protocol;
        private final long receivedResponseMillis;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final long sentRequestMillis;
        private final String url;
        private final Headers varyHeaders;

        @i0(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lokhttp3/Cache$Entry$Companion;", "", "()V", "RECEIVED_MILLIS", "", "SENT_MILLIS", "okhttp"}, k = 1, mv = {1, 4, 0})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(w wVar) {
                this();
            }
        }

        static {
            StringBuilder sb = new StringBuilder();
            okhttp3.internal.platform.k.a aVar = okhttp3.internal.platform.k.f38284e;
            sb.append(aVar.g().i());
            sb.append("-Sent-Millis");
            SENT_MILLIS = sb.toString();
            RECEIVED_MILLIS = aVar.g().i() + "-Received-Millis";
        }

        public Entry(@d o0 rawSource) throws IOException {
            l0.p(rawSource, "rawSource");
            try {
                o oVarD = a0.d(rawSource);
                this.url = oVarD.X0();
                this.requestMethod = oVarD.X0();
                Headers.Builder builder = new Headers.Builder();
                int int$okhttp = Cache.Companion.readInt$okhttp(oVarD);
                for (int i7 = 0; i7 < int$okhttp; i7++) {
                    builder.addLenient$okhttp(oVarD.X0());
                }
                this.varyHeaders = builder.build();
                okhttp3.internal.http.k kVarB = okhttp3.internal.http.k.f37900h.b(oVarD.X0());
                this.protocol = kVarB.f37901a;
                this.code = kVarB.f37902b;
                this.message = kVarB.f37903c;
                Headers.Builder builder2 = new Headers.Builder();
                int int$okhttp2 = Cache.Companion.readInt$okhttp(oVarD);
                for (int i8 = 0; i8 < int$okhttp2; i8++) {
                    builder2.addLenient$okhttp(oVarD.X0());
                }
                String str = SENT_MILLIS;
                String str2 = builder2.get(str);
                String str3 = RECEIVED_MILLIS;
                String str4 = builder2.get(str3);
                builder2.removeAll(str);
                builder2.removeAll(str3);
                this.sentRequestMillis = str2 != null ? Long.parseLong(str2) : 0L;
                this.receivedResponseMillis = str4 != null ? Long.parseLong(str4) : 0L;
                this.responseHeaders = builder2.build();
                if (isHttps()) {
                    String strX0 = oVarD.X0();
                    if (strX0.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + strX0 + h0.f35376b);
                    }
                    this.handshake = Handshake.Companion.get(!oVarD.N() ? TlsVersion.Companion.forJavaName(oVarD.X0()) : TlsVersion.SSL_3_0, CipherSuite.Companion.forJavaName(oVarD.X0()), readCertificateList(oVarD), readCertificateList(oVarD));
                } else {
                    this.handshake = null;
                }
                rawSource.close();
            } catch (Throwable th) {
                rawSource.close();
                throw th;
            }
        }

        private final boolean isHttps() {
            return b0.u2(this.url, "https://", false, 2, null);
        }

        private final List<Certificate> readCertificateList(o oVar) throws IOException {
            int int$okhttp = Cache.Companion.readInt$okhttp(oVar);
            if (int$okhttp == -1) {
                return y.F();
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(int$okhttp);
                for (int i7 = 0; i7 < int$okhttp; i7++) {
                    String strX0 = oVar.X0();
                    okio.m mVar = new okio.m();
                    p pVarH = p.f38508f.h(strX0);
                    l0.m(pVarH);
                    mVar.p1(pVarH);
                    arrayList.add(certificateFactory.generateCertificate(mVar.S1()));
                }
                return arrayList;
            } catch (CertificateException e8) {
                throw new IOException(e8.getMessage());
            }
        }

        private final void writeCertList(n nVar, List<? extends Certificate> list) throws IOException {
            try {
                nVar.H1(list.size()).writeByte(10);
                int size = list.size();
                for (int i7 = 0; i7 < size; i7++) {
                    byte[] bytes = list.get(i7).getEncoded();
                    p.a aVar = p.f38508f;
                    l0.o(bytes, "bytes");
                    nVar.q0(p.a.p(aVar, bytes, 0, 0, 3, null).d()).writeByte(10);
                }
            } catch (CertificateEncodingException e8) {
                throw new IOException(e8.getMessage());
            }
        }

        public final boolean matches(@d Request request, @d Response response) {
            l0.p(request, "request");
            l0.p(response, "response");
            return l0.g(this.url, request.url().toString()) && l0.g(this.requestMethod, request.method()) && Cache.Companion.varyMatches(response, this.varyHeaders, request);
        }

        @d
        public final Response response(@d okhttp3.internal.cache.d.C0501d snapshot) {
            l0.p(snapshot, "snapshot");
            String str = this.responseHeaders.get("Content-Type");
            String str2 = this.responseHeaders.get(c.f22134b);
            return new Response.Builder().request(new Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build()).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(snapshot, str, str2)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }

        public final void writeTo(@d okhttp3.internal.cache.d.b editor) throws IOException {
            l0.p(editor, "editor");
            n nVarC = a0.c(editor.f(0));
            try {
                nVarC.q0(this.url).writeByte(10);
                nVarC.q0(this.requestMethod).writeByte(10);
                nVarC.H1(this.varyHeaders.size()).writeByte(10);
                int size = this.varyHeaders.size();
                for (int i7 = 0; i7 < size; i7++) {
                    nVarC.q0(this.varyHeaders.name(i7)).q0(": ").q0(this.varyHeaders.value(i7)).writeByte(10);
                }
                nVarC.q0(new okhttp3.internal.http.k(this.protocol, this.code, this.message).toString()).writeByte(10);
                nVarC.H1(this.responseHeaders.size() + 2).writeByte(10);
                int size2 = this.responseHeaders.size();
                for (int i8 = 0; i8 < size2; i8++) {
                    nVarC.q0(this.responseHeaders.name(i8)).q0(": ").q0(this.responseHeaders.value(i8)).writeByte(10);
                }
                nVarC.q0(SENT_MILLIS).q0(": ").H1(this.sentRequestMillis).writeByte(10);
                nVarC.q0(RECEIVED_MILLIS).q0(": ").H1(this.receivedResponseMillis).writeByte(10);
                if (isHttps()) {
                    nVarC.writeByte(10);
                    Handshake handshake = this.handshake;
                    l0.m(handshake);
                    nVarC.q0(handshake.cipherSuite().javaName()).writeByte(10);
                    writeCertList(nVarC, this.handshake.peerCertificates());
                    writeCertList(nVarC, this.handshake.localCertificates());
                    nVarC.q0(this.handshake.tlsVersion().javaName()).writeByte(10);
                }
                l2 l2Var = l2.f34958a;
                kotlin.io.c.a(nVarC, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    kotlin.io.c.a(nVarC, th);
                    throw th2;
                }
            }
        }

        public Entry(@d Response response) {
            l0.p(response, "response");
            this.url = response.request().url().toString();
            this.varyHeaders = Cache.Companion.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
            this.sentRequestMillis = response.sentRequestAtMillis();
            this.receivedResponseMillis = response.receivedResponseAtMillis();
        }
    }
}
