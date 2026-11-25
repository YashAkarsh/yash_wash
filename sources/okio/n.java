package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import kotlin.b1;

/* JADX INFO: loaded from: classes3.dex */
public interface n extends m0, WritableByteChannel {
    @a7.d
    n B0(@a7.d String str, int i7, int i8) throws IOException;

    long C0(@a7.d o0 o0Var) throws IOException;

    @a7.d
    n D(long j7) throws IOException;

    @a7.d
    n D0(long j7) throws IOException;

    @a7.d
    n D1(@a7.d String str, int i7, int i8, @a7.d Charset charset) throws IOException;

    @a7.d
    n F0(@a7.d String str, @a7.d Charset charset) throws IOException;

    @a7.d
    n H1(long j7) throws IOException;

    @a7.d
    OutputStream J1();

    @a7.d
    n L(int i7) throws IOException;

    @a7.d
    n O0(@a7.d o0 o0Var, long j7) throws IOException;

    @a7.d
    n b0() throws IOException;

    @Override // okio.m0, java.io.Flushable
    void flush() throws IOException;

    @a7.d
    n m0(int i7) throws IOException;

    @a7.d
    @kotlin.k(level = kotlin.m.WARNING, message = "moved to val: use getBuffer() instead", replaceWith = @b1(expression = "buffer", imports = {}))
    m o();

    @a7.d
    m p();

    @a7.d
    n p1(@a7.d p pVar) throws IOException;

    @a7.d
    n q0(@a7.d String str) throws IOException;

    @a7.d
    n w() throws IOException;

    @a7.d
    n write(@a7.d byte[] bArr) throws IOException;

    @a7.d
    n write(@a7.d byte[] bArr, int i7, int i8) throws IOException;

    @a7.d
    n writeByte(int i7) throws IOException;

    @a7.d
    n writeInt(int i7) throws IOException;

    @a7.d
    n writeLong(long j7) throws IOException;

    @a7.d
    n writeShort(int i7) throws IOException;

    @a7.d
    n x(int i7) throws IOException;

    @a7.d
    n z(@a7.d p pVar, int i7, int i8) throws IOException;
}
