package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import c.m0;
import c.o0;
import com.google.android.material.R;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
class f extends BaseAdapter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f17474d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f17475e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final Calendar f17476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f17477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f17478c;

    static {
        f17475e = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public f() {
        Calendar calendarV = u.v();
        this.f17476a = calendarV;
        this.f17477b = calendarV.getMaximum(7);
        this.f17478c = calendarV.getFirstDayOfWeek();
    }

    private int b(int i7) {
        int i8 = i7 + this.f17478c;
        int i9 = this.f17477b;
        return i8 > i9 ? i8 - i9 : i8;
    }

    @Override // android.widget.Adapter
    @o0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer getItem(int i7) {
        if (i7 >= this.f17477b) {
            return null;
        }
        return Integer.valueOf(b(i7));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f17477b;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i7) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @o0
    @SuppressLint({"WrongConstant"})
    public View getView(int i7, @o0 View view, @m0 ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        this.f17476a.set(7, b(i7));
        textView.setText(this.f17476a.getDisplayName(7, f17475e, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R.string.mtrl_picker_day_of_week_column_header), this.f17476a.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }
}
