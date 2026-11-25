package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class p extends FilterInputStream {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f14588f = "BufferedIs";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile byte[] f14589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f14591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14592d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14593e;

    public static class a extends RuntimeException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final long f14594a = -4338378848813561757L;

        public a(String str) {
            super(str);
        }
    }

    public p(InputStream inputStream, byte[] bArr) {
        super(inputStream);
        this.f14592d = -1;
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("buffer is null or empty");
        }
        this.f14589a = bArr;
    }

    private int b(InputStream inputStream, byte[] bArr) throws IOException {
        int i7 = this.f14592d;
        if (i7 != -1) {
            int i8 = this.f14593e - i7;
            int i9 = this.f14591c;
            if (i8 < i9) {
                if (i7 == 0 && i9 > bArr.length && this.f14590b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i9) {
                        i9 = length;
                    }
                    if (Log.isLoggable(f14588f, 3)) {
                        Log.d(f14588f, "allocate buffer of length: " + i9);
                    }
                    byte[] bArr2 = new byte[i9];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f14589a = bArr2;
                    bArr = bArr2;
                } else if (i7 > 0) {
                    System.arraycopy(bArr, i7, bArr, 0, bArr.length - i7);
                }
                int i10 = this.f14593e - this.f14592d;
                this.f14593e = i10;
                this.f14592d = 0;
                this.f14590b = 0;
                int i11 = inputStream.read(bArr, i10, bArr.length - i10);
                int i12 = this.f14593e;
                if (i11 > 0) {
                    i12 += i11;
                }
                this.f14590b = i12;
                return i11;
            }
        }
        int i13 = inputStream.read(bArr);
        if (i13 > 0) {
            this.f14592d = -1;
            this.f14593e = 0;
            this.f14590b = i13;
        }
        return i13;
    }

    private static IOException q() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f14589a == null || inputStream == null) {
            throw q();
        }
        return (this.f14590b - this.f14593e) + inputStream.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f14589a = null;
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void e() {
        this.f14591c = this.f14589a.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i7) {
        this.f14591c = Math.max(this.f14591c, i7);
        this.f14592d = this.f14593e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.f14589a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            throw q();
        }
        if (this.f14593e >= this.f14590b && b(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.f14589a && (bArr = this.f14589a) == null) {
            throw q();
        }
        int i7 = this.f14590b;
        int i8 = this.f14593e;
        if (i7 - i8 <= 0) {
            return -1;
        }
        this.f14593e = i8 + 1;
        return bArr[i8] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.f14589a == null) {
            throw new IOException("Stream is closed");
        }
        int i7 = this.f14592d;
        if (-1 == i7) {
            throw new a("Mark has been invalidated");
        }
        this.f14593e = i7;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j7) throws IOException {
        byte[] bArr = this.f14589a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null) {
            throw q();
        }
        if (j7 < 1) {
            return 0L;
        }
        if (inputStream == null) {
            throw q();
        }
        int i7 = this.f14590b;
        int i8 = this.f14593e;
        if (i7 - i8 >= j7) {
            this.f14593e = (int) (((long) i8) + j7);
            return j7;
        }
        long j8 = i7 - i8;
        this.f14593e = i7;
        if (this.f14592d == -1 || j7 > this.f14591c) {
            return j8 + inputStream.skip(j7 - j8);
        }
        if (b(inputStream, bArr) == -1) {
            return j8;
        }
        int i9 = this.f14590b;
        int i10 = this.f14593e;
        long j9 = j7 - j8;
        if (i9 - i10 >= j9) {
            this.f14593e = (int) (((long) i10) + j9);
            return j7;
        }
        long j10 = (j8 + ((long) i9)) - ((long) i10);
        this.f14593e = i9;
        return j10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i7, int i8) throws IOException {
        int i9;
        int i10;
        byte[] bArr2 = this.f14589a;
        if (bArr2 == null) {
            throw q();
        }
        if (i8 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i11 = this.f14593e;
            int i12 = this.f14590b;
            if (i11 < i12) {
                int i13 = i12 - i11 >= i8 ? i8 : i12 - i11;
                System.arraycopy(bArr2, i11, bArr, i7, i13);
                this.f14593e += i13;
                if (i13 == i8 || inputStream.available() == 0) {
                    return i13;
                }
                i7 += i13;
                i9 = i8 - i13;
            } else {
                i9 = i8;
            }
            while (true) {
                if (this.f14592d == -1 && i9 >= bArr2.length) {
                    i10 = inputStream.read(bArr, i7, i9);
                    if (i10 == -1) {
                        return i9 != i8 ? i8 - i9 : -1;
                    }
                } else {
                    if (b(inputStream, bArr2) == -1) {
                        return i9 != i8 ? i8 - i9 : -1;
                    }
                    if (bArr2 != this.f14589a && (bArr2 = this.f14589a) == null) {
                        throw q();
                    }
                    int i14 = this.f14590b;
                    int i15 = this.f14593e;
                    i10 = i14 - i15 >= i9 ? i9 : i14 - i15;
                    System.arraycopy(bArr2, i15, bArr, i7, i10);
                    this.f14593e += i10;
                }
                i9 -= i10;
                if (i9 == 0) {
                    return i8;
                }
                if (inputStream.available() == 0) {
                    return i8 - i9;
                }
                i7 += i10;
            }
        } else {
            throw q();
        }
    }
}
