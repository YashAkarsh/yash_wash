package com.google.common.collect;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
abstract class fa<E> extends u8<E> {

    class a extends t6<E> {
        a() {
        }

        @Override // com.google.common.collect.t6
        x6<E> W() {
            return fa.this;
        }

        @Override // java.util.List
        public E get(int i7) {
            return (E) fa.this.get(i7);
        }

        @Override // com.google.common.collect.t6, com.google.common.collect.x6
        boolean h() {
            return fa.this.h();
        }

        @Override // com.google.common.collect.t6, java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return fa.this.size();
        }
    }

    fa() {
    }

    @Override // com.google.common.collect.x6
    @s1.c
    int b(Object[] objArr, int i7) {
        return a().b(objArr, i7);
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> consumer) {
        com.google.common.base.e0.E(consumer);
        int size = size();
        for (int i7 = 0; i7 < size; i7++) {
            consumer.accept(get(i7));
        }
    }

    abstract E get(int i7);

    @Override // com.google.common.collect.u8, com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: j */
    public ck<E> iterator() {
        return a().iterator();
    }

    @Override // com.google.common.collect.x6, java.util.Collection, java.lang.Iterable, java.util.Set
    public Spliterator<E> spliterator() {
        return q2.c(size(), 1297, new IntFunction() { // from class: com.google.common.collect.ea
            @Override // java.util.function.IntFunction
            public final Object apply(int i7) {
                return this.f20202a.get(i7);
            }
        });
    }

    @Override // com.google.common.collect.u8
    d7<E> v() {
        return new a();
    }
}
