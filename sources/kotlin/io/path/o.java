package kotlin.io.path;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.g1;
import kotlin.l2;
import kotlin.q2;

/* JADX INFO: loaded from: classes2.dex */
class o {
    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final Path A(Path path, kotlin.sequences.m<? extends CharSequence> lines, Charset charset, OpenOption... options) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(lines, "lines");
        kotlin.jvm.internal.l0.p(charset, "charset");
        kotlin.jvm.internal.l0.p(options, "options");
        Path pathWrite = Files.write(path, kotlin.sequences.u.N(lines), charset, (OpenOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.l0.o(pathWrite, "write(this, lines.asIterable(), charset, *options)");
        return pathWrite;
    }

    static /* synthetic */ Path B(Path path, Iterable lines, Charset charset, OpenOption[] options, int i7, Object obj) throws IOException {
        if ((i7 & 2) != 0) {
            charset = kotlin.text.f.f35353b;
        }
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(lines, "lines");
        kotlin.jvm.internal.l0.p(charset, "charset");
        kotlin.jvm.internal.l0.p(options, "options");
        Path pathWrite = Files.write(path, lines, charset, (OpenOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.l0.o(pathWrite, "write(this, lines, charset, *options)");
        return pathWrite;
    }

    static /* synthetic */ Path C(Path path, kotlin.sequences.m lines, Charset charset, OpenOption[] options, int i7, Object obj) throws IOException {
        if ((i7 & 2) != 0) {
            charset = kotlin.text.f.f35353b;
        }
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(lines, "lines");
        kotlin.jvm.internal.l0.p(charset, "charset");
        kotlin.jvm.internal.l0.p(options, "options");
        Path pathWrite = Files.write(path, kotlin.sequences.u.N(lines), charset, (OpenOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.l0.o(pathWrite, "write(this, lines.asIterable(), charset, *options)");
        return pathWrite;
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    public static final void D(@a7.d Path path, @a7.d CharSequence text, @a7.d Charset charset, @a7.d OpenOption... options) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(text, "text");
        kotlin.jvm.internal.l0.p(charset, "charset");
        kotlin.jvm.internal.l0.p(options, "options");
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.l0.o(outputStreamNewOutputStream, "newOutputStream(this, *options)");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStreamNewOutputStream, charset);
        try {
            outputStreamWriter.append(text);
            kotlin.io.c.a(outputStreamWriter, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.io.c.a(outputStreamWriter, th);
                throw th2;
            }
        }
    }

    public static /* synthetic */ void E(Path path, CharSequence charSequence, Charset charset, OpenOption[] openOptionArr, int i7, Object obj) throws IOException {
        if ((i7 & 2) != 0) {
            charset = kotlin.text.f.f35353b;
        }
        D(path, charSequence, charset, openOptionArr);
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final OutputStreamWriter F(Path path, Charset charset, OpenOption... options) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(charset, "charset");
        kotlin.jvm.internal.l0.p(options, "options");
        return new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length)), charset);
    }

    static /* synthetic */ OutputStreamWriter G(Path path, Charset charset, OpenOption[] options, int i7, Object obj) throws IOException {
        if ((i7 & 1) != 0) {
            charset = kotlin.text.f.f35353b;
        }
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(charset, "charset");
        kotlin.jvm.internal.l0.p(options, "options");
        return new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length)), charset);
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final void a(Path path, byte[] array) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(array, "array");
        Files.write(path, array, k.a(StandardOpenOption.APPEND));
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final Path b(Path path, Iterable<? extends CharSequence> lines, Charset charset) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(lines, "lines");
        kotlin.jvm.internal.l0.p(charset, "charset");
        Path pathWrite = Files.write(path, lines, charset, k.a(StandardOpenOption.APPEND));
        kotlin.jvm.internal.l0.o(pathWrite, "write(this, lines, chars…tandardOpenOption.APPEND)");
        return pathWrite;
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final Path c(Path path, kotlin.sequences.m<? extends CharSequence> lines, Charset charset) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(lines, "lines");
        kotlin.jvm.internal.l0.p(charset, "charset");
        Path pathWrite = Files.write(path, kotlin.sequences.u.N(lines), charset, k.a(StandardOpenOption.APPEND));
        kotlin.jvm.internal.l0.o(pathWrite, "write(this, lines.asIter…tandardOpenOption.APPEND)");
        return pathWrite;
    }

    static /* synthetic */ Path d(Path path, Iterable lines, Charset charset, int i7, Object obj) throws IOException {
        if ((i7 & 2) != 0) {
            charset = kotlin.text.f.f35353b;
        }
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(lines, "lines");
        kotlin.jvm.internal.l0.p(charset, "charset");
        Path pathWrite = Files.write(path, lines, charset, k.a(StandardOpenOption.APPEND));
        kotlin.jvm.internal.l0.o(pathWrite, "write(this, lines, chars…tandardOpenOption.APPEND)");
        return pathWrite;
    }

    static /* synthetic */ Path e(Path path, kotlin.sequences.m lines, Charset charset, int i7, Object obj) throws IOException {
        if ((i7 & 2) != 0) {
            charset = kotlin.text.f.f35353b;
        }
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(lines, "lines");
        kotlin.jvm.internal.l0.p(charset, "charset");
        Path pathWrite = Files.write(path, kotlin.sequences.u.N(lines), charset, k.a(StandardOpenOption.APPEND));
        kotlin.jvm.internal.l0.o(pathWrite, "write(this, lines.asIter…tandardOpenOption.APPEND)");
        return pathWrite;
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    public static final void f(@a7.d Path path, @a7.d CharSequence text, @a7.d Charset charset) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(text, "text");
        kotlin.jvm.internal.l0.p(charset, "charset");
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(path, k.a(StandardOpenOption.APPEND));
        kotlin.jvm.internal.l0.o(outputStreamNewOutputStream, "newOutputStream(this, StandardOpenOption.APPEND)");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStreamNewOutputStream, charset);
        try {
            outputStreamWriter.append(text);
            kotlin.io.c.a(outputStreamWriter, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.io.c.a(outputStreamWriter, th);
                throw th2;
            }
        }
    }

    public static /* synthetic */ void g(Path path, CharSequence charSequence, Charset charset, int i7, Object obj) throws IOException {
        if ((i7 & 2) != 0) {
            charset = kotlin.text.f.f35353b;
        }
        f(path, charSequence, charset);
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final BufferedReader h(Path path, Charset charset, int i7, OpenOption... options) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(charset, "charset");
        kotlin.jvm.internal.l0.p(options, "options");
        return new BufferedReader(new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length)), charset), i7);
    }

    static /* synthetic */ BufferedReader i(Path path, Charset charset, int i7, OpenOption[] options, int i8, Object obj) throws IOException {
        if ((i8 & 1) != 0) {
            charset = kotlin.text.f.f35353b;
        }
        if ((i8 & 2) != 0) {
            i7 = 8192;
        }
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(charset, "charset");
        kotlin.jvm.internal.l0.p(options, "options");
        return new BufferedReader(new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length)), charset), i7);
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final BufferedWriter j(Path path, Charset charset, int i7, OpenOption... options) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(charset, "charset");
        kotlin.jvm.internal.l0.p(options, "options");
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length)), charset), i7);
    }

    static /* synthetic */ BufferedWriter k(Path path, Charset charset, int i7, OpenOption[] options, int i8, Object obj) throws IOException {
        if ((i8 & 1) != 0) {
            charset = kotlin.text.f.f35353b;
        }
        if ((i8 & 2) != 0) {
            i7 = 8192;
        }
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(charset, "charset");
        kotlin.jvm.internal.l0.p(options, "options");
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length)), charset), i7);
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final void l(Path path, Charset charset, i5.l<? super String, l2> action) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(charset, "charset");
        kotlin.jvm.internal.l0.p(action, "action");
        BufferedReader bufferedReaderNewBufferedReader = Files.newBufferedReader(path, charset);
        kotlin.jvm.internal.l0.o(bufferedReaderNewBufferedReader, "newBufferedReader(this, charset)");
        try {
            Iterator<String> it = kotlin.io.y.h(bufferedReaderNewBufferedReader).iterator();
            while (it.hasNext()) {
                action.z(it.next());
            }
            l2 l2Var = l2.f34958a;
            kotlin.jvm.internal.i0.d(1);
            kotlin.io.c.a(bufferedReaderNewBufferedReader, null);
            kotlin.jvm.internal.i0.c(1);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.jvm.internal.i0.d(1);
                kotlin.io.c.a(bufferedReaderNewBufferedReader, th);
                kotlin.jvm.internal.i0.c(1);
                throw th2;
            }
        }
    }

    static /* synthetic */ void m(Path path, Charset charset, i5.l action, int i7, Object obj) throws IOException {
        if ((i7 & 1) != 0) {
            charset = kotlin.text.f.f35353b;
        }
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(charset, "charset");
        kotlin.jvm.internal.l0.p(action, "action");
        BufferedReader bufferedReaderNewBufferedReader = Files.newBufferedReader(path, charset);
        kotlin.jvm.internal.l0.o(bufferedReaderNewBufferedReader, "newBufferedReader(this, charset)");
        try {
            Iterator<String> it = kotlin.io.y.h(bufferedReaderNewBufferedReader).iterator();
            while (it.hasNext()) {
                action.z(it.next());
            }
            l2 l2Var = l2.f34958a;
            kotlin.jvm.internal.i0.d(1);
            kotlin.io.c.a(bufferedReaderNewBufferedReader, null);
            kotlin.jvm.internal.i0.c(1);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.jvm.internal.i0.d(1);
                kotlin.io.c.a(bufferedReaderNewBufferedReader, th);
                kotlin.jvm.internal.i0.c(1);
                throw th2;
            }
        }
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final InputStream n(Path path, OpenOption... options) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(options, "options");
        InputStream inputStreamNewInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.l0.o(inputStreamNewInputStream, "newInputStream(this, *options)");
        return inputStreamNewInputStream;
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final OutputStream o(Path path, OpenOption... options) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(options, "options");
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.l0.o(outputStreamNewOutputStream, "newOutputStream(this, *options)");
        return outputStreamNewOutputStream;
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final byte[] p(Path path) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        byte[] allBytes = Files.readAllBytes(path);
        kotlin.jvm.internal.l0.o(allBytes, "readAllBytes(this)");
        return allBytes;
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final List<String> q(Path path, Charset charset) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(charset, "charset");
        List<String> allLines = Files.readAllLines(path, charset);
        kotlin.jvm.internal.l0.o(allLines, "readAllLines(this, charset)");
        return allLines;
    }

    static /* synthetic */ List r(Path path, Charset charset, int i7, Object obj) throws IOException {
        if ((i7 & 1) != 0) {
            charset = kotlin.text.f.f35353b;
        }
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(charset, "charset");
        List allLines = Files.readAllLines(path, charset);
        kotlin.jvm.internal.l0.o(allLines, "readAllLines(this, charset)");
        return allLines;
    }

    @a7.d
    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    public static final String s(@a7.d Path path, @a7.d Charset charset) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0)), charset);
        try {
            String strK = kotlin.io.y.k(inputStreamReader);
            kotlin.io.c.a(inputStreamReader, null);
            return strK;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.io.c.a(inputStreamReader, th);
                throw th2;
            }
        }
    }

    public static /* synthetic */ String t(Path path, Charset charset, int i7, Object obj) throws IOException {
        if ((i7 & 1) != 0) {
            charset = kotlin.text.f.f35353b;
        }
        return s(path, charset);
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final InputStreamReader u(Path path, Charset charset, OpenOption... options) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(charset, "charset");
        kotlin.jvm.internal.l0.p(options, "options");
        return new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length)), charset);
    }

    static /* synthetic */ InputStreamReader v(Path path, Charset charset, OpenOption[] options, int i7, Object obj) throws IOException {
        if ((i7 & 1) != 0) {
            charset = kotlin.text.f.f35353b;
        }
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(charset, "charset");
        kotlin.jvm.internal.l0.p(options, "options");
        return new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length)), charset);
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final <T> T w(Path path, Charset charset, i5.l<? super kotlin.sequences.m<String>, ? extends T> block) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(charset, "charset");
        kotlin.jvm.internal.l0.p(block, "block");
        BufferedReader it = Files.newBufferedReader(path, charset);
        try {
            kotlin.jvm.internal.l0.o(it, "it");
            T tZ = block.z(kotlin.io.y.h(it));
            kotlin.jvm.internal.i0.d(1);
            kotlin.io.c.a(it, null);
            kotlin.jvm.internal.i0.c(1);
            return tZ;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.jvm.internal.i0.d(1);
                kotlin.io.c.a(it, th);
                kotlin.jvm.internal.i0.c(1);
                throw th2;
            }
        }
    }

    static /* synthetic */ Object x(Path path, Charset charset, i5.l block, int i7, Object obj) throws IOException {
        if ((i7 & 1) != 0) {
            charset = kotlin.text.f.f35353b;
        }
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(charset, "charset");
        kotlin.jvm.internal.l0.p(block, "block");
        BufferedReader it = Files.newBufferedReader(path, charset);
        try {
            kotlin.jvm.internal.l0.o(it, "it");
            Object objZ = block.z(kotlin.io.y.h(it));
            kotlin.jvm.internal.i0.d(1);
            kotlin.io.c.a(it, null);
            kotlin.jvm.internal.i0.c(1);
            return objZ;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.jvm.internal.i0.d(1);
                kotlin.io.c.a(it, th);
                kotlin.jvm.internal.i0.c(1);
                throw th2;
            }
        }
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final void y(Path path, byte[] array, OpenOption... options) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(array, "array");
        kotlin.jvm.internal.l0.p(options, "options");
        Files.write(path, array, (OpenOption[]) Arrays.copyOf(options, options.length));
    }

    @g1(version = "1.5")
    @q2(markerClass = {a.class})
    @kotlin.internal.f
    private static final Path z(Path path, Iterable<? extends CharSequence> lines, Charset charset, OpenOption... options) throws IOException {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(lines, "lines");
        kotlin.jvm.internal.l0.p(charset, "charset");
        kotlin.jvm.internal.l0.p(options, "options");
        Path pathWrite = Files.write(path, lines, charset, (OpenOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.l0.o(pathWrite, "write(this, lines, charset, *options)");
        return pathWrite;
    }
}
