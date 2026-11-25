package org.apache.commons.lang3;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class Validate {
    private static final String DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE = "The value %s is not in the specified exclusive range of %s to %s";
    private static final String DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE = "The value %s is not in the specified inclusive range of %s to %s";
    private static final String DEFAULT_IS_ASSIGNABLE_EX_MESSAGE = "Cannot assign a %s to a %s";
    private static final String DEFAULT_IS_INSTANCE_OF_EX_MESSAGE = "Expected type: %s, actual: %s";
    private static final String DEFAULT_IS_NULL_EX_MESSAGE = "The validated object is null";
    private static final String DEFAULT_IS_TRUE_EX_MESSAGE = "The validated expression is false";
    private static final String DEFAULT_MATCHES_PATTERN_EX = "The string %s does not match the pattern %s";
    private static final String DEFAULT_NOT_BLANK_EX_MESSAGE = "The validated character sequence is blank";
    private static final String DEFAULT_NOT_EMPTY_ARRAY_EX_MESSAGE = "The validated array is empty";
    private static final String DEFAULT_NOT_EMPTY_CHAR_SEQUENCE_EX_MESSAGE = "The validated character sequence is empty";
    private static final String DEFAULT_NOT_EMPTY_COLLECTION_EX_MESSAGE = "The validated collection is empty";
    private static final String DEFAULT_NOT_EMPTY_MAP_EX_MESSAGE = "The validated map is empty";
    private static final String DEFAULT_NO_NULL_ELEMENTS_ARRAY_EX_MESSAGE = "The validated array contains null element at index: %d";
    private static final String DEFAULT_NO_NULL_ELEMENTS_COLLECTION_EX_MESSAGE = "The validated collection contains null element at index: %d";
    private static final String DEFAULT_VALID_INDEX_ARRAY_EX_MESSAGE = "The validated array index is invalid: %d";
    private static final String DEFAULT_VALID_INDEX_CHAR_SEQUENCE_EX_MESSAGE = "The validated character sequence index is invalid: %d";
    private static final String DEFAULT_VALID_INDEX_COLLECTION_EX_MESSAGE = "The validated collection index is invalid: %d";
    private static final String DEFAULT_VALID_STATE_EX_MESSAGE = "The validated state is false";

    public static <T> void exclusiveBetween(T t7, T t8, Comparable<T> comparable) {
        if (comparable.compareTo(t7) <= 0 || comparable.compareTo(t8) >= 0) {
            throw new IllegalArgumentException(String.format(DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE, comparable, t7, t8));
        }
    }

    public static <T> void inclusiveBetween(T t7, T t8, Comparable<T> comparable) {
        if (comparable.compareTo(t7) < 0 || comparable.compareTo(t8) > 0) {
            throw new IllegalArgumentException(String.format(DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE, comparable, t7, t8));
        }
    }

    public static void isAssignableFrom(Class<?> cls, Class<?> cls2) {
        if (cls.isAssignableFrom(cls2)) {
            return;
        }
        Object[] objArr = new Object[2];
        objArr[0] = cls2 == null ? "null" : cls2.getName();
        objArr[1] = cls.getName();
        throw new IllegalArgumentException(String.format(DEFAULT_IS_ASSIGNABLE_EX_MESSAGE, objArr));
    }

    public static void isInstanceOf(Class<?> cls, Object obj) {
        if (cls.isInstance(obj)) {
            return;
        }
        Object[] objArr = new Object[2];
        objArr[0] = cls.getName();
        objArr[1] = obj == null ? "null" : obj.getClass().getName();
        throw new IllegalArgumentException(String.format(DEFAULT_IS_INSTANCE_OF_EX_MESSAGE, objArr));
    }

    public static void isTrue(boolean z7, String str, long j7) {
        if (!z7) {
            throw new IllegalArgumentException(String.format(str, Long.valueOf(j7)));
        }
    }

    public static void matchesPattern(CharSequence charSequence, String str) {
        if (!Pattern.matches(str, charSequence)) {
            throw new IllegalArgumentException(String.format(DEFAULT_MATCHES_PATTERN_EX, charSequence, str));
        }
    }

    public static <T> T[] noNullElements(T[] tArr, String str, Object... objArr) {
        notNull(tArr);
        for (int i7 = 0; i7 < tArr.length; i7++) {
            if (tArr[i7] == null) {
                throw new IllegalArgumentException(String.format(str, ArrayUtils.add((Integer[]) objArr, Integer.valueOf(i7))));
            }
        }
        return tArr;
    }

    public static <T extends CharSequence> T notBlank(T t7, String str, Object... objArr) {
        if (t7 == null) {
            throw new NullPointerException(String.format(str, objArr));
        }
        if (StringUtils.isBlank(t7)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
        return t7;
    }

    public static <T> T[] notEmpty(T[] tArr, String str, Object... objArr) {
        if (tArr == null) {
            throw new NullPointerException(String.format(str, objArr));
        }
        if (tArr.length != 0) {
            return tArr;
        }
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    public static <T> T notNull(T t7) {
        return (T) notNull(t7, DEFAULT_IS_NULL_EX_MESSAGE, new Object[0]);
    }

    public static <T> T[] validIndex(T[] tArr, int i7, String str, Object... objArr) {
        notNull(tArr);
        if (i7 < 0 || i7 >= tArr.length) {
            throw new IndexOutOfBoundsException(String.format(str, objArr));
        }
        return tArr;
    }

    public static void validState(boolean z7) {
        if (!z7) {
            throw new IllegalStateException(DEFAULT_VALID_STATE_EX_MESSAGE);
        }
    }

    public static void isTrue(boolean z7, String str, double d8) {
        if (!z7) {
            throw new IllegalArgumentException(String.format(str, Double.valueOf(d8)));
        }
    }

    public static <T> T notNull(T t7, String str, Object... objArr) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(String.format(str, objArr));
    }

    public static void validState(boolean z7, String str, Object... objArr) {
        if (!z7) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    public static <T> void exclusiveBetween(T t7, T t8, Comparable<T> comparable, String str, Object... objArr) {
        if (comparable.compareTo(t7) <= 0 || comparable.compareTo(t8) >= 0) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T> void inclusiveBetween(T t7, T t8, Comparable<T> comparable, String str, Object... objArr) {
        if (comparable.compareTo(t7) < 0 || comparable.compareTo(t8) > 0) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void isAssignableFrom(Class<?> cls, Class<?> cls2, String str, Object... objArr) {
        if (!cls.isAssignableFrom(cls2)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void isInstanceOf(Class<?> cls, Object obj, String str, Object... objArr) {
        if (!cls.isInstance(obj)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void isTrue(boolean z7, String str, Object... objArr) {
        if (!z7) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void matchesPattern(CharSequence charSequence, String str, String str2, Object... objArr) {
        if (!Pattern.matches(str, charSequence)) {
            throw new IllegalArgumentException(String.format(str2, objArr));
        }
    }

    public static void isTrue(boolean z7) {
        if (!z7) {
            throw new IllegalArgumentException(DEFAULT_IS_TRUE_EX_MESSAGE);
        }
    }

    public static <T extends CharSequence> T notBlank(T t7) {
        return (T) notBlank(t7, DEFAULT_NOT_BLANK_EX_MESSAGE, new Object[0]);
    }

    public static <T> T[] notEmpty(T[] tArr) {
        return (T[]) notEmpty(tArr, DEFAULT_NOT_EMPTY_ARRAY_EX_MESSAGE, new Object[0]);
    }

    public static <T> T[] validIndex(T[] tArr, int i7) {
        return (T[]) validIndex(tArr, i7, DEFAULT_VALID_INDEX_ARRAY_EX_MESSAGE, Integer.valueOf(i7));
    }

    public static void exclusiveBetween(long j7, long j8, long j9) {
        if (j9 <= j7 || j9 >= j8) {
            throw new IllegalArgumentException(String.format(DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE, Long.valueOf(j9), Long.valueOf(j7), Long.valueOf(j8)));
        }
    }

    public static void inclusiveBetween(long j7, long j8, long j9) {
        if (j9 < j7 || j9 > j8) {
            throw new IllegalArgumentException(String.format(DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE, Long.valueOf(j9), Long.valueOf(j7), Long.valueOf(j8)));
        }
    }

    public static <T extends Collection<?>> T notEmpty(T t7, String str, Object... objArr) {
        if (t7 != null) {
            if (t7.isEmpty()) {
                throw new IllegalArgumentException(String.format(str, objArr));
            }
            return t7;
        }
        throw new NullPointerException(String.format(str, objArr));
    }

    public static <T extends Collection<?>> T validIndex(T t7, int i7, String str, Object... objArr) {
        notNull(t7);
        if (i7 < 0 || i7 >= t7.size()) {
            throw new IndexOutOfBoundsException(String.format(str, objArr));
        }
        return t7;
    }

    public static void exclusiveBetween(long j7, long j8, long j9, String str) {
        if (j9 <= j7 || j9 >= j8) {
            throw new IllegalArgumentException(String.format(str, new Object[0]));
        }
    }

    public static void inclusiveBetween(long j7, long j8, long j9, String str) {
        if (j9 < j7 || j9 > j8) {
            throw new IllegalArgumentException(String.format(str, new Object[0]));
        }
    }

    public static <T> T[] noNullElements(T[] tArr) {
        return (T[]) noNullElements(tArr, DEFAULT_NO_NULL_ELEMENTS_ARRAY_EX_MESSAGE, new Object[0]);
    }

    public static void exclusiveBetween(double d8, double d9, double d10) {
        if (d10 <= d8 || d10 >= d9) {
            throw new IllegalArgumentException(String.format(DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE, Double.valueOf(d10), Double.valueOf(d8), Double.valueOf(d9)));
        }
    }

    public static void inclusiveBetween(double d8, double d9, double d10) {
        if (d10 < d8 || d10 > d9) {
            throw new IllegalArgumentException(String.format(DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE, Double.valueOf(d10), Double.valueOf(d8), Double.valueOf(d9)));
        }
    }

    public static <T extends Iterable<?>> T noNullElements(T t7, String str, Object... objArr) {
        notNull(t7);
        Iterator it = t7.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException(String.format(str, ArrayUtils.addAll(objArr, Integer.valueOf(i7))));
            }
            i7++;
        }
        return t7;
    }

    public static void exclusiveBetween(double d8, double d9, double d10, String str) {
        if (d10 <= d8 || d10 >= d9) {
            throw new IllegalArgumentException(String.format(str, new Object[0]));
        }
    }

    public static void inclusiveBetween(double d8, double d9, double d10, String str) {
        if (d10 < d8 || d10 > d9) {
            throw new IllegalArgumentException(String.format(str, new Object[0]));
        }
    }

    public static <T extends Collection<?>> T notEmpty(T t7) {
        return (T) notEmpty(t7, DEFAULT_NOT_EMPTY_COLLECTION_EX_MESSAGE, new Object[0]);
    }

    public static <T extends Collection<?>> T validIndex(T t7, int i7) {
        return (T) validIndex(t7, i7, DEFAULT_VALID_INDEX_COLLECTION_EX_MESSAGE, Integer.valueOf(i7));
    }

    public static <T extends Map<?, ?>> T notEmpty(T t7, String str, Object... objArr) {
        if (t7 != null) {
            if (t7.isEmpty()) {
                throw new IllegalArgumentException(String.format(str, objArr));
            }
            return t7;
        }
        throw new NullPointerException(String.format(str, objArr));
    }

    public static <T extends CharSequence> T validIndex(T t7, int i7, String str, Object... objArr) {
        notNull(t7);
        if (i7 < 0 || i7 >= t7.length()) {
            throw new IndexOutOfBoundsException(String.format(str, objArr));
        }
        return t7;
    }

    public static <T extends Iterable<?>> T noNullElements(T t7) {
        return (T) noNullElements(t7, DEFAULT_NO_NULL_ELEMENTS_COLLECTION_EX_MESSAGE, new Object[0]);
    }

    public static <T extends Map<?, ?>> T notEmpty(T t7) {
        return (T) notEmpty(t7, DEFAULT_NOT_EMPTY_MAP_EX_MESSAGE, new Object[0]);
    }

    public static <T extends CharSequence> T validIndex(T t7, int i7) {
        return (T) validIndex(t7, i7, DEFAULT_VALID_INDEX_CHAR_SEQUENCE_EX_MESSAGE, Integer.valueOf(i7));
    }

    public static <T extends CharSequence> T notEmpty(T t7, String str, Object... objArr) {
        if (t7 != null) {
            if (t7.length() != 0) {
                return t7;
            }
            throw new IllegalArgumentException(String.format(str, objArr));
        }
        throw new NullPointerException(String.format(str, objArr));
    }

    public static <T extends CharSequence> T notEmpty(T t7) {
        return (T) notEmpty(t7, DEFAULT_NOT_EMPTY_CHAR_SEQUENCE_EX_MESSAGE, new Object[0]);
    }
}
