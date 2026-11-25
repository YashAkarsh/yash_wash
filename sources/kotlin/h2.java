package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
@h5.f
@g1(version = "1.3")
@t
public final class h2 implements Collection<g2>, j5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final short[] f34741a;

    private static final class a implements Iterator<g2>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        private final short[] f34742a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f34743b;

        public a(@a7.d short[] array) {
            kotlin.jvm.internal.l0.p(array, "array");
            this.f34742a = array;
        }

        public short a() {
            int i7 = this.f34743b;
            short[] sArr = this.f34742a;
            if (i7 >= sArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f34743b));
            }
            this.f34743b = i7 + 1;
            return g2.h(sArr[i7]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f34743b < this.f34742a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ g2 next() {
            return g2.b(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @a1
    private /* synthetic */ h2(short[] sArr) {
        this.f34741a = sArr;
    }

    public static final /* synthetic */ h2 b(short[] sArr) {
        return new h2(sArr);
    }

    @a7.d
    public static short[] d(int i7) {
        return f(new short[i7]);
    }

    @a7.d
    @a1
    public static short[] f(@a7.d short[] storage) {
        kotlin.jvm.internal.l0.p(storage, "storage");
        return storage;
    }

    public static boolean h(short[] sArr, short s7) {
        return kotlin.collections.p.U8(sArr, s7);
    }

    public static boolean j(short[] sArr, @a7.d Collection<g2> elements) {
        kotlin.jvm.internal.l0.p(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        for (Object obj : elements) {
            if (!((obj instanceof g2) && kotlin.collections.p.U8(sArr, ((g2) obj).e0()))) {
                return false;
            }
        }
        return true;
    }

    public static boolean k(short[] sArr, Object obj) {
        return (obj instanceof h2) && kotlin.jvm.internal.l0.g(sArr, ((h2) obj).x());
    }

    public static final boolean l(short[] sArr, short[] sArr2) {
        return kotlin.jvm.internal.l0.g(sArr, sArr2);
    }

    public static final short m(short[] sArr, int i7) {
        return g2.h(sArr[i7]);
    }

    public static int o(short[] sArr) {
        return sArr.length;
    }

    @a1
    public static /* synthetic */ void p() {
    }

    public static int r(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    public static boolean s(short[] sArr) {
        return sArr.length == 0;
    }

    @a7.d
    public static Iterator<g2> t(short[] sArr) {
        return new a(sArr);
    }

    public static final void u(short[] sArr, int i7, short s7) {
        sArr[i7] = s7;
    }

    public static String w(short[] sArr) {
        return "UShortArray(storage=" + Arrays.toString(sArr) + ')';
    }

    public boolean a(short s7) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(g2 g2Var) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends g2> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof g2) {
            return g(((g2) obj).e0());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@a7.d Collection<? extends Object> elements) {
        kotlin.jvm.internal.l0.p(elements, "elements");
        return j(this.f34741a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return k(this.f34741a, obj);
    }

    public boolean g(short s7) {
        return h(this.f34741a, s7);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return r(this.f34741a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return s(this.f34741a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @a7.d
    public Iterator<g2> iterator() {
        return t(this.f34741a);
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public int size() {
        return o(this.f34741a);
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
        return w(this.f34741a);
    }

    public final /* synthetic */ short[] x() {
        return this.f34741a;
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.l0.p(array, "array");
        return (T[]) kotlin.jvm.internal.v.b(this, array);
    }
}
