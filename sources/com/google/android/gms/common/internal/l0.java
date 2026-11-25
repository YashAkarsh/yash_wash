package com.google.android.gms.common.internal;

import android.content.Intent;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes.dex */
final class l0 extends n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f15759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Fragment f15760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f15761c;

    l0(Intent intent, Fragment fragment, int i7) {
        this.f15759a = intent;
        this.f15760b = fragment;
        this.f15761c = i7;
    }

    @Override // com.google.android.gms.common.internal.n0
    public final void a() {
        Intent intent = this.f15759a;
        if (intent != null) {
            this.f15760b.startActivityForResult(intent, this.f15761c);
        }
    }
}
