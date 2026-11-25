package com.google.common.io;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
class c2 extends Reader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Iterator<? extends p> f21955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Reader f21956b;

    c2(Iterator<? extends p> it) throws IOException {
        this.f21955a = it;
        b();
    }

    private void b() throws IOException {
        close();
        if (this.f21955a.hasNext()) {
            this.f21956b = this.f21955a.next().q();
        }
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Reader reader = this.f21956b;
        if (reader != null) {
            try {
                reader.close();
            } finally {
                this.f21956b = null;
            }
        }
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i7, int i8) throws IOException {
        Reader reader = this.f21956b;
        if (reader == null) {
            return -1;
        }
        int i9 = reader.read(cArr, i7, i8);
        if (i9 != -1) {
            return i9;
        }
        b();
        return read(cArr, i7, i8);
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        Reader reader = this.f21956b;
        return reader != null && reader.ready();
    }

    @Override // java.io.Reader
    public long skip(long j7) throws IOException {
        com.google.common.base.e0.e(j7 >= 0, "n is negative");
        if (j7 > 0) {
            while (true) {
                Reader reader = this.f21956b;
                if (reader == null) {
                    break;
                }
                long jSkip = reader.skip(j7);
                if (jSkip > 0) {
                    return jSkip;
                }
                b();
            }
        }
        return 0L;
    }
}
