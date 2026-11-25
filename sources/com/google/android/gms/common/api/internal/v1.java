package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class v1<O extends com.google.android.gms.common.api.a.d> implements com.google.android.gms.common.api.k.b, com.google.android.gms.common.api.k.c, z3 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @d6.c
    private final com.google.android.gms.common.api.a.f f15435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final c<O> f15436e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final h0 f15437f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f15440i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @c.o0
    private final y2 f15441j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f15442k;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final /* synthetic */ i f15446o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Queue<n3> f15434a = new LinkedList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Set<q3> f15438g = new HashSet();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map<n.a<?>, n2> f15439h = new HashMap();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final List<x1> f15443l = new ArrayList();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @c.o0
    private ConnectionResult f15444m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f15445n = 0;

    @c.h1
    public v1(i iVar, com.google.android.gms.common.api.j<O> jVar) {
        this.f15446o = iVar;
        com.google.android.gms.common.api.a.f fVarW = jVar.w(iVar.f15264p.getLooper(), this);
        this.f15435d = fVarW;
        this.f15436e = jVar.b();
        this.f15437f = new h0();
        this.f15440i = jVar.v();
        if (fVarW.w()) {
            this.f15441j = jVar.x(iVar.f15255g, iVar.f15264p);
        } else {
            this.f15441j = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @c.h1
    @c.o0
    private final Feature b(@c.o0 Feature[] featureArr) {
        if (featureArr != null && featureArr.length != 0) {
            Feature[] featureArrS = this.f15435d.s();
            if (featureArrS == null) {
                featureArrS = new Feature[0];
            }
            androidx.collection.a aVar = new androidx.collection.a(featureArrS.length);
            for (Feature feature : featureArrS) {
                aVar.put(feature.K(), Long.valueOf(feature.Q()));
            }
            for (Feature feature2 : featureArr) {
                Long l7 = (Long) aVar.get(feature2.K());
                if (l7 == null || l7.longValue() < feature2.Q()) {
                    return feature2;
                }
            }
        }
        return null;
    }

    @c.h1
    private final void c(ConnectionResult connectionResult) {
        Iterator<q3> it = this.f15438g.iterator();
        while (it.hasNext()) {
            it.next().c(this.f15436e, connectionResult, com.google.android.gms.common.internal.s.b(connectionResult, ConnectionResult.D) ? this.f15435d.k() : null);
        }
        this.f15438g.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @c.h1
    public final void d(Status status) {
        com.google.android.gms.common.internal.u.d(this.f15446o.f15264p);
        e(status, null, false);
    }

    @c.h1
    private final void e(@c.o0 Status status, @c.o0 Exception exc, boolean z7) {
        com.google.android.gms.common.internal.u.d(this.f15446o.f15264p);
        if ((status == null) == (exc == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator<n3> it = this.f15434a.iterator();
        while (it.hasNext()) {
            n3 next = it.next();
            if (!z7 || next.f15358a == 2) {
                if (status != null) {
                    next.a(status);
                } else {
                    next.b(exc);
                }
                it.remove();
            }
        }
    }

    @c.h1
    private final void f() {
        ArrayList arrayList = new ArrayList(this.f15434a);
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            n3 n3Var = (n3) arrayList.get(i7);
            if (!this.f15435d.a()) {
                return;
            }
            if (l(n3Var)) {
                this.f15434a.remove(n3Var);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @c.h1
    public final void g() {
        A();
        c(ConnectionResult.D);
        k();
        Iterator<n2> it = this.f15439h.values().iterator();
        while (it.hasNext()) {
            n2 next = it.next();
            if (b(next.f15355a.c()) != null) {
                it.remove();
            } else {
                try {
                    next.f15355a.d(this.f15435d, new com.google.android.gms.tasks.n<>());
                } catch (DeadObjectException unused) {
                    i0(3);
                    this.f15435d.i("DeadObjectException thrown while calling register listener method.");
                } catch (RemoteException unused2) {
                    it.remove();
                }
            }
        }
        f();
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @c.h1
    public final void h(int i7) {
        A();
        this.f15442k = true;
        this.f15437f.e(i7, this.f15435d.u());
        i iVar = this.f15446o;
        iVar.f15264p.sendMessageDelayed(Message.obtain(iVar.f15264p, 9, this.f15436e), this.f15446o.f15249a);
        i iVar2 = this.f15446o;
        iVar2.f15264p.sendMessageDelayed(Message.obtain(iVar2.f15264p, 11, this.f15436e), this.f15446o.f15250b);
        this.f15446o.f15257i.c();
        Iterator<n2> it = this.f15439h.values().iterator();
        while (it.hasNext()) {
            it.next().f15357c.run();
        }
    }

    private final void i() {
        this.f15446o.f15264p.removeMessages(12, this.f15436e);
        i iVar = this.f15446o;
        iVar.f15264p.sendMessageDelayed(iVar.f15264p.obtainMessage(12, this.f15436e), this.f15446o.f15251c);
    }

    @c.h1
    private final void j(n3 n3Var) {
        n3Var.d(this.f15437f, M());
        try {
            n3Var.c(this);
        } catch (DeadObjectException unused) {
            i0(1);
            this.f15435d.i("DeadObjectException thrown while running ApiCallRunner.");
        }
    }

    @c.h1
    private final void k() {
        if (this.f15442k) {
            this.f15446o.f15264p.removeMessages(11, this.f15436e);
            this.f15446o.f15264p.removeMessages(9, this.f15436e);
            this.f15442k = false;
        }
    }

    @c.h1
    private final boolean l(n3 n3Var) {
        if (!(n3Var instanceof e2)) {
            j(n3Var);
            return true;
        }
        e2 e2Var = (e2) n3Var;
        Feature featureB = b(e2Var.g(this));
        if (featureB == null) {
            j(n3Var);
            return true;
        }
        String name = this.f15435d.getClass().getName();
        String strK = featureB.K();
        long jQ = featureB.Q();
        StringBuilder sb = new StringBuilder(name.length() + 77 + String.valueOf(strK).length());
        sb.append(name);
        sb.append(" could not execute call because it requires feature (");
        sb.append(strK);
        sb.append(", ");
        sb.append(jQ);
        sb.append(").");
        Log.w("GoogleApiManager", sb.toString());
        if (!this.f15446o.f15265q || !e2Var.f(this)) {
            e2Var.b(new com.google.android.gms.common.api.y(featureB));
            return true;
        }
        x1 x1Var = new x1(this.f15436e, featureB, null);
        int iIndexOf = this.f15443l.indexOf(x1Var);
        if (iIndexOf >= 0) {
            x1 x1Var2 = this.f15443l.get(iIndexOf);
            this.f15446o.f15264p.removeMessages(15, x1Var2);
            i iVar = this.f15446o;
            iVar.f15264p.sendMessageDelayed(Message.obtain(iVar.f15264p, 15, x1Var2), this.f15446o.f15249a);
            return false;
        }
        this.f15443l.add(x1Var);
        i iVar2 = this.f15446o;
        iVar2.f15264p.sendMessageDelayed(Message.obtain(iVar2.f15264p, 15, x1Var), this.f15446o.f15249a);
        i iVar3 = this.f15446o;
        iVar3.f15264p.sendMessageDelayed(Message.obtain(iVar3.f15264p, 16, x1Var), this.f15446o.f15250b);
        ConnectionResult connectionResult = new ConnectionResult(2, null);
        if (m(connectionResult)) {
            return false;
        }
        this.f15446o.h(connectionResult, this.f15440i);
        return false;
    }

    @c.h1
    private final boolean m(@c.m0 ConnectionResult connectionResult) {
        synchronized (i.f15247t) {
            i iVar = this.f15446o;
            if (iVar.f15261m == null || !iVar.f15262n.contains(this.f15436e)) {
                return false;
            }
            this.f15446o.f15261m.t(connectionResult, this.f15440i);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @c.h1
    public final boolean n(boolean z7) {
        com.google.android.gms.common.internal.u.d(this.f15446o.f15264p);
        if (!this.f15435d.a() || this.f15439h.size() != 0) {
            return false;
        }
        if (!this.f15437f.g()) {
            this.f15435d.i("Timing out service connection.");
            return true;
        }
        if (z7) {
            i();
        }
        return false;
    }

    static /* bridge */ /* synthetic */ void y(v1 v1Var, x1 x1Var) {
        if (v1Var.f15443l.contains(x1Var) && !v1Var.f15442k) {
            if (v1Var.f15435d.a()) {
                v1Var.f();
            } else {
                v1Var.B();
            }
        }
    }

    static /* bridge */ /* synthetic */ void z(v1 v1Var, x1 x1Var) {
        Feature[] featureArrG;
        if (v1Var.f15443l.remove(x1Var)) {
            v1Var.f15446o.f15264p.removeMessages(15, x1Var);
            v1Var.f15446o.f15264p.removeMessages(16, x1Var);
            Feature feature = x1Var.f15453b;
            ArrayList arrayList = new ArrayList(v1Var.f15434a.size());
            for (n3 n3Var : v1Var.f15434a) {
                if ((n3Var instanceof e2) && (featureArrG = ((e2) n3Var).g(v1Var)) != null && g1.b.d(featureArrG, feature)) {
                    arrayList.add(n3Var);
                }
            }
            int size = arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                n3 n3Var2 = (n3) arrayList.get(i7);
                v1Var.f15434a.remove(n3Var2);
                n3Var2.b(new com.google.android.gms.common.api.y(feature));
            }
        }
    }

    @c.h1
    public final void A() {
        com.google.android.gms.common.internal.u.d(this.f15446o.f15264p);
        this.f15444m = null;
    }

    @c.h1
    public final void B() {
        com.google.android.gms.common.internal.u.d(this.f15446o.f15264p);
        if (this.f15435d.a() || this.f15435d.j()) {
            return;
        }
        try {
            i iVar = this.f15446o;
            int iB = iVar.f15257i.b(iVar.f15255g, this.f15435d);
            if (iB == 0) {
                i iVar2 = this.f15446o;
                com.google.android.gms.common.api.a.f fVar = this.f15435d;
                z1 z1Var = new z1(iVar2, fVar, this.f15436e);
                if (fVar.w()) {
                    ((y2) com.google.android.gms.common.internal.u.k(this.f15441j)).w6(z1Var);
                }
                try {
                    this.f15435d.l(z1Var);
                    return;
                } catch (SecurityException e8) {
                    E(new ConnectionResult(10), e8);
                    return;
                }
            }
            ConnectionResult connectionResult = new ConnectionResult(iB, null);
            String name = this.f15435d.getClass().getName();
            String string = connectionResult.toString();
            StringBuilder sb = new StringBuilder(name.length() + 35 + string.length());
            sb.append("The service for ");
            sb.append(name);
            sb.append(" is not available: ");
            sb.append(string);
            Log.w("GoogleApiManager", sb.toString());
            E(connectionResult, null);
        } catch (IllegalStateException e9) {
            E(new ConnectionResult(10), e9);
        }
    }

    @c.h1
    public final void C(n3 n3Var) {
        com.google.android.gms.common.internal.u.d(this.f15446o.f15264p);
        if (this.f15435d.a()) {
            if (l(n3Var)) {
                i();
                return;
            } else {
                this.f15434a.add(n3Var);
                return;
            }
        }
        this.f15434a.add(n3Var);
        ConnectionResult connectionResult = this.f15444m;
        if (connectionResult == null || !connectionResult.r0()) {
            B();
        } else {
            E(this.f15444m, null);
        }
    }

    @c.h1
    final void D() {
        this.f15445n++;
    }

    @c.h1
    public final void E(@c.m0 ConnectionResult connectionResult, @c.o0 Exception exc) {
        com.google.android.gms.common.internal.u.d(this.f15446o.f15264p);
        y2 y2Var = this.f15441j;
        if (y2Var != null) {
            y2Var.x6();
        }
        A();
        this.f15446o.f15257i.c();
        c(connectionResult);
        if ((this.f15435d instanceof com.google.android.gms.common.internal.service.q) && connectionResult.K() != 24) {
            this.f15446o.f15252d = true;
            i iVar = this.f15446o;
            iVar.f15264p.sendMessageDelayed(iVar.f15264p.obtainMessage(19), 300000L);
        }
        if (connectionResult.K() == 4) {
            d(i.f15246s);
            return;
        }
        if (this.f15434a.isEmpty()) {
            this.f15444m = connectionResult;
            return;
        }
        if (exc != null) {
            com.google.android.gms.common.internal.u.d(this.f15446o.f15264p);
            e(null, exc, false);
            return;
        }
        if (!this.f15446o.f15265q) {
            d(i.i(this.f15436e, connectionResult));
            return;
        }
        e(i.i(this.f15436e, connectionResult), null, true);
        if (this.f15434a.isEmpty() || m(connectionResult) || this.f15446o.h(connectionResult, this.f15440i)) {
            return;
        }
        if (connectionResult.K() == 18) {
            this.f15442k = true;
        }
        if (!this.f15442k) {
            d(i.i(this.f15436e, connectionResult));
        } else {
            i iVar2 = this.f15446o;
            iVar2.f15264p.sendMessageDelayed(Message.obtain(iVar2.f15264p, 9, this.f15436e), this.f15446o.f15249a);
        }
    }

    @c.h1
    public final void F(@c.m0 ConnectionResult connectionResult) {
        com.google.android.gms.common.internal.u.d(this.f15446o.f15264p);
        com.google.android.gms.common.api.a.f fVar = this.f15435d;
        String name = fVar.getClass().getName();
        String strValueOf = String.valueOf(connectionResult);
        StringBuilder sb = new StringBuilder(name.length() + 25 + strValueOf.length());
        sb.append("onSignInFailed for ");
        sb.append(name);
        sb.append(" with ");
        sb.append(strValueOf);
        fVar.i(sb.toString());
        E(connectionResult, null);
    }

    @c.h1
    public final void G(q3 q3Var) {
        com.google.android.gms.common.internal.u.d(this.f15446o.f15264p);
        this.f15438g.add(q3Var);
    }

    @c.h1
    public final void H() {
        com.google.android.gms.common.internal.u.d(this.f15446o.f15264p);
        if (this.f15442k) {
            B();
        }
    }

    @c.h1
    public final void I() {
        com.google.android.gms.common.internal.u.d(this.f15446o.f15264p);
        d(i.f15245r);
        this.f15437f.f();
        for (n.a aVar : (n.a[]) this.f15439h.keySet().toArray(new n.a[0])) {
            C(new m3(aVar, new com.google.android.gms.tasks.n()));
        }
        c(new ConnectionResult(4));
        if (this.f15435d.a()) {
            this.f15435d.m(new u1(this));
        }
    }

    @c.h1
    public final void J() {
        com.google.android.gms.common.internal.u.d(this.f15446o.f15264p);
        if (this.f15442k) {
            k();
            i iVar = this.f15446o;
            d(iVar.f15256h.j(iVar.f15255g) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.") : new Status(22, "API failed to connect while resuming due to an unknown error."));
            this.f15435d.i("Timing out connection while resuming.");
        }
    }

    final boolean L() {
        return this.f15435d.a();
    }

    public final boolean M() {
        return this.f15435d.w();
    }

    @c.h1
    public final boolean a() {
        return n(true);
    }

    @Override // com.google.android.gms.common.api.internal.f
    public final void i0(int i7) {
        if (Looper.myLooper() == this.f15446o.f15264p.getLooper()) {
            h(i7);
        } else {
            this.f15446o.f15264p.post(new s1(this, i7));
        }
    }

    public final int o() {
        return this.f15440i;
    }

    @c.h1
    final int p() {
        return this.f15445n;
    }

    @c.h1
    @c.o0
    public final ConnectionResult q() {
        com.google.android.gms.common.internal.u.d(this.f15446o.f15264p);
        return this.f15444m;
    }

    public final com.google.android.gms.common.api.a.f s() {
        return this.f15435d;
    }

    public final Map<n.a<?>, n2> u() {
        return this.f15439h;
    }

    @Override // com.google.android.gms.common.api.internal.q
    @c.h1
    public final void u0(@c.m0 ConnectionResult connectionResult) {
        E(connectionResult, null);
    }

    @Override // com.google.android.gms.common.api.internal.f
    public final void y0(@c.o0 Bundle bundle) {
        if (Looper.myLooper() == this.f15446o.f15264p.getLooper()) {
            g();
        } else {
            this.f15446o.f15264p.post(new r1(this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.z3
    public final void z3(ConnectionResult connectionResult, com.google.android.gms.common.api.a<?> aVar, boolean z7) {
        throw null;
    }
}
