package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.m;
import androidx.lifecycle.o;
import androidx.lifecycle.q;
import c.j0;
import c.m0;
import c.t0;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
@t0(19)
final class ImmLeaksCleaner implements o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f555b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f556c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f557d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f558e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Field f559f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Field f560g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Field f561h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f562a;

    ImmLeaksCleaner(Activity activity) {
        this.f562a = activity;
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    @j0
    private static void h() {
        try {
            f558e = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f560g = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f561h = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f559f = declaredField3;
            declaredField3.setAccessible(true);
            f558e = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // androidx.lifecycle.o
    public void g(@m0 q qVar, @m0 m.b bVar) {
        if (bVar != m.b.ON_DESTROY) {
            return;
        }
        if (f558e == 0) {
            h();
        }
        if (f558e == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f562a.getSystemService("input_method");
            try {
                Object obj = f559f.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            View view = (View) f560g.get(inputMethodManager);
                            if (view == null) {
                                return;
                            }
                            if (view.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                f561h.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (IllegalAccessException unused) {
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    } catch (ClassCastException unused2) {
                    } catch (IllegalAccessException unused3) {
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }
}
