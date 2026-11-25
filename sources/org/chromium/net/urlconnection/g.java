package org.chromium.net.urlconnection;

import java.io.IOException;
import java.io.OutputStream;
import org.chromium.net.q0;

/* JADX INFO: loaded from: classes3.dex */
abstract class g extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IOException f39576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f39577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f39578c;

    g() {
    }

    protected void b() throws IOException {
        IOException iOException = this.f39576a;
        if (iOException != null) {
            throw iOException;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f39577b = true;
    }

    protected void e() throws IOException {
        if (this.f39578c) {
            b();
            throw new IOException("Writing after request completed.");
        }
        if (this.f39577b) {
            throw new IOException("Stream has been closed.");
        }
    }

    abstract void q() throws IOException;

    abstract q0 r();

    abstract void u() throws IOException;

    void v(IOException iOException) {
        this.f39576a = iOException;
        this.f39578c = true;
    }
}
