package kotlin.collections;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class i1<T> extends f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final List<T> f34536a;

    public i1(@a7.d List<T> delegate) {
        kotlin.jvm.internal.l0.p(delegate, "delegate");
        this.f34536a = delegate;
    }

    @Override // kotlin.collections.f
    public int a() {
        return this.f34536a.size();
    }

    @Override // kotlin.collections.f, java.util.AbstractList, java.util.List
    public void add(int i7, T t7) {
        this.f34536a.add(e0.Z0(this, i7), t7);
    }

    @Override // kotlin.collections.f
    public T b(int i7) {
        return this.f34536a.remove(e0.Y0(this, i7));
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f34536a.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i7) {
        return this.f34536a.get(e0.Y0(this, i7));
    }

    @Override // kotlin.collections.f, java.util.AbstractList, java.util.List
    public T set(int i7, T t7) {
        return this.f34536a.set(e0.Y0(this, i7), t7);
    }
}
