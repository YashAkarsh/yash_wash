package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
final class f4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ LifecycleCallback f15210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f15211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ g4 f15212c;

    f4(g4 g4Var, LifecycleCallback lifecycleCallback, String str) {
        this.f15212c = g4Var;
        this.f15210a = lifecycleCallback;
        this.f15211b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g4 g4Var = this.f15212c;
        if (g4Var.f15233b > 0) {
            this.f15210a.g(g4Var.f15234c != null ? g4Var.f15234c.getBundle(this.f15211b) : null);
        }
        if (this.f15212c.f15233b >= 2) {
            this.f15210a.k();
        }
        if (this.f15212c.f15233b >= 3) {
            this.f15210a.i();
        }
        if (this.f15212c.f15233b >= 4) {
            this.f15210a.l();
        }
        if (this.f15212c.f15233b >= 5) {
            this.f15210a.h();
        }
    }
}
