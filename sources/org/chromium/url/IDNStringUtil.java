package org.chromium.url;

import java.net.IDN;
import org.chromium.base.annotations.CalledByNative;
import x6.c;

/* JADX INFO: loaded from: classes3.dex */
@c("url::android")
public class IDNStringUtil {
    @CalledByNative
    private static String idnToASCII(String str) {
        try {
            return IDN.toASCII(str, 2);
        } catch (Exception unused) {
            return null;
        }
    }
}
