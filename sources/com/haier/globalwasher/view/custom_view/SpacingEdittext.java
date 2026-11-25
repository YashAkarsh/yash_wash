package com.haier.globalwasher.view.custom_view;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.method.ArrowKeyMovementMethod;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;
import c.o0;

/* JADX INFO: loaded from: classes2.dex */
public class SpacingEdittext extends SpacingText {
    public SpacingEdittext(Context context) {
        super(context);
    }

    public void c(int i7) {
        Selection.extendSelection(getText(), i7);
    }

    public void d() {
        Selection.selectAll(getText());
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return EditText.class.getName();
    }

    @Override // android.widget.TextView
    protected boolean getDefaultEditable() {
        return true;
    }

    @Override // android.widget.TextView
    protected MovementMethod getDefaultMovementMethod() {
        return ArrowKeyMovementMethod.getInstance();
    }

    @Override // android.widget.TextView
    public boolean getFreezesText() {
        return true;
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new IllegalArgumentException("EditText cannot use the ellipsize mode TextUtils.TruncateAt.MARQUEE");
        }
        super.setEllipsize(truncateAt);
    }

    public void setSelection(int i7, int i8) {
        Selection.setSelection(getText(), i7, i8);
    }

    @Override // com.haier.globalwasher.view.custom_view.SpacingText, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, TextView.BufferType.EDITABLE);
    }

    public SpacingEdittext(Context context, @o0 AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.haier.globalwasher.view.custom_view.SpacingText, android.widget.TextView
    public Editable getText() {
        return (Editable) super.getText();
    }

    public void setSelection(int i7) {
        Selection.setSelection(getText(), i7);
    }

    public SpacingEdittext(Context context, @o0 AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
    }
}
