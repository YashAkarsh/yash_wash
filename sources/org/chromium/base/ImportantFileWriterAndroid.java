package org.chromium.base;

/* JADX INFO: loaded from: classes3.dex */
@x6.c("base::android")
public class ImportantFileWriterAndroid {
    public static boolean a(String str, byte[] bArr) {
        return nativeWriteFileAtomically(str, bArr);
    }

    private static native boolean nativeWriteFileAtomically(String str, byte[] bArr);
}
