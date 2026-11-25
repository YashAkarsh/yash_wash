package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.g1(version = "1.1")
public abstract class c<E> extends kotlin.collections.a<E> implements List<E>, j5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final a f34509a = new a(null);

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
            this();
        }

        public final void a(int i7, int i8, int i9) {
            if (i7 < 0 || i8 > i9) {
                throw new IndexOutOfBoundsException("startIndex: " + i7 + ", endIndex: " + i8 + ", size: " + i9);
            }
            if (i7 <= i8) {
                return;
            }
            throw new IllegalArgumentException("startIndex: " + i7 + " > endIndex: " + i8);
        }

        public final void b(int i7, int i8) {
            if (i7 < 0 || i7 >= i8) {
                throw new IndexOutOfBoundsException("index: " + i7 + ", size: " + i8);
            }
        }

        public final void c(int i7, int i8) {
            if (i7 < 0 || i7 > i8) {
                throw new IndexOutOfBoundsException("index: " + i7 + ", size: " + i8);
            }
        }

        public final void d(int i7, int i8, int i9) {
            if (i7 < 0 || i8 > i9) {
                throw new IndexOutOfBoundsException("fromIndex: " + i7 + ", toIndex: " + i8 + ", size: " + i9);
            }
            if (i7 <= i8) {
                return;
            }
            throw new IllegalArgumentException("fromIndex: " + i7 + " > toIndex: " + i8);
        }

        public final boolean e(@a7.d Collection<?> c8, @a7.d Collection<?> other) {
            kotlin.jvm.internal.l0.p(c8, "c");
            kotlin.jvm.internal.l0.p(other, "other");
            if (c8.size() != other.size()) {
                return false;
            }
            Iterator<?> it = other.iterator();
            Iterator<?> it2 = c8.iterator();
            while (it2.hasNext()) {
                if (!kotlin.jvm.internal.l0.g(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int f(@a7.d Collection<?> c8) {
            kotlin.jvm.internal.l0.p(c8, "c");
            Iterator<?> it = c8.iterator();
            int iHashCode = 1;
            while (it.hasNext()) {
                Object next = it.next();
                iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
            }
            return iHashCode;
        }

        private a() {
        }
    }

    private class b implements Iterator<E>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f34510a;

        public b() {
        }

        protected final int a() {
            return this.f34510a;
        }

        protected final void b(int i7) {
            this.f34510a = i7;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f34510a < c.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            c<E> cVar = c.this;
            int i7 = this.f34510a;
            this.f34510a = i7 + 1;
            return cVar.get(i7);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: renamed from: kotlin.collections.c$c, reason: collision with other inner class name */
    private class C0423c extends c<E>.b implements ListIterator<E>, j5.a {
        public C0423c(int i7) {
            super();
            c.f34509a.c(i7, c.this.size());
            b(i7);
        }

        @Override // java.util.ListIterator
        public void add(E e8) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return a() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return a();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            c<E> cVar = c.this;
            b(a() - 1);
            return cVar.get(a());
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return a() - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e8) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private static final class d<E> extends c<E> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.d
        private final c<E> f34513b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f34514c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f34515d;

        /* JADX WARN: Multi-variable type inference failed */
        public d(@a7.d c<? extends E> list, int i7, int i8) {
            kotlin.jvm.internal.l0.p(list, "list");
            this.f34513b = list;
            this.f34514c = i7;
            c.f34509a.d(i7, i8, list.size());
            this.f34515d = i8 - i7;
        }

        @Override // kotlin.collections.c, kotlin.collections.a
        public int a() {
            return this.f34515d;
        }

        @Override // kotlin.collections.c, java.util.List
        public E get(int i7) {
            c.f34509a.b(i7, this.f34515d);
            return this.f34513b.get(this.f34514c + i7);
        }
    }

    protected c() {
    }

    @Override // kotlin.collections.a
    public abstract int a();

    @Override // java.util.List
    public void add(int i7, E e8) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i7, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@a7.e Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return f34509a.e(this, (Collection) obj);
        }
        return false;
    }

    @Override // java.util.List
    public abstract E get(int i7);

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return f34509a.f(this);
    }

    @Override // java.util.List
    public int indexOf(E e8) {
        Iterator<E> it = iterator();
        int i7 = 0;
        while (it.hasNext()) {
            if (kotlin.jvm.internal.l0.g(it.next(), e8)) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    @Override // kotlin.collections.a, java.util.Collection, java.lang.Iterable
    @a7.d
    public Iterator<E> iterator() {
        return new b();
    }

    @Override // java.util.List
    public int lastIndexOf(E e8) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (kotlin.jvm.internal.l0.g(listIterator.previous(), e8)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    @a7.d
    public ListIterator<E> listIterator() {
        return new C0423c(0);
    }

    @Override // java.util.List
    public E remove(int i7) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i7, E e8) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    @a7.d
    public List<E> subList(int i7, int i8) {
        return new d(this, i7, i8);
    }

    @Override // java.util.List
    @a7.d
    public ListIterator<E> listIterator(int i7) {
        return new C0423c(i7);
    }
}
