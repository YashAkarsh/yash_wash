package androidx.core.location;

import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f6050a = "mockLocation";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f6051b = "verticalAccuracy";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f6052c = "speedAccuracy";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f6053d = "bearingAccuracy";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @c.o0
    private static Method f6054e;

    @c.t0(17)
    private static class a {
        private a() {
        }

        @c.t
        static long a(Location location) {
            return location.getElapsedRealtimeNanos();
        }
    }

    @c.t0(18)
    private static class b {
        private b() {
        }

        @c.t
        static boolean a(Location location) {
            return location.isFromMockProvider();
        }
    }

    @c.t0(26)
    private static class c {
        private c() {
        }

        @c.t
        static float a(Location location) {
            return location.getBearingAccuracyDegrees();
        }

        @c.t
        static float b(Location location) {
            return location.getSpeedAccuracyMetersPerSecond();
        }

        @c.t
        static float c(Location location) {
            return location.getVerticalAccuracyMeters();
        }

        @c.t
        static boolean d(Location location) {
            return location.hasBearingAccuracy();
        }

        @c.t
        static boolean e(Location location) {
            return location.hasSpeedAccuracy();
        }

        @c.t
        static boolean f(Location location) {
            return location.hasVerticalAccuracy();
        }

        @c.t
        static void g(Location location, float f8) {
            location.setBearingAccuracyDegrees(f8);
        }

        @c.t
        static void h(Location location, float f8) {
            location.setSpeedAccuracyMetersPerSecond(f8);
        }

        @c.t
        static void i(Location location, float f8) {
            location.setVerticalAccuracyMeters(f8);
        }
    }

    private t() {
    }

    public static float a(@c.m0 Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return c.a(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        return extras.getFloat(f6053d, 0.0f);
    }

    public static long b(@c.m0 Location location) {
        return TimeUnit.NANOSECONDS.toMillis(a.a(location));
    }

    public static long c(@c.m0 Location location) {
        return a.a(location);
    }

    private static Method d() throws NoSuchMethodException {
        if (f6054e == null) {
            Method declaredMethod = Location.class.getDeclaredMethod("setIsFromMockProvider", Boolean.TYPE);
            f6054e = declaredMethod;
            declaredMethod.setAccessible(true);
        }
        return f6054e;
    }

    public static float e(@c.m0 Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return c.b(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        return extras.getFloat(f6052c, 0.0f);
    }

    public static float f(@c.m0 Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return c.c(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        return extras.getFloat("verticalAccuracy", 0.0f);
    }

    public static boolean g(@c.m0 Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return c.d(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return false;
        }
        return extras.containsKey(f6053d);
    }

    public static boolean h(@c.m0 Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return c.e(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return false;
        }
        return extras.containsKey(f6052c);
    }

    public static boolean i(@c.m0 Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return c.f(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return false;
        }
        return extras.containsKey("verticalAccuracy");
    }

    public static boolean j(@c.m0 Location location) {
        return b.a(location);
    }

    public static void k(@c.m0 Location location, float f8) {
        if (Build.VERSION.SDK_INT >= 26) {
            c.g(location, f8);
            return;
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            location.setExtras(new Bundle());
            extras = location.getExtras();
        }
        extras.putFloat(f6053d, f8);
    }

    public static void l(@c.m0 Location location, boolean z7) {
        try {
            d().invoke(location, Boolean.valueOf(z7));
        } catch (IllegalAccessException e8) {
            IllegalAccessError illegalAccessError = new IllegalAccessError();
            illegalAccessError.initCause(e8);
            throw illegalAccessError;
        } catch (NoSuchMethodException e9) {
            NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
            noSuchMethodError.initCause(e9);
            throw noSuchMethodError;
        } catch (InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static void m(@c.m0 Location location, float f8) {
        if (Build.VERSION.SDK_INT >= 26) {
            c.h(location, f8);
            return;
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            location.setExtras(new Bundle());
            extras = location.getExtras();
        }
        extras.putFloat(f6052c, f8);
    }

    public static void n(@c.m0 Location location, float f8) {
        if (Build.VERSION.SDK_INT >= 26) {
            c.i(location, f8);
            return;
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            location.setExtras(new Bundle());
            extras = location.getExtras();
        }
        extras.putFloat("verticalAccuracy", f8);
    }
}
