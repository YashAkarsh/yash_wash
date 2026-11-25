package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import androidx.appcompat.R;
import androidx.core.view.n2;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY})
class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.m0
    private final CheckedTextView f1813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ColorStateList f1814b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f1815c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1816d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f1817e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1818f;

    e(@c.m0 CheckedTextView checkedTextView) {
        this.f1813a = checkedTextView;
    }

    void a() {
        Drawable drawableA = androidx.core.widget.c.a(this.f1813a);
        if (drawableA != null) {
            if (this.f1816d || this.f1817e) {
                Drawable drawableMutate = androidx.core.graphics.drawable.d.r(drawableA).mutate();
                if (this.f1816d) {
                    androidx.core.graphics.drawable.d.o(drawableMutate, this.f1814b);
                }
                if (this.f1817e) {
                    androidx.core.graphics.drawable.d.p(drawableMutate, this.f1815c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f1813a.getDrawableState());
                }
                this.f1813a.setCheckMarkDrawable(drawableMutate);
            }
        }
    }

    ColorStateList b() {
        return this.f1814b;
    }

    PorterDuff.Mode c() {
        return this.f1815c;
    }

    void d(@c.o0 AttributeSet attributeSet, int i7) {
        boolean z7;
        int iU;
        int iU2;
        h1 h1VarG = h1.G(this.f1813a.getContext(), attributeSet, R.styleable.CheckedTextView, i7, 0);
        CheckedTextView checkedTextView = this.f1813a;
        n2.z1(checkedTextView, checkedTextView.getContext(), R.styleable.CheckedTextView, attributeSet, h1VarG.B(), i7, 0);
        try {
            if (!h1VarG.C(R.styleable.CheckedTextView_checkMarkCompat) || (iU2 = h1VarG.u(R.styleable.CheckedTextView_checkMarkCompat, 0)) == 0) {
                z7 = false;
            } else {
                try {
                    CheckedTextView checkedTextView2 = this.f1813a;
                    checkedTextView2.setCheckMarkDrawable(e.a.b(checkedTextView2.getContext(), iU2));
                    z7 = true;
                } catch (Resources.NotFoundException unused) {
                    z7 = false;
                }
            }
            if (!z7 && h1VarG.C(R.styleable.CheckedTextView_android_checkMark) && (iU = h1VarG.u(R.styleable.CheckedTextView_android_checkMark, 0)) != 0) {
                CheckedTextView checkedTextView3 = this.f1813a;
                checkedTextView3.setCheckMarkDrawable(e.a.b(checkedTextView3.getContext(), iU));
            }
            if (h1VarG.C(R.styleable.CheckedTextView_checkMarkTint)) {
                androidx.core.widget.c.d(this.f1813a, h1VarG.d(R.styleable.CheckedTextView_checkMarkTint));
            }
            if (h1VarG.C(R.styleable.CheckedTextView_checkMarkTintMode)) {
                androidx.core.widget.c.e(this.f1813a, k0.e(h1VarG.o(R.styleable.CheckedTextView_checkMarkTintMode, -1), null));
            }
        } finally {
            h1VarG.I();
        }
    }

    void e() {
        if (this.f1818f) {
            this.f1818f = false;
        } else {
            this.f1818f = true;
            a();
        }
    }

    void f(ColorStateList colorStateList) {
        this.f1814b = colorStateList;
        this.f1816d = true;
        a();
    }

    void g(@c.o0 PorterDuff.Mode mode) {
        this.f1815c = mode;
        this.f1817e = true;
        a();
    }
}
