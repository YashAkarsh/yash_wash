package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.g1(version = "1.1")
public abstract class a<E> implements Collection<E>, j5.a {

    /* JADX INFO: renamed from: kotlin.collections.a$a, reason: collision with other inner class name */
    static final class C0421a extends kotlin.jvm.internal.n0 implements i5.l<E, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a<E> f34459a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C0421a(a<? extends E> aVar) {
            super(1);
            this.f34459a = aVar;
        }

        @Override // i5.l
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CharSequence z(E e8) {
            return e8 == this.f34459a ? "(this Collection)" : String.valueOf(e8);
        }
    }

    protected a() {
    }

    public abstract int a();

    @Override // java.util.Collection
    public boolean add(E e8) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(E e8) {
        if (isEmpty()) {
            return false;
        }
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.l0.g(it.next(), e8)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
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

    @Override // java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    @a7.d
    public abstract Iterator<E> iterator();

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
    @a7.d
    public Object[] toArray() {
        return kotlin.jvm.internal.v.a(this);
    }

    @a7.d
    public String toString() {
        return g0.h3(this, ", ", "[", "]", 0, null, new C0421a(this), 24, null);
    }

    @Override // java.util.Collection
    @a7.d
    public <T> T[] toArray(@a7.d T[] array) {
        kotlin.jvm.internal.l0.p(array, "array");
        T[] tArr = (T[]) kotlin.jvm.internal.v.b(this, array);
        kotlin.jvm.internal.l0.n(tArr, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.CollectionsKt__CollectionsJVMKt.copyToArrayImpl>");
        return tArr;
    }
}
