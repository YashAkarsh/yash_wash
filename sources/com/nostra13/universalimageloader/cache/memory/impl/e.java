package com.nostra13.universalimageloader.cache.memory.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e<K, V> implements com.nostra13.universalimageloader.cache.memory.c<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.nostra13.universalimageloader.cache.memory.c<K, V> f32618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f32619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<K, Long> f32620c = Collections.synchronizedMap(new HashMap());

    public e(com.nostra13.universalimageloader.cache.memory.c<K, V> cVar, long j7) {
        this.f32618a = cVar;
        this.f32619b = j7 * 1000;
    }

    @Override // com.nostra13.universalimageloader.cache.memory.c
    public void clear() {
        this.f32618a.clear();
        this.f32620c.clear();
    }

    @Override // com.nostra13.universalimageloader.cache.memory.c
    public V get(K k7) {
        Long l7 = this.f32620c.get(k7);
        if (l7 != null && System.currentTimeMillis() - l7.longValue() > this.f32619b) {
            this.f32618a.remove(k7);
            this.f32620c.remove(k7);
        }
        return this.f32618a.get(k7);
    }

    @Override // com.nostra13.universalimageloader.cache.memory.c
    public Collection<K> keys() {
        return this.f32618a.keys();
    }

    @Override // com.nostra13.universalimageloader.cache.memory.c
    public boolean put(K k7, V v7) {
        boolean zPut = this.f32618a.put(k7, v7);
        if (zPut) {
            this.f32620c.put(k7, Long.valueOf(System.currentTimeMillis()));
        }
        return zPut;
    }

    @Override // com.nostra13.universalimageloader.cache.memory.c
    public void remove(K k7) {
        this.f32618a.remove(k7);
        this.f32620c.remove(k7);
    }
}
