package com.haier.globalwasher.mvp_api.volley.toolbox;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class r extends ByteArrayOutputStream {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f25032b = 256;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f25033a;

    public r(d dVar) {
        this(dVar, 256);
    }

    private void b(int i7) {
        int i8 = ((ByteArrayOutputStream) this).count;
        if (i8 + i7 <= ((ByteArrayOutputStream) this).buf.length) {
            return;
        }
        byte[] bArrA = this.f25033a.a((i8 + i7) * 2);
        System.arraycopy(((ByteArrayOutputStream) this).buf, 0, bArrA, 0, ((ByteArrayOutputStream) this).count);
        this.f25033a.b(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = bArrA;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f25033a.b(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    public void finalize() {
        this.f25033a.b(((ByteArrayOutputStream) this).buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i7, int i8) {
        b(i8);
        super.write(bArr, i7, i8);
    }

    public r(d dVar, int i7) {
        this.f25033a = dVar;
        ((ByteArrayOutputStream) this).buf = dVar.a(Math.max(i7, 256));
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i7) {
        b(1);
        super.write(i7);
    }
}
