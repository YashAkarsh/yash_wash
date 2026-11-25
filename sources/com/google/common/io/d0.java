package com.google.common.io;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public final class d0 extends FilterInputStream implements DataInput {
    public d0(InputStream inputStream) {
        super((InputStream) com.google.common.base.e0.E(inputStream));
    }

    private byte b() throws IOException {
        int i7 = ((FilterInputStream) this).in.read();
        if (-1 != i7) {
            return (byte) i7;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    @u1.a
    public boolean readBoolean() throws IOException {
        return readUnsignedByte() != 0;
    }

    @Override // java.io.DataInput
    @u1.a
    public byte readByte() throws IOException {
        return (byte) readUnsignedByte();
    }

    @Override // java.io.DataInput
    @u1.a
    public char readChar() throws IOException {
        return (char) readUnsignedShort();
    }

    @Override // java.io.DataInput
    @u1.a
    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    @u1.a
    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws IOException {
        h.p(this, bArr);
    }

    @Override // java.io.DataInput
    @u1.a
    public int readInt() throws IOException {
        byte b8 = b();
        byte b9 = b();
        return com.google.common.primitives.c0.k(b(), b(), b9, b8);
    }

    @Override // java.io.DataInput
    @u1.a
    public String readLine() {
        throw new UnsupportedOperationException("readLine is not supported");
    }

    @Override // java.io.DataInput
    @u1.a
    public long readLong() throws IOException {
        byte b8 = b();
        byte b9 = b();
        byte b10 = b();
        byte b11 = b();
        byte b12 = b();
        byte b13 = b();
        return com.google.common.primitives.d0.j(b(), b(), b13, b12, b11, b10, b9, b8);
    }

    @Override // java.io.DataInput
    @u1.a
    public short readShort() throws IOException {
        return (short) readUnsignedShort();
    }

    @Override // java.io.DataInput
    @u1.a
    public String readUTF() throws IOException {
        return new DataInputStream(((FilterInputStream) this).in).readUTF();
    }

    @Override // java.io.DataInput
    @u1.a
    public int readUnsignedByte() throws IOException {
        int i7 = ((FilterInputStream) this).in.read();
        if (i7 >= 0) {
            return i7;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    @u1.a
    public int readUnsignedShort() throws IOException {
        return com.google.common.primitives.c0.k((byte) 0, (byte) 0, b(), b());
    }

    @Override // java.io.DataInput
    public int skipBytes(int i7) throws IOException {
        return (int) ((FilterInputStream) this).in.skip(i7);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i7, int i8) throws IOException {
        h.q(this, bArr, i7, i8);
    }
}
