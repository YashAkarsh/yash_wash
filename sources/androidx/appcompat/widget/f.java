package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.R;
import androidx.core.view.n2;

/* JADX INFO: loaded from: classes.dex */
class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.m0
    private final CompoundButton f1823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ColorStateList f1824b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f1825c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1826d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f1827e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1828f;

    f(@c.m0 CompoundButton compoundButton) {
        this.f1823a = compoundButton;
    }

    void a() {
        Drawable drawableA = androidx.core.widget.d.a(this.f1823a);
        if (drawableA != null) {
            if (this.f1826d || this.f1827e) {
                Drawable drawableMutate = androidx.core.graphics.drawable.d.r(drawableA).mutate();
                if (this.f1826d) {
                    androidx.core.graphics.drawable.d.o(drawableMutate, this.f1824b);
                }
                if (this.f1827e) {
                    androidx.core.graphics.drawable.d.p(drawableMutate, this.f1825c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f1823a.getDrawableState());
                }
                this.f1823a.setButtonDrawable(drawableMutate);
            }
        }
    }

    int b(int i7) {
        return i7;
    }

    ColorStateList c() {
        return this.f1824b;
    }

    PorterDuff.Mode d() {
        return this.f1825c;
    }

    void e(@c.o0 AttributeSet attributeSet, int i7) {
        boolean z7;
        int iU;
        int iU2;
        h1 h1VarG = h1.G(this.f1823a.getContext(), attributeSet, R.styleable.CompoundButton, i7, 0);
        CompoundButton compoundButton = this.f1823a;
        n2.z1(compoundButton, compoundButton.getContext(), R.styleable.CompoundButton, attributeSet, h1VarG.B(), i7, 0);
        try {
            if (!h1VarG.C(R.styleable.CompoundButton_buttonCompat) || (iU2 = h1VarG.u(R.styleable.CompoundButton_buttonCompat, 0)) == 0) {
                z7 = false;
            } else {
                try {
                    CompoundButton compoundButton2 = this.f1823a;
                    compoundButton2.setButtonDrawable(e.a.b(compoundButton2.getContext(), iU2));
                    z7 = true;
                } catch (Resources.NotFoundException unused) {
                    z7 = false;
                }
            }
            if (!z7 && h1VarG.C(R.styleable.CompoundButton_android_button) && (iU = h1VarG.u(R.styleable.CompoundButton_android_button, 0)) != 0) {
                CompoundButton compoundButton3 = this.f1823a;
                compoundButton3.setButtonDrawable(e.a.b(compoundButton3.getContext(), iU));
            }
            if (h1VarG.C(R.styleable.CompoundButton_buttonTint)) {
                androidx.core.widget.d.d(this.f1823a, h1VarG.d(R.styleable.CompoundButton_buttonTint));
            }
            if (h1VarG.C(R.styleable.CompoundButton_buttonTintMode)) {
                androidx.core.widget.d.e(this.f1823a, k0.e(h1VarG.o(R.styleable.CompoundButton_buttonTintMode, -1), null));
            }
        } finally {
            h1VarG.I();
        }
    }

    void f() {
        if (this.f1828f) {
            this.f1828f = false;
        } else {
            this.f1828f = true;
            a();
        }
    }

    void g(ColorStateList colorStateList) {
        this.f1824b = colorStateList;
        this.f1826d = true;
        a();
    }

    void h(@c.o0 PorterDuff.Mode mode) {
        this.f1825c = mode;
        this.f1827e = true;
        a();
    }
}
