package com.nostra13.universalimageloader.cache.memory;

import com.nostra13.universalimageloader.utils.d;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b<K, V> extends a<K, V> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f32606e = 16;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f32607f = 16777216;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f32608b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<V> f32610d = Collections.synchronizedList(new LinkedList());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicInteger f32609c = new AtomicInteger();

    public b(int i7) {
        this.f32608b = i7;
        if (i7 > 16777216) {
            d.i("You set too large memory cache size (more than %1$d Mb)", 16);
        }
    }

    protected abstract int b(V v7);

    protected int c() {
        return this.f32608b;
    }

    @Override // com.nostra13.universalimageloader.cache.memory.a, com.nostra13.universalimageloader.cache.memory.c
    public void clear() {
        this.f32610d.clear();
        this.f32609c.set(0);
        super.clear();
    }

    protected abstract V d();

    @Override // com.nostra13.universalimageloader.cache.memory.a, com.nostra13.universalimageloader.cache.memory.c
    public boolean put(K k7, V v7) {
        boolean z7;
        int iB = b(v7);
        int iC = c();
        int iAddAndGet = this.f32609c.get();
        if (iB < iC) {
            while (iAddAndGet + iB > iC) {
                V vD = d();
                if (this.f32610d.remove(vD)) {
                    iAddAndGet = this.f32609c.addAndGet(-b(vD));
                }
            }
            this.f32610d.add(v7);
            this.f32609c.addAndGet(iB);
            z7 = true;
        } else {
            z7 = false;
        }
        super.put(k7, v7);
        return z7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.nostra13.universalimageloader.cache.memory.a, com.nostra13.universalimageloader.cache.memory.c
    public void remove(K k7) {
        Object obj = super.get(k7);
        if (obj != null && this.f32610d.remove(obj)) {
            this.f32609c.addAndGet(-b(obj));
        }
        super.remove(k7);
    }
}
