package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.ToggleButton;
import androidx.core.view.j2;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatToggleButton extends ToggleButton implements j2, n0, androidx.core.widget.i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f1484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final t f1485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private i f1486c;

    public AppCompatToggleButton(@c.m0 Context context) {
        this(context, null);
    }

    @c.m0
    private i getEmojiTextViewHelper() {
        if (this.f1486c == null) {
            this.f1486c = new i(this);
        }
        return this.f1486c;
    }

    @Override // androidx.appcompat.widget.n0
    public boolean b() {
        return getEmojiTextViewHelper().b();
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f1484a;
        if (dVar != null) {
            dVar.b();
        }
        t tVar = this.f1485b;
        if (tVar != null) {
            tVar.b();
        }
    }

    @Override // androidx.core.view.j2
    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f1484a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.j2
    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1484a;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    @Override // androidx.core.widget.i0
    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1485b.j();
    }

    @Override // androidx.core.widget.i0
    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1485b.k();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z7) {
        super.setAllCaps(z7);
        getEmojiTextViewHelper().d(z7);
    }

    @Override // android.widget.ToggleButton, android.view.View
    public void setBackgroundDrawable(@c.o0 Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1484a;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@c.u int i7) {
        super.setBackgroundResource(i7);
        d dVar = this.f1484a;
        if (dVar != null) {
            dVar.g(i7);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@c.o0 Drawable drawable, @c.o0 Drawable drawable2, @c.o0 Drawable drawable3, @c.o0 Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        t tVar = this.f1485b;
        if (tVar != null) {
            tVar.p();
        }
    }

    @Override // android.widget.TextView
    @c.t0(17)
    public void setCompoundDrawablesRelative(@c.o0 Drawable drawable, @c.o0 Drawable drawable2, @c.o0 Drawable drawable3, @c.o0 Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        t tVar = this.f1485b;
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
        d dVar = this.f1484a;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.j2
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@c.o0 PorterDuff.Mode mode) {
        d dVar = this.f1484a;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    @Override // androidx.core.widget.i0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintList(@c.o0 ColorStateList colorStateList) {
        this.f1485b.w(colorStateList);
        this.f1485b.b();
    }

    @Override // androidx.core.widget.i0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintMode(@c.o0 PorterDuff.Mode mode) {
        this.f1485b.x(mode);
        this.f1485b.b();
    }

    public AppCompatToggleButton(@c.m0 Context context, @c.o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyleToggle);
    }

    public AppCompatToggleButton(@c.m0 Context context, @c.o0 AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        c1.a(this, getContext());
        d dVar = new d(this);
        this.f1484a = dVar;
        dVar.e(attributeSet, i7);
        t tVar = new t(this);
        this.f1485b = tVar;
        tVar.m(attributeSet, i7);
        getEmojiTextViewHelper().c(attributeSet, i7);
    }
}
