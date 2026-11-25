package com.google.android.gms.tasks;

/* JADX INFO: loaded from: classes.dex */
final class e0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f16787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ f0 f16788b;

    e0(f0 f0Var, m mVar) {
        this.f16788b = f0Var;
        this.f16787a = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f16788b.f16790b) {
            f0 f0Var = this.f16788b;
            if (f0Var.f16791c != null) {
                f0Var.f16791c.a(this.f16787a);
            }
        }
    }
}
