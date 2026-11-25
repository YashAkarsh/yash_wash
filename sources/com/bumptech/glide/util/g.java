package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class g extends FilterInputStream {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f14928b = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f14929c = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14930a;

    public g(InputStream inputStream) {
        super(inputStream);
        this.f14930a = Integer.MIN_VALUE;
    }

    private long c(long j7) {
        int i7 = this.f14930a;
        if (i7 == 0) {
            return -1L;
        }
        return (i7 == Integer.MIN_VALUE || j7 <= ((long) i7)) ? j7 : i7;
    }

    private void e(long j7) {
        int i7 = this.f14930a;
        if (i7 == Integer.MIN_VALUE || j7 == -1) {
            return;
        }
        this.f14930a = (int) (((long) i7) - j7);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int i7 = this.f14930a;
        return i7 == Integer.MIN_VALUE ? super.available() : Math.min(i7, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i7) {
        super.mark(i7);
        this.f14930a = i7;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (c(1L) == -1) {
            return -1;
        }
        int i7 = super.read();
        e(1L);
        return i7;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        super.reset();
        this.f14930a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j7) throws IOException {
        long jC = c(j7);
        if (jC == -1) {
            return -1L;
        }
        long jSkip = super.skip(jC);
        e(jSkip);
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i7, int i8) throws IOException {
        int iC = (int) c(i8);
        if (iC == -1) {
            return -1;
        }
        int i9 = super.read(bArr, i7, iC);
        e(i9);
        return i9;
    }
}
