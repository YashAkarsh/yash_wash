package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.n2;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class ChangeTransform extends Transition {
    private static final String B0 = "android:changeTransform:parent";
    private static final String D0 = "android:changeTransform:intermediateParentMatrix";
    private static final String E0 = "android:changeTransform:intermediateMatrix";
    boolean W;
    private boolean X;
    private Matrix Y;
    private static final String Z = "android:changeTransform:matrix";
    private static final String A0 = "android:changeTransform:transforms";
    private static final String C0 = "android:changeTransform:parentMatrix";
    private static final String[] F0 = {Z, A0, C0};
    private static final Property<e, float[]> G0 = new a(float[].class, "nonTranslations");
    private static final Property<e, PointF> H0 = new b(PointF.class, "translations");
    private static final boolean I0 = true;

    static class a extends Property<e, float[]> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public float[] get(e eVar) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(e eVar, float[] fArr) {
            eVar.d(fArr);
        }
    }

    static class b extends Property<e, PointF> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(e eVar) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(e eVar, PointF pointF) {
            eVar.c(pointF);
        }
    }

    class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f10579a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Matrix f10580b = new Matrix();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f10581c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Matrix f10582d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f10583e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f f10584f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ e f10585g;

        c(boolean z7, Matrix matrix, View view, f fVar, e eVar) {
            this.f10581c = z7;
            this.f10582d = matrix;
            this.f10583e = view;
            this.f10584f = fVar;
            this.f10585g = eVar;
        }

        private void a(Matrix matrix) {
            this.f10580b.set(matrix);
            this.f10583e.setTag(R.id.transition_transform, this.f10580b);
            this.f10584f.a(this.f10583e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f10579a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.f10579a) {
                if (this.f10581c && ChangeTransform.this.W) {
                    a(this.f10582d);
                } else {
                    this.f10583e.setTag(R.id.transition_transform, null);
                    this.f10583e.setTag(R.id.parent_matrix, null);
                }
            }
            q0.f(this.f10583e, null);
            this.f10584f.a(this.f10583e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            a(this.f10585g.a());
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            ChangeTransform.J0(this.f10583e);
        }
    }

    private static class d extends y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private View f10587a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private h f10588b;

        d(View view, h hVar) {
            this.f10587a = view;
            this.f10588b = hVar;
        }

        @Override // androidx.transition.y, androidx.transition.Transition.h
        public void b(@c.m0 Transition transition) {
            this.f10588b.setVisibility(4);
        }

        @Override // androidx.transition.y, androidx.transition.Transition.h
        public void c(@c.m0 Transition transition) {
            transition.j0(this);
            l.b(this.f10587a);
            this.f10587a.setTag(R.id.transition_transform, null);
            this.f10587a.setTag(R.id.parent_matrix, null);
        }

        @Override // androidx.transition.y, androidx.transition.Transition.h
        public void e(@c.m0 Transition transition) {
            this.f10588b.setVisibility(0);
        }
    }

    private static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Matrix f10589a = new Matrix();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f10590b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float[] f10591c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f10592d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f10593e;

        e(View view, float[] fArr) {
            this.f10590b = view;
            float[] fArr2 = (float[]) fArr.clone();
            this.f10591c = fArr2;
            this.f10592d = fArr2[2];
            this.f10593e = fArr2[5];
            b();
        }

        private void b() {
            float[] fArr = this.f10591c;
            fArr[2] = this.f10592d;
            fArr[5] = this.f10593e;
            this.f10589a.setValues(fArr);
            q0.f(this.f10590b, this.f10589a);
        }

        Matrix a() {
            return this.f10589a;
        }

        void c(PointF pointF) {
            this.f10592d = pointF.x;
            this.f10593e = pointF.y;
            b();
        }

        void d(float[] fArr) {
            System.arraycopy(fArr, 0, this.f10591c, 0, fArr.length);
            b();
        }
    }

    private static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final float f10594a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final float f10595b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final float f10596c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final float f10597d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final float f10598e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final float f10599f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final float f10600g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final float f10601h;

        f(View view) {
            this.f10594a = view.getTranslationX();
            this.f10595b = view.getTranslationY();
            this.f10596c = n2.A0(view);
            this.f10597d = view.getScaleX();
            this.f10598e = view.getScaleY();
            this.f10599f = view.getRotationX();
            this.f10600g = view.getRotationY();
            this.f10601h = view.getRotation();
        }

        public void a(View view) {
            ChangeTransform.N0(view, this.f10594a, this.f10595b, this.f10596c, this.f10597d, this.f10598e, this.f10599f, this.f10600g, this.f10601h);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return fVar.f10594a == this.f10594a && fVar.f10595b == this.f10595b && fVar.f10596c == this.f10596c && fVar.f10597d == this.f10597d && fVar.f10598e == this.f10598e && fVar.f10599f == this.f10599f && fVar.f10600g == this.f10600g && fVar.f10601h == this.f10601h;
        }

        public int hashCode() {
            float f8 = this.f10594a;
            int iFloatToIntBits = (f8 != 0.0f ? Float.floatToIntBits(f8) : 0) * 31;
            float f9 = this.f10595b;
            int iFloatToIntBits2 = (iFloatToIntBits + (f9 != 0.0f ? Float.floatToIntBits(f9) : 0)) * 31;
            float f10 = this.f10596c;
            int iFloatToIntBits3 = (iFloatToIntBits2 + (f10 != 0.0f ? Float.floatToIntBits(f10) : 0)) * 31;
            float f11 = this.f10597d;
            int iFloatToIntBits4 = (iFloatToIntBits3 + (f11 != 0.0f ? Float.floatToIntBits(f11) : 0)) * 31;
            float f12 = this.f10598e;
            int iFloatToIntBits5 = (iFloatToIntBits4 + (f12 != 0.0f ? Float.floatToIntBits(f12) : 0)) * 31;
            float f13 = this.f10599f;
            int iFloatToIntBits6 = (iFloatToIntBits5 + (f13 != 0.0f ? Float.floatToIntBits(f13) : 0)) * 31;
            float f14 = this.f10600g;
            int iFloatToIntBits7 = (iFloatToIntBits6 + (f14 != 0.0f ? Float.floatToIntBits(f14) : 0)) * 31;
            float f15 = this.f10601h;
            return iFloatToIntBits7 + (f15 != 0.0f ? Float.floatToIntBits(f15) : 0);
        }
    }

    public ChangeTransform() {
        this.W = true;
        this.X = true;
        this.Y = new Matrix();
    }

    private void D0(d0 d0Var) {
        View view = d0Var.f10675b;
        if (view.getVisibility() == 8) {
            return;
        }
        d0Var.f10674a.put(B0, view.getParent());
        d0Var.f10674a.put(A0, new f(view));
        Matrix matrix = view.getMatrix();
        d0Var.f10674a.put(Z, (matrix == null || matrix.isIdentity()) ? null : new Matrix(matrix));
        if (this.X) {
            Matrix matrix2 = new Matrix();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            q0.j(viewGroup, matrix2);
            matrix2.preTranslate(-viewGroup.getScrollX(), -viewGroup.getScrollY());
            d0Var.f10674a.put(C0, matrix2);
            d0Var.f10674a.put(E0, view.getTag(R.id.transition_transform));
            d0Var.f10674a.put(D0, view.getTag(R.id.parent_matrix));
        }
    }

    private void E0(ViewGroup viewGroup, d0 d0Var, d0 d0Var2) {
        View view = d0Var2.f10675b;
        Matrix matrix = new Matrix((Matrix) d0Var2.f10674a.get(C0));
        q0.k(viewGroup, matrix);
        h hVarA = l.a(view, viewGroup, matrix);
        if (hVarA == null) {
            return;
        }
        hVarA.a((ViewGroup) d0Var.f10674a.get(B0), d0Var.f10675b);
        Transition transition = this;
        while (true) {
            TransitionSet transitionSet = transition.f10627r;
            if (transitionSet == null) {
                break;
            } else {
                transition = transitionSet;
            }
        }
        transition.a(new d(view, hVarA));
        if (I0) {
            View view2 = d0Var.f10675b;
            if (view2 != d0Var2.f10675b) {
                q0.h(view2, 0.0f);
            }
            q0.h(view, 1.0f);
        }
    }

    private ObjectAnimator F0(d0 d0Var, d0 d0Var2, boolean z7) {
        Matrix matrix = (Matrix) d0Var.f10674a.get(Z);
        Matrix matrix2 = (Matrix) d0Var2.f10674a.get(Z);
        if (matrix == null) {
            matrix = o.f10760a;
        }
        if (matrix2 == null) {
            matrix2 = o.f10760a;
        }
        Matrix matrix3 = matrix2;
        if (matrix.equals(matrix3)) {
            return null;
        }
        f fVar = (f) d0Var2.f10674a.get(A0);
        View view = d0Var2.f10675b;
        J0(view);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float[] fArr2 = new float[9];
        matrix3.getValues(fArr2);
        e eVar = new e(view, fArr);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(eVar, PropertyValuesHolder.ofObject(G0, new androidx.transition.f(new float[9]), fArr, fArr2), s.a(H0, N().a(fArr[2], fArr[5], fArr2[2], fArr2[5])));
        c cVar = new c(z7, matrix3, view, fVar, eVar);
        objectAnimatorOfPropertyValuesHolder.addListener(cVar);
        androidx.transition.a.a(objectAnimatorOfPropertyValuesHolder, cVar);
        return objectAnimatorOfPropertyValuesHolder;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x001d  */
    private boolean I0(ViewGroup viewGroup, ViewGroup viewGroup2) {
        boolean z7 = true;
        if (Z(viewGroup) && Z(viewGroup2)) {
            d0 d0VarL = L(viewGroup, true);
            if (d0VarL == null) {
                return false;
            }
            if (viewGroup2 != d0VarL.f10675b) {
                z7 = false;
            }
        } else if (viewGroup != viewGroup2) {
            z7 = false;
        }
        return z7;
    }

    static void J0(View view) {
        N0(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    private void K0(d0 d0Var, d0 d0Var2) {
        Matrix matrix = (Matrix) d0Var2.f10674a.get(C0);
        d0Var2.f10675b.setTag(R.id.parent_matrix, matrix);
        Matrix matrix2 = this.Y;
        matrix2.reset();
        matrix.invert(matrix2);
        Matrix matrix3 = (Matrix) d0Var.f10674a.get(Z);
        if (matrix3 == null) {
            matrix3 = new Matrix();
            d0Var.f10674a.put(Z, matrix3);
        }
        matrix3.postConcat((Matrix) d0Var.f10674a.get(C0));
        matrix3.postConcat(matrix2);
    }

    static void N0(View view, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15) {
        view.setTranslationX(f8);
        view.setTranslationY(f9);
        n2.w2(view, f10);
        view.setScaleX(f11);
        view.setScaleY(f12);
        view.setRotationX(f13);
        view.setRotationY(f14);
        view.setRotation(f15);
    }

    public boolean G0() {
        return this.X;
    }

    public boolean H0() {
        return this.W;
    }

    public void L0(boolean z7) {
        this.X = z7;
    }

    public void M0(boolean z7) {
        this.W = z7;
    }

    @Override // androidx.transition.Transition
    public String[] V() {
        return F0;
    }

    @Override // androidx.transition.Transition
    public void k(@c.m0 d0 d0Var) {
        D0(d0Var);
    }

    @Override // androidx.transition.Transition
    public void n(@c.m0 d0 d0Var) {
        D0(d0Var);
        if (I0) {
            return;
        }
        ((ViewGroup) d0Var.f10675b.getParent()).startViewTransition(d0Var.f10675b);
    }

    @Override // androidx.transition.Transition
    public Animator r(@c.m0 ViewGroup viewGroup, d0 d0Var, d0 d0Var2) {
        if (d0Var == null || d0Var2 == null || !d0Var.f10674a.containsKey(B0) || !d0Var2.f10674a.containsKey(B0)) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) d0Var.f10674a.get(B0);
        boolean z7 = this.X && !I0(viewGroup2, (ViewGroup) d0Var2.f10674a.get(B0));
        Matrix matrix = (Matrix) d0Var.f10674a.get(E0);
        if (matrix != null) {
            d0Var.f10674a.put(Z, matrix);
        }
        Matrix matrix2 = (Matrix) d0Var.f10674a.get(D0);
        if (matrix2 != null) {
            d0Var.f10674a.put(C0, matrix2);
        }
        if (z7) {
            K0(d0Var, d0Var2);
        }
        ObjectAnimator objectAnimatorF0 = F0(d0Var, d0Var2, z7);
        if (z7 && objectAnimatorF0 != null && this.W) {
            E0(viewGroup, d0Var, d0Var2);
        } else if (!I0) {
            viewGroup2.endViewTransition(d0Var.f10675b);
        }
        return objectAnimatorF0;
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.W = true;
        this.X = true;
        this.Y = new Matrix();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.f10788g);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        this.W = androidx.core.content.res.q.e(typedArrayObtainStyledAttributes, xmlPullParser, "reparentWithOverlay", 1, true);
        this.X = androidx.core.content.res.q.e(typedArrayObtainStyledAttributes, xmlPullParser, "reparent", 0, true);
        typedArrayObtainStyledAttributes.recycle();
    }
}
