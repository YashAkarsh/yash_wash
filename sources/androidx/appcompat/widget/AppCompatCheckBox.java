package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.CheckBox;
import androidx.appcompat.R;
import androidx.core.view.j2;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatCheckBox extends CheckBox implements androidx.core.widget.h0, j2, n0, androidx.core.widget.i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f1418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f1419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final t f1420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private i f1421d;

    public AppCompatCheckBox(@c.m0 Context context) {
        this(context, null);
    }

    @c.m0
    private i getEmojiTextViewHelper() {
        if (this.f1421d == null) {
            this.f1421d = new i(this);
        }
        return this.f1421d;
    }

    @Override // androidx.appcompat.widget.n0
    public boolean b() {
        return getEmojiTextViewHelper().b();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f1419b;
        if (dVar != null) {
            dVar.b();
        }
        t tVar = this.f1420c;
        if (tVar != null) {
            tVar.b();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        f fVar = this.f1418a;
        return fVar != null ? fVar.b(compoundPaddingLeft) : compoundPaddingLeft;
    }

    @Override // androidx.core.view.j2
    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f1419b;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.j2
    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1419b;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    @Override // androidx.core.widget.h0
    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportButtonTintList() {
        f fVar = this.f1418a;
        if (fVar != null) {
            return fVar.c();
        }
        return null;
    }

    @Override // androidx.core.widget.h0
    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportButtonTintMode() {
        f fVar = this.f1418a;
        if (fVar != null) {
            return fVar.d();
        }
        return null;
    }

    @Override // androidx.core.widget.i0
    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1420c.j();
    }

    @Override // androidx.core.widget.i0
    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1420c.k();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z7) {
        super.setAllCaps(z7);
        getEmojiTextViewHelper().d(z7);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@c.o0 Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1419b;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@c.u int i7) {
        super.setBackgroundResource(i7);
        d dVar = this.f1419b;
        if (dVar != null) {
            dVar.g(i7);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        f fVar = this.f1418a;
        if (fVar != null) {
            fVar.f();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@c.o0 Drawable drawable, @c.o0 Drawable drawable2, @c.o0 Drawable drawable3, @c.o0 Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        t tVar = this.f1420c;
        if (tVar != null) {
            tVar.p();
        }
    }

    @Override // android.widget.TextView
    @c.t0(17)
    public void setCompoundDrawablesRelative(@c.o0 Drawable drawable, @c.o0 Drawable drawable2, @c.o0 Drawable drawable3, @c.o0 Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        t tVar = this.f1420c;
        if (tVar != null) {
            tVar.p();
        }
    }

    @Override // androidx.appcompat.widget.n0
    public void setEmojiCompatEnabled(boolean z7) {
        getEmojiTextViewHelper().e(z7);
    }

    @Override // android.widget.TextView
    public void setFilters(@c.m0 InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    @Override // androidx.core.view.j2
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@c.o0 ColorStateList colorStateList) {
        d dVar = this.f1419b;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.j2
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@c.o0 PorterDuff.Mode mode) {
        d dVar = this.f1419b;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    @Override // androidx.core.widget.h0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setSupportButtonTintList(@c.o0 ColorStateList colorStateList) {
        f fVar = this.f1418a;
        if (fVar != null) {
            fVar.g(colorStateList);
        }
    }

    @Override // androidx.core.widget.h0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setSupportButtonTintMode(@c.o0 PorterDuff.Mode mode) {
        f fVar = this.f1418a;
        if (fVar != null) {
            fVar.h(mode);
        }
    }

    @Override // androidx.core.widget.i0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintList(@c.o0 ColorStateList colorStateList) {
        this.f1420c.w(colorStateList);
        this.f1420c.b();
    }

    @Override // androidx.core.widget.i0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintMode(@c.o0 PorterDuff.Mode mode) {
        this.f1420c.x(mode);
        this.f1420c.b();
    }

    public AppCompatCheckBox(@c.m0 Context context, @c.o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkboxStyle);
    }

    public AppCompatCheckBox(@c.m0 Context context, @c.o0 AttributeSet attributeSet, int i7) {
        super(e1.b(context), attributeSet, i7);
        c1.a(this, getContext());
        f fVar = new f(this);
        this.f1418a = fVar;
        fVar.e(attributeSet, i7);
        d dVar = new d(this);
        this.f1419b = dVar;
        dVar.e(attributeSet, i7);
        t tVar = new t(this);
        this.f1420c = tVar;
        tVar.m(attributeSet, i7);
        getEmojiTextViewHelper().c(attributeSet, i7);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(@c.u int i7) {
        setButtonDrawable(e.a.b(getContext(), i7));
    }
}
