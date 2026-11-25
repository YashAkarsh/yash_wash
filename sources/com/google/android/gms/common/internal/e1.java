package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
abstract class e1 extends q1<Boolean> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f15708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @c.o0
    public final Bundle f15709e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ e f15710f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @c.g
    protected e1(e eVar, @c.o0 int i7, Bundle bundle) {
        super(eVar, Boolean.TRUE);
        this.f15710f = eVar;
        this.f15708d = i7;
        this.f15709e = bundle;
    }

    @Override // com.google.android.gms.common.internal.q1
    protected final /* bridge */ /* synthetic */ void a(Boolean bool) {
        if (this.f15708d != 0) {
            this.f15710f.q0(1, null);
            Bundle bundle = this.f15709e;
            f(new ConnectionResult(this.f15708d, bundle != null ? (PendingIntent) bundle.getParcelable(e.G) : null));
        } else {
            if (g()) {
                return;
            }
            this.f15710f.q0(1, null);
            f(new ConnectionResult(8, null));
        }
    }

    @Override // com.google.android.gms.common.internal.q1
    protected final void b() {
    }

    protected abstract void f(ConnectionResult connectionResult);

    protected abstract boolean g();
}
