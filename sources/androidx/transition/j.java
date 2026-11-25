package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@c.t0(21)
class j implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10725b = "GhostViewApi21";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Class<?> f10726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f10727d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Method f10728e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f10729f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Method f10730g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f10731h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f10732a;

    private j(@c.m0 View view) {
        this.f10732a = view;
    }

    static h b(View view, ViewGroup viewGroup, Matrix matrix) {
        c();
        Method method = f10728e;
        if (method != null) {
            try {
                return new j((View) method.invoke(null, view, viewGroup, matrix));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e8) {
                throw new RuntimeException(e8.getCause());
            }
        }
        return null;
    }

    private static void c() {
        if (f10729f) {
            return;
        }
        try {
            d();
            Method declaredMethod = f10726c.getDeclaredMethod("addGhost", View.class, ViewGroup.class, Matrix.class);
            f10728e = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e8) {
            Log.i(f10725b, "Failed to retrieve addGhost method", e8);
        }
        f10729f = true;
    }

    private static void d() {
        if (f10727d) {
            return;
        }
        try {
            f10726c = Class.forName("android.view.GhostView");
        } catch (ClassNotFoundException e8) {
            Log.i(f10725b, "Failed to retrieve GhostView class", e8);
        }
        f10727d = true;
    }

    private static void e() {
        if (f10731h) {
            return;
        }
        try {
            d();
            Method declaredMethod = f10726c.getDeclaredMethod("removeGhost", View.class);
            f10730g = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e8) {
            Log.i(f10725b, "Failed to retrieve removeGhost method", e8);
        }
        f10731h = true;
    }

    static void f(View view) {
        e();
        Method method = f10730g;
        if (method != null) {
            try {
                method.invoke(null, view);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e8) {
                throw new RuntimeException(e8.getCause());
            }
        }
    }

    @Override // androidx.transition.h
    public void a(ViewGroup viewGroup, View view) {
    }

    @Override // androidx.transition.h
    public void setVisibility(int i7) {
        this.f10732a.setVisibility(i7);
    }
}
