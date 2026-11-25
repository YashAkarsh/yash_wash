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
final class p<N, E> extends b<N, E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @v1.b
    private transient Reference<hd<N>> f21668d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @v1.b
    private transient Reference<hd<N>> f21669e;

    class a extends j0<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f21670c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Map map, Object obj, Object obj2) {
            super(map, obj);
            this.f21670c = obj2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return p.this.s().l0(this.f21670c);
        }
    }

    private p(Map<E, N> map, Map<E, N> map2, int i7) {
        super(map, map2, i7);
    }

    private static <T> T o(Reference<T> reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    static <N, E> p<N, E> p() {
        return new p<>(new HashMap(2, 1.0f), new HashMap(2, 1.0f), 0);
    }

    static <N, E> p<N, E> q(Map<E, N> map, Map<E, N> map2, int i7) {
        return new p<>(v7.g(map), v7.g(map2), i7);
    }

    private hd<N> r() {
        hd<N> hdVar = (hd) o(this.f21668d);
        if (hdVar != null) {
            return hdVar;
        }
        r6 r6VarV = r6.v(this.f21585a.values());
        this.f21668d = new SoftReference(r6VarV);
        return r6VarV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public hd<N> s() {
        hd<N> hdVar = (hd) o(this.f21669e);
        if (hdVar != null) {
            return hdVar;
        }
        r6 r6VarV = r6.v(this.f21586b.values());
        this.f21669e = new SoftReference(r6VarV);
        return r6VarV;
    }

    @Override // com.google.common.graph.q0
    public Set<N> b() {
        return Collections.unmodifiableSet(s().e());
    }

    @Override // com.google.common.graph.q0
    public Set<N> c() {
        return Collections.unmodifiableSet(r().e());
    }

    @Override // com.google.common.graph.b, com.google.common.graph.q0
    public N d(E e8, boolean z7) {
        N n7 = (N) super.d(e8, z7);
        hd hdVar = (hd) o(this.f21668d);
        if (hdVar != null) {
            com.google.common.base.e0.g0(hdVar.remove(n7));
        }
        return n7;
    }

    @Override // com.google.common.graph.b, com.google.common.graph.q0
    public N h(E e8) {
        N n7 = (N) super.h(e8);
        hd hdVar = (hd) o(this.f21669e);
        if (hdVar != null) {
            com.google.common.base.e0.g0(hdVar.remove(n7));
        }
        return n7;
    }

    @Override // com.google.common.graph.b, com.google.common.graph.q0
    public void j(E e8, N n7) {
        super.j(e8, n7);
        hd hdVar = (hd) o(this.f21669e);
        if (hdVar != null) {
            com.google.common.base.e0.g0(hdVar.add(n7));
        }
    }

    @Override // com.google.common.graph.q0
    public Set<E> k(N n7) {
        return new a(this.f21586b, n7, n7);
    }

    @Override // com.google.common.graph.b, com.google.common.graph.q0
    public void l(E e8, N n7, boolean z7) {
        super.l(e8, n7, z7);
        hd hdVar = (hd) o(this.f21668d);
        if (hdVar != null) {
            com.google.common.base.e0.g0(hdVar.add(n7));
        }
    }
}
