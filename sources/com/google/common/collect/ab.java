package com.google.common.collect;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(serializable = true)
final class ab<E> extends fa<E> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Set<?> f19863j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final d7<E> f19864k;

    ab(Set<?> set, d7<E> d7Var) {
        this.f19863j = set;
        this.f19864k = d7Var;
    }

    @Override // com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f19863j.contains(obj);
    }

    @Override // com.google.common.collect.fa
    E get(int i7) {
        return this.f19864k.get(i7);
    }

    @Override // com.google.common.collect.x6
    boolean h() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f19864k.size();
    }
}
