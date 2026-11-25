package org.chromium.base;

import android.annotation.SuppressLint;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"SecureRandom"})
public class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f38812a = 16;

    public static void a(SecureRandom secureRandom) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/dev/urandom");
        try {
            byte[] bArr = new byte[16];
            if (fileInputStream.read(bArr) != 16) {
                throw new IOException("Failed to get enough random data.");
            }
            secureRandom.setSeed(bArr);
            fileInputStream.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }
}
