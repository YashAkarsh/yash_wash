package com.google.gson;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class u implements Iterator<l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.gson.stream.a f23307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f23308b;

    public u(String str) {
        this(new StringReader(str));
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public l next() throws p {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        try {
            return com.google.gson.internal.m.a(this.f23307a);
        } catch (p e8) {
            if (e8.getCause() instanceof EOFException) {
                throw new NoSuchElementException();
            }
            throw e8;
        } catch (OutOfMemoryError e9) {
            throw new p("Failed parsing JSON source to Json", e9);
        } catch (StackOverflowError e10) {
            throw new p("Failed parsing JSON source to Json", e10);
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        boolean z7;
        synchronized (this.f23308b) {
            try {
                try {
                    try {
                        z7 = this.f23307a.J0() != com.google.gson.stream.c.END_DOCUMENT;
                    } catch (IOException e8) {
                        throw new m(e8);
                    }
                } catch (com.google.gson.stream.e e9) {
                    throw new v(e9);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z7;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public u(Reader reader) {
        com.google.gson.stream.a aVar = new com.google.gson.stream.a(reader);
        this.f23307a = aVar;
        aVar.Y0(true);
        this.f23308b = new Object();
    }
}
