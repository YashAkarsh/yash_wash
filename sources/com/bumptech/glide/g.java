package com.bumptech.glide;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class g<ModelType> extends f<ModelType> implements d {
    private final com.bumptech.glide.load.model.l<ModelType, InputStream> D;
    private final com.bumptech.glide.load.model.l<ModelType, ParcelFileDescriptor> E;
    private final q.e F;

    g(Class<ModelType> cls, com.bumptech.glide.load.model.l<ModelType, InputStream> lVar, com.bumptech.glide.load.model.l<ModelType, ParcelFileDescriptor> lVar2, Context context, l lVar3, com.bumptech.glide.manager.m mVar, com.bumptech.glide.manager.g gVar, q.e eVar) {
        super(context, cls, N0(lVar3, lVar, lVar2, com.bumptech.glide.load.resource.gifbitmap.a.class, com.bumptech.glide.load.resource.drawable.b.class, null), lVar3, mVar, gVar);
        this.D = lVar;
        this.E = lVar2;
        this.F = eVar;
    }

    private static <A, Z, R> a1.e<A, com.bumptech.glide.load.model.g, Z, R> N0(l lVar, com.bumptech.glide.load.model.l<A, InputStream> lVar2, com.bumptech.glide.load.model.l<A, ParcelFileDescriptor> lVar3, Class<Z> cls, Class<R> cls2, y0.f<Z, R> fVar) {
        if (lVar2 == null && lVar3 == null) {
            return null;
        }
        if (fVar == null) {
            fVar = lVar.i(cls, cls2);
        }
        return new a1.e<>(new com.bumptech.glide.load.model.f(lVar2, lVar3), fVar, lVar.a(com.bumptech.glide.load.model.g.class, cls));
    }

    private i<ModelType, InputStream, File> O0() {
        q.e eVar = this.F;
        return (i) eVar.a(new i(File.class, this, this.D, InputStream.class, File.class, eVar));
    }

    public c<ModelType> L0() {
        q.e eVar = this.F;
        return (c) eVar.a(new c(this, this.D, this.E, eVar));
    }

    public k<ModelType> M0() {
        q.e eVar = this.F;
        return (k) eVar.a(new k(this, this.D, eVar));
    }

    @Override // com.bumptech.glide.d
    public com.bumptech.glide.request.a<File> a(int i7, int i8) {
        return O0().a(i7, i8);
    }

    @Override // com.bumptech.glide.d
    public <Y extends com.bumptech.glide.request.target.m<File>> Y d(Y y7) {
        return (Y) O0().d(y7);
    }
}
