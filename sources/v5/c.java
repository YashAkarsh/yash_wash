package v5;

import java.io.EOFException;
import java.io.IOException;
import kotlin.jvm.internal.l0;
import okio.h0;
import okio.m;
import okio.m0;
import okio.n;
import okio.o0;
import okio.p;
import okio.q0;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final void a(@a7.d h0 commonClose) throws Throwable {
        l0.p(commonClose, "$this$commonClose");
        if (commonClose.f38458b) {
            return;
        }
        if (commonClose.f38457a.B1() > 0) {
            m0 m0Var = commonClose.f38459c;
            m mVar = commonClose.f38457a;
            m0Var.write(mVar, mVar.B1());
        }
        th = null;
        try {
            commonClose.f38459c.close();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        commonClose.f38458b = true;
        if (th != null) {
            throw th;
        }
    }

    @a7.d
    public static final n b(@a7.d h0 commonEmit) throws IOException {
        l0.p(commonEmit, "$this$commonEmit");
        if (!(!commonEmit.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        long jB1 = commonEmit.f38457a.B1();
        if (jB1 > 0) {
            commonEmit.f38459c.write(commonEmit.f38457a, jB1);
        }
        return commonEmit;
    }

    @a7.d
    public static final n c(@a7.d h0 commonEmitCompleteSegments) throws IOException {
        l0.p(commonEmitCompleteSegments, "$this$commonEmitCompleteSegments");
        if (!(!commonEmitCompleteSegments.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        long jU = commonEmitCompleteSegments.f38457a.u();
        if (jU > 0) {
            commonEmitCompleteSegments.f38459c.write(commonEmitCompleteSegments.f38457a, jU);
        }
        return commonEmitCompleteSegments;
    }

    public static final void d(@a7.d h0 commonFlush) throws IOException {
        l0.p(commonFlush, "$this$commonFlush");
        if (!(!commonFlush.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        if (commonFlush.f38457a.B1() > 0) {
            m0 m0Var = commonFlush.f38459c;
            m mVar = commonFlush.f38457a;
            m0Var.write(mVar, mVar.B1());
        }
        commonFlush.f38459c.flush();
    }

    @a7.d
    public static final q0 e(@a7.d h0 commonTimeout) {
        l0.p(commonTimeout, "$this$commonTimeout");
        return commonTimeout.f38459c.timeout();
    }

    @a7.d
    public static final String f(@a7.d h0 commonToString) {
        l0.p(commonToString, "$this$commonToString");
        return "buffer(" + commonToString.f38459c + ')';
    }

    @a7.d
    public static final n g(@a7.d h0 commonWrite, @a7.d p byteString) {
        l0.p(commonWrite, "$this$commonWrite");
        l0.p(byteString, "byteString");
        if (!(!commonWrite.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWrite.f38457a.p1(byteString);
        return commonWrite.b0();
    }

    @a7.d
    public static final n h(@a7.d h0 commonWrite, @a7.d p byteString, int i7, int i8) {
        l0.p(commonWrite, "$this$commonWrite");
        l0.p(byteString, "byteString");
        if (!(!commonWrite.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWrite.f38457a.z(byteString, i7, i8);
        return commonWrite.b0();
    }

    @a7.d
    public static final n i(@a7.d h0 commonWrite, @a7.d o0 source, long j7) throws IOException {
        l0.p(commonWrite, "$this$commonWrite");
        l0.p(source, "source");
        while (j7 > 0) {
            long j8 = source.read(commonWrite.f38457a, j7);
            if (j8 == -1) {
                throw new EOFException();
            }
            j7 -= j8;
            commonWrite.b0();
        }
        return commonWrite;
    }

    @a7.d
    public static final n j(@a7.d h0 commonWrite, @a7.d byte[] source) {
        l0.p(commonWrite, "$this$commonWrite");
        l0.p(source, "source");
        if (!(!commonWrite.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWrite.f38457a.write(source);
        return commonWrite.b0();
    }

    @a7.d
    public static final n k(@a7.d h0 commonWrite, @a7.d byte[] source, int i7, int i8) {
        l0.p(commonWrite, "$this$commonWrite");
        l0.p(source, "source");
        if (!(!commonWrite.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWrite.f38457a.write(source, i7, i8);
        return commonWrite.b0();
    }

    public static final void l(@a7.d h0 commonWrite, @a7.d m source, long j7) throws IOException {
        l0.p(commonWrite, "$this$commonWrite");
        l0.p(source, "source");
        if (!(!commonWrite.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWrite.f38457a.write(source, j7);
        commonWrite.b0();
    }

    public static final long m(@a7.d h0 commonWriteAll, @a7.d o0 source) throws IOException {
        l0.p(commonWriteAll, "$this$commonWriteAll");
        l0.p(source, "source");
        long j7 = 0;
        while (true) {
            long j8 = source.read(commonWriteAll.f38457a, 8192);
            if (j8 == -1) {
                return j7;
            }
            j7 += j8;
            commonWriteAll.b0();
        }
    }

    @a7.d
    public static final n n(@a7.d h0 commonWriteByte, int i7) {
        l0.p(commonWriteByte, "$this$commonWriteByte");
        if (!(!commonWriteByte.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteByte.f38457a.writeByte(i7);
        return commonWriteByte.b0();
    }

    @a7.d
    public static final n o(@a7.d h0 commonWriteDecimalLong, long j7) {
        l0.p(commonWriteDecimalLong, "$this$commonWriteDecimalLong");
        if (!(!commonWriteDecimalLong.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteDecimalLong.f38457a.H1(j7);
        return commonWriteDecimalLong.b0();
    }

    @a7.d
    public static final n p(@a7.d h0 commonWriteHexadecimalUnsignedLong, long j7) {
        l0.p(commonWriteHexadecimalUnsignedLong, "$this$commonWriteHexadecimalUnsignedLong");
        if (!(!commonWriteHexadecimalUnsignedLong.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteHexadecimalUnsignedLong.f38457a.D0(j7);
        return commonWriteHexadecimalUnsignedLong.b0();
    }

    @a7.d
    public static final n q(@a7.d h0 commonWriteInt, int i7) {
        l0.p(commonWriteInt, "$this$commonWriteInt");
        if (!(!commonWriteInt.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteInt.f38457a.writeInt(i7);
        return commonWriteInt.b0();
    }

    @a7.d
    public static final n r(@a7.d h0 commonWriteIntLe, int i7) {
        l0.p(commonWriteIntLe, "$this$commonWriteIntLe");
        if (!(!commonWriteIntLe.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteIntLe.f38457a.L(i7);
        return commonWriteIntLe.b0();
    }

    @a7.d
    public static final n s(@a7.d h0 commonWriteLong, long j7) {
        l0.p(commonWriteLong, "$this$commonWriteLong");
        if (!(!commonWriteLong.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteLong.f38457a.writeLong(j7);
        return commonWriteLong.b0();
    }

    @a7.d
    public static final n t(@a7.d h0 commonWriteLongLe, long j7) {
        l0.p(commonWriteLongLe, "$this$commonWriteLongLe");
        if (!(!commonWriteLongLe.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteLongLe.f38457a.D(j7);
        return commonWriteLongLe.b0();
    }

    @a7.d
    public static final n u(@a7.d h0 commonWriteShort, int i7) {
        l0.p(commonWriteShort, "$this$commonWriteShort");
        if (!(!commonWriteShort.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteShort.f38457a.writeShort(i7);
        return commonWriteShort.b0();
    }

    @a7.d
    public static final n v(@a7.d h0 commonWriteShortLe, int i7) {
        l0.p(commonWriteShortLe, "$this$commonWriteShortLe");
        if (!(!commonWriteShortLe.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteShortLe.f38457a.m0(i7);
        return commonWriteShortLe.b0();
    }

    @a7.d
    public static final n w(@a7.d h0 commonWriteUtf8, @a7.d String string) {
        l0.p(commonWriteUtf8, "$this$commonWriteUtf8");
        l0.p(string, "string");
        if (!(!commonWriteUtf8.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteUtf8.f38457a.q0(string);
        return commonWriteUtf8.b0();
    }

    @a7.d
    public static final n x(@a7.d h0 commonWriteUtf8, @a7.d String string, int i7, int i8) {
        l0.p(commonWriteUtf8, "$this$commonWriteUtf8");
        l0.p(string, "string");
        if (!(!commonWriteUtf8.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteUtf8.f38457a.B0(string, i7, i8);
        return commonWriteUtf8.b0();
    }

    @a7.d
    public static final n y(@a7.d h0 commonWriteUtf8CodePoint, int i7) {
        l0.p(commonWriteUtf8CodePoint, "$this$commonWriteUtf8CodePoint");
        if (!(!commonWriteUtf8CodePoint.f38458b)) {
            throw new IllegalStateException("closed".toString());
        }
        commonWriteUtf8CodePoint.f38457a.x(i7);
        return commonWriteUtf8CodePoint.b0();
    }
}
