package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import c.m0;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    final a f17455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    final a f17456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m0
    final a f17457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m0
    final a f17458d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @m0
    final a f17459e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @m0
    final a f17460f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @m0
    final a f17461g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @m0
    final Paint f17462h;

    b(@m0 Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(com.google.android.material.resources.b.g(context, R.attr.materialCalendarStyle, g.class.getCanonicalName()), R.styleable.MaterialCalendar);
        this.f17455a = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayStyle, 0));
        this.f17461g = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayInvalidStyle, 0));
        this.f17456b = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_daySelectedStyle, 0));
        this.f17457c = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList colorStateListA = com.google.android.material.resources.c.a(context, typedArrayObtainStyledAttributes, R.styleable.MaterialCalendar_rangeFillColor);
        this.f17458d = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearStyle, 0));
        this.f17459e = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearSelectedStyle, 0));
        this.f17460f = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearTodayStyle, 0));
        Paint paint = new Paint();
        this.f17462h = paint;
        paint.setColor(colorStateListA.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }
}
