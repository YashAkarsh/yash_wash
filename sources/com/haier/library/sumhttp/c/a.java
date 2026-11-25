package com.haier.library.sumhttp.c;

import com.google.common.base.c;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static String a(String str, String str2, String str3, String str4, String str5) {
        byte[] bArrDigest;
        String strReplaceAll = str2.trim().replaceAll("\"", "");
        if (str4 != null) {
            str4 = str4.trim();
        }
        if (!str4.equals("")) {
            str4 = str4.replaceAll("", "").replaceAll("\t", "").replaceAll("\r", "").replaceAll("\n", "");
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str5);
        stringBuffer.append(str4);
        stringBuffer.append(str);
        stringBuffer.append(strReplaceAll);
        stringBuffer.append(str3);
        try {
            bArrDigest = MessageDigest.getInstance("sha-256").digest(stringBuffer.toString().getBytes("utf-8"));
        } catch (Exception e8) {
            e8.printStackTrace();
            bArrDigest = null;
        }
        return b(bArrDigest);
    }

    static String b(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i7 = 0; i7 < bArr.length; i7++) {
            sb.append(String.valueOf("0123456789abcdef".charAt((bArr[i7] & 240) >> 4)));
            sb.append(String.valueOf("0123456789abcdef".charAt(bArr[i7] & c.f19317q)));
        }
        return sb.toString();
    }

    public static String c(String str, String str2, String str3, String str4, String str5) {
        byte[] bArrDigest;
        String strReplaceAll = str2.trim().replaceAll("\"", "");
        if (str4 != null) {
            str4 = str4.trim();
        }
        if (!str4.equals("")) {
            str4 = str4.replaceAll(" ", "").replaceAll("\t", "").replaceAll("\r", "").replaceAll("\n", "");
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str5);
        stringBuffer.append(str4);
        stringBuffer.append(str);
        stringBuffer.append(strReplaceAll);
        stringBuffer.append(str3);
        try {
            bArrDigest = MessageDigest.getInstance("sha-256").digest(stringBuffer.toString().getBytes("utf-8"));
        } catch (Exception e8) {
            e8.printStackTrace();
            bArrDigest = null;
        }
        return b(bArrDigest);
    }
}
