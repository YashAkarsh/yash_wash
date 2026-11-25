package com.haier.uhome.nfc.service;

import android.net.Uri;
import com.haier.uhome.nfc.service.entity.NFCInfo;
import com.haier.uhome.trace.api.TraceProtocolConst;

/* JADX INFO: loaded from: classes2.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f29532a = "^[-_0-9A-Za-z]+$";

    a() {
    }

    public static NFCInfo a(String str) {
        Uri uri = Uri.parse(str);
        uri.getQueryParameter("untype");
        String queryParameter = uri.getQueryParameter("nsn");
        String queryParameter2 = uri.getQueryParameter("mac");
        String queryParameter3 = uri.getQueryParameter(TraceProtocolConst.PRO_MODEL);
        String queryParameter4 = uri.getQueryParameter("hwp");
        String queryParameter5 = uri.getQueryParameter("c");
        if (!b(queryParameter5)) {
            queryParameter5 = null;
        }
        return a(queryParameter, queryParameter2, queryParameter3, queryParameter4, queryParameter5);
    }

    protected static boolean b(String str) {
        return str != null && str.length() <= 32 && str.matches(f29532a);
    }

    public static NFCInfo a(String str, String str2, String str3, String str4, String str5) {
        NFCInfo nFCInfo = new NFCInfo();
        nFCInfo.setNFCSerialNumber(str);
        nFCInfo.setMAC(str2);
        nFCInfo.setProductCode(str3);
        nFCInfo.setHwProductID(str4);
        nFCInfo.setCustom(str5);
        return nFCInfo;
    }
}
