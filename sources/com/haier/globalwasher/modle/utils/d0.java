package com.haier.globalwasher.modle.utils;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class d0 {

    public static class a implements InputFilter {
        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i7, int i8, Spanned spanned, int i9, int i10) {
            if (charSequence.equals(" ")) {
                return "";
            }
            return null;
        }
    }

    public static String a(String str) {
        return (str == null || str.length() <= 0) ? str : str.replace((char) 65509, (char) 165);
    }

    public static String b(String str, String str2) {
        if (str == null || str.equals("")) {
            return "";
        }
        try {
            return new SimpleDateFormat(str2).format(new SimpleDateFormat("yyyyMMddHHmmss").parse(str));
        } catch (ParseException e8) {
            e8.printStackTrace();
            return "";
        }
    }

    public static String c(String str) {
        String strSubstring = "";
        if (str != null) {
            for (int i7 = 0; i7 < str.length(); i7++) {
                if (str.charAt(i7) == 'F') {
                    strSubstring = str.substring(0, i7);
                }
            }
        }
        return strSubstring;
    }

    public static String d(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        if (str.length() <= 8) {
            return " **** ";
        }
        return str.substring(0, str.length() - 8) + "****" + str.substring(str.length() - 4, str.length());
    }

    public static String e(String str, String str2) {
        return k(str).get(str2);
    }

    public static String f(String str) {
        String strSubstring = "";
        if (str != null) {
            for (int i7 = 0; i7 < str.length(); i7++) {
                if (str.charAt(i7) == 'U') {
                    strSubstring = str.substring(i7 + 1, str.length());
                }
            }
        }
        return strSubstring;
    }

    public static String g(String str) {
        if (!j(str)) {
            return "";
        }
        String strReplaceAll = str.replaceAll(" ", "");
        if (strReplaceAll.contains("@")) {
            return strReplaceAll.substring(0, strReplaceAll.indexOf("@")).length() > 2 ? strReplaceAll.replaceAll("(\\w?)(\\w+)(\\w)(@\\w+\\.[a-z]+(\\.[a-z]+)?)", "$1****$3$4") : strReplaceAll.replaceAll("(^\\w)[^@]*(@.*$)", "$1****$2");
        }
        return "";
    }

    public static String h(String str) {
        String str2 = "";
        if (str == null || "".equals(str) || str.length() <= 5) {
            return "";
        }
        for (int i7 = 0; i7 < 4; i7++) {
            str2 = str2 + "*";
        }
        return str.replace(str.substring(str.length() - 8, str.length()).substring(0, 5), str2);
    }

    public static String i(int i7, String str) {
        if (str != null) {
            return str.substring(i7, i7 + 1);
        }
        return null;
    }

    public static boolean j(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            return str.trim().length() > 0 && !str.toLowerCase().equals("null");
        }
        if (obj instanceof CharSequence) {
            return !TextUtils.isEmpty((CharSequence) obj);
        }
        return true;
    }

    public static Map<String, String> k(String str) {
        HashMap map = new HashMap();
        if (str != null && str.indexOf(m0.a.f37445e) > -1 && str.indexOf("=") > -1) {
            for (String str2 : str.split(m0.a.f37445e)) {
                String[] strArrSplit = str2.split("=");
                map.put(strArrSplit[0], strArrSplit[1]);
            }
        }
        return map;
    }
}
