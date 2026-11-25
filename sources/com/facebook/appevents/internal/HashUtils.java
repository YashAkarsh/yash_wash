package com.facebook.appevents.internal;

import c.o0;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
final class HashUtils {
    private static final String MD5 = "MD5";

    HashUtils() {
    }

    @o0
    public static final String computeChecksum(String str) throws Exception {
        return computeFileMd5(new File(str));
    }

    @o0
    private static String computeFileMd5(File file) throws Exception {
        int i7;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 1024);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[1024];
            do {
                i7 = bufferedInputStream.read(bArr);
                if (i7 > 0) {
                    messageDigest.update(bArr, 0, i7);
                }
            } while (i7 != -1);
            String string = new BigInteger(1, messageDigest.digest()).toString(16);
            bufferedInputStream.close();
            return string;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    bufferedInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }
}
