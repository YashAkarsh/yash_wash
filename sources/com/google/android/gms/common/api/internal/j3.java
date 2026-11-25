package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.e.a;

/* JADX INFO: loaded from: classes.dex */
public final class j3<A extends e.a<? extends com.google.android.gms.common.api.t, com.google.android.gms.common.api.a.b>> extends n3 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final A f15315b;

    public j3(int i7, A a8) {
        super(i7);
        this.f15315b = (A) com.google.android.gms.common.internal.u.l(a8, "Null methods are not runnable.");
    }

    @Override // com.google.android.gms.common.api.internal.n3
    public final void a(@c.m0 Status status) {
        try {
            this.f15315b.a(status);
        } catch (IllegalStateException e8) {
            Log.w("ApiCallRunner", "Exception reporting failure", e8);
        }
    }

    @Override // com.google.android.gms.common.api.internal.n3
    public final void b(@c.m0 Exception exc) {
        String simpleName = exc.getClass().getSimpleName();
        String localizedMessage = exc.getLocalizedMessage();
        StringBuilder sb = new StringBuilder(simpleName.length() + 2 + String.valueOf(localizedMessage).length());
        sb.append(simpleName);
        sb.append(": ");
        sb.append(localizedMessage);
        try {
            this.f15315b.a(new Status(10, sb.toString()));
        } catch (IllegalStateException e8) {
            Log.w("ApiCallRunner", "Exception reporting failure", e8);
        }
    }

    @Override // com.google.android.gms.common.api.internal.n3
    public final void c(v1<?> v1Var) throws DeadObjectException {
        try {
            this.f15315b.A(v1Var.s());
        } catch (RuntimeException e8) {
            b(e8);
        }
    }

    @Override // com.google.android.gms.common.api.internal.n3
    public final void d(@c.m0 h0 h0Var, boolean z7) {
        h0Var.c(this.f15315b, z7);
    }
}
