package com.google.common.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public final class t extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f22024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f22025b;

    public t(InputStream inputStream) {
        super((InputStream) com.google.common.base.e0.E(inputStream));
        this.f22025b = -1L;
    }

    public long b() {
        return this.f22024a;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i7) {
        ((FilterInputStream) this).in.mark(i7);
        this.f22025b = this.f22024a;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i7 = ((FilterInputStream) this).in.read();
        if (i7 != -1) {
            this.f22024a++;
        }
        return i7;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (!((FilterInputStream) this).in.markSupported()) {
            throw new IOException("Mark not supported");
        }
        if (this.f22025b == -1) {
            throw new IOException("Mark not set");
        }
        ((FilterInputStream) this).in.reset();
        this.f22024a = this.f22025b;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j7) throws IOException {
        long jSkip = ((FilterInputStream) this).in.skip(j7);
        this.f22024a += jSkip;
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i7, int i8) throws IOException {
        int i9 = ((FilterInputStream) this).in.read(bArr, i7, i8);
        if (i9 != -1) {
            this.f22024a += (long) i9;
        }
        return i9;
    }
}
