package v5;

import com.haier.uhome.mesh.bridge.RtkCoreMeshWrapper;
import java.io.EOFException;
import java.io.IOException;
import kotlin.collections.o;
import kotlin.jvm.internal.l0;
import kotlin.text.h0;
import okio.d0;
import okio.i;
import okio.j;
import okio.j0;
import okio.k0;
import okio.m;
import okio.m0;
import okio.o0;
import okio.p;
import okio.r0;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private static final byte[] f40432a = i.a("0123456789abcdef");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f40433b = 4096;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f40434c = -922337203685477580L;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f40435d = -7;

    public static final short A(@a7.d m commonReadShort) throws EOFException {
        l0.p(commonReadShort, "$this$commonReadShort");
        if (commonReadShort.B1() < 2) {
            throw new EOFException();
        }
        j0 j0Var = commonReadShort.f38494a;
        l0.m(j0Var);
        int i7 = j0Var.f38469b;
        int i8 = j0Var.f38470c;
        if (i8 - i7 < 2) {
            return (short) ((commonReadShort.readByte() & 255) | ((commonReadShort.readByte() & 255) << 8));
        }
        byte[] bArr = j0Var.f38468a;
        int i9 = i7 + 1;
        int i10 = i9 + 1;
        int i11 = ((bArr[i7] & 255) << 8) | (bArr[i9] & 255);
        commonReadShort.s1(commonReadShort.B1() - 2);
        if (i10 == i8) {
            commonReadShort.f38494a = j0Var.b();
            k0.d(j0Var);
        } else {
            j0Var.f38469b = i10;
        }
        return (short) i11;
    }

    @a7.d
    public static final String B(@a7.d m commonReadUtf8, long j7) throws EOFException {
        l0.p(commonReadUtf8, "$this$commonReadUtf8");
        if (!(j7 >= 0 && j7 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j7).toString());
        }
        if (commonReadUtf8.B1() < j7) {
            throw new EOFException();
        }
        if (j7 == 0) {
            return "";
        }
        j0 j0Var = commonReadUtf8.f38494a;
        l0.m(j0Var);
        int i7 = j0Var.f38469b;
        if (((long) i7) + j7 > j0Var.f38470c) {
            return f.c(commonReadUtf8.h1(j7), 0, 0, 3, null);
        }
        int i8 = (int) j7;
        String strB = f.b(j0Var.f38468a, i7, i7 + i8);
        j0Var.f38469b += i8;
        commonReadUtf8.s1(commonReadUtf8.B1() - j7);
        if (j0Var.f38469b == j0Var.f38470c) {
            commonReadUtf8.f38494a = j0Var.b();
            k0.d(j0Var);
        }
        return strB;
    }

    public static final int C(@a7.d m commonReadUtf8CodePoint) throws EOFException {
        int i7;
        int i8;
        int i9;
        l0.p(commonReadUtf8CodePoint, "$this$commonReadUtf8CodePoint");
        if (commonReadUtf8CodePoint.B1() == 0) {
            throw new EOFException();
        }
        byte bV0 = commonReadUtf8CodePoint.v0(0L);
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
                commonReadUtf8CodePoint.skip(1L);
                return r0.f38530c;
            }
            i7 = bV0 & 7;
            i8 = 4;
            i9 = 65536;
        }
        long j7 = i8;
        if (commonReadUtf8CodePoint.B1() < j7) {
            throw new EOFException("size < " + i8 + ": " + commonReadUtf8CodePoint.B1() + " (to read code point prefixed 0x" + j.m(bV0) + ')');
        }
        for (int i10 = 1; i10 < i8; i10++) {
            long j8 = i10;
            byte bV1 = commonReadUtf8CodePoint.v0(j8);
            if ((bV1 & 192) != 128) {
                commonReadUtf8CodePoint.skip(j8);
                return r0.f38530c;
            }
            i7 = (i7 << 6) | (bV1 & r0.f38528a);
        }
        commonReadUtf8CodePoint.skip(j7);
        if (i7 > 1114111) {
            return r0.f38530c;
        }
        return ((55296 <= i7 && 57343 >= i7) || i7 < i9) ? r0.f38530c : i7;
    }

    @a7.e
    public static final String D(@a7.d m commonReadUtf8Line) {
        l0.p(commonReadUtf8Line, "$this$commonReadUtf8Line");
        long jM1 = commonReadUtf8Line.M1((byte) 10);
        if (jM1 != -1) {
            return b0(commonReadUtf8Line, jM1);
        }
        if (commonReadUtf8Line.B1() != 0) {
            return commonReadUtf8Line.h(commonReadUtf8Line.B1());
        }
        return null;
    }

    @a7.d
    public static final String E(@a7.d m commonReadUtf8LineStrict, long j7) throws EOFException {
        l0.p(commonReadUtf8LineStrict, "$this$commonReadUtf8LineStrict");
        if (!(j7 >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j7).toString());
        }
        long j8 = j7 != Long.MAX_VALUE ? j7 + 1 : Long.MAX_VALUE;
        byte b8 = (byte) 10;
        long jY = commonReadUtf8LineStrict.Y(b8, 0L, j8);
        if (jY != -1) {
            return b0(commonReadUtf8LineStrict, jY);
        }
        if (j8 < commonReadUtf8LineStrict.B1() && commonReadUtf8LineStrict.v0(j8 - 1) == ((byte) 13) && commonReadUtf8LineStrict.v0(j8) == b8) {
            return b0(commonReadUtf8LineStrict, j8);
        }
        m mVar = new m();
        commonReadUtf8LineStrict.Q(mVar, 0L, Math.min(32, commonReadUtf8LineStrict.B1()));
        throw new EOFException("\\n not found: limit=" + Math.min(commonReadUtf8LineStrict.B1(), j7) + " content=" + mVar.E0().t() + h0.F);
    }

    public static final int F(@a7.d m commonSelect, @a7.d d0 options) throws EOFException {
        l0.p(commonSelect, "$this$commonSelect");
        l0.p(options, "options");
        int iE0 = e0(commonSelect, options, false, 2, null);
        if (iE0 == -1) {
            return -1;
        }
        commonSelect.skip(options.f()[iE0].a0());
        return iE0;
    }

    public static final void G(@a7.d m commonSkip, long j7) throws EOFException {
        l0.p(commonSkip, "$this$commonSkip");
        while (j7 > 0) {
            j0 j0Var = commonSkip.f38494a;
            if (j0Var == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j7, j0Var.f38470c - j0Var.f38469b);
            long j8 = iMin;
            commonSkip.s1(commonSkip.B1() - j8);
            j7 -= j8;
            int i7 = j0Var.f38469b + iMin;
            j0Var.f38469b = i7;
            if (i7 == j0Var.f38470c) {
                commonSkip.f38494a = j0Var.b();
                k0.d(j0Var);
            }
        }
    }

    @a7.d
    public static final p H(@a7.d m commonSnapshot) {
        l0.p(commonSnapshot, "$this$commonSnapshot");
        if (commonSnapshot.B1() <= ((long) Integer.MAX_VALUE)) {
            return commonSnapshot.R1((int) commonSnapshot.B1());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + commonSnapshot.B1()).toString());
    }

    @a7.d
    public static final p I(@a7.d m commonSnapshot, int i7) {
        l0.p(commonSnapshot, "$this$commonSnapshot");
        if (i7 == 0) {
            return p.f38507e;
        }
        j.e(commonSnapshot.B1(), 0L, i7);
        j0 j0Var = commonSnapshot.f38494a;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i9 < i7) {
            l0.m(j0Var);
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
        j0 j0Var2 = commonSnapshot.f38494a;
        int i13 = 0;
        while (i8 < i7) {
            l0.m(j0Var2);
            bArr[i13] = j0Var2.f38468a;
            i8 += j0Var2.f38470c - j0Var2.f38469b;
            iArr[i13] = Math.min(i8, i7);
            iArr[i13 + i10] = j0Var2.f38469b;
            j0Var2.f38471d = true;
            i13++;
            j0Var2 = j0Var2.f38473f;
        }
        return new okio.l0(bArr, iArr);
    }

    @a7.d
    public static final j0 J(@a7.d m commonWritableSegment, int i7) {
        l0.p(commonWritableSegment, "$this$commonWritableSegment");
        if (!(i7 >= 1 && i7 <= 8192)) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        j0 j0Var = commonWritableSegment.f38494a;
        if (j0Var != null) {
            l0.m(j0Var);
            j0 j0Var2 = j0Var.f38474g;
            l0.m(j0Var2);
            return (j0Var2.f38470c + i7 > 8192 || !j0Var2.f38472e) ? j0Var2.c(k0.e()) : j0Var2;
        }
        j0 j0VarE = k0.e();
        commonWritableSegment.f38494a = j0VarE;
        j0VarE.f38474g = j0VarE;
        j0VarE.f38473f = j0VarE;
        return j0VarE;
    }

    @a7.d
    public static final m K(@a7.d m commonWrite, @a7.d p byteString, int i7, int i8) {
        l0.p(commonWrite, "$this$commonWrite");
        l0.p(byteString, "byteString");
        byteString.n0(commonWrite, i7, i8);
        return commonWrite;
    }

    @a7.d
    public static final m L(@a7.d m commonWrite, @a7.d o0 source, long j7) throws IOException {
        l0.p(commonWrite, "$this$commonWrite");
        l0.p(source, "source");
        while (j7 > 0) {
            long j8 = source.read(commonWrite, j7);
            if (j8 == -1) {
                throw new EOFException();
            }
            j7 -= j8;
        }
        return commonWrite;
    }

    @a7.d
    public static final m M(@a7.d m commonWrite, @a7.d byte[] source) {
        l0.p(commonWrite, "$this$commonWrite");
        l0.p(source, "source");
        return commonWrite.write(source, 0, source.length);
    }

    @a7.d
    public static final m N(@a7.d m commonWrite, @a7.d byte[] source, int i7, int i8) {
        l0.p(commonWrite, "$this$commonWrite");
        l0.p(source, "source");
        long j7 = i8;
        j.e(source.length, i7, j7);
        int i9 = i8 + i7;
        while (i7 < i9) {
            j0 j0VarW1 = commonWrite.W1(1);
            int iMin = Math.min(i9 - i7, 8192 - j0VarW1.f38470c);
            int i10 = i7 + iMin;
            o.W0(source, j0VarW1.f38468a, j0VarW1.f38470c, i7, i10);
            j0VarW1.f38470c += iMin;
            i7 = i10;
        }
        commonWrite.s1(commonWrite.B1() + j7);
        return commonWrite;
    }

    public static final void O(@a7.d m commonWrite, @a7.d m source, long j7) {
        j0 j0Var;
        l0.p(commonWrite, "$this$commonWrite");
        l0.p(source, "source");
        if (!(source != commonWrite)) {
            throw new IllegalArgumentException("source == this".toString());
        }
        j.e(source.B1(), 0L, j7);
        while (j7 > 0) {
            j0 j0Var2 = source.f38494a;
            l0.m(j0Var2);
            int i7 = j0Var2.f38470c;
            j0 j0Var3 = source.f38494a;
            l0.m(j0Var3);
            if (j7 < i7 - j0Var3.f38469b) {
                j0 j0Var4 = commonWrite.f38494a;
                if (j0Var4 != null) {
                    l0.m(j0Var4);
                    j0Var = j0Var4.f38474g;
                } else {
                    j0Var = null;
                }
                if (j0Var != null && j0Var.f38472e) {
                    if ((((long) j0Var.f38470c) + j7) - ((long) (j0Var.f38471d ? 0 : j0Var.f38469b)) <= 8192) {
                        j0 j0Var5 = source.f38494a;
                        l0.m(j0Var5);
                        j0Var5.g(j0Var, (int) j7);
                        source.s1(source.B1() - j7);
                        commonWrite.s1(commonWrite.B1() + j7);
                        return;
                    }
                }
                j0 j0Var6 = source.f38494a;
                l0.m(j0Var6);
                source.f38494a = j0Var6.e((int) j7);
            }
            j0 j0Var7 = source.f38494a;
            l0.m(j0Var7);
            long j8 = j0Var7.f38470c - j0Var7.f38469b;
            source.f38494a = j0Var7.b();
            j0 j0Var8 = commonWrite.f38494a;
            if (j0Var8 == null) {
                commonWrite.f38494a = j0Var7;
                j0Var7.f38474g = j0Var7;
                j0Var7.f38473f = j0Var7;
            } else {
                l0.m(j0Var8);
                j0 j0Var9 = j0Var8.f38474g;
                l0.m(j0Var9);
                j0Var9.c(j0Var7).a();
            }
            source.s1(source.B1() - j8);
            commonWrite.s1(commonWrite.B1() + j8);
            j7 -= j8;
        }
    }

    public static /* synthetic */ m P(m commonWrite, p byteString, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = byteString.a0();
        }
        l0.p(commonWrite, "$this$commonWrite");
        l0.p(byteString, "byteString");
        byteString.n0(commonWrite, i7, i8);
        return commonWrite;
    }

    public static final long Q(@a7.d m commonWriteAll, @a7.d o0 source) throws IOException {
        l0.p(commonWriteAll, "$this$commonWriteAll");
        l0.p(source, "source");
        long j7 = 0;
        while (true) {
            long j8 = source.read(commonWriteAll, 8192);
            if (j8 == -1) {
                return j7;
            }
            j7 += j8;
        }
    }

    @a7.d
    public static final m R(@a7.d m commonWriteByte, int i7) {
        l0.p(commonWriteByte, "$this$commonWriteByte");
        j0 j0VarW1 = commonWriteByte.W1(1);
        byte[] bArr = j0VarW1.f38468a;
        int i8 = j0VarW1.f38470c;
        j0VarW1.f38470c = i8 + 1;
        bArr[i8] = (byte) i7;
        commonWriteByte.s1(commonWriteByte.B1() + 1);
        return commonWriteByte;
    }

    @a7.d
    public static final m S(@a7.d m commonWriteDecimalLong, long j7) {
        boolean z7;
        l0.p(commonWriteDecimalLong, "$this$commonWriteDecimalLong");
        if (j7 == 0) {
            return commonWriteDecimalLong.writeByte(48);
        }
        int i7 = 1;
        if (j7 < 0) {
            j7 = -j7;
            if (j7 < 0) {
                return commonWriteDecimalLong.q0("-9223372036854775808");
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
        j0 j0VarW1 = commonWriteDecimalLong.W1(i7);
        byte[] bArr = j0VarW1.f38468a;
        int i8 = j0VarW1.f38470c + i7;
        while (j7 != 0) {
            long j8 = 10;
            i8--;
            bArr[i8] = Z()[(int) (j7 % j8)];
            j7 /= j8;
        }
        if (z7) {
            bArr[i8 - 1] = (byte) 45;
        }
        j0VarW1.f38470c += i7;
        commonWriteDecimalLong.s1(commonWriteDecimalLong.B1() + ((long) i7));
        return commonWriteDecimalLong;
    }

    @a7.d
    public static final m T(@a7.d m commonWriteHexadecimalUnsignedLong, long j7) {
        l0.p(commonWriteHexadecimalUnsignedLong, "$this$commonWriteHexadecimalUnsignedLong");
        if (j7 == 0) {
            return commonWriteHexadecimalUnsignedLong.writeByte(48);
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
        j0 j0VarW1 = commonWriteHexadecimalUnsignedLong.W1(i7);
        byte[] bArr = j0VarW1.f38468a;
        int i8 = j0VarW1.f38470c;
        for (int i9 = (i8 + i7) - 1; i9 >= i8; i9--) {
            bArr[i9] = Z()[(int) (15 & j7)];
            j7 >>>= 4;
        }
        j0VarW1.f38470c += i7;
        commonWriteHexadecimalUnsignedLong.s1(commonWriteHexadecimalUnsignedLong.B1() + ((long) i7));
        return commonWriteHexadecimalUnsignedLong;
    }

    @a7.d
    public static final m U(@a7.d m commonWriteInt, int i7) {
        l0.p(commonWriteInt, "$this$commonWriteInt");
        j0 j0VarW1 = commonWriteInt.W1(4);
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
        commonWriteInt.s1(commonWriteInt.B1() + 4);
        return commonWriteInt;
    }

    @a7.d
    public static final m V(@a7.d m commonWriteLong, long j7) {
        l0.p(commonWriteLong, "$this$commonWriteLong");
        j0 j0VarW1 = commonWriteLong.W1(8);
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
        commonWriteLong.s1(commonWriteLong.B1() + 8);
        return commonWriteLong;
    }

    @a7.d
    public static final m W(@a7.d m commonWriteShort, int i7) {
        l0.p(commonWriteShort, "$this$commonWriteShort");
        j0 j0VarW1 = commonWriteShort.W1(2);
        byte[] bArr = j0VarW1.f38468a;
        int i8 = j0VarW1.f38470c;
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((i7 >>> 8) & 255);
        bArr[i9] = (byte) (i7 & 255);
        j0VarW1.f38470c = i9 + 1;
        commonWriteShort.s1(commonWriteShort.B1() + 2);
        return commonWriteShort;
    }

    @a7.d
    public static final m X(@a7.d m commonWriteUtf8, @a7.d String string, int i7, int i8) {
        l0.p(commonWriteUtf8, "$this$commonWriteUtf8");
        l0.p(string, "string");
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
                j0 j0VarW1 = commonWriteUtf8.W1(1);
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
                commonWriteUtf8.s1(commonWriteUtf8.B1() + ((long) i12));
                i7 = i10;
            } else {
                if (cCharAt < 2048) {
                    j0 j0VarW2 = commonWriteUtf8.W1(2);
                    byte[] bArr2 = j0VarW2.f38468a;
                    int i13 = j0VarW2.f38470c;
                    bArr2[i13] = (byte) ((cCharAt >> 6) | com.alibaba.fastjson.asm.j.f12606c0);
                    bArr2[i13 + 1] = (byte) ((cCharAt & '?') | 128);
                    j0VarW2.f38470c = i13 + 2;
                    commonWriteUtf8.s1(commonWriteUtf8.B1() + 2);
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    j0 j0VarW3 = commonWriteUtf8.W1(3);
                    byte[] bArr3 = j0VarW3.f38468a;
                    int i14 = j0VarW3.f38470c;
                    bArr3[i14] = (byte) ((cCharAt >> '\f') | 224);
                    bArr3[i14 + 1] = (byte) ((63 & (cCharAt >> 6)) | 128);
                    bArr3[i14 + 2] = (byte) ((cCharAt & '?') | 128);
                    j0VarW3.f38470c = i14 + 3;
                    commonWriteUtf8.s1(commonWriteUtf8.B1() + 3);
                } else {
                    int i15 = i7 + 1;
                    char cCharAt3 = i15 < i8 ? string.charAt(i15) : (char) 0;
                    if (cCharAt > 56319 || 56320 > cCharAt3 || 57343 < cCharAt3) {
                        commonWriteUtf8.writeByte(63);
                        i7 = i15;
                    } else {
                        int i16 = (((cCharAt & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        j0 j0VarW4 = commonWriteUtf8.W1(4);
                        byte[] bArr4 = j0VarW4.f38468a;
                        int i17 = j0VarW4.f38470c;
                        bArr4[i17] = (byte) ((i16 >> 18) | 240);
                        bArr4[i17 + 1] = (byte) (((i16 >> 12) & 63) | 128);
                        bArr4[i17 + 2] = (byte) (((i16 >> 6) & 63) | 128);
                        bArr4[i17 + 3] = (byte) ((i16 & 63) | 128);
                        j0VarW4.f38470c = i17 + 4;
                        commonWriteUtf8.s1(commonWriteUtf8.B1() + 4);
                        i7 += 2;
                    }
                }
                i7++;
            }
        }
        return commonWriteUtf8;
    }

    @a7.d
    public static final m Y(@a7.d m commonWriteUtf8CodePoint, int i7) {
        l0.p(commonWriteUtf8CodePoint, "$this$commonWriteUtf8CodePoint");
        if (i7 < 128) {
            commonWriteUtf8CodePoint.writeByte(i7);
        } else if (i7 < 2048) {
            j0 j0VarW1 = commonWriteUtf8CodePoint.W1(2);
            byte[] bArr = j0VarW1.f38468a;
            int i8 = j0VarW1.f38470c;
            bArr[i8] = (byte) ((i7 >> 6) | com.alibaba.fastjson.asm.j.f12606c0);
            bArr[i8 + 1] = (byte) ((i7 & 63) | 128);
            j0VarW1.f38470c = i8 + 2;
            commonWriteUtf8CodePoint.s1(commonWriteUtf8CodePoint.B1() + 2);
        } else if (55296 <= i7 && 57343 >= i7) {
            commonWriteUtf8CodePoint.writeByte(63);
        } else if (i7 < 65536) {
            j0 j0VarW2 = commonWriteUtf8CodePoint.W1(3);
            byte[] bArr2 = j0VarW2.f38468a;
            int i9 = j0VarW2.f38470c;
            bArr2[i9] = (byte) ((i7 >> 12) | 224);
            bArr2[i9 + 1] = (byte) (((i7 >> 6) & 63) | 128);
            bArr2[i9 + 2] = (byte) ((i7 & 63) | 128);
            j0VarW2.f38470c = i9 + 3;
            commonWriteUtf8CodePoint.s1(commonWriteUtf8CodePoint.B1() + 3);
        } else {
            if (i7 > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: 0x" + j.n(i7));
            }
            j0 j0VarW3 = commonWriteUtf8CodePoint.W1(4);
            byte[] bArr3 = j0VarW3.f38468a;
            int i10 = j0VarW3.f38470c;
            bArr3[i10] = (byte) ((i7 >> 18) | 240);
            bArr3[i10 + 1] = (byte) (((i7 >> 12) & 63) | 128);
            bArr3[i10 + 2] = (byte) (((i7 >> 6) & 63) | 128);
            bArr3[i10 + 3] = (byte) ((i7 & 63) | 128);
            j0VarW3.f38470c = i10 + 4;
            commonWriteUtf8CodePoint.s1(commonWriteUtf8CodePoint.B1() + 4);
        }
        return commonWriteUtf8CodePoint;
    }

    @a7.d
    public static final byte[] Z() {
        return f40432a;
    }

    public static final void a(@a7.d m commonClear) throws EOFException {
        l0.p(commonClear, "$this$commonClear");
        commonClear.skip(commonClear.B1());
    }

    public static final boolean a0(@a7.d j0 segment, int i7, @a7.d byte[] bytes, int i8, int i9) {
        l0.p(segment, "segment");
        l0.p(bytes, "bytes");
        int i10 = segment.f38470c;
        byte[] bArr = segment.f38468a;
        while (i8 < i9) {
            if (i7 == i10) {
                segment = segment.f38473f;
                l0.m(segment);
                byte[] bArr2 = segment.f38468a;
                bArr = bArr2;
                i7 = segment.f38469b;
                i10 = segment.f38470c;
            }
            if (bArr[i7] != bytes[i8]) {
                return false;
            }
            i7++;
            i8++;
        }
        return true;
    }

    public static final long b(@a7.d m commonCompleteSegmentByteCount) {
        l0.p(commonCompleteSegmentByteCount, "$this$commonCompleteSegmentByteCount");
        long jB1 = commonCompleteSegmentByteCount.B1();
        if (jB1 == 0) {
            return 0L;
        }
        j0 j0Var = commonCompleteSegmentByteCount.f38494a;
        l0.m(j0Var);
        j0 j0Var2 = j0Var.f38474g;
        l0.m(j0Var2);
        int i7 = j0Var2.f38470c;
        return (i7 >= 8192 || !j0Var2.f38472e) ? jB1 : jB1 - ((long) (i7 - j0Var2.f38469b));
    }

    @a7.d
    public static final String b0(@a7.d m readUtf8Line, long j7) throws EOFException {
        l0.p(readUtf8Line, "$this$readUtf8Line");
        if (j7 > 0) {
            long j8 = j7 - 1;
            if (readUtf8Line.v0(j8) == ((byte) 13)) {
                String strH = readUtf8Line.h(j8);
                readUtf8Line.skip(2L);
                return strH;
            }
        }
        String strH2 = readUtf8Line.h(j7);
        readUtf8Line.skip(1L);
        return strH2;
    }

    @a7.d
    public static final m c(@a7.d m commonCopy) {
        l0.p(commonCopy, "$this$commonCopy");
        m mVar = new m();
        if (commonCopy.B1() == 0) {
            return mVar;
        }
        j0 j0Var = commonCopy.f38494a;
        l0.m(j0Var);
        j0 j0VarD = j0Var.d();
        mVar.f38494a = j0VarD;
        j0VarD.f38474g = j0VarD;
        j0VarD.f38473f = j0VarD;
        for (j0 j0Var2 = j0Var.f38473f; j0Var2 != j0Var; j0Var2 = j0Var2.f38473f) {
            j0 j0Var3 = j0VarD.f38474g;
            l0.m(j0Var3);
            l0.m(j0Var2);
            j0Var3.c(j0Var2.d());
        }
        mVar.s1(commonCopy.B1());
        return mVar;
    }

    public static final <T> T c0(@a7.d m seek, long j7, @a7.d i5.p<? super j0, ? super Long, ? extends T> lambda) {
        l0.p(seek, "$this$seek");
        l0.p(lambda, "lambda");
        j0 j0Var = seek.f38494a;
        if (j0Var == null) {
            return lambda.a0(null, -1L);
        }
        if (seek.B1() - j7 < j7) {
            long jB1 = seek.B1();
            while (jB1 > j7) {
                j0Var = j0Var.f38474g;
                l0.m(j0Var);
                jB1 -= (long) (j0Var.f38470c - j0Var.f38469b);
            }
            return lambda.a0(j0Var, Long.valueOf(jB1));
        }
        long j8 = 0;
        while (true) {
            long j9 = ((long) (j0Var.f38470c - j0Var.f38469b)) + j8;
            if (j9 > j7) {
                return lambda.a0(j0Var, Long.valueOf(j8));
            }
            j0Var = j0Var.f38473f;
            l0.m(j0Var);
            j8 = j9;
        }
    }

    @a7.d
    public static final m d(@a7.d m commonCopyTo, @a7.d m out, long j7, long j8) {
        l0.p(commonCopyTo, "$this$commonCopyTo");
        l0.p(out, "out");
        j.e(commonCopyTo.B1(), j7, j8);
        if (j8 == 0) {
            return commonCopyTo;
        }
        out.s1(out.B1() + j8);
        j0 j0Var = commonCopyTo.f38494a;
        while (true) {
            l0.m(j0Var);
            int i7 = j0Var.f38470c;
            int i8 = j0Var.f38469b;
            if (j7 < i7 - i8) {
                break;
            }
            j7 -= (long) (i7 - i8);
            j0Var = j0Var.f38473f;
        }
        while (j8 > 0) {
            l0.m(j0Var);
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
                l0.m(j0Var2);
                j0 j0Var3 = j0Var2.f38474g;
                l0.m(j0Var3);
                j0Var3.c(j0VarD);
            }
            j8 -= (long) (j0VarD.f38470c - j0VarD.f38469b);
            j0Var = j0Var.f38473f;
            j7 = 0;
        }
        return commonCopyTo;
    }

    public static final int d0(@a7.d m selectPrefix, @a7.d d0 options, boolean z7) {
        int i7;
        int i8;
        int i9;
        int i10;
        j0 j0Var;
        l0.p(selectPrefix, "$this$selectPrefix");
        l0.p(options, "options");
        j0 j0Var2 = selectPrefix.f38494a;
        if (j0Var2 == null) {
            return z7 ? -2 : -1;
        }
        byte[] bArr = j0Var2.f38468a;
        int i11 = j0Var2.f38469b;
        int i12 = j0Var2.f38470c;
        int[] iArrG = options.g();
        j0 j0Var3 = j0Var2;
        int i13 = -1;
        int i14 = 0;
        loop0: while (true) {
            int i15 = i14 + 1;
            int i16 = iArrG[i14];
            int i17 = i15 + 1;
            int i18 = iArrG[i15];
            if (i18 != -1) {
                i13 = i18;
            }
            if (j0Var3 == null) {
                break;
            }
            if (i16 >= 0) {
                i7 = i11 + 1;
                int i19 = bArr[i11] & 255;
                int i20 = i17 + i16;
                while (i17 != i20) {
                    if (i19 == iArrG[i17]) {
                        i8 = iArrG[i17 + i16];
                        if (i7 == i12) {
                            j0Var3 = j0Var3.f38473f;
                            l0.m(j0Var3);
                            i7 = j0Var3.f38469b;
                            bArr = j0Var3.f38468a;
                            i12 = j0Var3.f38470c;
                            if (j0Var3 == j0Var2) {
                                j0Var3 = null;
                            }
                        }
                    } else {
                        i17++;
                    }
                }
                return i13;
            }
            int i21 = i17 + (i16 * (-1));
            while (true) {
                int i22 = i11 + 1;
                int i23 = i17 + 1;
                if ((bArr[i11] & 255) != iArrG[i17]) {
                    return i13;
                }
                boolean z8 = i23 == i21;
                if (i22 == i12) {
                    l0.m(j0Var3);
                    j0 j0Var4 = j0Var3.f38473f;
                    l0.m(j0Var4);
                    i10 = j0Var4.f38469b;
                    byte[] bArr2 = j0Var4.f38468a;
                    i9 = j0Var4.f38470c;
                    if (j0Var4 != j0Var2) {
                        j0Var = j0Var4;
                        bArr = bArr2;
                    } else {
                        if (!z8) {
                            break loop0;
                        }
                        bArr = bArr2;
                        j0Var = null;
                    }
                } else {
                    j0 j0Var5 = j0Var3;
                    i9 = i12;
                    i10 = i22;
                    j0Var = j0Var5;
                }
                if (z8) {
                    i8 = iArrG[i23];
                    i7 = i10;
                    i12 = i9;
                    j0Var3 = j0Var;
                    break;
                }
                i11 = i10;
                i12 = i9;
                i17 = i23;
                j0Var3 = j0Var;
            }
            if (i8 >= 0) {
                return i8;
            }
            i14 = -i8;
            i11 = i7;
        }
        if (z7) {
            return -2;
        }
        return i13;
    }

    public static final boolean e(@a7.d m commonEquals, @a7.e Object obj) {
        l0.p(commonEquals, "$this$commonEquals");
        if (commonEquals == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (commonEquals.B1() != mVar.B1()) {
            return false;
        }
        if (commonEquals.B1() == 0) {
            return true;
        }
        j0 j0Var = commonEquals.f38494a;
        l0.m(j0Var);
        j0 j0Var2 = mVar.f38494a;
        l0.m(j0Var2);
        int i7 = j0Var.f38469b;
        int i8 = j0Var2.f38469b;
        long j7 = 0;
        while (j7 < commonEquals.B1()) {
            long jMin = Math.min(j0Var.f38470c - i7, j0Var2.f38470c - i8);
            long j8 = 0;
            while (j8 < jMin) {
                int i9 = i7 + 1;
                int i10 = i8 + 1;
                if (j0Var.f38468a[i7] != j0Var2.f38468a[i8]) {
                    return false;
                }
                j8++;
                i7 = i9;
                i8 = i10;
            }
            if (i7 == j0Var.f38470c) {
                j0Var = j0Var.f38473f;
                l0.m(j0Var);
                i7 = j0Var.f38469b;
            }
            if (i8 == j0Var2.f38470c) {
                j0Var2 = j0Var2.f38473f;
                l0.m(j0Var2);
                i8 = j0Var2.f38469b;
            }
            j7 += jMin;
        }
        return true;
    }

    public static /* synthetic */ int e0(m mVar, d0 d0Var, boolean z7, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        return d0(mVar, d0Var, z7);
    }

    public static final byte f(@a7.d m commonGet, long j7) {
        l0.p(commonGet, "$this$commonGet");
        j.e(commonGet.B1(), j7, 1L);
        j0 j0Var = commonGet.f38494a;
        if (j0Var == null) {
            l0.m(null);
            throw null;
        }
        if (commonGet.B1() - j7 < j7) {
            long jB1 = commonGet.B1();
            while (jB1 > j7) {
                j0Var = j0Var.f38474g;
                l0.m(j0Var);
                jB1 -= (long) (j0Var.f38470c - j0Var.f38469b);
            }
            l0.m(j0Var);
            return j0Var.f38468a[(int) ((((long) j0Var.f38469b) + j7) - jB1)];
        }
        long j8 = 0;
        while (true) {
            long j9 = ((long) (j0Var.f38470c - j0Var.f38469b)) + j8;
            if (j9 > j7) {
                l0.m(j0Var);
                return j0Var.f38468a[(int) ((((long) j0Var.f38469b) + j7) - j8)];
            }
            j0Var = j0Var.f38473f;
            l0.m(j0Var);
            j8 = j9;
        }
    }

    public static final int g(@a7.d m commonHashCode) {
        l0.p(commonHashCode, "$this$commonHashCode");
        j0 j0Var = commonHashCode.f38494a;
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
            l0.m(j0Var);
        } while (j0Var != commonHashCode.f38494a);
        return i7;
    }

    public static final long h(@a7.d m commonIndexOf, byte b8, long j7, long j8) {
        j0 j0Var;
        int i7;
        l0.p(commonIndexOf, "$this$commonIndexOf");
        long jB1 = 0;
        if (!(0 <= j7 && j8 >= j7)) {
            throw new IllegalArgumentException(("size=" + commonIndexOf.B1() + " fromIndex=" + j7 + " toIndex=" + j8).toString());
        }
        if (j8 > commonIndexOf.B1()) {
            j8 = commonIndexOf.B1();
        }
        if (j7 == j8 || (j0Var = commonIndexOf.f38494a) == null) {
            return -1L;
        }
        if (commonIndexOf.B1() - j7 < j7) {
            jB1 = commonIndexOf.B1();
            while (jB1 > j7) {
                j0Var = j0Var.f38474g;
                l0.m(j0Var);
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
                l0.m(j0Var);
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
            l0.m(j0Var);
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
            l0.m(j0Var);
            j7 = jB1;
        }
        return -1L;
        return ((long) (i7 - j0Var.f38469b)) + jB1;
    }

    public static final long i(@a7.d m commonIndexOf, @a7.d p bytes, long j7) {
        long j8 = j7;
        l0.p(commonIndexOf, "$this$commonIndexOf");
        l0.p(bytes, "bytes");
        boolean z7 = true;
        if (!(bytes.a0() > 0)) {
            throw new IllegalArgumentException("bytes is empty".toString());
        }
        long j9 = 0;
        if (!(j8 >= 0)) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j8).toString());
        }
        j0 j0Var = commonIndexOf.f38494a;
        if (j0Var == null) {
            return -1L;
        }
        if (commonIndexOf.B1() - j8 < j8) {
            long jB1 = commonIndexOf.B1();
            while (jB1 > j8) {
                j0Var = j0Var.f38474g;
                l0.m(j0Var);
                jB1 -= (long) (j0Var.f38470c - j0Var.f38469b);
            }
            byte[] bArrE = bytes.E();
            byte b8 = bArrE[0];
            int iA0 = bytes.a0();
            long jB2 = (commonIndexOf.B1() - ((long) iA0)) + 1;
            while (jB1 < jB2) {
                byte[] bArr = j0Var.f38468a;
                int iMin = (int) Math.min(j0Var.f38470c, (((long) j0Var.f38469b) + jB2) - jB1);
                for (int i7 = (int) ((((long) j0Var.f38469b) + j8) - jB1); i7 < iMin; i7++) {
                    if (bArr[i7] == b8 && a0(j0Var, i7 + 1, bArrE, 1, iA0)) {
                        return ((long) (i7 - j0Var.f38469b)) + jB1;
                    }
                }
                jB1 += (long) (j0Var.f38470c - j0Var.f38469b);
                j0Var = j0Var.f38473f;
                l0.m(j0Var);
                j8 = jB1;
            }
            return -1L;
        }
        while (true) {
            long j10 = ((long) (j0Var.f38470c - j0Var.f38469b)) + j9;
            if (j10 > j8) {
                break;
            }
            j0Var = j0Var.f38473f;
            l0.m(j0Var);
            j9 = j10;
            z7 = z7;
        }
        byte[] bArrE2 = bytes.E();
        byte b9 = bArrE2[0];
        int iA1 = bytes.a0();
        long jB3 = (commonIndexOf.B1() - ((long) iA1)) + 1;
        while (j9 < jB3) {
            byte[] bArr2 = j0Var.f38468a;
            long j11 = j9;
            int iMin2 = (int) Math.min(j0Var.f38470c, (((long) j0Var.f38469b) + jB3) - j9);
            for (int i8 = (int) ((((long) j0Var.f38469b) + j8) - j11); i8 < iMin2; i8++) {
                if (bArr2[i8] == b9 && a0(j0Var, i8 + 1, bArrE2, 1, iA1)) {
                    return ((long) (i8 - j0Var.f38469b)) + j11;
                }
            }
            j9 = j11 + ((long) (j0Var.f38470c - j0Var.f38469b));
            j0Var = j0Var.f38473f;
            l0.m(j0Var);
            j8 = j9;
        }
        return -1L;
    }

    public static final long j(@a7.d m commonIndexOfElement, @a7.d p targetBytes, long j7) {
        int i7;
        int i8;
        l0.p(commonIndexOfElement, "$this$commonIndexOfElement");
        l0.p(targetBytes, "targetBytes");
        long jB1 = 0;
        if (!(j7 >= 0)) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j7).toString());
        }
        j0 j0Var = commonIndexOfElement.f38494a;
        if (j0Var == null) {
            return -1L;
        }
        if (commonIndexOfElement.B1() - j7 < j7) {
            jB1 = commonIndexOfElement.B1();
            while (jB1 > j7) {
                j0Var = j0Var.f38474g;
                l0.m(j0Var);
                jB1 -= (long) (j0Var.f38470c - j0Var.f38469b);
            }
            if (targetBytes.a0() == 2) {
                byte bN = targetBytes.n(0);
                byte bN2 = targetBytes.n(1);
                while (jB1 < commonIndexOfElement.B1()) {
                    byte[] bArr = j0Var.f38468a;
                    i7 = (int) ((((long) j0Var.f38469b) + j7) - jB1);
                    int i9 = j0Var.f38470c;
                    while (true) {
                        if (i7 >= i9) {
                            jB1 += (long) (j0Var.f38470c - j0Var.f38469b);
                            j0Var = j0Var.f38473f;
                            l0.m(j0Var);
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
            } else {
                byte[] bArrE = targetBytes.E();
                while (jB1 < commonIndexOfElement.B1()) {
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
                            l0.m(j0Var);
                            j7 = jB1;
                        }
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
            l0.m(j0Var);
            jB1 = j8;
        }
        if (targetBytes.a0() == 2) {
            byte bN3 = targetBytes.n(0);
            byte bN4 = targetBytes.n(1);
            while (jB1 < commonIndexOfElement.B1()) {
                byte[] bArr3 = j0Var.f38468a;
                i7 = (int) ((((long) j0Var.f38469b) + j7) - jB1);
                int i12 = j0Var.f38470c;
                while (true) {
                    if (i7 >= i12) {
                        jB1 += (long) (j0Var.f38470c - j0Var.f38469b);
                        j0Var = j0Var.f38473f;
                        l0.m(j0Var);
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
        } else {
            byte[] bArrE2 = targetBytes.E();
            while (jB1 < commonIndexOfElement.B1()) {
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
                        l0.m(j0Var);
                        j7 = jB1;
                    }
                }
            }
        }
        return -1L;
        return ((long) (i7 - i8)) + jB1;
    }

    public static final boolean k(@a7.d m commonRangeEquals, long j7, @a7.d p bytes, int i7, int i8) {
        l0.p(commonRangeEquals, "$this$commonRangeEquals");
        l0.p(bytes, "bytes");
        if (j7 < 0 || i7 < 0 || i8 < 0 || commonRangeEquals.B1() - j7 < i8 || bytes.a0() - i7 < i8) {
            return false;
        }
        for (int i9 = 0; i9 < i8; i9++) {
            if (commonRangeEquals.v0(((long) i9) + j7) != bytes.n(i7 + i9)) {
                return false;
            }
        }
        return true;
    }

    public static final int l(@a7.d m commonRead, @a7.d byte[] sink) {
        l0.p(commonRead, "$this$commonRead");
        l0.p(sink, "sink");
        return commonRead.read(sink, 0, sink.length);
    }

    public static final int m(@a7.d m commonRead, @a7.d byte[] sink, int i7, int i8) {
        l0.p(commonRead, "$this$commonRead");
        l0.p(sink, "sink");
        j.e(sink.length, i7, i8);
        j0 j0Var = commonRead.f38494a;
        if (j0Var == null) {
            return -1;
        }
        int iMin = Math.min(i8, j0Var.f38470c - j0Var.f38469b);
        byte[] bArr = j0Var.f38468a;
        int i9 = j0Var.f38469b;
        o.W0(bArr, sink, i7, i9, i9 + iMin);
        j0Var.f38469b += iMin;
        commonRead.s1(commonRead.B1() - ((long) iMin));
        if (j0Var.f38469b == j0Var.f38470c) {
            commonRead.f38494a = j0Var.b();
            k0.d(j0Var);
        }
        return iMin;
    }

    public static final long n(@a7.d m commonRead, @a7.d m sink, long j7) {
        l0.p(commonRead, "$this$commonRead");
        l0.p(sink, "sink");
        if (!(j7 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j7).toString());
        }
        if (commonRead.B1() == 0) {
            return -1L;
        }
        if (j7 > commonRead.B1()) {
            j7 = commonRead.B1();
        }
        sink.write(commonRead, j7);
        return j7;
    }

    public static final long o(@a7.d m commonReadAll, @a7.d m0 sink) throws IOException {
        l0.p(commonReadAll, "$this$commonReadAll");
        l0.p(sink, "sink");
        long jB1 = commonReadAll.B1();
        if (jB1 > 0) {
            sink.write(commonReadAll, jB1);
        }
        return jB1;
    }

    public static final byte p(@a7.d m commonReadByte) throws EOFException {
        l0.p(commonReadByte, "$this$commonReadByte");
        if (commonReadByte.B1() == 0) {
            throw new EOFException();
        }
        j0 j0Var = commonReadByte.f38494a;
        l0.m(j0Var);
        int i7 = j0Var.f38469b;
        int i8 = j0Var.f38470c;
        int i9 = i7 + 1;
        byte b8 = j0Var.f38468a[i7];
        commonReadByte.s1(commonReadByte.B1() - 1);
        if (i9 == i8) {
            commonReadByte.f38494a = j0Var.b();
            k0.d(j0Var);
        } else {
            j0Var.f38469b = i9;
        }
        return b8;
    }

    @a7.d
    public static final byte[] q(@a7.d m commonReadByteArray) {
        l0.p(commonReadByteArray, "$this$commonReadByteArray");
        return commonReadByteArray.h1(commonReadByteArray.B1());
    }

    @a7.d
    public static final byte[] r(@a7.d m commonReadByteArray, long j7) throws EOFException {
        l0.p(commonReadByteArray, "$this$commonReadByteArray");
        if (!(j7 >= 0 && j7 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j7).toString());
        }
        if (commonReadByteArray.B1() < j7) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j7];
        commonReadByteArray.readFully(bArr);
        return bArr;
    }

    @a7.d
    public static final p s(@a7.d m commonReadByteString) {
        l0.p(commonReadByteString, "$this$commonReadByteString");
        return commonReadByteString.l(commonReadByteString.B1());
    }

    @a7.d
    public static final p t(@a7.d m commonReadByteString, long j7) throws EOFException {
        l0.p(commonReadByteString, "$this$commonReadByteString");
        if (!(j7 >= 0 && j7 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j7).toString());
        }
        if (commonReadByteString.B1() < j7) {
            throw new EOFException();
        }
        if (j7 < 4096) {
            return new p(commonReadByteString.h1(j7));
        }
        p pVarR1 = commonReadByteString.R1((int) j7);
        commonReadByteString.skip(j7);
        return pVarR1;
    }

    public static final long u(@a7.d m commonReadDecimalLong) throws EOFException {
        l0.p(commonReadDecimalLong, "$this$commonReadDecimalLong");
        if (commonReadDecimalLong.B1() == 0) {
            throw new EOFException();
        }
        int i7 = 0;
        boolean z7 = false;
        long j7 = -7;
        long j8 = 0;
        boolean z8 = false;
        do {
            j0 j0Var = commonReadDecimalLong.f38494a;
            l0.m(j0Var);
            byte[] bArr = j0Var.f38468a;
            int i8 = j0Var.f38469b;
            int i9 = j0Var.f38470c;
            while (i8 < i9) {
                byte b8 = bArr[i8];
                byte b9 = (byte) 48;
                if (b8 >= b9 && b8 <= ((byte) 57)) {
                    int i10 = b9 - b8;
                    if (j8 < f40434c || (j8 == f40434c && i10 < j7)) {
                        m mVarC2 = new m().H1(j8).writeByte(b8);
                        if (!z7) {
                            mVarC2.readByte();
                        }
                        throw new NumberFormatException("Number too large: " + mVarC2.m1());
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
                commonReadDecimalLong.f38494a = j0Var.b();
                k0.d(j0Var);
            } else {
                j0Var.f38469b = i8;
            }
            if (z8) {
                break;
            }
        } while (commonReadDecimalLong.f38494a != null);
        commonReadDecimalLong.s1(commonReadDecimalLong.B1() - ((long) i7));
        return z7 ? j8 : -j8;
    }

    public static final void v(@a7.d m commonReadFully, @a7.d m sink, long j7) throws EOFException {
        l0.p(commonReadFully, "$this$commonReadFully");
        l0.p(sink, "sink");
        if (commonReadFully.B1() >= j7) {
            sink.write(commonReadFully, j7);
        } else {
            sink.write(commonReadFully, commonReadFully.B1());
            throw new EOFException();
        }
    }

    public static final void w(@a7.d m commonReadFully, @a7.d byte[] sink) throws EOFException {
        l0.p(commonReadFully, "$this$commonReadFully");
        l0.p(sink, "sink");
        int i7 = 0;
        while (i7 < sink.length) {
            int i8 = commonReadFully.read(sink, i7, sink.length - i7);
            if (i8 == -1) {
                throw new EOFException();
            }
            i7 += i8;
        }
    }

    public static final long x(@a7.d m commonReadHexadecimalUnsignedLong) throws EOFException {
        int i7;
        l0.p(commonReadHexadecimalUnsignedLong, "$this$commonReadHexadecimalUnsignedLong");
        if (commonReadHexadecimalUnsignedLong.B1() == 0) {
            throw new EOFException();
        }
        int i8 = 0;
        boolean z7 = false;
        long j7 = 0;
        do {
            j0 j0Var = commonReadHexadecimalUnsignedLong.f38494a;
            l0.m(j0Var);
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
                commonReadHexadecimalUnsignedLong.f38494a = j0Var.b();
                k0.d(j0Var);
            } else {
                j0Var.f38469b = i9;
            }
            if (z7) {
                break;
            }
        } while (commonReadHexadecimalUnsignedLong.f38494a != null);
        commonReadHexadecimalUnsignedLong.s1(commonReadHexadecimalUnsignedLong.B1() - ((long) i8));
        return j7;
    }

    public static final int y(@a7.d m commonReadInt) throws EOFException {
        l0.p(commonReadInt, "$this$commonReadInt");
        if (commonReadInt.B1() < 4) {
            throw new EOFException();
        }
        j0 j0Var = commonReadInt.f38494a;
        l0.m(j0Var);
        int i7 = j0Var.f38469b;
        int i8 = j0Var.f38470c;
        if (i8 - i7 < 4) {
            return (commonReadInt.readByte() & 255) | ((commonReadInt.readByte() & 255) << 24) | ((commonReadInt.readByte() & 255) << 16) | ((commonReadInt.readByte() & 255) << 8);
        }
        byte[] bArr = j0Var.f38468a;
        int i9 = i7 + 1;
        int i10 = i9 + 1;
        int i11 = ((bArr[i7] & 255) << 24) | ((bArr[i9] & 255) << 16);
        int i12 = i10 + 1;
        int i13 = i11 | ((bArr[i10] & 255) << 8);
        int i14 = i12 + 1;
        int i15 = i13 | (bArr[i12] & 255);
        commonReadInt.s1(commonReadInt.B1() - 4);
        if (i14 == i8) {
            commonReadInt.f38494a = j0Var.b();
            k0.d(j0Var);
        } else {
            j0Var.f38469b = i14;
        }
        return i15;
    }

    public static final long z(@a7.d m commonReadLong) throws EOFException {
        l0.p(commonReadLong, "$this$commonReadLong");
        if (commonReadLong.B1() < 8) {
            throw new EOFException();
        }
        j0 j0Var = commonReadLong.f38494a;
        l0.m(j0Var);
        int i7 = j0Var.f38469b;
        int i8 = j0Var.f38470c;
        if (i8 - i7 < 8) {
            return ((((long) commonReadLong.readInt()) & 4294967295L) << 32) | (4294967295L & ((long) commonReadLong.readInt()));
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
        commonReadLong.s1(commonReadLong.B1() - 8);
        if (i16 == i8) {
            commonReadLong.f38494a = j0Var.b();
            k0.d(j0Var);
        } else {
            j0Var.f38469b = i16;
        }
        return j12;
    }
}
