package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class r implements w0.e<InputStream, Bitmap> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f14599e = "StreamBitmapDecoder.com.bumptech.glide.load.resource.bitmap";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f14600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bumptech.glide.load.engine.bitmap_recycle.c f14601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private w0.a f14602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f14603d;

    public r(Context context) {
        this(com.bumptech.glide.l.o(context).r());
    }

    @Override // w0.e
    public String a() {
        if (this.f14603d == null) {
            this.f14603d = f14599e + this.f14600a.a() + this.f14602c.name();
        }
        return this.f14603d;
    }

    @Override // w0.e
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.engine.m<Bitmap> b(InputStream inputStream, int i7, int i8) {
        return d.d(this.f14600a.b(inputStream, this.f14601b, i7, i8, this.f14602c), this.f14601b);
    }

    public r(com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        this(cVar, w0.a.f40489d);
    }

    public r(Context context, w0.a aVar) {
        this(com.bumptech.glide.l.o(context).r(), aVar);
    }

    public r(com.bumptech.glide.load.engine.bitmap_recycle.c cVar, w0.a aVar) {
        this(g.f14533d, cVar, aVar);
    }

    public r(g gVar, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, w0.a aVar) {
        this.f14600a = gVar;
        this.f14601b = cVar;
        this.f14602c = aVar;
    }
}
