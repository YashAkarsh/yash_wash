package com.google.common.graph;

import com.google.common.collect.ma;
import com.google.common.collect.wb;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
public final class d0 {

    private enum a {
        PENDING,
        COMPLETE
    }

    private static class b<N> extends v<N> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final z<N> f21611a;

        b(z<N> zVar) {
            this.f21611a = zVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.graph.v
        /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
        public z<N> H() {
            return this.f21611a;
        }

        @Override // com.google.common.graph.v, com.google.common.graph.c, com.google.common.graph.a, com.google.common.graph.i
        public boolean e(N n7, N n8) {
            return H().e(n8, n7);
        }

        @Override // com.google.common.graph.v, com.google.common.graph.c, com.google.common.graph.a, com.google.common.graph.i
        public int h(N n7) {
            return H().m(n7);
        }

        @Override // com.google.common.graph.v, com.google.common.graph.c, com.google.common.graph.a, com.google.common.graph.i
        public int m(N n7) {
            return H().h(n7);
        }

        @Override // com.google.common.graph.v, com.google.common.graph.c, com.google.common.graph.a, com.google.common.graph.i, com.google.common.graph.r0
        public Set<N> a(N n7) {
            return H().b((Object) n7);
        }

        @Override // com.google.common.graph.v, com.google.common.graph.c, com.google.common.graph.a, com.google.common.graph.i, com.google.common.graph.s0
        public Set<N> b(N n7) {
            return H().a((Object) n7);
        }
    }

    private static class c<N, E> extends w<N, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final o0<N, E> f21612a;

        c(o0<N, E> o0Var) {
            this.f21612a = o0Var;
        }

        @Override // com.google.common.graph.w, com.google.common.graph.o0
        public Set<E> C(N n7) {
            return I().s(n7);
        }

        @Override // com.google.common.graph.w
        protected o0<N, E> I() {
            return this.f21612a;
        }

        @Override // com.google.common.graph.w, com.google.common.graph.e, com.google.common.graph.o0
        public boolean e(N n7, N n8) {
            return I().e(n8, n7);
        }

        @Override // com.google.common.graph.w, com.google.common.graph.e, com.google.common.graph.o0
        public int h(N n7) {
            return I().m(n7);
        }

        @Override // com.google.common.graph.w, com.google.common.graph.e, com.google.common.graph.o0
        public int m(N n7) {
            return I().h(n7);
        }

        @Override // com.google.common.graph.w, com.google.common.graph.e, com.google.common.graph.o0
        public E r(N n7, N n8) {
            return I().r(n8, n7);
        }

        @Override // com.google.common.graph.w, com.google.common.graph.o0
        public Set<E> s(N n7) {
            return I().C(n7);
        }

        @Override // com.google.common.graph.w, com.google.common.graph.e, com.google.common.graph.o0
        public Set<E> u(N n7, N n8) {
            return I().u(n8, n7);
        }

        @Override // com.google.common.graph.w, com.google.common.graph.o0
        public t<N> w(E e8) {
            t<N> tVarW = I().w(e8);
            return t.j(this.f21612a, tVarW.g(), tVarW.f());
        }

        @Override // com.google.common.graph.w, com.google.common.graph.e, com.google.common.graph.o0
        public Optional<E> x(N n7, N n8) {
            return I().x(n8, n7);
        }

        @Override // com.google.common.graph.w, com.google.common.graph.e, com.google.common.graph.o0, com.google.common.graph.r0
        public Set<N> a(N n7) {
            return I().b((Object) n7);
        }

        @Override // com.google.common.graph.w, com.google.common.graph.e, com.google.common.graph.o0, com.google.common.graph.s0
        public Set<N> b(N n7) {
            return I().a((Object) n7);
        }
    }

    private static class d<N, V> extends x<N, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final y0<N, V> f21613a;

        d(y0<N, V> y0Var) {
            this.f21613a = y0Var;
        }

        @Override // com.google.common.graph.x, com.google.common.graph.g, com.google.common.graph.y0
        public Optional<V> E(N n7, N n8) {
            return I().E(n8, n7);
        }

        @Override // com.google.common.graph.x
        protected y0<N, V> I() {
            return this.f21613a;
        }

        @Override // com.google.common.graph.x, com.google.common.graph.g, com.google.common.graph.a, com.google.common.graph.i
        public boolean e(N n7, N n8) {
            return I().e(n8, n7);
        }

        @Override // com.google.common.graph.x, com.google.common.graph.g, com.google.common.graph.a, com.google.common.graph.i
        public int h(N n7) {
            return I().m(n7);
        }

        @Override // com.google.common.graph.x, com.google.common.graph.g, com.google.common.graph.a, com.google.common.graph.i
        public int m(N n7) {
            return I().h(n7);
        }

        @Override // com.google.common.graph.x, com.google.common.graph.y0
        public V y(N n7, N n8, V v7) {
            return I().y(n8, n7, v7);
        }

        @Override // com.google.common.graph.x, com.google.common.graph.g, com.google.common.graph.a, com.google.common.graph.i, com.google.common.graph.r0
        public Set<N> a(N n7) {
            return I().b((Object) n7);
        }

        @Override // com.google.common.graph.x, com.google.common.graph.g, com.google.common.graph.a, com.google.common.graph.i, com.google.common.graph.s0
        public Set<N> b(N n7) {
            return I().a((Object) n7);
        }
    }

    private d0() {
    }

    private static boolean a(z<?> zVar, Object obj, Object obj2) {
        return zVar.f() || !com.google.common.base.y.a(obj2, obj);
    }

    @u1.a
    static int b(int i7) {
        com.google.common.base.e0.k(i7 >= 0, "Not true that %s is non-negative.", i7);
        return i7;
    }

    @u1.a
    static long c(long j7) {
        com.google.common.base.e0.p(j7 >= 0, "Not true that %s is non-negative.", j7);
        return j7;
    }

    @u1.a
    static int d(int i7) {
        com.google.common.base.e0.k(i7 > 0, "Not true that %s is positive.", i7);
        return i7;
    }

    @u1.a
    static long e(long j7) {
        com.google.common.base.e0.p(j7 > 0, "Not true that %s is positive.", j7);
        return j7;
    }

    public static <N> k0<N> f(z<N> zVar) {
        k0<N> k0Var = (k0<N>) a0.f(zVar).e(zVar.l().size()).b();
        Iterator<N> it = zVar.l().iterator();
        while (it.hasNext()) {
            k0Var.n(it.next());
        }
        for (t<N> tVar : zVar.d()) {
            k0Var.z(tVar.f(), tVar.g());
        }
        return k0Var;
    }

    public static <N, E> l0<N, E> g(o0<N, E> o0Var) {
        l0<N, E> l0Var = (l0<N, E>) p0.i(o0Var).h(o0Var.l().size()).g(o0Var.d().size()).c();
        Iterator<N> it = o0Var.l().iterator();
        while (it.hasNext()) {
            l0Var.n(it.next());
        }
        for (E e8 : o0Var.d()) {
            t<N> tVarW = o0Var.w(e8);
            l0Var.F(tVarW.f(), tVarW.g(), e8);
        }
        return l0Var;
    }

    public static <N, V> m0<N, V> h(y0<N, V> y0Var) {
        m0<N, V> m0Var = (m0<N, V>) z0.f(y0Var).e(y0Var.l().size()).b();
        Iterator<N> it = y0Var.l().iterator();
        while (it.hasNext()) {
            m0Var.n(it.next());
        }
        for (t<N> tVar : y0Var.d()) {
            m0Var.D(tVar.f(), tVar.g(), y0Var.y(tVar.f(), tVar.g(), null));
        }
        return m0Var;
    }

    public static <N> boolean i(z<N> zVar) {
        int size = zVar.d().size();
        if (size == 0) {
            return false;
        }
        if (!zVar.f() && size >= zVar.l().size()) {
            return true;
        }
        HashMap mapK0 = wb.k0(zVar.l().size());
        Iterator<N> it = zVar.l().iterator();
        while (it.hasNext()) {
            if (o(zVar, mapK0, it.next(), null)) {
                return true;
            }
        }
        return false;
    }

    public static boolean j(o0<?, ?> o0Var) {
        if (o0Var.f() || !o0Var.v() || o0Var.d().size() <= o0Var.q().d().size()) {
            return i(o0Var.q());
        }
        return true;
    }

    public static <N> k0<N> k(z<N> zVar, Iterable<? extends N> iterable) {
        j jVar = iterable instanceof Collection ? (k0<N>) a0.f(zVar).e(((Collection) iterable).size()).b() : (k0<N>) a0.f(zVar).b();
        Iterator<? extends N> it = iterable.iterator();
        while (it.hasNext()) {
            jVar.n(it.next());
        }
        for (N n7 : jVar.l()) {
            for (N n8 : zVar.b((Object) n7)) {
                if (jVar.l().contains(n8)) {
                    jVar.z(n7, n8);
                }
            }
        }
        return jVar;
    }

    public static <N, E> l0<N, E> l(o0<N, E> o0Var, Iterable<? extends N> iterable) {
        k kVar = iterable instanceof Collection ? (l0<N, E>) p0.i(o0Var).h(((Collection) iterable).size()).c() : (l0<N, E>) p0.i(o0Var).c();
        Iterator<? extends N> it = iterable.iterator();
        while (it.hasNext()) {
            kVar.n(it.next());
        }
        for (E e8 : kVar.l()) {
            for (E e9 : o0Var.s(e8)) {
                N nA = o0Var.w(e9).a(e8);
                if (kVar.l().contains(nA)) {
                    kVar.F(e8, nA, e9);
                }
            }
        }
        return kVar;
    }

    public static <N, V> m0<N, V> m(y0<N, V> y0Var, Iterable<? extends N> iterable) {
        l lVar = iterable instanceof Collection ? (m0<N, V>) z0.f(y0Var).e(((Collection) iterable).size()).b() : (m0<N, V>) z0.f(y0Var).b();
        Iterator<? extends N> it = iterable.iterator();
        while (it.hasNext()) {
            lVar.n(it.next());
        }
        for (N n7 : lVar.l()) {
            for (N n8 : y0Var.b((Object) n7)) {
                if (lVar.l().contains(n8)) {
                    lVar.D(n7, n8, y0Var.y(n7, n8, null));
                }
            }
        }
        return lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <N> Set<N> n(z<N> zVar, N n7) {
        com.google.common.base.e0.u(zVar.l().contains(n7), "Node %s is not an element of this graph.", n7);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayDeque arrayDeque = new ArrayDeque();
        linkedHashSet.add(n7);
        arrayDeque.add(n7);
        while (!arrayDeque.isEmpty()) {
            for (Object obj : zVar.b(arrayDeque.remove())) {
                if (linkedHashSet.add(obj)) {
                    arrayDeque.add(obj);
                }
            }
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    private static <N> boolean o(z<N> zVar, Map<Object, a> map, N n7, N n8) {
        a aVar = map.get(n7);
        if (aVar == a.COMPLETE) {
            return false;
        }
        a aVar2 = a.PENDING;
        if (aVar == aVar2) {
            return true;
        }
        map.put(n7, aVar2);
        for (N n9 : zVar.b((Object) n7)) {
            if (a(zVar, n9, n8) && o(zVar, map, n9, n7)) {
                return true;
            }
        }
        map.put(n7, a.COMPLETE);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <N> z<N> p(z<N> zVar) {
        j jVarB = a0.f(zVar).a(true).b();
        if (zVar.f()) {
            for (N n7 : zVar.l()) {
                Iterator it = n(zVar, n7).iterator();
                while (it.hasNext()) {
                    jVarB.z(n7, it.next());
                }
            }
        } else {
            HashSet hashSet = new HashSet();
            for (N n8 : zVar.l()) {
                if (!hashSet.contains(n8)) {
                    Set setN = n(zVar, n8);
                    hashSet.addAll(setN);
                    int i7 = 1;
                    for (Object obj : setN) {
                        int i8 = i7 + 1;
                        Iterator it2 = ma.D(setN, i7).iterator();
                        while (it2.hasNext()) {
                            jVarB.z(obj, it2.next());
                        }
                        i7 = i8;
                    }
                }
            }
        }
        return jVarB;
    }

    public static <N> z<N> q(z<N> zVar) {
        if (zVar.f()) {
            return zVar instanceof b ? ((b) zVar).f21611a : new b(zVar);
        }
        return zVar;
    }

    public static <N, E> o0<N, E> r(o0<N, E> o0Var) {
        if (o0Var.f()) {
            return o0Var instanceof c ? ((c) o0Var).f21612a : new c(o0Var);
        }
        return o0Var;
    }

    public static <N, V> y0<N, V> s(y0<N, V> y0Var) {
        if (y0Var.f()) {
            return y0Var instanceof d ? ((d) y0Var).f21613a : new d(y0Var);
        }
        return y0Var;
    }
}
