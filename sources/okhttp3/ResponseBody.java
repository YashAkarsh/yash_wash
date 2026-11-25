package okhttp3;

import a7.d;
import a7.e;
import androidx.constraintlayout.core.motion.utils.w;
import com.facebook.share.internal.ShareConstants;
import h5.h;
import h5.l;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.b1;
import kotlin.i0;
import kotlin.io.c;
import kotlin.jvm.internal.l0;
import kotlin.k;
import kotlin.text.f;
import kotlinx.coroutines.z0;
import okio.m;
import okio.o;
import okio.p;

/* JADX INFO: loaded from: classes3.dex */
@i0(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 \"2\u00020\u0001:\u0002#\"B\u0007¢\u0006\u0004\b \u0010!JB\u0010\t\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0004H\u0082\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\f\u001a\u00020\u000bH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\b\u0010\u0010\u001a\u00020\u000fH&J\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0013\u001a\u00020\u0005H&J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u001aJ\b\u0010\u001d\u001a\u00020\u001cH\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lokhttp3/ResponseBody;", "Ljava/io/Closeable;", "", "T", "Lkotlin/Function1;", "Lokio/o;", "consumer", "", "sizeMapper", "consumeSource", "(Li5/l;Li5/l;)Ljava/lang/Object;", "Ljava/nio/charset/Charset;", "charset", "Lokhttp3/MediaType;", "contentType", "", "contentLength", "Ljava/io/InputStream;", "byteStream", ShareConstants.FEED_SOURCE_PARAM, "", "bytes", "Lokio/p;", "byteString", "Ljava/io/Reader;", "charStream", "", w.b.f3030e, "Lkotlin/l2;", "close", "reader", "Ljava/io/Reader;", "<init>", "()V", "Companion", "BomAwareReader", "okhttp"}, k = 1, mv = {1, 4, 0})
public abstract class ResponseBody implements Closeable {
    public static final Companion Companion = new Companion(null);
    private Reader reader;

    @i0(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lokhttp3/ResponseBody$BomAwareReader;", "Ljava/io/Reader;", "", "cbuf", "", z0.f37391e, "len", "read", "Lkotlin/l2;", "close", "", "closed", "Z", "delegate", "Ljava/io/Reader;", "Lokio/o;", ShareConstants.FEED_SOURCE_PARAM, "Lokio/o;", "Ljava/nio/charset/Charset;", "charset", "Ljava/nio/charset/Charset;", "<init>", "(Lokio/o;Ljava/nio/charset/Charset;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class BomAwareReader extends Reader {
        private final Charset charset;
        private boolean closed;
        private Reader delegate;
        private final o source;

        public BomAwareReader(@d o source, @d Charset charset) {
            l0.p(source, "source");
            l0.p(charset, "charset");
            this.source = source;
            this.charset = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.closed = true;
            Reader reader = this.delegate;
            if (reader != null) {
                reader.close();
            } else {
                this.source.close();
            }
        }

        @Override // java.io.Reader
        public int read(@d char[] cbuf, int i7, int i8) throws IOException {
            l0.p(cbuf, "cbuf");
            if (this.closed) {
                throw new IOException("Stream closed");
            }
            Reader inputStreamReader = this.delegate;
            if (inputStreamReader == null) {
                inputStreamReader = new InputStreamReader(this.source.S1(), okhttp3.internal.d.P(this.source, this.charset));
                this.delegate = inputStreamReader;
            }
            return inputStreamReader.read(cbuf, i7, i8);
        }
    }

    @i0(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\b\u001a\u00020\u0005*\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u0005*\u00020\t2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\nJ\u001f\u0010\b\u001a\u00020\u0005*\u00020\u000b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\fJ)\u0010\u0011\u001a\u00020\u0005*\u00020\r2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0006\u0010\u0010J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0007J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\tH\u0007J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u000bH\u0007J\"\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\rH\u0007¨\u0006\u0015"}, d2 = {"Lokhttp3/ResponseBody$Companion;", "", "", "Lokhttp3/MediaType;", "contentType", "Lokhttp3/ResponseBody;", "create", "(Ljava/lang/String;Lokhttp3/MediaType;)Lokhttp3/ResponseBody;", "toResponseBody", "", "([BLokhttp3/MediaType;)Lokhttp3/ResponseBody;", "Lokio/p;", "(Lokio/p;Lokhttp3/MediaType;)Lokhttp3/ResponseBody;", "Lokio/o;", "", "contentLength", "(Lokio/o;Lokhttp3/MediaType;J)Lokhttp3/ResponseBody;", "asResponseBody", "content", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, String str, MediaType mediaType, int i7, Object obj) {
            if ((i7 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        @d
        @h(name = "create")
        @l
        public final ResponseBody create(@d String toResponseBody, @e MediaType mediaType) {
            l0.p(toResponseBody, "$this$toResponseBody");
            Charset charset = f.f35353b;
            if (mediaType != null) {
                Charset charsetCharset$default = MediaType.charset$default(mediaType, null, 1, null);
                if (charsetCharset$default == null) {
                    mediaType = MediaType.Companion.parse(mediaType + "; charset=utf-8");
                } else {
                    charset = charsetCharset$default;
                }
            }
            m mVarF0 = new m().F0(toResponseBody, charset);
            return create(mVarF0, mediaType, mVarF0.B1());
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.w wVar) {
            this();
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i7, Object obj) {
            if ((i7 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(bArr, mediaType);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, p pVar, MediaType mediaType, int i7, Object obj) {
            if ((i7 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(pVar, mediaType);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, o oVar, MediaType mediaType, long j7, int i7, Object obj) {
            if ((i7 & 1) != 0) {
                mediaType = null;
            }
            if ((i7 & 2) != 0) {
                j7 = -1;
            }
            return companion.create(oVar, mediaType, j7);
        }

        @d
        @h(name = "create")
        @l
        public final ResponseBody create(@d byte[] toResponseBody, @e MediaType mediaType) {
            l0.p(toResponseBody, "$this$toResponseBody");
            return create(new m().write(toResponseBody), mediaType, toResponseBody.length);
        }

        @d
        @h(name = "create")
        @l
        public final ResponseBody create(@d p toResponseBody, @e MediaType mediaType) {
            l0.p(toResponseBody, "$this$toResponseBody");
            return create(new m().p1(toResponseBody), mediaType, toResponseBody.a0());
        }

        @d
        @h(name = "create")
        @l
        public final ResponseBody create(@d final o asResponseBody, @e final MediaType mediaType, final long j7) {
            l0.p(asResponseBody, "$this$asResponseBody");
            return new ResponseBody() { // from class: okhttp3.ResponseBody$Companion$asResponseBody$1
                @Override // okhttp3.ResponseBody
                public long contentLength() {
                    return j7;
                }

                @Override // okhttp3.ResponseBody
                @e
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.ResponseBody
                @d
                public o source() {
                    return asResponseBody;
                }
            };
        }

        @d
        @k(level = kotlin.m.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @b1(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
        @l
        public final ResponseBody create(@e MediaType mediaType, @d String content) {
            l0.p(content, "content");
            return create(content, mediaType);
        }

        @d
        @k(level = kotlin.m.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @b1(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
        @l
        public final ResponseBody create(@e MediaType mediaType, @d byte[] content) {
            l0.p(content, "content");
            return create(content, mediaType);
        }

        @d
        @k(level = kotlin.m.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @b1(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
        @l
        public final ResponseBody create(@e MediaType mediaType, @d p content) {
            l0.p(content, "content");
            return create(content, mediaType);
        }

        @d
        @k(level = kotlin.m.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @b1(expression = "content.asResponseBody(contentType, contentLength)", imports = {"okhttp3.ResponseBody.Companion.asResponseBody"}))
        @l
        public final ResponseBody create(@e MediaType mediaType, long j7, @d o content) {
            l0.p(content, "content");
            return create(content, mediaType, j7);
        }
    }

    private final Charset charset() {
        Charset charset;
        MediaType mediaTypeContentType = contentType();
        return (mediaTypeContentType == null || (charset = mediaTypeContentType.charset(f.f35353b)) == null) ? f.f35353b : charset;
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [T, java.lang.Object] */
    private final <T> T consumeSource(i5.l<? super o, ? extends T> lVar, i5.l<? super T, Integer> lVar2) throws IOException {
        long jContentLength = contentLength();
        if (jContentLength > Integer.MAX_VALUE) {
            throw new IOException("Cannot buffer entire body for content length: " + jContentLength);
        }
        o oVarSource = source();
        try {
            T tZ = lVar.z(oVarSource);
            kotlin.jvm.internal.i0.d(1);
            c.a(oVarSource, null);
            kotlin.jvm.internal.i0.c(1);
            int iIntValue = lVar2.z(tZ).intValue();
            if (jContentLength == -1 || jContentLength == iIntValue) {
                return tZ;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + iIntValue + ") disagree");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.jvm.internal.i0.d(1);
                c.a(oVarSource, th);
                kotlin.jvm.internal.i0.c(1);
                throw th2;
            }
        }
    }

    @d
    @h(name = "create")
    @l
    public static final ResponseBody create(@d String str, @e MediaType mediaType) {
        return Companion.create(str, mediaType);
    }

    @d
    public final InputStream byteStream() {
        return source().S1();
    }

    @d
    public final p byteString() throws IOException {
        long jContentLength = contentLength();
        if (jContentLength > Integer.MAX_VALUE) {
            throw new IOException("Cannot buffer entire body for content length: " + jContentLength);
        }
        o oVarSource = source();
        try {
            p pVarE0 = oVarSource.E0();
            c.a(oVarSource, null);
            int iA0 = pVarE0.a0();
            if (jContentLength == -1 || jContentLength == iA0) {
                return pVarE0;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + iA0 + ") disagree");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                c.a(oVarSource, th);
                throw th2;
            }
        }
    }

    @d
    public final byte[] bytes() throws IOException {
        long jContentLength = contentLength();
        if (jContentLength > Integer.MAX_VALUE) {
            throw new IOException("Cannot buffer entire body for content length: " + jContentLength);
        }
        o oVarSource = source();
        try {
            byte[] bArrI = oVarSource.I();
            c.a(oVarSource, null);
            int length = bArrI.length;
            if (jContentLength == -1 || jContentLength == length) {
                return bArrI;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + length + ") disagree");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                c.a(oVarSource, th);
                throw th2;
            }
        }
    }

    @d
    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        BomAwareReader bomAwareReader = new BomAwareReader(source(), charset());
        this.reader = bomAwareReader;
        return bomAwareReader;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        okhttp3.internal.d.l(source());
    }

    public abstract long contentLength();

    @e
    public abstract MediaType contentType();

    @d
    public abstract o source();

    @d
    public final String string() throws IOException {
        o oVarSource = source();
        try {
            String strU0 = oVarSource.u0(okhttp3.internal.d.P(oVarSource, charset()));
            c.a(oVarSource, null);
            return strU0;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                c.a(oVarSource, th);
                throw th2;
            }
        }
    }

    @d
    @k(level = kotlin.m.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @b1(expression = "content.asResponseBody(contentType, contentLength)", imports = {"okhttp3.ResponseBody.Companion.asResponseBody"}))
    @l
    public static final ResponseBody create(@e MediaType mediaType, long j7, @d o oVar) {
        return Companion.create(mediaType, j7, oVar);
    }

    @d
    @k(level = kotlin.m.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @b1(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @l
    public static final ResponseBody create(@e MediaType mediaType, @d String str) {
        return Companion.create(mediaType, str);
    }

    @d
    @k(level = kotlin.m.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @b1(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @l
    public static final ResponseBody create(@e MediaType mediaType, @d p pVar) {
        return Companion.create(mediaType, pVar);
    }

    @d
    @k(level = kotlin.m.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @b1(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @l
    public static final ResponseBody create(@e MediaType mediaType, @d byte[] bArr) {
        return Companion.create(mediaType, bArr);
    }

    @d
    @h(name = "create")
    @l
    public static final ResponseBody create(@d o oVar, @e MediaType mediaType, long j7) {
        return Companion.create(oVar, mediaType, j7);
    }

    @d
    @h(name = "create")
    @l
    public static final ResponseBody create(@d p pVar, @e MediaType mediaType) {
        return Companion.create(pVar, mediaType);
    }

    @d
    @h(name = "create")
    @l
    public static final ResponseBody create(@d byte[] bArr, @e MediaType mediaType) {
        return Companion.create(bArr, mediaType);
    }
}
