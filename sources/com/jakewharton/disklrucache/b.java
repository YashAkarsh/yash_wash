package com.jakewharton.disklrucache;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
class b implements Closeable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final byte f32267f = 13;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final byte f32268g = 10;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputStream f32269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Charset f32270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f32271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f32272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f32273e;

    class a extends ByteArrayOutputStream {
        a(int i7) {
            super(i7);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i7 = ((ByteArrayOutputStream) this).count;
            if (i7 > 0 && ((ByteArrayOutputStream) this).buf[i7 - 1] == 13) {
                i7--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i7, b.this.f32270b.name());
            } catch (UnsupportedEncodingException e8) {
                throw new AssertionError(e8);
            }
        }
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void e() throws IOException {
        InputStream inputStream = this.f32269a;
        byte[] bArr = this.f32271c;
        int i7 = inputStream.read(bArr, 0, bArr.length);
        if (i7 == -1) {
            throw new EOFException();
        }
        this.f32272d = 0;
        this.f32273e = i7;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f32269a) {
            if (this.f32271c != null) {
                this.f32271c = null;
                this.f32269a.close();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x002b  */
    public String q() throws IOException {
        int i7;
        byte[] bArr;
        int i8;
        synchronized (this.f32269a) {
            if (this.f32271c == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.f32272d >= this.f32273e) {
                e();
            }
            for (int i9 = this.f32272d; i9 != this.f32273e; i9++) {
                byte[] bArr2 = this.f32271c;
                if (bArr2[i9] == 10) {
                    int i10 = this.f32272d;
                    if (i9 != i10) {
                        i8 = i9 - 1;
                        if (bArr2[i8] != 13) {
                            i8 = i9;
                        }
                    } else {
                        i8 = i9;
                    }
                    String str = new String(bArr2, i10, i8 - i10, this.f32270b.name());
                    this.f32272d = i9 + 1;
                    return str;
                }
            }
            a aVar = new a((this.f32273e - this.f32272d) + 80);
            loop1: while (true) {
                byte[] bArr3 = this.f32271c;
                int i11 = this.f32272d;
                aVar.write(bArr3, i11, this.f32273e - i11);
                this.f32273e = -1;
                e();
                i7 = this.f32272d;
                while (i7 != this.f32273e) {
                    bArr = this.f32271c;
                    if (bArr[i7] == 10) {
                        break loop1;
                    }
                    i7++;
                }
            }
            int i12 = this.f32272d;
            if (i7 != i12) {
                aVar.write(bArr, i12, i7 - i12);
            }
            this.f32272d = i7 + 1;
            return aVar.toString();
        }
    }

    public b(InputStream inputStream, int i7, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i7 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(c.f32275a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f32269a = inputStream;
        this.f32270b = charset;
        this.f32271c = new byte[i7];
    }
}
