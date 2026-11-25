package com.google.zxing.client.result;

import java.util.ArrayList;
import org.apache.commons.lang3.CharUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends u {
    private static String[] q(String str, int i7, String str2, boolean z7) {
        ArrayList arrayList = null;
        for (int i8 = 1; i8 <= i7; i8++) {
            String strG = u.g(str + i8 + ':', str2, CharUtils.CR, z7);
            if (strG == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList(i7);
            }
            arrayList.add(strG);
        }
        if (arrayList == null) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @Override // com.google.zxing.client.result.u
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public d k(com.google.zxing.r rVar) {
        String strC = u.c(rVar);
        if (!strC.contains("MEMORY") || !strC.contains("\r\n")) {
            return null;
        }
        String strG = u.g("NAME1:", strC, CharUtils.CR, true);
        String strG2 = u.g("NAME2:", strC, CharUtils.CR, true);
        String[] strArrQ = q("TEL", 3, strC, true);
        String[] strArrQ2 = q("MAIL", 3, strC, true);
        String strG3 = u.g("MEMORY:", strC, CharUtils.CR, false);
        String strG4 = u.g("ADD:", strC, CharUtils.CR, true);
        return new d(u.j(strG), null, strG2, strArrQ, null, strArrQ2, null, null, strG3, strG4 != null ? new String[]{strG4} : null, null, null, null, null, null, null);
    }
}
