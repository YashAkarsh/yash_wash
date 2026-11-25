package com.google.zxing.client.result;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.time.DateUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends q {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Pattern f23432m = Pattern.compile("P(?:(\\d+)W)?(?:(\\d+)D)?(?:T(?:(\\d+)H)?(?:(\\d+)M)?(?:(\\d+)S)?)?");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final long[] f23433n = {604800000, DateUtils.MILLIS_PER_DAY, DateUtils.MILLIS_PER_HOUR, DateUtils.MILLIS_PER_MINUTE, 1000};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Pattern f23434o = Pattern.compile("[0-9]{8}(T[0-9]{6}Z?)?");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f23435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f23436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f23437d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f23438e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f23439f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f23440g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f23441h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String[] f23442i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f23443j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final double f23444k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final double f23445l;

    public g(String str, String str2, String str3, String str4, String str5, String str6, String[] strArr, String str7, double d8, double d9) {
        super(r.CALENDAR);
        this.f23435b = str;
        try {
            long jS = s(str2);
            this.f23436c = jS;
            if (str3 == null) {
                long jU = u(str4);
                this.f23438e = jU < 0 ? -1L : jS + jU;
            } else {
                try {
                    this.f23438e = s(str3);
                } catch (ParseException e8) {
                    throw new IllegalArgumentException(e8.toString());
                }
            }
            this.f23437d = str2.length() == 8;
            this.f23439f = str3 != null && str3.length() == 8;
            this.f23440g = str5;
            this.f23441h = str6;
            this.f23442i = strArr;
            this.f23443j = str7;
            this.f23444k = d8;
            this.f23445l = d9;
        } catch (ParseException e9) {
            throw new IllegalArgumentException(e9.toString());
        }
    }

    private static String e(boolean z7, long j7) {
        if (j7 < 0) {
            return null;
        }
        return (z7 ? DateFormat.getDateInstance(2) : DateFormat.getDateTimeInstance(2, 2)).format(Long.valueOf(j7));
    }

    private static long s(String str) throws ParseException {
        if (!f23434o.matcher(str).matches()) {
            throw new ParseException(str, 0);
        }
        if (str.length() == 8) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat.parse(str).getTime();
        }
        if (str.length() != 16 || str.charAt(15) != 'Z') {
            return t(str);
        }
        long jT = t(str.substring(0, 15));
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        long j7 = jT + ((long) gregorianCalendar.get(15));
        gregorianCalendar.setTime(new Date(j7));
        return j7 + ((long) gregorianCalendar.get(16));
    }

    private static long t(String str) throws ParseException {
        return new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.ENGLISH).parse(str).getTime();
    }

    private static long u(CharSequence charSequence) {
        if (charSequence == null) {
            return -1L;
        }
        Matcher matcher = f23432m.matcher(charSequence);
        if (!matcher.matches()) {
            return -1L;
        }
        long j7 = 0;
        int i7 = 0;
        while (true) {
            long[] jArr = f23433n;
            if (i7 >= jArr.length) {
                return j7;
            }
            int i8 = i7 + 1;
            String strGroup = matcher.group(i8);
            if (strGroup != null) {
                j7 += jArr[i7] * ((long) Integer.parseInt(strGroup));
            }
            i7 = i8;
        }
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        StringBuilder sb = new StringBuilder(100);
        q.c(this.f23435b, sb);
        q.c(e(this.f23437d, this.f23436c), sb);
        q.c(e(this.f23439f, this.f23438e), sb);
        q.c(this.f23440g, sb);
        q.c(this.f23441h, sb);
        q.d(this.f23442i, sb);
        q.c(this.f23443j, sb);
        return sb.toString();
    }

    public String[] f() {
        return this.f23442i;
    }

    public String g() {
        return this.f23443j;
    }

    @Deprecated
    public Date h() {
        if (this.f23438e < 0) {
            return null;
        }
        return new Date(this.f23438e);
    }

    public long i() {
        return this.f23438e;
    }

    public double j() {
        return this.f23444k;
    }

    public String k() {
        return this.f23440g;
    }

    public double l() {
        return this.f23445l;
    }

    public String m() {
        return this.f23441h;
    }

    @Deprecated
    public Date n() {
        return new Date(this.f23436c);
    }

    public long o() {
        return this.f23436c;
    }

    public String p() {
        return this.f23435b;
    }

    public boolean q() {
        return this.f23439f;
    }

    public boolean r() {
        return this.f23437d;
    }
}
