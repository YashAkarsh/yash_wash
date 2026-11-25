package com.google.common.graph;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
public abstract class c<N> extends a<N> implements z<N> {
    @Override // com.google.common.graph.a, com.google.common.graph.i, com.google.common.graph.r0
    public /* bridge */ /* synthetic */ Iterable a(Object obj) {
        return a(obj);
    }

    @Override // com.google.common.graph.a, com.google.common.graph.i, com.google.common.graph.s0
    public /* bridge */ /* synthetic */ Iterable b(Object obj) {
        return b(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.a, com.google.common.graph.i
    public /* bridge */ /* synthetic */ int c(Object obj) {
        return super.c(obj);
    }

    @Override // com.google.common.graph.a, com.google.common.graph.i
    public /* bridge */ /* synthetic */ Set d() {
        return super.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.a, com.google.common.graph.i
    public /* bridge */ /* synthetic */ boolean e(Object obj, Object obj2) {
        return super.e(obj, obj2);
    }

    @Override // com.google.common.graph.z
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return f() == zVar.f() && l().equals(zVar.l()) && d().equals(zVar.d());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.a, com.google.common.graph.i
    public /* bridge */ /* synthetic */ int h(Object obj) {
        return super.h(obj);
    }

    @Override // com.google.common.graph.z
    public final int hashCode() {
        return d().hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.a, com.google.common.graph.i
    public /* bridge */ /* synthetic */ Set k(Object obj) {
        return super.k(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.a, com.google.common.graph.i
    public /* bridge */ /* synthetic */ int m(Object obj) {
        return super.m(obj);
    }

    public String toString() {
        return "isDirected: " + f() + ", allowsSelfLoops: " + i() + ", nodes: " + l() + ", edges: " + d();
    }
}
