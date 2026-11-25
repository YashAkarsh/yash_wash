package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
@h5.f
@g1(version = "1.3")
@t
public final class b2 implements Collection<a2>, j5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final long[] f34453a;

    private static final class a implements Iterator<a2>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        private final long[] f34454a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f34455b;

        public a(@a7.d long[] array) {
            kotlin.jvm.internal.l0.p(array, "array");
            this.f34454a = array;
        }

        public long a() {
            int i7 = this.f34455b;
            long[] jArr = this.f34454a;
            if (i7 >= jArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f34455b));
            }
            this.f34455b = i7 + 1;
            return a2.h(jArr[i7]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f34455b < this.f34454a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ a2 next() {
            return a2.b(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @a1
    private /* synthetic */ b2(long[] jArr) {
        this.f34453a = jArr;
    }

    public static final /* synthetic */ b2 b(long[] jArr) {
        return new b2(jArr);
    }

    @a7.d
    public static long[] d(int i7) {
        return f(new long[i7]);
    }

    @a7.d
    @a1
    public static long[] f(@a7.d long[] storage) {
        kotlin.jvm.internal.l0.p(storage, "storage");
        return storage;
    }

    public static boolean h(long[] jArr, long j7) {
        return kotlin.collections.p.S8(jArr, j7);
    }

    public static boolean j(long[] jArr, @a7.d Collection<a2> elements) {
        kotlin.jvm.internal.l0.p(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        for (Object obj : elements) {
            if (!((obj instanceof a2) && kotlin.collections.p.S8(jArr, ((a2) obj).g0()))) {
                return false;
            }
        }
        return true;
    }

    public static boolean k(long[] jArr, Object obj) {
        return (obj instanceof b2) && kotlin.jvm.internal.l0.g(jArr, ((b2) obj).x());
    }

    public static final boolean l(long[] jArr, long[] jArr2) {
        return kotlin.jvm.internal.l0.g(jArr, jArr2);
    }

    public static final long m(long[] jArr, int i7) {
        return a2.h(jArr[i7]);
    }

    public static int o(long[] jArr) {
        return jArr.length;
    }

    @a1
    public static /* synthetic */ void p() {
    }

    public static int r(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    public static boolean s(long[] jArr) {
        return jArr.length == 0;
    }

    @a7.d
    public static Iterator<a2> t(long[] jArr) {
        return new a(jArr);
    }

    public static final void u(long[] jArr, int i7, long j7) {
        jArr[i7] = j7;
    }

    public static String w(long[] jArr) {
        return "ULongArray(storage=" + Arrays.toString(jArr) + ')';
    }

    public boolean a(long j7) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(a2 a2Var) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends a2> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof a2) {
            return g(((a2) obj).g0());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@a7.d Collection<? extends Object> elements) {
        kotlin.jvm.internal.l0.p(elements, "elements");
        return j(this.f34453a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return k(this.f34453a, obj);
    }

    public boolean g(long j7) {
        return h(this.f34453a, j7);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return r(this.f34453a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return s(this.f34453a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @a7.d
    public Iterator<a2> iterator() {
        return t(this.f34453a);
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public int size() {
        return o(this.f34453a);
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
    public Object[] toArray() {
        return kotlin.jvm.internal.v.a(this);
    }

    public String toString() {
        return w(this.f34453a);
    }

    public final /* synthetic */ long[] x() {
        return this.f34453a;
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.l0.p(array, "array");
        return (T[]) kotlin.jvm.internal.v.b(this, array);
    }
}
