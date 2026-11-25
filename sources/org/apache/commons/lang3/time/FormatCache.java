package org.apache.commons.lang3.time;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes3.dex */
abstract class FormatCache<F extends Format> {
    static final int NONE = -1;
    private static final ConcurrentMap<MultipartKey, String> cDateTimeInstanceCache = new ConcurrentHashMap(7);
    private final ConcurrentMap<MultipartKey, F> cInstanceCache = new ConcurrentHashMap(7);

    private static class MultipartKey {
        private int hashCode;
        private final Object[] keys;

        public MultipartKey(Object... objArr) {
            this.keys = objArr;
        }

        public boolean equals(Object obj) {
            return Arrays.equals(this.keys, ((MultipartKey) obj).keys);
        }

        public int hashCode() {
            if (this.hashCode == 0) {
                int iHashCode = 0;
                for (Object obj : this.keys) {
                    if (obj != null) {
                        iHashCode = (iHashCode * 7) + obj.hashCode();
                    }
                }
                this.hashCode = iHashCode;
            }
            return this.hashCode;
        }
    }

    FormatCache() {
    }

    private F getDateTimeInstance(Integer num, Integer num2, TimeZone timeZone, Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return (F) getInstance(getPatternForStyle(num, num2, locale), timeZone, locale);
    }

    static String getPatternForStyle(Integer num, Integer num2, Locale locale) {
        DateFormat dateInstance;
        MultipartKey multipartKey = new MultipartKey(num, num2, locale);
        ConcurrentMap<MultipartKey, String> concurrentMap = cDateTimeInstanceCache;
        String str = concurrentMap.get(multipartKey);
        if (str != null) {
            return str;
        }
        try {
            if (num == null) {
                dateInstance = DateFormat.getTimeInstance(num2.intValue(), locale);
            } else {
                dateInstance = num2 == null ? DateFormat.getDateInstance(num.intValue(), locale) : DateFormat.getDateTimeInstance(num.intValue(), num2.intValue(), locale);
            }
            String pattern = ((SimpleDateFormat) dateInstance).toPattern();
            String strPutIfAbsent = concurrentMap.putIfAbsent(multipartKey, pattern);
            return strPutIfAbsent != null ? strPutIfAbsent : pattern;
        } catch (ClassCastException unused) {
            throw new IllegalArgumentException("No date time pattern for locale: " + locale);
        }
    }

    protected abstract F createInstance(String str, TimeZone timeZone, Locale locale);

    F getDateInstance(int i7, TimeZone timeZone, Locale locale) {
        return (F) getDateTimeInstance(Integer.valueOf(i7), (Integer) null, timeZone, locale);
    }

    public F getInstance() {
        return (F) getDateTimeInstance(3, 3, TimeZone.getDefault(), Locale.getDefault());
    }

    F getTimeInstance(int i7, TimeZone timeZone, Locale locale) {
        return (F) getDateTimeInstance((Integer) null, Integer.valueOf(i7), timeZone, locale);
    }

    public F getInstance(String str, TimeZone timeZone, Locale locale) {
        if (str == null) {
            throw new NullPointerException("pattern must not be null");
        }
        if (timeZone == null) {
            timeZone = TimeZone.getDefault();
        }
        if (locale == null) {
            locale = Locale.getDefault();
        }
        MultipartKey multipartKey = new MultipartKey(str, timeZone, locale);
        F f8 = this.cInstanceCache.get(multipartKey);
        if (f8 != null) {
            return f8;
        }
        F f9 = (F) createInstance(str, timeZone, locale);
        F fPutIfAbsent = this.cInstanceCache.putIfAbsent(multipartKey, f9);
        return fPutIfAbsent != null ? fPutIfAbsent : f9;
    }

    F getDateTimeInstance(int i7, int i8, TimeZone timeZone, Locale locale) {
        return (F) getDateTimeInstance(Integer.valueOf(i7), Integer.valueOf(i8), timeZone, locale);
    }
}
