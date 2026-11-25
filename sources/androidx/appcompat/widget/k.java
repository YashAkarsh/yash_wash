package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R;
import androidx.core.view.n2;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.m0
    private final ImageView f1879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f1 f1880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private f1 f1881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private f1 f1882d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1883e = 0;

    public k(@c.m0 ImageView imageView) {
        this.f1879a = imageView;
    }

    private boolean a(@c.m0 Drawable drawable) {
        if (this.f1882d == null) {
            this.f1882d = new f1();
        }
        f1 f1Var = this.f1882d;
        f1Var.a();
        ColorStateList colorStateListA = androidx.core.widget.n.a(this.f1879a);
        if (colorStateListA != null) {
            f1Var.f1832d = true;
            f1Var.f1829a = colorStateListA;
        }
        PorterDuff.Mode modeB = androidx.core.widget.n.b(this.f1879a);
        if (modeB != null) {
            f1Var.f1831c = true;
            f1Var.f1830b = modeB;
        }
        if (!f1Var.f1832d && !f1Var.f1831c) {
            return false;
        }
        g.j(drawable, f1Var, this.f1879a.getDrawableState());
        return true;
    }

    private boolean m() {
        return this.f1880b != null;
    }

    void b() {
        if (this.f1879a.getDrawable() != null) {
            this.f1879a.getDrawable().setLevel(this.f1883e);
        }
    }

    void c() {
        Drawable drawable = this.f1879a.getDrawable();
        if (drawable != null) {
            k0.b(drawable);
        }
        if (drawable != null) {
            if (m() && a(drawable)) {
                return;
            }
            f1 f1Var = this.f1881c;
            if (f1Var != null) {
                g.j(drawable, f1Var, this.f1879a.getDrawableState());
                return;
            }
            f1 f1Var2 = this.f1880b;
            if (f1Var2 != null) {
                g.j(drawable, f1Var2, this.f1879a.getDrawableState());
            }
        }
    }

    ColorStateList d() {
        f1 f1Var = this.f1881c;
        if (f1Var != null) {
            return f1Var.f1829a;
        }
        return null;
    }

    PorterDuff.Mode e() {
        f1 f1Var = this.f1881c;
        if (f1Var != null) {
            return f1Var.f1830b;
        }
        return null;
    }

    boolean f() {
        return !(this.f1879a.getBackground() instanceof RippleDrawable);
    }

    public void g(AttributeSet attributeSet, int i7) {
        int iU;
        h1 h1VarG = h1.G(this.f1879a.getContext(), attributeSet, R.styleable.AppCompatImageView, i7, 0);
        ImageView imageView = this.f1879a;
        n2.z1(imageView, imageView.getContext(), R.styleable.AppCompatImageView, attributeSet, h1VarG.B(), i7, 0);
        try {
            Drawable drawable = this.f1879a.getDrawable();
            if (drawable == null && (iU = h1VarG.u(R.styleable.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = e.a.b(this.f1879a.getContext(), iU)) != null) {
                this.f1879a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                k0.b(drawable);
            }
            if (h1VarG.C(R.styleable.AppCompatImageView_tint)) {
                androidx.core.widget.n.c(this.f1879a, h1VarG.d(R.styleable.AppCompatImageView_tint));
            }
            if (h1VarG.C(R.styleable.AppCompatImageView_tintMode)) {
                androidx.core.widget.n.d(this.f1879a, k0.e(h1VarG.o(R.styleable.AppCompatImageView_tintMode, -1), null));
            }
        } finally {
            h1VarG.I();
        }
    }

    void h(@c.m0 Drawable drawable) {
        this.f1883e = drawable.getLevel();
    }

    public void i(int i7) {
        if (i7 != 0) {
            Drawable drawableB = e.a.b(this.f1879a.getContext(), i7);
            if (drawableB != null) {
                k0.b(drawableB);
            }
            this.f1879a.setImageDrawable(drawableB);
        } else {
            this.f1879a.setImageDrawable(null);
        }
        c();
    }

    void j(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1880b == null) {
                this.f1880b = new f1();
            }
            f1 f1Var = this.f1880b;
            f1Var.f1829a = colorStateList;
            f1Var.f1832d = true;
        } else {
            this.f1880b = null;
        }
        c();
    }

    void k(ColorStateList colorStateList) {
        if (this.f1881c == null) {
            this.f1881c = new f1();
        }
        f1 f1Var = this.f1881c;
        f1Var.f1829a = colorStateList;
        f1Var.f1832d = true;
        c();
    }

    void l(PorterDuff.Mode mode) {
        if (this.f1881c == null) {
            this.f1881c = new f1();
        }
        f1 f1Var = this.f1881c;
        f1Var.f1830b = mode;
        f1Var.f1831c = true;
        c();
    }
}
