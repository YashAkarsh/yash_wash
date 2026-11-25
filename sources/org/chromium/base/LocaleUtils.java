package org.chromium.base;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Locale;
import org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes3.dex */
public class LocaleUtils {
    private LocaleUtils() {
    }

    public static Locale a(String str) {
        return f(Locale.forLanguageTag(str));
    }

    public static Locale b(String str) {
        String[] strArrSplit = str.split("-");
        if (strArrSplit.length == 0) {
            return new Locale("");
        }
        String strD = d(strArrSplit[0]);
        if (strD.length() != 2 && strD.length() != 3) {
            return new Locale("");
        }
        if (strArrSplit.length == 1) {
            return new Locale(strD);
        }
        String str2 = strArrSplit[1];
        return (str2.length() == 2 || str2.length() == 3) ? new Locale(strD, str2) : new Locale(strD);
    }

    public static String c() {
        return Build.VERSION.SDK_INT >= 24 ? k(LocaleList.getDefault()) : getDefaultLocaleString();
    }

    public static String d(String str) {
        str.hashCode();
        if (str.equals("fil")) {
            return "tl";
        }
        return !str.equals("und") ? str : "";
    }

    public static String e(String str) {
        str.hashCode();
        switch (str) {
            case "in":
                return "id";
            case "iw":
                return "he";
            case "ji":
                return "yi";
            case "tl":
                return "fil";
            default:
                return str;
        }
    }

    @TargetApi(21)
    @s0
    public static Locale f(Locale locale) {
        String language = locale.getLanguage();
        String strD = d(language);
        return strD.equals(language) ? locale : new Locale.Builder().setLocale(locale).setLanguage(strD).build();
    }

    @TargetApi(21)
    @s0
    public static Locale g(Locale locale) {
        String language = locale.getLanguage();
        String strE = e(language);
        return strE.equals(language) ? locale : new Locale.Builder().setLocale(locale).setLanguage(strE).build();
    }

    @CalledByNative
    private static String getDefaultCountryCode() {
        CommandLine commandLineM = CommandLine.m();
        return commandLineM.q(k.f38810e) ? commandLineM.o(k.f38810e) : Locale.getDefault().getCountry();
    }

    @CalledByNative
    public static String getDefaultLocaleString() {
        return j(Locale.getDefault());
    }

    public static boolean h(String str) {
        for (String str2 : l.f38817e) {
            if (i(str2).equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static String i(String str) {
        int iIndexOf = str.indexOf(45);
        return iIndexOf < 0 ? str : str.substring(0, iIndexOf);
    }

    public static String j(Locale locale) {
        String strE = e(locale.getLanguage());
        String country = locale.getCountry();
        if (strE.equals("no") && country.equals("NO") && locale.getVariant().equals("NY")) {
            return "nn-NO";
        }
        if (country.isEmpty()) {
            return strE;
        }
        return strE + "-" + country;
    }

    @TargetApi(24)
    public static String k(LocaleList localeList) {
        ArrayList arrayList = new ArrayList();
        for (int i7 = 0; i7 < localeList.size(); i7++) {
            arrayList.add(j(g(localeList.get(i7))));
        }
        return TextUtils.join(",", arrayList);
    }
}
