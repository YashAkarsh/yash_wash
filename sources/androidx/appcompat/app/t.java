package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.core.content.w;
import c.g1;
import c.m0;
import c.w0;
import java.util.Calendar;
import org.apache.commons.lang3.time.DateUtils;

/* JADX INFO: loaded from: classes.dex */
class t {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f879d = "TwilightManager";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f880e = 6;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f881f = 22;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static t f882g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LocationManager f884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f885c = new a();

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f886a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f887b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f888c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f889d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f890e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f891f;

        a() {
        }
    }

    @g1
    t(@m0 Context context, @m0 LocationManager locationManager) {
        this.f883a = context;
        this.f884b = locationManager;
    }

    static t a(@m0 Context context) {
        if (f882g == null) {
            Context applicationContext = context.getApplicationContext();
            f882g = new t(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f882g;
    }

    @SuppressLint({"MissingPermission"})
    private Location b() {
        Location locationC = w.d(this.f883a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c("network") : null;
        Location locationC2 = w.d(this.f883a, "android.permission.ACCESS_FINE_LOCATION") == 0 ? c("gps") : null;
        if (locationC2 == null || locationC == null) {
            return locationC2 != null ? locationC2 : locationC;
        }
        return locationC2.getTime() > locationC.getTime() ? locationC2 : locationC;
    }

    @w0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    private Location c(String str) {
        try {
            if (this.f884b.isProviderEnabled(str)) {
                return this.f884b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e8) {
            Log.d(f879d, "Failed to get last known location", e8);
            return null;
        }
    }

    private boolean e() {
        return this.f885c.f891f > System.currentTimeMillis();
    }

    @g1
    static void f(t tVar) {
        f882g = tVar;
    }

    private void g(@m0 Location location) {
        long j7;
        long j8;
        a aVar = this.f885c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        s sVarB = s.b();
        sVarB.a(jCurrentTimeMillis - DateUtils.MILLIS_PER_DAY, location.getLatitude(), location.getLongitude());
        long j9 = sVarB.f876a;
        sVarB.a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z7 = sVarB.f878c == 1;
        long j10 = sVarB.f877b;
        long j11 = sVarB.f876a;
        sVarB.a(DateUtils.MILLIS_PER_DAY + jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        long j12 = sVarB.f877b;
        if (j10 == -1 || j11 == -1) {
            j7 = jCurrentTimeMillis + 43200000;
        } else {
            if (jCurrentTimeMillis > j11) {
                j8 = 0 + j12;
            } else {
                j8 = jCurrentTimeMillis > j10 ? 0 + j11 : 0 + j10;
            }
            j7 = j8 + DateUtils.MILLIS_PER_MINUTE;
        }
        aVar.f886a = z7;
        aVar.f887b = j9;
        aVar.f888c = j10;
        aVar.f889d = j11;
        aVar.f890e = j12;
        aVar.f891f = j7;
    }

    boolean d() {
        a aVar = this.f885c;
        if (e()) {
            return aVar.f886a;
        }
        Location locationB = b();
        if (locationB != null) {
            g(locationB);
            return aVar.f886a;
        }
        Log.i(f879d, "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i7 = Calendar.getInstance().get(11);
        return i7 < 6 || i7 >= 22;
    }
}
