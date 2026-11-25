package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(serializable = true)
public class wj<R, C, V> extends dg<R, C, V> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final long f21374k = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Comparator<? super C> f21375j;

    class a implements com.google.common.base.s<Map<C, V>, Iterator<C>> {
        a() {
        }

        @Override // com.google.common.base.s, java.util.function.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Iterator<C> apply(Map<C, V> map) {
            return map.keySet().iterator();
        }
    }

    class b extends e<C> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        C f21377c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Iterator f21378d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Comparator f21379e;

        b(Iterator it, Comparator comparator) {
            this.f21378d = it;
            this.f21379e = comparator;
        }

        @Override // com.google.common.collect.e
        protected C a() {
            while (this.f21378d.hasNext()) {
                C c8 = (C) this.f21378d.next();
                C c9 = this.f21377c;
                if (!(c9 != null && this.f21379e.compare(c8, c9) == 0)) {
                    this.f21377c = c8;
                    return c8;
                }
            }
            this.f21377c = null;
            return b();
        }
    }

    private static class c<C, V> implements com.google.common.base.p0<TreeMap<C, V>>, Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f21381b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Comparator<? super C> f21382a;

        c(Comparator<? super C> comparator) {
            this.f21382a = comparator;
        }

        @Override // com.google.common.base.p0, java.util.function.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TreeMap<C, V> get() {
            return new TreeMap<>(this.f21382a);
        }
    }

    private class d extends gg<R, C, V>.g implements SortedMap<C, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final C f21383d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final C f21384e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        transient SortedMap<C, V> f21385f;

        d(wj wjVar, R r7) {
            this(r7, null, null);
        }

        @Override // java.util.SortedMap
        public Comparator<? super C> comparator() {
            return wj.this.E();
        }

        @Override // com.google.common.collect.gg.g, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return n(obj) && super.containsKey(obj);
        }

        @Override // com.google.common.collect.gg.g
        void f() {
            if (o() == null || !this.f21385f.isEmpty()) {
                return;
            }
            wj.this.f20296c.remove(this.f20323a);
            this.f21385f = null;
            this.f20324b = null;
        }

        @Override // java.util.SortedMap
        public C firstKey() {
            if (d() != null) {
                return d().firstKey();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> headMap(C c8) {
            com.google.common.base.e0.d(n(com.google.common.base.e0.E(c8)));
            return new d(this.f20323a, this.f21383d, c8);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.gg.g
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public SortedMap<C, V> d() {
            return (SortedMap) super.d();
        }

        int k(Object obj, Object obj2) {
            return comparator().compare(obj, obj2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.gg.g
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public SortedMap<C, V> e() {
            SortedMap<C, V> sortedMapO = o();
            if (sortedMapO == null) {
                return null;
            }
            C c8 = this.f21383d;
            if (c8 != null) {
                sortedMapO = sortedMapO.tailMap(c8);
            }
            C c9 = this.f21384e;
            return c9 != null ? sortedMapO.headMap(c9) : sortedMapO;
        }

        @Override // java.util.SortedMap
        public C lastKey() {
            if (d() != null) {
                return d().lastKey();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public SortedSet<C> keySet() {
            return new wb.h0(this);
        }

        boolean n(Object obj) {
            C c8;
            C c9;
            return obj != null && ((c8 = this.f21383d) == null || k(c8, obj) <= 0) && ((c9 = this.f21384e) == null || k(c9, obj) > 0);
        }

        SortedMap<C, V> o() {
            SortedMap<C, V> sortedMap = this.f21385f;
            if (sortedMap == null || (sortedMap.isEmpty() && wj.this.f20296c.containsKey(this.f20323a))) {
                this.f21385f = (SortedMap) wj.this.f20296c.get(this.f20323a);
            }
            return this.f21385f;
        }

        @Override // com.google.common.collect.gg.g, java.util.AbstractMap, java.util.Map
        public V put(C c8, V v7) {
            com.google.common.base.e0.d(n(com.google.common.base.e0.E(c8)));
            return (V) super.put(c8, v7);
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> subMap(C c8, C c9) {
            com.google.common.base.e0.d(n(com.google.common.base.e0.E(c8)) && n(com.google.common.base.e0.E(c9)));
            return new d(this.f20323a, c8, c9);
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> tailMap(C c8) {
            com.google.common.base.e0.d(n(com.google.common.base.e0.E(c8)));
            return new d(this.f20323a, c8, this.f21384e);
        }

        d(R r7, C c8, C c9) {
            super(r7);
            this.f21383d = c8;
            this.f21384e = c9;
            com.google.common.base.e0.d(c8 == null || c9 == null || k(c8, c9) <= 0);
        }
    }

    wj(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        super(new TreeMap(comparator), new c(comparator2));
        this.f21375j = comparator2;
    }

    public static <R extends Comparable, C extends Comparable, V> wj<R, C, V> F() {
        return new wj<>(td.A(), td.A());
    }

    public static <R, C, V> wj<R, C, V> H(wj<R, C, ? extends V> wjVar) {
        wj<R, C, V> wjVar2 = new wj<>(wjVar.K(), wjVar.E());
        wjVar2.O(wjVar);
        return wjVar2;
    }

    public static <R, C, V> wj<R, C, V> I(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        com.google.common.base.e0.E(comparator);
        com.google.common.base.e0.E(comparator2);
        return new wj<>(comparator, comparator2);
    }

    @Deprecated
    public Comparator<? super C> E() {
        return this.f21375j;
    }

    @Override // com.google.common.collect.gg, com.google.common.collect.oj
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public SortedMap<C, V> X(R r7) {
        return new d(this, r7);
    }

    @Deprecated
    public Comparator<? super R> K() {
        return g().comparator();
    }

    @Override // com.google.common.collect.gg, com.google.common.collect.h0, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ Set L() {
        return super.L();
    }

    @Override // com.google.common.collect.gg, com.google.common.collect.h0, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ boolean M(Object obj) {
        return super.M(obj);
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ void O(oj ojVar) {
        super.O(ojVar);
    }

    @Override // com.google.common.collect.gg, com.google.common.collect.h0, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ boolean P(Object obj, Object obj2) {
        return super.P(obj, obj2);
    }

    @Override // com.google.common.collect.gg, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ Map S() {
        return super.S();
    }

    @Override // com.google.common.collect.gg, com.google.common.collect.h0, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.gg, com.google.common.collect.h0, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.gg, com.google.common.collect.h0, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.gg, com.google.common.collect.h0, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ Object k(Object obj, Object obj2) {
        return super.k(obj, obj2);
    }

    @Override // com.google.common.collect.gg, com.google.common.collect.h0, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ boolean m(Object obj) {
        return super.m(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.gg, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ Map n(Object obj) {
        return super.n(obj);
    }

    @Override // com.google.common.collect.gg, com.google.common.collect.h0, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ Set r() {
        return super.r();
    }

    @Override // com.google.common.collect.gg, com.google.common.collect.h0, com.google.common.collect.oj
    @u1.a
    public /* bridge */ /* synthetic */ Object remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.gg, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.gg, com.google.common.collect.h0, com.google.common.collect.oj
    @u1.a
    public /* bridge */ /* synthetic */ Object t(Object obj, Object obj2, Object obj3) {
        return super.t(obj, obj2, obj3);
    }

    @Override // com.google.common.collect.h0
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.gg
    Iterator<C> u() {
        Comparator<? super C> comparatorE = E();
        return new b(ua.O(ma.S(this.f20296c.values(), new a()), comparatorE), comparatorE);
    }

    @Override // com.google.common.collect.gg, com.google.common.collect.h0, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    @Override // com.google.common.collect.dg, com.google.common.collect.gg, com.google.common.collect.oj
    public SortedMap<R, Map<C, V>> f() {
        return super.f();
    }

    @Override // com.google.common.collect.dg, com.google.common.collect.gg, com.google.common.collect.h0, com.google.common.collect.oj
    public SortedSet<R> g() {
        return super.g();
    }
}
