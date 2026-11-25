package com.google.android.material.datepicker;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import c.m0;
import c.o0;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
abstract class c extends com.google.android.material.internal.m {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f17463g = 1000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final TextInputLayout f17464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DateFormat f17465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CalendarConstraints f17466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f17467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Runnable f17468e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Runnable f17469f;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f17470a;

        a(String str) {
            this.f17470a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout textInputLayout = c.this.f17464a;
            DateFormat dateFormat = c.this.f17465b;
            Context context = textInputLayout.getContext();
            textInputLayout.setError(context.getString(R.string.mtrl_picker_invalid_format) + "\n" + String.format(context.getString(R.string.mtrl_picker_invalid_format_use), this.f17470a) + "\n" + String.format(context.getString(R.string.mtrl_picker_invalid_format_example), dateFormat.format(new Date(u.t().getTimeInMillis()))));
            c.this.e();
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f17472a;

        b(long j7) {
            this.f17472a = j7;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f17464a.setError(String.format(c.this.f17467d, e.c(this.f17472a)));
            c.this.e();
        }
    }

    c(String str, DateFormat dateFormat, @m0 TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.f17465b = dateFormat;
        this.f17464a = textInputLayout;
        this.f17466c = calendarConstraints;
        this.f17467d = textInputLayout.getContext().getString(R.string.mtrl_picker_out_of_range);
        this.f17468e = new a(str);
    }

    private Runnable d(long j7) {
        return new b(j7);
    }

    void e() {
    }

    abstract void f(@o0 Long l7);

    public void g(View view, Runnable runnable) {
        view.postDelayed(runnable, 1000L);
    }

    @Override // com.google.android.material.internal.m, android.text.TextWatcher
    public void onTextChanged(@m0 CharSequence charSequence, int i7, int i8, int i9) {
        this.f17464a.removeCallbacks(this.f17468e);
        this.f17464a.removeCallbacks(this.f17469f);
        this.f17464a.setError(null);
        f(null);
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        try {
            Date date = this.f17465b.parse(charSequence.toString());
            this.f17464a.setError(null);
            long time = date.getTime();
            if (this.f17466c.g().m(time) && this.f17466c.n(time)) {
                f(Long.valueOf(date.getTime()));
                return;
            }
            Runnable runnableD = d(time);
            this.f17469f = runnableD;
            g(this.f17464a, runnableD);
        } catch (ParseException unused) {
            g(this.f17464a, this.f17468e);
        }
    }
}
