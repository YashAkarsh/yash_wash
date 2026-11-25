package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class n implements w0.e<com.bumptech.glide.load.model.g, Bitmap> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f14581c = "ImageVideoDecoder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w0.e<InputStream, Bitmap> f14582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final w0.e<ParcelFileDescriptor, Bitmap> f14583b;

    public n(w0.e<InputStream, Bitmap> eVar, w0.e<ParcelFileDescriptor, Bitmap> eVar2) {
        this.f14582a = eVar;
        this.f14583b = eVar2;
    }

    @Override // w0.e
    public String a() {
        return "ImageVideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }

    @Override // w0.e
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.engine.m<Bitmap> b(com.bumptech.glide.load.model.g gVar, int i7, int i8) throws IOException {
        com.bumptech.glide.load.engine.m<Bitmap> mVarB;
        ParcelFileDescriptor parcelFileDescriptorA;
        InputStream inputStreamB = gVar.b();
        if (inputStreamB != null) {
            try {
                mVarB = this.f14582a.b(inputStreamB, i7, i8);
            } catch (IOException e8) {
                if (Log.isLoggable(f14581c, 2)) {
                    Log.v(f14581c, "Failed to load image from stream, trying FileDescriptor", e8);
                }
                mVarB = null;
            }
        } else {
            mVarB = null;
        }
        return (mVarB != null || (parcelFileDescriptorA = gVar.a()) == null) ? mVarB : this.f14583b.b(parcelFileDescriptorA, i7, i8);
    }
}
