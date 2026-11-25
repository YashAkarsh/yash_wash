package com.google.common.collect;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public class s8<K extends Comparable<?>, V> implements zd<K, V>, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final s8<Comparable<?>, Object> f21044c = new s8<>(d7.x(), d7.x());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f21045d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final transient d7<xd<K>> f21046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final transient d7<V> f21047b;

    class a extends d7<xd<K>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f21048c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f21049d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ xd f21050e;

        a(int i7, int i8, xd xdVar) {
            this.f21048c = i7;
            this.f21049d = i8;
            this.f21050e = xdVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
        public xd<K> get(int i7) {
            com.google.common.base.e0.C(i7, this.f21048c);
            return (i7 == 0 || i7 == this.f21048c + (-1)) ? ((xd) s8.this.f21046a.get(i7 + this.f21049d)).u(this.f21050e) : (xd) s8.this.f21046a.get(i7 + this.f21049d);
        }

        @Override // com.google.common.collect.x6
        boolean h() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f21048c;
        }
    }

    class b extends s8<K, V> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ xd f21052e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ s8 f21053f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(d7 d7Var, d7 d7Var2, xd xdVar, s8 s8Var) {
            super(d7Var, d7Var2);
            this.f21052e = xdVar;
            this.f21053f = s8Var;
        }

        @Override // com.google.common.collect.s8, com.google.common.collect.zd
        public /* bridge */ /* synthetic */ Map f() {
            return super.f();
        }

        @Override // com.google.common.collect.s8, com.google.common.collect.zd
        public /* bridge */ /* synthetic */ Map g() {
            return super.g();
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
        @Override // com.google.common.collect.s8, com.google.common.collect.zd
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public s8<K, V> e(xd<K> xdVar) {
            return this.f21052e.v(xdVar) ? this.f21053f.e(xdVar.u(this.f21052e)) : s8.p();
        }
    }

    public static final class c<K extends Comparable<?>, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<Map.Entry<xd<K>, V>> f21055a = ib.q();

        public s8<K, V> a() {
            Collections.sort(this.f21055a, xd.E().D());
            d7.b bVar = new d7.b(this.f21055a.size());
            d7.b bVar2 = new d7.b(this.f21055a.size());
            for (int i7 = 0; i7 < this.f21055a.size(); i7++) {
                xd<K> key = this.f21055a.get(i7).getKey();
                if (i7 > 0) {
                    xd<K> key2 = this.f21055a.get(i7 - 1).getKey();
                    if (key.v(key2) && !key.u(key2).w()) {
                        throw new IllegalArgumentException("Overlapping ranges: range " + key2 + " overlaps with entry " + key);
                    }
                }
                bVar.a(key);
                bVar2.a(this.f21055a.get(i7).getValue());
            }
            return new s8<>(bVar.e(), bVar2.e());
        }

        @u1.a
        c<K, V> b(c<K, V> cVar) {
            this.f21055a.addAll(cVar.f21055a);
            return this;
        }

        @u1.a
        public c<K, V> c(xd<K> xdVar, V v7) {
            com.google.common.base.e0.E(xdVar);
            com.google.common.base.e0.E(v7);
            com.google.common.base.e0.u(!xdVar.w(), "Range must not be empty, but was %s", xdVar);
            this.f21055a.add(wb.T(xdVar, v7));
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @u1.a
        public c<K, V> d(zd<K, ? extends V> zdVar) {
            for (Map.Entry entry : zdVar.g().entrySet()) {
                c((xd) entry.getKey(), entry.getValue());
            }
            return this;
        }
    }

    private static class d<K extends Comparable<?>, V> implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f21056b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final v7<xd<K>, V> f21057a;

        d(v7<xd<K>, V> v7Var) {
            this.f21057a = v7Var;
        }

        Object a() {
            c cVar = new c();
            ck<Map.Entry<xd<K>, V>> it = this.f21057a.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<xd<K>, V> next = it.next();
                cVar.c(next.getKey(), next.getValue());
            }
            return cVar.a();
        }

        Object readResolve() {
            return this.f21057a.isEmpty() ? s8.p() : a();
        }
    }

    s8(d7<xd<K>> d7Var, d7<V> d7Var2) {
        this.f21046a = d7Var;
        this.f21047b = d7Var2;
    }

    public static <K extends Comparable<?>, V> c<K, V> n() {
        return new c<>();
    }

    public static <K extends Comparable<?>, V> s8<K, V> o(zd<K, ? extends V> zdVar) {
        if (zdVar instanceof s8) {
            return (s8) zdVar;
        }
        Map<xd<K>, ? extends V> mapG = zdVar.g();
        d7.b bVar = new d7.b(mapG.size());
        d7.b bVar2 = new d7.b(mapG.size());
        for (Map.Entry entry : mapG.entrySet()) {
            bVar.a(entry.getKey());
            bVar2.a(entry.getValue());
        }
        return new s8<>(bVar.e(), bVar2.e());
    }

    public static <K extends Comparable<?>, V> s8<K, V> p() {
        return (s8<K, V>) f21044c;
    }

    public static <K extends Comparable<?>, V> s8<K, V> q(xd<K> xdVar, V v7) {
        return new s8<>(d7.z(xdVar), d7.z(v7));
    }

    @s1.a
    public static <T, K extends Comparable<? super K>, V> Collector<T, ?, s8<K, V>> t(Function<? super T, xd<K>> function, Function<? super T, ? extends V> function2) {
        return e2.p(function, function2);
    }

    @Override // com.google.common.collect.zd
    @Deprecated
    public void b(xd<K> xdVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.zd
    public xd<K> c() {
        if (this.f21046a.isEmpty()) {
            throw new NoSuchElementException();
        }
        xd<K> xdVar = this.f21046a.get(0);
        d7<xd<K>> d7Var = this.f21046a;
        return xd.l(xdVar.f21414a, d7Var.get(d7Var.size() - 1).f21415b);
    }

    @Override // com.google.common.collect.zd
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.zd
    public Map.Entry<xd<K>, V> d(K k7) {
        int iA = sf.a(this.f21046a, xd.y(), k4.d(k7), sf.c.f21074a, sf.b.f21070a);
        if (iA == -1) {
            return null;
        }
        xd<K> xdVar = this.f21046a.get(iA);
        if (xdVar.j(k7)) {
            return wb.T(xdVar, this.f21047b.get(iA));
        }
        return null;
    }

    @Override // com.google.common.collect.zd
    public boolean equals(Object obj) {
        if (obj instanceof zd) {
            return g().equals(((zd) obj).g());
        }
        return false;
    }

    @Override // com.google.common.collect.zd
    public V h(K k7) {
        int iA = sf.a(this.f21046a, xd.y(), k4.d(k7), sf.c.f21074a, sf.b.f21070a);
        if (iA != -1 && this.f21046a.get(iA).j(k7)) {
            return this.f21047b.get(iA);
        }
        return null;
    }

    @Override // com.google.common.collect.zd
    public int hashCode() {
        return g().hashCode();
    }

    @Override // com.google.common.collect.zd
    @Deprecated
    public void i(zd<K, V> zdVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.zd
    @Deprecated
    public void j(xd<K> xdVar, V v7) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.zd
    @Deprecated
    public void k(xd<K> xdVar, V v7) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.zd
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public v7<xd<K>, V> f() {
        return this.f21046a.isEmpty() ? v7.y() : new i9(new me(this.f21046a.O(), xd.E().F()), this.f21047b.O());
    }

    @Override // com.google.common.collect.zd
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public v7<xd<K>, V> g() {
        return this.f21046a.isEmpty() ? v7.y() : new i9(new me(this.f21046a, xd.E()), this.f21047b);
    }

    @Override // com.google.common.collect.zd
    /* JADX INFO: renamed from: r */
    public s8<K, V> e(xd<K> xdVar) {
        if (((xd) com.google.common.base.e0.E(xdVar)).w()) {
            return p();
        }
        if (this.f21046a.isEmpty() || xdVar.o(c())) {
            return this;
        }
        d7<xd<K>> d7Var = this.f21046a;
        com.google.common.base.s sVarK = xd.K();
        Comparable comparable = xdVar.f21414a;
        sf.c cVar = sf.c.f21077d;
        sf.b bVar = sf.b.f21071b;
        int iA = sf.a(d7Var, sVarK, comparable, cVar, bVar);
        int iA2 = sf.a(this.f21046a, xd.y(), xdVar.f21415b, sf.c.f21074a, bVar);
        return iA >= iA2 ? p() : new b(new a(iA2 - iA, iA, xdVar), this.f21047b.subList(iA, iA2), xdVar, this);
    }

    @Override // com.google.common.collect.zd
    public String toString() {
        return g().toString();
    }

    Object writeReplace() {
        return new d(g());
    }
}
