package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.g;
import androidx.appcompat.widget.k;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.util.w;
import androidx.core.view.j2;
import androidx.core.view.n2;
import androidx.core.widget.j0;
import c.b0;
import c.g1;
import c.l;
import c.m0;
import c.o0;
import c.p;
import c.r0;
import c.t0;
import c.u;
import c.x0;
import com.google.android.material.R;
import com.google.android.material.animation.h;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.internal.n;
import com.google.android.material.internal.v;
import com.google.android.material.shape.o;
import com.google.android.material.shape.s;
import com.google.android.material.stateful.ExtendableSavedState;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FloatingActionButton extends VisibilityAwareImageButton implements j2, j0, o1.a, s, CoordinatorLayout.b {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f17608r = "FloatingActionButton";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f17609s = "expandableWidgetHelper";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final int f17610t = R.style.Widget_Design_FloatingActionButton;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f17611u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f17612v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f17613w = -1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f17614x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int f17615y = 470;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    private ColorStateList f17616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    private PorterDuff.Mode f17617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @o0
    private ColorStateList f17618d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @o0
    private PorterDuff.Mode f17619e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @o0
    private ColorStateList f17620f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f17621g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f17622h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f17623i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f17624j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f17625k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    boolean f17626l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final Rect f17627m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Rect f17628n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @m0
    private final k f17629o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @m0
    private final o1.c f17630p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private com.google.android.material.floatingactionbutton.d f17631q;

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* JADX INFO: renamed from: G */
        public /* bridge */ /* synthetic */ boolean b(@m0 CoordinatorLayout coordinatorLayout, @m0 FloatingActionButton floatingActionButton, @m0 Rect rect) {
            return super.b(coordinatorLayout, floatingActionButton, rect);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean H() {
            return super.H();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* JADX INFO: renamed from: K */
        public /* bridge */ /* synthetic */ boolean i(CoordinatorLayout coordinatorLayout, @m0 FloatingActionButton floatingActionButton, View view) {
            return super.i(coordinatorLayout, floatingActionButton, view);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* JADX INFO: renamed from: L */
        public /* bridge */ /* synthetic */ boolean m(@m0 CoordinatorLayout coordinatorLayout, @m0 FloatingActionButton floatingActionButton, int i7) {
            return super.m(coordinatorLayout, floatingActionButton, i7);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ void M(boolean z7) {
            super.M(z7);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        @g1
        public /* bridge */ /* synthetic */ void N(b bVar) {
            super.N(bVar);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void h(@m0 CoordinatorLayout.f fVar) {
            super.h(fVar);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    class a implements com.google.android.material.floatingactionbutton.d.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f17636a;

        a(b bVar) {
            this.f17636a = bVar;
        }

        @Override // com.google.android.material.floatingactionbutton.d.j
        public void a() {
            this.f17636a.b(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.d.j
        public void b() {
            this.f17636a.a(FloatingActionButton.this);
        }
    }

    public static abstract class b {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    private class c implements com.google.android.material.shadow.c {
        c() {
        }

        @Override // com.google.android.material.shadow.c
        public void a(@o0 Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }

        @Override // com.google.android.material.shadow.c
        public void b(int i7, int i8, int i9, int i10) {
            FloatingActionButton.this.f17627m.set(i7, i8, i9, i10);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i7 + floatingActionButton.f17624j, i8 + FloatingActionButton.this.f17624j, i9 + FloatingActionButton.this.f17624j, i10 + FloatingActionButton.this.f17624j);
        }

        @Override // com.google.android.material.shadow.c
        public boolean c() {
            return FloatingActionButton.this.f17626l;
        }

        @Override // com.google.android.material.shadow.c
        public float d() {
            return FloatingActionButton.this.getSizeDimension() / 2.0f;
        }
    }

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface d {
    }

    class e<T extends FloatingActionButton> implements com.google.android.material.floatingactionbutton.d.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m0
        private final com.google.android.material.animation.k<T> f17639a;

        e(com.google.android.material.animation.k<T> kVar) {
            this.f17639a = kVar;
        }

        @Override // com.google.android.material.floatingactionbutton.d.i
        public void a() {
            this.f17639a.b(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.d.i
        public void b() {
            this.f17639a.a(FloatingActionButton.this);
        }

        public boolean equals(@o0 Object obj) {
            return (obj instanceof e) && ((e) obj).f17639a.equals(this.f17639a);
        }

        public int hashCode() {
            return this.f17639a.hashCode();
        }
    }

    public FloatingActionButton(@m0 Context context) {
        this(context, null);
    }

    @o0
    private com.google.android.material.floatingactionbutton.d.j C(@o0 b bVar) {
        if (bVar == null) {
            return null;
        }
        return new a(bVar);
    }

    private com.google.android.material.floatingactionbutton.d getImpl() {
        if (this.f17631q == null) {
            this.f17631q = j();
        }
        return this.f17631q;
    }

    @m0
    private com.google.android.material.floatingactionbutton.d j() {
        return new com.google.android.material.floatingactionbutton.e(this, new c());
    }

    private int m(int i7) {
        int i8 = this.f17623i;
        if (i8 != 0) {
            return i8;
        }
        Resources resources = getResources();
        if (i7 != -1) {
            return i7 != 1 ? resources.getDimensionPixelSize(R.dimen.design_fab_size_normal) : resources.getDimensionPixelSize(R.dimen.design_fab_size_mini);
        }
        return Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < f17615y ? m(1) : m(0);
    }

    private void s(@m0 Rect rect) {
        int i7 = rect.left;
        Rect rect2 = this.f17627m;
        rect.left = i7 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    private void t() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f17618d;
        if (colorStateList == null) {
            androidx.core.graphics.drawable.d.c(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f17619e;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(g.e(colorForState, mode));
    }

    private static int x(int i7, int i8) {
        int mode = View.MeasureSpec.getMode(i8);
        int size = View.MeasureSpec.getSize(i8);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i7, size);
        }
        if (mode == 0) {
            return i7;
        }
        if (mode == 1073741824) {
            return size;
        }
        throw new IllegalArgumentException();
    }

    public void A(@o0 b bVar) {
        B(bVar, true);
    }

    void B(@o0 b bVar, boolean z7) {
        getImpl().f0(C(bVar), z7);
    }

    @Override // o1.b
    public boolean a(boolean z7) {
        return this.f17630p.f(z7);
    }

    @Override // o1.b
    public boolean b() {
        return this.f17630p.c();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().E(getDrawableState());
    }

    public void f(@m0 Animator.AnimatorListener animatorListener) {
        getImpl().d(animatorListener);
    }

    public void g(@m0 Animator.AnimatorListener animatorListener) {
        getImpl().e(animatorListener);
    }

    @Override // android.view.View
    @o0
    public ColorStateList getBackgroundTintList() {
        return this.f17616b;
    }

    @Override // android.view.View
    @o0
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f17617c;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    @m0
    public CoordinatorLayout.Behavior<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().n();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().q();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().t();
    }

    @o0
    public Drawable getContentBackground() {
        return getImpl().k();
    }

    @r0
    public int getCustomSize() {
        return this.f17623i;
    }

    @Override // o1.a
    public int getExpandedComponentIdHint() {
        return this.f17630p.b();
    }

    @o0
    public h getHideMotionSpec() {
        return getImpl().p();
    }

    @l
    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f17620f;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    @o0
    public ColorStateList getRippleColorStateList() {
        return this.f17620f;
    }

    @Override // com.google.android.material.shape.s
    @m0
    public o getShapeAppearanceModel() {
        return (o) w.l(getImpl().u());
    }

    @o0
    public h getShowMotionSpec() {
        return getImpl().v();
    }

    public int getSize() {
        return this.f17622h;
    }

    int getSizeDimension() {
        return m(this.f17622h);
    }

    @Override // androidx.core.view.j2
    @o0
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // androidx.core.view.j2
    @o0
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // androidx.core.widget.j0
    @o0
    public ColorStateList getSupportImageTintList() {
        return this.f17618d;
    }

    @Override // androidx.core.widget.j0
    @o0
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f17619e;
    }

    public boolean getUseCompatPadding() {
        return this.f17626l;
    }

    public void h(@m0 com.google.android.material.animation.k<? extends FloatingActionButton> kVar) {
        getImpl().f(new e(kVar));
    }

    public void i() {
        setCustomSize(0);
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().A();
    }

    @Deprecated
    public boolean k(@m0 Rect rect) {
        if (!n2.U0(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        s(rect);
        return true;
    }

    public void l(@m0 Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        s(rect);
    }

    public void n() {
        o(null);
    }

    public void o(@o0 b bVar) {
        p(bVar, true);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().B();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().D();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i7, int i8) {
        int sizeDimension = getSizeDimension();
        this.f17624j = (sizeDimension - this.f17625k) / 2;
        getImpl().i0();
        int iMin = Math.min(x(sizeDimension, i7), x(sizeDimension, i8));
        Rect rect = this.f17627m;
        setMeasuredDimension(rect.left + iMin + rect.right, iMin + rect.top + rect.bottom);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.a());
        this.f17630p.d((Bundle) w.l(extendableSavedState.f18504c.get(f17609s)));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            parcelableOnSaveInstanceState = new Bundle();
        }
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(parcelableOnSaveInstanceState);
        extendableSavedState.f18504c.put(f17609s, this.f17630p.e());
        return extendableSavedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@m0 MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && k(this.f17628n) && !this.f17628n.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    void p(@o0 b bVar, boolean z7) {
        getImpl().w(C(bVar), z7);
    }

    public boolean q() {
        return getImpl().y();
    }

    public boolean r() {
        return getImpl().z();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i7) {
        Log.i(f17608r, "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i(f17608r, "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i7) {
        Log.i(f17608r, "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(@o0 ColorStateList colorStateList) {
        if (this.f17616b != colorStateList) {
            this.f17616b = colorStateList;
            getImpl().O(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@o0 PorterDuff.Mode mode) {
        if (this.f17617c != mode) {
            this.f17617c = mode;
            getImpl().P(mode);
        }
    }

    public void setCompatElevation(float f8) {
        getImpl().Q(f8);
    }

    public void setCompatElevationResource(@p int i7) {
        setCompatElevation(getResources().getDimension(i7));
    }

    public void setCompatHoveredFocusedTranslationZ(float f8) {
        getImpl().T(f8);
    }

    public void setCompatHoveredFocusedTranslationZResource(@p int i7) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i7));
    }

    public void setCompatPressedTranslationZ(float f8) {
        getImpl().X(f8);
    }

    public void setCompatPressedTranslationZResource(@p int i7) {
        setCompatPressedTranslationZ(getResources().getDimension(i7));
    }

    public void setCustomSize(@r0 int i7) {
        if (i7 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        if (i7 != this.f17623i) {
            this.f17623i = i7;
            requestLayout();
        }
    }

    @Override // android.view.View
    @t0(21)
    public void setElevation(float f8) {
        super.setElevation(f8);
        getImpl().j0(f8);
    }

    public void setEnsureMinTouchTargetSize(boolean z7) {
        if (z7 != getImpl().o()) {
            getImpl().R(z7);
            requestLayout();
        }
    }

    @Override // o1.a
    public void setExpandedComponentIdHint(@b0 int i7) {
        this.f17630p.g(i7);
    }

    public void setHideMotionSpec(@o0 h hVar) {
        getImpl().S(hVar);
    }

    public void setHideMotionSpecResource(@c.b int i7) {
        setHideMotionSpec(h.d(getContext(), i7));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@o0 Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            getImpl().h0();
            if (this.f17618d != null) {
                t();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(@u int i7) {
        this.f17629o.i(i7);
        t();
    }

    public void setRippleColor(@l int i7) {
        setRippleColor(ColorStateList.valueOf(i7));
    }

    @Override // android.view.View
    public void setScaleX(float f8) {
        super.setScaleX(f8);
        getImpl().I();
    }

    @Override // android.view.View
    public void setScaleY(float f8) {
        super.setScaleY(f8);
        getImpl().I();
    }

    @x0({x0.a.LIBRARY_GROUP})
    @g1
    public void setShadowPaddingEnabled(boolean z7) {
        getImpl().Z(z7);
    }

    @Override // com.google.android.material.shape.s
    public void setShapeAppearanceModel(@m0 o oVar) {
        getImpl().a0(oVar);
    }

    public void setShowMotionSpec(@o0 h hVar) {
        getImpl().b0(hVar);
    }

    public void setShowMotionSpecResource(@c.b int i7) {
        setShowMotionSpec(h.d(getContext(), i7));
    }

    public void setSize(int i7) {
        this.f17623i = 0;
        if (i7 != this.f17622h) {
            this.f17622h = i7;
            requestLayout();
        }
    }

    @Override // androidx.core.view.j2
    public void setSupportBackgroundTintList(@o0 ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    @Override // androidx.core.view.j2
    public void setSupportBackgroundTintMode(@o0 PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    @Override // androidx.core.widget.j0
    public void setSupportImageTintList(@o0 ColorStateList colorStateList) {
        if (this.f17618d != colorStateList) {
            this.f17618d = colorStateList;
            t();
        }
    }

    @Override // androidx.core.widget.j0
    public void setSupportImageTintMode(@o0 PorterDuff.Mode mode) {
        if (this.f17619e != mode) {
            this.f17619e = mode;
            t();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f8) {
        super.setTranslationX(f8);
        getImpl().J();
    }

    @Override // android.view.View
    public void setTranslationY(float f8) {
        super.setTranslationY(f8);
        getImpl().J();
    }

    @Override // android.view.View
    public void setTranslationZ(float f8) {
        super.setTranslationZ(f8);
        getImpl().J();
    }

    public void setUseCompatPadding(boolean z7) {
        if (this.f17626l != z7) {
            this.f17626l = z7;
            getImpl().C();
        }
    }

    @Override // com.google.android.material.internal.VisibilityAwareImageButton, android.widget.ImageView, android.view.View
    public void setVisibility(int i7) {
        super.setVisibility(i7);
    }

    public void u(@m0 Animator.AnimatorListener animatorListener) {
        getImpl().K(animatorListener);
    }

    public void v(@m0 Animator.AnimatorListener animatorListener) {
        getImpl().L(animatorListener);
    }

    public void w(@m0 com.google.android.material.animation.k<? extends FloatingActionButton> kVar) {
        getImpl().M(new e(kVar));
    }

    public boolean y() {
        return getImpl().o();
    }

    public void z() {
        A(null);
    }

    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final boolean f17632d = true;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Rect f17633a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private b f17634b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f17635c;

        public BaseBehavior() {
            this.f17635c = true;
        }

        private static boolean I(@m0 View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private void J(@m0 CoordinatorLayout coordinatorLayout, @m0 FloatingActionButton floatingActionButton) {
            int i7;
            Rect rect = floatingActionButton.f17627m;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) floatingActionButton.getLayoutParams();
            int i8 = 0;
            if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) fVar).rightMargin) {
                i7 = rect.right;
            } else {
                i7 = floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) fVar).leftMargin ? -rect.left : 0;
            }
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) {
                i8 = rect.bottom;
            } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) fVar).topMargin) {
                i8 = -rect.top;
            }
            if (i8 != 0) {
                n2.f1(floatingActionButton, i8);
            }
            if (i7 != 0) {
                n2.e1(floatingActionButton, i7);
            }
        }

        private boolean O(@m0 View view, @m0 FloatingActionButton floatingActionButton) {
            return this.f17635c && ((CoordinatorLayout.f) floatingActionButton.getLayoutParams()).e() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        private boolean P(CoordinatorLayout coordinatorLayout, @m0 AppBarLayout appBarLayout, @m0 FloatingActionButton floatingActionButton) {
            if (!O(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f17633a == null) {
                this.f17633a = new Rect();
            }
            Rect rect = this.f17633a;
            com.google.android.material.internal.c.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.p(this.f17634b, false);
                return true;
            }
            floatingActionButton.B(this.f17634b, false);
            return true;
        }

        private boolean Q(@m0 View view, @m0 FloatingActionButton floatingActionButton) {
            if (!O(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.p(this.f17634b, false);
                return true;
            }
            floatingActionButton.B(this.f17634b, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
        public boolean b(@m0 CoordinatorLayout coordinatorLayout, @m0 FloatingActionButton floatingActionButton, @m0 Rect rect) {
            Rect rect2 = floatingActionButton.f17627m;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        public boolean H() {
            return this.f17635c;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
        public boolean i(CoordinatorLayout coordinatorLayout, @m0 FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                P(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            }
            if (!I(view)) {
                return false;
            }
            Q(view, floatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
        public boolean m(@m0 CoordinatorLayout coordinatorLayout, @m0 FloatingActionButton floatingActionButton, int i7) {
            List<View> listW = coordinatorLayout.w(floatingActionButton);
            int size = listW.size();
            for (int i8 = 0; i8 < size; i8++) {
                View view = listW.get(i8);
                if (!(view instanceof AppBarLayout)) {
                    if (I(view) && Q(view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (P(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.N(floatingActionButton, i7);
            J(coordinatorLayout, floatingActionButton);
            return true;
        }

        public void M(boolean z7) {
            this.f17635c = z7;
        }

        @g1
        public void N(b bVar) {
            this.f17634b = bVar;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void h(@m0 CoordinatorLayout.f fVar) {
            if (fVar.f5014h == 0) {
                fVar.f5014h = 80;
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionButton_Behavior_Layout);
            this.f17635c = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public FloatingActionButton(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.floatingActionButtonStyle);
    }

    public void setRippleColor(@o0 ColorStateList colorStateList) {
        if (this.f17620f != colorStateList) {
            this.f17620f = colorStateList;
            getImpl().Y(this.f17620f);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FloatingActionButton(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        int i8 = f17610t;
        super(q1.a.c(context, attributeSet, i7, i8), attributeSet, i7);
        this.f17627m = new Rect();
        this.f17628n = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayJ = n.j(context2, attributeSet, R.styleable.FloatingActionButton, i7, i8, new int[0]);
        this.f17616b = com.google.android.material.resources.c.a(context2, typedArrayJ, R.styleable.FloatingActionButton_backgroundTint);
        this.f17617c = v.k(typedArrayJ.getInt(R.styleable.FloatingActionButton_backgroundTintMode, -1), null);
        this.f17620f = com.google.android.material.resources.c.a(context2, typedArrayJ, R.styleable.FloatingActionButton_rippleColor);
        this.f17622h = typedArrayJ.getInt(R.styleable.FloatingActionButton_fabSize, -1);
        this.f17623i = typedArrayJ.getDimensionPixelSize(R.styleable.FloatingActionButton_fabCustomSize, 0);
        this.f17621g = typedArrayJ.getDimensionPixelSize(R.styleable.FloatingActionButton_borderWidth, 0);
        float dimension = typedArrayJ.getDimension(R.styleable.FloatingActionButton_elevation, 0.0f);
        float dimension2 = typedArrayJ.getDimension(R.styleable.FloatingActionButton_hoveredFocusedTranslationZ, 0.0f);
        float dimension3 = typedArrayJ.getDimension(R.styleable.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.f17626l = typedArrayJ.getBoolean(R.styleable.FloatingActionButton_useCompatPadding, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mtrl_fab_min_touch_target);
        this.f17625k = typedArrayJ.getDimensionPixelSize(R.styleable.FloatingActionButton_maxImageSize, 0);
        h hVarC = h.c(context2, typedArrayJ, R.styleable.FloatingActionButton_showMotionSpec);
        h hVarC2 = h.c(context2, typedArrayJ, R.styleable.FloatingActionButton_hideMotionSpec);
        o oVarM = o.g(context2, attributeSet, i7, i8, o.f18282m).m();
        boolean z7 = typedArrayJ.getBoolean(R.styleable.FloatingActionButton_ensureMinTouchTargetSize, false);
        setEnabled(typedArrayJ.getBoolean(R.styleable.FloatingActionButton_android_enabled, true));
        typedArrayJ.recycle();
        k kVar = new k(this);
        this.f17629o = kVar;
        kVar.g(attributeSet, i7);
        this.f17630p = new o1.c(this);
        getImpl().a0(oVarM);
        getImpl().x(this.f17616b, this.f17617c, this.f17620f, this.f17621g);
        getImpl().W(dimensionPixelSize);
        getImpl().Q(dimension);
        getImpl().T(dimension2);
        getImpl().X(dimension3);
        getImpl().V(this.f17625k);
        getImpl().b0(hVarC);
        getImpl().S(hVarC2);
        getImpl().R(z7);
        setScaleType(ImageView.ScaleType.MATRIX);
    }
}
