package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.haier.uhome.control.base.json.ProtocolConst;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public abstract class e<T extends IInterface> {

    @c1.a
    public static final int D = 1;

    @c1.a
    public static final int E = 4;

    @c1.a
    public static final int F = 5;

    @c1.a
    @c.m0
    public static final String G = "pendingIntent";

    @c1.a
    @c.m0
    public static final String H = "<<default account>>";
    private boolean A;

    @c.o0
    private volatile zzj B;

    @g1.d0
    @c.m0
    protected AtomicInteger C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f15680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f15681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f15682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f15683e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @c.o0
    private volatile String f15684f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g1.d0
    h2 f15685g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Context f15686h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Looper f15687i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final j f15688j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.google.android.gms.common.h f15689k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final Handler f15690l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Object f15691m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Object f15692n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @c.o0
    @GuardedBy("mServiceBrokerLock")
    private p f15693o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @g1.d0
    @c.m0
    protected c f15694p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @c.o0
    @GuardedBy("mLock")
    private T f15695q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final ArrayList<q1<?>> f15696r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @c.o0
    @GuardedBy("mLock")
    private s1 f15697s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @GuardedBy("mLock")
    private int f15698t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @c.o0
    private final a f15699u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @c.o0
    private final b f15700v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final int f15701w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @c.o0
    private final String f15702x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @c.o0
    private volatile String f15703y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @c.o0
    private ConnectionResult f15704z;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static final Feature[] f15678J = new Feature[0];

    @c1.a
    @c.m0
    public static final String[] I = {"service_esmobile", "service_googleme"};

    @c1.a
    public interface a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @c1.a
        public static final int f15705a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @c1.a
        public static final int f15706b = 3;

        @c1.a
        void i0(int i7);

        @c1.a
        void y0(@c.o0 Bundle bundle);
    }

    @c1.a
    public interface b {
        @c1.a
        void u0(@c.m0 ConnectionResult connectionResult);
    }

    @c1.a
    public interface c {
        @c1.a
        void a(@c.m0 ConnectionResult connectionResult);
    }

    protected class d implements c {
        @c1.a
        public d() {
        }

        @Override // com.google.android.gms.common.internal.e.c
        public final void a(@c.m0 ConnectionResult connectionResult) {
            if (connectionResult.s0()) {
                e eVar = e.this;
                eVar.h(null, eVar.L());
            } else if (e.this.f15700v != null) {
                e.this.f15700v.u0(connectionResult);
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.common.internal.e$e, reason: collision with other inner class name */
    @c1.a
    public interface InterfaceC0183e {
        @c1.a
        void a();
    }

    @g1.d0
    @c1.a
    protected e(@c.m0 Context context, @c.m0 Handler handler, @c.m0 j jVar, @c.m0 com.google.android.gms.common.h hVar, int i7, @c.o0 a aVar, @c.o0 b bVar) {
        this.f15684f = null;
        this.f15691m = new Object();
        this.f15692n = new Object();
        this.f15696r = new ArrayList<>();
        this.f15698t = 1;
        this.f15704z = null;
        this.A = false;
        this.B = null;
        this.C = new AtomicInteger(0);
        u.l(context, "Context must not be null");
        this.f15686h = context;
        u.l(handler, "Handler must not be null");
        this.f15690l = handler;
        this.f15687i = handler.getLooper();
        u.l(jVar, "Supervisor must not be null");
        this.f15688j = jVar;
        u.l(hVar, "API availability must not be null");
        this.f15689k = hVar;
        this.f15701w = i7;
        this.f15699u = aVar;
        this.f15700v = bVar;
        this.f15702x = null;
    }

    static /* bridge */ /* synthetic */ void k0(e eVar, zzj zzjVar) {
        eVar.B = zzjVar;
        if (eVar.a0()) {
            ConnectionTelemetryConfiguration connectionTelemetryConfiguration = zzjVar.f15844d;
            w.b().c(connectionTelemetryConfiguration == null ? null : connectionTelemetryConfiguration.v0());
        }
    }

    static /* bridge */ /* synthetic */ void l0(e eVar, int i7) {
        int i8;
        int i9;
        synchronized (eVar.f15691m) {
            i8 = eVar.f15698t;
        }
        if (i8 == 3) {
            eVar.A = true;
            i9 = 5;
        } else {
            i9 = 4;
        }
        Handler handler = eVar.f15690l;
        handler.sendMessage(handler.obtainMessage(i9, eVar.C.get(), 16));
    }

    static /* bridge */ /* synthetic */ boolean o0(e eVar, int i7, int i8, IInterface iInterface) {
        synchronized (eVar.f15691m) {
            if (eVar.f15698t != i7) {
                return false;
            }
            eVar.q0(i8, iInterface);
            return true;
        }
    }

    static /* bridge */ /* synthetic */ boolean p0(e eVar) {
        if (eVar.A || TextUtils.isEmpty(eVar.N()) || TextUtils.isEmpty(eVar.J())) {
            return false;
        }
        try {
            Class.forName(eVar.N());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0(int i7, @c.o0 T t7) {
        h2 h2Var;
        u.a((i7 == 4) == (t7 != null));
        synchronized (this.f15691m) {
            this.f15698t = i7;
            this.f15695q = t7;
            if (i7 == 1) {
                s1 s1Var = this.f15697s;
                if (s1Var != null) {
                    j jVar = this.f15688j;
                    String strC = this.f15685g.c();
                    u.k(strC);
                    jVar.j(strC, this.f15685g.b(), this.f15685g.a(), s1Var, f0(), this.f15685g.d());
                    this.f15697s = null;
                }
            } else if (i7 == 2 || i7 == 3) {
                s1 s1Var2 = this.f15697s;
                if (s1Var2 != null && (h2Var = this.f15685g) != null) {
                    String strC2 = h2Var.c();
                    String strB = h2Var.b();
                    StringBuilder sb = new StringBuilder(String.valueOf(strC2).length() + 70 + String.valueOf(strB).length());
                    sb.append("Calling connect() while still connected, missing disconnect() for ");
                    sb.append(strC2);
                    sb.append(" on ");
                    sb.append(strB);
                    Log.e("GmsClient", sb.toString());
                    j jVar2 = this.f15688j;
                    String strC3 = this.f15685g.c();
                    u.k(strC3);
                    jVar2.j(strC3, this.f15685g.b(), this.f15685g.a(), s1Var2, f0(), this.f15685g.d());
                    this.C.incrementAndGet();
                }
                s1 s1Var3 = new s1(this, this.C.get());
                this.f15697s = s1Var3;
                h2 h2Var2 = (this.f15698t != 3 || J() == null) ? new h2(P(), O(), false, j.c(), R()) : new h2(G().getPackageName(), J(), true, j.c(), false);
                this.f15685g = h2Var2;
                if (h2Var2.d() && r() < 17895000) {
                    String strValueOf = String.valueOf(this.f15685g.c());
                    throw new IllegalStateException(strValueOf.length() != 0 ? "Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(strValueOf) : new String("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: "));
                }
                j jVar3 = this.f15688j;
                String strC4 = this.f15685g.c();
                u.k(strC4);
                if (!jVar3.k(new a2(strC4, this.f15685g.b(), this.f15685g.a(), this.f15685g.d()), s1Var3, f0(), E())) {
                    String strC5 = this.f15685g.c();
                    String strB2 = this.f15685g.b();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(strC5).length() + 34 + String.valueOf(strB2).length());
                    sb2.append("unable to connect to service: ");
                    sb2.append(strC5);
                    sb2.append(" on ");
                    sb2.append(strB2);
                    Log.w("GmsClient", sb2.toString());
                    m0(16, null, this.C.get());
                }
            } else if (i7 == 4) {
                u.k(t7);
                T(t7);
            }
        }
    }

    @c.o0
    @c1.a
    protected abstract T A(@c.m0 IBinder iBinder);

    @c1.a
    protected boolean B() {
        return false;
    }

    @c.o0
    @c1.a
    public Account C() {
        return null;
    }

    @c1.a
    @c.m0
    public Feature[] D() {
        return f15678J;
    }

    @c.o0
    @c1.a
    protected Executor E() {
        return null;
    }

    @c.o0
    @c1.a
    public Bundle F() {
        return null;
    }

    @c1.a
    @c.m0
    public final Context G() {
        return this.f15686h;
    }

    @c1.a
    public int H() {
        return this.f15701w;
    }

    @c1.a
    @c.m0
    protected Bundle I() {
        return new Bundle();
    }

    @c.o0
    @c1.a
    protected String J() {
        return null;
    }

    @c1.a
    @c.m0
    public final Looper K() {
        return this.f15687i;
    }

    @c1.a
    @c.m0
    protected Set<Scope> L() {
        return Collections.emptySet();
    }

    @c1.a
    @c.m0
    public final T M() throws DeadObjectException {
        T t7;
        synchronized (this.f15691m) {
            if (this.f15698t == 5) {
                throw new DeadObjectException();
            }
            z();
            t7 = this.f15695q;
            u.l(t7, "Client is connected but service is null");
        }
        return t7;
    }

    @c1.a
    @c.m0
    protected abstract String N();

    @c1.a
    @c.m0
    protected abstract String O();

    @c1.a
    @c.m0
    protected String P() {
        return "com.google.android.gms";
    }

    @c.o0
    @c1.a
    public ConnectionTelemetryConfiguration Q() {
        zzj zzjVar = this.B;
        if (zzjVar == null) {
            return null;
        }
        return zzjVar.f15844d;
    }

    @c1.a
    protected boolean R() {
        return r() >= 211700000;
    }

    @c1.a
    public boolean S() {
        return this.B != null;
    }

    @c1.a
    @c.i
    protected void T(@c.m0 T t7) {
        this.f15681c = System.currentTimeMillis();
    }

    @c1.a
    @c.i
    protected void U(@c.m0 ConnectionResult connectionResult) {
        this.f15682d = connectionResult.K();
        this.f15683e = System.currentTimeMillis();
    }

    @c1.a
    @c.i
    protected void V(int i7) {
        this.f15679a = i7;
        this.f15680b = System.currentTimeMillis();
    }

    @c1.a
    protected void W(int i7, @c.o0 IBinder iBinder, @c.o0 Bundle bundle, int i8) {
        Handler handler = this.f15690l;
        handler.sendMessage(handler.obtainMessage(1, i8, -1, new t1(this, i7, iBinder, bundle)));
    }

    @c1.a
    public void X(@c.m0 String str) {
        this.f15703y = str;
    }

    @c1.a
    public void Y(int i7) {
        Handler handler = this.f15690l;
        handler.sendMessage(handler.obtainMessage(6, this.C.get(), i7));
    }

    @g1.d0
    @c1.a
    protected void Z(@c.m0 c cVar, int i7, @c.o0 PendingIntent pendingIntent) {
        u.l(cVar, "Connection progress callbacks cannot be null.");
        this.f15694p = cVar;
        Handler handler = this.f15690l;
        handler.sendMessage(handler.obtainMessage(3, this.C.get(), i7, pendingIntent));
    }

    @c1.a
    public boolean a() {
        boolean z7;
        synchronized (this.f15691m) {
            z7 = this.f15698t == 4;
        }
        return z7;
    }

    @c1.a
    public boolean a0() {
        return false;
    }

    @c1.a
    public boolean c() {
        return false;
    }

    @c1.a
    public boolean d() {
        return false;
    }

    @c1.a
    public void f() {
        this.C.incrementAndGet();
        synchronized (this.f15696r) {
            int size = this.f15696r.size();
            for (int i7 = 0; i7 < size; i7++) {
                this.f15696r.get(i7).d();
            }
            this.f15696r.clear();
        }
        synchronized (this.f15692n) {
            this.f15693o = null;
        }
        q0(1, null);
    }

    @c.m0
    protected final String f0() {
        String str = this.f15702x;
        return str == null ? this.f15686h.getClass().getName() : str;
    }

    @c.h1
    @c1.a
    public void h(@c.o0 m mVar, @c.m0 Set<Scope> set) {
        Bundle bundleI = I();
        GetServiceRequest getServiceRequest = new GetServiceRequest(this.f15701w, this.f15703y);
        getServiceRequest.f15631d = this.f15686h.getPackageName();
        getServiceRequest.f15634g = bundleI;
        if (set != null) {
            getServiceRequest.f15633f = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (w()) {
            Account accountC = C();
            if (accountC == null) {
                accountC = new Account("<<default account>>", com.google.android.gms.common.internal.b.f15664a);
            }
            getServiceRequest.f15635h = accountC;
            if (mVar != null) {
                getServiceRequest.f15632e = mVar.asBinder();
            }
        } else if (c()) {
            getServiceRequest.f15635h = C();
        }
        getServiceRequest.f15636i = f15678J;
        getServiceRequest.f15637j = D();
        if (a0()) {
            getServiceRequest.f15640m = true;
        }
        try {
            synchronized (this.f15692n) {
                p pVar = this.f15693o;
                if (pVar != null) {
                    pVar.K1(new r1(this, this.C.get()), getServiceRequest);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e8) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e8);
            Y(3);
        } catch (RemoteException e9) {
            e = e9;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            W(8, null, null, this.C.get());
        } catch (SecurityException e10) {
            throw e10;
        } catch (RuntimeException e11) {
            e = e11;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            W(8, null, null, this.C.get());
        }
    }

    @c1.a
    public void i(@c.m0 String str) {
        this.f15684f = str;
        f();
    }

    @c1.a
    public boolean j() {
        boolean z7;
        synchronized (this.f15691m) {
            int i7 = this.f15698t;
            z7 = true;
            if (i7 != 2 && i7 != 3) {
                z7 = false;
            }
        }
        return z7;
    }

    @c1.a
    @c.m0
    public String k() {
        h2 h2Var;
        if (!a() || (h2Var = this.f15685g) == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return h2Var.b();
    }

    @c1.a
    public void l(@c.m0 c cVar) {
        u.l(cVar, "Connection progress callbacks cannot be null.");
        this.f15694p = cVar;
        q0(2, null);
    }

    @c1.a
    public void m(@c.m0 InterfaceC0183e interfaceC0183e) {
        interfaceC0183e.a();
    }

    protected final void m0(int i7, @c.o0 Bundle bundle, int i8) {
        Handler handler = this.f15690l;
        handler.sendMessage(handler.obtainMessage(7, i8, -1, new u1(this, i7, null)));
    }

    @c1.a
    public void o(@c.m0 String str, @c.m0 FileDescriptor fileDescriptor, @c.m0 PrintWriter printWriter, @c.m0 String[] strArr) {
        int i7;
        T t7;
        p pVar;
        synchronized (this.f15691m) {
            i7 = this.f15698t;
            t7 = this.f15695q;
        }
        synchronized (this.f15692n) {
            pVar = this.f15693o;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        if (i7 == 1) {
            printWriter.print("DISCONNECTED");
        } else if (i7 == 2) {
            printWriter.print("REMOTE_CONNECTING");
        } else if (i7 == 3) {
            printWriter.print("LOCAL_CONNECTING");
        } else if (i7 == 4) {
            printWriter.print(ProtocolConst.ONLINE_STATE_CONNECTED);
        } else if (i7 != 5) {
            printWriter.print("UNKNOWN");
        } else {
            printWriter.print("DISCONNECTING");
        }
        printWriter.append(" mService=");
        if (t7 == null) {
            printWriter.append("null");
        } else {
            printWriter.append((CharSequence) N()).append("@").append((CharSequence) Integer.toHexString(System.identityHashCode(t7.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (pVar == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(pVar.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.f15681c > 0) {
            PrintWriter printWriterAppend = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j7 = this.f15681c;
            String str2 = simpleDateFormat.format(new Date(j7));
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 21);
            sb.append(j7);
            sb.append(" ");
            sb.append(str2);
            printWriterAppend.println(sb.toString());
        }
        if (this.f15680b > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            int i8 = this.f15679a;
            if (i8 == 1) {
                printWriter.append("CAUSE_SERVICE_DISCONNECTED");
            } else if (i8 == 2) {
                printWriter.append("CAUSE_NETWORK_LOST");
            } else if (i8 != 3) {
                printWriter.append((CharSequence) String.valueOf(i8));
            } else {
                printWriter.append("CAUSE_DEAD_OBJECT_EXCEPTION");
            }
            PrintWriter printWriterAppend2 = printWriter.append(" lastSuspendedTime=");
            long j8 = this.f15680b;
            String str3 = simpleDateFormat.format(new Date(j8));
            StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + 21);
            sb2.append(j8);
            sb2.append(" ");
            sb2.append(str3);
            printWriterAppend2.println(sb2.toString());
        }
        if (this.f15683e > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) com.google.android.gms.common.api.h.a(this.f15682d));
            PrintWriter printWriterAppend3 = printWriter.append(" lastFailedTime=");
            long j9 = this.f15683e;
            String str4 = simpleDateFormat.format(new Date(j9));
            StringBuilder sb3 = new StringBuilder(String.valueOf(str4).length() + 21);
            sb3.append(j9);
            sb3.append(" ");
            sb3.append(str4);
            printWriterAppend3.println(sb3.toString());
        }
    }

    @c1.a
    public boolean p() {
        return true;
    }

    @c1.a
    public int r() {
        return com.google.android.gms.common.h.f15574a;
    }

    @c.o0
    @c1.a
    public final Feature[] s() {
        zzj zzjVar = this.B;
        if (zzjVar == null) {
            return null;
        }
        return zzjVar.f15842b;
    }

    @c.o0
    @c1.a
    public String u() {
        return this.f15684f;
    }

    @c1.a
    @c.m0
    public Intent v() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    @c1.a
    public boolean w() {
        return false;
    }

    @c.o0
    @c1.a
    public IBinder x() {
        synchronized (this.f15692n) {
            p pVar = this.f15693o;
            if (pVar == null) {
                return null;
            }
            return pVar.asBinder();
        }
    }

    @c1.a
    public void y() {
        int iK = this.f15689k.k(this.f15686h, r());
        if (iK == 0) {
            l(new d());
        } else {
            q0(1, null);
            Z(new d(), iK, null);
        }
    }

    @c1.a
    protected final void z() {
        if (!a()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @c1.a
    protected e(@c.m0 Context context, @c.m0 Looper looper, int i7, @c.o0 a aVar, @c.o0 b bVar, @c.o0 String str) {
        j jVarD = j.d(context);
        com.google.android.gms.common.h hVarI = com.google.android.gms.common.h.i();
        u.k(aVar);
        u.k(bVar);
        this(context, looper, jVarD, hVarI, i7, aVar, bVar, str);
    }

    @g1.d0
    @c1.a
    protected e(@c.m0 Context context, @c.m0 Looper looper, @c.m0 j jVar, @c.m0 com.google.android.gms.common.h hVar, int i7, @c.o0 a aVar, @c.o0 b bVar, @c.o0 String str) {
        this.f15684f = null;
        this.f15691m = new Object();
        this.f15692n = new Object();
        this.f15696r = new ArrayList<>();
        this.f15698t = 1;
        this.f15704z = null;
        this.A = false;
        this.B = null;
        this.C = new AtomicInteger(0);
        u.l(context, "Context must not be null");
        this.f15686h = context;
        u.l(looper, "Looper must not be null");
        this.f15687i = looper;
        u.l(jVar, "Supervisor must not be null");
        this.f15688j = jVar;
        u.l(hVar, "API availability must not be null");
        this.f15689k = hVar;
        this.f15690l = new p1(this, looper);
        this.f15701w = i7;
        this.f15699u = aVar;
        this.f15700v = bVar;
        this.f15702x = str;
    }
}
