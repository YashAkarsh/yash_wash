package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
final class j<T> implements Collection<T>, j5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final T[] f34537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f34538b;

    public j(@a7.d T[] values, boolean z7) {
        kotlin.jvm.internal.l0.p(values, "values");
        this.f34537a = values;
        this.f34538b = z7;
    }

    public int a() {
        return this.f34537a.length;
    }

    @Override // java.util.Collection
    public boolean add(T t7) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @a7.d
    public final T[] b() {
        return this.f34537a;
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return p.T8(this.f34537a, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(@a7.d Collection<? extends Object> elements) {
        kotlin.jvm.internal.l0.p(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        Iterator<T> it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean d() {
        return this.f34538b;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f34537a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    @a7.d
    public Iterator<T> iterator() {
        return kotlin.jvm.internal.i.a(this.f34537a);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.l0.p(array, "array");
        return (T[]) kotlin.jvm.internal.v.b(this, array);
    }

    @Override // java.util.Collection
    @a7.d
    public final Object[] toArray() {
        return x.i(this.f34537a, this.f34538b);
    }
}
