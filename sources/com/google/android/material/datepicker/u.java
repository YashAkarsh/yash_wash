package com.google.android.material.datepicker;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.icu.text.DateFormat;
import c.m0;
import c.o0;
import com.google.android.material.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f17583a = "UTC";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static AtomicReference<q> f17584b = new AtomicReference<>();

    private u() {
    }

    static void A(@o0 q qVar) {
        f17584b.set(qVar);
    }

    static long a(long j7) {
        Calendar calendarV = v();
        calendarV.setTimeInMillis(j7);
        return f(calendarV).getTimeInMillis();
    }

    private static int b(@m0 String str, @m0 String str2, int i7, int i8) {
        while (i8 >= 0 && i8 < str.length() && str2.indexOf(str.charAt(i8)) == -1) {
            if (str.charAt(i8) == '\'') {
                do {
                    i8 += i7;
                    if (i8 < 0 || i8 >= str.length()) {
                        break;
                    }
                } while (str.charAt(i8) != '\'');
            }
            i8 += i7;
        }
        return i8;
    }

    @TargetApi(24)
    static DateFormat c(Locale locale) {
        return e("MMMd", locale);
    }

    @TargetApi(24)
    static DateFormat d(Locale locale) {
        return e("MMMEd", locale);
    }

    @TargetApi(24)
    private static DateFormat e(String str, Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(u());
        return instanceForSkeleton;
    }

    static Calendar f(Calendar calendar) {
        Calendar calendarW = w(calendar);
        Calendar calendarV = v();
        calendarV.set(calendarW.get(1), calendarW.get(2), calendarW.get(5));
        return calendarV;
    }

    private static java.text.DateFormat g(int i7, Locale locale) {
        java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(i7, locale);
        dateInstance.setTimeZone(s());
        return dateInstance;
    }

    static java.text.DateFormat h() {
        return i(Locale.getDefault());
    }

    static java.text.DateFormat i(Locale locale) {
        return g(0, locale);
    }

    static java.text.DateFormat j() {
        return k(Locale.getDefault());
    }

    static java.text.DateFormat k(Locale locale) {
        return g(2, locale);
    }

    static java.text.DateFormat l() {
        return m(Locale.getDefault());
    }

    static java.text.DateFormat m(Locale locale) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) k(locale);
        simpleDateFormat.applyPattern(z(simpleDateFormat.toPattern()));
        return simpleDateFormat;
    }

    static SimpleDateFormat n(String str) {
        return o(str, Locale.getDefault());
    }

    private static SimpleDateFormat o(String str, Locale locale) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
        simpleDateFormat.setTimeZone(s());
        return simpleDateFormat;
    }

    static SimpleDateFormat p() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(((SimpleDateFormat) java.text.DateFormat.getDateInstance(3, Locale.getDefault())).toLocalizedPattern().replaceAll("\\s+", ""), Locale.getDefault());
        simpleDateFormat.setTimeZone(s());
        simpleDateFormat.setLenient(false);
        return simpleDateFormat;
    }

    static String q(Resources resources, SimpleDateFormat simpleDateFormat) {
        String localizedPattern = simpleDateFormat.toLocalizedPattern();
        return localizedPattern.replaceAll("d", resources.getString(R.string.mtrl_picker_text_input_day_abbr)).replaceAll("M", resources.getString(R.string.mtrl_picker_text_input_month_abbr)).replaceAll("y", resources.getString(R.string.mtrl_picker_text_input_year_abbr));
    }

    static q r() {
        q qVar = f17584b.get();
        return qVar == null ? q.e() : qVar;
    }

    private static TimeZone s() {
        return TimeZone.getTimeZone(f17583a);
    }

    static Calendar t() {
        Calendar calendarC = r().c();
        calendarC.set(11, 0);
        calendarC.set(12, 0);
        calendarC.set(13, 0);
        calendarC.set(14, 0);
        calendarC.setTimeZone(s());
        return calendarC;
    }

    @TargetApi(24)
    private static android.icu.util.TimeZone u() {
        return android.icu.util.TimeZone.getTimeZone(f17583a);
    }

    static Calendar v() {
        return w(null);
    }

    static Calendar w(@o0 Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(s());
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }

    @TargetApi(24)
    static DateFormat x(Locale locale) {
        return e("yMMMd", locale);
    }

    @TargetApi(24)
    static DateFormat y(Locale locale) {
        return e("yMMMEd", locale);
    }

    @m0
    private static String z(@m0 String str) {
        int iB = b(str, "yY", 1, 0);
        if (iB >= str.length()) {
            return str;
        }
        String str2 = "EMd";
        int iB2 = b(str, "EMd", 1, iB);
        if (iB2 < str.length()) {
            str2 = "EMd,";
        }
        return str.replace(str.substring(b(str, str2, -1, iB) + 1, iB2), " ").trim();
    }
}
