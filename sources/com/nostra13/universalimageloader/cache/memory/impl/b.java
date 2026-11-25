package com.nostra13.universalimageloader.cache.memory.impl;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class b<K, V> implements com.nostra13.universalimageloader.cache.memory.c<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.nostra13.universalimageloader.cache.memory.c<K, V> f32612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Comparator<K> f32613b;

    public b(com.nostra13.universalimageloader.cache.memory.c<K, V> cVar, Comparator<K> comparator) {
        this.f32612a = cVar;
        this.f32613b = comparator;
    }

    @Override // com.nostra13.universalimageloader.cache.memory.c
    public void clear() {
        this.f32612a.clear();
    }

    @Override // com.nostra13.universalimageloader.cache.memory.c
    public V get(K k7) {
        return this.f32612a.get(k7);
    }

    @Override // com.nostra13.universalimageloader.cache.memory.c
    public Collection<K> keys() {
        return this.f32612a.keys();
    }

    @Override // com.nostra13.universalimageloader.cache.memory.c
    public boolean put(K k7, V v7) {
        K next;
        synchronized (this.f32612a) {
            Iterator<K> it = this.f32612a.keys().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (this.f32613b.compare(k7, next) != 0);
            if (next != null) {
                this.f32612a.remove(next);
            }
        }
        return this.f32612a.put(k7, v7);
    }

    @Override // com.nostra13.universalimageloader.cache.memory.c
    public void remove(K k7) {
        this.f32612a.remove(k7);
    }
}
