package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
class i implements TextView.OnEditorActionListener, View.OnKeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ChipTextInputComboView f18848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ChipTextInputComboView f18849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TimeModel f18850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f18851d = false;

    i(ChipTextInputComboView chipTextInputComboView, ChipTextInputComboView chipTextInputComboView2, TimeModel timeModel) {
        this.f18848a = chipTextInputComboView;
        this.f18849b = chipTextInputComboView2;
        this.f18850c = timeModel;
    }

    private void b(int i7) {
        this.f18849b.setChecked(i7 == 12);
        this.f18848a.setChecked(i7 == 10);
        this.f18850c.f18795f = i7;
    }

    private boolean c(int i7, KeyEvent keyEvent, EditText editText) {
        Editable text = editText.getText();
        if (text == null) {
            return false;
        }
        if (!(i7 >= 7 && i7 <= 16 && keyEvent.getAction() == 1 && editText.getSelectionStart() == 2 && text.length() == 2)) {
            return false;
        }
        b(12);
        return true;
    }

    private boolean d(int i7, KeyEvent keyEvent, EditText editText) {
        if (!(i7 == 67 && keyEvent.getAction() == 0 && TextUtils.isEmpty(editText.getText()))) {
            return false;
        }
        b(10);
        return true;
    }

    public void a() {
        TextInputLayout textInputLayoutE = this.f18848a.e();
        TextInputLayout textInputLayoutE2 = this.f18849b.e();
        EditText editText = textInputLayoutE.getEditText();
        EditText editText2 = textInputLayoutE2.getEditText();
        editText.setImeOptions(268435461);
        editText2.setImeOptions(268435462);
        editText.setOnEditorActionListener(this);
        editText.setOnKeyListener(this);
        editText2.setOnKeyListener(this);
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i7, KeyEvent keyEvent) {
        boolean z7 = i7 == 5;
        if (z7) {
            b(12);
        }
        return z7;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i7, KeyEvent keyEvent) {
        if (this.f18851d) {
            return false;
        }
        this.f18851d = true;
        EditText editText = (EditText) view;
        boolean zD = this.f18850c.f18795f == 12 ? d(i7, keyEvent, editText) : c(i7, keyEvent, editText);
        this.f18851d = false;
        return zD;
    }
}
