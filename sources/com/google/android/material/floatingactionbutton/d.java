package com.google.android.material.floatingactionbutton;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.util.w;
import androidx.core.view.n2;
import c.m0;
import c.o0;
import com.google.android.material.shape.o;
import com.google.android.material.shape.s;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class d {
    static final long G = 100;
    static final long H = 100;
    static final int I = 0;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    static final int f17667J = 1;
    static final int K = 2;
    static final float L = 1.5f;
    private static final float M = 0.0f;
    private static final float N = 0.0f;
    private static final float O = 0.0f;
    private static final float P = 1.0f;
    private static final float Q = 1.0f;
    private static final float R = 1.0f;

    @o0
    private ViewTreeObserver.OnPreDrawListener E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @o0
    o f17668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    com.google.android.material.shape.j f17669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    Drawable f17670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @o0
    com.google.android.material.floatingactionbutton.c f17671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @o0
    Drawable f17672e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f17673f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float f17675h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float f17676i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    float f17677j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f17678k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @m0
    private final com.google.android.material.internal.i f17679l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @o0
    private com.google.android.material.animation.h f17680m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @o0
    private com.google.android.material.animation.h f17681n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @o0
    private Animator f17682o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @o0
    private com.google.android.material.animation.h f17683p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @o0
    private com.google.android.material.animation.h f17684q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f17685r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f17687t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ArrayList<Animator.AnimatorListener> f17689v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private ArrayList<Animator.AnimatorListener> f17690w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private ArrayList<i> f17691x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    final FloatingActionButton f17692y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    final com.google.android.material.shadow.c f17693z;
    static final TimeInterpolator F = com.google.android.material.animation.a.f16848c;
    static final int[] S = {R.attr.state_pressed, R.attr.state_enabled};
    static final int[] T = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
    static final int[] U = {R.attr.state_focused, R.attr.state_enabled};
    static final int[] V = {R.attr.state_hovered, R.attr.state_enabled};
    static final int[] W = {R.attr.state_enabled};
    static final int[] X = new int[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f17674g = true;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f17686s = 1.0f;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f17688u = 0;
    private final Rect A = new Rect();
    private final RectF B = new RectF();
    private final RectF C = new RectF();
    private final Matrix D = new Matrix();

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f17694a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f17695b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ j f17696c;

        a(boolean z7, j jVar) {
            this.f17695b = z7;
            this.f17696c = jVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f17694a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.f17688u = 0;
            d.this.f17682o = null;
            if (this.f17694a) {
                return;
            }
            FloatingActionButton floatingActionButton = d.this.f17692y;
            boolean z7 = this.f17695b;
            floatingActionButton.c(z7 ? 8 : 4, z7);
            j jVar = this.f17696c;
            if (jVar != null) {
                jVar.b();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            d.this.f17692y.c(0, this.f17695b);
            d.this.f17688u = 1;
            d.this.f17682o = animator;
            this.f17694a = false;
        }
    }

    class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f17698a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ j f17699b;

        b(boolean z7, j jVar) {
            this.f17698a = z7;
            this.f17699b = jVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.f17688u = 0;
            d.this.f17682o = null;
            j jVar = this.f17699b;
            if (jVar != null) {
                jVar.a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            d.this.f17692y.c(0, this.f17698a);
            d.this.f17688u = 2;
            d.this.f17682o = animator;
        }
    }

    class c extends com.google.android.material.animation.g {
        c() {
        }

        @Override // com.google.android.material.animation.g, android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a */
        public Matrix evaluate(float f8, @m0 Matrix matrix, @m0 Matrix matrix2) {
            d.this.f17686s = f8;
            return super.evaluate(f8, matrix, matrix2);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.floatingactionbutton.d$d, reason: collision with other inner class name */
    class C0198d implements TypeEvaluator<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        FloatEvaluator f17702a = new FloatEvaluator();

        C0198d() {
        }

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float evaluate(float f8, Float f9, Float f10) {
            float fFloatValue = this.f17702a.evaluate(f8, (Number) f9, (Number) f10).floatValue();
            if (fFloatValue < 0.1f) {
                fFloatValue = 0.0f;
            }
            return Float.valueOf(fFloatValue);
        }
    }

    class e implements ViewTreeObserver.OnPreDrawListener {
        e() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            d.this.H();
            return true;
        }
    }

    private class f extends l {
        f() {
            super(d.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.l
        protected float a() {
            return 0.0f;
        }
    }

    private class g extends l {
        g() {
            super(d.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.l
        protected float a() {
            d dVar = d.this;
            return dVar.f17675h + dVar.f17676i;
        }
    }

    private class h extends l {
        h() {
            super(d.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.l
        protected float a() {
            d dVar = d.this;
            return dVar.f17675h + dVar.f17677j;
        }
    }

    interface i {
        void a();

        void b();
    }

    interface j {
        void a();

        void b();
    }

    private class k extends l {
        k() {
            super(d.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.l
        protected float a() {
            return d.this.f17675h;
        }
    }

    private abstract class l extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f17709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f17710b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f17711c;

        private l() {
        }

        protected abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.j0((int) this.f17711c);
            this.f17709a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@m0 ValueAnimator valueAnimator) {
            if (!this.f17709a) {
                com.google.android.material.shape.j jVar = d.this.f17669b;
                this.f17710b = jVar == null ? 0.0f : jVar.x();
                this.f17711c = a();
                this.f17709a = true;
            }
            d dVar = d.this;
            float f8 = this.f17710b;
            dVar.j0((int) (f8 + ((this.f17711c - f8) * valueAnimator.getAnimatedFraction())));
        }

        /* synthetic */ l(d dVar, a aVar) {
            this();
        }
    }

    d(FloatingActionButton floatingActionButton, com.google.android.material.shadow.c cVar) {
        this.f17692y = floatingActionButton;
        this.f17693z = cVar;
        com.google.android.material.internal.i iVar = new com.google.android.material.internal.i();
        this.f17679l = iVar;
        iVar.a(S, i(new h()));
        iVar.a(T, i(new g()));
        iVar.a(U, i(new g()));
        iVar.a(V, i(new g()));
        iVar.a(W, i(new k()));
        iVar.a(X, i(new f()));
        this.f17685r = floatingActionButton.getRotation();
    }

    private boolean d0() {
        return n2.U0(this.f17692y) && !this.f17692y.isInEditMode();
    }

    private void g(float f8, @m0 Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.f17692y.getDrawable();
        if (drawable == null || this.f17687t == 0) {
            return;
        }
        RectF rectF = this.B;
        RectF rectF2 = this.C;
        rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        int i7 = this.f17687t;
        rectF2.set(0.0f, 0.0f, i7, i7);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i8 = this.f17687t;
        matrix.postScale(f8, f8, i8 / 2.0f, i8 / 2.0f);
    }

    @m0
    private AnimatorSet h(@m0 com.google.android.material.animation.h hVar, float f8, float f9, float f10) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f17692y, (Property<FloatingActionButton, Float>) View.ALPHA, f8);
        hVar.h("opacity").a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f17692y, (Property<FloatingActionButton, Float>) View.SCALE_X, f9);
        hVar.h("scale").a(objectAnimatorOfFloat2);
        k0(objectAnimatorOfFloat2);
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f17692y, (Property<FloatingActionButton, Float>) View.SCALE_Y, f9);
        hVar.h("scale").a(objectAnimatorOfFloat3);
        k0(objectAnimatorOfFloat3);
        arrayList.add(objectAnimatorOfFloat3);
        g(f10, this.D);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(this.f17692y, new com.google.android.material.animation.f(), new c(), new Matrix(this.D));
        hVar.h("iconScale").a(objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        com.google.android.material.animation.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    @m0
    private ValueAnimator i(@m0 l lVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(F);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(lVar);
        valueAnimator.addUpdateListener(lVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    private void k0(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        objectAnimator.setEvaluator(new C0198d());
    }

    private com.google.android.material.animation.h l() {
        if (this.f17681n == null) {
            this.f17681n = com.google.android.material.animation.h.d(this.f17692y.getContext(), com.google.android.material.R.animator.design_fab_hide_motion_spec);
        }
        return (com.google.android.material.animation.h) w.l(this.f17681n);
    }

    private com.google.android.material.animation.h m() {
        if (this.f17680m == null) {
            this.f17680m = com.google.android.material.animation.h.d(this.f17692y.getContext(), com.google.android.material.R.animator.design_fab_show_motion_spec);
        }
        return (com.google.android.material.animation.h) w.l(this.f17680m);
    }

    @m0
    private ViewTreeObserver.OnPreDrawListener r() {
        if (this.E == null) {
            this.E = new e();
        }
        return this.E;
    }

    void A() {
        this.f17679l.c();
    }

    void B() {
        com.google.android.material.shape.j jVar = this.f17669b;
        if (jVar != null) {
            com.google.android.material.shape.k.f(this.f17692y, jVar);
        }
        if (N()) {
            this.f17692y.getViewTreeObserver().addOnPreDrawListener(r());
        }
    }

    void C() {
    }

    void D() {
        ViewTreeObserver viewTreeObserver = this.f17692y.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.E;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.E = null;
        }
    }

    void E(int[] iArr) {
        this.f17679l.d(iArr);
    }

    void F(float f8, float f9, float f10) {
        i0();
        j0(f8);
    }

    void G(@m0 Rect rect) {
        w.m(this.f17672e, "Didn't initialize content background");
        if (!c0()) {
            this.f17693z.a(this.f17672e);
        } else {
            this.f17693z.a(new InsetDrawable(this.f17672e, rect.left, rect.top, rect.right, rect.bottom));
        }
    }

    void H() {
        float rotation = this.f17692y.getRotation();
        if (this.f17685r != rotation) {
            this.f17685r = rotation;
            g0();
        }
    }

    void I() {
        ArrayList<i> arrayList = this.f17691x;
        if (arrayList != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    void J() {
        ArrayList<i> arrayList = this.f17691x;
        if (arrayList != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    public void K(@m0 Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.f17690w;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    void L(@m0 Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.f17689v;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    void M(@m0 i iVar) {
        ArrayList<i> arrayList = this.f17691x;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(iVar);
    }

    boolean N() {
        return true;
    }

    void O(@o0 ColorStateList colorStateList) {
        com.google.android.material.shape.j jVar = this.f17669b;
        if (jVar != null) {
            jVar.setTintList(colorStateList);
        }
        com.google.android.material.floatingactionbutton.c cVar = this.f17671d;
        if (cVar != null) {
            cVar.d(colorStateList);
        }
    }

    void P(@o0 PorterDuff.Mode mode) {
        com.google.android.material.shape.j jVar = this.f17669b;
        if (jVar != null) {
            jVar.setTintMode(mode);
        }
    }

    final void Q(float f8) {
        if (this.f17675h != f8) {
            this.f17675h = f8;
            F(f8, this.f17676i, this.f17677j);
        }
    }

    void R(boolean z7) {
        this.f17673f = z7;
    }

    final void S(@o0 com.google.android.material.animation.h hVar) {
        this.f17684q = hVar;
    }

    final void T(float f8) {
        if (this.f17676i != f8) {
            this.f17676i = f8;
            F(this.f17675h, f8, this.f17677j);
        }
    }

    final void U(float f8) {
        this.f17686s = f8;
        Matrix matrix = this.D;
        g(f8, matrix);
        this.f17692y.setImageMatrix(matrix);
    }

    final void V(int i7) {
        if (this.f17687t != i7) {
            this.f17687t = i7;
            h0();
        }
    }

    void W(int i7) {
        this.f17678k = i7;
    }

    final void X(float f8) {
        if (this.f17677j != f8) {
            this.f17677j = f8;
            F(this.f17675h, this.f17676i, f8);
        }
    }

    void Y(@o0 ColorStateList colorStateList) {
        Drawable drawable = this.f17670c;
        if (drawable != null) {
            androidx.core.graphics.drawable.d.o(drawable, com.google.android.material.ripple.b.d(colorStateList));
        }
    }

    void Z(boolean z7) {
        this.f17674g = z7;
        i0();
    }

    final void a0(@m0 o oVar) {
        this.f17668a = oVar;
        com.google.android.material.shape.j jVar = this.f17669b;
        if (jVar != null) {
            jVar.setShapeAppearanceModel(oVar);
        }
        Object obj = this.f17670c;
        if (obj instanceof s) {
            ((s) obj).setShapeAppearanceModel(oVar);
        }
        com.google.android.material.floatingactionbutton.c cVar = this.f17671d;
        if (cVar != null) {
            cVar.g(oVar);
        }
    }

    final void b0(@o0 com.google.android.material.animation.h hVar) {
        this.f17683p = hVar;
    }

    boolean c0() {
        return true;
    }

    public void d(@m0 Animator.AnimatorListener animatorListener) {
        if (this.f17690w == null) {
            this.f17690w = new ArrayList<>();
        }
        this.f17690w.add(animatorListener);
    }

    void e(@m0 Animator.AnimatorListener animatorListener) {
        if (this.f17689v == null) {
            this.f17689v = new ArrayList<>();
        }
        this.f17689v.add(animatorListener);
    }

    final boolean e0() {
        return !this.f17673f || this.f17692y.getSizeDimension() >= this.f17678k;
    }

    void f(@m0 i iVar) {
        if (this.f17691x == null) {
            this.f17691x = new ArrayList<>();
        }
        this.f17691x.add(iVar);
    }

    void f0(@o0 j jVar, boolean z7) {
        if (z()) {
            return;
        }
        Animator animator = this.f17682o;
        if (animator != null) {
            animator.cancel();
        }
        if (!d0()) {
            this.f17692y.c(0, z7);
            this.f17692y.setAlpha(1.0f);
            this.f17692y.setScaleY(1.0f);
            this.f17692y.setScaleX(1.0f);
            U(1.0f);
            if (jVar != null) {
                jVar.a();
                return;
            }
            return;
        }
        if (this.f17692y.getVisibility() != 0) {
            this.f17692y.setAlpha(0.0f);
            this.f17692y.setScaleY(0.0f);
            this.f17692y.setScaleX(0.0f);
            U(0.0f);
        }
        com.google.android.material.animation.h hVarM = this.f17683p;
        if (hVarM == null) {
            hVarM = m();
        }
        AnimatorSet animatorSetH = h(hVarM, 1.0f, 1.0f, 1.0f);
        animatorSetH.addListener(new b(z7, jVar));
        ArrayList<Animator.AnimatorListener> arrayList = this.f17689v;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetH.addListener(it.next());
            }
        }
        animatorSetH.start();
    }

    void g0() {
        com.google.android.material.shape.j jVar = this.f17669b;
        if (jVar != null) {
            jVar.v0((int) this.f17685r);
        }
    }

    final void h0() {
        U(this.f17686s);
    }

    final void i0() {
        Rect rect = this.A;
        s(rect);
        G(rect);
        this.f17693z.b(rect.left, rect.top, rect.right, rect.bottom);
    }

    com.google.android.material.shape.j j() {
        return new com.google.android.material.shape.j((o) w.l(this.f17668a));
    }

    void j0(float f8) {
        com.google.android.material.shape.j jVar = this.f17669b;
        if (jVar != null) {
            jVar.m0(f8);
        }
    }

    @o0
    final Drawable k() {
        return this.f17672e;
    }

    float n() {
        return this.f17675h;
    }

    boolean o() {
        return this.f17673f;
    }

    @o0
    final com.google.android.material.animation.h p() {
        return this.f17684q;
    }

    float q() {
        return this.f17676i;
    }

    void s(@m0 Rect rect) {
        int sizeDimension = this.f17673f ? (this.f17678k - this.f17692y.getSizeDimension()) / 2 : 0;
        float fN = this.f17674g ? n() + this.f17677j : 0.0f;
        int iMax = Math.max(sizeDimension, (int) Math.ceil(fN));
        int iMax2 = Math.max(sizeDimension, (int) Math.ceil(fN * L));
        rect.set(iMax, iMax2, iMax, iMax2);
    }

    float t() {
        return this.f17677j;
    }

    @o0
    final o u() {
        return this.f17668a;
    }

    @o0
    final com.google.android.material.animation.h v() {
        return this.f17683p;
    }

    void w(@o0 j jVar, boolean z7) {
        if (y()) {
            return;
        }
        Animator animator = this.f17682o;
        if (animator != null) {
            animator.cancel();
        }
        if (!d0()) {
            this.f17692y.c(z7 ? 8 : 4, z7);
            if (jVar != null) {
                jVar.b();
                return;
            }
            return;
        }
        com.google.android.material.animation.h hVarL = this.f17684q;
        if (hVarL == null) {
            hVarL = l();
        }
        AnimatorSet animatorSetH = h(hVarL, 0.0f, 0.0f, 0.0f);
        animatorSetH.addListener(new a(z7, jVar));
        ArrayList<Animator.AnimatorListener> arrayList = this.f17690w;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetH.addListener(it.next());
            }
        }
        animatorSetH.start();
    }

    void x(ColorStateList colorStateList, @o0 PorterDuff.Mode mode, ColorStateList colorStateList2, int i7) {
        com.google.android.material.shape.j jVarJ = j();
        this.f17669b = jVarJ;
        jVarJ.setTintList(colorStateList);
        if (mode != null) {
            this.f17669b.setTintMode(mode);
        }
        this.f17669b.u0(-12303292);
        this.f17669b.Y(this.f17692y.getContext());
        com.google.android.material.ripple.a aVar = new com.google.android.material.ripple.a(this.f17669b.getShapeAppearanceModel());
        aVar.setTintList(com.google.android.material.ripple.b.d(colorStateList2));
        this.f17670c = aVar;
        this.f17672e = new LayerDrawable(new Drawable[]{(Drawable) w.l(this.f17669b), aVar});
    }

    boolean y() {
        if (this.f17692y.getVisibility() == 0) {
            return this.f17688u == 1;
        }
        return this.f17688u != 2;
    }

    boolean z() {
        if (this.f17692y.getVisibility() != 0) {
            return this.f17688u == 2;
        }
        return this.f17688u != 1;
    }
}
