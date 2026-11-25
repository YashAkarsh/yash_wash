package androidx.appcompat.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.core.view.n2;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
public class r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1965a = "ViewUtils";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f1966b;

    static {
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
            f1966b = declaredMethod;
            if (declaredMethod.isAccessible()) {
                return;
            }
            f1966b.setAccessible(true);
        } catch (NoSuchMethodException unused) {
            Log.d(f1965a, "Could not find method computeFitSystemWindows. Oh well.");
        }
    }

    private r1() {
    }

    public static void a(View view, Rect rect, Rect rect2) {
        Method method = f1966b;
        if (method != null) {
            try {
                method.invoke(view, rect, rect2);
            } catch (Exception e8) {
                Log.d(f1965a, "Could not invoke computeFitSystemWindows", e8);
            }
        }
    }

    public static boolean b(View view) {
        return n2.Z(view) == 1;
    }

    public static void c(View view) {
        try {
            Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(view, new Object[0]);
        } catch (IllegalAccessException e8) {
            Log.d(f1965a, "Could not invoke makeOptionalFitsSystemWindows", e8);
        } catch (NoSuchMethodException unused) {
            Log.d(f1965a, "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        } catch (InvocationTargetException e9) {
            Log.d(f1965a, "Could not invoke makeOptionalFitsSystemWindows", e9);
        }
    }
}
