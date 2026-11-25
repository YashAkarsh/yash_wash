package com.facebook.appevents.ml;

import android.text.TextUtils;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public class Utils {
    static String normalizeString(String str) {
        return TextUtils.join(" ", str.trim().split("\\s+"));
    }

    static int[] vectorize(String str, int i7) {
        int[] iArr = new int[i7];
        byte[] bytes = normalizeString(str).getBytes(Charset.forName("UTF-8"));
        for (int i8 = 0; i8 < i7; i8++) {
            if (i8 < bytes.length) {
                iArr[i8] = bytes[i8] & 255;
            } else {
                iArr[i8] = 0;
            }
        }
        return iArr;
    }
}
