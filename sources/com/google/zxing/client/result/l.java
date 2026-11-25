package com.google.zxing.client.result;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends u {
    private static String q(int i7, String str) {
        if (str.charAt(i7) != '(') {
            return null;
        }
        String strSubstring = str.substring(i7 + 1);
        StringBuilder sb = new StringBuilder();
        for (int i8 = 0; i8 < strSubstring.length(); i8++) {
            char cCharAt = strSubstring.charAt(i8);
            if (cCharAt == ')') {
                return sb.toString();
            }
            if (cCharAt < '0' || cCharAt > '9') {
                return null;
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    private static String r(int i7, String str) {
        StringBuilder sb = new StringBuilder();
        String strSubstring = str.substring(i7);
        for (int i8 = 0; i8 < strSubstring.length(); i8++) {
            char cCharAt = strSubstring.charAt(i8);
            if (cCharAt != '(') {
                sb.append(cCharAt);
            } else {
                if (q(i8, strSubstring) != null) {
                    break;
                }
                sb.append('(');
            }
        }
        return sb.toString();
    }

    @Override // com.google.zxing.client.result.u
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public k k(com.google.zxing.r rVar) {
        k kVar = null;
        if (rVar.b() != com.google.zxing.a.RSS_EXPANDED) {
            return null;
        }
        String strC = u.c(rVar);
        HashMap map = new HashMap();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String strSubstring = null;
        String str10 = null;
        String strSubstring2 = null;
        String strSubstring3 = null;
        int length = 0;
        while (length < strC.length()) {
            String strQ = q(length, strC);
            if (strQ == null) {
                return kVar;
            }
            byte b8 = 2;
            int length2 = length + strQ.length() + 2;
            String strR = r(length2, strC);
            length = length2 + strR.length();
            switch (strQ.hashCode()) {
                case 1536:
                    b8 = !strQ.equals("00") ? (byte) -1 : (byte) 0;
                    break;
                case 1537:
                    b8 = !strQ.equals("01") ? (byte) -1 : (byte) 1;
                    break;
                case 1567:
                    if (!strQ.equals("10")) {
                        b8 = -1;
                    }
                    break;
                case 1568:
                    b8 = !strQ.equals("11") ? (byte) -1 : (byte) 3;
                    break;
                case 1570:
                    b8 = !strQ.equals("13") ? (byte) -1 : (byte) 4;
                    break;
                case 1572:
                    b8 = !strQ.equals("15") ? (byte) -1 : (byte) 5;
                    break;
                case 1574:
                    b8 = !strQ.equals("17") ? (byte) -1 : (byte) 6;
                    break;
                case 1567966:
                    b8 = !strQ.equals("3100") ? (byte) -1 : (byte) 7;
                    break;
                case 1567967:
                    b8 = !strQ.equals("3101") ? (byte) -1 : (byte) 8;
                    break;
                case 1567968:
                    b8 = !strQ.equals("3102") ? (byte) -1 : (byte) 9;
                    break;
                case 1567969:
                    b8 = !strQ.equals("3103") ? (byte) -1 : (byte) 10;
                    break;
                case 1567970:
                    b8 = !strQ.equals("3104") ? (byte) -1 : com.google.common.base.c.f19313m;
                    break;
                case 1567971:
                    b8 = !strQ.equals("3105") ? (byte) -1 : com.google.common.base.c.f19314n;
                    break;
                case 1567972:
                    b8 = !strQ.equals("3106") ? (byte) -1 : com.google.common.base.c.f19315o;
                    break;
                case 1567973:
                    b8 = !strQ.equals("3107") ? (byte) -1 : com.google.common.base.c.f19316p;
                    break;
                case 1567974:
                    b8 = !strQ.equals("3108") ? (byte) -1 : com.google.common.base.c.f19317q;
                    break;
                case 1567975:
                    b8 = !strQ.equals("3109") ? (byte) -1 : com.google.common.base.c.f19318r;
                    break;
                case 1568927:
                    b8 = !strQ.equals("3200") ? (byte) -1 : (byte) 17;
                    break;
                case 1568928:
                    b8 = !strQ.equals("3201") ? (byte) -1 : com.google.common.base.c.f19321u;
                    break;
                case 1568929:
                    b8 = !strQ.equals("3202") ? (byte) -1 : (byte) 19;
                    break;
                case 1568930:
                    b8 = !strQ.equals("3203") ? (byte) -1 : com.google.common.base.c.f19324x;
                    break;
                case 1568931:
                    b8 = !strQ.equals("3204") ? (byte) -1 : com.google.common.base.c.f19325y;
                    break;
                case 1568932:
                    b8 = !strQ.equals("3205") ? (byte) -1 : com.google.common.base.c.f19326z;
                    break;
                case 1568933:
                    b8 = !strQ.equals("3206") ? (byte) -1 : com.google.common.base.c.A;
                    break;
                case 1568934:
                    b8 = !strQ.equals("3207") ? (byte) -1 : com.google.common.base.c.B;
                    break;
                case 1568935:
                    b8 = !strQ.equals("3208") ? (byte) -1 : com.google.common.base.c.C;
                    break;
                case 1568936:
                    b8 = !strQ.equals("3209") ? (byte) -1 : com.google.common.base.c.D;
                    break;
                case 1575716:
                    b8 = !strQ.equals("3920") ? (byte) -1 : com.google.common.base.c.E;
                    break;
                case 1575717:
                    b8 = !strQ.equals("3921") ? (byte) -1 : com.google.common.base.c.F;
                    break;
                case 1575718:
                    b8 = !strQ.equals("3922") ? (byte) -1 : com.google.common.base.c.G;
                    break;
                case 1575719:
                    b8 = !strQ.equals("3923") ? (byte) -1 : com.google.common.base.c.H;
                    break;
                case 1575747:
                    b8 = !strQ.equals("3930") ? (byte) -1 : com.google.common.base.c.I;
                    break;
                case 1575748:
                    b8 = !strQ.equals("3931") ? (byte) -1 : (byte) 32;
                    break;
                case 1575749:
                    b8 = !strQ.equals("3932") ? (byte) -1 : (byte) 33;
                    break;
                case 1575750:
                    b8 = !strQ.equals("3933") ? (byte) -1 : (byte) 34;
                    break;
                default:
                    b8 = -1;
                    break;
            }
            switch (b8) {
                case 0:
                    str2 = strR;
                    kVar = null;
                    break;
                case 1:
                    str = strR;
                    kVar = null;
                    break;
                case 2:
                    str3 = strR;
                    kVar = null;
                    break;
                case 3:
                    str4 = strR;
                    kVar = null;
                    break;
                case 4:
                    str5 = strR;
                    kVar = null;
                    break;
                case 5:
                    str6 = strR;
                    kVar = null;
                    break;
                case 6:
                    str7 = strR;
                    kVar = null;
                    break;
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                    strSubstring = strQ.substring(3);
                    str9 = k.f23472q;
                    str8 = strR;
                    kVar = null;
                    break;
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                    strSubstring = strQ.substring(3);
                    str9 = k.f23473r;
                    str8 = strR;
                    kVar = null;
                    break;
                case 27:
                case 28:
                case 29:
                case 30:
                    strSubstring2 = strQ.substring(3);
                    str10 = strR;
                    kVar = null;
                    break;
                case 31:
                case 32:
                case 33:
                case 34:
                    if (strR.length() < 4) {
                        return null;
                    }
                    String strSubstring4 = strR.substring(3);
                    strSubstring3 = strR.substring(0, 3);
                    str10 = strSubstring4;
                    kVar = null;
                    strSubstring2 = strQ.substring(3);
                    break;
                default:
                    map.put(strQ, strR);
                    kVar = null;
                    break;
            }
        }
        return new k(strC, str, str2, str3, str4, str5, str6, str7, str8, str9, strSubstring, str10, strSubstring2, strSubstring3, map);
    }
}
