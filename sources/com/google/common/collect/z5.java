package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import java.util.function.BiFunction;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
public abstract class z5<K, V> extends f6<K, V> implements NavigableMap<K, V> {

    @s1.a
    protected class a extends wb.r<K, V> {

        /* JADX INFO: renamed from: com.google.common.collect.z5$a$a, reason: collision with other inner class name */
        class C0261a implements Iterator<Map.Entry<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private Map.Entry<K, V> f21479a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private Map.Entry<K, V> f21480b;

            C0261a() {
                this.f21480b = a.this.w0().lastEntry();
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                try {
                    return this.f21480b;
                } finally {
                    this.f21479a = this.f21480b;
                    this.f21480b = a.this.w0().lowerEntry(this.f21480b.getKey());
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f21480b != null;
            }

            @Override // java.util.Iterator
            public void remove() {
                f2.e(this.f21479a != null);
                a.this.w0().remove(this.f21479a.getKey());
                this.f21479a = null;
            }
        }

        public a() {
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
            w0().replaceAll(biFunction);
        }

        @Override // com.google.common.collect.wb.r
        protected Iterator<Map.Entry<K, V>> u0() {
            return new C0261a();
        }

        @Override // com.google.common.collect.wb.r
        NavigableMap<K, V> w0() {
            return z5.this;
        }
    }

    @s1.a
    protected class b extends wb.f0<K, V> {
        public b() {
            super(z5.this);
        }
    }

    protected z5() {
    }

    @s1.a
    protected NavigableSet<K> A0() {
        return descendingMap().navigableKeySet();
    }

    protected Map.Entry<K, V> B0() {
        return (Map.Entry) ma.v(entrySet(), null);
    }

    protected K C0() {
        Map.Entry<K, V> entryFirstEntry = firstEntry();
        if (entryFirstEntry != null) {
            return entryFirstEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    protected Map.Entry<K, V> D0(K k7) {
        return headMap(k7, true).lastEntry();
    }

    protected K E0(K k7) {
        return (K) wb.Y(floorEntry(k7));
    }

    protected SortedMap<K, V> F0(K k7) {
        return headMap(k7, false);
    }

    protected Map.Entry<K, V> G0(K k7) {
        return tailMap(k7, false).firstEntry();
    }

    protected K H0(K k7) {
        return (K) wb.Y(higherEntry(k7));
    }

    protected Map.Entry<K, V> I0() {
        return (Map.Entry) ma.v(descendingMap().entrySet(), null);
    }

    protected K J0() {
        Map.Entry<K, V> entryLastEntry = lastEntry();
        if (entryLastEntry != null) {
            return entryLastEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    protected Map.Entry<K, V> K0(K k7) {
        return headMap(k7, false).lastEntry();
    }

    protected K L0(K k7) {
        return (K) wb.Y(lowerEntry(k7));
    }

    protected Map.Entry<K, V> M0() {
        return (Map.Entry) ua.U(entrySet().iterator());
    }

    protected Map.Entry<K, V> N0() {
        return (Map.Entry) ua.U(descendingMap().entrySet().iterator());
    }

    protected SortedMap<K, V> O0(K k7) {
        return tailMap(k7, true);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K k7) {
        return c0().ceilingEntry(k7);
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K k7) {
        return c0().ceilingKey(k7);
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        return c0().descendingKeySet();
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> descendingMap() {
        return c0().descendingMap();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        return c0().firstEntry();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K k7) {
        return c0().floorEntry(k7);
    }

    @Override // java.util.NavigableMap
    public K floorKey(K k7) {
        return c0().floorKey(k7);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> headMap(K k7, boolean z7) {
        return c0().headMap(k7, z7);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K k7) {
        return c0().higherEntry(k7);
    }

    @Override // java.util.NavigableMap
    public K higherKey(K k7) {
        return c0().higherKey(k7);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        return c0().lastEntry();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K k7) {
        return c0().lowerEntry(k7);
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K k7) {
        return c0().lowerKey(k7);
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> navigableKeySet() {
        return c0().navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollFirstEntry() {
        return c0().pollFirstEntry();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollLastEntry() {
        return c0().pollLastEntry();
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> subMap(K k7, boolean z7, K k8, boolean z8) {
        return c0().subMap(k7, z7, k8, z8);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> tailMap(K k7, boolean z7) {
        return c0().tailMap(k7, z7);
    }

    @Override // com.google.common.collect.f6
    protected SortedMap<K, V> u0(K k7, K k8) {
        return subMap(k7, true, k8, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.f6
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public abstract NavigableMap<K, V> c0();

    protected Map.Entry<K, V> y0(K k7) {
        return tailMap(k7, true).firstEntry();
    }

    protected K z0(K k7) {
        return (K) wb.Y(ceilingEntry(k7));
    }
}
