package y0;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.m;
import com.bumptech.glide.load.resource.bitmap.k;

/* JADX INFO: loaded from: classes.dex */
public class c implements f<com.bumptech.glide.load.resource.gifbitmap.a, com.bumptech.glide.load.resource.drawable.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f<Bitmap, k> f40578a;

    public c(f<Bitmap, k> fVar) {
        this.f40578a = fVar;
    }

    @Override // y0.f
    public String a() {
        return "GifBitmapWrapperDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }

    @Override // y0.f
    public m<com.bumptech.glide.load.resource.drawable.b> b(m<com.bumptech.glide.load.resource.gifbitmap.a> mVar) {
        com.bumptech.glide.load.resource.gifbitmap.a aVar = mVar.get();
        m<Bitmap> mVarA = aVar.a();
        return mVarA != null ? this.f40578a.b(mVarA) : aVar.b();
    }
}
