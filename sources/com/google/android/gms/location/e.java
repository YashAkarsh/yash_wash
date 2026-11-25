package com.google.android.gms.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.internal.location.zzba;
import com.haier.uhome.mesh.bridge.RtkCoreMeshWrapper;

/* JADX INFO: loaded from: classes.dex */
public class e extends com.google.android.gms.common.api.j<com.google.android.gms.common.api.a.d.C0181d> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @c.m0
    public static final String f16334k = "mockLocation";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @c.m0
    public static final String f16335l = "verticalAccuracy";

    @c.g1(otherwise = 3)
    public e(@c.m0 Activity activity) {
        super(activity, m.f16384a, com.google.android.gms.common.api.a.d.f15078l0, (com.google.android.gms.common.api.internal.y) new com.google.android.gms.common.api.internal.b());
    }

    private final com.google.android.gms.tasks.m<Void> O(final zzba zzbaVar, final k kVar, Looper looper, final h0 h0Var, int i7) {
        final com.google.android.gms.common.api.internal.n nVarA = com.google.android.gms.common.api.internal.o.a(kVar, com.google.android.gms.internal.location.h0.a(looper), k.class.getSimpleName());
        final e0 e0Var = new e0(this, nVarA);
        return k(com.google.android.gms.common.api.internal.u.a().c(new com.google.android.gms.common.api.internal.v(this, e0Var, kVar, h0Var, zzbaVar, nVarA) { // from class: com.google.android.gms.location.y

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final e f16422a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final j0 f16423b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final k f16424c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final h0 f16425d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private final zzba f16426e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final com.google.android.gms.common.api.internal.n f16427f;

            {
                this.f16422a = this;
                this.f16423b = e0Var;
                this.f16424c = kVar;
                this.f16425d = h0Var;
                this.f16426e = zzbaVar;
                this.f16427f = nVarA;
            }

            @Override // com.google.android.gms.common.api.internal.v
            public final void accept(Object obj, Object obj2) throws RemoteException {
                this.f16422a.L(this.f16423b, this.f16424c, this.f16425d, this.f16426e, this.f16427f, (com.google.android.gms.internal.location.z) obj, (com.google.android.gms.tasks.n) obj2);
            }
        }).g(e0Var).h(nVarA).f(i7).a());
    }

    @c.m0
    public com.google.android.gms.tasks.m<Void> A() {
        return o(com.google.android.gms.common.api.internal.a0.a().c(j2.f16372a).f(2422).a());
    }

    @c.w0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @c.m0
    public com.google.android.gms.tasks.m<Location> B(int i7, @c.m0 final com.google.android.gms.tasks.a aVar) {
        LocationRequest locationRequestK = LocationRequest.K();
        locationRequestK.d1(i7);
        locationRequestK.V0(0L);
        locationRequestK.T0(0L);
        locationRequestK.L0(30000L);
        final zzba zzbaVarS = zzba.s(null, locationRequestK);
        zzbaVarS.p0(true);
        zzbaVarS.K(RtkCoreMeshWrapper.RTK_PROV_CONNECT_TIMEOUT);
        com.google.android.gms.tasks.m mVarI = i(com.google.android.gms.common.api.internal.a0.a().c(new com.google.android.gms.common.api.internal.v(this, aVar, zzbaVarS) { // from class: com.google.android.gms.location.v

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final e f16414a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final com.google.android.gms.tasks.a f16415b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final zzba f16416c;

            {
                this.f16414a = this;
                this.f16415b = aVar;
                this.f16416c = zzbaVarS;
            }

            @Override // com.google.android.gms.common.api.internal.v
            public final void accept(Object obj, Object obj2) throws RemoteException {
                this.f16414a.M(this.f16415b, this.f16416c, (com.google.android.gms.internal.location.z) obj, (com.google.android.gms.tasks.n) obj2);
            }
        }).e(h2.f16361d).f(2415).a());
        if (aVar == null) {
            return mVarI;
        }
        final com.google.android.gms.tasks.n nVar = new com.google.android.gms.tasks.n(aVar);
        mVarI.o(new com.google.android.gms.tasks.c(nVar) { // from class: com.google.android.gms.location.w

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final com.google.android.gms.tasks.n f16418a;

            {
                this.f16418a = nVar;
            }

            @Override // com.google.android.gms.tasks.c
            public final Object a(com.google.android.gms.tasks.m mVar) {
                com.google.android.gms.tasks.n nVar2 = this.f16418a;
                if (mVar.v()) {
                    nVar2.e((Location) mVar.r());
                } else {
                    Exception excQ = mVar.q();
                    if (excQ != null) {
                        nVar2.b(excQ);
                    }
                }
                return nVar2.a();
            }
        });
        return nVar.a();
    }

    @c.w0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @c.m0
    public com.google.android.gms.tasks.m<Location> C() {
        return i(com.google.android.gms.common.api.internal.a0.a().c(new com.google.android.gms.common.api.internal.v(this) { // from class: com.google.android.gms.location.i2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final e f16366a;

            {
                this.f16366a = this;
            }

            @Override // com.google.android.gms.common.api.internal.v
            public final void accept(Object obj, Object obj2) throws RemoteException {
                this.f16366a.N((com.google.android.gms.internal.location.z) obj, (com.google.android.gms.tasks.n) obj2);
            }
        }).f(2414).a());
    }

    @c.w0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @c.m0
    public com.google.android.gms.tasks.m<LocationAvailability> D() {
        return i(com.google.android.gms.common.api.internal.a0.a().c(x.f16420a).f(2416).a());
    }

    @c.m0
    public com.google.android.gms.tasks.m<Void> E(@c.m0 final PendingIntent pendingIntent) {
        return o(com.google.android.gms.common.api.internal.a0.a().c(new com.google.android.gms.common.api.internal.v(pendingIntent) { // from class: com.google.android.gms.location.a0

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final PendingIntent f16326a;

            {
                this.f16326a = pendingIntent;
            }

            @Override // com.google.android.gms.common.api.internal.v
            public final void accept(Object obj, Object obj2) throws RemoteException {
                ((com.google.android.gms.internal.location.z) obj).B0(this.f16326a, new i0((com.google.android.gms.tasks.n) obj2));
            }
        }).f(2418).a());
    }

    @c.m0
    public com.google.android.gms.tasks.m<Void> F(@c.m0 k kVar) {
        return com.google.android.gms.common.api.internal.b0.c(l(com.google.android.gms.common.api.internal.o.c(kVar, k.class.getSimpleName())));
    }

    @c.w0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @c.m0
    public com.google.android.gms.tasks.m<Void> G(@c.m0 LocationRequest locationRequest, @c.m0 final PendingIntent pendingIntent) {
        final zzba zzbaVarS = zzba.s(null, locationRequest);
        return o(com.google.android.gms.common.api.internal.a0.a().c(new com.google.android.gms.common.api.internal.v(this, zzbaVarS, pendingIntent) { // from class: com.google.android.gms.location.z

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final e f16428a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final zzba f16429b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final PendingIntent f16430c;

            {
                this.f16428a = this;
                this.f16429b = zzbaVarS;
                this.f16430c = pendingIntent;
            }

            @Override // com.google.android.gms.common.api.internal.v
            public final void accept(Object obj, Object obj2) throws RemoteException {
                this.f16428a.K(this.f16429b, this.f16430c, (com.google.android.gms.internal.location.z) obj, (com.google.android.gms.tasks.n) obj2);
            }
        }).f(2417).a());
    }

    @c.w0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @c.m0
    public com.google.android.gms.tasks.m<Void> H(@c.m0 LocationRequest locationRequest, @c.m0 k kVar, @c.m0 Looper looper) {
        return O(zzba.s(null, locationRequest), kVar, looper, null, 2436);
    }

    @c.w0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @c.m0
    public com.google.android.gms.tasks.m<Void> I(@c.m0 final Location location) {
        return o(com.google.android.gms.common.api.internal.a0.a().c(new com.google.android.gms.common.api.internal.v(location) { // from class: com.google.android.gms.location.c0

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Location f16329a;

            {
                this.f16329a = location;
            }

            @Override // com.google.android.gms.common.api.internal.v
            public final void accept(Object obj, Object obj2) throws RemoteException {
                ((com.google.android.gms.internal.location.z) obj).E0(this.f16329a);
                ((com.google.android.gms.tasks.n) obj2).c(null);
            }
        }).f(2421).a());
    }

    @c.w0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @c.m0
    public com.google.android.gms.tasks.m<Void> J(final boolean z7) {
        return o(com.google.android.gms.common.api.internal.a0.a().c(new com.google.android.gms.common.api.internal.v(z7) { // from class: com.google.android.gms.location.b0

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final boolean f16327a;

            {
                this.f16327a = z7;
            }

            @Override // com.google.android.gms.common.api.internal.v
            public final void accept(Object obj, Object obj2) throws RemoteException {
                ((com.google.android.gms.internal.location.z) obj).D0(this.f16327a);
                ((com.google.android.gms.tasks.n) obj2).c(null);
            }
        }).f(2420).a());
    }

    final /* synthetic */ void K(zzba zzbaVar, PendingIntent pendingIntent, com.google.android.gms.internal.location.z zVar, com.google.android.gms.tasks.n nVar) throws RemoteException {
        i0 i0Var = new i0(nVar);
        zzbaVar.Q(r());
        zVar.y0(zzbaVar, pendingIntent, i0Var);
    }

    final /* synthetic */ void L(final j0 j0Var, final k kVar, final h0 h0Var, zzba zzbaVar, com.google.android.gms.common.api.internal.n nVar, com.google.android.gms.internal.location.z zVar, com.google.android.gms.tasks.n nVar2) throws RemoteException {
        g0 g0Var = new g0(nVar2, new h0(this, j0Var, kVar, h0Var) { // from class: com.google.android.gms.location.k2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final e f16376a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final j0 f16377b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final k f16378c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final h0 f16379d;

            {
                this.f16376a = this;
                this.f16377b = j0Var;
                this.f16378c = kVar;
                this.f16379d = h0Var;
            }

            @Override // com.google.android.gms.location.h0
            public final void a() {
                e eVar = this.f16376a;
                j0 j0Var2 = this.f16377b;
                k kVar2 = this.f16378c;
                h0 h0Var2 = this.f16379d;
                j0Var2.b(false);
                eVar.F(kVar2);
                if (h0Var2 != null) {
                    h0Var2.a();
                }
            }
        });
        zzbaVar.Q(r());
        zVar.w0(zzbaVar, nVar, g0Var);
    }

    final /* synthetic */ void M(com.google.android.gms.tasks.a aVar, zzba zzbaVar, com.google.android.gms.internal.location.z zVar, final com.google.android.gms.tasks.n nVar) throws RemoteException {
        final d0 d0Var = new d0(this, nVar);
        if (aVar != null) {
            aVar.b(new com.google.android.gms.tasks.i(this, d0Var) { // from class: com.google.android.gms.location.l2

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private final e f16382a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private final k f16383b;

                {
                    this.f16382a = this;
                    this.f16383b = d0Var;
                }

                @Override // com.google.android.gms.tasks.i
                public final void a() {
                    this.f16382a.F(this.f16383b);
                }
            });
        }
        O(zzbaVar, d0Var, Looper.getMainLooper(), new h0(nVar) { // from class: com.google.android.gms.location.m2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final com.google.android.gms.tasks.n f16391a;

            {
                this.f16391a = nVar;
            }

            @Override // com.google.android.gms.location.h0
            public final void a() {
                this.f16391a.e(null);
            }
        }, 2437).o(new com.google.android.gms.tasks.c(nVar) { // from class: com.google.android.gms.location.u

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final com.google.android.gms.tasks.n f16412a;

            {
                this.f16412a = nVar;
            }

            @Override // com.google.android.gms.tasks.c
            public final Object a(com.google.android.gms.tasks.m mVar) {
                com.google.android.gms.tasks.n nVar2 = this.f16412a;
                if (!mVar.v()) {
                    if (mVar.q() != null) {
                        Exception excQ = mVar.q();
                        if (excQ != null) {
                            nVar2.b(excQ);
                        }
                    } else {
                        nVar2.e(null);
                    }
                }
                return nVar2.a();
            }
        });
    }

    final /* synthetic */ void N(com.google.android.gms.internal.location.z zVar, com.google.android.gms.tasks.n nVar) throws RemoteException {
        nVar.c(zVar.Q0(r()));
    }

    @c.g1(otherwise = 3)
    public e(@c.m0 Context context) {
        super(context, m.f16384a, com.google.android.gms.common.api.a.d.f15078l0, new com.google.android.gms.common.api.internal.b());
    }
}
