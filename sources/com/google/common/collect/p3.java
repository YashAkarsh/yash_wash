package com.google.common.collect;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
class p3<K, V> extends k3<K, V> {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int f20862v = -2;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @s1.d
    transient long[] f20863r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private transient int f20864s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private transient int f20865t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final boolean f20866u;

    class a extends k3<K, V>.d {
        a() {
            super();
        }

        @Override // com.google.common.collect.k3.d, java.util.Collection, java.lang.Iterable, java.util.Set
        public Spliterator<Map.Entry<K, V>> spliterator() {
            return Spliterators.spliterator(this, 17);
        }
    }

    class b extends k3<K, V>.f {
        b() {
            super();
        }

        @Override // com.google.common.collect.k3.f, com.google.common.collect.wb.c0, java.lang.Iterable
        public void forEach(Consumer<? super K> consumer) {
            com.google.common.base.e0.E(consumer);
            int iR = p3.this.f20864s;
            while (iR != -2) {
                consumer.accept(p3.this.f20512c[iR]);
                iR = p3.this.r(iR);
            }
        }

        @Override // com.google.common.collect.k3.f, java.util.Collection, java.lang.Iterable, java.util.Set
        public Spliterator<K> spliterator() {
            return Spliterators.spliterator(this, 17);
        }

        @Override // com.google.common.collect.k3.f, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return sd.l(this);
        }

        @Override // com.google.common.collect.k3.f, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) sd.m(this, tArr);
        }
    }

    class c extends k3<K, V>.h {
        c() {
            super();
        }

        @Override // com.google.common.collect.k3.h, com.google.common.collect.wb.r0, java.lang.Iterable
        public void forEach(Consumer<? super V> consumer) {
            com.google.common.base.e0.E(consumer);
            int iR = p3.this.f20864s;
            while (iR != -2) {
                consumer.accept(p3.this.f20513d[iR]);
                iR = p3.this.r(iR);
            }
        }

        @Override // com.google.common.collect.k3.h, java.util.Collection, java.lang.Iterable
        public Spliterator<V> spliterator() {
            return Spliterators.spliterator(this, 16);
        }

        @Override // com.google.common.collect.k3.h, java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return sd.l(this);
        }

        @Override // com.google.common.collect.k3.h, java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) sd.m(this, tArr);
        }
    }

    p3() {
        this(3);
    }

    public static <K, V> p3<K, V> P() {
        return new p3<>();
    }

    public static <K, V> p3<K, V> R(int i7) {
        return new p3<>(i7);
    }

    private int S(int i7) {
        return (int) (this.f20863r[i7] >>> 32);
    }

    private void W(int i7, int i8) {
        long[] jArr = this.f20863r;
        jArr[i7] = (jArr[i7] & 4294967295L) | (((long) i8) << 32);
    }

    private void X(int i7, int i8) {
        if (i7 == -2) {
            this.f20864s = i8;
        } else {
            Y(i7, i8);
        }
        if (i8 == -2) {
            this.f20865t = i7;
        } else {
            W(i8, i7);
        }
    }

    private void Y(int i7, int i8) {
        long[] jArr = this.f20863r;
        jArr[i7] = (jArr[i7] & (-4294967296L)) | (((long) i8) & 4294967295L);
    }

    @Override // com.google.common.collect.k3
    void B(int i7) {
        int size = size() - 1;
        X(S(i7), r(i7));
        if (i7 < size) {
            X(S(size), i7);
            X(i7, r(size));
        }
        super.B(i7);
    }

    @Override // com.google.common.collect.k3
    void I(int i7) {
        super.I(i7);
        this.f20863r = Arrays.copyOf(this.f20863r, i7);
    }

    @Override // com.google.common.collect.k3, java.util.AbstractMap, java.util.Map
    public void clear() {
        super.clear();
        this.f20864s = -2;
        this.f20865t = -2;
    }

    @Override // com.google.common.collect.k3
    void d(int i7) {
        if (this.f20866u) {
            X(S(i7), r(i7));
            X(this.f20865t, i7);
            X(i7, -2);
            this.f20515f++;
        }
    }

    @Override // com.google.common.collect.k3
    int e(int i7, int i8) {
        return i7 >= size() ? i8 : i7;
    }

    @Override // com.google.common.collect.k3, java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        com.google.common.base.e0.E(biConsumer);
        int iR = this.f20864s;
        while (iR != -2) {
            biConsumer.accept(this.f20512c[iR], this.f20513d[iR]);
            iR = r(iR);
        }
    }

    @Override // com.google.common.collect.k3
    Set<Map.Entry<K, V>> g() {
        return new a();
    }

    @Override // com.google.common.collect.k3
    Set<K> i() {
        return new b();
    }

    @Override // com.google.common.collect.k3
    Collection<V> k() {
        return new c();
    }

    @Override // com.google.common.collect.k3
    int n() {
        return this.f20864s;
    }

    @Override // com.google.common.collect.k3
    int r(int i7) {
        return (int) this.f20863r[i7];
    }

    @Override // com.google.common.collect.k3
    void w(int i7, float f8) {
        super.w(i7, f8);
        this.f20864s = -2;
        this.f20865t = -2;
        long[] jArr = new long[i7];
        this.f20863r = jArr;
        Arrays.fill(jArr, -1L);
    }

    @Override // com.google.common.collect.k3
    void y(int i7, K k7, V v7, int i8) {
        super.y(i7, k7, v7, i8);
        X(this.f20865t, i7);
        X(i7, -2);
    }

    p3(int i7) {
        this(i7, 1.0f, false);
    }

    p3(int i7, float f8, boolean z7) {
        super(i7, f8);
        this.f20866u = z7;
    }
}
