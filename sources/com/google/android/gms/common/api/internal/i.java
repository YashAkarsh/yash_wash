package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.TelemetryData;
import com.haier.uhome.mesh.bridge.RtkCoreMeshWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
@c1.a
@com.google.android.gms.common.internal.y
public class i implements Handler.Callback {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @c.m0
    public static final Status f15245r = new Status(4, "Sign-out occurred while this API call was in progress.");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final Status f15246s = new Status(4, "The user must be signed in to make this API call.");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final Object f15247t = new Object();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @c.o0
    @GuardedBy("lock")
    private static i f15248u;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @c.o0
    private TelemetryData f15253e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @c.o0
    private com.google.android.gms.common.internal.b0 f15254f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f15255g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.google.android.gms.common.g f15256h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.google.android.gms.common.internal.s0 f15257i;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @d6.c
    private final Handler f15264p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private volatile boolean f15265q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f15249a = 5000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f15250b = 120000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f15251c = RtkCoreMeshWrapper.RTK_PROV_CONNECT_TIMEOUT;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f15252d = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AtomicInteger f15258j = new AtomicInteger(1);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AtomicInteger f15259k = new AtomicInteger(0);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Map<c<?>, v1<?>> f15260l = new ConcurrentHashMap(5, 0.75f, 1);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @c.o0
    @GuardedBy("lock")
    private i0 f15261m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @GuardedBy("lock")
    private final Set<c<?>> f15262n = new androidx.collection.b();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Set<c<?>> f15263o = new androidx.collection.b();

    @c1.a
    private i(Context context, Looper looper, com.google.android.gms.common.g gVar) {
        this.f15265q = true;
        this.f15255g = context;
        com.google.android.gms.internal.base.p pVar = new com.google.android.gms.internal.base.p(looper, this);
        this.f15264p = pVar;
        this.f15256h = gVar;
        this.f15257i = new com.google.android.gms.common.internal.s0(gVar);
        if (g1.l.a(context)) {
            this.f15265q = false;
        }
        pVar.sendMessage(pVar.obtainMessage(6));
    }

    @c1.a
    public static void a() {
        synchronized (f15247t) {
            i iVar = f15248u;
            if (iVar != null) {
                iVar.f15259k.incrementAndGet();
                Handler handler = iVar.f15264p;
                handler.sendMessageAtFrontOfQueue(handler.obtainMessage(10));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status i(c<?> cVar, ConnectionResult connectionResult) {
        String strB = cVar.b();
        String strValueOf = String.valueOf(connectionResult);
        StringBuilder sb = new StringBuilder(String.valueOf(strB).length() + 63 + strValueOf.length());
        sb.append("API: ");
        sb.append(strB);
        sb.append(" is not available on this device. Connection failed with: ");
        sb.append(strValueOf);
        return new Status(connectionResult, sb.toString());
    }

    @c.h1
    private final v1<?> j(com.google.android.gms.common.api.j<?> jVar) {
        Object objB = jVar.b();
        v1<?> v1Var = this.f15260l.get(objB);
        if (v1Var == null) {
            v1Var = new v1<>(this, jVar);
            this.f15260l.put((c<?>) objB, v1Var);
        }
        if (v1Var.M()) {
            this.f15263o.add((c<?>) objB);
        }
        v1Var.B();
        return v1Var;
    }

    @c.h1
    private final com.google.android.gms.common.internal.b0 k() {
        if (this.f15254f == null) {
            this.f15254f = com.google.android.gms.common.internal.a0.a(this.f15255g);
        }
        return this.f15254f;
    }

    @c.h1
    private final void l() {
        TelemetryData telemetryData = this.f15253e;
        if (telemetryData != null) {
            if (telemetryData.b() > 0 || g()) {
                k().a(telemetryData);
            }
            this.f15253e = null;
        }
    }

    private final <T> void m(com.google.android.gms.tasks.n<T> nVar, int i7, com.google.android.gms.common.api.j jVar) {
        i2 i2VarB;
        if (i7 == 0 || (i2VarB = i2.b(this, i7, jVar.b())) == null) {
            return;
        }
        com.google.android.gms.tasks.m<T> mVarA = nVar.a();
        final Handler handler = this.f15264p;
        handler.getClass();
        mVarA.f(new Executor() { // from class: com.google.android.gms.common.api.internal.p1
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        }, i2VarB);
    }

    @c.m0
    public static i y() {
        i iVar;
        synchronized (f15247t) {
            com.google.android.gms.common.internal.u.l(f15248u, "Must guarantee manager is non-null before using getInstance");
            iVar = f15248u;
        }
        return iVar;
    }

    @c.m0
    public static i z(@c.m0 Context context) {
        i iVar;
        synchronized (f15247t) {
            if (f15248u == null) {
                f15248u = new i(context.getApplicationContext(), com.google.android.gms.common.internal.j.e().getLooper(), com.google.android.gms.common.g.x());
            }
            iVar = f15248u;
        }
        return iVar;
    }

    @c.m0
    public final com.google.android.gms.tasks.m<Map<c<?>, String>> B(@c.m0 Iterable<? extends com.google.android.gms.common.api.l<?>> iterable) {
        q3 q3Var = new q3(iterable);
        Handler handler = this.f15264p;
        handler.sendMessage(handler.obtainMessage(2, q3Var));
        return q3Var.a();
    }

    @c.m0
    public final com.google.android.gms.tasks.m<Boolean> C(@c.m0 com.google.android.gms.common.api.j<?> jVar) {
        j0 j0Var = new j0(jVar.b());
        Handler handler = this.f15264p;
        handler.sendMessage(handler.obtainMessage(14, j0Var));
        return j0Var.b().a();
    }

    @c.m0
    public final <O extends com.google.android.gms.common.api.a.d> com.google.android.gms.tasks.m<Void> D(@c.m0 com.google.android.gms.common.api.j<O> jVar, @c.m0 t<com.google.android.gms.common.api.a.b, ?> tVar, @c.m0 c0<com.google.android.gms.common.api.a.b, ?> c0Var, @c.m0 Runnable runnable) {
        com.google.android.gms.tasks.n nVar = new com.google.android.gms.tasks.n();
        m(nVar, tVar.e(), jVar);
        k3 k3Var = new k3(new n2(tVar, c0Var, runnable), nVar);
        Handler handler = this.f15264p;
        handler.sendMessage(handler.obtainMessage(8, new m2(k3Var, this.f15259k.get(), jVar)));
        return nVar.a();
    }

    @c.m0
    public final <O extends com.google.android.gms.common.api.a.d> com.google.android.gms.tasks.m<Boolean> E(@c.m0 com.google.android.gms.common.api.j<O> jVar, @c.m0 n.a aVar, int i7) {
        com.google.android.gms.tasks.n nVar = new com.google.android.gms.tasks.n();
        m(nVar, i7, jVar);
        m3 m3Var = new m3(aVar, nVar);
        Handler handler = this.f15264p;
        handler.sendMessage(handler.obtainMessage(13, new m2(m3Var, this.f15259k.get(), jVar)));
        return nVar.a();
    }

    public final <O extends com.google.android.gms.common.api.a.d> void J(@c.m0 com.google.android.gms.common.api.j<O> jVar, int i7, @c.m0 e.a<? extends com.google.android.gms.common.api.t, com.google.android.gms.common.api.a.b> aVar) {
        j3 j3Var = new j3(i7, aVar);
        Handler handler = this.f15264p;
        handler.sendMessage(handler.obtainMessage(4, new m2(j3Var, this.f15259k.get(), jVar)));
    }

    public final <O extends com.google.android.gms.common.api.a.d, ResultT> void K(@c.m0 com.google.android.gms.common.api.j<O> jVar, int i7, @c.m0 a0<com.google.android.gms.common.api.a.b, ResultT> a0Var, @c.m0 com.google.android.gms.tasks.n<ResultT> nVar, @c.m0 y yVar) {
        m(nVar, a0Var.d(), jVar);
        l3 l3Var = new l3(i7, a0Var, nVar, yVar);
        Handler handler = this.f15264p;
        handler.sendMessage(handler.obtainMessage(4, new m2(l3Var, this.f15259k.get(), jVar)));
    }

    final void L(MethodInvocation methodInvocation, int i7, long j7, int i8) {
        Handler handler = this.f15264p;
        handler.sendMessage(handler.obtainMessage(18, new j2(methodInvocation, i7, j7, i8)));
    }

    public final void M(@c.m0 ConnectionResult connectionResult, int i7) {
        if (h(connectionResult, i7)) {
            return;
        }
        Handler handler = this.f15264p;
        handler.sendMessage(handler.obtainMessage(5, i7, 0, connectionResult));
    }

    public final void b() {
        Handler handler = this.f15264p;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final void c(@c.m0 com.google.android.gms.common.api.j<?> jVar) {
        Handler handler = this.f15264p;
        handler.sendMessage(handler.obtainMessage(7, jVar));
    }

    public final void d(@c.m0 i0 i0Var) {
        synchronized (f15247t) {
            if (this.f15261m != i0Var) {
                this.f15261m = i0Var;
                this.f15262n.clear();
            }
            this.f15262n.addAll(i0Var.u());
        }
    }

    final void e(@c.m0 i0 i0Var) {
        synchronized (f15247t) {
            if (this.f15261m == i0Var) {
                this.f15261m = null;
                this.f15262n.clear();
            }
        }
    }

    @c.h1
    final boolean g() {
        if (this.f15252d) {
            return false;
        }
        RootTelemetryConfiguration rootTelemetryConfigurationA = com.google.android.gms.common.internal.w.b().a();
        if (rootTelemetryConfigurationA != null && !rootTelemetryConfigurationA.p0()) {
            return false;
        }
        int iA = this.f15257i.a(this.f15255g, 203400000);
        return iA == -1 || iA == 0;
    }

    final boolean h(ConnectionResult connectionResult, int i7) {
        return this.f15256h.L(this.f15255g, connectionResult, i7);
    }

    /* JADX WARN: Code duplicated, block: B:63:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:65:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:66:0x0235  */
    /* JADX WARN: Code duplicated, block: B:67:0x0242  */
    @Override // android.os.Handler.Callback
    @c.h1
    public final boolean handleMessage(@c.m0 Message message) {
        int i7 = message.what;
        v1<?> v1Var = null;
        switch (i7) {
            case 1:
                this.f15251c = true == ((Boolean) message.obj).booleanValue() ? RtkCoreMeshWrapper.RTK_PROV_CONNECT_TIMEOUT : 300000L;
                this.f15264p.removeMessages(12);
                for (c<?> cVar : this.f15260l.keySet()) {
                    Handler handler = this.f15264p;
                    handler.sendMessageDelayed(handler.obtainMessage(12, cVar), this.f15251c);
                }
                return true;
            case 2:
                q3 q3Var = (q3) message.obj;
                for (c<?> cVar2 : q3Var.b()) {
                    v1<?> v1Var2 = this.f15260l.get(cVar2);
                    if (v1Var2 == null) {
                        q3Var.c(cVar2, new ConnectionResult(13), null);
                        return true;
                    }
                    if (v1Var2.L()) {
                        q3Var.c(cVar2, ConnectionResult.D, v1Var2.s().k());
                    } else {
                        ConnectionResult connectionResultQ = v1Var2.q();
                        if (connectionResultQ != null) {
                            q3Var.c(cVar2, connectionResultQ, null);
                        } else {
                            v1Var2.G(q3Var);
                            v1Var2.B();
                        }
                    }
                }
                return true;
            case 3:
                for (v1<?> v1Var3 : this.f15260l.values()) {
                    v1Var3.A();
                    v1Var3.B();
                }
                return true;
            case 4:
            case 8:
            case 13:
                m2 m2Var = (m2) message.obj;
                v1<?> v1VarJ = this.f15260l.get(m2Var.f15331c.b());
                if (v1VarJ == null) {
                    v1VarJ = j(m2Var.f15331c);
                }
                if (!v1VarJ.M() || this.f15259k.get() == m2Var.f15330b) {
                    v1VarJ.C(m2Var.f15329a);
                } else {
                    m2Var.f15329a.a(f15245r);
                    v1VarJ.I();
                }
                return true;
            case 5:
                int i8 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                for (v1<?> v1Var4 : this.f15260l.values()) {
                    if (v1Var4.o() == i8) {
                        v1Var = v1Var4;
                        if (v1Var != null) {
                            StringBuilder sb = new StringBuilder(76);
                            sb.append("Could not find API instance ");
                            sb.append(i8);
                            sb.append(" while trying to fail enqueued calls.");
                            Log.wtf("GoogleApiManager", sb.toString(), new Exception());
                        } else if (connectionResult.K() == 13) {
                            String strH = this.f15256h.h(connectionResult.K());
                            String strQ = connectionResult.Q();
                            StringBuilder sb2 = new StringBuilder(String.valueOf(strH).length() + 69 + String.valueOf(strQ).length());
                            sb2.append("Error resolution was canceled by the user, original error message: ");
                            sb2.append(strH);
                            sb2.append(": ");
                            sb2.append(strQ);
                            v1Var.d(new Status(17, sb2.toString()));
                        } else {
                            v1Var.d(i(((v1) v1Var).f15436e, connectionResult));
                        }
                        return true;
                    }
                }
                if (v1Var != null) {
                    StringBuilder sb3 = new StringBuilder(76);
                    sb3.append("Could not find API instance ");
                    sb3.append(i8);
                    sb3.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb3.toString(), new Exception());
                } else if (connectionResult.K() == 13) {
                    String strH2 = this.f15256h.h(connectionResult.K());
                    String strQ2 = connectionResult.Q();
                    StringBuilder sb4 = new StringBuilder(String.valueOf(strH2).length() + 69 + String.valueOf(strQ2).length());
                    sb4.append("Error resolution was canceled by the user, original error message: ");
                    sb4.append(strH2);
                    sb4.append(": ");
                    sb4.append(strQ2);
                    v1Var.d(new Status(17, sb4.toString()));
                } else {
                    v1Var.d(i(((v1) v1Var).f15436e, connectionResult));
                }
                return true;
            case 6:
                if (this.f15255g.getApplicationContext() instanceof Application) {
                    d.c((Application) this.f15255g.getApplicationContext());
                    d.b().a(new q1(this));
                    if (!d.b().e(true)) {
                        this.f15251c = 300000L;
                    }
                }
                return true;
            case 7:
                j((com.google.android.gms.common.api.j) message.obj);
                return true;
            case 9:
                if (this.f15260l.containsKey(message.obj)) {
                    this.f15260l.get(message.obj).H();
                }
                return true;
            case 10:
                Iterator<c<?>> it = this.f15263o.iterator();
                while (it.hasNext()) {
                    v1<?> v1VarRemove = this.f15260l.remove(it.next());
                    if (v1VarRemove != null) {
                        v1VarRemove.I();
                    }
                }
                this.f15263o.clear();
                return true;
            case 11:
                if (this.f15260l.containsKey(message.obj)) {
                    this.f15260l.get(message.obj).J();
                }
                return true;
            case 12:
                if (this.f15260l.containsKey(message.obj)) {
                    this.f15260l.get(message.obj).a();
                }
                return true;
            case 14:
                j0 j0Var = (j0) message.obj;
                c<?> cVarA = j0Var.a();
                if (this.f15260l.containsKey(cVarA)) {
                    j0Var.b().c(Boolean.valueOf(this.f15260l.get(cVarA).n(false)));
                } else {
                    j0Var.b().c(Boolean.FALSE);
                }
                return true;
            case 15:
                x1 x1Var = (x1) message.obj;
                if (this.f15260l.containsKey(x1Var.f15452a)) {
                    v1.y(this.f15260l.get(x1Var.f15452a), x1Var);
                }
                return true;
            case 16:
                x1 x1Var2 = (x1) message.obj;
                if (this.f15260l.containsKey(x1Var2.f15452a)) {
                    v1.z(this.f15260l.get(x1Var2.f15452a), x1Var2);
                }
                return true;
            case 17:
                l();
                return true;
            case 18:
                j2 j2Var = (j2) message.obj;
                if (j2Var.f15313c == 0) {
                    k().a(new TelemetryData(j2Var.f15312b, Arrays.asList(j2Var.f15311a)));
                } else {
                    TelemetryData telemetryData = this.f15253e;
                    if (telemetryData != null) {
                        List<MethodInvocation> listK = telemetryData.K();
                        if (telemetryData.b() != j2Var.f15312b || (listK != null && listK.size() >= j2Var.f15314d)) {
                            this.f15264p.removeMessages(17);
                            l();
                        } else {
                            this.f15253e.Q(j2Var.f15311a);
                        }
                    }
                    if (this.f15253e == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(j2Var.f15311a);
                        this.f15253e = new TelemetryData(j2Var.f15312b, arrayList);
                        Handler handler2 = this.f15264p;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), j2Var.f15313c);
                    }
                }
                return true;
            case 19:
                this.f15252d = false;
                return true;
            default:
                StringBuilder sb5 = new StringBuilder(31);
                sb5.append("Unknown message id: ");
                sb5.append(i7);
                Log.w("GoogleApiManager", sb5.toString());
                return false;
        }
    }

    public final int n() {
        return this.f15258j.getAndIncrement();
    }

    @c.o0
    final v1 x(c<?> cVar) {
        return this.f15260l.get(cVar);
    }
}
