package com.google.common.collect;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.IntFunction;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.b(emulated = true)
public final class n0<R, C, V> extends h0<R, C, V> implements Serializable {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long f20669j = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d7<R> f20670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d7<C> f20671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final v7<R, Integer> f20672e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final v7<C, Integer> f20673f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final V[][] f20674g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private transient n0<R, C, V>.f f20675h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private transient n0<R, C, V>.h f20676i;

    class a extends com.google.common.collect.d<oj.a<R, C, V>> {
        a(int i7) {
            super(i7);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public oj.a<R, C, V> a(int i7) {
            return n0.this.D(i7);
        }
    }

    class b extends sj.b<R, C, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f20678a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f20679b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f20680c;

        b(int i7) {
            this.f20680c = i7;
            this.f20678a = i7 / n0.this.f20671d.size();
            this.f20679b = i7 % n0.this.f20671d.size();
        }

        @Override // com.google.common.collect.oj.a
        public C a() {
            return (C) n0.this.f20671d.get(this.f20679b);
        }

        @Override // com.google.common.collect.oj.a
        public R b() {
            return (R) n0.this.f20670c.get(this.f20678a);
        }

        @Override // com.google.common.collect.oj.a
        public V getValue() {
            return (V) n0.this.w(this.f20678a, this.f20679b);
        }
    }

    class c extends com.google.common.collect.d<V> {
        c(int i7) {
            super(i7);
        }

        @Override // com.google.common.collect.d
        protected V a(int i7) {
            return (V) n0.this.E(i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static abstract class d<K, V> extends wb.b0<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final v7<K, Integer> f20683a;

        class a extends v<K, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f20684a;

            a(int i7) {
                this.f20684a = i7;
            }

            @Override // com.google.common.collect.v, java.util.Map.Entry
            public K getKey() {
                return (K) d.this.e(this.f20684a);
            }

            @Override // com.google.common.collect.v, java.util.Map.Entry
            public V getValue() {
                return (V) d.this.g(this.f20684a);
            }

            @Override // com.google.common.collect.v, java.util.Map.Entry
            public V setValue(V v7) {
                return (V) d.this.i(this.f20684a, v7);
            }
        }

        class b extends com.google.common.collect.d<Map.Entry<K, V>> {
            b(int i7) {
                super(i7);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> a(int i7) {
                return d.this.d(i7);
            }
        }

        /* synthetic */ d(v7 v7Var, a aVar) {
            this(v7Var);
        }

        @Override // com.google.common.collect.wb.b0
        Iterator<Map.Entry<K, V>> a() {
            return new b(size());
        }

        @Override // com.google.common.collect.wb.b0
        Spliterator<Map.Entry<K, V>> b() {
            return q2.c(size(), 16, new IntFunction() { // from class: com.google.common.collect.o0
                @Override // java.util.function.IntFunction
                public final Object apply(int i7) {
                    return this.f20768a.d(i7);
                }
            });
        }

        @Override // com.google.common.collect.wb.b0, java.util.AbstractMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f20683a.containsKey(obj);
        }

        Map.Entry<K, V> d(int i7) {
            com.google.common.base.e0.C(i7, size());
            return new a(i7);
        }

        K e(int i7) {
            return this.f20683a.keySet().a().get(i7);
        }

        abstract String f();

        abstract V g(int i7);

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            Integer num = this.f20683a.get(obj);
            if (num == null) {
                return null;
            }
            return g(num.intValue());
        }

        abstract V i(int i7, V v7);

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f20683a.isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f20683a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k7, V v7) {
            Integer num = this.f20683a.get(k7);
            if (num != null) {
                return i(num.intValue(), v7);
            }
            throw new IllegalArgumentException(f() + " " + k7 + " not in " + this.f20683a.keySet());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.wb.b0, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f20683a.size();
        }

        private d(v7<K, Integer> v7Var) {
            this.f20683a = v7Var;
        }
    }

    private class e extends d<R, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f20687b;

        e(int i7) {
            super(n0.this.f20672e, null);
            this.f20687b = i7;
        }

        @Override // com.google.common.collect.n0.d
        String f() {
            return "Row";
        }

        @Override // com.google.common.collect.n0.d
        V g(int i7) {
            return (V) n0.this.w(i7, this.f20687b);
        }

        @Override // com.google.common.collect.n0.d
        V i(int i7, V v7) {
            return (V) n0.this.I(i7, this.f20687b, v7);
        }
    }

    private class f extends d<C, Map<R, V>> {
        /* synthetic */ f(n0 n0Var, a aVar) {
            this();
        }

        @Override // com.google.common.collect.n0.d
        String f() {
            return "Column";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.n0.d
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Map<R, V> g(int i7) {
            return new e(i7);
        }

        @Override // com.google.common.collect.n0.d, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public Map<R, V> put(C c8, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.n0.d
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public Map<R, V> i(int i7, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }

        private f() {
            super(n0.this.f20673f, null);
        }
    }

    private class g extends d<C, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f20690b;

        g(int i7) {
            super(n0.this.f20673f, null);
            this.f20690b = i7;
        }

        @Override // com.google.common.collect.n0.d
        String f() {
            return "Column";
        }

        @Override // com.google.common.collect.n0.d
        V g(int i7) {
            return (V) n0.this.w(this.f20690b, i7);
        }

        @Override // com.google.common.collect.n0.d
        V i(int i7, V v7) {
            return (V) n0.this.I(this.f20690b, i7, v7);
        }
    }

    private class h extends d<R, Map<C, V>> {
        /* synthetic */ h(n0 n0Var, a aVar) {
            this();
        }

        @Override // com.google.common.collect.n0.d
        String f() {
            return "Row";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.n0.d
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Map<C, V> g(int i7) {
            return new g(i7);
        }

        @Override // com.google.common.collect.n0.d, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public Map<C, V> put(R r7, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.n0.d
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public Map<C, V> i(int i7, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }

        private h() {
            super(n0.this.f20672e, null);
        }
    }

    private n0(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        d7<R> d7VarP = d7.p(iterable);
        this.f20670c = d7VarP;
        d7<C> d7VarP2 = d7.p(iterable2);
        this.f20671d = d7VarP2;
        com.google.common.base.e0.d(d7VarP.isEmpty() == d7VarP2.isEmpty());
        this.f20672e = wb.V(d7VarP);
        this.f20673f = wb.V(d7VarP2);
        this.f20674g = (V[][]) ((Object[][]) Array.newInstance((Class<?>) Object.class, d7VarP.size(), d7VarP2.size()));
        C();
    }

    public static <R, C, V> n0<R, C, V> A(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        return new n0<>(iterable, iterable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public oj.a<R, C, V> D(int i7) {
        return new b(i7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V E(int i7) {
        return w(i7 / this.f20671d.size(), i7 % this.f20671d.size());
    }

    public static <R, C, V> n0<R, C, V> z(oj<R, C, V> ojVar) {
        return ojVar instanceof n0 ? new n0<>((n0) ojVar) : new n0<>(ojVar);
    }

    @u1.a
    public V B(Object obj, Object obj2) {
        Integer num = this.f20672e.get(obj);
        Integer num2 = this.f20673f.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return I(num.intValue(), num2.intValue(), null);
    }

    public void C() {
        for (V[] vArr : this.f20674g) {
            Arrays.fill(vArr, (Object) null);
        }
    }

    public d7<R> F() {
        return this.f20670c;
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public u8<R> g() {
        return this.f20672e.keySet();
    }

    @u1.a
    public V I(int i7, int i8, V v7) {
        com.google.common.base.e0.C(i7, this.f20670c.size());
        com.google.common.base.e0.C(i8, this.f20671d.size());
        V[] vArr = this.f20674g[i7];
        V v8 = vArr[i8];
        vArr[i8] = v7;
        return v8;
    }

    @s1.c
    public V[][] J(Class<V> cls) {
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance((Class<?>) cls, this.f20670c.size(), this.f20671d.size()));
        for (int i7 = 0; i7 < this.f20670c.size(); i7++) {
            V[] vArr2 = this.f20674g[i7];
            System.arraycopy(vArr2, 0, vArr[i7], 0, vArr2.length);
        }
        return vArr;
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public boolean M(Object obj) {
        return this.f20672e.containsKey(obj);
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public void O(oj<? extends R, ? extends C, ? extends V> ojVar) {
        super.O(ojVar);
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public boolean P(Object obj, Object obj2) {
        return M(obj) && m(obj2);
    }

    @Override // com.google.common.collect.oj
    public Map<C, Map<R, V>> S() {
        n0<R, C, V>.f fVar = this.f20675h;
        if (fVar != null) {
            return fVar;
        }
        n0<R, C, V>.f fVar2 = new f(this, null);
        this.f20675h = fVar2;
        return fVar2;
    }

    @Override // com.google.common.collect.oj
    public Map<C, V> X(R r7) {
        com.google.common.base.e0.E(r7);
        Integer num = this.f20672e.get(r7);
        return num == null ? v7.y() : new g(num.intValue());
    }

    @Override // com.google.common.collect.h0
    Iterator<oj.a<R, C, V>> a() {
        return new a(size());
    }

    @Override // com.google.common.collect.h0
    Spliterator<oj.a<R, C, V>> b() {
        return q2.c(size(), 273, new IntFunction() { // from class: com.google.common.collect.m0
            @Override // java.util.function.IntFunction
            public final Object apply(int i7) {
                return this.f20600a.D(i7);
            }
        });
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public boolean containsValue(Object obj) {
        for (V[] vArr : this.f20674g) {
            for (V v7 : vArr) {
                if (com.google.common.base.y.a(obj, v7)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.common.collect.h0
    Iterator<V> e() {
        return new c(size());
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.oj
    public Map<R, Map<C, V>> f() {
        n0<R, C, V>.h hVar = this.f20676i;
        if (hVar != null) {
            return hVar;
        }
        n0<R, C, V>.h hVar2 = new h(this, null);
        this.f20676i = hVar2;
        return hVar2;
    }

    @Override // com.google.common.collect.h0
    Spliterator<V> h() {
        return q2.c(size(), 16, new IntFunction() { // from class: com.google.common.collect.l0
            @Override // java.util.function.IntFunction
            public final Object apply(int i7) {
                return this.f20562a.E(i7);
            }
        });
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public boolean isEmpty() {
        return this.f20670c.isEmpty() || this.f20671d.isEmpty();
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public V k(Object obj, Object obj2) {
        Integer num = this.f20672e.get(obj);
        Integer num2 = this.f20673f.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return w(num.intValue(), num2.intValue());
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public boolean m(Object obj) {
        return this.f20673f.containsKey(obj);
    }

    @Override // com.google.common.collect.oj
    public Map<R, V> n(C c8) {
        com.google.common.base.e0.E(c8);
        Integer num = this.f20673f.get(c8);
        return num == null ? v7.y() : new e(num.intValue());
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public Set<oj.a<R, C, V>> r() {
        return super.r();
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    @u1.a
    @Deprecated
    public V remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.oj
    public int size() {
        return this.f20670c.size() * this.f20671d.size();
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    @u1.a
    public V t(R r7, C c8, V v7) {
        com.google.common.base.e0.E(r7);
        com.google.common.base.e0.E(c8);
        Integer num = this.f20672e.get(r7);
        com.google.common.base.e0.y(num != null, "Row %s not in %s", r7, this.f20670c);
        Integer num2 = this.f20673f.get(c8);
        com.google.common.base.e0.y(num2 != null, "Column %s not in %s", c8, this.f20671d);
        return I(num.intValue(), num2.intValue(), v7);
    }

    @Override // com.google.common.collect.h0
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public Collection<V> values() {
        return super.values();
    }

    public V w(int i7, int i8) {
        com.google.common.base.e0.C(i7, this.f20670c.size());
        com.google.common.base.e0.C(i8, this.f20671d.size());
        return this.f20674g[i7][i8];
    }

    public d7<C> x() {
        return this.f20671d;
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public u8<C> L() {
        return this.f20673f.keySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private n0(oj<R, C, V> ojVar) {
        this(ojVar.g(), ojVar.L());
        O(ojVar);
    }

    private n0(n0<R, C, V> n0Var) {
        d7<R> d7Var = n0Var.f20670c;
        this.f20670c = d7Var;
        d7<C> d7Var2 = n0Var.f20671d;
        this.f20671d = d7Var2;
        this.f20672e = n0Var.f20672e;
        this.f20673f = n0Var.f20673f;
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance((Class<?>) Object.class, d7Var.size(), d7Var2.size()));
        this.f20674g = vArr;
        for (int i7 = 0; i7 < this.f20670c.size(); i7++) {
            V[] vArr2 = n0Var.f20674g[i7];
            System.arraycopy(vArr2, 0, vArr[i7], 0, vArr2.length);
        }
    }
}
