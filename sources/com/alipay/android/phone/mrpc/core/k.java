package com.alipay.android.phone.mrpc.core;

import android.text.format.Time;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f13441a = Pattern.compile("([0-9]{1,2})[- ]([A-Za-z]{3,9})[- ]([0-9]{2,4})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f13442b = Pattern.compile("[ ]([A-Za-z]{3,9})[ ]+([0-9]{1,2})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])[ ]([0-9]{2,4})");

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13443a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f13444b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f13445c;

        a(int i7, int i8, int i9) {
            this.f13443a = i7;
            this.f13444b = i8;
            this.f13445c = i9;
        }
    }

    public static long a(String str) {
        int iC;
        int iD;
        int iB;
        a aVarE;
        int i7;
        int i8;
        int i9;
        Matcher matcher = f13441a.matcher(str);
        if (matcher.find()) {
            iB = b(matcher.group(1));
            iC = c(matcher.group(2));
            iD = d(matcher.group(3));
            aVarE = e(matcher.group(4));
        } else {
            Matcher matcher2 = f13442b.matcher(str);
            if (!matcher2.find()) {
                throw new IllegalArgumentException();
            }
            iC = c(matcher2.group(1));
            int iB2 = b(matcher2.group(2));
            a aVarE2 = e(matcher2.group(3));
            iD = d(matcher2.group(4));
            iB = iB2;
            aVarE = aVarE2;
        }
        if (iD >= 2038) {
            i8 = 0;
            i9 = 2038;
            i7 = 1;
        } else {
            i7 = iB;
            i8 = iC;
            i9 = iD;
        }
        Time time = new Time("UTC");
        time.set(aVarE.f13445c, aVarE.f13444b, aVarE.f13443a, i7, i8, i9);
        return time.toMillis(false);
    }

    private static int b(String str) {
        return str.length() == 2 ? ((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0') : str.charAt(0) - '0';
    }

    private static int c(String str) {
        int lowerCase = ((Character.toLowerCase(str.charAt(0)) + Character.toLowerCase(str.charAt(1))) + Character.toLowerCase(str.charAt(2))) - 291;
        if (lowerCase == 9) {
            return 11;
        }
        if (lowerCase == 10) {
            return 1;
        }
        if (lowerCase == 22) {
            return 0;
        }
        if (lowerCase == 26) {
            return 7;
        }
        if (lowerCase == 29) {
            return 2;
        }
        if (lowerCase == 32) {
            return 3;
        }
        if (lowerCase == 40) {
            return 6;
        }
        if (lowerCase == 42) {
            return 5;
        }
        if (lowerCase == 48) {
            return 10;
        }
        switch (lowerCase) {
            case 35:
                return 9;
            case 36:
                return 4;
            case 37:
                return 8;
            default:
                throw new IllegalArgumentException();
        }
    }

    private static int d(String str) {
        if (str.length() == 2) {
            int iCharAt = ((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0');
            return iCharAt >= 70 ? iCharAt + 1900 : iCharAt + 2000;
        }
        if (str.length() == 3) {
            return ((str.charAt(0) - '0') * 100) + ((str.charAt(1) - '0') * 10) + (str.charAt(2) - '0') + 1900;
        }
        if (str.length() == 4) {
            return ((str.charAt(0) - '0') * 1000) + ((str.charAt(1) - '0') * 100) + ((str.charAt(2) - '0') * 10) + (str.charAt(3) - '0');
        }
        return 1970;
    }

    private static a e(String str) {
        int i7;
        int iCharAt = str.charAt(0) - '0';
        if (str.charAt(1) != ':') {
            iCharAt = (iCharAt * 10) + (str.charAt(1) - '0');
            i7 = 2;
        } else {
            i7 = 1;
        }
        int i8 = i7 + 1;
        int i9 = i8 + 1;
        int i10 = i9 + 1 + 1;
        return new a(iCharAt, ((str.charAt(i8) - '0') * 10) + (str.charAt(i9) - '0'), ((str.charAt(i10) - '0') * 10) + (str.charAt(i10 + 1) - '0'));
    }
}
