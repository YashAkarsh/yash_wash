package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f10671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f10672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f10673c;

    private d() {
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    static void a(@c.m0 Canvas canvas, boolean z7) {
        Method method;
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 29) {
            if (z7) {
                canvas.enableZ();
                return;
            } else {
                canvas.disableZ();
                return;
            }
        }
        if (i7 == 28) {
            throw new IllegalStateException("This method doesn't work on Pie!");
        }
        if (!f10673c) {
            try {
                Method declaredMethod = Canvas.class.getDeclaredMethod("insertReorderBarrier", new Class[0]);
                f10671a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = Canvas.class.getDeclaredMethod("insertInorderBarrier", new Class[0]);
                f10672b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f10673c = true;
        }
        if (z7) {
            try {
                Method method2 = f10671a;
                if (method2 != null) {
                    method2.invoke(canvas, new Object[0]);
                }
            } catch (IllegalAccessException unused2) {
                return;
            } catch (InvocationTargetException e8) {
                throw new RuntimeException(e8.getCause());
            }
        }
        if (z7 || (method = f10672b) == null) {
            return;
        }
        method.invoke(canvas, new Object[0]);
    }
}
