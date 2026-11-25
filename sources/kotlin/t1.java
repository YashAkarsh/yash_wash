package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
@h5.f
@g1(version = "1.3")
@t
public final class t1 implements Collection<s1>, j5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final byte[] f35279a;

    private static final class a implements Iterator<s1>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        private final byte[] f35280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f35281b;

        public a(@a7.d byte[] array) {
            kotlin.jvm.internal.l0.p(array, "array");
            this.f35280a = array;
        }

        public byte a() {
            int i7 = this.f35281b;
            byte[] bArr = this.f35280a;
            if (i7 >= bArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f35281b));
            }
            this.f35281b = i7 + 1;
            return s1.h(bArr[i7]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f35281b < this.f35280a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ s1 next() {
            return s1.b(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @a1
    private /* synthetic */ t1(byte[] bArr) {
        this.f35279a = bArr;
    }

    public static final /* synthetic */ t1 b(byte[] bArr) {
        return new t1(bArr);
    }

    @a7.d
    public static byte[] d(int i7) {
        return f(new byte[i7]);
    }

    @a7.d
    @a1
    public static byte[] f(@a7.d byte[] storage) {
        kotlin.jvm.internal.l0.p(storage, "storage");
        return storage;
    }

    public static boolean h(byte[] bArr, byte b8) {
        return kotlin.collections.p.N8(bArr, b8);
    }

    public static boolean j(byte[] bArr, @a7.d Collection<s1> elements) {
        kotlin.jvm.internal.l0.p(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        for (Object obj : elements) {
            if (!((obj instanceof s1) && kotlin.collections.p.N8(bArr, ((s1) obj).e0()))) {
                return false;
            }
        }
        return true;
    }

    public static boolean k(byte[] bArr, Object obj) {
        return (obj instanceof t1) && kotlin.jvm.internal.l0.g(bArr, ((t1) obj).x());
    }

    public static final boolean l(byte[] bArr, byte[] bArr2) {
        return kotlin.jvm.internal.l0.g(bArr, bArr2);
    }

    public static final byte m(byte[] bArr, int i7) {
        return s1.h(bArr[i7]);
    }

    public static int o(byte[] bArr) {
        return bArr.length;
    }

    @a1
    public static /* synthetic */ void p() {
    }

    public static int r(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    public static boolean s(byte[] bArr) {
        return bArr.length == 0;
    }

    @a7.d
    public static Iterator<s1> t(byte[] bArr) {
        return new a(bArr);
    }

    public static final void u(byte[] bArr, int i7, byte b8) {
        bArr[i7] = b8;
    }

    public static String w(byte[] bArr) {
        return "UByteArray(storage=" + Arrays.toString(bArr) + ')';
    }

    public boolean a(byte b8) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(s1 s1Var) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends s1> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof s1) {
            return g(((s1) obj).e0());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@a7.d Collection<? extends Object> elements) {
        kotlin.jvm.internal.l0.p(elements, "elements");
        return j(this.f35279a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return k(this.f35279a, obj);
    }

    public boolean g(byte b8) {
        return h(this.f35279a, b8);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return r(this.f35279a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return s(this.f35279a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @a7.d
    public Iterator<s1> iterator() {
        return t(this.f35279a);
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public int size() {
        return o(this.f35279a);
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
        return w(this.f35279a);
    }

    public final /* synthetic */ byte[] x() {
        return this.f35279a;
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.l0.p(array, "array");
        return (T[]) kotlin.jvm.internal.v.b(this, array);
    }
}
