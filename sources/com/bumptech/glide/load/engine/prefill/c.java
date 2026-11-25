package com.bumptech.glide.load.engine.prefill;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<d, Integer> f14447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<d> f14448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f14449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14450d;

    public c(Map<d, Integer> map) {
        this.f14447a = map;
        this.f14448b = new ArrayList(map.keySet());
        Iterator<Integer> it = map.values().iterator();
        while (it.hasNext()) {
            this.f14449c += it.next().intValue();
        }
    }

    public int a() {
        return this.f14449c;
    }

    public boolean b() {
        return this.f14449c == 0;
    }

    public d c() {
        d dVar = this.f14448b.get(this.f14450d);
        Integer num = this.f14447a.get(dVar);
        if (num.intValue() == 1) {
            this.f14447a.remove(dVar);
            this.f14448b.remove(this.f14450d);
        } else {
            this.f14447a.put(dVar, Integer.valueOf(num.intValue() - 1));
        }
        this.f14449c--;
        this.f14450d = this.f14448b.isEmpty() ? 0 : (this.f14450d + 1) % this.f14448b.size();
        return dVar;
    }
}
