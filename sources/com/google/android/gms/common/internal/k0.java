package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
final class k0 extends n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f15756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Activity f15757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f15758c;

    k0(Intent intent, Activity activity, int i7) {
        this.f15756a = intent;
        this.f15757b = activity;
        this.f15758c = i7;
    }

    @Override // com.google.android.gms.common.internal.n0
    public final void a() {
        Intent intent = this.f15756a;
        if (intent != null) {
            this.f15757b.startActivityForResult(intent, this.f15758c);
        }
    }
}
