package com.google.android.gms.maps.model;

import android.os.RemoteException;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.internal.maps.h f16697a;

    public l(com.google.android.gms.internal.maps.h hVar) {
        this.f16697a = (com.google.android.gms.internal.maps.h) com.google.android.gms.common.internal.u.k(hVar);
    }

    public void a() {
        try {
            this.f16697a.h();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public boolean b() {
        try {
            return this.f16697a.B();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    @m0
    public String c() {
        try {
            return this.f16697a.b();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public float d() {
        try {
            return this.f16697a.a();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public float e() {
        try {
            return this.f16697a.c();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public boolean equals(@o0 Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        try {
            return this.f16697a.D1(((l) obj).f16697a);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public boolean f() {
        try {
            return this.f16697a.F0();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void g() {
        try {
            this.f16697a.f();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void h(boolean z7) {
        try {
            this.f16697a.g2(z7);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public int hashCode() {
        try {
            return this.f16697a.d();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void i(float f8) {
        try {
            this.f16697a.v2(f8);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void j(boolean z7) {
        try {
            this.f16697a.L(z7);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void k(float f8) {
        try {
            this.f16697a.M0(f8);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }
}
