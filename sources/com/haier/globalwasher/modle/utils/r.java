package com.haier.globalwasher.modle.utils;

import com.haier.uhome.nfc.service.HttpHelper;
import com.haier.uhome.trace.api.TraceProtocolConst;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f24689a = {"0", "1", "2", "3", "4", "5", TraceProtocolConst.PRO_CONFIG_PROFILE_TYPE_BLE_ADV, TraceProtocolConst.PRO_CONFIG_PROFILE_BT_SECURITY, HttpHelper.b.f29530c, "9", "a", "b", "c", "d", "e", "f"};

    public static String a(String str, String str2) {
        String str3 = null;
        try {
            String str4 = new String(str);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                return (str2 == null || "".equals(str2)) ? b(messageDigest.digest(str4.getBytes())) : b(messageDigest.digest(str4.getBytes(str2)));
            } catch (Exception unused) {
                str3 = str4;
                return str3;
            }
        } catch (Exception unused2) {
        }
    }

    private static String b(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b8 : bArr) {
            stringBuffer.append(c(b8));
        }
        return stringBuffer.toString();
    }

    private static String c(byte b8) {
        int i7 = b8;
        if (b8 < 0) {
            i7 = b8 + 256;
        }
        StringBuilder sb = new StringBuilder();
        String[] strArr = f24689a;
        sb.append(strArr[i7 / 16]);
        sb.append(strArr[i7 % 16]);
        return sb.toString();
    }
}
