package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;

/* JADX INFO: loaded from: classes.dex */
final class t3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r3 f15413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ u3 f15414b;

    t3(u3 u3Var, r3 r3Var) {
        this.f15414b = u3Var;
        this.f15413a = r3Var;
    }

    @Override // java.lang.Runnable
    @c.j0
    public final void run() {
        if (this.f15414b.f15429b) {
            ConnectionResult connectionResultB = this.f15413a.b();
            if (connectionResultB.r0()) {
                u3 u3Var = this.f15414b;
                u3Var.f15136a.startActivityForResult(GoogleApiActivity.a(u3Var.b(), (PendingIntent) com.google.android.gms.common.internal.u.k(connectionResultB.p0()), this.f15413a.a(), false), 1);
                return;
            }
            u3 u3Var2 = this.f15414b;
            if (u3Var2.f15432e.e(u3Var2.b(), connectionResultB.K(), null) != null) {
                u3 u3Var3 = this.f15414b;
                u3Var3.f15432e.K(u3Var3.b(), this.f15414b.f15136a, connectionResultB.K(), 2, this.f15414b);
            } else {
                if (connectionResultB.K() != 18) {
                    this.f15414b.m(connectionResultB, this.f15413a.a());
                    return;
                }
                u3 u3Var4 = this.f15414b;
                Dialog dialogF = u3Var4.f15432e.F(u3Var4.b(), this.f15414b);
                u3 u3Var5 = this.f15414b;
                u3Var5.f15432e.G(u3Var5.b().getApplicationContext(), new s3(this, dialogF));
            }
        }
    }
}
