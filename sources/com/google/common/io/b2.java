package com.google.common.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
final class b2 extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Iterator<? extends g> f21946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InputStream f21947b;

    public b2(Iterator<? extends g> it) throws IOException {
        this.f21946a = (Iterator) com.google.common.base.e0.E(it);
        b();
    }

    private void b() throws IOException {
        close();
        if (this.f21946a.hasNext()) {
            this.f21947b = this.f21946a.next().m();
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        InputStream inputStream = this.f21947b;
        if (inputStream == null) {
            return 0;
        }
        return inputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.f21947b;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                this.f21947b = null;
            }
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        while (true) {
            InputStream inputStream = this.f21947b;
            if (inputStream == null) {
                return -1;
            }
            int i7 = inputStream.read();
            if (i7 != -1) {
                return i7;
            }
            b();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j7) throws IOException {
        InputStream inputStream = this.f21947b;
        if (inputStream == null || j7 <= 0) {
            return 0L;
        }
        long jSkip = inputStream.skip(j7);
        if (jSkip != 0) {
            return jSkip;
        }
        if (read() == -1) {
            return 0L;
        }
        return this.f21947b.skip(j7 - 1) + 1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i7, int i8) throws IOException {
        while (true) {
            InputStream inputStream = this.f21947b;
            if (inputStream == null) {
                return -1;
            }
            int i9 = inputStream.read(bArr, i7, i8);
            if (i9 != -1) {
                return i9;
            }
            b();
        }
    }
}
