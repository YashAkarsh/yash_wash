package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class i implements w0.e<ParcelFileDescriptor, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final t f14541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.c f14542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private w0.a f14543c;

    public i(Context context) {
        this(com.bumptech.glide.l.o(context).r(), w0.a.f40489d);
    }

    @Override // w0.e
    public String a() {
        return "FileDescriptorBitmapDecoder.com.bumptech.glide.load.data.bitmap";
    }

    @Override // w0.e
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.engine.m<Bitmap> b(ParcelFileDescriptor parcelFileDescriptor, int i7, int i8) throws IOException {
        return d.d(this.f14541a.b(parcelFileDescriptor, this.f14542b, i7, i8, this.f14543c), this.f14542b);
    }

    public i(Context context, w0.a aVar) {
        this(com.bumptech.glide.l.o(context).r(), aVar);
    }

    public i(com.bumptech.glide.load.engine.bitmap_recycle.c cVar, w0.a aVar) {
        this(new t(), cVar, aVar);
    }

    public i(t tVar, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, w0.a aVar) {
        this.f14541a = tVar;
        this.f14542b = cVar;
        this.f14543c = aVar;
    }
}
