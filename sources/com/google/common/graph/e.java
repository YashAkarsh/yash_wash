package com.google.common.graph;

import com.google.common.collect.af;
import com.google.common.collect.u8;
import com.google.common.collect.ua;
import com.google.common.collect.wb;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
public abstract class e<N, E> implements o0<N, E> {

    class a extends com.google.common.graph.c<N> {

        /* JADX INFO: renamed from: com.google.common.graph.e$a$a, reason: collision with other inner class name */
        class C0272a extends AbstractSet<t<N>> {

            /* JADX INFO: renamed from: com.google.common.graph.e$a$a$a, reason: collision with other inner class name */
            class C0273a implements com.google.common.base.s<E, t<N>> {
                C0273a() {
                }

                @Override // com.google.common.base.s, java.util.function.Function
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public t<N> apply(E e8) {
                    return e.this.w(e8);
                }
            }

            C0272a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof t)) {
                    return false;
                }
                t tVar = (t) obj;
                return a.this.f() == tVar.b() && a.this.l().contains(tVar.f()) && a.this.b(tVar.f()).contains(tVar.g());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<t<N>> iterator() {
                return ua.c0(e.this.d().iterator(), new C0273a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return e.this.d().size();
            }
        }

        a() {
        }

        @Override // com.google.common.graph.c, com.google.common.graph.a, com.google.common.graph.i
        public Set<t<N>> d() {
            return e.this.v() ? super.d() : new C0272a();
        }

        @Override // com.google.common.graph.i, com.google.common.graph.z
        public boolean f() {
            return e.this.f();
        }

        @Override // com.google.common.graph.i, com.google.common.graph.z
        public s<N> g() {
            return e.this.g();
        }

        @Override // com.google.common.graph.i, com.google.common.graph.z
        public boolean i() {
            return e.this.i();
        }

        @Override // com.google.common.graph.i, com.google.common.graph.z
        public Set<N> j(N n7) {
            return e.this.j(n7);
        }

        @Override // com.google.common.graph.i, com.google.common.graph.z
        public Set<N> l() {
            return e.this.l();
        }

        @Override // com.google.common.graph.c, com.google.common.graph.a, com.google.common.graph.i, com.google.common.graph.r0
        public Set<N> a(N n7) {
            return e.this.a((Object) n7);
        }

        @Override // com.google.common.graph.c, com.google.common.graph.a, com.google.common.graph.i, com.google.common.graph.s0
        public Set<N> b(N n7) {
            return e.this.b((Object) n7);
        }
    }

    class b implements com.google.common.base.g0<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f21617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f21618b;

        b(Object obj, Object obj2) {
            this.f21617a = obj;
            this.f21618b = obj2;
        }

        @Override // com.google.common.base.g0
        public boolean apply(E e8) {
            return e.this.w(e8).a(this.f21617a).equals(this.f21618b);
        }

        @Override // com.google.common.base.g0, java.util.function.Predicate
        public /* synthetic */ boolean test(Object obj) {
            return com.google.common.base.f0.a(this, obj);
        }
    }

    static class c implements com.google.common.base.s<E, t<N>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ o0 f21620a;

        c(o0 o0Var) {
            this.f21620a = o0Var;
        }

        @Override // com.google.common.base.s, java.util.function.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public t<N> apply(E e8) {
            return this.f21620a.w(e8);
        }
    }

    private com.google.common.base.g0<E> G(N n7, N n8) {
        return new b(n7, n8);
    }

    private static <N, E> Map<E, t<N>> H(o0<N, E> o0Var) {
        return wb.o(o0Var.d(), new c(o0Var));
    }

    @Override // com.google.common.graph.o0, com.google.common.graph.r0
    public /* bridge */ /* synthetic */ Iterable a(Object obj) {
        return a(obj);
    }

    @Override // com.google.common.graph.o0, com.google.common.graph.s0
    public /* bridge */ /* synthetic */ Iterable b(Object obj) {
        return b(obj);
    }

    @Override // com.google.common.graph.o0
    public int c(N n7) {
        return f() ? com.google.common.math.d.t(C(n7).size(), s(n7).size()) : com.google.common.math.d.t(k(n7).size(), u(n7, n7).size());
    }

    @Override // com.google.common.graph.o0
    public boolean e(N n7, N n8) {
        return !u(n7, n8).isEmpty();
    }

    @Override // com.google.common.graph.o0
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o0)) {
            return false;
        }
        o0 o0Var = (o0) obj;
        return f() == o0Var.f() && l().equals(o0Var.l()) && H(this).equals(H(o0Var));
    }

    @Override // com.google.common.graph.o0
    public int h(N n7) {
        return f() ? s(n7).size() : c(n7);
    }

    @Override // com.google.common.graph.o0
    public final int hashCode() {
        return H(this).hashCode();
    }

    @Override // com.google.common.graph.o0
    public int m(N n7) {
        return f() ? C(n7).size() : c(n7);
    }

    @Override // com.google.common.graph.o0
    public z<N> q() {
        return new a();
    }

    @Override // com.google.common.graph.o0
    public E r(N n7, N n8) {
        return (E) x(n7, n8).orElse(null);
    }

    @Override // com.google.common.graph.o0
    public Set<E> t(E e8) {
        t<N> tVarW = w(e8);
        return af.f(af.O(k(tVarW.f()), k(tVarW.g())), u8.B(e8));
    }

    public String toString() {
        return "isDirected: " + f() + ", allowsParallelEdges: " + v() + ", allowsSelfLoops: " + i() + ", nodes: " + l() + ", edges: " + H(this);
    }

    @Override // com.google.common.graph.o0
    public Set<E> u(N n7, N n8) {
        Set<E> setS = s(n7);
        Set<E> setC = C(n8);
        return setS.size() <= setC.size() ? Collections.unmodifiableSet(af.i(setS, G(n7, n8))) : Collections.unmodifiableSet(af.i(setC, G(n8, n7)));
    }

    @Override // com.google.common.graph.o0
    public Optional<E> x(N n7, N n8) {
        Set<E> setU = u(n7, n8);
        int size = setU.size();
        if (size == 0) {
            return Optional.empty();
        }
        if (size == 1) {
            return Optional.of(setU.iterator().next());
        }
        throw new IllegalArgumentException(String.format("Cannot call edgeConnecting() when parallel edges exist between %s and %s. Consider calling edgesConnecting() instead.", n7, n8));
    }
}
