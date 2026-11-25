package com.google.common.collect;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.SortedMap;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public abstract class f6<K, V> extends u5<K, V> implements SortedMap<K, V> {

    @s1.a
    protected class a extends wb.h0<K, V> {
        public a() {
            super(f6.this);
        }
    }

    protected f6() {
    }

    private int w0(Object obj, Object obj2) {
        Comparator<? super K> comparator = comparator();
        return comparator == null ? ((Comparable) obj).compareTo(obj2) : comparator.compare(obj, obj2);
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return c0().comparator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.u5
    @s1.a
    protected boolean f0(Object obj) {
        try {
            return w0(tailMap(obj).firstKey(), obj) == 0;
        } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
            return false;
        }
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        return c0().firstKey();
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> headMap(K k7) {
        return c0().headMap(k7);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return c0().lastKey();
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> subMap(K k7, K k8) {
        return c0().subMap(k7, k8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.u5
    /* JADX INFO: renamed from: t0 */
    public abstract SortedMap<K, V> c0();

    @Override // java.util.SortedMap
    public SortedMap<K, V> tailMap(K k7) {
        return c0().tailMap(k7);
    }

    @s1.a
    protected SortedMap<K, V> u0(K k7, K k8) {
        com.google.common.base.e0.e(w0(k7, k8) <= 0, "fromKey must be <= toKey");
        return tailMap(k7).headMap(k8);
    }
}
