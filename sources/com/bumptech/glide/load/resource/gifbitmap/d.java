package com.bumptech.glide.load.resource.gifbitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.m;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class d implements w0.f<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w0.f<Bitmap> f14696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final w0.f<com.bumptech.glide.load.resource.gif.b> f14697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f14698c;

    public d(w0.f<Bitmap> fVar, w0.f<com.bumptech.glide.load.resource.gif.b> fVar2) {
        this.f14696a = fVar;
        this.f14697b = fVar2;
    }

    @Override // w0.b
    public String a() {
        if (this.f14698c == null) {
            this.f14698c = this.f14696a.a() + this.f14697b.a();
        }
        return this.f14698c;
    }

    @Override // w0.b
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean b(m<a> mVar, OutputStream outputStream) {
        a aVar = mVar.get();
        m<Bitmap> mVarA = aVar.a();
        return mVarA != null ? this.f14696a.b(mVarA, outputStream) : this.f14697b.b(aVar.b(), outputStream);
    }
}
