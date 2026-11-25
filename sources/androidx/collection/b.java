package androidx.collection;

import c.m0;
import c.o0;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class b<E> implements Collection<E>, Set<E> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final boolean f2257e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f2258f = "ArraySet";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int[] f2259g = new int[0];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Object[] f2260h = new Object[0];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f2261i = 4;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f2262j = 10;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @o0
    private static Object[] f2263k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static int f2264l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @o0
    private static Object[] f2265m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static int f2266n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f2267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object[] f2268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f2269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private h<E, E> f2270d;

    class a extends h<E, E> {
        a() {
        }

        @Override // androidx.collection.h
        protected void a() {
            b.this.clear();
        }

        @Override // androidx.collection.h
        protected Object b(int i7, int i8) {
            return b.this.f2268b[i7];
        }

        @Override // androidx.collection.h
        protected Map<E, E> c() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // androidx.collection.h
        protected int d() {
            return b.this.f2269c;
        }

        @Override // androidx.collection.h
        protected int e(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // androidx.collection.h
        protected int f(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // androidx.collection.h
        protected void g(E e8, E e9) {
            b.this.add(e8);
        }

        @Override // androidx.collection.h
        protected void h(int i7) {
            b.this.l(i7);
        }

        @Override // androidx.collection.h
        protected E i(int i7, E e8) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public b() {
        this(0);
    }

    private void b(int i7) {
        if (i7 == 8) {
            synchronized (b.class) {
                Object[] objArr = f2265m;
                if (objArr != null) {
                    this.f2268b = objArr;
                    f2265m = (Object[]) objArr[0];
                    this.f2267a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f2266n--;
                    return;
                }
            }
        } else if (i7 == 4) {
            synchronized (b.class) {
                Object[] objArr2 = f2263k;
                if (objArr2 != null) {
                    this.f2268b = objArr2;
                    f2263k = (Object[]) objArr2[0];
                    this.f2267a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f2264l--;
                    return;
                }
            }
        }
        this.f2267a = new int[i7];
        this.f2268b = new Object[i7];
    }

    private static void f(int[] iArr, Object[] objArr, int i7) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (f2266n < 10) {
                    objArr[0] = f2265m;
                    objArr[1] = iArr;
                    for (int i8 = i7 - 1; i8 >= 2; i8--) {
                        objArr[i8] = null;
                    }
                    f2265m = objArr;
                    f2266n++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (b.class) {
                if (f2264l < 10) {
                    objArr[0] = f2263k;
                    objArr[1] = iArr;
                    for (int i9 = i7 - 1; i9 >= 2; i9--) {
                        objArr[i9] = null;
                    }
                    f2263k = objArr;
                    f2264l++;
                }
            }
        }
    }

    private h<E, E> g() {
        if (this.f2270d == null) {
            this.f2270d = new a();
        }
        return this.f2270d;
    }

    private int h(Object obj, int i7) {
        int i8 = this.f2269c;
        if (i8 == 0) {
            return -1;
        }
        int iA = e.a(this.f2267a, i8, i7);
        if (iA < 0 || obj.equals(this.f2268b[iA])) {
            return iA;
        }
        int i9 = iA + 1;
        while (i9 < i8 && this.f2267a[i9] == i7) {
            if (obj.equals(this.f2268b[i9])) {
                return i9;
            }
            i9++;
        }
        for (int i10 = iA - 1; i10 >= 0 && this.f2267a[i10] == i7; i10--) {
            if (obj.equals(this.f2268b[i10])) {
                return i10;
            }
        }
        return ~i9;
    }

    private int j() {
        int i7 = this.f2269c;
        if (i7 == 0) {
            return -1;
        }
        int iA = e.a(this.f2267a, i7, 0);
        if (iA < 0 || this.f2268b[iA] == null) {
            return iA;
        }
        int i8 = iA + 1;
        while (i8 < i7 && this.f2267a[i8] == 0) {
            if (this.f2268b[i8] == null) {
                return i8;
            }
            i8++;
        }
        for (int i9 = iA - 1; i9 >= 0 && this.f2267a[i9] == 0; i9--) {
            if (this.f2268b[i9] == null) {
                return i9;
            }
        }
        return ~i8;
    }

    public void a(@m0 b<? extends E> bVar) {
        int i7 = bVar.f2269c;
        d(this.f2269c + i7);
        if (this.f2269c != 0) {
            for (int i8 = 0; i8 < i7; i8++) {
                add(bVar.m(i8));
            }
        } else if (i7 > 0) {
            System.arraycopy(bVar.f2267a, 0, this.f2267a, 0, i7);
            System.arraycopy(bVar.f2268b, 0, this.f2268b, 0, i7);
            this.f2269c = i7;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(@o0 E e8) {
        int i7;
        int iH;
        if (e8 == null) {
            iH = j();
            i7 = 0;
        } else {
            int iHashCode = e8.hashCode();
            i7 = iHashCode;
            iH = h(e8, iHashCode);
        }
        if (iH >= 0) {
            return false;
        }
        int i8 = ~iH;
        int i9 = this.f2269c;
        int[] iArr = this.f2267a;
        if (i9 >= iArr.length) {
            int i10 = 8;
            if (i9 >= 8) {
                i10 = (i9 >> 1) + i9;
            } else if (i9 < 4) {
                i10 = 4;
            }
            Object[] objArr = this.f2268b;
            b(i10);
            int[] iArr2 = this.f2267a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f2268b, 0, objArr.length);
            }
            f(iArr, objArr, this.f2269c);
        }
        int i11 = this.f2269c;
        if (i8 < i11) {
            int[] iArr3 = this.f2267a;
            int i12 = i8 + 1;
            System.arraycopy(iArr3, i8, iArr3, i12, i11 - i8);
            Object[] objArr2 = this.f2268b;
            System.arraycopy(objArr2, i8, objArr2, i12, this.f2269c - i8);
        }
        this.f2267a[i8] = i7;
        this.f2268b[i8] = e8;
        this.f2269c++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(@m0 Collection<? extends E> collection) {
        d(this.f2269c + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i7 = this.f2269c;
        if (i7 != 0) {
            f(this.f2267a, this.f2268b, i7);
            this.f2267a = f2259g;
            this.f2268b = f2260h;
            this.f2269c = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(@o0 Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(@m0 Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public void d(int i7) {
        int[] iArr = this.f2267a;
        if (iArr.length < i7) {
            Object[] objArr = this.f2268b;
            b(i7);
            int i8 = this.f2269c;
            if (i8 > 0) {
                System.arraycopy(iArr, 0, this.f2267a, 0, i8);
                System.arraycopy(objArr, 0, this.f2268b, 0, this.f2269c);
            }
            f(iArr, objArr, this.f2269c);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i7 = 0; i7 < this.f2269c; i7++) {
                try {
                    if (!set.contains(m(i7))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f2267a;
        int i7 = this.f2269c;
        int i8 = 0;
        for (int i9 = 0; i9 < i7; i9++) {
            i8 += iArr[i9];
        }
        return i8;
    }

    public int indexOf(@o0 Object obj) {
        return obj == null ? j() : h(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f2269c <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return g().m().iterator();
    }

    public boolean k(@m0 b<? extends E> bVar) {
        int i7 = bVar.f2269c;
        int i8 = this.f2269c;
        for (int i9 = 0; i9 < i7; i9++) {
            remove(bVar.m(i9));
        }
        return i8 != this.f2269c;
    }

    public E l(int i7) {
        Object[] objArr = this.f2268b;
        E e8 = (E) objArr[i7];
        int i8 = this.f2269c;
        if (i8 <= 1) {
            f(this.f2267a, objArr, i8);
            this.f2267a = f2259g;
            this.f2268b = f2260h;
            this.f2269c = 0;
        } else {
            int[] iArr = this.f2267a;
            if (iArr.length <= 8 || i8 >= iArr.length / 3) {
                int i9 = i8 - 1;
                this.f2269c = i9;
                if (i7 < i9) {
                    int i10 = i7 + 1;
                    System.arraycopy(iArr, i10, iArr, i7, i9 - i7);
                    Object[] objArr2 = this.f2268b;
                    System.arraycopy(objArr2, i10, objArr2, i7, this.f2269c - i7);
                }
                this.f2268b[this.f2269c] = null;
            } else {
                b(i8 > 8 ? i8 + (i8 >> 1) : 8);
                this.f2269c--;
                if (i7 > 0) {
                    System.arraycopy(iArr, 0, this.f2267a, 0, i7);
                    System.arraycopy(objArr, 0, this.f2268b, 0, i7);
                }
                int i11 = this.f2269c;
                if (i7 < i11) {
                    int i12 = i7 + 1;
                    System.arraycopy(iArr, i12, this.f2267a, i7, i11 - i7);
                    System.arraycopy(objArr, i12, this.f2268b, i7, this.f2269c - i7);
                }
            }
        }
        return e8;
    }

    @o0
    public E m(int i7) {
        return (E) this.f2268b[i7];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(@o0 Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        l(iIndexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(@m0 Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(@m0 Collection<?> collection) {
        boolean z7 = false;
        for (int i7 = this.f2269c - 1; i7 >= 0; i7--) {
            if (!collection.contains(this.f2268b[i7])) {
                l(i7);
                z7 = true;
            }
        }
        return z7;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f2269c;
    }

    @Override // java.util.Collection, java.util.Set
    @m0
    public Object[] toArray() {
        int i7 = this.f2269c;
        Object[] objArr = new Object[i7];
        System.arraycopy(this.f2268b, 0, objArr, 0, i7);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f2269c * 14);
        sb.append('{');
        for (int i7 = 0; i7 < this.f2269c; i7++) {
            if (i7 > 0) {
                sb.append(", ");
            }
            E eM = m(i7);
            if (eM != this) {
                sb.append(eM);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public b(int i7) {
        if (i7 == 0) {
            this.f2267a = f2259g;
            this.f2268b = f2260h;
        } else {
            b(i7);
        }
        this.f2269c = 0;
    }

    @Override // java.util.Collection, java.util.Set
    @m0
    public <T> T[] toArray(@m0 T[] tArr) {
        if (tArr.length < this.f2269c) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f2269c));
        }
        System.arraycopy(this.f2268b, 0, tArr, 0, this.f2269c);
        int length = tArr.length;
        int i7 = this.f2269c;
        if (length > i7) {
            tArr[i7] = null;
        }
        return tArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(@o0 b<E> bVar) {
        this();
        if (bVar != 0) {
            a(bVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(@o0 Collection<E> collection) {
        this();
        if (collection != 0) {
            addAll(collection);
        }
    }
}
