package org.chromium.net;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import javax.annotation.concurrent.GuardedBy;
import org.chromium.base.ApplicationStatus;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"NewApi"})
public class NetworkChangeNotifierAutoDetect extends BroadcastReceiver {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f39019p = "NetworkChangeNotifierAutoDetect";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f39020q = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Looper f39021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f39022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final NetworkConnectivityIntentFilter f39023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f f39024d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final g f39025e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private c f39026f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b f39027g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private h f39028h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private d f39029i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private NetworkRequest f39030j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f39031k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private e f39032l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f39033m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f39034n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f39035o;

    private static class NetworkConnectivityIntentFilter extends IntentFilter {
        NetworkConnectivityIntentFilter() {
            addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
    }

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NetworkChangeNotifierAutoDetect.this.f39031k) {
                if (NetworkChangeNotifierAutoDetect.this.f39033m) {
                    NetworkChangeNotifierAutoDetect.this.f39033m = false;
                } else {
                    NetworkChangeNotifierAutoDetect.this.k();
                }
            }
        }
    }

    @TargetApi(21)
    private class c extends ConnectivityManager.NetworkCallback {
        private c() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            if (NetworkChangeNotifierAutoDetect.this.f39031k) {
                NetworkChangeNotifierAutoDetect.this.k();
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            onAvailable(null);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            onAvailable(null);
        }

        /* synthetic */ c(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect, a aVar) {
            this();
        }
    }

    @TargetApi(21)
    private class d extends ConnectivityManager.NetworkCallback {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final /* synthetic */ boolean f39040c = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Network f39041a;

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ long f39043a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f39044b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ boolean f39045c;

            a(long j7, int i7, boolean z7) {
                this.f39043a = j7;
                this.f39044b = i7;
                this.f39045c = z7;
            }

            @Override // java.lang.Runnable
            public void run() {
                NetworkChangeNotifierAutoDetect.this.f39024d.c(this.f39043a, this.f39044b);
                if (this.f39045c) {
                    NetworkChangeNotifierAutoDetect.this.f39024d.a(this.f39044b);
                    NetworkChangeNotifierAutoDetect.this.f39024d.e(new long[]{this.f39043a});
                }
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ long f39047a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f39048b;

            b(long j7, int i7) {
                this.f39047a = j7;
                this.f39048b = i7;
            }

            @Override // java.lang.Runnable
            public void run() {
                NetworkChangeNotifierAutoDetect.this.f39024d.c(this.f39047a, this.f39048b);
            }
        }

        class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ long f39050a;

            c(long j7) {
                this.f39050a = j7;
            }

            @Override // java.lang.Runnable
            public void run() {
                NetworkChangeNotifierAutoDetect.this.f39024d.b(this.f39050a);
            }
        }

        /* JADX INFO: renamed from: org.chromium.net.NetworkChangeNotifierAutoDetect$d$d, reason: collision with other inner class name */
        class RunnableC0521d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Network f39052a;

            RunnableC0521d(Network network) {
                this.f39052a = network;
            }

            @Override // java.lang.Runnable
            public void run() {
                NetworkChangeNotifierAutoDetect.this.f39024d.f(NetworkChangeNotifierAutoDetect.t(this.f39052a));
            }
        }

        class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f39054a;

            e(int i7) {
                this.f39054a = i7;
            }

            @Override // java.lang.Runnable
            public void run() {
                NetworkChangeNotifierAutoDetect.this.f39024d.a(this.f39054a);
            }
        }

        private d() {
        }

        private boolean a(Network network, NetworkCapabilities networkCapabilities) {
            if (networkCapabilities == null) {
                networkCapabilities = NetworkChangeNotifierAutoDetect.this.f39027g.d(network);
            }
            return networkCapabilities == null || (networkCapabilities.hasTransport(4) && !NetworkChangeNotifierAutoDetect.this.f39027g.k(network));
        }

        private boolean b(Network network, NetworkCapabilities networkCapabilities) {
            return c(network) || a(network, networkCapabilities);
        }

        private boolean c(Network network) {
            Network network2 = this.f39041a;
            return (network2 == null || network2.equals(network)) ? false : true;
        }

        void d() {
            NetworkCapabilities networkCapabilitiesD;
            Network[] networkArrN = NetworkChangeNotifierAutoDetect.n(NetworkChangeNotifierAutoDetect.this.f39027g, null);
            this.f39041a = null;
            if (networkArrN.length == 1 && (networkCapabilitiesD = NetworkChangeNotifierAutoDetect.this.f39027g.d(networkArrN[0])) != null && networkCapabilitiesD.hasTransport(4)) {
                this.f39041a = networkArrN[0];
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            NetworkCapabilities networkCapabilitiesD = NetworkChangeNotifierAutoDetect.this.f39027g.d(network);
            if (b(network, networkCapabilitiesD)) {
                return;
            }
            boolean zHasTransport = networkCapabilitiesD.hasTransport(4);
            if (zHasTransport) {
                this.f39041a = network;
            }
            NetworkChangeNotifierAutoDetect.this.x(new a(NetworkChangeNotifierAutoDetect.t(network), NetworkChangeNotifierAutoDetect.this.f39027g.b(network), zHasTransport));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            if (b(network, networkCapabilities)) {
                return;
            }
            NetworkChangeNotifierAutoDetect.this.x(new b(NetworkChangeNotifierAutoDetect.t(network), NetworkChangeNotifierAutoDetect.this.f39027g.b(network)));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network network, int i7) {
            if (b(network, null)) {
                return;
            }
            NetworkChangeNotifierAutoDetect.this.x(new c(NetworkChangeNotifierAutoDetect.t(network)));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            if (c(network)) {
                return;
            }
            NetworkChangeNotifierAutoDetect.this.x(new RunnableC0521d(network));
            if (this.f39041a != null) {
                this.f39041a = null;
                for (Network network2 : NetworkChangeNotifierAutoDetect.n(NetworkChangeNotifierAutoDetect.this.f39027g, network)) {
                    onAvailable(network2);
                }
                NetworkChangeNotifierAutoDetect.this.x(new e(NetworkChangeNotifierAutoDetect.this.o().b()));
            }
        }

        /* synthetic */ d(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect, a aVar) {
            this();
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f39056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f39057b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f39058c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f39059d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f39060e;

        public e(boolean z7, int i7, int i8, String str, boolean z8) {
            this.f39056a = z7;
            this.f39057b = i7;
            this.f39058c = i8;
            this.f39059d = str == null ? "" : str;
            this.f39060e = z8;
        }

        public int a() {
            if (!f()) {
                return 1;
            }
            if (e() != 0) {
                return 0;
            }
            switch (d()) {
                case 1:
                    return 7;
                case 2:
                    return 8;
                case 3:
                    return 9;
                case 4:
                    return 5;
                case 5:
                    return 10;
                case 6:
                    return 11;
                case 7:
                    return 6;
                case 8:
                    return 14;
                case 9:
                    return 15;
                case 10:
                    return 12;
                case 11:
                    return 4;
                case 12:
                    return 13;
                case 13:
                    return 18;
                case 14:
                    return 16;
                case 15:
                    return 17;
                default:
                    return 0;
            }
        }

        public int b() {
            if (f()) {
                return NetworkChangeNotifierAutoDetect.l(e(), d());
            }
            return 6;
        }

        public String c() {
            return this.f39059d;
        }

        public int d() {
            return this.f39058c;
        }

        public int e() {
            return this.f39057b;
        }

        public boolean f() {
            return this.f39056a;
        }

        public boolean g() {
            return this.f39060e;
        }
    }

    public interface f {
        void a(int i7);

        void b(long j7);

        void c(long j7, int i7);

        void d(int i7);

        void e(long[] jArr);

        void f(long j7);
    }

    public static abstract class g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ boolean f39061b = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private NetworkChangeNotifierAutoDetect f39062a;

        protected abstract void b();

        protected void c(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect) {
            this.f39062a = networkChangeNotifierAutoDetect;
        }

        protected final void d() {
            this.f39062a.v();
        }

        protected final void e() {
            this.f39062a.A();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetApi(21)
    public NetworkChangeNotifierAutoDetect(f fVar, g gVar) {
        Looper looperMyLooper = Looper.myLooper();
        this.f39021a = looperMyLooper;
        this.f39022b = new Handler(looperMyLooper);
        this.f39024d = fVar;
        this.f39027g = new b(org.chromium.base.o.e());
        int i7 = Build.VERSION.SDK_INT;
        Object[] objArr = 0;
        this.f39029i = new d(this, 0 == true ? 1 : 0);
        this.f39030j = new NetworkRequest.Builder().addCapability(12).removeCapability(15).build();
        this.f39026f = i7 >= 28 ? new c(this, objArr == true ? 1 : 0) : null;
        this.f39032l = o();
        this.f39023c = new NetworkConnectivityIntentFilter();
        this.f39033m = false;
        this.f39034n = false;
        this.f39025e = gVar;
        gVar.c(this);
        this.f39034n = true;
    }

    private void j() {
        if (org.chromium.base.l.f38814b && !u()) {
            throw new IllegalStateException("Must be called on NetworkChangeNotifierAutoDetect thread.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        e eVarO = o();
        if (eVarO.b() != this.f39032l.b() || !eVarO.c().equals(this.f39032l.c()) || eVarO.g() != this.f39032l.g()) {
            this.f39024d.a(eVarO.b());
        }
        if (eVarO.b() != this.f39032l.b() || eVarO.a() != this.f39032l.a()) {
            this.f39024d.d(eVarO.a());
        }
        this.f39032l = eVarO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int l(int i7, int i8) {
        int i9 = 5;
        if (i7 == 0) {
            switch (i8) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return 3;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return 4;
                case 13:
                    return 5;
                default:
                    return 0;
            }
        }
        if (i7 == 1) {
            return 2;
        }
        if (i7 != 6) {
            i9 = 7;
            if (i7 != 7) {
                return i7 != 9 ? 0 : 1;
            }
        }
        return i9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(21)
    public static Network[] n(b bVar, Network network) {
        NetworkCapabilities networkCapabilitiesD;
        Network[] networkArrA = bVar.a();
        int i7 = 0;
        for (Network network2 : networkArrA) {
            if (!network2.equals(network) && (networkCapabilitiesD = bVar.d(network2)) != null && networkCapabilitiesD.hasCapability(12)) {
                if (!networkCapabilitiesD.hasTransport(4)) {
                    networkArrA[i7] = network2;
                    i7++;
                } else if (bVar.k(network2)) {
                    return new Network[]{network2};
                }
            }
        }
        return (Network[]) Arrays.copyOf(networkArrA, i7);
    }

    @TargetApi(21)
    @org.chromium.base.s0
    static long t(Network network) {
        return y6.a.e(network);
    }

    private boolean u() {
        return this.f39021a == Looper.myLooper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(Runnable runnable) {
        if (u()) {
            runnable.run();
        } else {
            this.f39022b.post(runnable);
        }
    }

    public void A() {
        j();
        if (this.f39031k) {
            this.f39031k = false;
            d dVar = this.f39029i;
            if (dVar != null) {
                this.f39027g.j(dVar);
            }
            c cVar = this.f39026f;
            if (cVar != null) {
                this.f39027g.j(cVar);
            } else {
                org.chromium.base.o.e().unregisterReceiver(this);
            }
        }
    }

    public void m() {
        j();
        this.f39025e.b();
        A();
    }

    public e o() {
        return this.f39027g.f(this.f39028h);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        x(new a());
    }

    public long p() {
        Network networkC = this.f39027g.c();
        if (networkC == null) {
            return -1L;
        }
        return t(networkC);
    }

    public long[] q() {
        Network[] networkArrN = n(this.f39027g, null);
        long[] jArr = new long[networkArrN.length * 2];
        int i7 = 0;
        for (Network network : networkArrN) {
            int i8 = i7 + 1;
            jArr[i7] = t(network);
            i7 = i8 + 1;
            jArr[i8] = this.f39027g.b(network);
        }
        return jArr;
    }

    @org.chromium.base.s0
    g r() {
        return this.f39025e;
    }

    @org.chromium.base.s0
    boolean s() {
        return this.f39031k;
    }

    public void v() {
        j();
        if (this.f39031k) {
            return;
        }
        if (this.f39034n) {
            k();
        }
        c cVar = this.f39026f;
        if (cVar != null) {
            try {
                this.f39027g.h(cVar, this.f39022b);
            } catch (RuntimeException unused) {
                this.f39026f = null;
            }
        }
        if (this.f39026f == null) {
            this.f39033m = org.chromium.base.o.e().registerReceiver(this, this.f39023c) != null;
        }
        this.f39031k = true;
        d dVar = this.f39029i;
        if (dVar != null) {
            dVar.d();
            try {
                this.f39027g.i(this.f39030j, this.f39029i, this.f39022b);
            } catch (RuntimeException unused2) {
                this.f39035o = true;
                this.f39029i = null;
            }
            if (this.f39035o || !this.f39034n) {
                return;
            }
            Network[] networkArrN = n(this.f39027g, null);
            long[] jArr = new long[networkArrN.length];
            for (int i7 = 0; i7 < networkArrN.length; i7++) {
                jArr[i7] = t(networkArrN[i7]);
            }
            this.f39024d.e(jArr);
        }
    }

    public boolean w() {
        return this.f39035o;
    }

    void y(b bVar) {
        this.f39027g = bVar;
    }

    void z(h hVar) {
        this.f39028h = hVar;
    }

    static class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ boolean f39037b = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ConnectivityManager f39038a;

        b(Context context) {
            this.f39038a = (ConnectivityManager) context.getSystemService("connectivity");
        }

        private NetworkInfo e(Network network) {
            try {
                try {
                    return this.f39038a.getNetworkInfo(network);
                } catch (NullPointerException unused) {
                    return null;
                }
            } catch (NullPointerException unused2) {
                return this.f39038a.getNetworkInfo(network);
            }
        }

        @TargetApi(21)
        private NetworkInfo g(NetworkInfo networkInfo) {
            if (networkInfo == null) {
                return null;
            }
            if (networkInfo.isConnected()) {
                return networkInfo;
            }
            if (networkInfo.getDetailedState() == NetworkInfo.DetailedState.BLOCKED && ApplicationStatus.getStateForApplication() == 1) {
                return networkInfo;
            }
            return null;
        }

        @TargetApi(21)
        @org.chromium.base.s0
        protected Network[] a() {
            Network[] allNetworks = this.f39038a.getAllNetworks();
            return allNetworks == null ? new Network[0] : allNetworks;
        }

        @TargetApi(21)
        int b(Network network) {
            NetworkInfo networkInfoE = e(network);
            if (networkInfoE != null && networkInfoE.getType() == 17) {
                networkInfoE = this.f39038a.getActiveNetworkInfo();
            }
            if (networkInfoE == null || !networkInfoE.isConnected()) {
                return 6;
            }
            return NetworkChangeNotifierAutoDetect.l(networkInfoE.getType(), networkInfoE.getSubtype());
        }

        @TargetApi(21)
        Network c() {
            Network networkB = y6.a.b(this.f39038a);
            if (networkB != null) {
                return networkB;
            }
            NetworkInfo activeNetworkInfo = this.f39038a.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            for (Network network : NetworkChangeNotifierAutoDetect.n(this, null)) {
                NetworkInfo networkInfoE = e(network);
                if (networkInfoE != null && (networkInfoE.getType() == activeNetworkInfo.getType() || networkInfoE.getType() == 17)) {
                    networkB = network;
                }
            }
            return networkB;
        }

        @TargetApi(21)
        @org.chromium.base.s0
        protected NetworkCapabilities d(Network network) {
            return this.f39038a.getNetworkCapabilities(network);
        }

        e f(h hVar) {
            int i7 = Build.VERSION.SDK_INT;
            Network networkC = c();
            NetworkInfo networkInfoG = g(y6.a.f(this.f39038a, networkC));
            if (networkInfoG == null) {
                return new e(false, -1, -1, null, false);
            }
            if (networkC != null) {
                return new e(true, networkInfoG.getType(), networkInfoG.getSubtype(), String.valueOf(NetworkChangeNotifierAutoDetect.t(networkC)), i7 >= 28 && AndroidNetworkLibrary.d(this.f39038a.getLinkProperties(networkC)));
            }
            if (networkInfoG.getType() == 1) {
                return (networkInfoG.getExtraInfo() == null || "".equals(networkInfoG.getExtraInfo())) ? new e(true, networkInfoG.getType(), networkInfoG.getSubtype(), hVar.b(), false) : new e(true, networkInfoG.getType(), networkInfoG.getSubtype(), networkInfoG.getExtraInfo(), false);
            }
            return new e(true, networkInfoG.getType(), networkInfoG.getSubtype(), null, false);
        }

        @TargetApi(28)
        void h(ConnectivityManager.NetworkCallback networkCallback, Handler handler) {
            this.f39038a.registerDefaultNetworkCallback(networkCallback, handler);
        }

        @TargetApi(21)
        void i(NetworkRequest networkRequest, ConnectivityManager.NetworkCallback networkCallback, Handler handler) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f39038a.registerNetworkCallback(networkRequest, networkCallback, handler);
            } else {
                this.f39038a.registerNetworkCallback(networkRequest, networkCallback);
            }
        }

        @TargetApi(21)
        void j(ConnectivityManager.NetworkCallback networkCallback) {
            this.f39038a.unregisterNetworkCallback(networkCallback);
        }

        @TargetApi(21)
        @org.chromium.base.s0
        protected boolean k(Network network) {
            Socket socket = new Socket();
            try {
                try {
                    org.chromium.base.m0 m0VarB = org.chromium.base.m0.b();
                    try {
                        network.bindSocket(socket);
                        if (m0VarB != null) {
                            m0VarB.close();
                        }
                        try {
                            socket.close();
                            return true;
                        } catch (IOException unused) {
                            return true;
                        }
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            if (m0VarB != null) {
                                try {
                                    m0VarB.close();
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                }
                            }
                            throw th2;
                        }
                    }
                } catch (IOException unused2) {
                    return false;
                }
            } catch (IOException unused3) {
                socket.close();
                return false;
            } catch (Throwable th4) {
                try {
                    socket.close();
                } catch (IOException unused4) {
                }
                throw th4;
            }
        }

        b() {
            this.f39038a = null;
        }
    }

    static class h {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final /* synthetic */ boolean f39063f = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f39064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f39065b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @GuardedBy("mLock")
        private boolean f39066c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @GuardedBy("mLock")
        private boolean f39067d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @GuardedBy("mLock")
        private WifiManager f39068e;

        h(Context context) {
            this.f39065b = new Object();
            this.f39064a = context;
        }

        @GuardedBy("mLock")
        private WifiInfo a() {
            try {
                try {
                    return this.f39068e.getConnectionInfo();
                } catch (NullPointerException unused) {
                    return null;
                }
            } catch (NullPointerException unused2) {
                return this.f39068e.getConnectionInfo();
            }
        }

        @GuardedBy("mLock")
        @SuppressLint({"WifiManagerPotentialLeak"})
        private boolean c() {
            if (this.f39066c) {
                return this.f39067d;
            }
            boolean z7 = this.f39064a.getPackageManager().checkPermission("android.permission.ACCESS_WIFI_STATE", this.f39064a.getPackageName()) == 0;
            this.f39067d = z7;
            this.f39068e = z7 ? (WifiManager) this.f39064a.getSystemService("wifi") : null;
            this.f39066c = true;
            return this.f39067d;
        }

        String b() {
            synchronized (this.f39065b) {
                if (!c()) {
                    return AndroidNetworkLibrary.getWifiSSID();
                }
                WifiInfo wifiInfoA = a();
                if (wifiInfoA == null) {
                    return "";
                }
                return wifiInfoA.getSSID();
            }
        }

        h() {
            this.f39065b = new Object();
            this.f39064a = null;
        }
    }
}
