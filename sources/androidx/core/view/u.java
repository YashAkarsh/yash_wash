package androidx.core.view;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;

/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f6838a = 3840;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f6839b = 2160;

    @c.t0(17)
    static class a {
        private a() {
        }

        static void a(Display display, Point point) {
            display.getRealSize(point);
        }
    }

    @c.t0(23)
    static class b {
        private b() {
        }

        @c.m0
        static c a(@c.m0 Context context, @c.m0 Display display) {
            Display.Mode mode = display.getMode();
            Point pointA = u.a(context, display);
            return (pointA == null || d(mode, pointA)) ? new c(mode, true) : new c(mode, pointA);
        }

        @c.m0
        @SuppressLint({"ArrayReturn"})
        public static c[] b(@c.m0 Context context, @c.m0 Display display) {
            Display.Mode[] supportedModes = display.getSupportedModes();
            c[] cVarArr = new c[supportedModes.length];
            Display.Mode mode = display.getMode();
            Point pointA = u.a(context, display);
            if (pointA == null || d(mode, pointA)) {
                for (int i7 = 0; i7 < supportedModes.length; i7++) {
                    cVarArr[i7] = new c(supportedModes[i7], e(supportedModes[i7], mode));
                }
            } else {
                for (int i8 = 0; i8 < supportedModes.length; i8++) {
                    cVarArr[i8] = e(supportedModes[i8], mode) ? new c(supportedModes[i8], pointA) : new c(supportedModes[i8], false);
                }
            }
            return cVarArr;
        }

        static boolean c(@c.m0 Display display) {
            Display.Mode mode = display.getMode();
            for (Display.Mode mode2 : display.getSupportedModes()) {
                if (mode.getPhysicalHeight() < mode2.getPhysicalHeight() || mode.getPhysicalWidth() < mode2.getPhysicalWidth()) {
                    return false;
                }
            }
            return true;
        }

        static boolean d(Display.Mode mode, Point point) {
            return (mode.getPhysicalWidth() == point.x && mode.getPhysicalHeight() == point.y) || (mode.getPhysicalWidth() == point.y && mode.getPhysicalHeight() == point.x);
        }

        static boolean e(Display.Mode mode, Display.Mode mode2) {
            return mode.getPhysicalWidth() == mode2.getPhysicalWidth() && mode.getPhysicalHeight() == mode2.getPhysicalHeight();
        }
    }

    private u() {
    }

    static Point a(@c.m0 Context context, @c.m0 Display display) {
        Point pointJ = Build.VERSION.SDK_INT < 28 ? j("sys.display-size", display) : j("vendor.display-size", display);
        if (pointJ != null) {
            return pointJ;
        }
        if (g(context) && f(display)) {
            return new Point(f6838a, f6839b);
        }
        return null;
    }

    @c.m0
    private static Point b(@c.m0 Context context, @c.m0 Display display) {
        Point pointA = a(context, display);
        if (pointA != null) {
            return pointA;
        }
        Point point = new Point();
        a.a(display, point);
        return point;
    }

    @c.m0
    public static c c(@c.m0 Context context, @c.m0 Display display) {
        return b.a(context, display);
    }

    @c.m0
    @SuppressLint({"ArrayReturn"})
    public static c[] d(@c.m0 Context context, @c.m0 Display display) {
        return b.b(context, display);
    }

    @c.o0
    private static String e(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception unused) {
            return null;
        }
    }

    static boolean f(@c.m0 Display display) {
        return b.c(display);
    }

    private static boolean g(@c.m0 Context context) {
        return h(context) && "Sony".equals(Build.MANUFACTURER) && Build.MODEL.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd");
    }

    private static boolean h(@c.m0 Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    private static Point i(@c.m0 String str) throws NumberFormatException {
        String[] strArrSplit = str.trim().split("x", -1);
        if (strArrSplit.length == 2) {
            int i7 = Integer.parseInt(strArrSplit[0]);
            int i8 = Integer.parseInt(strArrSplit[1]);
            if (i7 > 0 && i8 > 0) {
                return new Point(i7, i8);
            }
        }
        throw new NumberFormatException();
    }

    @c.o0
    private static Point j(@c.m0 String str, @c.m0 Display display) {
        if (display.getDisplayId() != 0) {
            return null;
        }
        String strE = e(str);
        if (!TextUtils.isEmpty(strE) && strE != null) {
            try {
                return i(strE);
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Display.Mode f6840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Point f6841b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f6842c;

        @c.t0(23)
        static class a {
            private a() {
            }

            @c.t
            static int a(Display.Mode mode) {
                return mode.getPhysicalHeight();
            }

            @c.t
            static int b(Display.Mode mode) {
                return mode.getPhysicalWidth();
            }
        }

        c(@c.m0 Point point) {
            androidx.core.util.w.m(point, "physicalSize == null");
            this.f6841b = point;
            this.f6840a = null;
            this.f6842c = true;
        }

        public int a() {
            return this.f6841b.y;
        }

        public int b() {
            return this.f6841b.x;
        }

        @Deprecated
        public boolean c() {
            return this.f6842c;
        }

        @c.o0
        @c.t0(23)
        public Display.Mode d() {
            return this.f6840a;
        }

        @c.t0(23)
        c(@c.m0 Display.Mode mode, boolean z7) {
            androidx.core.util.w.m(mode, "mode == null, can't wrap a null reference");
            this.f6841b = new Point(a.b(mode), a.a(mode));
            this.f6840a = mode;
            this.f6842c = z7;
        }

        @c.t0(23)
        c(@c.m0 Display.Mode mode, @c.m0 Point point) {
            androidx.core.util.w.m(mode, "mode == null, can't wrap a null reference");
            androidx.core.util.w.m(point, "physicalSize == null");
            this.f6841b = point;
            this.f6840a = mode;
            this.f6842c = true;
        }
    }
}
