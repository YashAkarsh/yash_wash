package com.google.common.graph;

import com.google.common.collect.ck;
import com.google.common.collect.d7;

/* JADX INFO: loaded from: classes2.dex */
final class k<N, E> extends m<N, E> implements l0<N, E> {
    k(p0<? super N, ? super E> p0Var) {
        super(p0Var);
    }

    @u1.a
    private q0<N, E> M(N n7) {
        q0<N, E> q0VarN = N();
        com.google.common.base.e0.g0(this.f21650f.i(n7, q0VarN) == null);
        return q0VarN;
    }

    private q0<N, E> N() {
        if (f()) {
            return v() ? p.p() : q.n();
        }
        return v() ? v0.p() : w0.m();
    }

    @Override // com.google.common.graph.l0
    @u1.a
    public boolean B(E e8) {
        com.google.common.base.e0.F(e8, "edge");
        N nF = this.f21651g.f(e8);
        boolean z7 = false;
        if (nF == null) {
            return false;
        }
        q0<N, E> q0VarF = this.f21650f.f(nF);
        N nF2 = q0VarF.f(e8);
        q0<N, E> q0VarF2 = this.f21650f.f(nF2);
        q0VarF.h(e8);
        if (i() && nF.equals(nF2)) {
            z7 = true;
        }
        q0VarF2.d(e8, z7);
        this.f21651g.j(e8);
        return true;
    }

    @Override // com.google.common.graph.l0
    @u1.a
    public boolean F(N n7, N n8, E e8) {
        com.google.common.base.e0.F(n7, "nodeU");
        com.google.common.base.e0.F(n8, "nodeV");
        com.google.common.base.e0.F(e8, "edge");
        if (K(e8)) {
            t<N> tVarW = w(e8);
            t tVarJ = t.j(this, n7, n8);
            com.google.common.base.e0.z(tVarW.equals(tVarJ), "Edge %s already exists between the following nodes: %s, so it cannot be reused to connect the following nodes: %s.", e8, tVarW, tVarJ);
            return false;
        }
        q0<N, E> q0VarF = this.f21650f.f(n7);
        if (!v()) {
            com.google.common.base.e0.y(q0VarF == null || !q0VarF.b().contains(n8), "Nodes %s and %s are already connected by a different edge. To construct a graph that allows parallel edges, call allowsParallelEdges(true) on the Builder.", n7, n8);
        }
        boolean zEquals = n7.equals(n8);
        if (!i()) {
            com.google.common.base.e0.u(!zEquals, "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", n7);
        }
        if (q0VarF == null) {
            q0VarF = M(n7);
        }
        q0VarF.j(e8, n8);
        q0<N, E> q0VarF2 = this.f21650f.f(n8);
        if (q0VarF2 == null) {
            q0VarF2 = M(n8);
        }
        q0VarF2.l(e8, n7, zEquals);
        this.f21651g.i(e8, n7);
        return true;
    }

    @Override // com.google.common.graph.l0
    @u1.a
    public boolean n(N n7) {
        com.google.common.base.e0.F(n7, "node");
        if (L(n7)) {
            return false;
        }
        M(n7);
        return true;
    }

    @Override // com.google.common.graph.l0
    @u1.a
    public boolean o(N n7) {
        com.google.common.base.e0.F(n7, "node");
        q0<N, E> q0VarF = this.f21650f.f(n7);
        if (q0VarF == null) {
            return false;
        }
        ck<E> it = d7.r(q0VarF.e()).iterator();
        while (it.hasNext()) {
            B(it.next());
        }
        this.f21650f.j(n7);
        return true;
    }
}
