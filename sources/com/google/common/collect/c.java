package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
abstract class c<K, V> extends u5<K, V> implements r0<K, V>, Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @s1.c
    private static final long f19984f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient Map<K, V> f19985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @y1.h
    transient c<V, K> f19986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient Set<K> f19987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private transient Set<V> f19988d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private transient Set<Map.Entry<K, V>> f19989e;

    class a implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Map.Entry<K, V> f19990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Iterator f19991b;

        a(Iterator it) {
            this.f19991b = it;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            Map.Entry<K, V> entry = (Map.Entry) this.f19991b.next();
            this.f19990a = entry;
            return new b(entry);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f19991b.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            f2.e(this.f19990a != null);
            V value = this.f19990a.getValue();
            this.f19991b.remove();
            c.this.E0(value);
            this.f19990a = null;
        }
    }

    class b extends v5<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map.Entry<K, V> f19993a;

        b(Map.Entry<K, V> entry) {
            this.f19993a = entry;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.v5, com.google.common.collect.b6
        /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> c0() {
            return this.f19993a;
        }

        @Override // com.google.common.collect.v5, java.util.Map.Entry
        public V setValue(V v7) {
            c.this.z0(v7);
            com.google.common.base.e0.h0(c.this.entrySet().contains(this), "entry no longer in map");
            if (com.google.common.base.y.a(v7, getValue())) {
                return v7;
            }
            com.google.common.base.e0.u(!c.this.containsValue(v7), "value already present: %s", v7);
            V value = this.f19993a.setValue(v7);
            com.google.common.base.e0.h0(com.google.common.base.y.a(v7, c.this.get(getKey())), "entry no longer in map");
            c.this.H0(getKey(), true, value, v7);
            return value;
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.c$c, reason: collision with other inner class name */
    private class C0237c extends d6<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Set<Map.Entry<K, V>> f19995a;

        private C0237c() {
            this.f19995a = c.this.f19985a.entrySet();
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.Set
        public void clear() {
            c.this.clear();
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return wb.u(c0(), obj);
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return j0(collection);
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public Iterator<Map.Entry<K, V>> iterator() {
            return c.this.A0();
        }

        @Override // com.google.common.collect.j5, java.util.Collection
        public boolean remove(Object obj) {
            if (!this.f19995a.contains(obj)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            ((c) c.this.f19986b).f19985a.remove(entry.getValue());
            this.f19995a.remove(entry);
            return true;
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return n0(collection);
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return p0(collection);
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return q0();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.d6, com.google.common.collect.j5
        /* JADX INFO: renamed from: w0 */
        public Set<Map.Entry<K, V>> c0() {
            return this.f19995a;
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) t0(tArr);
        }

        /* synthetic */ C0237c(c cVar, a aVar) {
            this();
        }
    }

    static class d<K, V> extends c<K, V> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @s1.c
        private static final long f19997g = 0;

        d(Map<K, V> map, c<V, K> cVar) {
            super(map, cVar, null);
        }

        @s1.c
        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            G0((c) objectInputStream.readObject());
        }

        @s1.c
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(T());
        }

        @Override // com.google.common.collect.c, com.google.common.collect.u5, com.google.common.collect.b6
        protected /* bridge */ /* synthetic */ Object c0() {
            return super.c0();
        }

        @s1.c
        Object readResolve() {
            return T().T();
        }

        @Override // com.google.common.collect.c, com.google.common.collect.u5, java.util.Map, com.google.common.collect.r0
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }

        @Override // com.google.common.collect.c
        K y0(K k7) {
            return this.f19986b.z0(k7);
        }

        @Override // com.google.common.collect.c
        V z0(V v7) {
            return this.f19986b.y0(v7);
        }
    }

    private class e extends d6<K> {
        private e() {
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.Set
        public void clear() {
            c.this.clear();
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public Iterator<K> iterator() {
            return wb.X(c.this.entrySet().iterator());
        }

        @Override // com.google.common.collect.j5, java.util.Collection
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            c.this.D0(obj);
            return true;
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return n0(collection);
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return p0(collection);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.d6, com.google.common.collect.j5
        /* JADX INFO: renamed from: w0 */
        public Set<K> c0() {
            return c.this.f19985a.keySet();
        }

        /* synthetic */ e(c cVar, a aVar) {
            this();
        }
    }

    private class f extends d6<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Set<V> f19999a;

        private f() {
            this.f19999a = c.this.f19986b.keySet();
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public Iterator<V> iterator() {
            return wb.a1(c.this.entrySet().iterator());
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return q0();
        }

        @Override // com.google.common.collect.b6
        public String toString() {
            return u0();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.d6, com.google.common.collect.j5
        /* JADX INFO: renamed from: w0 */
        public Set<V> c0() {
            return this.f19999a;
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) t0(tArr);
        }

        /* synthetic */ f(c cVar, a aVar) {
            this();
        }
    }

    /* synthetic */ c(Map map, c cVar, a aVar) {
        this(map, cVar);
    }

    private V C0(K k7, V v7, boolean z7) {
        y0(k7);
        z0(v7);
        boolean zContainsKey = containsKey(k7);
        if (zContainsKey && com.google.common.base.y.a(v7, get(k7))) {
            return v7;
        }
        if (z7) {
            T().remove(v7);
        } else {
            com.google.common.base.e0.u(!containsValue(v7), "value already present: %s", v7);
        }
        V vPut = this.f19985a.put(k7, v7);
        H0(k7, zContainsKey, vPut, v7);
        return vPut;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @u1.a
    public V D0(Object obj) {
        V vRemove = this.f19985a.remove(obj);
        E0(vRemove);
        return vRemove;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(V v7) {
        this.f19986b.f19985a.remove(v7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(K k7, boolean z7, V v7, V v8) {
        if (z7) {
            E0(v7);
        }
        this.f19986b.f19985a.put(v8, k7);
    }

    Iterator<Map.Entry<K, V>> A0() {
        return new a(this.f19985a.entrySet().iterator());
    }

    c<V, K> B0(Map<V, K> map) {
        return new d(map, this);
    }

    void F0(Map<K, V> map, Map<V, K> map2) {
        com.google.common.base.e0.g0(this.f19985a == null);
        com.google.common.base.e0.g0(this.f19986b == null);
        com.google.common.base.e0.d(map.isEmpty());
        com.google.common.base.e0.d(map2.isEmpty());
        com.google.common.base.e0.d(map != map2);
        this.f19985a = map;
        this.f19986b = B0(map2);
    }

    void G0(c<V, K> cVar) {
        this.f19986b = cVar;
    }

    @Override // com.google.common.collect.r0
    public r0<V, K> T() {
        return this.f19986b;
    }

    @Override // com.google.common.collect.u5, java.util.Map
    public void clear() {
        this.f19985a.clear();
        this.f19986b.f19985a.clear();
    }

    @Override // com.google.common.collect.u5, java.util.Map
    public boolean containsValue(Object obj) {
        return this.f19986b.containsKey(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.u5, com.google.common.collect.b6
    /* JADX INFO: renamed from: d0 */
    public Map<K, V> c0() {
        return this.f19985a;
    }

    @Override // com.google.common.collect.u5, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f19989e;
        if (set != null) {
            return set;
        }
        C0237c c0237c = new C0237c(this, null);
        this.f19989e = c0237c;
        return c0237c;
    }

    @Override // com.google.common.collect.u5, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.f19987c;
        if (set != null) {
            return set;
        }
        e eVar = new e(this, null);
        this.f19987c = eVar;
        return eVar;
    }

    @Override // com.google.common.collect.u5, java.util.Map, com.google.common.collect.r0
    @u1.a
    public V put(K k7, V v7) {
        return C0(k7, v7, false);
    }

    @Override // com.google.common.collect.u5, java.util.Map, com.google.common.collect.r0
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.common.collect.u5, java.util.Map
    @u1.a
    public V remove(Object obj) {
        if (containsKey(obj)) {
            return D0(obj);
        }
        return null;
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
        this.f19985a.replaceAll(biFunction);
        this.f19986b.f19985a.clear();
        Iterator<Map.Entry<K, V>> it = this.f19985a.entrySet().iterator();
        Map.Entry<K, V> entry = null;
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (this.f19986b.f19985a.putIfAbsent(next.getValue(), next.getKey()) != null) {
                it.remove();
                entry = next;
            }
        }
        if (entry == null) {
            return;
        }
        throw new IllegalArgumentException("value already present: " + entry.getValue());
    }

    @Override // com.google.common.collect.r0
    @u1.a
    public V x(K k7, V v7) {
        return C0(k7, v7, true);
    }

    @u1.a
    K y0(K k7) {
        return k7;
    }

    @u1.a
    V z0(V v7) {
        return v7;
    }

    c(Map<K, V> map, Map<V, K> map2) {
        F0(map, map2);
    }

    @Override // com.google.common.collect.u5, java.util.Map, com.google.common.collect.r0
    public Set<V> values() {
        Set<V> set = this.f19988d;
        if (set != null) {
            return set;
        }
        f fVar = new f(this, null);
        this.f19988d = fVar;
        return fVar;
    }

    private c(Map<K, V> map, c<V, K> cVar) {
        this.f19985a = map;
        this.f19986b = cVar;
    }
}
