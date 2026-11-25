package com.google.common.hash;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
public final class k<T> implements com.google.common.base.g0<T>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l.c f21827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f21828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final p<? super T> f21829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f21830d;

    private static class b<T> implements Serializable {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final long f21831e = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long[] f21832a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f21833b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final p<? super T> f21834c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final c f21835d;

        b(k<T> kVar) {
            this.f21832a = l.c.g(((k) kVar).f21827a.f21840a);
            this.f21833b = ((k) kVar).f21828b;
            this.f21834c = ((k) kVar).f21829c;
            this.f21835d = ((k) kVar).f21830d;
        }

        Object readResolve() {
            return new k(new l.c(this.f21832a), this.f21833b, this.f21834c, this.f21835d);
        }
    }

    interface c extends Serializable {
        <T> boolean G(T t7, p<? super T> pVar, int i7, l.c cVar);

        int ordinal();

        <T> boolean s(T t7, p<? super T> pVar, int i7, l.c cVar);
    }

    public static <T> Collector<T, ?, k<T>> A(final p<? super T> pVar, final long j7, final double d8) {
        com.google.common.base.e0.E(pVar);
        com.google.common.base.e0.p(j7 >= 0, "Expected insertions (%s) must be >= 0", j7);
        com.google.common.base.e0.u(d8 > 0.0d, "False positive probability (%s) must be > 0.0", Double.valueOf(d8));
        com.google.common.base.e0.u(d8 < 1.0d, "False positive probability (%s) must be < 1.0", Double.valueOf(d8));
        return Collector.of(new Supplier() { // from class: com.google.common.hash.h
            @Override // java.util.function.Supplier
            public final Object get() {
                return k.m(pVar, j7, d8);
            }
        }, new BiConsumer() { // from class: com.google.common.hash.i
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((k) obj).w(obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.hash.j
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return k.r((k) obj, (k) obj2);
            }
        }, Collector.Characteristics.UNORDERED, Collector.Characteristics.CONCURRENT);
    }

    public static <T> k<T> j(p<? super T> pVar, int i7) {
        return l(pVar, i7);
    }

    public static <T> k<T> k(p<? super T> pVar, int i7, double d8) {
        return m(pVar, i7, d8);
    }

    public static <T> k<T> l(p<? super T> pVar, long j7) {
        return m(pVar, j7, 0.03d);
    }

    public static <T> k<T> m(p<? super T> pVar, long j7, double d8) {
        return n(pVar, j7, d8, l.f21837b);
    }

    @s1.d
    static <T> k<T> n(p<? super T> pVar, long j7, double d8, c cVar) {
        com.google.common.base.e0.E(pVar);
        com.google.common.base.e0.p(j7 >= 0, "Expected insertions (%s) must be >= 0", j7);
        com.google.common.base.e0.u(d8 > 0.0d, "False positive probability (%s) must be > 0.0", Double.valueOf(d8));
        com.google.common.base.e0.u(d8 < 1.0d, "False positive probability (%s) must be < 1.0", Double.valueOf(d8));
        com.google.common.base.e0.E(cVar);
        if (j7 == 0) {
            j7 = 1;
        }
        long jU = u(j7, d8);
        try {
            return new k<>(new l.c(jU), v(j7, jU), pVar, cVar);
        } catch (IllegalArgumentException e8) {
            throw new IllegalArgumentException("Could not create BloomFilter of " + jU + " bits", e8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ k r(k kVar, k kVar2) {
        kVar.x(kVar2);
        return kVar;
    }

    @s1.d
    static long u(long j7, double d8) {
        if (d8 == 0.0d) {
            d8 = Double.MIN_VALUE;
        }
        return (long) (((-j7) * Math.log(d8)) / (Math.log(2.0d) * Math.log(2.0d)));
    }

    @s1.d
    static int v(long j7, long j8) {
        return Math.max(1, (int) Math.round((j8 / j7) * Math.log(2.0d)));
    }

    private Object writeReplace() {
        return new b(this);
    }

    public static <T> k<T> y(InputStream inputStream, p<? super T> pVar) throws IOException {
        int i7;
        int iP;
        com.google.common.base.e0.F(inputStream, "InputStream");
        com.google.common.base.e0.F(pVar, "Funnel");
        int i8 = -1;
        try {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            byte b8 = dataInputStream.readByte();
            try {
                iP = com.google.common.primitives.i0.p(dataInputStream.readByte());
                try {
                    i8 = dataInputStream.readInt();
                    l lVar = l.values()[b8];
                    long[] jArr = new long[i8];
                    for (int i9 = 0; i9 < i8; i9++) {
                        jArr[i9] = dataInputStream.readLong();
                    }
                    return new k<>(new l.c(jArr), iP, pVar, lVar);
                } catch (RuntimeException e8) {
                    e = e8;
                    int i10 = i8;
                    i8 = b8;
                    i7 = i10;
                    throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + i8 + " numHashFunctions: " + iP + " dataLength: " + i7, e);
                }
            } catch (RuntimeException e9) {
                e = e9;
                iP = -1;
                i8 = b8;
                i7 = -1;
            }
        } catch (RuntimeException e10) {
            e = e10;
            i7 = -1;
            iP = -1;
        }
    }

    public static <T> Collector<T, ?, k<T>> z(p<? super T> pVar, long j7) {
        return A(pVar, j7, 0.03d);
    }

    public void B(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeByte(com.google.common.primitives.h0.a(this.f21830d.ordinal()));
        dataOutputStream.writeByte(com.google.common.primitives.i0.a(this.f21828b));
        dataOutputStream.writeInt(this.f21827a.f21840a.length());
        for (int i7 = 0; i7 < this.f21827a.f21840a.length(); i7++) {
            dataOutputStream.writeLong(this.f21827a.f21840a.get(i7));
        }
    }

    @Override // com.google.common.base.g0
    @Deprecated
    public boolean apply(T t7) {
        return t(t7);
    }

    @Override // com.google.common.base.g0
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f21828b == kVar.f21828b && this.f21829c.equals(kVar.f21829c) && this.f21827a.equals(kVar.f21827a) && this.f21830d.equals(kVar.f21830d);
    }

    public long g() {
        double dB = this.f21827a.b();
        return com.google.common.math.b.q(((-Math.log1p(-(this.f21827a.a() / dB))) * dB) / ((double) this.f21828b), RoundingMode.HALF_UP);
    }

    @s1.d
    long h() {
        return this.f21827a.b();
    }

    public int hashCode() {
        return com.google.common.base.y.b(Integer.valueOf(this.f21828b), this.f21829c, this.f21830d, this.f21827a);
    }

    public k<T> i() {
        return new k<>(this.f21827a.c(), this.f21828b, this.f21829c, this.f21830d);
    }

    public double o() {
        return Math.pow(this.f21827a.a() / h(), this.f21828b);
    }

    public boolean p(k<T> kVar) {
        com.google.common.base.e0.E(kVar);
        return this != kVar && this.f21828b == kVar.f21828b && h() == kVar.h() && this.f21830d.equals(kVar.f21830d) && this.f21829c.equals(kVar.f21829c);
    }

    public boolean t(T t7) {
        return this.f21830d.s(t7, this.f21829c, this.f21828b, this.f21827a);
    }

    @Override // com.google.common.base.g0, java.util.function.Predicate
    public /* synthetic */ boolean test(Object obj) {
        return com.google.common.base.f0.a(this, obj);
    }

    @u1.a
    public boolean w(T t7) {
        return this.f21830d.G(t7, this.f21829c, this.f21828b, this.f21827a);
    }

    public void x(k<T> kVar) {
        com.google.common.base.e0.E(kVar);
        com.google.common.base.e0.e(this != kVar, "Cannot combine a BloomFilter with itself.");
        int i7 = this.f21828b;
        int i8 = kVar.f21828b;
        com.google.common.base.e0.m(i7 == i8, "BloomFilters must have the same number of hash functions (%s != %s)", i7, i8);
        com.google.common.base.e0.s(h() == kVar.h(), "BloomFilters must have the same size underlying bit arrays (%s != %s)", h(), kVar.h());
        com.google.common.base.e0.y(this.f21830d.equals(kVar.f21830d), "BloomFilters must have equal strategies (%s != %s)", this.f21830d, kVar.f21830d);
        com.google.common.base.e0.y(this.f21829c.equals(kVar.f21829c), "BloomFilters must have equal funnels (%s != %s)", this.f21829c, kVar.f21829c);
        this.f21827a.e(kVar.f21827a);
    }

    private k(l.c cVar, int i7, p<? super T> pVar, c cVar2) {
        com.google.common.base.e0.k(i7 > 0, "numHashFunctions (%s) must be > 0", i7);
        com.google.common.base.e0.k(i7 <= 255, "numHashFunctions (%s) must be <= 255", i7);
        this.f21827a = (l.c) com.google.common.base.e0.E(cVar);
        this.f21828b = i7;
        this.f21829c = (p) com.google.common.base.e0.E(pVar);
        this.f21830d = (c) com.google.common.base.e0.E(cVar2);
    }
}
