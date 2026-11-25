package com.google.common.io;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
class a extends Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Appendable f21898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f21899b;

    a(Appendable appendable) {
        this.f21898a = (Appendable) com.google.common.base.e0.E(appendable);
    }

    private void b() throws IOException {
        if (this.f21899b) {
            throw new IOException("Cannot write to a closed writer.");
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f21899b = true;
        Appendable appendable = this.f21898a;
        if (appendable instanceof Closeable) {
            ((Closeable) appendable).close();
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        b();
        Appendable appendable = this.f21898a;
        if (appendable instanceof Flushable) {
            ((Flushable) appendable).flush();
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i7, int i8) throws IOException {
        b();
        this.f21898a.append(new String(cArr, i7, i8));
    }

    @Override // java.io.Writer
    public void write(int i7) throws IOException {
        b();
        this.f21898a.append((char) i7);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c8) throws IOException {
        b();
        this.f21898a.append(c8);
        return this;
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        b();
        this.f21898a.append(str);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) throws IOException {
        b();
        this.f21898a.append(charSequence);
        return this;
    }

    @Override // java.io.Writer
    public void write(String str, int i7, int i8) throws IOException {
        b();
        this.f21898a.append(str, i7, i8 + i7);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i7, int i8) throws IOException {
        b();
        this.f21898a.append(charSequence, i7, i8);
        return this;
    }
}
