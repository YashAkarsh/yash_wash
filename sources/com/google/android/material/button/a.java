package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import androidx.core.graphics.drawable.d;
import androidx.core.view.n2;
import c.m0;
import c.o0;
import c.q;
import c.x0;
import com.google.android.material.R;
import com.google.android.material.internal.v;
import com.google.android.material.resources.c;
import com.google.android.material.ripple.b;
import com.google.android.material.shape.j;
import com.google.android.material.shape.o;
import com.google.android.material.shape.s;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
class a {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final boolean f17255t = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaterialButton f17256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    private o f17257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f17258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f17259d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f17260e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f17261f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f17262g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f17263h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @o0
    private PorterDuff.Mode f17264i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @o0
    private ColorStateList f17265j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @o0
    private ColorStateList f17266k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @o0
    private ColorStateList f17267l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @o0
    private Drawable f17268m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f17269n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f17270o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f17271p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f17272q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private LayerDrawable f17273r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f17274s;

    a(MaterialButton materialButton, @m0 o oVar) {
        this.f17256a = materialButton;
        this.f17257b = oVar;
    }

    private void E(@q int i7, @q int i8) {
        int iK0 = n2.k0(this.f17256a);
        int paddingTop = this.f17256a.getPaddingTop();
        int iJ0 = n2.j0(this.f17256a);
        int paddingBottom = this.f17256a.getPaddingBottom();
        int i9 = this.f17260e;
        int i10 = this.f17261f;
        this.f17261f = i8;
        this.f17260e = i7;
        if (!this.f17270o) {
            F();
        }
        n2.d2(this.f17256a, iK0, (paddingTop + i7) - i9, iJ0, (paddingBottom + i8) - i10);
    }

    private void F() {
        this.f17256a.setInternalBackground(a());
        j jVarF = f();
        if (jVarF != null) {
            jVarF.m0(this.f17274s);
        }
    }

    private void G(@m0 o oVar) {
        if (f() != null) {
            f().setShapeAppearanceModel(oVar);
        }
        if (n() != null) {
            n().setShapeAppearanceModel(oVar);
        }
        if (e() != null) {
            e().setShapeAppearanceModel(oVar);
        }
    }

    private void I() {
        j jVarF = f();
        j jVarN = n();
        if (jVarF != null) {
            jVarF.D0(this.f17263h, this.f17266k);
            if (jVarN != null) {
                jVarN.C0(this.f17263h, this.f17269n ? k1.a.d(this.f17256a, R.attr.colorSurface) : 0);
            }
        }
    }

    @m0
    private InsetDrawable J(Drawable drawable) {
        return new InsetDrawable(drawable, this.f17258c, this.f17260e, this.f17259d, this.f17261f);
    }

    private Drawable a() {
        j jVar = new j(this.f17257b);
        jVar.Y(this.f17256a.getContext());
        d.o(jVar, this.f17265j);
        PorterDuff.Mode mode = this.f17264i;
        if (mode != null) {
            d.p(jVar, mode);
        }
        jVar.D0(this.f17263h, this.f17266k);
        j jVar2 = new j(this.f17257b);
        jVar2.setTint(0);
        jVar2.C0(this.f17263h, this.f17269n ? k1.a.d(this.f17256a, R.attr.colorSurface) : 0);
        if (f17255t) {
            j jVar3 = new j(this.f17257b);
            this.f17268m = jVar3;
            d.n(jVar3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(b.d(this.f17267l), J(new LayerDrawable(new Drawable[]{jVar2, jVar})), this.f17268m);
            this.f17273r = rippleDrawable;
            return rippleDrawable;
        }
        com.google.android.material.ripple.a aVar = new com.google.android.material.ripple.a(this.f17257b);
        this.f17268m = aVar;
        d.o(aVar, b.d(this.f17267l));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{jVar2, jVar, this.f17268m});
        this.f17273r = layerDrawable;
        return J(layerDrawable);
    }

    @o0
    private j g(boolean z7) {
        LayerDrawable layerDrawable = this.f17273r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return f17255t ? (j) ((LayerDrawable) ((InsetDrawable) this.f17273r.getDrawable(0)).getDrawable()).getDrawable(!z7 ? 1 : 0) : (j) this.f17273r.getDrawable(!z7 ? 1 : 0);
    }

    @o0
    private j n() {
        return g(true);
    }

    void A(@o0 ColorStateList colorStateList) {
        if (this.f17266k != colorStateList) {
            this.f17266k = colorStateList;
            I();
        }
    }

    void B(int i7) {
        if (this.f17263h != i7) {
            this.f17263h = i7;
            I();
        }
    }

    void C(@o0 ColorStateList colorStateList) {
        if (this.f17265j != colorStateList) {
            this.f17265j = colorStateList;
            if (f() != null) {
                d.o(f(), this.f17265j);
            }
        }
    }

    void D(@o0 PorterDuff.Mode mode) {
        if (this.f17264i != mode) {
            this.f17264i = mode;
            if (f() == null || this.f17264i == null) {
                return;
            }
            d.p(f(), this.f17264i);
        }
    }

    void H(int i7, int i8) {
        Drawable drawable = this.f17268m;
        if (drawable != null) {
            drawable.setBounds(this.f17258c, this.f17260e, i8 - this.f17259d, i7 - this.f17261f);
        }
    }

    int b() {
        return this.f17262g;
    }

    public int c() {
        return this.f17261f;
    }

    public int d() {
        return this.f17260e;
    }

    @o0
    public s e() {
        LayerDrawable layerDrawable = this.f17273r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.f17273r.getNumberOfLayers() > 2 ? (s) this.f17273r.getDrawable(2) : (s) this.f17273r.getDrawable(1);
    }

    @o0
    j f() {
        return g(false);
    }

    @o0
    ColorStateList h() {
        return this.f17267l;
    }

    @m0
    o i() {
        return this.f17257b;
    }

    @o0
    ColorStateList j() {
        return this.f17266k;
    }

    int k() {
        return this.f17263h;
    }

    ColorStateList l() {
        return this.f17265j;
    }

    PorterDuff.Mode m() {
        return this.f17264i;
    }

    boolean o() {
        return this.f17270o;
    }

    boolean p() {
        return this.f17272q;
    }

    void q(@m0 TypedArray typedArray) {
        this.f17258c = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetLeft, 0);
        this.f17259d = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetRight, 0);
        this.f17260e = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetTop, 0);
        this.f17261f = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetBottom, 0);
        if (typedArray.hasValue(R.styleable.MaterialButton_cornerRadius)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_cornerRadius, -1);
            this.f17262g = dimensionPixelSize;
            y(this.f17257b.w(dimensionPixelSize));
            this.f17271p = true;
        }
        this.f17263h = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_strokeWidth, 0);
        this.f17264i = v.k(typedArray.getInt(R.styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f17265j = c.a(this.f17256a.getContext(), typedArray, R.styleable.MaterialButton_backgroundTint);
        this.f17266k = c.a(this.f17256a.getContext(), typedArray, R.styleable.MaterialButton_strokeColor);
        this.f17267l = c.a(this.f17256a.getContext(), typedArray, R.styleable.MaterialButton_rippleColor);
        this.f17272q = typedArray.getBoolean(R.styleable.MaterialButton_android_checkable, false);
        this.f17274s = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_elevation, 0);
        int iK0 = n2.k0(this.f17256a);
        int paddingTop = this.f17256a.getPaddingTop();
        int iJ0 = n2.j0(this.f17256a);
        int paddingBottom = this.f17256a.getPaddingBottom();
        if (typedArray.hasValue(R.styleable.MaterialButton_android_background)) {
            s();
        } else {
            F();
        }
        n2.d2(this.f17256a, iK0 + this.f17258c, paddingTop + this.f17260e, iJ0 + this.f17259d, paddingBottom + this.f17261f);
    }

    void r(int i7) {
        if (f() != null) {
            f().setTint(i7);
        }
    }

    void s() {
        this.f17270o = true;
        this.f17256a.setSupportBackgroundTintList(this.f17265j);
        this.f17256a.setSupportBackgroundTintMode(this.f17264i);
    }

    void t(boolean z7) {
        this.f17272q = z7;
    }

    void u(int i7) {
        if (this.f17271p && this.f17262g == i7) {
            return;
        }
        this.f17262g = i7;
        this.f17271p = true;
        y(this.f17257b.w(i7));
    }

    public void v(@q int i7) {
        E(this.f17260e, i7);
    }

    public void w(@q int i7) {
        E(i7, this.f17261f);
    }

    void x(@o0 ColorStateList colorStateList) {
        if (this.f17267l != colorStateList) {
            this.f17267l = colorStateList;
            boolean z7 = f17255t;
            if (z7 && (this.f17256a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f17256a.getBackground()).setColor(b.d(colorStateList));
            } else {
                if (z7 || !(this.f17256a.getBackground() instanceof com.google.android.material.ripple.a)) {
                    return;
                }
                ((com.google.android.material.ripple.a) this.f17256a.getBackground()).setTintList(b.d(colorStateList));
            }
        }
    }

    void y(@m0 o oVar) {
        this.f17257b = oVar;
        G(oVar);
    }

    void z(boolean z7) {
        this.f17269n = z7;
        I();
    }
}
