package com.google.common.io;

import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
final class i extends Reader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CharSequence f21992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f21993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f21994c;

    public i(CharSequence charSequence) {
        this.f21992a = (CharSequence) com.google.common.base.e0.E(charSequence);
    }

    private void b() throws IOException {
        if (this.f21992a == null) {
            throw new IOException("reader closed");
        }
    }

    private boolean e() {
        return q() > 0;
    }

    private int q() {
        return this.f21992a.length() - this.f21993b;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f21992a = null;
    }

    @Override // java.io.Reader
    public synchronized void mark(int i7) throws IOException {
        com.google.common.base.e0.k(i7 >= 0, "readAheadLimit (%s) may not be negative", i7);
        b();
        this.f21994c = this.f21993b;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader, java.lang.Readable
    public synchronized int read(CharBuffer charBuffer) throws IOException {
        com.google.common.base.e0.E(charBuffer);
        b();
        if (!e()) {
            return -1;
        }
        int iMin = Math.min(charBuffer.remaining(), q());
        for (int i7 = 0; i7 < iMin; i7++) {
            CharSequence charSequence = this.f21992a;
            int i8 = this.f21993b;
            this.f21993b = i8 + 1;
            charBuffer.put(charSequence.charAt(i8));
        }
        return iMin;
    }

    @Override // java.io.Reader
    public synchronized boolean ready() throws IOException {
        b();
        return true;
    }

    @Override // java.io.Reader
    public synchronized void reset() throws IOException {
        b();
        this.f21993b = this.f21994c;
    }

    @Override // java.io.Reader
    public synchronized long skip(long j7) throws IOException {
        int iMin;
        com.google.common.base.e0.p(j7 >= 0, "n (%s) may not be negative", j7);
        b();
        iMin = (int) Math.min(q(), j7);
        this.f21993b += iMin;
        return iMin;
    }

    @Override // java.io.Reader
    public synchronized int read() throws IOException {
        int iCharAt;
        b();
        if (e()) {
            CharSequence charSequence = this.f21992a;
            int i7 = this.f21993b;
            this.f21993b = i7 + 1;
            iCharAt = charSequence.charAt(i7);
        } else {
            iCharAt = -1;
        }
        return iCharAt;
    }

    @Override // java.io.Reader
    public synchronized int read(char[] cArr, int i7, int i8) throws IOException {
        com.google.common.base.e0.f0(i7, i7 + i8, cArr.length);
        b();
        if (!e()) {
            return -1;
        }
        int iMin = Math.min(i8, q());
        for (int i9 = 0; i9 < iMin; i9++) {
            CharSequence charSequence = this.f21992a;
            int i10 = this.f21993b;
            this.f21993b = i10 + 1;
            cArr[i7 + i9] = charSequence.charAt(i10);
        }
        return iMin;
    }
}
