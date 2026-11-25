package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatEditText;
import c.m0;
import c.o0;
import com.google.android.material.R;
import com.google.android.material.internal.n;

/* JADX INFO: loaded from: classes.dex */
public class TextInputEditText extends AppCompatEditText {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Rect f18599f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f18600g;

    public TextInputEditText(@m0 Context context) {
        this(context, null);
    }

    @m0
    private String d(@m0 TextInputLayout textInputLayout) {
        Editable text = getText();
        CharSequence hint = textInputLayout.getHint();
        boolean z7 = !TextUtils.isEmpty(text);
        boolean z8 = !TextUtils.isEmpty(hint);
        setLabelFor(R.id.textinput_helper_text);
        String str = "";
        String string = z8 ? hint.toString() : "";
        if (!z7) {
            return !TextUtils.isEmpty(string) ? string : "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append((Object) text);
        if (!TextUtils.isEmpty(string)) {
            str = ", " + string;
        }
        sb.append(str);
        return sb.toString();
    }

    @o0
    private CharSequence getHintFromLayout() {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null) {
            return textInputLayout.getHint();
        }
        return null;
    }

    @o0
    private TextInputLayout getTextInputLayout() {
        for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    public boolean e() {
        return this.f18600g;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(@o0 Rect rect) {
        super.getFocusedRect(rect);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout == null || !this.f18600g || rect == null) {
            return;
        }
        textInputLayout.getFocusedRect(this.f18599f);
        rect.bottom = this.f18599f.bottom;
    }

    @Override // android.view.View
    public boolean getGlobalVisibleRect(@o0 Rect rect, @o0 Point point) {
        boolean globalVisibleRect = super.getGlobalVisibleRect(rect, point);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && this.f18600g && rect != null) {
            textInputLayout.getGlobalVisibleRect(this.f18599f, point);
            rect.bottom = this.f18599f.bottom;
        }
        return globalVisibleRect;
    }

    @Override // android.widget.TextView
    @o0
    public CharSequence getHint() {
        TextInputLayout textInputLayout = getTextInputLayout();
        return (textInputLayout == null || !textInputLayout.Z()) ? super.getHint() : textInputLayout.getHint();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && textInputLayout.Z() && super.getHint() == null && com.google.android.material.internal.e.c()) {
            setHint("");
        }
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    @o0
    public InputConnection onCreateInputConnection(@m0 EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (inputConnectionOnCreateInputConnection != null && editorInfo.hintText == null) {
            editorInfo.hintText = getHintFromLayout();
        }
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@m0 AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        getTextInputLayout();
    }

    @Override // android.view.View
    public boolean requestRectangleOnScreen(@o0 Rect rect) {
        boolean zRequestRectangleOnScreen = super.requestRectangleOnScreen(rect);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && this.f18600g) {
            this.f18599f.set(0, textInputLayout.getHeight() - getResources().getDimensionPixelOffset(R.dimen.mtrl_edittext_rectangle_top_offset), textInputLayout.getWidth(), textInputLayout.getHeight());
            textInputLayout.requestRectangleOnScreen(this.f18599f, true);
        }
        return zRequestRectangleOnScreen;
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean z7) {
        this.f18600g = z7;
    }

    public TextInputEditText(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    public TextInputEditText(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        super(q1.a.c(context, attributeSet, i7, 0), attributeSet, i7);
        this.f18599f = new Rect();
        TypedArray typedArrayJ = n.j(context, attributeSet, R.styleable.TextInputEditText, i7, R.style.Widget_Design_TextInputEditText, new int[0]);
        setTextInputLayoutFocusedRectEnabled(typedArrayJ.getBoolean(R.styleable.TextInputEditText_textInputLayoutFocusedRectEnabled, false));
        typedArrayJ.recycle();
    }
}
