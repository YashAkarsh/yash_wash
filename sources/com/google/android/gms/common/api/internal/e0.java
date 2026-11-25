package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
final class e0 implements f2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f15189a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final j1 f15190d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Looper f15191e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final n1 f15192f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final n1 f15193g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map<com.google.android.gms.common.api.a.c<?>, n1> f15194h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @c.o0
    private final com.google.android.gms.common.api.a.f f15196j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @c.o0
    private Bundle f15197k;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lock f15201o;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Set<w> f15195i = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @c.o0
    private ConnectionResult f15198l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @c.o0
    private ConnectionResult f15199m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f15200n = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @GuardedBy("mLock")
    private int f15202p = 0;

    private e0(Context context, j1 j1Var, Lock lock, Looper looper, com.google.android.gms.common.h hVar, Map<com.google.android.gms.common.api.a.c<?>, com.google.android.gms.common.api.a.f> map, Map<com.google.android.gms.common.api.a.c<?>, com.google.android.gms.common.api.a.f> map2, com.google.android.gms.common.internal.f fVar, com.google.android.gms.common.api.a.AbstractC0179a<? extends com.google.android.gms.signin.f, com.google.android.gms.signin.a> abstractC0179a, @c.o0 com.google.android.gms.common.api.a.f fVar2, ArrayList<y3> arrayList, ArrayList<y3> arrayList2, Map<com.google.android.gms.common.api.a<?>, Boolean> map3, Map<com.google.android.gms.common.api.a<?>, Boolean> map4) {
        this.f15189a = context;
        this.f15190d = j1Var;
        this.f15201o = lock;
        this.f15191e = looper;
        this.f15196j = fVar2;
        this.f15192f = new n1(context, j1Var, lock, looper, hVar, map2, null, map4, null, arrayList2, new c4(this, null));
        this.f15193g = new n1(context, j1Var, lock, looper, hVar, map, fVar, map3, abstractC0179a, arrayList, new e4(this, null));
        androidx.collection.a aVar = new androidx.collection.a();
        Iterator<com.google.android.gms.common.api.a.c<?>> it = map2.keySet().iterator();
        while (it.hasNext()) {
            aVar.put(it.next(), this.f15192f);
        }
        Iterator<com.google.android.gms.common.api.a.c<?>> it2 = map.keySet().iterator();
        while (it2.hasNext()) {
            aVar.put(it2.next(), this.f15193g);
        }
        this.f15194h = Collections.unmodifiableMap(aVar);
    }

    static /* bridge */ /* synthetic */ void A(e0 e0Var, int i7, boolean z7) {
        e0Var.f15190d.b(i7, z7);
        e0Var.f15199m = null;
        e0Var.f15198l = null;
    }

    static /* bridge */ /* synthetic */ void B(e0 e0Var, Bundle bundle) {
        Bundle bundle2 = e0Var.f15197k;
        if (bundle2 == null) {
            e0Var.f15197k = bundle;
        } else if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    static /* bridge */ /* synthetic */ void C(e0 e0Var) {
        ConnectionResult connectionResult;
        if (!r(e0Var.f15198l)) {
            if (e0Var.f15198l != null && r(e0Var.f15199m)) {
                e0Var.f15193g.n();
                e0Var.a((ConnectionResult) com.google.android.gms.common.internal.u.k(e0Var.f15198l));
                return;
            }
            ConnectionResult connectionResult2 = e0Var.f15198l;
            if (connectionResult2 == null || (connectionResult = e0Var.f15199m) == null) {
                return;
            }
            if (e0Var.f15193g.f15352o < e0Var.f15192f.f15352o) {
                connectionResult2 = connectionResult;
            }
            e0Var.a(connectionResult2);
            return;
        }
        if (r(e0Var.f15199m) || e0Var.c()) {
            int i7 = e0Var.f15202p;
            if (i7 == 1) {
                e0Var.b();
            } else if (i7 != 2) {
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
            } else {
                ((j1) com.google.android.gms.common.internal.u.k(e0Var.f15190d)).a(e0Var.f15197k);
                e0Var.b();
            }
            e0Var.f15202p = 0;
            return;
        }
        ConnectionResult connectionResult3 = e0Var.f15199m;
        if (connectionResult3 != null) {
            if (e0Var.f15202p == 1) {
                e0Var.b();
            } else {
                e0Var.a(connectionResult3);
                e0Var.f15192f.n();
            }
        }
    }

    @c.o0
    private final PendingIntent E() {
        if (this.f15196j == null) {
            return null;
        }
        return com.google.android.gms.internal.base.k.a(this.f15189a, System.identityHashCode(this.f15190d), this.f15196j.v(), com.google.android.gms.internal.base.k.f16088a | 134217728);
    }

    @GuardedBy("mLock")
    private final void a(ConnectionResult connectionResult) {
        int i7 = this.f15202p;
        if (i7 == 1) {
            b();
        } else if (i7 != 2) {
            Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
        } else {
            this.f15190d.c(connectionResult);
            b();
        }
        this.f15202p = 0;
    }

    @GuardedBy("mLock")
    private final void b() {
        Iterator<w> it = this.f15195i.iterator();
        while (it.hasNext()) {
            it.next().onComplete();
        }
        this.f15195i.clear();
    }

    @GuardedBy("mLock")
    private final boolean c() {
        ConnectionResult connectionResult = this.f15199m;
        return connectionResult != null && connectionResult.K() == 4;
    }

    private final boolean d(e.a<? extends com.google.android.gms.common.api.t, ? extends com.google.android.gms.common.api.a.b> aVar) {
        n1 n1Var = this.f15194h.get(aVar.y());
        com.google.android.gms.common.internal.u.l(n1Var, "GoogleApiClient is not configured to use the API required for this call.");
        return n1Var.equals(this.f15193g);
    }

    private static boolean r(@c.o0 ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.s0();
    }

    public static e0 t(Context context, j1 j1Var, Lock lock, Looper looper, com.google.android.gms.common.h hVar, Map<com.google.android.gms.common.api.a.c<?>, com.google.android.gms.common.api.a.f> map, com.google.android.gms.common.internal.f fVar, Map<com.google.android.gms.common.api.a<?>, Boolean> map2, com.google.android.gms.common.api.a.AbstractC0179a<? extends com.google.android.gms.signin.f, com.google.android.gms.signin.a> abstractC0179a, ArrayList<y3> arrayList) {
        androidx.collection.a aVar = new androidx.collection.a();
        androidx.collection.a aVar2 = new androidx.collection.a();
        com.google.android.gms.common.api.a.f fVar2 = null;
        for (Map.Entry<com.google.android.gms.common.api.a.c<?>, com.google.android.gms.common.api.a.f> entry : map.entrySet()) {
            com.google.android.gms.common.api.a.f value = entry.getValue();
            if (true == value.d()) {
                fVar2 = value;
            }
            if (value.w()) {
                aVar.put(entry.getKey(), value);
            } else {
                aVar2.put(entry.getKey(), value);
            }
        }
        com.google.android.gms.common.internal.u.r(!aVar.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        androidx.collection.a aVar3 = new androidx.collection.a();
        androidx.collection.a aVar4 = new androidx.collection.a();
        for (com.google.android.gms.common.api.a<?> aVar5 : map2.keySet()) {
            com.google.android.gms.common.api.a.c<?> cVarB = aVar5.b();
            if (aVar.containsKey(cVarB)) {
                aVar3.put(aVar5, map2.get(aVar5));
            } else {
                if (!aVar2.containsKey(cVarB)) {
                    throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
                }
                aVar4.put(aVar5, map2.get(aVar5));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            y3 y3Var = arrayList.get(i7);
            if (aVar3.containsKey(y3Var.f15465a)) {
                arrayList2.add(y3Var);
            } else {
                if (!aVar4.containsKey(y3Var.f15465a)) {
                    throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
                }
                arrayList3.add(y3Var);
            }
        }
        return new e0(context, j1Var, lock, looper, hVar, aVar, aVar2, fVar, abstractC0179a, fVar2, arrayList2, arrayList3, aVar3, aVar4);
    }

    @Override // com.google.android.gms.common.api.internal.f2
    @GuardedBy("mLock")
    public final ConnectionResult e() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.common.api.internal.f2
    public final boolean f() {
        this.f15201o.lock();
        try {
            return this.f15202p == 2;
        } finally {
            this.f15201o.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.f2
    @GuardedBy("mLock")
    public final ConnectionResult g(long j7, @c.m0 TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.common.api.internal.f2
    @GuardedBy("mLock")
    public final void h() {
        this.f15202p = 2;
        this.f15200n = false;
        this.f15199m = null;
        this.f15198l = null;
        this.f15192f.h();
        this.f15193g.h();
    }

    @Override // com.google.android.gms.common.api.internal.f2
    @GuardedBy("mLock")
    public final <A extends com.google.android.gms.common.api.a.b, R extends com.google.android.gms.common.api.t, T extends e.a<R, A>> T i(@c.m0 T t7) {
        if (!d(t7)) {
            this.f15192f.i(t7);
            return t7;
        }
        if (c()) {
            t7.a(new Status(4, (String) null, E()));
            return t7;
        }
        this.f15193g.i(t7);
        return t7;
    }

    @Override // com.google.android.gms.common.api.internal.f2
    public final boolean j() {
        this.f15201o.lock();
        try {
            boolean z7 = false;
            if (this.f15192f.j() && (this.f15193g.j() || c() || this.f15202p == 1)) {
                z7 = true;
            }
            return z7;
        } finally {
            this.f15201o.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.f2
    @GuardedBy("mLock")
    public final <A extends com.google.android.gms.common.api.a.b, T extends e.a<? extends com.google.android.gms.common.api.t, A>> T k(@c.m0 T t7) {
        if (!d(t7)) {
            return (T) this.f15192f.k(t7);
        }
        if (!c()) {
            return (T) this.f15193g.k(t7);
        }
        t7.a(new Status(4, (String) null, E()));
        return t7;
    }

    @Override // com.google.android.gms.common.api.internal.f2
    @GuardedBy("mLock")
    public final void l() {
        this.f15192f.l();
        this.f15193g.l();
    }

    @Override // com.google.android.gms.common.api.internal.f2
    public final void m() {
        this.f15201o.lock();
        try {
            boolean zF = f();
            this.f15193g.n();
            this.f15199m = new ConnectionResult(4);
            if (zF) {
                new com.google.android.gms.internal.base.p(this.f15191e).post(new a4(this));
            } else {
                b();
            }
        } finally {
            this.f15201o.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.f2
    @GuardedBy("mLock")
    public final void n() {
        this.f15199m = null;
        this.f15198l = null;
        this.f15202p = 0;
        this.f15192f.n();
        this.f15193g.n();
        b();
    }

    @Override // com.google.android.gms.common.api.internal.f2
    public final boolean o(w wVar) {
        this.f15201o.lock();
        try {
            if ((!f() && !j()) || this.f15193g.j()) {
                return false;
            }
            this.f15195i.add(wVar);
            if (this.f15202p == 0) {
                this.f15202p = 1;
            }
            this.f15199m = null;
            this.f15193g.h();
            return true;
        } finally {
            this.f15201o.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.f2
    public final void p(String str, @c.o0 FileDescriptor fileDescriptor, PrintWriter printWriter, @c.o0 String[] strArr) {
        printWriter.append((CharSequence) str).append("authClient").println(":");
        this.f15193g.p(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append((CharSequence) str).append("anonClient").println(":");
        this.f15192f.p(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    @Override // com.google.android.gms.common.api.internal.f2
    @c.o0
    @GuardedBy("mLock")
    public final ConnectionResult q(@c.m0 com.google.android.gms.common.api.a<?> aVar) {
        if (com.google.android.gms.common.internal.s.b(this.f15194h.get(aVar.b()), this.f15193g)) {
            return c() ? new ConnectionResult(4, E()) : this.f15193g.q(aVar);
        }
        return this.f15192f.q(aVar);
    }
}
