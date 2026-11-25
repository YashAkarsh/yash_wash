package kotlin.collections;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class t0<T> implements Iterator<r0<? extends T>>, j5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final Iterator<T> f34620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f34621b;

    /* JADX WARN: Multi-variable type inference failed */
    public t0(@a7.d Iterator<? extends T> iterator) {
        kotlin.jvm.internal.l0.p(iterator, "iterator");
        this.f34620a = iterator;
    }

    @Override // java.util.Iterator
    @a7.d
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final r0<T> next() {
        int i7 = this.f34621b;
        this.f34621b = i7 + 1;
        if (i7 < 0) {
            y.X();
        }
        return new r0<>(i7, this.f34620a.next());
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f34620a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
