package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
@h5.f
@g1(version = "1.3")
@t
public final class x1 implements Collection<w1>, j5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final int[] f35496a;

    private static final class a implements Iterator<w1>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        private final int[] f35497a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f35498b;

        public a(@a7.d int[] array) {
            kotlin.jvm.internal.l0.p(array, "array");
            this.f35497a = array;
        }

        public int a() {
            int i7 = this.f35498b;
            int[] iArr = this.f35497a;
            if (i7 >= iArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f35498b));
            }
            this.f35498b = i7 + 1;
            return w1.h(iArr[i7]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f35498b < this.f35497a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ w1 next() {
            return w1.b(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @a1
    private /* synthetic */ x1(int[] iArr) {
        this.f35496a = iArr;
    }

    public static final /* synthetic */ x1 b(int[] iArr) {
        return new x1(iArr);
    }

    @a7.d
    public static int[] d(int i7) {
        return f(new int[i7]);
    }

    @a7.d
    @a1
    public static int[] f(@a7.d int[] storage) {
        kotlin.jvm.internal.l0.p(storage, "storage");
        return storage;
    }

    public static boolean h(int[] iArr, int i7) {
        return kotlin.collections.p.R8(iArr, i7);
    }

    public static boolean j(int[] iArr, @a7.d Collection<w1> elements) {
        kotlin.jvm.internal.l0.p(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        for (Object obj : elements) {
            if (!((obj instanceof w1) && kotlin.collections.p.R8(iArr, ((w1) obj).g0()))) {
                return false;
            }
        }
        return true;
    }

    public static boolean k(int[] iArr, Object obj) {
        return (obj instanceof x1) && kotlin.jvm.internal.l0.g(iArr, ((x1) obj).x());
    }

    public static final boolean l(int[] iArr, int[] iArr2) {
        return kotlin.jvm.internal.l0.g(iArr, iArr2);
    }

    public static final int m(int[] iArr, int i7) {
        return w1.h(iArr[i7]);
    }

    public static int o(int[] iArr) {
        return iArr.length;
    }

    @a1
    public static /* synthetic */ void p() {
    }

    public static int r(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    public static boolean s(int[] iArr) {
        return iArr.length == 0;
    }

    @a7.d
    public static Iterator<w1> t(int[] iArr) {
        return new a(iArr);
    }

    public static final void u(int[] iArr, int i7, int i8) {
        iArr[i7] = i8;
    }

    public static String w(int[] iArr) {
        return "UIntArray(storage=" + Arrays.toString(iArr) + ')';
    }

    public boolean a(int i7) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(w1 w1Var) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends w1> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof w1) {
            return g(((w1) obj).g0());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@a7.d Collection<? extends Object> elements) {
        kotlin.jvm.internal.l0.p(elements, "elements");
        return j(this.f35496a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return k(this.f35496a, obj);
    }

    public boolean g(int i7) {
        return h(this.f35496a, i7);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return r(this.f35496a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return s(this.f35496a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @a7.d
    public Iterator<w1> iterator() {
        return t(this.f35496a);
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public int size() {
        return o(this.f35496a);
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
        return w(this.f35496a);
    }

    public final /* synthetic */ int[] x() {
        return this.f35496a;
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.l0.p(array, "array");
        return (T[]) kotlin.jvm.internal.v.b(this, array);
    }
}
