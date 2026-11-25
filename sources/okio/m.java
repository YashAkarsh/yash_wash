package okio;

import com.haier.uhome.mesh.bridge.RtkCoreMeshWrapper;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.b1;
import kotlin.jvm.internal.s1;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements o, n, Cloneable, ByteChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @h5.e
    @a7.e
    public j0 f38494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f38495b;

    public static final class a implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @h5.e
        @a7.e
        public m f38496a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @h5.e
        public boolean f38497b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private j0 f38498c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @h5.e
        @a7.e
        public byte[] f38500e;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @h5.e
        public long f38499d = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @h5.e
        public int f38501f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @h5.e
        public int f38502g = -1;

        public final long b(int i7) {
            if (!(i7 > 0)) {
                throw new IllegalArgumentException(("minByteCount <= 0: " + i7).toString());
            }
            if (!(i7 <= 8192)) {
                throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + i7).toString());
            }
            m mVar = this.f38496a;
            if (mVar == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (!this.f38497b) {
                throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
            }
            long jB1 = mVar.B1();
            j0 j0VarW1 = mVar.W1(i7);
            int i8 = 8192 - j0VarW1.f38470c;
            j0VarW1.f38470c = 8192;
            long j7 = i8;
            mVar.s1(jB1 + j7);
            this.f38498c = j0VarW1;
            this.f38499d = jB1;
            this.f38500e = j0VarW1.f38468a;
            this.f38501f = 8192 - i8;
            this.f38502g = 8192;
            return j7;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!(this.f38496a != null)) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            this.f38496a = null;
            this.f38498c = null;
            this.f38499d = -1L;
            this.f38500e = null;
            this.f38501f = -1;
            this.f38502g = -1;
        }

        public final int e() {
            long j7 = this.f38499d;
            m mVar = this.f38496a;
            kotlin.jvm.internal.l0.m(mVar);
            if (!(j7 != mVar.B1())) {
                throw new IllegalStateException("no more bytes".toString());
            }
            long j8 = this.f38499d;
            return g(j8 == -1 ? 0L : j8 + ((long) (this.f38502g - this.f38501f)));
        }

        public final long f(long j7) {
            m mVar = this.f38496a;
            if (mVar == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (!this.f38497b) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
            }
            long jB1 = mVar.B1();
            int i7 = 1;
            if (j7 <= jB1) {
                if (!(j7 >= 0)) {
                    throw new IllegalArgumentException(("newSize < 0: " + j7).toString());
                }
                long j8 = jB1 - j7;
                while (j8 > 0) {
                    j0 j0Var = mVar.f38494a;
                    kotlin.jvm.internal.l0.m(j0Var);
                    j0 j0Var2 = j0Var.f38474g;
                    kotlin.jvm.internal.l0.m(j0Var2);
                    int i8 = j0Var2.f38470c;
                    long j9 = i8 - j0Var2.f38469b;
                    if (j9 > j8) {
                        j0Var2.f38470c = i8 - ((int) j8);
                        break;
                    }
                    mVar.f38494a = j0Var2.b();
                    k0.d(j0Var2);
                    j8 -= j9;
                }
                this.f38498c = null;
                this.f38499d = j7;
                this.f38500e = null;
                this.f38501f = -1;
                this.f38502g = -1;
            } else if (j7 > jB1) {
                long j10 = j7 - jB1;
                boolean z7 = true;
                while (j10 > 0) {
                    j0 j0VarW1 = mVar.W1(i7);
                    int iMin = (int) Math.min(j10, 8192 - j0VarW1.f38470c);
                    int i9 = j0VarW1.f38470c + iMin;
                    j0VarW1.f38470c = i9;
                    j10 -= (long) iMin;
                    if (z7) {
                        this.f38498c = j0VarW1;
                        this.f38499d = jB1;
                        this.f38500e = j0VarW1.f38468a;
                        this.f38501f = i9 - iMin;
                        this.f38502g = i9;
                        z7 = false;
                    }
                    i7 = 1;
                }
            }
            mVar.s1(j7);
            return jB1;
        }

        public final int g(long j7) {
            j0 j0VarC;
            m mVar = this.f38496a;
            if (mVar == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (j7 < -1 || j7 > mVar.B1()) {
                s1 s1Var = s1.f34921a;
                String str = String.format("offset=%s > size=%s", Arrays.copyOf(new Object[]{Long.valueOf(j7), Long.valueOf(mVar.B1())}, 2));
                kotlin.jvm.internal.l0.o(str, "java.lang.String.format(format, *args)");
                throw new ArrayIndexOutOfBoundsException(str);
            }
            if (j7 == -1 || j7 == mVar.B1()) {
                this.f38498c = null;
                this.f38499d = j7;
                this.f38500e = null;
                this.f38501f = -1;
                this.f38502g = -1;
                return -1;
            }
            long jB1 = mVar.B1();
            j0 j0Var = mVar.f38494a;
            j0 j0Var2 = this.f38498c;
            long j8 = 0;
            if (j0Var2 != null) {
                long j9 = this.f38499d;
                int i7 = this.f38501f;
                kotlin.jvm.internal.l0.m(j0Var2);
                long j10 = j9 - ((long) (i7 - j0Var2.f38469b));
                if (j10 > j7) {
                    j0VarC = j0Var;
                    j0Var = this.f38498c;
                    jB1 = j10;
                } else {
                    j0VarC = this.f38498c;
                    j8 = j10;
                }
            } else {
                j0VarC = j0Var;
            }
            if (jB1 - j7 > j7 - j8) {
                while (true) {
                    kotlin.jvm.internal.l0.m(j0VarC);
                    int i8 = j0VarC.f38470c;
                    int i9 = j0VarC.f38469b;
                    if (j7 < ((long) (i8 - i9)) + j8) {
                        break;
                    }
                    j8 += (long) (i8 - i9);
                    j0VarC = j0VarC.f38473f;
                }
            } else {
                while (jB1 > j7) {
                    kotlin.jvm.internal.l0.m(j0Var);
                    j0Var = j0Var.f38474g;
                    kotlin.jvm.internal.l0.m(j0Var);
                    jB1 -= (long) (j0Var.f38470c - j0Var.f38469b);
                }
                j8 = jB1;
                j0VarC = j0Var;
            }
            if (this.f38497b) {
                kotlin.jvm.internal.l0.m(j0VarC);
                if (j0VarC.f38471d) {
                    j0 j0VarF = j0VarC.f();
                    if (mVar.f38494a == j0VarC) {
                        mVar.f38494a = j0VarF;
                    }
                    j0VarC = j0VarC.c(j0VarF);
                    j0 j0Var3 = j0VarC.f38474g;
                    kotlin.jvm.internal.l0.m(j0Var3);
                    j0Var3.b();
                }
            }
            this.f38498c = j0VarC;
            this.f38499d = j7;
            kotlin.jvm.internal.l0.m(j0VarC);
            this.f38500e = j0VarC.f38468a;
            int i10 = j0VarC.f38469b + ((int) (j7 - j8));
            this.f38501f = i10;
            int i11 = j0VarC.f38470c;
            this.f38502g = i11;
            return i11 - i10;
        }
    }

    public static final class c extends OutputStream {
        c() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        @a7.d
        public String toString() {
            return m.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i7) {
            m.this.writeByte(i7);
        }

        @Override // java.io.OutputStream
        public void write(@a7.d byte[] data, int i7, int i8) {
            kotlin.jvm.internal.l0.p(data, "data");
            m.this.write(data, i7, i8);
        }
    }

    public static /* synthetic */ a V0(m mVar, a aVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            aVar = new a();
        }
        return mVar.T0(aVar);
    }

    private final void d1(InputStream inputStream, long j7, boolean z7) throws IOException {
        while (true) {
            if (j7 <= 0 && !z7) {
                return;
            }
            j0 j0VarW1 = W1(1);
            int i7 = inputStream.read(j0VarW1.f38468a, j0VarW1.f38470c, (int) Math.min(j7, 8192 - j0VarW1.f38470c));
            if (i7 == -1) {
                if (j0VarW1.f38469b == j0VarW1.f38470c) {
                    this.f38494a = j0VarW1.b();
                    k0.d(j0VarW1);
                }
                if (!z7) {
                    throw new EOFException();
                }
                return;
            }
            j0VarW1.f38470c += i7;
            long j8 = i7;
            this.f38495b += j8;
            j7 -= j8;
        }
    }

    public static /* synthetic */ m g0(m mVar, OutputStream outputStream, long j7, long j8, int i7, Object obj) throws IOException {
        if ((i7 & 2) != 0) {
            j7 = 0;
        }
        long j9 = j7;
        if ((i7 & 4) != 0) {
            j8 = mVar.f38495b - j9;
        }
        return mVar.G(outputStream, j9, j8);
    }

    public static /* synthetic */ m h0(m mVar, m mVar2, long j7, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            j7 = 0;
        }
        return mVar.H(mVar2, j7);
    }

    public static /* synthetic */ m l0(m mVar, m mVar2, long j7, long j8, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            j7 = 0;
        }
        return mVar.Q(mVar2, j7, j8);
    }

    private final p o0(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        j0 j0Var = this.f38494a;
        if (j0Var != null) {
            byte[] bArr = j0Var.f38468a;
            int i7 = j0Var.f38469b;
            messageDigest.update(bArr, i7, j0Var.f38470c - i7);
            j0 j0Var2 = j0Var.f38473f;
            kotlin.jvm.internal.l0.m(j0Var2);
            while (j0Var2 != j0Var) {
                byte[] bArr2 = j0Var2.f38468a;
                int i8 = j0Var2.f38469b;
                messageDigest.update(bArr2, i8, j0Var2.f38470c - i8);
                j0Var2 = j0Var2.f38473f;
                kotlin.jvm.internal.l0.m(j0Var2);
            }
        }
        byte[] bArrDigest = messageDigest.digest();
        kotlin.jvm.internal.l0.o(bArrDigest, "messageDigest.digest()");
        return new p(bArrDigest);
    }

    public static /* synthetic */ m p2(m mVar, OutputStream outputStream, long j7, int i7, Object obj) throws IOException {
        if ((i7 & 2) != 0) {
            j7 = mVar.f38495b;
        }
        return mVar.o2(outputStream, j7);
    }

    public static /* synthetic */ a q1(m mVar, a aVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            aVar = new a();
        }
        return mVar.i1(aVar);
    }

    private final p x0(String str, p pVar) throws NoSuchAlgorithmException {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(pVar.E(), str));
            j0 j0Var = this.f38494a;
            if (j0Var != null) {
                byte[] bArr = j0Var.f38468a;
                int i7 = j0Var.f38469b;
                mac.update(bArr, i7, j0Var.f38470c - i7);
                j0 j0Var2 = j0Var.f38473f;
                kotlin.jvm.internal.l0.m(j0Var2);
                while (j0Var2 != j0Var) {
                    byte[] bArr2 = j0Var2.f38468a;
                    int i8 = j0Var2.f38469b;
                    mac.update(bArr2, i8, j0Var2.f38470c - i8);
                    j0Var2 = j0Var2.f38473f;
                    kotlin.jvm.internal.l0.m(j0Var2);
                }
            }
            byte[] bArrDoFinal = mac.doFinal();
            kotlin.jvm.internal.l0.o(bArrDoFinal, "mac.doFinal()");
            return new p(bArrDoFinal);
        } catch (InvalidKeyException e8) {
            throw new IllegalArgumentException(e8);
        }
    }

    @Override // okio.o
    public int A0() throws EOFException {
        int i7;
        int i8;
        int i9;
        if (B1() == 0) {
            throw new EOFException();
        }
        byte bV0 = v0(0L);
        if ((bV0 & 128) == 0) {
            i7 = bV0 & 127;
            i9 = 0;
            i8 = 1;
        } else if ((bV0 & 224) == 192) {
            i7 = bV0 & com.google.common.base.c.I;
            i8 = 2;
            i9 = 128;
        } else if ((bV0 & 240) == 224) {
            i7 = bV0 & com.google.common.base.c.f19317q;
            i8 = 3;
            i9 = 2048;
        } else {
            if ((bV0 & 248) != 240) {
                skip(1L);
                return r0.f38530c;
            }
            i7 = bV0 & 7;
            i8 = 4;
            i9 = 65536;
        }
        long j7 = i8;
        if (B1() < j7) {
            throw new EOFException("size < " + i8 + ": " + B1() + " (to read code point prefixed 0x" + j.m(bV0) + ')');
        }
        for (int i10 = 1; i10 < i8; i10++) {
            long j8 = i10;
            byte bV1 = v0(j8);
            if ((bV1 & 192) != 128) {
                skip(j8);
                return r0.f38530c;
            }
            i7 = (i7 << 6) | (bV1 & r0.f38528a);
        }
        skip(j7);
        if (i7 > 1114111) {
            return r0.f38530c;
        }
        return ((55296 <= i7 && 57343 >= i7) || i7 < i9) ? r0.f38530c : i7;
    }

    @a7.d
    public final p A1() {
        return o0("SHA-512");
    }

    @h5.h(name = "size")
    public final long B1() {
        return this.f38495b;
    }

    @a7.d
    public final m C() {
        m mVar = new m();
        if (B1() != 0) {
            j0 j0Var = this.f38494a;
            kotlin.jvm.internal.l0.m(j0Var);
            j0 j0VarD = j0Var.d();
            mVar.f38494a = j0VarD;
            j0VarD.f38474g = j0VarD;
            j0VarD.f38473f = j0VarD;
            for (j0 j0Var2 = j0Var.f38473f; j0Var2 != j0Var; j0Var2 = j0Var2.f38473f) {
                j0 j0Var3 = j0VarD.f38474g;
                kotlin.jvm.internal.l0.m(j0Var3);
                kotlin.jvm.internal.l0.m(j0Var2);
                j0Var3.c(j0Var2.d());
            }
            mVar.s1(B1());
        }
        return mVar;
    }

    @Override // okio.n
    public long C0(@a7.d o0 source) throws IOException {
        kotlin.jvm.internal.l0.p(source, "source");
        long j7 = 0;
        while (true) {
            long j8 = source.read(this, 8192);
            if (j8 == -1) {
                return j7;
            }
            j7 += j8;
        }
    }

    @a7.d
    @h5.i
    public final m E(@a7.d OutputStream outputStream) throws IOException {
        return g0(this, outputStream, 0L, 0L, 6, null);
    }

    @Override // okio.o
    @a7.d
    public p E0() {
        return l(B1());
    }

    @a7.d
    @h5.i
    public final m F(@a7.d OutputStream outputStream, long j7) throws IOException {
        return g0(this, outputStream, j7, 0L, 4, null);
    }

    @Override // okio.o
    public long F1(@a7.d p targetBytes, long j7) {
        int i7;
        int i8;
        kotlin.jvm.internal.l0.p(targetBytes, "targetBytes");
        long jB1 = 0;
        if (!(j7 >= 0)) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j7).toString());
        }
        j0 j0Var = this.f38494a;
        if (j0Var == null) {
            return -1L;
        }
        if (B1() - j7 < j7) {
            jB1 = B1();
            while (jB1 > j7) {
                j0Var = j0Var.f38474g;
                kotlin.jvm.internal.l0.m(j0Var);
                jB1 -= (long) (j0Var.f38470c - j0Var.f38469b);
            }
            if (targetBytes.a0() == 2) {
                byte bN = targetBytes.n(0);
                byte bN2 = targetBytes.n(1);
                while (jB1 < B1()) {
                    byte[] bArr = j0Var.f38468a;
                    i7 = (int) ((((long) j0Var.f38469b) + j7) - jB1);
                    int i9 = j0Var.f38470c;
                    while (true) {
                        if (i7 >= i9) {
                            jB1 += (long) (j0Var.f38470c - j0Var.f38469b);
                            j0Var = j0Var.f38473f;
                            kotlin.jvm.internal.l0.m(j0Var);
                            j7 = jB1;
                        } else {
                            byte b8 = bArr[i7];
                            if (b8 == bN || b8 == bN2) {
                                i8 = j0Var.f38469b;
                            } else {
                                i7++;
                            }
                        }
                    }
                }
                return -1L;
            }
            byte[] bArrE = targetBytes.E();
            while (jB1 < B1()) {
                byte[] bArr2 = j0Var.f38468a;
                i7 = (int) ((((long) j0Var.f38469b) + j7) - jB1);
                int i10 = j0Var.f38470c;
                while (true) {
                    if (i7 < i10) {
                        byte b9 = bArr2[i7];
                        int length = bArrE.length;
                        int i11 = 0;
                        while (true) {
                            if (i11 >= length) {
                                i7++;
                            } else if (b9 == bArrE[i11]) {
                                i8 = j0Var.f38469b;
                            } else {
                                i11++;
                            }
                        }
                    } else {
                        jB1 += (long) (j0Var.f38470c - j0Var.f38469b);
                        j0Var = j0Var.f38473f;
                        kotlin.jvm.internal.l0.m(j0Var);
                        j7 = jB1;
                    }
                }
            }
            return -1L;
        }
        while (true) {
            long j8 = ((long) (j0Var.f38470c - j0Var.f38469b)) + jB1;
            if (j8 > j7) {
                break;
            }
            j0Var = j0Var.f38473f;
            kotlin.jvm.internal.l0.m(j0Var);
            jB1 = j8;
        }
        if (targetBytes.a0() == 2) {
            byte bN3 = targetBytes.n(0);
            byte bN4 = targetBytes.n(1);
            while (jB1 < B1()) {
                byte[] bArr3 = j0Var.f38468a;
                i7 = (int) ((((long) j0Var.f38469b) + j7) - jB1);
                int i12 = j0Var.f38470c;
                while (true) {
                    if (i7 >= i12) {
                        jB1 += (long) (j0Var.f38470c - j0Var.f38469b);
                        j0Var = j0Var.f38473f;
                        kotlin.jvm.internal.l0.m(j0Var);
                        j7 = jB1;
                    } else {
                        byte b10 = bArr3[i7];
                        if (b10 == bN3 || b10 == bN4) {
                            i8 = j0Var.f38469b;
                        } else {
                            i7++;
                        }
                    }
                }
            }
            return -1L;
        }
        byte[] bArrE2 = targetBytes.E();
        while (jB1 < B1()) {
            byte[] bArr4 = j0Var.f38468a;
            i7 = (int) ((((long) j0Var.f38469b) + j7) - jB1);
            int i13 = j0Var.f38470c;
            while (true) {
                if (i7 < i13) {
                    byte b11 = bArr4[i7];
                    int length2 = bArrE2.length;
                    int i14 = 0;
                    while (true) {
                        if (i14 >= length2) {
                            i7++;
                        } else if (b11 == bArrE2[i14]) {
                            i8 = j0Var.f38469b;
                        } else {
                            i14++;
                        }
                    }
                } else {
                    jB1 += (long) (j0Var.f38470c - j0Var.f38469b);
                    j0Var = j0Var.f38473f;
                    kotlin.jvm.internal.l0.m(j0Var);
                    j7 = jB1;
                }
            }
        }
        return -1L;
        return ((long) (i7 - i8)) + jB1;
    }

    @a7.d
    @h5.i
    public final m G(@a7.d OutputStream out, long j7, long j8) throws IOException {
        kotlin.jvm.internal.l0.p(out, "out");
        j.e(this.f38495b, j7, j8);
        if (j8 == 0) {
            return this;
        }
        j0 j0Var = this.f38494a;
        while (true) {
            kotlin.jvm.internal.l0.m(j0Var);
            int i7 = j0Var.f38470c;
            int i8 = j0Var.f38469b;
            if (j7 < i7 - i8) {
                break;
            }
            j7 -= (long) (i7 - i8);
            j0Var = j0Var.f38473f;
        }
        while (j8 > 0) {
            kotlin.jvm.internal.l0.m(j0Var);
            int i9 = (int) (((long) j0Var.f38469b) + j7);
            int iMin = (int) Math.min(j0Var.f38470c - i9, j8);
            out.write(j0Var.f38468a, i9, iMin);
            j8 -= (long) iMin;
            j0Var = j0Var.f38473f;
            j7 = 0;
        }
        return this;
    }

    @a7.d
    public final p G0(@a7.d p key) {
        kotlin.jvm.internal.l0.p(key, "key");
        return x0("HmacSHA1", key);
    }

    @Override // okio.o
    public void G1(long j7) throws EOFException {
        if (this.f38495b < j7) {
            throw new EOFException();
        }
    }

    @a7.d
    public final m H(@a7.d m out, long j7) {
        kotlin.jvm.internal.l0.p(out, "out");
        return Q(out, j7, this.f38495b - j7);
    }

    @Override // okio.o
    @a7.d
    public byte[] I() {
        return h1(B1());
    }

    @a7.d
    public final p I0(@a7.d p key) {
        kotlin.jvm.internal.l0.p(key, "key");
        return x0("HmacSHA256", key);
    }

    @Override // okio.o
    public long J(@a7.d p bytes) throws IOException {
        kotlin.jvm.internal.l0.p(bytes, "bytes");
        return k(bytes, 0L);
    }

    @a7.d
    public final p J0(@a7.d p key) {
        kotlin.jvm.internal.l0.p(key, "key");
        return x0("HmacSHA512", key);
    }

    @Override // okio.n
    @a7.d
    public OutputStream J1() {
        return new c();
    }

    @Override // okio.o
    public boolean K0(long j7) {
        return this.f38495b >= j7;
    }

    @a7.d
    public final p L0() {
        return o0("MD5");
    }

    @Override // okio.o
    public long M1(byte b8) {
        return Y(b8, 0L, Long.MAX_VALUE);
    }

    @Override // okio.o
    public boolean N() {
        return this.f38495b == 0;
    }

    @a7.d
    public final p N1() {
        if (B1() <= ((long) Integer.MAX_VALUE)) {
            return R1((int) B1());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + B1()).toString());
    }

    @a7.d
    public final m Q(@a7.d m out, long j7, long j8) {
        kotlin.jvm.internal.l0.p(out, "out");
        j.e(B1(), j7, j8);
        if (j8 != 0) {
            out.s1(out.B1() + j8);
            j0 j0Var = this.f38494a;
            while (true) {
                kotlin.jvm.internal.l0.m(j0Var);
                int i7 = j0Var.f38470c;
                int i8 = j0Var.f38469b;
                if (j7 < i7 - i8) {
                    break;
                }
                j7 -= (long) (i7 - i8);
                j0Var = j0Var.f38473f;
            }
            while (j8 > 0) {
                kotlin.jvm.internal.l0.m(j0Var);
                j0 j0VarD = j0Var.d();
                int i9 = j0VarD.f38469b + ((int) j7);
                j0VarD.f38469b = i9;
                j0VarD.f38470c = Math.min(i9 + ((int) j8), j0VarD.f38470c);
                j0 j0Var2 = out.f38494a;
                if (j0Var2 == null) {
                    j0VarD.f38474g = j0VarD;
                    j0VarD.f38473f = j0VarD;
                    out.f38494a = j0VarD;
                } else {
                    kotlin.jvm.internal.l0.m(j0Var2);
                    j0 j0Var3 = j0Var2.f38474g;
                    kotlin.jvm.internal.l0.m(j0Var3);
                    j0Var3.c(j0VarD);
                }
                j8 -= (long) (j0VarD.f38470c - j0VarD.f38469b);
                j0Var = j0Var.f38473f;
                j7 = 0;
            }
        }
        return this;
    }

    @a7.d
    @h5.i
    public final a Q0() {
        return V0(this, null, 1, null);
    }

    @Override // okio.o
    public long Q1() throws EOFException {
        int i7;
        if (B1() == 0) {
            throw new EOFException();
        }
        int i8 = 0;
        boolean z7 = false;
        long j7 = 0;
        do {
            j0 j0Var = this.f38494a;
            kotlin.jvm.internal.l0.m(j0Var);
            byte[] bArr = j0Var.f38468a;
            int i9 = j0Var.f38469b;
            int i10 = j0Var.f38470c;
            while (i9 < i10) {
                byte b8 = bArr[i9];
                byte b9 = (byte) 48;
                if (b8 < b9 || b8 > ((byte) 57)) {
                    byte b10 = (byte) 97;
                    if ((b8 < b10 || b8 > ((byte) 102)) && (b8 < (b10 = (byte) 65) || b8 > ((byte) 70))) {
                        if (i8 != 0) {
                            z7 = true;
                            break;
                        }
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + j.m(b8));
                    }
                    i7 = (b8 - b10) + 10;
                } else {
                    i7 = b8 - b9;
                }
                if (((-1152921504606846976L) & j7) != 0) {
                    throw new NumberFormatException("Number too large: " + new m().D0(j7).writeByte(b8).m1());
                }
                j7 = (j7 << 4) | ((long) i7);
                i9++;
                i8++;
            }
            if (i9 == i10) {
                this.f38494a = j0Var.b();
                k0.d(j0Var);
            } else {
                j0Var.f38469b = i9;
            }
            if (z7) {
                break;
            }
        } while (this.f38494a != null);
        s1(B1() - ((long) i8));
        return j7;
    }

    @a7.d
    public final p R1(int i7) {
        if (i7 == 0) {
            return p.f38507e;
        }
        j.e(B1(), 0L, i7);
        j0 j0Var = this.f38494a;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i9 < i7) {
            kotlin.jvm.internal.l0.m(j0Var);
            int i11 = j0Var.f38470c;
            int i12 = j0Var.f38469b;
            if (i11 == i12) {
                throw new AssertionError("s.limit == s.pos");
            }
            i9 += i11 - i12;
            i10++;
            j0Var = j0Var.f38473f;
        }
        byte[][] bArr = new byte[i10][];
        int[] iArr = new int[i10 * 2];
        j0 j0Var2 = this.f38494a;
        int i13 = 0;
        while (i8 < i7) {
            kotlin.jvm.internal.l0.m(j0Var2);
            bArr[i13] = j0Var2.f38468a;
            i8 += j0Var2.f38470c - j0Var2.f38469b;
            iArr[i13] = Math.min(i8, i7);
            iArr[i13 + i10] = j0Var2.f38469b;
            j0Var2.f38471d = true;
            i13++;
            j0Var2 = j0Var2.f38473f;
        }
        return new l0(bArr, iArr);
    }

    @Override // okio.o
    @a7.d
    public InputStream S1() {
        return new b();
    }

    @a7.d
    @h5.i
    public final a T0(@a7.d a unsafeCursor) {
        kotlin.jvm.internal.l0.p(unsafeCursor, "unsafeCursor");
        if (!(unsafeCursor.f38496a == null)) {
            throw new IllegalStateException("already attached to a buffer".toString());
        }
        unsafeCursor.f38496a = this;
        unsafeCursor.f38497b = true;
        return unsafeCursor;
    }

    @Override // okio.o
    public long U(byte b8, long j7) {
        return Y(b8, j7, Long.MAX_VALUE);
    }

    @Override // okio.o
    public void V(@a7.d m sink, long j7) throws EOFException {
        kotlin.jvm.internal.l0.p(sink, "sink");
        if (B1() >= j7) {
            sink.write(this, j7);
        } else {
            sink.write(this, B1());
            throw new EOFException();
        }
    }

    @Override // okio.o
    public int V1(@a7.d d0 options) throws EOFException {
        kotlin.jvm.internal.l0.p(options, "options");
        int iE0 = v5.a.e0(this, options, false, 2, null);
        if (iE0 == -1) {
            return -1;
        }
        skip(options.f()[iE0].a0());
        return iE0;
    }

    @a7.d
    public final j0 W1(int i7) {
        if (!(i7 >= 1 && i7 <= 8192)) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        j0 j0Var = this.f38494a;
        if (j0Var != null) {
            kotlin.jvm.internal.l0.m(j0Var);
            j0 j0Var2 = j0Var.f38474g;
            kotlin.jvm.internal.l0.m(j0Var2);
            return (j0Var2.f38470c + i7 > 8192 || !j0Var2.f38472e) ? j0Var2.c(k0.e()) : j0Var2;
        }
        j0 j0VarE = k0.e();
        this.f38494a = j0VarE;
        j0VarE.f38474g = j0VarE;
        j0VarE.f38473f = j0VarE;
        return j0VarE;
    }

    @Override // okio.o
    @a7.d
    public String X0() throws EOFException {
        return e0(Long.MAX_VALUE);
    }

    @Override // okio.n
    @a7.d
    /* JADX INFO: renamed from: X1, reason: merged with bridge method [inline-methods] */
    public m p1(@a7.d p byteString) {
        kotlin.jvm.internal.l0.p(byteString, "byteString");
        byteString.n0(this, 0, byteString.a0());
        return this;
    }

    @Override // okio.o
    public long Y(byte b8, long j7, long j8) {
        j0 j0Var;
        int i7;
        long jB1 = 0;
        if (!(0 <= j7 && j8 >= j7)) {
            throw new IllegalArgumentException(("size=" + B1() + " fromIndex=" + j7 + " toIndex=" + j8).toString());
        }
        if (j8 > B1()) {
            j8 = B1();
        }
        if (j7 == j8 || (j0Var = this.f38494a) == null) {
            return -1L;
        }
        if (B1() - j7 < j7) {
            jB1 = B1();
            while (jB1 > j7) {
                j0Var = j0Var.f38474g;
                kotlin.jvm.internal.l0.m(j0Var);
                jB1 -= (long) (j0Var.f38470c - j0Var.f38469b);
            }
            while (jB1 < j8) {
                byte[] bArr = j0Var.f38468a;
                int iMin = (int) Math.min(j0Var.f38470c, (((long) j0Var.f38469b) + j8) - jB1);
                i7 = (int) ((((long) j0Var.f38469b) + j7) - jB1);
                while (i7 < iMin) {
                    if (bArr[i7] != b8) {
                        i7++;
                    }
                }
                jB1 += (long) (j0Var.f38470c - j0Var.f38469b);
                j0Var = j0Var.f38473f;
                kotlin.jvm.internal.l0.m(j0Var);
                j7 = jB1;
            }
            return -1L;
        }
        while (true) {
            long j9 = ((long) (j0Var.f38470c - j0Var.f38469b)) + jB1;
            if (j9 > j7) {
                break;
            }
            j0Var = j0Var.f38473f;
            kotlin.jvm.internal.l0.m(j0Var);
            jB1 = j9;
        }
        while (jB1 < j8) {
            byte[] bArr2 = j0Var.f38468a;
            int iMin2 = (int) Math.min(j0Var.f38470c, (((long) j0Var.f38469b) + j8) - jB1);
            i7 = (int) ((((long) j0Var.f38469b) + j7) - jB1);
            while (i7 < iMin2) {
                if (bArr2[i7] != b8) {
                    i7++;
                }
            }
            jB1 += (long) (j0Var.f38470c - j0Var.f38469b);
            j0Var = j0Var.f38473f;
            kotlin.jvm.internal.l0.m(j0Var);
            j7 = jB1;
        }
        return -1L;
        return ((long) (i7 - j0Var.f38469b)) + jB1;
    }

    @a7.d
    public final m Y0(@a7.d InputStream input) throws IOException {
        kotlin.jvm.internal.l0.p(input, "input");
        d1(input, Long.MAX_VALUE, true);
        return this;
    }

    @Override // okio.n
    @a7.d
    /* JADX INFO: renamed from: Y1, reason: merged with bridge method [inline-methods] */
    public m z(@a7.d p byteString, int i7, int i8) {
        kotlin.jvm.internal.l0.p(byteString, "byteString");
        byteString.n0(this, i7, i8);
        return this;
    }

    @Override // okio.o
    public long Z(@a7.d p targetBytes) {
        kotlin.jvm.internal.l0.p(targetBytes, "targetBytes");
        return F1(targetBytes, 0L);
    }

    @Override // okio.n
    @a7.d
    /* JADX INFO: renamed from: Z1, reason: merged with bridge method [inline-methods] */
    public m O0(@a7.d o0 source, long j7) throws IOException {
        kotlin.jvm.internal.l0.p(source, "source");
        while (j7 > 0) {
            long j8 = source.read(this, j7);
            if (j8 == -1) {
                throw new EOFException();
            }
            j7 -= j8;
        }
        return this;
    }

    @Override // okio.o
    @a7.e
    public String a0() throws EOFException {
        long jM1 = M1((byte) 10);
        if (jM1 != -1) {
            return v5.a.b0(this, jM1);
        }
        if (B1() != 0) {
            return h(B1());
        }
        return null;
    }

    @a7.d
    public final m a1(@a7.d InputStream input, long j7) throws IOException {
        kotlin.jvm.internal.l0.p(input, "input");
        if (j7 >= 0) {
            d1(input, j7, false);
            return this;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j7).toString());
    }

    @Override // okio.n
    @a7.d
    /* JADX INFO: renamed from: a2, reason: merged with bridge method [inline-methods] */
    public m write(@a7.d byte[] source) {
        kotlin.jvm.internal.l0.p(source, "source");
        return write(source, 0, source.length);
    }

    @Override // okio.o
    public int b1() throws EOFException {
        return j.h(readInt());
    }

    @Override // okio.n
    @a7.d
    /* JADX INFO: renamed from: b2, reason: merged with bridge method [inline-methods] */
    public m write(@a7.d byte[] source, int i7, int i8) {
        kotlin.jvm.internal.l0.p(source, "source");
        long j7 = i8;
        j.e(source.length, i7, j7);
        int i9 = i8 + i7;
        while (i7 < i9) {
            j0 j0VarW1 = W1(1);
            int iMin = Math.min(i9 - i7, 8192 - j0VarW1.f38470c);
            int i10 = i7 + iMin;
            kotlin.collections.o.W0(source, j0VarW1.f38468a, j0VarW1.f38470c, i7, i10);
            j0VarW1.f38470c += iMin;
            i7 = i10;
        }
        s1(B1() + j7);
        return this;
    }

    @kotlin.k(level = kotlin.m.ERROR, message = "moved to operator function", replaceWith = @b1(expression = "this[index]", imports = {}))
    @h5.h(name = "-deprecated_getByte")
    public final byte c(long j7) {
        return v0(j7);
    }

    @Override // okio.o
    public long c0() throws EOFException {
        if (B1() == 0) {
            throw new EOFException();
        }
        int i7 = 0;
        boolean z7 = false;
        long j7 = -7;
        long j8 = 0;
        boolean z8 = false;
        do {
            j0 j0Var = this.f38494a;
            kotlin.jvm.internal.l0.m(j0Var);
            byte[] bArr = j0Var.f38468a;
            int i8 = j0Var.f38469b;
            int i9 = j0Var.f38470c;
            while (i8 < i9) {
                byte b8 = bArr[i8];
                byte b9 = (byte) 48;
                if (b8 >= b9 && b8 <= ((byte) 57)) {
                    int i10 = b9 - b8;
                    if (j8 < v5.a.f40434c || (j8 == v5.a.f40434c && i10 < j7)) {
                        m mVarWriteByte = new m().H1(j8).writeByte(b8);
                        if (!z7) {
                            mVarWriteByte.readByte();
                        }
                        throw new NumberFormatException("Number too large: " + mVarWriteByte.m1());
                    }
                    j8 = (j8 * 10) + ((long) i10);
                } else {
                    if (b8 != ((byte) 45) || i7 != 0) {
                        if (i7 != 0) {
                            z8 = true;
                            break;
                        }
                        throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + j.m(b8));
                    }
                    j7--;
                    z7 = true;
                }
                i8++;
                i7++;
            }
            if (i8 == i9) {
                this.f38494a = j0Var.b();
                k0.d(j0Var);
            } else {
                j0Var.f38469b = i8;
            }
            if (z8) {
                break;
            }
        } while (this.f38494a != null);
        s1(B1() - ((long) i7));
        return z7 ? j8 : -j8;
    }

    @Override // okio.o
    public boolean c1(long j7, @a7.d p bytes, int i7, int i8) {
        kotlin.jvm.internal.l0.p(bytes, "bytes");
        if (j7 < 0 || i7 < 0 || i8 < 0 || B1() - j7 < i8 || bytes.a0() - i7 < i8) {
            return false;
        }
        for (int i9 = 0; i9 < i8; i9++) {
            if (v0(((long) i9) + j7) != bytes.n(i7 + i9)) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.n
    @a7.d
    /* JADX INFO: renamed from: c2, reason: merged with bridge method [inline-methods] */
    public m writeByte(int i7) {
        j0 j0VarW1 = W1(1);
        byte[] bArr = j0VarW1.f38468a;
        int i8 = j0VarW1.f38470c;
        j0VarW1.f38470c = i8 + 1;
        bArr[i8] = (byte) i7;
        s1(B1() + 1);
        return this;
    }

    @Override // okio.o0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // okio.n
    @a7.d
    /* JADX INFO: renamed from: d2, reason: merged with bridge method [inline-methods] */
    public m H1(long j7) {
        boolean z7;
        if (j7 == 0) {
            return writeByte(48);
        }
        int i7 = 1;
        if (j7 < 0) {
            j7 = -j7;
            if (j7 < 0) {
                return q0("-9223372036854775808");
            }
            z7 = true;
        } else {
            z7 = false;
        }
        if (j7 < 100000000) {
            if (j7 < RtkCoreMeshWrapper.RTK_PROV_CONNECT_TIMEOUT) {
                if (j7 >= 100) {
                    i7 = j7 < 1000 ? 3 : 4;
                } else if (j7 >= 10) {
                    i7 = 2;
                }
            } else if (j7 < 1000000) {
                i7 = j7 < 100000 ? 5 : 6;
            } else {
                i7 = j7 < 10000000 ? 7 : 8;
            }
        } else if (j7 < 1000000000000L) {
            if (j7 < okhttp3.internal.connection.f.f37803v) {
                i7 = j7 < 1000000000 ? 9 : 10;
            } else {
                i7 = j7 < 100000000000L ? 11 : 12;
            }
        } else if (j7 < 1000000000000000L) {
            if (j7 < 10000000000000L) {
                i7 = 13;
            } else {
                i7 = j7 < 100000000000000L ? 14 : 15;
            }
        } else if (j7 < 100000000000000000L) {
            i7 = j7 < 10000000000000000L ? 16 : 17;
        } else {
            i7 = j7 < 1000000000000000000L ? 18 : 19;
        }
        if (z7) {
            i7++;
        }
        j0 j0VarW1 = W1(i7);
        byte[] bArr = j0VarW1.f38468a;
        int i8 = j0VarW1.f38470c + i7;
        while (j7 != 0) {
            long j8 = 10;
            i8--;
            bArr[i8] = v5.a.Z()[(int) (j7 % j8)];
            j7 /= j8;
        }
        if (z7) {
            bArr[i8 - 1] = (byte) 45;
        }
        j0VarW1.f38470c += i7;
        s1(B1() + ((long) i7));
        return this;
    }

    @kotlin.k(level = kotlin.m.ERROR, message = "moved to val", replaceWith = @b1(expression = "size", imports = {}))
    @h5.h(name = "-deprecated_size")
    public final long e() {
        return this.f38495b;
    }

    @Override // okio.o
    @a7.d
    public String e0(long j7) throws EOFException {
        if (!(j7 >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j7).toString());
        }
        long j8 = j7 != Long.MAX_VALUE ? j7 + 1 : Long.MAX_VALUE;
        byte b8 = (byte) 10;
        long jY = Y(b8, 0L, j8);
        if (jY != -1) {
            return v5.a.b0(this, jY);
        }
        if (j8 < B1() && v0(j8 - 1) == ((byte) 13) && v0(j8) == b8) {
            return v5.a.b0(this, j8);
        }
        m mVar = new m();
        Q(mVar, 0L, Math.min(32, B1()));
        throw new EOFException("\\n not found: limit=" + Math.min(B1(), j7) + " content=" + mVar.E0().t() + kotlin.text.h0.F);
    }

    @a7.d
    @h5.i
    public final a e1() {
        return q1(this, null, 1, null);
    }

    @Override // okio.n
    @a7.d
    /* JADX INFO: renamed from: e2, reason: merged with bridge method [inline-methods] */
    public m D0(long j7) {
        if (j7 == 0) {
            return writeByte(48);
        }
        long j8 = (j7 >>> 1) | j7;
        long j9 = j8 | (j8 >>> 2);
        long j10 = j9 | (j9 >>> 4);
        long j11 = j10 | (j10 >>> 8);
        long j12 = j11 | (j11 >>> 16);
        long j13 = j12 | (j12 >>> 32);
        long j14 = j13 - ((j13 >>> 1) & 6148914691236517205L);
        long j15 = ((j14 >>> 2) & 3689348814741910323L) + (j14 & 3689348814741910323L);
        long j16 = ((j15 >>> 4) + j15) & 1085102592571150095L;
        long j17 = j16 + (j16 >>> 8);
        long j18 = j17 + (j17 >>> 16);
        int i7 = (int) ((((j18 & 63) + ((j18 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        j0 j0VarW1 = W1(i7);
        byte[] bArr = j0VarW1.f38468a;
        int i8 = j0VarW1.f38470c;
        for (int i9 = (i8 + i7) - 1; i9 >= i8; i9--) {
            bArr[i9] = v5.a.Z()[(int) (15 & j7)];
            j7 >>>= 4;
        }
        j0VarW1.f38470c += i7;
        s1(B1() + ((long) i7));
        return this;
    }

    public boolean equals(@a7.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (B1() == mVar.B1()) {
                if (B1() == 0) {
                    return true;
                }
                j0 j0Var = this.f38494a;
                kotlin.jvm.internal.l0.m(j0Var);
                j0 j0Var2 = mVar.f38494a;
                kotlin.jvm.internal.l0.m(j0Var2);
                int i7 = j0Var.f38469b;
                int i8 = j0Var2.f38469b;
                long j7 = 0;
                while (j7 < B1()) {
                    long jMin = Math.min(j0Var.f38470c - i7, j0Var2.f38470c - i8);
                    long j8 = 0;
                    while (j8 < jMin) {
                        int i9 = i7 + 1;
                        int i10 = i8 + 1;
                        if (j0Var.f38468a[i7] == j0Var2.f38468a[i8]) {
                            j8++;
                            i7 = i9;
                            i8 = i10;
                        }
                    }
                    if (i7 == j0Var.f38470c) {
                        j0Var = j0Var.f38473f;
                        kotlin.jvm.internal.l0.m(j0Var);
                        i7 = j0Var.f38469b;
                    }
                    if (i8 == j0Var2.f38470c) {
                        j0Var2 = j0Var2.f38473f;
                        kotlin.jvm.internal.l0.m(j0Var2);
                        i8 = j0Var2.f38469b;
                    }
                    j7 += jMin;
                }
                return true;
            }
        }
        return false;
    }

    @Override // okio.n
    @a7.d
    /* JADX INFO: renamed from: f2, reason: merged with bridge method [inline-methods] */
    public m writeInt(int i7) {
        j0 j0VarW1 = W1(4);
        byte[] bArr = j0VarW1.f38468a;
        int i8 = j0VarW1.f38470c;
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((i7 >>> 24) & 255);
        int i10 = i9 + 1;
        bArr[i9] = (byte) ((i7 >>> 16) & 255);
        int i11 = i10 + 1;
        bArr[i10] = (byte) ((i7 >>> 8) & 255);
        bArr[i11] = (byte) (i7 & 255);
        j0VarW1.f38470c = i11 + 1;
        s1(B1() + 4);
        return this;
    }

    @Override // okio.n, okio.m0, java.io.Flushable
    public void flush() {
    }

    @Override // okio.n
    @a7.d
    /* JADX INFO: renamed from: g2, reason: merged with bridge method [inline-methods] */
    public m L(int i7) {
        return writeInt(j.h(i7));
    }

    @Override // okio.o
    @a7.d
    public String h(long j7) throws EOFException {
        return o1(j7, kotlin.text.f.f35353b);
    }

    @Override // okio.o
    @a7.d
    public byte[] h1(long j7) throws EOFException {
        if (!(j7 >= 0 && j7 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j7).toString());
        }
        if (B1() < j7) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j7];
        readFully(bArr);
        return bArr;
    }

    @Override // okio.n
    @a7.d
    /* JADX INFO: renamed from: h2, reason: merged with bridge method [inline-methods] */
    public m writeLong(long j7) {
        j0 j0VarW1 = W1(8);
        byte[] bArr = j0VarW1.f38468a;
        int i7 = j0VarW1.f38470c;
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j7 >>> 56) & 255);
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((j7 >>> 48) & 255);
        int i10 = i9 + 1;
        bArr[i9] = (byte) ((j7 >>> 40) & 255);
        int i11 = i10 + 1;
        bArr[i10] = (byte) ((j7 >>> 32) & 255);
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((j7 >>> 24) & 255);
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((j7 >>> 16) & 255);
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((j7 >>> 8) & 255);
        bArr[i14] = (byte) (j7 & 255);
        j0VarW1.f38470c = i14 + 1;
        s1(B1() + 8);
        return this;
    }

    public int hashCode() {
        j0 j0Var = this.f38494a;
        if (j0Var == null) {
            return 0;
        }
        int i7 = 1;
        do {
            int i8 = j0Var.f38470c;
            for (int i9 = j0Var.f38469b; i9 < i8; i9++) {
                i7 = (i7 * 31) + j0Var.f38468a[i9];
            }
            j0Var = j0Var.f38473f;
            kotlin.jvm.internal.l0.m(j0Var);
        } while (j0Var != this.f38494a);
        return i7;
    }

    @a7.d
    @h5.i
    public final a i1(@a7.d a unsafeCursor) {
        kotlin.jvm.internal.l0.p(unsafeCursor, "unsafeCursor");
        if (!(unsafeCursor.f38496a == null)) {
            throw new IllegalStateException("already attached to a buffer".toString());
        }
        unsafeCursor.f38496a = this;
        unsafeCursor.f38497b = false;
        return unsafeCursor;
    }

    @Override // okio.n
    @a7.d
    /* JADX INFO: renamed from: i2, reason: merged with bridge method [inline-methods] */
    public m D(long j7) {
        return writeLong(j.i(j7));
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // okio.n
    @a7.d
    /* JADX INFO: renamed from: j2, reason: merged with bridge method [inline-methods] */
    public m writeShort(int i7) {
        j0 j0VarW1 = W1(2);
        byte[] bArr = j0VarW1.f38468a;
        int i8 = j0VarW1.f38470c;
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((i7 >>> 8) & 255);
        bArr[i9] = (byte) (i7 & 255);
        j0VarW1.f38470c = i9 + 1;
        s1(B1() + 2);
        return this;
    }

    @Override // okio.o
    public long k(@a7.d p bytes, long j7) throws IOException {
        long j8 = j7;
        kotlin.jvm.internal.l0.p(bytes, "bytes");
        if (!(bytes.a0() > 0)) {
            throw new IllegalArgumentException("bytes is empty".toString());
        }
        long j9 = 0;
        if (!(j8 >= 0)) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j8).toString());
        }
        j0 j0Var = this.f38494a;
        if (j0Var != null) {
            if (B1() - j8 < j8) {
                long jB1 = B1();
                while (jB1 > j8) {
                    j0Var = j0Var.f38474g;
                    kotlin.jvm.internal.l0.m(j0Var);
                    jB1 -= (long) (j0Var.f38470c - j0Var.f38469b);
                }
                byte[] bArrE = bytes.E();
                byte b8 = bArrE[0];
                int iA0 = bytes.a0();
                long jB2 = (B1() - ((long) iA0)) + 1;
                while (jB1 < jB2) {
                    byte[] bArr = j0Var.f38468a;
                    long j10 = jB1;
                    int iMin = (int) Math.min(j0Var.f38470c, (((long) j0Var.f38469b) + jB2) - jB1);
                    for (int i7 = (int) ((((long) j0Var.f38469b) + j8) - j10); i7 < iMin; i7++) {
                        if (bArr[i7] == b8 && v5.a.a0(j0Var, i7 + 1, bArrE, 1, iA0)) {
                            return ((long) (i7 - j0Var.f38469b)) + j10;
                        }
                    }
                    jB1 = j10 + ((long) (j0Var.f38470c - j0Var.f38469b));
                    j0Var = j0Var.f38473f;
                    kotlin.jvm.internal.l0.m(j0Var);
                    j8 = jB1;
                }
            } else {
                while (true) {
                    long j11 = ((long) (j0Var.f38470c - j0Var.f38469b)) + j9;
                    if (j11 > j8) {
                        break;
                    }
                    j0Var = j0Var.f38473f;
                    kotlin.jvm.internal.l0.m(j0Var);
                    j9 = j11;
                }
                byte[] bArrE2 = bytes.E();
                byte b9 = bArrE2[0];
                int iA1 = bytes.a0();
                long jB3 = (B1() - ((long) iA1)) + 1;
                while (j9 < jB3) {
                    byte[] bArr2 = j0Var.f38468a;
                    long j12 = jB3;
                    int iMin2 = (int) Math.min(j0Var.f38470c, (((long) j0Var.f38469b) + jB3) - j9);
                    for (int i8 = (int) ((((long) j0Var.f38469b) + j8) - j9); i8 < iMin2; i8++) {
                        if (bArr2[i8] == b9 && v5.a.a0(j0Var, i8 + 1, bArrE2, 1, iA1)) {
                            return ((long) (i8 - j0Var.f38469b)) + j9;
                        }
                    }
                    j9 += (long) (j0Var.f38470c - j0Var.f38469b);
                    j0Var = j0Var.f38473f;
                    kotlin.jvm.internal.l0.m(j0Var);
                    j8 = j9;
                    jB3 = j12;
                }
            }
        }
        return -1L;
    }

    @Override // okio.n
    @a7.d
    /* JADX INFO: renamed from: k2, reason: merged with bridge method [inline-methods] */
    public m m0(int i7) {
        return writeShort(j.j((short) i7));
    }

    @Override // okio.o
    @a7.d
    public p l(long j7) throws EOFException {
        if (!(j7 >= 0 && j7 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j7).toString());
        }
        if (B1() < j7) {
            throw new EOFException();
        }
        if (j7 < 4096) {
            return new p(h1(j7));
        }
        p pVarR1 = R1((int) j7);
        skip(j7);
        return pVarR1;
    }

    @Override // okio.n
    @a7.d
    /* JADX INFO: renamed from: l2, reason: merged with bridge method [inline-methods] */
    public m D1(@a7.d String string, int i7, int i8, @a7.d Charset charset) {
        kotlin.jvm.internal.l0.p(string, "string");
        kotlin.jvm.internal.l0.p(charset, "charset");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i7).toString());
        }
        if (!(i8 >= i7)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i8 + " < " + i7).toString());
        }
        if (!(i8 <= string.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i8 + " > " + string.length()).toString());
        }
        if (kotlin.jvm.internal.l0.g(charset, kotlin.text.f.f35353b)) {
            return B0(string, i7, i8);
        }
        String strSubstring = string.substring(i7, i8);
        kotlin.jvm.internal.l0.o(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (strSubstring == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = strSubstring.getBytes(charset);
        kotlin.jvm.internal.l0.o(bytes, "(this as java.lang.String).getBytes(charset)");
        return write(bytes, 0, bytes.length);
    }

    @Override // okio.o
    @a7.d
    public String m1() {
        return o1(this.f38495b, kotlin.text.f.f35353b);
    }

    @Override // okio.n
    @a7.d
    /* JADX INFO: renamed from: m2, reason: merged with bridge method [inline-methods] */
    public m F0(@a7.d String string, @a7.d Charset charset) {
        kotlin.jvm.internal.l0.p(string, "string");
        kotlin.jvm.internal.l0.p(charset, "charset");
        return D1(string, 0, string.length(), charset);
    }

    @a7.d
    @h5.i
    public final m n2(@a7.d OutputStream outputStream) throws IOException {
        return p2(this, outputStream, 0L, 2, null);
    }

    @Override // okio.o
    @a7.d
    public m o() {
        return this;
    }

    @Override // okio.o
    @a7.d
    public String o1(long j7, @a7.d Charset charset) throws EOFException {
        kotlin.jvm.internal.l0.p(charset, "charset");
        if (!(j7 >= 0 && j7 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j7).toString());
        }
        if (this.f38495b < j7) {
            throw new EOFException();
        }
        if (j7 == 0) {
            return "";
        }
        j0 j0Var = this.f38494a;
        kotlin.jvm.internal.l0.m(j0Var);
        int i7 = j0Var.f38469b;
        if (((long) i7) + j7 > j0Var.f38470c) {
            return new String(h1(j7), charset);
        }
        int i8 = (int) j7;
        String str = new String(j0Var.f38468a, i7, i8, charset);
        int i9 = j0Var.f38469b + i8;
        j0Var.f38469b = i9;
        this.f38495b -= j7;
        if (i9 == j0Var.f38470c) {
            this.f38494a = j0Var.b();
            k0.d(j0Var);
        }
        return str;
    }

    @a7.d
    @h5.i
    public final m o2(@a7.d OutputStream out, long j7) throws IOException {
        kotlin.jvm.internal.l0.p(out, "out");
        j.e(this.f38495b, 0L, j7);
        j0 j0Var = this.f38494a;
        while (j7 > 0) {
            kotlin.jvm.internal.l0.m(j0Var);
            int iMin = (int) Math.min(j7, j0Var.f38470c - j0Var.f38469b);
            out.write(j0Var.f38468a, j0Var.f38469b, iMin);
            int i7 = j0Var.f38469b + iMin;
            j0Var.f38469b = i7;
            long j8 = iMin;
            this.f38495b -= j8;
            j7 -= j8;
            if (i7 == j0Var.f38470c) {
                j0 j0VarB = j0Var.b();
                this.f38494a = j0VarB;
                k0.d(j0Var);
                j0Var = j0VarB;
            }
        }
        return this;
    }

    @Override // okio.o
    @a7.d
    public m p() {
        return this;
    }

    @Override // okio.o
    @a7.d
    public o peek() {
        return a0.d(new f0(this));
    }

    public final void q() throws EOFException {
        skip(B1());
    }

    @Override // okio.n
    @a7.d
    /* JADX INFO: renamed from: q2, reason: merged with bridge method [inline-methods] */
    public m q0(@a7.d String string) {
        kotlin.jvm.internal.l0.p(string, "string");
        return B0(string, 0, string.length());
    }

    @a7.d
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public m clone() {
        return C();
    }

    @Override // okio.n
    @a7.d
    /* JADX INFO: renamed from: r0, reason: merged with bridge method [inline-methods] */
    public m w() {
        return this;
    }

    @Override // okio.o
    public short r1() throws EOFException {
        return j.j(readShort());
    }

    @Override // okio.n
    @a7.d
    /* JADX INFO: renamed from: r2, reason: merged with bridge method [inline-methods] */
    public m B0(@a7.d String string, int i7, int i8) {
        kotlin.jvm.internal.l0.p(string, "string");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i7).toString());
        }
        if (!(i8 >= i7)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i8 + " < " + i7).toString());
        }
        if (!(i8 <= string.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i8 + " > " + string.length()).toString());
        }
        while (i7 < i8) {
            char cCharAt = string.charAt(i7);
            if (cCharAt < 128) {
                j0 j0VarW1 = W1(1);
                byte[] bArr = j0VarW1.f38468a;
                int i9 = j0VarW1.f38470c - i7;
                int iMin = Math.min(i8, 8192 - i9);
                int i10 = i7 + 1;
                bArr[i7 + i9] = (byte) cCharAt;
                while (i10 < iMin) {
                    char cCharAt2 = string.charAt(i10);
                    if (cCharAt2 >= 128) {
                        break;
                    }
                    bArr[i10 + i9] = (byte) cCharAt2;
                    i10++;
                }
                int i11 = j0VarW1.f38470c;
                int i12 = (i9 + i10) - i11;
                j0VarW1.f38470c = i11 + i12;
                s1(B1() + ((long) i12));
                i7 = i10;
            } else {
                if (cCharAt < 2048) {
                    j0 j0VarW2 = W1(2);
                    byte[] bArr2 = j0VarW2.f38468a;
                    int i13 = j0VarW2.f38470c;
                    bArr2[i13] = (byte) ((cCharAt >> 6) | com.alibaba.fastjson.asm.j.f12606c0);
                    bArr2[i13 + 1] = (byte) ((cCharAt & '?') | 128);
                    j0VarW2.f38470c = i13 + 2;
                    s1(B1() + 2);
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    j0 j0VarW3 = W1(3);
                    byte[] bArr3 = j0VarW3.f38468a;
                    int i14 = j0VarW3.f38470c;
                    bArr3[i14] = (byte) ((cCharAt >> '\f') | 224);
                    bArr3[i14 + 1] = (byte) ((63 & (cCharAt >> 6)) | 128);
                    bArr3[i14 + 2] = (byte) ((cCharAt & '?') | 128);
                    j0VarW3.f38470c = i14 + 3;
                    s1(B1() + 3);
                } else {
                    int i15 = i7 + 1;
                    char cCharAt3 = i15 < i8 ? string.charAt(i15) : (char) 0;
                    if (cCharAt > 56319 || 56320 > cCharAt3 || 57343 < cCharAt3) {
                        writeByte(63);
                        i7 = i15;
                    } else {
                        int i16 = (((cCharAt & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        j0 j0VarW4 = W1(4);
                        byte[] bArr4 = j0VarW4.f38468a;
                        int i17 = j0VarW4.f38470c;
                        bArr4[i17] = (byte) ((i16 >> 18) | 240);
                        bArr4[i17 + 1] = (byte) (((i16 >> 12) & 63) | 128);
                        bArr4[i17 + 2] = (byte) (((i16 >> 6) & 63) | 128);
                        bArr4[i17 + 3] = (byte) ((i16 & 63) | 128);
                        j0VarW4.f38470c = i17 + 4;
                        s1(B1() + 4);
                        i7 += 2;
                    }
                }
                i7++;
            }
        }
        return this;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(@a7.d ByteBuffer sink) throws IOException {
        kotlin.jvm.internal.l0.p(sink, "sink");
        j0 j0Var = this.f38494a;
        if (j0Var == null) {
            return -1;
        }
        int iMin = Math.min(sink.remaining(), j0Var.f38470c - j0Var.f38469b);
        sink.put(j0Var.f38468a, j0Var.f38469b, iMin);
        int i7 = j0Var.f38469b + iMin;
        j0Var.f38469b = i7;
        this.f38495b -= (long) iMin;
        if (i7 == j0Var.f38470c) {
            this.f38494a = j0Var.b();
            k0.d(j0Var);
        }
        return iMin;
    }

    @Override // okio.o
    public byte readByte() throws EOFException {
        if (B1() == 0) {
            throw new EOFException();
        }
        j0 j0Var = this.f38494a;
        kotlin.jvm.internal.l0.m(j0Var);
        int i7 = j0Var.f38469b;
        int i8 = j0Var.f38470c;
        int i9 = i7 + 1;
        byte b8 = j0Var.f38468a[i7];
        s1(B1() - 1);
        if (i9 == i8) {
            this.f38494a = j0Var.b();
            k0.d(j0Var);
        } else {
            j0Var.f38469b = i9;
        }
        return b8;
    }

    @Override // okio.o
    public void readFully(@a7.d byte[] sink) throws EOFException {
        kotlin.jvm.internal.l0.p(sink, "sink");
        int i7 = 0;
        while (i7 < sink.length) {
            int i8 = read(sink, i7, sink.length - i7);
            if (i8 == -1) {
                throw new EOFException();
            }
            i7 += i8;
        }
    }

    @Override // okio.o
    public int readInt() throws EOFException {
        if (B1() < 4) {
            throw new EOFException();
        }
        j0 j0Var = this.f38494a;
        kotlin.jvm.internal.l0.m(j0Var);
        int i7 = j0Var.f38469b;
        int i8 = j0Var.f38470c;
        if (i8 - i7 < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = j0Var.f38468a;
        int i9 = i7 + 1;
        int i10 = i9 + 1;
        int i11 = ((bArr[i7] & 255) << 24) | ((bArr[i9] & 255) << 16);
        int i12 = i10 + 1;
        int i13 = i11 | ((bArr[i10] & 255) << 8);
        int i14 = i12 + 1;
        int i15 = i13 | (bArr[i12] & 255);
        s1(B1() - 4);
        if (i14 == i8) {
            this.f38494a = j0Var.b();
            k0.d(j0Var);
        } else {
            j0Var.f38469b = i14;
        }
        return i15;
    }

    @Override // okio.o
    public long readLong() throws EOFException {
        if (B1() < 8) {
            throw new EOFException();
        }
        j0 j0Var = this.f38494a;
        kotlin.jvm.internal.l0.m(j0Var);
        int i7 = j0Var.f38469b;
        int i8 = j0Var.f38470c;
        if (i8 - i7 < 8) {
            return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
        }
        byte[] bArr = j0Var.f38468a;
        int i9 = i7 + 1;
        long j7 = (((long) bArr[i7]) & 255) << 56;
        int i10 = i9 + 1;
        int i11 = i10 + 1;
        long j8 = j7 | ((((long) bArr[i9]) & 255) << 48) | ((((long) bArr[i10]) & 255) << 40);
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        long j9 = j8 | ((((long) bArr[i11]) & 255) << 32) | ((((long) bArr[i12]) & 255) << 24);
        int i14 = i13 + 1;
        long j10 = j9 | ((((long) bArr[i13]) & 255) << 16);
        int i15 = i14 + 1;
        long j11 = j10 | ((((long) bArr[i14]) & 255) << 8);
        int i16 = i15 + 1;
        long j12 = j11 | (((long) bArr[i15]) & 255);
        s1(B1() - 8);
        if (i16 == i8) {
            this.f38494a = j0Var.b();
            k0.d(j0Var);
        } else {
            j0Var.f38469b = i16;
        }
        return j12;
    }

    @Override // okio.o
    public short readShort() throws EOFException {
        if (B1() < 2) {
            throw new EOFException();
        }
        j0 j0Var = this.f38494a;
        kotlin.jvm.internal.l0.m(j0Var);
        int i7 = j0Var.f38469b;
        int i8 = j0Var.f38470c;
        if (i8 - i7 < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = j0Var.f38468a;
        int i9 = i7 + 1;
        int i10 = i9 + 1;
        int i11 = ((bArr[i7] & 255) << 8) | (bArr[i9] & 255);
        s1(B1() - 2);
        if (i10 == i8) {
            this.f38494a = j0Var.b();
            k0.d(j0Var);
        } else {
            j0Var.f38469b = i10;
        }
        return (short) i11;
    }

    @Override // okio.n
    @a7.d
    /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
    public m b0() {
        return this;
    }

    public final void s1(long j7) {
        this.f38495b = j7;
    }

    @Override // okio.n
    @a7.d
    /* JADX INFO: renamed from: s2, reason: merged with bridge method [inline-methods] */
    public m x(int i7) {
        if (i7 < 128) {
            writeByte(i7);
        } else if (i7 < 2048) {
            j0 j0VarW1 = W1(2);
            byte[] bArr = j0VarW1.f38468a;
            int i8 = j0VarW1.f38470c;
            bArr[i8] = (byte) ((i7 >> 6) | com.alibaba.fastjson.asm.j.f12606c0);
            bArr[i8 + 1] = (byte) ((i7 & 63) | 128);
            j0VarW1.f38470c = i8 + 2;
            s1(B1() + 2);
        } else if (55296 <= i7 && 57343 >= i7) {
            writeByte(63);
        } else if (i7 < 65536) {
            j0 j0VarW2 = W1(3);
            byte[] bArr2 = j0VarW2.f38468a;
            int i9 = j0VarW2.f38470c;
            bArr2[i9] = (byte) ((i7 >> 12) | 224);
            bArr2[i9 + 1] = (byte) (((i7 >> 6) & 63) | 128);
            bArr2[i9 + 2] = (byte) ((i7 & 63) | 128);
            j0VarW2.f38470c = i9 + 3;
            s1(B1() + 3);
        } else {
            if (i7 > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: 0x" + j.n(i7));
            }
            j0 j0VarW3 = W1(4);
            byte[] bArr3 = j0VarW3.f38468a;
            int i10 = j0VarW3.f38470c;
            bArr3[i10] = (byte) ((i7 >> 18) | 240);
            bArr3[i10 + 1] = (byte) (((i7 >> 12) & 63) | 128);
            bArr3[i10 + 2] = (byte) (((i7 >> 6) & 63) | 128);
            bArr3[i10 + 3] = (byte) ((i7 & 63) | 128);
            j0VarW3.f38470c = i10 + 4;
            s1(B1() + 4);
        }
        return this;
    }

    @Override // okio.o
    public void skip(long j7) throws EOFException {
        while (j7 > 0) {
            j0 j0Var = this.f38494a;
            if (j0Var == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j7, j0Var.f38470c - j0Var.f38469b);
            long j8 = iMin;
            s1(B1() - j8);
            j7 -= j8;
            int i7 = j0Var.f38469b + iMin;
            j0Var.f38469b = i7;
            if (i7 == j0Var.f38470c) {
                this.f38494a = j0Var.b();
                k0.d(j0Var);
            }
        }
    }

    @Override // okio.o
    public boolean t0(long j7, @a7.d p bytes) {
        kotlin.jvm.internal.l0.p(bytes, "bytes");
        return c1(j7, bytes, 0, bytes.a0());
    }

    @Override // okio.o0
    @a7.d
    public q0 timeout() {
        return q0.f38523d;
    }

    @a7.d
    public String toString() {
        return N1().toString();
    }

    public final long u() {
        long jB1 = B1();
        if (jB1 == 0) {
            return 0L;
        }
        j0 j0Var = this.f38494a;
        kotlin.jvm.internal.l0.m(j0Var);
        j0 j0Var2 = j0Var.f38474g;
        kotlin.jvm.internal.l0.m(j0Var2);
        int i7 = j0Var2.f38470c;
        if (i7 < 8192 && j0Var2.f38472e) {
            jB1 -= (long) (i7 - j0Var2.f38469b);
        }
        return jB1;
    }

    @Override // okio.o
    @a7.d
    public String u0(@a7.d Charset charset) {
        kotlin.jvm.internal.l0.p(charset, "charset");
        return o1(this.f38495b, charset);
    }

    @h5.h(name = "getByte")
    public final byte v0(long j7) {
        j.e(B1(), j7, 1L);
        j0 j0Var = this.f38494a;
        if (j0Var == null) {
            kotlin.jvm.internal.l0.m(null);
            throw null;
        }
        if (B1() - j7 < j7) {
            long jB1 = B1();
            while (jB1 > j7) {
                j0Var = j0Var.f38474g;
                kotlin.jvm.internal.l0.m(j0Var);
                jB1 -= (long) (j0Var.f38470c - j0Var.f38469b);
            }
            kotlin.jvm.internal.l0.m(j0Var);
            return j0Var.f38468a[(int) ((((long) j0Var.f38469b) + j7) - jB1)];
        }
        long j8 = 0;
        while (true) {
            long j9 = ((long) (j0Var.f38470c - j0Var.f38469b)) + j8;
            if (j9 > j7) {
                kotlin.jvm.internal.l0.m(j0Var);
                return j0Var.f38468a[(int) ((((long) j0Var.f38469b) + j7) - j8)];
            }
            j0Var = j0Var.f38473f;
            kotlin.jvm.internal.l0.m(j0Var);
            j8 = j9;
        }
    }

    @Override // okio.o
    public long v1() throws EOFException {
        return j.i(readLong());
    }

    @a7.d
    public final p w1() {
        return o0("SHA-1");
    }

    @Override // okio.o
    public long x1(@a7.d m0 sink) throws IOException {
        kotlin.jvm.internal.l0.p(sink, "sink");
        long jB1 = B1();
        if (jB1 > 0) {
            sink.write(this, jB1);
        }
        return jB1;
    }

    @a7.d
    public final p z1() {
        return o0("SHA-256");
    }

    public static final class b extends InputStream {
        b() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(m.this.B1(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            if (m.this.B1() > 0) {
                return m.this.readByte() & 255;
            }
            return -1;
        }

        @a7.d
        public String toString() {
            return m.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(@a7.d byte[] sink, int i7, int i8) {
            kotlin.jvm.internal.l0.p(sink, "sink");
            return m.this.read(sink, i7, i8);
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(@a7.d ByteBuffer source) throws IOException {
        kotlin.jvm.internal.l0.p(source, "source");
        int iRemaining = source.remaining();
        int i7 = iRemaining;
        while (i7 > 0) {
            j0 j0VarW1 = W1(1);
            int iMin = Math.min(i7, 8192 - j0VarW1.f38470c);
            source.get(j0VarW1.f38468a, j0VarW1.f38470c, iMin);
            i7 -= iMin;
            j0VarW1.f38470c += iMin;
        }
        this.f38495b += (long) iRemaining;
        return iRemaining;
    }

    @Override // okio.o
    public int read(@a7.d byte[] sink) {
        kotlin.jvm.internal.l0.p(sink, "sink");
        return read(sink, 0, sink.length);
    }

    @Override // okio.m0
    public void write(@a7.d m source, long j7) {
        j0 j0Var;
        kotlin.jvm.internal.l0.p(source, "source");
        if (source != this) {
            j.e(source.B1(), 0L, j7);
            while (j7 > 0) {
                j0 j0Var2 = source.f38494a;
                kotlin.jvm.internal.l0.m(j0Var2);
                int i7 = j0Var2.f38470c;
                j0 j0Var3 = source.f38494a;
                kotlin.jvm.internal.l0.m(j0Var3);
                if (j7 < i7 - j0Var3.f38469b) {
                    j0 j0Var4 = this.f38494a;
                    if (j0Var4 != null) {
                        kotlin.jvm.internal.l0.m(j0Var4);
                        j0Var = j0Var4.f38474g;
                    } else {
                        j0Var = null;
                    }
                    if (j0Var != null && j0Var.f38472e) {
                        if ((((long) j0Var.f38470c) + j7) - ((long) (j0Var.f38471d ? 0 : j0Var.f38469b)) <= 8192) {
                            j0 j0Var5 = source.f38494a;
                            kotlin.jvm.internal.l0.m(j0Var5);
                            j0Var5.g(j0Var, (int) j7);
                            source.s1(source.B1() - j7);
                            s1(B1() + j7);
                            return;
                        }
                    }
                    j0 j0Var6 = source.f38494a;
                    kotlin.jvm.internal.l0.m(j0Var6);
                    source.f38494a = j0Var6.e((int) j7);
                }
                j0 j0Var7 = source.f38494a;
                kotlin.jvm.internal.l0.m(j0Var7);
                long j8 = j0Var7.f38470c - j0Var7.f38469b;
                source.f38494a = j0Var7.b();
                j0 j0Var8 = this.f38494a;
                if (j0Var8 == null) {
                    this.f38494a = j0Var7;
                    j0Var7.f38474g = j0Var7;
                    j0Var7.f38473f = j0Var7;
                } else {
                    kotlin.jvm.internal.l0.m(j0Var8);
                    j0 j0Var9 = j0Var8.f38474g;
                    kotlin.jvm.internal.l0.m(j0Var9);
                    j0Var9.c(j0Var7).a();
                }
                source.s1(source.B1() - j8);
                s1(B1() + j8);
                j7 -= j8;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    @Override // okio.o
    public int read(@a7.d byte[] sink, int i7, int i8) {
        kotlin.jvm.internal.l0.p(sink, "sink");
        j.e(sink.length, i7, i8);
        j0 j0Var = this.f38494a;
        if (j0Var == null) {
            return -1;
        }
        int iMin = Math.min(i8, j0Var.f38470c - j0Var.f38469b);
        byte[] bArr = j0Var.f38468a;
        int i9 = j0Var.f38469b;
        kotlin.collections.o.W0(bArr, sink, i7, i9, i9 + iMin);
        j0Var.f38469b += iMin;
        s1(B1() - ((long) iMin));
        if (j0Var.f38469b != j0Var.f38470c) {
            return iMin;
        }
        this.f38494a = j0Var.b();
        k0.d(j0Var);
        return iMin;
    }

    @Override // okio.o0
    public long read(@a7.d m sink, long j7) {
        kotlin.jvm.internal.l0.p(sink, "sink");
        if (!(j7 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j7).toString());
        }
        if (B1() == 0) {
            return -1L;
        }
        if (j7 > B1()) {
            j7 = B1();
        }
        sink.write(this, j7);
        return j7;
    }
}
