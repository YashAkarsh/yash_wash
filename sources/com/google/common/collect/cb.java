package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true, serializable = true)
public final class cb<K, V> extends db<K, V> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f20025l = 16;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f20026m = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @s1.d
    static final double f20027n = 1.0d;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @s1.c
    private static final long f20028o = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @s1.d
    transient int f20029j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private transient b<K, V> f20030k;

    class a implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        b<K, V> f20031a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        b<K, V> f20032b;

        a() {
            this.f20031a = cb.this.f20030k.f20039i;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            b<K, V> bVar = this.f20031a;
            this.f20032b = bVar;
            this.f20031a = bVar.f20039i;
            return bVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f20031a != cb.this.f20030k;
        }

        @Override // java.util.Iterator
        public void remove() {
            f2.e(this.f20032b != null);
            cb.this.remove(this.f20032b.getKey(), this.f20032b.getValue());
            this.f20032b = null;
        }
    }

    @s1.d
    static final class b<K, V> extends y6<K, V> implements d<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f20034d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        b<K, V> f20035e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        d<K, V> f20036f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        d<K, V> f20037g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        b<K, V> f20038h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        b<K, V> f20039i;

        b(K k7, V v7, int i7, b<K, V> bVar) {
            super(k7, v7);
            this.f20034d = i7;
            this.f20035e = bVar;
        }

        @Override // com.google.common.collect.cb.d
        public void a(d<K, V> dVar) {
            this.f20037g = dVar;
        }

        @Override // com.google.common.collect.cb.d
        public d<K, V> b() {
            return this.f20036f;
        }

        public b<K, V> c() {
            return this.f20038h;
        }

        @Override // com.google.common.collect.cb.d
        public d<K, V> d() {
            return this.f20037g;
        }

        public b<K, V> e() {
            return this.f20039i;
        }

        @Override // com.google.common.collect.cb.d
        public void f(d<K, V> dVar) {
            this.f20036f = dVar;
        }

        boolean g(Object obj, int i7) {
            return this.f20034d == i7 && com.google.common.base.y.a(getValue(), obj);
        }

        public void h(b<K, V> bVar) {
            this.f20038h = bVar;
        }

        public void i(b<K, V> bVar) {
            this.f20039i = bVar;
        }
    }

    @s1.d
    final class c extends af.l<V> implements d<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final K f20040a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @s1.d
        b<K, V>[] f20041b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f20042c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f20043d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private d<K, V> f20044e = this;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private d<K, V> f20045f = this;

        class a implements Iterator<V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            d<K, V> f20047a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            b<K, V> f20048b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f20049c;

            a() {
                this.f20047a = c.this.f20044e;
                this.f20049c = c.this.f20043d;
            }

            private void a() {
                if (c.this.f20043d != this.f20049c) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                a();
                return this.f20047a != c.this;
            }

            @Override // java.util.Iterator
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                b<K, V> bVar = (b) this.f20047a;
                V value = bVar.getValue();
                this.f20048b = bVar;
                this.f20047a = bVar.d();
                return value;
            }

            @Override // java.util.Iterator
            public void remove() {
                a();
                f2.e(this.f20048b != null);
                c.this.remove(this.f20048b.getValue());
                this.f20049c = c.this.f20043d;
                this.f20048b = null;
            }
        }

        c(K k7, int i7) {
            this.f20040a = k7;
            this.f20041b = new b[s6.a(i7, 1.0d)];
        }

        private int j() {
            return this.f20041b.length - 1;
        }

        private void k() {
            if (s6.b(this.f20042c, this.f20041b.length, 1.0d)) {
                int length = this.f20041b.length * 2;
                b<K, V>[] bVarArr = new b[length];
                this.f20041b = bVarArr;
                int i7 = length - 1;
                for (d<K, V> dVarD = this.f20044e; dVarD != this; dVarD = dVarD.d()) {
                    b<K, V> bVar = (b) dVarD;
                    int i8 = bVar.f20034d & i7;
                    bVar.f20035e = bVarArr[i8];
                    bVarArr[i8] = bVar;
                }
            }
        }

        @Override // com.google.common.collect.cb.d
        public void a(d<K, V> dVar) {
            this.f20044e = dVar;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(V v7) {
            int iD = s6.d(v7);
            int iJ = j() & iD;
            b<K, V> bVar = this.f20041b[iJ];
            for (b<K, V> bVar2 = bVar; bVar2 != null; bVar2 = bVar2.f20035e) {
                if (bVar2.g(v7, iD)) {
                    return false;
                }
            }
            b<K, V> bVar3 = new b<>(this.f20040a, v7, iD, bVar);
            cb.h0(this.f20045f, bVar3);
            cb.h0(bVar3, this);
            cb.g0(cb.this.f20030k.c(), bVar3);
            cb.g0(bVar3, cb.this.f20030k);
            this.f20041b[iJ] = bVar3;
            this.f20042c++;
            this.f20043d++;
            k();
            return true;
        }

        @Override // com.google.common.collect.cb.d
        public d<K, V> b() {
            return this.f20045f;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Arrays.fill(this.f20041b, (Object) null);
            this.f20042c = 0;
            for (d<K, V> dVarD = this.f20044e; dVarD != this; dVarD = dVarD.d()) {
                cb.e0((b) dVarD);
            }
            cb.h0(this, this);
            this.f20043d++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            int iD = s6.d(obj);
            for (b<K, V> bVar = this.f20041b[j() & iD]; bVar != null; bVar = bVar.f20035e) {
                if (bVar.g(obj, iD)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.collect.cb.d
        public d<K, V> d() {
            return this.f20044e;
        }

        @Override // com.google.common.collect.cb.d
        public void f(d<K, V> dVar) {
            this.f20045f = dVar;
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super V> consumer) {
            com.google.common.base.e0.E(consumer);
            for (d<K, V> dVarD = this.f20044e; dVarD != this; dVarD = dVarD.d()) {
                consumer.accept(((b) dVarD).getValue());
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @u1.a
        public boolean remove(Object obj) {
            int iD = s6.d(obj);
            int iJ = j() & iD;
            b<K, V> bVar = null;
            for (b<K, V> bVar2 = this.f20041b[iJ]; bVar2 != null; bVar2 = bVar2.f20035e) {
                if (bVar2.g(obj, iD)) {
                    if (bVar == null) {
                        this.f20041b[iJ] = bVar2.f20035e;
                    } else {
                        bVar.f20035e = bVar2.f20035e;
                    }
                    cb.f0(bVar2);
                    cb.e0(bVar2);
                    this.f20042c--;
                    this.f20043d++;
                    return true;
                }
                bVar = bVar2;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f20042c;
        }
    }

    private interface d<K, V> {
        void a(d<K, V> dVar);

        d<K, V> b();

        d<K, V> d();

        void f(d<K, V> dVar);
    }

    private cb(int i7, int i8) {
        super(vd.e(i7));
        this.f20029j = 2;
        f2.b(i8, "expectedValuesPerKey");
        this.f20029j = i8;
        b<K, V> bVar = new b<>(null, null, 0, null);
        this.f20030k = bVar;
        g0(bVar, bVar);
    }

    public static <K, V> cb<K, V> b0() {
        return new cb<>(16, 2);
    }

    public static <K, V> cb<K, V> c0(int i7, int i8) {
        return new cb<>(wb.t(i7), wb.t(i8));
    }

    public static <K, V> cb<K, V> d0(tc<? extends K, ? extends V> tcVar) {
        cb<K, V> cbVarC0 = c0(tcVar.keySet().size(), 2);
        cbVarC0.H(tcVar);
        return cbVarC0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void e0(b<K, V> bVar) {
        g0(bVar.c(), bVar.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void f0(d<K, V> dVar) {
        h0(dVar.b(), dVar.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void g0(b<K, V> bVar, b<K, V> bVar2) {
        bVar.i(bVar2);
        bVar2.h(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void h0(d<K, V> dVar, d<K, V> dVar2) {
        dVar.a(dVar2);
        dVar2.f(dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @s1.c
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        b<K, V> bVar = new b<>(null, null, 0, null);
        this.f20030k = bVar;
        g0(bVar, bVar);
        this.f20029j = 2;
        int i7 = objectInputStream.readInt();
        Map mapE = vd.e(12);
        for (int i8 = 0; i8 < i7; i8++) {
            Object object = objectInputStream.readObject();
            mapE.put(object, A(object));
        }
        int i9 = objectInputStream.readInt();
        for (int i10 = 0; i10 < i9; i10++) {
            ((Collection) mapE.get(objectInputStream.readObject())).add(objectInputStream.readObject());
        }
        O(mapE);
    }

    @s1.c
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(keySet().size());
        Iterator<K> it = keySet().iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
        objectOutputStream.writeInt(size());
        for (Map.Entry<K, V> entry : y()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @Override // com.google.common.collect.q
    Collection<V> A(K k7) {
        return new c(k7, this.f20029j);
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    @u1.a
    public /* bridge */ /* synthetic */ boolean H(tc tcVar) {
        return super.H(tcVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.c0, com.google.common.collect.q
    /* JADX INFO: renamed from: T */
    public Set<V> z() {
        return vd.f(this.f20029j);
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ boolean W(Object obj, Object obj2) {
        return super.W(obj, obj2);
    }

    @Override // com.google.common.collect.c0, com.google.common.collect.q, com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    public /* bridge */ /* synthetic */ Set a(Object obj) {
        return super.a(obj);
    }

    @Override // com.google.common.collect.c0, com.google.common.collect.x, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.q, com.google.common.collect.tc
    public void clear() {
        super.clear();
        b<K, V> bVar = this.f20030k;
        g0(bVar, bVar);
    }

    @Override // com.google.common.collect.q, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.c0, com.google.common.collect.x, com.google.common.collect.tc, com.google.common.collect.ue
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.q, com.google.common.collect.x, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ void forEach(BiConsumer biConsumer) {
        super.forEach(biConsumer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.c0, com.google.common.collect.q, com.google.common.collect.tc, com.google.common.collect.hb
    public /* bridge */ /* synthetic */ Set get(Object obj) {
        return super.get(obj);
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.q, com.google.common.collect.x
    Iterator<Map.Entry<K, V>> i() {
        return new a();
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.q, com.google.common.collect.x
    Spliterator<Map.Entry<K, V>> j() {
        return Spliterators.spliterator(y(), 17);
    }

    @Override // com.google.common.collect.q, com.google.common.collect.x
    Iterator<V> k() {
        return wb.a1(i());
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    public Set<K> keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ hd keys() {
        return super.keys();
    }

    @Override // com.google.common.collect.q, com.google.common.collect.x
    Spliterator<V> l() {
        return q2.e(j(), new a8());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.c0, com.google.common.collect.q, com.google.common.collect.x, com.google.common.collect.tc
    @u1.a
    public /* bridge */ /* synthetic */ boolean put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.x, com.google.common.collect.tc
    @u1.a
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    @u1.a
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.q, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.x
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.q, com.google.common.collect.x, com.google.common.collect.tc
    public Collection<V> values() {
        return super.values();
    }

    @Override // com.google.common.collect.c0, com.google.common.collect.q, com.google.common.collect.x, com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    public Set<V> b(K k7, Iterable<? extends V> iterable) {
        return super.b((Object) k7, (Iterable) iterable);
    }

    @Override // com.google.common.collect.c0, com.google.common.collect.q, com.google.common.collect.x, com.google.common.collect.tc, com.google.common.collect.ue
    /* JADX INFO: renamed from: entries */
    public Set<Map.Entry<K, V>> y() {
        return super.y();
    }
}
