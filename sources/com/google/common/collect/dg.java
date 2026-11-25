package com.google.common.collect;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
class dg<R, C, V> extends gg<R, C, V> implements re<R, C, V> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final long f20126i = 0;

    private class b extends gg<R, C, V>.h implements SortedMap<R, Map<C, V>> {
        private b() {
            super();
        }

        @Override // java.util.SortedMap
        public Comparator<? super R> comparator() {
            return dg.this.D().comparator();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.wb.s0
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public SortedSet<R> g() {
            return new wb.h0(this);
        }

        @Override // java.util.SortedMap
        public R firstKey() {
            return (R) dg.this.D().firstKey();
        }

        @Override // com.google.common.collect.wb.s0, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public SortedSet<R> keySet() {
            return (SortedSet) super.keySet();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> headMap(R r7) {
            com.google.common.base.e0.E(r7);
            return new dg(dg.this.D().headMap(r7), dg.this.f20297d).f();
        }

        @Override // java.util.SortedMap
        public R lastKey() {
            return (R) dg.this.D().lastKey();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> subMap(R r7, R r8) {
            com.google.common.base.e0.E(r7);
            com.google.common.base.e0.E(r8);
            return new dg(dg.this.D().subMap(r7, r8), dg.this.f20297d).f();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> tailMap(R r7) {
            com.google.common.base.e0.E(r7);
            return new dg(dg.this.D().tailMap(r7), dg.this.f20297d).f();
        }
    }

    dg(SortedMap<R, Map<C, V>> sortedMap, com.google.common.base.p0<? extends Map<C, V>> p0Var) {
        super(sortedMap, p0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SortedMap<R, Map<C, V>> D() {
        return (SortedMap) this.f20296c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.gg
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public SortedMap<R, Map<C, V>> v() {
        return new b();
    }

    @Override // com.google.common.collect.gg, com.google.common.collect.oj
    public SortedMap<R, Map<C, V>> f() {
        return (SortedMap) super.f();
    }

    @Override // com.google.common.collect.gg, com.google.common.collect.h0, com.google.common.collect.oj
    public SortedSet<R> g() {
        return (SortedSet) f().keySet();
    }
}
