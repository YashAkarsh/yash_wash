package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class u3 extends LifecycleCallback implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected volatile boolean f15429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final AtomicReference<r3> f15430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f15431d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final com.google.android.gms.common.g f15432e;

    @g1.d0
    u3(m mVar, com.google.android.gms.common.g gVar) {
        super(mVar);
        this.f15430c = new AtomicReference<>(null);
        this.f15431d = new com.google.android.gms.internal.base.p(Looper.getMainLooper());
        this.f15432e = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(ConnectionResult connectionResult, int i7) {
        this.f15430c.set(null);
        n(connectionResult, i7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        this.f15430c.set(null);
        o();
    }

    private static final int q(@c.o0 r3 r3Var) {
        if (r3Var == null) {
            return -1;
        }
        return r3Var.a();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void f(int i7, int i8, Intent intent) {
        r3 r3Var = this.f15430c.get();
        if (i7 != 1) {
            if (i7 == 2) {
                int iJ = this.f15432e.j(b());
                if (iJ == 0) {
                    p();
                    return;
                } else {
                    if (r3Var == null) {
                        return;
                    }
                    if (r3Var.b().K() == 18 && iJ == 18) {
                        return;
                    }
                }
            }
        } else if (i8 == -1) {
            p();
            return;
        } else if (i8 == 0) {
            if (r3Var == null) {
                return;
            }
            m(new ConnectionResult(intent != null ? intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13, null, r3Var.b().toString()), q(r3Var));
            return;
        }
        if (r3Var != null) {
            m(r3Var.b(), r3Var.a());
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void g(@c.o0 Bundle bundle) {
        super.g(bundle);
        if (bundle != null) {
            this.f15430c.set(bundle.getBoolean("resolving_error", false) ? new r3(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void j(Bundle bundle) {
        super.j(bundle);
        r3 r3Var = this.f15430c.get();
        if (r3Var == null) {
            return;
        }
        bundle.putBoolean("resolving_error", true);
        bundle.putInt("failed_client_id", r3Var.a());
        bundle.putInt("failed_status", r3Var.b().K());
        bundle.putParcelable("failed_resolution", r3Var.b().p0());
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void k() {
        super.k();
        this.f15429b = true;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void l() {
        super.l();
        this.f15429b = false;
    }

    protected abstract void n(ConnectionResult connectionResult, int i7);

    protected abstract void o();

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        m(new ConnectionResult(13, null), q(this.f15430c.get()));
    }

    public final void t(ConnectionResult connectionResult, int i7) {
        r3 r3Var = new r3(connectionResult, i7);
        if (com.facebook.internal.a.a(this.f15430c, null, r3Var)) {
            this.f15431d.post(new t3(this, r3Var));
        }
    }
}
