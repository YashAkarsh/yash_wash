package org.apache.commons.lang3.time;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes3.dex */
public class FastDateFormat extends Format implements DateParser, DatePrinter {
    public static final int FULL = 0;
    public static final int LONG = 1;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    private static final FormatCache<FastDateFormat> cache = new FormatCache<FastDateFormat>() { // from class: org.apache.commons.lang3.time.FastDateFormat.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.commons.lang3.time.FormatCache
        public FastDateFormat createInstance(String str, TimeZone timeZone, Locale locale) {
            return new FastDateFormat(str, timeZone, locale);
        }
    };
    private static final long serialVersionUID = 2;
    private final FastDateParser parser;
    private final FastDatePrinter printer;

    protected FastDateFormat(String str, TimeZone timeZone, Locale locale) {
        this(str, timeZone, locale, null);
    }

    public static FastDateFormat getDateInstance(int i7) {
        return (FastDateFormat) cache.getDateInstance(i7, null, null);
    }

    public static FastDateFormat getDateTimeInstance(int i7, int i8) {
        return (FastDateFormat) cache.getDateTimeInstance(i7, i8, (TimeZone) null, (Locale) null);
    }

    public static FastDateFormat getInstance() {
        return (FastDateFormat) cache.getInstance();
    }

    public static FastDateFormat getTimeInstance(int i7) {
        return (FastDateFormat) cache.getTimeInstance(i7, null, null);
    }

    protected StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) {
        return this.printer.applyRules(calendar, stringBuffer);
    }

    public boolean equals(Object obj) {
        if (obj instanceof FastDateFormat) {
            return this.printer.equals(((FastDateFormat) obj).printer);
        }
        return false;
    }

    @Override // java.text.Format, org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return this.printer.format(obj, stringBuffer, fieldPosition);
    }

    @Override // org.apache.commons.lang3.time.DateParser, org.apache.commons.lang3.time.DatePrinter
    public Locale getLocale() {
        return this.printer.getLocale();
    }

    public int getMaxLengthEstimate() {
        return this.printer.getMaxLengthEstimate();
    }

    @Override // org.apache.commons.lang3.time.DateParser, org.apache.commons.lang3.time.DatePrinter
    public String getPattern() {
        return this.printer.getPattern();
    }

    @Override // org.apache.commons.lang3.time.DateParser, org.apache.commons.lang3.time.DatePrinter
    public TimeZone getTimeZone() {
        return this.printer.getTimeZone();
    }

    public int hashCode() {
        return this.printer.hashCode();
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public Date parse(String str) throws ParseException {
        return this.parser.parse(str);
    }

    @Override // java.text.Format, org.apache.commons.lang3.time.DateParser
    public Object parseObject(String str, ParsePosition parsePosition) {
        return this.parser.parseObject(str, parsePosition);
    }

    public String toString() {
        return "FastDateFormat[" + this.printer.getPattern() + "," + this.printer.getLocale() + "," + this.printer.getTimeZone().getID() + "]";
    }

    protected FastDateFormat(String str, TimeZone timeZone, Locale locale, Date date) {
        this.printer = new FastDatePrinter(str, timeZone, locale);
        this.parser = new FastDateParser(str, timeZone, locale, date);
    }

    public static FastDateFormat getDateInstance(int i7, Locale locale) {
        return (FastDateFormat) cache.getDateInstance(i7, null, locale);
    }

    public static FastDateFormat getDateTimeInstance(int i7, int i8, Locale locale) {
        return (FastDateFormat) cache.getDateTimeInstance(i7, i8, (TimeZone) null, locale);
    }

    public static FastDateFormat getInstance(String str) {
        return (FastDateFormat) cache.getInstance(str, null, null);
    }

    public static FastDateFormat getTimeInstance(int i7, Locale locale) {
        return (FastDateFormat) cache.getTimeInstance(i7, null, locale);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(long j7) {
        return this.printer.format(j7);
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public Date parse(String str, ParsePosition parsePosition) {
        return this.parser.parse(str, parsePosition);
    }

    public static FastDateFormat getDateInstance(int i7, TimeZone timeZone) {
        return (FastDateFormat) cache.getDateInstance(i7, timeZone, null);
    }

    public static FastDateFormat getDateTimeInstance(int i7, int i8, TimeZone timeZone) {
        return getDateTimeInstance(i7, i8, timeZone, null);
    }

    public static FastDateFormat getInstance(String str, TimeZone timeZone) {
        return (FastDateFormat) cache.getInstance(str, timeZone, null);
    }

    public static FastDateFormat getTimeInstance(int i7, TimeZone timeZone) {
        return (FastDateFormat) cache.getTimeInstance(i7, timeZone, null);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(Date date) {
        return this.printer.format(date);
    }

    public static FastDateFormat getDateInstance(int i7, TimeZone timeZone, Locale locale) {
        return (FastDateFormat) cache.getDateInstance(i7, timeZone, locale);
    }

    public static FastDateFormat getDateTimeInstance(int i7, int i8, TimeZone timeZone, Locale locale) {
        return (FastDateFormat) cache.getDateTimeInstance(i7, i8, timeZone, locale);
    }

    public static FastDateFormat getInstance(String str, Locale locale) {
        return (FastDateFormat) cache.getInstance(str, null, locale);
    }

    public static FastDateFormat getTimeInstance(int i7, TimeZone timeZone, Locale locale) {
        return (FastDateFormat) cache.getTimeInstance(i7, timeZone, locale);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(Calendar calendar) {
        return this.printer.format(calendar);
    }

    public static FastDateFormat getInstance(String str, TimeZone timeZone, Locale locale) {
        return (FastDateFormat) cache.getInstance(str, timeZone, locale);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(long j7, StringBuffer stringBuffer) {
        return this.printer.format(j7, stringBuffer);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(Date date, StringBuffer stringBuffer) {
        return this.printer.format(date, stringBuffer);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        return this.printer.format(calendar, stringBuffer);
    }
}
