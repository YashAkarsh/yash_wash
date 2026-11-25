package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
final class n4<E> extends s9<E> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final s9<E> f20710m;

    n4(s9<E> s9Var) {
        super(td.i(s9Var.comparator()).F());
        this.f20710m = s9Var;
    }

    @Override // com.google.common.collect.s9
    s9<E> F0(E e8, boolean z7, E e9, boolean z8) {
        return this.f20710m.subSet(e9, z8, e8, z7).descendingSet();
    }

    @Override // com.google.common.collect.s9
    s9<E> I0(E e8, boolean z7) {
        return this.f20710m.headSet(e8, z7).descendingSet();
    }

    @Override // com.google.common.collect.s9, java.util.NavigableSet
    public E ceiling(E e8) {
        return this.f20710m.floor(e8);
    }

    @Override // com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f20710m.contains(obj);
    }

    @Override // com.google.common.collect.s9, java.util.NavigableSet
    public E floor(E e8) {
        return this.f20710m.ceiling(e8);
    }

    @Override // com.google.common.collect.x6
    boolean h() {
        return this.f20710m.h();
    }

    @Override // com.google.common.collect.s9, java.util.NavigableSet
    public E higher(E e8) {
        return this.f20710m.lower(e8);
    }

    @Override // com.google.common.collect.s9
    @s1.c("NavigableSet")
    s9<E> i0() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.s9
    int indexOf(Object obj) {
        int iIndexOf = this.f20710m.indexOf(obj);
        return iIndexOf == -1 ? iIndexOf : (size() - 1) - iIndexOf;
    }

    @Override // com.google.common.collect.s9, com.google.common.collect.u8, com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: j */
    public ck<E> iterator() {
        return this.f20710m.descendingIterator();
    }

    @Override // com.google.common.collect.s9, java.util.NavigableSet
    @s1.c("NavigableSet")
    /* JADX INFO: renamed from: j0 */
    public ck<E> descendingIterator() {
        return this.f20710m.iterator();
    }

    @Override // com.google.common.collect.s9, java.util.NavigableSet
    @s1.c("NavigableSet")
    /* JADX INFO: renamed from: k0 */
    public s9<E> descendingSet() {
        return this.f20710m;
    }

    @Override // com.google.common.collect.s9, java.util.NavigableSet
    public E lower(E e8) {
        return this.f20710m.higher(e8);
    }

    @Override // com.google.common.collect.s9
    s9<E> q0(E e8, boolean z7) {
        return this.f20710m.tailSet(e8, z7).descendingSet();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f20710m.size();
    }
}
