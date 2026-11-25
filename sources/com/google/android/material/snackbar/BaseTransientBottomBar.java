package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.accessibility.l0;
import androidx.core.view.n2;
import androidx.core.view.w5;
import androidx.core.view.z1;
import c.b0;
import c.e0;
import c.h0;
import c.m0;
import c.o0;
import c.t0;
import c.x0;
import com.google.android.material.R;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    static final int A = 180;
    private static final int B = 150;
    private static final int C = 75;
    private static final float D = 0.8f;
    static final int F = 0;
    static final int G = 1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f18417u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f18418v = 1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f18419w = -2;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f18420x = -1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f18421y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    static final int f18422z = 250;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final ViewGroup f18423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f18424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m0
    protected final SnackbarBaseLayout f18425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m0
    private final com.google.android.material.snackbar.a f18426d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f18427e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f18428f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @o0
    private View f18429g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f18430h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ViewTreeObserver.OnGlobalLayoutListener f18431i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @t0(29)
    private final Runnable f18432j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @o0
    private Rect f18433k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f18434l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f18435m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f18436n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f18437o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f18438p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private List<t<B>> f18439q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Behavior f18440r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @o0
    private final AccessibilityManager f18441s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @m0
    com.google.android.material.snackbar.c.b f18442t;
    private static final boolean H = false;
    private static final int[] I = {R.attr.snackbarStyle};

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static final String f18416J = BaseTransientBottomBar.class.getSimpleName();

    @m0
    static final Handler E = new Handler(Looper.getMainLooper(), new j());

    public static class Behavior extends SwipeDismissBehavior<View> {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        @m0
        private final u f18443t = new u(this);

        /* JADX INFO: Access modifiers changed from: private */
        public void V(@m0 BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f18443t.c(baseTransientBottomBar);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean G(View view) {
            return this.f18443t.a(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean l(@m0 CoordinatorLayout coordinatorLayout, @m0 View view, @m0 MotionEvent motionEvent) {
            this.f18443t.b(coordinatorLayout, view, motionEvent);
            return super.l(coordinatorLayout, view, motionEvent);
        }
    }

    @x0({x0.a.LIBRARY_GROUP})
    protected static class SnackbarBaseLayout extends FrameLayout {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final View.OnTouchListener f18444h = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private y f18445a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private x f18446b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f18447c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f18448d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final float f18449e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private ColorStateList f18450f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private PorterDuff.Mode f18451g;

        static class a implements View.OnTouchListener {
            a() {
            }

            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        protected SnackbarBaseLayout(@m0 Context context) {
            this(context, null);
        }

        @m0
        private Drawable a() {
            float dimension = getResources().getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(dimension);
            gradientDrawable.setColor(k1.a.j(this, R.attr.colorSurface, R.attr.colorOnSurface, getBackgroundOverlayColorAlpha()));
            if (this.f18450f == null) {
                return androidx.core.graphics.drawable.d.r(gradientDrawable);
            }
            Drawable drawableR = androidx.core.graphics.drawable.d.r(gradientDrawable);
            androidx.core.graphics.drawable.d.o(drawableR, this.f18450f);
            return drawableR;
        }

        float getActionTextColorAlpha() {
            return this.f18449e;
        }

        int getAnimationMode() {
            return this.f18447c;
        }

        float getBackgroundOverlayColorAlpha() {
            return this.f18448d;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            x xVar = this.f18446b;
            if (xVar != null) {
                xVar.onViewAttachedToWindow(this);
            }
            n2.v1(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            x xVar = this.f18446b;
            if (xVar != null) {
                xVar.onViewDetachedFromWindow(this);
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
            super.onLayout(z7, i7, i8, i9, i10);
            y yVar = this.f18445a;
            if (yVar != null) {
                yVar.a(this, i7, i8, i9, i10);
            }
        }

        void setAnimationMode(int i7) {
            this.f18447c = i7;
        }

        @Override // android.view.View
        public void setBackground(@o0 Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(@o0 Drawable drawable) {
            if (drawable != null && this.f18450f != null) {
                drawable = androidx.core.graphics.drawable.d.r(drawable.mutate());
                androidx.core.graphics.drawable.d.o(drawable, this.f18450f);
                androidx.core.graphics.drawable.d.p(drawable, this.f18451g);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(@o0 ColorStateList colorStateList) {
            this.f18450f = colorStateList;
            if (getBackground() != null) {
                Drawable drawableR = androidx.core.graphics.drawable.d.r(getBackground().mutate());
                androidx.core.graphics.drawable.d.o(drawableR, colorStateList);
                androidx.core.graphics.drawable.d.p(drawableR, this.f18451g);
                if (drawableR != getBackground()) {
                    super.setBackgroundDrawable(drawableR);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(@o0 PorterDuff.Mode mode) {
            this.f18451g = mode;
            if (getBackground() != null) {
                Drawable drawableR = androidx.core.graphics.drawable.d.r(getBackground().mutate());
                androidx.core.graphics.drawable.d.p(drawableR, mode);
                if (drawableR != getBackground()) {
                    super.setBackgroundDrawable(drawableR);
                }
            }
        }

        void setOnAttachStateChangeListener(x xVar) {
            this.f18446b = xVar;
        }

        @Override // android.view.View
        public void setOnClickListener(@o0 View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : f18444h);
            super.setOnClickListener(onClickListener);
        }

        void setOnLayoutChangeListener(y yVar) {
            this.f18445a = yVar;
        }

        protected SnackbarBaseLayout(@m0 Context context, AttributeSet attributeSet) {
            super(q1.a.c(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.SnackbarLayout_elevation)) {
                n2.N1(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_elevation, 0));
            }
            this.f18447c = typedArrayObtainStyledAttributes.getInt(R.styleable.SnackbarLayout_animationMode, 0);
            this.f18448d = typedArrayObtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(com.google.android.material.resources.c.a(context2, typedArrayObtainStyledAttributes, R.styleable.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(com.google.android.material.internal.v.k(typedArrayObtainStyledAttributes.getInt(R.styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.f18449e = typedArrayObtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
            typedArrayObtainStyledAttributes.recycle();
            setOnTouchListener(f18444h);
            setFocusable(true);
            if (getBackground() == null) {
                n2.I1(this, a());
            }
        }
    }

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SnackbarBaseLayout snackbarBaseLayout = BaseTransientBottomBar.this.f18425c;
            if (snackbarBaseLayout == null) {
                return;
            }
            if (snackbarBaseLayout.getParent() != null) {
                BaseTransientBottomBar.this.f18425c.setVisibility(0);
            }
            if (BaseTransientBottomBar.this.f18425c.getAnimationMode() == 1) {
                BaseTransientBottomBar.this.i0();
            } else {
                BaseTransientBottomBar.this.k0();
            }
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.T();
        }
    }

    class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f18454a;

        c(int i7) {
            this.f18454a = i7;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.S(this.f18454a);
        }
    }

    class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@m0 ValueAnimator valueAnimator) {
            BaseTransientBottomBar.this.f18425c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    class e implements ValueAnimator.AnimatorUpdateListener {
        e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@m0 ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BaseTransientBottomBar.this.f18425c.setScaleX(fFloatValue);
            BaseTransientBottomBar.this.f18425c.setScaleY(fFloatValue);
        }
    }

    class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.T();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f18426d.a(70, 180);
        }
    }

    class g implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f18459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f18460b;

        g(int i7) {
            this.f18460b = i7;
            this.f18459a = i7;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@m0 ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.H) {
                n2.f1(BaseTransientBottomBar.this.f18425c, iIntValue - this.f18459a);
            } else {
                BaseTransientBottomBar.this.f18425c.setTranslationY(iIntValue);
            }
            this.f18459a = iIntValue;
        }
    }

    class h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f18462a;

        h(int i7) {
            this.f18462a = i7;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.S(this.f18462a);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f18426d.b(0, 180);
        }
    }

    class i implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f18464a = 0;

        i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@m0 ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.H) {
                n2.f1(BaseTransientBottomBar.this.f18425c, iIntValue - this.f18464a);
            } else {
                BaseTransientBottomBar.this.f18425c.setTranslationY(iIntValue);
            }
            this.f18464a = iIntValue;
        }
    }

    static class j implements Handler.Callback {
        j() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@m0 Message message) {
            int i7 = message.what;
            if (i7 == 0) {
                ((BaseTransientBottomBar) message.obj).g0();
                return true;
            }
            if (i7 != 1) {
                return false;
            }
            ((BaseTransientBottomBar) message.obj).M(message.arg1);
            return true;
        }
    }

    class k implements ViewTreeObserver.OnGlobalLayoutListener {
        k() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (BaseTransientBottomBar.this.f18430h) {
                BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
                baseTransientBottomBar.f18438p = baseTransientBottomBar.v();
                BaseTransientBottomBar.this.m0();
            }
        }
    }

    class l implements Runnable {
        l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int iG;
            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
            if (baseTransientBottomBar.f18425c == null || baseTransientBottomBar.f18424b == null || (iG = (BaseTransientBottomBar.this.G() - BaseTransientBottomBar.this.K()) + ((int) BaseTransientBottomBar.this.f18425c.getTranslationY())) >= BaseTransientBottomBar.this.f18437o) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = BaseTransientBottomBar.this.f18425c.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                Log.w(BaseTransientBottomBar.f18416J, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                return;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += BaseTransientBottomBar.this.f18437o - iG;
            BaseTransientBottomBar.this.f18425c.requestLayout();
        }
    }

    class m implements z1 {
        m() {
        }

        @Override // androidx.core.view.z1
        @m0
        public w5 a(View view, @m0 w5 w5Var) {
            BaseTransientBottomBar.this.f18434l = w5Var.o();
            BaseTransientBottomBar.this.f18435m = w5Var.p();
            BaseTransientBottomBar.this.f18436n = w5Var.q();
            BaseTransientBottomBar.this.m0();
            return w5Var;
        }
    }

    class n extends androidx.core.view.a {
        n() {
        }

        @Override // androidx.core.view.a
        public void g(View view, @m0 l0 l0Var) {
            super.g(view, l0Var);
            l0Var.a(1048576);
            l0Var.d1(true);
        }

        @Override // androidx.core.view.a
        public boolean j(View view, int i7, Bundle bundle) {
            if (i7 != 1048576) {
                return super.j(view, i7, bundle);
            }
            BaseTransientBottomBar.this.w();
            return true;
        }
    }

    class o implements com.google.android.material.snackbar.c.b {
        o() {
        }

        @Override // com.google.android.material.snackbar.c.b
        public void a(int i7) {
            Handler handler = BaseTransientBottomBar.E;
            handler.sendMessage(handler.obtainMessage(1, i7, 0, BaseTransientBottomBar.this));
        }

        @Override // com.google.android.material.snackbar.c.b
        public void b() {
            Handler handler = BaseTransientBottomBar.E;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }
    }

    class p implements x {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BaseTransientBottomBar.this.S(3);
            }
        }

        p() {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.x
        public void onViewAttachedToWindow(View view) {
            WindowInsets rootWindowInsets;
            if (Build.VERSION.SDK_INT < 29 || (rootWindowInsets = BaseTransientBottomBar.this.f18425c.getRootWindowInsets()) == null) {
                return;
            }
            BaseTransientBottomBar.this.f18437o = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
            BaseTransientBottomBar.this.m0();
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.x
        public void onViewDetachedFromWindow(View view) {
            if (BaseTransientBottomBar.this.Q()) {
                BaseTransientBottomBar.E.post(new a());
            }
        }
    }

    class q implements y {
        q() {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.y
        public void a(View view, int i7, int i8, int i9, int i10) {
            BaseTransientBottomBar.this.f18425c.setOnLayoutChangeListener(null);
            BaseTransientBottomBar.this.h0();
        }
    }

    class r implements SwipeDismissBehavior.c {
        r() {
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void a(@m0 View view) {
            if (view.getParent() != null) {
                view.setVisibility(8);
            }
            BaseTransientBottomBar.this.x(0);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void b(int i7) {
            if (i7 == 0) {
                com.google.android.material.snackbar.c.c().l(BaseTransientBottomBar.this.f18442t);
            } else if (i7 == 1 || i7 == 2) {
                com.google.android.material.snackbar.c.c().k(BaseTransientBottomBar.this.f18442t);
            }
        }
    }

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface s {
    }

    public static abstract class t<B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f18475a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f18476b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f18477c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f18478d = 3;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f18479e = 4;

        @x0({x0.a.LIBRARY_GROUP})
        @Retention(RetentionPolicy.SOURCE)
        public @interface a {
        }

        public void a(B b8, int i7) {
        }

        public void b(B b8) {
        }
    }

    @x0({x0.a.LIBRARY_GROUP})
    public static class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.google.android.material.snackbar.c.b f18480a;

        public u(@m0 SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.R(0.1f);
            swipeDismissBehavior.O(0.6f);
            swipeDismissBehavior.S(0);
        }

        public boolean a(View view) {
            return view instanceof SnackbarBaseLayout;
        }

        public void b(@m0 CoordinatorLayout coordinatorLayout, @m0 View view, @m0 MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (coordinatorLayout.G(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    com.google.android.material.snackbar.c.c().k(this.f18480a);
                }
            } else if (actionMasked == 1 || actionMasked == 3) {
                com.google.android.material.snackbar.c.c().l(this.f18480a);
            }
        }

        public void c(@m0 BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f18480a = baseTransientBottomBar.f18442t;
        }
    }

    @Deprecated
    public interface v extends com.google.android.material.snackbar.a {
    }

    @x0({x0.a.LIBRARY_GROUP})
    @e0(from = 1)
    @Retention(RetentionPolicy.SOURCE)
    public @interface w {
    }

    @x0({x0.a.LIBRARY_GROUP})
    protected interface x {
        void onViewAttachedToWindow(View view);

        void onViewDetachedFromWindow(View view);
    }

    @x0({x0.a.LIBRARY_GROUP})
    protected interface y {
        void a(View view, int i7, int i8, int i9, int i10);
    }

    protected BaseTransientBottomBar(@m0 ViewGroup viewGroup, @m0 View view, @m0 com.google.android.material.snackbar.a aVar) {
        this(viewGroup.getContext(), viewGroup, view, aVar);
    }

    private ValueAnimator F(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(com.google.android.material.animation.a.f16849d);
        valueAnimatorOfFloat.addUpdateListener(new e());
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @t0(17)
    public int G() {
        WindowManager windowManager = (WindowManager) this.f18424b.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private int I() {
        int height = this.f18425c.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f18425c.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int K() {
        int[] iArr = new int[2];
        this.f18425c.getLocationOnScreen(iArr);
        return iArr[1] + this.f18425c.getHeight();
    }

    private boolean R() {
        ViewGroup.LayoutParams layoutParams = this.f18425c.getLayoutParams();
        return (layoutParams instanceof CoordinatorLayout.f) && (((CoordinatorLayout.f) layoutParams).f() instanceof SwipeDismissBehavior);
    }

    private void c0(CoordinatorLayout.f fVar) {
        SwipeDismissBehavior<? extends View> swipeDismissBehaviorE = this.f18440r;
        if (swipeDismissBehaviorE == null) {
            swipeDismissBehaviorE = E();
        }
        if (swipeDismissBehaviorE instanceof Behavior) {
            ((Behavior) swipeDismissBehaviorE).V(this);
        }
        swipeDismissBehaviorE.P(new r());
        fVar.q(swipeDismissBehaviorE);
        if (this.f18429g == null) {
            fVar.f5013g = 80;
        }
    }

    private boolean e0() {
        return this.f18437o > 0 && !this.f18428f && R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0() {
        if (d0()) {
            t();
            return;
        }
        if (this.f18425c.getParent() != null) {
            this.f18425c.setVisibility(0);
        }
        T();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0() {
        ValueAnimator valueAnimatorY = y(0.0f, 1.0f);
        ValueAnimator valueAnimatorF = F(D, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorY, valueAnimatorF);
        animatorSet.setDuration(150L);
        animatorSet.addListener(new b());
        animatorSet.start();
    }

    private void j0(int i7) {
        ValueAnimator valueAnimatorY = y(1.0f, 0.0f);
        valueAnimatorY.setDuration(75L);
        valueAnimatorY.addListener(new c(i7));
        valueAnimatorY.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0() {
        int I2 = I();
        if (H) {
            n2.f1(this.f18425c, I2);
        } else {
            this.f18425c.setTranslationY(I2);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(I2, 0);
        valueAnimator.setInterpolator(com.google.android.material.animation.a.f16847b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new f());
        valueAnimator.addUpdateListener(new g(I2));
        valueAnimator.start();
    }

    private void l0(int i7) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, I());
        valueAnimator.setInterpolator(com.google.android.material.animation.a.f16847b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new h(i7));
        valueAnimator.addUpdateListener(new i());
        valueAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0() {
        Rect rect;
        ViewGroup.LayoutParams layoutParams = this.f18425c.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams) || (rect = this.f18433k) == null) {
            Log.w(f18416J, "Unable to update margins because layout params are not MarginLayoutParams");
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = rect.bottom + (this.f18429g != null ? this.f18438p : this.f18434l);
        marginLayoutParams.leftMargin = rect.left + this.f18435m;
        marginLayoutParams.rightMargin = rect.right + this.f18436n;
        this.f18425c.requestLayout();
        if (Build.VERSION.SDK_INT < 29 || !e0()) {
            return;
        }
        this.f18425c.removeCallbacks(this.f18432j);
        this.f18425c.post(this.f18432j);
    }

    private void u(int i7) {
        if (this.f18425c.getAnimationMode() == 1) {
            j0(i7);
        } else {
            l0(i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int v() {
        View view = this.f18429g;
        if (view == null) {
            return 0;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i7 = iArr[1];
        int[] iArr2 = new int[2];
        this.f18423a.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.f18423a.getHeight()) - i7;
    }

    private ValueAnimator y(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(com.google.android.material.animation.a.f16846a);
        valueAnimatorOfFloat.addUpdateListener(new d());
        return valueAnimatorOfFloat;
    }

    public int A() {
        return this.f18425c.getAnimationMode();
    }

    public Behavior B() {
        return this.f18440r;
    }

    @m0
    public Context C() {
        return this.f18424b;
    }

    public int D() {
        return this.f18427e;
    }

    @m0
    protected SwipeDismissBehavior<? extends View> E() {
        return new Behavior();
    }

    @h0
    protected int H() {
        return L() ? R.layout.mtrl_layout_snackbar : R.layout.design_layout_snackbar;
    }

    @m0
    public View J() {
        return this.f18425c;
    }

    protected boolean L() {
        TypedArray typedArrayObtainStyledAttributes = this.f18424b.obtainStyledAttributes(I);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    final void M(int i7) {
        if (d0() && this.f18425c.getVisibility() == 0) {
            u(i7);
        } else {
            S(i7);
        }
    }

    public boolean N() {
        return this.f18430h;
    }

    public boolean O() {
        return this.f18428f;
    }

    public boolean P() {
        return com.google.android.material.snackbar.c.c().e(this.f18442t);
    }

    public boolean Q() {
        return com.google.android.material.snackbar.c.c().f(this.f18442t);
    }

    void S(int i7) {
        com.google.android.material.snackbar.c.c().i(this.f18442t);
        List<t<B>> list = this.f18439q;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f18439q.get(size).a(this, i7);
            }
        }
        ViewParent parent = this.f18425c.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f18425c);
        }
    }

    void T() {
        com.google.android.material.snackbar.c.c().j(this.f18442t);
        List<t<B>> list = this.f18439q;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f18439q.get(size).b(this);
            }
        }
    }

    @m0
    public B U(@o0 t<B> tVar) {
        List<t<B>> list;
        if (tVar == null || (list = this.f18439q) == null) {
            return this;
        }
        list.remove(tVar);
        return this;
    }

    @m0
    public B V(@b0 int i7) {
        View viewFindViewById = this.f18423a.findViewById(i7);
        if (viewFindViewById != null) {
            return (B) W(viewFindViewById);
        }
        throw new IllegalArgumentException("Unable to find anchor view with id: " + i7);
    }

    @m0
    public B W(@o0 View view) {
        com.google.android.material.internal.v.l(this.f18429g, this.f18431i);
        this.f18429g = view;
        com.google.android.material.internal.v.a(view, this.f18431i);
        return this;
    }

    public void X(boolean z7) {
        this.f18430h = z7;
    }

    @m0
    public B Y(int i7) {
        this.f18425c.setAnimationMode(i7);
        return this;
    }

    @m0
    public B Z(Behavior behavior) {
        this.f18440r = behavior;
        return this;
    }

    @m0
    public B a0(int i7) {
        this.f18427e = i7;
        return this;
    }

    @m0
    public B b0(boolean z7) {
        this.f18428f = z7;
        return this;
    }

    boolean d0() {
        AccessibilityManager accessibilityManager = this.f18441s;
        if (accessibilityManager == null) {
            return true;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    public void f0() {
        com.google.android.material.snackbar.c.c().n(D(), this.f18442t);
    }

    final void g0() {
        this.f18425c.setOnAttachStateChangeListener(new p());
        if (this.f18425c.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f18425c.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                c0((CoordinatorLayout.f) layoutParams);
            }
            this.f18438p = v();
            m0();
            this.f18425c.setVisibility(4);
            this.f18423a.addView(this.f18425c);
        }
        if (n2.U0(this.f18425c)) {
            h0();
        } else {
            this.f18425c.setOnLayoutChangeListener(new q());
        }
    }

    @m0
    public B s(@o0 t<B> tVar) {
        if (tVar == null) {
            return this;
        }
        if (this.f18439q == null) {
            this.f18439q = new ArrayList();
        }
        this.f18439q.add(tVar);
        return this;
    }

    void t() {
        this.f18425c.post(new a());
    }

    public void w() {
        x(3);
    }

    protected void x(int i7) {
        com.google.android.material.snackbar.c.c().b(this.f18442t, i7);
    }

    @o0
    public View z() {
        return this.f18429g;
    }

    protected BaseTransientBottomBar(@m0 Context context, @m0 ViewGroup viewGroup, @m0 View view, @m0 com.google.android.material.snackbar.a aVar) {
        this.f18430h = false;
        this.f18431i = new k();
        this.f18432j = new l();
        this.f18442t = new o();
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        }
        if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
        this.f18423a = viewGroup;
        this.f18426d = aVar;
        this.f18424b = context;
        com.google.android.material.internal.n.a(context);
        SnackbarBaseLayout snackbarBaseLayout = (SnackbarBaseLayout) LayoutInflater.from(context).inflate(H(), viewGroup, false);
        this.f18425c = snackbarBaseLayout;
        if (view instanceof SnackbarContentLayout) {
            ((SnackbarContentLayout) view).c(snackbarBaseLayout.getActionTextColorAlpha());
        }
        snackbarBaseLayout.addView(view);
        ViewGroup.LayoutParams layoutParams = snackbarBaseLayout.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            this.f18433k = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
        n2.D1(snackbarBaseLayout, 1);
        n2.R1(snackbarBaseLayout, 1);
        n2.O1(snackbarBaseLayout, true);
        n2.a2(snackbarBaseLayout, new m());
        n2.B1(snackbarBaseLayout, new n());
        this.f18441s = (AccessibilityManager) context.getSystemService("accessibility");
    }
}
