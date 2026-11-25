package com.google.zxing.client.result;

import com.facebook.share.internal.ShareConstants;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class f0 extends u {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Pattern f23422f = Pattern.compile("BEGIN:VCARD", 2);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Pattern f23423g = Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Pattern f23424h = Pattern.compile("\r\n[ \t]");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Pattern f23425i = Pattern.compile("\\\\[nN]");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Pattern f23426j = Pattern.compile("\\\\([,;\\\\])");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Pattern f23427k = Pattern.compile("=");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Pattern f23428l = Pattern.compile(com.alipay.sdk.util.j.f13806b);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Pattern f23429m = Pattern.compile("(?<!\\\\);+");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Pattern f23430n = Pattern.compile(",");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Pattern f23431o = Pattern.compile("[;,]");

    private static String[] A(Collection<List<String>> collection) {
        String strSubstring;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List<String> list : collection) {
            String str = list.get(0);
            if (str != null && !str.isEmpty()) {
                int i7 = 1;
                while (true) {
                    if (i7 >= list.size()) {
                        strSubstring = null;
                        break;
                    }
                    strSubstring = list.get(i7);
                    int iIndexOf = strSubstring.indexOf(61);
                    if (iIndexOf < 0) {
                        break;
                    }
                    if ("TYPE".equalsIgnoreCase(strSubstring.substring(0, iIndexOf))) {
                        strSubstring = strSubstring.substring(iIndexOf + 1);
                        break;
                    }
                    i7++;
                }
                arrayList.add(strSubstring);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static String q(CharSequence charSequence, String str) {
        char cCharAt;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i7 = 0;
        while (i7 < length) {
            char cCharAt2 = charSequence.charAt(i7);
            if (cCharAt2 != '\n' && cCharAt2 != '\r') {
                if (cCharAt2 != '=') {
                    w(byteArrayOutputStream, str, sb);
                    sb.append(cCharAt2);
                } else if (i7 < length - 2 && (cCharAt = charSequence.charAt(i7 + 1)) != '\r' && cCharAt != '\n') {
                    i7 += 2;
                    char cCharAt3 = charSequence.charAt(i7);
                    int iL = u.l(cCharAt);
                    int iL2 = u.l(cCharAt3);
                    if (iL >= 0 && iL2 >= 0) {
                        byteArrayOutputStream.write((iL << 4) + iL2);
                    }
                }
            }
            i7++;
        }
        w(byteArrayOutputStream, str, sb);
        return sb.toString();
    }

    private static void r(Iterable<List<String>> iterable) {
        int iIndexOf;
        if (iterable != null) {
            for (List<String> list : iterable) {
                String str = list.get(0);
                String[] strArr = new String[5];
                int i7 = 0;
                int i8 = 0;
                while (i7 < 4 && (iIndexOf = str.indexOf(59, i8)) >= 0) {
                    strArr[i7] = str.substring(i8, iIndexOf);
                    i7++;
                    i8 = iIndexOf + 1;
                }
                strArr[i7] = str.substring(i8);
                StringBuilder sb = new StringBuilder(100);
                v(strArr, 3, sb);
                v(strArr, 1, sb);
                v(strArr, 2, sb);
                v(strArr, 0, sb);
                v(strArr, 4, sb);
                list.set(0, sb.toString().trim());
            }
        }
    }

    private static boolean s(CharSequence charSequence) {
        return charSequence == null || f23423g.matcher(charSequence).matches();
    }

    static List<String> t(CharSequence charSequence, String str, boolean z7, boolean z8) {
        List<List<String>> listU = u(charSequence, str, z7, z8);
        if (listU == null || listU.isEmpty()) {
            return null;
        }
        return listU.get(0);
    }

    static List<List<String>> u(CharSequence charSequence, String str, boolean z7, boolean z8) {
        ArrayList arrayList;
        int i7;
        String str2;
        String str3;
        int iIndexOf;
        int i8;
        String strReplaceAll;
        int length = str.length();
        int i9 = 0;
        int i10 = 0;
        ArrayList arrayList2 = null;
        while (i10 < length) {
            int i11 = 2;
            Matcher matcher = Pattern.compile("(?:^|\n)" + ((Object) charSequence) + "(?:;([^:]*))?:", 2).matcher(str);
            if (i10 > 0) {
                i10--;
            }
            if (!matcher.find(i10)) {
                break;
            }
            int iEnd = matcher.end(i9);
            String strGroup = matcher.group(1);
            if (strGroup != null) {
                String[] strArrSplit = f23428l.split(strGroup);
                int length2 = strArrSplit.length;
                int i12 = i9;
                i7 = i12;
                arrayList = null;
                str2 = null;
                str3 = null;
                while (i12 < length2) {
                    String str4 = strArrSplit[i12];
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(str4);
                    String[] strArrSplit2 = f23427k.split(str4, i11);
                    if (strArrSplit2.length > 1) {
                        String str5 = strArrSplit2[0];
                        String str6 = strArrSplit2[1];
                        if ("ENCODING".equalsIgnoreCase(str5) && "QUOTED-PRINTABLE".equalsIgnoreCase(str6)) {
                            i7 = 1;
                        } else if ("CHARSET".equalsIgnoreCase(str5)) {
                            str2 = str6;
                        } else if ("VALUE".equalsIgnoreCase(str5)) {
                            str3 = str6;
                        }
                    }
                    i12++;
                    i11 = 2;
                }
            } else {
                arrayList = null;
                i7 = 0;
                str2 = null;
                str3 = null;
            }
            int i13 = iEnd;
            while (true) {
                iIndexOf = str.indexOf(10, i13);
                if (iIndexOf < 0) {
                    break;
                }
                if (iIndexOf < str.length() - 1) {
                    int i14 = iIndexOf + 1;
                    if (str.charAt(i14) == ' ' || str.charAt(i14) == '\t') {
                        i13 = iIndexOf + 2;
                    }
                }
                if (i7 == 0 || ((iIndexOf <= 0 || str.charAt(iIndexOf - 1) != '=') && (iIndexOf < 2 || str.charAt(iIndexOf - 2) != '='))) {
                    break;
                }
                i13 = iIndexOf + 1;
            }
            if (iIndexOf < 0) {
                i10 = length;
                i9 = 0;
            } else {
                if (iIndexOf <= iEnd) {
                    i8 = 0;
                } else {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(1);
                    }
                    if (iIndexOf > 0 && str.charAt(iIndexOf - 1) == '\r') {
                        iIndexOf--;
                    }
                    String strSubstring = str.substring(iEnd, iIndexOf);
                    if (z7) {
                        strSubstring = strSubstring.trim();
                    }
                    if (i7 != 0) {
                        strReplaceAll = q(strSubstring, str2);
                        if (z8) {
                            strReplaceAll = f23429m.matcher(strReplaceAll).replaceAll("\n").trim();
                        }
                    } else {
                        if (z8) {
                            strSubstring = f23429m.matcher(strSubstring).replaceAll("\n").trim();
                        }
                        strReplaceAll = f23426j.matcher(f23425i.matcher(f23424h.matcher(strSubstring).replaceAll("")).replaceAll("\n")).replaceAll("$1");
                    }
                    if (ShareConstants.MEDIA_URI.equals(str3)) {
                        try {
                            strReplaceAll = URI.create(strReplaceAll).getSchemeSpecificPart();
                        } catch (IllegalArgumentException unused) {
                        }
                    }
                    if (arrayList == null) {
                        ArrayList arrayList3 = new ArrayList(1);
                        arrayList3.add(strReplaceAll);
                        arrayList2.add(arrayList3);
                        i8 = 0;
                    } else {
                        i8 = 0;
                        arrayList.add(0, strReplaceAll);
                        arrayList2.add(arrayList);
                    }
                }
                i9 = i8;
                i10 = iIndexOf + 1;
            }
        }
        return arrayList2;
    }

    private static void v(String[] strArr, int i7, StringBuilder sb) {
        String str = strArr[i7];
        if (str == null || str.isEmpty()) {
            return;
        }
        if (sb.length() > 0) {
            sb.append(' ');
        }
        sb.append(strArr[i7]);
    }

    private static void w(ByteArrayOutputStream byteArrayOutputStream, String str, StringBuilder sb) {
        String str2;
        if (byteArrayOutputStream.size() > 0) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (str == null) {
                str2 = new String(byteArray, StandardCharsets.UTF_8);
            } else {
                try {
                    str2 = new String(byteArray, str);
                } catch (UnsupportedEncodingException unused) {
                    str2 = new String(byteArray, StandardCharsets.UTF_8);
                }
            }
            byteArrayOutputStream.reset();
            sb.append(str2);
        }
    }

    private static String y(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    private static String[] z(Collection<List<String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<List<String>> it = collection.iterator();
        while (it.hasNext()) {
            String str = it.next().get(0);
            if (str != null && !str.isEmpty()) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @Override // com.google.zxing.client.result.u
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public d k(com.google.zxing.r rVar) {
        String strC = u.c(rVar);
        Matcher matcher = f23422f.matcher(strC);
        if (!matcher.find() || matcher.start() != 0) {
            return null;
        }
        List<List<String>> listU = u("FN", strC, true, false);
        if (listU == null) {
            listU = u("N", strC, true, false);
            r(listU);
        }
        List<String> listT = t("NICKNAME", strC, true, false);
        String[] strArrSplit = listT == null ? null : f23430n.split(listT.get(0));
        List<List<String>> listU2 = u("TEL", strC, true, false);
        List<List<String>> listU3 = u("EMAIL", strC, true, false);
        List<String> listT2 = t("NOTE", strC, false, false);
        List<List<String>> listU4 = u("ADR", strC, true, true);
        List<String> listT3 = t("ORG", strC, true, true);
        List<String> listT4 = t("BDAY", strC, true, false);
        List<String> list = (listT4 == null || s(listT4.get(0))) ? listT4 : null;
        List<String> listT5 = t(ShareConstants.TITLE, strC, true, false);
        List<List<String>> listU5 = u("URL", strC, true, false);
        List<String> listT6 = t("IMPP", strC, true, false);
        List<String> listT7 = t("GEO", strC, true, false);
        String[] strArrSplit2 = listT7 == null ? null : f23431o.split(listT7.get(0));
        return new d(z(listU), strArrSplit, null, z(listU2), A(listU2), z(listU3), A(listU3), y(listT6), y(listT2), z(listU4), A(listU4), y(listT3), y(list), y(listT5), z(listU5), (strArrSplit2 == null || strArrSplit2.length == 2) ? strArrSplit2 : null);
    }
}
