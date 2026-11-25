package com.google.android.gms.maps.model;

import android.os.RemoteException;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.internal.maps.y f16684a;

    public d(com.google.android.gms.internal.maps.y yVar) {
        this.f16684a = (com.google.android.gms.internal.maps.y) com.google.android.gms.common.internal.u.k(yVar);
    }

    public float a() {
        try {
            return this.f16684a.a();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    @m0
    public LatLngBounds b() {
        try {
            return this.f16684a.r();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public float c() {
        try {
            return this.f16684a.c();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    @m0
    public String d() {
        try {
            return this.f16684a.o();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    @m0
    public LatLng e() {
        try {
            return this.f16684a.s();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public boolean equals(@o0 Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        try {
            return this.f16684a.x5(((d) obj).f16684a);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    @o0
    public Object f() {
        try {
            return com.google.android.gms.dynamic.f.y0(this.f16684a.l());
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public float g() {
        try {
            return this.f16684a.d();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public float h() {
        try {
            return this.f16684a.b();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public int hashCode() {
        try {
            return this.f16684a.f();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public float i() {
        try {
            return this.f16684a.h();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public boolean j() {
        try {
            return this.f16684a.K();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public boolean k() {
        try {
            return this.f16684a.h0();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void l() {
        try {
            this.f16684a.q();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void m(float f8) {
        try {
            this.f16684a.r0(f8);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void n(boolean z7) {
        try {
            this.f16684a.u(z7);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void o(float f8) {
        try {
            this.f16684a.W3(f8);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void p(float f8, float f9) {
        try {
            this.f16684a.z4(f8, f9);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void q(@m0 a aVar) {
        com.google.android.gms.common.internal.u.l(aVar, "imageDescriptor must not be null");
        try {
            this.f16684a.d0(aVar.a());
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void r(@m0 LatLng latLng) {
        try {
            this.f16684a.d4(latLng);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void s(@m0 LatLngBounds latLngBounds) {
        try {
            this.f16684a.L0(latLngBounds);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void t(@o0 Object obj) {
        try {
            this.f16684a.R(com.google.android.gms.dynamic.f.z3(obj));
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void u(float f8) {
        try {
            this.f16684a.a2(f8);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void v(boolean z7) {
        try {
            this.f16684a.W5(z7);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public void w(float f8) {
        try {
            this.f16684a.a6(f8);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }
}
