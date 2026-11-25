package com.google.gson.internal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class k {
    private static String a(int i7) {
        if (i7 == 0) {
            return "EEEE, MMMM d, y";
        }
        if (i7 == 1) {
            return "MMMM d, y";
        }
        if (i7 == 2) {
            return "MMM d, y";
        }
        if (i7 == 3) {
            return "M/d/yy";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i7);
    }

    private static String b(int i7) {
        if (i7 == 0) {
            return "EEEE, MMMM d, yyyy";
        }
        if (i7 == 1) {
            return "MMMM d, yyyy";
        }
        if (i7 == 2) {
            return "MMM d, yyyy";
        }
        if (i7 == 3) {
            return "M/d/yy";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i7);
    }

    private static String c(int i7) {
        if (i7 == 0 || i7 == 1) {
            return "h:mm:ss a z";
        }
        if (i7 == 2) {
            return "h:mm:ss a";
        }
        if (i7 == 3) {
            return "h:mm a";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i7);
    }

    public static DateFormat d(int i7) {
        return new SimpleDateFormat(a(i7), Locale.US);
    }

    public static DateFormat e(int i7, int i8) {
        return new SimpleDateFormat(b(i7) + " " + c(i8), Locale.US);
    }
}
