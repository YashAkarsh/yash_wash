package com.google.android.gms.maps.model;

import android.os.RemoteException;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.internal.maps.h0 f16691a;

    public h(com.google.android.gms.internal.maps.h0 h0Var) {
        this.f16691a = (com.google.android.gms.internal.maps.h0) com.google.android.gms.common.internal.u.k(h0Var);
    }

    public void A(float f8) {
        try {
            this.f16691a.C(f8);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void B() {
        try {
            this.f16691a.h0();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public float a() {
        try {
            return this.f16691a.a();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    @m0
    public String b() {
        try {
            return this.f16691a.l();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    @m0
    public LatLng c() {
        try {
            return this.f16691a.f();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public float d() {
        try {
            return this.f16691a.c();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    @o0
    public String e() {
        try {
            return this.f16691a.s();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public boolean equals(@o0 Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        try {
            return this.f16691a.E3(((h) obj).f16691a);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    @o0
    public Object f() {
        try {
            return com.google.android.gms.dynamic.f.y0(this.f16691a.h());
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    @o0
    public String g() {
        try {
            return this.f16691a.r();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public float h() {
        try {
            return this.f16691a.d();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public int hashCode() {
        try {
            return this.f16691a.b();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void i() {
        try {
            this.f16691a.o();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public boolean j() {
        try {
            return this.f16691a.A();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public boolean k() {
        try {
            return this.f16691a.D();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public boolean l() {
        try {
            return this.f16691a.O0();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public boolean m() {
        try {
            return this.f16691a.T1();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void n() {
        try {
            this.f16691a.q();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void o(float f8) {
        try {
            this.f16691a.r0(f8);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void p(float f8, float f9) {
        try {
            this.f16691a.R5(f8, f9);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void q(boolean z7) {
        try {
            this.f16691a.p4(z7);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void r(boolean z7) {
        try {
            this.f16691a.n0(z7);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void s(@o0 a aVar) {
        try {
            if (aVar == null) {
                this.f16691a.d0(null);
            } else {
                this.f16691a.d0(aVar.a());
            }
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void t(float f8, float f9) {
        try {
            this.f16691a.e3(f8, f9);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void u(@m0 LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("latlng cannot be null - a position is required.");
        }
        try {
            this.f16691a.T5(latLng);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void v(float f8) {
        try {
            this.f16691a.s1(f8);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void w(@o0 String str) {
        try {
            this.f16691a.K2(str);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void x(@o0 Object obj) {
        try {
            this.f16691a.b0(com.google.android.gms.dynamic.f.z3(obj));
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void y(@o0 String str) {
        try {
            this.f16691a.s4(str);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void z(boolean z7) {
        try {
            this.f16691a.j0(z7);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }
}
