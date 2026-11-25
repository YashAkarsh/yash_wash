package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f10740a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f10741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f10742c;

    private l0() {
    }

    static int a(@c.m0 ViewGroup viewGroup, int i7) {
        if (Build.VERSION.SDK_INT >= 29) {
            return viewGroup.getChildDrawingOrder(i7);
        }
        if (!f10742c) {
            try {
                Class cls = Integer.TYPE;
                Method declaredMethod = ViewGroup.class.getDeclaredMethod("getChildDrawingOrder", cls, cls);
                f10741b = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f10742c = true;
        }
        Method method = f10741b;
        if (method != null) {
            try {
                return ((Integer) method.invoke(viewGroup, Integer.valueOf(viewGroup.getChildCount()), Integer.valueOf(i7))).intValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return i7;
    }

    static i0 b(@c.m0 ViewGroup viewGroup) {
        return new h0(viewGroup);
    }

    @c.t0(18)
    @SuppressLint({"NewApi"})
    private static void c(@c.m0 ViewGroup viewGroup, boolean z7) {
        if (f10740a) {
            try {
                viewGroup.suppressLayout(z7);
            } catch (NoSuchMethodError unused) {
                f10740a = false;
            }
        }
    }

    static void d(@c.m0 ViewGroup viewGroup, boolean z7) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z7);
        } else {
            c(viewGroup, z7);
        }
    }
}
