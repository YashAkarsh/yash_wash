package com.google.android.material.textfield;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import c.m0;
import com.google.android.material.R;
import com.google.android.material.internal.m;

/* JADX INFO: loaded from: classes.dex */
class h extends e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TextWatcher f18748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextInputLayout.h f18749e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextInputLayout.i f18750f;

    class a extends m {
        a() {
        }

        @Override // com.google.android.material.internal.m, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
            h hVar = h.this;
            hVar.f18716c.setChecked(!hVar.g());
        }
    }

    class b implements TextInputLayout.h {
        b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.h
        public void a(@m0 TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(true);
            textInputLayout.setEndIconCheckable(true);
            h hVar = h.this;
            hVar.f18716c.setChecked(!hVar.g());
            editText.removeTextChangedListener(h.this.f18748d);
            editText.addTextChangedListener(h.this.f18748d);
        }
    }

    class c implements TextInputLayout.i {

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ EditText f18754a;

            a(EditText editText) {
                this.f18754a = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f18754a.removeTextChangedListener(h.this.f18748d);
            }
        }

        c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.i
        public void a(@m0 TextInputLayout textInputLayout, int i7) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i7 != 1) {
                return;
            }
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            editText.post(new a(editText));
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EditText editText = h.this.f18714a.getEditText();
            if (editText == null) {
                return;
            }
            int selectionEnd = editText.getSelectionEnd();
            if (h.this.g()) {
                editText.setTransformationMethod(null);
            } else {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            if (selectionEnd >= 0) {
                editText.setSelection(selectionEnd);
            }
            h.this.f18714a.i0();
        }
    }

    h(@m0 TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f18748d = new a();
        this.f18749e = new b();
        this.f18750f = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        EditText editText = this.f18714a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private static boolean h(EditText editText) {
        return editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224);
    }

    @Override // com.google.android.material.textfield.e
    void a() {
        this.f18714a.setEndIconDrawable(e.a.b(this.f18715b, R.drawable.design_password_eye));
        TextInputLayout textInputLayout = this.f18714a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.password_toggle_content_description));
        this.f18714a.setEndIconOnClickListener(new d());
        this.f18714a.e(this.f18749e);
        this.f18714a.f(this.f18750f);
        EditText editText = this.f18714a.getEditText();
        if (h(editText)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
