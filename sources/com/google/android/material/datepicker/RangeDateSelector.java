package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.core.util.w;
import c.m0;
import c.o0;
import c.x0;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class RangeDateSelector implements DateSelector<androidx.core.util.s<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f17432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f17433b = " ";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    private Long f17434c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @o0
    private Long f17435d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @o0
    private Long f17436e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @o0
    private Long f17437f = null;

    class a extends com.google.android.material.datepicker.c {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ TextInputLayout f17438h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ TextInputLayout f17439i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ n f17440j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, n nVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f17438h = textInputLayout2;
            this.f17439i = textInputLayout3;
            this.f17440j = nVar;
        }

        @Override // com.google.android.material.datepicker.c
        void e() {
            RangeDateSelector.this.f17436e = null;
            RangeDateSelector.this.l(this.f17438h, this.f17439i, this.f17440j);
        }

        @Override // com.google.android.material.datepicker.c
        void f(@o0 Long l7) {
            RangeDateSelector.this.f17436e = l7;
            RangeDateSelector.this.l(this.f17438h, this.f17439i, this.f17440j);
        }
    }

    class b extends com.google.android.material.datepicker.c {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ TextInputLayout f17442h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ TextInputLayout f17443i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ n f17444j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, n nVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f17442h = textInputLayout2;
            this.f17443i = textInputLayout3;
            this.f17444j = nVar;
        }

        @Override // com.google.android.material.datepicker.c
        void e() {
            RangeDateSelector.this.f17437f = null;
            RangeDateSelector.this.l(this.f17442h, this.f17443i, this.f17444j);
        }

        @Override // com.google.android.material.datepicker.c
        void f(@o0 Long l7) {
            RangeDateSelector.this.f17437f = l7;
            RangeDateSelector.this.l(this.f17442h, this.f17443i, this.f17444j);
        }
    }

    static class c implements Parcelable.Creator<RangeDateSelector> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        @m0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RangeDateSelector createFromParcel(@m0 Parcel parcel) {
            RangeDateSelector rangeDateSelector = new RangeDateSelector();
            rangeDateSelector.f17434c = (Long) parcel.readValue(Long.class.getClassLoader());
            rangeDateSelector.f17435d = (Long) parcel.readValue(Long.class.getClassLoader());
            return rangeDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        @m0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public RangeDateSelector[] newArray(int i7) {
            return new RangeDateSelector[i7];
        }
    }

    private void g(@m0 TextInputLayout textInputLayout, @m0 TextInputLayout textInputLayout2) {
        if (textInputLayout.getError() != null && this.f17432a.contentEquals(textInputLayout.getError())) {
            textInputLayout.setError(null);
        }
        if (textInputLayout2.getError() == null || !" ".contentEquals(textInputLayout2.getError())) {
            return;
        }
        textInputLayout2.setError(null);
    }

    private boolean i(long j7, long j8) {
        return j7 <= j8;
    }

    private void j(@m0 TextInputLayout textInputLayout, @m0 TextInputLayout textInputLayout2) {
        textInputLayout.setError(this.f17432a);
        textInputLayout2.setError(" ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(@m0 TextInputLayout textInputLayout, @m0 TextInputLayout textInputLayout2, @m0 n<androidx.core.util.s<Long, Long>> nVar) {
        Long l7 = this.f17436e;
        if (l7 == null || this.f17437f == null) {
            g(textInputLayout, textInputLayout2);
            nVar.a();
        } else if (!i(l7.longValue(), this.f17437f.longValue())) {
            j(textInputLayout, textInputLayout2);
            nVar.a();
        } else {
            this.f17434c = this.f17436e;
            this.f17435d = this.f17437f;
            nVar.b(l0());
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int C() {
        return R.string.mtrl_picker_range_header_title;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int H(@m0 Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return com.google.android.material.resources.b.g(context, Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis) ? R.attr.materialCalendarTheme : R.attr.materialCalendarFullscreenTheme, h.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @m0
    public String c(@m0 Context context) {
        Resources resources = context.getResources();
        Long l7 = this.f17434c;
        if (l7 == null && this.f17435d == null) {
            return resources.getString(R.string.mtrl_picker_range_header_unselected);
        }
        Long l8 = this.f17435d;
        if (l8 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_start_selected, e.c(l7.longValue()));
        }
        if (l7 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_end_selected, e.c(l8.longValue()));
        }
        androidx.core.util.s<String, String> sVarA = e.a(l7, l8);
        return resources.getString(R.string.mtrl_picker_range_header_selected, sVarA.f6387a, sVarA.f6388b);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean g0() {
        Long l7 = this.f17434c;
        return (l7 == null || this.f17435d == null || !i(l7.longValue(), this.f17435d.longValue())) ? false : true;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @m0
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public androidx.core.util.s<Long, Long> l0() {
        return new androidx.core.util.s<>(this.f17434c, this.f17435d);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @m0
    public Collection<Long> h0() {
        ArrayList arrayList = new ArrayList();
        Long l7 = this.f17434c;
        if (l7 != null) {
            arrayList.add(l7);
        }
        Long l8 = this.f17435d;
        if (l8 != null) {
            arrayList.add(l8);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public void r(@m0 androidx.core.util.s<Long, Long> sVar) {
        Long l7 = sVar.f6387a;
        if (l7 != null && sVar.f6388b != null) {
            w.a(i(l7.longValue(), sVar.f6388b.longValue()));
        }
        Long l8 = sVar.f6387a;
        this.f17434c = l8 == null ? null : Long.valueOf(u.a(l8.longValue()));
        Long l9 = sVar.f6388b;
        this.f17435d = l9 != null ? Long.valueOf(u.a(l9.longValue())) : null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void o0(long j7) {
        Long l7 = this.f17434c;
        if (l7 == null) {
            this.f17434c = Long.valueOf(j7);
        } else if (this.f17435d == null && i(l7.longValue(), j7)) {
            this.f17435d = Long.valueOf(j7);
        } else {
            this.f17435d = null;
            this.f17434c = Long.valueOf(j7);
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @m0
    public Collection<androidx.core.util.s<Long, Long>> q() {
        if (this.f17434c == null || this.f17435d == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new androidx.core.util.s(this.f17434c, this.f17435d));
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View v(@m0 LayoutInflater layoutInflater, @o0 ViewGroup viewGroup, @o0 Bundle bundle, CalendarConstraints calendarConstraints, @m0 n<androidx.core.util.s<Long, Long>> nVar) {
        View viewInflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date_range, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R.id.mtrl_picker_text_input_range_start);
        TextInputLayout textInputLayout2 = (TextInputLayout) viewInflate.findViewById(R.id.mtrl_picker_text_input_range_end);
        EditText editText = textInputLayout.getEditText();
        EditText editText2 = textInputLayout2.getEditText();
        if (com.google.android.material.internal.e.a()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.f17432a = viewInflate.getResources().getString(R.string.mtrl_picker_invalid_range);
        SimpleDateFormat simpleDateFormatP = u.p();
        Long l7 = this.f17434c;
        if (l7 != null) {
            editText.setText(simpleDateFormatP.format(l7));
            this.f17436e = this.f17434c;
        }
        Long l8 = this.f17435d;
        if (l8 != null) {
            editText2.setText(simpleDateFormatP.format(l8));
            this.f17437f = this.f17435d;
        }
        String strQ = u.q(viewInflate.getResources(), simpleDateFormatP);
        textInputLayout.setPlaceholderText(strQ);
        textInputLayout2.setPlaceholderText(strQ);
        editText.addTextChangedListener(new a(strQ, simpleDateFormatP, textInputLayout, calendarConstraints, textInputLayout, textInputLayout2, nVar));
        editText2.addTextChangedListener(new b(strQ, simpleDateFormatP, textInputLayout2, calendarConstraints, textInputLayout, textInputLayout2, nVar));
        com.google.android.material.internal.v.o(editText);
        return viewInflate;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        parcel.writeValue(this.f17434c);
        parcel.writeValue(this.f17435d);
    }
}
