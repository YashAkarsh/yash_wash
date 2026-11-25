package com.google.common.graph;

/* JADX INFO: loaded from: classes2.dex */
final class j<N> extends v<N> implements k0<N> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m0<N, c0.a> f21640a;

    j(d<? super N> dVar) {
        this.f21640a = new l(dVar);
    }

    @Override // com.google.common.graph.v
    protected i<N> H() {
        return this.f21640a;
    }

    @Override // com.google.common.graph.k0
    public boolean n(N n7) {
        return this.f21640a.n(n7);
    }

    @Override // com.google.common.graph.k0
    public boolean o(N n7) {
        return this.f21640a.o(n7);
    }

    @Override // com.google.common.graph.k0
    public boolean p(N n7, N n8) {
        return this.f21640a.p(n7, n8) != null;
    }

    @Override // com.google.common.graph.k0
    public boolean z(N n7, N n8) {
        return this.f21640a.D(n7, n8, c0.a.EDGE_EXISTS) == null;
    }
}
