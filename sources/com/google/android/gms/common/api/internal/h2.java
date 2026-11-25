package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
public final class h2 extends u3 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.google.android.gms.tasks.n<Void> f15240f;

    private h2(m mVar) {
        super(mVar, com.google.android.gms.common.g.x());
        this.f15240f = new com.google.android.gms.tasks.n<>();
        this.f15136a.h("GmsAvailabilityHelper", this);
    }

    public static h2 u(@c.m0 Activity activity) {
        m mVarC = LifecycleCallback.c(activity);
        h2 h2Var = (h2) mVarC.l("GmsAvailabilityHelper", h2.class);
        if (h2Var == null) {
            return new h2(mVarC);
        }
        if (h2Var.f15240f.a().u()) {
            h2Var.f15240f = new com.google.android.gms.tasks.n<>();
        }
        return h2Var;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void h() {
        super.h();
        this.f15240f.d(new CancellationException("Host activity was destroyed before Google Play services could be made available."));
    }

    @Override // com.google.android.gms.common.api.internal.u3
    protected final void n(ConnectionResult connectionResult, int i7) {
        String strQ = connectionResult.Q();
        if (strQ == null) {
            strQ = "Error connecting to Google Play services";
        }
        this.f15240f.b(new com.google.android.gms.common.api.b(new Status(connectionResult, strQ, connectionResult.K())));
    }

    @Override // com.google.android.gms.common.api.internal.u3
    protected final void o() {
        Activity activityM = this.f15136a.m();
        if (activityM == null) {
            this.f15240f.d(new com.google.android.gms.common.api.b(new Status(8)));
            return;
        }
        int iJ = this.f15432e.j(activityM);
        if (iJ == 0) {
            this.f15240f.e(null);
        } else {
            if (this.f15240f.a().u()) {
                return;
            }
            t(new ConnectionResult(iJ, null), 0);
        }
    }

    public final com.google.android.gms.tasks.m<Void> v() {
        return this.f15240f.a();
    }
}
