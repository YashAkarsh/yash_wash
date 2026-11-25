package com.google.android.gms.common;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.o0
    private String f15894a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f15895b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.google.android.gms.internal.common.h<byte[]> f15896c = com.google.android.gms.internal.common.h.o();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.google.android.gms.internal.common.h<byte[]> f15897d = com.google.android.gms.internal.common.h.o();

    r0() {
    }

    final r0 a(long j7) {
        this.f15895b = j7;
        return this;
    }

    final r0 b(List<byte[]> list) {
        com.google.android.gms.common.internal.u.k(list);
        this.f15897d = com.google.android.gms.internal.common.h.n(list);
        return this;
    }

    final r0 c(List<byte[]> list) {
        com.google.android.gms.common.internal.u.k(list);
        this.f15896c = com.google.android.gms.internal.common.h.n(list);
        return this;
    }

    final r0 d(String str) {
        this.f15894a = str;
        return this;
    }

    final t0 e() {
        if (this.f15894a == null) {
            throw new IllegalStateException("packageName must be defined");
        }
        if (this.f15895b < 0) {
            throw new IllegalStateException("minimumStampedVersionNumber must be greater than or equal to 0");
        }
        if (this.f15896c.isEmpty() && this.f15897d.isEmpty()) {
            throw new IllegalStateException("Either orderedTestCerts or orderedProdCerts must have at least one cert");
        }
        return new t0(this.f15894a, this.f15895b, this.f15896c, this.f15897d, null);
    }
}
