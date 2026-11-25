package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class i<K, V> extends AbstractMap<K, V> implements Serializable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Comparator<Comparable> f23207h = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final /* synthetic */ boolean f23208i = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Comparator<? super K> f23209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    e<K, V> f23210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f23211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f23212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final e<K, V> f23213e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private i<K, V>.b f23214f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private i<K, V>.c f23215g;

    class a implements Comparator<Comparable> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    class b extends AbstractSet<Map.Entry<K, V>> {

        class a extends i<K, V>.d<Map.Entry<K, V>> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            i.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && i.this.c((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e<K, V> eVarC;
            if (!(obj instanceof Map.Entry) || (eVarC = i.this.c((Map.Entry) obj)) == null) {
                return false;
            }
            i.this.f(eVarC, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return i.this.f23211c;
        }
    }

    final class c extends AbstractSet<K> {

        class a extends i<K, V>.d<K> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().f23229f;
            }
        }

        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            i.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return i.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return i.this.g(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return i.this.f23211c;
        }
    }

    private abstract class d<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        e<K, V> f23220a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        e<K, V> f23221b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f23222c;

        d() {
            this.f23220a = i.this.f23213e.f23227d;
            this.f23222c = i.this.f23212d;
        }

        final e<K, V> a() {
            e<K, V> eVar = this.f23220a;
            i iVar = i.this;
            if (eVar == iVar.f23213e) {
                throw new NoSuchElementException();
            }
            if (iVar.f23212d != this.f23222c) {
                throw new ConcurrentModificationException();
            }
            this.f23220a = eVar.f23227d;
            this.f23221b = eVar;
            return eVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f23220a != i.this.f23213e;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.f23221b;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            i.this.f(eVar, true);
            this.f23221b = null;
            this.f23222c = i.this.f23212d;
        }
    }

    public i() {
        this(f23207h);
    }

    private boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void e(e<K, V> eVar, boolean z7) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.f23225b;
            e<K, V> eVar3 = eVar.f23226c;
            int i7 = eVar2 != null ? eVar2.f23231h : 0;
            int i8 = eVar3 != null ? eVar3.f23231h : 0;
            int i9 = i7 - i8;
            if (i9 == -2) {
                e<K, V> eVar4 = eVar3.f23225b;
                e<K, V> eVar5 = eVar3.f23226c;
                int i10 = (eVar4 != null ? eVar4.f23231h : 0) - (eVar5 != null ? eVar5.f23231h : 0);
                if (i10 == -1 || (i10 == 0 && !z7)) {
                    k(eVar);
                } else {
                    l(eVar3);
                    k(eVar);
                }
                if (z7) {
                    return;
                }
            } else if (i9 == 2) {
                e<K, V> eVar6 = eVar2.f23225b;
                e<K, V> eVar7 = eVar2.f23226c;
                int i11 = (eVar6 != null ? eVar6.f23231h : 0) - (eVar7 != null ? eVar7.f23231h : 0);
                if (i11 == 1 || (i11 == 0 && !z7)) {
                    l(eVar);
                } else {
                    k(eVar2);
                    l(eVar);
                }
                if (z7) {
                    return;
                }
            } else if (i9 == 0) {
                eVar.f23231h = i7 + 1;
                if (z7) {
                    return;
                }
            } else {
                eVar.f23231h = Math.max(i7, i8) + 1;
                if (!z7) {
                    return;
                }
            }
            eVar = eVar.f23224a;
        }
    }

    private void i(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.f23224a;
        eVar.f23224a = null;
        if (eVar2 != null) {
            eVar2.f23224a = eVar3;
        }
        if (eVar3 == null) {
            this.f23210b = eVar2;
        } else if (eVar3.f23225b == eVar) {
            eVar3.f23225b = eVar2;
        } else {
            eVar3.f23226c = eVar2;
        }
    }

    private void k(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f23225b;
        e<K, V> eVar3 = eVar.f23226c;
        e<K, V> eVar4 = eVar3.f23225b;
        e<K, V> eVar5 = eVar3.f23226c;
        eVar.f23226c = eVar4;
        if (eVar4 != null) {
            eVar4.f23224a = eVar;
        }
        i(eVar, eVar3);
        eVar3.f23225b = eVar;
        eVar.f23224a = eVar3;
        int iMax = Math.max(eVar2 != null ? eVar2.f23231h : 0, eVar4 != null ? eVar4.f23231h : 0) + 1;
        eVar.f23231h = iMax;
        eVar3.f23231h = Math.max(iMax, eVar5 != null ? eVar5.f23231h : 0) + 1;
    }

    private void l(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f23225b;
        e<K, V> eVar3 = eVar.f23226c;
        e<K, V> eVar4 = eVar2.f23225b;
        e<K, V> eVar5 = eVar2.f23226c;
        eVar.f23225b = eVar5;
        if (eVar5 != null) {
            eVar5.f23224a = eVar;
        }
        i(eVar, eVar2);
        eVar2.f23226c = eVar;
        eVar.f23224a = eVar2;
        int iMax = Math.max(eVar3 != null ? eVar3.f23231h : 0, eVar5 != null ? eVar5.f23231h : 0) + 1;
        eVar.f23231h = iMax;
        eVar2.f23231h = Math.max(iMax, eVar4 != null ? eVar4.f23231h : 0) + 1;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    e<K, V> b(K k7, boolean z7) {
        int iCompareTo;
        e<K, V> eVar;
        Comparator<? super K> comparator = this.f23209a;
        e<K, V> eVar2 = this.f23210b;
        if (eVar2 != null) {
            Comparable comparable = comparator == f23207h ? (Comparable) k7 : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(eVar2.f23229f) : comparator.compare(k7, eVar2.f23229f);
                if (iCompareTo == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = iCompareTo < 0 ? eVar2.f23225b : eVar2.f23226c;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            iCompareTo = 0;
        }
        if (!z7) {
            return null;
        }
        e<K, V> eVar4 = this.f23213e;
        if (eVar2 != null) {
            eVar = new e<>(eVar2, k7, eVar4, eVar4.f23228e);
            if (iCompareTo < 0) {
                eVar2.f23225b = eVar;
            } else {
                eVar2.f23226c = eVar;
            }
            e(eVar2, true);
        } else {
            if (comparator == f23207h && !(k7 instanceof Comparable)) {
                throw new ClassCastException(k7.getClass().getName() + " is not Comparable");
            }
            eVar = new e<>(eVar2, k7, eVar4, eVar4.f23228e);
            this.f23210b = eVar;
        }
        this.f23211c++;
        this.f23212d++;
        return eVar;
    }

    e<K, V> c(Map.Entry<?, ?> entry) {
        e<K, V> eVarD = d(entry.getKey());
        if (eVarD != null && a(eVarD.f23230g, entry.getValue())) {
            return eVarD;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f23210b = null;
        this.f23211c = 0;
        this.f23212d++;
        e<K, V> eVar = this.f23213e;
        eVar.f23228e = eVar;
        eVar.f23227d = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return d(obj) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    e<K, V> d(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return b(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        i<K, V>.b bVar = this.f23214f;
        if (bVar != null) {
            return bVar;
        }
        i<K, V>.b bVar2 = new b();
        this.f23214f = bVar2;
        return bVar2;
    }

    void f(e<K, V> eVar, boolean z7) {
        int i7;
        if (z7) {
            e<K, V> eVar2 = eVar.f23228e;
            eVar2.f23227d = eVar.f23227d;
            eVar.f23227d.f23228e = eVar2;
        }
        e<K, V> eVar3 = eVar.f23225b;
        e<K, V> eVar4 = eVar.f23226c;
        e<K, V> eVar5 = eVar.f23224a;
        int i8 = 0;
        if (eVar3 == null || eVar4 == null) {
            if (eVar3 != null) {
                i(eVar, eVar3);
                eVar.f23225b = null;
            } else if (eVar4 != null) {
                i(eVar, eVar4);
                eVar.f23226c = null;
            } else {
                i(eVar, null);
            }
            e(eVar5, false);
            this.f23211c--;
            this.f23212d++;
            return;
        }
        e<K, V> eVarB = eVar3.f23231h > eVar4.f23231h ? eVar3.b() : eVar4.a();
        f(eVarB, false);
        e<K, V> eVar6 = eVar.f23225b;
        if (eVar6 != null) {
            i7 = eVar6.f23231h;
            eVarB.f23225b = eVar6;
            eVar6.f23224a = eVarB;
            eVar.f23225b = null;
        } else {
            i7 = 0;
        }
        e<K, V> eVar7 = eVar.f23226c;
        if (eVar7 != null) {
            i8 = eVar7.f23231h;
            eVarB.f23226c = eVar7;
            eVar7.f23224a = eVarB;
            eVar.f23226c = null;
        }
        eVarB.f23231h = Math.max(i7, i8) + 1;
        i(eVar, eVarB);
    }

    e<K, V> g(Object obj) {
        e<K, V> eVarD = d(obj);
        if (eVarD != null) {
            f(eVarD, true);
        }
        return eVarD;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        e<K, V> eVarD = d(obj);
        if (eVarD != null) {
            return eVarD.f23230g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        i<K, V>.c cVar = this.f23215g;
        if (cVar != null) {
            return cVar;
        }
        i<K, V>.c cVar2 = new c();
        this.f23215g = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k7, V v7) {
        if (k7 == null) {
            throw new NullPointerException("key == null");
        }
        e<K, V> eVarB = b(k7, true);
        V v8 = eVarB.f23230g;
        eVarB.f23230g = v7;
        return v8;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> eVarG = g(obj);
        if (eVarG != null) {
            return eVarG.f23230g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f23211c;
    }

    public i(Comparator<? super K> comparator) {
        this.f23211c = 0;
        this.f23212d = 0;
        this.f23213e = new e<>();
        this.f23209a = comparator == null ? f23207h : comparator;
    }

    static final class e<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        e<K, V> f23224a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        e<K, V> f23225b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        e<K, V> f23226c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        e<K, V> f23227d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        e<K, V> f23228e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final K f23229f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        V f23230g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f23231h;

        e() {
            this.f23229f = null;
            this.f23228e = this;
            this.f23227d = this;
        }

        public e<K, V> a() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f23225b; eVar2 != null; eVar2 = eVar2.f23225b) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e<K, V> b() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f23226c; eVar2 != null; eVar2 = eVar2.f23226c) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k7 = this.f23229f;
            if (k7 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k7.equals(entry.getKey())) {
                return false;
            }
            V v7 = this.f23230g;
            if (v7 == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!v7.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f23229f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f23230g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k7 = this.f23229f;
            int iHashCode = k7 == null ? 0 : k7.hashCode();
            V v7 = this.f23230g;
            return iHashCode ^ (v7 != null ? v7.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v7) {
            V v8 = this.f23230g;
            this.f23230g = v7;
            return v8;
        }

        public String toString() {
            return this.f23229f + "=" + this.f23230g;
        }

        e(e<K, V> eVar, K k7, e<K, V> eVar2, e<K, V> eVar3) {
            this.f23224a = eVar;
            this.f23229f = k7;
            this.f23231h = 1;
            this.f23227d = eVar2;
            this.f23228e = eVar3;
            eVar3.f23227d = this;
            eVar2.f23228e = this;
        }
    }
}
