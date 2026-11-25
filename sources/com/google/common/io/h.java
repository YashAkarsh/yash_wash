package com.google.common.io;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f21982a = 8192;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f21983b = 524288;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f21984c = 2147483639;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f21985d = 20;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final OutputStream f21986e = new a();

    static class a extends OutputStream {
        a() {
        }

        public String toString() {
            return "ByteStreams.nullOutputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i7) {
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            com.google.common.base.e0.E(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i7, int i8) {
            com.google.common.base.e0.E(bArr);
        }
    }

    private h() {
    }

    private static byte[] a(Deque<byte[]> deque, int i7) {
        byte[] bArr = new byte[i7];
        int i8 = i7;
        while (i8 > 0) {
            byte[] bArrRemoveFirst = deque.removeFirst();
            int iMin = Math.min(i8, bArrRemoveFirst.length);
            System.arraycopy(bArrRemoveFirst, 0, bArr, i7 - i8, iMin);
            i8 -= iMin;
        }
        return bArr;
    }

    @u1.a
    public static long b(InputStream inputStream, OutputStream outputStream) throws IOException {
        com.google.common.base.e0.E(inputStream);
        com.google.common.base.e0.E(outputStream);
        byte[] bArrD = d();
        long j7 = 0;
        while (true) {
            int i7 = inputStream.read(bArrD);
            if (i7 == -1) {
                return j7;
            }
            outputStream.write(bArrD, 0, i7);
            j7 += (long) i7;
        }
    }

    @u1.a
    public static long c(ReadableByteChannel readableByteChannel, WritableByteChannel writableByteChannel) throws IOException {
        com.google.common.base.e0.E(readableByteChannel);
        com.google.common.base.e0.E(writableByteChannel);
        long jWrite = 0;
        if (!(readableByteChannel instanceof FileChannel)) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(d());
            while (readableByteChannel.read(byteBufferWrap) != -1) {
                byteBufferWrap.flip();
                while (byteBufferWrap.hasRemaining()) {
                    jWrite += (long) writableByteChannel.write(byteBufferWrap);
                }
                byteBufferWrap.clear();
            }
            return jWrite;
        }
        FileChannel fileChannel = (FileChannel) readableByteChannel;
        long jPosition = fileChannel.position();
        long j7 = jPosition;
        while (true) {
            long jTransferTo = fileChannel.transferTo(j7, PlaybackStateCompat.F, writableByteChannel);
            j7 += jTransferTo;
            fileChannel.position(j7);
            if (jTransferTo <= 0 && j7 >= fileChannel.size()) {
                return j7 - jPosition;
            }
        }
    }

    static byte[] d() {
        return new byte[8192];
    }

    @u1.a
    public static long e(InputStream inputStream) throws IOException {
        byte[] bArrD = d();
        long j7 = 0;
        while (true) {
            long j8 = inputStream.read(bArrD);
            if (j8 == -1) {
                return j7;
            }
            j7 += j8;
        }
    }

    public static InputStream f(InputStream inputStream, long j7) {
        return new d(inputStream, j7);
    }

    public static com.google.common.io.c g(ByteArrayInputStream byteArrayInputStream) {
        return new b((ByteArrayInputStream) com.google.common.base.e0.E(byteArrayInputStream));
    }

    public static com.google.common.io.c h(byte[] bArr) {
        return g(new ByteArrayInputStream(bArr));
    }

    public static com.google.common.io.c i(byte[] bArr, int i7) {
        com.google.common.base.e0.d0(i7, bArr.length);
        return g(new ByteArrayInputStream(bArr, i7, bArr.length - i7));
    }

    public static com.google.common.io.d j() {
        return l(new ByteArrayOutputStream());
    }

    public static com.google.common.io.d k(int i7) {
        if (i7 >= 0) {
            return l(new ByteArrayOutputStream(i7));
        }
        throw new IllegalArgumentException(String.format("Invalid size: %s", Integer.valueOf(i7)));
    }

    public static com.google.common.io.d l(ByteArrayOutputStream byteArrayOutputStream) {
        return new c((ByteArrayOutputStream) com.google.common.base.e0.E(byteArrayOutputStream));
    }

    public static OutputStream m() {
        return f21986e;
    }

    @u1.a
    public static int n(InputStream inputStream, byte[] bArr, int i7, int i8) throws IOException {
        com.google.common.base.e0.E(inputStream);
        com.google.common.base.e0.E(bArr);
        if (i8 < 0) {
            throw new IndexOutOfBoundsException("len is negative");
        }
        int i9 = 0;
        while (i9 < i8) {
            int i10 = inputStream.read(bArr, i7 + i9, i8 - i9);
            if (i10 == -1) {
                break;
            }
            i9 += i10;
        }
        return i9;
    }

    @u1.a
    public static <T> T o(InputStream inputStream, e<T> eVar) throws IOException {
        int i7;
        com.google.common.base.e0.E(inputStream);
        com.google.common.base.e0.E(eVar);
        byte[] bArrD = d();
        do {
            i7 = inputStream.read(bArrD);
            if (i7 == -1) {
                break;
            }
        } while (eVar.b(bArrD, 0, i7));
        return eVar.a();
    }

    public static void p(InputStream inputStream, byte[] bArr) throws IOException {
        q(inputStream, bArr, 0, bArr.length);
    }

    public static void q(InputStream inputStream, byte[] bArr, int i7, int i8) throws IOException {
        int iN = n(inputStream, bArr, i7, i8);
        if (iN == i8) {
            return;
        }
        throw new EOFException("reached end of stream after reading " + iN + " bytes; " + i8 + " bytes expected");
    }

    public static void r(InputStream inputStream, long j7) throws IOException {
        long jT = t(inputStream, j7);
        if (jT >= j7) {
            return;
        }
        throw new EOFException("reached end of stream after skipping " + jT + " bytes; " + j7 + " bytes expected");
    }

    private static long s(InputStream inputStream, long j7) throws IOException {
        int iAvailable = inputStream.available();
        if (iAvailable == 0) {
            return 0L;
        }
        return inputStream.skip(Math.min(iAvailable, j7));
    }

    static long t(InputStream inputStream, long j7) throws IOException {
        byte[] bArrD = d();
        long j8 = 0;
        while (j8 < j7) {
            long j9 = j7 - j8;
            long jS = s(inputStream, j9);
            if (jS == 0) {
                jS = inputStream.read(bArrD, 0, (int) Math.min(j9, bArrD.length));
                if (jS == -1) {
                    break;
                }
            }
            j8 += jS;
        }
        return j8;
    }

    public static byte[] u(InputStream inputStream) throws IOException {
        com.google.common.base.e0.E(inputStream);
        return w(inputStream, new ArrayDeque(20), 0);
    }

    static byte[] v(InputStream inputStream, long j7) throws IOException {
        com.google.common.base.e0.p(j7 >= 0, "expectedSize (%s) must be non-negative", j7);
        if (j7 > 2147483639) {
            throw new OutOfMemoryError(j7 + " bytes is too large to fit in a byte array");
        }
        int i7 = (int) j7;
        byte[] bArr = new byte[i7];
        int i8 = i7;
        while (i8 > 0) {
            int i9 = i7 - i8;
            int i10 = inputStream.read(bArr, i9, i8);
            if (i10 == -1) {
                return Arrays.copyOf(bArr, i9);
            }
            i8 -= i10;
        }
        int i11 = inputStream.read();
        if (i11 == -1) {
            return bArr;
        }
        ArrayDeque arrayDeque = new ArrayDeque(22);
        arrayDeque.add(bArr);
        arrayDeque.add(new byte[]{(byte) i11});
        return w(inputStream, arrayDeque, i7 + 1);
    }

    private static byte[] w(InputStream inputStream, Deque<byte[]> deque, int i7) throws IOException {
        int iU = 8192;
        while (i7 < f21984c) {
            int iMin = Math.min(iU, f21984c - i7);
            byte[] bArr = new byte[iMin];
            deque.add(bArr);
            int i8 = 0;
            while (i8 < iMin) {
                int i9 = inputStream.read(bArr, i8, iMin - i8);
                if (i9 == -1) {
                    return a(deque, i7);
                }
                i8 += i9;
                i7 += i9;
            }
            iU = com.google.common.math.d.u(iU, 2);
        }
        if (inputStream.read() == -1) {
            return a(deque, f21984c);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    private static class b implements com.google.common.io.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final DataInput f21987a;

        b(ByteArrayInputStream byteArrayInputStream) {
            this.f21987a = new DataInputStream(byteArrayInputStream);
        }

        @Override // com.google.common.io.c, java.io.DataInput
        public boolean readBoolean() {
            try {
                return this.f21987a.readBoolean();
            } catch (IOException e8) {
                throw new IllegalStateException(e8);
            }
        }

        @Override // com.google.common.io.c, java.io.DataInput
        public byte readByte() {
            try {
                return this.f21987a.readByte();
            } catch (EOFException e8) {
                throw new IllegalStateException(e8);
            } catch (IOException e9) {
                throw new AssertionError(e9);
            }
        }

        @Override // com.google.common.io.c, java.io.DataInput
        public char readChar() {
            try {
                return this.f21987a.readChar();
            } catch (IOException e8) {
                throw new IllegalStateException(e8);
            }
        }

        @Override // com.google.common.io.c, java.io.DataInput
        public double readDouble() {
            try {
                return this.f21987a.readDouble();
            } catch (IOException e8) {
                throw new IllegalStateException(e8);
            }
        }

        @Override // com.google.common.io.c, java.io.DataInput
        public float readFloat() {
            try {
                return this.f21987a.readFloat();
            } catch (IOException e8) {
                throw new IllegalStateException(e8);
            }
        }

        @Override // com.google.common.io.c, java.io.DataInput
        public void readFully(byte[] bArr) {
            try {
                this.f21987a.readFully(bArr);
            } catch (IOException e8) {
                throw new IllegalStateException(e8);
            }
        }

        @Override // com.google.common.io.c, java.io.DataInput
        public int readInt() {
            try {
                return this.f21987a.readInt();
            } catch (IOException e8) {
                throw new IllegalStateException(e8);
            }
        }

        @Override // com.google.common.io.c, java.io.DataInput
        public String readLine() {
            try {
                return this.f21987a.readLine();
            } catch (IOException e8) {
                throw new IllegalStateException(e8);
            }
        }

        @Override // com.google.common.io.c, java.io.DataInput
        public long readLong() {
            try {
                return this.f21987a.readLong();
            } catch (IOException e8) {
                throw new IllegalStateException(e8);
            }
        }

        @Override // com.google.common.io.c, java.io.DataInput
        public short readShort() {
            try {
                return this.f21987a.readShort();
            } catch (IOException e8) {
                throw new IllegalStateException(e8);
            }
        }

        @Override // com.google.common.io.c, java.io.DataInput
        public String readUTF() {
            try {
                return this.f21987a.readUTF();
            } catch (IOException e8) {
                throw new IllegalStateException(e8);
            }
        }

        @Override // com.google.common.io.c, java.io.DataInput
        public int readUnsignedByte() {
            try {
                return this.f21987a.readUnsignedByte();
            } catch (IOException e8) {
                throw new IllegalStateException(e8);
            }
        }

        @Override // com.google.common.io.c, java.io.DataInput
        public int readUnsignedShort() {
            try {
                return this.f21987a.readUnsignedShort();
            } catch (IOException e8) {
                throw new IllegalStateException(e8);
            }
        }

        @Override // com.google.common.io.c, java.io.DataInput
        public int skipBytes(int i7) {
            try {
                return this.f21987a.skipBytes(i7);
            } catch (IOException e8) {
                throw new IllegalStateException(e8);
            }
        }

        @Override // com.google.common.io.c, java.io.DataInput
        public void readFully(byte[] bArr, int i7, int i8) {
            try {
                this.f21987a.readFully(bArr, i7, i8);
            } catch (IOException e8) {
                throw new IllegalStateException(e8);
            }
        }
    }

    private static class c implements com.google.common.io.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final DataOutput f21988a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ByteArrayOutputStream f21989b;

        c(ByteArrayOutputStream byteArrayOutputStream) {
            this.f21989b = byteArrayOutputStream;
            this.f21988a = new DataOutputStream(byteArrayOutputStream);
        }

        @Override // com.google.common.io.d
        public byte[] b() {
            return this.f21989b.toByteArray();
        }

        @Override // com.google.common.io.d, java.io.DataOutput
        public void write(int i7) {
            try {
                this.f21988a.write(i7);
            } catch (IOException e8) {
                throw new AssertionError(e8);
            }
        }

        @Override // com.google.common.io.d, java.io.DataOutput
        public void writeBoolean(boolean z7) {
            try {
                this.f21988a.writeBoolean(z7);
            } catch (IOException e8) {
                throw new AssertionError(e8);
            }
        }

        @Override // com.google.common.io.d, java.io.DataOutput
        public void writeByte(int i7) {
            try {
                this.f21988a.writeByte(i7);
            } catch (IOException e8) {
                throw new AssertionError(e8);
            }
        }

        @Override // com.google.common.io.d, java.io.DataOutput
        public void writeBytes(String str) {
            try {
                this.f21988a.writeBytes(str);
            } catch (IOException e8) {
                throw new AssertionError(e8);
            }
        }

        @Override // com.google.common.io.d, java.io.DataOutput
        public void writeChar(int i7) {
            try {
                this.f21988a.writeChar(i7);
            } catch (IOException e8) {
                throw new AssertionError(e8);
            }
        }

        @Override // com.google.common.io.d, java.io.DataOutput
        public void writeChars(String str) {
            try {
                this.f21988a.writeChars(str);
            } catch (IOException e8) {
                throw new AssertionError(e8);
            }
        }

        @Override // com.google.common.io.d, java.io.DataOutput
        public void writeDouble(double d8) {
            try {
                this.f21988a.writeDouble(d8);
            } catch (IOException e8) {
                throw new AssertionError(e8);
            }
        }

        @Override // com.google.common.io.d, java.io.DataOutput
        public void writeFloat(float f8) {
            try {
                this.f21988a.writeFloat(f8);
            } catch (IOException e8) {
                throw new AssertionError(e8);
            }
        }

        @Override // com.google.common.io.d, java.io.DataOutput
        public void writeInt(int i7) {
            try {
                this.f21988a.writeInt(i7);
            } catch (IOException e8) {
                throw new AssertionError(e8);
            }
        }

        @Override // com.google.common.io.d, java.io.DataOutput
        public void writeLong(long j7) {
            try {
                this.f21988a.writeLong(j7);
            } catch (IOException e8) {
                throw new AssertionError(e8);
            }
        }

        @Override // com.google.common.io.d, java.io.DataOutput
        public void writeShort(int i7) {
            try {
                this.f21988a.writeShort(i7);
            } catch (IOException e8) {
                throw new AssertionError(e8);
            }
        }

        @Override // com.google.common.io.d, java.io.DataOutput
        public void writeUTF(String str) {
            try {
                this.f21988a.writeUTF(str);
            } catch (IOException e8) {
                throw new AssertionError(e8);
            }
        }

        @Override // com.google.common.io.d, java.io.DataOutput
        public void write(byte[] bArr) {
            try {
                this.f21988a.write(bArr);
            } catch (IOException e8) {
                throw new AssertionError(e8);
            }
        }

        @Override // com.google.common.io.d, java.io.DataOutput
        public void write(byte[] bArr, int i7, int i8) {
            try {
                this.f21988a.write(bArr, i7, i8);
            } catch (IOException e8) {
                throw new AssertionError(e8);
            }
        }
    }

    private static final class d extends FilterInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f21990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f21991b;

        d(InputStream inputStream, long j7) {
            super(inputStream);
            this.f21991b = -1L;
            com.google.common.base.e0.E(inputStream);
            com.google.common.base.e0.e(j7 >= 0, "limit must be non-negative");
            this.f21990a = j7;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int available() throws IOException {
            return (int) Math.min(((FilterInputStream) this).in.available(), this.f21990a);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i7) {
            ((FilterInputStream) this).in.mark(i7);
            this.f21991b = this.f21990a;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            if (this.f21990a == 0) {
                return -1;
            }
            int i7 = ((FilterInputStream) this).in.read();
            if (i7 != -1) {
                this.f21990a--;
            }
            return i7;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() throws IOException {
            if (!((FilterInputStream) this).in.markSupported()) {
                throw new IOException("Mark not supported");
            }
            if (this.f21991b == -1) {
                throw new IOException("Mark not set");
            }
            ((FilterInputStream) this).in.reset();
            this.f21990a = this.f21991b;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j7) throws IOException {
            long jSkip = ((FilterInputStream) this).in.skip(Math.min(j7, this.f21990a));
            this.f21990a -= jSkip;
            return jSkip;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i7, int i8) throws IOException {
            long j7 = this.f21990a;
            if (j7 == 0) {
                return -1;
            }
            int i9 = ((FilterInputStream) this).in.read(bArr, i7, (int) Math.min(i8, j7));
            if (i9 != -1) {
                this.f21990a -= (long) i9;
            }
            return i9;
        }
    }
}
