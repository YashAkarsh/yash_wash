package com.google.android.material.datepicker;

import c.o0;
import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
class q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final q f17580c = new q(null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @o0
    private final Long f17581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    private final TimeZone f17582b;

    private q(@o0 Long l7, @o0 TimeZone timeZone) {
        this.f17581a = l7;
        this.f17582b = timeZone;
    }

    static q a(long j7) {
        return new q(Long.valueOf(j7), null);
    }

    static q b(long j7, @o0 TimeZone timeZone) {
        return new q(Long.valueOf(j7), timeZone);
    }

    static q e() {
        return f17580c;
    }

    Calendar c() {
        return d(this.f17582b);
    }

    Calendar d(@o0 TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l7 = this.f17581a;
        if (l7 != null) {
            calendar.setTimeInMillis(l7.longValue());
        }
        return calendar;
    }
}
