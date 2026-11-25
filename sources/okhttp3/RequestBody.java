package okhttp3;

import a7.d;
import a7.e;
import androidx.constraintlayout.core.motion.utils.w;
import h5.h;
import h5.i;
import h5.l;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.b1;
import kotlin.i0;
import kotlin.io.c;
import kotlin.jvm.internal.l0;
import kotlin.k;
import kotlin.m;
import kotlin.text.f;
import okio.a0;
import okio.n;
import okio.o0;
import okio.p;

/* JADX INFO: loaded from: classes3.dex */
@i0(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b&\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016¨\u0006\u0010"}, d2 = {"Lokhttp3/RequestBody;", "", "Lokhttp3/MediaType;", "contentType", "", "contentLength", "Lokio/n;", "sink", "Lkotlin/l2;", "writeTo", "", "isDuplex", "isOneShot", "<init>", "()V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public abstract class RequestBody {
    public static final Companion Companion = new Companion(null);

    @i0(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\b\u001a\u00020\u0005*\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u0005*\u00020\t2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\nJ3\u0010\b\u001a\u00020\u0005*\u00020\u000b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0006\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u0005*\u00020\u00102\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0011J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u0002H\u0007J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\tH\u0007J.\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0007J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u0010H\u0007¨\u0006\u0017"}, d2 = {"Lokhttp3/RequestBody$Companion;", "", "", "Lokhttp3/MediaType;", "contentType", "Lokhttp3/RequestBody;", "create", "(Ljava/lang/String;Lokhttp3/MediaType;)Lokhttp3/RequestBody;", "toRequestBody", "Lokio/p;", "(Lokio/p;Lokhttp3/MediaType;)Lokhttp3/RequestBody;", "", "", w.c.R, "byteCount", "([BLokhttp3/MediaType;II)Lokhttp3/RequestBody;", "Ljava/io/File;", "(Ljava/io/File;Lokhttp3/MediaType;)Lokhttp3/RequestBody;", "asRequestBody", "content", "file", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, String str, MediaType mediaType, int i7, Object obj) {
            if ((i7 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        @k(level = m.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @b1(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @i
        @d
        @l
        public final RequestBody create(@e MediaType mediaType, @d byte[] bArr) {
            return create$default(this, mediaType, bArr, 0, 0, 12, (Object) null);
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.w wVar) {
            this();
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, p pVar, MediaType mediaType, int i7, Object obj) {
            if ((i7 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(pVar, mediaType);
        }

        @k(level = m.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @b1(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @i
        @d
        @l
        public final RequestBody create(@e MediaType mediaType, @d byte[] bArr, int i7) {
            return create$default(this, mediaType, bArr, i7, 0, 8, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i7, int i8, int i9, Object obj) {
            if ((i9 & 1) != 0) {
                mediaType = null;
            }
            if ((i9 & 2) != 0) {
                i7 = 0;
            }
            if ((i9 & 4) != 0) {
                i8 = bArr.length;
            }
            return companion.create(bArr, mediaType, i7, i8);
        }

        @i
        @h(name = "create")
        @d
        @l
        public final RequestBody create(@d byte[] bArr) {
            return create$default(this, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, File file, MediaType mediaType, int i7, Object obj) {
            if ((i7 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(file, mediaType);
        }

        @i
        @h(name = "create")
        @d
        @l
        public final RequestBody create(@d byte[] bArr, @e MediaType mediaType) {
            return create$default(this, bArr, mediaType, 0, 0, 6, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, MediaType mediaType, byte[] bArr, int i7, int i8, int i9, Object obj) {
            if ((i9 & 4) != 0) {
                i7 = 0;
            }
            if ((i9 & 8) != 0) {
                i8 = bArr.length;
            }
            return companion.create(mediaType, bArr, i7, i8);
        }

        @i
        @h(name = "create")
        @d
        @l
        public final RequestBody create(@d byte[] bArr, @e MediaType mediaType, int i7) {
            return create$default(this, bArr, mediaType, i7, 0, 4, (Object) null);
        }

        @d
        @h(name = "create")
        @l
        public final RequestBody create(@d String toRequestBody, @e MediaType mediaType) {
            l0.p(toRequestBody, "$this$toRequestBody");
            Charset charset = f.f35353b;
            if (mediaType != null) {
                Charset charsetCharset$default = MediaType.charset$default(mediaType, null, 1, null);
                if (charsetCharset$default == null) {
                    mediaType = MediaType.Companion.parse(mediaType + "; charset=utf-8");
                } else {
                    charset = charsetCharset$default;
                }
            }
            byte[] bytes = toRequestBody.getBytes(charset);
            l0.o(bytes, "(this as java.lang.String).getBytes(charset)");
            return create(bytes, mediaType, 0, bytes.length);
        }

        @d
        @h(name = "create")
        @l
        public final RequestBody create(@d final p toRequestBody, @e final MediaType mediaType) {
            l0.p(toRequestBody, "$this$toRequestBody");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return toRequestBody.a0();
                }

                @Override // okhttp3.RequestBody
                @e
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(@d n sink) throws IOException {
                    l0.p(sink, "sink");
                    sink.p1(toRequestBody);
                }
            };
        }

        @i
        @h(name = "create")
        @d
        @l
        public final RequestBody create(@d final byte[] toRequestBody, @e final MediaType mediaType, final int i7, final int i8) {
            l0.p(toRequestBody, "$this$toRequestBody");
            okhttp3.internal.d.k(toRequestBody.length, i7, i8);
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$2
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return i8;
                }

                @Override // okhttp3.RequestBody
                @e
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(@d n sink) throws IOException {
                    l0.p(sink, "sink");
                    sink.write(toRequestBody, i7, i8);
                }
            };
        }

        @d
        @h(name = "create")
        @l
        public final RequestBody create(@d final File asRequestBody, @e final MediaType mediaType) {
            l0.p(asRequestBody, "$this$asRequestBody");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$asRequestBody$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return asRequestBody.length();
                }

                @Override // okhttp3.RequestBody
                @e
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(@d n sink) throws FileNotFoundException {
                    l0.p(sink, "sink");
                    o0 o0VarL = a0.l(asRequestBody);
                    try {
                        sink.C0(o0VarL);
                        c.a(o0VarL, null);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            c.a(o0VarL, th);
                            throw th2;
                        }
                    }
                }
            };
        }

        @d
        @k(level = m.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @b1(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @l
        public final RequestBody create(@e MediaType mediaType, @d String content) {
            l0.p(content, "content");
            return create(content, mediaType);
        }

        @d
        @k(level = m.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @b1(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @l
        public final RequestBody create(@e MediaType mediaType, @d p content) {
            l0.p(content, "content");
            return create(content, mediaType);
        }

        @k(level = m.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @b1(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @i
        @d
        @l
        public final RequestBody create(@e MediaType mediaType, @d byte[] content, int i7, int i8) {
            l0.p(content, "content");
            return create(content, mediaType, i7, i8);
        }

        @d
        @k(level = m.WARNING, message = "Moved to extension function. Put the 'file' argument first to fix Java", replaceWith = @b1(expression = "file.asRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.asRequestBody"}))
        @l
        public final RequestBody create(@e MediaType mediaType, @d File file) {
            l0.p(file, "file");
            return create(file, mediaType);
        }
    }

    @d
    @h(name = "create")
    @l
    public static final RequestBody create(@d File file, @e MediaType mediaType) {
        return Companion.create(file, mediaType);
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    @e
    public abstract MediaType contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(@d n nVar) throws IOException;

    @d
    @h(name = "create")
    @l
    public static final RequestBody create(@d String str, @e MediaType mediaType) {
        return Companion.create(str, mediaType);
    }

    @d
    @k(level = m.WARNING, message = "Moved to extension function. Put the 'file' argument first to fix Java", replaceWith = @b1(expression = "file.asRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.asRequestBody"}))
    @l
    public static final RequestBody create(@e MediaType mediaType, @d File file) {
        return Companion.create(mediaType, file);
    }

    @d
    @k(level = m.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @b1(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @l
    public static final RequestBody create(@e MediaType mediaType, @d String str) {
        return Companion.create(mediaType, str);
    }

    @d
    @k(level = m.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @b1(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @l
    public static final RequestBody create(@e MediaType mediaType, @d p pVar) {
        return Companion.create(mediaType, pVar);
    }

    @k(level = m.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @b1(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @i
    @d
    @l
    public static final RequestBody create(@e MediaType mediaType, @d byte[] bArr) {
        return Companion.create$default(Companion, mediaType, bArr, 0, 0, 12, (Object) null);
    }

    @k(level = m.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @b1(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @i
    @d
    @l
    public static final RequestBody create(@e MediaType mediaType, @d byte[] bArr, int i7) {
        return Companion.create$default(Companion, mediaType, bArr, i7, 0, 8, (Object) null);
    }

    @k(level = m.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @b1(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @i
    @d
    @l
    public static final RequestBody create(@e MediaType mediaType, @d byte[] bArr, int i7, int i8) {
        return Companion.create(mediaType, bArr, i7, i8);
    }

    @d
    @h(name = "create")
    @l
    public static final RequestBody create(@d p pVar, @e MediaType mediaType) {
        return Companion.create(pVar, mediaType);
    }

    @i
    @h(name = "create")
    @d
    @l
    public static final RequestBody create(@d byte[] bArr) {
        return Companion.create$default(Companion, bArr, (MediaType) null, 0, 0, 7, (Object) null);
    }

    @i
    @h(name = "create")
    @d
    @l
    public static final RequestBody create(@d byte[] bArr, @e MediaType mediaType) {
        return Companion.create$default(Companion, bArr, mediaType, 0, 0, 6, (Object) null);
    }

    @i
    @h(name = "create")
    @d
    @l
    public static final RequestBody create(@d byte[] bArr, @e MediaType mediaType, int i7) {
        return Companion.create$default(Companion, bArr, mediaType, i7, 0, 4, (Object) null);
    }

    @i
    @h(name = "create")
    @d
    @l
    public static final RequestBody create(@d byte[] bArr, @e MediaType mediaType, int i7, int i8) {
        return Companion.create(bArr, mediaType, i7, i8);
    }
}
