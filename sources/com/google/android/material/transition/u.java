package com.google.android.material.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.TypedValue;
import android.view.View;
import androidx.core.graphics.g2;
import androidx.transition.PathMotion;
import androidx.transition.PatternPathMotion;
import androidx.transition.Transition;
import androidx.transition.TransitionSet;
import c.b0;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f19185a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.f
    static final int f19186b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f19187c = "cubic-bezier";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f19188d = "path";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f19189e = "(";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f19190f = ")";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f19191g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f19192h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final RectF f19193i = new RectF();

    static class a implements com.google.android.material.shape.o.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RectF f19194a;

        a(RectF rectF) {
            this.f19194a = rectF;
        }

        @Override // com.google.android.material.shape.o.c
        @m0
        public com.google.android.material.shape.d a(@m0 com.google.android.material.shape.d dVar) {
            return dVar instanceof com.google.android.material.shape.m ? dVar : new com.google.android.material.shape.m(dVar.a(this.f19194a) / this.f19194a.height());
        }
    }

    static class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RectF f19195a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ RectF f19196b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f19197c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f19198d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f19199e;

        b(RectF rectF, RectF rectF2, float f8, float f9, float f10) {
            this.f19195a = rectF;
            this.f19196b = rectF2;
            this.f19197c = f8;
            this.f19198d = f9;
            this.f19199e = f10;
        }

        @Override // com.google.android.material.transition.u.d
        @m0
        public com.google.android.material.shape.d a(@m0 com.google.android.material.shape.d dVar, @m0 com.google.android.material.shape.d dVar2) {
            return new com.google.android.material.shape.a(u.o(dVar.a(this.f19195a), dVar2.a(this.f19196b), this.f19197c, this.f19198d, this.f19199e));
        }
    }

    interface c {
        void a(Canvas canvas);
    }

    interface d {
        @m0
        com.google.android.material.shape.d a(@m0 com.google.android.material.shape.d dVar, @m0 com.google.android.material.shape.d dVar2);
    }

    private u() {
    }

    static void A(Canvas canvas, Rect rect, float f8, float f9, float f10, int i7, c cVar) {
        if (i7 <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(f8, f9);
        canvas.scale(f10, f10);
        if (i7 < 255) {
            z(canvas, rect, i7);
        }
        cVar.a(canvas);
        canvas.restoreToCount(iSave);
    }

    static com.google.android.material.shape.o B(com.google.android.material.shape.o oVar, com.google.android.material.shape.o oVar2, RectF rectF, d dVar) {
        return (m(oVar, rectF) ? oVar : oVar2).v().L(dVar.a(oVar.r(), oVar2.r())).Q(dVar.a(oVar.t(), oVar2.t())).y(dVar.a(oVar.j(), oVar2.j())).D(dVar.a(oVar.l(), oVar2.l())).m();
    }

    static float a(@m0 RectF rectF) {
        return rectF.width() * rectF.height();
    }

    static com.google.android.material.shape.o b(com.google.android.material.shape.o oVar, RectF rectF) {
        return oVar.y(new a(rectF));
    }

    static Shader c(@c.l int i7) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, i7, i7, Shader.TileMode.CLAMP);
    }

    @m0
    static <T> T d(@o0 T t7, @m0 T t8) {
        return t7 != null ? t7 : t8;
    }

    static View e(View view, @b0 int i7) {
        String resourceName = view.getResources().getResourceName(i7);
        while (view != null) {
            if (view.getId() != i7) {
                Object parent = view.getParent();
                if (!(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            } else {
                return view;
            }
        }
        throw new IllegalArgumentException(resourceName + " is not a valid ancestor");
    }

    static View f(View view, @b0 int i7) {
        View viewFindViewById = view.findViewById(i7);
        return viewFindViewById != null ? viewFindViewById : e(view, i7);
    }

    private static float g(String[] strArr, int i7) {
        float f8 = Float.parseFloat(strArr[i7]);
        if (f8 >= 0.0f && f8 <= 1.0f) {
            return f8;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + f8);
    }

    private static String h(String str, String str2) {
        return str.substring(str2.length() + 1, str.length() - 1);
    }

    static RectF i(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i7 = iArr[0];
        int i8 = iArr[1];
        return new RectF(i7, i8, view.getWidth() + i7, view.getHeight() + i8);
    }

    static RectF j(View view) {
        return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    static Rect k(View view) {
        return new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    private static boolean l(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(f19189e);
        return str.startsWith(sb.toString()) && str.endsWith(f19190f);
    }

    private static boolean m(com.google.android.material.shape.o oVar, RectF rectF) {
        return (oVar.r().a(rectF) == 0.0f && oVar.t().a(rectF) == 0.0f && oVar.l().a(rectF) == 0.0f && oVar.j().a(rectF) == 0.0f) ? false : true;
    }

    static float n(float f8, float f9, float f10) {
        return f8 + (f10 * (f9 - f8));
    }

    static float o(float f8, float f9, @c.v(from = 0.0d, to = 1.0d) float f10, @c.v(from = 0.0d, to = 1.0d) float f11, @c.v(from = 0.0d, to = 1.0d) float f12) {
        return p(f8, f9, f10, f11, f12, false);
    }

    static float p(float f8, float f9, @c.v(from = 0.0d, to = 1.0d) float f10, @c.v(from = 0.0d, to = 1.0d) float f11, @c.v(from = 0.0d) float f12, boolean z7) {
        if (z7 && (f12 < 0.0f || f12 > 1.0f)) {
            return n(f8, f9, f12);
        }
        if (f12 < f10) {
            return f8;
        }
        return f12 > f11 ? f9 : n(f8, f9, (f12 - f10) / (f11 - f10));
    }

    static int q(int i7, int i8, @c.v(from = 0.0d, to = 1.0d) float f8, @c.v(from = 0.0d, to = 1.0d) float f9, @c.v(from = 0.0d, to = 1.0d) float f10) {
        if (f10 < f8) {
            return i7;
        }
        return f10 > f9 ? i8 : (int) n(i7, i8, (f10 - f8) / (f9 - f8));
    }

    static com.google.android.material.shape.o r(com.google.android.material.shape.o oVar, com.google.android.material.shape.o oVar2, RectF rectF, RectF rectF2, @c.v(from = 0.0d, to = 1.0d) float f8, @c.v(from = 0.0d, to = 1.0d) float f9, @c.v(from = 0.0d, to = 1.0d) float f10) {
        if (f10 < f8) {
            return oVar;
        }
        return f10 > f9 ? oVar2 : B(oVar, oVar2, rectF, new b(rectF, rectF2, f8, f9, f10));
    }

    static void s(TransitionSet transitionSet, @o0 Transition transition) {
        if (transition != null) {
            transitionSet.I0(transition);
        }
    }

    static boolean t(Transition transition, Context context, @c.f int i7) {
        int iE;
        if (i7 == 0 || transition.G() != -1 || (iE = com.google.android.material.resources.b.e(context, i7, -1)) == -1) {
            return false;
        }
        transition.t0(iE);
        return true;
    }

    static boolean u(Transition transition, Context context, @c.f int i7, TimeInterpolator timeInterpolator) {
        if (i7 == 0 || transition.J() != null) {
            return false;
        }
        transition.v0(x(context, i7, timeInterpolator));
        return true;
    }

    static boolean v(Transition transition, Context context, @c.f int i7) {
        PathMotion pathMotionY;
        if (i7 == 0 || (pathMotionY = y(context, i7)) == null) {
            return false;
        }
        transition.x0(pathMotionY);
        return true;
    }

    static void w(TransitionSet transitionSet, @o0 Transition transition) {
        if (transition != null) {
            transitionSet.S0(transition);
        }
    }

    static TimeInterpolator x(Context context, @c.f int i7, @m0 TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i7, typedValue, true)) {
            return timeInterpolator;
        }
        if (typedValue.type != 3) {
            throw new IllegalArgumentException("Motion easing theme attribute must be a string");
        }
        String strValueOf = String.valueOf(typedValue.string);
        if (!l(strValueOf, f19187c)) {
            if (l(strValueOf, f19188d)) {
                return androidx.core.view.animation.b.c(g2.e(h(strValueOf, f19188d)));
            }
            throw new IllegalArgumentException("Invalid motion easing type: " + strValueOf);
        }
        String[] strArrSplit = h(strValueOf, f19187c).split(",");
        if (strArrSplit.length == 4) {
            return androidx.core.view.animation.b.b(g(strArrSplit, 0), g(strArrSplit, 1), g(strArrSplit, 2), g(strArrSplit, 3));
        }
        throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + strArrSplit.length);
    }

    @o0
    static PathMotion y(Context context, @c.f int i7) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i7, typedValue, true)) {
            return null;
        }
        int i8 = typedValue.type;
        if (i8 != 16) {
            if (i8 == 3) {
                return new PatternPathMotion(g2.e(String.valueOf(typedValue.string)));
            }
            throw new IllegalArgumentException("Motion path theme attribute must either be an enum value or path data string");
        }
        int i9 = typedValue.data;
        if (i9 == 0) {
            return null;
        }
        if (i9 == 1) {
            return new k();
        }
        throw new IllegalArgumentException("Invalid motion path type: " + i9);
    }

    private static int z(Canvas canvas, Rect rect, int i7) {
        RectF rectF = f19193i;
        rectF.set(rect);
        return canvas.saveLayerAlpha(rectF, i7);
    }
}
