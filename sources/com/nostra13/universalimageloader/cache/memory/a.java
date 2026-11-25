package com.nostra13.universalimageloader.cache.memory;

import java.lang.ref.Reference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<K, V> implements c<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<K, Reference<V>> f32605a = Collections.synchronizedMap(new HashMap());

    protected abstract Reference<V> a(V v7);

    @Override // com.nostra13.universalimageloader.cache.memory.c
    public void clear() {
        this.f32605a.clear();
    }

    @Override // com.nostra13.universalimageloader.cache.memory.c
    public V get(K k7) {
        Reference<V> reference = this.f32605a.get(k7);
        if (reference != null) {
            return reference.get();
        }
        return null;
    }

    @Override // com.nostra13.universalimageloader.cache.memory.c
    public Collection<K> keys() {
        HashSet hashSet;
        synchronized (this.f32605a) {
            hashSet = new HashSet(this.f32605a.keySet());
        }
        return hashSet;
    }

    @Override // com.nostra13.universalimageloader.cache.memory.c
    public boolean put(K k7, V v7) {
        this.f32605a.put(k7, a(v7));
        return true;
    }

    @Override // com.nostra13.universalimageloader.cache.memory.c
    public void remove(K k7) {
        this.f32605a.remove(k7);
    }
}
