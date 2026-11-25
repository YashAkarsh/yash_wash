package com.google.common.hash;

import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
abstract class l implements k.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f21836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f21837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ l[] f21838c;

    static enum a extends l {
        a(String str, int i7) {
            super(str, i7, null);
        }

        @Override // com.google.common.hash.k.c
        public <T> boolean G(T t7, p<? super T> pVar, int i7, c cVar) {
            long jB = cVar.b();
            long jC = v.w().d(t7, pVar).c();
            int i8 = (int) jC;
            int i9 = (int) (jC >>> 32);
            boolean zF = false;
            for (int i10 = 1; i10 <= i7; i10++) {
                int i11 = (i10 * i9) + i8;
                if (i11 < 0) {
                    i11 = ~i11;
                }
                zF |= cVar.f(((long) i11) % jB);
            }
            return zF;
        }

        @Override // com.google.common.hash.k.c
        public <T> boolean s(T t7, p<? super T> pVar, int i7, c cVar) {
            long jB = cVar.b();
            long jC = v.w().d(t7, pVar).c();
            int i8 = (int) jC;
            int i9 = (int) (jC >>> 32);
            for (int i10 = 1; i10 <= i7; i10++) {
                int i11 = (i10 * i9) + i8;
                if (i11 < 0) {
                    i11 = ~i11;
                }
                if (!cVar.d(((long) i11) % jB)) {
                    return false;
                }
            }
            return true;
        }
    }

    static final class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int f21839c = 6;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicLongArray f21840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a0 f21841b;

        c(long j7) {
            this(new long[com.google.common.primitives.c0.d(com.google.common.math.f.g(j7, 64L, RoundingMode.CEILING))]);
        }

        public static long[] g(AtomicLongArray atomicLongArray) {
            int length = atomicLongArray.length();
            long[] jArr = new long[length];
            for (int i7 = 0; i7 < length; i7++) {
                jArr[i7] = atomicLongArray.get(i7);
            }
            return jArr;
        }

        long a() {
            return this.f21841b.b();
        }

        long b() {
            return ((long) this.f21840a.length()) * 64;
        }

        c c() {
            return new c(g(this.f21840a));
        }

        boolean d(long j7) {
            return ((1 << ((int) j7)) & this.f21840a.get((int) (j7 >>> 6))) != 0;
        }

        void e(c cVar) {
            long j7;
            long j8;
            boolean z7;
            com.google.common.base.e0.m(this.f21840a.length() == cVar.f21840a.length(), "BitArrays must be of equal length (%s != %s)", this.f21840a.length(), cVar.f21840a.length());
            for (int i7 = 0; i7 < this.f21840a.length(); i7++) {
                long j9 = cVar.f21840a.get(i7);
                while (true) {
                    j7 = this.f21840a.get(i7);
                    j8 = j7 | j9;
                    if (j7 != j8) {
                        if (this.f21840a.compareAndSet(i7, j7, j8)) {
                            z7 = true;
                            break;
                        }
                    } else {
                        z7 = false;
                        break;
                    }
                }
                if (z7) {
                    this.f21841b.c(Long.bitCount(j8) - Long.bitCount(j7));
                }
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return Arrays.equals(g(this.f21840a), g(((c) obj).f21840a));
            }
            return false;
        }

        boolean f(long j7) {
            long j8;
            long j9;
            if (d(j7)) {
                return false;
            }
            int i7 = (int) (j7 >>> 6);
            long j10 = 1 << ((int) j7);
            do {
                j8 = this.f21840a.get(i7);
                j9 = j8 | j10;
                if (j8 == j9) {
                    return false;
                }
            } while (!this.f21840a.compareAndSet(i7, j8, j9));
            this.f21841b.a();
            return true;
        }

        public int hashCode() {
            return Arrays.hashCode(g(this.f21840a));
        }

        c(long[] jArr) {
            com.google.common.base.e0.e(jArr.length > 0, "data length is zero!");
            this.f21840a = new AtomicLongArray(jArr);
            this.f21841b = b0.a();
            long jBitCount = 0;
            for (long j7 : jArr) {
                jBitCount += (long) Long.bitCount(j7);
            }
            this.f21841b.c(jBitCount);
        }
    }

    static {
        a aVar = new a("MURMUR128_MITZ_32", 0);
        f21836a = aVar;
        l lVar = new l("MURMUR128_MITZ_64", 1) { // from class: com.google.common.hash.l.b
            {
                a aVar2 = null;
            }

            private long a(byte[] bArr) {
                return com.google.common.primitives.d0.j(bArr[7], bArr[6], bArr[5], bArr[4], bArr[3], bArr[2], bArr[1], bArr[0]);
            }

            private long b(byte[] bArr) {
                return com.google.common.primitives.d0.j(bArr[15], bArr[14], bArr[13], bArr[12], bArr[11], bArr[10], bArr[9], bArr[8]);
            }

            @Override // com.google.common.hash.k.c
            public <T> boolean G(T t7, p<? super T> pVar, int i7, c cVar) {
                long jB = cVar.b();
                byte[] bArrL = v.w().d(t7, pVar).l();
                long jA = a(bArrL);
                long jB2 = b(bArrL);
                boolean zF = false;
                for (int i8 = 0; i8 < i7; i8++) {
                    zF |= cVar.f((Long.MAX_VALUE & jA) % jB);
                    jA += jB2;
                }
                return zF;
            }

            @Override // com.google.common.hash.k.c
            public <T> boolean s(T t7, p<? super T> pVar, int i7, c cVar) {
                long jB = cVar.b();
                byte[] bArrL = v.w().d(t7, pVar).l();
                long jA = a(bArrL);
                long jB2 = b(bArrL);
                for (int i8 = 0; i8 < i7; i8++) {
                    if (!cVar.d((Long.MAX_VALUE & jA) % jB)) {
                        return false;
                    }
                    jA += jB2;
                }
                return true;
            }
        };
        f21837b = lVar;
        f21838c = new l[]{aVar, lVar};
    }

    private l(String str, int i7) {
        super(str, i7);
    }

    public static l valueOf(String str) {
        return (l) Enum.valueOf(l.class, str);
    }

    public static l[] values() {
        return (l[]) f21838c.clone();
    }

    /* synthetic */ l(String str, int i7, a aVar) {
        this(str, i7);
    }
}
