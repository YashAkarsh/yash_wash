package com.google.common.collect;

import java.io.Serializable;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
final class z7<K, V> extends fa<K> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @y1.i
    private final v7<K, V> f21483j;

    @s1.c
    private static class a<K> implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f21484b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final v7<K, ?> f21485a;

        a(v7<K, ?> v7Var) {
            this.f21485a = v7Var;
        }

        Object readResolve() {
            return this.f21485a.keySet();
        }
    }

    z7(v7<K, V> v7Var) {
        this.f21483j = v7Var;
    }

    @Override // com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f21483j.containsKey(obj);
    }

    @Override // com.google.common.collect.fa, java.lang.Iterable
    public void forEach(final Consumer<? super K> consumer) {
        com.google.common.base.e0.E(consumer);
        this.f21483j.forEach(new BiConsumer() { // from class: com.google.common.collect.y7
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                i2.a(consumer, obj);
            }
        });
    }

    @Override // com.google.common.collect.fa
    K get(int i7) {
        return this.f21483j.entrySet().a().get(i7).getKey();
    }

    @Override // com.google.common.collect.x6
    boolean h() {
        return true;
    }

    @Override // com.google.common.collect.fa, com.google.common.collect.u8, com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: j */
    public ck<K> iterator() {
        return this.f21483j.t();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f21483j.size();
    }

    @Override // com.google.common.collect.fa, com.google.common.collect.x6, java.util.Collection, java.lang.Iterable, java.util.Set
    public Spliterator<K> spliterator() {
        return this.f21483j.w();
    }

    @Override // com.google.common.collect.u8, com.google.common.collect.x6
    @s1.c
    Object writeReplace() {
        return new a(this.f21483j);
    }
}
