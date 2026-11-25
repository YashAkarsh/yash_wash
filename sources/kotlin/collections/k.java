package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.l2;
import kotlin.q2;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.g1(version = "1.4")
@q2(markerClass = {kotlin.s.class})
public final class k<E> extends f<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    public static final a f34542d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    private static final Object[] f34543e = new Object[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f34544f = 2147483639;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f34545g = 10;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f34546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private Object[] f34547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f34548c;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
            this();
        }

        public final int a(int i7, int i8) {
            int i9 = i7 + (i7 >> 1);
            if (i9 - i8 < 0) {
                i9 = i8;
            }
            if (i9 - k.f34544f <= 0) {
                return i9;
            }
            if (i8 > k.f34544f) {
                return Integer.MAX_VALUE;
            }
            return k.f34544f;
        }

        private a() {
        }
    }

    public k(int i7) {
        Object[] objArr;
        if (i7 == 0) {
            objArr = f34543e;
        } else {
            if (i7 <= 0) {
                throw new IllegalArgumentException("Illegal Capacity: " + i7);
            }
            objArr = new Object[i7];
        }
        this.f34547b = objArr;
    }

    private final void d(int i7, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.f34547b.length;
        while (i7 < length && it.hasNext()) {
            this.f34547b[i7] = it.next();
            i7++;
        }
        int i8 = this.f34546a;
        for (int i9 = 0; i9 < i8 && it.hasNext(); i9++) {
            this.f34547b[i9] = it.next();
        }
        this.f34548c = size() + collection.size();
    }

    private final void f(int i7) {
        Object[] objArr = new Object[i7];
        Object[] objArr2 = this.f34547b;
        o.c1(objArr2, objArr, 0, this.f34546a, objArr2.length);
        Object[] objArr3 = this.f34547b;
        int length = objArr3.length;
        int i8 = this.f34546a;
        o.c1(objArr3, objArr, length - i8, 0, i8);
        this.f34546a = 0;
        this.f34547b = objArr;
    }

    private final int g(int i7) {
        return i7 == 0 ? p.Xe(this.f34547b) : i7 - 1;
    }

    private final void h(int i7) {
        if (i7 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f34547b;
        if (i7 <= objArr.length) {
            return;
        }
        if (objArr == f34543e) {
            this.f34547b = new Object[kotlin.ranges.q.n(i7, 10)];
        } else {
            f(f34542d.a(objArr.length, i7));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean j(i5.l<? super E, Boolean> lVar) {
        int iT;
        boolean z7 = false;
        z7 = false;
        z7 = false;
        if (!isEmpty()) {
            if ((this.f34547b.length == 0) == false) {
                int iT2 = t(this.f34546a + size());
                int i7 = this.f34546a;
                if (i7 < iT2) {
                    iT = i7;
                    while (i7 < iT2) {
                        Object obj = this.f34547b[i7];
                        if (lVar.z(obj).booleanValue()) {
                            this.f34547b[iT] = obj;
                            iT++;
                        } else {
                            z7 = true;
                        }
                        i7++;
                    }
                    o.n2(this.f34547b, null, iT, iT2);
                } else {
                    int length = this.f34547b.length;
                    boolean z8 = false;
                    int i8 = i7;
                    while (i7 < length) {
                        Object[] objArr = this.f34547b;
                        Object obj2 = objArr[i7];
                        objArr[i7] = null;
                        if (lVar.z(obj2).booleanValue()) {
                            this.f34547b[i8] = obj2;
                            i8++;
                        } else {
                            z8 = true;
                        }
                        i7++;
                    }
                    iT = t(i8);
                    for (int i9 = 0; i9 < iT2; i9++) {
                        Object[] objArr2 = this.f34547b;
                        Object obj3 = objArr2[i9];
                        objArr2[i9] = null;
                        if (lVar.z(obj3).booleanValue()) {
                            this.f34547b[iT] = obj3;
                            iT = l(iT);
                        } else {
                            z8 = true;
                        }
                    }
                    z7 = z8;
                }
                if (z7) {
                    this.f34548c = r(iT - this.f34546a);
                }
            }
        }
        return z7;
    }

    private final int l(int i7) {
        if (i7 == p.Xe(this.f34547b)) {
            return 0;
        }
        return i7 + 1;
    }

    @kotlin.internal.f
    private final E m(int i7) {
        return (E) this.f34547b[i7];
    }

    @kotlin.internal.f
    private final int n(int i7) {
        return t(this.f34546a + i7);
    }

    private final int r(int i7) {
        return i7 < 0 ? i7 + this.f34547b.length : i7;
    }

    private final int t(int i7) {
        Object[] objArr = this.f34547b;
        return i7 >= objArr.length ? i7 - objArr.length : i7;
    }

    @Override // kotlin.collections.f
    public int a() {
        return this.f34548c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e8) {
        addLast(e8);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(@a7.d Collection<? extends E> elements) {
        kotlin.jvm.internal.l0.p(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        h(size() + elements.size());
        d(t(this.f34546a + size()), elements);
        return true;
    }

    public final void addFirst(E e8) {
        h(size() + 1);
        int iG = g(this.f34546a);
        this.f34546a = iG;
        this.f34547b[iG] = e8;
        this.f34548c = size() + 1;
    }

    public final void addLast(E e8) {
        h(size() + 1);
        this.f34547b[t(this.f34546a + size())] = e8;
        this.f34548c = size() + 1;
    }

    @Override // kotlin.collections.f
    public E b(int i7) {
        c.f34509a.b(i7, size());
        if (i7 == y.H(this)) {
            return removeLast();
        }
        if (i7 == 0) {
            return removeFirst();
        }
        int iT = t(this.f34546a + i7);
        E e8 = (E) this.f34547b[iT];
        if (i7 < (size() >> 1)) {
            int i8 = this.f34546a;
            if (iT >= i8) {
                Object[] objArr = this.f34547b;
                o.c1(objArr, objArr, i8 + 1, i8, iT);
            } else {
                Object[] objArr2 = this.f34547b;
                o.c1(objArr2, objArr2, 1, 0, iT);
                Object[] objArr3 = this.f34547b;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i9 = this.f34546a;
                o.c1(objArr3, objArr3, i9 + 1, i9, objArr3.length - 1);
            }
            Object[] objArr4 = this.f34547b;
            int i10 = this.f34546a;
            objArr4[i10] = null;
            this.f34546a = l(i10);
        } else {
            int iT2 = t(this.f34546a + y.H(this));
            if (iT <= iT2) {
                Object[] objArr5 = this.f34547b;
                o.c1(objArr5, objArr5, iT, iT + 1, iT2 + 1);
            } else {
                Object[] objArr6 = this.f34547b;
                o.c1(objArr6, objArr6, iT, iT + 1, objArr6.length);
                Object[] objArr7 = this.f34547b;
                objArr7[objArr7.length - 1] = objArr7[0];
                o.c1(objArr7, objArr7, 0, 1, iT2 + 1);
            }
            this.f34547b[iT2] = null;
        }
        this.f34548c = size() - 1;
        return e8;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int iT = t(this.f34546a + size());
        int i7 = this.f34546a;
        if (i7 < iT) {
            o.n2(this.f34547b, null, i7, iT);
        } else if (!isEmpty()) {
            Object[] objArr = this.f34547b;
            o.n2(objArr, null, this.f34546a, objArr.length);
            o.n2(this.f34547b, null, 0, iT);
        }
        this.f34546a = 0;
        this.f34548c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final E first() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.f34547b[this.f34546a];
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i7) {
        c.f34509a.b(i7, size());
        return (E) this.f34547b[t(this.f34546a + i7)];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i7;
        int iT = t(this.f34546a + size());
        int length = this.f34546a;
        if (length < iT) {
            while (length < iT) {
                if (kotlin.jvm.internal.l0.g(obj, this.f34547b[length])) {
                    i7 = this.f34546a;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iT) {
            return -1;
        }
        int length2 = this.f34547b.length;
        while (length < length2) {
            if (kotlin.jvm.internal.l0.g(obj, this.f34547b[length])) {
                i7 = this.f34546a;
            } else {
                length++;
            }
        }
        for (int i8 = 0; i8 < iT; i8++) {
            if (kotlin.jvm.internal.l0.g(obj, this.f34547b[i8])) {
                length = i8 + this.f34547b.length;
                i7 = this.f34546a;
            }
        }
        return -1;
        return length - i7;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @a7.e
    public final E k() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.f34547b[this.f34546a];
    }

    public final E last() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.f34547b[t(this.f34546a + y.H(this))];
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int iXe;
        int i7;
        int iT = t(this.f34546a + size());
        int i8 = this.f34546a;
        if (i8 < iT) {
            iXe = iT - 1;
            if (i8 <= iXe) {
                while (!kotlin.jvm.internal.l0.g(obj, this.f34547b[iXe])) {
                    if (iXe != i8) {
                        iXe--;
                    }
                }
                i7 = this.f34546a;
                return iXe - i7;
            }
            return -1;
        }
        if (i8 > iT) {
            for (int i9 = iT - 1; -1 < i9; i9--) {
                if (kotlin.jvm.internal.l0.g(obj, this.f34547b[i9])) {
                    iXe = i9 + this.f34547b.length;
                    i7 = this.f34546a;
                    return iXe - i7;
                }
            }
            iXe = p.Xe(this.f34547b);
            int i10 = this.f34546a;
            if (i10 <= iXe) {
                while (!kotlin.jvm.internal.l0.g(obj, this.f34547b[iXe])) {
                    if (iXe != i10) {
                        iXe--;
                    }
                }
                i7 = this.f34546a;
                return iXe - i7;
            }
        }
        return -1;
    }

    public final void o(@a7.d i5.p<? super Integer, ? super Object[], l2> structure) {
        int i7;
        kotlin.jvm.internal.l0.p(structure, "structure");
        structure.a0(Integer.valueOf((isEmpty() || (i7 = this.f34546a) < t(this.f34546a + size())) ? this.f34546a : i7 - this.f34547b.length), toArray());
    }

    @a7.e
    public final E p() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.f34547b[t(this.f34546a + y.H(this))];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(@a7.d Collection<? extends Object> elements) {
        int iT;
        kotlin.jvm.internal.l0.p(elements, "elements");
        boolean z7 = false;
        z7 = false;
        z7 = false;
        if (!isEmpty()) {
            if ((this.f34547b.length == 0) == false) {
                int iT2 = t(this.f34546a + size());
                int i7 = this.f34546a;
                if (i7 < iT2) {
                    iT = i7;
                    while (i7 < iT2) {
                        Object obj = this.f34547b[i7];
                        if (!elements.contains(obj)) {
                            this.f34547b[iT] = obj;
                            iT++;
                        } else {
                            z7 = true;
                        }
                        i7++;
                    }
                    o.n2(this.f34547b, null, iT, iT2);
                } else {
                    int length = this.f34547b.length;
                    boolean z8 = false;
                    int i8 = i7;
                    while (i7 < length) {
                        Object[] objArr = this.f34547b;
                        Object obj2 = objArr[i7];
                        objArr[i7] = null;
                        if (!elements.contains(obj2)) {
                            this.f34547b[i8] = obj2;
                            i8++;
                        } else {
                            z8 = true;
                        }
                        i7++;
                    }
                    iT = t(i8);
                    for (int i9 = 0; i9 < iT2; i9++) {
                        Object[] objArr2 = this.f34547b;
                        Object obj3 = objArr2[i9];
                        objArr2[i9] = null;
                        if (!elements.contains(obj3)) {
                            this.f34547b[iT] = obj3;
                            iT = l(iT);
                        } else {
                            z8 = true;
                        }
                    }
                    z7 = z8;
                }
                if (z7) {
                    this.f34548c = r(iT - this.f34546a);
                }
            }
        }
        return z7;
    }

    public final E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        Object[] objArr = this.f34547b;
        int i7 = this.f34546a;
        E e8 = (E) objArr[i7];
        objArr[i7] = null;
        this.f34546a = l(i7);
        this.f34548c = size() - 1;
        return e8;
    }

    public final E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        int iT = t(this.f34546a + y.H(this));
        Object[] objArr = this.f34547b;
        E e8 = (E) objArr[iT];
        objArr[iT] = null;
        this.f34548c = size() - 1;
        return e8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(@a7.d Collection<? extends Object> elements) {
        int iT;
        kotlin.jvm.internal.l0.p(elements, "elements");
        boolean z7 = false;
        z7 = false;
        z7 = false;
        if (!isEmpty()) {
            if ((this.f34547b.length == 0) == false) {
                int iT2 = t(this.f34546a + size());
                int i7 = this.f34546a;
                if (i7 < iT2) {
                    iT = i7;
                    while (i7 < iT2) {
                        Object obj = this.f34547b[i7];
                        if (elements.contains(obj)) {
                            this.f34547b[iT] = obj;
                            iT++;
                        } else {
                            z7 = true;
                        }
                        i7++;
                    }
                    o.n2(this.f34547b, null, iT, iT2);
                } else {
                    int length = this.f34547b.length;
                    boolean z8 = false;
                    int i8 = i7;
                    while (i7 < length) {
                        Object[] objArr = this.f34547b;
                        Object obj2 = objArr[i7];
                        objArr[i7] = null;
                        if (elements.contains(obj2)) {
                            this.f34547b[i8] = obj2;
                            i8++;
                        } else {
                            z8 = true;
                        }
                        i7++;
                    }
                    iT = t(i8);
                    for (int i9 = 0; i9 < iT2; i9++) {
                        Object[] objArr2 = this.f34547b;
                        Object obj3 = objArr2[i9];
                        objArr2[i9] = null;
                        if (elements.contains(obj3)) {
                            this.f34547b[iT] = obj3;
                            iT = l(iT);
                        } else {
                            z8 = true;
                        }
                    }
                    z7 = z8;
                }
                if (z7) {
                    this.f34548c = r(iT - this.f34546a);
                }
            }
        }
        return z7;
    }

    @Override // kotlin.collections.f, java.util.AbstractList, java.util.List
    public E set(int i7, E e8) {
        c.f34509a.b(i7, size());
        int iT = t(this.f34546a + i7);
        Object[] objArr = this.f34547b;
        E e9 = (E) objArr[iT];
        objArr[iT] = e8;
        return e9;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @a7.d
    public <T> T[] toArray(@a7.d T[] array) {
        kotlin.jvm.internal.l0.p(array, "array");
        if (array.length < size()) {
            array = (T[]) m.a(array, size());
        }
        kotlin.jvm.internal.l0.n(array, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        int iT = t(this.f34546a + size());
        int i7 = this.f34546a;
        if (i7 < iT) {
            o.l1(this.f34547b, array, 0, i7, iT, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr = this.f34547b;
            o.c1(objArr, array, 0, this.f34546a, objArr.length);
            Object[] objArr2 = this.f34547b;
            o.c1(objArr2, array, objArr2.length - this.f34546a, 0, iT);
        }
        if (array.length > size()) {
            array[size()] = null;
        }
        return array;
    }

    @a7.e
    public final E u() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    @a7.e
    public final E w() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    @a7.d
    public final Object[] x() {
        return toArray();
    }

    @a7.d
    public final <T> T[] z(@a7.d T[] array) {
        kotlin.jvm.internal.l0.p(array, "array");
        return (T[]) toArray(array);
    }

    @Override // kotlin.collections.f, java.util.AbstractList, java.util.List
    public void add(int i7, E e8) {
        c.f34509a.c(i7, size());
        if (i7 == size()) {
            addLast(e8);
            return;
        }
        if (i7 == 0) {
            addFirst(e8);
            return;
        }
        h(size() + 1);
        int iT = t(this.f34546a + i7);
        if (i7 < ((size() + 1) >> 1)) {
            int iG = g(iT);
            int iG2 = g(this.f34546a);
            int i8 = this.f34546a;
            if (iG >= i8) {
                Object[] objArr = this.f34547b;
                objArr[iG2] = objArr[i8];
                o.c1(objArr, objArr, i8, i8 + 1, iG + 1);
            } else {
                Object[] objArr2 = this.f34547b;
                o.c1(objArr2, objArr2, i8 - 1, i8, objArr2.length);
                Object[] objArr3 = this.f34547b;
                objArr3[objArr3.length - 1] = objArr3[0];
                o.c1(objArr3, objArr3, 0, 1, iG + 1);
            }
            this.f34547b[iG] = e8;
            this.f34546a = iG2;
        } else {
            int iT2 = t(this.f34546a + size());
            if (iT < iT2) {
                Object[] objArr4 = this.f34547b;
                o.c1(objArr4, objArr4, iT + 1, iT, iT2);
            } else {
                Object[] objArr5 = this.f34547b;
                o.c1(objArr5, objArr5, 1, 0, iT2);
                Object[] objArr6 = this.f34547b;
                objArr6[0] = objArr6[objArr6.length - 1];
                o.c1(objArr6, objArr6, iT + 1, iT, objArr6.length - 1);
            }
            this.f34547b[iT] = e8;
        }
        this.f34548c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i7, @a7.d Collection<? extends E> elements) {
        kotlin.jvm.internal.l0.p(elements, "elements");
        c.f34509a.c(i7, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (i7 == size()) {
            return addAll(elements);
        }
        h(size() + elements.size());
        int iT = t(this.f34546a + size());
        int iT2 = t(this.f34546a + i7);
        int size = elements.size();
        if (i7 < ((size() + 1) >> 1)) {
            int i8 = this.f34546a;
            int length = i8 - size;
            if (iT2 < i8) {
                Object[] objArr = this.f34547b;
                o.c1(objArr, objArr, length, i8, objArr.length);
                if (size >= iT2) {
                    Object[] objArr2 = this.f34547b;
                    o.c1(objArr2, objArr2, objArr2.length - size, 0, iT2);
                } else {
                    Object[] objArr3 = this.f34547b;
                    o.c1(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f34547b;
                    o.c1(objArr4, objArr4, 0, size, iT2);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.f34547b;
                o.c1(objArr5, objArr5, length, i8, iT2);
            } else {
                Object[] objArr6 = this.f34547b;
                length += objArr6.length;
                int i9 = iT2 - i8;
                int length2 = objArr6.length - length;
                if (length2 >= i9) {
                    o.c1(objArr6, objArr6, length, i8, iT2);
                } else {
                    o.c1(objArr6, objArr6, length, i8, i8 + length2);
                    Object[] objArr7 = this.f34547b;
                    o.c1(objArr7, objArr7, 0, this.f34546a + length2, iT2);
                }
            }
            this.f34546a = length;
            d(r(iT2 - size), elements);
        } else {
            int i10 = iT2 + size;
            if (iT2 < iT) {
                int i11 = size + iT;
                Object[] objArr8 = this.f34547b;
                if (i11 <= objArr8.length) {
                    o.c1(objArr8, objArr8, i10, iT2, iT);
                } else if (i10 >= objArr8.length) {
                    o.c1(objArr8, objArr8, i10 - objArr8.length, iT2, iT);
                } else {
                    int length3 = iT - (i11 - objArr8.length);
                    o.c1(objArr8, objArr8, 0, length3, iT);
                    Object[] objArr9 = this.f34547b;
                    o.c1(objArr9, objArr9, i10, iT2, length3);
                }
            } else {
                Object[] objArr10 = this.f34547b;
                o.c1(objArr10, objArr10, size, 0, iT);
                Object[] objArr11 = this.f34547b;
                if (i10 >= objArr11.length) {
                    o.c1(objArr11, objArr11, i10 - objArr11.length, iT2, objArr11.length);
                } else {
                    o.c1(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f34547b;
                    o.c1(objArr12, objArr12, i10, iT2, objArr12.length - size);
                }
            }
            d(iT2, elements);
        }
        return true;
    }

    public k() {
        this.f34547b = f34543e;
    }

    public k(@a7.d Collection<? extends E> elements) {
        kotlin.jvm.internal.l0.p(elements, "elements");
        Object[] array = elements.toArray(new Object[0]);
        kotlin.jvm.internal.l0.n(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this.f34547b = array;
        this.f34548c = array.length;
        if (array.length == 0) {
            this.f34547b = f34543e;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @a7.d
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
