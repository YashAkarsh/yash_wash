package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import c.m0;
import c.o0;
import com.google.android.material.R;
import com.google.android.material.timepicker.TimeModel;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class l extends BaseAdapter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int f17565f = u.v().getMaximum(4);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Month f17566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final DateSelector<?> f17567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Collection<Long> f17568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    b f17569d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final CalendarConstraints f17570e;

    l(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints) {
        this.f17566a = month;
        this.f17567b = dateSelector;
        this.f17570e = calendarConstraints;
        this.f17568c = dateSelector.h0();
    }

    private void e(Context context) {
        if (this.f17569d == null) {
            this.f17569d = new b(context);
        }
    }

    private boolean h(long j7) {
        Iterator<Long> it = this.f17567b.h0().iterator();
        while (it.hasNext()) {
            if (u.a(j7) == u.a(it.next().longValue())) {
                return true;
            }
        }
        return false;
    }

    private void k(@o0 TextView textView, long j7) {
        a aVar;
        if (textView == null) {
            return;
        }
        if (this.f17570e.g().m(j7)) {
            textView.setEnabled(true);
            if (h(j7)) {
                aVar = this.f17569d.f17456b;
            } else {
                aVar = u.t().getTimeInMillis() == j7 ? this.f17569d.f17457c : this.f17569d.f17455a;
            }
        } else {
            textView.setEnabled(false);
            aVar = this.f17569d.f17461g;
        }
        aVar.f(textView);
    }

    private void l(MaterialCalendarGridView materialCalendarGridView, long j7) {
        if (Month.d(j7).equals(this.f17566a)) {
            k((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().a(this.f17566a.h(j7)) - materialCalendarGridView.getFirstVisiblePosition()), j7);
        }
    }

    int a(int i7) {
        return b() + (i7 - 1);
    }

    int b() {
        return this.f17566a.f();
    }

    @Override // android.widget.Adapter
    @o0
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Long getItem(int i7) {
        if (i7 < this.f17566a.f() || i7 > i()) {
            return null;
        }
        return Long.valueOf(this.f17566a.g(j(i7)));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0075  */
    @Override // android.widget.Adapter
    @m0
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public TextView getView(int i7, @o0 View view, @m0 ViewGroup viewGroup) {
        e(viewGroup.getContext());
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_day, viewGroup, false);
        }
        int iB = i7 - b();
        if (iB >= 0) {
            Month month = this.f17566a;
            if (iB >= month.f17429e) {
                textView.setVisibility(8);
                textView.setEnabled(false);
            } else {
                int i8 = iB + 1;
                textView.setTag(month);
                textView.setText(String.format(textView.getResources().getConfiguration().locale, TimeModel.f18789i, Integer.valueOf(i8)));
                long jG = this.f17566a.g(i8);
                if (this.f17566a.f17427c == Month.e().f17427c) {
                    textView.setContentDescription(e.g(jG));
                } else {
                    textView.setContentDescription(e.l(jG));
                }
                textView.setVisibility(0);
                textView.setEnabled(true);
            }
        } else {
            textView.setVisibility(8);
            textView.setEnabled(false);
        }
        Long item = getItem(i7);
        if (item == null) {
            return textView;
        }
        k(textView, item.longValue());
        return textView;
    }

    boolean f(int i7) {
        return i7 % this.f17566a.f17428d == 0;
    }

    boolean g(int i7) {
        return (i7 + 1) % this.f17566a.f17428d == 0;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f17566a.f17429e + b();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i7) {
        return i7 / this.f17566a.f17428d;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    int i() {
        return (this.f17566a.f() + this.f17566a.f17429e) - 1;
    }

    int j(int i7) {
        return (i7 - this.f17566a.f()) + 1;
    }

    public void m(MaterialCalendarGridView materialCalendarGridView) {
        Iterator<Long> it = this.f17568c.iterator();
        while (it.hasNext()) {
            l(materialCalendarGridView, it.next().longValue());
        }
        DateSelector<?> dateSelector = this.f17567b;
        if (dateSelector != null) {
            Iterator<Long> it2 = dateSelector.h0().iterator();
            while (it2.hasNext()) {
                l(materialCalendarGridView, it2.next().longValue());
            }
            this.f17568c = this.f17567b.h0();
        }
    }

    boolean n(int i7) {
        return i7 >= b() && i7 <= i();
    }
}
