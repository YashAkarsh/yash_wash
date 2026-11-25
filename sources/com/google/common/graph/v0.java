package com.google.common.graph;

import com.google.common.collect.hd;
import com.google.common.collect.r6;
import com.google.common.collect.v7;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class v0<N, E> extends f<N, E> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @v1.b
    private transient Reference<hd<N>> f21728b;

    class a extends j0<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f21729c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Map map, Object obj, Object obj2) {
            super(map, obj);
            this.f21729c = obj2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return v0.this.n().l0(this.f21729c);
        }
    }

    private v0(Map<E, N> map) {
        super(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public hd<N> n() {
        hd<N> hdVar = (hd) o(this.f21728b);
        if (hdVar != null) {
            return hdVar;
        }
        r6 r6VarV = r6.v(this.f21622a.values());
        this.f21728b = new SoftReference(r6VarV);
        return r6VarV;
    }

    private static <T> T o(Reference<T> reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    static <N, E> v0<N, E> p() {
        return new v0<>(new HashMap(2, 1.0f));
    }

    static <N, E> v0<N, E> q(Map<E, N> map) {
        return new v0<>(v7.g(map));
    }

    @Override // com.google.common.graph.q0
    public Set<N> a() {
        return Collections.unmodifiableSet(n().e());
    }

    @Override // com.google.common.graph.f, com.google.common.graph.q0
    public N d(E e8, boolean z7) {
        if (z7) {
            return null;
        }
        return h(e8);
    }

    @Override // com.google.common.graph.f, com.google.common.graph.q0
    public N h(E e8) {
        N n7 = (N) super.h(e8);
        hd hdVar = (hd) o(this.f21728b);
        if (hdVar != null) {
            com.google.common.base.e0.g0(hdVar.remove(n7));
        }
        return n7;
    }

    @Override // com.google.common.graph.f, com.google.common.graph.q0
    public void j(E e8, N n7) {
        super.j(e8, n7);
        hd hdVar = (hd) o(this.f21728b);
        if (hdVar != null) {
            com.google.common.base.e0.g0(hdVar.add(n7));
        }
    }

    @Override // com.google.common.graph.q0
    public Set<E> k(N n7) {
        return new a(this.f21622a, n7, n7);
    }

    @Override // com.google.common.graph.f, com.google.common.graph.q0
    public void l(E e8, N n7, boolean z7) {
        if (z7) {
            return;
        }
        j(e8, n7);
    }
}
