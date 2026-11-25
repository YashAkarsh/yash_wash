package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class d implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteBuffer f7514a;

    public d(ByteBuffer byteBuffer) {
        this.f7514a = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public void a(double d8) {
        this.f7514a.putDouble(d8);
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public void b(short s7) {
        this.f7514a.putShort(s7);
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public void c(boolean z7) {
        this.f7514a.put(z7 ? (byte) 1 : (byte) 0);
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public void d(float f8) {
        this.f7514a.putFloat(f8);
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public void e(int i7) {
        this.f7514a.putInt(i7);
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public void f(long j7) {
        this.f7514a.putLong(j7);
    }

    @Override // androidx.emoji2.text.flatbuffer.r, androidx.emoji2.text.flatbuffer.q
    public int g() {
        return this.f7514a.limit();
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public byte get(int i7) {
        return this.f7514a.get(i7);
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public double getDouble(int i7) {
        return this.f7514a.getDouble(i7);
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public float getFloat(int i7) {
        return this.f7514a.getFloat(i7);
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public int getInt(int i7) {
        return this.f7514a.getInt(i7);
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public long getLong(int i7) {
        return this.f7514a.getLong(i7);
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public short getShort(int i7) {
        return this.f7514a.getShort(i7);
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public void h(int i7, byte[] bArr, int i8, int i9) {
        p((i9 - i8) + i7);
        int iPosition = this.f7514a.position();
        this.f7514a.position(i7);
        this.f7514a.put(bArr, i8, i9);
        this.f7514a.position(iPosition);
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public void i(int i7, double d8) {
        p(i7 + 8);
        this.f7514a.putDouble(i7, d8);
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public void j(int i7, int i8) {
        p(i7 + 4);
        this.f7514a.putInt(i7, i8);
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public boolean k(int i7) {
        return get(i7) != 0;
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public void l(int i7, float f8) {
        p(i7 + 4);
        this.f7514a.putFloat(i7, f8);
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public byte[] m() {
        return this.f7514a.array();
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public String n(int i7, int i8) {
        return b0.h(this.f7514a, i7, i8);
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public void o(int i7, short s7) {
        p(i7 + 2);
        this.f7514a.putShort(i7, s7);
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public boolean p(int i7) {
        return i7 <= this.f7514a.limit();
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public void q(int i7, byte b8) {
        p(i7 + 1);
        this.f7514a.put(i7, b8);
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public void r(int i7, long j7) {
        p(i7 + 8);
        this.f7514a.putLong(i7, j7);
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public int s() {
        return this.f7514a.position();
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public void t(int i7, boolean z7) {
        q(i7, z7 ? (byte) 1 : (byte) 0);
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public void u(byte[] bArr, int i7, int i8) {
        this.f7514a.put(bArr, i7, i8);
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public void v(byte b8) {
        this.f7514a.put(b8);
    }
}
