package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.load.engine.m;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class j implements w0.f<b> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final a f14679d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f14680e = "GifEncoder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.gifdecoder.a.InterfaceC0161a f14681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.c f14682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f14683c;

    static class a {
        a() {
        }

        public com.bumptech.glide.gifdecoder.a a(com.bumptech.glide.gifdecoder.a.InterfaceC0161a interfaceC0161a) {
            return new com.bumptech.glide.gifdecoder.a(interfaceC0161a);
        }

        public com.bumptech.glide.gifencoder.a b() {
            return new com.bumptech.glide.gifencoder.a();
        }

        public m<Bitmap> c(Bitmap bitmap, com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
            return new com.bumptech.glide.load.resource.bitmap.d(bitmap, cVar);
        }

        public com.bumptech.glide.gifdecoder.d d() {
            return new com.bumptech.glide.gifdecoder.d();
        }
    }

    public j(com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        this(cVar, f14679d);
    }

    private com.bumptech.glide.gifdecoder.a c(byte[] bArr) {
        com.bumptech.glide.gifdecoder.d dVarD = this.f14683c.d();
        dVarD.o(bArr);
        com.bumptech.glide.gifdecoder.c cVarC = dVarD.c();
        com.bumptech.glide.gifdecoder.a aVarA = this.f14683c.a(this.f14681a);
        aVarA.x(cVarC, bArr);
        aVarA.a();
        return aVarA;
    }

    private m<Bitmap> e(Bitmap bitmap, w0.g<Bitmap> gVar, b bVar) {
        m<Bitmap> mVarC = this.f14683c.c(bitmap, this.f14682b);
        m<Bitmap> mVarB = gVar.b(mVarC, bVar.getIntrinsicWidth(), bVar.getIntrinsicHeight());
        if (!mVarC.equals(mVarB)) {
            mVarC.a();
        }
        return mVarB;
    }

    private boolean f(byte[] bArr, OutputStream outputStream) {
        try {
            outputStream.write(bArr);
            return true;
        } catch (IOException e8) {
            if (Log.isLoggable(f14680e, 3)) {
                Log.d(f14680e, "Failed to write data to output stream in GifResourceEncoder", e8);
            }
            return false;
        }
    }

    @Override // w0.b
    public String a() {
        return "";
    }

    @Override // w0.b
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(m<b> mVar, OutputStream outputStream) {
        long jB = com.bumptech.glide.util.e.b();
        b bVar = mVar.get();
        w0.g<Bitmap> gVarK = bVar.k();
        if (gVarK instanceof com.bumptech.glide.load.resource.e) {
            return f(bVar.g(), outputStream);
        }
        com.bumptech.glide.gifdecoder.a aVarC = c(bVar.g());
        com.bumptech.glide.gifencoder.a aVarB = this.f14683c.b();
        if (!aVarB.m(outputStream)) {
            return false;
        }
        for (int i7 = 0; i7 < aVarC.g(); i7++) {
            m<Bitmap> mVarE = e(aVarC.n(), gVarK, bVar);
            try {
                if (!aVarB.a(mVarE.get())) {
                    mVarE.a();
                    return false;
                }
                aVarB.f(aVarC.f(aVarC.d()));
                aVarC.a();
                mVarE.a();
            } catch (Throwable th) {
                mVarE.a();
                throw th;
            }
        }
        boolean zD = aVarB.d();
        if (Log.isLoggable(f14680e, 2)) {
            Log.v(f14680e, "Encoded gif with " + aVarC.g() + " frames and " + bVar.g().length + " bytes in " + com.bumptech.glide.util.e.a(jB) + " ms");
        }
        return zD;
    }

    j(com.bumptech.glide.load.engine.bitmap_recycle.c cVar, a aVar) {
        this.f14682b = cVar;
        this.f14681a = new com.bumptech.glide.load.resource.gif.a(cVar);
        this.f14683c = aVar;
    }
}
