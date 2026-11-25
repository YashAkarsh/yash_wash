package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
final class d3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.common.api.t f15185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ g3 f15186b;

    d3(g3 g3Var, com.google.android.gms.common.api.t tVar) {
        this.f15186b = g3Var;
        this.f15185a = tVar;
    }

    @Override // java.lang.Runnable
    @c.h1
    public final void run() {
        com.google.android.gms.common.api.k kVar;
        try {
            try {
                ThreadLocal<Boolean> threadLocal = BasePendingResult.f15119p;
                threadLocal.set(Boolean.TRUE);
                com.google.android.gms.common.api.n nVarC = ((com.google.android.gms.common.api.w) com.google.android.gms.common.internal.u.k(this.f15186b.f15222a)).c(this.f15185a);
                g3 g3Var = this.f15186b;
                g3Var.f15229h.sendMessage(g3Var.f15229h.obtainMessage(0, nVarC));
                threadLocal.set(Boolean.FALSE);
                g3 g3Var2 = this.f15186b;
                g3.q(this.f15185a);
                kVar = (com.google.android.gms.common.api.k) this.f15186b.f15228g.get();
                if (kVar == null) {
                    return;
                }
            } catch (RuntimeException e8) {
                g3 g3Var3 = this.f15186b;
                g3Var3.f15229h.sendMessage(g3Var3.f15229h.obtainMessage(1, e8));
                BasePendingResult.f15119p.set(Boolean.FALSE);
                g3 g3Var4 = this.f15186b;
                g3.q(this.f15185a);
                kVar = (com.google.android.gms.common.api.k) this.f15186b.f15228g.get();
                if (kVar == null) {
                    return;
                }
            }
            kVar.I(this.f15186b);
        } catch (Throwable th) {
            BasePendingResult.f15119p.set(Boolean.FALSE);
            g3 g3Var5 = this.f15186b;
            g3.q(this.f15185a);
            com.google.android.gms.common.api.k kVar2 = (com.google.android.gms.common.api.k) this.f15186b.f15228g.get();
            if (kVar2 != null) {
                kVar2.I(this.f15186b);
            }
            throw th;
        }
    }
}
