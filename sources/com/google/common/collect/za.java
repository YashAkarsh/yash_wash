package com.google.common.collect;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
final class za<E> extends p8<E> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<E, Integer> f21489e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d7<hd.a<E>> f21490f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f21491g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private transient u8<E> f21492h;

    private za(Map<E, Integer> map, d7<hd.a<E>> d7Var, long j7) {
        this.f21489e = map;
        this.f21490f = d7Var;
        this.f21491g = j7;
    }

    static <E> p8<E> T(Collection<? extends hd.a<? extends E>> collection) {
        hd.a[] aVarArr = (hd.a[]) collection.toArray(new hd.a[0]);
        HashMap mapK0 = wb.k0(aVarArr.length);
        long j7 = 0;
        for (int i7 = 0; i7 < aVarArr.length; i7++) {
            hd.a aVar = aVarArr[i7];
            int count = aVar.getCount();
            j7 += (long) count;
            Object objE = com.google.common.base.e0.E(aVar.getElement());
            mapK0.put(objE, Integer.valueOf(count));
            if (!(aVar instanceof md.k)) {
                aVarArr[i7] = md.m(objE, count);
            }
        }
        return new za(mapK0, d7.k(aVarArr), j7);
    }

    @Override // com.google.common.collect.p8
    hd.a<E> A(int i7) {
        return this.f21490f.get(i7);
    }

    @Override // com.google.common.collect.x6
    boolean h() {
        return false;
    }

    @Override // com.google.common.collect.hd
    public int l0(Object obj) {
        return ((Integer) this.f21489e.getOrDefault(obj, 0)).intValue();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.hd
    public int size() {
        return com.google.common.primitives.c0.x(this.f21491g);
    }

    @Override // com.google.common.collect.p8, com.google.common.collect.hd
    /* JADX INFO: renamed from: x */
    public u8<E> e() {
        u8<E> u8Var = this.f21492h;
        if (u8Var != null) {
            return u8Var;
        }
        p8.c cVar = new p8.c(this.f21490f, this);
        this.f21492h = cVar;
        return cVar;
    }
}
