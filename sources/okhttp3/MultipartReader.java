package okhttp3;

import a7.d;
import a7.e;
import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.share.internal.ShareConstants;
import h5.h;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.i0;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import okio.a0;
import okio.d0;
import okio.m;
import okio.o;
import okio.o0;
import okio.p;
import okio.q0;

/* JADX INFO: loaded from: classes3.dex */
@i0(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0003#$%B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001e\u0010\u001fB\u0011\b\u0016\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\u001e\u0010\"J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u001c\u0010\u0015\u001a\b\u0018\u00010\u0014R\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001b\u001a\u00020\u001a8\u0007¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001d¨\u0006&"}, d2 = {"Lokhttp3/MultipartReader;", "Ljava/io/Closeable;", "", "maxResult", "currentPartBytesRemaining", "Lokhttp3/MultipartReader$Part;", "nextPart", "Lkotlin/l2;", "close", "Lokio/p;", "dashDashBoundary", "Lokio/p;", "crlfDashDashBoundary", "", "partCount", "I", "", "closed", "Z", "noMoreParts", "Lokhttp3/MultipartReader$PartSource;", "currentPart", "Lokhttp3/MultipartReader$PartSource;", "Lokio/o;", ShareConstants.FEED_SOURCE_PARAM, "Lokio/o;", "", "boundary", "Ljava/lang/String;", "()Ljava/lang/String;", "<init>", "(Lokio/o;Ljava/lang/String;)V", "Lokhttp3/ResponseBody;", "response", "(Lokhttp3/ResponseBody;)V", "Companion", "Part", "PartSource", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class MultipartReader implements Closeable {
    public static final Companion Companion = new Companion(null);

    @d
    private static final d0 afterBoundaryOptions;

    @d
    private final String boundary;
    private boolean closed;
    private final p crlfDashDashBoundary;
    private PartSource currentPart;
    private final p dashDashBoundary;
    private boolean noMoreParts;
    private int partCount;
    private final o source;

    @i0(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lokhttp3/MultipartReader$Companion;", "", "Lokio/d0;", "afterBoundaryOptions", "Lokio/d0;", "getAfterBoundaryOptions", "()Lokio/d0;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        @d
        public final d0 getAfterBoundaryOptions() {
            return MultipartReader.afterBoundaryOptions;
        }

        public /* synthetic */ Companion(w wVar) {
            this();
        }
    }

    @i0(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0001R\u0017\u0010\u0005\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0017\u0010\t\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b¨\u0006\u000e"}, d2 = {"Lokhttp3/MultipartReader$Part;", "Ljava/io/Closeable;", "Lkotlin/l2;", "close", "Lokhttp3/Headers;", "headers", "Lokhttp3/Headers;", "()Lokhttp3/Headers;", "Lokio/o;", com.paytm.pgsdk.d.V, "Lokio/o;", "()Lokio/o;", "<init>", "(Lokhttp3/Headers;Lokio/o;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Part implements Closeable {

        @d
        private final o body;

        @d
        private final Headers headers;

        public Part(@d Headers headers, @d o body) {
            l0.p(headers, "headers");
            l0.p(body, "body");
            this.headers = headers;
            this.body = body;
        }

        @d
        @h(name = com.paytm.pgsdk.d.V)
        public final o body() {
            return this.body;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.body.close();
        }

        @d
        @h(name = "headers")
        public final Headers headers() {
            return this.headers;
        }
    }

    @i0(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lokhttp3/MultipartReader$PartSource;", "Lokio/o0;", "Lkotlin/l2;", "close", "Lokio/m;", "sink", "", "byteCount", "read", "Lokio/q0;", com.alipay.sdk.data.a.f13674p, "Lokio/q0;", "<init>", "(Lokhttp3/MultipartReader;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    private final class PartSource implements o0 {
        private final q0 timeout = new q0();

        public PartSource() {
        }

        @Override // okio.o0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (l0.g(MultipartReader.this.currentPart, this)) {
                MultipartReader.this.currentPart = null;
            }
        }

        @Override // okio.o0
        public long read(@d m sink, long j7) {
            l0.p(sink, "sink");
            if (!(j7 >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + j7).toString());
            }
            if (!l0.g(MultipartReader.this.currentPart, this)) {
                throw new IllegalStateException("closed".toString());
            }
            q0 q0VarTimeout = MultipartReader.this.source.timeout();
            q0 q0Var = this.timeout;
            long j8 = q0VarTimeout.j();
            q0VarTimeout.i(q0.f38524e.a(q0Var.j(), q0VarTimeout.j()), TimeUnit.NANOSECONDS);
            if (!q0VarTimeout.f()) {
                if (q0Var.f()) {
                    q0VarTimeout.e(q0Var.d());
                }
                try {
                    long jCurrentPartBytesRemaining = MultipartReader.this.currentPartBytesRemaining(j7);
                    return jCurrentPartBytesRemaining == 0 ? -1L : MultipartReader.this.source.read(sink, jCurrentPartBytesRemaining);
                } finally {
                    q0VarTimeout.i(j8, TimeUnit.NANOSECONDS);
                    if (q0Var.f()) {
                        q0VarTimeout.a();
                    }
                }
            }
            long jD = q0VarTimeout.d();
            if (q0Var.f()) {
                q0VarTimeout.e(Math.min(q0VarTimeout.d(), q0Var.d()));
            }
            try {
                long jCurrentPartBytesRemaining2 = MultipartReader.this.currentPartBytesRemaining(j7);
                return jCurrentPartBytesRemaining2 == 0 ? -1L : MultipartReader.this.source.read(sink, jCurrentPartBytesRemaining2);
            } finally {
                q0VarTimeout.i(j8, TimeUnit.NANOSECONDS);
                if (q0Var.f()) {
                    q0VarTimeout.e(jD);
                }
            }
        }

        @Override // okio.o0
        @d
        public q0 timeout() {
            return this.timeout;
        }
    }

    static {
        d0.a aVar = d0.f38425d;
        p.a aVar2 = p.f38508f;
        afterBoundaryOptions = aVar.d(aVar2.l("\r\n"), aVar2.l("--"), aVar2.l(" "), aVar2.l("\t"));
    }

    public MultipartReader(@d o source, @d String boundary) throws IOException {
        l0.p(source, "source");
        l0.p(boundary, "boundary");
        this.source = source;
        this.boundary = boundary;
        this.dashDashBoundary = new m().q0("--").q0(boundary).E0();
        this.crlfDashDashBoundary = new m().q0("\r\n--").q0(boundary).E0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long currentPartBytesRemaining(long j7) throws IOException {
        this.source.G1(this.crlfDashDashBoundary.a0());
        long J2 = this.source.p().J(this.crlfDashDashBoundary);
        return J2 == -1 ? Math.min(j7, (this.source.p().B1() - ((long) this.crlfDashDashBoundary.a0())) + 1) : Math.min(j7, J2);
    }

    @d
    @h(name = "boundary")
    public final String boundary() {
        return this.boundary;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.currentPart = null;
        this.source.close();
    }

    @e
    public final Part nextPart() throws IOException {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.noMoreParts) {
            return null;
        }
        if (this.partCount == 0 && this.source.t0(0L, this.dashDashBoundary)) {
            this.source.skip(this.dashDashBoundary.a0());
        } else {
            while (true) {
                long jCurrentPartBytesRemaining = currentPartBytesRemaining(PlaybackStateCompat.f450z);
                if (jCurrentPartBytesRemaining == 0) {
                    break;
                }
                this.source.skip(jCurrentPartBytesRemaining);
            }
            this.source.skip(this.crlfDashDashBoundary.a0());
        }
        boolean z7 = false;
        while (true) {
            int iV1 = this.source.V1(afterBoundaryOptions);
            if (iV1 == -1) {
                throw new ProtocolException("unexpected characters after boundary");
            }
            if (iV1 == 0) {
                this.partCount++;
                Headers headersB = new okhttp3.internal.http1.a(this.source).b();
                PartSource partSource = new PartSource();
                this.currentPart = partSource;
                return new Part(headersB, a0.d(partSource));
            }
            if (iV1 == 1) {
                if (z7) {
                    throw new ProtocolException("unexpected characters after boundary");
                }
                if (this.partCount == 0) {
                    throw new ProtocolException("expected at least 1 part");
                }
                this.noMoreParts = true;
                return null;
            }
            if (iV1 == 2 || iV1 == 3) {
                z7 = true;
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MultipartReader(@d ResponseBody response) throws IOException {
        String strParameter;
        l0.p(response, "response");
        o oVarSource = response.source();
        MediaType mediaTypeContentType = response.contentType();
        if (mediaTypeContentType != null && (strParameter = mediaTypeContentType.parameter("boundary")) != null) {
            this(oVarSource, strParameter);
            return;
        }
        throw new ProtocolException("expected the Content-Type to have a boundary parameter");
    }
}
