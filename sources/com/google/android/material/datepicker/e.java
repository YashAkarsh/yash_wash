package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Build;
import android.text.format.DateUtils;
import c.o0;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
class e {
    private e() {
    }

    static androidx.core.util.s<String, String> a(@o0 Long l7, @o0 Long l8) {
        return b(l7, l8, null);
    }

    static androidx.core.util.s<String, String> b(@o0 Long l7, @o0 Long l8, @o0 SimpleDateFormat simpleDateFormat) {
        if (l7 == null && l8 == null) {
            return androidx.core.util.s.a(null, null);
        }
        if (l7 == null) {
            return androidx.core.util.s.a(null, d(l8.longValue(), simpleDateFormat));
        }
        if (l8 == null) {
            return androidx.core.util.s.a(d(l7.longValue(), simpleDateFormat), null);
        }
        Calendar calendarT = u.t();
        Calendar calendarV = u.v();
        calendarV.setTimeInMillis(l7.longValue());
        Calendar calendarV2 = u.v();
        calendarV2.setTimeInMillis(l8.longValue());
        if (simpleDateFormat != null) {
            return androidx.core.util.s.a(simpleDateFormat.format(new Date(l7.longValue())), simpleDateFormat.format(new Date(l8.longValue())));
        }
        if (calendarV.get(1) == calendarV2.get(1)) {
            return calendarV.get(1) == calendarT.get(1) ? androidx.core.util.s.a(f(l7.longValue(), Locale.getDefault()), f(l8.longValue(), Locale.getDefault())) : androidx.core.util.s.a(f(l7.longValue(), Locale.getDefault()), k(l8.longValue(), Locale.getDefault()));
        }
        return androidx.core.util.s.a(k(l7.longValue(), Locale.getDefault()), k(l8.longValue(), Locale.getDefault()));
    }

    static String c(long j7) {
        return d(j7, null);
    }

    static String d(long j7, @o0 SimpleDateFormat simpleDateFormat) {
        Calendar calendarT = u.t();
        Calendar calendarV = u.v();
        calendarV.setTimeInMillis(j7);
        if (simpleDateFormat != null) {
            return simpleDateFormat.format(new Date(j7));
        }
        return calendarT.get(1) == calendarV.get(1) ? e(j7) : j(j7);
    }

    static String e(long j7) {
        return f(j7, Locale.getDefault());
    }

    static String f(long j7, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? u.c(locale).format(new Date(j7)) : u.m(locale).format(new Date(j7));
    }

    static String g(long j7) {
        return h(j7, Locale.getDefault());
    }

    static String h(long j7, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? u.d(locale).format(new Date(j7)) : u.i(locale).format(new Date(j7));
    }

    static String i(Context context, long j7) {
        return DateUtils.formatDateTime(context, j7 - ((long) TimeZone.getDefault().getOffset(j7)), 36);
    }

    static String j(long j7) {
        return k(j7, Locale.getDefault());
    }

    static String k(long j7, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? u.x(locale).format(new Date(j7)) : u.k(locale).format(new Date(j7));
    }

    static String l(long j7) {
        return m(j7, Locale.getDefault());
    }

    static String m(long j7, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? u.y(locale).format(new Date(j7)) : u.i(locale).format(new Date(j7));
    }
}
