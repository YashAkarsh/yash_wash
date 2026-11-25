package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.graphics.q2;
import androidx.core.view.j2;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatTextView extends TextView implements j2, androidx.core.widget.i0, androidx.core.widget.b, n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f1478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final t f1479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final s f1480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @c.m0
    private i f1481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f1482e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @c.o0
    private Future<androidx.core.text.i0> f1483f;

    public AppCompatTextView(@c.m0 Context context) {
        this(context, null);
    }

    private void e() {
        Future<androidx.core.text.i0> future = this.f1483f;
        if (future != null) {
            try {
                this.f1483f = null;
                androidx.core.widget.u.D(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @c.m0
    private i getEmojiTextViewHelper() {
        if (this.f1481d == null) {
            this.f1481d = new i(this);
        }
        return this.f1481d;
    }

    @Override // androidx.appcompat.widget.n0
    public boolean b() {
        return getEmojiTextViewHelper().b();
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f1478a;
        if (dVar != null) {
            dVar.b();
        }
        t tVar = this.f1479b;
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
        t tVar = this.f1479b;
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
        t tVar = this.f1479b;
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
        t tVar = this.f1479b;
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
        t tVar = this.f1479b;
        return tVar != null ? tVar.h() : new int[0];
    }

    @Override // android.widget.TextView, androidx.core.widget.b
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (androidx.core.widget.b.f7024a0) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        t tVar = this.f1479b;
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

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return androidx.core.widget.u.i(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return androidx.core.widget.u.j(this);
    }

    @Override // androidx.core.view.j2
    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f1478a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.j2
    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1478a;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    @Override // androidx.core.widget.i0
    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1479b.j();
    }

    @Override // androidx.core.widget.i0
    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1479b.k();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        e();
        return super.getText();
    }

    @Override // android.widget.TextView
    @c.t0(api = 26)
    @c.m0
    public TextClassifier getTextClassifier() {
        s sVar;
        return (Build.VERSION.SDK_INT >= 28 || (sVar = this.f1480c) == null) ? super.getTextClassifier() : sVar.a();
    }

    @c.m0
    public androidx.core.text.i0.a getTextMetricsParamsCompat() {
        return androidx.core.widget.u.o(this);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f1479b.r(this, inputConnectionOnCreateInputConnection, editorInfo);
        return j.a(inputConnectionOnCreateInputConnection, editorInfo, this);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        super.onLayout(z7, i7, i8, i9, i10);
        t tVar = this.f1479b;
        if (tVar != null) {
            tVar.o(z7, i7, i8, i9, i10);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i7, int i8) {
        e();
        super.onMeasure(i7, i8);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        super.onTextChanged(charSequence, i7, i8, i9);
        t tVar = this.f1479b;
        if (tVar == null || androidx.core.widget.b.f7024a0 || !tVar.l()) {
            return;
        }
        this.f1479b.c();
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
        t tVar = this.f1479b;
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
        t tVar = this.f1479b;
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
        t tVar = this.f1479b;
        if (tVar != null) {
            tVar.v(i7);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@c.o0 Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1478a;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@c.u int i7) {
        super.setBackgroundResource(i7);
        d dVar = this.f1478a;
        if (dVar != null) {
            dVar.g(i7);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@c.o0 Drawable drawable, @c.o0 Drawable drawable2, @c.o0 Drawable drawable3, @c.o0 Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        t tVar = this.f1479b;
        if (tVar != null) {
            tVar.p();
        }
    }

    @Override // android.widget.TextView
    @c.t0(17)
    public void setCompoundDrawablesRelative(@c.o0 Drawable drawable, @c.o0 Drawable drawable2, @c.o0 Drawable drawable3, @c.o0 Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        t tVar = this.f1479b;
        if (tVar != null) {
            tVar.p();
        }
    }

    @Override // android.widget.TextView
    @c.t0(17)
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@c.o0 Drawable drawable, @c.o0 Drawable drawable2, @c.o0 Drawable drawable3, @c.o0 Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        t tVar = this.f1479b;
        if (tVar != null) {
            tVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@c.o0 Drawable drawable, @c.o0 Drawable drawable2, @c.o0 Drawable drawable3, @c.o0 Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        t tVar = this.f1479b;
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

    @Override // android.widget.TextView
    public void setFilters(@c.m0 InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(@c.e0(from = 0) @c.r0 int i7) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i7);
        } else {
            androidx.core.widget.u.A(this, i7);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(@c.e0(from = 0) @c.r0 int i7) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i7);
        } else {
            androidx.core.widget.u.B(this, i7);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(@c.e0(from = 0) @c.r0 int i7) {
        androidx.core.widget.u.C(this, i7);
    }

    public void setPrecomputedText(@c.m0 androidx.core.text.i0 i0Var) {
        androidx.core.widget.u.D(this, i0Var);
    }

    @Override // androidx.core.view.j2
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@c.o0 ColorStateList colorStateList) {
        d dVar = this.f1478a;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.j2
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@c.o0 PorterDuff.Mode mode) {
        d dVar = this.f1478a;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    @Override // androidx.core.widget.i0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintList(@c.o0 ColorStateList colorStateList) {
        this.f1479b.w(colorStateList);
        this.f1479b.b();
    }

    @Override // androidx.core.widget.i0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintMode(@c.o0 PorterDuff.Mode mode) {
        this.f1479b.x(mode);
        this.f1479b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i7) {
        super.setTextAppearance(context, i7);
        t tVar = this.f1479b;
        if (tVar != null) {
            tVar.q(context, i7);
        }
    }

    @Override // android.widget.TextView
    @c.t0(api = 26)
    public void setTextClassifier(@c.o0 TextClassifier textClassifier) {
        s sVar;
        if (Build.VERSION.SDK_INT >= 28 || (sVar = this.f1480c) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            sVar.b(textClassifier);
        }
    }

    public void setTextFuture(@c.o0 Future<androidx.core.text.i0> future) {
        this.f1483f = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(@c.m0 androidx.core.text.i0.a aVar) {
        androidx.core.widget.u.F(this, aVar);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i7, float f8) {
        if (androidx.core.widget.b.f7024a0) {
            super.setTextSize(i7, f8);
            return;
        }
        t tVar = this.f1479b;
        if (tVar != null) {
            tVar.A(i7, f8);
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(@c.o0 Typeface typeface, int i7) {
        if (this.f1482e) {
            return;
        }
        Typeface typefaceB = (typeface == null || i7 <= 0) ? null : q2.b(getContext(), typeface, i7);
        this.f1482e = true;
        if (typefaceB != null) {
            typeface = typefaceB;
        }
        try {
            super.setTypeface(typeface, i7);
        } finally {
            this.f1482e = false;
        }
    }

    public AppCompatTextView(@c.m0 Context context, @c.o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public AppCompatTextView(@c.m0 Context context, @c.o0 AttributeSet attributeSet, int i7) {
        super(e1.b(context), attributeSet, i7);
        this.f1482e = false;
        c1.a(this, getContext());
        d dVar = new d(this);
        this.f1478a = dVar;
        dVar.e(attributeSet, i7);
        t tVar = new t(this);
        this.f1479b = tVar;
        tVar.m(attributeSet, i7);
        tVar.b();
        this.f1480c = new s(this);
        getEmojiTextViewHelper().c(attributeSet, i7);
    }

    @Override // android.widget.TextView
    @c.t0(17)
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i7, int i8, int i9, int i10) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i7 != 0 ? e.a.b(context, i7) : null, i8 != 0 ? e.a.b(context, i8) : null, i9 != 0 ? e.a.b(context, i9) : null, i10 != 0 ? e.a.b(context, i10) : null);
        t tVar = this.f1479b;
        if (tVar != null) {
            tVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i7, int i8, int i9, int i10) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i7 != 0 ? e.a.b(context, i7) : null, i8 != 0 ? e.a.b(context, i8) : null, i9 != 0 ? e.a.b(context, i9) : null, i10 != 0 ? e.a.b(context, i10) : null);
        t tVar = this.f1479b;
        if (tVar != null) {
            tVar.p();
        }
    }
}
