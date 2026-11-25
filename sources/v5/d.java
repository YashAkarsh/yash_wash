package v5;

import java.io.EOFException;
import java.io.IOException;
import kotlin.jvm.internal.l0;
import okio.a0;
import okio.d0;
import okio.f0;
import okio.i0;
import okio.j;
import okio.m;
import okio.m0;
import okio.o;
import okio.p;
import okio.q0;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    @a7.d
    public static final String A(@a7.d i0 commonReadUtf8, long j7) throws EOFException {
        l0.p(commonReadUtf8, "$this$commonReadUtf8");
        commonReadUtf8.G1(j7);
        return commonReadUtf8.f38461a.h(j7);
    }

    public static final int B(@a7.d i0 commonReadUtf8CodePoint) throws EOFException {
        l0.p(commonReadUtf8CodePoint, "$this$commonReadUtf8CodePoint");
        commonReadUtf8CodePoint.G1(1L);
        byte bV0 = commonReadUtf8CodePoint.f38461a.v0(0L);
        if ((bV0 & 224) == 192) {
            commonReadUtf8CodePoint.G1(2L);
        } else if ((bV0 & 240) == 224) {
            commonReadUtf8CodePoint.G1(3L);
        } else if ((bV0 & 248) == 240) {
            commonReadUtf8CodePoint.G1(4L);
        }
        return commonReadUtf8CodePoint.f38461a.A0();
    }

    @a7.e
    public static final String C(@a7.d i0 commonReadUtf8Line) {
        l0.p(commonReadUtf8Line, "$this$commonReadUtf8Line");
        long jM1 = commonReadUtf8Line.M1((byte) 10);
        if (jM1 != -1) {
            return a.b0(commonReadUtf8Line.f38461a, jM1);
        }
        if (commonReadUtf8Line.f38461a.B1() != 0) {
            return commonReadUtf8Line.h(commonReadUtf8Line.f38461a.B1());
        }
        return null;
    }

    @a7.d
    public static final String D(@a7.d i0 commonReadUtf8LineStrict, long j7) throws EOFException {
        l0.p(commonReadUtf8LineStrict, "$this$commonReadUtf8LineStrict");
        if (!(j7 >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j7).toString());
        }
        long j8 = j7 == Long.MAX_VALUE ? Long.MAX_VALUE : j7 + 1;
        byte b8 = (byte) 10;
        long jY = commonReadUtf8LineStrict.Y(b8, 0L, j8);
        if (jY != -1) {
            return a.b0(commonReadUtf8LineStrict.f38461a, jY);
        }
        if (j8 < Long.MAX_VALUE && commonReadUtf8LineStrict.K0(j8) && commonReadUtf8LineStrict.f38461a.v0(j8 - 1) == ((byte) 13) && commonReadUtf8LineStrict.K0(1 + j8) && commonReadUtf8LineStrict.f38461a.v0(j8) == b8) {
            return a.b0(commonReadUtf8LineStrict.f38461a, j8);
        }
        m mVar = new m();
        m mVar2 = commonReadUtf8LineStrict.f38461a;
        mVar2.Q(mVar, 0L, Math.min(32, mVar2.B1()));
        throw new EOFException("\\n not found: limit=" + Math.min(commonReadUtf8LineStrict.f38461a.B1(), j7) + " content=" + mVar.E0().t() + "…");
    }

    public static final boolean E(@a7.d i0 commonRequest, long j7) {
        l0.p(commonRequest, "$this$commonRequest");
        if (!(j7 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j7).toString());
        }
        if (!(!commonRequest.f38462b)) {
            throw new IllegalStateException("closed".toString());
        }
        while (commonRequest.f38461a.B1() < j7) {
            if (commonRequest.f38463c.read(commonRequest.f38461a, 8192) == -1) {
                return false;
            }
        }
        return true;
    }

    public static final void F(@a7.d i0 commonRequire, long j7) throws EOFException {
        l0.p(commonRequire, "$this$commonRequire");
        if (!commonRequire.K0(j7)) {
            throw new EOFException();
        }
    }

    public static final int G(@a7.d i0 commonSelect, @a7.d d0 options) throws EOFException {
        l0.p(commonSelect, "$this$commonSelect");
        l0.p(options, "options");
        if (!(!commonSelect.f38462b)) {
            throw new IllegalStateException("closed".toString());
        }
        do {
            int iD0 = a.d0(commonSelect.f38461a, options, true);
            if (iD0 != -2) {
                if (iD0 == -1) {
                    return -1;
                }
                commonSelect.f38461a.skip(options.f()[iD0].a0());
                return iD0;
            }
        } while (commonSelect.f38463c.read(commonSelect.f38461a, 8192) != -1);
        return -1;
    }

    public static final void H(@a7.d i0 commonSkip, long j7) throws EOFException {
        l0.p(commonSkip, "$this$commonSkip");
        if (!(!commonSkip.f38462b)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j7 > 0) {
            if (commonSkip.f38461a.B1() == 0 && commonSkip.f38463c.read(commonSkip.f38461a, 8192) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j7, commonSkip.f38461a.B1());
            commonSkip.f38461a.skip(jMin);
            j7 -= jMin;
        }
    }

    @a7.d
    public static final q0 I(@a7.d i0 commonTimeout) {
        l0.p(commonTimeout, "$this$commonTimeout");
        return commonTimeout.f38463c.timeout();
    }

    @a7.d
    public static final String J(@a7.d i0 commonToString) {
        l0.p(commonToString, "$this$commonToString");
        return "buffer(" + commonToString.f38463c + ')';
    }

    public static final void a(@a7.d i0 commonClose) throws IOException {
        l0.p(commonClose, "$this$commonClose");
        if (commonClose.f38462b) {
            return;
        }
        commonClose.f38462b = true;
        commonClose.f38463c.close();
        commonClose.f38461a.q();
    }

    public static final boolean b(@a7.d i0 commonExhausted) {
        l0.p(commonExhausted, "$this$commonExhausted");
        if (!commonExhausted.f38462b) {
            return commonExhausted.f38461a.N() && commonExhausted.f38463c.read(commonExhausted.f38461a, (long) 8192) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final long c(@a7.d i0 commonIndexOf, byte b8, long j7, long j8) {
        l0.p(commonIndexOf, "$this$commonIndexOf");
        if (!(!commonIndexOf.f38462b)) {
            throw new IllegalStateException("closed".toString());
        }
        if (!(0 <= j7 && j8 >= j7)) {
            throw new IllegalArgumentException(("fromIndex=" + j7 + " toIndex=" + j8).toString());
        }
        while (j7 < j8) {
            long jY = commonIndexOf.f38461a.Y(b8, j7, j8);
            if (jY != -1) {
                return jY;
            }
            long jB1 = commonIndexOf.f38461a.B1();
            if (jB1 >= j8 || commonIndexOf.f38463c.read(commonIndexOf.f38461a, 8192) == -1) {
                break;
            }
            j7 = Math.max(j7, jB1);
        }
        return -1L;
    }

    public static final long d(@a7.d i0 commonIndexOf, @a7.d p bytes, long j7) throws IOException {
        l0.p(commonIndexOf, "$this$commonIndexOf");
        l0.p(bytes, "bytes");
        if (!(!commonIndexOf.f38462b)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long jK = commonIndexOf.f38461a.k(bytes, j7);
            if (jK != -1) {
                return jK;
            }
            long jB1 = commonIndexOf.f38461a.B1();
            if (commonIndexOf.f38463c.read(commonIndexOf.f38461a, 8192) == -1) {
                return -1L;
            }
            j7 = Math.max(j7, (jB1 - ((long) bytes.a0())) + 1);
        }
    }

    public static final long e(@a7.d i0 commonIndexOfElement, @a7.d p targetBytes, long j7) {
        l0.p(commonIndexOfElement, "$this$commonIndexOfElement");
        l0.p(targetBytes, "targetBytes");
        if (!(!commonIndexOfElement.f38462b)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long jF1 = commonIndexOfElement.f38461a.F1(targetBytes, j7);
            if (jF1 != -1) {
                return jF1;
            }
            long jB1 = commonIndexOfElement.f38461a.B1();
            if (commonIndexOfElement.f38463c.read(commonIndexOfElement.f38461a, 8192) == -1) {
                return -1L;
            }
            j7 = Math.max(j7, jB1);
        }
    }

    @a7.d
    public static final o f(@a7.d i0 commonPeek) {
        l0.p(commonPeek, "$this$commonPeek");
        return a0.d(new f0(commonPeek));
    }

    public static final boolean g(@a7.d i0 commonRangeEquals, long j7, @a7.d p bytes, int i7, int i8) {
        l0.p(commonRangeEquals, "$this$commonRangeEquals");
        l0.p(bytes, "bytes");
        if (!(!commonRangeEquals.f38462b)) {
            throw new IllegalStateException("closed".toString());
        }
        if (j7 < 0 || i7 < 0 || i8 < 0 || bytes.a0() - i7 < i8) {
            return false;
        }
        for (int i9 = 0; i9 < i8; i9++) {
            long j8 = ((long) i9) + j7;
            if (!commonRangeEquals.K0(1 + j8) || commonRangeEquals.f38461a.v0(j8) != bytes.n(i7 + i9)) {
                return false;
            }
        }
        return true;
    }

    public static final int h(@a7.d i0 commonRead, @a7.d byte[] sink, int i7, int i8) {
        l0.p(commonRead, "$this$commonRead");
        l0.p(sink, "sink");
        long j7 = i8;
        j.e(sink.length, i7, j7);
        if (commonRead.f38461a.B1() == 0 && commonRead.f38463c.read(commonRead.f38461a, 8192) == -1) {
            return -1;
        }
        return commonRead.f38461a.read(sink, i7, (int) Math.min(j7, commonRead.f38461a.B1()));
    }

    public static final long i(@a7.d i0 commonRead, @a7.d m sink, long j7) {
        l0.p(commonRead, "$this$commonRead");
        l0.p(sink, "sink");
        if (!(j7 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j7).toString());
        }
        if (!(!commonRead.f38462b)) {
            throw new IllegalStateException("closed".toString());
        }
        if (commonRead.f38461a.B1() == 0 && commonRead.f38463c.read(commonRead.f38461a, 8192) == -1) {
            return -1L;
        }
        return commonRead.f38461a.read(sink, Math.min(j7, commonRead.f38461a.B1()));
    }

    public static final long j(@a7.d i0 commonReadAll, @a7.d m0 sink) throws IOException {
        l0.p(commonReadAll, "$this$commonReadAll");
        l0.p(sink, "sink");
        long j7 = 0;
        while (commonReadAll.f38463c.read(commonReadAll.f38461a, 8192) != -1) {
            long jU = commonReadAll.f38461a.u();
            if (jU > 0) {
                j7 += jU;
                sink.write(commonReadAll.f38461a, jU);
            }
        }
        if (commonReadAll.f38461a.B1() <= 0) {
            return j7;
        }
        long jB1 = j7 + commonReadAll.f38461a.B1();
        m mVar = commonReadAll.f38461a;
        sink.write(mVar, mVar.B1());
        return jB1;
    }

    public static final byte k(@a7.d i0 commonReadByte) throws EOFException {
        l0.p(commonReadByte, "$this$commonReadByte");
        commonReadByte.G1(1L);
        return commonReadByte.f38461a.readByte();
    }

    @a7.d
    public static final byte[] l(@a7.d i0 commonReadByteArray) throws IOException {
        l0.p(commonReadByteArray, "$this$commonReadByteArray");
        commonReadByteArray.f38461a.C0(commonReadByteArray.f38463c);
        return commonReadByteArray.f38461a.I();
    }

    @a7.d
    public static final byte[] m(@a7.d i0 commonReadByteArray, long j7) throws EOFException {
        l0.p(commonReadByteArray, "$this$commonReadByteArray");
        commonReadByteArray.G1(j7);
        return commonReadByteArray.f38461a.h1(j7);
    }

    @a7.d
    public static final p n(@a7.d i0 commonReadByteString) throws IOException {
        l0.p(commonReadByteString, "$this$commonReadByteString");
        commonReadByteString.f38461a.C0(commonReadByteString.f38463c);
        return commonReadByteString.f38461a.E0();
    }

    @a7.d
    public static final p o(@a7.d i0 commonReadByteString, long j7) throws EOFException {
        l0.p(commonReadByteString, "$this$commonReadByteString");
        commonReadByteString.G1(j7);
        return commonReadByteString.f38461a.l(j7);
    }

    public static final long p(@a7.d i0 commonReadDecimalLong) throws EOFException {
        l0.p(commonReadDecimalLong, "$this$commonReadDecimalLong");
        commonReadDecimalLong.G1(1L);
        long j7 = 0;
        while (true) {
            long j8 = j7 + 1;
            if (!commonReadDecimalLong.K0(j8)) {
                break;
            }
            byte bV0 = commonReadDecimalLong.f38461a.v0(j7);
            if ((bV0 < ((byte) 48) || bV0 > ((byte) 57)) && !(j7 == 0 && bV0 == ((byte) 45))) {
                if (j7 != 0) {
                    break;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Expected leading [0-9] or '-' character but was 0x");
                String string = Integer.toString(bV0, kotlin.text.d.a(kotlin.text.d.a(16)));
                l0.o(string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                sb.append(string);
                throw new NumberFormatException(sb.toString());
            }
            j7 = j8;
        }
        return commonReadDecimalLong.f38461a.c0();
    }

    public static final void q(@a7.d i0 commonReadFully, @a7.d m sink, long j7) throws IOException {
        l0.p(commonReadFully, "$this$commonReadFully");
        l0.p(sink, "sink");
        try {
            commonReadFully.G1(j7);
            commonReadFully.f38461a.V(sink, j7);
        } catch (EOFException e8) {
            sink.C0(commonReadFully.f38461a);
            throw e8;
        }
    }

    public static final void r(@a7.d i0 commonReadFully, @a7.d byte[] sink) throws EOFException {
        l0.p(commonReadFully, "$this$commonReadFully");
        l0.p(sink, "sink");
        try {
            commonReadFully.G1(sink.length);
            commonReadFully.f38461a.readFully(sink);
        } catch (EOFException e8) {
            int i7 = 0;
            while (commonReadFully.f38461a.B1() > 0) {
                m mVar = commonReadFully.f38461a;
                int i8 = mVar.read(sink, i7, (int) mVar.B1());
                if (i8 == -1) {
                    throw new AssertionError();
                }
                i7 += i8;
            }
            throw e8;
        }
    }

    public static final long s(@a7.d i0 commonReadHexadecimalUnsignedLong) throws EOFException {
        l0.p(commonReadHexadecimalUnsignedLong, "$this$commonReadHexadecimalUnsignedLong");
        commonReadHexadecimalUnsignedLong.G1(1L);
        int i7 = 0;
        while (true) {
            int i8 = i7 + 1;
            if (!commonReadHexadecimalUnsignedLong.K0(i8)) {
                break;
            }
            byte bV0 = commonReadHexadecimalUnsignedLong.f38461a.v0(i7);
            if ((bV0 < ((byte) 48) || bV0 > ((byte) 57)) && ((bV0 < ((byte) 97) || bV0 > ((byte) 102)) && (bV0 < ((byte) 65) || bV0 > ((byte) 70)))) {
                if (i7 != 0) {
                    break;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Expected leading [0-9a-fA-F] character but was 0x");
                String string = Integer.toString(bV0, kotlin.text.d.a(kotlin.text.d.a(16)));
                l0.o(string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                sb.append(string);
                throw new NumberFormatException(sb.toString());
            }
            i7 = i8;
        }
        return commonReadHexadecimalUnsignedLong.f38461a.Q1();
    }

    public static final int t(@a7.d i0 commonReadInt) throws EOFException {
        l0.p(commonReadInt, "$this$commonReadInt");
        commonReadInt.G1(4L);
        return commonReadInt.f38461a.readInt();
    }

    public static final int u(@a7.d i0 commonReadIntLe) throws EOFException {
        l0.p(commonReadIntLe, "$this$commonReadIntLe");
        commonReadIntLe.G1(4L);
        return commonReadIntLe.f38461a.b1();
    }

    public static final long v(@a7.d i0 commonReadLong) throws EOFException {
        l0.p(commonReadLong, "$this$commonReadLong");
        commonReadLong.G1(8L);
        return commonReadLong.f38461a.readLong();
    }

    public static final long w(@a7.d i0 commonReadLongLe) throws EOFException {
        l0.p(commonReadLongLe, "$this$commonReadLongLe");
        commonReadLongLe.G1(8L);
        return commonReadLongLe.f38461a.v1();
    }

    public static final short x(@a7.d i0 commonReadShort) throws EOFException {
        l0.p(commonReadShort, "$this$commonReadShort");
        commonReadShort.G1(2L);
        return commonReadShort.f38461a.readShort();
    }

    public static final short y(@a7.d i0 commonReadShortLe) throws EOFException {
        l0.p(commonReadShortLe, "$this$commonReadShortLe");
        commonReadShortLe.G1(2L);
        return commonReadShortLe.f38461a.r1();
    }

    @a7.d
    public static final String z(@a7.d i0 commonReadUtf8) throws IOException {
        l0.p(commonReadUtf8, "$this$commonReadUtf8");
        commonReadUtf8.f38461a.C0(commonReadUtf8.f38463c);
        return commonReadUtf8.f38461a.m1();
    }
}
