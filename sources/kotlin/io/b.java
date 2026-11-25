package kotlin.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.NoSuchElementException;
import kotlin.b1;
import kotlin.g1;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
@h5.h(name = "ByteStreamsKt")
public final class b {

    public static final class a extends kotlin.collections.t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f34752a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f34753b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f34754c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ BufferedInputStream f34755d;

        a(BufferedInputStream bufferedInputStream) {
            this.f34755d = bufferedInputStream;
        }

        private final void g() throws IOException {
            if (this.f34753b || this.f34754c) {
                return;
            }
            int i7 = this.f34755d.read();
            this.f34752a = i7;
            this.f34753b = true;
            this.f34754c = i7 == -1;
        }

        @Override // kotlin.collections.t
        public byte b() throws IOException {
            g();
            if (this.f34754c) {
                throw new NoSuchElementException("Input stream is over.");
            }
            byte b8 = (byte) this.f34752a;
            this.f34753b = false;
            return b8;
        }

        public final boolean d() {
            return this.f34754c;
        }

        public final int e() {
            return this.f34752a;
        }

        public final boolean f() {
            return this.f34753b;
        }

        public final void h(boolean z7) {
            this.f34754c = z7;
        }

        @Override // java.util.Iterator
        public boolean hasNext() throws IOException {
            g();
            return !this.f34754c;
        }

        public final void i(int i7) {
            this.f34752a = i7;
        }

        public final void j(boolean z7) {
            this.f34753b = z7;
        }
    }

    @kotlin.internal.f
    private static final BufferedInputStream a(InputStream inputStream, int i7) {
        l0.p(inputStream, "<this>");
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i7);
    }

    @kotlin.internal.f
    private static final BufferedOutputStream b(OutputStream outputStream, int i7) {
        l0.p(outputStream, "<this>");
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i7);
    }

    static /* synthetic */ BufferedInputStream c(InputStream inputStream, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i7 = 8192;
        }
        l0.p(inputStream, "<this>");
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i7);
    }

    static /* synthetic */ BufferedOutputStream d(OutputStream outputStream, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i7 = 8192;
        }
        l0.p(outputStream, "<this>");
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i7);
    }

    @kotlin.internal.f
    private static final BufferedReader e(InputStream inputStream, Charset charset) {
        l0.p(inputStream, "<this>");
        l0.p(charset, "charset");
        Reader inputStreamReader = new InputStreamReader(inputStream, charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
    }

    static /* synthetic */ BufferedReader f(InputStream inputStream, Charset charset, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            charset = kotlin.text.f.f35353b;
        }
        l0.p(inputStream, "<this>");
        l0.p(charset, "charset");
        Reader inputStreamReader = new InputStreamReader(inputStream, charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
    }

    @kotlin.internal.f
    private static final BufferedWriter g(OutputStream outputStream, Charset charset) {
        l0.p(outputStream, "<this>");
        l0.p(charset, "charset");
        Writer outputStreamWriter = new OutputStreamWriter(outputStream, charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
    }

    static /* synthetic */ BufferedWriter h(OutputStream outputStream, Charset charset, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            charset = kotlin.text.f.f35353b;
        }
        l0.p(outputStream, "<this>");
        l0.p(charset, "charset");
        Writer outputStreamWriter = new OutputStreamWriter(outputStream, charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
    }

    @kotlin.internal.f
    private static final ByteArrayInputStream i(String str, Charset charset) {
        l0.p(str, "<this>");
        l0.p(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        l0.o(bytes, "this as java.lang.String).getBytes(charset)");
        return new ByteArrayInputStream(bytes);
    }

    static /* synthetic */ ByteArrayInputStream j(String str, Charset charset, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            charset = kotlin.text.f.f35353b;
        }
        l0.p(str, "<this>");
        l0.p(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        l0.o(bytes, "this as java.lang.String).getBytes(charset)");
        return new ByteArrayInputStream(bytes);
    }

    public static final long k(@a7.d InputStream inputStream, @a7.d OutputStream out, int i7) throws IOException {
        l0.p(inputStream, "<this>");
        l0.p(out, "out");
        byte[] bArr = new byte[i7];
        int i8 = inputStream.read(bArr);
        long j7 = 0;
        while (i8 >= 0) {
            out.write(bArr, 0, i8);
            j7 += (long) i8;
            i8 = inputStream.read(bArr);
        }
        return j7;
    }

    public static /* synthetic */ long l(InputStream inputStream, OutputStream outputStream, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = 8192;
        }
        return k(inputStream, outputStream, i7);
    }

    @kotlin.internal.f
    private static final ByteArrayInputStream m(byte[] bArr) {
        l0.p(bArr, "<this>");
        return new ByteArrayInputStream(bArr);
    }

    @kotlin.internal.f
    private static final ByteArrayInputStream n(byte[] bArr, int i7, int i8) {
        l0.p(bArr, "<this>");
        return new ByteArrayInputStream(bArr, i7, i8);
    }

    @a7.d
    public static final kotlin.collections.t o(@a7.d BufferedInputStream bufferedInputStream) {
        l0.p(bufferedInputStream, "<this>");
        return new a(bufferedInputStream);
    }

    @a7.d
    @g1(version = "1.3")
    public static final byte[] p(@a7.d InputStream inputStream) {
        l0.p(inputStream, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, inputStream.available()));
        l(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        l0.o(byteArray, "buffer.toByteArray()");
        return byteArray;
    }

    @a7.d
    @kotlin.k(message = "Use readBytes() overload without estimatedSize parameter", replaceWith = @b1(expression = "readBytes()", imports = {}))
    @kotlin.l(errorSince = "1.5", warningSince = "1.3")
    public static final byte[] q(@a7.d InputStream inputStream, int i7) {
        l0.p(inputStream, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(i7, inputStream.available()));
        l(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        l0.o(byteArray, "buffer.toByteArray()");
        return byteArray;
    }

    public static /* synthetic */ byte[] r(InputStream inputStream, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i7 = 8192;
        }
        return q(inputStream, i7);
    }

    @kotlin.internal.f
    private static final InputStreamReader s(InputStream inputStream, Charset charset) {
        l0.p(inputStream, "<this>");
        l0.p(charset, "charset");
        return new InputStreamReader(inputStream, charset);
    }

    static /* synthetic */ InputStreamReader t(InputStream inputStream, Charset charset, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            charset = kotlin.text.f.f35353b;
        }
        l0.p(inputStream, "<this>");
        l0.p(charset, "charset");
        return new InputStreamReader(inputStream, charset);
    }

    @kotlin.internal.f
    private static final OutputStreamWriter u(OutputStream outputStream, Charset charset) {
        l0.p(outputStream, "<this>");
        l0.p(charset, "charset");
        return new OutputStreamWriter(outputStream, charset);
    }

    static /* synthetic */ OutputStreamWriter v(OutputStream outputStream, Charset charset, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            charset = kotlin.text.f.f35353b;
        }
        l0.p(outputStream, "<this>");
        l0.p(charset, "charset");
        return new OutputStreamWriter(outputStream, charset);
    }
}
