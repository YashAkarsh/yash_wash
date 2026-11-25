package androidx.emoji2.text.flatbuffer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final /* synthetic */ boolean f7523o = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ByteBuffer f7524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f7525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f7526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int[] f7527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f7528e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f7529f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f7530g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f7531h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int[] f7532i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f7533j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f7534k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    boolean f7535l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    b f7536m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final x f7537n;

    static class a extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ByteBuffer f7538a;

        public a(ByteBuffer byteBuffer) {
            this.f7538a = byteBuffer;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            try {
                return this.f7538a.get() & 255;
            } catch (BufferUnderflowException unused) {
                return -1;
            }
        }
    }

    public static abstract class b {
        public abstract ByteBuffer a(int i7);

        public void b(ByteBuffer byteBuffer) {
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f7539a = new c();

        @Override // androidx.emoji2.text.flatbuffer.i.b
        public ByteBuffer a(int i7) {
            return ByteBuffer.allocate(i7).order(ByteOrder.LITTLE_ENDIAN);
        }
    }

    public i(int i7, b bVar) {
        this(i7, bVar, null, x.d());
    }

    @Deprecated
    private int C() {
        L();
        return this.f7525b;
    }

    static ByteBuffer N(ByteBuffer byteBuffer, b bVar) {
        int iCapacity = byteBuffer.capacity();
        if (((-1073741824) & iCapacity) != 0) {
            throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
        }
        int i7 = iCapacity == 0 ? 1 : iCapacity << 1;
        byteBuffer.position(0);
        ByteBuffer byteBufferA = bVar.a(i7);
        byteBufferA.position(byteBufferA.clear().capacity() - iCapacity);
        byteBufferA.put(byteBuffer);
        return byteBufferA;
    }

    public static boolean P(v vVar, int i7) {
        return vVar.d(i7) != 0;
    }

    public int A(int[] iArr) {
        Q();
        h0(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            n(iArr[length]);
        }
        return E();
    }

    public ByteBuffer B() {
        L();
        return this.f7524a;
    }

    public int D() {
        int i7;
        if (this.f7527d == null || !this.f7529f) {
            throw new AssertionError("FlatBuffers: endTable called without startTable");
        }
        j(0);
        int iR = R();
        int i8 = this.f7528e - 1;
        while (i8 >= 0 && this.f7527d[i8] == 0) {
            i8--;
        }
        int i9 = i8 + 1;
        while (i8 >= 0) {
            int i10 = this.f7527d[i8];
            q((short) (i10 != 0 ? iR - i10 : 0));
            i8--;
        }
        q((short) (iR - this.f7531h));
        q((short) ((i9 + 2) * 2));
        int i11 = 0;
        loop2: while (true) {
            if (i11 >= this.f7533j) {
                i7 = 0;
                break;
            }
            int iCapacity = this.f7524a.capacity() - this.f7532i[i11];
            int i12 = this.f7525b;
            short s7 = this.f7524a.getShort(iCapacity);
            if (s7 == this.f7524a.getShort(i12)) {
                int i13 = 2;
                while (true) {
                    if (i13 >= s7) {
                        i7 = this.f7532i[i11];
                        break loop2;
                    }
                    if (this.f7524a.getShort(iCapacity + i13) != this.f7524a.getShort(i12 + i13)) {
                        break;
                    }
                    i13 += 2;
                }
            }
            i11++;
        }
        if (i7 != 0) {
            int iCapacity2 = this.f7524a.capacity() - iR;
            this.f7525b = iCapacity2;
            this.f7524a.putInt(iCapacity2, i7 - iR);
        } else {
            int i14 = this.f7533j;
            int[] iArr = this.f7532i;
            if (i14 == iArr.length) {
                this.f7532i = Arrays.copyOf(iArr, i14 * 2);
            }
            int[] iArr2 = this.f7532i;
            int i15 = this.f7533j;
            this.f7533j = i15 + 1;
            iArr2[i15] = R();
            ByteBuffer byteBuffer = this.f7524a;
            byteBuffer.putInt(byteBuffer.capacity() - iR, R() - iR);
        }
        this.f7529f = false;
        return iR;
    }

    public int E() {
        if (!this.f7529f) {
            throw new AssertionError("FlatBuffers: endVector called without startVector");
        }
        this.f7529f = false;
        Y(this.f7534k);
        return R();
    }

    public void F(int i7) {
        I(i7, false);
    }

    public void G(int i7, String str) {
        H(i7, str, false);
    }

    protected void H(int i7, String str, boolean z7) {
        T(this.f7526c, (z7 ? 4 : 0) + 8);
        if (str.length() != 4) {
            throw new AssertionError("FlatBuffers: file identifier must be length 4");
        }
        for (int i8 = 3; i8 >= 0; i8--) {
            d((byte) str.charAt(i8));
        }
        I(i7, z7);
    }

    protected void I(int i7, boolean z7) {
        T(this.f7526c, (z7 ? 4 : 0) + 4);
        n(i7);
        if (z7) {
            j(this.f7524a.capacity() - this.f7525b);
        }
        this.f7524a.position(this.f7525b);
        this.f7530g = true;
    }

    public void J(int i7) {
        I(i7, true);
    }

    public void K(int i7, String str) {
        H(i7, str, true);
    }

    public void L() {
        if (!this.f7530g) {
            throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
        }
    }

    public i M(boolean z7) {
        this.f7535l = z7;
        return this;
    }

    public i O(ByteBuffer byteBuffer, b bVar) {
        this.f7536m = bVar;
        this.f7524a = byteBuffer;
        byteBuffer.clear();
        this.f7524a.order(ByteOrder.LITTLE_ENDIAN);
        this.f7526c = 1;
        this.f7525b = this.f7524a.capacity();
        this.f7528e = 0;
        this.f7529f = false;
        this.f7530g = false;
        this.f7531h = 0;
        this.f7533j = 0;
        this.f7534k = 0;
        return this;
    }

    public void Q() {
        if (this.f7529f) {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
    }

    public int R() {
        return this.f7524a.capacity() - this.f7525b;
    }

    public void S(int i7) {
        for (int i8 = 0; i8 < i7; i8++) {
            ByteBuffer byteBuffer = this.f7524a;
            int i9 = this.f7525b - 1;
            this.f7525b = i9;
            byteBuffer.put(i9, (byte) 0);
        }
    }

    public void T(int i7, int i8) {
        if (i7 > this.f7526c) {
            this.f7526c = i7;
        }
        int i9 = ((~((this.f7524a.capacity() - this.f7525b) + i8)) + 1) & (i7 - 1);
        while (this.f7525b < i9 + i7 + i8) {
            int iCapacity = this.f7524a.capacity();
            ByteBuffer byteBuffer = this.f7524a;
            ByteBuffer byteBufferN = N(byteBuffer, this.f7536m);
            this.f7524a = byteBufferN;
            if (byteBuffer != byteBufferN) {
                this.f7536m.b(byteBuffer);
            }
            this.f7525b += this.f7524a.capacity() - iCapacity;
        }
        S(i9);
    }

    public void U(boolean z7) {
        ByteBuffer byteBuffer = this.f7524a;
        int i7 = this.f7525b - 1;
        this.f7525b = i7;
        byteBuffer.put(i7, z7 ? (byte) 1 : (byte) 0);
    }

    public void V(byte b8) {
        ByteBuffer byteBuffer = this.f7524a;
        int i7 = this.f7525b - 1;
        this.f7525b = i7;
        byteBuffer.put(i7, b8);
    }

    public void W(double d8) {
        ByteBuffer byteBuffer = this.f7524a;
        int i7 = this.f7525b - 8;
        this.f7525b = i7;
        byteBuffer.putDouble(i7, d8);
    }

    public void X(float f8) {
        ByteBuffer byteBuffer = this.f7524a;
        int i7 = this.f7525b - 4;
        this.f7525b = i7;
        byteBuffer.putFloat(i7, f8);
    }

    public void Y(int i7) {
        ByteBuffer byteBuffer = this.f7524a;
        int i8 = this.f7525b - 4;
        this.f7525b = i8;
        byteBuffer.putInt(i8, i7);
    }

    public void Z(long j7) {
        ByteBuffer byteBuffer = this.f7524a;
        int i7 = this.f7525b - 8;
        this.f7525b = i7;
        byteBuffer.putLong(i7, j7);
    }

    public void a(int i7) {
        if (i7 != R()) {
            throw new AssertionError("FlatBuffers: struct must be serialized inline.");
        }
    }

    public void a0(short s7) {
        ByteBuffer byteBuffer = this.f7524a;
        int i7 = this.f7525b - 2;
        this.f7525b = i7;
        byteBuffer.putShort(i7, s7);
    }

    public void b(int i7, boolean z7, boolean z8) {
        if (this.f7535l || z7 != z8) {
            c(z7);
            f0(i7);
        }
    }

    public void b0(int i7, int i8) {
        int iCapacity = this.f7524a.capacity() - i7;
        if (this.f7524a.getShort((iCapacity - this.f7524a.getInt(iCapacity)) + i8) != 0) {
            return;
        }
        throw new AssertionError("FlatBuffers: field " + i8 + " must be set");
    }

    public void c(boolean z7) {
        T(1, 0);
        U(z7);
    }

    public byte[] c0() {
        return d0(this.f7525b, this.f7524a.capacity() - this.f7525b);
    }

    public void d(byte b8) {
        T(1, 0);
        V(b8);
    }

    public byte[] d0(int i7, int i8) {
        L();
        byte[] bArr = new byte[i8];
        this.f7524a.position(i7);
        this.f7524a.get(bArr);
        return bArr;
    }

    public void e(int i7, byte b8, int i8) {
        if (this.f7535l || b8 != i8) {
            d(b8);
            f0(i7);
        }
    }

    public InputStream e0() {
        L();
        ByteBuffer byteBufferDuplicate = this.f7524a.duplicate();
        byteBufferDuplicate.position(this.f7525b);
        byteBufferDuplicate.limit(this.f7524a.capacity());
        return new a(byteBufferDuplicate);
    }

    public void f(double d8) {
        T(8, 0);
        W(d8);
    }

    public void f0(int i7) {
        this.f7527d[i7] = R();
    }

    public void g(int i7, double d8, double d9) {
        if (this.f7535l || d8 != d9) {
            f(d8);
            f0(i7);
        }
    }

    public void g0(int i7) {
        Q();
        int[] iArr = this.f7527d;
        if (iArr == null || iArr.length < i7) {
            this.f7527d = new int[i7];
        }
        this.f7528e = i7;
        Arrays.fill(this.f7527d, 0, i7, 0);
        this.f7529f = true;
        this.f7531h = R();
    }

    public void h(float f8) {
        T(4, 0);
        X(f8);
    }

    public void h0(int i7, int i8, int i9) {
        Q();
        this.f7534k = i8;
        int i10 = i7 * i8;
        T(4, i10);
        T(i9, i10);
        this.f7529f = true;
    }

    public void i(int i7, float f8, double d8) {
        if (this.f7535l || f8 != d8) {
            h(f8);
            f0(i7);
        }
    }

    public void j(int i7) {
        T(4, 0);
        Y(i7);
    }

    public void k(int i7, int i8, int i9) {
        if (this.f7535l || i8 != i9) {
            j(i8);
            f0(i7);
        }
    }

    public void l(int i7, long j7, long j8) {
        if (this.f7535l || j7 != j8) {
            m(j7);
            f0(i7);
        }
    }

    public void m(long j7) {
        T(8, 0);
        Z(j7);
    }

    public void n(int i7) {
        T(4, 0);
        Y((R() - i7) + 4);
    }

    public void o(int i7, int i8, int i9) {
        if (this.f7535l || i8 != i9) {
            n(i8);
            f0(i7);
        }
    }

    public void p(int i7, short s7, int i8) {
        if (this.f7535l || s7 != i8) {
            q(s7);
            f0(i7);
        }
    }

    public void q(short s7) {
        T(2, 0);
        a0(s7);
    }

    public void r(int i7, int i8, int i9) {
        if (i8 != i9) {
            a(i8);
            f0(i7);
        }
    }

    public void s() {
        this.f7525b = this.f7524a.capacity();
        this.f7524a.clear();
        this.f7526c = 1;
        while (true) {
            int i7 = this.f7528e;
            if (i7 <= 0) {
                this.f7528e = 0;
                this.f7529f = false;
                this.f7530g = false;
                this.f7531h = 0;
                this.f7533j = 0;
                this.f7534k = 0;
                return;
            }
            int[] iArr = this.f7527d;
            int i8 = i7 - 1;
            this.f7528e = i8;
            iArr[i8] = 0;
        }
    }

    public int t(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        h0(1, iRemaining, 1);
        ByteBuffer byteBuffer2 = this.f7524a;
        int i7 = this.f7525b - iRemaining;
        this.f7525b = i7;
        byteBuffer2.position(i7);
        this.f7524a.put(byteBuffer);
        return E();
    }

    public int u(byte[] bArr) {
        int length = bArr.length;
        h0(1, length, 1);
        ByteBuffer byteBuffer = this.f7524a;
        int i7 = this.f7525b - length;
        this.f7525b = i7;
        byteBuffer.position(i7);
        this.f7524a.put(bArr);
        return E();
    }

    public int v(byte[] bArr, int i7, int i8) {
        h0(1, i8, 1);
        ByteBuffer byteBuffer = this.f7524a;
        int i9 = this.f7525b - i8;
        this.f7525b = i9;
        byteBuffer.position(i9);
        this.f7524a.put(bArr, i7, i8);
        return E();
    }

    public <T extends v> int w(T t7, int[] iArr) {
        t7.t(iArr, this.f7524a);
        return A(iArr);
    }

    public int x(CharSequence charSequence) {
        int iC = this.f7537n.c(charSequence);
        d((byte) 0);
        h0(1, iC, 1);
        ByteBuffer byteBuffer = this.f7524a;
        int i7 = this.f7525b - iC;
        this.f7525b = i7;
        byteBuffer.position(i7);
        this.f7537n.b(charSequence, this.f7524a);
        return E();
    }

    public int y(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        d((byte) 0);
        h0(1, iRemaining, 1);
        ByteBuffer byteBuffer2 = this.f7524a;
        int i7 = this.f7525b - iRemaining;
        this.f7525b = i7;
        byteBuffer2.position(i7);
        this.f7524a.put(byteBuffer);
        return E();
    }

    public ByteBuffer z(int i7, int i8, int i9) {
        int i10 = i7 * i8;
        h0(i7, i8, i9);
        ByteBuffer byteBuffer = this.f7524a;
        int i11 = this.f7525b - i10;
        this.f7525b = i11;
        byteBuffer.position(i11);
        ByteBuffer byteBufferOrder = this.f7524a.slice().order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.limit(i10);
        return byteBufferOrder;
    }

    public i(int i7, b bVar, ByteBuffer byteBuffer, x xVar) {
        this.f7526c = 1;
        this.f7527d = null;
        this.f7528e = 0;
        this.f7529f = false;
        this.f7530g = false;
        this.f7532i = new int[16];
        this.f7533j = 0;
        this.f7534k = 0;
        this.f7535l = false;
        i7 = i7 <= 0 ? 1 : i7;
        this.f7536m = bVar;
        if (byteBuffer != null) {
            this.f7524a = byteBuffer;
            byteBuffer.clear();
            this.f7524a.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f7524a = bVar.a(i7);
        }
        this.f7537n = xVar;
        this.f7525b = this.f7524a.capacity();
    }

    public i(int i7) {
        this(i7, c.f7539a, null, x.d());
    }

    public i() {
        this(1024);
    }

    public i(ByteBuffer byteBuffer, b bVar) {
        this(byteBuffer.capacity(), bVar, byteBuffer, x.d());
    }

    public i(ByteBuffer byteBuffer) {
        this(byteBuffer, new c());
    }
}
