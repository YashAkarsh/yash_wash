package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
abstract class h0 extends f0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final WeakReference<byte[]> f15580e = new WeakReference<>(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private WeakReference<byte[]> f15581d;

    h0(byte[] bArr) {
        super(bArr);
        this.f15581d = f15580e;
    }

    protected abstract byte[] t6();

    @Override // com.google.android.gms.common.f0
    final byte[] z3() {
        byte[] bArrT6;
        synchronized (this) {
            bArrT6 = this.f15581d.get();
            if (bArrT6 == null) {
                bArrT6 = t6();
                this.f15581d = new WeakReference<>(bArrT6);
            }
        }
        return bArrT6;
    }
}
