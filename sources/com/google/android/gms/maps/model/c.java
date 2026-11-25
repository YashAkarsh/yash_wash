package com.google.android.gms.maps.model;

import android.os.RemoteException;
import c.m0;
import c.o0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.internal.maps.v f16683a;

    public c(com.google.android.gms.internal.maps.v vVar) {
        this.f16683a = (com.google.android.gms.internal.maps.v) com.google.android.gms.common.internal.u.k(vVar);
    }

    @m0
    public LatLng a() {
        try {
            return this.f16683a.s();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public int b() {
        try {
            return this.f16683a.b();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    @m0
    public String c() {
        try {
            return this.f16683a.r();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public double d() {
        try {
            return this.f16683a.a();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public int e() {
        try {
            return this.f16683a.h();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public final boolean equals(@o0 Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        try {
            return this.f16683a.q3(((c) obj).f16683a);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    @o0
    public List<PatternItem> f() {
        try {
            return PatternItem.s(this.f16683a.o());
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public float g() {
        try {
            return this.f16683a.c();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    @o0
    public Object h() {
        try {
            return com.google.android.gms.dynamic.f.y0(this.f16683a.l());
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public final int hashCode() {
        try {
            return this.f16683a.f();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public float i() {
        try {
            return this.f16683a.d();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public boolean j() {
        try {
            return this.f16683a.Q();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public boolean k() {
        try {
            return this.f16683a.K();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void l() {
        try {
            this.f16683a.q();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void m(@m0 LatLng latLng) {
        try {
            com.google.android.gms.common.internal.u.l(latLng, "center must not be null.");
            this.f16683a.b2(latLng);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void n(boolean z7) {
        try {
            this.f16683a.u(z7);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void o(int i7) {
        try {
            this.f16683a.F(i7);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void p(double d8) {
        try {
            this.f16683a.w4(d8);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void q(int i7) {
        try {
            this.f16683a.p2(i7);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void r(@o0 List<PatternItem> list) {
        try {
            this.f16683a.g0(list);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void s(float f8) {
        try {
            this.f16683a.G3(f8);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void t(@o0 Object obj) {
        try {
            this.f16683a.R(com.google.android.gms.dynamic.f.z3(obj));
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void u(boolean z7) {
        try {
            this.f16683a.r5(z7);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void v(float f8) {
        try {
            this.f16683a.t0(f8);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }
}
