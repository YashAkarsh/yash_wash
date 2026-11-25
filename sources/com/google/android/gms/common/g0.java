package com.google.android.gms.common;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class g0 extends f0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f15573d;

    g0(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f15573d = bArr;
    }

    @Override // com.google.android.gms.common.f0
    final byte[] z3() {
        return this.f15573d;
    }
}
