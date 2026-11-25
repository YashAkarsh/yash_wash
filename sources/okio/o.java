package okio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import kotlin.b1;

/* JADX INFO: loaded from: classes3.dex */
public interface o extends o0, ReadableByteChannel {
    int A0() throws IOException;

    @a7.d
    p E0() throws IOException;

    long F1(@a7.d p pVar, long j7) throws IOException;

    void G1(long j7) throws IOException;

    @a7.d
    byte[] I() throws IOException;

    long J(@a7.d p pVar) throws IOException;

    boolean K0(long j7) throws IOException;

    long M1(byte b8) throws IOException;

    boolean N() throws IOException;

    long Q1() throws IOException;

    @a7.d
    InputStream S1();

    long U(byte b8, long j7) throws IOException;

    void V(@a7.d m mVar, long j7) throws IOException;

    int V1(@a7.d d0 d0Var) throws IOException;

    @a7.d
    String X0() throws IOException;

    long Y(byte b8, long j7, long j8) throws IOException;

    long Z(@a7.d p pVar) throws IOException;

    @a7.e
    String a0() throws IOException;

    int b1() throws IOException;

    long c0() throws IOException;

    boolean c1(long j7, @a7.d p pVar, int i7, int i8) throws IOException;

    @a7.d
    String e0(long j7) throws IOException;

    @a7.d
    String h(long j7) throws IOException;

    @a7.d
    byte[] h1(long j7) throws IOException;

    long k(@a7.d p pVar, long j7) throws IOException;

    @a7.d
    p l(long j7) throws IOException;

    @a7.d
    String m1() throws IOException;

    @a7.d
    @kotlin.k(level = kotlin.m.WARNING, message = "moved to val: use getBuffer() instead", replaceWith = @b1(expression = "buffer", imports = {}))
    m o();

    @a7.d
    String o1(long j7, @a7.d Charset charset) throws IOException;

    @a7.d
    m p();

    @a7.d
    o peek();

    short r1() throws IOException;

    int read(@a7.d byte[] bArr) throws IOException;

    int read(@a7.d byte[] bArr, int i7, int i8) throws IOException;

    byte readByte() throws IOException;

    void readFully(@a7.d byte[] bArr) throws IOException;

    int readInt() throws IOException;

    long readLong() throws IOException;

    short readShort() throws IOException;

    void skip(long j7) throws IOException;

    boolean t0(long j7, @a7.d p pVar) throws IOException;

    @a7.d
    String u0(@a7.d Charset charset) throws IOException;

    long v1() throws IOException;

    long x1(@a7.d m0 m0Var) throws IOException;
}
