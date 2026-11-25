package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class f<E> extends kotlin.collections.h<E> implements Set<E>, j5.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final d<E, ?> f34497a;

    public f(@a7.d d<E, ?> backing) {
        l0.p(backing, "backing");
        this.f34497a = backing;
    }

    @Override // kotlin.collections.h
    public int a() {
        return this.f34497a.size();
    }

    @Override // kotlin.collections.h, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e8) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(@a7.d Collection<? extends E> elements) {
        l0.p(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f34497a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f34497a.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f34497a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    @a7.d
    public Iterator<E> iterator() {
        return this.f34497a.L();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this.f34497a.W(obj) >= 0;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(@a7.d Collection<? extends Object> elements) {
        l0.p(elements, "elements");
        this.f34497a.m();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(@a7.d Collection<? extends Object> elements) {
        l0.p(elements, "elements");
        this.f34497a.m();
        return super.retainAll(elements);
    }
}
