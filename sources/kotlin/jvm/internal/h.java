package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
final class h<T> implements Iterator<T>, j5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final T[] f34855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f34856b;

    public h(@a7.d T[] array) {
        l0.p(array, "array");
        this.f34855a = array;
    }

    @a7.d
    public final T[] a() {
        return this.f34855a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f34856b < this.f34855a.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f34855a;
            int i7 = this.f34856b;
            this.f34856b = i7 + 1;
            return tArr[i7];
        } catch (ArrayIndexOutOfBoundsException e8) {
            this.f34856b--;
            throw new NoSuchElementException(e8.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
