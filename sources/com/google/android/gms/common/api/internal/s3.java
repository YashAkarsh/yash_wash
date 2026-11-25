package com.google.android.gms.common.api.internal;

import android.app.Dialog;

/* JADX INFO: loaded from: classes.dex */
final class s3 extends b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Dialog f15403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ t3 f15404b;

    s3(t3 t3Var, Dialog dialog) {
        this.f15404b = t3Var;
        this.f15403a = dialog;
    }

    @Override // com.google.android.gms.common.api.internal.b2
    public final void a() {
        this.f15404b.f15414b.p();
        if (this.f15403a.isShowing()) {
            this.f15403a.dismiss();
        }
    }
}
