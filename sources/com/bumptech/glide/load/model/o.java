package com.bumptech.glide.load.model;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class o implements w0.b<InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f14508a = "StreamEncoder";

    @Override // w0.b
    public String a() {
        return "";
    }

    @Override // w0.b
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean b(InputStream inputStream, OutputStream outputStream) {
        byte[] bArrC = com.bumptech.glide.util.a.b().c();
        while (true) {
            try {
                try {
                    int i7 = inputStream.read(bArrC);
                    if (i7 == -1) {
                        com.bumptech.glide.util.a.b().d(bArrC);
                        return true;
                    }
                    outputStream.write(bArrC, 0, i7);
                } catch (IOException e8) {
                    if (Log.isLoggable(f14508a, 3)) {
                        Log.d(f14508a, "Failed to encode data onto the OutputStream", e8);
                    }
                    com.bumptech.glide.util.a.b().d(bArrC);
                    return false;
                }
            } catch (Throwable th) {
                com.bumptech.glide.util.a.b().d(bArrC);
                throw th;
            }
            com.bumptech.glide.util.a.b().d(bArrC);
            throw th;
        }
    }
}
