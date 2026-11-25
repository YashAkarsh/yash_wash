package com.bumptech.glide.load.resource.gifbitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.resource.bitmap.m;
import com.bumptech.glide.load.resource.bitmap.p;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class c implements w0.e<com.bumptech.glide.load.model.g, com.bumptech.glide.load.resource.gifbitmap.a> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final b f14687g = new b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final a f14688h = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final int f14689i = 2048;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w0.e<com.bumptech.glide.load.model.g, Bitmap> f14690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final w0.e<InputStream, com.bumptech.glide.load.resource.gif.b> f14691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.c f14692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f14693d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a f14694e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f14695f;

    static class a {
        a() {
        }

        public InputStream a(InputStream inputStream, byte[] bArr) {
            return new p(inputStream, bArr);
        }
    }

    static class b {
        b() {
        }

        public m.a a(InputStream inputStream) throws IOException {
            return new m(inputStream).d();
        }
    }

    public c(w0.e<com.bumptech.glide.load.model.g, Bitmap> eVar, w0.e<InputStream, com.bumptech.glide.load.resource.gif.b> eVar2, com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        this(eVar, eVar2, cVar, f14687g, f14688h);
    }

    private com.bumptech.glide.load.resource.gifbitmap.a d(com.bumptech.glide.load.model.g gVar, int i7, int i8, byte[] bArr) throws IOException {
        return gVar.b() != null ? g(gVar, i7, i8, bArr) : e(gVar, i7, i8);
    }

    private com.bumptech.glide.load.resource.gifbitmap.a e(com.bumptech.glide.load.model.g gVar, int i7, int i8) throws IOException {
        com.bumptech.glide.load.engine.m<Bitmap> mVarB = this.f14690a.b(gVar, i7, i8);
        if (mVarB != null) {
            return new com.bumptech.glide.load.resource.gifbitmap.a(mVarB, null);
        }
        return null;
    }

    private com.bumptech.glide.load.resource.gifbitmap.a f(InputStream inputStream, int i7, int i8) throws IOException {
        com.bumptech.glide.load.engine.m<com.bumptech.glide.load.resource.gif.b> mVarB = this.f14691b.b(inputStream, i7, i8);
        if (mVarB == null) {
            return null;
        }
        com.bumptech.glide.load.resource.gif.b bVar = mVarB.get();
        return bVar.j() > 1 ? new com.bumptech.glide.load.resource.gifbitmap.a(null, mVarB) : new com.bumptech.glide.load.resource.gifbitmap.a(new com.bumptech.glide.load.resource.bitmap.d(bVar.i(), this.f14692c), null);
    }

    private com.bumptech.glide.load.resource.gifbitmap.a g(com.bumptech.glide.load.model.g gVar, int i7, int i8, byte[] bArr) throws IOException {
        InputStream inputStreamA = this.f14694e.a(gVar.b(), bArr);
        inputStreamA.mark(2048);
        m.a aVarA = this.f14693d.a(inputStreamA);
        inputStreamA.reset();
        com.bumptech.glide.load.resource.gifbitmap.a aVarF = aVarA == m.a.GIF ? f(inputStreamA, i7, i8) : null;
        return aVarF == null ? e(new com.bumptech.glide.load.model.g(inputStreamA, gVar.a()), i7, i8) : aVarF;
    }

    @Override // w0.e
    public String a() {
        if (this.f14695f == null) {
            this.f14695f = this.f14691b.a() + this.f14690a.a();
        }
        return this.f14695f;
    }

    @Override // w0.e
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.engine.m<com.bumptech.glide.load.resource.gifbitmap.a> b(com.bumptech.glide.load.model.g gVar, int i7, int i8) throws IOException {
        com.bumptech.glide.util.a aVarB = com.bumptech.glide.util.a.b();
        byte[] bArrC = aVarB.c();
        try {
            com.bumptech.glide.load.resource.gifbitmap.a aVarD = d(gVar, i7, i8, bArrC);
            aVarB.d(bArrC);
            if (aVarD != null) {
                return new com.bumptech.glide.load.resource.gifbitmap.b(aVarD);
            }
            return null;
        } catch (Throwable th) {
            aVarB.d(bArrC);
            throw th;
        }
    }

    c(w0.e<com.bumptech.glide.load.model.g, Bitmap> eVar, w0.e<InputStream, com.bumptech.glide.load.resource.gif.b> eVar2, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, b bVar, a aVar) {
        this.f14690a = eVar;
        this.f14691b = eVar2;
        this.f14692c = cVar;
        this.f14693d = bVar;
        this.f14694e = aVar;
    }
}
