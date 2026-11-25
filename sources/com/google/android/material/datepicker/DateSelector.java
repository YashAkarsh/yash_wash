package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a1;
import c.b1;
import c.m0;
import c.o0;
import c.x0;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public interface DateSelector<S> extends Parcelable {
    @a1
    int C();

    @b1
    int H(Context context);

    @m0
    String c(Context context);

    boolean g0();

    @m0
    Collection<Long> h0();

    @o0
    S l0();

    void o0(long j7);

    @m0
    Collection<androidx.core.util.s<Long, Long>> q();

    void r(@m0 S s7);

    @m0
    View v(@m0 LayoutInflater layoutInflater, @o0 ViewGroup viewGroup, @o0 Bundle bundle, @m0 CalendarConstraints calendarConstraints, @m0 n<S> nVar);
}
