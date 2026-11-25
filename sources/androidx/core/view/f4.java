package androidx.core.view;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class f4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6564a = "ViewConfigCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f6565b;

    @c.t0(26)
    static class a {
        private a() {
        }

        @c.t
        static float a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHorizontalScrollFactor();
        }

        @c.t
        static float b(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledVerticalScrollFactor();
        }
    }

    @c.t0(28)
    static class b {
        private b() {
        }

        @c.t
        static int a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHoverSlop();
        }

        @c.t
        static boolean b(ViewConfiguration viewConfiguration) {
            return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
    }

    static {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                f6565b = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
            } catch (Exception unused) {
                Log.i(f6564a, "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
    }

    private f4() {
    }

    private static float a(ViewConfiguration viewConfiguration, Context context) {
        Method method;
        if (Build.VERSION.SDK_INT >= 25 && (method = f6565b) != null) {
            try {
                return ((Integer) method.invoke(viewConfiguration, new Object[0])).intValue();
            } catch (Exception unused) {
                Log.i(f6564a, "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
            return typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    public static float b(@c.m0 ViewConfiguration viewConfiguration, @c.m0 Context context) {
        return Build.VERSION.SDK_INT >= 26 ? a.a(viewConfiguration) : a(viewConfiguration, context);
    }

    public static int c(@c.m0 ViewConfiguration viewConfiguration) {
        return Build.VERSION.SDK_INT >= 28 ? b.a(viewConfiguration) : viewConfiguration.getScaledTouchSlop() / 2;
    }

    @Deprecated
    public static int d(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledPagingTouchSlop();
    }

    public static float e(@c.m0 ViewConfiguration viewConfiguration, @c.m0 Context context) {
        return Build.VERSION.SDK_INT >= 26 ? a.b(viewConfiguration) : a(viewConfiguration, context);
    }

    @Deprecated
    public static boolean f(ViewConfiguration viewConfiguration) {
        return viewConfiguration.hasPermanentMenuKey();
    }

    public static boolean g(@c.m0 ViewConfiguration viewConfiguration, @c.m0 Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return b.b(viewConfiguration);
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
        return identifier != 0 && resources.getBoolean(identifier);
    }
}
