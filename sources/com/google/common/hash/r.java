package com.google.common.hash;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f21868a = "0123456789abcdef".toCharArray();

    private static final class a extends r implements Serializable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final long f21869c = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final byte[] f21870b;

        a(byte[] bArr) {
            this.f21870b = (byte[]) com.google.common.base.e0.E(bArr);
        }

        @Override // com.google.common.hash.r
        public byte[] a() {
            return (byte[]) this.f21870b.clone();
        }

        @Override // com.google.common.hash.r
        public int b() {
            byte[] bArr = this.f21870b;
            com.google.common.base.e0.n0(bArr.length >= 4, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", bArr.length);
            byte[] bArr2 = this.f21870b;
            return ((bArr2[3] & 255) << 24) | (bArr2[0] & 255) | ((bArr2[1] & 255) << 8) | ((bArr2[2] & 255) << 16);
        }

        @Override // com.google.common.hash.r
        public long c() {
            byte[] bArr = this.f21870b;
            com.google.common.base.e0.n0(bArr.length >= 8, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", bArr.length);
            return m();
        }

        @Override // com.google.common.hash.r
        public int d() {
            return this.f21870b.length * 8;
        }

        @Override // com.google.common.hash.r
        boolean f(r rVar) {
            if (this.f21870b.length != rVar.l().length) {
                return false;
            }
            boolean z7 = true;
            int i7 = 0;
            while (true) {
                byte[] bArr = this.f21870b;
                if (i7 >= bArr.length) {
                    return z7;
                }
                z7 &= bArr[i7] == rVar.l()[i7];
                i7++;
            }
        }

        @Override // com.google.common.hash.r
        byte[] l() {
            return this.f21870b;
        }

        @Override // com.google.common.hash.r
        public long m() {
            long j7 = this.f21870b[0] & 255;
            for (int i7 = 1; i7 < Math.min(this.f21870b.length, 8); i7++) {
                j7 |= (((long) this.f21870b[i7]) & 255) << (i7 * 8);
            }
            return j7;
        }

        @Override // com.google.common.hash.r
        void o(byte[] bArr, int i7, int i8) {
            System.arraycopy(this.f21870b, 0, bArr, i7, i8);
        }
    }

    private static final class b extends r implements Serializable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final long f21871c = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f21872b;

        b(int i7) {
            this.f21872b = i7;
        }

        @Override // com.google.common.hash.r
        public byte[] a() {
            int i7 = this.f21872b;
            return new byte[]{(byte) i7, (byte) (i7 >> 8), (byte) (i7 >> 16), (byte) (i7 >> 24)};
        }

        @Override // com.google.common.hash.r
        public int b() {
            return this.f21872b;
        }

        @Override // com.google.common.hash.r
        public long c() {
            throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
        }

        @Override // com.google.common.hash.r
        public int d() {
            return 32;
        }

        @Override // com.google.common.hash.r
        boolean f(r rVar) {
            return this.f21872b == rVar.b();
        }

        @Override // com.google.common.hash.r
        public long m() {
            return com.google.common.primitives.k0.r(this.f21872b);
        }

        @Override // com.google.common.hash.r
        void o(byte[] bArr, int i7, int i8) {
            for (int i9 = 0; i9 < i8; i9++) {
                bArr[i7 + i9] = (byte) (this.f21872b >> (i9 * 8));
            }
        }
    }

    private static final class c extends r implements Serializable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final long f21873c = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f21874b;

        c(long j7) {
            this.f21874b = j7;
        }

        @Override // com.google.common.hash.r
        public byte[] a() {
            long j7 = this.f21874b;
            return new byte[]{(byte) j7, (byte) (j7 >> 8), (byte) (j7 >> 16), (byte) (j7 >> 24), (byte) (j7 >> 32), (byte) (j7 >> 40), (byte) (j7 >> 48), (byte) (j7 >> 56)};
        }

        @Override // com.google.common.hash.r
        public int b() {
            return (int) this.f21874b;
        }

        @Override // com.google.common.hash.r
        public long c() {
            return this.f21874b;
        }

        @Override // com.google.common.hash.r
        public int d() {
            return 64;
        }

        @Override // com.google.common.hash.r
        boolean f(r rVar) {
            return this.f21874b == rVar.c();
        }

        @Override // com.google.common.hash.r
        public long m() {
            return this.f21874b;
        }

        @Override // com.google.common.hash.r
        void o(byte[] bArr, int i7, int i8) {
            for (int i9 = 0; i9 < i8; i9++) {
                bArr[i7 + i9] = (byte) (this.f21874b >> (i9 * 8));
            }
        }
    }

    r() {
    }

    private static int e(char c8) {
        if (c8 >= '0' && c8 <= '9') {
            return c8 - '0';
        }
        if (c8 >= 'a' && c8 <= 'f') {
            return (c8 - 'a') + 10;
        }
        throw new IllegalArgumentException("Illegal hexadecimal character: " + c8);
    }

    public static r g(byte[] bArr) {
        com.google.common.base.e0.e(bArr.length >= 1, "A HashCode must contain at least 1 byte.");
        return h((byte[]) bArr.clone());
    }

    static r h(byte[] bArr) {
        return new a(bArr);
    }

    public static r i(int i7) {
        return new b(i7);
    }

    public static r j(long j7) {
        return new c(j7);
    }

    public static r k(String str) {
        com.google.common.base.e0.u(str.length() >= 2, "input string (%s) must have at least 2 characters", str);
        com.google.common.base.e0.u(str.length() % 2 == 0, "input string (%s) must have an even number of characters", str);
        byte[] bArr = new byte[str.length() / 2];
        for (int i7 = 0; i7 < str.length(); i7 += 2) {
            bArr[i7 / 2] = (byte) ((e(str.charAt(i7)) << 4) + e(str.charAt(i7 + 1)));
        }
        return h(bArr);
    }

    public abstract byte[] a();

    public abstract int b();

    public abstract long c();

    public abstract int d();

    public final boolean equals(Object obj) {
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return d() == rVar.d() && f(rVar);
    }

    abstract boolean f(r rVar);

    public final int hashCode() {
        if (d() >= 32) {
            return b();
        }
        byte[] bArrL = l();
        int i7 = bArrL[0] & 255;
        for (int i8 = 1; i8 < bArrL.length; i8++) {
            i7 |= (bArrL[i8] & 255) << (i8 * 8);
        }
        return i7;
    }

    byte[] l() {
        return a();
    }

    public abstract long m();

    @u1.a
    public int n(byte[] bArr, int i7, int i8) {
        int iU = com.google.common.primitives.c0.u(i8, d() / 8);
        com.google.common.base.e0.f0(i7, i7 + iU, bArr.length);
        o(bArr, i7, iU);
        return iU;
    }

    abstract void o(byte[] bArr, int i7, int i8);

    public final String toString() {
        byte[] bArrL = l();
        StringBuilder sb = new StringBuilder(bArrL.length * 2);
        for (byte b8 : bArrL) {
            char[] cArr = f21868a;
            sb.append(cArr[(b8 >> 4) & 15]);
            sb.append(cArr[b8 & com.google.common.base.c.f19317q]);
        }
        return sb.toString();
    }
}
