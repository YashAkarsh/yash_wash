package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public final class o extends v {

    public static final class a extends b {
        public a f(int i7, int i8, ByteBuffer byteBuffer) {
            b(i7, i8, byteBuffer);
            return this;
        }

        public o g(int i7) {
            return h(new o(), i7);
        }

        public o h(o oVar, int i7) {
            return oVar.v(v.c(a(i7), this.f7513d), this.f7513d);
        }
    }

    public static void A(i iVar, boolean z7) {
        iVar.b(1, z7, false);
    }

    public static void B(i iVar, short s7) {
        iVar.p(5, s7, 0);
    }

    public static void C(i iVar, int i7) {
        iVar.k(0, i7, 0);
    }

    public static void D(i iVar, short s7) {
        iVar.p(2, s7, 0);
    }

    public static void E(i iVar, short s7) {
        iVar.p(4, s7, 0);
    }

    public static int M(i iVar, int[] iArr) {
        iVar.h0(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            iVar.j(iArr[length]);
        }
        return iVar.E();
    }

    public static int N(i iVar, int i7, boolean z7, short s7, short s8, short s9, short s10, int i8) {
        iVar.g0(7);
        y(iVar, i8);
        C(iVar, i7);
        B(iVar, s10);
        E(iVar, s9);
        z(iVar, s8);
        D(iVar, s7);
        A(iVar, z7);
        return P(iVar);
    }

    public static int P(i iVar) {
        return iVar.D();
    }

    public static o Q(ByteBuffer byteBuffer) {
        return R(byteBuffer, new o());
    }

    public static o R(ByteBuffer byteBuffer, o oVar) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return oVar.v(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public static void V(i iVar, int i7) {
        iVar.h0(4, i7, 4);
    }

    public static void W(i iVar) {
        iVar.g0(7);
    }

    public static void u() {
        g.a();
    }

    public static void y(i iVar, int i7) {
        iVar.o(6, i7, 0);
    }

    public static void z(i iVar, short s7) {
        iVar.p(3, s7, 0);
    }

    public int F(int i7) {
        int iD = d(16);
        if (iD != 0) {
            return this.f7613b.getInt(l(iD) + (i7 * 4));
        }
        return 0;
    }

    public ByteBuffer G() {
        return m(16, 4);
    }

    public ByteBuffer H(ByteBuffer byteBuffer) {
        return n(byteBuffer, 16, 4);
    }

    public int I() {
        int iD = d(16);
        if (iD != 0) {
            return o(iD);
        }
        return 0;
    }

    public m J() {
        return K(new m());
    }

    public m K(m mVar) {
        int iD = d(16);
        if (iD != 0) {
            return mVar.f(l(iD), this.f7613b);
        }
        return null;
    }

    public short L() {
        int iD = d(10);
        if (iD != 0) {
            return this.f7613b.getShort(iD + this.f7612a);
        }
        return (short) 0;
    }

    public boolean O() {
        int iD = d(6);
        return (iD == 0 || this.f7613b.get(iD + this.f7612a) == 0) ? false : true;
    }

    public short S() {
        int iD = d(14);
        if (iD != 0) {
            return this.f7613b.getShort(iD + this.f7612a);
        }
        return (short) 0;
    }

    public int T() {
        int iD = d(4);
        if (iD != 0) {
            return this.f7613b.getInt(iD + this.f7612a);
        }
        return 0;
    }

    public short U() {
        int iD = d(8);
        if (iD != 0) {
            return this.f7613b.getShort(iD + this.f7612a);
        }
        return (short) 0;
    }

    public short X() {
        int iD = d(12);
        if (iD != 0) {
            return this.f7613b.getShort(iD + this.f7612a);
        }
        return (short) 0;
    }

    public o v(int i7, ByteBuffer byteBuffer) {
        w(i7, byteBuffer);
        return this;
    }

    public void w(int i7, ByteBuffer byteBuffer) {
        g(i7, byteBuffer);
    }
}
