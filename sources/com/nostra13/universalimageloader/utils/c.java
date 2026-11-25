package com.nostra13.universalimageloader.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f32917a = 32768;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f32918b = 75;

    public interface a {
        boolean a(int i7, int i8);
    }

    private c() {
    }

    public static void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (Exception unused) {
        }
    }

    public static boolean b(InputStream inputStream, OutputStream outputStream, a aVar) throws IOException {
        return c(inputStream, outputStream, aVar, 32768);
    }

    public static boolean c(InputStream inputStream, OutputStream outputStream, a aVar, int i7) throws IOException {
        int iAvailable = inputStream.available();
        byte[] bArr = new byte[i7];
        if (e(aVar, 0, iAvailable)) {
            return false;
        }
        int i8 = 0;
        do {
            int i9 = inputStream.read(bArr, 0, i7);
            if (i9 == -1) {
                return true;
            }
            outputStream.write(bArr, 0, i9);
            i8 += i9;
        } while (!e(aVar, i8, iAvailable));
        return false;
    }

    public static void d(InputStream inputStream) {
        do {
            try {
            } catch (IOException unused) {
            } finally {
                a(inputStream);
            }
        } while (inputStream.read(new byte[32768], 0, 32768) != -1);
    }

    private static boolean e(a aVar, int i7, int i8) {
        return (aVar == null || aVar.a(i7, i8) || (i7 * 100) / i8 >= 75) ? false : true;
    }
}
