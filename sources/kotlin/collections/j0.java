package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import okhttp3.HttpUrl;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class j0 implements List, Serializable, RandomAccess, j5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final j0 f34539a = new j0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f34540b = -7390468764508069838L;

    private j0() {
    }

    private final Object readResolve() {
        return f34539a;
    }

    public void a(int i7, Void r7) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ void add(int i7, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i7, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean b(Void r7) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Void) {
            return d((Void) obj);
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(@a7.d Collection elements) {
        kotlin.jvm.internal.l0.p(elements, "elements");
        return elements.isEmpty();
    }

    public boolean d(@a7.d Void element) {
        kotlin.jvm.internal.l0.p(element, "element");
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(@a7.e Object obj) {
        return (obj instanceof List) && ((List) obj).isEmpty();
    }

    @Override // java.util.List
    @a7.d
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Void get(int i7) {
        throw new IndexOutOfBoundsException("Empty list doesn't contain element at index " + i7 + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    public int g() {
        return 0;
    }

    public int h(@a7.d Void element) {
        kotlin.jvm.internal.l0.p(element, "element");
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return 1;
    }

    @Override // java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Void) {
            return h((Void) obj);
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @a7.d
    public Iterator iterator() {
        return i0.f34535a;
    }

    public int j(@a7.d Void element) {
        kotlin.jvm.internal.l0.p(element, "element");
        return -1;
    }

    public Void k(int i7) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Void l(int i7, Void r7) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Void) {
            return j((Void) obj);
        }
        return -1;
    }

    @Override // java.util.List
    @a7.d
    public ListIterator listIterator() {
        return i0.f34535a;
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Object remove(int i7) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Object set(int i7, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return g();
    }

    @Override // java.util.List
    @a7.d
    public List subList(int i7, int i8) {
        if (i7 == 0 && i8 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException("fromIndex: " + i7 + ", toIndex: " + i8);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return kotlin.jvm.internal.v.a(this);
    }

    @a7.d
    public String toString() {
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    @Override // java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    @a7.d
    public ListIterator listIterator(int i7) {
        if (i7 == 0) {
            return i0.f34535a;
        }
        throw new IndexOutOfBoundsException("Index: " + i7);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.l0.p(array, "array");
        return (T[]) kotlin.jvm.internal.v.b(this, array);
    }
}
