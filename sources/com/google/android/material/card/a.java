package com.google.android.material.card;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import androidx.core.graphics.drawable.d;
import androidx.core.view.n2;
import c.b1;
import c.l;
import c.m0;
import c.o0;
import c.q;
import c.t0;
import c.v;
import c.x0;
import com.google.android.material.resources.c;
import com.google.android.material.ripple.b;
import com.google.android.material.shape.e;
import com.google.android.material.shape.f;
import com.google.android.material.shape.j;
import com.google.android.material.shape.n;
import com.google.android.material.shape.o;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
class a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int f17287u = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final float f17289w = 1.5f;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int f17290x = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final MaterialCardView f17291a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m0
    private final j f17293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m0
    private final j f17294d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @q
    private int f17295e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @q
    private int f17296f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @q
    private int f17297g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @o0
    private Drawable f17298h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @o0
    private Drawable f17299i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @o0
    private ColorStateList f17300j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @o0
    private ColorStateList f17301k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @o0
    private o f17302l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @o0
    private ColorStateList f17303m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @o0
    private Drawable f17304n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @o0
    private LayerDrawable f17305o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @o0
    private j f17306p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @o0
    private j f17307q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f17309s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final int[] f17286t = {R.attr.state_checked};

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final double f17288v = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    private final Rect f17292b = new Rect();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f17308r = false;

    /* JADX INFO: renamed from: com.google.android.material.card.a$a, reason: collision with other inner class name */
    class C0192a extends InsetDrawable {
        C0192a(Drawable drawable, int i7, int i8, int i9, int i10) {
            super(drawable, i7, i8, i9, i10);
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumHeight() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumWidth() {
            return -1;
        }

        @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean getPadding(Rect rect) {
            return false;
        }
    }

    public a(@m0 MaterialCardView materialCardView, AttributeSet attributeSet, int i7, @b1 int i8) {
        this.f17291a = materialCardView;
        j jVar = new j(materialCardView.getContext(), attributeSet, i7, i8);
        this.f17293c = jVar;
        jVar.Y(materialCardView.getContext());
        jVar.u0(-12303292);
        o.b bVarV = jVar.getShapeAppearanceModel().v();
        TypedArray typedArrayObtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.CardView, i7, com.google.android.material.R.style.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(com.google.android.material.R.styleable.CardView_cardCornerRadius)) {
            bVarV.o(typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R.styleable.CardView_cardCornerRadius, 0.0f));
        }
        this.f17294d = new j();
        R(bVarV.m());
        typedArrayObtainStyledAttributes.recycle();
    }

    @m0
    private Drawable B(Drawable drawable) {
        int iCeil;
        int iCeil2;
        if (this.f17291a.getUseCompatPadding()) {
            iCeil2 = (int) Math.ceil(d());
            iCeil = (int) Math.ceil(c());
        } else {
            iCeil = 0;
            iCeil2 = 0;
        }
        return new C0192a(drawable, iCeil, iCeil2, iCeil, iCeil2);
    }

    private boolean V() {
        return this.f17291a.getPreventCornerOverlap() && !e();
    }

    private boolean W() {
        return this.f17291a.getPreventCornerOverlap() && e() && this.f17291a.getUseCompatPadding();
    }

    private float a() {
        return Math.max(Math.max(b(this.f17302l.q(), this.f17293c.R()), b(this.f17302l.s(), this.f17293c.S())), Math.max(b(this.f17302l.k(), this.f17293c.u()), b(this.f17302l.i(), this.f17293c.t())));
    }

    private void a0(Drawable drawable) {
        if (this.f17291a.getForeground() instanceof InsetDrawable) {
            ((InsetDrawable) this.f17291a.getForeground()).setDrawable(drawable);
        } else {
            this.f17291a.setForeground(B(drawable));
        }
    }

    private float b(e eVar, float f8) {
        if (eVar instanceof n) {
            return (float) ((1.0d - f17288v) * ((double) f8));
        }
        if (eVar instanceof f) {
            return f8 / 2.0f;
        }
        return 0.0f;
    }

    private float c() {
        return this.f17291a.getMaxCardElevation() + (W() ? a() : 0.0f);
    }

    private void c0() {
        Drawable drawable;
        if (b.f18164a && (drawable = this.f17304n) != null) {
            ((RippleDrawable) drawable).setColor(this.f17300j);
            return;
        }
        j jVar = this.f17306p;
        if (jVar != null) {
            jVar.n0(this.f17300j);
        }
    }

    private float d() {
        return (this.f17291a.getMaxCardElevation() * f17289w) + (W() ? a() : 0.0f);
    }

    private boolean e() {
        return this.f17293c.d0();
    }

    @m0
    private Drawable f() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = this.f17299i;
        if (drawable != null) {
            stateListDrawable.addState(f17286t, drawable);
        }
        return stateListDrawable;
    }

    @m0
    private Drawable g() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        j jVarI = i();
        this.f17306p = jVarI;
        jVarI.n0(this.f17300j);
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, this.f17306p);
        return stateListDrawable;
    }

    @m0
    private Drawable h() {
        if (!b.f18164a) {
            return g();
        }
        this.f17307q = i();
        return new RippleDrawable(this.f17300j, null, this.f17307q);
    }

    @m0
    private j i() {
        return new j(this.f17302l);
    }

    @m0
    private Drawable r() {
        if (this.f17304n == null) {
            this.f17304n = h();
        }
        if (this.f17305o == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.f17304n, this.f17294d, f()});
            this.f17305o = layerDrawable;
            layerDrawable.setId(2, com.google.android.material.R.id.mtrl_card_checked_layer_id);
        }
        return this.f17305o;
    }

    private float t() {
        if (this.f17291a.getPreventCornerOverlap() && this.f17291a.getUseCompatPadding()) {
            return (float) ((1.0d - f17288v) * ((double) this.f17291a.getCardViewRadius()));
        }
        return 0.0f;
    }

    @m0
    Rect A() {
        return this.f17292b;
    }

    boolean C() {
        return this.f17308r;
    }

    boolean D() {
        return this.f17309s;
    }

    void E(@m0 TypedArray typedArray) {
        ColorStateList colorStateListA = c.a(this.f17291a.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_strokeColor);
        this.f17303m = colorStateListA;
        if (colorStateListA == null) {
            this.f17303m = ColorStateList.valueOf(-1);
        }
        this.f17297g = typedArray.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialCardView_strokeWidth, 0);
        boolean z7 = typedArray.getBoolean(com.google.android.material.R.styleable.MaterialCardView_android_checkable, false);
        this.f17309s = z7;
        this.f17291a.setLongClickable(z7);
        this.f17301k = c.a(this.f17291a.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_checkedIconTint);
        K(c.d(this.f17291a.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_checkedIcon));
        M(typedArray.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialCardView_checkedIconSize, 0));
        L(typedArray.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialCardView_checkedIconMargin, 0));
        ColorStateList colorStateListA2 = c.a(this.f17291a.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_rippleColor);
        this.f17300j = colorStateListA2;
        if (colorStateListA2 == null) {
            this.f17300j = ColorStateList.valueOf(k1.a.d(this.f17291a, com.google.android.material.R.attr.colorControlHighlight));
        }
        I(c.a(this.f17291a.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_cardForegroundColor));
        c0();
        Z();
        d0();
        this.f17291a.setBackgroundInternal(B(this.f17293c));
        Drawable drawableR = this.f17291a.isClickable() ? r() : this.f17294d;
        this.f17298h = drawableR;
        this.f17291a.setForeground(B(drawableR));
    }

    void F(int i7, int i8) {
        int i9;
        int i10;
        if (this.f17305o != null) {
            int i11 = this.f17295e;
            int i12 = this.f17296f;
            int iCeil = (i7 - i11) - i12;
            int iCeil2 = (i8 - i11) - i12;
            if (this.f17291a.getUseCompatPadding()) {
                iCeil2 -= (int) Math.ceil(d() * 2.0f);
                iCeil -= (int) Math.ceil(c() * 2.0f);
            }
            int i13 = iCeil2;
            int i14 = this.f17295e;
            if (n2.Z(this.f17291a) == 1) {
                i10 = iCeil;
                i9 = i14;
            } else {
                i9 = iCeil;
                i10 = i14;
            }
            this.f17305o.setLayerInset(2, i9, this.f17295e, i10, i13);
        }
    }

    void G(boolean z7) {
        this.f17308r = z7;
    }

    void H(ColorStateList colorStateList) {
        this.f17293c.n0(colorStateList);
    }

    void I(@o0 ColorStateList colorStateList) {
        j jVar = this.f17294d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        jVar.n0(colorStateList);
    }

    void J(boolean z7) {
        this.f17309s = z7;
    }

    void K(@o0 Drawable drawable) {
        this.f17299i = drawable;
        if (drawable != null) {
            Drawable drawableR = d.r(drawable.mutate());
            this.f17299i = drawableR;
            d.o(drawableR, this.f17301k);
        }
        if (this.f17305o != null) {
            this.f17305o.setDrawableByLayerId(com.google.android.material.R.id.mtrl_card_checked_layer_id, f());
        }
    }

    void L(@q int i7) {
        this.f17295e = i7;
    }

    void M(@q int i7) {
        this.f17296f = i7;
    }

    void N(@o0 ColorStateList colorStateList) {
        this.f17301k = colorStateList;
        Drawable drawable = this.f17299i;
        if (drawable != null) {
            d.o(drawable, colorStateList);
        }
    }

    void O(float f8) {
        R(this.f17302l.w(f8));
        this.f17298h.invalidateSelf();
        if (W() || V()) {
            Y();
        }
        if (W()) {
            b0();
        }
    }

    void P(@v(from = 0.0d, to = 1.0d) float f8) {
        this.f17293c.o0(f8);
        j jVar = this.f17294d;
        if (jVar != null) {
            jVar.o0(f8);
        }
        j jVar2 = this.f17307q;
        if (jVar2 != null) {
            jVar2.o0(f8);
        }
    }

    void Q(@o0 ColorStateList colorStateList) {
        this.f17300j = colorStateList;
        c0();
    }

    void R(@m0 o oVar) {
        this.f17302l = oVar;
        this.f17293c.setShapeAppearanceModel(oVar);
        j jVar = this.f17293c;
        jVar.t0(!jVar.d0());
        j jVar2 = this.f17294d;
        if (jVar2 != null) {
            jVar2.setShapeAppearanceModel(oVar);
        }
        j jVar3 = this.f17307q;
        if (jVar3 != null) {
            jVar3.setShapeAppearanceModel(oVar);
        }
        j jVar4 = this.f17306p;
        if (jVar4 != null) {
            jVar4.setShapeAppearanceModel(oVar);
        }
    }

    void S(ColorStateList colorStateList) {
        if (this.f17303m == colorStateList) {
            return;
        }
        this.f17303m = colorStateList;
        d0();
    }

    void T(@q int i7) {
        if (i7 == this.f17297g) {
            return;
        }
        this.f17297g = i7;
        d0();
    }

    void U(int i7, int i8, int i9, int i10) {
        this.f17292b.set(i7, i8, i9, i10);
        Y();
    }

    void X() {
        Drawable drawable = this.f17298h;
        Drawable drawableR = this.f17291a.isClickable() ? r() : this.f17294d;
        this.f17298h = drawableR;
        if (drawable != drawableR) {
            a0(drawableR);
        }
    }

    void Y() {
        int iA = (int) ((V() || W() ? a() : 0.0f) - t());
        MaterialCardView materialCardView = this.f17291a;
        Rect rect = this.f17292b;
        materialCardView.l(rect.left + iA, rect.top + iA, rect.right + iA, rect.bottom + iA);
    }

    void Z() {
        this.f17293c.m0(this.f17291a.getCardElevation());
    }

    void b0() {
        if (!C()) {
            this.f17291a.setBackgroundInternal(B(this.f17293c));
        }
        this.f17291a.setForeground(B(this.f17298h));
    }

    void d0() {
        this.f17294d.D0(this.f17297g, this.f17303m);
    }

    @t0(api = 23)
    void j() {
        Drawable drawable = this.f17304n;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i7 = bounds.bottom;
            this.f17304n.setBounds(bounds.left, bounds.top, bounds.right, i7 - 1);
            this.f17304n.setBounds(bounds.left, bounds.top, bounds.right, i7);
        }
    }

    @m0
    j k() {
        return this.f17293c;
    }

    ColorStateList l() {
        return this.f17293c.y();
    }

    ColorStateList m() {
        return this.f17294d.y();
    }

    @o0
    Drawable n() {
        return this.f17299i;
    }

    @q
    int o() {
        return this.f17295e;
    }

    @q
    int p() {
        return this.f17296f;
    }

    @o0
    ColorStateList q() {
        return this.f17301k;
    }

    float s() {
        return this.f17293c.R();
    }

    @v(from = 0.0d, to = 1.0d)
    float u() {
        return this.f17293c.z();
    }

    @o0
    ColorStateList v() {
        return this.f17300j;
    }

    o w() {
        return this.f17302l;
    }

    @l
    int x() {
        ColorStateList colorStateList = this.f17303m;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    @o0
    ColorStateList y() {
        return this.f17303m;
    }

    @q
    int z() {
        return this.f17297g;
    }
}
