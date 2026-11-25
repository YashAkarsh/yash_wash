package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.signin.internal.zak;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class y2 extends com.google.android.gms.signin.internal.c implements com.google.android.gms.common.api.k.b, com.google.android.gms.common.api.k.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final com.google.android.gms.common.api.a.AbstractC0179a<? extends com.google.android.gms.signin.f, com.google.android.gms.signin.a> f15457j = com.google.android.gms.signin.e.f16760c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f15458a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f15459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.google.android.gms.common.api.a.AbstractC0179a<? extends com.google.android.gms.signin.f, com.google.android.gms.signin.a> f15460e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set<Scope> f15461f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.google.android.gms.common.internal.f f15462g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.google.android.gms.signin.f f15463h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private x2 f15464i;

    @c.h1
    public y2(Context context, Handler handler, @c.m0 com.google.android.gms.common.internal.f fVar) {
        com.google.android.gms.common.api.a.AbstractC0179a<? extends com.google.android.gms.signin.f, com.google.android.gms.signin.a> abstractC0179a = f15457j;
        this.f15458a = context;
        this.f15459d = handler;
        this.f15462g = (com.google.android.gms.common.internal.f) com.google.android.gms.common.internal.u.l(fVar, "ClientSettings must not be null");
        this.f15461f = fVar.i();
        this.f15460e = abstractC0179a;
    }

    static /* bridge */ /* synthetic */ void v6(y2 y2Var, zak zakVar) {
        ConnectionResult connectionResultK = zakVar.K();
        if (connectionResultK.s0()) {
            zav zavVar = (zav) com.google.android.gms.common.internal.u.k(zakVar.Q());
            ConnectionResult connectionResultK2 = zavVar.K();
            if (!connectionResultK2.s0()) {
                String strValueOf = String.valueOf(connectionResultK2);
                Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(strValueOf), new Exception());
                y2Var.f15464i.b(connectionResultK2);
                y2Var.f15463h.f();
                return;
            }
            y2Var.f15464i.c(zavVar.Q(), y2Var.f15461f);
        } else {
            y2Var.f15464i.b(connectionResultK);
        }
        y2Var.f15463h.f();
    }

    @Override // com.google.android.gms.signin.internal.c, com.google.android.gms.signin.internal.e
    @c.g
    public final void O1(zak zakVar) {
        this.f15459d.post(new w2(this, zakVar));
    }

    @Override // com.google.android.gms.common.api.internal.f
    @c.h1
    public final void i0(int i7) {
        this.f15463h.f();
    }

    @Override // com.google.android.gms.common.api.internal.q
    @c.h1
    public final void u0(@c.m0 ConnectionResult connectionResult) {
        this.f15464i.b(connectionResult);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.gms.common.api.a$f, com.google.android.gms.signin.f] */
    @c.h1
    public final void w6(x2 x2Var) {
        com.google.android.gms.signin.f fVar = this.f15463h;
        if (fVar != null) {
            fVar.f();
        }
        this.f15462g.o(Integer.valueOf(System.identityHashCode(this)));
        com.google.android.gms.common.api.a.AbstractC0179a<? extends com.google.android.gms.signin.f, com.google.android.gms.signin.a> abstractC0179a = this.f15460e;
        Context context = this.f15458a;
        Looper looper = this.f15459d.getLooper();
        com.google.android.gms.common.internal.f fVar2 = this.f15462g;
        this.f15463h = abstractC0179a.c(context, looper, fVar2, fVar2.k(), this, this);
        this.f15464i = x2Var;
        Set<Scope> set = this.f15461f;
        if (set == null || set.isEmpty()) {
            this.f15459d.post(new v2(this));
        } else {
            this.f15463h.e();
        }
    }

    public final void x6() {
        com.google.android.gms.signin.f fVar = this.f15463h;
        if (fVar != null) {
            fVar.f();
        }
    }

    @Override // com.google.android.gms.common.api.internal.f
    @c.h1
    public final void y0(@c.o0 Bundle bundle) {
        this.f15463h.q(this);
    }
}
