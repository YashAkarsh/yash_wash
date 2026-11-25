package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.appcompat.R;
import androidx.core.view.j2;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatCheckedTextView extends CheckedTextView implements androidx.core.widget.g0, j2, n0, androidx.core.widget.i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f1422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f1423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final t f1424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @c.m0
    private i f1425d;

    public AppCompatCheckedTextView(@c.m0 Context context) {
        this(context, null);
    }

    @c.m0
    private i getEmojiTextViewHelper() {
        if (this.f1425d == null) {
            this.f1425d = new i(this);
        }
        return this.f1425d;
    }

    @Override // androidx.appcompat.widget.n0
    public boolean b() {
        return getEmojiTextViewHelper().b();
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        t tVar = this.f1424c;
        if (tVar != null) {
            tVar.b();
        }
        d dVar = this.f1423b;
        if (dVar != null) {
            dVar.b();
        }
        e eVar = this.f1422a;
        if (eVar != null) {
            eVar.a();
        }
    }

    @Override // android.widget.TextView
    @c.o0
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.u.G(super.getCustomSelectionActionModeCallback());
    }

    @Override // androidx.core.view.j2
    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f1423b;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.j2
    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1423b;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    @Override // androidx.core.widget.g0
    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCheckMarkTintList() {
        e eVar = this.f1422a;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    @Override // androidx.core.widget.g0
    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        e eVar = this.f1422a;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // androidx.core.widget.i0
    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1424c.j();
    }

    @Override // androidx.core.widget.i0
    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1424c.k();
    }

    @Override // android.widget.TextView, android.view.View
    @c.o0
    public InputConnection onCreateInputConnection(@c.m0 EditorInfo editorInfo) {
        return j.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z7) {
        super.setAllCaps(z7);
        getEmojiTextViewHelper().d(z7);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@c.o0 Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1423b;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@c.u int i7) {
        super.setBackgroundResource(i7);
        d dVar = this.f1423b;
        if (dVar != null) {
            dVar.g(i7);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(@c.o0 Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        e eVar = this.f1422a;
        if (eVar != null) {
            eVar.e();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@c.o0 Drawable drawable, @c.o0 Drawable drawable2, @c.o0 Drawable drawable3, @c.o0 Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        t tVar = this.f1424c;
        if (tVar != null) {
            tVar.p();
        }
    }

    @Override // android.widget.TextView
    @c.t0(17)
    public void setCompoundDrawablesRelative(@c.o0 Drawable drawable, @c.o0 Drawable drawable2, @c.o0 Drawable drawable3, @c.o0 Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        t tVar = this.f1424c;
        if (tVar != null) {
            tVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(@c.o0 ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.u.H(this, callback));
    }

    @Override // androidx.appcompat.widget.n0
    public void setEmojiCompatEnabled(boolean z7) {
        getEmojiTextViewHelper().e(z7);
    }

    @Override // androidx.core.view.j2
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@c.o0 ColorStateList colorStateList) {
        d dVar = this.f1423b;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.j2
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@c.o0 PorterDuff.Mode mode) {
        d dVar = this.f1423b;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    @Override // androidx.core.widget.g0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setSupportCheckMarkTintList(@c.o0 ColorStateList colorStateList) {
        e eVar = this.f1422a;
        if (eVar != null) {
            eVar.f(colorStateList);
        }
    }

    @Override // androidx.core.widget.g0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setSupportCheckMarkTintMode(@c.o0 PorterDuff.Mode mode) {
        e eVar = this.f1422a;
        if (eVar != null) {
            eVar.g(mode);
        }
    }

    @Override // androidx.core.widget.i0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintList(@c.o0 ColorStateList colorStateList) {
        this.f1424c.w(colorStateList);
        this.f1424c.b();
    }

    @Override // androidx.core.widget.i0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintMode(@c.o0 PorterDuff.Mode mode) {
        this.f1424c.x(mode);
        this.f1424c.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(@c.m0 Context context, int i7) {
        super.setTextAppearance(context, i7);
        t tVar = this.f1424c;
        if (tVar != null) {
            tVar.q(context, i7);
        }
    }

    public AppCompatCheckedTextView(@c.m0 Context context, @c.o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkedTextViewStyle);
    }

    public AppCompatCheckedTextView(@c.m0 Context context, @c.o0 AttributeSet attributeSet, int i7) {
        super(e1.b(context), attributeSet, i7);
        c1.a(this, getContext());
        t tVar = new t(this);
        this.f1424c = tVar;
        tVar.m(attributeSet, i7);
        tVar.b();
        d dVar = new d(this);
        this.f1423b = dVar;
        dVar.e(attributeSet, i7);
        e eVar = new e(this);
        this.f1422a = eVar;
        eVar.d(attributeSet, i7);
        getEmojiTextViewHelper().c(attributeSet, i7);
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(@c.u int i7) {
        setCheckMarkDrawable(e.a.b(getContext(), i7));
    }
}
