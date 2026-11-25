package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import androidx.appcompat.R;
import androidx.core.view.b2;
import androidx.core.view.j2;
import androidx.core.view.n2;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatEditText extends EditText implements j2, b2, n0, androidx.core.widget.i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f1426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final t f1427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final s f1428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final androidx.core.widget.f0 f1429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @c.m0
    private final h f1430e;

    public AppCompatEditText(@c.m0 Context context) {
        this(context, null);
    }

    @Override // androidx.core.view.b2
    @c.o0
    public androidx.core.view.k a(@c.m0 androidx.core.view.k kVar) {
        return this.f1429d.a(this, kVar);
    }

    @Override // androidx.appcompat.widget.n0
    public boolean b() {
        return this.f1430e.c();
    }

    void c(h hVar) {
        KeyListener keyListener = getKeyListener();
        if (hVar.b(keyListener)) {
            boolean zIsFocusable = super.isFocusable();
            boolean zIsClickable = super.isClickable();
            boolean zIsLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener keyListenerA = hVar.a(keyListener);
            if (keyListenerA == keyListener) {
                return;
            }
            super.setKeyListener(keyListenerA);
            super.setRawInputType(inputType);
            super.setFocusable(zIsFocusable);
            super.setClickable(zIsClickable);
            super.setLongClickable(zIsLongClickable);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f1426a;
        if (dVar != null) {
            dVar.b();
        }
        t tVar = this.f1427b;
        if (tVar != null) {
            tVar.b();
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
        d dVar = this.f1426a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.j2
    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1426a;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    @Override // androidx.core.widget.i0
    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1427b.j();
    }

    @Override // androidx.core.widget.i0
    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1427b.k();
    }

    @Override // android.widget.TextView
    @c.t0(api = 26)
    @c.m0
    public TextClassifier getTextClassifier() {
        s sVar;
        return (Build.VERSION.SDK_INT >= 28 || (sVar = this.f1428c) == null) ? super.getTextClassifier() : sVar.a();
    }

    @Override // android.widget.TextView, android.view.View
    @c.o0
    public InputConnection onCreateInputConnection(@c.m0 EditorInfo editorInfo) {
        String[] strArrH0;
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f1427b.r(this, inputConnectionOnCreateInputConnection, editorInfo);
        InputConnection inputConnectionA = j.a(inputConnectionOnCreateInputConnection, editorInfo, this);
        if (inputConnectionA != null && Build.VERSION.SDK_INT <= 30 && (strArrH0 = n2.h0(this)) != null) {
            androidx.core.view.inputmethod.g.h(editorInfo, strArrH0);
            inputConnectionA = androidx.core.view.inputmethod.j.d(this, inputConnectionA, editorInfo);
        }
        return this.f1430e.e(inputConnectionA, editorInfo);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onDragEvent(DragEvent dragEvent) {
        if (n.a(this, dragEvent)) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i7) {
        if (n.b(this, i7)) {
            return true;
        }
        return super.onTextContextMenuItem(i7);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@c.o0 Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1426a;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@c.u int i7) {
        super.setBackgroundResource(i7);
        d dVar = this.f1426a;
        if (dVar != null) {
            dVar.g(i7);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@c.o0 Drawable drawable, @c.o0 Drawable drawable2, @c.o0 Drawable drawable3, @c.o0 Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        t tVar = this.f1427b;
        if (tVar != null) {
            tVar.p();
        }
    }

    @Override // android.widget.TextView
    @c.t0(17)
    public void setCompoundDrawablesRelative(@c.o0 Drawable drawable, @c.o0 Drawable drawable2, @c.o0 Drawable drawable3, @c.o0 Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        t tVar = this.f1427b;
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
        this.f1430e.f(z7);
    }

    @Override // android.widget.TextView
    public void setKeyListener(@c.o0 KeyListener keyListener) {
        super.setKeyListener(this.f1430e.a(keyListener));
    }

    @Override // androidx.core.view.j2
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@c.o0 ColorStateList colorStateList) {
        d dVar = this.f1426a;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.j2
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@c.o0 PorterDuff.Mode mode) {
        d dVar = this.f1426a;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    @Override // androidx.core.widget.i0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintList(@c.o0 ColorStateList colorStateList) {
        this.f1427b.w(colorStateList);
        this.f1427b.b();
    }

    @Override // androidx.core.widget.i0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintMode(@c.o0 PorterDuff.Mode mode) {
        this.f1427b.x(mode);
        this.f1427b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i7) {
        super.setTextAppearance(context, i7);
        t tVar = this.f1427b;
        if (tVar != null) {
            tVar.q(context, i7);
        }
    }

    @Override // android.widget.TextView
    @c.t0(api = 26)
    public void setTextClassifier(@c.o0 TextClassifier textClassifier) {
        s sVar;
        if (Build.VERSION.SDK_INT >= 28 || (sVar = this.f1428c) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            sVar.b(textClassifier);
        }
    }

    public AppCompatEditText(@c.m0 Context context, @c.o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    @Override // android.widget.EditText, android.widget.TextView
    @c.o0
    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }

    public AppCompatEditText(@c.m0 Context context, @c.o0 AttributeSet attributeSet, int i7) {
        super(e1.b(context), attributeSet, i7);
        c1.a(this, getContext());
        d dVar = new d(this);
        this.f1426a = dVar;
        dVar.e(attributeSet, i7);
        t tVar = new t(this);
        this.f1427b = tVar;
        tVar.m(attributeSet, i7);
        tVar.b();
        this.f1428c = new s(this);
        this.f1429d = new androidx.core.widget.f0();
        h hVar = new h(this);
        this.f1430e = hVar;
        hVar.d(attributeSet, i7);
        c(hVar);
    }
}
