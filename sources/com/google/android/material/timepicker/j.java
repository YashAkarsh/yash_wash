package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.l;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.m;
import java.lang.reflect.Field;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
class j implements TimePickerView.g, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinearLayout f18852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TimeModel f18853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TextWatcher f18854c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TextWatcher f18855d = new b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ChipTextInputComboView f18856e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ChipTextInputComboView f18857f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final i f18858g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final EditText f18859h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final EditText f18860i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MaterialButtonToggleGroup f18861j;

    class a extends m {
        a() {
        }

        @Override // com.google.android.material.internal.m, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    j.this.f18853b.j(0);
                } else {
                    j.this.f18853b.j(Integer.parseInt(editable.toString()));
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    class b extends m {
        b() {
        }

        @Override // com.google.android.material.internal.m, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    j.this.f18853b.h(0);
                } else {
                    j.this.f18853b.h(Integer.parseInt(editable.toString()));
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.g(((Integer) view.getTag(R.id.selection_type)).intValue());
        }
    }

    class d implements MaterialButtonToggleGroup.e {
        d() {
        }

        @Override // com.google.android.material.button.MaterialButtonToggleGroup.e
        public void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i7, boolean z7) {
            j.this.f18853b.k(i7 == R.id.material_clock_period_pm_button ? 1 : 0);
        }
    }

    public j(LinearLayout linearLayout, TimeModel timeModel) {
        this.f18852a = linearLayout;
        this.f18853b = timeModel;
        Resources resources = linearLayout.getResources();
        ChipTextInputComboView chipTextInputComboView = (ChipTextInputComboView) linearLayout.findViewById(R.id.material_minute_text_input);
        this.f18856e = chipTextInputComboView;
        ChipTextInputComboView chipTextInputComboView2 = (ChipTextInputComboView) linearLayout.findViewById(R.id.material_hour_text_input);
        this.f18857f = chipTextInputComboView2;
        TextView textView = (TextView) chipTextInputComboView.findViewById(R.id.material_label);
        TextView textView2 = (TextView) chipTextInputComboView2.findViewById(R.id.material_label);
        textView.setText(resources.getString(R.string.material_timepicker_minute));
        textView2.setText(resources.getString(R.string.material_timepicker_hour));
        chipTextInputComboView.setTag(R.id.selection_type, 12);
        chipTextInputComboView2.setTag(R.id.selection_type, 10);
        if (timeModel.f18792c == 0) {
            m();
        }
        c cVar = new c();
        chipTextInputComboView2.setOnClickListener(cVar);
        chipTextInputComboView.setOnClickListener(cVar);
        chipTextInputComboView2.c(timeModel.e());
        chipTextInputComboView.c(timeModel.f());
        this.f18859h = chipTextInputComboView2.e().getEditText();
        this.f18860i = chipTextInputComboView.e().getEditText();
        this.f18858g = new i(chipTextInputComboView2, chipTextInputComboView, timeModel);
        chipTextInputComboView2.f(new com.google.android.material.timepicker.b(linearLayout.getContext(), R.string.material_hour_selection));
        chipTextInputComboView.f(new com.google.android.material.timepicker.b(linearLayout.getContext(), R.string.material_minute_selection));
        a();
    }

    private void e() {
        this.f18859h.addTextChangedListener(this.f18855d);
        this.f18860i.addTextChangedListener(this.f18854c);
    }

    private void i() {
        this.f18859h.removeTextChangedListener(this.f18855d);
        this.f18860i.removeTextChangedListener(this.f18854c);
    }

    private static void k(EditText editText, @l int i7) {
        try {
            Context context = editText.getContext();
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            int i8 = declaredField.getInt(editText);
            Field declaredField2 = TextView.class.getDeclaredField("mEditor");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(editText);
            Field declaredField3 = obj.getClass().getDeclaredField("mCursorDrawable");
            declaredField3.setAccessible(true);
            Drawable drawableB = e.a.b(context, i8);
            drawableB.setColorFilter(i7, PorterDuff.Mode.SRC_IN);
            declaredField3.set(obj, new Drawable[]{drawableB, drawableB});
        } catch (Throwable unused) {
        }
    }

    private void l(TimeModel timeModel) {
        i();
        Locale locale = this.f18852a.getResources().getConfiguration().locale;
        String str = String.format(locale, TimeModel.f18788h, Integer.valueOf(timeModel.f18794e));
        String str2 = String.format(locale, TimeModel.f18788h, Integer.valueOf(timeModel.d()));
        this.f18856e.i(str);
        this.f18857f.i(str2);
        e();
        n();
    }

    private void m() {
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this.f18852a.findViewById(R.id.material_clock_period_toggle);
        this.f18861j = materialButtonToggleGroup;
        materialButtonToggleGroup.g(new d());
        this.f18861j.setVisibility(0);
        n();
    }

    private void n() {
        MaterialButtonToggleGroup materialButtonToggleGroup = this.f18861j;
        if (materialButtonToggleGroup == null) {
            return;
        }
        materialButtonToggleGroup.j(this.f18853b.f18796g == 0 ? R.id.material_clock_period_am_button : R.id.material_clock_period_pm_button);
    }

    @Override // com.google.android.material.timepicker.h
    public void a() {
        e();
        l(this.f18853b);
        this.f18858g.a();
    }

    @Override // com.google.android.material.timepicker.h
    public void b() {
        this.f18852a.setVisibility(0);
    }

    @Override // com.google.android.material.timepicker.h
    public void c() {
        l(this.f18853b);
    }

    public void f() {
        this.f18856e.setChecked(false);
        this.f18857f.setChecked(false);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.g
    public void g(int i7) {
        this.f18853b.f18795f = i7;
        this.f18856e.setChecked(i7 == 12);
        this.f18857f.setChecked(i7 == 10);
        n();
    }

    @Override // com.google.android.material.timepicker.h
    public void h() {
        View focusedChild = this.f18852a.getFocusedChild();
        if (focusedChild == null) {
            this.f18852a.setVisibility(8);
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) androidx.core.content.d.o(this.f18852a.getContext(), InputMethodManager.class);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(focusedChild.getWindowToken(), 0);
        }
        this.f18852a.setVisibility(8);
    }

    public void j() {
        this.f18856e.setChecked(this.f18853b.f18795f == 12);
        this.f18857f.setChecked(this.f18853b.f18795f == 10);
    }
}
