package com.google.android.gms.maps.model;

import android.os.RemoteException;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.internal.maps.e0 f16687a;

    public f(com.google.android.gms.internal.maps.e0 e0Var) {
        this.f16687a = (com.google.android.gms.internal.maps.e0) com.google.android.gms.common.internal.u.k(e0Var);
    }

    public void a() {
        try {
            this.f16687a.b();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    @m0
    public String b() {
        try {
            return this.f16687a.c();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    @m0
    public String c() {
        try {
            return this.f16687a.d();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public boolean equals(@o0 Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        try {
            return this.f16687a.I3(((f) obj).f16687a);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public int hashCode() {
        try {
            return this.f16687a.a();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }
}
