package org.chromium.base;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes3.dex */
public class l0 {
    public static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static void b(ZipFile zipFile) {
        if (zipFile == null) {
            return;
        }
        try {
            zipFile.close();
        } catch (IOException unused) {
        }
    }
}
