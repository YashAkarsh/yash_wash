package com.google.common.graph;

import com.google.common.collect.ck;
import com.google.common.collect.ua;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@u1.j(containerOf = {"N"})
public abstract class t<N> implements Iterable<N> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final N f21684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final N f21685b;

    private static final class b<N> extends t<N> {
        @Override // com.google.common.graph.t
        public boolean b() {
            return true;
        }

        @Override // com.google.common.graph.t
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof t)) {
                return false;
            }
            t tVar = (t) obj;
            if (b() != tVar.b()) {
                return false;
            }
            return l().equals(tVar.l()) && m().equals(tVar.m());
        }

        @Override // com.google.common.graph.t
        public int hashCode() {
            return com.google.common.base.y.b(l(), m());
        }

        @Override // com.google.common.graph.t, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.graph.t
        public N l() {
            return f();
        }

        @Override // com.google.common.graph.t
        public N m() {
            return g();
        }

        public String toString() {
            return "<" + l() + " -> " + m() + ">";
        }

        private b(N n7, N n8) {
            super(n7, n8);
        }
    }

    private static final class c<N> extends t<N> {
        @Override // com.google.common.graph.t
        public boolean b() {
            return false;
        }

        @Override // com.google.common.graph.t
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof t)) {
                return false;
            }
            t tVar = (t) obj;
            if (b() != tVar.b()) {
                return false;
            }
            if (f().equals(tVar.f())) {
                return g().equals(tVar.g());
            }
            return f().equals(tVar.g()) && g().equals(tVar.f());
        }

        @Override // com.google.common.graph.t
        public int hashCode() {
            return f().hashCode() + g().hashCode();
        }

        @Override // com.google.common.graph.t, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.graph.t
        public N l() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        @Override // com.google.common.graph.t
        public N m() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        public String toString() {
            return "[" + f() + ", " + g() + "]";
        }

        private c(N n7, N n8) {
            super(n7, n8);
        }
    }

    static <N> t<N> h(z<?> zVar, N n7, N n8) {
        return zVar.f() ? k(n7, n8) : n(n7, n8);
    }

    static <N> t<N> j(o0<?, ?> o0Var, N n7, N n8) {
        return o0Var.f() ? k(n7, n8) : n(n7, n8);
    }

    public static <N> t<N> k(N n7, N n8) {
        return new b(n7, n8);
    }

    public static <N> t<N> n(N n7, N n8) {
        return new c(n8, n7);
    }

    public final N a(Object obj) {
        if (obj.equals(this.f21684a)) {
            return this.f21685b;
        }
        if (obj.equals(this.f21685b)) {
            return this.f21684a;
        }
        throw new IllegalArgumentException("EndpointPair " + this + " does not contain node " + obj);
    }

    public abstract boolean b();

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final ck<N> iterator() {
        return ua.B(this.f21684a, this.f21685b);
    }

    public abstract boolean equals(Object obj);

    public final N f() {
        return this.f21684a;
    }

    public final N g() {
        return this.f21685b;
    }

    public abstract int hashCode();

    public abstract N l();

    public abstract N m();

    private t(N n7, N n8) {
        this.f21684a = (N) com.google.common.base.e0.E(n7);
        this.f21685b = (N) com.google.common.base.e0.E(n8);
    }
}
