package com.google.android.gms.common.internal;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
final class m0 extends n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f15766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.common.api.internal.m f15767b;

    m0(Intent intent, com.google.android.gms.common.api.internal.m mVar, int i7) {
        this.f15766a = intent;
        this.f15767b = mVar;
    }

    @Override // com.google.android.gms.common.internal.n0
    public final void a() {
        Intent intent = this.f15766a;
        if (intent != null) {
            this.f15767b.startActivityForResult(intent, 2);
        }
    }
}
