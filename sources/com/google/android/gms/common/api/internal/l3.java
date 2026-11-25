package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class l3<ResultT> extends e2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a0<com.google.android.gms.common.api.a.b, ResultT> f15324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.android.gms.tasks.n<ResultT> f15325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final y f15326d;

    public l3(int i7, a0<com.google.android.gms.common.api.a.b, ResultT> a0Var, com.google.android.gms.tasks.n<ResultT> nVar, y yVar) {
        super(i7);
        this.f15325c = nVar;
        this.f15324b = a0Var;
        this.f15326d = yVar;
        if (i7 == 2 && a0Var.c()) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // com.google.android.gms.common.api.internal.n3
    public final void a(@c.m0 Status status) {
        this.f15325c.d(this.f15326d.a(status));
    }

    @Override // com.google.android.gms.common.api.internal.n3
    public final void b(@c.m0 Exception exc) {
        this.f15325c.d(exc);
    }

    @Override // com.google.android.gms.common.api.internal.n3
    public final void c(v1<?> v1Var) throws DeadObjectException {
        try {
            this.f15324b.b(v1Var.s(), this.f15325c);
        } catch (DeadObjectException e8) {
            throw e8;
        } catch (RemoteException e9) {
            a(n3.e(e9));
        } catch (RuntimeException e10) {
            this.f15325c.d(e10);
        }
    }

    @Override // com.google.android.gms.common.api.internal.n3
    public final void d(@c.m0 h0 h0Var, boolean z7) {
        h0Var.d(this.f15325c, z7);
    }

    @Override // com.google.android.gms.common.api.internal.e2
    public final boolean f(v1<?> v1Var) {
        return this.f15324b.c();
    }

    @Override // com.google.android.gms.common.api.internal.e2
    @c.o0
    public final Feature[] g(v1<?> v1Var) {
        return this.f15324b.e();
    }
}
