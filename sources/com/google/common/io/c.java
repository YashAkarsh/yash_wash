package com.google.common.io;

import java.io.DataInput;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
public interface c extends DataInput {
    @Override // java.io.DataInput
    @u1.a
    boolean readBoolean();

    @Override // java.io.DataInput
    @u1.a
    byte readByte();

    @Override // java.io.DataInput
    @u1.a
    char readChar();

    @Override // java.io.DataInput
    @u1.a
    double readDouble();

    @Override // java.io.DataInput
    @u1.a
    float readFloat();

    @Override // java.io.DataInput
    void readFully(byte[] bArr);

    @Override // java.io.DataInput
    void readFully(byte[] bArr, int i7, int i8);

    @Override // java.io.DataInput
    @u1.a
    int readInt();

    @Override // java.io.DataInput
    @u1.a
    String readLine();

    @Override // java.io.DataInput
    @u1.a
    long readLong();

    @Override // java.io.DataInput
    @u1.a
    short readShort();

    @Override // java.io.DataInput
    @u1.a
    String readUTF();

    @Override // java.io.DataInput
    @u1.a
    int readUnsignedByte();

    @Override // java.io.DataInput
    @u1.a
    int readUnsignedShort();

    @Override // java.io.DataInput
    int skipBytes(int i7);
}
