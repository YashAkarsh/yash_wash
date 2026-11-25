package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e0<m> f16167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f16168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f16169c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<com.google.android.gms.common.api.internal.n.a<com.google.android.gms.location.l>, u> f16170d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<com.google.android.gms.common.api.internal.n.a, s> f16171e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<com.google.android.gms.common.api.internal.n.a<com.google.android.gms.location.k>, r> f16172f = new HashMap();

    public v(Context context, e0<m> e0Var) {
        this.f16168b = context;
        this.f16167a = e0Var;
    }

    public final Location a(String str) throws RemoteException {
        ((z0) this.f16167a).f16179a.z();
        return ((z0) this.f16167a).a().W2(str);
    }

    @Deprecated
    public final Location b() throws RemoteException {
        ((z0) this.f16167a).f16179a.z();
        return ((z0) this.f16167a).a().o();
    }

    public final LocationAvailability c() throws RemoteException {
        ((z0) this.f16167a).f16179a.z();
        return ((z0) this.f16167a).a().F1(this.f16168b.getPackageName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(LocationRequest locationRequest, com.google.android.gms.common.api.internal.n<com.google.android.gms.location.l> nVar, i iVar) throws RemoteException {
        u uVar;
        u uVar2;
        ((z0) this.f16167a).f16179a.z();
        com.google.android.gms.common.api.internal.n.a<com.google.android.gms.location.l> aVarB = nVar.b();
        if (aVarB == null) {
            uVar2 = null;
        } else {
            synchronized (this.f16170d) {
                uVar = this.f16170d.get(aVarB);
                if (uVar == null) {
                    uVar = new u(nVar);
                }
                this.f16170d.put(aVarB, uVar);
            }
            uVar2 = uVar;
        }
        if (uVar2 == null) {
            return;
        }
        ((z0) this.f16167a).a().k1(new zzbc(1, zzba.s(null, locationRequest), uVar2, null, null, iVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(zzba zzbaVar, com.google.android.gms.common.api.internal.n<com.google.android.gms.location.k> nVar, i iVar) throws RemoteException {
        r rVar;
        ((z0) this.f16167a).f16179a.z();
        com.google.android.gms.common.api.internal.n.a<com.google.android.gms.location.k> aVarB = nVar.b();
        if (aVarB == null) {
            rVar = null;
        } else {
            synchronized (this.f16172f) {
                r rVar2 = this.f16172f.get(aVarB);
                if (rVar2 == null) {
                    rVar2 = new r(nVar);
                }
                rVar = rVar2;
                this.f16172f.put(aVarB, rVar);
            }
        }
        r rVar3 = rVar;
        if (rVar3 == null) {
            return;
        }
        ((z0) this.f16167a).a().k1(new zzbc(1, zzbaVar, null, null, rVar3, iVar));
    }

    public final void f(zzba zzbaVar, PendingIntent pendingIntent, i iVar) throws RemoteException {
        ((z0) this.f16167a).f16179a.z();
        ((z0) this.f16167a).a().k1(zzbc.K(zzbaVar, pendingIntent, iVar));
    }

    public final void g(LocationRequest locationRequest, PendingIntent pendingIntent, i iVar) throws RemoteException {
        ((z0) this.f16167a).f16179a.z();
        ((z0) this.f16167a).a().k1(zzbc.K(zzba.s(null, locationRequest), pendingIntent, iVar));
    }

    public final void h(com.google.android.gms.common.api.internal.n.a<com.google.android.gms.location.l> aVar, i iVar) throws RemoteException {
        ((z0) this.f16167a).f16179a.z();
        com.google.android.gms.common.internal.u.l(aVar, "Invalid null listener key");
        synchronized (this.f16170d) {
            u uVarRemove = this.f16170d.remove(aVar);
            if (uVarRemove != null) {
                uVarRemove.t();
                ((z0) this.f16167a).a().k1(zzbc.s(uVarRemove, iVar));
            }
        }
    }

    public final void i(com.google.android.gms.common.api.internal.n.a<com.google.android.gms.location.k> aVar, i iVar) throws RemoteException {
        ((z0) this.f16167a).f16179a.z();
        com.google.android.gms.common.internal.u.l(aVar, "Invalid null listener key");
        synchronized (this.f16172f) {
            r rVarRemove = this.f16172f.remove(aVar);
            if (rVarRemove != null) {
                rVarRemove.t();
                ((z0) this.f16167a).a().k1(zzbc.Q(rVarRemove, iVar));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j(PendingIntent pendingIntent, i iVar) throws RemoteException {
        ((z0) this.f16167a).f16179a.z();
        ((z0) this.f16167a).a().k1(new zzbc(2, null, null, pendingIntent, null, iVar));
    }

    public final void k(boolean z7) throws RemoteException {
        ((z0) this.f16167a).f16179a.z();
        ((z0) this.f16167a).a().u(z7);
        this.f16169c = z7;
    }

    public final void l(Location location) throws RemoteException {
        ((z0) this.f16167a).f16179a.z();
        ((z0) this.f16167a).a().f4(location);
    }

    public final void m(i iVar) throws RemoteException {
        ((z0) this.f16167a).f16179a.z();
        ((z0) this.f16167a).a().a5(iVar);
    }

    public final void n() throws RemoteException {
        synchronized (this.f16170d) {
            for (u uVar : this.f16170d.values()) {
                if (uVar != null) {
                    ((z0) this.f16167a).a().k1(zzbc.s(uVar, null));
                }
            }
            this.f16170d.clear();
        }
        synchronized (this.f16172f) {
            for (r rVar : this.f16172f.values()) {
                if (rVar != null) {
                    ((z0) this.f16167a).a().k1(zzbc.Q(rVar, null));
                }
            }
            this.f16172f.clear();
        }
        synchronized (this.f16171e) {
            for (s sVar : this.f16171e.values()) {
                if (sVar != null) {
                    ((z0) this.f16167a).a().C3(new zzl(2, null, sVar, null));
                }
            }
            this.f16171e.clear();
        }
    }

    public final void o() throws RemoteException {
        if (this.f16169c) {
            k(false);
        }
    }
}
