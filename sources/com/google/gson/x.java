package com.google.gson;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class x<T> {

    class a extends x<T> {
        a() {
        }

        @Override // com.google.gson.x
        public T e(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.J0() != com.google.gson.stream.c.NULL) {
                return (T) x.this.e(aVar);
            }
            aVar.v0();
            return null;
        }

        @Override // com.google.gson.x
        public void i(com.google.gson.stream.d dVar, T t7) throws IOException {
            if (t7 == null) {
                dVar.g0();
            } else {
                x.this.i(dVar, t7);
            }
        }
    }

    public final T a(Reader reader) throws IOException {
        return e(new com.google.gson.stream.a(reader));
    }

    public final T b(String str) throws IOException {
        return a(new StringReader(str));
    }

    public final T c(l lVar) {
        try {
            return e(new com.google.gson.internal.bind.a(lVar));
        } catch (IOException e8) {
            throw new m(e8);
        }
    }

    public final x<T> d() {
        return new a();
    }

    public abstract T e(com.google.gson.stream.a aVar) throws IOException;

    public final String f(T t7) {
        StringWriter stringWriter = new StringWriter();
        try {
            g(stringWriter, t7);
            return stringWriter.toString();
        } catch (IOException e8) {
            throw new AssertionError(e8);
        }
    }

    public final void g(Writer writer, T t7) throws IOException {
        i(new com.google.gson.stream.d(writer), t7);
    }

    public final l h(T t7) {
        try {
            com.google.gson.internal.bind.b bVar = new com.google.gson.internal.bind.b();
            i(bVar, t7);
            return bVar.a1();
        } catch (IOException e8) {
            throw new m(e8);
        }
    }

    public abstract void i(com.google.gson.stream.d dVar, T t7) throws IOException;
}
