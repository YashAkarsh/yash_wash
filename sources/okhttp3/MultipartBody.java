package okhttp3;

import a7.d;
import com.google.common.net.c;
import com.haier.uhome.account.api.RetInfoContent;
import h5.e;
import h5.h;
import h5.i;
import h5.l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.b1;
import kotlin.i0;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import kotlin.k;
import kotlin.m;
import kotlin.text.h0;
import okio.n;
import okio.p;

/* JADX INFO: loaded from: classes3.dex */
@i0(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 '2\u00020\u0001:\u0003(')B'\b\u0000\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u0018¢\u0006\u0004\b%\u0010&J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\b\u0010\r\u001a\u00020\fH\u0016J\u000f\u0010\u0010\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0014\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0017\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u0018H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u001c\u001a\u00020\u0006H\u0016J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001fR\u0016\u0010\u001c\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0017\u0010\u0010\u001a\u00020\f8\u0007¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b\u0010\u0010\u000fR\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u00188\u0007¢\u0006\f\n\u0004\b\u001b\u0010$\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u0014\u001a\u00020\u00118G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0017\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016¨\u0006*"}, d2 = {"Lokhttp3/MultipartBody;", "Lokhttp3/RequestBody;", "Lokio/n;", "sink", "", "countBytes", "", "writeOrCountBytes", "", "index", "Lokhttp3/MultipartBody$Part;", "part", "Lokhttp3/MediaType;", "contentType", "-deprecated_type", "()Lokhttp3/MediaType;", "type", "", "-deprecated_boundary", "()Ljava/lang/String;", "boundary", "-deprecated_size", "()I", "size", "", "-deprecated_parts", "()Ljava/util/List;", "parts", "contentLength", "Lkotlin/l2;", "writeTo", "Lokhttp3/MediaType;", "J", "Lokio/p;", "boundaryByteString", "Lokio/p;", "Ljava/util/List;", "<init>", "(Lokio/p;Lokhttp3/MediaType;Ljava/util/List;)V", "Companion", "Builder", "Part", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class MultipartBody extends RequestBody {

    @d
    @e
    public static final MediaType ALTERNATIVE;
    private static final byte[] COLONSPACE;
    private static final byte[] CRLF;
    public static final Companion Companion = new Companion(null);
    private static final byte[] DASHDASH;

    @d
    @e
    public static final MediaType DIGEST;

    @d
    @e
    public static final MediaType FORM;

    @d
    @e
    public static final MediaType MIXED;

    @d
    @e
    public static final MediaType PARALLEL;
    private final p boundaryByteString;
    private long contentLength;
    private final MediaType contentType;

    @d
    private final List<Part> parts;

    @d
    private final MediaType type;

    @i0(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u0018\u0010\u0007\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u0005J\u0016\u0010\r\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ \u0010\r\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0011R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lokhttp3/MultipartBody$Builder;", "", "Lokhttp3/MediaType;", "type", "setType", "Lokhttp3/RequestBody;", com.paytm.pgsdk.d.V, "addPart", "Lokhttp3/Headers;", "headers", "", "name", "value", "addFormDataPart", "filename", "Lokhttp3/MultipartBody$Part;", "part", "Lokhttp3/MultipartBody;", "build", "Lokio/p;", "boundary", "Lokio/p;", "Lokhttp3/MediaType;", "", "parts", "Ljava/util/List;", "<init>", "(Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Builder {
        private final p boundary;
        private final List<Part> parts;
        private MediaType type;

        /* JADX WARN: Multi-variable type inference failed */
        @i
        public Builder() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @d
        public final Builder addFormDataPart(@d String name, @d String value) {
            l0.p(name, "name");
            l0.p(value, "value");
            addPart(Part.Companion.createFormData(name, value));
            return this;
        }

        @d
        public final Builder addPart(@d RequestBody body) {
            l0.p(body, "body");
            addPart(Part.Companion.create(body));
            return this;
        }

        @d
        public final MultipartBody build() {
            if (!this.parts.isEmpty()) {
                return new MultipartBody(this.boundary, this.type, okhttp3.internal.d.c0(this.parts));
            }
            throw new IllegalStateException("Multipart body must have at least one part.".toString());
        }

        @d
        public final Builder setType(@d MediaType type) {
            l0.p(type, "type");
            if (l0.g(type.type(), "multipart")) {
                this.type = type;
                return this;
            }
            throw new IllegalArgumentException(("multipart != " + type).toString());
        }

        @i
        public Builder(@d String boundary) {
            l0.p(boundary, "boundary");
            this.boundary = p.f38508f.l(boundary);
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
        }

        @d
        public final Builder addFormDataPart(@d String name, @a7.e String str, @d RequestBody body) {
            l0.p(name, "name");
            l0.p(body, "body");
            addPart(Part.Companion.createFormData(name, str, body));
            return this;
        }

        @d
        public final Builder addPart(@a7.e Headers headers, @d RequestBody body) {
            l0.p(body, "body");
            addPart(Part.Companion.create(headers, body));
            return this;
        }

        @d
        public final Builder addPart(@d Part part) {
            l0.p(part, "part");
            this.parts.add(part);
            return this;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Builder(String str, int i7, w wVar) {
            if ((i7 & 1) != 0) {
                str = UUID.randomUUID().toString();
                l0.o(str, "UUID.randomUUID().toString()");
            }
            this(str);
        }
    }

    @i0(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\t\u001a\u00020\u0006*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\fR\u0014\u0010\u0014\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\fR\u0014\u0010\u0015\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\f¨\u0006\u0018"}, d2 = {"Lokhttp3/MultipartBody$Companion;", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", RetInfoContent.BindKEY_ISNULL, "Lkotlin/l2;", "appendQuotedString$okhttp", "(Ljava/lang/StringBuilder;Ljava/lang/String;)V", "appendQuotedString", "Lokhttp3/MediaType;", "ALTERNATIVE", "Lokhttp3/MediaType;", "", "COLONSPACE", "[B", "CRLF", "DASHDASH", "DIGEST", "FORM", "MIXED", "PARALLEL", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public final void appendQuotedString$okhttp(@d StringBuilder appendQuotedString, @d String key) {
            l0.p(appendQuotedString, "$this$appendQuotedString");
            l0.p(key, "key");
            appendQuotedString.append(h0.f35376b);
            int length = key.length();
            for (int i7 = 0; i7 < length; i7++) {
                char cCharAt = key.charAt(i7);
                if (cCharAt == '\n') {
                    appendQuotedString.append("%0A");
                } else if (cCharAt == '\r') {
                    appendQuotedString.append("%0D");
                } else if (cCharAt != '\"') {
                    appendQuotedString.append(cCharAt);
                } else {
                    appendQuotedString.append("%22");
                }
            }
            appendQuotedString.append(h0.f35376b);
        }

        public /* synthetic */ Companion(w wVar) {
            this();
        }
    }

    @i0(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0019\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\tJ\u000f\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b\nR\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\b¨\u0006\f"}, d2 = {"Lokhttp3/MultipartBody$Part;", "", "headers", "Lokhttp3/Headers;", com.paytm.pgsdk.d.V, "Lokhttp3/RequestBody;", "(Lokhttp3/Headers;Lokhttp3/RequestBody;)V", "()Lokhttp3/RequestBody;", "()Lokhttp3/Headers;", "-deprecated_body", "-deprecated_headers", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Part {
        public static final Companion Companion = new Companion(null);

        @d
        private final RequestBody body;

        @a7.e
        private final Headers headers;

        @i0(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0007J\"\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\u000e"}, d2 = {"Lokhttp3/MultipartBody$Part$Companion;", "", "()V", "create", "Lokhttp3/MultipartBody$Part;", "headers", "Lokhttp3/Headers;", com.paytm.pgsdk.d.V, "Lokhttp3/RequestBody;", "createFormData", "name", "", "value", "filename", "okhttp"}, k = 1, mv = {1, 4, 0})
        public static final class Companion {
            private Companion() {
            }

            @d
            @l
            public final Part create(@d RequestBody body) {
                l0.p(body, "body");
                return create(null, body);
            }

            @d
            @l
            public final Part createFormData(@d String name, @d String value) {
                l0.p(name, "name");
                l0.p(value, "value");
                return createFormData(name, null, RequestBody.Companion.create$default(RequestBody.Companion, value, (MediaType) null, 1, (Object) null));
            }

            public /* synthetic */ Companion(w wVar) {
                this();
            }

            @d
            @l
            public final Part create(@a7.e Headers headers, @d RequestBody body) {
                l0.p(body, "body");
                w wVar = null;
                if (!((headers != null ? headers.get("Content-Type") : null) == null)) {
                    throw new IllegalArgumentException("Unexpected header: Content-Type".toString());
                }
                if ((headers != null ? headers.get(c.f22134b) : null) == null) {
                    return new Part(headers, body, wVar);
                }
                throw new IllegalArgumentException("Unexpected header: Content-Length".toString());
            }

            @d
            @l
            public final Part createFormData(@d String name, @a7.e String str, @d RequestBody body) {
                l0.p(name, "name");
                l0.p(body, "body");
                StringBuilder sb = new StringBuilder();
                sb.append("form-data; name=");
                Companion companion = MultipartBody.Companion;
                companion.appendQuotedString$okhttp(sb, name);
                if (str != null) {
                    sb.append("; filename=");
                    companion.appendQuotedString$okhttp(sb, str);
                }
                String string = sb.toString();
                l0.o(string, "StringBuilder().apply(builderAction).toString()");
                return create(new Headers.Builder().addUnsafeNonAscii("Content-Disposition", string).build(), body);
            }
        }

        private Part(Headers headers, RequestBody requestBody) {
            this.headers = headers;
            this.body = requestBody;
        }

        @d
        @l
        public static final Part create(@a7.e Headers headers, @d RequestBody requestBody) {
            return Companion.create(headers, requestBody);
        }

        @d
        @l
        public static final Part createFormData(@d String str, @d String str2) {
            return Companion.createFormData(str, str2);
        }

        @d
        @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = com.paytm.pgsdk.d.V, imports = {}))
        @h(name = "-deprecated_body")
        /* JADX INFO: renamed from: -deprecated_body, reason: not valid java name */
        public final RequestBody m84deprecated_body() {
            return this.body;
        }

        @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "headers", imports = {}))
        @a7.e
        @h(name = "-deprecated_headers")
        /* JADX INFO: renamed from: -deprecated_headers, reason: not valid java name */
        public final Headers m85deprecated_headers() {
            return this.headers;
        }

        @d
        @h(name = com.paytm.pgsdk.d.V)
        public final RequestBody body() {
            return this.body;
        }

        @a7.e
        @h(name = "headers")
        public final Headers headers() {
            return this.headers;
        }

        public /* synthetic */ Part(Headers headers, RequestBody requestBody, w wVar) {
            this(headers, requestBody);
        }

        @d
        @l
        public static final Part create(@d RequestBody requestBody) {
            return Companion.create(requestBody);
        }

        @d
        @l
        public static final Part createFormData(@d String str, @a7.e String str2, @d RequestBody requestBody) {
            return Companion.createFormData(str, str2, requestBody);
        }
    }

    static {
        MediaType.Companion companion = MediaType.Companion;
        MIXED = companion.get("multipart/mixed");
        ALTERNATIVE = companion.get("multipart/alternative");
        DIGEST = companion.get("multipart/digest");
        PARALLEL = companion.get("multipart/parallel");
        FORM = companion.get("multipart/form-data");
        COLONSPACE = new byte[]{(byte) 58, (byte) 32};
        CRLF = new byte[]{(byte) 13, (byte) 10};
        byte b8 = (byte) 45;
        DASHDASH = new byte[]{b8, b8};
    }

    public MultipartBody(@d p boundaryByteString, @d MediaType type, @d List<Part> parts) {
        l0.p(boundaryByteString, "boundaryByteString");
        l0.p(type, "type");
        l0.p(parts, "parts");
        this.boundaryByteString = boundaryByteString;
        this.type = type;
        this.parts = parts;
        this.contentType = MediaType.Companion.get(type + "; boundary=" + boundary());
        this.contentLength = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long writeOrCountBytes(n nVar, boolean z7) throws IOException {
        okio.m mVar;
        if (z7) {
            nVar = new okio.m();
            mVar = nVar;
        } else {
            mVar = 0;
        }
        int size = this.parts.size();
        long j7 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            Part part = this.parts.get(i7);
            Headers headers = part.headers();
            RequestBody requestBodyBody = part.body();
            l0.m(nVar);
            nVar.write(DASHDASH);
            nVar.p1(this.boundaryByteString);
            nVar.write(CRLF);
            if (headers != null) {
                int size2 = headers.size();
                for (int i8 = 0; i8 < size2; i8++) {
                    nVar.q0(headers.name(i8)).write(COLONSPACE).q0(headers.value(i8)).write(CRLF);
                }
            }
            MediaType mediaTypeContentType = requestBodyBody.contentType();
            if (mediaTypeContentType != null) {
                nVar.q0("Content-Type: ").q0(mediaTypeContentType.toString()).write(CRLF);
            }
            long jContentLength = requestBodyBody.contentLength();
            if (jContentLength != -1) {
                nVar.q0("Content-Length: ").H1(jContentLength).write(CRLF);
            } else if (z7) {
                l0.m(mVar);
                mVar.q();
                return -1L;
            }
            byte[] bArr = CRLF;
            nVar.write(bArr);
            if (z7) {
                j7 += jContentLength;
            } else {
                requestBodyBody.writeTo(nVar);
            }
            nVar.write(bArr);
        }
        l0.m(nVar);
        byte[] bArr2 = DASHDASH;
        nVar.write(bArr2);
        nVar.p1(this.boundaryByteString);
        nVar.write(bArr2);
        nVar.write(CRLF);
        if (!z7) {
            return j7;
        }
        l0.m(mVar);
        long jB1 = j7 + mVar.B1();
        mVar.q();
        return jB1;
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "boundary", imports = {}))
    @h(name = "-deprecated_boundary")
    /* JADX INFO: renamed from: -deprecated_boundary, reason: not valid java name */
    public final String m80deprecated_boundary() {
        return boundary();
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "parts", imports = {}))
    @h(name = "-deprecated_parts")
    /* JADX INFO: renamed from: -deprecated_parts, reason: not valid java name */
    public final List<Part> m81deprecated_parts() {
        return this.parts;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "size", imports = {}))
    @h(name = "-deprecated_size")
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final int m82deprecated_size() {
        return size();
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "type", imports = {}))
    @h(name = "-deprecated_type")
    /* JADX INFO: renamed from: -deprecated_type, reason: not valid java name */
    public final MediaType m83deprecated_type() {
        return this.type;
    }

    @d
    @h(name = "boundary")
    public final String boundary() {
        return this.boundaryByteString.l0();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        long j7 = this.contentLength;
        if (j7 != -1) {
            return j7;
        }
        long jWriteOrCountBytes = writeOrCountBytes(null, true);
        this.contentLength = jWriteOrCountBytes;
        return jWriteOrCountBytes;
    }

    @Override // okhttp3.RequestBody
    @d
    public MediaType contentType() {
        return this.contentType;
    }

    @d
    public final Part part(int i7) {
        return this.parts.get(i7);
    }

    @d
    @h(name = "parts")
    public final List<Part> parts() {
        return this.parts;
    }

    @h(name = "size")
    public final int size() {
        return this.parts.size();
    }

    @d
    @h(name = "type")
    public final MediaType type() {
        return this.type;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(@d n sink) throws IOException {
        l0.p(sink, "sink");
        writeOrCountBytes(sink, false);
    }
}
