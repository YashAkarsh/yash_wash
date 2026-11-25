package kotlin.collections.builders;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.collections.k;
import kotlin.collections.o;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class b<E> extends kotlin.collections.f<E> implements List<E>, RandomAccess, Serializable, j5.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private E[] f34465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f34466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f34467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f34468d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.e
    private final b<E> f34469e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.e
    private final b<E> f34470f;

    private static final class a<E> implements ListIterator<E>, j5.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        private final b<E> f34471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f34472b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f34473c;

        public a(@a7.d b<E> list, int i7) {
            l0.p(list, "list");
            this.f34471a = list;
            this.f34472b = i7;
            this.f34473c = -1;
        }

        @Override // java.util.ListIterator
        public void add(E e8) {
            b<E> bVar = this.f34471a;
            int i7 = this.f34472b;
            this.f34472b = i7 + 1;
            bVar.add(i7, e8);
            this.f34473c = -1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f34472b < ((b) this.f34471a).f34467c;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f34472b > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            if (this.f34472b >= ((b) this.f34471a).f34467c) {
                throw new NoSuchElementException();
            }
            int i7 = this.f34472b;
            this.f34472b = i7 + 1;
            this.f34473c = i7;
            return (E) ((b) this.f34471a).f34465a[((b) this.f34471a).f34466b + this.f34473c];
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f34472b;
        }

        @Override // java.util.ListIterator
        public E previous() {
            int i7 = this.f34472b;
            if (i7 <= 0) {
                throw new NoSuchElementException();
            }
            int i8 = i7 - 1;
            this.f34472b = i8;
            this.f34473c = i8;
            return (E) ((b) this.f34471a).f34465a[((b) this.f34471a).f34466b + this.f34473c];
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f34472b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            int i7 = this.f34473c;
            if (!(i7 != -1)) {
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
            }
            this.f34471a.remove(i7);
            this.f34472b = this.f34473c;
            this.f34473c = -1;
        }

        @Override // java.util.ListIterator
        public void set(E e8) {
            int i7 = this.f34473c;
            if (!(i7 != -1)) {
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
            }
            this.f34471a.set(i7, e8);
        }
    }

    private b(E[] eArr, int i7, int i8, boolean z7, b<E> bVar, b<E> bVar2) {
        this.f34465a = eArr;
        this.f34466b = i7;
        this.f34467c = i8;
        this.f34468d = z7;
        this.f34469e = bVar;
        this.f34470f = bVar2;
    }

    private final void h(int i7, Collection<? extends E> collection, int i8) {
        b<E> bVar = this.f34469e;
        if (bVar != null) {
            bVar.h(i7, collection, i8);
            this.f34465a = this.f34469e.f34465a;
            this.f34467c += i8;
        } else {
            p(i7, i8);
            Iterator<? extends E> it = collection.iterator();
            for (int i9 = 0; i9 < i8; i9++) {
                this.f34465a[i7 + i9] = it.next();
            }
        }
    }

    private final void j(int i7, E e8) {
        b<E> bVar = this.f34469e;
        if (bVar == null) {
            p(i7, 1);
            this.f34465a[i7] = e8;
        } else {
            bVar.j(i7, e8);
            this.f34465a = this.f34469e.f34465a;
            this.f34467c++;
        }
    }

    private final void l() {
        if (r()) {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean m(List<?> list) {
        return c.h(this.f34465a, this.f34466b, this.f34467c, list);
    }

    private final void n(int i7) {
        if (this.f34469e != null) {
            throw new IllegalStateException();
        }
        if (i7 < 0) {
            throw new OutOfMemoryError();
        }
        E[] eArr = this.f34465a;
        if (i7 > eArr.length) {
            this.f34465a = (E[]) c.e(this.f34465a, k.f34542d.a(eArr.length, i7));
        }
    }

    private final void o(int i7) {
        n(this.f34467c + i7);
    }

    private final void p(int i7, int i8) {
        o(i8);
        E[] eArr = this.f34465a;
        o.c1(eArr, eArr, i7 + i8, i7, this.f34466b + this.f34467c);
        this.f34467c += i8;
    }

    private final boolean r() {
        b<E> bVar;
        return this.f34468d || ((bVar = this.f34470f) != null && bVar.f34468d);
    }

    private final E t(int i7) {
        b<E> bVar = this.f34469e;
        if (bVar != null) {
            E eT = bVar.t(i7);
            this.f34467c--;
            return eT;
        }
        E[] eArr = this.f34465a;
        E e8 = eArr[i7];
        o.c1(eArr, eArr, i7, i7 + 1, this.f34466b + this.f34467c);
        c.f(this.f34465a, (this.f34466b + this.f34467c) - 1);
        this.f34467c--;
        return e8;
    }

    private final void u(int i7, int i8) {
        b<E> bVar = this.f34469e;
        if (bVar != null) {
            bVar.u(i7, i8);
        } else {
            E[] eArr = this.f34465a;
            o.c1(eArr, eArr, i7, i7 + i8, this.f34467c);
            E[] eArr2 = this.f34465a;
            int i9 = this.f34467c;
            c.g(eArr2, i9 - i8, i9);
        }
        this.f34467c -= i8;
    }

    private final int w(int i7, int i8, Collection<? extends E> collection, boolean z7) {
        b<E> bVar = this.f34469e;
        if (bVar != null) {
            int iW = bVar.w(i7, i8, collection, z7);
            this.f34467c -= iW;
            return iW;
        }
        int i9 = 0;
        int i10 = 0;
        while (i9 < i8) {
            int i11 = i7 + i9;
            if (collection.contains(this.f34465a[i11]) == z7) {
                E[] eArr = this.f34465a;
                i9++;
                eArr[i10 + i7] = eArr[i11];
                i10++;
            } else {
                i9++;
            }
        }
        int i12 = i8 - i10;
        E[] eArr2 = this.f34465a;
        o.c1(eArr2, eArr2, i7 + i10, i8 + i7, this.f34467c);
        E[] eArr3 = this.f34465a;
        int i13 = this.f34467c;
        c.g(eArr3, i13 - i12, i13);
        this.f34467c -= i12;
        return i12;
    }

    private final Object writeReplace() throws NotSerializableException {
        if (r()) {
            return new h(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    @Override // kotlin.collections.f
    public int a() {
        return this.f34467c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e8) {
        l();
        j(this.f34466b + this.f34467c, e8);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(@a7.d Collection<? extends E> elements) {
        l0.p(elements, "elements");
        l();
        int size = elements.size();
        h(this.f34466b + this.f34467c, elements, size);
        return size > 0;
    }

    @Override // kotlin.collections.f
    public E b(int i7) {
        l();
        kotlin.collections.c.f34509a.b(i7, this.f34467c);
        return t(this.f34466b + i7);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        l();
        u(this.f34466b, this.f34467c);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(@a7.e Object obj) {
        return obj == this || ((obj instanceof List) && m((List) obj));
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i7) {
        kotlin.collections.c.f34509a.b(i7, this.f34467c);
        return this.f34465a[this.f34466b + i7];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return c.i(this.f34465a, this.f34466b, this.f34467c);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        for (int i7 = 0; i7 < this.f34467c; i7++) {
            if (l0.g(this.f34465a[this.f34466b + i7], obj)) {
                return i7;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.f34467c == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    @a7.d
    public Iterator<E> iterator() {
        return new a(this, 0);
    }

    @a7.d
    public final List<E> k() {
        if (this.f34469e != null) {
            throw new IllegalStateException();
        }
        l();
        this.f34468d = true;
        return this;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        for (int i7 = this.f34467c - 1; i7 >= 0; i7--) {
            if (l0.g(this.f34465a[this.f34466b + i7], obj)) {
                return i7;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    @a7.d
    public ListIterator<E> listIterator() {
        return new a(this, 0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        l();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            remove(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(@a7.d Collection<? extends Object> elements) {
        l0.p(elements, "elements");
        l();
        return w(this.f34466b, this.f34467c, elements, false) > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(@a7.d Collection<? extends Object> elements) {
        l0.p(elements, "elements");
        l();
        return w(this.f34466b, this.f34467c, elements, true) > 0;
    }

    @Override // kotlin.collections.f, java.util.AbstractList, java.util.List
    public E set(int i7, E e8) {
        l();
        kotlin.collections.c.f34509a.b(i7, this.f34467c);
        E[] eArr = this.f34465a;
        int i8 = this.f34466b;
        E e9 = eArr[i8 + i7];
        eArr[i8 + i7] = e8;
        return e9;
    }

    @Override // java.util.AbstractList, java.util.List
    @a7.d
    public List<E> subList(int i7, int i8) {
        kotlin.collections.c.f34509a.d(i7, i8, this.f34467c);
        E[] eArr = this.f34465a;
        int i9 = this.f34466b + i7;
        int i10 = i8 - i7;
        boolean z7 = this.f34468d;
        b<E> bVar = this.f34470f;
        return new b(eArr, i9, i10, z7, this, bVar == null ? this : bVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @a7.d
    public <T> T[] toArray(@a7.d T[] destination) {
        l0.p(destination, "destination");
        int length = destination.length;
        int i7 = this.f34467c;
        if (length < i7) {
            E[] eArr = this.f34465a;
            int i8 = this.f34466b;
            T[] tArr = (T[]) Arrays.copyOfRange(eArr, i8, i7 + i8, destination.getClass());
            l0.o(tArr, "copyOfRange(array, offse…h, destination.javaClass)");
            return tArr;
        }
        E[] eArr2 = this.f34465a;
        l0.n(eArr2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.builders.ListBuilder.toArray>");
        int i9 = this.f34466b;
        o.c1(eArr2, destination, 0, i9, this.f34467c + i9);
        int length2 = destination.length;
        int i10 = this.f34467c;
        if (length2 > i10) {
            destination[i10] = null;
        }
        return destination;
    }

    @Override // java.util.AbstractCollection
    @a7.d
    public String toString() {
        return c.j(this.f34465a, this.f34466b, this.f34467c);
    }

    @Override // java.util.AbstractList, java.util.List
    @a7.d
    public ListIterator<E> listIterator(int i7) {
        kotlin.collections.c.f34509a.c(i7, this.f34467c);
        return new a(this, i7);
    }

    @Override // kotlin.collections.f, java.util.AbstractList, java.util.List
    public void add(int i7, E e8) {
        l();
        kotlin.collections.c.f34509a.c(i7, this.f34467c);
        j(this.f34466b + i7, e8);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i7, @a7.d Collection<? extends E> elements) {
        l0.p(elements, "elements");
        l();
        kotlin.collections.c.f34509a.c(i7, this.f34467c);
        int size = elements.size();
        h(this.f34466b + i7, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @a7.d
    public Object[] toArray() {
        E[] eArr = this.f34465a;
        int i7 = this.f34466b;
        Object[] objArrM1 = o.M1(eArr, i7, this.f34467c + i7);
        l0.n(objArrM1, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        return objArrM1;
    }

    public b() {
        this(10);
    }

    public b(int i7) {
        this(c.d(i7), 0, 0, false, null, null);
    }
}
