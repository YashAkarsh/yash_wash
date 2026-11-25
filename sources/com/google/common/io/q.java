package com.google.common.io;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f22004a = 2048;

    private static final class a extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f22005a = new a();

        private a() {
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(char c8) {
            return this;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return "CharStreams.nullWriter()";
        }

        @Override // java.io.Writer
        public void write(int i7) {
        }

        @Override // java.io.Writer
        public void write(char[] cArr) {
            com.google.common.base.e0.E(cArr);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i7, int i8) {
            com.google.common.base.e0.f0(i7, i8 + i7, cArr.length);
        }

        @Override // java.io.Writer
        public void write(String str) {
            com.google.common.base.e0.E(str);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence) {
            com.google.common.base.e0.E(charSequence);
            return this;
        }

        @Override // java.io.Writer
        public void write(String str, int i7, int i8) {
            com.google.common.base.e0.f0(i7, i8 + i7, str.length());
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence, int i7, int i8) {
            com.google.common.base.e0.f0(i7, i8, charSequence.length());
            return this;
        }
    }

    private q() {
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new com.google.common.io.a(appendable);
    }

    @u1.a
    public static long b(Readable readable, Appendable appendable) throws IOException {
        if (readable instanceof Reader) {
            return appendable instanceof StringBuilder ? c((Reader) readable, (StringBuilder) appendable) : d((Reader) readable, a(appendable));
        }
        com.google.common.base.e0.E(readable);
        com.google.common.base.e0.E(appendable);
        CharBuffer charBufferE = e();
        long jRemaining = 0;
        while (readable.read(charBufferE) != -1) {
            charBufferE.flip();
            appendable.append(charBufferE);
            jRemaining += (long) charBufferE.remaining();
            charBufferE.clear();
        }
        return jRemaining;
    }

    @u1.a
    static long c(Reader reader, StringBuilder sb) throws IOException {
        com.google.common.base.e0.E(reader);
        com.google.common.base.e0.E(sb);
        char[] cArr = new char[2048];
        long j7 = 0;
        while (true) {
            int i7 = reader.read(cArr);
            if (i7 == -1) {
                return j7;
            }
            sb.append(cArr, 0, i7);
            j7 += (long) i7;
        }
    }

    @u1.a
    static long d(Reader reader, Writer writer) throws IOException {
        com.google.common.base.e0.E(reader);
        com.google.common.base.e0.E(writer);
        char[] cArr = new char[2048];
        long j7 = 0;
        while (true) {
            int i7 = reader.read(cArr);
            if (i7 == -1) {
                return j7;
            }
            writer.write(cArr, 0, i7);
            j7 += (long) i7;
        }
    }

    static CharBuffer e() {
        return CharBuffer.allocate(2048);
    }

    @u1.a
    public static long f(Readable readable) throws IOException {
        CharBuffer charBufferE = e();
        long j7 = 0;
        while (true) {
            long j8 = readable.read(charBufferE);
            if (j8 == -1) {
                return j7;
            }
            j7 += j8;
            charBufferE.clear();
        }
    }

    public static Writer g() {
        return a.f22005a;
    }

    @u1.a
    public static <T> T h(Readable readable, b0<T> b0Var) throws IOException {
        String strB;
        com.google.common.base.e0.E(readable);
        com.google.common.base.e0.E(b0Var);
        c0 c0Var = new c0(readable);
        do {
            strB = c0Var.b();
            if (strB == null) {
                break;
            }
        } while (b0Var.b(strB));
        return b0Var.a();
    }

    public static List<String> i(Readable readable) throws IOException {
        ArrayList arrayList = new ArrayList();
        c0 c0Var = new c0(readable);
        while (true) {
            String strB = c0Var.b();
            if (strB == null) {
                return arrayList;
            }
            arrayList.add(strB);
        }
    }

    public static void j(Reader reader, long j7) throws IOException {
        com.google.common.base.e0.E(reader);
        while (j7 > 0) {
            long jSkip = reader.skip(j7);
            if (jSkip == 0) {
                throw new EOFException();
            }
            j7 -= jSkip;
        }
    }

    public static String k(Readable readable) throws IOException {
        return l(readable).toString();
    }

    private static StringBuilder l(Readable readable) throws IOException {
        StringBuilder sb = new StringBuilder();
        if (readable instanceof Reader) {
            c((Reader) readable, sb);
        } else {
            b(readable, sb);
        }
        return sb;
    }
}
