package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public final class l0 extends p {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @a7.d
    private final transient byte[][] f38492g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @a7.d
    private final transient int[] f38493h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(@a7.d byte[][] segments, @a7.d int[] directory) {
        super(p.f38507e.o());
        kotlin.jvm.internal.l0.p(segments, "segments");
        kotlin.jvm.internal.l0.p(directory, "directory");
        this.f38492g = segments;
        this.f38493h = directory;
    }

    private final p q0() {
        return new p(k0());
    }

    private final Object writeReplace() {
        p pVarQ0 = q0();
        if (pVarQ0 != null) {
            return pVarQ0;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
    }

    @Override // okio.p
    public int B(@a7.d byte[] other, int i7) {
        kotlin.jvm.internal.l0.p(other, "other");
        return q0().B(other, i7);
    }

    @Override // okio.p
    @a7.d
    public byte[] E() {
        return k0();
    }

    @Override // okio.p
    public byte F(int i7) {
        j.e(o0()[p0().length - 1], i7, 1L);
        int iN = v5.e.n(this, i7);
        return p0()[iN][(i7 - (iN == 0 ? 0 : o0()[iN - 1])) + o0()[p0().length + iN]];
    }

    @Override // okio.p
    public int K(@a7.d byte[] other, int i7) {
        kotlin.jvm.internal.l0.p(other, "other");
        return q0().K(other, i7);
    }

    @Override // okio.p
    public boolean S(int i7, @a7.d p other, int i8, int i9) {
        kotlin.jvm.internal.l0.p(other, "other");
        if (i7 < 0 || i7 > a0() - i9) {
            return false;
        }
        int i10 = i9 + i7;
        int iN = v5.e.n(this, i7);
        while (i7 < i10) {
            int i11 = iN == 0 ? 0 : o0()[iN - 1];
            int i12 = o0()[iN] - i11;
            int i13 = o0()[p0().length + iN];
            int iMin = Math.min(i10, i12 + i11) - i7;
            if (!other.T(i8, p0()[iN], i13 + (i7 - i11), iMin)) {
                return false;
            }
            i8 += iMin;
            i7 += iMin;
            iN++;
        }
        return true;
    }

    @Override // okio.p
    public boolean T(int i7, @a7.d byte[] other, int i8, int i9) {
        kotlin.jvm.internal.l0.p(other, "other");
        if (i7 < 0 || i7 > a0() - i9 || i8 < 0 || i8 > other.length - i9) {
            return false;
        }
        int i10 = i9 + i7;
        int iN = v5.e.n(this, i7);
        while (i7 < i10) {
            int i11 = iN == 0 ? 0 : o0()[iN - 1];
            int i12 = o0()[iN] - i11;
            int i13 = o0()[p0().length + iN];
            int iMin = Math.min(i10, i12 + i11) - i7;
            if (!j.d(p0()[iN], i13 + (i7 - i11), other, i8, iMin)) {
                return false;
            }
            i8 += iMin;
            i7 += iMin;
            iN++;
        }
        return true;
    }

    @Override // okio.p
    @a7.d
    public ByteBuffer c() {
        ByteBuffer byteBufferAsReadOnlyBuffer = ByteBuffer.wrap(k0()).asReadOnlyBuffer();
        kotlin.jvm.internal.l0.o(byteBufferAsReadOnlyBuffer, "ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer()");
        return byteBufferAsReadOnlyBuffer;
    }

    @Override // okio.p
    @a7.d
    public String d() {
        return q0().d();
    }

    @Override // okio.p
    @a7.d
    public String d0(@a7.d Charset charset) {
        kotlin.jvm.internal.l0.p(charset, "charset");
        return q0().d0(charset);
    }

    @Override // okio.p
    @a7.d
    public String e() {
        return q0().e();
    }

    @Override // okio.p
    public boolean equals(@a7.e Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (pVar.a0() == a0() && S(0, pVar, 0, a0())) {
                return true;
            }
        }
        return false;
    }

    @Override // okio.p
    @a7.d
    public p g0(int i7, int i8) {
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("beginIndex=" + i7 + " < 0").toString());
        }
        if (!(i8 <= a0())) {
            throw new IllegalArgumentException(("endIndex=" + i8 + " > length(" + a0() + ')').toString());
        }
        int i9 = i8 - i7;
        if (!(i9 >= 0)) {
            throw new IllegalArgumentException(("endIndex=" + i8 + " < beginIndex=" + i7).toString());
        }
        if (i7 == 0 && i8 == a0()) {
            return this;
        }
        if (i7 == i8) {
            return p.f38507e;
        }
        int iN = v5.e.n(this, i7);
        int iN2 = v5.e.n(this, i8 - 1);
        byte[][] bArr = (byte[][]) kotlin.collections.o.M1(p0(), iN, iN2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (iN <= iN2) {
            int i10 = 0;
            int i11 = iN;
            while (true) {
                iArr[i10] = Math.min(o0()[i11] - i7, i9);
                int i12 = i10 + 1;
                iArr[i10 + bArr.length] = o0()[p0().length + i11];
                if (i11 == iN2) {
                    break;
                }
                i11++;
                i10 = i12;
            }
        }
        int i13 = iN != 0 ? o0()[iN - 1] : 0;
        int length = bArr.length;
        iArr[length] = iArr[length] + (i7 - i13);
        return new l0(bArr, iArr);
    }

    @Override // okio.p
    public int hashCode() {
        int iP = p();
        if (iP != 0) {
            return iP;
        }
        int length = p0().length;
        int i7 = 0;
        int i8 = 1;
        int i9 = 0;
        while (i7 < length) {
            int i10 = o0()[length + i7];
            int i11 = o0()[i7];
            byte[] bArr = p0()[i7];
            int i12 = (i11 - i9) + i10;
            while (i10 < i12) {
                i8 = (i8 * 31) + bArr[i10];
                i10++;
            }
            i7++;
            i9 = i11;
        }
        V(i8);
        return i8;
    }

    @Override // okio.p
    @a7.d
    public p i(@a7.d String algorithm) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.l0.p(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        int length = p0().length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            int i9 = o0()[length + i7];
            int i10 = o0()[i7];
            messageDigest.update(p0()[i7], i9, i10 - i8);
            i7++;
            i8 = i10;
        }
        byte[] bArrDigest = messageDigest.digest();
        kotlin.jvm.internal.l0.o(bArrDigest, "digest.digest()");
        return new p(bArrDigest);
    }

    @Override // okio.p
    @a7.d
    public p i0() {
        return q0().i0();
    }

    @Override // okio.p
    @a7.d
    public p j0() {
        return q0().j0();
    }

    @Override // okio.p
    @a7.d
    public byte[] k0() {
        byte[] bArr = new byte[a0()];
        int length = p0().length;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < length) {
            int i10 = o0()[length + i7];
            int i11 = o0()[i7];
            int i12 = i11 - i8;
            kotlin.collections.o.W0(p0()[i7], bArr, i9, i10, i10 + i12);
            i9 += i12;
            i7++;
            i8 = i11;
        }
        return bArr;
    }

    @Override // okio.p
    public void m0(@a7.d OutputStream out) throws IOException {
        kotlin.jvm.internal.l0.p(out, "out");
        int length = p0().length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            int i9 = o0()[length + i7];
            int i10 = o0()[i7];
            out.write(p0()[i7], i9, i10 - i8);
            i7++;
            i8 = i10;
        }
    }

    @Override // okio.p
    public void n0(@a7.d m buffer, int i7, int i8) {
        kotlin.jvm.internal.l0.p(buffer, "buffer");
        int i9 = i8 + i7;
        int iN = v5.e.n(this, i7);
        while (i7 < i9) {
            int i10 = iN == 0 ? 0 : o0()[iN - 1];
            int i11 = o0()[iN] - i10;
            int i12 = o0()[p0().length + iN];
            int iMin = Math.min(i9, i11 + i10) - i7;
            int i13 = i12 + (i7 - i10);
            j0 j0Var = new j0(p0()[iN], i13, i13 + iMin, true, false);
            j0 j0Var2 = buffer.f38494a;
            if (j0Var2 == null) {
                j0Var.f38474g = j0Var;
                j0Var.f38473f = j0Var;
                buffer.f38494a = j0Var;
            } else {
                kotlin.jvm.internal.l0.m(j0Var2);
                j0 j0Var3 = j0Var2.f38474g;
                kotlin.jvm.internal.l0.m(j0Var3);
                j0Var3.c(j0Var);
            }
            i7 += iMin;
            iN++;
        }
        buffer.s1(buffer.B1() + ((long) a0()));
    }

    @a7.d
    public final int[] o0() {
        return this.f38493h;
    }

    @a7.d
    public final byte[][] p0() {
        return this.f38492g;
    }

    @Override // okio.p
    public int q() {
        return o0()[p0().length - 1];
    }

    @Override // okio.p
    @a7.d
    public String t() {
        return q0().t();
    }

    @Override // okio.p
    @a7.d
    public String toString() {
        return q0().toString();
    }

    @Override // okio.p
    @a7.d
    public p u(@a7.d String algorithm, @a7.d p key) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.l0.p(algorithm, "algorithm");
        kotlin.jvm.internal.l0.p(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.k0(), algorithm));
            int length = p0().length;
            int i7 = 0;
            int i8 = 0;
            while (i7 < length) {
                int i9 = o0()[length + i7];
                int i10 = o0()[i7];
                mac.update(p0()[i7], i9, i10 - i8);
                i7++;
                i8 = i10;
            }
            byte[] bArrDoFinal = mac.doFinal();
            kotlin.jvm.internal.l0.o(bArrDoFinal, "mac.doFinal()");
            return new p(bArrDoFinal);
        } catch (InvalidKeyException e8) {
            throw new IllegalArgumentException(e8);
        }
    }
}
