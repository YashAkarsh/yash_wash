package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.zak;

/* JADX INFO: loaded from: classes.dex */
final class w2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zak f15448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ y2 f15449b;

    w2(y2 y2Var, zak zakVar) {
        this.f15449b = y2Var;
        this.f15448a = zakVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        y2.v6(this.f15449b, this.f15448a);
    }
}
