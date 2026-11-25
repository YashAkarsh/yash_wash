package kotlin.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.i0;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;
import kotlin.l2;

/* JADX INFO: loaded from: classes2.dex */
@h5.h(name = "TextStreamsKt")
public final class y {

    static final class a extends n0 implements i5.l<String, l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList<String> f34810a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ArrayList<String> arrayList) {
            super(1);
            this.f34810a = arrayList;
        }

        public final void b(@a7.d String it) {
            l0.p(it, "it");
            this.f34810a.add(it);
        }

        @Override // i5.l
        public /* bridge */ /* synthetic */ l2 z(String str) {
            b(str);
            return l2.f34958a;
        }
    }

    @kotlin.internal.f
    private static final BufferedReader a(Reader reader, int i7) {
        l0.p(reader, "<this>");
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i7);
    }

    @kotlin.internal.f
    private static final BufferedWriter b(Writer writer, int i7) {
        l0.p(writer, "<this>");
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i7);
    }

    static /* synthetic */ BufferedReader c(Reader reader, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i7 = 8192;
        }
        l0.p(reader, "<this>");
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i7);
    }

    static /* synthetic */ BufferedWriter d(Writer writer, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i7 = 8192;
        }
        l0.p(writer, "<this>");
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i7);
    }

    public static final long e(@a7.d Reader reader, @a7.d Writer out, int i7) throws IOException {
        l0.p(reader, "<this>");
        l0.p(out, "out");
        char[] cArr = new char[i7];
        int i8 = reader.read(cArr);
        long j7 = 0;
        while (i8 >= 0) {
            out.write(cArr, 0, i8);
            j7 += (long) i8;
            i8 = reader.read(cArr);
        }
        return j7;
    }

    public static /* synthetic */ long f(Reader reader, Writer writer, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = 8192;
        }
        return e(reader, writer, i7);
    }

    public static final void g(@a7.d Reader reader, @a7.d i5.l<? super String, l2> action) {
        l0.p(reader, "<this>");
        l0.p(action, "action");
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, 8192);
        try {
            Iterator<String> it = h(bufferedReader).iterator();
            while (it.hasNext()) {
                action.z(it.next());
            }
            l2 l2Var = l2.f34958a;
            c.a(bufferedReader, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                c.a(bufferedReader, th);
                throw th2;
            }
        }
    }

    @a7.d
    public static final kotlin.sequences.m<String> h(@a7.d BufferedReader bufferedReader) {
        l0.p(bufferedReader, "<this>");
        return kotlin.sequences.s.f(new s(bufferedReader));
    }

    @a7.d
    public static final byte[] i(@a7.d URL url) throws IOException {
        l0.p(url, "<this>");
        InputStream it = url.openStream();
        try {
            l0.o(it, "it");
            byte[] bArrP = b.p(it);
            c.a(it, null);
            return bArrP;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                c.a(it, th);
                throw th2;
            }
        }
    }

    @a7.d
    public static final List<String> j(@a7.d Reader reader) {
        l0.p(reader, "<this>");
        ArrayList arrayList = new ArrayList();
        g(reader, new a(arrayList));
        return arrayList;
    }

    @a7.d
    public static final String k(@a7.d Reader reader) {
        l0.p(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        f(reader, stringWriter, 0, 2, null);
        String string = stringWriter.toString();
        l0.o(string, "buffer.toString()");
        return string;
    }

    @kotlin.internal.f
    private static final String l(URL url, Charset charset) {
        l0.p(url, "<this>");
        l0.p(charset, "charset");
        return new String(i(url), charset);
    }

    static /* synthetic */ String m(URL url, Charset charset, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            charset = kotlin.text.f.f35353b;
        }
        l0.p(url, "<this>");
        l0.p(charset, "charset");
        return new String(i(url), charset);
    }

    @kotlin.internal.f
    private static final StringReader n(String str) {
        l0.p(str, "<this>");
        return new StringReader(str);
    }

    public static final <T> T o(@a7.d Reader reader, @a7.d i5.l<? super kotlin.sequences.m<String>, ? extends T> block) {
        l0.p(reader, "<this>");
        l0.p(block, "block");
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, 8192);
        try {
            T tZ = block.z(h(bufferedReader));
            i0.d(1);
            c.a(bufferedReader, null);
            i0.c(1);
            return tZ;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                i0.d(1);
                c.a(bufferedReader, th);
                i0.c(1);
                throw th2;
            }
        }
    }
}
