package com.haier.library.okhttp.b.b;

import com.haier.library.a.b0;
import com.haier.library.a.g;
import com.haier.library.a.l;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class e extends l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f27004b;

    e(b0 b0Var) {
        super(b0Var);
    }

    @Override // com.haier.library.a.l, com.haier.library.a.b0
    public void I1(g gVar, long j7) throws IOException {
        if (this.f27004b) {
            gVar.j0(j7);
            return;
        }
        try {
            super.I1(gVar, j7);
        } catch (IOException e8) {
            this.f27004b = true;
            c(e8);
        }
    }

    protected void c(IOException iOException) {
    }

    @Override // com.haier.library.a.l, com.haier.library.a.b0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f27004b) {
            return;
        }
        try {
            super.close();
        } catch (IOException e8) {
            this.f27004b = true;
            c(e8);
        }
    }

    @Override // com.haier.library.a.l, com.haier.library.a.b0, java.io.Flushable
    public void flush() throws IOException {
        if (this.f27004b) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e8) {
            this.f27004b = true;
            c(e8);
        }
    }
}
