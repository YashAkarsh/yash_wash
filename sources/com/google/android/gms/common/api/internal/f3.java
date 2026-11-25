package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
abstract class f3<T> extends e2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.google.android.gms.tasks.n<T> f15209b;

    public f3(int i7, com.google.android.gms.tasks.n<T> nVar) {
        super(i7);
        this.f15209b = nVar;
    }

    @Override // com.google.android.gms.common.api.internal.n3
    public final void a(@c.m0 Status status) {
        this.f15209b.d(new com.google.android.gms.common.api.b(status));
    }

    @Override // com.google.android.gms.common.api.internal.n3
    public final void b(@c.m0 Exception exc) {
        this.f15209b.d(exc);
    }

    @Override // com.google.android.gms.common.api.internal.n3
    public final void c(v1<?> v1Var) throws DeadObjectException {
        try {
            h(v1Var);
        } catch (DeadObjectException e8) {
            a(n3.e(e8));
            throw e8;
        } catch (RemoteException e9) {
            a(n3.e(e9));
        } catch (RuntimeException e10) {
            this.f15209b.d(e10);
        }
    }

    @Override // com.google.android.gms.common.api.internal.n3
    public void d(@c.m0 h0 h0Var, boolean z7) {
    }

    protected abstract void h(v1<?> v1Var) throws RemoteException;
}
