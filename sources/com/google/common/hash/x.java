package com.google.common.hash;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
public final class x extends FilterOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u f21887a;

    public x(s sVar, OutputStream outputStream) {
        super((OutputStream) com.google.common.base.e0.E(outputStream));
        this.f21887a = (u) com.google.common.base.e0.E(sVar.b());
    }

    public r b() {
        return this.f21887a.o();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i7) throws IOException {
        this.f21887a.h((byte) i7);
        ((FilterOutputStream) this).out.write(i7);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i7, int i8) throws IOException {
        this.f21887a.j(bArr, i7, i8);
        ((FilterOutputStream) this).out.write(bArr, i7, i8);
    }
}
