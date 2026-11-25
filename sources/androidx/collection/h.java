package androidx.collection;

import c.o0;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
abstract class h<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @o0
    h<K, V>.b f2296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    h<K, V>.c f2297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    h<K, V>.e f2298c;

    final class a<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f2299a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2300b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f2301c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f2302d = false;

        a(int i7) {
            this.f2299a = i7;
            this.f2300b = h.this.d();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2301c < this.f2300b;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t7 = (T) h.this.b(this.f2301c, this.f2299a);
            this.f2301c++;
            this.f2302d = true;
            return t7;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f2302d) {
                throw new IllegalStateException();
            }
            int i7 = this.f2301c - 1;
            this.f2301c = i7;
            this.f2300b--;
            this.f2302d = false;
            h.this.h(i7);
        }
    }

    final class b implements Set<Map.Entry<K, V>> {
        b() {
        }

        @Override // java.util.Set, java.util.Collection
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int iD = h.this.d();
            for (Map.Entry<K, V> entry : collection) {
                h.this.g(entry.getKey(), entry.getValue());
            }
            return iD != h.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            h.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iE = h.this.e(entry.getKey());
            if (iE < 0) {
                return false;
            }
            return androidx.collection.e.c(h.this.b(iE, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return h.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iD = h.this.d() - 1; iD >= 0; iD--) {
                Object objB = h.this.b(iD, 0);
                Object objB2 = h.this.b(iD, 1);
                iHashCode += (objB == null ? 0 : objB.hashCode()) ^ (objB2 == null ? 0 : objB2.hashCode());
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return h.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return h.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    final class c implements Set<K> {
        c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k7) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            h.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return h.this.e(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return h.j(h.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return h.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iD = h.this.d() - 1; iD >= 0; iD--) {
                Object objB = h.this.b(iD, 0);
                iHashCode += objB == null ? 0 : objB.hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return h.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int iE = h.this.e(obj);
            if (iE < 0) {
                return false;
            }
            h.this.h(iE);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return h.o(h.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return h.p(h.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return h.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return h.this.q(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) h.this.r(tArr, 0);
        }
    }

    final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2306a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f2308c = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2307b = -1;

        d() {
            this.f2306a = h.this.d() - 1;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f2307b++;
            this.f2308c = true;
            return this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.f2308c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return androidx.collection.e.c(entry.getKey(), h.this.b(this.f2307b, 0)) && androidx.collection.e.c(entry.getValue(), h.this.b(this.f2307b, 1));
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.f2308c) {
                return (K) h.this.b(this.f2307b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.f2308c) {
                return (V) h.this.b(this.f2307b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2307b < this.f2306a;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.f2308c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object objB = h.this.b(this.f2307b, 0);
            Object objB2 = h.this.b(this.f2307b, 1);
            return (objB == null ? 0 : objB.hashCode()) ^ (objB2 != null ? objB2.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f2308c) {
                throw new IllegalStateException();
            }
            h.this.h(this.f2307b);
            this.f2307b--;
            this.f2306a--;
            this.f2308c = false;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v7) {
            if (this.f2308c) {
                return (V) h.this.i(this.f2307b, v7);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class e implements Collection<V> {
        e() {
        }

        @Override // java.util.Collection
        public boolean add(V v7) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            h.this.a();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return h.this.f(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return h.this.d() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int iF = h.this.f(obj);
            if (iF < 0) {
                return false;
            }
            h.this.h(iF);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int iD = h.this.d();
            int i7 = 0;
            boolean z7 = false;
            while (i7 < iD) {
                if (collection.contains(h.this.b(i7, 1))) {
                    h.this.h(i7);
                    i7--;
                    iD--;
                    z7 = true;
                }
                i7++;
            }
            return z7;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int iD = h.this.d();
            int i7 = 0;
            boolean z7 = false;
            while (i7 < iD) {
                if (!collection.contains(h.this.b(i7, 1))) {
                    h.this.h(i7);
                    i7--;
                    iD--;
                    z7 = true;
                }
                i7++;
            }
            return z7;
        }

        @Override // java.util.Collection
        public int size() {
            return h.this.d();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return h.this.q(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) h.this.r(tArr, 1);
        }
    }

    h() {
    }

    public static <K, V> boolean j(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean k(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                return set.size() == set2.size() && set.containsAll(set2);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <K, V> boolean o(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean p(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract void a();

    protected abstract Object b(int i7, int i8);

    protected abstract Map<K, V> c();

    protected abstract int d();

    protected abstract int e(Object obj);

    protected abstract int f(Object obj);

    protected abstract void g(K k7, V v7);

    protected abstract void h(int i7);

    protected abstract V i(int i7, V v7);

    public Set<Map.Entry<K, V>> l() {
        if (this.f2296a == null) {
            this.f2296a = new b();
        }
        return this.f2296a;
    }

    public Set<K> m() {
        if (this.f2297b == null) {
            this.f2297b = new c();
        }
        return this.f2297b;
    }

    public Collection<V> n() {
        if (this.f2298c == null) {
            this.f2298c = new e();
        }
        return this.f2298c;
    }

    public Object[] q(int i7) {
        int iD = d();
        Object[] objArr = new Object[iD];
        for (int i8 = 0; i8 < iD; i8++) {
            objArr[i8] = b(i8, i7);
        }
        return objArr;
    }

    public <T> T[] r(T[] tArr, int i7) {
        int iD = d();
        if (tArr.length < iD) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), iD));
        }
        for (int i8 = 0; i8 < iD; i8++) {
            tArr[i8] = b(i8, i7);
        }
        if (tArr.length > iD) {
            tArr[iD] = null;
        }
        return tArr;
    }
}
