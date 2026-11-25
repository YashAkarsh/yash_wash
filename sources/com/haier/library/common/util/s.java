package com.haier.library.common.util;

/* JADX INFO: loaded from: classes2.dex */
public class s<K, V> extends j<K, V> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f26612g;

    public s() {
    }

    @Override // com.haier.library.common.util.j
    public void a(K k7, V v7) {
        e3.a.v("expiration key = %s, value = %s", k7, v7);
    }

    @Override // com.haier.library.common.util.j, java.util.Map
    public V put(K k7, V v7) {
        long j7 = this.f26612g;
        return j7 > 0 ? a(k7, v7, j7) : (V) super.put(k7, v7);
    }

    public s(long j7) {
        this.f26612g = j7;
    }
}
