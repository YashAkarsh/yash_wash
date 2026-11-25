package com.google.common.collect;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
class pf<R, C, V> extends ca<R, C, V> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final R f20906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final C f20907d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final V f20908e;

    pf(R r7, C c8, V v7) {
        this.f20906c = (R) com.google.common.base.e0.E(r7);
        this.f20907d = (C) com.google.common.base.e0.E(c8);
        this.f20908e = (V) com.google.common.base.e0.E(v7);
    }

    @Override // com.google.common.collect.ca, com.google.common.collect.oj
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public v7<R, V> n(C c8) {
        com.google.common.base.e0.E(c8);
        return m(c8) ? v7.z(this.f20906c, this.f20908e) : v7.y();
    }

    @Override // com.google.common.collect.ca, com.google.common.collect.oj
    /* JADX INFO: renamed from: D */
    public v7<C, Map<R, V>> S() {
        return v7.z(this.f20907d, v7.z(this.f20906c, this.f20908e));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ca, com.google.common.collect.h0
    /* JADX INFO: renamed from: H */
    public u8<oj.a<R, C, V>> c() {
        return u8.B(ca.z(this.f20906c, this.f20907d, this.f20908e));
    }

    @Override // com.google.common.collect.ca
    ca.e I() {
        return ca.e.a(this, new int[]{0}, new int[]{0});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ca, com.google.common.collect.h0
    /* JADX INFO: renamed from: J */
    public x6<V> d() {
        return u8.B(this.f20908e);
    }

    @Override // com.google.common.collect.ca, com.google.common.collect.oj
    /* JADX INFO: renamed from: d0 */
    public v7<R, Map<C, V>> f() {
        return v7.z(this.f20906c, v7.z(this.f20907d, this.f20908e));
    }

    @Override // com.google.common.collect.oj
    public int size() {
        return 1;
    }

    pf(oj.a<R, C, V> aVar) {
        this(aVar.b(), aVar.a(), aVar.getValue());
    }
}
