package com.google.common.graph;

import com.google.common.collect.af;
import com.google.common.collect.ck;
import com.google.common.collect.u8;
import com.google.common.collect.ua;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
abstract class a<N> implements i<N> {

    /* JADX INFO: renamed from: com.google.common.graph.a$a, reason: collision with other inner class name */
    class C0266a extends AbstractSet<t<N>> {
        C0266a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ck<t<N>> iterator() {
            return u.e(a.this);
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

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.common.primitives.c0.x(a.this.G());
        }
    }

    private static abstract class b<N> extends AbstractSet<t<N>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final N f21580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final i<N> f21581b;

        /* JADX INFO: renamed from: com.google.common.graph.a$b$a, reason: collision with other inner class name */
        private static final class C0267a<N> extends b<N> {

            /* JADX INFO: renamed from: com.google.common.graph.a$b$a$a, reason: collision with other inner class name */
            class C0268a implements com.google.common.base.s<N, t<N>> {
                C0268a() {
                }

                @Override // com.google.common.base.s, java.util.function.Function
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public t<N> apply(N n7) {
                    return t.k(n7, C0267a.this.f21580a);
                }
            }

            /* JADX INFO: renamed from: com.google.common.graph.a$b$a$b, reason: collision with other inner class name */
            class C0269b implements com.google.common.base.s<N, t<N>> {
                C0269b() {
                }

                @Override // com.google.common.base.s, java.util.function.Function
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public t<N> apply(N n7) {
                    return t.k(C0267a.this.f21580a, n7);
                }
            }

            /* synthetic */ C0267a(i iVar, Object obj, C0266a c0266a) {
                this(iVar, obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public ck<t<N>> iterator() {
                return ua.f0(ua.j(ua.c0(this.f21581b.a((Object) this.f21580a).iterator(), new C0268a()), ua.c0(af.f(this.f21581b.b((Object) this.f21580a), u8.B(this.f21580a)).iterator(), new C0269b())));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof t)) {
                    return false;
                }
                t tVar = (t) obj;
                if (!tVar.b()) {
                    return false;
                }
                Object objL = tVar.l();
                Object objM = tVar.m();
                return (this.f21580a.equals(objL) && this.f21581b.b((Object) this.f21580a).contains(objM)) || (this.f21580a.equals(objM) && this.f21581b.a((Object) this.f21580a).contains(objL));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return (this.f21581b.m(this.f21580a) + this.f21581b.h(this.f21580a)) - (this.f21581b.b((Object) this.f21580a).contains(this.f21580a) ? 1 : 0);
            }

            private C0267a(i<N> iVar, N n7) {
                super(iVar, n7, null);
            }
        }

        /* JADX INFO: renamed from: com.google.common.graph.a$b$b, reason: collision with other inner class name */
        private static final class C0270b<N> extends b<N> {

            /* JADX INFO: renamed from: com.google.common.graph.a$b$b$a, reason: collision with other inner class name */
            class C0271a implements com.google.common.base.s<N, t<N>> {
                C0271a() {
                }

                @Override // com.google.common.base.s, java.util.function.Function
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public t<N> apply(N n7) {
                    return t.n(C0270b.this.f21580a, n7);
                }
            }

            /* synthetic */ C0270b(i iVar, Object obj, C0266a c0266a) {
                this(iVar, obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public ck<t<N>> iterator() {
                return ua.f0(ua.c0(this.f21581b.j(this.f21580a).iterator(), new C0271a()));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof t)) {
                    return false;
                }
                t tVar = (t) obj;
                if (tVar.b()) {
                    return false;
                }
                Set<N> setJ = this.f21581b.j(this.f21580a);
                Object objF = tVar.f();
                Object objG = tVar.g();
                return (this.f21580a.equals(objG) && setJ.contains(objF)) || (this.f21580a.equals(objF) && setJ.contains(objG));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return this.f21581b.j(this.f21580a).size();
            }

            private C0270b(i<N> iVar, N n7) {
                super(iVar, n7, null);
            }
        }

        /* synthetic */ b(i iVar, Object obj, C0266a c0266a) {
            this(iVar, obj);
        }

        public static <N> b<N> a(i<N> iVar, N n7) {
            C0266a c0266a = null;
            return iVar.f() ? new C0267a(iVar, n7, c0266a) : new C0270b(iVar, n7, c0266a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        private b(i<N> iVar, N n7) {
            this.f21581b = iVar;
            this.f21580a = n7;
        }
    }

    a() {
    }

    protected long G() {
        Iterator<N> it = l().iterator();
        long jC = 0;
        while (it.hasNext()) {
            jC += (long) c(it.next());
        }
        com.google.common.base.e0.g0((1 & jC) == 0);
        return jC >>> 1;
    }

    @Override // com.google.common.graph.i, com.google.common.graph.r0
    public /* bridge */ /* synthetic */ Iterable a(Object obj) {
        return a(obj);
    }

    @Override // com.google.common.graph.i, com.google.common.graph.s0
    public /* bridge */ /* synthetic */ Iterable b(Object obj) {
        return b(obj);
    }

    @Override // com.google.common.graph.i
    public int c(N n7) {
        if (f()) {
            return com.google.common.math.d.t(a((Object) n7).size(), b((Object) n7).size());
        }
        Set<N> setJ = j(n7);
        return com.google.common.math.d.t(setJ.size(), (i() && setJ.contains(n7)) ? 1 : 0);
    }

    @Override // com.google.common.graph.i
    public Set<t<N>> d() {
        return new C0266a();
    }

    @Override // com.google.common.graph.i
    public boolean e(N n7, N n8) {
        com.google.common.base.e0.E(n7);
        com.google.common.base.e0.E(n8);
        return l().contains(n7) && b((Object) n7).contains(n8);
    }

    @Override // com.google.common.graph.i
    public int h(N n7) {
        return f() ? b((Object) n7).size() : c(n7);
    }

    @Override // com.google.common.graph.i
    public Set<t<N>> k(N n7) {
        com.google.common.base.e0.E(n7);
        com.google.common.base.e0.u(l().contains(n7), "Node %s is not an element of this graph.", n7);
        return b.a(this, n7);
    }

    @Override // com.google.common.graph.i
    public int m(N n7) {
        return f() ? a((Object) n7).size() : c(n7);
    }
}
