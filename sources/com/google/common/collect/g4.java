package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
public final class g4<E> extends y<E> implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f20277d = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final transient ConcurrentMap<E, AtomicInteger> f20278c;

    class a extends d6<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Set f20279a;

        a(Set set) {
            this.f20279a = set;
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return obj != null && h3.j(this.f20279a, obj);
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return j0(collection);
        }

        @Override // com.google.common.collect.j5, java.util.Collection
        public boolean remove(Object obj) {
            return obj != null && h3.k(this.f20279a, obj);
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return n0(collection);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.d6, com.google.common.collect.j5
        /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
        public Set<E> c0() {
            return this.f20279a;
        }
    }

    class b extends com.google.common.collect.e<hd.a<E>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Iterator<Map.Entry<E, AtomicInteger>> f20281c;

        b() {
            this.f20281c = g4.this.f20278c.entrySet().iterator();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.e
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public hd.a<E> a() {
            while (this.f20281c.hasNext()) {
                Map.Entry<E, AtomicInteger> next = this.f20281c.next();
                int i7 = next.getValue().get();
                if (i7 != 0) {
                    return md.m(next.getKey(), i7);
                }
            }
            return b();
        }
    }

    class c extends q5<hd.a<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private hd.a<E> f20283a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Iterator f20284b;

        c(Iterator it) {
            this.f20284b = it;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.q5, com.google.common.collect.b6
        /* JADX INFO: renamed from: d0 */
        public Iterator<hd.a<E>> c0() {
            return this.f20284b;
        }

        @Override // com.google.common.collect.q5, java.util.Iterator
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public hd.a<E> next() {
            hd.a<E> aVar = (hd.a) super.next();
            this.f20283a = aVar;
            return aVar;
        }

        @Override // com.google.common.collect.q5, java.util.Iterator
        public void remove() {
            f2.e(this.f20283a != null);
            g4.this.setCount(this.f20283a.getElement(), 0);
            this.f20283a = null;
        }
    }

    private class d extends y<E>.b {
        private d() {
            super();
        }

        private List<hd.a<E>> j() {
            ArrayList arrayListV = ib.v(size());
            ua.a(arrayListV, iterator());
            return arrayListV;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.y.b, com.google.common.collect.md.i
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public g4<E> g() {
            return g4.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return j().toArray();
        }

        /* synthetic */ d(g4 g4Var, a aVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) j().toArray(tArr);
        }
    }

    private static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final se.b<g4> f20287a = se.a(g4.class, "countMap");

        private e() {
        }
    }

    @s1.d
    g4(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        com.google.common.base.e0.u(concurrentMap.isEmpty(), "the backing map (%s) must be empty", concurrentMap);
        this.f20278c = concurrentMap;
    }

    public static <E> g4<E> j() {
        return new g4<>(new ConcurrentHashMap());
    }

    public static <E> g4<E> k(Iterable<? extends E> iterable) {
        g4<E> g4VarJ = j();
        ma.a(g4VarJ, iterable);
        return g4VarJ;
    }

    @s1.a
    public static <E> g4<E> l(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        return new g4<>(concurrentMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private List<E> n() {
        ArrayList arrayListV = ib.v(size());
        for (hd.a aVar : entrySet()) {
            Object element = aVar.getElement();
            for (int count = aVar.getCount(); count > 0; count--) {
                arrayListV.add(element);
            }
        }
        return arrayListV;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        e.f20287a.b(this, (ConcurrentMap) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f20278c);
    }

    @Override // com.google.common.collect.y, com.google.common.collect.hd
    @u1.a
    public boolean E(E e8, int i7, int i8) {
        com.google.common.base.e0.E(e8);
        f2.b(i7, "oldCount");
        f2.b(i8, "newCount");
        AtomicInteger atomicInteger = (AtomicInteger) wb.z0(this.f20278c, e8);
        if (atomicInteger == null) {
            if (i7 != 0) {
                return false;
            }
            return i8 == 0 || this.f20278c.putIfAbsent(e8, new AtomicInteger(i8)) == null;
        }
        int i9 = atomicInteger.get();
        if (i9 == i7) {
            if (i9 == 0) {
                if (i8 == 0) {
                    this.f20278c.remove(e8, atomicInteger);
                    return true;
                }
                AtomicInteger atomicInteger2 = new AtomicInteger(i8);
                return this.f20278c.putIfAbsent(e8, atomicInteger2) == null || this.f20278c.replace(e8, atomicInteger, atomicInteger2);
            }
            if (atomicInteger.compareAndSet(i9, i8)) {
                if (i8 == 0) {
                    this.f20278c.remove(e8, atomicInteger);
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.y
    Set<E> a() {
        return new a(this.f20278c.keySet());
    }

    @Override // com.google.common.collect.y, com.google.common.collect.hd
    @u1.a
    public int add(E e8, int i7) {
        AtomicInteger atomicIntegerPutIfAbsent;
        int i8;
        AtomicInteger atomicInteger;
        com.google.common.base.e0.E(e8);
        if (i7 == 0) {
            return l0(e8);
        }
        f2.d(i7, "occurences");
        do {
            atomicIntegerPutIfAbsent = (AtomicInteger) wb.z0(this.f20278c, e8);
            if (atomicIntegerPutIfAbsent == null && (atomicIntegerPutIfAbsent = this.f20278c.putIfAbsent(e8, new AtomicInteger(i7))) == null) {
                return 0;
            }
            do {
                i8 = atomicIntegerPutIfAbsent.get();
                if (i8 == 0) {
                    atomicInteger = new AtomicInteger(i7);
                    if (this.f20278c.putIfAbsent(e8, atomicInteger) == null) {
                        break;
                    }
                } else {
                    try {
                    } catch (ArithmeticException unused) {
                        throw new IllegalArgumentException("Overflow adding " + i7 + " occurrences to a count of " + i8);
                    }
                }
            } while (!atomicIntegerPutIfAbsent.compareAndSet(i8, com.google.common.math.d.c(i8, i7)));
            return i8;
        } while (!this.f20278c.replace(e8, atomicIntegerPutIfAbsent, atomicInteger));
        return 0;
    }

    @Override // com.google.common.collect.y
    @Deprecated
    public Set<hd.a<E>> b() {
        return new d(this, null);
    }

    @Override // com.google.common.collect.y, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f20278c.clear();
    }

    @Override // com.google.common.collect.y, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.hd
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.y
    int d() {
        return this.f20278c.size();
    }

    @Override // com.google.common.collect.y, com.google.common.collect.hd
    public /* bridge */ /* synthetic */ Set e() {
        return super.e();
    }

    @Override // com.google.common.collect.y, com.google.common.collect.hd
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.y
    Iterator<E> f() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.y
    Iterator<hd.a<E>> g() {
        return new c(new b());
    }

    @Override // com.google.common.collect.y, java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.f20278c.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.hd
    public Iterator<E> iterator() {
        return md.p(this);
    }

    @Override // com.google.common.collect.hd
    public int l0(Object obj) {
        AtomicInteger atomicInteger = (AtomicInteger) wb.z0(this.f20278c, obj);
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    @u1.a
    public boolean m(Object obj, int i7) {
        int i8;
        int i9;
        if (i7 == 0) {
            return true;
        }
        f2.d(i7, "occurences");
        AtomicInteger atomicInteger = (AtomicInteger) wb.z0(this.f20278c, obj);
        if (atomicInteger == null) {
            return false;
        }
        do {
            i8 = atomicInteger.get();
            if (i8 < i7) {
                return false;
            }
            i9 = i8 - i7;
        } while (!atomicInteger.compareAndSet(i8, i9));
        if (i9 == 0) {
            this.f20278c.remove(obj, atomicInteger);
        }
        return true;
    }

    @Override // com.google.common.collect.y, com.google.common.collect.hd
    @u1.a
    public int remove(Object obj, int i7) {
        int i8;
        int iMax;
        if (i7 == 0) {
            return l0(obj);
        }
        f2.d(i7, "occurences");
        AtomicInteger atomicInteger = (AtomicInteger) wb.z0(this.f20278c, obj);
        if (atomicInteger == null) {
            return 0;
        }
        do {
            i8 = atomicInteger.get();
            if (i8 == 0) {
                return 0;
            }
            iMax = Math.max(0, i8 - i7);
        } while (!atomicInteger.compareAndSet(i8, iMax));
        if (iMax == 0) {
            this.f20278c.remove(obj, atomicInteger);
        }
        return i8;
    }

    @Override // com.google.common.collect.y, com.google.common.collect.hd
    @u1.a
    public int setCount(E e8, int i7) {
        AtomicInteger atomicIntegerPutIfAbsent;
        AtomicInteger atomicInteger;
        com.google.common.base.e0.E(e8);
        f2.b(i7, "count");
        do {
            atomicIntegerPutIfAbsent = (AtomicInteger) wb.z0(this.f20278c, e8);
            if (atomicIntegerPutIfAbsent != null || (i7 != 0 && (atomicIntegerPutIfAbsent = this.f20278c.putIfAbsent(e8, new AtomicInteger(i7))) != null)) {
                while (true) {
                    int i8 = atomicIntegerPutIfAbsent.get();
                    if (i8 == 0) {
                        break;
                    }
                    if (atomicIntegerPutIfAbsent.compareAndSet(i8, i7)) {
                        if (i7 == 0) {
                            this.f20278c.remove(e8, atomicIntegerPutIfAbsent);
                        }
                        return i8;
                    }
                }
                if (i7 != 0) {
                    atomicInteger = new AtomicInteger(i7);
                    if (this.f20278c.putIfAbsent(e8, atomicInteger) == null) {
                        break;
                    }
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } while (!this.f20278c.replace(e8, atomicIntegerPutIfAbsent, atomicInteger));
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.hd
    public int size() {
        Iterator<AtomicInteger> it = this.f20278c.values().iterator();
        long j7 = 0;
        while (it.hasNext()) {
            j7 += (long) it.next().get();
        }
        return com.google.common.primitives.c0.x(j7);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return n().toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) n().toArray(tArr);
    }
}
