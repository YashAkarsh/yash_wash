package com.google.common.collect;

import java.io.Serializable;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
abstract class x7<K, V> extends u8<Map.Entry<K, V>> {

    @s1.c
    private static class a<K, V> implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f21403b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final v7<K, V> f21404a;

        a(v7<K, V> v7Var) {
            this.f21404a = v7Var;
        }

        Object readResolve() {
            return this.f21404a.entrySet();
        }
    }

    static final class b<K, V> extends x7<K, V> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @y1.i
        private final transient v7<K, V> f21405j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final transient d7<Map.Entry<K, V>> f21406k;

        b(v7<K, V> v7Var, Map.Entry<K, V>[] entryArr) {
            this(v7Var, d7.k(entryArr));
        }

        @Override // com.google.common.collect.x7
        v7<K, V> M() {
            return this.f21405j;
        }

        @Override // com.google.common.collect.x6
        @s1.c("not used in GWT")
        int b(Object[] objArr, int i7) {
            return this.f21406k.b(objArr, i7);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Map.Entry<K, V>> consumer) {
            this.f21406k.forEach(consumer);
        }

        @Override // com.google.common.collect.u8, com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: j */
        public ck<Map.Entry<K, V>> iterator() {
            return this.f21406k.iterator();
        }

        @Override // com.google.common.collect.x6, java.util.Collection, java.lang.Iterable, java.util.Set
        public Spliterator<Map.Entry<K, V>> spliterator() {
            return this.f21406k.spliterator();
        }

        @Override // com.google.common.collect.u8
        d7<Map.Entry<K, V>> v() {
            return new de(this, this.f21406k);
        }

        b(v7<K, V> v7Var, d7<Map.Entry<K, V>> d7Var) {
            this.f21405j = v7Var;
            this.f21406k = d7Var;
        }
    }

    x7() {
    }

    abstract v7<K, V> M();

    @Override // com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        V v7 = M().get(entry.getKey());
        return v7 != null && v7.equals(entry.getValue());
    }

    @Override // com.google.common.collect.x6
    boolean h() {
        return M().r();
    }

    @Override // com.google.common.collect.u8, java.util.Collection, java.util.Set
    public int hashCode() {
        return M().hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return M().size();
    }

    @Override // com.google.common.collect.u8, com.google.common.collect.x6
    @s1.c
    Object writeReplace() {
        return new a(M());
    }

    @Override // com.google.common.collect.u8
    @s1.c
    boolean x() {
        return M().q();
    }
}
