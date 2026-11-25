package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.b1;
import c.m0;
import c.o0;
import c.x0;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public final class k<S> extends o<S> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f17558e = "THEME_RES_ID_KEY";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f17559f = "DATE_SELECTOR_KEY";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f17560g = "CALENDAR_CONSTRAINTS_KEY";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @b1
    private int f17561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    private DateSelector<S> f17562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @o0
    private CalendarConstraints f17563d;

    class a extends n<S> {
        a() {
        }

        @Override // com.google.android.material.datepicker.n
        public void a() {
            Iterator<n<S>> it = k.this.f17578a.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }

        @Override // com.google.android.material.datepicker.n
        public void b(S s7) {
            Iterator<n<S>> it = k.this.f17578a.iterator();
            while (it.hasNext()) {
                it.next().b(s7);
            }
        }
    }

    @m0
    static <T> k<T> E(DateSelector<T> dateSelector, @b1 int i7, @m0 CalendarConstraints calendarConstraints) {
        k<T> kVar = new k<>();
        Bundle bundle = new Bundle();
        bundle.putInt(f17558e, i7);
        bundle.putParcelable(f17559f, dateSelector);
        bundle.putParcelable(f17560g, calendarConstraints);
        kVar.setArguments(bundle);
        return kVar;
    }

    @Override // com.google.android.material.datepicker.o
    @m0
    public DateSelector<S> C() {
        DateSelector<S> dateSelector = this.f17562c;
        if (dateSelector != null) {
            return dateSelector;
        }
        throw new IllegalStateException("dateSelector should not be null. Use MaterialTextInputPicker#newInstance() to create this fragment with a DateSelector, and call this method after the fragment has been created.");
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@o0 Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f17561b = bundle.getInt(f17558e);
        this.f17562c = (DateSelector) bundle.getParcelable(f17559f);
        this.f17563d = (CalendarConstraints) bundle.getParcelable(f17560g);
    }

    @Override // androidx.fragment.app.Fragment
    @m0
    public View onCreateView(@m0 LayoutInflater layoutInflater, @o0 ViewGroup viewGroup, @o0 Bundle bundle) {
        return this.f17562c.v(layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), this.f17561b)), viewGroup, bundle, this.f17563d, new a());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@m0 Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(f17558e, this.f17561b);
        bundle.putParcelable(f17559f, this.f17562c);
        bundle.putParcelable(f17560g, this.f17563d);
    }
}
