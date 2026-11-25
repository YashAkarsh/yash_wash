package com.bumptech.glide.load.resource.gifbitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.m;

/* JADX INFO: loaded from: classes.dex */
public class f implements w0.g<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w0.g<Bitmap> f14700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final w0.g<com.bumptech.glide.load.resource.gif.b> f14701b;

    public f(com.bumptech.glide.load.engine.bitmap_recycle.c cVar, w0.g<Bitmap> gVar) {
        this(gVar, new com.bumptech.glide.load.resource.gif.e(gVar, cVar));
    }

    @Override // w0.g
    public String a() {
        return this.f14700a.a();
    }

    @Override // w0.g
    public m<a> b(m<a> mVar, int i7, int i8) {
        w0.g<com.bumptech.glide.load.resource.gif.b> gVar;
        w0.g<Bitmap> gVar2;
        m<Bitmap> mVarA = mVar.get().a();
        m<com.bumptech.glide.load.resource.gif.b> mVarB = mVar.get().b();
        if (mVarA != null && (gVar2 = this.f14700a) != null) {
            m<Bitmap> mVarB2 = gVar2.b(mVarA, i7, i8);
            return !mVarA.equals(mVarB2) ? new b(new a(mVarB2, mVar.get().b())) : mVar;
        }
        if (mVarB == null || (gVar = this.f14701b) == null) {
            return mVar;
        }
        m<com.bumptech.glide.load.resource.gif.b> mVarB3 = gVar.b(mVarB, i7, i8);
        return !mVarB.equals(mVarB3) ? new b(new a(mVar.get().a(), mVarB3)) : mVar;
    }

    f(w0.g<Bitmap> gVar, w0.g<com.bumptech.glide.load.resource.gif.b> gVar2) {
        this.f14700a = gVar;
        this.f14701b = gVar2;
    }
}
