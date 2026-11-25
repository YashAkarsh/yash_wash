package com.haier.library.a;

import android.support.v4.media.session.PlaybackStateCompat;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.text.h0;
import okio.r0;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements h, i, Cloneable, ByteChannel {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final byte[] f26252c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int f26253d = 65533;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    y f26254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f26255b;

    class a extends OutputStream {
        a() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return g.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i7) {
            g.this.y1((byte) i7);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i7, int i8) {
            g.this.T1(bArr, i7, i8);
        }
    }

    class b extends InputStream {
        b() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(g.this.f26255b, 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            g gVar = g.this;
            if (gVar.f26255b > 0) {
                return gVar.j() & 255;
            }
            return -1;
        }

        public String toString() {
            return g.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i7, int i8) {
            return g.this.W0(bArr, i7, i8);
        }
    }

    public static final class c implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g f26258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f26259b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private y f26260c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f26262e;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f26261d = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f26263f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f26264g = -1;

        public final int b() {
            long j7 = this.f26261d;
            if (j7 != this.f26258a.f26255b) {
                return j7 == -1 ? c(0L) : c(j7 + ((long) (this.f26264g - this.f26263f)));
            }
            throw new IllegalStateException();
        }

        public final int c(long j7) {
            if (j7 >= -1) {
                g gVar = this.f26258a;
                long j8 = gVar.f26255b;
                if (j7 <= j8) {
                    if (j7 == -1 || j7 == j8) {
                        this.f26260c = null;
                        this.f26261d = j7;
                        this.f26262e = null;
                        this.f26263f = -1;
                        this.f26264g = -1;
                        return -1;
                    }
                    y yVar = gVar.f26254a;
                    y yVarC = this.f26260c;
                    long j9 = 0;
                    if (yVarC != null) {
                        long j10 = this.f26261d - ((long) (this.f26263f - yVarC.f26332b));
                        if (j10 > j7) {
                            j8 = j10;
                            yVarC = yVar;
                            yVar = yVarC;
                        } else {
                            j9 = j10;
                        }
                    } else {
                        yVarC = yVar;
                    }
                    if (j8 - j7 > j7 - j9) {
                        while (true) {
                            int i7 = yVarC.f26333c;
                            int i8 = yVarC.f26332b;
                            if (j7 < ((long) (i7 - i8)) + j9) {
                                break;
                            }
                            j9 += (long) (i7 - i8);
                            yVarC = yVarC.f26336f;
                        }
                    } else {
                        while (j8 > j7) {
                            yVar = yVar.f26337g;
                            j8 -= (long) (yVar.f26333c - yVar.f26332b);
                        }
                        yVarC = yVar;
                        j9 = j8;
                    }
                    if (this.f26259b && yVarC.f26334d) {
                        y yVarE = yVarC.e();
                        g gVar2 = this.f26258a;
                        if (gVar2.f26254a == yVarC) {
                            gVar2.f26254a = yVarE;
                        }
                        yVarC = yVarC.c(yVarE);
                        yVarC.f26337g.f();
                    }
                    this.f26260c = yVarC;
                    this.f26261d = j7;
                    this.f26262e = yVarC.f26331a;
                    int i9 = yVarC.f26332b + ((int) (j7 - j9));
                    this.f26263f = i9;
                    int i10 = yVarC.f26333c;
                    this.f26264g = i10;
                    return i10 - i9;
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", Long.valueOf(j7), Long.valueOf(this.f26258a.f26255b)));
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f26258a == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.f26258a = null;
            this.f26260c = null;
            this.f26261d = -1L;
            this.f26262e = null;
            this.f26263f = -1;
            this.f26264g = -1;
        }

        public final long e(int i7) {
            if (i7 <= 0) {
                throw new IllegalArgumentException("minByteCount <= 0: " + i7);
            }
            if (i7 > 8192) {
                throw new IllegalArgumentException("minByteCount > Segment.SIZE: " + i7);
            }
            g gVar = this.f26258a;
            if (gVar == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.f26259b) {
                throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
            }
            long j7 = gVar.f26255b;
            y yVarZ1 = gVar.Z1(i7);
            int i8 = 8192 - yVarZ1.f26333c;
            yVarZ1.f26333c = 8192;
            long j8 = i8;
            this.f26258a.f26255b = j7 + j8;
            this.f26260c = yVarZ1;
            this.f26261d = j7;
            this.f26262e = yVarZ1.f26331a;
            this.f26263f = 8192 - i8;
            this.f26264g = 8192;
            return j8;
        }

        public final long f(long j7) {
            g gVar = this.f26258a;
            if (gVar == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.f26259b) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
            long j8 = gVar.f26255b;
            if (j7 <= j8) {
                if (j7 < 0) {
                    throw new IllegalArgumentException("newSize < 0: " + j7);
                }
                long j9 = j8 - j7;
                while (j9 > 0) {
                    g gVar2 = this.f26258a;
                    y yVar = gVar2.f26254a.f26337g;
                    int i7 = yVar.f26333c;
                    long j10 = i7 - yVar.f26332b;
                    if (j10 > j9) {
                        yVar.f26333c = (int) (((long) i7) - j9);
                        break;
                    }
                    gVar2.f26254a = yVar.f();
                    z.b(yVar);
                    j9 -= j10;
                }
                this.f26260c = null;
                this.f26261d = j7;
                this.f26262e = null;
                this.f26263f = -1;
                this.f26264g = -1;
            } else if (j7 > j8) {
                long j11 = j7 - j8;
                boolean z7 = true;
                while (j11 > 0) {
                    y yVarZ1 = this.f26258a.Z1(1);
                    int iMin = (int) Math.min(j11, 8192 - yVarZ1.f26333c);
                    int i8 = yVarZ1.f26333c + iMin;
                    yVarZ1.f26333c = i8;
                    j11 -= (long) iMin;
                    if (z7) {
                        this.f26260c = yVarZ1;
                        this.f26261d = j8;
                        this.f26262e = yVarZ1.f26331a;
                        this.f26263f = i8 - iMin;
                        this.f26264g = i8;
                        z7 = false;
                    }
                }
            }
            this.f26258a.f26255b = j7;
            return j8;
        }
    }

    private j Q0(String str, j jVar) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(jVar.a0(), str));
            y yVar = this.f26254a;
            if (yVar != null) {
                byte[] bArr = yVar.f26331a;
                int i7 = yVar.f26332b;
                mac.update(bArr, i7, yVar.f26333c - i7);
                y yVar2 = this.f26254a;
                while (true) {
                    yVar2 = yVar2.f26336f;
                    if (yVar2 == this.f26254a) {
                        break;
                    }
                    byte[] bArr2 = yVar2.f26331a;
                    int i8 = yVar2.f26332b;
                    mac.update(bArr2, i8, yVar2.f26333c - i8);
                }
            }
            return j.m(mac.doFinal());
        } catch (InvalidKeyException e8) {
            throw new IllegalArgumentException(e8);
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    private void T0(InputStream inputStream, long j7, boolean z7) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        while (true) {
            if (j7 <= 0 && !z7) {
                return;
            }
            y yVarZ1 = Z1(1);
            int i7 = inputStream.read(yVarZ1.f26331a, yVarZ1.f26333c, (int) Math.min(j7, 8192 - yVarZ1.f26333c));
            if (i7 == -1) {
                if (!z7) {
                    throw new EOFException();
                }
                return;
            } else {
                yVarZ1.f26333c += i7;
                long j8 = i7;
                this.f26255b += j8;
                j7 -= j8;
            }
        }
    }

    private boolean V0(y yVar, int i7, j jVar, int i8, int i9) {
        int i10 = yVar.f26333c;
        byte[] bArr = yVar.f26331a;
        while (i8 < i9) {
            if (i7 == i10) {
                yVar = yVar.f26336f;
                byte[] bArr2 = yVar.f26331a;
                bArr = bArr2;
                i7 = yVar.f26332b;
                i10 = yVar.f26333c;
            }
            if (bArr[i7] != jVar.x(i8)) {
                return false;
            }
            i7++;
            i8++;
        }
        return true;
    }

    private j z1(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            y yVar = this.f26254a;
            if (yVar != null) {
                byte[] bArr = yVar.f26331a;
                int i7 = yVar.f26332b;
                messageDigest.update(bArr, i7, yVar.f26333c - i7);
                y yVar2 = this.f26254a;
                while (true) {
                    yVar2 = yVar2.f26336f;
                    if (yVar2 == this.f26254a) {
                        break;
                    }
                    byte[] bArr2 = yVar2.f26331a;
                    int i8 = yVar2.f26332b;
                    messageDigest.update(bArr2, i8, yVar2.f26333c - i8);
                }
            }
            return j.m(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    @Override // com.haier.library.a.i
    public boolean A(long j7, j jVar) {
        return w0(j7, jVar, 0, jVar.Z());
    }

    @Override // com.haier.library.a.h
    /* JADX INFO: renamed from: A1, reason: merged with bridge method [inline-methods] */
    public g N0(int i7) {
        return l1(com.haier.library.a.c.c((short) i7));
    }

    public final j B1(j jVar) {
        return Q0("HmacSHA1", jVar);
    }

    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public g clone() {
        g gVar = new g();
        if (this.f26255b == 0) {
            return gVar;
        }
        y yVarA = this.f26254a.a();
        gVar.f26254a = yVarA;
        yVarA.f26337g = yVarA;
        yVarA.f26336f = yVarA;
        y yVar = this.f26254a;
        while (true) {
            yVar = yVar.f26336f;
            if (yVar == this.f26254a) {
                gVar.f26255b = this.f26255b;
                return gVar;
            }
            gVar.f26254a.f26337g.c(yVar.a());
        }
    }

    @Override // com.haier.library.a.i
    public String C1(long j7) throws EOFException {
        return O(j7, com.haier.library.a.c.f26245a);
    }

    public final j E() {
        long j7 = this.f26255b;
        if (j7 <= 2147483647L) {
            return b2((int) j7);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f26255b);
    }

    @Override // com.haier.library.a.i
    public long E1() {
        if (this.f26255b == 0) {
            throw new IllegalStateException("size == 0");
        }
        int i7 = 0;
        boolean z7 = false;
        long j7 = -7;
        long j8 = 0;
        boolean z8 = false;
        do {
            y yVar = this.f26254a;
            byte[] bArr = yVar.f26331a;
            int i8 = yVar.f26332b;
            int i9 = yVar.f26333c;
            while (i8 < i9) {
                byte b8 = bArr[i8];
                if (b8 >= 48 && b8 <= 57) {
                    int i10 = 48 - b8;
                    if (j8 < v5.a.f40434c || (j8 == v5.a.f40434c && i10 < j7)) {
                        g gVarY1 = new g().n(j8).y1(b8);
                        if (!z7) {
                            gVarY1.j();
                        }
                        throw new NumberFormatException("Number too large: " + gVarY1.T());
                    }
                    j8 = (j8 * 10) + ((long) i10);
                } else {
                    if (b8 != 45 || i7 != 0) {
                        if (i7 != 0) {
                            z8 = true;
                            break;
                        }
                        throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Integer.toHexString(b8));
                    }
                    j7--;
                    z7 = true;
                }
                i8++;
                i7++;
            }
            if (i8 == i9) {
                this.f26254a = yVar.f();
                z.b(yVar);
            } else {
                yVar.f26332b = i8;
            }
            if (z8) {
                break;
            }
        } while (this.f26254a != null);
        this.f26255b -= (long) i7;
        return z7 ? j8 : -j8;
    }

    public final c F() {
        return Q(new c());
    }

    public final c G() {
        return a1(new c());
    }

    @Override // com.haier.library.a.h
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public g b(String str) {
        return b(str, 0, str.length());
    }

    int H(u uVar, boolean z7) {
        int i7;
        int i8;
        int i9;
        int i10;
        y yVar;
        y yVar2 = this.f26254a;
        int i11 = -2;
        if (yVar2 == null) {
            if (z7) {
                return -2;
            }
            return uVar.indexOf(j.f26267f);
        }
        byte[] bArr = yVar2.f26331a;
        int i12 = yVar2.f26332b;
        int i13 = yVar2.f26333c;
        int[] iArr = uVar.f26310b;
        y yVar3 = yVar2;
        int i14 = 0;
        int i15 = -1;
        loop0: while (true) {
            int i16 = i14 + 1;
            int i17 = iArr[i14];
            int i18 = i16 + 1;
            int i19 = iArr[i16];
            if (i19 != -1) {
                i15 = i19;
            }
            if (yVar3 == null) {
                break;
            }
            if (i17 >= 0) {
                int i20 = i12 + 1;
                int i21 = bArr[i12] & 255;
                int i22 = i18 + i17;
                while (i18 != i22) {
                    if (i21 == iArr[i18]) {
                        i7 = iArr[i18 + i17];
                        if (i20 == i13) {
                            yVar3 = yVar3.f26336f;
                            i8 = yVar3.f26332b;
                            bArr = yVar3.f26331a;
                            i13 = yVar3.f26333c;
                            if (yVar3 == yVar2) {
                                yVar3 = null;
                            }
                        } else {
                            i8 = i20;
                        }
                    } else {
                        i18++;
                    }
                }
                return i15;
            }
            int i23 = i18 + (i17 * (-1));
            while (true) {
                int i24 = i12 + 1;
                int i25 = i18 + 1;
                if ((bArr[i12] & 255) != iArr[i18]) {
                    return i15;
                }
                boolean z8 = i25 == i23;
                if (i24 == i13) {
                    y yVar4 = yVar3.f26336f;
                    i10 = yVar4.f26332b;
                    byte[] bArr2 = yVar4.f26331a;
                    i9 = yVar4.f26333c;
                    if (yVar4 != yVar2) {
                        yVar = yVar4;
                        bArr = bArr2;
                    } else {
                        if (!z8) {
                            break loop0;
                        }
                        bArr = bArr2;
                        yVar = null;
                    }
                } else {
                    y yVar5 = yVar3;
                    i9 = i13;
                    i10 = i24;
                    yVar = yVar5;
                }
                if (z8) {
                    i7 = iArr[i25];
                    i8 = i10;
                    i13 = i9;
                    yVar3 = yVar;
                    break;
                }
                i12 = i10;
                i13 = i9;
                i18 = i25;
                yVar3 = yVar;
            }
            if (i7 >= 0) {
                return i7;
            }
            i14 = -i7;
            i12 = i8;
            i11 = -2;
        }
        return z7 ? i11 : i15;
    }

    @Override // com.haier.library.a.i
    public long H0(j jVar, long j7) {
        int i7;
        int i8;
        long j8 = 0;
        if (j7 < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        y yVar = this.f26254a;
        if (yVar == null) {
            return -1L;
        }
        long j9 = this.f26255b;
        if (j9 - j7 < j7) {
            while (j9 > j7) {
                yVar = yVar.f26337g;
                j9 -= (long) (yVar.f26333c - yVar.f26332b);
            }
        } else {
            while (true) {
                long j10 = ((long) (yVar.f26333c - yVar.f26332b)) + j8;
                if (j10 >= j7) {
                    break;
                }
                yVar = yVar.f26336f;
                j8 = j10;
            }
            j9 = j8;
        }
        if (jVar.Z() == 2) {
            byte bX = jVar.x(0);
            byte bX2 = jVar.x(1);
            while (j9 < this.f26255b) {
                byte[] bArr = yVar.f26331a;
                i7 = (int) ((((long) yVar.f26332b) + j7) - j9);
                int i9 = yVar.f26333c;
                while (i7 < i9) {
                    byte b8 = bArr[i7];
                    if (b8 == bX || b8 == bX2) {
                        i8 = yVar.f26332b;
                        return ((long) (i7 - i8)) + j9;
                    }
                    i7++;
                }
                j9 += (long) (yVar.f26333c - yVar.f26332b);
                yVar = yVar.f26336f;
                j7 = j9;
            }
            return -1L;
        }
        byte[] bArrB0 = jVar.b0();
        while (j9 < this.f26255b) {
            byte[] bArr2 = yVar.f26331a;
            i7 = (int) ((((long) yVar.f26332b) + j7) - j9);
            int i10 = yVar.f26333c;
            while (i7 < i10) {
                byte b9 = bArr2[i7];
                for (byte b10 : bArrB0) {
                    if (b9 == b10) {
                        i8 = yVar.f26332b;
                        return ((long) (i7 - i8)) + j9;
                    }
                }
                i7++;
            }
            j9 += (long) (yVar.f26333c - yVar.f26332b);
            yVar = yVar.f26336f;
            j7 = j9;
        }
        return -1L;
    }

    @Override // com.haier.library.a.h
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public g b(String str, int i7, int i8) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i7 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i7);
        }
        if (i8 < i7) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i8 + " < " + i7);
        }
        if (i8 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i8 + " > " + str.length());
        }
        while (i7 < i8) {
            char cCharAt = str.charAt(i7);
            if (cCharAt < 128) {
                y yVarZ1 = Z1(1);
                byte[] bArr = yVarZ1.f26331a;
                int i9 = yVarZ1.f26333c - i7;
                int iMin = Math.min(i8, 8192 - i9);
                int i10 = i7 + 1;
                bArr[i7 + i9] = (byte) cCharAt;
                while (i10 < iMin) {
                    char cCharAt2 = str.charAt(i10);
                    if (cCharAt2 >= 128) {
                        break;
                    }
                    bArr[i10 + i9] = (byte) cCharAt2;
                    i10++;
                }
                int i11 = yVarZ1.f26333c;
                int i12 = (i9 + i10) - i11;
                yVarZ1.f26333c = i11 + i12;
                this.f26255b += (long) i12;
                i7 = i10;
            } else {
                if (cCharAt < 2048) {
                    y1((cCharAt >> 6) | com.alibaba.fastjson.asm.j.f12606c0);
                    y1((cCharAt & '?') | 128);
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    y1((cCharAt >> '\f') | 224);
                    y1(((cCharAt >> 6) & 63) | 128);
                    y1((cCharAt & '?') | 128);
                } else {
                    int i13 = i7 + 1;
                    char cCharAt3 = i13 < i8 ? str.charAt(i13) : (char) 0;
                    if (cCharAt > 56319 || cCharAt3 < 56320 || cCharAt3 > 57343) {
                        y1(63);
                        i7 = i13;
                    } else {
                        int i14 = (((cCharAt & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                        y1((i14 >> 18) | 240);
                        y1(((i14 >> 12) & 63) | 128);
                        y1(((i14 >> 6) & 63) | 128);
                        y1((i14 & 63) | 128);
                        i7 += 2;
                    }
                }
                i7++;
            }
        }
        return this;
    }

    @Override // com.haier.library.a.b0
    public void I1(g gVar, long j7) {
        if (gVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (gVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        com.haier.library.a.c.d(gVar.f26255b, 0L, j7);
        while (j7 > 0) {
            y yVar = gVar.f26254a;
            if (j7 < yVar.f26333c - yVar.f26332b) {
                y yVar2 = this.f26254a;
                y yVar3 = yVar2 != null ? yVar2.f26337g : null;
                if (yVar3 != null && yVar3.f26335e) {
                    if ((((long) yVar3.f26333c) + j7) - ((long) (yVar3.f26334d ? 0 : yVar3.f26332b)) <= PlaybackStateCompat.f450z) {
                        yVar.d(yVar3, (int) j7);
                        gVar.f26255b -= j7;
                        this.f26255b += j7;
                        return;
                    }
                }
                gVar.f26254a = yVar.b((int) j7);
            }
            y yVar4 = gVar.f26254a;
            long j8 = yVar4.f26333c - yVar4.f26332b;
            gVar.f26254a = yVar4.f();
            y yVar5 = this.f26254a;
            if (yVar5 == null) {
                this.f26254a = yVar4;
                yVar4.f26337g = yVar4;
                yVar4.f26336f = yVar4;
            } else {
                yVar5.f26337g.c(yVar4).g();
            }
            gVar.f26255b -= j8;
            this.f26255b += j8;
            j7 -= j8;
        }
    }

    @Override // com.haier.library.a.h
    /* JADX INFO: renamed from: J0, reason: merged with bridge method [inline-methods] */
    public g W(String str, int i7, int i8, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i7 < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i7);
        }
        if (i8 < i7) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i8 + " < " + i7);
        }
        if (i8 <= str.length()) {
            if (charset == null) {
                throw new IllegalArgumentException("charset == null");
            }
            if (charset.equals(com.haier.library.a.c.f26245a)) {
                return b(str, i7, i8);
            }
            byte[] bytes = str.substring(i7, i8).getBytes(charset);
            return T1(bytes, 0, bytes.length);
        }
        throw new IllegalArgumentException("endIndex > string.length: " + i8 + " > " + str.length());
    }

    @Override // com.haier.library.a.h
    /* JADX INFO: renamed from: L0, reason: merged with bridge method [inline-methods] */
    public g U0(String str, Charset charset) {
        return W(str, 0, str.length(), charset);
    }

    @Override // com.haier.library.a.i
    public long L1(byte b8, long j7) {
        return U1(b8, j7, Long.MAX_VALUE);
    }

    @Override // com.haier.library.a.i
    public int M0(byte[] bArr) {
        return W0(bArr, 0, bArr.length);
    }

    @Override // com.haier.library.a.h
    /* JADX INFO: renamed from: N1, reason: merged with bridge method [inline-methods] */
    public g P() {
        return this;
    }

    @Override // com.haier.library.a.i
    public String O(long j7, Charset charset) throws EOFException {
        com.haier.library.a.c.d(this.f26255b, 0L, j7);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j7 > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j7);
        }
        if (j7 == 0) {
            return "";
        }
        y yVar = this.f26254a;
        int i7 = yVar.f26332b;
        if (((long) i7) + j7 > yVar.f26333c) {
            return new String(S(j7), charset);
        }
        String str = new String(yVar.f26331a, i7, (int) j7, charset);
        int i8 = (int) (((long) yVar.f26332b) + j7);
        yVar.f26332b = i8;
        this.f26255b -= j7;
        if (i8 == yVar.f26333c) {
            this.f26254a = yVar.f();
            z.b(yVar);
        }
        return str;
    }

    @Override // com.haier.library.a.c0
    public long P0(g gVar, long j7) {
        if (gVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j7 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j7);
        }
        long j8 = this.f26255b;
        if (j8 == 0) {
            return -1L;
        }
        if (j7 > j8) {
            j7 = j8;
        }
        gVar.I1(this, j7);
        return j7;
    }

    public final c Q(c cVar) {
        if (cVar.f26258a != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        cVar.f26258a = this;
        cVar.f26259b = false;
        return cVar;
    }

    @Override // com.haier.library.a.i
    public int R0() throws EOFException {
        int i7;
        int i8;
        int i9;
        if (this.f26255b == 0) {
            throw new EOFException();
        }
        byte bQ1 = q1(0L);
        if ((bQ1 & 128) == 0) {
            i7 = bQ1 & 127;
            i9 = 0;
            i8 = 1;
        } else if ((bQ1 & 224) == 192) {
            i7 = bQ1 & com.google.common.base.c.I;
            i8 = 2;
            i9 = 128;
        } else if ((bQ1 & 240) == 224) {
            i7 = bQ1 & com.google.common.base.c.f19317q;
            i8 = 3;
            i9 = 2048;
        } else {
            if ((bQ1 & 248) != 240) {
                j0(1L);
                return 65533;
            }
            i7 = bQ1 & 7;
            i8 = 4;
            i9 = 65536;
        }
        long j7 = i8;
        if (this.f26255b < j7) {
            throw new EOFException("size < " + i8 + ": " + this.f26255b + " (to read code point prefixed 0x" + Integer.toHexString(bQ1) + ")");
        }
        for (int i10 = 1; i10 < i8; i10++) {
            long j8 = i10;
            byte bQ2 = q1(j8);
            if ((bQ2 & 192) != 128) {
                j0(j8);
                return 65533;
            }
            i7 = (i7 << 6) | (bQ2 & r0.f38528a);
        }
        j0(j7);
        if (i7 > 1114111) {
            return 65533;
        }
        if ((i7 < 55296 || i7 > 57343) && i7 >= i9) {
            return i7;
        }
        return 65533;
    }

    @Override // com.haier.library.a.h
    /* JADX INFO: renamed from: R1, reason: merged with bridge method [inline-methods] */
    public g z0(int i7) {
        y yVarZ1 = Z1(4);
        byte[] bArr = yVarZ1.f26331a;
        int i8 = yVarZ1.f26333c;
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((i7 >>> 24) & 255);
        int i10 = i9 + 1;
        bArr[i9] = (byte) ((i7 >>> 16) & 255);
        int i11 = i10 + 1;
        bArr[i10] = (byte) ((i7 >>> 8) & 255);
        bArr[i11] = (byte) (i7 & 255);
        yVarZ1.f26333c = i11 + 1;
        this.f26255b += 4;
        return this;
    }

    @Override // com.haier.library.a.i
    public byte[] S(long j7) throws EOFException {
        com.haier.library.a.c.d(this.f26255b, 0L, j7);
        if (j7 <= 2147483647L) {
            byte[] bArr = new byte[(int) j7];
            k1(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j7);
    }

    @Override // com.haier.library.a.h
    public h S0(c0 c0Var, long j7) throws IOException {
        while (j7 > 0) {
            long jP0 = c0Var.P0(this, j7);
            if (jP0 == -1) {
                throw new EOFException();
            }
            j7 -= jP0;
        }
        return this;
    }

    @Override // com.haier.library.a.i
    public String T() {
        try {
            return O(this.f26255b, com.haier.library.a.c.f26245a);
        } catch (EOFException e8) {
            throw new AssertionError(e8);
        }
    }

    @Override // com.haier.library.a.i
    public long U1(byte b8, long j7, long j8) {
        y yVar;
        long j9 = 0;
        if (j7 < 0 || j8 < j7) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.f26255b), Long.valueOf(j7), Long.valueOf(j8)));
        }
        long j10 = this.f26255b;
        long j11 = j8 > j10 ? j10 : j8;
        if (j7 == j11 || (yVar = this.f26254a) == null) {
            return -1L;
        }
        if (j10 - j7 < j7) {
            while (j10 > j7) {
                yVar = yVar.f26337g;
                j10 -= (long) (yVar.f26333c - yVar.f26332b);
            }
        } else {
            while (true) {
                long j12 = ((long) (yVar.f26333c - yVar.f26332b)) + j9;
                if (j12 >= j7) {
                    break;
                }
                yVar = yVar.f26336f;
                j9 = j12;
            }
            j10 = j9;
        }
        long j13 = j7;
        while (j10 < j11) {
            byte[] bArr = yVar.f26331a;
            int iMin = (int) Math.min(yVar.f26333c, (((long) yVar.f26332b) + j11) - j10);
            for (int i7 = (int) ((((long) yVar.f26332b) + j13) - j10); i7 < iMin; i7++) {
                if (bArr[i7] == b8) {
                    return ((long) (i7 - yVar.f26332b)) + j10;
                }
            }
            j10 += (long) (yVar.f26333c - yVar.f26332b);
            yVar = yVar.f26336f;
            j13 = j10;
        }
        return -1L;
    }

    @Override // com.haier.library.a.i
    public int W0(byte[] bArr, int i7, int i8) {
        com.haier.library.a.c.d(bArr.length, i7, i8);
        y yVar = this.f26254a;
        if (yVar == null) {
            return -1;
        }
        int iMin = Math.min(i8, yVar.f26333c - yVar.f26332b);
        System.arraycopy(yVar.f26331a, yVar.f26332b, bArr, i7, iMin);
        int i9 = yVar.f26332b + iMin;
        yVar.f26332b = i9;
        this.f26255b -= (long) iMin;
        if (i9 == yVar.f26333c) {
            this.f26254a = yVar.f();
            z.b(yVar);
        }
        return iMin;
    }

    public final j W1(j jVar) {
        return Q0("HmacSHA256", jVar);
    }

    @Override // com.haier.library.a.i
    public int X(u uVar) {
        int iH = H(uVar, false);
        if (iH == -1) {
            return -1;
        }
        try {
            j0(uVar.f26309a[iH].Z());
            return iH;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    @Override // com.haier.library.a.h
    /* JADX INFO: renamed from: X1, reason: merged with bridge method [inline-methods] */
    public g i0(int i7) {
        return z0(com.haier.library.a.c.a(i7));
    }

    public final long Y0() {
        return this.f26255b;
    }

    public final j Y1(j jVar) {
        return Q0("HmacSHA512", jVar);
    }

    @Override // com.haier.library.a.i
    public int Z0() {
        return com.haier.library.a.c.a(l());
    }

    y Z1(int i7) {
        if (i7 < 1 || i7 > 8192) {
            throw new IllegalArgumentException();
        }
        y yVar = this.f26254a;
        if (yVar != null) {
            y yVar2 = yVar.f26337g;
            return (yVar2.f26333c + i7 > 8192 || !yVar2.f26335e) ? yVar2.c(z.a()) : yVar2;
        }
        y yVarA = z.a();
        this.f26254a = yVarA;
        yVarA.f26337g = yVarA;
        yVarA.f26336f = yVarA;
        return yVarA;
    }

    @Override // com.haier.library.a.i
    public void a(long j7) throws EOFException {
        if (this.f26255b < j7) {
            throw new EOFException();
        }
    }

    public final c a1(c cVar) {
        if (cVar.f26258a != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        cVar.f26258a = this;
        cVar.f26259b = true;
        return cVar;
    }

    String a2(long j7) throws EOFException {
        if (j7 > 0) {
            long j8 = j7 - 1;
            if (q1(j8) == 13) {
                String strC1 = C1(j8);
                j0(2L);
                return strC1;
            }
        }
        String strC2 = C1(j7);
        j0(1L);
        return strC2;
    }

    public final j b2(int i7) {
        return i7 == 0 ? j.f26267f : new a0(this, i7);
    }

    @Override // com.haier.library.a.h, com.haier.library.a.i
    public g c() {
        return this;
    }

    public final long c2() {
        long j7 = this.f26255b;
        if (j7 == 0) {
            return 0L;
        }
        y yVar = this.f26254a.f26337g;
        int i7 = yVar.f26333c;
        return (i7 >= 8192 || !yVar.f26335e) ? j7 : j7 - ((long) (i7 - yVar.f26332b));
    }

    @Override // com.haier.library.a.b0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // com.haier.library.a.h
    public OutputStream d() {
        return new a();
    }

    @Override // com.haier.library.a.h
    /* JADX INFO: renamed from: d1, reason: merged with bridge method [inline-methods] */
    public g y1(int i7) {
        y yVarZ1 = Z1(1);
        byte[] bArr = yVarZ1.f26331a;
        int i8 = yVarZ1.f26333c;
        yVarZ1.f26333c = i8 + 1;
        bArr[i8] = (byte) i7;
        this.f26255b++;
        return this;
    }

    @Override // com.haier.library.a.h
    /* JADX INFO: renamed from: d2, reason: merged with bridge method [inline-methods] */
    public g d0(long j7) {
        y yVarZ1 = Z1(8);
        byte[] bArr = yVarZ1.f26331a;
        int i7 = yVarZ1.f26333c;
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
        yVarZ1.f26333c = i14 + 1;
        this.f26255b += 8;
        return this;
    }

    public final j e() {
        return z1("MD5");
    }

    public final g e1(OutputStream outputStream) throws IOException {
        return v0(outputStream, this.f26255b);
    }

    @Override // com.haier.library.a.h
    /* JADX INFO: renamed from: e2, reason: merged with bridge method [inline-methods] */
    public g M(long j7) {
        return d0(com.haier.library.a.c.b(j7));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        long j7 = this.f26255b;
        if (j7 != gVar.f26255b) {
            return false;
        }
        long j8 = 0;
        if (j7 == 0) {
            return true;
        }
        y yVar = this.f26254a;
        y yVar2 = gVar.f26254a;
        int i7 = yVar.f26332b;
        int i8 = yVar2.f26332b;
        while (j8 < this.f26255b) {
            long jMin = Math.min(yVar.f26333c - i7, yVar2.f26333c - i8);
            int i9 = 0;
            while (i9 < jMin) {
                int i10 = i7 + 1;
                int i11 = i8 + 1;
                if (yVar.f26331a[i7] != yVar2.f26331a[i8]) {
                    return false;
                }
                i9++;
                i7 = i10;
                i8 = i11;
            }
            if (i7 == yVar.f26333c) {
                yVar = yVar.f26336f;
                i7 = yVar.f26332b;
            }
            if (i8 == yVar2.f26333c) {
                yVar2 = yVar2.f26336f;
                i8 = yVar2.f26332b;
            }
            j8 += jMin;
        }
        return true;
    }

    @Override // com.haier.library.a.h
    public h f() {
        return this;
    }

    @Override // com.haier.library.a.h
    public long f0(c0 c0Var) throws IOException {
        if (c0Var == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j7 = 0;
        while (true) {
            long jP0 = c0Var.P0(this, PlaybackStateCompat.f450z);
            if (jP0 == -1) {
                return j7;
            }
            j7 += jP0;
        }
    }

    @Override // com.haier.library.a.i
    public long f1(j jVar, long j7) throws IOException {
        if (jVar.Z() == 0) {
            throw new IllegalArgumentException("bytes is empty");
        }
        long j8 = 0;
        if (j7 < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        y yVar = this.f26254a;
        long j9 = -1;
        if (yVar == null) {
            return -1L;
        }
        long j10 = this.f26255b;
        if (j10 - j7 < j7) {
            while (j10 > j7) {
                yVar = yVar.f26337g;
                j10 -= (long) (yVar.f26333c - yVar.f26332b);
            }
        } else {
            while (true) {
                long j11 = ((long) (yVar.f26333c - yVar.f26332b)) + j8;
                if (j11 >= j7) {
                    break;
                }
                yVar = yVar.f26336f;
                j8 = j11;
            }
            j10 = j8;
        }
        byte bX = jVar.x(0);
        int iZ = jVar.Z();
        long j12 = 1 + (this.f26255b - ((long) iZ));
        long j13 = j7;
        y yVar2 = yVar;
        long j14 = j10;
        while (j14 < j12) {
            byte[] bArr = yVar2.f26331a;
            int iMin = (int) Math.min(yVar2.f26333c, (((long) yVar2.f26332b) + j12) - j14);
            int i7 = (int) ((((long) yVar2.f26332b) + j13) - j14);
            while (i7 < iMin) {
                if (bArr[i7] == bX) {
                    if (V0(yVar2, i7 + 1, jVar, 1, iZ)) {
                        return ((long) (i7 - yVar2.f26332b)) + j14;
                    }
                }
                i7++;
                bArr = bArr;
            }
            j14 += (long) (yVar2.f26333c - yVar2.f26332b);
            yVar2 = yVar2.f26336f;
            j13 = j14;
            j9 = -1;
        }
        return j9;
    }

    @Override // com.haier.library.a.h
    /* JADX INFO: renamed from: f2, reason: merged with bridge method [inline-methods] */
    public g n(long j7) {
        boolean z7;
        if (j7 == 0) {
            return y1(48);
        }
        int i7 = 1;
        if (j7 < 0) {
            j7 = -j7;
            if (j7 < 0) {
                return b("-9223372036854775808");
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
        y yVarZ1 = Z1(i7);
        byte[] bArr = yVarZ1.f26331a;
        int i8 = yVarZ1.f26333c + i7;
        while (j7 != 0) {
            i8--;
            bArr[i8] = f26252c[(int) (j7 % 10)];
            j7 /= 10;
        }
        if (z7) {
            bArr[i8 - 1] = 45;
        }
        yVarZ1.f26333c += i7;
        this.f26255b += (long) i7;
        return this;
    }

    @Override // com.haier.library.a.h, com.haier.library.a.b0, java.io.Flushable
    public void flush() {
    }

    @Override // com.haier.library.a.i
    public boolean g() {
        return this.f26255b == 0;
    }

    @Override // com.haier.library.a.h
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public g O1(int i7) {
        if (i7 < 128) {
            y1(i7);
        } else if (i7 < 2048) {
            y1((i7 >> 6) | com.alibaba.fastjson.asm.j.f12606c0);
            y1((i7 & 63) | 128);
        } else if (i7 < 65536) {
            if (i7 < 55296 || i7 > 57343) {
                y1((i7 >> 12) | 224);
                y1(((i7 >> 6) & 63) | 128);
                y1((i7 & 63) | 128);
            } else {
                y1(63);
            }
        } else {
            if (i7 > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i7));
            }
            y1((i7 >> 18) | 240);
            y1(((i7 >> 12) & 63) | 128);
            y1(((i7 >> 6) & 63) | 128);
            y1((i7 & 63) | 128);
        }
        return this;
    }

    @Override // com.haier.library.a.i
    public long g1(b0 b0Var) throws IOException {
        long j7 = this.f26255b;
        if (j7 > 0) {
            b0Var.I1(this, j7);
        }
        return j7;
    }

    @Override // com.haier.library.a.h
    /* JADX INFO: renamed from: g2, reason: merged with bridge method [inline-methods] */
    public g P1(long j7) {
        if (j7 == 0) {
            return y1(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j7)) / 4) + 1;
        y yVarZ1 = Z1(iNumberOfTrailingZeros);
        byte[] bArr = yVarZ1.f26331a;
        int i7 = yVarZ1.f26333c;
        for (int i8 = (i7 + iNumberOfTrailingZeros) - 1; i8 >= i7; i8--) {
            bArr[i8] = f26252c[(int) (15 & j7)];
            j7 >>>= 4;
        }
        yVarZ1.f26333c += iNumberOfTrailingZeros;
        this.f26255b += (long) iNumberOfTrailingZeros;
        return this;
    }

    @Override // com.haier.library.a.i
    public InputStream h() {
        return new b();
    }

    public final g h0(g gVar, long j7, long j8) {
        if (gVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        com.haier.library.a.c.d(this.f26255b, j7, j8);
        if (j8 == 0) {
            return this;
        }
        gVar.f26255b += j8;
        y yVar = this.f26254a;
        while (true) {
            int i7 = yVar.f26333c;
            int i8 = yVar.f26332b;
            if (j7 < i7 - i8) {
                break;
            }
            j7 -= (long) (i7 - i8);
            yVar = yVar.f26336f;
        }
        while (j8 > 0) {
            y yVarA = yVar.a();
            int i9 = (int) (((long) yVarA.f26332b) + j7);
            yVarA.f26332b = i9;
            yVarA.f26333c = Math.min(i9 + ((int) j8), yVarA.f26333c);
            y yVar2 = gVar.f26254a;
            if (yVar2 == null) {
                yVarA.f26337g = yVarA;
                yVarA.f26336f = yVarA;
                gVar.f26254a = yVarA;
            } else {
                yVar2.f26337g.c(yVarA);
            }
            j8 -= (long) (yVarA.f26333c - yVarA.f26332b);
            yVar = yVar.f26336f;
            j7 = 0;
        }
        return this;
    }

    public final void h2() {
        try {
            j0(this.f26255b);
        } catch (EOFException e8) {
            throw new AssertionError(e8);
        }
    }

    public int hashCode() {
        y yVar = this.f26254a;
        if (yVar == null) {
            return 0;
        }
        int i7 = 1;
        do {
            int i8 = yVar.f26333c;
            for (int i9 = yVar.f26332b; i9 < i8; i9++) {
                i7 = (i7 * 31) + yVar.f26331a[i9];
            }
            yVar = yVar.f26336f;
        } while (yVar != this.f26254a);
        return i7;
    }

    @Override // com.haier.library.a.h
    /* JADX INFO: renamed from: i1, reason: merged with bridge method [inline-methods] */
    public g T1(byte[] bArr, int i7, int i8) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j7 = i8;
        com.haier.library.a.c.d(bArr.length, i7, j7);
        int i9 = i8 + i7;
        while (i7 < i9) {
            y yVarZ1 = Z1(1);
            int iMin = Math.min(i9 - i7, 8192 - yVarZ1.f26333c);
            System.arraycopy(bArr, i7, yVarZ1.f26331a, yVarZ1.f26333c, iMin);
            i7 += iMin;
            yVarZ1.f26333c += iMin;
        }
        this.f26255b += j7;
        return this;
    }

    List<Integer> i2() {
        if (this.f26254a == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        y yVar = this.f26254a;
        arrayList.add(Integer.valueOf(yVar.f26333c - yVar.f26332b));
        y yVar2 = this.f26254a;
        while (true) {
            yVar2 = yVar2.f26336f;
            if (yVar2 == this.f26254a) {
                return arrayList;
            }
            arrayList.add(Integer.valueOf(yVar2.f26333c - yVar2.f26332b));
        }
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // com.haier.library.a.i
    public byte j() {
        long j7 = this.f26255b;
        if (j7 == 0) {
            throw new IllegalStateException("size == 0");
        }
        y yVar = this.f26254a;
        int i7 = yVar.f26332b;
        int i8 = yVar.f26333c;
        int i9 = i7 + 1;
        byte b8 = yVar.f26331a[i7];
        this.f26255b = j7 - 1;
        if (i9 == i8) {
            this.f26254a = yVar.f();
            z.b(yVar);
        } else {
            yVar.f26332b = i9;
        }
        return b8;
    }

    @Override // com.haier.library.a.i
    public void j0(long j7) throws EOFException {
        while (j7 > 0) {
            y yVar = this.f26254a;
            if (yVar == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j7, yVar.f26333c - yVar.f26332b);
            long j8 = iMin;
            this.f26255b -= j8;
            j7 -= j8;
            y yVar2 = this.f26254a;
            int i7 = yVar2.f26332b + iMin;
            yVar2.f26332b = i7;
            if (i7 == yVar2.f26333c) {
                this.f26254a = yVar2.f();
                z.b(yVar2);
            }
        }
    }

    @Override // com.haier.library.a.i
    public String j1(Charset charset) {
        try {
            return O(this.f26255b, charset);
        } catch (EOFException e8) {
            throw new AssertionError(e8);
        }
    }

    @Override // com.haier.library.a.i
    public short k() {
        long j7 = this.f26255b;
        if (j7 < 2) {
            throw new IllegalStateException("size < 2: " + this.f26255b);
        }
        y yVar = this.f26254a;
        int i7 = yVar.f26332b;
        int i8 = yVar.f26333c;
        if (i8 - i7 < 2) {
            return (short) (((j() & 255) << 8) | (j() & 255));
        }
        byte[] bArr = yVar.f26331a;
        int i9 = i7 + 1;
        int i10 = i9 + 1;
        int i11 = ((bArr[i7] & 255) << 8) | (bArr[i9] & 255);
        this.f26255b = j7 - 2;
        if (i10 == i8) {
            this.f26254a = yVar.f();
            z.b(yVar);
        } else {
            yVar.f26332b = i10;
        }
        return (short) i11;
    }

    @Override // com.haier.library.a.i
    @Nullable
    public String k0() throws EOFException {
        long jN0 = n0((byte) 10);
        if (jN0 != -1) {
            return a2(jN0);
        }
        long j7 = this.f26255b;
        if (j7 != 0) {
            return C1(j7);
        }
        return null;
    }

    @Override // com.haier.library.a.i
    public void k1(byte[] bArr) throws EOFException {
        int i7 = 0;
        while (i7 < bArr.length) {
            int iW0 = W0(bArr, i7, bArr.length - i7);
            if (iW0 == -1) {
                throw new EOFException();
            }
            i7 += iW0;
        }
    }

    @Override // com.haier.library.a.i
    public int l() {
        long j7 = this.f26255b;
        if (j7 < 4) {
            throw new IllegalStateException("size < 4: " + this.f26255b);
        }
        y yVar = this.f26254a;
        int i7 = yVar.f26332b;
        int i8 = yVar.f26333c;
        if (i8 - i7 < 4) {
            return ((j() & 255) << 24) | ((j() & 255) << 16) | ((j() & 255) << 8) | (j() & 255);
        }
        byte[] bArr = yVar.f26331a;
        int i9 = i7 + 1;
        int i10 = i9 + 1;
        int i11 = ((bArr[i7] & 255) << 24) | ((bArr[i9] & 255) << 16);
        int i12 = i10 + 1;
        int i13 = i11 | ((bArr[i10] & 255) << 8);
        int i14 = i12 + 1;
        int i15 = i13 | (bArr[i12] & 255);
        this.f26255b = j7 - 4;
        if (i14 == i8) {
            this.f26254a = yVar.f();
            z.b(yVar);
        } else {
            yVar.f26332b = i14;
        }
        return i15;
    }

    @Override // com.haier.library.a.h
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public g B(j jVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        jVar.q(this);
        return this;
    }

    @Override // com.haier.library.a.i
    public long m() {
        long j7 = this.f26255b;
        if (j7 < 8) {
            throw new IllegalStateException("size < 8: " + this.f26255b);
        }
        y yVar = this.f26254a;
        int i7 = yVar.f26332b;
        int i8 = yVar.f26333c;
        if (i8 - i7 < 8) {
            return ((((long) l()) & 4294967295L) << 32) | (4294967295L & ((long) l()));
        }
        byte[] bArr = yVar.f26331a;
        int i9 = i7 + 1;
        long j8 = (((long) bArr[i7]) & 255) << 56;
        int i10 = i9 + 1;
        long j9 = ((((long) bArr[i9]) & 255) << 48) | j8;
        int i11 = i10 + 1;
        long j10 = j9 | ((((long) bArr[i10]) & 255) << 40);
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        long j11 = j10 | ((((long) bArr[i11]) & 255) << 32) | ((((long) bArr[i12]) & 255) << 24);
        int i14 = i13 + 1;
        long j12 = j11 | ((((long) bArr[i13]) & 255) << 16);
        int i15 = i14 + 1;
        long j13 = j12 | ((((long) bArr[i14]) & 255) << 8);
        int i16 = i15 + 1;
        long j14 = j13 | (((long) bArr[i15]) & 255);
        this.f26255b = j7 - 8;
        if (i16 == i8) {
            this.f26254a = yVar.f();
            z.b(yVar);
        } else {
            yVar.f26332b = i16;
        }
        return j14;
    }

    @Override // com.haier.library.a.i
    public long n0(byte b8) {
        return U1(b8, 0L, Long.MAX_VALUE);
    }

    @Override // com.haier.library.a.i
    public byte[] n1() {
        try {
            return S(this.f26255b);
        } catch (EOFException e8) {
            throw new AssertionError(e8);
        }
    }

    public final g o0(InputStream inputStream) throws IOException {
        T0(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    public final j q() {
        return z1("SHA-1");
    }

    public final byte q1(long j7) {
        int i7;
        com.haier.library.a.c.d(this.f26255b, j7, 1L);
        long j8 = this.f26255b;
        if (j8 - j7 <= j7) {
            long j9 = j7 - j8;
            y yVar = this.f26254a;
            do {
                yVar = yVar.f26337g;
                int i8 = yVar.f26333c;
                i7 = yVar.f26332b;
                j9 += (long) (i8 - i7);
            } while (j9 < 0);
            return yVar.f26331a[i7 + ((int) j9)];
        }
        y yVar2 = this.f26254a;
        while (true) {
            int i9 = yVar2.f26333c;
            int i10 = yVar2.f26332b;
            long j10 = i9 - i10;
            if (j7 < j10) {
                return yVar2.f26331a[i10 + ((int) j7)];
            }
            j7 -= j10;
            yVar2 = yVar2.f26336f;
        }
    }

    public final j r() {
        return z1("SHA-256");
    }

    public final g r0(InputStream inputStream, long j7) throws IOException {
        if (j7 >= 0) {
            T0(inputStream, j7, false);
            return this;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j7);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        y yVar = this.f26254a;
        if (yVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), yVar.f26333c - yVar.f26332b);
        byteBuffer.put(yVar.f26331a, yVar.f26332b, iMin);
        int i7 = yVar.f26332b + iMin;
        yVar.f26332b = i7;
        this.f26255b -= (long) iMin;
        if (i7 == yVar.f26333c) {
            this.f26254a = yVar.f();
            z.b(yVar);
        }
        return iMin;
    }

    @Override // com.haier.library.a.i
    public j s() {
        return new j(n1());
    }

    public final g s0(OutputStream outputStream) throws IOException {
        return x0(outputStream, 0L, this.f26255b);
    }

    @Override // com.haier.library.a.h
    /* JADX INFO: renamed from: s1, reason: merged with bridge method [inline-methods] */
    public g l1(int i7) {
        y yVarZ1 = Z1(2);
        byte[] bArr = yVarZ1.f26331a;
        int i8 = yVarZ1.f26333c;
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((i7 >>> 8) & 255);
        bArr[i9] = (byte) (i7 & 255);
        yVarZ1.f26333c = i9 + 1;
        this.f26255b += 2;
        return this;
    }

    @Override // com.haier.library.a.i
    public long t() {
        int i7;
        int i8;
        if (this.f26255b == 0) {
            throw new IllegalStateException("size == 0");
        }
        int i9 = 0;
        boolean z7 = false;
        long j7 = 0;
        do {
            y yVar = this.f26254a;
            byte[] bArr = yVar.f26331a;
            int i10 = yVar.f26332b;
            int i11 = yVar.f26333c;
            while (i10 < i11) {
                byte b8 = bArr[i10];
                if (b8 < 48 || b8 > 57) {
                    if (b8 >= 97 && b8 <= 102) {
                        i7 = b8 - 97;
                    } else {
                        if (b8 < 65 || b8 > 70) {
                            if (i9 != 0) {
                                z7 = true;
                                break;
                            }
                            throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(b8));
                        }
                        i7 = b8 - 65;
                    }
                    i8 = i7 + 10;
                } else {
                    i8 = b8 - 48;
                }
                if (((-1152921504606846976L) & j7) != 0) {
                    throw new NumberFormatException("Number too large: " + new g().P1(j7).y1(b8).T());
                }
                j7 = (j7 << 4) | ((long) i8);
                i10++;
                i9++;
            }
            if (i10 == i11) {
                this.f26254a = yVar.f();
                z.b(yVar);
            } else {
                yVar.f26332b = i10;
            }
            if (z7) {
                break;
            }
        } while (this.f26254a != null);
        this.f26255b -= (long) i9;
        return j7;
    }

    @Override // com.haier.library.a.i
    public j t1(long j7) throws EOFException {
        return new j(S(j7));
    }

    public String toString() {
        return E().toString();
    }

    public final j u() {
        return z1("SHA-512");
    }

    @Override // com.haier.library.a.i
    public long u1() {
        return com.haier.library.a.c.b(m());
    }

    @Override // com.haier.library.a.i
    public String v() throws EOFException {
        return j(Long.MAX_VALUE);
    }

    public final g v0(OutputStream outputStream, long j7) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        com.haier.library.a.c.d(this.f26255b, 0L, j7);
        y yVar = this.f26254a;
        while (j7 > 0) {
            int iMin = (int) Math.min(j7, yVar.f26333c - yVar.f26332b);
            outputStream.write(yVar.f26331a, yVar.f26332b, iMin);
            int i7 = yVar.f26332b + iMin;
            yVar.f26332b = i7;
            long j8 = iMin;
            this.f26255b -= j8;
            j7 -= j8;
            if (i7 == yVar.f26333c) {
                y yVarF = yVar.f();
                this.f26254a = yVarF;
                z.b(yVar);
                yVar = yVarF;
            }
        }
        return this;
    }

    @Override // com.haier.library.a.i
    public boolean w0(long j7, j jVar, int i7, int i8) {
        if (j7 < 0 || i7 < 0 || i8 < 0 || this.f26255b - j7 < i8 || jVar.Z() - i7 < i8) {
            return false;
        }
        for (int i9 = 0; i9 < i8; i9++) {
            if (q1(((long) i9) + j7) != jVar.x(i7 + i9)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.haier.library.a.h
    /* JADX INFO: renamed from: w1, reason: merged with bridge method [inline-methods] */
    public g K1(byte[] bArr) {
        if (bArr != null) {
            return T1(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int iRemaining = byteBuffer.remaining();
        int i7 = iRemaining;
        while (i7 > 0) {
            y yVarZ1 = Z1(1);
            int iMin = Math.min(i7, 8192 - yVarZ1.f26333c);
            byteBuffer.get(yVarZ1.f26331a, yVarZ1.f26333c, iMin);
            i7 -= iMin;
            yVarZ1.f26333c += iMin;
        }
        this.f26255b += (long) iRemaining;
        return iRemaining;
    }

    public final g x0(OutputStream outputStream, long j7, long j8) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        com.haier.library.a.c.d(this.f26255b, j7, j8);
        if (j8 == 0) {
            return this;
        }
        y yVar = this.f26254a;
        while (true) {
            int i7 = yVar.f26333c;
            int i8 = yVar.f26332b;
            if (j7 < i7 - i8) {
                break;
            }
            j7 -= (long) (i7 - i8);
            yVar = yVar.f26336f;
        }
        while (j8 > 0) {
            int i9 = (int) (((long) yVar.f26332b) + j7);
            int iMin = (int) Math.min(yVar.f26333c - i9, j8);
            outputStream.write(yVar.f26331a, i9, iMin);
            j8 -= (long) iMin;
            yVar = yVar.f26336f;
            j7 = 0;
        }
        return this;
    }

    @Override // com.haier.library.a.i
    public void y0(g gVar, long j7) throws EOFException {
        long j8 = this.f26255b;
        if (j8 >= j7) {
            gVar.I1(this, j7);
        } else {
            gVar.I1(this, j8);
            throw new EOFException();
        }
    }

    @Override // com.haier.library.a.i
    public long a(j jVar) {
        return H0(jVar, 0L);
    }

    @Override // com.haier.library.a.i
    public long d(j jVar) throws IOException {
        return f1(jVar, 0L);
    }

    @Override // com.haier.library.a.i
    public short n() {
        return com.haier.library.a.c.c(k());
    }

    @Override // com.haier.library.a.b0
    public d0 a() {
        return d0.f26246d;
    }

    @Override // com.haier.library.a.i
    public boolean b(long j7) {
        return this.f26255b >= j7;
    }

    @Override // com.haier.library.a.i
    public String j(long j7) throws EOFException {
        if (j7 >= 0) {
            long j8 = j7 != Long.MAX_VALUE ? j7 + 1 : Long.MAX_VALUE;
            long jU1 = U1((byte) 10, 0L, j8);
            if (jU1 != -1) {
                return a2(jU1);
            }
            if (j8 < Y0() && q1(j8 - 1) == 13 && q1(j8) == 10) {
                return a2(j8);
            }
            g gVar = new g();
            h0(gVar, 0L, Math.min(32L, Y0()));
            throw new EOFException("\\n not found: limit=" + Math.min(Y0(), j7) + " content=" + gVar.s().W() + h0.F);
        }
        throw new IllegalArgumentException("limit < 0: " + j7);
    }
}
