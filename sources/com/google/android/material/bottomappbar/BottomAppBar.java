package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.n0;
import androidx.core.view.n2;
import androidx.core.view.w5;
import androidx.customview.view.AbsSavedState;
import c.k0;
import c.m0;
import c.o0;
import c.q;
import c.r0;
import com.google.android.material.R;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.n;
import com.google.android.material.internal.v;
import com.google.android.material.shape.o;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.b {
    private static final int Q0 = R.style.Widget_MaterialComponents_BottomAppBar;
    private static final long R0 = 300;
    public static final int S0 = 0;
    public static final int T0 = 1;
    public static final int U0 = 0;
    public static final int V0 = 1;
    private static final int W0 = 0;
    private int A0;
    private boolean B0;
    private final boolean C0;
    private final boolean D0;
    private final boolean E0;
    private int F0;
    private ArrayList<j> G0;

    @k0
    private int H0;
    private boolean I0;
    private boolean J0;
    private Behavior K0;
    private int L0;
    private int M0;
    private int N0;

    @m0
    AnimatorListenerAdapter O0;

    @m0
    com.google.android.material.animation.k<FloatingActionButton> P0;
    private final int S;
    private final com.google.android.material.shape.j T;

    @o0
    private Animator U;

    @o0
    private Animator V;
    private int W;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f17084c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f17085d;

        static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @o0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@m0 Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @m0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@m0 Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @m0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i7) {
                return new SavedState[i7];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@m0 Parcel parcel, int i7) {
            super.writeToParcel(parcel, i7);
            parcel.writeInt(this.f17084c);
            parcel.writeInt(this.f17085d ? 1 : 0);
        }

        public SavedState(@m0 Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f17084c = parcel.readInt();
            this.f17085d = parcel.readInt() != 0;
        }
    }

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (BottomAppBar.this.I0) {
                return;
            }
            BottomAppBar bottomAppBar = BottomAppBar.this;
            bottomAppBar.G0(bottomAppBar.W, BottomAppBar.this.J0);
        }
    }

    class b implements com.google.android.material.animation.k<FloatingActionButton> {
        b() {
        }

        @Override // com.google.android.material.animation.k
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(@m0 FloatingActionButton floatingActionButton) {
            BottomAppBar.this.T.o0(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
        }

        @Override // com.google.android.material.animation.k
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(@m0 FloatingActionButton floatingActionButton) {
            float translationX = floatingActionButton.getTranslationX();
            if (BottomAppBar.this.getTopEdgeTreatment().n() != translationX) {
                BottomAppBar.this.getTopEdgeTreatment().t(translationX);
                BottomAppBar.this.T.invalidateSelf();
            }
            float fMax = Math.max(0.0f, -floatingActionButton.getTranslationY());
            if (BottomAppBar.this.getTopEdgeTreatment().i() != fMax) {
                BottomAppBar.this.getTopEdgeTreatment().o(fMax);
                BottomAppBar.this.T.invalidateSelf();
            }
            BottomAppBar.this.T.o0(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
        }
    }

    class c implements v.e {
        c() {
        }

        @Override // com.google.android.material.internal.v.e
        @m0
        public w5 a(View view, @m0 w5 w5Var, @m0 v.f fVar) {
            boolean z7;
            if (BottomAppBar.this.C0) {
                BottomAppBar.this.L0 = w5Var.o();
            }
            boolean z8 = false;
            if (BottomAppBar.this.D0) {
                z7 = BottomAppBar.this.N0 != w5Var.p();
                BottomAppBar.this.N0 = w5Var.p();
            } else {
                z7 = false;
            }
            if (BottomAppBar.this.E0) {
                boolean z9 = BottomAppBar.this.M0 != w5Var.q();
                BottomAppBar.this.M0 = w5Var.q();
                z8 = z9;
            }
            if (z7 || z8) {
                BottomAppBar.this.v0();
                BottomAppBar.this.N0();
                BottomAppBar.this.M0();
            }
            return w5Var;
        }
    }

    class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.z0();
            BottomAppBar.this.U = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.A0();
        }
    }

    class e extends FloatingActionButton.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f17090a;

        class a extends FloatingActionButton.b {
            a() {
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
            public void b(FloatingActionButton floatingActionButton) {
                BottomAppBar.this.z0();
            }
        }

        e(int i7) {
            this.f17090a = i7;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
        public void a(@m0 FloatingActionButton floatingActionButton) {
            floatingActionButton.setTranslationX(BottomAppBar.this.E0(this.f17090a));
            floatingActionButton.A(new a());
        }
    }

    class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.z0();
            BottomAppBar.this.I0 = false;
            BottomAppBar.this.V = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.A0();
        }
    }

    class g extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f17094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ActionMenuView f17095b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f17096c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f17097d;

        g(ActionMenuView actionMenuView, int i7, boolean z7) {
            this.f17095b = actionMenuView;
            this.f17096c = i7;
            this.f17097d = z7;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f17094a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f17094a) {
                return;
            }
            boolean z7 = BottomAppBar.this.H0 != 0;
            BottomAppBar bottomAppBar = BottomAppBar.this;
            bottomAppBar.L0(bottomAppBar.H0);
            BottomAppBar.this.Q0(this.f17095b, this.f17096c, this.f17097d, z7);
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ActionMenuView f17099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f17100b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f17101c;

        h(ActionMenuView actionMenuView, int i7, boolean z7) {
            this.f17099a = actionMenuView;
            this.f17100b = i7;
            this.f17101c = z7;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionMenuView actionMenuView = this.f17099a;
            actionMenuView.setTranslationX(BottomAppBar.this.D0(actionMenuView, this.f17100b, this.f17101c));
        }
    }

    class i extends AnimatorListenerAdapter {
        i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.O0.onAnimationStart(animator);
            FloatingActionButton floatingActionButtonB0 = BottomAppBar.this.B0();
            if (floatingActionButtonB0 != null) {
                floatingActionButtonB0.setTranslationX(BottomAppBar.this.getFabTranslationX());
            }
        }
    }

    interface j {
        void a(BottomAppBar bottomAppBar);

        void b(BottomAppBar bottomAppBar);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface k {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface l {
    }

    public BottomAppBar(@m0 Context context) {
        this(context, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        ArrayList<j> arrayList;
        int i7 = this.F0;
        this.F0 = i7 + 1;
        if (i7 != 0 || (arrayList = this.G0) == null) {
            return;
        }
        Iterator<j> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @o0
    public FloatingActionButton B0() {
        View viewC0 = C0();
        if (viewC0 instanceof FloatingActionButton) {
            return (FloatingActionButton) viewC0;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @o0
    public View C0() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).x(this)) {
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float E0(int i7) {
        boolean zJ = v.j(this);
        if (i7 == 1) {
            return ((getMeasuredWidth() / 2) - (this.S + (zJ ? this.N0 : this.M0))) * (zJ ? -1 : 1);
        }
        return 0.0f;
    }

    private boolean F0() {
        FloatingActionButton floatingActionButtonB0 = B0();
        return floatingActionButtonB0 != null && floatingActionButtonB0.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(int i7, boolean z7) {
        if (!n2.U0(this)) {
            this.I0 = false;
            L0(this.H0);
            return;
        }
        Animator animator = this.V;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!F0()) {
            i7 = 0;
            z7 = false;
        }
        y0(i7, z7, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.V = animatorSet;
        animatorSet.addListener(new f());
        this.V.start();
    }

    private void H0(int i7) {
        if (this.W == i7 || !n2.U0(this)) {
            return;
        }
        Animator animator = this.U;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (this.A0 == 1) {
            x0(i7, arrayList);
        } else {
            w0(i7, arrayList);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.U = animatorSet;
        animatorSet.addListener(new d());
        this.U.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null || this.V != null) {
            return;
        }
        actionMenuView.setAlpha(1.0f);
        if (F0()) {
            P0(actionMenuView, this.W, this.J0);
        } else {
            P0(actionMenuView, 0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0() {
        getTopEdgeTreatment().t(getFabTranslationX());
        View viewC0 = C0();
        this.T.o0((this.J0 && F0()) ? 1.0f : 0.0f);
        if (viewC0 != null) {
            viewC0.setTranslationY(getFabTranslationY());
            viewC0.setTranslationX(getFabTranslationX());
        }
    }

    private void P0(@m0 ActionMenuView actionMenuView, int i7, boolean z7) {
        Q0(actionMenuView, i7, z7, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0(@m0 ActionMenuView actionMenuView, int i7, boolean z7, boolean z8) {
        h hVar = new h(actionMenuView, i7, z7);
        if (z8) {
            actionMenuView.post(hVar);
        } else {
            hVar.run();
        }
    }

    @o0
    private ActionMenuView getActionMenuView() {
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            View childAt = getChildAt(i7);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBottomInset() {
        return this.L0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX() {
        return E0(this.W);
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        return this.N0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        return this.M0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @m0
    public com.google.android.material.bottomappbar.a getTopEdgeTreatment() {
        return (com.google.android.material.bottomappbar.a) this.T.getShapeAppearanceModel().p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(@m0 FloatingActionButton floatingActionButton) {
        floatingActionButton.f(this.O0);
        floatingActionButton.g(new i());
        floatingActionButton.h(this.P0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0() {
        Animator animator = this.V;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.U;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    private void x0(int i7, @m0 List<Animator> list) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(B0(), "translationX", E0(i7));
        objectAnimatorOfFloat.setDuration(R0);
        list.add(objectAnimatorOfFloat);
    }

    private void y0(int i7, boolean z7, @m0 List<Animator> list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        Animator animatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        if (Math.abs(actionMenuView.getTranslationX() - D0(actionMenuView, i7, z7)) <= 1.0f) {
            if (actionMenuView.getAlpha() < 1.0f) {
                list.add(animatorOfFloat);
            }
        } else {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
            objectAnimatorOfFloat.addListener(new g(actionMenuView, i7, z7));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(150L);
            animatorSet.playSequentially(objectAnimatorOfFloat, animatorOfFloat);
            list.add(animatorSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        ArrayList<j> arrayList;
        int i7 = this.F0 - 1;
        this.F0 = i7;
        if (i7 != 0 || (arrayList = this.G0) == null) {
            return;
        }
        Iterator<j> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    protected int D0(@m0 ActionMenuView actionMenuView, int i7, boolean z7) {
        if (i7 != 1 || !z7) {
            return 0;
        }
        boolean zJ = v.j(this);
        int measuredWidth = zJ ? getMeasuredWidth() : 0;
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            View childAt = getChildAt(i8);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).f628a & n0.f6719d) == 8388611) {
                measuredWidth = zJ ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        return measuredWidth - ((zJ ? actionMenuView.getRight() : actionMenuView.getLeft()) + (zJ ? this.M0 : -this.N0));
    }

    public void I0() {
        getBehavior().J(this);
    }

    public void J0() {
        getBehavior().K(this);
    }

    void K0(@m0 j jVar) {
        ArrayList<j> arrayList = this.G0;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(jVar);
    }

    public void L0(@k0 int i7) {
        if (i7 != 0) {
            this.H0 = 0;
            getMenu().clear();
            x(i7);
        }
    }

    boolean O0(@r0 int i7) {
        float f8 = i7;
        if (f8 == getTopEdgeTreatment().m()) {
            return false;
        }
        getTopEdgeTreatment().s(f8);
        this.T.invalidateSelf();
        return true;
    }

    @o0
    public ColorStateList getBackgroundTint() {
        return this.T.Q();
    }

    @q
    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().i();
    }

    public int getFabAlignmentMode() {
        return this.W;
    }

    public int getFabAnimationMode() {
        return this.A0;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().k();
    }

    @q
    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().l();
    }

    public boolean getHideOnScroll() {
        return this.B0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.shape.k.f(this, this.T);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        super.onLayout(z7, i7, i8, i9, i10);
        if (z7) {
            v0();
            N0();
        }
        M0();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.W = savedState.f17084c;
        this.J0 = savedState.f17085d;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    @m0
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f17084c = this.W;
        savedState.f17085d = this.J0;
        return savedState;
    }

    public void setBackgroundTint(@o0 ColorStateList colorStateList) {
        androidx.core.graphics.drawable.d.o(this.T, colorStateList);
    }

    public void setCradleVerticalOffset(@q float f8) {
        if (f8 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().o(f8);
            this.T.invalidateSelf();
            N0();
        }
    }

    @Override // android.view.View
    public void setElevation(float f8) {
        this.T.m0(f8);
        getBehavior().I(this, this.T.J() - this.T.I());
    }

    public void setFabAlignmentMode(int i7) {
        setFabAlignmentModeAndReplaceMenu(i7, 0);
    }

    public void setFabAlignmentModeAndReplaceMenu(int i7, @k0 int i8) {
        this.H0 = i8;
        this.I0 = true;
        G0(i7, this.J0);
        H0(i7);
        this.W = i7;
    }

    public void setFabAnimationMode(int i7) {
        this.A0 = i7;
    }

    void setFabCornerSize(@q float f8) {
        if (f8 != getTopEdgeTreatment().j()) {
            getTopEdgeTreatment().p(f8);
            this.T.invalidateSelf();
        }
    }

    public void setFabCradleMargin(@q float f8) {
        if (f8 != getFabCradleMargin()) {
            getTopEdgeTreatment().q(f8);
            this.T.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(@q float f8) {
        if (f8 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().r(f8);
            this.T.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z7) {
        this.B0 = z7;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    void t0(@m0 j jVar) {
        if (this.G0 == null) {
            this.G0 = new ArrayList<>();
        }
        this.G0.add(jVar);
    }

    protected void w0(int i7, List<Animator> list) {
        FloatingActionButton floatingActionButtonB0 = B0();
        if (floatingActionButtonB0 == null || floatingActionButtonB0.q()) {
            return;
        }
        A0();
        floatingActionButtonB0.o(new e(i7));
    }

    public BottomAppBar(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomAppBarStyle);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    @m0
    public Behavior getBehavior() {
        if (this.K0 == null) {
            this.K0 = new Behavior();
        }
        return this.K0;
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @m0
        private final Rect f17079i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private WeakReference<BottomAppBar> f17080j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f17081k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final View.OnLayoutChangeListener f17082l;

        class a implements View.OnLayoutChangeListener {
            a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.f17080j.get();
                if (bottomAppBar == null || !(view instanceof FloatingActionButton)) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                floatingActionButton.l(Behavior.this.f17079i);
                int iHeight = Behavior.this.f17079i.height();
                bottomAppBar.O0(iHeight);
                bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().r().a(new RectF(Behavior.this.f17079i)));
                CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
                if (Behavior.this.f17081k == 0) {
                    ((ViewGroup.MarginLayoutParams) fVar).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fab_bottom_margin) - ((floatingActionButton.getMeasuredHeight() - iHeight) / 2));
                    ((ViewGroup.MarginLayoutParams) fVar).leftMargin = bottomAppBar.getLeftInset();
                    ((ViewGroup.MarginLayoutParams) fVar).rightMargin = bottomAppBar.getRightInset();
                    if (v.j(floatingActionButton)) {
                        ((ViewGroup.MarginLayoutParams) fVar).leftMargin += bottomAppBar.S;
                    } else {
                        ((ViewGroup.MarginLayoutParams) fVar).rightMargin += bottomAppBar.S;
                    }
                }
            }
        }

        public Behavior() {
            this.f17082l = new a();
            this.f17079i = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
        public boolean m(@m0 CoordinatorLayout coordinatorLayout, @m0 BottomAppBar bottomAppBar, int i7) {
            this.f17080j = new WeakReference<>(bottomAppBar);
            View viewC0 = bottomAppBar.C0();
            if (viewC0 != null && !n2.U0(viewC0)) {
                CoordinatorLayout.f fVar = (CoordinatorLayout.f) viewC0.getLayoutParams();
                fVar.f5010d = 49;
                this.f17081k = ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
                if (viewC0 instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) viewC0;
                    floatingActionButton.addOnLayoutChangeListener(this.f17082l);
                    bottomAppBar.u0(floatingActionButton);
                }
                bottomAppBar.N0();
            }
            coordinatorLayout.N(bottomAppBar, i7);
            return super.m(coordinatorLayout, bottomAppBar, i7);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
        public boolean B(@m0 CoordinatorLayout coordinatorLayout, @m0 BottomAppBar bottomAppBar, @m0 View view, @m0 View view2, int i7, int i8) {
            return bottomAppBar.getHideOnScroll() && super.B(coordinatorLayout, bottomAppBar, view, view2, i7, i8);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f17082l = new a();
            this.f17079i = new Rect();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BottomAppBar(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        int i8 = Q0;
        super(q1.a.c(context, attributeSet, i7, i8), attributeSet, i7);
        com.google.android.material.shape.j jVar = new com.google.android.material.shape.j();
        this.T = jVar;
        this.F0 = 0;
        this.H0 = 0;
        this.I0 = false;
        this.J0 = true;
        this.O0 = new a();
        this.P0 = new b();
        Context context2 = getContext();
        TypedArray typedArrayJ = n.j(context2, attributeSet, R.styleable.BottomAppBar, i7, i8, new int[0]);
        ColorStateList colorStateListA = com.google.android.material.resources.c.a(context2, typedArrayJ, R.styleable.BottomAppBar_backgroundTint);
        int dimensionPixelSize = typedArrayJ.getDimensionPixelSize(R.styleable.BottomAppBar_elevation, 0);
        float dimensionPixelOffset = typedArrayJ.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleMargin, 0);
        float dimensionPixelOffset2 = typedArrayJ.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleRoundedCornerRadius, 0);
        float dimensionPixelOffset3 = typedArrayJ.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleVerticalOffset, 0);
        this.W = typedArrayJ.getInt(R.styleable.BottomAppBar_fabAlignmentMode, 0);
        this.A0 = typedArrayJ.getInt(R.styleable.BottomAppBar_fabAnimationMode, 0);
        this.B0 = typedArrayJ.getBoolean(R.styleable.BottomAppBar_hideOnScroll, false);
        this.C0 = typedArrayJ.getBoolean(R.styleable.BottomAppBar_paddingBottomSystemWindowInsets, false);
        this.D0 = typedArrayJ.getBoolean(R.styleable.BottomAppBar_paddingLeftSystemWindowInsets, false);
        this.E0 = typedArrayJ.getBoolean(R.styleable.BottomAppBar_paddingRightSystemWindowInsets, false);
        typedArrayJ.recycle();
        this.S = getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fabOffsetEndMode);
        jVar.setShapeAppearanceModel(o.a().G(new com.google.android.material.bottomappbar.a(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3)).m());
        jVar.w0(2);
        jVar.q0(Paint.Style.FILL);
        jVar.Y(context2);
        setElevation(dimensionPixelSize);
        androidx.core.graphics.drawable.d.o(jVar, colorStateListA);
        n2.I1(this, jVar);
        v.c(this, attributeSet, i7, i8, new c());
    }
}
