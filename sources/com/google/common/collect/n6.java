package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
public final class n6<K, V> extends wb.b0<K, V> implements r0<K, V>, Serializable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final double f20711i = 1.0d;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @s1.c
    private static final long f20712j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient b<K, V>[] f20713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient b<K, V>[] f20714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient b<K, V> f20715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private transient b<K, V> f20716d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private transient int f20717e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient int f20718f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient int f20719g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @y1.h
    private transient r0<V, K> f20720h;

    class a extends n6<K, V>.e<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: com.google.common.collect.n6$a$a, reason: collision with other inner class name */
        class C0250a extends v<K, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            b<K, V> f20722a;

            C0250a(b<K, V> bVar) {
                this.f20722a = bVar;
            }

            @Override // com.google.common.collect.v, java.util.Map.Entry
            public K getKey() {
                return this.f20722a.f21445a;
            }

            @Override // com.google.common.collect.v, java.util.Map.Entry
            public V getValue() {
                return this.f20722a.f21446b;
            }

            @Override // com.google.common.collect.v, java.util.Map.Entry
            public V setValue(V v7) {
                V v8 = this.f20722a.f21446b;
                int iD = s6.d(v7);
                if (iD == this.f20722a.f20725e && com.google.common.base.y.a(v7, v8)) {
                    return v7;
                }
                com.google.common.base.e0.u(n6.this.D(v7, iD) == null, "value already present: %s", v7);
                n6.this.t(this.f20722a);
                b<K, V> bVar = this.f20722a;
                b<K, V> bVar2 = new b<>(bVar.f21445a, bVar.f20724d, v7, iD);
                n6.this.w(bVar2, this.f20722a);
                b<K, V> bVar3 = this.f20722a;
                bVar3.f20729i = null;
                bVar3.f20728h = null;
                a aVar = a.this;
                aVar.f20739c = n6.this.f20719g;
                a aVar2 = a.this;
                if (aVar2.f20738b == this.f20722a) {
                    aVar2.f20738b = bVar2;
                }
                this.f20722a = bVar2;
                return v8;
            }
        }

        a() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.n6.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> a(b<K, V> bVar) {
            return new C0250a(bVar);
        }
    }

    private static final class b<K, V> extends y6<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f20724d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final int f20725e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        b<K, V> f20726f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        b<K, V> f20727g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        b<K, V> f20728h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        b<K, V> f20729i;

        b(K k7, int i7, V v7, int i8) {
            super(k7, v7);
            this.f20724d = i7;
            this.f20725e = i8;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class c extends wb.b0<V, K> implements r0<V, K>, Serializable {

        class a extends n6<K, V>.e<Map.Entry<V, K>> {

            /* JADX INFO: renamed from: com.google.common.collect.n6$c$a$a, reason: collision with other inner class name */
            class C0251a extends v<V, K> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                b<K, V> f20732a;

                C0251a(b<K, V> bVar) {
                    this.f20732a = bVar;
                }

                @Override // com.google.common.collect.v, java.util.Map.Entry
                public V getKey() {
                    return this.f20732a.f21446b;
                }

                @Override // com.google.common.collect.v, java.util.Map.Entry
                public K getValue() {
                    return this.f20732a.f21445a;
                }

                @Override // com.google.common.collect.v, java.util.Map.Entry
                public K setValue(K k7) {
                    K k8 = this.f20732a.f21445a;
                    int iD = s6.d(k7);
                    if (iD == this.f20732a.f20724d && com.google.common.base.y.a(k7, k8)) {
                        return k7;
                    }
                    com.google.common.base.e0.u(n6.this.C(k7, iD) == null, "value already present: %s", k7);
                    n6.this.t(this.f20732a);
                    b<K, V> bVar = this.f20732a;
                    b<K, V> bVar2 = new b<>(k7, iD, bVar.f21446b, bVar.f20725e);
                    this.f20732a = bVar2;
                    n6.this.w(bVar2, null);
                    a aVar = a.this;
                    aVar.f20739c = n6.this.f20719g;
                    return k8;
                }
            }

            a() {
                super();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.n6.e
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry<V, K> a(b<K, V> bVar) {
                return new C0251a(bVar);
            }
        }

        private final class b extends wb.c0<V, K> {

            class a extends n6<K, V>.e<V> {
                a() {
                    super();
                }

                @Override // com.google.common.collect.n6.e
                V a(b<K, V> bVar) {
                    return bVar.f21446b;
                }
            }

            b() {
                super(c.this);
            }

            @Override // com.google.common.collect.wb.c0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<V> iterator() {
                return new a();
            }

            @Override // com.google.common.collect.wb.c0, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                b bVarD = n6.this.D(obj, s6.d(obj));
                if (bVarD == null) {
                    return false;
                }
                n6.this.t(bVarD);
                return true;
            }
        }

        private c() {
        }

        @Override // com.google.common.collect.r0
        public r0<K, V> T() {
            return e();
        }

        @Override // com.google.common.collect.wb.b0
        Iterator<Map.Entry<V, K>> a() {
            return new a();
        }

        @Override // com.google.common.collect.wb.b0, java.util.AbstractMap, java.util.Map
        public void clear() {
            e().clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return e().containsValue(obj);
        }

        r0<K, V> e() {
            return n6.this;
        }

        @Override // java.util.Map
        public void forEach(final BiConsumer<? super V, ? super K> biConsumer) {
            com.google.common.base.e0.E(biConsumer);
            n6.this.forEach(new BiConsumer() { // from class: com.google.common.collect.o6
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    h.a(biConsumer, obj2, obj);
                }
            });
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K get(Object obj) {
            return (K) wb.Y(n6.this.D(obj, s6.d(obj)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<V> keySet() {
            return new b();
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.r0
        @u1.a
        public K put(V v7, K k7) {
            return (K) n6.this.z(v7, k7, false);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K remove(Object obj) {
            b bVarD = n6.this.D(obj, s6.d(obj));
            if (bVarD == null) {
                return null;
            }
            n6.this.t(bVarD);
            bVarD.f20729i = null;
            bVarD.f20728h = null;
            return bVarD.f21445a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        public void replaceAll(BiFunction<? super V, ? super K, ? extends K> biFunction) {
            com.google.common.base.e0.E(biFunction);
            clear();
            for (b<K, V> bVar = n6.this.f20715c; bVar != null; bVar = bVar.f20728h) {
                V v7 = bVar.f21446b;
                put(v7, biFunction.apply(v7, bVar.f21445a));
            }
        }

        @Override // com.google.common.collect.wb.b0, java.util.AbstractMap, java.util.Map
        public int size() {
            return n6.this.f20717e;
        }

        Object writeReplace() {
            return new d(n6.this);
        }

        @Override // com.google.common.collect.r0
        public K x(V v7, K k7) {
            return (K) n6.this.z(v7, k7, true);
        }

        /* synthetic */ c(n6 n6Var, a aVar) {
            this();
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.r0
        public Set<K> values() {
            return e().keySet();
        }
    }

    private static final class d<K, V> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final n6<K, V> f20736a;

        d(n6<K, V> n6Var) {
            this.f20736a = n6Var;
        }

        Object readResolve() {
            return this.f20736a.T();
        }
    }

    abstract class e<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        b<K, V> f20737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        b<K, V> f20738b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f20739c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f20740d;

        e() {
            this.f20737a = n6.this.f20715c;
            this.f20739c = n6.this.f20719g;
            this.f20740d = n6.this.size();
        }

        abstract T a(b<K, V> bVar);

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (n6.this.f20719g == this.f20739c) {
                return this.f20737a != null && this.f20740d > 0;
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            b<K, V> bVar = this.f20737a;
            this.f20737a = bVar.f20728h;
            this.f20738b = bVar;
            this.f20740d--;
            return a(bVar);
        }

        @Override // java.util.Iterator
        public void remove() {
            if (n6.this.f20719g != this.f20739c) {
                throw new ConcurrentModificationException();
            }
            f2.e(this.f20738b != null);
            n6.this.t(this.f20738b);
            this.f20739c = n6.this.f20719g;
            this.f20738b = null;
        }
    }

    private final class f extends wb.c0<K, V> {

        class a extends n6<K, V>.e<K> {
            a() {
                super();
            }

            @Override // com.google.common.collect.n6.e
            K a(b<K, V> bVar) {
                return bVar.f21445a;
            }
        }

        f() {
            super(n6.this);
        }

        @Override // com.google.common.collect.wb.c0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a();
        }

        @Override // com.google.common.collect.wb.c0, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            b bVarC = n6.this.C(obj, s6.d(obj));
            if (bVarC == null) {
                return false;
            }
            n6.this.t(bVarC);
            bVarC.f20729i = null;
            bVarC.f20728h = null;
            return true;
        }
    }

    private n6(int i7) {
        u(i7);
    }

    private void B() {
        b<K, V>[] bVarArr = this.f20713a;
        if (s6.b(this.f20717e, bVarArr.length, 1.0d)) {
            int length = bVarArr.length * 2;
            this.f20713a = r(length);
            this.f20714b = r(length);
            this.f20718f = length - 1;
            this.f20717e = 0;
            for (b<K, V> bVar = this.f20715c; bVar != null; bVar = bVar.f20728h) {
                w(bVar, bVar);
            }
            this.f20719g++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b<K, V> C(Object obj, int i7) {
        for (b<K, V> bVar = this.f20713a[this.f20718f & i7]; bVar != null; bVar = bVar.f20726f) {
            if (i7 == bVar.f20724d && com.google.common.base.y.a(obj, bVar.f21445a)) {
                return bVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b<K, V> D(Object obj, int i7) {
        for (b<K, V> bVar = this.f20714b[this.f20718f & i7]; bVar != null; bVar = bVar.f20727g) {
            if (i7 == bVar.f20725e && com.google.common.base.y.a(obj, bVar.f21446b)) {
                return bVar;
            }
        }
        return null;
    }

    public static <K, V> n6<K, V> n() {
        return o(16);
    }

    public static <K, V> n6<K, V> o(int i7) {
        return new n6<>(i7);
    }

    public static <K, V> n6<K, V> q(Map<? extends K, ? extends V> map) {
        n6<K, V> n6VarO = o(map.size());
        n6VarO.putAll(map);
        return n6VarO;
    }

    private b<K, V>[] r(int i7) {
        return new b[i7];
    }

    @s1.c
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int iH = se.h(objectInputStream);
        u(16);
        se.c(this, objectInputStream, iH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(b<K, V> bVar) {
        b<K, V> bVar2;
        int i7 = bVar.f20724d & this.f20718f;
        b<K, V> bVar3 = null;
        b<K, V> bVar4 = null;
        for (b<K, V> bVar5 = this.f20713a[i7]; bVar5 != bVar; bVar5 = bVar5.f20726f) {
            bVar4 = bVar5;
        }
        if (bVar4 == null) {
            this.f20713a[i7] = bVar.f20726f;
        } else {
            bVar4.f20726f = bVar.f20726f;
        }
        int i8 = bVar.f20725e & this.f20718f;
        b<K, V> bVar6 = this.f20714b[i8];
        while (true) {
            bVar2 = bVar3;
            bVar3 = bVar6;
            if (bVar3 == bVar) {
                break;
            } else {
                bVar6 = bVar3.f20727g;
            }
        }
        if (bVar2 == null) {
            this.f20714b[i8] = bVar.f20727g;
        } else {
            bVar2.f20727g = bVar.f20727g;
        }
        b<K, V> bVar7 = bVar.f20729i;
        if (bVar7 == null) {
            this.f20715c = bVar.f20728h;
        } else {
            bVar7.f20728h = bVar.f20728h;
        }
        b<K, V> bVar8 = bVar.f20728h;
        if (bVar8 == null) {
            this.f20716d = bVar7;
        } else {
            bVar8.f20729i = bVar7;
        }
        this.f20717e--;
        this.f20719g++;
    }

    private void u(int i7) {
        f2.b(i7, "expectedSize");
        int iA = s6.a(i7, 1.0d);
        this.f20713a = r(iA);
        this.f20714b = r(iA);
        this.f20715c = null;
        this.f20716d = null;
        this.f20717e = 0;
        this.f20718f = iA - 1;
        this.f20719g = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(b<K, V> bVar, b<K, V> bVar2) {
        int i7 = bVar.f20724d;
        int i8 = this.f20718f;
        int i9 = i7 & i8;
        b<K, V>[] bVarArr = this.f20713a;
        bVar.f20726f = bVarArr[i9];
        bVarArr[i9] = bVar;
        int i10 = bVar.f20725e & i8;
        b<K, V>[] bVarArr2 = this.f20714b;
        bVar.f20727g = bVarArr2[i10];
        bVarArr2[i10] = bVar;
        if (bVar2 == null) {
            b<K, V> bVar3 = this.f20716d;
            bVar.f20729i = bVar3;
            bVar.f20728h = null;
            if (bVar3 == null) {
                this.f20715c = bVar;
            } else {
                bVar3.f20728h = bVar;
            }
            this.f20716d = bVar;
        } else {
            b<K, V> bVar4 = bVar2.f20729i;
            bVar.f20729i = bVar4;
            if (bVar4 == null) {
                this.f20715c = bVar;
            } else {
                bVar4.f20728h = bVar;
            }
            b<K, V> bVar5 = bVar2.f20728h;
            bVar.f20728h = bVar5;
            if (bVar5 == null) {
                this.f20716d = bVar;
            } else {
                bVar5.f20729i = bVar;
            }
        }
        this.f20717e++;
        this.f20719g++;
    }

    @s1.c
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        se.i(this, objectOutputStream);
    }

    private V y(K k7, V v7, boolean z7) {
        int iD = s6.d(k7);
        int iD2 = s6.d(v7);
        b<K, V> bVarC = C(k7, iD);
        if (bVarC != null && iD2 == bVarC.f20725e && com.google.common.base.y.a(v7, bVarC.f21446b)) {
            return v7;
        }
        b<K, V> bVarD = D(v7, iD2);
        if (bVarD != null) {
            if (!z7) {
                throw new IllegalArgumentException("value already present: " + v7);
            }
            t(bVarD);
        }
        b<K, V> bVar = new b<>(k7, iD, v7, iD2);
        if (bVarC == null) {
            w(bVar, null);
            B();
            return null;
        }
        t(bVarC);
        w(bVar, bVarC);
        bVarC.f20729i = null;
        bVarC.f20728h = null;
        return bVarC.f21446b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public K z(V v7, K k7, boolean z7) {
        int iD = s6.d(v7);
        int iD2 = s6.d(k7);
        b<K, V> bVarD = D(v7, iD);
        b<K, V> bVarC = C(k7, iD2);
        if (bVarD != null && iD2 == bVarD.f20724d && com.google.common.base.y.a(k7, bVarD.f21445a)) {
            return k7;
        }
        if (bVarC != null && !z7) {
            throw new IllegalArgumentException("key already present: " + k7);
        }
        if (bVarD != null) {
            t(bVarD);
        }
        if (bVarC != null) {
            t(bVarC);
        }
        w(new b<>(k7, iD2, v7, iD), bVarC);
        if (bVarC != null) {
            bVarC.f20729i = null;
            bVarC.f20728h = null;
        }
        if (bVarD != null) {
            bVarD.f20729i = null;
            bVarD.f20728h = null;
        }
        B();
        return (K) wb.Y(bVarD);
    }

    @Override // com.google.common.collect.r0
    public r0<V, K> T() {
        r0<V, K> r0Var = this.f20720h;
        if (r0Var != null) {
            return r0Var;
        }
        c cVar = new c(this, null);
        this.f20720h = cVar;
        return cVar;
    }

    @Override // com.google.common.collect.wb.b0
    Iterator<Map.Entry<K, V>> a() {
        return new a();
    }

    @Override // com.google.common.collect.wb.b0, java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f20717e = 0;
        Arrays.fill(this.f20713a, (Object) null);
        Arrays.fill(this.f20714b, (Object) null);
        this.f20715c = null;
        this.f20716d = null;
        this.f20719g++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return C(obj, s6.d(obj)) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return D(obj, s6.d(obj)) != null;
    }

    @Override // com.google.common.collect.wb.b0, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        com.google.common.base.e0.E(biConsumer);
        for (b<K, V> bVar = this.f20715c; bVar != null; bVar = bVar.f20728h) {
            biConsumer.accept(bVar.f21445a, bVar.f21446b);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        return (V) wb.b1(C(obj, s6.d(obj)));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        return new f();
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.r0
    @u1.a
    public V put(K k7, V v7) {
        return y(k7, v7, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @u1.a
    public V remove(Object obj) {
        b<K, V> bVarC = C(obj, s6.d(obj));
        if (bVarC == null) {
            return null;
        }
        t(bVarC);
        bVarC.f20729i = null;
        bVarC.f20728h = null;
        return bVarC.f21446b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
        com.google.common.base.e0.E(biFunction);
        clear();
        for (b<K, V> bVar = this.f20715c; bVar != null; bVar = bVar.f20728h) {
            K k7 = bVar.f21445a;
            put(k7, biFunction.apply(k7, bVar.f21446b));
        }
    }

    @Override // com.google.common.collect.wb.b0, java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f20717e;
    }

    @Override // com.google.common.collect.r0
    @u1.a
    public V x(K k7, V v7) {
        return y(k7, v7, true);
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.r0
    public Set<V> values() {
        return T().keySet();
    }
}
