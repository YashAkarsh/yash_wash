package kotlin.random;

import kotlin.a2;
import kotlin.g1;
import kotlin.jvm.internal.l0;
import kotlin.o2;
import kotlin.q2;
import kotlin.ranges.w;
import kotlin.t;
import kotlin.t1;
import kotlin.w1;

/* JADX INFO: loaded from: classes2.dex */
public final class h {
    public static final void a(int i7, int i8) {
        if (!(o2.c(i8, i7) > 0)) {
            throw new IllegalArgumentException(g.c(w1.b(i7), w1.b(i8)).toString());
        }
    }

    public static final void b(long j7, long j8) {
        if (!(o2.g(j8, j7) > 0)) {
            throw new IllegalArgumentException(g.c(a2.b(j7), a2.b(j8)).toString());
        }
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final byte[] c(@a7.d f fVar, int i7) {
        l0.p(fVar, "<this>");
        return t1.f(fVar.d(i7));
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final byte[] d(@a7.d f nextUBytes, @a7.d byte[] array) {
        l0.p(nextUBytes, "$this$nextUBytes");
        l0.p(array, "array");
        nextUBytes.e(array);
        return array;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final byte[] e(@a7.d f nextUBytes, @a7.d byte[] array, int i7, int i8) {
        l0.p(nextUBytes, "$this$nextUBytes");
        l0.p(array, "array");
        nextUBytes.f(array, i7, i8);
        return array;
    }

    public static /* synthetic */ byte[] f(f fVar, byte[] bArr, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = t1.o(bArr);
        }
        return e(fVar, bArr, i7, i8);
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class})
    public static final int g(@a7.d f fVar) {
        l0.p(fVar, "<this>");
        return w1.h(fVar.l());
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class})
    public static final int h(@a7.d f fVar, @a7.d kotlin.ranges.t range) {
        l0.p(fVar, "<this>");
        l0.p(range, "range");
        if (!range.isEmpty()) {
            if (o2.c(range.h(), -1) < 0) {
                return i(fVar, range.g(), w1.h(range.h() + 1));
            }
            return o2.c(range.g(), 0) > 0 ? w1.h(i(fVar, w1.h(range.g() - 1), range.h()) + 1) : g(fVar);
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class})
    public static final int i(@a7.d f nextUInt, int i7, int i8) {
        l0.p(nextUInt, "$this$nextUInt");
        a(i7, i8);
        return w1.h(nextUInt.n(i7 ^ Integer.MIN_VALUE, i8 ^ Integer.MIN_VALUE) ^ Integer.MIN_VALUE);
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class})
    public static final int j(@a7.d f nextUInt, int i7) {
        l0.p(nextUInt, "$this$nextUInt");
        return i(nextUInt, 0, i7);
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class})
    public static final long k(@a7.d f fVar) {
        l0.p(fVar, "<this>");
        return a2.h(fVar.o());
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class})
    public static final long l(@a7.d f fVar, @a7.d w range) {
        l0.p(fVar, "<this>");
        l0.p(range, "range");
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + range);
        }
        if (o2.g(range.h(), -1L) < 0) {
            return n(fVar, range.g(), a2.h(range.h() + a2.h(((long) 1) & 4294967295L)));
        }
        if (o2.g(range.g(), 0L) <= 0) {
            return k(fVar);
        }
        long j7 = ((long) 1) & 4294967295L;
        return a2.h(n(fVar, a2.h(range.g() - a2.h(j7)), range.h()) + a2.h(j7));
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class})
    public static final long m(@a7.d f nextULong, long j7) {
        l0.p(nextULong, "$this$nextULong");
        return n(nextULong, 0L, j7);
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class})
    public static final long n(@a7.d f nextULong, long j7, long j8) {
        l0.p(nextULong, "$this$nextULong");
        b(j7, j8);
        return a2.h(nextULong.q(j7 ^ Long.MIN_VALUE, j8 ^ Long.MIN_VALUE) ^ Long.MIN_VALUE);
    }
}
