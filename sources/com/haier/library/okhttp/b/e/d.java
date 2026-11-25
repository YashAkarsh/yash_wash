package com.haier.library.okhttp.b.e;

import com.haier.library.okhttp.n;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f27061a = 253402300799999L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<DateFormat> f27062b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f27063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final DateFormat[] f27064d;

    static class a extends ThreadLocal<DateFormat> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(n.d.f27701p);
            return simpleDateFormat;
        }
    }

    static {
        String[] strArr = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        f27063c = strArr;
        f27064d = new DateFormat[strArr.length];
    }

    private d() {
    }

    public static String a(Date date) {
        return f27062b.get().format(date);
    }

    public static Date b(String str) {
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date date = f27062b.get().parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return date;
        }
        String[] strArr = f27063c;
        synchronized (strArr) {
            int length = strArr.length;
            for (int i7 = 0; i7 < length; i7++) {
                DateFormat[] dateFormatArr = f27064d;
                DateFormat simpleDateFormat = dateFormatArr[i7];
                if (simpleDateFormat == null) {
                    simpleDateFormat = new SimpleDateFormat(f27063c[i7], Locale.US);
                    simpleDateFormat.setTimeZone(n.d.f27701p);
                    dateFormatArr[i7] = simpleDateFormat;
                }
                parsePosition.setIndex(0);
                Date date2 = simpleDateFormat.parse(str, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return date2;
                }
            }
            return null;
        }
    }
}
