package org.apache.commons.lang3.time;

import easypay.appinvoke.manager.Constants;
import f4.d;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes3.dex */
public class FastDatePrinter implements DatePrinter, Serializable {
    public static final int FULL = 0;
    public static final int LONG = 1;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    private static final ConcurrentMap<TimeZoneDisplayKey, String> cTimeZoneDisplayCache = new ConcurrentHashMap(7);
    private static final long serialVersionUID = 1;
    private final Locale mLocale;
    private transient int mMaxLengthEstimate;
    private final String mPattern;
    private transient Rule[] mRules;
    private final TimeZone mTimeZone;

    private static class CharacterLiteral implements Rule {
        private final char mValue;

        CharacterLiteral(char c8) {
            this.mValue = c8;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.mValue);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 1;
        }
    }

    private static class Iso8601_Rule implements Rule {
        final int length;
        static final Iso8601_Rule ISO8601_HOURS = new Iso8601_Rule(3);
        static final Iso8601_Rule ISO8601_HOURS_MINUTES = new Iso8601_Rule(5);
        static final Iso8601_Rule ISO8601_HOURS_COLON_MINUTES = new Iso8601_Rule(6);

        Iso8601_Rule(int i7) {
            this.length = i7;
        }

        static Iso8601_Rule getRule(int i7) {
            if (i7 == 1) {
                return ISO8601_HOURS;
            }
            if (i7 == 2) {
                return ISO8601_HOURS_MINUTES;
            }
            if (i7 == 3) {
                return ISO8601_HOURS_COLON_MINUTES;
            }
            throw new IllegalArgumentException("invalid number of X");
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            int i7 = calendar.get(15);
            if (i7 == 0) {
                stringBuffer.append("Z");
                return;
            }
            int i8 = i7 + calendar.get(16);
            if (i8 < 0) {
                stringBuffer.append('-');
                i8 = -i8;
            } else {
                stringBuffer.append('+');
            }
            int i9 = i8 / 3600000;
            FastDatePrinter.appendDigits(stringBuffer, i9);
            int i10 = this.length;
            if (i10 < 5) {
                return;
            }
            if (i10 == 6) {
                stringBuffer.append(':');
            }
            FastDatePrinter.appendDigits(stringBuffer, (i8 / 60000) - (i9 * 60));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.length;
        }
    }

    private interface NumberRule extends Rule {
        void appendTo(StringBuffer stringBuffer, int i7);
    }

    private static class PaddedNumberField implements NumberRule {
        private final int mField;
        private final int mSize;

        PaddedNumberField(int i7, int i8) {
            if (i8 < 3) {
                throw new IllegalArgumentException();
            }
            this.mField = i7;
            this.mSize = i8;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(this.mField));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mSize;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(StringBuffer stringBuffer, int i7) {
            for (int i8 = 0; i8 < this.mSize; i8++) {
                stringBuffer.append('0');
            }
            int length = stringBuffer.length();
            while (i7 > 0) {
                length--;
                stringBuffer.setCharAt(length, (char) ((i7 % 10) + 48));
                i7 /= 10;
            }
        }
    }

    private interface Rule {
        void appendTo(StringBuffer stringBuffer, Calendar calendar);

        int estimateLength();
    }

    private static class StringLiteral implements Rule {
        private final String mValue;

        StringLiteral(String str) {
            this.mValue = str;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.mValue);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mValue.length();
        }
    }

    private static class TextField implements Rule {
        private final int mField;
        private final String[] mValues;

        TextField(int i7, String[] strArr) {
            this.mField = i7;
            this.mValues = strArr;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.mValues[calendar.get(this.mField)]);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            int length = this.mValues.length;
            int i7 = 0;
            while (true) {
                length--;
                if (length < 0) {
                    return i7;
                }
                int length2 = this.mValues[length].length();
                if (length2 > i7) {
                    i7 = length2;
                }
            }
        }
    }

    private static class TimeZoneDisplayKey {
        private final Locale mLocale;
        private final int mStyle;
        private final TimeZone mTimeZone;

        TimeZoneDisplayKey(TimeZone timeZone, boolean z7, int i7, Locale locale) {
            this.mTimeZone = timeZone;
            if (z7) {
                this.mStyle = Integer.MIN_VALUE | i7;
            } else {
                this.mStyle = i7;
            }
            this.mLocale = locale;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TimeZoneDisplayKey)) {
                return false;
            }
            TimeZoneDisplayKey timeZoneDisplayKey = (TimeZoneDisplayKey) obj;
            return this.mTimeZone.equals(timeZoneDisplayKey.mTimeZone) && this.mStyle == timeZoneDisplayKey.mStyle && this.mLocale.equals(timeZoneDisplayKey.mLocale);
        }

        public int hashCode() {
            return (((this.mStyle * 31) + this.mLocale.hashCode()) * 31) + this.mTimeZone.hashCode();
        }
    }

    private static class TimeZoneNameRule implements Rule {
        private final String mDaylight;
        private final Locale mLocale;
        private final String mStandard;
        private final int mStyle;

        TimeZoneNameRule(TimeZone timeZone, Locale locale, int i7) {
            this.mLocale = locale;
            this.mStyle = i7;
            this.mStandard = FastDatePrinter.getTimeZoneDisplay(timeZone, false, i7, locale);
            this.mDaylight = FastDatePrinter.getTimeZoneDisplay(timeZone, true, i7, locale);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            TimeZone timeZone = calendar.getTimeZone();
            if (calendar.get(16) != 0) {
                stringBuffer.append(FastDatePrinter.getTimeZoneDisplay(timeZone, true, this.mStyle, this.mLocale));
            } else {
                stringBuffer.append(FastDatePrinter.getTimeZoneDisplay(timeZone, false, this.mStyle, this.mLocale));
            }
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return Math.max(this.mStandard.length(), this.mDaylight.length());
        }
    }

    private static class TimeZoneNumberRule implements Rule {
        final boolean mColon;
        final boolean mISO8601;
        static final TimeZoneNumberRule INSTANCE_COLON = new TimeZoneNumberRule(true, false);
        static final TimeZoneNumberRule INSTANCE_NO_COLON = new TimeZoneNumberRule(false, false);
        static final TimeZoneNumberRule INSTANCE_ISO_8601 = new TimeZoneNumberRule(true, true);

        TimeZoneNumberRule(boolean z7, boolean z8) {
            this.mColon = z7;
            this.mISO8601 = z8;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            if (this.mISO8601 && calendar.getTimeZone().getID().equals("UTC")) {
                stringBuffer.append("Z");
                return;
            }
            int i7 = calendar.get(15) + calendar.get(16);
            if (i7 < 0) {
                stringBuffer.append('-');
                i7 = -i7;
            } else {
                stringBuffer.append('+');
            }
            int i8 = i7 / 3600000;
            FastDatePrinter.appendDigits(stringBuffer, i8);
            if (this.mColon) {
                stringBuffer.append(':');
            }
            FastDatePrinter.appendDigits(stringBuffer, (i7 / 60000) - (i8 * 60));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 5;
        }
    }

    private static class TwoDigitMonthField implements NumberRule {
        static final TwoDigitMonthField INSTANCE = new TwoDigitMonthField();

        TwoDigitMonthField() {
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(2) + 1);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(StringBuffer stringBuffer, int i7) {
            FastDatePrinter.appendDigits(stringBuffer, i7);
        }
    }

    private static class TwoDigitNumberField implements NumberRule {
        private final int mField;

        TwoDigitNumberField(int i7) {
            this.mField = i7;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(this.mField));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(StringBuffer stringBuffer, int i7) {
            if (i7 < 100) {
                FastDatePrinter.appendDigits(stringBuffer, i7);
            } else {
                stringBuffer.append(i7);
            }
        }
    }

    private static class TwoDigitYearField implements NumberRule {
        static final TwoDigitYearField INSTANCE = new TwoDigitYearField();

        TwoDigitYearField() {
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(1) % 100);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(StringBuffer stringBuffer, int i7) {
            FastDatePrinter.appendDigits(stringBuffer, i7);
        }
    }

    private static class UnpaddedMonthField implements NumberRule {
        static final UnpaddedMonthField INSTANCE = new UnpaddedMonthField();

        UnpaddedMonthField() {
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(2) + 1);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(StringBuffer stringBuffer, int i7) {
            if (i7 < 10) {
                stringBuffer.append((char) (i7 + 48));
            } else {
                FastDatePrinter.appendDigits(stringBuffer, i7);
            }
        }
    }

    private static class UnpaddedNumberField implements NumberRule {
        private final int mField;

        UnpaddedNumberField(int i7) {
            this.mField = i7;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(this.mField));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 4;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(StringBuffer stringBuffer, int i7) {
            if (i7 < 10) {
                stringBuffer.append((char) (i7 + 48));
            } else if (i7 < 100) {
                FastDatePrinter.appendDigits(stringBuffer, i7);
            } else {
                stringBuffer.append(i7);
            }
        }
    }

    protected FastDatePrinter(String str, TimeZone timeZone, Locale locale) {
        this.mPattern = str;
        this.mTimeZone = timeZone;
        this.mLocale = locale;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void appendDigits(StringBuffer stringBuffer, int i7) {
        stringBuffer.append((char) ((i7 / 10) + 48));
        stringBuffer.append((char) ((i7 % 10) + 48));
    }

    private String applyRulesToString(Calendar calendar) {
        return applyRules(calendar, new StringBuffer(this.mMaxLengthEstimate)).toString();
    }

    static String getTimeZoneDisplay(TimeZone timeZone, boolean z7, int i7, Locale locale) {
        TimeZoneDisplayKey timeZoneDisplayKey = new TimeZoneDisplayKey(timeZone, z7, i7, locale);
        ConcurrentMap<TimeZoneDisplayKey, String> concurrentMap = cTimeZoneDisplayCache;
        String str = concurrentMap.get(timeZoneDisplayKey);
        if (str != null) {
            return str;
        }
        String displayName = timeZone.getDisplayName(z7, i7, locale);
        String strPutIfAbsent = concurrentMap.putIfAbsent(timeZoneDisplayKey, displayName);
        return strPutIfAbsent != null ? strPutIfAbsent : displayName;
    }

    private void init() {
        List<Rule> pattern = parsePattern();
        Rule[] ruleArr = (Rule[]) pattern.toArray(new Rule[pattern.size()]);
        this.mRules = ruleArr;
        int length = ruleArr.length;
        int iEstimateLength = 0;
        while (true) {
            length--;
            if (length < 0) {
                this.mMaxLengthEstimate = iEstimateLength;
                return;
            }
            iEstimateLength += this.mRules[length].estimateLength();
        }
    }

    private GregorianCalendar newCalendar() {
        return new GregorianCalendar(this.mTimeZone, this.mLocale);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        init();
    }

    protected StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) {
        for (Rule rule : this.mRules) {
            rule.appendTo(stringBuffer, calendar);
        }
        return stringBuffer;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FastDatePrinter)) {
            return false;
        }
        FastDatePrinter fastDatePrinter = (FastDatePrinter) obj;
        return this.mPattern.equals(fastDatePrinter.mPattern) && this.mTimeZone.equals(fastDatePrinter.mTimeZone) && this.mLocale.equals(fastDatePrinter.mLocale);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (obj instanceof Date) {
            return format((Date) obj, stringBuffer);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj, stringBuffer);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue(), stringBuffer);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown class: ");
        sb.append(obj == null ? "<null>" : obj.getClass().getName());
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public Locale getLocale() {
        return this.mLocale;
    }

    public int getMaxLengthEstimate() {
        return this.mMaxLengthEstimate;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String getPattern() {
        return this.mPattern;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public TimeZone getTimeZone() {
        return this.mTimeZone;
    }

    public int hashCode() {
        return this.mPattern.hashCode() + ((this.mTimeZone.hashCode() + (this.mLocale.hashCode() * 13)) * 13);
    }

    protected List<Rule> parsePattern() {
        boolean z7;
        int i7;
        Object objSelectNumberRule;
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.mLocale);
        ArrayList arrayList = new ArrayList();
        String[] eras = dateFormatSymbols.getEras();
        String[] months = dateFormatSymbols.getMonths();
        String[] shortMonths = dateFormatSymbols.getShortMonths();
        String[] weekdays = dateFormatSymbols.getWeekdays();
        String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
        String[] amPmStrings = dateFormatSymbols.getAmPmStrings();
        int length = this.mPattern.length();
        int[] iArr = new int[1];
        int i8 = 0;
        int i9 = 0;
        while (i9 < length) {
            iArr[i8] = i9;
            String token = parseToken(this.mPattern, iArr);
            int i10 = iArr[i8];
            int length2 = token.length();
            if (length2 == 0) {
                return arrayList;
            }
            char cCharAt = token.charAt(i8);
            if (cCharAt == 'W') {
                z7 = true;
                i7 = 0;
                objSelectNumberRule = selectNumberRule(4, length2);
            } else if (cCharAt == 'X') {
                z7 = true;
                i7 = 0;
                objSelectNumberRule = Iso8601_Rule.getRule(length2);
            } else if (cCharAt == 'y') {
                i7 = 0;
                if (length2 == 2) {
                    objSelectNumberRule = TwoDigitYearField.INSTANCE;
                    z7 = true;
                } else {
                    if (length2 < 4) {
                        length2 = 4;
                    }
                    z7 = true;
                    objSelectNumberRule = selectNumberRule(1, length2);
                }
            } else if (cCharAt != 'z') {
                switch (cCharAt) {
                    case '\'':
                        String strSubstring = token.substring(1);
                        objSelectNumberRule = strSubstring.length() == 1 ? new CharacterLiteral(strSubstring.charAt(0)) : new StringLiteral(strSubstring);
                        z7 = true;
                        i7 = 0;
                        break;
                    case 'K':
                        objSelectNumberRule = selectNumberRule(10, length2);
                        z7 = true;
                        i7 = 0;
                        break;
                    case 'M':
                        if (length2 >= 4) {
                            objSelectNumberRule = new TextField(2, months);
                        } else if (length2 == 3) {
                            objSelectNumberRule = new TextField(2, shortMonths);
                        } else {
                            objSelectNumberRule = length2 == 2 ? TwoDigitMonthField.INSTANCE : UnpaddedMonthField.INSTANCE;
                        }
                        z7 = true;
                        i7 = 0;
                        break;
                    case 'S':
                        objSelectNumberRule = selectNumberRule(14, length2);
                        z7 = true;
                        i7 = 0;
                        break;
                    case 'Z':
                        if (length2 == 1) {
                            objSelectNumberRule = TimeZoneNumberRule.INSTANCE_NO_COLON;
                        } else {
                            objSelectNumberRule = length2 == 2 ? TimeZoneNumberRule.INSTANCE_ISO_8601 : TimeZoneNumberRule.INSTANCE_COLON;
                        }
                        z7 = true;
                        i7 = 0;
                        break;
                    case 'a':
                        objSelectNumberRule = new TextField(9, amPmStrings);
                        z7 = true;
                        i7 = 0;
                        break;
                    case 'd':
                        objSelectNumberRule = selectNumberRule(5, length2);
                        z7 = true;
                        i7 = 0;
                        break;
                    case 'h':
                        objSelectNumberRule = new TwelveHourField(selectNumberRule(10, length2));
                        z7 = true;
                        i7 = 0;
                        break;
                    case Constants.OTP_FILLER_WEB_SUCCESS /* 107 */:
                        objSelectNumberRule = new TwentyFourHourField(selectNumberRule(11, length2));
                        z7 = true;
                        i7 = 0;
                        break;
                    case 'm':
                        objSelectNumberRule = selectNumberRule(12, length2);
                        z7 = true;
                        i7 = 0;
                        break;
                    case 's':
                        objSelectNumberRule = selectNumberRule(13, length2);
                        z7 = true;
                        i7 = 0;
                        break;
                    case 'w':
                        objSelectNumberRule = selectNumberRule(3, length2);
                        z7 = true;
                        i7 = 0;
                        break;
                    default:
                        switch (cCharAt) {
                            case d.f33912b /* 68 */:
                                objSelectNumberRule = selectNumberRule(6, length2);
                                z7 = true;
                                i7 = 0;
                                break;
                            case d.f33916f /* 69 */:
                                objSelectNumberRule = new TextField(7, length2 < 4 ? shortWeekdays : weekdays);
                                z7 = true;
                                i7 = 0;
                                break;
                            case d.f33913c /* 70 */:
                                objSelectNumberRule = selectNumberRule(8, length2);
                                z7 = true;
                                i7 = 0;
                                break;
                            case 'G':
                                objSelectNumberRule = new TextField(0, eras);
                                i7 = 0;
                                z7 = true;
                                break;
                            case d.f33918h /* 72 */:
                                objSelectNumberRule = selectNumberRule(11, length2);
                                z7 = true;
                                i7 = 0;
                                break;
                            default:
                                throw new IllegalArgumentException("Illegal pattern component: " + token);
                        }
                        break;
                }
            } else if (length2 >= 4) {
                objSelectNumberRule = new TimeZoneNameRule(this.mTimeZone, this.mLocale, 1);
                z7 = true;
                i7 = 0;
            } else {
                i7 = 0;
                objSelectNumberRule = new TimeZoneNameRule(this.mTimeZone, this.mLocale, 0);
                z7 = true;
            }
            arrayList.add(objSelectNumberRule);
            i9 = i10 + 1;
            i8 = i7;
        }
        return arrayList;
    }

    protected String parseToken(String str, int[] iArr) {
        StringBuilder sb = new StringBuilder();
        int i7 = iArr[0];
        int length = str.length();
        char cCharAt = str.charAt(i7);
        if ((cCharAt < 'A' || cCharAt > 'Z') && (cCharAt < 'a' || cCharAt > 'z')) {
            sb.append('\'');
            boolean z7 = false;
            while (i7 < length) {
                char cCharAt2 = str.charAt(i7);
                if (cCharAt2 != '\'') {
                    if (!z7 && ((cCharAt2 >= 'A' && cCharAt2 <= 'Z') || (cCharAt2 >= 'a' && cCharAt2 <= 'z'))) {
                        i7--;
                        break;
                    }
                    sb.append(cCharAt2);
                } else {
                    int i8 = i7 + 1;
                    if (i8 >= length || str.charAt(i8) != '\'') {
                        z7 = !z7;
                    } else {
                        sb.append(cCharAt2);
                        i7 = i8;
                    }
                }
                i7++;
            }
        } else {
            sb.append(cCharAt);
            while (true) {
                int i9 = i7 + 1;
                if (i9 >= length || str.charAt(i9) != cCharAt) {
                    break;
                }
                sb.append(cCharAt);
                i7 = i9;
            }
        }
        iArr[0] = i7;
        return sb.toString();
    }

    protected NumberRule selectNumberRule(int i7, int i8) {
        if (i8 != 1) {
            return i8 != 2 ? new PaddedNumberField(i7, i8) : new TwoDigitNumberField(i7);
        }
        return new UnpaddedNumberField(i7);
    }

    public String toString() {
        return "FastDatePrinter[" + this.mPattern + "," + this.mLocale + "," + this.mTimeZone.getID() + "]";
    }

    private static class TwelveHourField implements NumberRule {
        private final NumberRule mRule;

        TwelveHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            int leastMaximum = calendar.get(10);
            if (leastMaximum == 0) {
                leastMaximum = calendar.getLeastMaximum(10) + 1;
            }
            this.mRule.appendTo(stringBuffer, leastMaximum);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(StringBuffer stringBuffer, int i7) {
            this.mRule.appendTo(stringBuffer, i7);
        }
    }

    private static class TwentyFourHourField implements NumberRule {
        private final NumberRule mRule;

        TwentyFourHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            int maximum = calendar.get(11);
            if (maximum == 0) {
                maximum = calendar.getMaximum(11) + 1;
            }
            this.mRule.appendTo(stringBuffer, maximum);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(StringBuffer stringBuffer, int i7) {
            this.mRule.appendTo(stringBuffer, i7);
        }
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(long j7) {
        GregorianCalendar gregorianCalendarNewCalendar = newCalendar();
        gregorianCalendarNewCalendar.setTimeInMillis(j7);
        return applyRulesToString(gregorianCalendarNewCalendar);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(Date date) {
        GregorianCalendar gregorianCalendarNewCalendar = newCalendar();
        gregorianCalendarNewCalendar.setTime(date);
        return applyRulesToString(gregorianCalendarNewCalendar);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(Calendar calendar) {
        return format(calendar, new StringBuffer(this.mMaxLengthEstimate)).toString();
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(long j7, StringBuffer stringBuffer) {
        return format(new Date(j7), stringBuffer);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(Date date, StringBuffer stringBuffer) {
        GregorianCalendar gregorianCalendarNewCalendar = newCalendar();
        gregorianCalendarNewCalendar.setTime(date);
        return applyRules(gregorianCalendarNewCalendar, stringBuffer);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        return applyRules(calendar, stringBuffer);
    }
}
