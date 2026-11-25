package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class z1 implements com.google.android.gms.common.internal.e.c, x2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.common.api.a.f f15469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c<?> f15470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c.o0
    private com.google.android.gms.common.internal.m f15471c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @c.o0
    private Set<Scope> f15472d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f15473e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ i f15474f;

    public z1(i iVar, com.google.android.gms.common.api.a.f fVar, c<?> cVar) {
        this.f15474f = iVar;
        this.f15469a = fVar;
        this.f15470b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @c.h1
    public final void h() {
        com.google.android.gms.common.internal.m mVar;
        if (!this.f15473e || (mVar = this.f15471c) == null) {
            return;
        }
        this.f15469a.h(mVar, this.f15472d);
    }

    @Override // com.google.android.gms.common.internal.e.c
    public final void a(@c.m0 ConnectionResult connectionResult) {
        this.f15474f.f15264p.post(new y1(this, connectionResult));
    }

    @Override // com.google.android.gms.common.api.internal.x2
    @c.h1
    public final void b(ConnectionResult connectionResult) {
        v1 v1Var = (v1) this.f15474f.f15260l.get(this.f15470b);
        if (v1Var != null) {
            v1Var.F(connectionResult);
        }
    }

    @Override // com.google.android.gms.common.api.internal.x2
    @c.h1
    public final void c(@c.o0 com.google.android.gms.common.internal.m mVar, @c.o0 Set<Scope> set) {
        if (mVar == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            b(new ConnectionResult(4));
        } else {
            this.f15471c = mVar;
            this.f15472d = set;
            h();
        }
    }
}
