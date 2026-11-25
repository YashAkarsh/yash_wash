package com.bumptech.glide.load.resource.gifbitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.m;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m<com.bumptech.glide.load.resource.gif.b> f14684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m<Bitmap> f14685b;

    public a(m<Bitmap> mVar, m<com.bumptech.glide.load.resource.gif.b> mVar2) {
        if (mVar != null && mVar2 != null) {
            throw new IllegalArgumentException("Can only contain either a bitmap resource or a gif resource, not both");
        }
        if (mVar == null && mVar2 == null) {
            throw new IllegalArgumentException("Must contain either a bitmap resource or a gif resource");
        }
        this.f14685b = mVar;
        this.f14684a = mVar2;
    }

    public m<Bitmap> a() {
        return this.f14685b;
    }

    public m<com.bumptech.glide.load.resource.gif.b> b() {
        return this.f14684a;
    }

    public int c() {
        m<Bitmap> mVar = this.f14685b;
        return mVar != null ? mVar.b() : this.f14684a.b();
    }
}
