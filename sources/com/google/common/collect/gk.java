package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
final class gk<K, V> extends u5<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<K, V> f20335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Set<Map.Entry<K, V>> f20336b;

    private final class b extends wb.t<K, V> {

        class a extends uj<K, Map.Entry<K, V>> {

            /* JADX INFO: renamed from: com.google.common.collect.gk$b$a$a, reason: collision with other inner class name */
            class C0247a extends v<K, V> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ Object f20339a;

                C0247a(Object obj) {
                    this.f20339a = obj;
                }

                @Override // com.google.common.collect.v, java.util.Map.Entry
                public K getKey() {
                    return (K) this.f20339a;
                }

                @Override // com.google.common.collect.v, java.util.Map.Entry
                public V getValue() {
                    return gk.this.get(this.f20339a);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.collect.v, java.util.Map.Entry
                public V setValue(V v7) {
                    return (V) gk.this.put(this.f20339a, v7);
                }
            }

            a(Iterator it) {
                super(it);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.uj
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> a(K k7) {
                return new C0247a(k7);
            }
        }

        private b() {
        }

        @Override // com.google.common.collect.wb.t
        Map<K, V> g() {
            return gk.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a(gk.this.keySet().iterator());
        }
    }

    private gk(Map<K, V> map) {
        this.f20335a = map;
    }

    static <K, V> gk<K, V> t0(Map<K, V> map) {
        return new gk<>(map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.u5, com.google.common.collect.b6
    /* JADX INFO: renamed from: d0 */
    public Map<K, V> c0() {
        return this.f20335a;
    }

    @Override // com.google.common.collect.u5, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f20336b;
        if (set != null) {
            return set;
        }
        b bVar = new b();
        this.f20336b = bVar;
        return bVar;
    }
}
