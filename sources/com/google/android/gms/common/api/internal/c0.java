package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.a.b;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public abstract class c0<A extends com.google.android.gms.common.api.a.b, L> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n.a<L> f15173a;

    @c1.a
    protected c0(@c.m0 n.a<L> aVar) {
        this.f15173a = aVar;
    }

    @c1.a
    @c.m0
    public n.a<L> a() {
        return this.f15173a;
    }

    @c1.a
    protected abstract void b(@c.m0 A a8, @c.m0 com.google.android.gms.tasks.n<Boolean> nVar) throws RemoteException;
}
