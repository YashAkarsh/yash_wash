package com.google.common.collect;

import com.haier.uhome.account.api.RetInfoContent;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
final class va<K, V> extends u6<K, V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final transient d7<Map.Entry<K, V>> f21289f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<K, V> f21290g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map<V, K> f21291h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @y1.h
    @v1.b
    private transient va<V, K> f21292i;

    private final class b extends d7<Map.Entry<V, K>> {
        private b() {
        }

        @Override // java.util.List
        /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
        public Map.Entry<V, K> get(int i7) {
            Map.Entry entry = (Map.Entry) va.this.f21289f.get(i7);
            return wb.T(entry.getValue(), entry.getKey());
        }

        @Override // com.google.common.collect.x6
        boolean h() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return va.this.f21289f.size();
        }
    }

    private va(d7<Map.Entry<K, V>> d7Var, Map<K, V> map, Map<V, K> map2) {
        this.f21289f = d7Var;
        this.f21290g = map;
        this.f21291h = map2;
    }

    @s1.d
    static <K, V> u6<K, V> d0(int i7, Map.Entry<K, V>[] entryArr) {
        HashMap mapK0 = wb.k0(i7);
        HashMap mapK1 = wb.k0(i7);
        for (int i8 = 0; i8 < i7; i8++) {
            w7 w7VarO = ie.O(entryArr[i8]);
            entryArr[i8] = w7VarO;
            Object objPutIfAbsent = mapK0.putIfAbsent(w7VarO.getKey(), w7VarO.getValue());
            if (objPutIfAbsent != null) {
                throw v7.e(RetInfoContent.BindKEY_ISNULL, w7VarO.getKey() + "=" + objPutIfAbsent, entryArr[i8]);
            }
            Object objPutIfAbsent2 = mapK1.putIfAbsent(w7VarO.getValue(), w7VarO.getKey());
            if (objPutIfAbsent2 != null) {
                throw v7.e("value", objPutIfAbsent2 + "=" + w7VarO.getValue(), entryArr[i8]);
            }
        }
        return new va(d7.l(entryArr, i7), mapK0, mapK1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.u6, com.google.common.collect.r0
    /* JADX INFO: renamed from: P */
    public u6<V, K> T() {
        va<V, K> vaVar = this.f21292i;
        if (vaVar != null) {
            return vaVar;
        }
        va<V, K> vaVar2 = new va<>(new b(), this.f21291h, this.f21290g);
        this.f21292i = vaVar2;
        vaVar2.f21292i = this;
        return vaVar2;
    }

    @Override // com.google.common.collect.v7, java.util.Map
    public V get(Object obj) {
        return this.f21290g.get(obj);
    }

    @Override // com.google.common.collect.v7
    u8<Map.Entry<K, V>> k() {
        return new x7.b(this, this.f21289f);
    }

    @Override // com.google.common.collect.v7
    u8<K> l() {
        return new z7(this);
    }

    @Override // com.google.common.collect.v7
    boolean r() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.f21289f.size();
    }
}
