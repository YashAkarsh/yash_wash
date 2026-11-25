package com.haier.library.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes2.dex */
public class q {
    public static String a(Long l7) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(com.haier.library.json.a.f26647d);
        try {
            return simpleDateFormat.format(simpleDateFormat.parse(simpleDateFormat.format(l7)));
        } catch (ParseException e8) {
            e8.printStackTrace();
            return null;
        }
    }
}
