package androidx.transition;

import android.animation.LayoutTransition;
import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f10743a = "ViewGroupUtilsApi14";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f10744b = 4;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static LayoutTransition f10745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Field f10746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f10747e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Method f10748f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f10749g;

    static class a extends LayoutTransition {
        a() {
        }

        @Override // android.animation.LayoutTransition
        public boolean isChangingLayout() {
            return true;
        }
    }

    private m0() {
    }

    private static void a(LayoutTransition layoutTransition) {
        if (!f10749g) {
            try {
                Method declaredMethod = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                f10748f = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.i(f10743a, "Failed to access cancel method by reflection");
            }
            f10749g = true;
        }
        Method method = f10748f;
        if (method != null) {
            try {
                method.invoke(layoutTransition, new Object[0]);
            } catch (IllegalAccessException unused2) {
                Log.i(f10743a, "Failed to access cancel method by reflection");
            } catch (InvocationTargetException unused3) {
                Log.i(f10743a, "Failed to invoke cancel method by reflection");
            }
        }
    }

    static void b(@c.m0 ViewGroup viewGroup, boolean z7) {
        boolean z8 = false;
        if (f10745c == null) {
            a aVar = new a();
            f10745c = aVar;
            aVar.setAnimator(2, null);
            f10745c.setAnimator(0, null);
            f10745c.setAnimator(1, null);
            f10745c.setAnimator(3, null);
            f10745c.setAnimator(4, null);
        }
        if (z7) {
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null) {
                if (layoutTransition.isRunning()) {
                    a(layoutTransition);
                }
                if (layoutTransition != f10745c) {
                    viewGroup.setTag(R.id.transition_layout_save, layoutTransition);
                }
            }
            viewGroup.setLayoutTransition(f10745c);
            return;
        }
        viewGroup.setLayoutTransition(null);
        if (!f10747e) {
            try {
                Field declaredField = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
                f10746d = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i(f10743a, "Failed to access mLayoutSuppressed field by reflection");
            }
            f10747e = true;
        }
        Field field = f10746d;
        if (field != null) {
            try {
                boolean z9 = field.getBoolean(viewGroup);
                if (z9) {
                    try {
                        f10746d.setBoolean(viewGroup, false);
                    } catch (IllegalAccessException unused2) {
                        z8 = z9;
                        Log.i(f10743a, "Failed to get mLayoutSuppressed field by reflection");
                    }
                }
                z8 = z9;
            } catch (IllegalAccessException unused3) {
            }
        }
        if (z8) {
            viewGroup.requestLayout();
        }
        LayoutTransition layoutTransition2 = (LayoutTransition) viewGroup.getTag(R.id.transition_layout_save);
        if (layoutTransition2 != null) {
            viewGroup.setTag(R.id.transition_layout_save, null);
            viewGroup.setLayoutTransition(layoutTransition2);
        }
    }
}
