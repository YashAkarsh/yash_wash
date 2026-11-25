package com.google.common.collect;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public class ak<C extends Comparable<?>> extends a0<C> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @s1.d
    final NavigableMap<k4<C>, xd<C>> f19913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient Set<xd<C>> f19914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient Set<xd<C>> f19915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private transient be<C> f19916d;

    final class b extends j5<xd<C>> implements Set<xd<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Collection<xd<C>> f19917a;

        b(Collection<xd<C>> collection) {
            this.f19917a = collection;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.j5, com.google.common.collect.b6
        /* JADX INFO: renamed from: d0 */
        public Collection<xd<C>> c0() {
            return this.f19917a;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return af.g(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return af.k(this);
        }
    }

    private final class c extends ak<C> {
        c() {
            super(new d(ak.this.f19913a));
        }

        @Override // com.google.common.collect.ak, com.google.common.collect.a0, com.google.common.collect.be
        public boolean a(C c8) {
            return !ak.this.a(c8);
        }

        @Override // com.google.common.collect.ak, com.google.common.collect.a0, com.google.common.collect.be
        public void b(xd<C> xdVar) {
            ak.this.h(xdVar);
        }

        @Override // com.google.common.collect.ak, com.google.common.collect.a0, com.google.common.collect.be
        public void h(xd<C> xdVar) {
            ak.this.b(xdVar);
        }

        @Override // com.google.common.collect.ak, com.google.common.collect.be
        public be<C> i() {
            return ak.this;
        }
    }

    private static final class d<C extends Comparable<?>> extends z<k4<C>, xd<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final NavigableMap<k4<C>, xd<C>> f19920a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final NavigableMap<k4<C>, xd<C>> f19921b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final xd<k4<C>> f19922c;

        class a extends com.google.common.collect.e<Map.Entry<k4<C>, xd<C>>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            k4<C> f19923c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ k4 f19924d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ ud f19925e;

            a(k4 k4Var, ud udVar) {
                this.f19924d = k4Var;
                this.f19925e = udVar;
                this.f19923c = k4Var;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.e
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<k4<C>, xd<C>> a() {
                xd xdVarL;
                if (d.this.f19922c.f21415b.k(this.f19923c) || this.f19923c == k4.a()) {
                    return (Map.Entry) b();
                }
                if (this.f19925e.hasNext()) {
                    xd xdVar = (xd) this.f19925e.next();
                    xdVarL = xd.l(this.f19923c, xdVar.f21414a);
                    this.f19923c = xdVar.f21415b;
                } else {
                    xdVarL = xd.l(this.f19923c, k4.a());
                    this.f19923c = k4.a();
                }
                return wb.T(xdVarL.f21414a, xdVarL);
            }
        }

        class b extends com.google.common.collect.e<Map.Entry<k4<C>, xd<C>>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            k4<C> f19927c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ k4 f19928d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ ud f19929e;

            b(k4 k4Var, ud udVar) {
                this.f19928d = k4Var;
                this.f19929e = udVar;
                this.f19927c = k4Var;
            }

            /* JADX INFO: Access modifiers changed from: protected */
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
            @Override // com.google.common.collect.e
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<k4<C>, xd<C>> a() {
                if (this.f19927c == k4.c()) {
                    return (Map.Entry) b();
                }
                if (this.f19929e.hasNext()) {
                    xd xdVar = (xd) this.f19929e.next();
                    xd xdVarL = xd.l(xdVar.f21415b, this.f19927c);
                    this.f19927c = xdVar.f21414a;
                    if (d.this.f19922c.f21414a.k(xdVarL.f21414a)) {
                        return wb.T(xdVarL.f21414a, xdVarL);
                    }
                } else if (d.this.f19922c.f21414a.k(k4.c())) {
                    xd xdVarL2 = xd.l(k4.c(), this.f19927c);
                    this.f19927c = k4.c();
                    return wb.T(k4.c(), xdVarL2);
                }
                return (Map.Entry) b();
            }
        }

        d(NavigableMap<k4<C>, xd<C>> navigableMap) {
            this(navigableMap, xd.a());
        }

        private NavigableMap<k4<C>, xd<C>> k(xd<k4<C>> xdVar) {
            if (!this.f19922c.v(xdVar)) {
                return i9.s0();
            }
            return new d(this.f19920a, xdVar.u(this.f19922c));
        }

        @Override // com.google.common.collect.wb.b0
        Iterator<Map.Entry<k4<C>, xd<C>>> a() {
            Collection<xd<C>> collectionValues;
            k4 k4VarC;
            if (this.f19922c.r()) {
                collectionValues = this.f19921b.tailMap((k4<C>) this.f19922c.A(), this.f19922c.z() == s0.CLOSED).values();
            } else {
                collectionValues = this.f19921b.values();
            }
            ud udVarT = ua.T(collectionValues.iterator());
            if (this.f19922c.j(k4.c()) && (!udVarT.hasNext() || ((xd) udVarT.peek()).f21414a != k4.c())) {
                k4VarC = k4.c();
            } else {
                if (!udVarT.hasNext()) {
                    return ua.u();
                }
                k4VarC = ((xd) udVarT.next()).f21415b;
            }
            return new a(k4VarC, udVarT);
        }

        @Override // java.util.SortedMap
        public Comparator<? super k4<C>> comparator() {
            return td.A();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        @Override // com.google.common.collect.z
        Iterator<Map.Entry<k4<C>, xd<C>>> d() {
            k4<C> k4VarHigherKey;
            ud udVarT = ua.T(this.f19921b.headMap(this.f19922c.t() ? (k4) this.f19922c.M() : k4.a(), this.f19922c.t() && this.f19922c.L() == s0.CLOSED).descendingMap().values().iterator());
            if (udVarT.hasNext()) {
                k4VarHigherKey = ((xd) udVarT.peek()).f21415b == k4.a() ? ((xd) udVarT.next()).f21414a : this.f19920a.higherKey(((xd) udVarT.peek()).f21415b);
            } else {
                if (!this.f19922c.j(k4.c()) || this.f19920a.containsKey(k4.c())) {
                    return ua.u();
                }
                k4VarHigherKey = this.f19920a.higherKey(k4.c());
            }
            return new b((k4) com.google.common.base.x.a(k4VarHigherKey, k4.a()), udVarT);
        }

        @Override // com.google.common.collect.z, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public xd<C> get(Object obj) {
            if (obj instanceof k4) {
                try {
                    k4<C> k4Var = (k4) obj;
                    Map.Entry<k4<C>, xd<C>> entryFirstEntry = tailMap(k4Var, true).firstEntry();
                    if (entryFirstEntry != null && entryFirstEntry.getKey().equals(k4Var)) {
                        return entryFirstEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public NavigableMap<k4<C>, xd<C>> headMap(k4<C> k4Var, boolean z7) {
            return k(xd.J(k4Var, s0.b(z7)));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public NavigableMap<k4<C>, xd<C>> subMap(k4<C> k4Var, boolean z7, k4<C> k4Var2, boolean z8) {
            return k(xd.D(k4Var, s0.b(z7), k4Var2, s0.b(z8)));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public NavigableMap<k4<C>, xd<C>> tailMap(k4<C> k4Var, boolean z7) {
            return k(xd.m(k4Var, s0.b(z7)));
        }

        @Override // com.google.common.collect.wb.b0, java.util.AbstractMap, java.util.Map
        public int size() {
            return ua.Z(a());
        }

        private d(NavigableMap<k4<C>, xd<C>> navigableMap, xd<k4<C>> xdVar) {
            this.f19920a = navigableMap;
            this.f19921b = new e(navigableMap);
            this.f19922c = xdVar;
        }
    }

    private final class f extends ak<C> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final xd<C> f19937e;

        /* JADX WARN: Illegal instructions before constructor call */
        f(xd<C> xdVar) {
            super(new g(xd.a(), xdVar, ak.this.f19913a));
            this.f19937e = xdVar;
        }

        @Override // com.google.common.collect.ak, com.google.common.collect.a0, com.google.common.collect.be
        public boolean a(C c8) {
            return this.f19937e.j(c8) && ak.this.a(c8);
        }

        @Override // com.google.common.collect.ak, com.google.common.collect.a0, com.google.common.collect.be
        public void b(xd<C> xdVar) {
            if (xdVar.v(this.f19937e)) {
                ak.this.b(xdVar.u(this.f19937e));
            }
        }

        @Override // com.google.common.collect.ak, com.google.common.collect.a0, com.google.common.collect.be
        public void clear() {
            ak.this.b(this.f19937e);
        }

        @Override // com.google.common.collect.ak, com.google.common.collect.a0, com.google.common.collect.be
        public void h(xd<C> xdVar) {
            com.google.common.base.e0.y(this.f19937e.o(xdVar), "Cannot add range %s to subRangeSet(%s)", xdVar, this.f19937e);
            super.h(xdVar);
        }

        @Override // com.google.common.collect.ak, com.google.common.collect.a0, com.google.common.collect.be
        public xd<C> j(C c8) {
            xd<C> xdVarJ;
            if (this.f19937e.j(c8) && (xdVarJ = ak.this.j(c8)) != null) {
                return xdVarJ.u(this.f19937e);
            }
            return null;
        }

        @Override // com.google.common.collect.ak, com.google.common.collect.a0, com.google.common.collect.be
        public boolean k(xd<C> xdVar) {
            xd xdVarW;
            return (this.f19937e.w() || !this.f19937e.o(xdVar) || (xdVarW = ak.this.w(xdVar)) == null || xdVarW.u(this.f19937e).w()) ? false : true;
        }

        @Override // com.google.common.collect.ak, com.google.common.collect.be
        public be<C> m(xd<C> xdVar) {
            if (xdVar.o(this.f19937e)) {
                return this;
            }
            return xdVar.v(this.f19937e) ? new f(this.f19937e.u(xdVar)) : t8.F();
        }
    }

    private static final class g<C extends Comparable<?>> extends z<k4<C>, xd<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final xd<k4<C>> f19939a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final xd<C> f19940b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final NavigableMap<k4<C>, xd<C>> f19941c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final NavigableMap<k4<C>, xd<C>> f19942d;

        class a extends com.google.common.collect.e<Map.Entry<k4<C>, xd<C>>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Iterator f19943c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ k4 f19944d;

            a(Iterator it, k4 k4Var) {
                this.f19943c = it;
                this.f19944d = k4Var;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.e
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<k4<C>, xd<C>> a() {
                if (!this.f19943c.hasNext()) {
                    return (Map.Entry) b();
                }
                xd xdVar = (xd) this.f19943c.next();
                if (this.f19944d.k(xdVar.f21414a)) {
                    return (Map.Entry) b();
                }
                xd xdVarU = xdVar.u(g.this.f19940b);
                return wb.T(xdVarU.f21414a, xdVarU);
            }
        }

        class b extends com.google.common.collect.e<Map.Entry<k4<C>, xd<C>>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Iterator f19946c;

            b(Iterator it) {
                this.f19946c = it;
            }

            /* JADX INFO: Access modifiers changed from: protected */
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
            @Override // com.google.common.collect.e
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<k4<C>, xd<C>> a() {
                if (!this.f19946c.hasNext()) {
                    return (Map.Entry) b();
                }
                xd xdVar = (xd) this.f19946c.next();
                if (g.this.f19940b.f21414a.compareTo(xdVar.f21415b) >= 0) {
                    return (Map.Entry) b();
                }
                xd xdVarU = xdVar.u(g.this.f19940b);
                return g.this.f19939a.j(xdVarU.f21414a) ? wb.T(xdVarU.f21414a, xdVarU) : (Map.Entry) b();
            }
        }

        private NavigableMap<k4<C>, xd<C>> l(xd<k4<C>> xdVar) {
            return !xdVar.v(this.f19939a) ? i9.s0() : new g(this.f19939a.u(xdVar), this.f19940b, this.f19941c);
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
        @Override // com.google.common.collect.wb.b0
        Iterator<Map.Entry<k4<C>, xd<C>>> a() {
            Iterator<xd<C>> it;
            if (this.f19940b.w()) {
                return ua.u();
            }
            if (this.f19939a.f21415b.k(this.f19940b.f21414a)) {
                return ua.u();
            }
            if (this.f19939a.f21414a.k(this.f19940b.f21414a)) {
                it = this.f19942d.tailMap(this.f19940b.f21414a, false).values().iterator();
            } else {
                it = this.f19941c.tailMap(this.f19939a.f21414a.i(), this.f19939a.z() == s0.CLOSED).values().iterator();
            }
            return new a(it, (k4) td.A().x(this.f19939a.f21415b, k4.d(this.f19940b.f21415b)));
        }

        @Override // java.util.SortedMap
        public Comparator<? super k4<C>> comparator() {
            return td.A();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // com.google.common.collect.z
        Iterator<Map.Entry<k4<C>, xd<C>>> d() {
            if (this.f19940b.w()) {
                return ua.u();
            }
            k4 k4Var = (k4) td.A().x(this.f19939a.f21415b, k4.d(this.f19940b.f21415b));
            return new b(this.f19941c.headMap((k4<C>) k4Var.i(), k4Var.n() == s0.CLOSED).descendingMap().values().iterator());
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
        @Override // com.google.common.collect.z, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public xd<C> get(Object obj) {
            if (obj instanceof k4) {
                try {
                    k4<C> k4Var = (k4) obj;
                    if (this.f19939a.j(k4Var) && k4Var.compareTo(this.f19940b.f21414a) >= 0 && k4Var.compareTo(this.f19940b.f21415b) < 0) {
                        if (k4Var.equals(this.f19940b.f21414a)) {
                            xd xdVar = (xd) wb.b1(this.f19941c.floorEntry(k4Var));
                            if (xdVar != null && xdVar.f21415b.compareTo(this.f19940b.f21414a) > 0) {
                                return xdVar.u(this.f19940b);
                            }
                        } else {
                            xd<C> xdVar2 = this.f19941c.get(k4Var);
                            if (xdVar2 != null) {
                                return xdVar2.u(this.f19940b);
                            }
                        }
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public NavigableMap<k4<C>, xd<C>> headMap(k4<C> k4Var, boolean z7) {
            return l(xd.J(k4Var, s0.b(z7)));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public NavigableMap<k4<C>, xd<C>> subMap(k4<C> k4Var, boolean z7, k4<C> k4Var2, boolean z8) {
            return l(xd.D(k4Var, s0.b(z7), k4Var2, s0.b(z8)));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public NavigableMap<k4<C>, xd<C>> tailMap(k4<C> k4Var, boolean z7) {
            return l(xd.m(k4Var, s0.b(z7)));
        }

        @Override // com.google.common.collect.wb.b0, java.util.AbstractMap, java.util.Map
        public int size() {
            return ua.Z(a());
        }

        private g(xd<k4<C>> xdVar, xd<C> xdVar2, NavigableMap<k4<C>, xd<C>> navigableMap) {
            this.f19939a = (xd) com.google.common.base.e0.E(xdVar);
            this.f19940b = (xd) com.google.common.base.e0.E(xdVar2);
            this.f19941c = (NavigableMap) com.google.common.base.e0.E(navigableMap);
            this.f19942d = new e(navigableMap);
        }
    }

    public static <C extends Comparable<?>> ak<C> t() {
        return new ak<>(new TreeMap());
    }

    public static <C extends Comparable<?>> ak<C> u(be<C> beVar) {
        ak<C> akVarT = t();
        akVarT.e(beVar);
        return akVarT;
    }

    public static <C extends Comparable<?>> ak<C> v(Iterable<xd<C>> iterable) {
        ak<C> akVarT = t();
        akVarT.d(iterable);
        return akVarT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public xd<C> w(xd<C> xdVar) {
        com.google.common.base.e0.E(xdVar);
        Map.Entry<k4<C>, xd<C>> entryFloorEntry = this.f19913a.floorEntry(xdVar.f21414a);
        if (entryFloorEntry == null || !entryFloorEntry.getValue().o(xdVar)) {
            return null;
        }
        return entryFloorEntry.getValue();
    }

    private void x(xd<C> xdVar) {
        if (xdVar.w()) {
            this.f19913a.remove(xdVar.f21414a);
        } else {
            this.f19913a.put(xdVar.f21414a, xdVar);
        }
    }

    @Override // com.google.common.collect.a0, com.google.common.collect.be
    public /* bridge */ /* synthetic */ boolean a(Comparable comparable) {
        return super.a(comparable);
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
    @Override // com.google.common.collect.a0, com.google.common.collect.be
    public void b(xd<C> xdVar) {
        com.google.common.base.e0.E(xdVar);
        if (xdVar.w()) {
            return;
        }
        Map.Entry<k4<C>, xd<C>> entryLowerEntry = this.f19913a.lowerEntry(xdVar.f21414a);
        if (entryLowerEntry != null) {
            xd<C> value = entryLowerEntry.getValue();
            if (value.f21415b.compareTo(xdVar.f21414a) >= 0) {
                if (xdVar.t() && value.f21415b.compareTo(xdVar.f21415b) >= 0) {
                    x(xd.l(xdVar.f21415b, value.f21415b));
                }
                x(xd.l(value.f21414a, xdVar.f21414a));
            }
        }
        Map.Entry<k4<C>, xd<C>> entryFloorEntry = this.f19913a.floorEntry(xdVar.f21415b);
        if (entryFloorEntry != null) {
            xd<C> value2 = entryFloorEntry.getValue();
            if (xdVar.t() && value2.f21415b.compareTo(xdVar.f21415b) >= 0) {
                x(xd.l(xdVar.f21415b, value2.f21415b));
            }
        }
        this.f19913a.subMap(xdVar.f21414a, xdVar.f21415b).clear();
    }

    @Override // com.google.common.collect.be
    public xd<C> c() {
        Map.Entry<k4<C>, xd<C>> entryFirstEntry = this.f19913a.firstEntry();
        Map.Entry<k4<C>, xd<C>> entryLastEntry = this.f19913a.lastEntry();
        if (entryFirstEntry != null) {
            return xd.l(entryFirstEntry.getValue().f21414a, entryLastEntry.getValue().f21415b);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.a0, com.google.common.collect.be
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.a0, com.google.common.collect.be
    public /* bridge */ /* synthetic */ void e(be beVar) {
        super.e(beVar);
    }

    @Override // com.google.common.collect.a0, com.google.common.collect.be
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.a0, com.google.common.collect.be
    public /* bridge */ /* synthetic */ boolean g(be beVar) {
        return super.g(beVar);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.common.collect.a0, com.google.common.collect.be
    public void h(xd<C> xdVar) {
        com.google.common.base.e0.E(xdVar);
        if (xdVar.w()) {
            return;
        }
        k4<C> k4Var = xdVar.f21414a;
        k4<C> k4Var2 = xdVar.f21415b;
        Map.Entry<k4<C>, xd<C>> entryLowerEntry = this.f19913a.lowerEntry(k4Var);
        if (entryLowerEntry != null) {
            xd<C> value = entryLowerEntry.getValue();
            if (value.f21415b.compareTo(k4Var) >= 0) {
                if (value.f21415b.compareTo(k4Var2) >= 0) {
                    k4Var2 = value.f21415b;
                }
                k4Var = value.f21414a;
            }
        }
        Map.Entry<k4<C>, xd<C>> entryFloorEntry = this.f19913a.floorEntry(k4Var2);
        if (entryFloorEntry != null) {
            xd<C> value2 = entryFloorEntry.getValue();
            if (value2.f21415b.compareTo(k4Var2) >= 0) {
                k4Var2 = value2.f21415b;
            }
        }
        this.f19913a.subMap(k4Var, k4Var2).clear();
        x(xd.l(k4Var, k4Var2));
    }

    @Override // com.google.common.collect.be
    public be<C> i() {
        be<C> beVar = this.f19916d;
        if (beVar != null) {
            return beVar;
        }
        c cVar = new c();
        this.f19916d = cVar;
        return cVar;
    }

    @Override // com.google.common.collect.a0, com.google.common.collect.be
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.a0, com.google.common.collect.be
    public xd<C> j(C c8) {
        com.google.common.base.e0.E(c8);
        Map.Entry<k4<C>, xd<C>> entryFloorEntry = this.f19913a.floorEntry(k4.d(c8));
        if (entryFloorEntry == null || !entryFloorEntry.getValue().j(c8)) {
            return null;
        }
        return entryFloorEntry.getValue();
    }

    @Override // com.google.common.collect.a0, com.google.common.collect.be
    public boolean k(xd<C> xdVar) {
        com.google.common.base.e0.E(xdVar);
        Map.Entry<k4<C>, xd<C>> entryFloorEntry = this.f19913a.floorEntry(xdVar.f21414a);
        return entryFloorEntry != null && entryFloorEntry.getValue().o(xdVar);
    }

    @Override // com.google.common.collect.be
    public be<C> m(xd<C> xdVar) {
        return xdVar.equals(xd.a()) ? this : new f(xdVar);
    }

    @Override // com.google.common.collect.be
    public Set<xd<C>> n() {
        Set<xd<C>> set = this.f19915c;
        if (set != null) {
            return set;
        }
        b bVar = new b(this.f19913a.descendingMap().values());
        this.f19915c = bVar;
        return bVar;
    }

    @Override // com.google.common.collect.be
    public Set<xd<C>> o() {
        Set<xd<C>> set = this.f19914b;
        if (set != null) {
            return set;
        }
        b bVar = new b(this.f19913a.values());
        this.f19914b = bVar;
        return bVar;
    }

    @Override // com.google.common.collect.a0, com.google.common.collect.be
    public /* bridge */ /* synthetic */ void p(be beVar) {
        super.p(beVar);
    }

    @Override // com.google.common.collect.a0, com.google.common.collect.be
    public boolean q(xd<C> xdVar) {
        com.google.common.base.e0.E(xdVar);
        Map.Entry<k4<C>, xd<C>> entryCeilingEntry = this.f19913a.ceilingEntry(xdVar.f21414a);
        if (entryCeilingEntry != null && entryCeilingEntry.getValue().v(xdVar) && !entryCeilingEntry.getValue().u(xdVar).w()) {
            return true;
        }
        Map.Entry<k4<C>, xd<C>> entryLowerEntry = this.f19913a.lowerEntry(xdVar.f21414a);
        return (entryLowerEntry == null || !entryLowerEntry.getValue().v(xdVar) || entryLowerEntry.getValue().u(xdVar).w()) ? false : true;
    }

    private ak(NavigableMap<k4<C>, xd<C>> navigableMap) {
        this.f19913a = navigableMap;
    }

    @s1.d
    static final class e<C extends Comparable<?>> extends z<k4<C>, xd<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final NavigableMap<k4<C>, xd<C>> f19931a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final xd<k4<C>> f19932b;

        class a extends com.google.common.collect.e<Map.Entry<k4<C>, xd<C>>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Iterator f19933c;

            a(Iterator it) {
                this.f19933c = it;
            }

            /* JADX INFO: Access modifiers changed from: protected */
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
            @Override // com.google.common.collect.e
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<k4<C>, xd<C>> a() {
                if (!this.f19933c.hasNext()) {
                    return (Map.Entry) b();
                }
                xd xdVar = (xd) this.f19933c.next();
                return e.this.f19932b.f21415b.k(xdVar.f21415b) ? (Map.Entry) b() : wb.T(xdVar.f21415b, xdVar);
            }
        }

        class b extends com.google.common.collect.e<Map.Entry<k4<C>, xd<C>>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ ud f19935c;

            b(ud udVar) {
                this.f19935c = udVar;
            }

            /* JADX INFO: Access modifiers changed from: protected */
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
            @Override // com.google.common.collect.e
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<k4<C>, xd<C>> a() {
                if (!this.f19935c.hasNext()) {
                    return (Map.Entry) b();
                }
                xd xdVar = (xd) this.f19935c.next();
                return e.this.f19932b.f21414a.k(xdVar.f21415b) ? wb.T(xdVar.f21415b, xdVar) : (Map.Entry) b();
            }
        }

        e(NavigableMap<k4<C>, xd<C>> navigableMap) {
            this.f19931a = navigableMap;
            this.f19932b = xd.a();
        }

        private NavigableMap<k4<C>, xd<C>> k(xd<k4<C>> xdVar) {
            return xdVar.v(this.f19932b) ? new e(this.f19931a, xdVar.u(this.f19932b)) : i9.s0();
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
        @Override // com.google.common.collect.wb.b0
        Iterator<Map.Entry<k4<C>, xd<C>>> a() {
            Map.Entry entryLowerEntry;
            Iterator<xd<C>> it;
            if (this.f19932b.r() && (entryLowerEntry = this.f19931a.lowerEntry((k4<C>) this.f19932b.A())) != null) {
                it = this.f19932b.f21414a.k(((xd) entryLowerEntry.getValue()).f21415b) ? this.f19931a.tailMap(entryLowerEntry.getKey(), true).values().iterator() : this.f19931a.tailMap(this.f19932b.A(), true).values().iterator();
            } else {
                it = this.f19931a.values().iterator();
            }
            return new a(it);
        }

        @Override // java.util.SortedMap
        public Comparator<? super k4<C>> comparator() {
            return td.A();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
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
        @Override // com.google.common.collect.z
        Iterator<Map.Entry<k4<C>, xd<C>>> d() {
            ud udVarT = ua.T((this.f19932b.t() ? this.f19931a.headMap(this.f19932b.M(), false).descendingMap().values() : this.f19931a.descendingMap().values()).iterator());
            if (udVarT.hasNext() && this.f19932b.f21415b.k(((xd) udVarT.peek()).f21415b)) {
                udVarT.next();
            }
            return new b(udVarT);
        }

        @Override // com.google.common.collect.z, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public xd<C> get(Object obj) {
            Map.Entry<k4<C>, xd<C>> entryLowerEntry;
            if (obj instanceof k4) {
                try {
                    k4<C> k4Var = (k4) obj;
                    if (this.f19932b.j(k4Var) && (entryLowerEntry = this.f19931a.lowerEntry(k4Var)) != null && entryLowerEntry.getValue().f21415b.equals(k4Var)) {
                        return entryLowerEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public NavigableMap<k4<C>, xd<C>> headMap(k4<C> k4Var, boolean z7) {
            return k(xd.J(k4Var, s0.b(z7)));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public NavigableMap<k4<C>, xd<C>> subMap(k4<C> k4Var, boolean z7, k4<C> k4Var2, boolean z8) {
            return k(xd.D(k4Var, s0.b(z7), k4Var2, s0.b(z8)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            if (this.f19932b.equals(xd.a())) {
                return this.f19931a.isEmpty();
            }
            return !a().hasNext();
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public NavigableMap<k4<C>, xd<C>> tailMap(k4<C> k4Var, boolean z7) {
            return k(xd.m(k4Var, s0.b(z7)));
        }

        @Override // com.google.common.collect.wb.b0, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f19932b.equals(xd.a()) ? this.f19931a.size() : ua.Z(a());
        }

        private e(NavigableMap<k4<C>, xd<C>> navigableMap, xd<k4<C>> xdVar) {
            this.f19931a = navigableMap;
            this.f19932b = xdVar;
        }
    }
}
