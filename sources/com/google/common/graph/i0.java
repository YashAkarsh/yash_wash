package com.google.common.graph;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class i0<K, V> extends h0<K, V> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient a<K, V> f21636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private transient a<K, V> f21637d;

    private static final class a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final K f21638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final V f21639b;

        a(K k7, V v7) {
            this.f21638a = k7;
            this.f21639b = v7;
        }
    }

    i0(Map<K, V> map) {
        super(map);
    }

    private void l(a<K, V> aVar) {
        this.f21637d = this.f21636c;
        this.f21636c = aVar;
    }

    private void m(K k7, V v7) {
        l(new a<>(k7, v7));
    }

    @Override // com.google.common.graph.h0
    protected void d() {
        super.d();
        this.f21636c = null;
        this.f21637d = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.h0
    public V f(Object obj) {
        V vG = g(obj);
        if (vG != null) {
            return vG;
        }
        V vH = h(obj);
        if (vH != null) {
            m(obj, vH);
        }
        return vH;
    }

    @Override // com.google.common.graph.h0
    protected V g(Object obj) {
        V v7 = (V) super.g(obj);
        if (v7 != null) {
            return v7;
        }
        a<K, V> aVar = this.f21636c;
        if (aVar != null && aVar.f21638a == obj) {
            return aVar.f21639b;
        }
        a<K, V> aVar2 = this.f21637d;
        if (aVar2 == null || aVar2.f21638a != obj) {
            return null;
        }
        l(aVar2);
        return aVar2.f21639b;
    }
}
