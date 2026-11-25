package com.bumptech.glide.load.data;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class d extends FilterInputStream {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f14193c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final byte[] f14194d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f14195e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f14196f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte f14197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14198b;

    static {
        byte[] bArr = {-1, -31, 0, com.google.common.base.c.F, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, com.google.common.base.c.f19321u, 0, 2, 0, 0, 0, 1, 0};
        f14194d = bArr;
        int length = bArr.length;
        f14195e = length;
        f14196f = length + 2;
    }

    public d(InputStream inputStream, int i7) {
        super(inputStream);
        if (i7 >= -1 && i7 <= 8) {
            this.f14197a = (byte) i7;
            return;
        }
        throw new IllegalArgumentException("Cannot add invalid orientation: " + i7);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i7) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i7;
        int i8;
        int i9 = this.f14198b;
        if (i9 < 2 || i9 > (i8 = f14196f)) {
            i7 = super.read();
        } else {
            i7 = i9 == i8 ? this.f14197a : f14194d[i9 - 2] & 255;
        }
        if (i7 != -1) {
            this.f14198b++;
        }
        return i7;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j7) throws IOException {
        long jSkip = super.skip(j7);
        if (jSkip > 0) {
            this.f14198b = (int) (((long) this.f14198b) + jSkip);
        }
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i7, int i8) throws IOException {
        int i9;
        int i10 = this.f14198b;
        int i11 = f14196f;
        if (i10 > i11) {
            i9 = super.read(bArr, i7, i8);
        } else if (i10 == i11) {
            bArr[i7] = this.f14197a;
            i9 = 1;
        } else if (i10 < 2) {
            i9 = super.read(bArr, i7, 2 - i10);
        } else {
            int iMin = Math.min(i11 - i10, i8);
            System.arraycopy(f14194d, this.f14198b - 2, bArr, i7, iMin);
            i9 = iMin;
        }
        if (i9 > 0) {
            this.f14198b += i9;
        }
        return i9;
    }
}
