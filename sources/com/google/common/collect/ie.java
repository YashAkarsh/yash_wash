package com.google.common.collect;

import com.haier.uhome.account.api.RetInfoContent;
import java.io.Serializable;
import java.util.Map;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true, serializable = true)
final class ie<K, V> extends v7<K, V> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final v7<Object, Object> f20444i = new ie(v7.f21264e, null, 0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @s1.d
    static final double f20445j = 1.2d;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @s1.d
    static final double f20446k = 0.001d;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @s1.d
    static final int f20447l = 8;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final long f20448m = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @s1.d
    final transient Map.Entry<K, V>[] f20449f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final transient w7<K, V>[] f20450g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final transient int f20451h;

    @s1.b(emulated = true)
    private static final class a<K, V> extends fa<K> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @y1.i
        private final ie<K, V> f20452j;

        /* JADX INFO: renamed from: com.google.common.collect.ie$a$a, reason: collision with other inner class name */
        @s1.c
        private static class C0248a<K> implements Serializable {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private static final long f20453b = 0;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final v7<K, ?> f20454a;

            C0248a(v7<K, ?> v7Var) {
                this.f20454a = v7Var;
            }

            Object readResolve() {
                return this.f20454a.keySet();
            }
        }

        a(ie<K, V> ieVar) {
            this.f20452j = ieVar;
        }

        @Override // com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f20452j.containsKey(obj);
        }

        @Override // com.google.common.collect.fa
        K get(int i7) {
            return this.f20452j.f20449f[i7].getKey();
        }

        @Override // com.google.common.collect.x6
        boolean h() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f20452j.size();
        }

        @Override // com.google.common.collect.u8, com.google.common.collect.x6
        @s1.c
        Object writeReplace() {
            return new C0248a(this.f20452j);
        }
    }

    @s1.b(emulated = true)
    private static final class b<K, V> extends d7<V> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @y1.i
        final ie<K, V> f20455c;

        @s1.c
        private static class a<V> implements Serializable {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private static final long f20456b = 0;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final v7<?, V> f20457a;

            a(v7<?, V> v7Var) {
                this.f20457a = v7Var;
            }

            Object readResolve() {
                return this.f20457a.values();
            }
        }

        b(ie<K, V> ieVar) {
            this.f20455c = ieVar;
        }

        @Override // java.util.List
        public V get(int i7) {
            return this.f20455c.f20449f[i7].getValue();
        }

        @Override // com.google.common.collect.x6
        boolean h() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f20455c.size();
        }

        @Override // com.google.common.collect.d7, com.google.common.collect.x6
        @s1.c
        Object writeReplace() {
            return new a(this.f20455c);
        }
    }

    private ie(Map.Entry<K, V>[] entryArr, w7<K, V>[] w7VarArr, int i7) {
        this.f20449f = entryArr;
        this.f20450g = w7VarArr;
        this.f20451h = i7;
    }

    @u1.a
    static int K(Object obj, Map.Entry<?, ?> entry, w7<?, ?> w7Var) {
        int i7 = 0;
        while (w7Var != null) {
            v7.d(!obj.equals(w7Var.getKey()), RetInfoContent.BindKEY_ISNULL, entry, w7Var);
            i7++;
            w7Var = w7Var.e();
        }
        return i7;
    }

    static <K, V> v7<K, V> L(Map.Entry<K, V>... entryArr) {
        return M(entryArr.length, entryArr);
    }

    static <K, V> v7<K, V> M(int i7, Map.Entry<K, V>[] entryArr) {
        com.google.common.base.e0.d0(i7, entryArr.length);
        if (i7 == 0) {
            return (ie) f20444i;
        }
        Map.Entry<K, V>[] entryArrC = i7 == entryArr.length ? entryArr : w7.c(i7);
        int iA = s6.a(i7, f20445j);
        w7[] w7VarArrC = w7.c(iA);
        int i8 = iA - 1;
        for (int i9 = 0; i9 < i7; i9++) {
            Map.Entry<K, V> entry = entryArr[i9];
            K key = entry.getKey();
            V value = entry.getValue();
            f2.a(key, value);
            int iC = s6.c(key.hashCode()) & i8;
            w7 w7Var = w7VarArrC[iC];
            w7 w7VarP = w7Var == null ? P(entry, key, value) : new w7.b(key, value, w7Var);
            w7VarArrC[iC] = w7VarP;
            entryArrC[i9] = w7VarP;
            if (K(key, w7VarP, w7Var) > 8) {
                return xa.L(i7, entryArr);
            }
        }
        return new ie(entryArrC, w7VarArrC, i8);
    }

    static <V> V N(Object obj, w7<?, V>[] w7VarArr, int i7) {
        if (obj != null && w7VarArr != null) {
            for (w7<?, V> w7VarE = w7VarArr[i7 & s6.c(obj.hashCode())]; w7VarE != null; w7VarE = w7VarE.e()) {
                if (obj.equals(w7VarE.getKey())) {
                    return w7VarE.getValue();
                }
            }
        }
        return null;
    }

    static <K, V> w7<K, V> O(Map.Entry<K, V> entry) {
        return P(entry, entry.getKey(), entry.getValue());
    }

    static <K, V> w7<K, V> P(Map.Entry<K, V> entry, K k7, V v7) {
        return (entry instanceof w7) && ((w7) entry).h() ? (w7) entry : new w7<>(k7, v7);
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        com.google.common.base.e0.E(biConsumer);
        for (Map.Entry<K, V> entry : this.f20449f) {
            biConsumer.accept(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.common.collect.v7, java.util.Map
    public V get(Object obj) {
        return (V) N(obj, this.f20450g, this.f20451h);
    }

    @Override // com.google.common.collect.v7
    u8<Map.Entry<K, V>> k() {
        return new x7.b(this, this.f20449f);
    }

    @Override // com.google.common.collect.v7
    u8<K> l() {
        return new a(this);
    }

    @Override // com.google.common.collect.v7
    x6<V> m() {
        return new b(this);
    }

    @Override // com.google.common.collect.v7
    boolean r() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.f20449f.length;
    }
}
