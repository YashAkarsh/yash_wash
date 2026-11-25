package com.bumptech.glide;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class i<ModelType, DataType, ResourceType> extends h<ModelType, DataType, ResourceType, ResourceType> implements d {
    private final com.bumptech.glide.load.model.l<ModelType, DataType> D;
    private final Class<DataType> E;
    private final Class<ResourceType> F;
    private final q.e G;

    i(Class<ResourceType> cls, h<ModelType, ?, ?, ?> hVar, com.bumptech.glide.load.model.l<ModelType, DataType> lVar, Class<DataType> cls2, Class<ResourceType> cls3, q.e eVar) {
        super(Y(hVar.f14143c, lVar, cls2, cls3, y0.h.c()), cls, hVar);
        this.D = lVar;
        this.E = cls2;
        this.F = cls3;
        this.G = eVar;
    }

    private static <A, T, Z, R> a1.f<A, T, Z, R> Y(l lVar, com.bumptech.glide.load.model.l<A, T> lVar2, Class<T> cls, Class<Z> cls2, y0.f<Z, R> fVar) {
        return new a1.e(lVar2, fVar, lVar.a(cls, cls2));
    }

    private h<ModelType, DataType, File, File> Z() {
        return this.G.a(new h(new a1.e(this.D, y0.h.c(), this.f14143c.a(this.E, File.class)), File.class, this)).P(p.LOW).u(com.bumptech.glide.load.engine.c.SOURCE).S(true);
    }

    @Override // com.bumptech.glide.d
    public com.bumptech.glide.request.a<File> a(int i7, int i8) {
        return Z().D(i7, i8);
    }

    public <TranscodeType> h<ModelType, DataType, ResourceType, TranscodeType> a0(y0.f<ResourceType, TranscodeType> fVar, Class<TranscodeType> cls) {
        return this.G.a(new h(Y(this.f14143c, this.D, this.E, this.F, fVar), cls, this));
    }

    @Override // com.bumptech.glide.d
    public <Y extends com.bumptech.glide.request.target.m<File>> Y d(Y y7) {
        return (Y) Z().F(y7);
    }

    i(Context context, l lVar, Class<ModelType> cls, com.bumptech.glide.load.model.l<ModelType, DataType> lVar2, Class<DataType> cls2, Class<ResourceType> cls3, com.bumptech.glide.manager.m mVar, com.bumptech.glide.manager.g gVar, q.e eVar) {
        super(context, cls, Y(lVar, lVar2, cls2, cls3, y0.h.c()), cls3, lVar, mVar, gVar);
        this.D = lVar2;
        this.E = cls2;
        this.F = cls3;
        this.G = eVar;
    }
}
