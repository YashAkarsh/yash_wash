package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.appcompat.R;
import androidx.core.view.j2;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatButton extends Button implements j2, androidx.core.widget.b, androidx.core.widget.i0, n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f1415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final t f1416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c.m0
    private i f1417c;

    public AppCompatButton(@c.m0 Context context) {
        this(context, null);
    }

    @c.m0
    private i getEmojiTextViewHelper() {
        if (this.f1417c == null) {
            this.f1417c = new i(this);
        }
        return this.f1417c;
    }

    @Override // androidx.appcompat.widget.n0
    public boolean b() {
        return getEmojiTextViewHelper().b();
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f1415a;
        if (dVar != null) {
            dVar.b();
        }
        t tVar = this.f1416b;
        if (tVar != null) {
            tVar.b();
        }
    }

    @Override // android.widget.TextView, androidx.core.widget.b
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeMaxTextSize() {
        if (androidx.core.widget.b.f7024a0) {
            return super.getAutoSizeMaxTextSize();
        }
        t tVar = this.f1416b;
        if (tVar != null) {
            return tVar.e();
        }
        return -1;
    }

    @Override // android.widget.TextView, androidx.core.widget.b
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeMinTextSize() {
        if (androidx.core.widget.b.f7024a0) {
            return super.getAutoSizeMinTextSize();
        }
        t tVar = this.f1416b;
        if (tVar != null) {
            return tVar.f();
        }
        return -1;
    }

    @Override // android.widget.TextView, androidx.core.widget.b
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeStepGranularity() {
        if (androidx.core.widget.b.f7024a0) {
            return super.getAutoSizeStepGranularity();
        }
        t tVar = this.f1416b;
        if (tVar != null) {
            return tVar.g();
        }
        return -1;
    }

    @Override // android.widget.TextView, androidx.core.widget.b
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public int[] getAutoSizeTextAvailableSizes() {
        if (androidx.core.widget.b.f7024a0) {
            return super.getAutoSizeTextAvailableSizes();
        }
        t tVar = this.f1416b;
        return tVar != null ? tVar.h() : new int[0];
    }

    @Override // android.widget.TextView, androidx.core.widget.b
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (androidx.core.widget.b.f7024a0) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        t tVar = this.f1416b;
        if (tVar != null) {
            return tVar.i();
        }
        return 0;
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
        d dVar = this.f1415a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.j2
    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1415a;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    @Override // androidx.core.widget.i0
    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1416b.j();
    }

    @Override // androidx.core.widget.i0
    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1416b.k();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        super.onLayout(z7, i7, i8, i9, i10);
        t tVar = this.f1416b;
        if (tVar != null) {
            tVar.o(z7, i7, i8, i9, i10);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        super.onTextChanged(charSequence, i7, i8, i9);
        t tVar = this.f1416b;
        if (tVar == null || androidx.core.widget.b.f7024a0 || !tVar.l()) {
            return;
        }
        this.f1416b.c();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z7) {
        super.setAllCaps(z7);
        getEmojiTextViewHelper().d(z7);
    }

    @Override // android.widget.TextView, androidx.core.widget.b
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeUniformWithConfiguration(int i7, int i8, int i9, int i10) throws IllegalArgumentException {
        if (androidx.core.widget.b.f7024a0) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i7, i8, i9, i10);
            return;
        }
        t tVar = this.f1416b;
        if (tVar != null) {
            tVar.t(i7, i8, i9, i10);
        }
    }

    @Override // android.widget.TextView, androidx.core.widget.b
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeUniformWithPresetSizes(@c.m0 int[] iArr, int i7) throws IllegalArgumentException {
        if (androidx.core.widget.b.f7024a0) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i7);
            return;
        }
        t tVar = this.f1416b;
        if (tVar != null) {
            tVar.u(iArr, i7);
        }
    }

    @Override // android.widget.TextView, androidx.core.widget.b
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeWithDefaults(int i7) {
        if (androidx.core.widget.b.f7024a0) {
            super.setAutoSizeTextTypeWithDefaults(i7);
            return;
        }
        t tVar = this.f1416b;
        if (tVar != null) {
            tVar.v(i7);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@c.o0 Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1415a;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@c.u int i7) {
        super.setBackgroundResource(i7);
        d dVar = this.f1415a;
        if (dVar != null) {
            dVar.g(i7);
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

    @Override // android.widget.TextView
    public void setFilters(@c.m0 InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z7) {
        t tVar = this.f1416b;
        if (tVar != null) {
            tVar.s(z7);
        }
    }

    @Override // androidx.core.view.j2
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@c.o0 ColorStateList colorStateList) {
        d dVar = this.f1415a;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.j2
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@c.o0 PorterDuff.Mode mode) {
        d dVar = this.f1415a;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    @Override // androidx.core.widget.i0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintList(@c.o0 ColorStateList colorStateList) {
        this.f1416b.w(colorStateList);
        this.f1416b.b();
    }

    @Override // androidx.core.widget.i0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintMode(@c.o0 PorterDuff.Mode mode) {
        this.f1416b.x(mode);
        this.f1416b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i7) {
        super.setTextAppearance(context, i7);
        t tVar = this.f1416b;
        if (tVar != null) {
            tVar.q(context, i7);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i7, float f8) {
        if (androidx.core.widget.b.f7024a0) {
            super.setTextSize(i7, f8);
            return;
        }
        t tVar = this.f1416b;
        if (tVar != null) {
            tVar.A(i7, f8);
        }
    }

    public AppCompatButton(@c.m0 Context context, @c.o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyle);
    }

    public AppCompatButton(@c.m0 Context context, @c.o0 AttributeSet attributeSet, int i7) {
        super(e1.b(context), attributeSet, i7);
        c1.a(this, getContext());
        d dVar = new d(this);
        this.f1415a = dVar;
        dVar.e(attributeSet, i7);
        t tVar = new t(this);
        this.f1416b = tVar;
        tVar.m(attributeSet, i7);
        tVar.b();
        getEmojiTextViewHelper().c(attributeSet, i7);
    }
}
