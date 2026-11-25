package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.n2;
import c.m0;
import c.o0;
import com.google.android.material.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.m;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Chip f18757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextInputLayout f18758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EditText f18759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextWatcher f18760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f18761e;

    private class b extends m {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final String f18762b = "00";

        private b() {
        }

        @Override // com.google.android.material.internal.m, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView.this.f18757a.setText(ChipTextInputComboView.this.d(f18762b));
            } else {
                ChipTextInputComboView.this.f18757a.setText(ChipTextInputComboView.this.d(editable));
            }
        }
    }

    public ChipTextInputComboView(@m0 Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(CharSequence charSequence) {
        return TimeModel.a(getResources(), charSequence);
    }

    private void j() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f18759c.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
    }

    public void c(InputFilter inputFilter) {
        InputFilter[] filters = this.f18759c.getFilters();
        InputFilter[] inputFilterArr = (InputFilter[]) Arrays.copyOf(filters, filters.length + 1);
        inputFilterArr[filters.length] = inputFilter;
        this.f18759c.setFilters(inputFilterArr);
    }

    public TextInputLayout e() {
        return this.f18758b;
    }

    public void f(androidx.core.view.a aVar) {
        n2.B1(this.f18757a, aVar);
    }

    public void g(boolean z7) {
        this.f18759c.setCursorVisible(z7);
    }

    public void h(CharSequence charSequence) {
        this.f18761e.setText(charSequence);
    }

    public void i(CharSequence charSequence) {
        this.f18757a.setText(d(charSequence));
        if (TextUtils.isEmpty(this.f18759c.getText())) {
            return;
        }
        this.f18759c.removeTextChangedListener(this.f18760d);
        this.f18759c.setText((CharSequence) null);
        this.f18759c.addTextChangedListener(this.f18760d);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f18757a.isChecked();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        j();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z7) {
        this.f18757a.setChecked(z7);
        this.f18759c.setVisibility(z7 ? 0 : 4);
        this.f18757a.setVisibility(z7 ? 8 : 0);
        if (isChecked()) {
            this.f18759c.requestFocus();
            if (TextUtils.isEmpty(this.f18759c.getText())) {
                return;
            }
            EditText editText = this.f18759c;
            editText.setSelection(editText.getText().length());
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@o0 View.OnClickListener onClickListener) {
        this.f18757a.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(int i7, Object obj) {
        this.f18757a.setTag(i7, obj);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f18757a.toggle();
    }

    public ChipTextInputComboView(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChipTextInputComboView(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        Chip chip = (Chip) layoutInflaterFrom.inflate(R.layout.material_time_chip, (ViewGroup) this, false);
        this.f18757a = chip;
        TextInputLayout textInputLayout = (TextInputLayout) layoutInflaterFrom.inflate(R.layout.material_time_input, (ViewGroup) this, false);
        this.f18758b = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.f18759c = editText;
        editText.setVisibility(4);
        b bVar = new b();
        this.f18760d = bVar;
        editText.addTextChangedListener(bVar);
        j();
        addView(chip);
        addView(textInputLayout);
        this.f18761e = (TextView) findViewById(R.id.material_label);
        editText.setSaveEnabled(false);
    }
}
