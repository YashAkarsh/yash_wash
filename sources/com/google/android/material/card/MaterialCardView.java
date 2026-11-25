package com.google.android.material.card;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.cardview.widget.CardView;
import c.l;
import c.m0;
import c.n;
import c.o0;
import c.p;
import c.q;
import c.u;
import c.v;
import com.google.android.material.shape.k;
import com.google.android.material.shape.o;
import com.google.android.material.shape.s;

/* JADX INFO: loaded from: classes.dex */
public class MaterialCardView extends CardView implements Checkable, s {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int[] f17275o = {R.attr.state_checkable};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int[] f17276p = {R.attr.state_checked};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int[] f17277q = {com.google.android.material.R.attr.state_dragged};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int f17278r = com.google.android.material.R.style.Widget_MaterialComponents_CardView;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f17279s = "MaterialCardView";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f17280t = "androidx.cardview.widget.CardView";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @m0
    private final com.google.android.material.card.a f17281j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f17282k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f17283l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f17284m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private a f17285n;

    public interface a {
        void a(MaterialCardView materialCardView, boolean z7);
    }

    public MaterialCardView(Context context) {
        this(context, null);
    }

    @m0
    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.f17281j.k().getBounds());
        return rectF;
    }

    private void i() {
        if (Build.VERSION.SDK_INT > 26) {
            this.f17281j.j();
        }
    }

    @Override // androidx.cardview.widget.CardView
    @m0
    public ColorStateList getCardBackgroundColor() {
        return this.f17281j.l();
    }

    @m0
    public ColorStateList getCardForegroundColor() {
        return this.f17281j.m();
    }

    float getCardViewRadius() {
        return super.getRadius();
    }

    @o0
    public Drawable getCheckedIcon() {
        return this.f17281j.n();
    }

    @q
    public int getCheckedIconMargin() {
        return this.f17281j.o();
    }

    @q
    public int getCheckedIconSize() {
        return this.f17281j.p();
    }

    @o0
    public ColorStateList getCheckedIconTint() {
        return this.f17281j.q();
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.f17281j.A().bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.f17281j.A().left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.f17281j.A().right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.f17281j.A().top;
    }

    @v(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.f17281j.u();
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.f17281j.s();
    }

    public ColorStateList getRippleColor() {
        return this.f17281j.v();
    }

    @Override // com.google.android.material.shape.s
    @m0
    public o getShapeAppearanceModel() {
        return this.f17281j.w();
    }

    @l
    @Deprecated
    public int getStrokeColor() {
        return this.f17281j.x();
    }

    @o0
    public ColorStateList getStrokeColorStateList() {
        return this.f17281j.y();
    }

    @q
    public int getStrokeWidth() {
        return this.f17281j.z();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f17283l;
    }

    public boolean j() {
        com.google.android.material.card.a aVar = this.f17281j;
        return aVar != null && aVar.D();
    }

    public boolean k() {
        return this.f17284m;
    }

    void l(int i7, int i8, int i9, int i10) {
        super.setContentPadding(i7, i8, i9, i10);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        k.f(this, this.f17281j.k());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i7) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i7 + 3);
        if (j()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f17275o);
        }
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f17276p);
        }
        if (k()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f17277q);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@m0 AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(f17280t);
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@m0 AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(f17280t);
        accessibilityNodeInfo.setCheckable(j());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i7, int i8) {
        super.onMeasure(i7, i8);
        this.f17281j.F(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f17282k) {
            if (!this.f17281j.C()) {
                Log.i(f17279s, "Setting a custom background is not supported.");
                this.f17281j.G(true);
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@l int i7) {
        this.f17281j.H(ColorStateList.valueOf(i7));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f8) {
        super.setCardElevation(f8);
        this.f17281j.Z();
    }

    public void setCardForegroundColor(@o0 ColorStateList colorStateList) {
        this.f17281j.I(colorStateList);
    }

    public void setCheckable(boolean z7) {
        this.f17281j.J(z7);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z7) {
        if (this.f17283l != z7) {
            toggle();
        }
    }

    public void setCheckedIcon(@o0 Drawable drawable) {
        this.f17281j.K(drawable);
    }

    public void setCheckedIconMargin(@q int i7) {
        this.f17281j.L(i7);
    }

    public void setCheckedIconMarginResource(@p int i7) {
        if (i7 != -1) {
            this.f17281j.L(getResources().getDimensionPixelSize(i7));
        }
    }

    public void setCheckedIconResource(@u int i7) {
        this.f17281j.K(e.a.b(getContext(), i7));
    }

    public void setCheckedIconSize(@q int i7) {
        this.f17281j.M(i7);
    }

    public void setCheckedIconSizeResource(@p int i7) {
        if (i7 != 0) {
            this.f17281j.M(getResources().getDimensionPixelSize(i7));
        }
    }

    public void setCheckedIconTint(@o0 ColorStateList colorStateList) {
        this.f17281j.N(colorStateList);
    }

    @Override // android.view.View
    public void setClickable(boolean z7) {
        super.setClickable(z7);
        com.google.android.material.card.a aVar = this.f17281j;
        if (aVar != null) {
            aVar.X();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setContentPadding(int i7, int i8, int i9, int i10) {
        this.f17281j.U(i7, i8, i9, i10);
    }

    public void setDragged(boolean z7) {
        if (this.f17284m != z7) {
            this.f17284m = z7;
            refreshDrawableState();
            i();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f8) {
        super.setMaxCardElevation(f8);
        this.f17281j.b0();
    }

    public void setOnCheckedChangeListener(@o0 a aVar) {
        this.f17285n = aVar;
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z7) {
        super.setPreventCornerOverlap(z7);
        this.f17281j.b0();
        this.f17281j.Y();
    }

    public void setProgress(@v(from = 0.0d, to = 1.0d) float f8) {
        this.f17281j.P(f8);
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f8) {
        super.setRadius(f8);
        this.f17281j.O(f8);
    }

    public void setRippleColor(@o0 ColorStateList colorStateList) {
        this.f17281j.Q(colorStateList);
    }

    public void setRippleColorResource(@n int i7) {
        this.f17281j.Q(e.a.a(getContext(), i7));
    }

    @Override // com.google.android.material.shape.s
    public void setShapeAppearanceModel(@m0 o oVar) {
        setClipToOutline(oVar.u(getBoundsAsRectF()));
        this.f17281j.R(oVar);
    }

    public void setStrokeColor(@l int i7) {
        this.f17281j.S(ColorStateList.valueOf(i7));
    }

    public void setStrokeWidth(@q int i7) {
        this.f17281j.T(i7);
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z7) {
        super.setUseCompatPadding(z7);
        this.f17281j.b0();
        this.f17281j.Y();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (j() && isEnabled()) {
            this.f17283l = !this.f17283l;
            refreshDrawableState();
            i();
            a aVar = this.f17285n;
            if (aVar != null) {
                aVar.a(this, this.f17283l);
            }
        }
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.materialCardViewStyle);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@o0 ColorStateList colorStateList) {
        this.f17281j.H(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f17281j.S(colorStateList);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialCardView(Context context, AttributeSet attributeSet, int i7) {
        int i8 = f17278r;
        super(q1.a.c(context, attributeSet, i7, i8), attributeSet, i7);
        this.f17283l = false;
        this.f17284m = false;
        this.f17282k = true;
        TypedArray typedArrayJ = com.google.android.material.internal.n.j(getContext(), attributeSet, com.google.android.material.R.styleable.MaterialCardView, i7, i8, new int[0]);
        com.google.android.material.card.a aVar = new com.google.android.material.card.a(this, attributeSet, i7, i8);
        this.f17281j = aVar;
        aVar.H(super.getCardBackgroundColor());
        aVar.U(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        aVar.E(typedArrayJ);
        typedArrayJ.recycle();
    }
}
