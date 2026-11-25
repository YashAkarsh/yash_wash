package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class g<V> extends kotlin.collections.e<V> implements Collection<V>, j5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final d<?, V> f34498a;

    public g(@a7.d d<?, V> backing) {
        l0.p(backing, "backing");
        this.f34498a = backing;
    }

    @Override // kotlin.collections.e
    public int a() {
        return this.f34498a.size();
    }

    @Override // kotlin.collections.e, java.util.AbstractCollection, java.util.Collection
    public boolean add(V v7) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(@a7.d Collection<? extends V> elements) {
        l0.p(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @a7.d
    public final d<?, V> b() {
        return this.f34498a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f34498a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f34498a.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.f34498a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    @a7.d
    public Iterator<V> iterator() {
        return this.f34498a.Z();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        return this.f34498a.Y(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(@a7.d Collection<? extends Object> elements) {
        l0.p(elements, "elements");
        this.f34498a.m();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(@a7.d Collection<? extends Object> elements) {
        l0.p(elements, "elements");
        this.f34498a.m();
        return super.retainAll(elements);
    }
}
