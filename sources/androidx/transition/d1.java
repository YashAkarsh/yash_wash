package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class d1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10677b = "ViewUtilsBase";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f10678c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f10679d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Field f10680e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f10681f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f10682g = 12;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float[] f10683a;

    d1() {
    }

    @SuppressLint({"PrivateApi"})
    private void b() {
        if (f10679d) {
            return;
        }
        try {
            Class cls = Integer.TYPE;
            Method declaredMethod = View.class.getDeclaredMethod("setFrame", cls, cls, cls, cls);
            f10678c = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e8) {
            Log.i(f10677b, "Failed to retrieve setFrame method", e8);
        }
        f10679d = true;
    }

    public void a(@c.m0 View view) {
        if (view.getVisibility() == 0) {
            view.setTag(R.id.save_non_transition_alpha, null);
        }
    }

    public float c(@c.m0 View view) {
        Float f8 = (Float) view.getTag(R.id.save_non_transition_alpha);
        return f8 != null ? view.getAlpha() / f8.floatValue() : view.getAlpha();
    }

    public void d(@c.m0 View view) {
        if (view.getTag(R.id.save_non_transition_alpha) == null) {
            view.setTag(R.id.save_non_transition_alpha, Float.valueOf(view.getAlpha()));
        }
    }

    public void e(@c.m0 View view, @c.o0 Matrix matrix) {
        if (matrix == null || matrix.isIdentity()) {
            view.setPivotX(view.getWidth() / 2);
            view.setPivotY(view.getHeight() / 2);
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setRotation(0.0f);
            return;
        }
        float[] fArr = this.f10683a;
        if (fArr == null) {
            fArr = new float[9];
            this.f10683a = fArr;
        }
        matrix.getValues(fArr);
        float f8 = fArr[3];
        float fSqrt = ((float) Math.sqrt(1.0f - (f8 * f8))) * (fArr[0] < 0.0f ? -1 : 1);
        float degrees = (float) Math.toDegrees(Math.atan2(f8, fSqrt));
        float f9 = fArr[0] / fSqrt;
        float f10 = fArr[4] / fSqrt;
        float f11 = fArr[2];
        float f12 = fArr[5];
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.setTranslationX(f11);
        view.setTranslationY(f12);
        view.setRotation(degrees);
        view.setScaleX(f9);
        view.setScaleY(f10);
    }

    public void f(@c.m0 View view, int i7, int i8, int i9, int i10) {
        b();
        Method method = f10678c;
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e8) {
                throw new RuntimeException(e8.getCause());
            }
        }
    }

    public void g(@c.m0 View view, float f8) {
        Float f9 = (Float) view.getTag(R.id.save_non_transition_alpha);
        if (f9 != null) {
            view.setAlpha(f9.floatValue() * f8);
        } else {
            view.setAlpha(f8);
        }
    }

    public void h(@c.m0 View view, int i7) {
        if (!f10681f) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f10680e = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i(f10677b, "fetchViewFlagsField: ");
            }
            f10681f = true;
        }
        Field field = f10680e;
        if (field != null) {
            try {
                f10680e.setInt(view, i7 | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public void i(@c.m0 View view, @c.m0 Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            i(view2, matrix);
            matrix.preTranslate(-view2.getScrollX(), -view2.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        matrix.preConcat(matrix2);
    }

    public void j(@c.m0 View view, @c.m0 Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            j(view2, matrix);
            matrix.postTranslate(view2.getScrollX(), view2.getScrollY());
        }
        matrix.postTranslate(-view.getLeft(), -view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        Matrix matrix3 = new Matrix();
        if (matrix2.invert(matrix3)) {
            matrix.postConcat(matrix3);
        }
    }
}
