package com.google.common.collect;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@u1.j(containerOf = {"R", "C", "V"})
@s1.b
final class cg<R, C, V> extends ne<R, C, V> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final ca<Object, Object, Object> f20098g = new cg(d7.x(), u8.A(), u8.A());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final v7<R, v7<C, V>> f20099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final v7<C, v7<R, V>> f20100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int[] f20101e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int[] f20102f;

    cg(d7<oj.a<R, C, V>> d7Var, u8<R> u8Var, u8<C> u8Var2) {
        v7 v7VarV = wb.V(u8Var);
        LinkedHashMap linkedHashMapM0 = wb.m0();
        ck<R> it = u8Var.iterator();
        while (it.hasNext()) {
            linkedHashMapM0.put(it.next(), new LinkedHashMap());
        }
        LinkedHashMap linkedHashMapM1 = wb.m0();
        ck<C> it2 = u8Var2.iterator();
        while (it2.hasNext()) {
            linkedHashMapM1.put(it2.next(), new LinkedHashMap());
        }
        int[] iArr = new int[d7Var.size()];
        int[] iArr2 = new int[d7Var.size()];
        for (int i7 = 0; i7 < d7Var.size(); i7++) {
            oj.a<R, C, V> aVar = d7Var.get(i7);
            R rB = aVar.b();
            C cA = aVar.a();
            V value = aVar.getValue();
            iArr[i7] = ((Integer) v7VarV.get(rB)).intValue();
            Map map = (Map) linkedHashMapM0.get(rB);
            iArr2[i7] = map.size();
            Object objPut = map.put(cA, value);
            if (objPut != null) {
                throw new IllegalArgumentException("Duplicate value for row=" + rB + ", column=" + cA + ": " + value + ", " + objPut);
            }
            ((Map) linkedHashMapM1.get(cA)).put(rB, value);
        }
        this.f20101e = iArr;
        this.f20102f = iArr2;
        v7.b bVar = new v7.b(linkedHashMapM0.size());
        for (Map.Entry entry : linkedHashMapM0.entrySet()) {
            bVar.f(entry.getKey(), v7.g((Map) entry.getValue()));
        }
        this.f20099c = bVar.a();
        v7.b bVar2 = new v7.b(linkedHashMapM1.size());
        for (Map.Entry entry2 : linkedHashMapM1.entrySet()) {
            bVar2.f(entry2.getKey(), v7.g((Map) entry2.getValue()));
        }
        this.f20100d = bVar2.a();
    }

    @Override // com.google.common.collect.ca, com.google.common.collect.oj
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public v7<C, Map<R, V>> S() {
        return v7.g(this.f20100d);
    }

    @Override // com.google.common.collect.ca
    ca.e I() {
        v7 v7VarV = wb.V(L());
        int[] iArr = new int[r().size()];
        ck<oj.a<R, C, V>> it = r().iterator();
        int i7 = 0;
        while (it.hasNext()) {
            iArr[i7] = ((Integer) v7VarV.get(it.next().a())).intValue();
            i7++;
        }
        return ca.e.a(this, this.f20101e, iArr);
    }

    @Override // com.google.common.collect.ca, com.google.common.collect.oj
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public v7<R, Map<C, V>> f() {
        return v7.g(this.f20099c);
    }

    @Override // com.google.common.collect.ne
    oj.a<R, C, V> l0(int i7) {
        Map.Entry<R, v7<C, V>> entry = this.f20099c.entrySet().a().get(this.f20101e[i7]);
        v7<C, V> value = entry.getValue();
        Map.Entry<C, V> entry2 = value.entrySet().a().get(this.f20102f[i7]);
        return ca.z(entry.getKey(), entry2.getKey(), entry2.getValue());
    }

    @Override // com.google.common.collect.ne
    V m0(int i7) {
        v7<C, V> v7Var = this.f20099c.values().a().get(this.f20101e[i7]);
        return v7Var.values().a().get(this.f20102f[i7]);
    }

    @Override // com.google.common.collect.oj
    public int size() {
        return this.f20101e.length;
    }
}
