package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
final class h4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ LifecycleCallback f15242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f15243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ i4 f15244c;

    h4(i4 i4Var, LifecycleCallback lifecycleCallback, String str) {
        this.f15244c = i4Var;
        this.f15242a = lifecycleCallback;
        this.f15243b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i4 i4Var = this.f15244c;
        if (i4Var.f15279b > 0) {
            this.f15242a.g(i4Var.f15280c != null ? i4Var.f15280c.getBundle(this.f15243b) : null);
        }
        if (this.f15244c.f15279b >= 2) {
            this.f15242a.k();
        }
        if (this.f15244c.f15279b >= 3) {
            this.f15242a.i();
        }
        if (this.f15244c.f15279b >= 4) {
            this.f15242a.l();
        }
        if (this.f15244c.f15279b >= 5) {
            this.f15242a.h();
        }
    }
}
