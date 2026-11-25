package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R;
import androidx.core.view.n2;

/* JADX INFO: loaded from: classes.dex */
class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.m0
    private final View f1804a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private f1 f1807d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private f1 f1808e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private f1 f1809f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1806c = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f1805b = g.b();

    d(@c.m0 View view) {
        this.f1804a = view;
    }

    private boolean a(@c.m0 Drawable drawable) {
        if (this.f1809f == null) {
            this.f1809f = new f1();
        }
        f1 f1Var = this.f1809f;
        f1Var.a();
        ColorStateList colorStateListN = n2.N(this.f1804a);
        if (colorStateListN != null) {
            f1Var.f1832d = true;
            f1Var.f1829a = colorStateListN;
        }
        PorterDuff.Mode modeO = n2.O(this.f1804a);
        if (modeO != null) {
            f1Var.f1831c = true;
            f1Var.f1830b = modeO;
        }
        if (!f1Var.f1832d && !f1Var.f1831c) {
            return false;
        }
        g.j(drawable, f1Var, this.f1804a.getDrawableState());
        return true;
    }

    private boolean k() {
        return this.f1807d != null;
    }

    void b() {
        Drawable background = this.f1804a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            f1 f1Var = this.f1808e;
            if (f1Var != null) {
                g.j(background, f1Var, this.f1804a.getDrawableState());
                return;
            }
            f1 f1Var2 = this.f1807d;
            if (f1Var2 != null) {
                g.j(background, f1Var2, this.f1804a.getDrawableState());
            }
        }
    }

    ColorStateList c() {
        f1 f1Var = this.f1808e;
        if (f1Var != null) {
            return f1Var.f1829a;
        }
        return null;
    }

    PorterDuff.Mode d() {
        f1 f1Var = this.f1808e;
        if (f1Var != null) {
            return f1Var.f1830b;
        }
        return null;
    }

    void e(@c.o0 AttributeSet attributeSet, int i7) {
        h1 h1VarG = h1.G(this.f1804a.getContext(), attributeSet, R.styleable.ViewBackgroundHelper, i7, 0);
        View view = this.f1804a;
        n2.z1(view, view.getContext(), R.styleable.ViewBackgroundHelper, attributeSet, h1VarG.B(), i7, 0);
        try {
            if (h1VarG.C(R.styleable.ViewBackgroundHelper_android_background)) {
                this.f1806c = h1VarG.u(R.styleable.ViewBackgroundHelper_android_background, -1);
                ColorStateList colorStateListF = this.f1805b.f(this.f1804a.getContext(), this.f1806c);
                if (colorStateListF != null) {
                    h(colorStateListF);
                }
            }
            if (h1VarG.C(R.styleable.ViewBackgroundHelper_backgroundTint)) {
                n2.J1(this.f1804a, h1VarG.d(R.styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (h1VarG.C(R.styleable.ViewBackgroundHelper_backgroundTintMode)) {
                n2.K1(this.f1804a, k0.e(h1VarG.o(R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            h1VarG.I();
        }
    }

    void f(Drawable drawable) {
        this.f1806c = -1;
        h(null);
        b();
    }

    void g(int i7) {
        this.f1806c = i7;
        g gVar = this.f1805b;
        h(gVar != null ? gVar.f(this.f1804a.getContext(), i7) : null);
        b();
    }

    void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1807d == null) {
                this.f1807d = new f1();
            }
            f1 f1Var = this.f1807d;
            f1Var.f1829a = colorStateList;
            f1Var.f1832d = true;
        } else {
            this.f1807d = null;
        }
        b();
    }

    void i(ColorStateList colorStateList) {
        if (this.f1808e == null) {
            this.f1808e = new f1();
        }
        f1 f1Var = this.f1808e;
        f1Var.f1829a = colorStateList;
        f1Var.f1832d = true;
        b();
    }

    void j(PorterDuff.Mode mode) {
        if (this.f1808e == null) {
            this.f1808e = new f1();
        }
        f1 f1Var = this.f1808e;
        f1Var.f1830b = mode;
        f1Var.f1831c = true;
        b();
    }
}
