package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.n2;
import c.g1;
import c.m0;
import c.o0;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.n;
import com.google.android.material.shape.o;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.b {
    private static final int P = 0;
    private static final int Q = 1;
    private static final int R = 2;
    private int A;
    private final com.google.android.material.floatingactionbutton.a B;

    @m0
    private final com.google.android.material.floatingactionbutton.f C;

    @m0
    private final com.google.android.material.floatingactionbutton.f D;
    private final com.google.android.material.floatingactionbutton.f E;
    private final com.google.android.material.floatingactionbutton.f F;
    private final int G;
    private int H;
    private int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    @m0
    private final CoordinatorLayout.Behavior<ExtendedFloatingActionButton> f17588J;
    private boolean K;
    private boolean L;
    private boolean M;

    @m0
    protected ColorStateList N;
    private static final int O = R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
    static final Property<View, Float> S = new d(Float.class, ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
    static final Property<View, Float> T = new e(Float.class, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
    static final Property<View, Float> U = new f(Float.class, "paddingStart");
    static final Property<View, Float> V = new g(Float.class, "paddingEnd");

    class a implements l {
        a() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int b() {
            return (ExtendedFloatingActionButton.this.getMeasuredWidth() - (ExtendedFloatingActionButton.this.getCollapsedPadding() * 2)) + ExtendedFloatingActionButton.this.H + ExtendedFloatingActionButton.this.I;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int c() {
            return ExtendedFloatingActionButton.this.I;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public ViewGroup.LayoutParams d() {
            return new ViewGroup.LayoutParams(-2, -2);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int e() {
            return ExtendedFloatingActionButton.this.getMeasuredHeight();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int f() {
            return ExtendedFloatingActionButton.this.H;
        }
    }

    class b implements l {
        b() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int b() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int c() {
            return ExtendedFloatingActionButton.this.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public ViewGroup.LayoutParams d() {
            return new ViewGroup.LayoutParams(b(), e());
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int e() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int f() {
            return ExtendedFloatingActionButton.this.getCollapsedPadding();
        }
    }

    class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f17598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.floatingactionbutton.f f17599b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ j f17600c;

        c(com.google.android.material.floatingactionbutton.f fVar, j jVar) {
            this.f17599b = fVar;
            this.f17600c = jVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f17598a = true;
            this.f17599b.a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f17599b.i();
            if (this.f17598a) {
                return;
            }
            this.f17599b.m(this.f17600c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f17599b.onAnimationStart(animator);
            this.f17598a = false;
        }
    }

    static class d extends Property<View, Float> {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @m0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(@m0 View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(@m0 View view, @m0 Float f8) {
            view.getLayoutParams().width = f8.intValue();
            view.requestLayout();
        }
    }

    static class e extends Property<View, Float> {
        e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @m0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(@m0 View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(@m0 View view, @m0 Float f8) {
            view.getLayoutParams().height = f8.intValue();
            view.requestLayout();
        }
    }

    static class f extends Property<View, Float> {
        f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @m0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(@m0 View view) {
            return Float.valueOf(n2.k0(view));
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(@m0 View view, @m0 Float f8) {
            n2.d2(view, f8.intValue(), view.getPaddingTop(), n2.j0(view), view.getPaddingBottom());
        }
    }

    static class g extends Property<View, Float> {
        g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @m0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(@m0 View view) {
            return Float.valueOf(n2.j0(view));
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(@m0 View view, @m0 Float f8) {
            n2.d2(view, n2.k0(view), view.getPaddingTop(), f8.intValue(), view.getPaddingBottom());
        }
    }

    class h extends com.google.android.material.floatingactionbutton.b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final l f17602g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f17603h;

        h(com.google.android.material.floatingactionbutton.a aVar, l lVar, boolean z7) {
            super(ExtendedFloatingActionButton.this, aVar);
            this.f17602g = lVar;
            this.f17603h = z7;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public int c() {
            return this.f17603h ? R.animator.mtrl_extended_fab_change_size_expand_motion_spec : R.animator.mtrl_extended_fab_change_size_collapse_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void d() {
            ExtendedFloatingActionButton.this.K = this.f17603h;
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.f17602g.d().width;
            layoutParams.height = this.f17602g.d().height;
            n2.d2(ExtendedFloatingActionButton.this, this.f17602g.f(), ExtendedFloatingActionButton.this.getPaddingTop(), this.f17602g.c(), ExtendedFloatingActionButton.this.getPaddingBottom());
            ExtendedFloatingActionButton.this.requestLayout();
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public boolean f() {
            return this.f17603h == ExtendedFloatingActionButton.this.K || ExtendedFloatingActionButton.this.getIcon() == null || TextUtils.isEmpty(ExtendedFloatingActionButton.this.getText());
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void i() {
            super.i();
            ExtendedFloatingActionButton.this.L = false;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(false);
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.f17602g.d().width;
            layoutParams.height = this.f17602g.d().height;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        @m0
        public AnimatorSet k() {
            com.google.android.material.animation.h hVarB = b();
            if (hVarB.j(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)) {
                PropertyValuesHolder[] propertyValuesHolderArrG = hVarB.g(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
                propertyValuesHolderArrG[0].setFloatValues(ExtendedFloatingActionButton.this.getWidth(), this.f17602g.b());
                hVarB.l(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, propertyValuesHolderArrG);
            }
            if (hVarB.j(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)) {
                PropertyValuesHolder[] propertyValuesHolderArrG2 = hVarB.g(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
                propertyValuesHolderArrG2[0].setFloatValues(ExtendedFloatingActionButton.this.getHeight(), this.f17602g.e());
                hVarB.l(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, propertyValuesHolderArrG2);
            }
            if (hVarB.j("paddingStart")) {
                PropertyValuesHolder[] propertyValuesHolderArrG3 = hVarB.g("paddingStart");
                propertyValuesHolderArrG3[0].setFloatValues(n2.k0(ExtendedFloatingActionButton.this), this.f17602g.f());
                hVarB.l("paddingStart", propertyValuesHolderArrG3);
            }
            if (hVarB.j("paddingEnd")) {
                PropertyValuesHolder[] propertyValuesHolderArrG4 = hVarB.g("paddingEnd");
                propertyValuesHolderArrG4[0].setFloatValues(n2.j0(ExtendedFloatingActionButton.this), this.f17602g.c());
                hVarB.l("paddingEnd", propertyValuesHolderArrG4);
            }
            if (hVarB.j("labelOpacity")) {
                PropertyValuesHolder[] propertyValuesHolderArrG5 = hVarB.g("labelOpacity");
                boolean z7 = this.f17603h;
                propertyValuesHolderArrG5[0].setFloatValues(z7 ? 0.0f : 1.0f, z7 ? 1.0f : 0.0f);
                hVarB.l("labelOpacity", propertyValuesHolderArrG5);
            }
            return super.o(hVarB);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void m(@o0 j jVar) {
            if (jVar == null) {
                return;
            }
            if (this.f17603h) {
                jVar.a(ExtendedFloatingActionButton.this);
            } else {
                jVar.d(ExtendedFloatingActionButton.this);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.K = this.f17603h;
            ExtendedFloatingActionButton.this.L = true;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(true);
        }
    }

    class i extends com.google.android.material.floatingactionbutton.b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f17605g;

        public i(com.google.android.material.floatingactionbutton.a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void a() {
            super.a();
            this.f17605g = true;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public int c() {
            return R.animator.mtrl_extended_fab_hide_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void d() {
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public boolean f() {
            return ExtendedFloatingActionButton.this.J();
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void i() {
            super.i();
            ExtendedFloatingActionButton.this.A = 0;
            if (this.f17605g) {
                return;
            }
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void m(@o0 j jVar) {
            if (jVar != null) {
                jVar.b(ExtendedFloatingActionButton.this);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.f17605g = false;
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.A = 1;
        }
    }

    public static abstract class j {
        public void a(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void b(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void c(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void d(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }
    }

    class k extends com.google.android.material.floatingactionbutton.b {
        public k(com.google.android.material.floatingactionbutton.a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public int c() {
            return R.animator.mtrl_extended_fab_show_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void d() {
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.setAlpha(1.0f);
            ExtendedFloatingActionButton.this.setScaleY(1.0f);
            ExtendedFloatingActionButton.this.setScaleX(1.0f);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public boolean f() {
            return ExtendedFloatingActionButton.this.K();
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void i() {
            super.i();
            ExtendedFloatingActionButton.this.A = 0;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void m(@o0 j jVar) {
            if (jVar != null) {
                jVar.c(ExtendedFloatingActionButton.this);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.A = 2;
        }
    }

    interface l {
        int b();

        int c();

        ViewGroup.LayoutParams d();

        int e();

        int f();
    }

    public ExtendedFloatingActionButton(@m0 Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J() {
        if (getVisibility() == 0) {
            return this.A == 1;
        }
        return this.A != 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean K() {
        if (getVisibility() != 0) {
            return this.A == 2;
        }
        return this.A != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(@m0 com.google.android.material.floatingactionbutton.f fVar, @o0 j jVar) {
        if (fVar.f()) {
            return;
        }
        if (!R()) {
            fVar.d();
            fVar.m(jVar);
            return;
        }
        measure(0, 0);
        AnimatorSet animatorSetK = fVar.k();
        animatorSetK.addListener(new c(fVar, jVar));
        Iterator<Animator.AnimatorListener> it = fVar.l().iterator();
        while (it.hasNext()) {
            animatorSetK.addListener(it.next());
        }
        animatorSetK.start();
    }

    private void Q() {
        this.N = getTextColors();
    }

    private boolean R() {
        return (n2.U0(this) || (!K() && this.M)) && !isInEditMode();
    }

    public void A(@m0 Animator.AnimatorListener animatorListener) {
        this.D.h(animatorListener);
    }

    public void B(@m0 Animator.AnimatorListener animatorListener) {
        this.F.h(animatorListener);
    }

    public void C(@m0 Animator.AnimatorListener animatorListener) {
        this.E.h(animatorListener);
    }

    public void D(@m0 Animator.AnimatorListener animatorListener) {
        this.C.h(animatorListener);
    }

    public void E() {
        L(this.D, null);
    }

    public void F(@m0 j jVar) {
        L(this.D, jVar);
    }

    public void G() {
        L(this.F, null);
    }

    public void H(@m0 j jVar) {
        L(this.F, jVar);
    }

    public final boolean I() {
        return this.K;
    }

    public void M(@m0 Animator.AnimatorListener animatorListener) {
        this.D.g(animatorListener);
    }

    public void N(@m0 Animator.AnimatorListener animatorListener) {
        this.F.g(animatorListener);
    }

    public void O(@m0 Animator.AnimatorListener animatorListener) {
        this.E.g(animatorListener);
    }

    public void P(@m0 Animator.AnimatorListener animatorListener) {
        this.C.g(animatorListener);
    }

    public void S() {
        L(this.E, null);
    }

    public void T(@m0 j jVar) {
        L(this.E, jVar);
    }

    public void U() {
        L(this.C, null);
    }

    public void V(@m0 j jVar) {
        L(this.C, jVar);
    }

    protected void W(@m0 ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    @m0
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.f17588J;
    }

    int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    @g1
    int getCollapsedSize() {
        int i7 = this.G;
        return i7 < 0 ? (Math.min(n2.k0(this), n2.j0(this)) * 2) + getIconSize() : i7;
    }

    @o0
    public com.google.android.material.animation.h getExtendMotionSpec() {
        return this.D.e();
    }

    @o0
    public com.google.android.material.animation.h getHideMotionSpec() {
        return this.F.e();
    }

    @o0
    public com.google.android.material.animation.h getShowMotionSpec() {
        return this.E.e();
    }

    @o0
    public com.google.android.material.animation.h getShrinkMotionSpec() {
        return this.C.e();
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.K && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.K = false;
            this.C.d();
        }
    }

    public void setAnimateShowBeforeLayout(boolean z7) {
        this.M = z7;
    }

    public void setExtendMotionSpec(@o0 com.google.android.material.animation.h hVar) {
        this.D.j(hVar);
    }

    public void setExtendMotionSpecResource(@c.b int i7) {
        setExtendMotionSpec(com.google.android.material.animation.h.d(getContext(), i7));
    }

    public void setExtended(boolean z7) {
        if (this.K == z7) {
            return;
        }
        com.google.android.material.floatingactionbutton.f fVar = z7 ? this.D : this.C;
        if (fVar.f()) {
            return;
        }
        fVar.d();
    }

    public void setHideMotionSpec(@o0 com.google.android.material.animation.h hVar) {
        this.F.j(hVar);
    }

    public void setHideMotionSpecResource(@c.b int i7) {
        setHideMotionSpec(com.google.android.material.animation.h.d(getContext(), i7));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i7, int i8, int i9, int i10) {
        super.setPadding(i7, i8, i9, i10);
        if (!this.K || this.L) {
            return;
        }
        this.H = n2.k0(this);
        this.I = n2.j0(this);
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int i7, int i8, int i9, int i10) {
        super.setPaddingRelative(i7, i8, i9, i10);
        if (!this.K || this.L) {
            return;
        }
        this.H = i7;
        this.I = i9;
    }

    public void setShowMotionSpec(@o0 com.google.android.material.animation.h hVar) {
        this.E.j(hVar);
    }

    public void setShowMotionSpecResource(@c.b int i7) {
        setShowMotionSpec(com.google.android.material.animation.h.d(getContext(), i7));
    }

    public void setShrinkMotionSpec(@o0 com.google.android.material.animation.h hVar) {
        this.C.j(hVar);
    }

    public void setShrinkMotionSpecResource(@c.b int i7) {
        setShrinkMotionSpec(com.google.android.material.animation.h.d(getContext(), i7));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i7) {
        super.setTextColor(i7);
        Q();
    }

    public ExtendedFloatingActionButton(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.extendedFloatingActionButtonStyle);
    }

    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final boolean f17589f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final boolean f17590g = true;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Rect f17591a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @o0
        private j f17592b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @o0
        private j f17593c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f17594d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f17595e;

        public ExtendedFloatingActionButtonBehavior() {
            this.f17594d = false;
            this.f17595e = true;
        }

        private static boolean K(@m0 View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean R(@m0 View view, @m0 ExtendedFloatingActionButton extendedFloatingActionButton) {
            return (this.f17594d || this.f17595e) && ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams()).e() == view.getId();
        }

        private boolean T(CoordinatorLayout coordinatorLayout, @m0 AppBarLayout appBarLayout, @m0 ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!R(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.f17591a == null) {
                this.f17591a = new Rect();
            }
            Rect rect = this.f17591a;
            com.google.android.material.internal.c.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                S(extendedFloatingActionButton);
                return true;
            }
            G(extendedFloatingActionButton);
            return true;
        }

        private boolean U(@m0 View view, @m0 ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!R(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                S(extendedFloatingActionButton);
                return true;
            }
            G(extendedFloatingActionButton);
            return true;
        }

        protected void G(@m0 ExtendedFloatingActionButton extendedFloatingActionButton) {
            boolean z7 = this.f17595e;
            extendedFloatingActionButton.L(z7 ? extendedFloatingActionButton.D : extendedFloatingActionButton.E, z7 ? this.f17593c : this.f17592b);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
        public boolean b(@m0 CoordinatorLayout coordinatorLayout, @m0 ExtendedFloatingActionButton extendedFloatingActionButton, @m0 Rect rect) {
            return super.b(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        public boolean I() {
            return this.f17594d;
        }

        public boolean J() {
            return this.f17595e;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
        public boolean i(CoordinatorLayout coordinatorLayout, @m0 ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                T(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            }
            if (!K(view)) {
                return false;
            }
            U(view, extendedFloatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
        public boolean m(@m0 CoordinatorLayout coordinatorLayout, @m0 ExtendedFloatingActionButton extendedFloatingActionButton, int i7) {
            List<View> listW = coordinatorLayout.w(extendedFloatingActionButton);
            int size = listW.size();
            for (int i8 = 0; i8 < size; i8++) {
                View view = listW.get(i8);
                if (!(view instanceof AppBarLayout)) {
                    if (K(view) && U(view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (T(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.N(extendedFloatingActionButton, i7);
            return true;
        }

        public void N(boolean z7) {
            this.f17594d = z7;
        }

        public void O(boolean z7) {
            this.f17595e = z7;
        }

        @g1
        void P(@o0 j jVar) {
            this.f17592b = jVar;
        }

        @g1
        void Q(@o0 j jVar) {
            this.f17593c = jVar;
        }

        protected void S(@m0 ExtendedFloatingActionButton extendedFloatingActionButton) {
            boolean z7 = this.f17595e;
            extendedFloatingActionButton.L(z7 ? extendedFloatingActionButton.C : extendedFloatingActionButton.F, z7 ? this.f17593c : this.f17592b);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void h(@m0 CoordinatorLayout.f fVar) {
            if (fVar.f5014h == 0) {
                fVar.f5014h = 80;
            }
        }

        public ExtendedFloatingActionButtonBehavior(@m0 Context context, @o0 AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.f17594d = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.f17595e = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ExtendedFloatingActionButton(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        int i8 = O;
        super(q1.a.c(context, attributeSet, i7, i8), attributeSet, i7);
        this.A = 0;
        com.google.android.material.floatingactionbutton.a aVar = new com.google.android.material.floatingactionbutton.a();
        this.B = aVar;
        k kVar = new k(aVar);
        this.E = kVar;
        i iVar = new i(aVar);
        this.F = iVar;
        this.K = true;
        this.L = false;
        this.M = false;
        Context context2 = getContext();
        this.f17588J = new ExtendedFloatingActionButtonBehavior(context2, attributeSet);
        TypedArray typedArrayJ = n.j(context2, attributeSet, R.styleable.ExtendedFloatingActionButton, i7, i8, new int[0]);
        com.google.android.material.animation.h hVarC = com.google.android.material.animation.h.c(context2, typedArrayJ, R.styleable.ExtendedFloatingActionButton_showMotionSpec);
        com.google.android.material.animation.h hVarC2 = com.google.android.material.animation.h.c(context2, typedArrayJ, R.styleable.ExtendedFloatingActionButton_hideMotionSpec);
        com.google.android.material.animation.h hVarC3 = com.google.android.material.animation.h.c(context2, typedArrayJ, R.styleable.ExtendedFloatingActionButton_extendMotionSpec);
        com.google.android.material.animation.h hVarC4 = com.google.android.material.animation.h.c(context2, typedArrayJ, R.styleable.ExtendedFloatingActionButton_shrinkMotionSpec);
        this.G = typedArrayJ.getDimensionPixelSize(R.styleable.ExtendedFloatingActionButton_collapsedSize, -1);
        this.H = n2.k0(this);
        this.I = n2.j0(this);
        com.google.android.material.floatingactionbutton.a aVar2 = new com.google.android.material.floatingactionbutton.a();
        h hVar = new h(aVar2, new a(), true);
        this.D = hVar;
        h hVar2 = new h(aVar2, new b(), false);
        this.C = hVar2;
        kVar.j(hVarC);
        iVar.j(hVarC2);
        hVar.j(hVarC3);
        hVar2.j(hVarC4);
        typedArrayJ.recycle();
        setShapeAppearanceModel(o.g(context2, attributeSet, i7, i8, o.f18282m).m());
        Q();
    }

    @Override // android.widget.TextView
    public void setTextColor(@m0 ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        Q();
    }
}
