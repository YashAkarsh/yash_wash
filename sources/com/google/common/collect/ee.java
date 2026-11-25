package com.google.common.collect;

import java.io.Serializable;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true, serializable = true)
class ee<K, V> extends u6<K, V> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final ee<Object, Object> f20205l = new ee<>(null, null, v7.f21264e, 0, 0);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final double f20206m = 1.2d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final transient w7<K, V>[] f20207f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final transient w7<K, V>[] f20208g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @s1.d
    final transient Map.Entry<K, V>[] f20209h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final transient int f20210i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final transient int f20211j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @y1.h
    @v1.b
    private transient u6<V, K> f20212k;

    /* JADX INFO: Access modifiers changed from: private */
    final class b extends u6<V, K> {

        final class a extends x7<V, K> {

            /* JADX INFO: renamed from: com.google.common.collect.ee$b$a$a, reason: collision with other inner class name */
            class C0243a extends t6<Map.Entry<V, K>> {
                C0243a() {
                }

                @Override // com.google.common.collect.t6
                x6<Map.Entry<V, K>> W() {
                    return a.this;
                }

                @Override // java.util.List
                /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
                public Map.Entry<V, K> get(int i7) {
                    Map.Entry<K, V> entry = ee.this.f20209h[i7];
                    return wb.T(entry.getValue(), entry.getKey());
                }
            }

            a() {
            }

            @Override // com.google.common.collect.x7
            v7<V, K> M() {
                return b.this;
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Map.Entry<V, K>> consumer) {
                a().forEach(consumer);
            }

            @Override // com.google.common.collect.x7, com.google.common.collect.u8, java.util.Collection, java.util.Set
            public int hashCode() {
                return ee.this.f20211j;
            }

            @Override // com.google.common.collect.u8, com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            /* JADX INFO: renamed from: j */
            public ck<Map.Entry<V, K>> iterator() {
                return a().iterator();
            }

            @Override // com.google.common.collect.u8
            d7<Map.Entry<V, K>> v() {
                return new C0243a();
            }

            @Override // com.google.common.collect.x7, com.google.common.collect.u8
            boolean x() {
                return true;
            }
        }

        private b() {
        }

        @Override // com.google.common.collect.u6, com.google.common.collect.r0
        /* JADX INFO: renamed from: P */
        public u6<K, V> T() {
            return ee.this;
        }

        @Override // java.util.Map
        public void forEach(final BiConsumer<? super V, ? super K> biConsumer) {
            com.google.common.base.e0.E(biConsumer);
            ee.this.forEach(new BiConsumer() { // from class: com.google.common.collect.fe
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    h.a(biConsumer, obj2, obj);
                }
            });
        }

        @Override // com.google.common.collect.v7, java.util.Map
        public K get(Object obj) {
            if (obj != null && ee.this.f20208g != null) {
                for (w7 w7VarG = ee.this.f20208g[s6.c(obj.hashCode()) & ee.this.f20210i]; w7VarG != null; w7VarG = w7VarG.g()) {
                    if (obj.equals(w7VarG.getValue())) {
                        return w7VarG.getKey();
                    }
                }
            }
            return null;
        }

        @Override // com.google.common.collect.v7
        u8<Map.Entry<V, K>> k() {
            return new a();
        }

        @Override // com.google.common.collect.v7
        u8<V> l() {
            return new z7(this);
        }

        @Override // com.google.common.collect.v7
        boolean r() {
            return false;
        }

        @Override // java.util.Map
        public int size() {
            return T().size();
        }

        @Override // com.google.common.collect.u6, com.google.common.collect.v7
        Object writeReplace() {
            return new c(ee.this);
        }
    }

    private static class c<K, V> implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f20216b = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final u6<K, V> f20217a;

        c(u6<K, V> u6Var) {
            this.f20217a = u6Var;
        }

        Object readResolve() {
            return this.f20217a.T();
        }
    }

    private ee(w7<K, V>[] w7VarArr, w7<K, V>[] w7VarArr2, Map.Entry<K, V>[] entryArr, int i7, int i8) {
        this.f20207f = w7VarArr;
        this.f20208g = w7VarArr2;
        this.f20209h = entryArr;
        this.f20210i = i7;
        this.f20211j = i8;
    }

    @u1.a
    private static int f0(Object obj, Map.Entry<?, ?> entry, w7<?, ?> w7Var) {
        int i7 = 0;
        while (w7Var != null) {
            v7.d(!obj.equals(w7Var.getValue()), "value", entry, w7Var);
            i7++;
            w7Var = w7Var.g();
        }
        return i7;
    }

    static <K, V> u6<K, V> g0(Map.Entry<K, V>... entryArr) {
        return h0(entryArr.length, entryArr);
    }

    static <K, V> u6<K, V> h0(int i7, Map.Entry<K, V>[] entryArr) {
        int i8 = i7;
        Map.Entry<K, V>[] entryArr2 = entryArr;
        com.google.common.base.e0.d0(i8, entryArr2.length);
        int iA = s6.a(i8, f20206m);
        int i9 = iA - 1;
        w7[] w7VarArrC = w7.c(iA);
        w7[] w7VarArrC2 = w7.c(iA);
        Map.Entry<K, V>[] entryArrC = i8 == entryArr2.length ? entryArr2 : w7.c(i7);
        int i10 = 0;
        int i11 = 0;
        while (i10 < i8) {
            Map.Entry<K, V> entry = entryArr2[i10];
            K key = entry.getKey();
            V value = entry.getValue();
            f2.a(key, value);
            int iHashCode = key.hashCode();
            int iHashCode2 = value.hashCode();
            int iC = s6.c(iHashCode) & i9;
            int iC2 = s6.c(iHashCode2) & i9;
            w7 w7Var = w7VarArrC[iC];
            int iK = ie.K(key, entry, w7Var);
            w7 w7Var2 = w7VarArrC2[iC2];
            int i12 = i9;
            int iF0 = f0(value, entry, w7Var2);
            int i13 = i11;
            if (iK > 8 || iF0 > 8) {
                return va.d0(i7, entryArr);
            }
            w7 w7VarP = (w7Var2 == null && w7Var == null) ? ie.P(entry, key, value) : new w7.a(key, value, w7Var, w7Var2);
            w7VarArrC[iC] = w7VarP;
            w7VarArrC2[iC2] = w7VarP;
            entryArrC[i10] = w7VarP;
            i11 = i13 + (iHashCode ^ iHashCode2);
            i10++;
            i8 = i7;
            entryArr2 = entryArr;
            i9 = i12;
        }
        return new ee(w7VarArrC, w7VarArrC2, entryArrC, i9, i11);
    }

    @Override // com.google.common.collect.u6, com.google.common.collect.r0
    /* JADX INFO: renamed from: P */
    public u6<V, K> T() {
        if (isEmpty()) {
            return u6.R();
        }
        u6<V, K> u6Var = this.f20212k;
        if (u6Var != null) {
            return u6Var;
        }
        b bVar = new b();
        this.f20212k = bVar;
        return bVar;
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        com.google.common.base.e0.E(biConsumer);
        for (Map.Entry<K, V> entry : this.f20209h) {
            biConsumer.accept(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.common.collect.v7, java.util.Map
    public V get(Object obj) {
        w7<K, V>[] w7VarArr = this.f20207f;
        if (w7VarArr == null) {
            return null;
        }
        return (V) ie.N(obj, w7VarArr, this.f20210i);
    }

    @Override // com.google.common.collect.v7, java.util.Map
    public int hashCode() {
        return this.f20211j;
    }

    @Override // com.google.common.collect.v7
    u8<Map.Entry<K, V>> k() {
        return isEmpty() ? u8.A() : new x7.b(this, this.f20209h);
    }

    @Override // com.google.common.collect.v7
    u8<K> l() {
        return new z7(this);
    }

    @Override // com.google.common.collect.v7
    boolean q() {
        return true;
    }

    @Override // com.google.common.collect.v7
    boolean r() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.f20209h.length;
    }
}
