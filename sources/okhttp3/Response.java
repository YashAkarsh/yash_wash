package okhttp3;

import a7.e;
import com.facebook.share.internal.ShareConstants;
import com.paytm.pgsdk.d;
import h5.h;
import h5.i;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import kotlin.b1;
import kotlin.collections.y;
import kotlin.i0;
import kotlin.jvm.internal.l0;
import kotlin.k;
import kotlin.m;
import okhttp3.internal.connection.c;
import okio.o;

/* JADX INFO: loaded from: classes3.dex */
@i0(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001RB}\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\n\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u001b\u0012\b\u0010%\u001a\u0004\u0018\u00010!\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u00107\u001a\u00020\u001f\u0012\u0006\u00109\u001a\u00020\u001f\u0012\b\u0010I\u001a\u0004\u0018\u00010H¢\u0006\u0004\bP\u0010QJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0011\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00172\u0006\u0010\u0016\u001a\u00020\u000eJ\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\u000e2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0007J\u000f\u0010\u0018\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u001bJ\u000e\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fJ\u0011\u0010%\u001a\u0004\u0018\u00010!H\u0007¢\u0006\u0004\b#\u0010$J\u0006\u0010'\u001a\u00020&J\u0011\u0010*\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b(\u0010)J\u0011\u0010,\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b+\u0010)J\u0011\u0010.\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b-\u0010)J\f\u00100\u001a\b\u0012\u0004\u0012\u00020/0\u0017J\u000f\u00104\u001a\u000201H\u0007¢\u0006\u0004\b2\u00103J\u000f\u00107\u001a\u00020\u001fH\u0007¢\u0006\u0004\b5\u00106J\u000f\u00109\u001a\u00020\u001fH\u0007¢\u0006\u0004\b8\u00106J\b\u0010;\u001a\u00020:H\u0016J\b\u0010<\u001a\u00020\u000eH\u0016R\u0018\u0010=\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010?\u001a\u0004\b\u0005\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\t\u0010@\u001a\u0004\b\t\u0010\bR\u0017\u0010\u0011\u001a\u00020\u000e8\u0007¢\u0006\f\n\u0004\b\u0011\u0010A\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\r\u001a\u00020\n8\u0007¢\u0006\f\n\u0004\b\r\u0010B\u001a\u0004\b\r\u0010\fR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0007¢\u0006\f\n\u0004\b\u0015\u0010C\u001a\u0004\b\u0015\u0010\u0014R\u0017\u0010\u0018\u001a\u00020\u001b8\u0007¢\u0006\f\n\u0004\b\u0018\u0010D\u001a\u0004\b\u0018\u0010\u001dR\u0019\u0010%\u001a\u0004\u0018\u00010!8\u0007¢\u0006\f\n\u0004\b%\u0010E\u001a\u0004\b%\u0010$R\u0019\u0010*\u001a\u0004\u0018\u00010\u00008\u0007¢\u0006\f\n\u0004\b*\u0010F\u001a\u0004\b*\u0010)R\u0019\u0010,\u001a\u0004\u0018\u00010\u00008\u0007¢\u0006\f\n\u0004\b,\u0010F\u001a\u0004\b,\u0010)R\u0019\u0010.\u001a\u0004\u0018\u00010\u00008\u0007¢\u0006\f\n\u0004\b.\u0010F\u001a\u0004\b.\u0010)R\u0017\u00107\u001a\u00020\u001f8\u0007¢\u0006\f\n\u0004\b7\u0010G\u001a\u0004\b7\u00106R\u0017\u00109\u001a\u00020\u001f8\u0007¢\u0006\f\n\u0004\b9\u0010G\u001a\u0004\b9\u00106R\u001c\u0010I\u001a\u0004\u0018\u00010H8\u0001X\u0080\u0004¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bI\u0010KR\u0011\u0010M\u001a\u00020L8F¢\u0006\u0006\u001a\u0004\bM\u0010NR\u0011\u0010O\u001a\u00020L8F¢\u0006\u0006\u001a\u0004\bO\u0010NR\u0011\u00104\u001a\u0002018G¢\u0006\u0006\u001a\u0004\b4\u00103¨\u0006S"}, d2 = {"Lokhttp3/Response;", "Ljava/io/Closeable;", "Lokhttp3/Request;", "-deprecated_request", "()Lokhttp3/Request;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lokhttp3/Protocol;", "-deprecated_protocol", "()Lokhttp3/Protocol;", "protocol", "", "-deprecated_code", "()I", "code", "", "-deprecated_message", "()Ljava/lang/String;", ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "Lokhttp3/Handshake;", "-deprecated_handshake", "()Lokhttp3/Handshake;", "handshake", "name", "", "headers", "defaultValue", "header", "Lokhttp3/Headers;", "-deprecated_headers", "()Lokhttp3/Headers;", "trailers", "", "byteCount", "Lokhttp3/ResponseBody;", "peekBody", "-deprecated_body", "()Lokhttp3/ResponseBody;", d.V, "Lokhttp3/Response$Builder;", "newBuilder", "-deprecated_networkResponse", "()Lokhttp3/Response;", "networkResponse", "-deprecated_cacheResponse", "cacheResponse", "-deprecated_priorResponse", "priorResponse", "Lokhttp3/Challenge;", "challenges", "Lokhttp3/CacheControl;", "-deprecated_cacheControl", "()Lokhttp3/CacheControl;", "cacheControl", "-deprecated_sentRequestAtMillis", "()J", "sentRequestAtMillis", "-deprecated_receivedResponseAtMillis", "receivedResponseAtMillis", "Lkotlin/l2;", "close", "toString", "lazyCacheControl", "Lokhttp3/CacheControl;", "Lokhttp3/Request;", "Lokhttp3/Protocol;", "Ljava/lang/String;", "I", "Lokhttp3/Handshake;", "Lokhttp3/Headers;", "Lokhttp3/ResponseBody;", "Lokhttp3/Response;", "J", "Lokhttp3/internal/connection/c;", "exchange", "Lokhttp3/internal/connection/c;", "()Lokhttp3/internal/connection/c;", "", "isSuccessful", "()Z", "isRedirect", "<init>", "(Lokhttp3/Request;Lokhttp3/Protocol;Ljava/lang/String;ILokhttp3/Handshake;Lokhttp3/Headers;Lokhttp3/ResponseBody;Lokhttp3/Response;Lokhttp3/Response;Lokhttp3/Response;JJLokhttp3/internal/connection/c;)V", "Builder", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Response implements Closeable {

    @e
    private final ResponseBody body;

    @e
    private final Response cacheResponse;
    private final int code;

    @e
    private final c exchange;

    @e
    private final Handshake handshake;

    @a7.d
    private final Headers headers;
    private CacheControl lazyCacheControl;

    @a7.d
    private final String message;

    @e
    private final Response networkResponse;

    @e
    private final Response priorResponse;

    @a7.d
    private final Protocol protocol;
    private final long receivedResponseAtMillis;

    @a7.d
    private final Request request;
    private final long sentRequestAtMillis;

    public Response(@a7.d Request request, @a7.d Protocol protocol, @a7.d String message, int i7, @e Handshake handshake, @a7.d Headers headers, @e ResponseBody responseBody, @e Response response, @e Response response2, @e Response response3, long j7, long j8, @e c cVar) {
        l0.p(request, "request");
        l0.p(protocol, "protocol");
        l0.p(message, "message");
        l0.p(headers, "headers");
        this.request = request;
        this.protocol = protocol;
        this.message = message;
        this.code = i7;
        this.handshake = handshake;
        this.headers = headers;
        this.body = responseBody;
        this.networkResponse = response;
        this.cacheResponse = response2;
        this.priorResponse = response3;
        this.sentRequestAtMillis = j7;
        this.receivedResponseAtMillis = j8;
        this.exchange = cVar;
    }

    public static /* synthetic */ String header$default(Response response, String str, String str2, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            str2 = null;
        }
        return response.header(str, str2);
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = d.V, imports = {}))
    @e
    @h(name = "-deprecated_body")
    /* JADX INFO: renamed from: -deprecated_body, reason: not valid java name */
    public final ResponseBody m119deprecated_body() {
        return this.body;
    }

    @a7.d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "cacheControl", imports = {}))
    @h(name = "-deprecated_cacheControl")
    /* JADX INFO: renamed from: -deprecated_cacheControl, reason: not valid java name */
    public final CacheControl m120deprecated_cacheControl() {
        return cacheControl();
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "cacheResponse", imports = {}))
    @e
    @h(name = "-deprecated_cacheResponse")
    /* JADX INFO: renamed from: -deprecated_cacheResponse, reason: not valid java name */
    public final Response m121deprecated_cacheResponse() {
        return this.cacheResponse;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "code", imports = {}))
    @h(name = "-deprecated_code")
    /* JADX INFO: renamed from: -deprecated_code, reason: not valid java name */
    public final int m122deprecated_code() {
        return this.code;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "handshake", imports = {}))
    @e
    @h(name = "-deprecated_handshake")
    /* JADX INFO: renamed from: -deprecated_handshake, reason: not valid java name */
    public final Handshake m123deprecated_handshake() {
        return this.handshake;
    }

    @a7.d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "headers", imports = {}))
    @h(name = "-deprecated_headers")
    /* JADX INFO: renamed from: -deprecated_headers, reason: not valid java name */
    public final Headers m124deprecated_headers() {
        return this.headers;
    }

    @a7.d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = ShareConstants.WEB_DIALOG_PARAM_MESSAGE, imports = {}))
    @h(name = "-deprecated_message")
    /* JADX INFO: renamed from: -deprecated_message, reason: not valid java name */
    public final String m125deprecated_message() {
        return this.message;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "networkResponse", imports = {}))
    @e
    @h(name = "-deprecated_networkResponse")
    /* JADX INFO: renamed from: -deprecated_networkResponse, reason: not valid java name */
    public final Response m126deprecated_networkResponse() {
        return this.networkResponse;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "priorResponse", imports = {}))
    @e
    @h(name = "-deprecated_priorResponse")
    /* JADX INFO: renamed from: -deprecated_priorResponse, reason: not valid java name */
    public final Response m127deprecated_priorResponse() {
        return this.priorResponse;
    }

    @a7.d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "protocol", imports = {}))
    @h(name = "-deprecated_protocol")
    /* JADX INFO: renamed from: -deprecated_protocol, reason: not valid java name */
    public final Protocol m128deprecated_protocol() {
        return this.protocol;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "receivedResponseAtMillis", imports = {}))
    @h(name = "-deprecated_receivedResponseAtMillis")
    /* JADX INFO: renamed from: -deprecated_receivedResponseAtMillis, reason: not valid java name */
    public final long m129deprecated_receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    @a7.d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, imports = {}))
    @h(name = "-deprecated_request")
    /* JADX INFO: renamed from: -deprecated_request, reason: not valid java name */
    public final Request m130deprecated_request() {
        return this.request;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "sentRequestAtMillis", imports = {}))
    @h(name = "-deprecated_sentRequestAtMillis")
    /* JADX INFO: renamed from: -deprecated_sentRequestAtMillis, reason: not valid java name */
    public final long m131deprecated_sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    @e
    @h(name = d.V)
    public final ResponseBody body() {
        return this.body;
    }

    @a7.d
    @h(name = "cacheControl")
    public final CacheControl cacheControl() {
        CacheControl cacheControl = this.lazyCacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl cacheControl2 = CacheControl.Companion.parse(this.headers);
        this.lazyCacheControl = cacheControl2;
        return cacheControl2;
    }

    @e
    @h(name = "cacheResponse")
    public final Response cacheResponse() {
        return this.cacheResponse;
    }

    @a7.d
    public final List<Challenge> challenges() {
        String str;
        Headers headers = this.headers;
        int i7 = this.code;
        if (i7 == 401) {
            str = com.google.common.net.c.B0;
        } else {
            if (i7 != 407) {
                return y.F();
            }
            str = com.google.common.net.c.f22161o0;
        }
        return okhttp3.internal.http.e.b(headers, str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ResponseBody responseBody = this.body;
        if (responseBody == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed".toString());
        }
        responseBody.close();
    }

    @h(name = "code")
    public final int code() {
        return this.code;
    }

    @e
    @h(name = "exchange")
    public final c exchange() {
        return this.exchange;
    }

    @e
    @h(name = "handshake")
    public final Handshake handshake() {
        return this.handshake;
    }

    @i
    @e
    public final String header(@a7.d String str) {
        return header$default(this, str, null, 2, null);
    }

    @a7.d
    @h(name = "headers")
    public final Headers headers() {
        return this.headers;
    }

    public final boolean isRedirect() {
        int i7 = this.code;
        if (i7 != 307 && i7 != 308) {
            switch (i7) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public final boolean isSuccessful() {
        int i7 = this.code;
        return 200 <= i7 && 299 >= i7;
    }

    @a7.d
    @h(name = ShareConstants.WEB_DIALOG_PARAM_MESSAGE)
    public final String message() {
        return this.message;
    }

    @e
    @h(name = "networkResponse")
    public final Response networkResponse() {
        return this.networkResponse;
    }

    @a7.d
    public final Builder newBuilder() {
        return new Builder(this);
    }

    @a7.d
    public final ResponseBody peekBody(long j7) throws IOException {
        ResponseBody responseBody = this.body;
        l0.m(responseBody);
        o oVarPeek = responseBody.source().peek();
        okio.m mVar = new okio.m();
        oVarPeek.K0(j7);
        mVar.O0(oVarPeek, Math.min(j7, oVarPeek.p().B1()));
        return ResponseBody.Companion.create(mVar, this.body.contentType(), mVar.B1());
    }

    @e
    @h(name = "priorResponse")
    public final Response priorResponse() {
        return this.priorResponse;
    }

    @a7.d
    @h(name = "protocol")
    public final Protocol protocol() {
        return this.protocol;
    }

    @h(name = "receivedResponseAtMillis")
    public final long receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    @a7.d
    @h(name = ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID)
    public final Request request() {
        return this.request;
    }

    @h(name = "sentRequestAtMillis")
    public final long sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    @a7.d
    public String toString() {
        return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.url() + '}';
    }

    @a7.d
    public final Headers trailers() throws IOException {
        c cVar = this.exchange;
        if (cVar != null) {
            return cVar.u();
        }
        throw new IllegalStateException("trailers not available".toString());
    }

    @i
    @e
    public final String header(@a7.d String name, @e String str) {
        l0.p(name, "name");
        String str2 = this.headers.get(name);
        return str2 != null ? str2 : str;
    }

    @a7.d
    public final List<String> headers(@a7.d String name) {
        l0.p(name, "name");
        return this.headers.values(name);
    }

    @i0(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\"\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b_\u0010`B\u0011\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b_\u0010NJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0012\u0010\u0011\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u0018\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0012\u0010\u0019\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001a\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u001b\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u001c\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001dH\u0016J\u0017\u0010$\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 H\u0000¢\u0006\u0004\b\"\u0010#J\b\u0010%\u001a\u00020\u0004H\u0016R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\n\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\f\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u0010\u000e\u001a\u00020\r8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000e\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000f\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010\u0017\u001a\u00020?8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR$\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR$\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010J\u001a\u0004\bO\u0010L\"\u0004\bP\u0010NR$\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010J\u001a\u0004\bQ\u0010L\"\u0004\bR\u0010NR\"\u0010\u001e\u001a\u00020\u001d8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010\u001f\u001a\u00020\u001d8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010S\u001a\u0004\bX\u0010U\"\u0004\bY\u0010WR$\u0010Z\u001a\u0004\u0018\u00010 8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010#¨\u0006a"}, d2 = {"Lokhttp3/Response$Builder;", "", "", "name", "Lokhttp3/Response;", "response", "Lkotlin/l2;", "checkSupportResponse", "checkPriorResponse", "Lokhttp3/Request;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lokhttp3/Protocol;", "protocol", "", "code", ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "Lokhttp3/Handshake;", "handshake", "value", "header", "addHeader", "removeHeader", "Lokhttp3/Headers;", "headers", "Lokhttp3/ResponseBody;", d.V, "networkResponse", "cacheResponse", "priorResponse", "", "sentRequestAtMillis", "receivedResponseAtMillis", "Lokhttp3/internal/connection/c;", "deferredTrailers", "initExchange$okhttp", "(Lokhttp3/internal/connection/c;)V", "initExchange", "build", "Lokhttp3/Request;", "getRequest$okhttp", "()Lokhttp3/Request;", "setRequest$okhttp", "(Lokhttp3/Request;)V", "Lokhttp3/Protocol;", "getProtocol$okhttp", "()Lokhttp3/Protocol;", "setProtocol$okhttp", "(Lokhttp3/Protocol;)V", "I", "getCode$okhttp", "()I", "setCode$okhttp", "(I)V", "Ljava/lang/String;", "getMessage$okhttp", "()Ljava/lang/String;", "setMessage$okhttp", "(Ljava/lang/String;)V", "Lokhttp3/Handshake;", "getHandshake$okhttp", "()Lokhttp3/Handshake;", "setHandshake$okhttp", "(Lokhttp3/Handshake;)V", "Lokhttp3/Headers$Builder;", "Lokhttp3/Headers$Builder;", "getHeaders$okhttp", "()Lokhttp3/Headers$Builder;", "setHeaders$okhttp", "(Lokhttp3/Headers$Builder;)V", "Lokhttp3/ResponseBody;", "getBody$okhttp", "()Lokhttp3/ResponseBody;", "setBody$okhttp", "(Lokhttp3/ResponseBody;)V", "Lokhttp3/Response;", "getNetworkResponse$okhttp", "()Lokhttp3/Response;", "setNetworkResponse$okhttp", "(Lokhttp3/Response;)V", "getCacheResponse$okhttp", "setCacheResponse$okhttp", "getPriorResponse$okhttp", "setPriorResponse$okhttp", "J", "getSentRequestAtMillis$okhttp", "()J", "setSentRequestAtMillis$okhttp", "(J)V", "getReceivedResponseAtMillis$okhttp", "setReceivedResponseAtMillis$okhttp", "exchange", "Lokhttp3/internal/connection/c;", "getExchange$okhttp", "()Lokhttp3/internal/connection/c;", "setExchange$okhttp", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static class Builder {

        @e
        private ResponseBody body;

        @e
        private Response cacheResponse;
        private int code;

        @e
        private c exchange;

        @e
        private Handshake handshake;

        @a7.d
        private Headers.Builder headers;

        @e
        private String message;

        @e
        private Response networkResponse;

        @e
        private Response priorResponse;

        @e
        private Protocol protocol;
        private long receivedResponseAtMillis;

        @e
        private Request request;
        private long sentRequestAtMillis;

        public Builder() {
            this.code = -1;
            this.headers = new Headers.Builder();
        }

        private final void checkPriorResponse(Response response) {
            if (response != null) {
                if (!(response.body() == null)) {
                    throw new IllegalArgumentException("priorResponse.body != null".toString());
                }
            }
        }

        private final void checkSupportResponse(String str, Response response) {
            if (response != null) {
                if (!(response.body() == null)) {
                    throw new IllegalArgumentException((str + ".body != null").toString());
                }
                if (!(response.networkResponse() == null)) {
                    throw new IllegalArgumentException((str + ".networkResponse != null").toString());
                }
                if (!(response.cacheResponse() == null)) {
                    throw new IllegalArgumentException((str + ".cacheResponse != null").toString());
                }
                if (response.priorResponse() == null) {
                    return;
                }
                throw new IllegalArgumentException((str + ".priorResponse != null").toString());
            }
        }

        @a7.d
        public Builder addHeader(@a7.d String name, @a7.d String value) {
            l0.p(name, "name");
            l0.p(value, "value");
            this.headers.add(name, value);
            return this;
        }

        @a7.d
        public Builder body(@e ResponseBody responseBody) {
            this.body = responseBody;
            return this;
        }

        @a7.d
        public Response build() {
            int i7 = this.code;
            if (!(i7 >= 0)) {
                throw new IllegalStateException(("code < 0: " + this.code).toString());
            }
            Request request = this.request;
            if (request == null) {
                throw new IllegalStateException("request == null".toString());
            }
            Protocol protocol = this.protocol;
            if (protocol == null) {
                throw new IllegalStateException("protocol == null".toString());
            }
            String str = this.message;
            if (str != null) {
                return new Response(request, protocol, str, i7, this.handshake, this.headers.build(), this.body, this.networkResponse, this.cacheResponse, this.priorResponse, this.sentRequestAtMillis, this.receivedResponseAtMillis, this.exchange);
            }
            throw new IllegalStateException("message == null".toString());
        }

        @a7.d
        public Builder cacheResponse(@e Response response) {
            checkSupportResponse("cacheResponse", response);
            this.cacheResponse = response;
            return this;
        }

        @a7.d
        public Builder code(int i7) {
            this.code = i7;
            return this;
        }

        @e
        public final ResponseBody getBody$okhttp() {
            return this.body;
        }

        @e
        public final Response getCacheResponse$okhttp() {
            return this.cacheResponse;
        }

        public final int getCode$okhttp() {
            return this.code;
        }

        @e
        public final c getExchange$okhttp() {
            return this.exchange;
        }

        @e
        public final Handshake getHandshake$okhttp() {
            return this.handshake;
        }

        @a7.d
        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        @e
        public final String getMessage$okhttp() {
            return this.message;
        }

        @e
        public final Response getNetworkResponse$okhttp() {
            return this.networkResponse;
        }

        @e
        public final Response getPriorResponse$okhttp() {
            return this.priorResponse;
        }

        @e
        public final Protocol getProtocol$okhttp() {
            return this.protocol;
        }

        public final long getReceivedResponseAtMillis$okhttp() {
            return this.receivedResponseAtMillis;
        }

        @e
        public final Request getRequest$okhttp() {
            return this.request;
        }

        public final long getSentRequestAtMillis$okhttp() {
            return this.sentRequestAtMillis;
        }

        @a7.d
        public Builder handshake(@e Handshake handshake) {
            this.handshake = handshake;
            return this;
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

        public final void initExchange$okhttp(@a7.d c deferredTrailers) {
            l0.p(deferredTrailers, "deferredTrailers");
            this.exchange = deferredTrailers;
        }

        @a7.d
        public Builder message(@a7.d String message) {
            l0.p(message, "message");
            this.message = message;
            return this;
        }

        @a7.d
        public Builder networkResponse(@e Response response) {
            checkSupportResponse("networkResponse", response);
            this.networkResponse = response;
            return this;
        }

        @a7.d
        public Builder priorResponse(@e Response response) {
            checkPriorResponse(response);
            this.priorResponse = response;
            return this;
        }

        @a7.d
        public Builder protocol(@a7.d Protocol protocol) {
            l0.p(protocol, "protocol");
            this.protocol = protocol;
            return this;
        }

        @a7.d
        public Builder receivedResponseAtMillis(long j7) {
            this.receivedResponseAtMillis = j7;
            return this;
        }

        @a7.d
        public Builder removeHeader(@a7.d String name) {
            l0.p(name, "name");
            this.headers.removeAll(name);
            return this;
        }

        @a7.d
        public Builder request(@a7.d Request request) {
            l0.p(request, "request");
            this.request = request;
            return this;
        }

        @a7.d
        public Builder sentRequestAtMillis(long j7) {
            this.sentRequestAtMillis = j7;
            return this;
        }

        public final void setBody$okhttp(@e ResponseBody responseBody) {
            this.body = responseBody;
        }

        public final void setCacheResponse$okhttp(@e Response response) {
            this.cacheResponse = response;
        }

        public final void setCode$okhttp(int i7) {
            this.code = i7;
        }

        public final void setExchange$okhttp(@e c cVar) {
            this.exchange = cVar;
        }

        public final void setHandshake$okhttp(@e Handshake handshake) {
            this.handshake = handshake;
        }

        public final void setHeaders$okhttp(@a7.d Headers.Builder builder) {
            l0.p(builder, "<set-?>");
            this.headers = builder;
        }

        public final void setMessage$okhttp(@e String str) {
            this.message = str;
        }

        public final void setNetworkResponse$okhttp(@e Response response) {
            this.networkResponse = response;
        }

        public final void setPriorResponse$okhttp(@e Response response) {
            this.priorResponse = response;
        }

        public final void setProtocol$okhttp(@e Protocol protocol) {
            this.protocol = protocol;
        }

        public final void setReceivedResponseAtMillis$okhttp(long j7) {
            this.receivedResponseAtMillis = j7;
        }

        public final void setRequest$okhttp(@e Request request) {
            this.request = request;
        }

        public final void setSentRequestAtMillis$okhttp(long j7) {
            this.sentRequestAtMillis = j7;
        }

        public Builder(@a7.d Response response) {
            l0.p(response, "response");
            this.code = -1;
            this.request = response.request();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.handshake = response.handshake();
            this.headers = response.headers().newBuilder();
            this.body = response.body();
            this.networkResponse = response.networkResponse();
            this.cacheResponse = response.cacheResponse();
            this.priorResponse = response.priorResponse();
            this.sentRequestAtMillis = response.sentRequestAtMillis();
            this.receivedResponseAtMillis = response.receivedResponseAtMillis();
            this.exchange = response.exchange();
        }
    }
}
