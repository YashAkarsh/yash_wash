package com.haier.library.a;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface i extends c0, ReadableByteChannel {
    boolean A(long j7, j jVar) throws IOException;

    String C1(long j7) throws IOException;

    long E1() throws IOException;

    long H0(j jVar, long j7) throws IOException;

    long L1(byte b8, long j7) throws IOException;

    int M0(byte[] bArr) throws IOException;

    String O(long j7, Charset charset) throws IOException;

    int R0() throws IOException;

    byte[] S(long j7) throws IOException;

    String T() throws IOException;

    long U1(byte b8, long j7, long j8) throws IOException;

    int W0(byte[] bArr, int i7, int i8) throws IOException;

    int X(u uVar) throws IOException;

    int Z0() throws IOException;

    long a(j jVar) throws IOException;

    void a(long j7) throws IOException;

    boolean b(long j7) throws IOException;

    g c();

    long d(j jVar) throws IOException;

    long f1(j jVar, long j7) throws IOException;

    boolean g() throws IOException;

    long g1(b0 b0Var) throws IOException;

    InputStream h();

    byte j() throws IOException;

    String j(long j7) throws IOException;

    void j0(long j7) throws IOException;

    String j1(Charset charset) throws IOException;

    short k() throws IOException;

    @Nullable
    String k0() throws IOException;

    void k1(byte[] bArr) throws IOException;

    int l() throws IOException;

    long m() throws IOException;

    short n() throws IOException;

    long n0(byte b8) throws IOException;

    byte[] n1() throws IOException;

    j s() throws IOException;

    long t() throws IOException;

    j t1(long j7) throws IOException;

    long u1() throws IOException;

    String v() throws IOException;

    boolean w0(long j7, j jVar, int i7, int i8) throws IOException;

    void y0(g gVar, long j7) throws IOException;
}
