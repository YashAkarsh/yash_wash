package com.google.common.graph;

import com.google.common.collect.ck;
import com.google.common.collect.v7;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class o<N, V> implements b0<N, V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f21657d = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<N, Object> f21658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f21659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f21660c;

    class a extends AbstractSet<N> {

        /* JADX INFO: renamed from: com.google.common.graph.o$a$a, reason: collision with other inner class name */
        class C0275a extends com.google.common.collect.e<N> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Iterator f21662c;

            C0275a(Iterator it) {
                this.f21662c = it;
            }

            @Override // com.google.common.collect.e
            protected N a() {
                while (this.f21662c.hasNext()) {
                    Map.Entry entry = (Map.Entry) this.f21662c.next();
                    if (o.n(entry.getValue())) {
                        return (N) entry.getKey();
                    }
                }
                return b();
            }
        }

        a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ck<N> iterator() {
            return new C0275a(o.this.f21658a.entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return o.n(o.this.f21658a.get(obj));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return o.this.f21659b;
        }
    }

    class b extends AbstractSet<N> {

        class a extends com.google.common.collect.e<N> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Iterator f21665c;

            a(Iterator it) {
                this.f21665c = it;
            }

            @Override // com.google.common.collect.e
            protected N a() {
                while (this.f21665c.hasNext()) {
                    Map.Entry entry = (Map.Entry) this.f21665c.next();
                    if (o.o(entry.getValue())) {
                        return (N) entry.getKey();
                    }
                }
                return b();
            }
        }

        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ck<N> iterator() {
            return new a(o.this.f21658a.entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return o.o(o.this.f21658a.get(obj));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return o.this.f21660c;
        }
    }

    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f21667a;

        c(Object obj) {
            this.f21667a = obj;
        }
    }

    private o(Map<N, Object> map, int i7, int i8) {
        this.f21658a = (Map) com.google.common.base.e0.E(map);
        this.f21659b = d0.b(i7);
        this.f21660c = d0.b(i8);
        com.google.common.base.e0.g0(i7 <= map.size() && i8 <= map.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean n(Object obj) {
        return obj == f21657d || (obj instanceof c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean o(Object obj) {
        return (obj == f21657d || obj == null) ? false : true;
    }

    static <N, V> o<N, V> p() {
        return new o<>(new HashMap(4, 1.0f), 0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <N, V> o<N, V> q(Set<N> set, Map<N, V> map) {
        HashMap map2 = new HashMap();
        map2.putAll(map);
        for (N n7 : set) {
            Object objPut = map2.put(n7, f21657d);
            if (objPut != null) {
                map2.put(n7, new c(objPut));
            }
        }
        return new o<>(v7.g(map2), set.size(), map.size());
    }

    @Override // com.google.common.graph.b0
    public Set<N> a() {
        return Collections.unmodifiableSet(this.f21658a.keySet());
    }

    @Override // com.google.common.graph.b0
    public Set<N> b() {
        return new b();
    }

    @Override // com.google.common.graph.b0
    public Set<N> c() {
        return new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.b0
    public V d(Object obj) {
        Object obj2;
        V v7 = (V) this.f21658a.get(obj);
        if (v7 == 0 || v7 == (obj2 = f21657d)) {
            return null;
        }
        if (v7 instanceof c) {
            this.f21658a.put(obj, obj2);
            int i7 = this.f21660c - 1;
            this.f21660c = i7;
            d0.b(i7);
            return (V) ((c) v7).f21667a;
        }
        this.f21658a.remove(obj);
        int i8 = this.f21660c - 1;
        this.f21660c = i8;
        d0.b(i8);
        return v7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.b0
    public V e(N n7) {
        V v7 = (V) this.f21658a.get(n7);
        if (v7 == f21657d) {
            return null;
        }
        return v7 instanceof c ? (V) ((c) v7).f21667a : v7;
    }

    @Override // com.google.common.graph.b0
    public void f(N n7) {
        Object obj = this.f21658a.get(n7);
        if (obj == f21657d) {
            this.f21658a.remove(n7);
            int i7 = this.f21659b - 1;
            this.f21659b = i7;
            d0.b(i7);
            return;
        }
        if (obj instanceof c) {
            this.f21658a.put(n7, ((c) obj).f21667a);
            int i8 = this.f21659b - 1;
            this.f21659b = i8;
            d0.b(i8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.b0
    public V g(N n7, V v7) {
        V v8 = (V) this.f21658a.put(n7, v7);
        if (v8 == 0) {
            int i7 = this.f21660c + 1;
            this.f21660c = i7;
            d0.d(i7);
            return null;
        }
        if (v8 instanceof c) {
            this.f21658a.put(n7, new c(v7));
            return (V) ((c) v8).f21667a;
        }
        if (v8 != f21657d) {
            return v8;
        }
        this.f21658a.put(n7, new c(v7));
        int i8 = this.f21660c + 1;
        this.f21660c = i8;
        d0.d(i8);
        return null;
    }

    @Override // com.google.common.graph.b0
    public void h(N n7, V v7) {
        Map<N, Object> map = this.f21658a;
        Object obj = f21657d;
        Object objPut = map.put(n7, obj);
        if (objPut == null) {
            int i7 = this.f21659b + 1;
            this.f21659b = i7;
            d0.d(i7);
        } else if (objPut instanceof c) {
            this.f21658a.put(n7, objPut);
        } else if (objPut != obj) {
            this.f21658a.put(n7, new c(objPut));
            int i8 = this.f21659b + 1;
            this.f21659b = i8;
            d0.d(i8);
        }
    }
}
