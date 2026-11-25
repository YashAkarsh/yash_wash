package com.haier.library.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f26613a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f26614b = 4096;

    public static int a(Reader reader, Writer writer) throws IOException {
        long jI = i(reader, writer);
        if (jI > 2147483647L) {
            return -1;
        }
        return (int) jI;
    }

    public static long b(Reader reader, Writer writer, char[] cArr) throws IOException {
        long j7 = 0;
        while (true) {
            int i7 = reader.read(cArr);
            if (-1 == i7) {
                return j7;
            }
            writer.write(cArr, 0, i7);
            j7 += (long) i7;
        }
    }

    public static String c(InputStream inputStream, Charset charset) throws IOException {
        z zVar = new z();
        try {
            f(inputStream, zVar, charset);
            String string = zVar.toString();
            zVar.close();
            return string;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    zVar.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    private static Charset d(String str) {
        return str == null ? Charset.defaultCharset() : Charset.forName(str);
    }

    private static Charset e(Charset charset) {
        return charset == null ? Charset.defaultCharset() : charset;
    }

    public static void f(InputStream inputStream, Writer writer, Charset charset) throws IOException {
        a(new InputStreamReader(inputStream, e(charset)), writer);
    }

    public static void g(String str, OutputStream outputStream, String str2) throws IOException {
        h(str, outputStream, d(str2));
    }

    public static void h(String str, OutputStream outputStream, Charset charset) throws IOException {
        if (str != null) {
            outputStream.write(str.getBytes(e(charset)));
        }
    }

    public static long i(Reader reader, Writer writer) throws IOException {
        return b(reader, writer, new char[4096]);
    }
}
