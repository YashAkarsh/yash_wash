package com.bumptech.glide.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public class c extends InputStream {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Queue<c> f14919c = i.d(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InputStream f14920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IOException f14921b;

    c() {
    }

    static void b() {
        while (true) {
            Queue<c> queue = f14919c;
            if (queue.isEmpty()) {
                return;
            } else {
                queue.remove();
            }
        }
    }

    public static c f(InputStream inputStream) {
        c cVarPoll;
        Queue<c> queue = f14919c;
        synchronized (queue) {
            cVarPoll = queue.poll();
        }
        if (cVarPoll == null) {
            cVarPoll = new c();
        }
        cVarPoll.g(inputStream);
        return cVarPoll;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f14920a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f14920a.close();
    }

    public IOException e() {
        return this.f14921b;
    }

    void g(InputStream inputStream) {
        this.f14920a = inputStream;
    }

    public void i() {
        this.f14921b = null;
        this.f14920a = null;
        Queue<c> queue = f14919c;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    @Override // java.io.InputStream
    public void mark(int i7) {
        this.f14920a.mark(i7);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f14920a.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            return this.f14920a.read(bArr);
        } catch (IOException e8) {
            this.f14921b = e8;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f14920a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j7) throws IOException {
        try {
            return this.f14920a.skip(j7);
        } catch (IOException e8) {
            this.f14921b = e8;
            return 0L;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i7, int i8) throws IOException {
        try {
            return this.f14920a.read(bArr, i7, i8);
        } catch (IOException e8) {
            this.f14921b = e8;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            return this.f14920a.read();
        } catch (IOException e8) {
            this.f14921b = e8;
            return -1;
        }
    }
}
