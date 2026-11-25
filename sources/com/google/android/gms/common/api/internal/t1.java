package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
final class t1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ u1 f15411a;

    t1(u1 u1Var) {
        this.f15411a = u1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        v1 v1Var = this.f15411a.f15427a;
        v1Var.f15435d.i(v1Var.f15435d.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
