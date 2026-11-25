package com.nostra13.universalimageloader.core.assist;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class a extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputStream f32630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f32631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f32632c;

    public a(InputStream inputStream, long j7) {
        this.f32630a = inputStream;
        this.f32631b = j7;
    }

    @Override // java.io.InputStream
    public synchronized int available() {
        return (int) (this.f32631b - this.f32632c);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f32630a.close();
    }

    @Override // java.io.InputStream
    public void mark(int i7) {
        this.f32632c = i7;
        this.f32630a.mark(i7);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        this.f32632c++;
        return this.f32630a.read();
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f32632c = 0L;
        this.f32630a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j7) throws IOException {
        this.f32632c += j7;
        return this.f32630a.skip(j7);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i7, int i8) throws IOException {
        this.f32632c += (long) i8;
        return this.f32630a.read(bArr, i7, i8);
    }
}
