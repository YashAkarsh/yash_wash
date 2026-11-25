package com.google.zxing.client.result;

import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends u {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Pattern f23460f = Pattern.compile(",");

    @Override // com.google.zxing.client.result.u
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public h k(com.google.zxing.r rVar) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        String str;
        String str2;
        String str3;
        String strC = u.c(rVar);
        if (!strC.startsWith(androidx.core.net.d.f6068b) && !strC.startsWith("MAILTO:")) {
            if (j.s(strC)) {
                return new h(strC);
            }
            return null;
        }
        String strSubstring = strC.substring(7);
        int iIndexOf = strSubstring.indexOf(63);
        if (iIndexOf >= 0) {
            strSubstring = strSubstring.substring(0, iIndexOf);
        }
        try {
            String strP = u.p(strSubstring);
            String[] strArrSplit = !strP.isEmpty() ? f23460f.split(strP) : null;
            Map<String, String> mapM = u.m(strC);
            if (mapM != null) {
                if (strArrSplit == null && (str3 = mapM.get("to")) != null) {
                    strArrSplit = f23460f.split(str3);
                }
                String str4 = mapM.get("cc");
                String[] strArrSplit2 = str4 != null ? f23460f.split(str4) : null;
                String str5 = mapM.get("bcc");
                String[] strArrSplit3 = str5 != null ? f23460f.split(str5) : null;
                String str6 = mapM.get("subject");
                str2 = mapM.get(com.paytm.pgsdk.d.V);
                strArr = strArrSplit;
                strArr3 = strArrSplit3;
                strArr2 = strArrSplit2;
                str = str6;
            } else {
                strArr = strArrSplit;
                strArr2 = null;
                strArr3 = null;
                str = null;
                str2 = null;
            }
            return new h(strArr, strArr2, strArr3, str, str2);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
