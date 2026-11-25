package androidx.core.location;

import android.annotation.SuppressLint;
import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f5975a = 30000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f5976b = 10000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f5977c = 5;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Field f5978d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @c.z("sLocationListeners")
    static final WeakHashMap<k, WeakReference<l>> f5979e = new WeakHashMap<>();

    @c.t0(19)
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static Class<?> f5980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static Method f5981b;

        private a() {
        }

        @c.t
        static boolean a(LocationManager locationManager, String str, m1 m1Var, f0 f0Var, Looper looper) {
            try {
                if (f5980a == null) {
                    f5980a = Class.forName("android.location.LocationRequest");
                }
                if (f5981b == null) {
                    Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", f5980a, LocationListener.class, Looper.class);
                    f5981b = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                LocationRequest locationRequestI = m1Var.i(str);
                if (locationRequestI != null) {
                    f5981b.invoke(locationManager, locationRequestI, f0Var, looper);
                    return true;
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
            }
            return false;
        }

        @c.w0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @c.t
        static boolean b(LocationManager locationManager, String str, m1 m1Var, l lVar) {
            try {
                if (f5980a == null) {
                    f5980a = Class.forName("android.location.LocationRequest");
                }
                if (f5981b == null) {
                    Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", f5980a, LocationListener.class, Looper.class);
                    f5981b = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                LocationRequest locationRequestI = m1Var.i(str);
                if (locationRequestI != null) {
                    synchronized (j0.f5979e) {
                        f5981b.invoke(locationManager, locationRequestI, lVar, Looper.getMainLooper());
                        j0.m(locationManager, lVar);
                    }
                    return true;
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
            }
            return false;
        }
    }

    @c.t0(24)
    static class b {
        private b() {
        }

        @c.w0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @c.t
        static boolean a(LocationManager locationManager, Handler handler, Executor executor, androidx.core.location.a.AbstractC0065a abstractC0065a) {
            androidx.core.util.w.a(handler != null);
            androidx.collection.i<Object, Object> iVar = g.f5990a;
            synchronized (iVar) {
                m mVar = (m) iVar.get(abstractC0065a);
                if (mVar == null) {
                    mVar = new m(abstractC0065a);
                } else {
                    mVar.j();
                }
                mVar.i(executor);
                if (!locationManager.registerGnssStatusCallback(mVar, handler)) {
                    return false;
                }
                iVar.put(abstractC0065a, mVar);
                return true;
            }
        }

        @c.t
        static void b(LocationManager locationManager, Object obj) {
            if (obj instanceof m) {
                ((m) obj).j();
            }
            locationManager.unregisterGnssStatusCallback(k0.a(obj));
        }
    }

    @c.t0(28)
    private static class c {
        private c() {
        }

        @c.t
        static String a(LocationManager locationManager) {
            return locationManager.getGnssHardwareModelName();
        }

        @c.t
        static int b(LocationManager locationManager) {
            return locationManager.getGnssYearOfHardware();
        }

        @c.t
        static boolean c(LocationManager locationManager) {
            return locationManager.isLocationEnabled();
        }
    }

    @c.t0(30)
    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static Class<?> f5982a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static Method f5983b;

        private d() {
        }

        @c.w0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @c.t
        static void a(LocationManager locationManager, @c.m0 String str, @c.o0 androidx.core.os.e eVar, @c.m0 Executor executor, @c.m0 final androidx.core.util.e<Location> eVar2) {
            CancellationSignal cancellationSignal = eVar != null ? (CancellationSignal) eVar.b() : null;
            Objects.requireNonNull(eVar2);
            locationManager.getCurrentLocation(str, cancellationSignal, executor, new Consumer() { // from class: androidx.core.location.s0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    eVar2.accept((Location) obj);
                }
            });
        }

        @c.w0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @c.t
        public static boolean b(LocationManager locationManager, Handler handler, Executor executor, androidx.core.location.a.AbstractC0065a abstractC0065a) {
            androidx.collection.i<Object, Object> iVar = g.f5990a;
            synchronized (iVar) {
                h hVar = (h) iVar.get(abstractC0065a);
                if (hVar == null) {
                    hVar = new h(abstractC0065a);
                }
                if (!locationManager.registerGnssStatusCallback(executor, hVar)) {
                    return false;
                }
                iVar.put(abstractC0065a, hVar);
                return true;
            }
        }

        @c.t
        public static boolean c(LocationManager locationManager, String str, m1 m1Var, Executor executor, f0 f0Var) {
            if (Build.VERSION.SDK_INT >= 30) {
                try {
                    if (f5982a == null) {
                        f5982a = Class.forName("android.location.LocationRequest");
                    }
                    if (f5983b == null) {
                        Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", f5982a, Executor.class, LocationListener.class);
                        f5983b = declaredMethod;
                        declaredMethod.setAccessible(true);
                    }
                    LocationRequest locationRequestI = m1Var.i(str);
                    if (locationRequestI != null) {
                        f5983b.invoke(locationManager, locationRequestI, executor, f0Var);
                        return true;
                    }
                } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
                }
            }
            return false;
        }
    }

    @c.t0(31)
    private static class e {
        private e() {
        }

        @c.t
        static boolean a(LocationManager locationManager, @c.m0 String str) {
            return locationManager.hasProvider(str);
        }

        @c.w0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @c.t
        static void b(LocationManager locationManager, @c.m0 String str, @c.m0 LocationRequest locationRequest, @c.m0 Executor executor, @c.m0 LocationListener locationListener) {
            locationManager.requestLocationUpdates(str, locationRequest, executor, locationListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class f implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LocationManager f5984a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Executor f5985b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Handler f5986c = new Handler(Looper.getMainLooper());

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private androidx.core.util.e<Location> f5987d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @c.z("this")
        private boolean f5988e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @c.o0
        Runnable f5989f;

        f(LocationManager locationManager, Executor executor, androidx.core.util.e<Location> eVar) {
            this.f5984a = locationManager;
            this.f5985b = executor;
            this.f5987d = eVar;
        }

        @c.w0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        private void d() {
            this.f5987d = null;
            this.f5984a.removeUpdates(this);
            Runnable runnable = this.f5989f;
            if (runnable != null) {
                this.f5986c.removeCallbacks(runnable);
                this.f5989f = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f() {
            this.f5989f = null;
            onLocationChanged((Location) null);
        }

        @c.w0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void c() {
            synchronized (this) {
                if (this.f5988e) {
                    return;
                }
                this.f5988e = true;
                d();
            }
        }

        @SuppressLint({"MissingPermission"})
        public void g(long j7) {
            synchronized (this) {
                if (this.f5988e) {
                    return;
                }
                Runnable runnable = new Runnable() { // from class: androidx.core.location.v0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6055a.f();
                    }
                };
                this.f5989f = runnable;
                this.f5986c.postDelayed(runnable, j7);
            }
        }

        @Override // android.location.LocationListener
        @c.w0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void onLocationChanged(@c.o0 final Location location) {
            synchronized (this) {
                if (this.f5988e) {
                    return;
                }
                this.f5988e = true;
                final androidx.core.util.e<Location> eVar = this.f5987d;
                this.f5985b.execute(new Runnable() { // from class: androidx.core.location.w0
                    @Override // java.lang.Runnable
                    public final void run() {
                        eVar.accept(location);
                    }
                });
                d();
            }
        }

        @Override // android.location.LocationListener
        @c.w0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void onProviderDisabled(@c.m0 String str) {
            onLocationChanged((Location) null);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(@c.m0 String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i7, Bundle bundle) {
        }
    }

    private static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @c.z("sGnssStatusListeners")
        static final androidx.collection.i<Object, Object> f5990a = new androidx.collection.i<>();

        private g() {
        }
    }

    @c.t0(30)
    private static class h extends GnssStatus.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final androidx.core.location.a.AbstractC0065a f5991a;

        h(androidx.core.location.a.AbstractC0065a abstractC0065a) {
            androidx.core.util.w.b(abstractC0065a != null, "invalid null callback");
            this.f5991a = abstractC0065a;
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i7) {
            this.f5991a.a(i7);
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            this.f5991a.b(androidx.core.location.a.n(gnssStatus));
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            this.f5991a.c();
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            this.f5991a.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class i implements GpsStatus.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LocationManager f5992a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final androidx.core.location.a.AbstractC0065a f5993b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @c.o0
        volatile Executor f5994c;

        i(LocationManager locationManager, androidx.core.location.a.AbstractC0065a abstractC0065a) {
            androidx.core.util.w.b(abstractC0065a != null, "invalid null callback");
            this.f5992a = locationManager;
            this.f5993b = abstractC0065a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(Executor executor) {
            if (this.f5994c != executor) {
                return;
            }
            this.f5993b.c();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(Executor executor) {
            if (this.f5994c != executor) {
                return;
            }
            this.f5993b.d();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(Executor executor, int i7) {
            if (this.f5994c != executor) {
                return;
            }
            this.f5993b.a(i7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(Executor executor, androidx.core.location.a aVar) {
            if (this.f5994c != executor) {
                return;
            }
            this.f5993b.b(aVar);
        }

        public void i(Executor executor) {
            androidx.core.util.w.n(this.f5994c == null);
            this.f5994c = executor;
        }

        public void j() {
            this.f5994c = null;
        }

        @Override // android.location.GpsStatus.Listener
        @c.w0("android.permission.ACCESS_FINE_LOCATION")
        public void onGpsStatusChanged(int i7) {
            GpsStatus gpsStatus;
            final Executor executor = this.f5994c;
            if (executor == null) {
                return;
            }
            if (i7 == 1) {
                executor.execute(new Runnable() { // from class: androidx.core.location.x0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6058a.e(executor);
                    }
                });
                return;
            }
            if (i7 == 2) {
                executor.execute(new Runnable() { // from class: androidx.core.location.y0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6060a.f(executor);
                    }
                });
                return;
            }
            if (i7 != 3) {
                if (i7 == 4 && (gpsStatus = this.f5992a.getGpsStatus(null)) != null) {
                    final androidx.core.location.a aVarO = androidx.core.location.a.o(gpsStatus);
                    executor.execute(new Runnable() { // from class: androidx.core.location.a1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f5948a.h(executor, aVarO);
                        }
                    });
                    return;
                }
                return;
            }
            GpsStatus gpsStatus2 = this.f5992a.getGpsStatus(null);
            if (gpsStatus2 != null) {
                final int timeToFirstFix = gpsStatus2.getTimeToFirstFix();
                executor.execute(new Runnable() { // from class: androidx.core.location.z0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6062a.g(executor, timeToFirstFix);
                    }
                });
            }
        }
    }

    private static final class j implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f5995a;

        j(@c.m0 Handler handler) {
            this.f5995a = (Handler) androidx.core.util.w.l(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(@c.m0 Runnable runnable) {
            if (Looper.myLooper() == this.f5995a.getLooper()) {
                runnable.run();
            } else {
                if (this.f5995a.post((Runnable) androidx.core.util.w.l(runnable))) {
                    return;
                }
                throw new RejectedExecutionException(this.f5995a + " is shutting down");
            }
        }
    }

    private static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f5996a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final f0 f5997b;

        k(String str, f0 f0Var) {
            this.f5996a = (String) androidx.core.util.r.e(str, "invalid null provider");
            this.f5997b = (f0) androidx.core.util.r.e(f0Var, "invalid null listener");
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            return this.f5996a.equals(kVar.f5996a) && this.f5997b.equals(kVar.f5997b);
        }

        public int hashCode() {
            return androidx.core.util.r.b(this.f5996a, this.f5997b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @c.t0(24)
    static class m extends GnssStatus.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final androidx.core.location.a.AbstractC0065a f6000a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @c.o0
        volatile Executor f6001b;

        m(androidx.core.location.a.AbstractC0065a abstractC0065a) {
            androidx.core.util.w.b(abstractC0065a != null, "invalid null callback");
            this.f6000a = abstractC0065a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(Executor executor, int i7) {
            if (this.f6001b != executor) {
                return;
            }
            this.f6000a.a(i7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(Executor executor, GnssStatus gnssStatus) {
            if (this.f6001b != executor) {
                return;
            }
            this.f6000a.b(androidx.core.location.a.n(gnssStatus));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(Executor executor) {
            if (this.f6001b != executor) {
                return;
            }
            this.f6000a.c();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(Executor executor) {
            if (this.f6001b != executor) {
                return;
            }
            this.f6000a.d();
        }

        public void i(Executor executor) {
            androidx.core.util.w.b(executor != null, "invalid null executor");
            androidx.core.util.w.n(this.f6001b == null);
            this.f6001b = executor;
        }

        public void j() {
            this.f6001b = null;
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(final int i7) {
            final Executor executor = this.f6001b;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: androidx.core.location.j1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6002a.e(executor, i7);
                }
            });
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(final GnssStatus gnssStatus) {
            final Executor executor = this.f6001b;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: androidx.core.location.i1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f5972a.f(executor, gnssStatus);
                }
            });
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            final Executor executor = this.f6001b;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: androidx.core.location.h1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f5969a.g(executor);
                }
            });
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            final Executor executor = this.f6001b;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: androidx.core.location.k1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6005a.h(executor);
                }
            });
        }
    }

    private j0() {
    }

    @c.w0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void c(@c.m0 LocationManager locationManager, @c.m0 String str, @c.o0 androidx.core.os.e eVar, @c.m0 Executor executor, @c.m0 final androidx.core.util.e<Location> eVar2) {
        if (Build.VERSION.SDK_INT >= 30) {
            d.a(locationManager, str, eVar, executor, eVar2);
            return;
        }
        if (eVar != null) {
            eVar.e();
        }
        final Location lastKnownLocation = locationManager.getLastKnownLocation(str);
        if (lastKnownLocation != null && SystemClock.elapsedRealtime() - t.b(lastKnownLocation) < 10000) {
            executor.execute(new Runnable() { // from class: androidx.core.location.h0
                @Override // java.lang.Runnable
                public final void run() {
                    eVar2.accept(lastKnownLocation);
                }
            });
            return;
        }
        final f fVar = new f(locationManager, executor, eVar2);
        locationManager.requestLocationUpdates(str, 0L, 0.0f, fVar, Looper.getMainLooper());
        if (eVar != null) {
            eVar.d(new androidx.core.os.e.b() { // from class: androidx.core.location.i0
                @Override // androidx.core.os.e.b
                public final void onCancel() {
                    fVar.c();
                }
            });
        }
        fVar.g(f5975a);
    }

    @c.o0
    public static String d(@c.m0 LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return c.a(locationManager);
        }
        return null;
    }

    public static int e(@c.m0 LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return c.b(locationManager);
        }
        return 0;
    }

    public static boolean f(@c.m0 LocationManager locationManager, @c.m0 String str) {
        if (Build.VERSION.SDK_INT >= 31) {
            return e.a(locationManager, str);
        }
        if (locationManager.getAllProviders().contains(str)) {
            return true;
        }
        try {
            return locationManager.getProvider(str) != null;
        } catch (SecurityException unused) {
            return false;
        }
    }

    public static boolean g(@c.m0 LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return c.c(locationManager);
        }
        return locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled("gps");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean i(LocationManager locationManager, i iVar) throws Exception {
        return Boolean.valueOf(locationManager.addGpsStatusListener(iVar));
    }

    /* JADX WARN: Code duplicated, block: B:60:0x00c5 A[Catch: all -> 0x00e1, TryCatch #0 {all -> 0x00e1, blocks: (B:54:0x00a4, B:55:0x00ba, B:58:0x00bd, B:60:0x00c5, B:62:0x00cd, B:63:0x00d3, B:64:0x00d4, B:65:0x00d9, B:66:0x00da, B:67:0x00e0, B:44:0x0093), top: B:77:0x0053 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x00cd A[Catch: all -> 0x00e1, TryCatch #0 {all -> 0x00e1, blocks: (B:54:0x00a4, B:55:0x00ba, B:58:0x00bd, B:60:0x00c5, B:62:0x00cd, B:63:0x00d3, B:64:0x00d4, B:65:0x00d9, B:66:0x00da, B:67:0x00e0, B:44:0x0093), top: B:77:0x0053 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x00d4 A[Catch: all -> 0x00e1, TryCatch #0 {all -> 0x00e1, blocks: (B:54:0x00a4, B:55:0x00ba, B:58:0x00bd, B:60:0x00c5, B:62:0x00cd, B:63:0x00d3, B:64:0x00d4, B:65:0x00d9, B:66:0x00da, B:67:0x00e0, B:44:0x0093), top: B:77:0x0053 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x00da A[Catch: all -> 0x00e1, TryCatch #0 {all -> 0x00e1, blocks: (B:54:0x00a4, B:55:0x00ba, B:58:0x00bd, B:60:0x00c5, B:62:0x00cd, B:63:0x00d3, B:64:0x00d4, B:65:0x00d9, B:66:0x00da, B:67:0x00e0, B:44:0x0093), top: B:77:0x0053 }] */
    @c.w0("android.permission.ACCESS_FINE_LOCATION")
    private static boolean j(final LocationManager locationManager, Handler handler, Executor executor, androidx.core.location.a.AbstractC0065a abstractC0065a) {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 30) {
            return d.b(locationManager, handler, executor, abstractC0065a);
        }
        if (i7 >= 24) {
            return b.a(locationManager, handler, executor, abstractC0065a);
        }
        boolean z7 = true;
        androidx.core.util.w.a(handler != null);
        androidx.collection.i<Object, Object> iVar = g.f5990a;
        synchronized (iVar) {
            final i iVar2 = (i) iVar.get(abstractC0065a);
            if (iVar2 == null) {
                iVar2 = new i(locationManager, abstractC0065a);
            } else {
                iVar2.j();
            }
            iVar2.i(executor);
            FutureTask futureTask = new FutureTask(new Callable() { // from class: androidx.core.location.g0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return j0.i(locationManager, iVar2);
                }
            });
            if (Looper.myLooper() == handler.getLooper()) {
                futureTask.run();
            } else if (!handler.post(futureTask)) {
                throw new IllegalStateException(handler + " is shutting down");
            }
            try {
                try {
                    long nanos = TimeUnit.SECONDS.toNanos(5L);
                    long jNanoTime = System.nanoTime() + nanos;
                    boolean z8 = false;
                    while (((Boolean) futureTask.get(nanos, TimeUnit.NANOSECONDS)).booleanValue()) {
                        try {
                            try {
                                g.f5990a.put(abstractC0065a, iVar2);
                                if (z8) {
                                    Thread.currentThread().interrupt();
                                }
                                return true;
                            } catch (ExecutionException e8) {
                                e = e8;
                                if (!(e.getCause() instanceof RuntimeException)) {
                                    throw ((RuntimeException) e.getCause());
                                }
                                if (e.getCause() instanceof Error) {
                                    throw ((Error) e.getCause());
                                }
                                throw new IllegalStateException(e);
                            } catch (TimeoutException e9) {
                                e = e9;
                                throw new IllegalStateException(handler + " appears to be blocked, please run registerGnssStatusCallback() directly on a Looper thread or ensure the main Looper is not blocked by this thread", e);
                            }
                        } catch (InterruptedException unused) {
                            nanos = jNanoTime - System.nanoTime();
                            z8 = true;
                        } catch (ExecutionException e10) {
                            e = e10;
                            if (!(e.getCause() instanceof RuntimeException)) {
                                throw ((RuntimeException) e.getCause());
                            }
                            if (e.getCause() instanceof Error) {
                                throw ((Error) e.getCause());
                            }
                            throw new IllegalStateException(e);
                        } catch (TimeoutException e11) {
                            e = e11;
                            throw new IllegalStateException(handler + " appears to be blocked, please run registerGnssStatusCallback() directly on a Looper thread or ensure the main Looper is not blocked by this thread", e);
                        } catch (Throwable th) {
                            th = th;
                            z7 = z8;
                            if (z7) {
                                Thread.currentThread().interrupt();
                            }
                            throw th;
                        }
                    }
                    if (z8) {
                        Thread.currentThread().interrupt();
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (ExecutionException e12) {
                e = e12;
            } catch (TimeoutException e13) {
                e = e13;
            } catch (Throwable th3) {
                th = th3;
                z7 = false;
            }
        }
    }

    @c.w0("android.permission.ACCESS_FINE_LOCATION")
    public static boolean k(@c.m0 LocationManager locationManager, @c.m0 androidx.core.location.a.AbstractC0065a abstractC0065a, @c.m0 Handler handler) {
        return Build.VERSION.SDK_INT >= 30 ? l(locationManager, androidx.core.os.i.a(handler), abstractC0065a) : l(locationManager, new j(handler), abstractC0065a);
    }

    @c.w0("android.permission.ACCESS_FINE_LOCATION")
    public static boolean l(@c.m0 LocationManager locationManager, @c.m0 Executor executor, @c.m0 androidx.core.location.a.AbstractC0065a abstractC0065a) {
        if (Build.VERSION.SDK_INT >= 30) {
            return j(locationManager, null, executor, abstractC0065a);
        }
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == null) {
            looperMyLooper = Looper.getMainLooper();
        }
        return j(locationManager, new Handler(looperMyLooper), executor, abstractC0065a);
    }

    @c.w0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @c.z("sLocationListeners")
    static void m(LocationManager locationManager, l lVar) {
        WeakReference<l> weakReferencePut = f5979e.put(lVar.g(), new WeakReference<>(lVar));
        l lVar2 = weakReferencePut != null ? weakReferencePut.get() : null;
        if (lVar2 != null) {
            lVar2.n();
            locationManager.removeUpdates(lVar2);
        }
    }

    @c.w0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void n(@c.m0 LocationManager locationManager, @c.m0 f0 f0Var) {
        WeakHashMap<k, WeakReference<l>> weakHashMap = f5979e;
        synchronized (weakHashMap) {
            Iterator<WeakReference<l>> it = weakHashMap.values().iterator();
            ArrayList arrayList = null;
            while (it.hasNext()) {
                l lVar = it.next().get();
                if (lVar != null) {
                    k kVarG = lVar.g();
                    if (kVarG.f5997b == f0Var) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(kVarG);
                        lVar.n();
                        locationManager.removeUpdates(lVar);
                    }
                }
            }
            if (arrayList != null) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    f5979e.remove((k) it2.next());
                }
            }
        }
        locationManager.removeUpdates(f0Var);
    }

    @c.w0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void o(@c.m0 LocationManager locationManager, @c.m0 String str, @c.m0 m1 m1Var, @c.m0 f0 f0Var, @c.m0 Looper looper) {
        if (Build.VERSION.SDK_INT >= 31) {
            e.b(locationManager, str, m1Var.h(), androidx.core.os.i.a(new Handler(looper)), f0Var);
        } else {
            if (a.a(locationManager, str, m1Var, f0Var, looper)) {
                return;
            }
            locationManager.requestLocationUpdates(str, m1Var.b(), m1Var.e(), f0Var, looper);
        }
    }

    @c.w0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void p(@c.m0 LocationManager locationManager, @c.m0 String str, @c.m0 m1 m1Var, @c.m0 Executor executor, @c.m0 f0 f0Var) {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 31) {
            e.b(locationManager, str, m1Var.h(), executor, f0Var);
            return;
        }
        if (i7 < 30 || !d.c(locationManager, str, m1Var, executor, f0Var)) {
            l lVar = new l(new k(str, f0Var), executor);
            if (a.b(locationManager, str, m1Var, lVar)) {
                return;
            }
            synchronized (f5979e) {
                locationManager.requestLocationUpdates(str, m1Var.b(), m1Var.e(), lVar, Looper.getMainLooper());
                m(locationManager, lVar);
            }
        }
    }

    public static void q(@c.m0 LocationManager locationManager, @c.m0 androidx.core.location.a.AbstractC0065a abstractC0065a) {
        if (Build.VERSION.SDK_INT >= 24) {
            androidx.collection.i<Object, Object> iVar = g.f5990a;
            synchronized (iVar) {
                Object objRemove = iVar.remove(abstractC0065a);
                if (objRemove != null) {
                    b.b(locationManager, objRemove);
                }
            }
            return;
        }
        androidx.collection.i<Object, Object> iVar2 = g.f5990a;
        synchronized (iVar2) {
            i iVar3 = (i) iVar2.remove(abstractC0065a);
            if (iVar3 != null) {
                iVar3.j();
                locationManager.removeGpsStatusListener(iVar3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class l implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @c.o0
        volatile k f5998a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Executor f5999b;

        l(@c.o0 k kVar, Executor executor) {
            this.f5998a = kVar;
            this.f5999b = executor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(int i7) {
            k kVar = this.f5998a;
            if (kVar == null) {
                return;
            }
            kVar.f5997b.onFlushComplete(i7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(Location location) {
            k kVar = this.f5998a;
            if (kVar == null) {
                return;
            }
            kVar.f5997b.onLocationChanged(location);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(List list) {
            k kVar = this.f5998a;
            if (kVar == null) {
                return;
            }
            kVar.f5997b.onLocationChanged((List<Location>) list);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(String str) {
            k kVar = this.f5998a;
            if (kVar == null) {
                return;
            }
            kVar.f5997b.onProviderDisabled(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(String str) {
            k kVar = this.f5998a;
            if (kVar == null) {
                return;
            }
            kVar.f5997b.onProviderEnabled(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(String str, int i7, Bundle bundle) {
            k kVar = this.f5998a;
            if (kVar == null) {
                return;
            }
            kVar.f5997b.onStatusChanged(str, i7, bundle);
        }

        public k g() {
            return (k) androidx.core.util.r.d(this.f5998a);
        }

        public void n() {
            this.f5998a = null;
        }

        @Override // android.location.LocationListener
        public void onFlushComplete(final int i7) {
            if (this.f5998a == null) {
                return;
            }
            this.f5999b.execute(new Runnable() { // from class: androidx.core.location.c1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f5953a.h(i7);
                }
            });
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(@c.m0 final Location location) {
            if (this.f5998a == null) {
                return;
            }
            this.f5999b.execute(new Runnable() { // from class: androidx.core.location.f1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f5959a.i(location);
                }
            });
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(@c.m0 final String str) {
            if (this.f5998a == null) {
                return;
            }
            this.f5999b.execute(new Runnable() { // from class: androidx.core.location.e1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f5957a.k(str);
                }
            });
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(@c.m0 final String str) {
            if (this.f5998a == null) {
                return;
            }
            this.f5999b.execute(new Runnable() { // from class: androidx.core.location.b1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f5951a.l(str);
                }
            });
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(final String str, final int i7, final Bundle bundle) {
            if (this.f5998a == null) {
                return;
            }
            this.f5999b.execute(new Runnable() { // from class: androidx.core.location.g1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f5963a.m(str, i7, bundle);
                }
            });
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(@c.m0 final List<Location> list) {
            if (this.f5998a == null) {
                return;
            }
            this.f5999b.execute(new Runnable() { // from class: androidx.core.location.d1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f5955a.j(list);
                }
            });
        }
    }
}
