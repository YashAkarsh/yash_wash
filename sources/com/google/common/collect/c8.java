package com.google.common.collect;

import java.io.Serializable;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
final class c8<K, V> extends x6<V> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @y1.i
    private final v7<K, V> f20004c;

    class a extends ck<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ck<Map.Entry<K, V>> f20005a;

        a() {
            this.f20005a = c8.this.f20004c.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f20005a.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            return this.f20005a.next().getValue();
        }
    }

    class b extends t6<V> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d7 f20007c;

        b(d7 d7Var) {
            this.f20007c = d7Var;
        }

        @Override // com.google.common.collect.t6
        x6<V> W() {
            return c8.this;
        }

        @Override // java.util.List
        public V get(int i7) {
            return (V) ((Map.Entry) this.f20007c.get(i7)).getValue();
        }
    }

    @s1.c
    private static class c<V> implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f20009b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final v7<?, V> f20010a;

        c(v7<?, V> v7Var) {
            this.f20010a = v7Var;
        }

        Object readResolve() {
            return this.f20010a.values();
        }
    }

    c8(v7<K, V> v7Var) {
        this.f20004c = v7Var;
    }

    @Override // com.google.common.collect.x6
    public d7<V> a() {
        return new b(this.f20004c.entrySet().a());
    }

    @Override // com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return obj != null && ua.q(iterator(), obj);
    }

    @Override // java.lang.Iterable
    @s1.c
    public void forEach(final Consumer<? super V> consumer) {
        com.google.common.base.e0.E(consumer);
        this.f20004c.forEach(new BiConsumer() { // from class: com.google.common.collect.b8
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                i2.a(consumer, obj2);
            }
        });
    }

    @Override // com.google.common.collect.x6
    boolean h() {
        return true;
    }

    @Override // com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: j */
    public ck<V> iterator() {
        return new a();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.f20004c.size();
    }

    @Override // com.google.common.collect.x6, java.util.Collection, java.lang.Iterable, java.util.Set
    public Spliterator<V> spliterator() {
        return q2.e(this.f20004c.entrySet().spliterator(), new a8());
    }

    @Override // com.google.common.collect.x6
    @s1.c
    Object writeReplace() {
        return new c(this.f20004c);
    }
}
