package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @o0
    private Long f17446a;

    class a extends c {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ n f17447h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, n nVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f17447h = nVar;
        }

        @Override // com.google.android.material.datepicker.c
        void e() {
            this.f17447h.a();
        }

        @Override // com.google.android.material.datepicker.c
        void f(@o0 Long l7) {
            if (l7 == null) {
                SingleDateSelector.this.d();
            } else {
                SingleDateSelector.this.o0(l7.longValue());
            }
            this.f17447h.b(SingleDateSelector.this.l0());
        }
    }

    static class b implements Parcelable.Creator<SingleDateSelector> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        @m0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SingleDateSelector createFromParcel(@m0 Parcel parcel) {
            SingleDateSelector singleDateSelector = new SingleDateSelector();
            singleDateSelector.f17446a = (Long) parcel.readValue(Long.class.getClassLoader());
            return singleDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        @m0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public SingleDateSelector[] newArray(int i7) {
            return new SingleDateSelector[i7];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.f17446a = null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int C() {
        return R.string.mtrl_picker_date_header_title;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int H(Context context) {
        return com.google.android.material.resources.b.g(context, R.attr.materialCalendarTheme, h.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @m0
    public String c(@m0 Context context) {
        Resources resources = context.getResources();
        Long l7 = this.f17446a;
        if (l7 == null) {
            return resources.getString(R.string.mtrl_picker_date_header_unselected);
        }
        return resources.getString(R.string.mtrl_picker_date_header_selected, e.j(l7.longValue()));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @o0
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Long l0() {
        return this.f17446a;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void r(@o0 Long l7) {
        this.f17446a = l7 == null ? null : Long.valueOf(u.a(l7.longValue()));
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean g0() {
        return this.f17446a != null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @m0
    public Collection<Long> h0() {
        ArrayList arrayList = new ArrayList();
        Long l7 = this.f17446a;
        if (l7 != null) {
            arrayList.add(l7);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void o0(long j7) {
        this.f17446a = Long.valueOf(j7);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @m0
    public Collection<androidx.core.util.s<Long, Long>> q() {
        return new ArrayList();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View v(@m0 LayoutInflater layoutInflater, @o0 ViewGroup viewGroup, @o0 Bundle bundle, CalendarConstraints calendarConstraints, @m0 n<Long> nVar) {
        View viewInflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R.id.mtrl_picker_text_input_date);
        EditText editText = textInputLayout.getEditText();
        if (com.google.android.material.internal.e.a()) {
            editText.setInputType(17);
        }
        SimpleDateFormat simpleDateFormatP = u.p();
        String strQ = u.q(viewInflate.getResources(), simpleDateFormatP);
        textInputLayout.setPlaceholderText(strQ);
        Long l7 = this.f17446a;
        if (l7 != null) {
            editText.setText(simpleDateFormatP.format(l7));
        }
        editText.addTextChangedListener(new a(strQ, simpleDateFormatP, textInputLayout, calendarConstraints, nVar));
        com.google.android.material.internal.v.o(editText);
        return viewInflate;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        parcel.writeValue(this.f17446a);
    }
}
