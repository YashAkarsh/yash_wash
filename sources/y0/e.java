package y0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.bumptech.glide.l;
import com.bumptech.glide.load.engine.m;
import com.bumptech.glide.load.resource.bitmap.k;

/* JADX INFO: loaded from: classes.dex */
public class e implements f<Bitmap, k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Resources f40579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.c f40580b;

    public e(Context context) {
        this(context.getResources(), l.o(context).r());
    }

    @Override // y0.f
    public String a() {
        return "GlideBitmapDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }

    @Override // y0.f
    public m<k> b(m<Bitmap> mVar) {
        return new com.bumptech.glide.load.resource.bitmap.l(new k(this.f40579a, mVar.get()), this.f40580b);
    }

    public e(Resources resources, com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        this.f40579a = resources;
        this.f40580b = cVar;
    }
}
