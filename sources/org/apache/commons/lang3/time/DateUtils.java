package org.apache.commons.lang3.time;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class DateUtils {
    public static final long MILLIS_PER_DAY = 86400000;
    public static final long MILLIS_PER_HOUR = 3600000;
    public static final long MILLIS_PER_MINUTE = 60000;
    public static final long MILLIS_PER_SECOND = 1000;
    public static final int RANGE_MONTH_MONDAY = 6;
    public static final int RANGE_MONTH_SUNDAY = 5;
    public static final int RANGE_WEEK_CENTER = 4;
    public static final int RANGE_WEEK_MONDAY = 2;
    public static final int RANGE_WEEK_RELATIVE = 3;
    public static final int RANGE_WEEK_SUNDAY = 1;
    public static final int SEMI_MONTH = 1001;
    private static final int[][] fields = {new int[]{14}, new int[]{13}, new int[]{12}, new int[]{11, 10}, new int[]{5, 5, 9}, new int[]{2, 1001}, new int[]{1}, new int[]{0}};

    static class DateIterator implements Iterator<Calendar> {
        private final Calendar endFinal;
        private final Calendar spot;

        DateIterator(Calendar calendar, Calendar calendar2) {
            this.endFinal = calendar2;
            this.spot = calendar;
            calendar.add(5, -1);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.spot.before(this.endFinal);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public Calendar next() {
            if (this.spot.equals(this.endFinal)) {
                throw new NoSuchElementException();
            }
            this.spot.add(5, 1);
            return (Calendar) this.spot.clone();
        }
    }

    private enum ModifyType {
        TRUNCATE,
        ROUND,
        CEILING
    }

    private static Date add(Date date, int i7, int i8) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(i7, i8);
        return calendar.getTime();
    }

    public static Date addDays(Date date, int i7) {
        return add(date, 5, i7);
    }

    public static Date addHours(Date date, int i7) {
        return add(date, 11, i7);
    }

    public static Date addMilliseconds(Date date, int i7) {
        return add(date, 14, i7);
    }

    public static Date addMinutes(Date date, int i7) {
        return add(date, 12, i7);
    }

    public static Date addMonths(Date date, int i7) {
        return add(date, 2, i7);
    }

    public static Date addSeconds(Date date, int i7) {
        return add(date, 13, i7);
    }

    public static Date addWeeks(Date date, int i7) {
        return add(date, 3, i7);
    }

    public static Date addYears(Date date, int i7) {
        return add(date, 1, i7);
    }

    public static Date ceiling(Date date, int i7) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        modify(calendar, i7, ModifyType.CEILING);
        return calendar.getTime();
    }

    private static long getFragment(Date date, int i7, TimeUnit timeUnit) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getFragment(calendar, i7, timeUnit);
    }

    public static long getFragmentInDays(Date date, int i7) {
        return getFragment(date, i7, TimeUnit.DAYS);
    }

    public static long getFragmentInHours(Date date, int i7) {
        return getFragment(date, i7, TimeUnit.HOURS);
    }

    public static long getFragmentInMilliseconds(Date date, int i7) {
        return getFragment(date, i7, TimeUnit.MILLISECONDS);
    }

    public static long getFragmentInMinutes(Date date, int i7) {
        return getFragment(date, i7, TimeUnit.MINUTES);
    }

    public static long getFragmentInSeconds(Date date, int i7) {
        return getFragment(date, i7, TimeUnit.SECONDS);
    }

    public static boolean isSameDay(Date date, Date date2) {
        if (date == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return isSameDay(calendar, calendar2);
    }

    public static boolean isSameInstant(Date date, Date date2) {
        if (date == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return date.getTime() == date2.getTime();
    }

    public static boolean isSameLocalTime(Calendar calendar, Calendar calendar2) {
        if (calendar == null || calendar2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return calendar.get(14) == calendar2.get(14) && calendar.get(13) == calendar2.get(13) && calendar.get(12) == calendar2.get(12) && calendar.get(11) == calendar2.get(11) && calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1) && calendar.get(0) == calendar2.get(0) && calendar.getClass() == calendar2.getClass();
    }

    public static Iterator<Calendar> iterator(Date date, int i7) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return iterator(calendar, i7);
    }

    /* JADX WARN: Code duplicated, block: B:61:0x00cb  */
    private static void modify(Calendar calendar, int i7, ModifyType modifyType) {
        char c8;
        int i8;
        boolean z7;
        char c9;
        if (calendar.get(1) > 280000000) {
            throw new ArithmeticException("Calendar value too large for accurate calculations");
        }
        if (i7 == 14) {
            return;
        }
        Date time = calendar.getTime();
        long time2 = time.getTime();
        int i9 = calendar.get(14);
        ModifyType modifyType2 = ModifyType.TRUNCATE;
        if (modifyType2 == modifyType || i9 < 500) {
            time2 -= (long) i9;
        }
        boolean z8 = i7 == 13;
        int i10 = calendar.get(13);
        if (!z8 && (modifyType2 == modifyType || i10 < 30)) {
            time2 -= ((long) i10) * 1000;
        }
        if (i7 == 12) {
            z8 = true;
        }
        int i11 = calendar.get(12);
        if (!z8 && (modifyType2 == modifyType || i11 < 30)) {
            time2 -= ((long) i11) * MILLIS_PER_MINUTE;
        }
        if (time.getTime() != time2) {
            time.setTime(time2);
            calendar.setTime(time);
        }
        boolean z9 = false;
        for (int[] iArr : fields) {
            for (int i12 : iArr) {
                if (i12 == i7) {
                    if (modifyType == ModifyType.CEILING || (modifyType == ModifyType.ROUND && z9)) {
                        if (i7 == 1001) {
                            if (calendar.get(5) == 1) {
                                calendar.add(5, 15);
                                return;
                            } else {
                                calendar.add(5, -15);
                                calendar.add(2, 1);
                                return;
                            }
                        }
                        if (i7 != 9) {
                            calendar.add(iArr[0], 1);
                            return;
                        } else if (calendar.get(11) == 0) {
                            calendar.add(11, 12);
                            return;
                        } else {
                            calendar.add(11, -12);
                            calendar.add(5, 1);
                            return;
                        }
                    }
                    return;
                }
            }
            if (i7 != 9) {
                if (i7 == 1001 && iArr[0] == 5) {
                    int i13 = calendar.get(5) - 1;
                    if (i13 >= 15) {
                        i13 -= 15;
                    }
                    z9 = i13 > 7;
                    i8 = i13;
                    c8 = '\f';
                    z7 = true;
                } else {
                    c8 = '\f';
                    z7 = false;
                    i8 = 0;
                }
            } else if (iArr[0] == 11) {
                int i14 = calendar.get(11);
                c8 = '\f';
                if (i14 >= 12) {
                    i14 -= 12;
                }
                z9 = i14 >= 6;
                i8 = i14;
                z7 = true;
            } else {
                c8 = '\f';
                z7 = false;
                i8 = 0;
            }
            if (z7) {
                c9 = 0;
            } else {
                c9 = 0;
                int actualMinimum = calendar.getActualMinimum(iArr[0]);
                int actualMaximum = calendar.getActualMaximum(iArr[0]);
                int i15 = calendar.get(iArr[0]) - actualMinimum;
                z9 = i15 > (actualMaximum - actualMinimum) / 2;
                i8 = i15;
            }
            if (i8 != 0) {
                int i16 = iArr[c9];
                calendar.set(i16, calendar.get(i16) - i8);
            }
        }
        throw new IllegalArgumentException("The field " + i7 + " is not supported");
    }

    public static Date parseDate(String str, String... strArr) throws ParseException {
        return parseDate(str, null, strArr);
    }

    public static Date parseDateStrictly(String str, String... strArr) throws ParseException {
        return parseDateStrictly(str, null, strArr);
    }

    private static Date parseDateWithLeniency(String str, Locale locale, String[] strArr, boolean z7) throws ParseException {
        if (str == null || strArr == null) {
            throw new IllegalArgumentException("Date and Patterns must not be null");
        }
        SimpleDateFormat simpleDateFormat = locale == null ? new SimpleDateFormat() : new SimpleDateFormat("", locale);
        simpleDateFormat.setLenient(z7);
        ParsePosition parsePosition = new ParsePosition(0);
        for (String str2 : strArr) {
            simpleDateFormat.applyPattern(str2.endsWith("ZZ") ? str2.substring(0, str2.length() - 1) : str2);
            parsePosition.setIndex(0);
            String strReplaceAll = str2.endsWith("ZZ") ? str.replaceAll("([-+][0-9][0-9]):([0-9][0-9])$", "$1$2") : str;
            Date date = simpleDateFormat.parse(strReplaceAll, parsePosition);
            if (date != null && parsePosition.getIndex() == strReplaceAll.length()) {
                return date;
            }
        }
        throw new ParseException("Unable to parse the date: " + str, -1);
    }

    public static Date round(Date date, int i7) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        modify(calendar, i7, ModifyType.ROUND);
        return calendar.getTime();
    }

    private static Date set(Date date, int i7, int i8) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        calendar.setTime(date);
        calendar.set(i7, i8);
        return calendar.getTime();
    }

    public static Date setDays(Date date, int i7) {
        return set(date, 5, i7);
    }

    public static Date setHours(Date date, int i7) {
        return set(date, 11, i7);
    }

    public static Date setMilliseconds(Date date, int i7) {
        return set(date, 14, i7);
    }

    public static Date setMinutes(Date date, int i7) {
        return set(date, 12, i7);
    }

    public static Date setMonths(Date date, int i7) {
        return set(date, 2, i7);
    }

    public static Date setSeconds(Date date, int i7) {
        return set(date, 13, i7);
    }

    public static Date setYears(Date date, int i7) {
        return set(date, 1, i7);
    }

    public static Calendar toCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static Date truncate(Date date, int i7) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        modify(calendar, i7, ModifyType.TRUNCATE);
        return calendar.getTime();
    }

    public static int truncatedCompareTo(Calendar calendar, Calendar calendar2, int i7) {
        return truncate(calendar, i7).compareTo(truncate(calendar2, i7));
    }

    public static boolean truncatedEquals(Calendar calendar, Calendar calendar2, int i7) {
        return truncatedCompareTo(calendar, calendar2, i7) == 0;
    }

    public static long getFragmentInDays(Calendar calendar, int i7) {
        return getFragment(calendar, i7, TimeUnit.DAYS);
    }

    public static long getFragmentInHours(Calendar calendar, int i7) {
        return getFragment(calendar, i7, TimeUnit.HOURS);
    }

    public static long getFragmentInMilliseconds(Calendar calendar, int i7) {
        return getFragment(calendar, i7, TimeUnit.MILLISECONDS);
    }

    public static long getFragmentInMinutes(Calendar calendar, int i7) {
        return getFragment(calendar, i7, TimeUnit.MINUTES);
    }

    public static long getFragmentInSeconds(Calendar calendar, int i7) {
        return getFragment(calendar, i7, TimeUnit.SECONDS);
    }

    public static Date parseDate(String str, Locale locale, String... strArr) throws ParseException {
        return parseDateWithLeniency(str, locale, strArr, true);
    }

    public static Date parseDateStrictly(String str, Locale locale, String... strArr) throws ParseException {
        return parseDateWithLeniency(str, null, strArr, false);
    }

    public static boolean truncatedEquals(Date date, Date date2, int i7) {
        return truncatedCompareTo(date, date2, i7) == 0;
    }

    public static boolean isSameInstant(Calendar calendar, Calendar calendar2) {
        if (calendar == null || calendar2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return calendar.getTime().getTime() == calendar2.getTime().getTime();
    }

    public static int truncatedCompareTo(Date date, Date date2, int i7) {
        return truncate(date, i7).compareTo(truncate(date2, i7));
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0051  */
    private static long getFragment(Calendar calendar, int i7, TimeUnit timeUnit) {
        long jConvert;
        if (calendar != null) {
            TimeUnit timeUnit2 = TimeUnit.DAYS;
            int i8 = timeUnit == timeUnit2 ? 0 : 1;
            long jConvert2 = 0;
            if (i7 == 1) {
                jConvert = timeUnit.convert(calendar.get(6) - i8, timeUnit2);
            } else {
                if (i7 == 2) {
                    jConvert = timeUnit.convert(calendar.get(5) - i8, timeUnit2);
                }
                if (i7 != 1 || i7 == 2 || i7 == 5 || i7 == 6) {
                    jConvert2 += timeUnit.convert(calendar.get(11), TimeUnit.HOURS);
                } else {
                    switch (i7) {
                        case 11:
                            break;
                        case 12:
                            jConvert2 += timeUnit.convert(calendar.get(13), TimeUnit.SECONDS);
                        case 13:
                            return jConvert2 + timeUnit.convert(calendar.get(14), TimeUnit.MILLISECONDS);
                        case 14:
                            return jConvert2;
                        default:
                            throw new IllegalArgumentException("The fragment " + i7 + " is not supported");
                    }
                }
                jConvert2 += timeUnit.convert(calendar.get(12), TimeUnit.MINUTES);
                jConvert2 += timeUnit.convert(calendar.get(13), TimeUnit.SECONDS);
                return jConvert2 + timeUnit.convert(calendar.get(14), TimeUnit.MILLISECONDS);
            }
            jConvert2 = 0 + jConvert;
            if (i7 != 1) {
                jConvert2 += timeUnit.convert(calendar.get(11), TimeUnit.HOURS);
                jConvert2 += timeUnit.convert(calendar.get(12), TimeUnit.MINUTES);
                jConvert2 += timeUnit.convert(calendar.get(13), TimeUnit.SECONDS);
            } else {
                jConvert2 += timeUnit.convert(calendar.get(11), TimeUnit.HOURS);
                jConvert2 += timeUnit.convert(calendar.get(12), TimeUnit.MINUTES);
                jConvert2 += timeUnit.convert(calendar.get(13), TimeUnit.SECONDS);
            }
            return jConvert2 + timeUnit.convert(calendar.get(14), TimeUnit.MILLISECONDS);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0069  */
    /* JADX WARN: Code duplicated, block: B:25:0x006d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0071  */
    /* JADX WARN: Code duplicated, block: B:29:0x0075  */
    /* JADX WARN: Code duplicated, block: B:32:0x007d A[LOOP:0: B:30:0x0077->B:32:0x007d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:35:0x0087 A[LOOP:1: B:33:0x0081->B:35:0x0087, LOOP_END] */
    public static Iterator<Calendar> iterator(Calendar calendar, int i7) {
        Calendar calendarTruncate;
        Calendar calendarTruncate2;
        int i8;
        if (calendar != null) {
            int i9 = 2;
            i9 = 1;
            switch (i7) {
                case 1:
                case 2:
                case 3:
                case 4:
                    calendarTruncate = truncate(calendar, 5);
                    calendarTruncate2 = truncate(calendar, 5);
                    if (i7 == 2) {
                        i8 = 1;
                    } else if (i7 == 3) {
                        i9 = calendar.get(7);
                        i8 = i9 - 1;
                    } else if (i7 != 4) {
                        i8 = 7;
                    } else {
                        int i10 = calendar.get(7) - 3;
                        i8 = calendar.get(7) + 3;
                        i9 = i10;
                    }
                    if (i9 < 1) {
                        i9 += 7;
                    }
                    if (i9 > 7) {
                        i9 -= 7;
                    }
                    if (i8 < 1) {
                        i8 += 7;
                    }
                    if (i8 > 7) {
                        i8 -= 7;
                    }
                    while (calendarTruncate.get(7) != i9) {
                        calendarTruncate.add(5, -1);
                    }
                    while (calendarTruncate2.get(7) != i8) {
                        calendarTruncate2.add(5, 1);
                    }
                    return new DateIterator(calendarTruncate, calendarTruncate2);
                case 5:
                case 6:
                    Calendar calendarTruncate3 = truncate(calendar, 2);
                    Calendar calendar2 = (Calendar) calendarTruncate3.clone();
                    calendar2.add(2, 1);
                    calendar2.add(5, -1);
                    if (i7 == 6) {
                        calendarTruncate2 = calendar2;
                        calendarTruncate = calendarTruncate3;
                        i8 = 1;
                        if (i9 < 1) {
                            i9 += 7;
                        }
                        if (i9 > 7) {
                            i9 -= 7;
                        }
                        if (i8 < 1) {
                            i8 += 7;
                        }
                        if (i8 > 7) {
                            i8 -= 7;
                        }
                        while (calendarTruncate.get(7) != i9) {
                            calendarTruncate.add(5, -1);
                        }
                        while (calendarTruncate2.get(7) != i8) {
                            calendarTruncate2.add(5, 1);
                        }
                        return new DateIterator(calendarTruncate, calendarTruncate2);
                    }
                    calendarTruncate2 = calendar2;
                    calendarTruncate = calendarTruncate3;
                    i8 = 7;
                    if (i9 < 1) {
                        i9 += 7;
                    }
                    if (i9 > 7) {
                        i9 -= 7;
                    }
                    if (i8 < 1) {
                        i8 += 7;
                    }
                    if (i8 > 7) {
                        i8 -= 7;
                    }
                    while (calendarTruncate.get(7) != i9) {
                        calendarTruncate.add(5, -1);
                    }
                    while (calendarTruncate2.get(7) != i8) {
                        calendarTruncate2.add(5, 1);
                    }
                    return new DateIterator(calendarTruncate, calendarTruncate2);
                default:
                    throw new IllegalArgumentException("The range style " + i7 + " is not valid.");
            }
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Calendar ceiling(Calendar calendar, int i7) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            modify(calendar2, i7, ModifyType.CEILING);
            return calendar2;
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Calendar round(Calendar calendar, int i7) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            modify(calendar2, i7, ModifyType.ROUND);
            return calendar2;
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Calendar truncate(Calendar calendar, int i7) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            modify(calendar2, i7, ModifyType.TRUNCATE);
            return calendar2;
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static boolean isSameDay(Calendar calendar, Calendar calendar2) {
        if (calendar == null || calendar2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    public static Date ceiling(Object obj, int i7) {
        if (obj != null) {
            if (obj instanceof Date) {
                return ceiling((Date) obj, i7);
            }
            if (obj instanceof Calendar) {
                return ceiling((Calendar) obj, i7).getTime();
            }
            throw new ClassCastException("Could not find ceiling of for type: " + obj.getClass());
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date round(Object obj, int i7) {
        if (obj != null) {
            if (obj instanceof Date) {
                return round((Date) obj, i7);
            }
            if (obj instanceof Calendar) {
                return round((Calendar) obj, i7).getTime();
            }
            throw new ClassCastException("Could not round " + obj);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date truncate(Object obj, int i7) {
        if (obj != null) {
            if (obj instanceof Date) {
                return truncate((Date) obj, i7);
            }
            if (obj instanceof Calendar) {
                return truncate((Calendar) obj, i7).getTime();
            }
            throw new ClassCastException("Could not truncate " + obj);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Iterator<?> iterator(Object obj, int i7) {
        if (obj != null) {
            if (obj instanceof Date) {
                return iterator((Date) obj, i7);
            }
            if (obj instanceof Calendar) {
                return iterator((Calendar) obj, i7);
            }
            throw new ClassCastException("Could not iterate based on " + obj);
        }
        throw new IllegalArgumentException("The date must not be null");
    }
}
