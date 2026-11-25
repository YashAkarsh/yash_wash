package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
public final class i0 extends u3 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final androidx.collection.b<c<?>> f15266f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final i f15267g;

    @g1.d0
    i0(m mVar, i iVar, com.google.android.gms.common.g gVar) {
        super(mVar, gVar);
        this.f15266f = new androidx.collection.b<>();
        this.f15267g = iVar;
        this.f15136a.h("ConnectionlessLifecycleHelper", this);
    }

    @c.j0
    public static void v(Activity activity, i iVar, c<?> cVar) {
        m mVarC = LifecycleCallback.c(activity);
        i0 i0Var = (i0) mVarC.l("ConnectionlessLifecycleHelper", i0.class);
        if (i0Var == null) {
            i0Var = new i0(mVarC, iVar, com.google.android.gms.common.g.x());
        }
        com.google.android.gms.common.internal.u.l(cVar, "ApiKey cannot be null");
        i0Var.f15266f.add(cVar);
        iVar.d(i0Var);
    }

    private final void w() {
        if (this.f15266f.isEmpty()) {
            return;
        }
        this.f15267g.d(this);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void i() {
        super.i();
        w();
    }

    @Override // com.google.android.gms.common.api.internal.u3, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void k() {
        super.k();
        w();
    }

    @Override // com.google.android.gms.common.api.internal.u3, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void l() {
        super.l();
        this.f15267g.e(this);
    }

    @Override // com.google.android.gms.common.api.internal.u3
    protected final void n(ConnectionResult connectionResult, int i7) {
        this.f15267g.M(connectionResult, i7);
    }

    @Override // com.google.android.gms.common.api.internal.u3
    protected final void o() {
        this.f15267g.b();
    }

    final androidx.collection.b<c<?>> u() {
        return this.f15266f;
    }
}
