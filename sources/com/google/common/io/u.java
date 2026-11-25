package com.google.common.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public final class u extends FilterOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f22026a;

    public u(OutputStream outputStream) {
        super((OutputStream) com.google.common.base.e0.E(outputStream));
    }

    public long b() {
        return this.f22026a;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i7, int i8) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i7, i8);
        this.f22026a += (long) i8;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i7) throws IOException {
        ((FilterOutputStream) this).out.write(i7);
        this.f22026a++;
    }
}
