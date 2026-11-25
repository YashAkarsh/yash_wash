package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.haier.uhome.mesh.bridge.RtkCoreMeshWrapper;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
public final class j1 extends com.google.android.gms.common.api.k implements d2 {
    final i3 A;
    private final com.google.android.gms.common.internal.q0 B;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Lock f15289e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.google.android.gms.common.internal.r0 f15290f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f15292h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Context f15293i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Looper f15294j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile boolean f15296l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f15297m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f15298n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final h1 f15299o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final com.google.android.gms.common.g f15300p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @c.o0
    @g1.d0
    zabx f15301q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    final Map<com.google.android.gms.common.api.a.c<?>, com.google.android.gms.common.api.a.f> f15302r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    Set<Scope> f15303s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final com.google.android.gms.common.internal.f f15304t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final Map<com.google.android.gms.common.api.a<?>, Boolean> f15305u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    final com.google.android.gms.common.api.a.AbstractC0179a<? extends com.google.android.gms.signin.f, com.google.android.gms.signin.a> f15306v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final o f15307w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final ArrayList<y3> f15308x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Integer f15309y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @c.o0
    Set<g3> f15310z;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @c.o0
    private f2 f15291g = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g1.d0
    final Queue<e.a<?, ?>> f15295k = new LinkedList();

    public j1(Context context, Lock lock, Looper looper, com.google.android.gms.common.internal.f fVar, com.google.android.gms.common.g gVar, com.google.android.gms.common.api.a.AbstractC0179a<? extends com.google.android.gms.signin.f, com.google.android.gms.signin.a> abstractC0179a, Map<com.google.android.gms.common.api.a<?>, Boolean> map, List<com.google.android.gms.common.api.k.b> list, List<com.google.android.gms.common.api.k.c> list2, Map<com.google.android.gms.common.api.a.c<?>, com.google.android.gms.common.api.a.f> map2, int i7, int i8, ArrayList<y3> arrayList) {
        this.f15297m = true != g1.e.c() ? 120000L : RtkCoreMeshWrapper.RTK_PROV_CONNECT_TIMEOUT;
        this.f15298n = 5000L;
        this.f15303s = new HashSet();
        this.f15307w = new o();
        this.f15309y = null;
        this.f15310z = null;
        c1 c1Var = new c1(this);
        this.B = c1Var;
        this.f15293i = context;
        this.f15289e = lock;
        this.f15290f = new com.google.android.gms.common.internal.r0(looper, c1Var);
        this.f15294j = looper;
        this.f15299o = new h1(this, looper);
        this.f15300p = gVar;
        this.f15292h = i7;
        if (i7 >= 0) {
            this.f15309y = Integer.valueOf(i8);
        }
        this.f15305u = map;
        this.f15302r = map2;
        this.f15308x = arrayList;
        this.A = new i3();
        Iterator<com.google.android.gms.common.api.k.b> it = list.iterator();
        while (it.hasNext()) {
            this.f15290f.f(it.next());
        }
        Iterator<com.google.android.gms.common.api.k.c> it2 = list2.iterator();
        while (it2.hasNext()) {
            this.f15290f.g(it2.next());
        }
        this.f15304t = fVar;
        this.f15306v = abstractC0179a;
    }

    public static int K(Iterable<com.google.android.gms.common.api.a.f> iterable, boolean z7) {
        boolean zW = false;
        boolean zD = false;
        for (com.google.android.gms.common.api.a.f fVar : iterable) {
            zW |= fVar.w();
            zD |= fVar.d();
        }
        if (zW) {
            return (zD && z7) ? 2 : 1;
        }
        return 3;
    }

    static String N(int i7) {
        if (i7 == 1) {
            return "SIGN_IN_MODE_REQUIRED";
        }
        if (i7 != 2) {
            return i7 != 3 ? "UNKNOWN" : "SIGN_IN_MODE_NONE";
        }
        return "SIGN_IN_MODE_OPTIONAL";
    }

    static /* bridge */ /* synthetic */ void P(j1 j1Var) {
        j1Var.f15289e.lock();
        try {
            if (j1Var.f15296l) {
                j1Var.U();
            }
        } finally {
            j1Var.f15289e.unlock();
        }
    }

    static /* bridge */ /* synthetic */ void Q(j1 j1Var) {
        j1Var.f15289e.lock();
        try {
            if (j1Var.R()) {
                j1Var.U();
            }
        } finally {
            j1Var.f15289e.unlock();
        }
    }

    private final void S(int i7) {
        Integer num = this.f15309y;
        if (num == null) {
            this.f15309y = Integer.valueOf(i7);
        } else if (num.intValue() != i7) {
            String strN = N(i7);
            String strN2 = N(this.f15309y.intValue());
            StringBuilder sb = new StringBuilder(strN.length() + 51 + strN2.length());
            sb.append("Cannot use sign-in mode: ");
            sb.append(strN);
            sb.append(". Mode was already set to ");
            sb.append(strN2);
            throw new IllegalStateException(sb.toString());
        }
        if (this.f15291g != null) {
            return;
        }
        boolean zW = false;
        boolean zD = false;
        for (com.google.android.gms.common.api.a.f fVar : this.f15302r.values()) {
            zW |= fVar.w();
            zD |= fVar.d();
        }
        int iIntValue = this.f15309y.intValue();
        if (iIntValue == 1) {
            if (!zW) {
                throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
            }
            if (zD) {
                throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
        } else if (iIntValue == 2 && zW) {
            this.f15291g = e0.t(this.f15293i, this, this.f15289e, this.f15294j, this.f15300p, this.f15302r, this.f15304t, this.f15305u, this.f15306v, this.f15308x);
            return;
        }
        this.f15291g = new n1(this.f15293i, this, this.f15289e, this.f15294j, this.f15300p, this.f15302r, this.f15304t, this.f15305u, this.f15306v, this.f15308x, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(com.google.android.gms.common.api.k kVar, z zVar, boolean z7) {
        com.google.android.gms.common.internal.service.a.f15799d.a(kVar).h(new g1(this, zVar, z7, kVar));
    }

    @GuardedBy("mLock")
    private final void U() {
        this.f15290f.b();
        ((f2) com.google.android.gms.common.internal.u.k(this.f15291g)).h();
    }

    @Override // com.google.android.gms.common.api.k
    public final void A() {
        i();
        g();
    }

    @Override // com.google.android.gms.common.api.k
    public final void B(@c.m0 com.google.android.gms.common.api.k.b bVar) {
        this.f15290f.f(bVar);
    }

    @Override // com.google.android.gms.common.api.k
    public final void C(@c.m0 com.google.android.gms.common.api.k.c cVar) {
        this.f15290f.g(cVar);
    }

    @Override // com.google.android.gms.common.api.k
    public final <L> n<L> D(@c.m0 L l7) {
        this.f15289e.lock();
        try {
            return this.f15307w.d(l7, this.f15294j, "NO_TYPE");
        } finally {
            this.f15289e.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.k
    public final void E(@c.m0 FragmentActivity fragmentActivity) {
        l lVar = new l((Activity) fragmentActivity);
        if (this.f15292h < 0) {
            throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
        }
        p3.u(lVar).w(this.f15292h);
    }

    @Override // com.google.android.gms.common.api.k
    public final void F(@c.m0 com.google.android.gms.common.api.k.b bVar) {
        this.f15290f.h(bVar);
    }

    @Override // com.google.android.gms.common.api.k
    public final void G(@c.m0 com.google.android.gms.common.api.k.c cVar) {
        this.f15290f.i(cVar);
    }

    @Override // com.google.android.gms.common.api.k
    public final void H(g3 g3Var) {
        this.f15289e.lock();
        try {
            if (this.f15310z == null) {
                this.f15310z = new HashSet();
            }
            this.f15310z.add(g3Var);
        } finally {
            this.f15289e.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.k
    public final void I(g3 g3Var) {
        this.f15289e.lock();
        try {
            Set<g3> set = this.f15310z;
            if (set == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (set.remove(g3Var)) {
                this.f15289e.lock();
                try {
                    Set<g3> set2 = this.f15310z;
                    if (set2 == null) {
                        this.f15289e.unlock();
                    } else {
                        boolean z7 = !set2.isEmpty();
                        this.f15289e.unlock();
                        if (!z7) {
                        }
                    }
                    f2 f2Var = this.f15291g;
                    if (f2Var != null) {
                        f2Var.l();
                    }
                } finally {
                    this.f15289e.unlock();
                }
            } else {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            }
        } catch (Throwable th) {
            this.f15289e.unlock();
            throw th;
        }
    }

    final String M() {
        StringWriter stringWriter = new StringWriter();
        j("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    @GuardedBy("mLock")
    final boolean R() {
        if (!this.f15296l) {
            return false;
        }
        this.f15296l = false;
        this.f15299o.removeMessages(2);
        this.f15299o.removeMessages(1);
        zabx zabxVar = this.f15301q;
        if (zabxVar != null) {
            zabxVar.b();
            this.f15301q = null;
        }
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.d2
    @GuardedBy("mLock")
    public final void a(@c.o0 Bundle bundle) {
        while (!this.f15295k.isEmpty()) {
            m(this.f15295k.remove());
        }
        this.f15290f.d(bundle);
    }

    @Override // com.google.android.gms.common.api.internal.d2
    @GuardedBy("mLock")
    public final void b(int i7, boolean z7) {
        if (i7 == 1) {
            if (!z7 && !this.f15296l) {
                this.f15296l = true;
                if (this.f15301q == null && !g1.e.c()) {
                    try {
                        this.f15301q = this.f15300p.G(this.f15293i.getApplicationContext(), new i1(this));
                    } catch (SecurityException unused) {
                    }
                }
                h1 h1Var = this.f15299o;
                h1Var.sendMessageDelayed(h1Var.obtainMessage(1), this.f15297m);
                h1 h1Var2 = this.f15299o;
                h1Var2.sendMessageDelayed(h1Var2.obtainMessage(2), this.f15298n);
            }
            i7 = 1;
        }
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.A.f15275a.toArray(new BasePendingResult[0])) {
            basePendingResult.l(i3.f15274c);
        }
        this.f15290f.e(i7);
        this.f15290f.a();
        if (i7 == 2) {
            U();
        }
    }

    @Override // com.google.android.gms.common.api.internal.d2
    @GuardedBy("mLock")
    public final void c(ConnectionResult connectionResult) {
        if (!this.f15300p.l(this.f15293i, connectionResult.K())) {
            R();
        }
        if (this.f15296l) {
            return;
        }
        this.f15290f.c(connectionResult);
        this.f15290f.a();
    }

    @Override // com.google.android.gms.common.api.k
    public final ConnectionResult d() {
        boolean z7 = true;
        com.google.android.gms.common.internal.u.r(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.f15289e.lock();
        try {
            if (this.f15292h >= 0) {
                if (this.f15309y == null) {
                    z7 = false;
                }
                com.google.android.gms.common.internal.u.r(z7, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.f15309y;
                if (num == null) {
                    this.f15309y = Integer.valueOf(K(this.f15302r.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            S(((Integer) com.google.android.gms.common.internal.u.k(this.f15309y)).intValue());
            this.f15290f.b();
            ConnectionResult connectionResultE = ((f2) com.google.android.gms.common.internal.u.k(this.f15291g)).e();
            this.f15289e.unlock();
            return connectionResultE;
        } catch (Throwable th) {
            this.f15289e.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.k
    public final ConnectionResult e(long j7, @c.m0 TimeUnit timeUnit) {
        com.google.android.gms.common.internal.u.r(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        com.google.android.gms.common.internal.u.l(timeUnit, "TimeUnit must not be null");
        this.f15289e.lock();
        try {
            Integer num = this.f15309y;
            if (num == null) {
                this.f15309y = Integer.valueOf(K(this.f15302r.values(), false));
            } else if (num.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            S(((Integer) com.google.android.gms.common.internal.u.k(this.f15309y)).intValue());
            this.f15290f.b();
            ConnectionResult connectionResultG = ((f2) com.google.android.gms.common.internal.u.k(this.f15291g)).g(j7, timeUnit);
            this.f15289e.unlock();
            return connectionResultG;
        } catch (Throwable th) {
            this.f15289e.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.k
    public final com.google.android.gms.common.api.n<Status> f() {
        com.google.android.gms.common.internal.u.r(u(), "GoogleApiClient is not connected yet.");
        Integer num = this.f15309y;
        boolean z7 = true;
        if (num != null && num.intValue() == 2) {
            z7 = false;
        }
        com.google.android.gms.common.internal.u.r(z7, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        z zVar = new z(this);
        if (this.f15302r.containsKey(com.google.android.gms.common.internal.service.a.f15796a)) {
            T(this, zVar, false);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            d1 d1Var = new d1(this, atomicReference, zVar);
            f1 f1Var = new f1(this, zVar);
            com.google.android.gms.common.api.k.a aVar = new com.google.android.gms.common.api.k.a(this.f15293i);
            aVar.a(com.google.android.gms.common.internal.service.a.f15797b);
            aVar.e(d1Var);
            aVar.f(f1Var);
            aVar.m(this.f15299o);
            com.google.android.gms.common.api.k kVarH = aVar.h();
            atomicReference.set(kVarH);
            kVarH.g();
        }
        return zVar;
    }

    @Override // com.google.android.gms.common.api.k
    public final void g() {
        this.f15289e.lock();
        try {
            int i7 = 2;
            boolean z7 = false;
            if (this.f15292h >= 0) {
                com.google.android.gms.common.internal.u.r(this.f15309y != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.f15309y;
                if (num == null) {
                    this.f15309y = Integer.valueOf(K(this.f15302r.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            int iIntValue = ((Integer) com.google.android.gms.common.internal.u.k(this.f15309y)).intValue();
            this.f15289e.lock();
            try {
                if (iIntValue != 3 && iIntValue != 1) {
                    if (iIntValue != 2) {
                        i7 = iIntValue;
                    }
                    StringBuilder sb = new StringBuilder(33);
                    sb.append("Illegal sign-in mode: ");
                    sb.append(i7);
                    com.google.android.gms.common.internal.u.b(z7, sb.toString());
                    S(i7);
                    U();
                    this.f15289e.unlock();
                    return;
                }
                i7 = iIntValue;
                StringBuilder sb2 = new StringBuilder(33);
                sb2.append("Illegal sign-in mode: ");
                sb2.append(i7);
                com.google.android.gms.common.internal.u.b(z7, sb2.toString());
                S(i7);
                U();
                this.f15289e.unlock();
                return;
            } finally {
                this.f15289e.unlock();
            }
            z7 = true;
        } catch (Throwable th) {
            this.f15289e.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.k
    public final void h(int i7) {
        this.f15289e.lock();
        boolean z7 = true;
        if (i7 != 3 && i7 != 1) {
            if (i7 == 2) {
                i7 = 2;
            } else {
                z7 = false;
            }
        }
        try {
            StringBuilder sb = new StringBuilder(33);
            sb.append("Illegal sign-in mode: ");
            sb.append(i7);
            com.google.android.gms.common.internal.u.b(z7, sb.toString());
            S(i7);
            U();
        } finally {
            this.f15289e.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.k
    public final void i() {
        Lock lock;
        this.f15289e.lock();
        try {
            this.A.b();
            f2 f2Var = this.f15291g;
            if (f2Var != null) {
                f2Var.n();
            }
            this.f15307w.e();
            for (e.a<?, ?> aVar : this.f15295k) {
                aVar.v(null);
                aVar.f();
            }
            this.f15295k.clear();
            if (this.f15291g == null) {
                lock = this.f15289e;
            } else {
                R();
                this.f15290f.a();
                lock = this.f15289e;
            }
            lock.unlock();
        } catch (Throwable th) {
            this.f15289e.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.k
    public final void j(String str, @c.o0 FileDescriptor fileDescriptor, PrintWriter printWriter, @c.o0 String[] strArr) {
        printWriter.append((CharSequence) str).append("mContext=").println(this.f15293i);
        printWriter.append((CharSequence) str).append("mResuming=").print(this.f15296l);
        printWriter.append(" mWorkQueue.size()=").print(this.f15295k.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.A.f15275a.size());
        f2 f2Var = this.f15291g;
        if (f2Var != null) {
            f2Var.p(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.k
    public final <A extends com.google.android.gms.common.api.a.b, R extends com.google.android.gms.common.api.t, T extends e.a<R, A>> T l(@c.m0 T t7) {
        Lock lock;
        com.google.android.gms.common.api.a<?> aVarX = t7.x();
        boolean zContainsKey = this.f15302r.containsKey(t7.y());
        String strD = aVarX != null ? aVarX.d() : "the API";
        StringBuilder sb = new StringBuilder(String.valueOf(strD).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(strD);
        sb.append(" required for this call.");
        com.google.android.gms.common.internal.u.b(zContainsKey, sb.toString());
        this.f15289e.lock();
        try {
            f2 f2Var = this.f15291g;
            if (f2Var == null) {
                this.f15295k.add(t7);
                lock = this.f15289e;
            } else {
                t7 = (T) f2Var.i(t7);
                lock = this.f15289e;
            }
            lock.unlock();
            return t7;
        } catch (Throwable th) {
            this.f15289e.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.k
    public final <A extends com.google.android.gms.common.api.a.b, T extends e.a<? extends com.google.android.gms.common.api.t, A>> T m(@c.m0 T t7) {
        Lock lock;
        com.google.android.gms.common.api.a<?> aVarX = t7.x();
        boolean zContainsKey = this.f15302r.containsKey(t7.y());
        String strD = aVarX != null ? aVarX.d() : "the API";
        StringBuilder sb = new StringBuilder(String.valueOf(strD).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(strD);
        sb.append(" required for this call.");
        com.google.android.gms.common.internal.u.b(zContainsKey, sb.toString());
        this.f15289e.lock();
        try {
            f2 f2Var = this.f15291g;
            if (f2Var == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (this.f15296l) {
                this.f15295k.add(t7);
                while (!this.f15295k.isEmpty()) {
                    e.a<?, ?> aVarRemove = this.f15295k.remove();
                    this.A.a(aVarRemove);
                    aVarRemove.a(Status.f15065h);
                }
                lock = this.f15289e;
            } else {
                t7 = (T) f2Var.k(t7);
                lock = this.f15289e;
            }
            lock.unlock();
            return t7;
        } catch (Throwable th) {
            this.f15289e.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.k
    @c.m0
    public final <C extends com.google.android.gms.common.api.a.f> C o(@c.m0 com.google.android.gms.common.api.a.c<C> cVar) {
        C c8 = (C) this.f15302r.get(cVar);
        com.google.android.gms.common.internal.u.l(c8, "Appropriate Api was not requested.");
        return c8;
    }

    @Override // com.google.android.gms.common.api.k
    @c.m0
    public final ConnectionResult p(@c.m0 com.google.android.gms.common.api.a<?> aVar) {
        ConnectionResult connectionResult;
        Lock lock;
        this.f15289e.lock();
        try {
            if (!u() && !this.f15296l) {
                throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
            }
            if (!this.f15302r.containsKey(aVar.b())) {
                throw new IllegalArgumentException(String.valueOf(aVar.d()).concat(" was never registered with GoogleApiClient"));
            }
            ConnectionResult connectionResultQ = ((f2) com.google.android.gms.common.internal.u.k(this.f15291g)).q(aVar);
            if (connectionResultQ != null) {
                this.f15289e.unlock();
                return connectionResultQ;
            }
            if (this.f15296l) {
                connectionResult = ConnectionResult.D;
                lock = this.f15289e;
            } else {
                Log.w("GoogleApiClientImpl", M());
                Log.wtf("GoogleApiClientImpl", String.valueOf(aVar.d()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map"), new Exception());
                connectionResult = new ConnectionResult(8, null);
                lock = this.f15289e;
            }
            lock.unlock();
            return connectionResult;
        } catch (Throwable th) {
            this.f15289e.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.k
    public final Context q() {
        return this.f15293i;
    }

    @Override // com.google.android.gms.common.api.k
    public final Looper r() {
        return this.f15294j;
    }

    @Override // com.google.android.gms.common.api.k
    public final boolean s(@c.m0 com.google.android.gms.common.api.a<?> aVar) {
        return this.f15302r.containsKey(aVar.b());
    }

    @Override // com.google.android.gms.common.api.k
    public final boolean t(@c.m0 com.google.android.gms.common.api.a<?> aVar) {
        com.google.android.gms.common.api.a.f fVar;
        return u() && (fVar = this.f15302r.get(aVar.b())) != null && fVar.a();
    }

    @Override // com.google.android.gms.common.api.k
    public final boolean u() {
        f2 f2Var = this.f15291g;
        return f2Var != null && f2Var.j();
    }

    @Override // com.google.android.gms.common.api.k
    public final boolean v() {
        f2 f2Var = this.f15291g;
        return f2Var != null && f2Var.f();
    }

    @Override // com.google.android.gms.common.api.k
    public final boolean w(@c.m0 com.google.android.gms.common.api.k.b bVar) {
        return this.f15290f.j(bVar);
    }

    @Override // com.google.android.gms.common.api.k
    public final boolean x(@c.m0 com.google.android.gms.common.api.k.c cVar) {
        return this.f15290f.k(cVar);
    }

    @Override // com.google.android.gms.common.api.k
    public final boolean y(w wVar) {
        f2 f2Var = this.f15291g;
        return f2Var != null && f2Var.o(wVar);
    }

    @Override // com.google.android.gms.common.api.k
    public final void z() {
        f2 f2Var = this.f15291g;
        if (f2Var != null) {
            f2Var.m();
        }
    }
}
