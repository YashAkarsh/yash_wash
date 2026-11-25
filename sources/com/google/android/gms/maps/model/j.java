package com.google.android.gms.maps.model;

import android.os.RemoteException;
import c.m0;
import c.o0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.internal.maps.e f16696a;

    public j(com.google.android.gms.internal.maps.e eVar) {
        this.f16696a = (com.google.android.gms.internal.maps.e) com.google.android.gms.common.internal.u.k(eVar);
    }

    public int a() {
        try {
            return this.f16696a.d();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    @m0
    public Cap b() {
        try {
            return this.f16696a.l().K();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    @m0
    public String c() {
        try {
            return this.f16696a.r();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public int d() {
        try {
            return this.f16696a.b();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    @o0
    public List<PatternItem> e() {
        try {
            return PatternItem.s(this.f16696a.o());
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public boolean equals(@o0 Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        try {
            return this.f16696a.T4(((j) obj).f16696a);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    @m0
    public List<LatLng> f() {
        try {
            return this.f16696a.q();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    @m0
    public Cap g() {
        try {
            return this.f16696a.s().K();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    @o0
    public Object h() {
        try {
            return com.google.android.gms.dynamic.f.y0(this.f16696a.f());
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public int hashCode() {
        try {
            return this.f16696a.h();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public float i() {
        try {
            return this.f16696a.a();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public float j() {
        try {
            return this.f16696a.c();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public boolean k() {
        try {
            return this.f16696a.p0();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public boolean l() {
        try {
            return this.f16696a.A();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public boolean m() {
        try {
            return this.f16696a.D();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void n() {
        try {
            this.f16696a.B();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void o(boolean z7) {
        try {
            this.f16696a.u(z7);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void p(int i7) {
        try {
            this.f16696a.F(i7);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void q(@m0 Cap cap) {
        com.google.android.gms.common.internal.u.l(cap, "endCap must not be null");
        try {
            this.f16696a.h3(cap);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void r(boolean z7) {
        try {
            this.f16696a.O2(z7);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void s(int i7) {
        try {
            this.f16696a.j3(i7);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void t(@o0 List<PatternItem> list) {
        try {
            this.f16696a.e6(list);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void u(@m0 List<LatLng> list) {
        com.google.android.gms.common.internal.u.l(list, "points must not be null");
        try {
            this.f16696a.u5(list);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void v(@m0 Cap cap) {
        com.google.android.gms.common.internal.u.l(cap, "startCap must not be null");
        try {
            this.f16696a.v4(cap);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void w(@o0 Object obj) {
        try {
            this.f16696a.b0(com.google.android.gms.dynamic.f.z3(obj));
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void x(boolean z7) {
        try {
            this.f16696a.R3(z7);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void y(float f8) {
        try {
            this.f16696a.t4(f8);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void z(float f8) {
        try {
            this.f16696a.C(f8);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }
}
