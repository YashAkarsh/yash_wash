package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
class k3<K, V> extends AbstractMap<K, V> implements Serializable {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f20504l = 1073741824;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final float f20505m = 1.0f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final long f20506n = 4294967295L;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final long f20507o = -4294967296L;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final int f20508p = 3;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    static final int f20509q = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient int[] f20510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @s1.d
    transient long[] f20511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @s1.d
    transient Object[] f20512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @s1.d
    transient Object[] f20513d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    transient float f20514e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    transient int f20515f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient int f20516g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private transient int f20517h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private transient Set<K> f20518i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private transient Set<Map.Entry<K, V>> f20519j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private transient Collection<V> f20520k;

    class a extends k3<K, V>.e<K> {
        a() {
            super(k3.this, null);
        }

        @Override // com.google.common.collect.k3.e
        K b(int i7) {
            return (K) k3.this.f20512c[i7];
        }
    }

    class b extends k3<K, V>.e<Map.Entry<K, V>> {
        b() {
            super(k3.this, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.k3.e
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> b(int i7) {
            return new g(i7);
        }
    }

    class c extends k3<K, V>.e<V> {
        c() {
            super(k3.this, null);
        }

        @Override // com.google.common.collect.k3.e
        V b(int i7) {
            return (V) k3.this.f20513d[i7];
        }
    }

    class d extends wb.t<K, V> {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Map.Entry j(int i7) {
            return new g(i7);
        }

        @Override // com.google.common.collect.wb.t, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iU = k3.this.u(entry.getKey());
            return iU != -1 && com.google.common.base.y.a(k3.this.f20513d[iU], entry.getValue());
        }

        @Override // com.google.common.collect.wb.t
        Map<K, V> g() {
            return k3.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return k3.this.m();
        }

        @Override // com.google.common.collect.wb.t, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iU = k3.this.u(entry.getKey());
            if (iU == -1 || !com.google.common.base.y.a(k3.this.f20513d[iU], entry.getValue())) {
                return false;
            }
            k3.this.H(iU);
            return true;
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set
        public Spliterator<Map.Entry<K, V>> spliterator() {
            return q2.c(k3.this.f20517h, 17, new IntFunction() { // from class: com.google.common.collect.l3
                @Override // java.util.function.IntFunction
                public final Object apply(int i7) {
                    return this.f20565a.j(i7);
                }
            });
        }
    }

    class f extends wb.c0<K, V> {
        f() {
            super(k3.this);
        }

        @Override // com.google.common.collect.wb.c0, java.lang.Iterable
        public void forEach(Consumer<? super K> consumer) {
            com.google.common.base.e0.E(consumer);
            for (int i7 = 0; i7 < k3.this.f20517h; i7++) {
                consumer.accept(k3.this.f20512c[i7]);
            }
        }

        @Override // com.google.common.collect.wb.c0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return k3.this.z();
        }

        @Override // com.google.common.collect.wb.c0, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int iU = k3.this.u(obj);
            if (iU == -1) {
                return false;
            }
            k3.this.H(iU);
            return true;
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set
        public Spliterator<K> spliterator() {
            k3 k3Var = k3.this;
            return Spliterators.spliterator(k3Var.f20512c, 0, k3Var.f20517h, 17);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            k3 k3Var = k3.this;
            return sd.g(k3Var.f20512c, 0, k3Var.f20517h);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            k3 k3Var = k3.this;
            return (T[]) sd.n(k3Var.f20512c, 0, k3Var.f20517h, tArr);
        }
    }

    final class g extends v<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final K f20530a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f20531b;

        g(int i7) {
            this.f20530a = (K) k3.this.f20512c[i7];
            this.f20531b = i7;
        }

        private void c() {
            int i7 = this.f20531b;
            if (i7 == -1 || i7 >= k3.this.size() || !com.google.common.base.y.a(this.f20530a, k3.this.f20512c[this.f20531b])) {
                this.f20531b = k3.this.u(this.f20530a);
            }
        }

        @Override // com.google.common.collect.v, java.util.Map.Entry
        public K getKey() {
            return this.f20530a;
        }

        @Override // com.google.common.collect.v, java.util.Map.Entry
        public V getValue() {
            c();
            int i7 = this.f20531b;
            if (i7 == -1) {
                return null;
            }
            return (V) k3.this.f20513d[i7];
        }

        @Override // com.google.common.collect.v, java.util.Map.Entry
        public V setValue(V v7) {
            c();
            int i7 = this.f20531b;
            if (i7 == -1) {
                k3.this.put(this.f20530a, v7);
                return null;
            }
            Object[] objArr = k3.this.f20513d;
            V v8 = (V) objArr[i7];
            objArr[i7] = v7;
            return v8;
        }
    }

    class h extends wb.r0<K, V> {
        h() {
            super(k3.this);
        }

        @Override // com.google.common.collect.wb.r0, java.lang.Iterable
        public void forEach(Consumer<? super V> consumer) {
            com.google.common.base.e0.E(consumer);
            for (int i7 = 0; i7 < k3.this.f20517h; i7++) {
                consumer.accept(k3.this.f20513d[i7]);
            }
        }

        @Override // com.google.common.collect.wb.r0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return k3.this.N();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<V> spliterator() {
            k3 k3Var = k3.this;
            return Spliterators.spliterator(k3Var.f20513d, 0, k3Var.f20517h, 16);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            k3 k3Var = k3.this;
            return sd.g(k3Var.f20513d, 0, k3Var.f20517h);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            k3 k3Var = k3.this;
            return (T[]) sd.n(k3Var.f20513d, 0, k3Var.f20517h, tArr);
        }
    }

    k3() {
        w(3, 1.0f);
    }

    private static long[] C(int i7) {
        long[] jArr = new long[i7];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    private static int[] D(int i7) {
        int[] iArr = new int[i7];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private V E(Object obj, int i7) {
        int iT = t() & i7;
        int i8 = this.f20510a[iT];
        if (i8 == -1) {
            return null;
        }
        int i9 = -1;
        while (true) {
            if (o(this.f20511b[i8]) == i7 && com.google.common.base.y.a(obj, this.f20512c[i8])) {
                V v7 = (V) this.f20513d[i8];
                if (i9 == -1) {
                    this.f20510a[iT] = q(this.f20511b[i8]);
                } else {
                    long[] jArr = this.f20511b;
                    jArr[i9] = L(jArr[i9], q(jArr[i8]));
                }
                B(i8);
                this.f20517h--;
                this.f20515f++;
                return v7;
            }
            int iQ = q(this.f20511b[i8]);
            if (iQ == -1) {
                return null;
            }
            i9 = i8;
            i8 = iQ;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @u1.a
    public V H(int i7) {
        return E(this.f20512c[i7], o(this.f20511b[i7]));
    }

    private void J(int i7) {
        int length = this.f20511b.length;
        if (i7 > length) {
            int iMax = Math.max(1, length >>> 1) + length;
            if (iMax < 0) {
                iMax = Integer.MAX_VALUE;
            }
            if (iMax != length) {
                I(iMax);
            }
        }
    }

    private void K(int i7) {
        if (this.f20510a.length >= 1073741824) {
            this.f20516g = Integer.MAX_VALUE;
            return;
        }
        int i8 = ((int) (i7 * this.f20514e)) + 1;
        int[] iArrD = D(i7);
        long[] jArr = this.f20511b;
        int length = iArrD.length - 1;
        for (int i9 = 0; i9 < this.f20517h; i9++) {
            int iO = o(jArr[i9]);
            int i10 = iO & length;
            int i11 = iArrD[i10];
            iArrD[i10] = i9;
            jArr[i9] = (((long) iO) << 32) | (((long) i11) & f20506n);
        }
        this.f20516g = i8;
        this.f20510a = iArrD;
    }

    private static long L(long j7, int i7) {
        return (j7 & f20507o) | (f20506n & ((long) i7));
    }

    public static <K, V> k3<K, V> f() {
        return new k3<>();
    }

    public static <K, V> k3<K, V> l(int i7) {
        return new k3<>(i7);
    }

    private static int o(long j7) {
        return (int) (j7 >>> 32);
    }

    private static int q(long j7) {
        return (int) j7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        w(3, 1.0f);
        int i7 = objectInputStream.readInt();
        while (true) {
            i7--;
            if (i7 < 0) {
                return;
            } else {
                put(objectInputStream.readObject(), objectInputStream.readObject());
            }
        }
    }

    private int t() {
        return this.f20510a.length - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int u(Object obj) {
        int iD = s6.d(obj);
        int iQ = this.f20510a[t() & iD];
        while (iQ != -1) {
            long j7 = this.f20511b[iQ];
            if (o(j7) == iD && com.google.common.base.y.a(obj, this.f20512c[iQ])) {
                return iQ;
            }
            iQ = q(j7);
        }
        return -1;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.f20517h);
        for (int i7 = 0; i7 < this.f20517h; i7++) {
            objectOutputStream.writeObject(this.f20512c[i7]);
            objectOutputStream.writeObject(this.f20513d[i7]);
        }
    }

    void B(int i7) {
        int size = size() - 1;
        if (i7 >= size) {
            this.f20512c[i7] = null;
            this.f20513d[i7] = null;
            this.f20511b[i7] = -1;
            return;
        }
        Object[] objArr = this.f20512c;
        objArr[i7] = objArr[size];
        Object[] objArr2 = this.f20513d;
        objArr2[i7] = objArr2[size];
        objArr[size] = null;
        objArr2[size] = null;
        long[] jArr = this.f20511b;
        long j7 = jArr[size];
        jArr[i7] = j7;
        jArr[size] = -1;
        int iO = o(j7) & t();
        int[] iArr = this.f20510a;
        int i8 = iArr[iO];
        if (i8 == size) {
            iArr[iO] = i7;
            return;
        }
        while (true) {
            long j8 = this.f20511b[i8];
            int iQ = q(j8);
            if (iQ == size) {
                this.f20511b[i8] = L(j8, i7);
                return;
            }
            i8 = iQ;
        }
    }

    void I(int i7) {
        this.f20512c = Arrays.copyOf(this.f20512c, i7);
        this.f20513d = Arrays.copyOf(this.f20513d, i7);
        long[] jArr = this.f20511b;
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, i7);
        if (i7 > length) {
            Arrays.fill(jArrCopyOf, length, i7, -1L);
        }
        this.f20511b = jArrCopyOf;
    }

    public void M() {
        int i7 = this.f20517h;
        if (i7 < this.f20511b.length) {
            I(i7);
        }
        int iMax = Math.max(1, Integer.highestOneBit((int) (i7 / this.f20514e)));
        if (iMax < 1073741824 && ((double) i7) / ((double) iMax) > this.f20514e) {
            iMax <<= 1;
        }
        if (iMax < this.f20510a.length) {
            K(iMax);
        }
    }

    Iterator<V> N() {
        return new c();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f20515f++;
        Arrays.fill(this.f20512c, 0, this.f20517h, (Object) null);
        Arrays.fill(this.f20513d, 0, this.f20517h, (Object) null);
        Arrays.fill(this.f20510a, -1);
        Arrays.fill(this.f20511b, -1L);
        this.f20517h = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return u(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        for (int i7 = 0; i7 < this.f20517h; i7++) {
            if (com.google.common.base.y.a(obj, this.f20513d[i7])) {
                return true;
            }
        }
        return false;
    }

    void d(int i7) {
    }

    int e(int i7, int i8) {
        return i7 - 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f20519j;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> setG = g();
        this.f20519j = setG;
        return setG;
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        com.google.common.base.e0.E(biConsumer);
        for (int i7 = 0; i7 < this.f20517h; i7++) {
            biConsumer.accept(this.f20512c[i7], this.f20513d[i7]);
        }
    }

    Set<Map.Entry<K, V>> g() {
        return new d();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        int iU = u(obj);
        d(iU);
        if (iU == -1) {
            return null;
        }
        return (V) this.f20513d[iU];
    }

    Set<K> i() {
        return new f();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.f20517h == 0;
    }

    Collection<V> k() {
        return new h();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.f20518i;
        if (set != null) {
            return set;
        }
        Set<K> setI = i();
        this.f20518i = setI;
        return setI;
    }

    Iterator<Map.Entry<K, V>> m() {
        return new b();
    }

    int n() {
        return isEmpty() ? -1 : 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @u1.a
    public V put(K k7, V v7) {
        long[] jArr = this.f20511b;
        Object[] objArr = this.f20512c;
        Object[] objArr2 = this.f20513d;
        int iD = s6.d(k7);
        int iT = t() & iD;
        int i7 = this.f20517h;
        int[] iArr = this.f20510a;
        int i8 = iArr[iT];
        if (i8 == -1) {
            iArr[iT] = i7;
        } else {
            while (true) {
                long j7 = jArr[i8];
                if (o(j7) == iD && com.google.common.base.y.a(k7, objArr[i8])) {
                    V v8 = (V) objArr2[i8];
                    objArr2[i8] = v7;
                    d(i8);
                    return v8;
                }
                int iQ = q(j7);
                if (iQ == -1) {
                    jArr[i8] = L(j7, i7);
                    break;
                }
                i8 = iQ;
            }
        }
        if (i7 == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        int i9 = i7 + 1;
        J(i9);
        y(i7, k7, v7, iD);
        this.f20517h = i9;
        if (i7 >= this.f20516g) {
            K(this.f20510a.length * 2);
        }
        this.f20515f++;
        return null;
    }

    int r(int i7) {
        int i8 = i7 + 1;
        if (i8 < this.f20517h) {
            return i8;
        }
        return -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @u1.a
    public V remove(Object obj) {
        return E(obj, s6.d(obj));
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
        com.google.common.base.e0.E(biFunction);
        for (int i7 = 0; i7 < this.f20517h; i7++) {
            Object[] objArr = this.f20513d;
            objArr[i7] = biFunction.apply(this.f20512c[i7], objArr[i7]);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f20517h;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.f20520k;
        if (collection != null) {
            return collection;
        }
        Collection<V> collectionK = k();
        this.f20520k = collectionK;
        return collectionK;
    }

    void w(int i7, float f8) {
        com.google.common.base.e0.e(i7 >= 0, "Initial capacity must be non-negative");
        com.google.common.base.e0.e(f8 > 0.0f, "Illegal load factor");
        int iA = s6.a(i7, f8);
        this.f20510a = D(iA);
        this.f20514e = f8;
        this.f20512c = new Object[i7];
        this.f20513d = new Object[i7];
        this.f20511b = C(i7);
        this.f20516g = Math.max(1, (int) (iA * f8));
    }

    void y(int i7, K k7, V v7, int i8) {
        this.f20511b[i7] = (((long) i8) << 32) | f20506n;
        this.f20512c[i7] = k7;
        this.f20513d[i7] = v7;
    }

    Iterator<K> z() {
        return new a();
    }

    k3(int i7) {
        this(i7, 1.0f);
    }

    private abstract class e<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20525a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f20526b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f20527c;

        private e() {
            this.f20525a = k3.this.f20515f;
            this.f20526b = k3.this.n();
            this.f20527c = -1;
        }

        private void a() {
            if (k3.this.f20515f != this.f20525a) {
                throw new ConcurrentModificationException();
            }
        }

        abstract T b(int i7);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f20526b >= 0;
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i7 = this.f20526b;
            this.f20527c = i7;
            T tB = b(i7);
            this.f20526b = k3.this.r(this.f20526b);
            return tB;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            f2.e(this.f20527c >= 0);
            this.f20525a++;
            k3.this.H(this.f20527c);
            this.f20526b = k3.this.e(this.f20526b, this.f20527c);
            this.f20527c = -1;
        }

        /* synthetic */ e(k3 k3Var, a aVar) {
            this();
        }
    }

    k3(int i7, float f8) {
        w(i7, f8);
    }
}
