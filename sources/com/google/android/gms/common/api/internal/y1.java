package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
final class y1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ConnectionResult f15455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ z1 f15456b;

    y1(z1 z1Var, ConnectionResult connectionResult) {
        this.f15456b = z1Var;
        this.f15455a = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        z1 z1Var = this.f15456b;
        v1 v1Var = (v1) z1Var.f15474f.f15260l.get(z1Var.f15470b);
        if (v1Var == null) {
            return;
        }
        if (!this.f15455a.s0()) {
            v1Var.E(this.f15455a, null);
            return;
        }
        this.f15456b.f15473e = true;
        if (this.f15456b.f15469a.w()) {
            this.f15456b.h();
            return;
        }
        try {
            z1 z1Var2 = this.f15456b;
            z1Var2.f15469a.h(null, z1Var2.f15469a.g());
        } catch (SecurityException e8) {
            Log.e("GoogleApiManager", "Failed to get service from broker. ", e8);
            this.f15456b.f15469a.i("Failed to get service from broker.");
            v1Var.E(new ConnectionResult(10), null);
        }
    }
}
