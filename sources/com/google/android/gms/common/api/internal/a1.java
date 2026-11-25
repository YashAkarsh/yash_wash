package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.signin.internal.zak;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
public final class a1 implements k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n1 f15144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lock f15145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f15146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.android.gms.common.h f15147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @c.o0
    private ConnectionResult f15148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f15149f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f15151h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @c.o0
    private com.google.android.gms.signin.f f15154k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f15155l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f15156m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f15157n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @c.o0
    private com.google.android.gms.common.internal.m f15158o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f15159p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f15160q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @c.o0
    private final com.google.android.gms.common.internal.f f15161r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Map<com.google.android.gms.common.api.a<?>, Boolean> f15162s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @c.o0
    private final com.google.android.gms.common.api.a.AbstractC0179a<? extends com.google.android.gms.signin.f, com.google.android.gms.signin.a> f15163t;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f15150g = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Bundle f15152i = new Bundle();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Set<com.google.android.gms.common.api.a.c> f15153j = new HashSet();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final ArrayList<Future<?>> f15164u = new ArrayList<>();

    public a1(n1 n1Var, @c.o0 com.google.android.gms.common.internal.f fVar, Map<com.google.android.gms.common.api.a<?>, Boolean> map, com.google.android.gms.common.h hVar, @c.o0 com.google.android.gms.common.api.a.AbstractC0179a<? extends com.google.android.gms.signin.f, com.google.android.gms.signin.a> abstractC0179a, Lock lock, Context context) {
        this.f15144a = n1Var;
        this.f15161r = fVar;
        this.f15162s = map;
        this.f15147d = hVar;
        this.f15163t = abstractC0179a;
        this.f15145b = lock;
        this.f15146c = context;
    }

    static /* bridge */ /* synthetic */ void B(a1 a1Var, zak zakVar) {
        if (a1Var.o(0)) {
            ConnectionResult connectionResultK = zakVar.K();
            if (!connectionResultK.s0()) {
                if (!a1Var.q(connectionResultK)) {
                    a1Var.l(connectionResultK);
                    return;
                } else {
                    a1Var.i();
                    a1Var.n();
                    return;
                }
            }
            zav zavVar = (zav) com.google.android.gms.common.internal.u.k(zakVar.Q());
            ConnectionResult connectionResultK2 = zavVar.K();
            if (!connectionResultK2.s0()) {
                String strValueOf = String.valueOf(connectionResultK2);
                Log.wtf("GACConnecting", "Sign-in succeeded with resolve account failure: ".concat(strValueOf), new Exception());
                a1Var.l(connectionResultK2);
                return;
            }
            a1Var.f15157n = true;
            a1Var.f15158o = (com.google.android.gms.common.internal.m) com.google.android.gms.common.internal.u.k(zavVar.Q());
            a1Var.f15159p = zavVar.p0();
            a1Var.f15160q = zavVar.r0();
            a1Var.n();
        }
    }

    private final void J() {
        ArrayList<Future<?>> arrayList = this.f15164u;
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            arrayList.get(i7).cancel(true);
        }
        this.f15164u.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void i() {
        this.f15156m = false;
        this.f15144a.f15353p.f15303s = Collections.emptySet();
        for (com.google.android.gms.common.api.a.c<?> cVar : this.f15153j) {
            if (!this.f15144a.f15346i.containsKey(cVar)) {
                this.f15144a.f15346i.put(cVar, new ConnectionResult(17, null));
            }
        }
    }

    @GuardedBy("mLock")
    private final void j(boolean z7) {
        com.google.android.gms.signin.f fVar = this.f15154k;
        if (fVar != null) {
            if (fVar.a() && z7) {
                fVar.b();
            }
            fVar.f();
            this.f15158o = null;
        }
    }

    @GuardedBy("mLock")
    private final void k() {
        this.f15144a.c();
        o1.a().execute(new o0(this));
        com.google.android.gms.signin.f fVar = this.f15154k;
        if (fVar != null) {
            if (this.f15159p) {
                fVar.t((com.google.android.gms.common.internal.m) com.google.android.gms.common.internal.u.k(this.f15158o), this.f15160q);
            }
            j(false);
        }
        Iterator<com.google.android.gms.common.api.a.c<?>> it = this.f15144a.f15346i.keySet().iterator();
        while (it.hasNext()) {
            ((com.google.android.gms.common.api.a.f) com.google.android.gms.common.internal.u.k(this.f15144a.f15345h.get(it.next()))).f();
        }
        this.f15144a.f15354q.a(this.f15152i.isEmpty() ? null : this.f15152i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void l(ConnectionResult connectionResult) {
        J();
        j(!connectionResult.r0());
        this.f15144a.r(connectionResult);
        this.f15144a.f15354q.c(connectionResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void m(ConnectionResult connectionResult, com.google.android.gms.common.api.a<?> aVar, boolean z7) {
        int iB = aVar.c().b();
        if ((!z7 || connectionResult.r0() || this.f15147d.d(connectionResult.K()) != null) && (this.f15148e == null || iB < this.f15149f)) {
            this.f15148e = connectionResult;
            this.f15149f = iB;
        }
        this.f15144a.f15346i.put(aVar.b(), connectionResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void n() {
        if (this.f15151h != 0) {
            return;
        }
        if (!this.f15156m || this.f15157n) {
            ArrayList arrayList = new ArrayList();
            this.f15150g = 1;
            this.f15151h = this.f15144a.f15345h.size();
            for (com.google.android.gms.common.api.a.c<?> cVar : this.f15144a.f15345h.keySet()) {
                if (!this.f15144a.f15346i.containsKey(cVar)) {
                    arrayList.add(this.f15144a.f15345h.get(cVar));
                } else if (p()) {
                    k();
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            this.f15164u.add(o1.a().submit(new t0(this, arrayList)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final boolean o(int i7) {
        if (this.f15150g == i7) {
            return true;
        }
        Log.w("GACConnecting", this.f15144a.f15353p.M());
        Log.w("GACConnecting", "Unexpected callback in ".concat(toString()));
        int i8 = this.f15151h;
        StringBuilder sb = new StringBuilder(33);
        sb.append("mRemainingConnections=");
        sb.append(i8);
        Log.w("GACConnecting", sb.toString());
        String strR = r(this.f15150g);
        String strR2 = r(i7);
        StringBuilder sb2 = new StringBuilder(strR.length() + 70 + strR2.length());
        sb2.append("GoogleApiClient connecting is in step ");
        sb2.append(strR);
        sb2.append(" but received callback for step ");
        sb2.append(strR2);
        Log.e("GACConnecting", sb2.toString(), new Exception());
        l(new ConnectionResult(8, null));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final boolean p() {
        int i7 = this.f15151h - 1;
        this.f15151h = i7;
        if (i7 > 0) {
            return false;
        }
        if (i7 < 0) {
            Log.w("GACConnecting", this.f15144a.f15353p.M());
            Log.wtf("GACConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            l(new ConnectionResult(8, null));
            return false;
        }
        ConnectionResult connectionResult = this.f15148e;
        if (connectionResult == null) {
            return true;
        }
        this.f15144a.f15352o = this.f15149f;
        l(connectionResult);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final boolean q(ConnectionResult connectionResult) {
        return this.f15155l && !connectionResult.r0();
    }

    private static final String r(int i7) {
        return i7 != 0 ? "STEP_GETTING_REMOTE_SERVICE" : "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    }

    static /* bridge */ /* synthetic */ Set y(a1 a1Var) {
        com.google.android.gms.common.internal.f fVar = a1Var.f15161r;
        if (fVar == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(fVar.i());
        Map<com.google.android.gms.common.api.a<?>, com.google.android.gms.common.internal.i0> mapN = a1Var.f15161r.n();
        for (com.google.android.gms.common.api.a<?> aVar : mapN.keySet()) {
            if (!a1Var.f15144a.f15346i.containsKey(aVar.b())) {
                hashSet.addAll(mapN.get(aVar).f15746a);
            }
        }
        return hashSet;
    }

    @Override // com.google.android.gms.common.api.internal.k1
    @GuardedBy("mLock")
    public final void a(@c.o0 Bundle bundle) {
        if (o(1)) {
            if (bundle != null) {
                this.f15152i.putAll(bundle);
            }
            if (p()) {
                k();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final void b() {
    }

    @Override // com.google.android.gms.common.api.internal.k1
    @GuardedBy("mLock")
    public final void c(ConnectionResult connectionResult, com.google.android.gms.common.api.a<?> aVar, boolean z7) {
        if (o(1)) {
            m(connectionResult, aVar, z7);
            if (p()) {
                k();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.k1
    @GuardedBy("mLock")
    public final void d(int i7) {
        l(new ConnectionResult(8, null));
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [com.google.android.gms.common.api.a$f, com.google.android.gms.signin.f] */
    @Override // com.google.android.gms.common.api.internal.k1
    @GuardedBy("mLock")
    public final void e() {
        this.f15144a.f15346i.clear();
        this.f15156m = false;
        w0 w0Var = null;
        this.f15148e = null;
        this.f15150g = 0;
        this.f15155l = true;
        this.f15157n = false;
        this.f15159p = false;
        HashMap map = new HashMap();
        boolean z7 = false;
        for (com.google.android.gms.common.api.a<?> aVar : this.f15162s.keySet()) {
            com.google.android.gms.common.api.a.f fVar = (com.google.android.gms.common.api.a.f) com.google.android.gms.common.internal.u.k(this.f15144a.f15345h.get(aVar.b()));
            z7 |= aVar.c().b() == 1;
            boolean zBooleanValue = this.f15162s.get(aVar).booleanValue();
            if (fVar.w()) {
                this.f15156m = true;
                if (zBooleanValue) {
                    this.f15153j.add(aVar.b());
                } else {
                    this.f15155l = false;
                }
            }
            map.put(fVar, new p0(this, aVar, zBooleanValue));
        }
        if (z7) {
            this.f15156m = false;
        }
        if (this.f15156m) {
            com.google.android.gms.common.internal.u.k(this.f15161r);
            com.google.android.gms.common.internal.u.k(this.f15163t);
            this.f15161r.o(Integer.valueOf(System.identityHashCode(this.f15144a.f15353p)));
            x0 x0Var = new x0(this, w0Var);
            com.google.android.gms.common.api.a.AbstractC0179a<? extends com.google.android.gms.signin.f, com.google.android.gms.signin.a> abstractC0179a = this.f15163t;
            Context context = this.f15146c;
            Looper looperR = this.f15144a.f15353p.r();
            com.google.android.gms.common.internal.f fVar2 = this.f15161r;
            this.f15154k = abstractC0179a.c(context, looperR, fVar2, fVar2.k(), x0Var, x0Var);
        }
        this.f15151h = this.f15144a.f15345h.size();
        this.f15164u.add(o1.a().submit(new s0(this, map)));
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final <A extends com.google.android.gms.common.api.a.b, R extends com.google.android.gms.common.api.t, T extends e.a<R, A>> T f(T t7) {
        this.f15144a.f15353p.f15295k.add(t7);
        return t7;
    }

    @Override // com.google.android.gms.common.api.internal.k1
    @GuardedBy("mLock")
    public final boolean g() {
        J();
        j(true);
        this.f15144a.r(null);
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final <A extends com.google.android.gms.common.api.a.b, T extends e.a<? extends com.google.android.gms.common.api.t, A>> T h(T t7) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
