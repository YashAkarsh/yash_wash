package com.google.common.hash;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
public final class w extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u f21886a;

    public w(s sVar, InputStream inputStream) {
        super((InputStream) com.google.common.base.e0.E(inputStream));
        this.f21886a = (u) com.google.common.base.e0.E(sVar.b());
    }

    public r b() {
        return this.f21886a.o();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i7) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    @u1.a
    public int read() throws IOException {
        int i7 = ((FilterInputStream) this).in.read();
        if (i7 != -1) {
            this.f21886a.h((byte) i7);
        }
        return i7;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new IOException("reset not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    @u1.a
    public int read(byte[] bArr, int i7, int i8) throws IOException {
        int i9 = ((FilterInputStream) this).in.read(bArr, i7, i8);
        if (i9 != -1) {
            this.f21886a.j(bArr, i7, i9);
        }
        return i9;
    }
}
