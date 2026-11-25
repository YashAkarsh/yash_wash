package com.google.android.gms.internal.common;

/* JADX INFO: loaded from: classes.dex */
public final class d0 {
    public static int a(int i7, int i8, String str) {
        String strA;
        if (i7 >= 0 && i7 < i8) {
            return i7;
        }
        if (i7 < 0) {
            strA = j0.a("%s (%s) must not be negative", "index", Integer.valueOf(i7));
        } else {
            if (i8 < 0) {
                StringBuilder sb = new StringBuilder(26);
                sb.append("negative size: ");
                sb.append(i8);
                throw new IllegalArgumentException(sb.toString());
            }
            strA = j0.a("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i7), Integer.valueOf(i8));
        }
        throw new IndexOutOfBoundsException(strA);
    }

    public static int b(int i7, int i8, String str) {
        if (i7 < 0 || i7 > i8) {
            throw new IndexOutOfBoundsException(d(i7, i8, "index"));
        }
        return i7;
    }

    public static void c(int i7, int i8, int i9) {
        String strD;
        if (i7 < 0 || i8 < i7 || i8 > i9) {
            if (i7 < 0 || i7 > i9) {
                strD = d(i7, i9, "start index");
            } else {
                strD = (i8 < 0 || i8 > i9) ? d(i8, i9, "end index") : j0.a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i8), Integer.valueOf(i7));
            }
            throw new IndexOutOfBoundsException(strD);
        }
    }

    private static String d(int i7, int i8, String str) {
        if (i7 < 0) {
            return j0.a("%s (%s) must not be negative", str, Integer.valueOf(i7));
        }
        if (i8 >= 0) {
            return j0.a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i7), Integer.valueOf(i8));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(i8);
        throw new IllegalArgumentException(sb.toString());
    }
}
