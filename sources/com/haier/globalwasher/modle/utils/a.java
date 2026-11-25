package com.haier.globalwasher.modle.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f24537a = false;

    public static boolean a(Window window, boolean z7) {
        if (window != null) {
            try {
                WindowManager.LayoutParams attributes = window.getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i7 = declaredField.getInt(null);
                int i8 = declaredField2.getInt(attributes);
                declaredField2.setInt(attributes, z7 ? i8 | i7 : (~i7) & i8);
                window.setAttributes(attributes);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean b(Window window, boolean z7) {
        if (window == null) {
            return false;
        }
        Class<?> cls = window.getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i7 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Class<?> cls3 = Integer.TYPE;
            Method method = cls.getMethod("setExtraFlags", cls3, cls3);
            if (z7) {
                method.invoke(window, Integer.valueOf(i7), Integer.valueOf(i7));
            } else {
                method.invoke(window, 0, Integer.valueOf(i7));
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int c(BaseActivity baseActivity) {
        if (b(baseActivity.getWindow(), true)) {
            return 1;
        }
        return a(baseActivity.getWindow(), true) ? 2 : 0;
    }

    protected static void d(BaseActivity baseActivity) {
        baseActivity.getWindow().getDecorView().setSystemUiVisibility(f4.e.a.f33921a);
        if (f24537a) {
            baseActivity.getWindow().setStatusBarColor(baseActivity.getResources().getColor(R.color.black));
        } else {
            baseActivity.getWindow().setStatusBarColor(baseActivity.getResources().getColor(R.color.black));
        }
    }

    public static void e(BaseActivity baseActivity, int i7) {
        f(baseActivity);
        d(baseActivity);
    }

    @TargetApi(19)
    private static void f(Activity activity) {
        activity.getWindow().addFlags(Integer.MIN_VALUE);
        activity.getWindow().clearFlags(67108864);
        activity.getWindow().addFlags(134217728);
        activity.getWindow().setStatusBarColor(0);
    }
}
