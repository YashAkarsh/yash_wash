package com.google.common.graph;

import com.google.common.collect.ck;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
abstract class j0<E> extends AbstractSet<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<E, ?> f21641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f21642b;

    class a extends com.google.common.collect.e<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Iterator f21643c;

        a(Iterator it) {
            this.f21643c = it;
        }

        @Override // com.google.common.collect.e
        protected E a() {
            while (this.f21643c.hasNext()) {
                Map.Entry entry = (Map.Entry) this.f21643c.next();
                if (j0.this.f21642b.equals(entry.getValue())) {
                    return (E) entry.getKey();
                }
            }
            return b();
        }
    }

    j0(Map<E, ?> map, Object obj) {
        this.f21641a = (Map) com.google.common.base.e0.E(map);
        this.f21642b = com.google.common.base.e0.E(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ck<E> iterator() {
        return new a(this.f21641a.entrySet().iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f21642b.equals(this.f21641a.get(obj));
    }
}
