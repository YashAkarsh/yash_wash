package com.bumptech.glide.load.resource.gifbitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.m;

/* JADX INFO: loaded from: classes.dex */
public class b implements m<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f14686a;

    public b(a aVar) {
        if (aVar == null) {
            throw new NullPointerException("Data must not be null");
        }
        this.f14686a = aVar;
    }

    @Override // com.bumptech.glide.load.engine.m
    public void a() {
        m<Bitmap> mVarA = this.f14686a.a();
        if (mVarA != null) {
            mVarA.a();
        }
        m<com.bumptech.glide.load.resource.gif.b> mVarB = this.f14686a.b();
        if (mVarB != null) {
            mVarB.a();
        }
    }

    @Override // com.bumptech.glide.load.engine.m
    public int b() {
        return this.f14686a.c();
    }

    @Override // com.bumptech.glide.load.engine.m
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public a get() {
        return this.f14686a;
    }
}
