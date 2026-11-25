package com.google.zxing.client.result;

import com.facebook.share.internal.ShareConstants;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class g0 extends u {
    private static String q(CharSequence charSequence, String str, boolean z7) {
        List<String> listT = f0.t(charSequence, str, z7, false);
        if (listT == null || listT.isEmpty()) {
            return null;
        }
        return listT.get(0);
    }

    private static String[] r(CharSequence charSequence, String str, boolean z7) {
        List<List<String>> listU = f0.u(charSequence, str, z7, false);
        if (listU == null || listU.isEmpty()) {
            return null;
        }
        int size = listU.size();
        String[] strArr = new String[size];
        for (int i7 = 0; i7 < size; i7++) {
            strArr[i7] = listU.get(i7).get(0);
        }
        return strArr;
    }

    private static String t(String str) {
        if (str != null) {
            return (str.startsWith(androidx.core.net.d.f6068b) || str.startsWith("MAILTO:")) ? str.substring(7) : str;
        }
        return str;
    }

    @Override // com.google.zxing.client.result.u
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public g k(com.google.zxing.r rVar) {
        double d8;
        double d9;
        String strC = u.c(rVar);
        if (strC.indexOf("BEGIN:VEVENT") < 0) {
            return null;
        }
        String strQ = q("SUMMARY", strC, true);
        String strQ2 = q("DTSTART", strC, true);
        if (strQ2 == null) {
            return null;
        }
        String strQ3 = q("DTEND", strC, true);
        String strQ4 = q("DURATION", strC, true);
        String strQ5 = q("LOCATION", strC, true);
        String strT = t(q("ORGANIZER", strC, true));
        String[] strArrR = r("ATTENDEE", strC, true);
        if (strArrR != null) {
            for (int i7 = 0; i7 < strArrR.length; i7++) {
                strArrR[i7] = t(strArrR[i7]);
            }
        }
        String strQ6 = q(ShareConstants.DESCRIPTION, strC, true);
        String strQ7 = q("GEO", strC, true);
        if (strQ7 == null) {
            d8 = Double.NaN;
            d9 = Double.NaN;
        } else {
            int iIndexOf = strQ7.indexOf(59);
            if (iIndexOf < 0) {
                return null;
            }
            try {
                d8 = Double.parseDouble(strQ7.substring(0, iIndexOf));
                d9 = Double.parseDouble(strQ7.substring(iIndexOf + 1));
            } catch (NumberFormatException | IllegalArgumentException unused) {
                return null;
            }
        }
        return new g(strQ, strQ2, strQ3, strQ4, strQ5, strT, strArrR, strQ6, d8, d9);
    }
}
