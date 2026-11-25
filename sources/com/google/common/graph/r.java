package com.google.common.graph;

import com.google.common.collect.ck;
import com.google.common.collect.u8;
import com.google.common.collect.ua;
import java.util.AbstractSet;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class r<E> extends AbstractSet<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<?, E> f21675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f21676b;

    r(Map<?, E> map, Object obj) {
        this.f21675a = (Map) com.google.common.base.e0.E(map);
        this.f21676b = com.google.common.base.e0.E(obj);
    }

    private E a() {
        return this.f21675a.get(this.f21676b);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ck<E> iterator() {
        E eA = a();
        return eA == null ? u8.A().iterator() : ua.Y(eA);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        E eA = a();
        return eA != null && eA.equals(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return a() == null ? 0 : 1;
    }
}
