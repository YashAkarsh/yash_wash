package com.google.common.io;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
public abstract class f {

    private final class b extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Charset f21966a;

        @Override // com.google.common.io.j
        public Writer b() throws IOException {
            return new OutputStreamWriter(f.this.c(), this.f21966a);
        }

        public String toString() {
            return f.this.toString() + ".asCharSink(" + this.f21966a + ")";
        }

        private b(Charset charset) {
            this.f21966a = (Charset) com.google.common.base.e0.E(charset);
        }
    }

    protected f() {
    }

    public j a(Charset charset) {
        return new b(charset);
    }

    public OutputStream b() throws IOException {
        OutputStream outputStreamC = c();
        return outputStreamC instanceof BufferedOutputStream ? (BufferedOutputStream) outputStreamC : new BufferedOutputStream(outputStreamC);
    }

    public abstract OutputStream c() throws IOException;

    public void d(byte[] bArr) throws Throwable {
        com.google.common.base.e0.E(bArr);
        s sVarB = s.b();
        try {
            OutputStream outputStream = (OutputStream) sVarB.c(c());
            outputStream.write(bArr);
            outputStream.flush();
            sVarB.close();
        } catch (Throwable th) {
            try {
                throw sVarB.e(th);
            } catch (Throwable th2) {
                sVarB.close();
                throw th2;
            }
        }
    }

    @u1.a
    public long e(InputStream inputStream) throws Throwable {
        com.google.common.base.e0.E(inputStream);
        s sVarB = s.b();
        try {
            OutputStream outputStream = (OutputStream) sVarB.c(c());
            long jB = h.b(inputStream, outputStream);
            outputStream.flush();
            sVarB.close();
            return jB;
        } catch (Throwable th) {
            try {
                throw sVarB.e(th);
            } catch (Throwable th2) {
                sVarB.close();
                throw th2;
            }
        }
    }
}
