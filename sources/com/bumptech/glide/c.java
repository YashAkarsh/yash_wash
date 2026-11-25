package com.bumptech.glide;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class c<ModelType> extends b<ModelType, Bitmap> {
    private final com.bumptech.glide.load.model.l<ModelType, InputStream> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final com.bumptech.glide.load.model.l<ModelType, ParcelFileDescriptor> f13952J;
    private final l K;
    private final q.e L;

    c(h<ModelType, ?, ?, ?> hVar, com.bumptech.glide.load.model.l<ModelType, InputStream> lVar, com.bumptech.glide.load.model.l<ModelType, ParcelFileDescriptor> lVar2, q.e eVar) {
        super(S0(hVar.f14143c, lVar, lVar2, Bitmap.class, null), Bitmap.class, hVar);
        this.I = lVar;
        this.f13952J = lVar2;
        this.K = hVar.f14143c;
        this.L = eVar;
    }

    private static <A, R> a1.e<A, com.bumptech.glide.load.model.g, Bitmap, R> S0(l lVar, com.bumptech.glide.load.model.l<A, InputStream> lVar2, com.bumptech.glide.load.model.l<A, ParcelFileDescriptor> lVar3, Class<R> cls, y0.f<Bitmap, R> fVar) {
        if (lVar2 == null && lVar3 == null) {
            return null;
        }
        if (fVar == null) {
            fVar = lVar.i(Bitmap.class, cls);
        }
        return new a1.e<>(new com.bumptech.glide.load.model.f(lVar2, lVar3), fVar, lVar.a(com.bumptech.glide.load.model.g.class, Bitmap.class));
    }

    public b<ModelType, byte[]> T0() {
        return (b<ModelType, byte[]>) V0(new y0.a(), byte[].class);
    }

    public b<ModelType, byte[]> U0(Bitmap.CompressFormat compressFormat, int i7) {
        return (b<ModelType, byte[]>) V0(new y0.a(compressFormat, i7), byte[].class);
    }

    public <R> b<ModelType, R> V0(y0.f<Bitmap, R> fVar, Class<R> cls) {
        return (b) this.L.a(new b(S0(this.K, this.I, this.f13952J, cls, fVar), cls, this));
    }
}
