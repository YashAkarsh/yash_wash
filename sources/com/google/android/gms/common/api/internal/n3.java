package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public abstract class n3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15358a;

    public n3(int i7) {
        this.f15358a = i7;
    }

    static /* bridge */ /* synthetic */ Status e(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage());
    }

    public abstract void a(@c.m0 Status status);

    public abstract void b(@c.m0 Exception exc);

    public abstract void c(v1<?> v1Var) throws DeadObjectException;

    public abstract void d(@c.m0 h0 h0Var, boolean z7);
}
