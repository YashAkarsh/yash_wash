package com.google.android.gms.maps.model;

import android.os.RemoteException;
import c.m0;
import c.o0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.internal.maps.b f16694a;

    public i(com.google.android.gms.internal.maps.b bVar) {
        this.f16694a = (com.google.android.gms.internal.maps.b) com.google.android.gms.common.internal.u.k(bVar);
    }

    public int a() {
        try {
            return this.f16694a.d();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    @m0
    public List<List<LatLng>> b() {
        try {
            return this.f16694a.r();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    @m0
    public String c() {
        try {
            return this.f16694a.s();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    @m0
    public List<LatLng> d() {
        try {
            return this.f16694a.o();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public int e() {
        try {
            return this.f16694a.b();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public boolean equals(@o0 Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        try {
            return this.f16694a.C0(((i) obj).f16694a);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public int f() {
        try {
            return this.f16694a.h();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    @o0
    public List<PatternItem> g() {
        try {
            return PatternItem.s(this.f16694a.q());
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public float h() {
        try {
            return this.f16694a.a();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public int hashCode() {
        try {
            return this.f16694a.f();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    @o0
    public Object i() {
        try {
            return com.google.android.gms.dynamic.f.y0(this.f16694a.l());
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public float j() {
        try {
            return this.f16694a.c();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public boolean k() {
        try {
            return this.f16694a.p0();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public boolean l() {
        try {
            return this.f16694a.A();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public boolean m() {
        try {
            return this.f16694a.D();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void n() {
        try {
            this.f16694a.B();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void o(boolean z7) {
        try {
            this.f16694a.u(z7);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void p(int i7) {
        try {
            this.f16694a.F(i7);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void q(boolean z7) {
        try {
            this.f16694a.n0(z7);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void r(@m0 List<? extends List<LatLng>> list) {
        try {
            this.f16694a.f5(list);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void s(@m0 List<LatLng> list) {
        try {
            com.google.android.gms.common.internal.u.l(list, "points must not be null.");
            this.f16694a.g0(list);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void t(int i7) {
        try {
            this.f16694a.J3(i7);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void u(int i7) {
        try {
            this.f16694a.f1(i7);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void v(@o0 List<PatternItem> list) {
        try {
            this.f16694a.L1(list);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void w(float f8) {
        try {
            this.f16694a.t0(f8);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void x(@o0 Object obj) {
        try {
            this.f16694a.y2(com.google.android.gms.dynamic.f.z3(obj));
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void y(boolean z7) {
        try {
            this.f16694a.j0(z7);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void z(float f8) {
        try {
            this.f16694a.C(f8);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }
}
