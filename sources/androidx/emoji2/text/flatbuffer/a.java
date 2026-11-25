package androidx.emoji2.text.flatbuffer;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class a implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f7503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7504b;

    public a() {
        this(10);
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public void a(double d8) {
        i(this.f7504b, d8);
        this.f7504b += 8;
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public void b(short s7) {
        o(this.f7504b, s7);
        this.f7504b += 2;
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public void c(boolean z7) {
        t(this.f7504b, z7);
        this.f7504b++;
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public void d(float f8) {
        l(this.f7504b, f8);
        this.f7504b += 4;
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public void e(int i7) {
        j(this.f7504b, i7);
        this.f7504b += 4;
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public void f(long j7) {
        r(this.f7504b, j7);
        this.f7504b += 8;
    }

    @Override // androidx.emoji2.text.flatbuffer.r, androidx.emoji2.text.flatbuffer.q
    public int g() {
        return this.f7504b;
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public byte get(int i7) {
        return this.f7503a[i7];
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public double getDouble(int i7) {
        return Double.longBitsToDouble(getLong(i7));
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public float getFloat(int i7) {
        return Float.intBitsToFloat(getInt(i7));
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public int getInt(int i7) {
        byte[] bArr = this.f7503a;
        return (bArr[i7] & 255) | (bArr[i7 + 3] << com.google.common.base.c.B) | ((bArr[i7 + 2] & 255) << 16) | ((bArr[i7 + 1] & 255) << 8);
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public long getLong(int i7) {
        byte[] bArr = this.f7503a;
        int i8 = i7 + 1;
        long j7 = ((long) bArr[i7]) & 255;
        int i9 = i8 + 1;
        int i10 = i9 + 1;
        long j8 = j7 | ((((long) bArr[i8]) & 255) << 8) | ((((long) bArr[i9]) & 255) << 16);
        int i11 = i10 + 1;
        long j9 = j8 | ((((long) bArr[i10]) & 255) << 24);
        int i12 = i11 + 1;
        long j10 = j9 | ((((long) bArr[i11]) & 255) << 32);
        int i13 = i12 + 1;
        return j10 | ((((long) bArr[i12]) & 255) << 40) | ((255 & ((long) bArr[i13])) << 48) | (((long) bArr[i13 + 1]) << 56);
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public short getShort(int i7) {
        byte[] bArr = this.f7503a;
        return (short) ((bArr[i7] & 255) | (bArr[i7 + 1] << 8));
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public void h(int i7, byte[] bArr, int i8, int i9) {
        p((i9 - i8) + i7);
        System.arraycopy(bArr, i8, this.f7503a, i7, i9);
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public void i(int i7, double d8) {
        p(i7 + 8);
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d8);
        int i8 = (int) jDoubleToRawLongBits;
        byte[] bArr = this.f7503a;
        int i9 = i7 + 1;
        bArr[i7] = (byte) (i8 & 255);
        int i10 = i9 + 1;
        bArr[i9] = (byte) ((i8 >> 8) & 255);
        int i11 = i10 + 1;
        bArr[i10] = (byte) ((i8 >> 16) & 255);
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((i8 >> 24) & 255);
        int i13 = (int) (jDoubleToRawLongBits >> 32);
        int i14 = i12 + 1;
        bArr[i12] = (byte) (i13 & 255);
        int i15 = i14 + 1;
        bArr[i14] = (byte) ((i13 >> 8) & 255);
        bArr[i15] = (byte) ((i13 >> 16) & 255);
        bArr[i15 + 1] = (byte) ((i13 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public void j(int i7, int i8) {
        p(i7 + 4);
        byte[] bArr = this.f7503a;
        int i9 = i7 + 1;
        bArr[i7] = (byte) (i8 & 255);
        int i10 = i9 + 1;
        bArr[i9] = (byte) ((i8 >> 8) & 255);
        bArr[i10] = (byte) ((i8 >> 16) & 255);
        bArr[i10 + 1] = (byte) ((i8 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public boolean k(int i7) {
        return this.f7503a[i7] != 0;
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public void l(int i7, float f8) {
        p(i7 + 4);
        int iFloatToRawIntBits = Float.floatToRawIntBits(f8);
        byte[] bArr = this.f7503a;
        int i8 = i7 + 1;
        bArr[i7] = (byte) (iFloatToRawIntBits & 255);
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((iFloatToRawIntBits >> 8) & 255);
        bArr[i9] = (byte) ((iFloatToRawIntBits >> 16) & 255);
        bArr[i9 + 1] = (byte) ((iFloatToRawIntBits >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public byte[] m() {
        return this.f7503a;
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public String n(int i7, int i8) {
        return b0.g(this.f7503a, i7, i8);
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public void o(int i7, short s7) {
        p(i7 + 2);
        byte[] bArr = this.f7503a;
        bArr[i7] = (byte) (s7 & 255);
        bArr[i7 + 1] = (byte) ((s7 >> 8) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public boolean p(int i7) {
        byte[] bArr = this.f7503a;
        if (bArr.length > i7) {
            return true;
        }
        int length = bArr.length;
        this.f7503a = Arrays.copyOf(bArr, length + (length >> 1));
        return true;
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public void q(int i7, byte b8) {
        p(i7 + 1);
        this.f7503a[i7] = b8;
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public void r(int i7, long j7) {
        p(i7 + 8);
        int i8 = (int) j7;
        byte[] bArr = this.f7503a;
        int i9 = i7 + 1;
        bArr[i7] = (byte) (i8 & 255);
        int i10 = i9 + 1;
        bArr[i9] = (byte) ((i8 >> 8) & 255);
        int i11 = i10 + 1;
        bArr[i10] = (byte) ((i8 >> 16) & 255);
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((i8 >> 24) & 255);
        int i13 = (int) (j7 >> 32);
        int i14 = i12 + 1;
        bArr[i12] = (byte) (i13 & 255);
        int i15 = i14 + 1;
        bArr[i14] = (byte) ((i13 >> 8) & 255);
        bArr[i15] = (byte) ((i13 >> 16) & 255);
        bArr[i15 + 1] = (byte) ((i13 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public int s() {
        return this.f7504b;
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public void t(int i7, boolean z7) {
        q(i7, z7 ? (byte) 1 : (byte) 0);
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public void u(byte[] bArr, int i7, int i8) {
        h(this.f7504b, bArr, i7, i8);
        this.f7504b += i8;
    }

    @Override // androidx.emoji2.text.flatbuffer.r
    public void v(byte b8) {
        q(this.f7504b, b8);
        this.f7504b++;
    }

    public a(int i7) {
        this(new byte[i7]);
    }

    public a(byte[] bArr) {
        this.f7503a = bArr;
        this.f7504b = 0;
    }

    public a(byte[] bArr, int i7) {
        this.f7503a = bArr;
        this.f7504b = i7;
    }
}
