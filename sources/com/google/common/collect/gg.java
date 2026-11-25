package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
class gg<R, C, V> extends h0<R, C, V> implements Serializable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final long f20295h = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l6
    final Map<R, Map<C, V>> f20296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l6
    final com.google.common.base.p0<? extends Map<C, V>> f20297d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private transient Set<C> f20298e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient Map<R, Map<C, V>> f20299f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient gg<R, C, V>.f f20300g;

    private class b implements Iterator<oj.a<R, C, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Iterator<Map.Entry<R, Map<C, V>>> f20301a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Map.Entry<R, Map<C, V>> f20302b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Iterator<Map.Entry<C, V>> f20303c;

        private b() {
            this.f20301a = gg.this.f20296c.entrySet().iterator();
            this.f20303c = ua.w();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public oj.a<R, C, V> next() {
            if (!this.f20303c.hasNext()) {
                Map.Entry<R, Map<C, V>> next = this.f20301a.next();
                this.f20302b = next;
                this.f20303c = next.getValue().entrySet().iterator();
            }
            Map.Entry<C, V> next2 = this.f20303c.next();
            return sj.f(this.f20302b.getKey(), next2.getKey(), next2.getValue());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f20301a.hasNext() || this.f20303c.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f20303c.remove();
            if (this.f20302b.getValue().isEmpty()) {
                this.f20301a.remove();
                this.f20302b = null;
            }
        }
    }

    private class c extends wb.s0<R, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final C f20305d;

        private class a extends af.l<Map.Entry<R, V>> {
            private a() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                c.this.d(com.google.common.base.h0.c());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return gg.this.q(entry.getKey(), c.this.f20305d, entry.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                c cVar = c.this;
                return !gg.this.m(cVar.f20305d);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, V>> iterator() {
                return new b();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return gg.this.A(entry.getKey(), c.this.f20305d, entry.getValue());
            }

            @Override // com.google.common.collect.af.l, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return c.this.d(com.google.common.base.h0.q(com.google.common.base.h0.n(collection)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                Iterator<Map<C, V>> it = gg.this.f20296c.values().iterator();
                int i7 = 0;
                while (it.hasNext()) {
                    if (it.next().containsKey(c.this.f20305d)) {
                        i7++;
                    }
                }
                return i7;
            }
        }

        private class b extends com.google.common.collect.e<Map.Entry<R, V>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final Iterator<Map.Entry<R, Map<C, V>>> f20308c;

            class a extends v<R, V> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ Map.Entry f20310a;

                a(Map.Entry entry) {
                    this.f20310a = entry;
                }

                @Override // com.google.common.collect.v, java.util.Map.Entry
                public R getKey() {
                    return (R) this.f20310a.getKey();
                }

                @Override // com.google.common.collect.v, java.util.Map.Entry
                public V getValue() {
                    return (V) ((Map) this.f20310a.getValue()).get(c.this.f20305d);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.collect.v, java.util.Map.Entry
                public V setValue(V v7) {
                    return (V) ((Map) this.f20310a.getValue()).put(c.this.f20305d, com.google.common.base.e0.E(v7));
                }
            }

            private b() {
                this.f20308c = gg.this.f20296c.entrySet().iterator();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.e
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<R, V> a() {
                while (this.f20308c.hasNext()) {
                    Map.Entry<R, Map<C, V>> next = this.f20308c.next();
                    if (next.getValue().containsKey(c.this.f20305d)) {
                        return new a(next);
                    }
                }
                return b();
            }
        }

        /* JADX INFO: renamed from: com.google.common.collect.gg$c$c, reason: collision with other inner class name */
        private class C0244c extends wb.c0<R, V> {
            C0244c() {
                super(c.this);
            }

            @Override // com.google.common.collect.wb.c0, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                c cVar = c.this;
                return gg.this.P(obj, cVar.f20305d);
            }

            @Override // com.google.common.collect.wb.c0, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                c cVar = c.this;
                return gg.this.remove(obj, cVar.f20305d) != null;
            }

            @Override // com.google.common.collect.af.l, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return c.this.d(wb.Z(com.google.common.base.h0.q(com.google.common.base.h0.n(collection))));
            }
        }

        private class d extends wb.r0<R, V> {
            d() {
                super(c.this);
            }

            @Override // com.google.common.collect.wb.r0, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                return obj != null && c.this.d(wb.c1(com.google.common.base.h0.m(obj)));
            }

            @Override // com.google.common.collect.wb.r0, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                return c.this.d(wb.c1(com.google.common.base.h0.n(collection)));
            }

            @Override // com.google.common.collect.wb.r0, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                return c.this.d(wb.c1(com.google.common.base.h0.q(com.google.common.base.h0.n(collection))));
            }
        }

        c(C c8) {
            this.f20305d = (C) com.google.common.base.e0.E(c8);
        }

        @Override // com.google.common.collect.wb.s0
        Set<Map.Entry<R, V>> a() {
            return new a();
        }

        @Override // com.google.common.collect.wb.s0
        /* JADX INFO: renamed from: b */
        Set<R> g() {
            return new C0244c();
        }

        @Override // com.google.common.collect.wb.s0
        Collection<V> c() {
            return new d();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return gg.this.P(obj, this.f20305d);
        }

        @u1.a
        boolean d(com.google.common.base.g0<? super Map.Entry<R, V>> g0Var) {
            Iterator<Map.Entry<R, Map<C, V>>> it = gg.this.f20296c.entrySet().iterator();
            boolean z7 = false;
            while (it.hasNext()) {
                Map.Entry<R, Map<C, V>> next = it.next();
                Map<C, V> value = next.getValue();
                V v7 = value.get(this.f20305d);
                if (v7 != null && g0Var.apply(wb.T(next.getKey(), v7))) {
                    value.remove(this.f20305d);
                    if (value.isEmpty()) {
                        it.remove();
                    }
                    z7 = true;
                }
            }
            return z7;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            return (V) gg.this.k(obj, this.f20305d);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(R r7, V v7) {
            return (V) gg.this.t(r7, this.f20305d, v7);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            return (V) gg.this.remove(obj, this.f20305d);
        }
    }

    private class d extends com.google.common.collect.e<C> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Map<C, V> f20314c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Iterator<Map<C, V>> f20315d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Iterator<Map.Entry<C, V>> f20316e;

        private d() {
            this.f20314c = gg.this.f20297d.get();
            this.f20315d = gg.this.f20296c.values().iterator();
            this.f20316e = ua.u();
        }

        @Override // com.google.common.collect.e
        protected C a() {
            while (true) {
                if (this.f20316e.hasNext()) {
                    Map.Entry<C, V> next = this.f20316e.next();
                    if (!this.f20314c.containsKey(next.getKey())) {
                        this.f20314c.put(next.getKey(), next.getValue());
                        return next.getKey();
                    }
                } else {
                    if (!this.f20315d.hasNext()) {
                        return b();
                    }
                    this.f20316e = this.f20315d.next().entrySet().iterator();
                }
            }
        }
    }

    private class e extends gg<R, C, V>.i<C> {
        private e() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return gg.this.m(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<C> iterator() {
            return gg.this.u();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            boolean z7 = false;
            if (obj == null) {
                return false;
            }
            Iterator<Map<C, V>> it = gg.this.f20296c.values().iterator();
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (next.keySet().remove(obj)) {
                    if (next.isEmpty()) {
                        it.remove();
                    }
                    z7 = true;
                }
            }
            return z7;
        }

        @Override // com.google.common.collect.af.l, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            com.google.common.base.e0.E(collection);
            Iterator<Map<C, V>> it = gg.this.f20296c.values().iterator();
            boolean z7 = false;
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (ua.V(next.keySet().iterator(), collection)) {
                    if (next.isEmpty()) {
                        it.remove();
                    }
                    z7 = true;
                }
            }
            return z7;
        }

        @Override // com.google.common.collect.af.l, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            com.google.common.base.e0.E(collection);
            Iterator<Map<C, V>> it = gg.this.f20296c.values().iterator();
            boolean z7 = false;
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (next.keySet().retainAll(collection)) {
                    if (next.isEmpty()) {
                        it.remove();
                    }
                    z7 = true;
                }
            }
            return z7;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ua.Z(iterator());
        }
    }

    private class f extends wb.s0<C, Map<R, V>> {

        class a extends gg<R, C, V>.i<Map.Entry<C, Map<R, V>>> {

            /* JADX INFO: renamed from: com.google.common.collect.gg$f$a$a, reason: collision with other inner class name */
            class C0245a implements com.google.common.base.s<C, Map<R, V>> {
                C0245a() {
                }

                @Override // com.google.common.base.s, java.util.function.Function
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Map<R, V> apply(C c8) {
                    return gg.this.n(c8);
                }
            }

            a() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (!gg.this.m(entry.getKey())) {
                    return false;
                }
                return f.this.get(entry.getKey()).equals(entry.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<C, Map<R, V>>> iterator() {
                return wb.r(gg.this.L(), new C0245a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                gg.this.z(((Map.Entry) obj).getKey());
                return true;
            }

            @Override // com.google.common.collect.af.l, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                com.google.common.base.e0.E(collection);
                return af.J(this, collection.iterator());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.af.l, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                com.google.common.base.e0.E(collection);
                boolean z7 = false;
                for (Object obj : ib.s(gg.this.L().iterator())) {
                    if (!collection.contains(wb.T(obj, gg.this.n(obj)))) {
                        gg.this.z(obj);
                        z7 = true;
                    }
                }
                return z7;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return gg.this.L().size();
            }
        }

        private class b extends wb.r0<C, Map<R, V>> {
            b() {
                super(f.this);
            }

            @Override // com.google.common.collect.wb.r0, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                for (Map.Entry<C, Map<R, V>> entry : f.this.entrySet()) {
                    if (entry.getValue().equals(obj)) {
                        gg.this.z(entry.getKey());
                        return true;
                    }
                }
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.wb.r0, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                com.google.common.base.e0.E(collection);
                boolean z7 = false;
                for (Object obj : ib.s(gg.this.L().iterator())) {
                    if (collection.contains(gg.this.n(obj))) {
                        gg.this.z(obj);
                        z7 = true;
                    }
                }
                return z7;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.wb.r0, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                com.google.common.base.e0.E(collection);
                boolean z7 = false;
                for (Object obj : ib.s(gg.this.L().iterator())) {
                    if (!collection.contains(gg.this.n(obj))) {
                        gg.this.z(obj);
                        z7 = true;
                    }
                }
                return z7;
            }
        }

        private f() {
        }

        @Override // com.google.common.collect.wb.s0
        public Set<Map.Entry<C, Map<R, V>>> a() {
            return new a();
        }

        @Override // com.google.common.collect.wb.s0
        Collection<Map<R, V>> c() {
            return new b();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return gg.this.m(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map<R, V> get(Object obj) {
            if (gg.this.m(obj)) {
                return gg.this.n(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Map<R, V> remove(Object obj) {
            if (gg.this.m(obj)) {
                return gg.this.z(obj);
            }
            return null;
        }

        @Override // com.google.common.collect.wb.s0, java.util.AbstractMap, java.util.Map
        public Set<C> keySet() {
            return gg.this.L();
        }
    }

    class g extends wb.b0<C, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final R f20323a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Map<C, V> f20324b;

        class a implements Iterator<Map.Entry<C, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Iterator f20326a;

            a(Iterator it) {
                this.f20326a = it;
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry<C, V> next() {
                return g.this.g((Map.Entry) this.f20326a.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f20326a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f20326a.remove();
                g.this.f();
            }
        }

        class b extends v5<C, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map.Entry f20328a;

            b(Map.Entry entry) {
                this.f20328a = entry;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.v5, com.google.common.collect.b6
            /* JADX INFO: renamed from: d0 */
            public Map.Entry<C, V> c0() {
                return this.f20328a;
            }

            @Override // com.google.common.collect.v5, java.util.Map.Entry
            public boolean equals(Object obj) {
                return e0(obj);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.v5, java.util.Map.Entry
            public V setValue(V v7) {
                return (V) super.setValue(com.google.common.base.e0.E(v7));
            }
        }

        g(R r7) {
            this.f20323a = (R) com.google.common.base.e0.E(r7);
        }

        @Override // com.google.common.collect.wb.b0
        Iterator<Map.Entry<C, V>> a() {
            Map<C, V> mapD = d();
            return mapD == null ? ua.w() : new a(mapD.entrySet().iterator());
        }

        @Override // com.google.common.collect.wb.b0
        Spliterator<Map.Entry<C, V>> b() {
            Map<C, V> mapD = d();
            return mapD == null ? Spliterators.emptySpliterator() : q2.e(mapD.entrySet().spliterator(), new Function() { // from class: com.google.common.collect.ig
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.f20458a.g((Map.Entry) obj);
                }
            });
        }

        @Override // com.google.common.collect.wb.b0, java.util.AbstractMap, java.util.Map
        public void clear() {
            Map<C, V> mapD = d();
            if (mapD != null) {
                mapD.clear();
            }
            f();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            Map<C, V> mapD = d();
            return (obj == null || mapD == null || !wb.y0(mapD, obj)) ? false : true;
        }

        Map<C, V> d() {
            Map<C, V> map = this.f20324b;
            if (map != null && (!map.isEmpty() || !gg.this.f20296c.containsKey(this.f20323a))) {
                return this.f20324b;
            }
            Map<C, V> mapE = e();
            this.f20324b = mapE;
            return mapE;
        }

        Map<C, V> e() {
            return gg.this.f20296c.get(this.f20323a);
        }

        void f() {
            if (d() == null || !this.f20324b.isEmpty()) {
                return;
            }
            gg.this.f20296c.remove(this.f20323a);
            this.f20324b = null;
        }

        Map.Entry<C, V> g(Map.Entry<C, V> entry) {
            return new b(entry);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            Map<C, V> mapD = d();
            if (obj == null || mapD == null) {
                return null;
            }
            return (V) wb.z0(mapD, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(C c8, V v7) {
            com.google.common.base.e0.E(c8);
            com.google.common.base.e0.E(v7);
            Map<C, V> map = this.f20324b;
            return (map == null || map.isEmpty()) ? (V) gg.this.t(this.f20323a, c8, v7) : this.f20324b.put(c8, v7);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            Map<C, V> mapD = d();
            if (mapD == null) {
                return null;
            }
            V v7 = (V) wb.A0(mapD, obj);
            f();
            return v7;
        }

        @Override // com.google.common.collect.wb.b0, java.util.AbstractMap, java.util.Map
        public int size() {
            Map<C, V> mapD = d();
            if (mapD == null) {
                return 0;
            }
            return mapD.size();
        }
    }

    class h extends wb.s0<R, Map<C, V>> {

        class a extends gg<R, C, V>.i<Map.Entry<R, Map<C, V>>> {

            /* JADX INFO: renamed from: com.google.common.collect.gg$h$a$a, reason: collision with other inner class name */
            class C0246a implements com.google.common.base.s<R, Map<C, V>> {
                C0246a() {
                }

                @Override // com.google.common.base.s, java.util.function.Function
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Map<C, V> apply(R r7) {
                    return gg.this.X(r7);
                }
            }

            a() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return entry.getKey() != null && (entry.getValue() instanceof Map) && h3.j(gg.this.f20296c.entrySet(), entry);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, Map<C, V>>> iterator() {
                return wb.r(gg.this.f20296c.keySet(), new C0246a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return entry.getKey() != null && (entry.getValue() instanceof Map) && gg.this.f20296c.entrySet().remove(entry);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return gg.this.f20296c.size();
            }
        }

        h() {
        }

        @Override // com.google.common.collect.wb.s0
        protected Set<Map.Entry<R, Map<C, V>>> a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return gg.this.M(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map<C, V> get(Object obj) {
            if (gg.this.M(obj)) {
                return gg.this.X(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Map<C, V> remove(Object obj) {
            if (obj == null) {
                return null;
            }
            return gg.this.f20296c.remove(obj);
        }
    }

    private abstract class i<T> extends af.l<T> {
        private i() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            gg.this.f20296c.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return gg.this.f20296c.isEmpty();
        }
    }

    gg(Map<R, Map<C, V>> map, com.google.common.base.p0<? extends Map<C, V>> p0Var) {
        this.f20296c = map;
        this.f20297d = p0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A(Object obj, Object obj2, Object obj3) {
        if (!q(obj, obj2, obj3)) {
            return false;
        }
        remove(obj, obj2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q(Object obj, Object obj2, Object obj3) {
        return obj3 != null && obj3.equals(k(obj, obj2));
    }

    private Map<C, V> w(R r7) {
        Map<C, V> map = this.f20296c.get(r7);
        if (map != null) {
            return map;
        }
        Map<C, V> map2 = this.f20297d.get();
        this.f20296c.put(r7, map2);
        return map2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Spliterator x(final Map.Entry entry) {
        return q2.e(((Map) entry.getValue()).entrySet().spliterator(), new Function() { // from class: com.google.common.collect.eg
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return gg.y(entry, (Map.Entry) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ oj.a y(Map.Entry entry, Map.Entry entry2) {
        return sj.f(entry.getKey(), entry2.getKey(), entry2.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @u1.a
    public Map<R, V> z(Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<R, Map<C, V>>> it = this.f20296c.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<R, Map<C, V>> next = it.next();
            V vRemove = next.getValue().remove(obj);
            if (vRemove != null) {
                linkedHashMap.put(next.getKey(), vRemove);
                if (next.getValue().isEmpty()) {
                    it.remove();
                }
            }
        }
        return linkedHashMap;
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public Set<C> L() {
        Set<C> set = this.f20298e;
        if (set != null) {
            return set;
        }
        e eVar = new e();
        this.f20298e = eVar;
        return eVar;
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public boolean M(Object obj) {
        return obj != null && wb.y0(this.f20296c, obj);
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public boolean P(Object obj, Object obj2) {
        return (obj == null || obj2 == null || !super.P(obj, obj2)) ? false : true;
    }

    @Override // com.google.common.collect.oj
    public Map<C, Map<R, V>> S() {
        gg<R, C, V>.f fVar = this.f20300g;
        if (fVar != null) {
            return fVar;
        }
        gg<R, C, V>.f fVar2 = new f();
        this.f20300g = fVar2;
        return fVar2;
    }

    @Override // com.google.common.collect.oj
    public Map<C, V> X(R r7) {
        return new g(r7);
    }

    @Override // com.google.common.collect.h0
    Iterator<oj.a<R, C, V>> a() {
        return new b();
    }

    @Override // com.google.common.collect.h0
    Spliterator<oj.a<R, C, V>> b() {
        return q2.b(this.f20296c.entrySet().spliterator(), new Function() { // from class: com.google.common.collect.fg
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return gg.x((Map.Entry) obj);
            }
        }, 65, size());
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public void clear() {
        this.f20296c.clear();
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public boolean containsValue(Object obj) {
        return obj != null && super.containsValue(obj);
    }

    @Override // com.google.common.collect.oj
    public Map<R, Map<C, V>> f() {
        Map<R, Map<C, V>> map = this.f20299f;
        if (map != null) {
            return map;
        }
        Map<R, Map<C, V>> mapV = v();
        this.f20299f = mapV;
        return mapV;
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public Set<R> g() {
        return f().keySet();
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public boolean isEmpty() {
        return this.f20296c.isEmpty();
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public V k(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return null;
        }
        return (V) super.k(obj, obj2);
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public boolean m(Object obj) {
        if (obj == null) {
            return false;
        }
        Iterator<Map<C, V>> it = this.f20296c.values().iterator();
        while (it.hasNext()) {
            if (wb.y0(it.next(), obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.oj
    public Map<R, V> n(C c8) {
        return new c(c8);
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public Set<oj.a<R, C, V>> r() {
        return super.r();
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    @u1.a
    public V remove(Object obj, Object obj2) {
        Map map;
        if (obj == null || obj2 == null || (map = (Map) wb.z0(this.f20296c, obj)) == null) {
            return null;
        }
        V v7 = (V) map.remove(obj2);
        if (map.isEmpty()) {
            this.f20296c.remove(obj);
        }
        return v7;
    }

    @Override // com.google.common.collect.oj
    public int size() {
        Iterator<Map<C, V>> it = this.f20296c.values().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += it.next().size();
        }
        return size;
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    @u1.a
    public V t(R r7, C c8, V v7) {
        com.google.common.base.e0.E(r7);
        com.google.common.base.e0.E(c8);
        com.google.common.base.e0.E(v7);
        return w(r7).put(c8, v7);
    }

    Iterator<C> u() {
        return new d();
    }

    Map<R, Map<C, V>> v() {
        return new h();
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public Collection<V> values() {
        return super.values();
    }
}
