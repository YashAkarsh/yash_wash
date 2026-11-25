package com.google.common.io;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public final class e0 extends FilterOutputStream implements DataOutput {
    public e0(OutputStream outputStream) {
        super(new DataOutputStream((OutputStream) com.google.common.base.e0.E(outputStream)));
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.DataOutput
    public void write(byte[] bArr, int i7, int i8) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i7, i8);
    }

    @Override // java.io.DataOutput
    public void writeBoolean(boolean z7) throws IOException {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeBoolean(z7);
    }

    @Override // java.io.DataOutput
    public void writeByte(int i7) throws IOException {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeByte(i7);
    }

    @Override // java.io.DataOutput
    @Deprecated
    public void writeBytes(String str) throws IOException {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeBytes(str);
    }

    @Override // java.io.DataOutput
    public void writeChar(int i7) throws IOException {
        writeShort(i7);
    }

    @Override // java.io.DataOutput
    public void writeChars(String str) throws IOException {
        for (int i7 = 0; i7 < str.length(); i7++) {
            writeChar(str.charAt(i7));
        }
    }

    @Override // java.io.DataOutput
    public void writeDouble(double d8) throws IOException {
        writeLong(Double.doubleToLongBits(d8));
    }

    @Override // java.io.DataOutput
    public void writeFloat(float f8) throws IOException {
        writeInt(Float.floatToIntBits(f8));
    }

    @Override // java.io.DataOutput
    public void writeInt(int i7) throws IOException {
        ((FilterOutputStream) this).out.write(i7 & 255);
        ((FilterOutputStream) this).out.write((i7 >> 8) & 255);
        ((FilterOutputStream) this).out.write((i7 >> 16) & 255);
        ((FilterOutputStream) this).out.write((i7 >> 24) & 255);
    }

    @Override // java.io.DataOutput
    public void writeLong(long j7) throws IOException {
        byte[] bArrA = com.google.common.primitives.d0.A(Long.reverseBytes(j7));
        write(bArrA, 0, bArrA.length);
    }

    @Override // java.io.DataOutput
    public void writeShort(int i7) throws IOException {
        ((FilterOutputStream) this).out.write(i7 & 255);
        ((FilterOutputStream) this).out.write((i7 >> 8) & 255);
    }

    @Override // java.io.DataOutput
    public void writeUTF(String str) throws IOException {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeUTF(str);
    }
}
