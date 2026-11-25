package com.haier.library.a;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public interface h extends b0, WritableByteChannel {
    h B(j jVar) throws IOException;

    h K1(byte[] bArr) throws IOException;

    h M(long j7) throws IOException;

    h N0(int i7) throws IOException;

    h O1(int i7) throws IOException;

    h P() throws IOException;

    h P1(long j7) throws IOException;

    h S0(c0 c0Var, long j7) throws IOException;

    h T1(byte[] bArr, int i7, int i8) throws IOException;

    h U0(String str, Charset charset) throws IOException;

    h W(String str, int i7, int i8, Charset charset) throws IOException;

    h b(String str) throws IOException;

    h b(String str, int i7, int i8) throws IOException;

    g c();

    OutputStream d();

    h d0(long j7) throws IOException;

    h f() throws IOException;

    long f0(c0 c0Var) throws IOException;

    @Override // com.haier.library.a.b0, java.io.Flushable
    void flush() throws IOException;

    h i0(int i7) throws IOException;

    h l1(int i7) throws IOException;

    h n(long j7) throws IOException;

    h y1(int i7) throws IOException;

    h z0(int i7) throws IOException;
}
