package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.gms.maps.model.StreetViewSource;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.maps.internal.g f16534a;

    public interface a {
        void a(@c.m0 StreetViewPanoramaCamera streetViewPanoramaCamera);
    }

    public interface b {
        void a(@c.m0 StreetViewPanoramaLocation streetViewPanoramaLocation);
    }

    public interface c {
        void a(@c.m0 StreetViewPanoramaOrientation streetViewPanoramaOrientation);
    }

    public interface d {
        void a(@c.m0 StreetViewPanoramaOrientation streetViewPanoramaOrientation);
    }

    public k(@c.m0 com.google.android.gms.maps.internal.g gVar) {
        this.f16534a = (com.google.android.gms.maps.internal.g) com.google.android.gms.common.internal.u.l(gVar, "delegate");
    }

    public void a(@c.m0 StreetViewPanoramaCamera streetViewPanoramaCamera, long j7) {
        com.google.android.gms.common.internal.u.k(streetViewPanoramaCamera);
        try {
            this.f16534a.U3(streetViewPanoramaCamera, j7);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @c.m0
    public StreetViewPanoramaLocation b() {
        try {
            return this.f16534a.n2();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @c.m0
    public StreetViewPanoramaCamera c() {
        try {
            return this.f16534a.m5();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public boolean d() {
        try {
            return this.f16534a.q6();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public boolean e() {
        try {
            return this.f16534a.B1();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public boolean f() {
        try {
            return this.f16534a.P0();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public boolean g() {
        try {
            return this.f16534a.V();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @c.o0
    public Point h(@c.m0 StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
        try {
            com.google.android.gms.dynamic.d dVarI5 = this.f16534a.I5(streetViewPanoramaOrientation);
            if (dVarI5 == null) {
                return null;
            }
            return (Point) com.google.android.gms.dynamic.f.y0(dVarI5);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @c.m0
    public StreetViewPanoramaOrientation i(@c.m0 Point point) {
        try {
            return this.f16534a.S4(com.google.android.gms.dynamic.f.z3(point));
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void j(@c.o0 a aVar) {
        try {
            if (aVar == null) {
                this.f16534a.K3(null);
            } else {
                this.f16534a.K3(new z(this, aVar));
            }
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void k(@c.o0 b bVar) {
        try {
            if (bVar == null) {
                this.f16534a.k6(null);
            } else {
                this.f16534a.k6(new y(this, bVar));
            }
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void l(@c.o0 c cVar) {
        try {
            if (cVar == null) {
                this.f16534a.N2(null);
            } else {
                this.f16534a.N2(new a0(this, cVar));
            }
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void m(@c.o0 d dVar) {
        try {
            if (dVar == null) {
                this.f16534a.T2(null);
            } else {
                this.f16534a.T2(new b0(this, dVar));
            }
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public void n(boolean z7) {
        try {
            this.f16534a.w1(z7);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public void o(@c.m0 LatLng latLng) {
        try {
            this.f16534a.C1(latLng);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public void p(@c.m0 LatLng latLng, int i7) {
        try {
            this.f16534a.H4(latLng, i7);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public void q(@c.m0 LatLng latLng, int i7, @c.o0 StreetViewSource streetViewSource) {
        try {
            this.f16534a.g3(latLng, i7, streetViewSource);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public void r(@c.m0 LatLng latLng, @c.o0 StreetViewSource streetViewSource) {
        try {
            this.f16534a.J1(latLng, streetViewSource);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public void s(@c.m0 String str) {
        try {
            this.f16534a.E1(str);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public void t(boolean z7) {
        try {
            this.f16534a.u4(z7);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public void u(boolean z7) {
        try {
            this.f16534a.P4(z7);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public void v(boolean z7) {
        try {
            this.f16534a.C2(z7);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }
}
