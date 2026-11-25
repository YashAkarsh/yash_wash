package com.google.common.collect;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public final class zj<K extends Comparable, V> implements zd<K, V> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final zd f21498b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NavigableMap<k4<K>, c<K, V>> f21499a = wb.p0();

    static class a implements zd {
        a() {
        }

        @Override // com.google.common.collect.zd
        public void b(xd xdVar) {
            com.google.common.base.e0.E(xdVar);
        }

        @Override // com.google.common.collect.zd
        public xd c() {
            throw new NoSuchElementException();
        }

        @Override // com.google.common.collect.zd
        public void clear() {
        }

        @Override // com.google.common.collect.zd
        public Map.Entry<xd, Object> d(Comparable comparable) {
            return null;
        }

        @Override // com.google.common.collect.zd
        public zd e(xd xdVar) {
            com.google.common.base.e0.E(xdVar);
            return this;
        }

        @Override // com.google.common.collect.zd
        public Map<xd, Object> f() {
            return Collections.emptyMap();
        }

        @Override // com.google.common.collect.zd
        public Map<xd, Object> g() {
            return Collections.emptyMap();
        }

        @Override // com.google.common.collect.zd
        public Object h(Comparable comparable) {
            return null;
        }

        @Override // com.google.common.collect.zd
        public void i(zd zdVar) {
            if (!zdVar.g().isEmpty()) {
                throw new IllegalArgumentException("Cannot putAll(nonEmptyRangeMap) into an empty subRangeMap");
            }
        }

        @Override // com.google.common.collect.zd
        public void j(xd xdVar, Object obj) {
            com.google.common.base.e0.E(xdVar);
            throw new IllegalArgumentException("Cannot insert range " + xdVar + " into an empty subRangeMap");
        }

        @Override // com.google.common.collect.zd
        public void k(xd xdVar, Object obj) {
            com.google.common.base.e0.E(xdVar);
            throw new IllegalArgumentException("Cannot insert range " + xdVar + " into an empty subRangeMap");
        }
    }

    private final class b extends wb.b0<xd<K>, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Iterable<Map.Entry<xd<K>, V>> f21500a;

        b(Iterable<c<K, V>> iterable) {
            this.f21500a = iterable;
        }

        @Override // com.google.common.collect.wb.b0
        Iterator<Map.Entry<xd<K>, V>> a() {
            return this.f21500a.iterator();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            if (!(obj instanceof xd)) {
                return null;
            }
            xd xdVar = (xd) obj;
            c cVar = (c) zj.this.f21499a.get(xdVar.f21414a);
            if (cVar == null || !cVar.getKey().equals(xdVar)) {
                return null;
            }
            return (V) cVar.getValue();
        }

        @Override // com.google.common.collect.wb.b0, java.util.AbstractMap, java.util.Map
        public int size() {
            return zj.this.f21499a.size();
        }
    }

    private static final class c<K extends Comparable, V> extends v<xd<K>, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final xd<K> f21502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final V f21503b;

        c(k4<K> k4Var, k4<K> k4Var2, V v7) {
            this(xd.l(k4Var, k4Var2), v7);
        }

        public boolean c(K k7) {
            return this.f21502a.j(k7);
        }

        @Override // com.google.common.collect.v, java.util.Map.Entry
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public xd<K> getKey() {
            return this.f21502a;
        }

        k4<K> g() {
            return (k4<K>) this.f21502a.f21414a;
        }

        @Override // com.google.common.collect.v, java.util.Map.Entry
        public V getValue() {
            return this.f21503b;
        }

        k4<K> h() {
            return (k4<K>) this.f21502a.f21415b;
        }

        c(xd<K> xdVar, V v7) {
            this.f21502a = xdVar;
            this.f21503b = v7;
        }
    }

    private class d implements zd<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final xd<K> f21504a;

        class a extends zj<K, V>.d.b {

            /* JADX INFO: renamed from: com.google.common.collect.zj$d$a$a, reason: collision with other inner class name */
            class C0262a extends e<Map.Entry<xd<K>, V>> {

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ Iterator f21507c;

                C0262a(Iterator it) {
                    this.f21507c = it;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.e
                /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
                public Map.Entry<xd<K>, V> a() {
                    if (!this.f21507c.hasNext()) {
                        return (Map.Entry) b();
                    }
                    c cVar = (c) this.f21507c.next();
                    return cVar.h().compareTo(d.this.f21504a.f21414a) <= 0 ? (Map.Entry) b() : wb.T(cVar.getKey().u(d.this.f21504a), cVar.getValue());
                }
            }

            a() {
                super();
            }

            @Override // com.google.common.collect.zj.d.b
            Iterator<Map.Entry<xd<K>, V>> b() {
                return d.this.f21504a.w() ? ua.u() : new C0262a(zj.this.f21499a.headMap(d.this.f21504a.f21415b, false).descendingMap().values().iterator());
            }
        }

        class b extends AbstractMap<xd<K>, V> {

            class a extends wb.c0<xd<K>, V> {
                a(Map map) {
                    super(map);
                }

                @Override // com.google.common.collect.wb.c0, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean remove(Object obj) {
                    return b.this.remove(obj) != null;
                }

                @Override // com.google.common.collect.af.l, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean retainAll(Collection<?> collection) {
                    return b.this.c(com.google.common.base.h0.h(com.google.common.base.h0.q(com.google.common.base.h0.n(collection)), wb.W()));
                }
            }

            /* JADX INFO: renamed from: com.google.common.collect.zj$d$b$b, reason: collision with other inner class name */
            class C0263b extends wb.t<xd<K>, V> {
                C0263b() {
                }

                @Override // com.google.common.collect.wb.t
                Map<xd<K>, V> g() {
                    return b.this;
                }

                @Override // com.google.common.collect.wb.t, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean isEmpty() {
                    return !iterator().hasNext();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public Iterator<Map.Entry<xd<K>, V>> iterator() {
                    return b.this.b();
                }

                @Override // com.google.common.collect.wb.t, com.google.common.collect.af.l, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean retainAll(Collection<?> collection) {
                    return b.this.c(com.google.common.base.h0.q(com.google.common.base.h0.n(collection)));
                }

                @Override // com.google.common.collect.wb.t, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return ua.Z(iterator());
                }
            }

            class c extends e<Map.Entry<xd<K>, V>> {

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ Iterator f21512c;

                c(Iterator it) {
                    this.f21512c = it;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.e
                /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
                public Map.Entry<xd<K>, V> a() {
                    while (this.f21512c.hasNext()) {
                        c cVar = (c) this.f21512c.next();
                        if (cVar.g().compareTo(d.this.f21504a.f21415b) >= 0) {
                            return (Map.Entry) b();
                        }
                        if (cVar.h().compareTo(d.this.f21504a.f21414a) > 0) {
                            return wb.T(cVar.getKey().u(d.this.f21504a), cVar.getValue());
                        }
                    }
                    return (Map.Entry) b();
                }
            }

            /* JADX INFO: renamed from: com.google.common.collect.zj$d$b$d, reason: collision with other inner class name */
            class C0264d extends wb.r0<xd<K>, V> {
                C0264d(Map map) {
                    super(map);
                }

                @Override // com.google.common.collect.wb.r0, java.util.AbstractCollection, java.util.Collection
                public boolean removeAll(Collection<?> collection) {
                    return b.this.c(com.google.common.base.h0.h(com.google.common.base.h0.n(collection), wb.Z0()));
                }

                @Override // com.google.common.collect.wb.r0, java.util.AbstractCollection, java.util.Collection
                public boolean retainAll(Collection<?> collection) {
                    return b.this.c(com.google.common.base.h0.h(com.google.common.base.h0.q(com.google.common.base.h0.n(collection)), wb.Z0()));
                }
            }

            b() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean c(com.google.common.base.g0<? super Map.Entry<xd<K>, V>> g0Var) {
                ArrayList arrayListQ = ib.q();
                for (Map.Entry<xd<K>, V> entry : entrySet()) {
                    if (g0Var.apply(entry)) {
                        arrayListQ.add(entry.getKey());
                    }
                }
                Iterator it = arrayListQ.iterator();
                while (it.hasNext()) {
                    zj.this.b((xd) it.next());
                }
                return !arrayListQ.isEmpty();
            }

            Iterator<Map.Entry<xd<K>, V>> b() {
                if (d.this.f21504a.w()) {
                    return ua.u();
                }
                return new c(zj.this.f21499a.tailMap((k4) com.google.common.base.x.a(zj.this.f21499a.floorKey(d.this.f21504a.f21414a), d.this.f21504a.f21414a), true).values().iterator());
            }

            @Override // java.util.AbstractMap, java.util.Map
            public void clear() {
                d.this.clear();
            }

            @Override // java.util.AbstractMap, java.util.Map
            public boolean containsKey(Object obj) {
                return get(obj) != null;
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Set<Map.Entry<xd<K>, V>> entrySet() {
                return new C0263b();
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // java.util.AbstractMap, java.util.Map
            public V get(Object obj) {
                c cVar;
                try {
                    if (obj instanceof xd) {
                        xd xdVar = (xd) obj;
                        if (d.this.f21504a.o(xdVar) && !xdVar.w()) {
                            if (xdVar.f21414a.compareTo(d.this.f21504a.f21414a) == 0) {
                                Map.Entry entryFloorEntry = zj.this.f21499a.floorEntry(xdVar.f21414a);
                                cVar = entryFloorEntry != null ? (c) entryFloorEntry.getValue() : null;
                            } else {
                                cVar = (c) zj.this.f21499a.get(xdVar.f21414a);
                            }
                            if (cVar != null && cVar.getKey().v(d.this.f21504a) && cVar.getKey().u(d.this.f21504a).equals(xdVar)) {
                                return (V) cVar.getValue();
                            }
                        }
                    }
                } catch (ClassCastException unused) {
                }
                return null;
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Set<xd<K>> keySet() {
                return new a(this);
            }

            @Override // java.util.AbstractMap, java.util.Map
            public V remove(Object obj) {
                V v7 = (V) get(obj);
                if (v7 == null) {
                    return null;
                }
                zj.this.b((xd) obj);
                return v7;
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Collection<V> values() {
                return new C0264d(this);
            }
        }

        d(xd<K> xdVar) {
            this.f21504a = xdVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.google.common.collect.zd
        public void b(xd<K> xdVar) {
            if (xdVar.v(this.f21504a)) {
                zj.this.b(xdVar.u(this.f21504a));
            }
        }

        @Override // com.google.common.collect.zd
        public xd<K> c() {
            k4 k4Var;
            Map.Entry entryFloorEntry = zj.this.f21499a.floorEntry(this.f21504a.f21414a);
            if (entryFloorEntry == null || ((c) entryFloorEntry.getValue()).h().compareTo(this.f21504a.f21414a) <= 0) {
                k4Var = (k4) zj.this.f21499a.ceilingKey(this.f21504a.f21414a);
                if (k4Var == null || k4Var.compareTo(this.f21504a.f21415b) >= 0) {
                    throw new NoSuchElementException();
                }
            } else {
                k4Var = this.f21504a.f21414a;
            }
            Map.Entry entryLowerEntry = zj.this.f21499a.lowerEntry(this.f21504a.f21415b);
            if (entryLowerEntry != null) {
                return xd.l(k4Var, ((c) entryLowerEntry.getValue()).h().compareTo(this.f21504a.f21415b) >= 0 ? this.f21504a.f21415b : ((c) entryLowerEntry.getValue()).h());
            }
            throw new NoSuchElementException();
        }

        @Override // com.google.common.collect.zd
        public void clear() {
            zj.this.b(this.f21504a);
        }

        @Override // com.google.common.collect.zd
        public Map.Entry<xd<K>, V> d(K k7) {
            Map.Entry<xd<K>, V> entryD;
            if (!this.f21504a.j(k7) || (entryD = zj.this.d(k7)) == null) {
                return null;
            }
            return wb.T(entryD.getKey().u(this.f21504a), entryD.getValue());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.google.common.collect.zd
        public zd<K, V> e(xd<K> xdVar) {
            return !xdVar.v(this.f21504a) ? zj.this.q() : zj.this.e(xdVar.u(this.f21504a));
        }

        @Override // com.google.common.collect.zd
        public boolean equals(Object obj) {
            if (obj instanceof zd) {
                return g().equals(((zd) obj).g());
            }
            return false;
        }

        @Override // com.google.common.collect.zd
        public Map<xd<K>, V> f() {
            return new a();
        }

        @Override // com.google.common.collect.zd
        public Map<xd<K>, V> g() {
            return new b();
        }

        @Override // com.google.common.collect.zd
        public V h(K k7) {
            if (this.f21504a.j(k7)) {
                return (V) zj.this.h(k7);
            }
            return null;
        }

        @Override // com.google.common.collect.zd
        public int hashCode() {
            return g().hashCode();
        }

        @Override // com.google.common.collect.zd
        public void i(zd<K, V> zdVar) {
            if (zdVar.g().isEmpty()) {
                return;
            }
            xd<K> xdVarC = zdVar.c();
            com.google.common.base.e0.y(this.f21504a.o(xdVarC), "Cannot putAll rangeMap with span %s into a subRangeMap(%s)", xdVarC, this.f21504a);
            zj.this.i(zdVar);
        }

        @Override // com.google.common.collect.zd
        public void j(xd<K> xdVar, V v7) {
            if (zj.this.f21499a.isEmpty() || xdVar.w() || !this.f21504a.o(xdVar)) {
                k(xdVar, v7);
            } else {
                k(zj.this.o(xdVar, com.google.common.base.e0.E(v7)).u(this.f21504a), v7);
            }
        }

        @Override // com.google.common.collect.zd
        public void k(xd<K> xdVar, V v7) {
            com.google.common.base.e0.y(this.f21504a.o(xdVar), "Cannot put range %s into a subRangeMap(%s)", xdVar, this.f21504a);
            zj.this.k(xdVar, v7);
        }

        @Override // com.google.common.collect.zd
        public String toString() {
            return g().toString();
        }
    }

    private zj() {
    }

    private static <K extends Comparable, V> xd<K> n(xd<K> xdVar, V v7, Map.Entry<k4<K>, c<K, V>> entry) {
        return (entry != null && entry.getValue().getKey().v(xdVar) && entry.getValue().getValue().equals(v7)) ? (xd<K>) xdVar.H(entry.getValue().getKey()) : xdVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public xd<K> o(xd<K> xdVar, V v7) {
        return n(n(xdVar, v7, this.f21499a.lowerEntry((k4<K>) xdVar.f21414a)), v7, this.f21499a.floorEntry((k4<K>) xdVar.f21415b));
    }

    public static <K extends Comparable, V> zj<K, V> p() {
        return new zj<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public zd<K, V> q() {
        return f21498b;
    }

    private void r(k4<K> k4Var, k4<K> k4Var2, V v7) {
        this.f21499a.put(k4Var, new c<>(k4Var, k4Var2, v7));
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.common.collect.zd
    public void b(xd<K> xdVar) {
        if (xdVar.w()) {
            return;
        }
        Map.Entry<k4<K>, c<K, V>> entryLowerEntry = this.f21499a.lowerEntry((k4<K>) xdVar.f21414a);
        if (entryLowerEntry != null) {
            c<K, V> value = entryLowerEntry.getValue();
            if (value.h().compareTo(xdVar.f21414a) > 0) {
                if (value.h().compareTo(xdVar.f21415b) > 0) {
                    r(xdVar.f21415b, value.h(), entryLowerEntry.getValue().getValue());
                }
                r(value.g(), xdVar.f21414a, entryLowerEntry.getValue().getValue());
            }
        }
        Map.Entry<k4<K>, c<K, V>> entryLowerEntry2 = this.f21499a.lowerEntry((k4<K>) xdVar.f21415b);
        if (entryLowerEntry2 != null) {
            c<K, V> value2 = entryLowerEntry2.getValue();
            if (value2.h().compareTo(xdVar.f21415b) > 0) {
                r(xdVar.f21415b, value2.h(), entryLowerEntry2.getValue().getValue());
            }
        }
        this.f21499a.subMap((k4<K>) xdVar.f21414a, (k4<K>) xdVar.f21415b).clear();
    }

    @Override // com.google.common.collect.zd
    public xd<K> c() {
        Map.Entry<k4<K>, c<K, V>> entryFirstEntry = this.f21499a.firstEntry();
        Map.Entry<k4<K>, c<K, V>> entryLastEntry = this.f21499a.lastEntry();
        if (entryFirstEntry != null) {
            return xd.l(entryFirstEntry.getValue().getKey().f21414a, entryLastEntry.getValue().getKey().f21415b);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.zd
    public void clear() {
        this.f21499a.clear();
    }

    @Override // com.google.common.collect.zd
    public Map.Entry<xd<K>, V> d(K k7) {
        Map.Entry<k4<K>, c<K, V>> entryFloorEntry = this.f21499a.floorEntry(k4.d(k7));
        if (entryFloorEntry == null || !entryFloorEntry.getValue().c(k7)) {
            return null;
        }
        return entryFloorEntry.getValue();
    }

    @Override // com.google.common.collect.zd
    public zd<K, V> e(xd<K> xdVar) {
        return xdVar.equals(xd.a()) ? this : new d(xdVar);
    }

    @Override // com.google.common.collect.zd
    public boolean equals(Object obj) {
        if (obj instanceof zd) {
            return g().equals(((zd) obj).g());
        }
        return false;
    }

    @Override // com.google.common.collect.zd
    public Map<xd<K>, V> f() {
        return new b(this.f21499a.descendingMap().values());
    }

    @Override // com.google.common.collect.zd
    public Map<xd<K>, V> g() {
        return new b(this.f21499a.values());
    }

    @Override // com.google.common.collect.zd
    public V h(K k7) {
        Map.Entry<xd<K>, V> entryD = d(k7);
        if (entryD == null) {
            return null;
        }
        return entryD.getValue();
    }

    @Override // com.google.common.collect.zd
    public int hashCode() {
        return g().hashCode();
    }

    @Override // com.google.common.collect.zd
    public void i(zd<K, V> zdVar) {
        for (Map.Entry<xd<K>, V> entry : zdVar.g().entrySet()) {
            k(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.zd
    public void j(xd<K> xdVar, V v7) {
        if (this.f21499a.isEmpty()) {
            k(xdVar, v7);
        } else {
            k(o(xdVar, com.google.common.base.e0.E(v7)), v7);
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.common.collect.zd
    public void k(xd<K> xdVar, V v7) {
        if (xdVar.w()) {
            return;
        }
        com.google.common.base.e0.E(v7);
        b(xdVar);
        this.f21499a.put((k4<K>) xdVar.f21414a, new c<>(xdVar, v7));
    }

    @Override // com.google.common.collect.zd
    public String toString() {
        return this.f21499a.values().toString();
    }
}
