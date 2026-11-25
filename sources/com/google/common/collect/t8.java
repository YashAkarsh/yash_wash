package com.google.common.collect;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public final class t8<C extends Comparable> extends a0<C> implements Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final t8<Comparable<?>> f21107c = new t8<>(d7.x());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final t8<Comparable<?>> f21108d = new t8<>(d7.z(xd.a()));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final transient d7<xd<C>> f21109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @v1.b
    private transient t8<C> f21110b;

    class a extends d7<xd<C>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f21111c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f21112d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ xd f21113e;

        a(int i7, int i8, xd xdVar) {
            this.f21111c = i7;
            this.f21112d = i8;
            this.f21113e = xdVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
        public xd<C> get(int i7) {
            com.google.common.base.e0.C(i7, this.f21111c);
            return (i7 == 0 || i7 == this.f21111c + (-1)) ? ((xd) t8.this.f21109a.get(i7 + this.f21112d)).u(this.f21113e) : (xd) t8.this.f21109a.get(i7 + this.f21112d);
        }

        @Override // com.google.common.collect.x6
        boolean h() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f21111c;
        }
    }

    private final class b extends s9<C> {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final p4<C> f21115m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private transient Integer f21116n;

        class a extends com.google.common.collect.e<C> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final Iterator<xd<C>> f21118c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Iterator<C> f21119d = ua.u();

            a() {
                this.f21118c = t8.this.f21109a.iterator();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.e
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public C a() {
                while (!this.f21119d.hasNext()) {
                    if (!this.f21118c.hasNext()) {
                        return (C) b();
                    }
                    this.f21119d = i4.Q0(this.f21118c.next(), b.this.f21115m).iterator();
                }
                return this.f21119d.next();
            }
        }

        /* JADX INFO: renamed from: com.google.common.collect.t8$b$b, reason: collision with other inner class name */
        class C0254b extends com.google.common.collect.e<C> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final Iterator<xd<C>> f21121c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Iterator<C> f21122d = ua.u();

            C0254b() {
                this.f21121c = t8.this.f21109a.O().iterator();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.e
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public C a() {
                while (!this.f21122d.hasNext()) {
                    if (!this.f21121c.hasNext()) {
                        return (C) b();
                    }
                    this.f21122d = i4.Q0(this.f21121c.next(), b.this.f21115m).descendingIterator();
                }
                return this.f21122d.next();
            }
        }

        b(p4<C> p4Var) {
            super(td.A());
            this.f21115m = p4Var;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.s9
        /* JADX INFO: renamed from: N0, reason: merged with bridge method [inline-methods] */
        public s9<C> q0(C c8, boolean z7) {
            return O0(xd.J(c8, s0.b(z7)));
        }

        s9<C> O0(xd<C> xdVar) {
            return t8.this.m(xdVar).w(this.f21115m);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.s9
        /* JADX INFO: renamed from: P0, reason: merged with bridge method [inline-methods] */
        public s9<C> F0(C c8, boolean z7, C c9, boolean z8) {
            return (z7 || z8 || xd.i(c8, c9) != 0) ? O0(xd.D(c8, s0.b(z7), c9, s0.b(z8))) : s9.t0();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.s9
        /* JADX INFO: renamed from: Q0, reason: merged with bridge method [inline-methods] */
        public s9<C> I0(C c8, boolean z7) {
            return O0(xd.m(c8, s0.b(z7)));
        }

        @Override // com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                return t8.this.a((Comparable) obj);
            } catch (ClassCastException unused) {
                return false;
            }
        }

        @Override // com.google.common.collect.x6
        boolean h() {
            return t8.this.f21109a.h();
        }

        @Override // com.google.common.collect.s9
        s9<C> i0() {
            return new n4(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.s9
        int indexOf(Object obj) {
            if (!contains(obj)) {
                return -1;
            }
            Comparable comparable = (Comparable) obj;
            ck it = t8.this.f21109a.iterator();
            long size = 0;
            while (it.hasNext()) {
                xd xdVar = (xd) it.next();
                if (xdVar.j(comparable)) {
                    return com.google.common.primitives.c0.x(size + ((long) i4.Q0(xdVar, this.f21115m).indexOf(comparable)));
                }
                size += (long) i4.Q0(xdVar, this.f21115m).size();
            }
            throw new AssertionError("impossible");
        }

        @Override // com.google.common.collect.s9, com.google.common.collect.u8, com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: j */
        public ck<C> iterator() {
            return new a();
        }

        @Override // com.google.common.collect.s9, java.util.NavigableSet
        @s1.c("NavigableSet")
        /* JADX INFO: renamed from: j0 */
        public ck<C> descendingIterator() {
            return new C0254b();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Integer numValueOf = this.f21116n;
            if (numValueOf == null) {
                ck it = t8.this.f21109a.iterator();
                long size = 0;
                while (it.hasNext()) {
                    size += (long) i4.Q0((xd) it.next(), this.f21115m).size();
                    if (size >= 2147483647L) {
                        break;
                    }
                }
                numValueOf = Integer.valueOf(com.google.common.primitives.c0.x(size));
                this.f21116n = numValueOf;
            }
            return numValueOf.intValue();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return t8.this.f21109a.toString();
        }

        @Override // com.google.common.collect.s9, com.google.common.collect.u8, com.google.common.collect.x6
        Object writeReplace() {
            return new c(t8.this.f21109a, this.f21115m);
        }
    }

    private static class c<C extends Comparable> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d7<xd<C>> f21124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final p4<C> f21125b;

        c(d7<xd<C>> d7Var, p4<C> p4Var) {
            this.f21124a = d7Var;
            this.f21125b = p4Var;
        }

        Object readResolve() {
            return new t8(this.f21124a).w(this.f21125b);
        }
    }

    public static class d<C extends Comparable<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<xd<C>> f21126a = ib.q();

        @u1.a
        public d<C> a(xd<C> xdVar) {
            com.google.common.base.e0.u(!xdVar.w(), "range must not be empty, but was %s", xdVar);
            this.f21126a.add(xdVar);
            return this;
        }

        @u1.a
        public d<C> b(be<C> beVar) {
            return c(beVar.o());
        }

        @u1.a
        public d<C> c(Iterable<xd<C>> iterable) {
            Iterator<xd<C>> it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }

        public t8<C> d() {
            d7.b bVar = new d7.b(this.f21126a.size());
            Collections.sort(this.f21126a, xd.E());
            ud udVarT = ua.T(this.f21126a.iterator());
            while (udVarT.hasNext()) {
                xd xdVarH = (xd) udVarT.next();
                while (udVarT.hasNext()) {
                    xd<C> xdVar = (xd) udVarT.peek();
                    if (!xdVarH.v(xdVar)) {
                        break;
                    }
                    com.google.common.base.e0.y(xdVarH.u(xdVar).w(), "Overlapping ranges not permitted but found %s overlapping %s", xdVarH, xdVar);
                    xdVarH = xdVarH.H((xd) udVarT.next());
                }
                bVar.a(xdVarH);
            }
            d7 d7VarE = bVar.e();
            if (d7VarE.isEmpty()) {
                return t8.F();
            }
            return (d7VarE.size() == 1 && ((xd) ma.z(d7VarE)).equals(xd.a())) ? t8.t() : new t8<>(d7VarE);
        }

        @u1.a
        d<C> e(d<C> dVar) {
            c(dVar.f21126a);
            return this;
        }
    }

    private final class e extends d7<xd<C>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f21127c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f21128d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f21129e;

        /* JADX WARN: Multi-variable type inference failed */
        e() {
            boolean zR = ((xd) t8.this.f21109a.get(0)).r();
            this.f21127c = zR;
            boolean zT = ((xd) ma.w(t8.this.f21109a)).t();
            this.f21128d = zT;
            int size = t8.this.f21109a.size() - 1;
            size = zR ? size + 1 : size;
            this.f21129e = zT ? size + 1 : size;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
        public xd<C> get(int i7) {
            k4<C> k4VarC;
            com.google.common.base.e0.C(i7, this.f21129e);
            if (this.f21127c) {
                k4VarC = i7 == 0 ? k4.c() : ((xd) t8.this.f21109a.get(i7 - 1)).f21415b;
            } else {
                k4VarC = ((xd) t8.this.f21109a.get(i7)).f21415b;
            }
            return xd.l(k4VarC, (this.f21128d && i7 == this.f21129e + (-1)) ? k4.a() : ((xd) t8.this.f21109a.get(i7 + (!this.f21127c ? 1 : 0))).f21414a);
        }

        @Override // com.google.common.collect.x6
        boolean h() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f21129e;
        }
    }

    private static final class f<C extends Comparable> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d7<xd<C>> f21131a;

        f(d7<xd<C>> d7Var) {
            this.f21131a = d7Var;
        }

        Object readResolve() {
            if (this.f21131a.isEmpty()) {
                return t8.F();
            }
            return this.f21131a.equals(d7.z(xd.a())) ? t8.t() : new t8(this.f21131a);
        }
    }

    t8(d7<xd<C>> d7Var) {
        this.f21109a = d7Var;
    }

    public static <C extends Comparable<?>> t8<C> A(Iterable<xd<C>> iterable) {
        return new d().c(iterable).d();
    }

    private d7<xd<C>> C(xd<C> xdVar) {
        if (this.f21109a.isEmpty() || xdVar.w()) {
            return d7.x();
        }
        if (xdVar.o(c())) {
            return this.f21109a;
        }
        int iA = xdVar.r() ? sf.a(this.f21109a, xd.K(), xdVar.f21414a, sf.c.f21077d, sf.b.f21071b) : 0;
        int iA2 = (xdVar.t() ? sf.a(this.f21109a, xd.y(), xdVar.f21415b, sf.c.f21076c, sf.b.f21071b) : this.f21109a.size()) - iA;
        return iA2 == 0 ? d7.x() : new a(iA2, iA, xdVar);
    }

    public static <C extends Comparable> t8<C> F() {
        return f21107c;
    }

    public static <C extends Comparable> t8<C> H(xd<C> xdVar) {
        com.google.common.base.e0.E(xdVar);
        if (xdVar.w()) {
            return F();
        }
        return xdVar.equals(xd.a()) ? t() : new t8<>(d7.z(xdVar));
    }

    @s1.a
    public static <E extends Comparable<? super E>> Collector<xd<E>, ?, t8<E>> J() {
        return e2.q();
    }

    public static <C extends Comparable<?>> t8<C> L(Iterable<xd<C>> iterable) {
        return z(ak.v(iterable));
    }

    static <C extends Comparable> t8<C> t() {
        return f21108d;
    }

    public static <C extends Comparable<?>> d<C> x() {
        return new d<>();
    }

    public static <C extends Comparable> t8<C> z(be<C> beVar) {
        com.google.common.base.e0.E(beVar);
        if (beVar.isEmpty()) {
            return F();
        }
        if (beVar.k(xd.a())) {
            return t();
        }
        if (beVar instanceof t8) {
            t8<C> t8Var = (t8) beVar;
            if (!t8Var.E()) {
                return t8Var;
            }
        }
        return new t8<>(d7.r(beVar.o()));
    }

    public t8<C> B(be<C> beVar) {
        ak akVarU = ak.u(this);
        akVarU.p(beVar);
        return z(akVarU);
    }

    public t8<C> D(be<C> beVar) {
        ak akVarU = ak.u(this);
        akVarU.p(beVar.i());
        return z(akVarU);
    }

    boolean E() {
        return this.f21109a.h();
    }

    @Override // com.google.common.collect.be
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public t8<C> m(xd<C> xdVar) {
        if (!isEmpty()) {
            xd<C> xdVarC = c();
            if (xdVar.o(xdVarC)) {
                return this;
            }
            if (xdVar.v(xdVarC)) {
                return new t8<>(C(xdVar));
            }
        }
        return F();
    }

    public t8<C> K(be<C> beVar) {
        return L(ma.f(o(), beVar.o()));
    }

    @Override // com.google.common.collect.a0, com.google.common.collect.be
    public /* bridge */ /* synthetic */ boolean a(Comparable comparable) {
        return super.a(comparable);
    }

    @Override // com.google.common.collect.a0, com.google.common.collect.be
    @Deprecated
    public void b(xd<C> xdVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.be
    public xd<C> c() {
        if (this.f21109a.isEmpty()) {
            throw new NoSuchElementException();
        }
        k4<C> k4Var = this.f21109a.get(0).f21414a;
        d7<xd<C>> d7Var = this.f21109a;
        return xd.l(k4Var, d7Var.get(d7Var.size() - 1).f21415b);
    }

    @Override // com.google.common.collect.a0, com.google.common.collect.be
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.a0, com.google.common.collect.be
    @Deprecated
    public void d(Iterable<xd<C>> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.a0, com.google.common.collect.be
    @Deprecated
    public void e(be<C> beVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.a0, com.google.common.collect.be
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.a0, com.google.common.collect.be
    @Deprecated
    public void f(Iterable<xd<C>> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.a0, com.google.common.collect.be
    public /* bridge */ /* synthetic */ boolean g(be beVar) {
        return super.g(beVar);
    }

    @Override // com.google.common.collect.a0, com.google.common.collect.be
    @Deprecated
    public void h(xd<C> xdVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.a0, com.google.common.collect.be
    public boolean isEmpty() {
        return this.f21109a.isEmpty();
    }

    @Override // com.google.common.collect.a0, com.google.common.collect.be
    public xd<C> j(C c8) {
        int iB = sf.b(this.f21109a, xd.y(), k4.d(c8), td.A(), sf.c.f21074a, sf.b.f21070a);
        if (iB == -1) {
            return null;
        }
        xd<C> xdVar = this.f21109a.get(iB);
        if (xdVar.j(c8)) {
            return xdVar;
        }
        return null;
    }

    @Override // com.google.common.collect.a0, com.google.common.collect.be
    public boolean k(xd<C> xdVar) {
        int iB = sf.b(this.f21109a, xd.y(), xdVar.f21414a, td.A(), sf.c.f21074a, sf.b.f21070a);
        return iB != -1 && this.f21109a.get(iB).o(xdVar);
    }

    @Override // com.google.common.collect.a0, com.google.common.collect.be
    @Deprecated
    public void p(be<C> beVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.a0, com.google.common.collect.be
    public boolean q(xd<C> xdVar) {
        int iB = sf.b(this.f21109a, xd.y(), xdVar.f21414a, td.A(), sf.c.f21074a, sf.b.f21071b);
        if (iB < this.f21109a.size() && this.f21109a.get(iB).v(xdVar) && !this.f21109a.get(iB).u(xdVar).w()) {
            return true;
        }
        if (iB > 0) {
            int i7 = iB - 1;
            if (this.f21109a.get(i7).v(xdVar) && !this.f21109a.get(i7).u(xdVar).w()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.be
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public u8<xd<C>> n() {
        return this.f21109a.isEmpty() ? u8.A() : new me(this.f21109a.O(), xd.E().F());
    }

    @Override // com.google.common.collect.be
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public u8<xd<C>> o() {
        return this.f21109a.isEmpty() ? u8.A() : new me(this.f21109a, xd.E());
    }

    public s9<C> w(p4<C> p4Var) {
        com.google.common.base.e0.E(p4Var);
        if (isEmpty()) {
            return s9.t0();
        }
        xd<C> xdVarE = c().e(p4Var);
        if (!xdVarE.r()) {
            throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
        }
        if (!xdVarE.t()) {
            try {
                p4Var.e();
            } catch (NoSuchElementException unused) {
                throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
            }
        }
        return new b(p4Var);
    }

    Object writeReplace() {
        return new f(this.f21109a);
    }

    @Override // com.google.common.collect.be
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public t8<C> i() {
        t8<C> t8Var = this.f21110b;
        if (t8Var != null) {
            return t8Var;
        }
        if (this.f21109a.isEmpty()) {
            t8<C> t8VarT = t();
            this.f21110b = t8VarT;
            return t8VarT;
        }
        if (this.f21109a.size() == 1 && this.f21109a.get(0).equals(xd.a())) {
            t8<C> t8VarF = F();
            this.f21110b = t8VarF;
            return t8VarF;
        }
        t8<C> t8Var2 = new t8<>(new e(), this);
        this.f21110b = t8Var2;
        return t8Var2;
    }

    private t8(d7<xd<C>> d7Var, t8<C> t8Var) {
        this.f21109a = d7Var;
        this.f21110b = t8Var;
    }
}
