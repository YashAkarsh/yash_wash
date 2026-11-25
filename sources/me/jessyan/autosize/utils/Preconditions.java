package me.jessyan.autosize.utils;

import android.os.Looper;

/* JADX INFO: loaded from: classes3.dex */
public final class Preconditions {
    private Preconditions() {
        throw new IllegalStateException("you can't instantiate me!");
    }

    private static String badElementIndex(int i7, int i8, String str) {
        if (i7 < 0) {
            return format("%s (%s) must not be negative", str, Integer.valueOf(i7));
        }
        if (i8 >= 0) {
            return format("%s (%s) must be less than size (%s)", str, Integer.valueOf(i7), Integer.valueOf(i8));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(i8);
        throw new IllegalArgumentException(sb.toString());
    }

    private static String badPositionIndex(int i7, int i8, String str) {
        if (i7 < 0) {
            return format("%s (%s) must not be negative", str, Integer.valueOf(i7));
        }
        if (i8 >= 0) {
            return format("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i7), Integer.valueOf(i8));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(i8);
        throw new IllegalArgumentException(sb.toString());
    }

    private static String badPositionIndexes(int i7, int i8, int i9) {
        if (i7 < 0 || i7 > i9) {
            return badPositionIndex(i7, i9, "start index");
        }
        return (i8 < 0 || i8 > i9) ? badPositionIndex(i8, i9, "end index") : format("end index (%s) must not be less than start index (%s)", Integer.valueOf(i8), Integer.valueOf(i7));
    }

    public static void checkArgument(boolean z7) {
        if (!z7) {
            throw new IllegalArgumentException();
        }
    }

    public static int checkElementIndex(int i7, int i8) {
        return checkElementIndex(i7, i8, "index");
    }

    public static void checkMainThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("Not in applications main thread");
        }
    }

    public static <T> T checkNotNull(T t7) {
        t7.getClass();
        return t7;
    }

    public static int checkPositionIndex(int i7, int i8) {
        return checkPositionIndex(i7, i8, "index");
    }

    public static void checkPositionIndexes(int i7, int i8, int i9) {
        if (i7 < 0 || i8 < i7 || i8 > i9) {
            throw new IndexOutOfBoundsException(badPositionIndexes(i7, i8, i9));
        }
    }

    public static void checkState(boolean z7) {
        if (!z7) {
            throw new IllegalStateException();
        }
    }

    static String format(String str, Object... objArr) {
        int iIndexOf;
        String strValueOf = String.valueOf(str);
        StringBuilder sb = new StringBuilder(strValueOf.length() + (objArr.length * 16));
        int i7 = 0;
        int i8 = 0;
        while (i7 < objArr.length && (iIndexOf = strValueOf.indexOf("%s", i8)) != -1) {
            sb.append(strValueOf.substring(i8, iIndexOf));
            sb.append(objArr[i7]);
            i8 = iIndexOf + 2;
            i7++;
        }
        sb.append(strValueOf.substring(i8));
        if (i7 < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i7]);
            for (int i9 = i7 + 1; i9 < objArr.length; i9++) {
                sb.append(", ");
                sb.append(objArr[i9]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static void checkArgument(boolean z7, Object obj) {
        if (!z7) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static int checkElementIndex(int i7, int i8, String str) {
        if (i7 < 0 || i7 >= i8) {
            throw new IndexOutOfBoundsException(badElementIndex(i7, i8, str));
        }
        return i7;
    }

    public static <T> T checkNotNull(T t7, Object obj) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static int checkPositionIndex(int i7, int i8, String str) {
        if (i7 < 0 || i7 > i8) {
            throw new IndexOutOfBoundsException(badPositionIndex(i7, i8, str));
        }
        return i7;
    }

    public static void checkState(boolean z7, Object obj) {
        if (!z7) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void checkArgument(boolean z7, String str, Object... objArr) {
        if (!z7) {
            throw new IllegalArgumentException(format(str, objArr));
        }
    }

    public static <T> T checkNotNull(T t7, String str, Object... objArr) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(format(str, objArr));
    }

    public static void checkState(boolean z7, String str, Object... objArr) {
        if (!z7) {
            throw new IllegalStateException(format(str, objArr));
        }
    }
}
