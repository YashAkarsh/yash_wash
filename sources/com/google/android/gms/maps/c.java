package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PointOfInterest;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f16488c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f16489d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f16490e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f16491f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f16492g = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.maps.internal.b f16493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.google.android.gms.maps.n f16494b;

    public interface a {
        void a();

        void onCancel();
    }

    public interface b {
        @c.o0
        View a(@c.m0 com.google.android.gms.maps.model.h hVar);

        @c.o0
        View b(@c.m0 com.google.android.gms.maps.model.h hVar);
    }

    /* JADX INFO: renamed from: com.google.android.gms.maps.c$c, reason: collision with other inner class name */
    @Deprecated
    public interface InterfaceC0187c {
        void a(@c.m0 CameraPosition cameraPosition);
    }

    public interface d {
        void a();
    }

    public interface e {
        void a();
    }

    public interface f {
        void a();
    }

    public interface g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f16495a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f16496b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f16497c = 3;

        void a(int i7);
    }

    public interface h {
        void a(@c.m0 com.google.android.gms.maps.model.c cVar);
    }

    public interface i {
        void a(@c.m0 com.google.android.gms.maps.model.d dVar);
    }

    public interface j {
        void a();

        void b(@c.m0 com.google.android.gms.maps.model.e eVar);
    }

    public interface k {
        void a(@c.m0 com.google.android.gms.maps.model.h hVar);
    }

    public interface l {
        void a(@c.m0 com.google.android.gms.maps.model.h hVar);
    }

    public interface m {
        void a(@c.m0 com.google.android.gms.maps.model.h hVar);
    }

    public interface n {
        void a(@c.m0 LatLng latLng);
    }

    public interface o {
        void a();
    }

    public interface p {
        void a(@c.m0 LatLng latLng);
    }

    public interface q {
        boolean s(@c.m0 com.google.android.gms.maps.model.h hVar);
    }

    public interface r {
        void a(@c.m0 com.google.android.gms.maps.model.h hVar);

        void b(@c.m0 com.google.android.gms.maps.model.h hVar);

        void c(@c.m0 com.google.android.gms.maps.model.h hVar);
    }

    public interface s {
        boolean a();
    }

    @Deprecated
    public interface t {
        void a(@c.m0 Location location);
    }

    public interface u {
        void a(@c.m0 Location location);
    }

    public interface v {
        void a(@c.m0 PointOfInterest pointOfInterest);
    }

    public interface w {
        void a(@c.m0 com.google.android.gms.maps.model.i iVar);
    }

    public interface x {
        void a(@c.m0 com.google.android.gms.maps.model.j jVar);
    }

    public interface y {
        void a(@c.o0 Bitmap bitmap);
    }

    public c(@c.m0 com.google.android.gms.maps.internal.b bVar) {
        this.f16493a = (com.google.android.gms.maps.internal.b) com.google.android.gms.common.internal.u.k(bVar);
    }

    public final boolean A(boolean z7) {
        try {
            return this.f16493a.h1(z7);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void B(@c.o0 b bVar) {
        try {
            if (bVar == null) {
                this.f16493a.f2(null);
            } else {
                this.f16493a.f2(new t0(this, bVar));
            }
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public void C(@c.o0 LatLngBounds latLngBounds) {
        try {
            this.f16493a.u1(latLngBounds);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void D(@c.o0 com.google.android.gms.maps.d dVar) {
        try {
            if (dVar == null) {
                this.f16493a.X1(null);
            } else {
                this.f16493a.X1(new g1(this, dVar));
            }
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public boolean E(@c.o0 MapStyleOptions mapStyleOptions) {
        try {
            return this.f16493a.G2(mapStyleOptions);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void F(int i7) {
        try {
            this.f16493a.O3(i7);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public void G(float f8) {
        try {
            this.f16493a.s3(f8);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public void H(float f8) {
        try {
            this.f16493a.F3(f8);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @c.w0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public final void I(boolean z7) {
        try {
            this.f16493a.H5(z7);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Deprecated
    public final void J(@c.o0 InterfaceC0187c interfaceC0187c) {
        try {
            if (interfaceC0187c == null) {
                this.f16493a.F5(null);
            } else {
                this.f16493a.F5(new h1(this, interfaceC0187c));
            }
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void K(@c.o0 d dVar) {
        try {
            if (dVar == null) {
                this.f16493a.r2(null);
            } else {
                this.f16493a.r2(new l1(this, dVar));
            }
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void L(@c.o0 e eVar) {
        try {
            if (eVar == null) {
                this.f16493a.t1(null);
            } else {
                this.f16493a.t1(new k1(this, eVar));
            }
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void M(@c.o0 f fVar) {
        try {
            if (fVar == null) {
                this.f16493a.t3(null);
            } else {
                this.f16493a.t3(new j1(this, fVar));
            }
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void N(@c.o0 g gVar) {
        try {
            if (gVar == null) {
                this.f16493a.P2(null);
            } else {
                this.f16493a.P2(new i1(this, gVar));
            }
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void O(@c.o0 h hVar) {
        try {
            if (hVar == null) {
                this.f16493a.S3(null);
            } else {
                this.f16493a.S3(new b1(this, hVar));
            }
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void P(@c.o0 i iVar) {
        try {
            if (iVar == null) {
                this.f16493a.O4(null);
            } else {
                this.f16493a.O4(new a1(this, iVar));
            }
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void Q(@c.o0 j jVar) {
        try {
            if (jVar == null) {
                this.f16493a.v1(null);
            } else {
                this.f16493a.v1(new y0(this, jVar));
            }
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void R(@c.o0 k kVar) {
        try {
            if (kVar == null) {
                this.f16493a.Q0(null);
            } else {
                this.f16493a.Q0(new q0(this, kVar));
            }
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void S(@c.o0 l lVar) {
        try {
            if (lVar == null) {
                this.f16493a.n1(null);
            } else {
                this.f16493a.n1(new s0(this, lVar));
            }
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void T(@c.o0 m mVar) {
        try {
            if (mVar == null) {
                this.f16493a.j4(null);
            } else {
                this.f16493a.j4(new r0(this, mVar));
            }
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void U(@c.o0 n nVar) {
        try {
            if (nVar == null) {
                this.f16493a.i3(null);
            } else {
                this.f16493a.i3(new m1(this, nVar));
            }
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public void V(@c.o0 o oVar) {
        try {
            if (oVar == null) {
                this.f16493a.m6(null);
            } else {
                this.f16493a.m6(new x0(this, oVar));
            }
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void W(@c.o0 p pVar) {
        try {
            if (pVar == null) {
                this.f16493a.z5(null);
            } else {
                this.f16493a.z5(new n1(this, pVar));
            }
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void X(@c.o0 q qVar) {
        try {
            if (qVar == null) {
                this.f16493a.M4(null);
            } else {
                this.f16493a.M4(new com.google.android.gms.maps.o(this, qVar));
            }
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void Y(@c.o0 r rVar) {
        try {
            if (rVar == null) {
                this.f16493a.c2(null);
            } else {
                this.f16493a.c2(new p0(this, rVar));
            }
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void Z(@c.o0 s sVar) {
        try {
            if (sVar == null) {
                this.f16493a.y1(null);
            } else {
                this.f16493a.y1(new v0(this, sVar));
            }
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @c.m0
    public final com.google.android.gms.maps.model.c a(@c.m0 CircleOptions circleOptions) {
        try {
            com.google.android.gms.common.internal.u.l(circleOptions, "CircleOptions must not be null.");
            return new com.google.android.gms.maps.model.c(this.f16493a.z1(circleOptions));
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Deprecated
    public final void a0(@c.o0 t tVar) {
        try {
            if (tVar == null) {
                this.f16493a.d5(null);
            } else {
                this.f16493a.d5(new u0(this, tVar));
            }
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @c.o0
    public final com.google.android.gms.maps.model.d b(@c.m0 GroundOverlayOptions groundOverlayOptions) {
        try {
            com.google.android.gms.common.internal.u.l(groundOverlayOptions, "GroundOverlayOptions must not be null.");
            com.google.android.gms.internal.maps.y yVarN3 = this.f16493a.n3(groundOverlayOptions);
            if (yVarN3 != null) {
                return new com.google.android.gms.maps.model.d(yVarN3);
            }
            return null;
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void b0(@c.o0 u uVar) {
        try {
            if (uVar == null) {
                this.f16493a.Y1(null);
            } else {
                this.f16493a.Y1(new w0(this, uVar));
            }
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @c.o0
    public final com.google.android.gms.maps.model.h c(@c.m0 MarkerOptions markerOptions) {
        try {
            com.google.android.gms.common.internal.u.l(markerOptions, "MarkerOptions must not be null.");
            com.google.android.gms.internal.maps.h0 h0VarD6 = this.f16493a.d6(markerOptions);
            if (h0VarD6 != null) {
                return new com.google.android.gms.maps.model.h(h0VarD6);
            }
            return null;
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void c0(@c.o0 v vVar) {
        try {
            if (vVar == null) {
                this.f16493a.X3(null);
            } else {
                this.f16493a.X3(new f1(this, vVar));
            }
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @c.m0
    public final com.google.android.gms.maps.model.i d(@c.m0 PolygonOptions polygonOptions) {
        try {
            com.google.android.gms.common.internal.u.l(polygonOptions, "PolygonOptions must not be null");
            return new com.google.android.gms.maps.model.i(this.f16493a.e4(polygonOptions));
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void d0(@c.o0 w wVar) {
        try {
            if (wVar == null) {
                this.f16493a.d2(null);
            } else {
                this.f16493a.d2(new c1(this, wVar));
            }
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @c.m0
    public final com.google.android.gms.maps.model.j e(@c.m0 PolylineOptions polylineOptions) {
        try {
            com.google.android.gms.common.internal.u.l(polylineOptions, "PolylineOptions must not be null");
            return new com.google.android.gms.maps.model.j(this.f16493a.y5(polylineOptions));
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void e0(@c.o0 x xVar) {
        try {
            if (xVar == null) {
                this.f16493a.O5(null);
            } else {
                this.f16493a.O5(new d1(this, xVar));
            }
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @c.o0
    public final com.google.android.gms.maps.model.l f(@c.m0 TileOverlayOptions tileOverlayOptions) {
        try {
            com.google.android.gms.common.internal.u.l(tileOverlayOptions, "TileOverlayOptions must not be null.");
            com.google.android.gms.internal.maps.h hVarY5 = this.f16493a.Y5(tileOverlayOptions);
            if (hVarY5 != null) {
                return new com.google.android.gms.maps.model.l(hVarY5);
            }
            return null;
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void f0(int i7, int i8, int i9, int i10) {
        try {
            this.f16493a.U1(i7, i8, i9, i10);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void g(@c.m0 com.google.android.gms.maps.a aVar) {
        try {
            com.google.android.gms.common.internal.u.l(aVar, "CameraUpdate must not be null.");
            this.f16493a.o5(aVar.a());
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void g0(boolean z7) {
        try {
            this.f16493a.D3(z7);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void h(@c.m0 com.google.android.gms.maps.a aVar, int i7, @c.o0 a aVar2) {
        try {
            com.google.android.gms.common.internal.u.l(aVar, "CameraUpdate must not be null.");
            this.f16493a.J2(aVar.a(), i7, aVar2 == null ? null : new com.google.android.gms.maps.p(aVar2));
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void h0(@c.m0 y yVar) {
        com.google.android.gms.common.internal.u.l(yVar, "Callback must not be null.");
        i0(yVar, null);
    }

    public final void i(@c.m0 com.google.android.gms.maps.a aVar, @c.o0 a aVar2) {
        try {
            com.google.android.gms.common.internal.u.l(aVar, "CameraUpdate must not be null.");
            this.f16493a.N0(aVar.a(), aVar2 == null ? null : new com.google.android.gms.maps.p(aVar2));
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void i0(@c.m0 y yVar, @c.o0 Bitmap bitmap) {
        com.google.android.gms.common.internal.u.l(yVar, "Callback must not be null.");
        try {
            this.f16493a.V0(new e1(this, yVar), (com.google.android.gms.dynamic.f) (bitmap != null ? com.google.android.gms.dynamic.f.z3(bitmap) : null));
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void j() {
        try {
            this.f16493a.clear();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void j0() {
        try {
            this.f16493a.s5();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @c.m0
    public final CameraPosition k() {
        try {
            return this.f16493a.t2();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @c.o0
    public com.google.android.gms.maps.model.e l() {
        try {
            com.google.android.gms.internal.maps.b0 b0VarZ5 = this.f16493a.Z5();
            if (b0VarZ5 != null) {
                return new com.google.android.gms.maps.model.e(b0VarZ5);
            }
            return null;
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final int m() {
        try {
            return this.f16493a.e1();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final float n() {
        try {
            return this.f16493a.E5();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final float o() {
        try {
            return this.f16493a.K0();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @c.m0
    @Deprecated
    public final Location p() {
        try {
            return this.f16493a.j6();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @c.m0
    public final com.google.android.gms.maps.j q() {
        try {
            return new com.google.android.gms.maps.j(this.f16493a.b5());
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @c.m0
    public final com.google.android.gms.maps.n r() {
        try {
            if (this.f16494b == null) {
                this.f16494b = new com.google.android.gms.maps.n(this.f16493a.x4());
            }
            return this.f16494b;
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final boolean s() {
        try {
            return this.f16493a.K4();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final boolean t() {
        try {
            return this.f16493a.V3();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final boolean u() {
        try {
            return this.f16493a.S1();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final boolean v() {
        try {
            return this.f16493a.p3();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void w(@c.m0 com.google.android.gms.maps.a aVar) {
        try {
            com.google.android.gms.common.internal.u.l(aVar, "CameraUpdate must not be null.");
            this.f16493a.s2(aVar.a());
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public void x() {
        try {
            this.f16493a.Z3();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void y(boolean z7) {
        try {
            this.f16493a.A0(z7);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void z(@c.o0 String str) {
        try {
            this.f16493a.l6(str);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }
}
