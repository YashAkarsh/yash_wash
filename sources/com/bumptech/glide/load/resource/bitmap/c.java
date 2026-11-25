package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.util.Log;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class c implements w0.f<Bitmap> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f14523c = "BitmapEncoder";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f14524d = 90;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bitmap.CompressFormat f14525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14526b;

    public c() {
        this(null, 90);
    }

    private Bitmap.CompressFormat d(Bitmap bitmap) {
        Bitmap.CompressFormat compressFormat = this.f14525a;
        if (compressFormat != null) {
            return compressFormat;
        }
        return bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }

    @Override // w0.b
    public String a() {
        return "BitmapEncoder.com.bumptech.glide.load.resource.bitmap";
    }

    @Override // w0.b
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean b(com.bumptech.glide.load.engine.m<Bitmap> mVar, OutputStream outputStream) {
        Bitmap bitmap = mVar.get();
        long jB = com.bumptech.glide.util.e.b();
        Bitmap.CompressFormat compressFormatD = d(bitmap);
        bitmap.compress(compressFormatD, this.f14526b, outputStream);
        if (!Log.isLoggable(f14523c, 2)) {
            return true;
        }
        Log.v(f14523c, "Compressed with type: " + compressFormatD + " of size " + com.bumptech.glide.util.i.f(bitmap) + " in " + com.bumptech.glide.util.e.a(jB));
        return true;
    }

    public c(Bitmap.CompressFormat compressFormat, int i7) {
        this.f14525a = compressFormat;
        this.f14526b = i7;
    }
}
