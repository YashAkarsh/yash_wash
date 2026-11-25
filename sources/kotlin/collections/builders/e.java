package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class e<K, V> extends a<Map.Entry<K, V>, K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final d<K, V> f34496a;

    public e(@a7.d d<K, V> backing) {
        l0.p(backing, "backing");
        this.f34496a = backing;
    }

    @Override // kotlin.collections.h
    public int a() {
        return this.f34496a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(@a7.d Collection<? extends Map.Entry<K, V>> elements) {
        l0.p(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f34496a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(@a7.d Collection<? extends Object> elements) {
        l0.p(elements, "elements");
        return this.f34496a.o(elements);
    }

    @Override // kotlin.collections.builders.a
    public boolean d(@a7.d Map.Entry<? extends K, ? extends V> element) {
        l0.p(element, "element");
        return this.f34496a.q(element);
    }

    @Override // kotlin.collections.builders.a
    public boolean f(@a7.d Map.Entry element) {
        l0.p(element, "element");
        return this.f34496a.R(element);
    }

    @Override // kotlin.collections.h, java.util.AbstractCollection, java.util.Collection, java.util.Set
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public boolean add(@a7.d Map.Entry<K, V> element) {
        l0.p(element, "element");
        throw new UnsupportedOperationException();
    }

    @a7.d
    public final d<K, V> h() {
        return this.f34496a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f34496a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    @a7.d
    public Iterator<Map.Entry<K, V>> iterator() {
        return this.f34496a.w();
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(@a7.d Collection<? extends Object> elements) {
        l0.p(elements, "elements");
        this.f34496a.m();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(@a7.d Collection<? extends Object> elements) {
        l0.p(elements, "elements");
        this.f34496a.m();
        return super.retainAll(elements);
    }
}
