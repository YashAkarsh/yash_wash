package kotlin.collections.builders;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class j<E> extends kotlin.collections.h<E> implements Set<E>, Serializable, j5.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final d<E, ?> f34508a;

    public j(@a7.d d<E, ?> backing) {
        l0.p(backing, "backing");
        this.f34508a = backing;
    }

    private final Object writeReplace() throws NotSerializableException {
        if (this.f34508a.K()) {
            return new h(this, 1);
        }
        throw new NotSerializableException("The set cannot be serialized while it is being built.");
    }

    @Override // kotlin.collections.h
    public int a() {
        return this.f34508a.size();
    }

    @Override // kotlin.collections.h, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e8) {
        return this.f34508a.i(e8) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(@a7.d Collection<? extends E> elements) {
        l0.p(elements, "elements");
        this.f34508a.m();
        return super.addAll(elements);
    }

    @a7.d
    public final Set<E> b() {
        this.f34508a.l();
        return this;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f34508a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f34508a.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f34508a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    @a7.d
    public Iterator<E> iterator() {
        return this.f34508a.L();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this.f34508a.W(obj) >= 0;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(@a7.d Collection<? extends Object> elements) {
        l0.p(elements, "elements");
        this.f34508a.m();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(@a7.d Collection<? extends Object> elements) {
        l0.p(elements, "elements");
        this.f34508a.m();
        return super.retainAll(elements);
    }

    public j() {
        this(new d());
    }

    public j(int i7) {
        this(new d(i7));
    }
}
