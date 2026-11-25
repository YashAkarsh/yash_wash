package com.google.common.io;

import java.io.DataOutput;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
public interface d extends DataOutput {
    byte[] b();

    @Override // java.io.DataOutput
    void write(int i7);

    @Override // java.io.DataOutput
    void write(byte[] bArr);

    @Override // java.io.DataOutput
    void write(byte[] bArr, int i7, int i8);

    @Override // java.io.DataOutput
    void writeBoolean(boolean z7);

    @Override // java.io.DataOutput
    void writeByte(int i7);

    @Override // java.io.DataOutput
    @Deprecated
    void writeBytes(String str);

    @Override // java.io.DataOutput
    void writeChar(int i7);

    @Override // java.io.DataOutput
    void writeChars(String str);

    @Override // java.io.DataOutput
    void writeDouble(double d8);

    @Override // java.io.DataOutput
    void writeFloat(float f8);

    @Override // java.io.DataOutput
    void writeInt(int i7);

    @Override // java.io.DataOutput
    void writeLong(long j7);

    @Override // java.io.DataOutput
    void writeShort(int i7);

    @Override // java.io.DataOutput
    void writeUTF(String str);
}
