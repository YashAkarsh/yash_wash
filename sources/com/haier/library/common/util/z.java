package com.haier.library.common.util;

import java.io.Serializable;
import java.io.Writer;

/* JADX INFO: loaded from: classes2.dex */
public class z extends Writer implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f26642b = -146927496096066153L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StringBuilder f26643a;

    public z() {
        this.f26643a = new StringBuilder();
    }

    public StringBuilder b() {
        return this.f26643a;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    public String toString() {
        return this.f26643a.toString();
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str != null) {
            this.f26643a.append(str);
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i7, int i8) {
        if (cArr != null) {
            this.f26643a.append(cArr, i7, i8);
        }
    }

    public z(int i7) {
        this.f26643a = new StringBuilder(i7);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c8) {
        this.f26643a.append(c8);
        return this;
    }

    public z(StringBuilder sb) {
        this.f26643a = sb == null ? new StringBuilder() : sb;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) {
        this.f26643a.append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i7, int i8) {
        this.f26643a.append(charSequence, i7, i8);
        return this;
    }
}
