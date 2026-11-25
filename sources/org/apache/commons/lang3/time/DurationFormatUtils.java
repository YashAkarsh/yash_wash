package org.apache.commons.lang3.time;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

/* JADX INFO: loaded from: classes3.dex */
public class DurationFormatUtils {
    public static final String ISO_EXTENDED_FORMAT_PATTERN = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.SSS'S'";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    static final Object f38562y = "y";
    static final Object M = "M";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final Object f38559d = "d";
    static final Object H = "H";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final Object f38560m = "m";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    static final Object f38561s = "s";
    static final Object S = "S";

    static String format(Token[] tokenArr, long j7, long j8, long j9, long j10, long j11, long j12, long j13, boolean z7) {
        Token[] tokenArr2 = tokenArr;
        long j14 = j13;
        StringBuilder sb = new StringBuilder();
        int length = tokenArr2.length;
        int i7 = 0;
        boolean z8 = false;
        while (i7 < length) {
            Token token = tokenArr2[i7];
            Object value = token.getValue();
            int count = token.getCount();
            if (value instanceof StringBuilder) {
                sb.append(value.toString());
                j14 = j14;
                length = length;
                i7 = i7;
            } else {
                if (value == f38562y) {
                    sb.append(paddedValue(j7, z7, count));
                } else {
                    if (value == M) {
                        sb.append(paddedValue(j8, z7, count));
                    } else if (value == f38559d) {
                        sb.append(paddedValue(j9, z7, count));
                        z8 = false;
                    } else {
                        i7 = i7;
                        if (value == H) {
                            length = length;
                            sb.append(paddedValue(j10, z7, count));
                        } else {
                            length = length;
                            if (value == f38560m) {
                                sb.append(paddedValue(j11, z7, count));
                            } else if (value == f38561s) {
                                sb.append(paddedValue(j12, z7, count));
                                j14 = j13;
                                z8 = true;
                            } else if (value == S) {
                                if (z8) {
                                    j14 = j13;
                                    sb.append(paddedValue(j14, true, z7 ? Math.max(3, count) : 3));
                                } else {
                                    j14 = j13;
                                    sb.append(paddedValue(j14, z7, count));
                                }
                                z8 = false;
                            } else {
                                j14 = j13;
                            }
                        }
                        j14 = j14;
                        z8 = false;
                    }
                    i7++;
                    j14 = j14;
                    length = length;
                    tokenArr2 = tokenArr;
                }
                z8 = false;
            }
            i7++;
            j14 = j14;
            length = length;
            tokenArr2 = tokenArr;
        }
        return sb.toString();
    }

    public static String formatDuration(long j7, String str) {
        return formatDuration(j7, str, true);
    }

    public static String formatDurationHMS(long j7) {
        return formatDuration(j7, "HH:mm:ss.SSS");
    }

    public static String formatDurationISO(long j7) {
        return formatDuration(j7, ISO_EXTENDED_FORMAT_PATTERN, false);
    }

    public static String formatDurationWords(long j7, boolean z7, boolean z8) {
        String duration = formatDuration(j7, "d' days 'H' hours 'm' minutes 's' seconds'");
        if (z7) {
            duration = " " + duration;
            String strReplaceOnce = StringUtils.replaceOnce(duration, " 0 days", "");
            if (strReplaceOnce.length() != duration.length()) {
                String strReplaceOnce2 = StringUtils.replaceOnce(strReplaceOnce, " 0 hours", "");
                if (strReplaceOnce2.length() != strReplaceOnce.length()) {
                    duration = StringUtils.replaceOnce(strReplaceOnce2, " 0 minutes", "");
                    if (duration.length() != duration.length()) {
                        duration = StringUtils.replaceOnce(duration, " 0 seconds", "");
                    }
                } else {
                    duration = strReplaceOnce;
                }
            }
            if (duration.length() != 0) {
                duration = duration.substring(1);
            }
        }
        if (z8) {
            String strReplaceOnce3 = StringUtils.replaceOnce(duration, " 0 seconds", "");
            if (strReplaceOnce3.length() != duration.length()) {
                duration = StringUtils.replaceOnce(strReplaceOnce3, " 0 minutes", "");
                if (duration.length() != strReplaceOnce3.length()) {
                    String strReplaceOnce4 = StringUtils.replaceOnce(duration, " 0 hours", "");
                    if (strReplaceOnce4.length() != duration.length()) {
                        duration = StringUtils.replaceOnce(strReplaceOnce4, " 0 days", "");
                    }
                } else {
                    duration = strReplaceOnce3;
                }
            }
        }
        return StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce(" " + duration, " 1 seconds", " 1 second"), " 1 minutes", " 1 minute"), " 1 hours", " 1 hour"), " 1 days", " 1 day").trim();
    }

    public static String formatPeriod(long j7, long j8, String str) {
        return formatPeriod(j7, j8, str, true, TimeZone.getDefault());
    }

    public static String formatPeriodISO(long j7, long j8) {
        return formatPeriod(j7, j8, ISO_EXTENDED_FORMAT_PATTERN, false, TimeZone.getDefault());
    }

    static Token[] lexx(String str) {
        Object obj;
        ArrayList arrayList = new ArrayList(str.length());
        boolean z7 = false;
        StringBuilder sb = null;
        Token token = null;
        for (int i7 = 0; i7 < str.length(); i7++) {
            char cCharAt = str.charAt(i7);
            if (!z7 || cCharAt == '\'') {
                if (cCharAt != '\'') {
                    if (cCharAt == 'H') {
                        obj = H;
                    } else if (cCharAt == 'M') {
                        obj = M;
                    } else if (cCharAt == 'S') {
                        obj = S;
                    } else if (cCharAt == 'd') {
                        obj = f38559d;
                    } else if (cCharAt == 'm') {
                        obj = f38560m;
                    } else if (cCharAt == 's') {
                        obj = f38561s;
                    } else if (cCharAt != 'y') {
                        if (sb == null) {
                            sb = new StringBuilder();
                            arrayList.add(new Token(sb));
                        }
                        sb.append(cCharAt);
                        obj = null;
                    } else {
                        obj = f38562y;
                    }
                } else if (z7) {
                    z7 = false;
                    sb = null;
                    obj = null;
                } else {
                    sb = new StringBuilder();
                    arrayList.add(new Token(sb));
                    z7 = true;
                    obj = null;
                }
                if (obj != null) {
                    if (token == null || token.getValue() != obj) {
                        Token token2 = new Token(obj);
                        arrayList.add(token2);
                        token = token2;
                    } else {
                        token.increment();
                    }
                    sb = null;
                }
            } else {
                sb.append(cCharAt);
            }
        }
        if (!z7) {
            return (Token[]) arrayList.toArray(new Token[arrayList.size()]);
        }
        throw new IllegalArgumentException("Unmatched quote in format: " + str);
    }

    private static String paddedValue(long j7, boolean z7, int i7) {
        String string = Long.toString(j7);
        return z7 ? StringUtils.leftPad(string, i7, '0') : string;
    }

    public static String formatDuration(long j7, String str, boolean z7) {
        long j8;
        long j9;
        long j10;
        long j11;
        long j12;
        long j13;
        Validate.inclusiveBetween(0L, Long.MAX_VALUE, j7, "durationMillis must not be negative");
        Token[] tokenArrLexx = lexx(str);
        if (Token.containsTokenWithValue(tokenArrLexx, f38559d)) {
            long j14 = j7 / DateUtils.MILLIS_PER_DAY;
            j8 = j7 - (DateUtils.MILLIS_PER_DAY * j14);
            j9 = j14;
        } else {
            j8 = j7;
            j9 = 0;
        }
        if (Token.containsTokenWithValue(tokenArrLexx, H)) {
            long j15 = j8 / DateUtils.MILLIS_PER_HOUR;
            j8 -= DateUtils.MILLIS_PER_HOUR * j15;
            j10 = j15;
        } else {
            j10 = 0;
        }
        if (Token.containsTokenWithValue(tokenArrLexx, f38560m)) {
            long j16 = j8 / DateUtils.MILLIS_PER_MINUTE;
            j8 -= DateUtils.MILLIS_PER_MINUTE * j16;
            j11 = j16;
        } else {
            j11 = 0;
        }
        if (Token.containsTokenWithValue(tokenArrLexx, f38561s)) {
            long j17 = j8 / 1000;
            j13 = j8 - (1000 * j17);
            j12 = j17;
        } else {
            j12 = 0;
            j13 = j8;
        }
        return format(tokenArrLexx, 0L, 0L, j9, j10, j11, j12, j13, z7);
    }

    public static String formatPeriod(long j7, long j8, String str, boolean z7, TimeZone timeZone) {
        int i7 = 0;
        Validate.isTrue(j7 <= j8, "startMillis must not be greater than endMillis", new Object[0]);
        Token[] tokenArrLexx = lexx(str);
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(new Date(j7));
        Calendar calendar2 = Calendar.getInstance(timeZone);
        calendar2.setTime(new Date(j8));
        int i8 = calendar2.get(14) - calendar.get(14);
        int i9 = calendar2.get(13) - calendar.get(13);
        int i10 = calendar2.get(12) - calendar.get(12);
        int i11 = calendar2.get(11) - calendar.get(11);
        int actualMaximum = calendar2.get(5) - calendar.get(5);
        int i12 = calendar2.get(2) - calendar.get(2);
        int i13 = calendar2.get(1) - calendar.get(1);
        while (i8 < 0) {
            i8 += 1000;
            i9--;
        }
        while (i9 < 0) {
            i9 += 60;
            i10--;
        }
        while (i10 < 0) {
            i10 += 60;
            i11--;
        }
        while (i11 < 0) {
            i11 += 24;
            actualMaximum--;
        }
        if (Token.containsTokenWithValue(tokenArrLexx, M)) {
            while (actualMaximum < 0) {
                actualMaximum += calendar.getActualMaximum(5);
                i12--;
                calendar.add(2, 1);
            }
            while (i12 < 0) {
                i12 += 12;
                i13--;
            }
            if (!Token.containsTokenWithValue(tokenArrLexx, f38562y) && i13 != 0) {
                while (i13 != 0) {
                    i12 += i13 * 12;
                    i13 = 0;
                }
            }
        } else {
            if (!Token.containsTokenWithValue(tokenArrLexx, f38562y)) {
                int i14 = calendar2.get(1);
                if (i12 < 0) {
                    i14--;
                }
                while (calendar.get(1) != i14) {
                    int actualMaximum2 = actualMaximum + (calendar.getActualMaximum(6) - calendar.get(6));
                    if ((calendar instanceof GregorianCalendar) && calendar.get(2) == 1 && calendar.get(5) == 29) {
                        actualMaximum2++;
                    }
                    calendar.add(1, 1);
                    actualMaximum = actualMaximum2 + calendar.get(6);
                }
                i13 = 0;
            }
            while (calendar.get(2) != calendar2.get(2)) {
                actualMaximum += calendar.getActualMaximum(5);
                calendar.add(2, 1);
            }
            i12 = 0;
            while (actualMaximum < 0) {
                actualMaximum += calendar.getActualMaximum(5);
                i12--;
                calendar.add(2, 1);
            }
        }
        if (!Token.containsTokenWithValue(tokenArrLexx, f38559d)) {
            i11 += actualMaximum * 24;
            actualMaximum = 0;
        }
        if (!Token.containsTokenWithValue(tokenArrLexx, H)) {
            i10 += i11 * 60;
            i11 = 0;
        }
        if (!Token.containsTokenWithValue(tokenArrLexx, f38560m)) {
            i9 += i10 * 60;
            i10 = 0;
        }
        if (Token.containsTokenWithValue(tokenArrLexx, f38561s)) {
            i7 = i9;
        } else {
            i8 += i9 * 1000;
        }
        return format(tokenArrLexx, i13, i12, actualMaximum, i11, i10, i7, i8, z7);
    }

    static class Token {
        private int count;
        private final Object value;

        Token(Object obj) {
            this.value = obj;
            this.count = 1;
        }

        static boolean containsTokenWithValue(Token[] tokenArr, Object obj) {
            for (Token token : tokenArr) {
                if (token.getValue() == obj) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            if (this.value.getClass() != token.value.getClass() || this.count != token.count) {
                return false;
            }
            Object obj2 = this.value;
            if (obj2 instanceof StringBuilder) {
                return obj2.toString().equals(token.value.toString());
            }
            if (obj2 instanceof Number) {
                return obj2.equals(token.value);
            }
            return obj2 == token.value;
        }

        int getCount() {
            return this.count;
        }

        Object getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        void increment() {
            this.count++;
        }

        public String toString() {
            return StringUtils.repeat(this.value.toString(), this.count);
        }

        Token(Object obj, int i7) {
            this.value = obj;
            this.count = i7;
        }
    }
}
