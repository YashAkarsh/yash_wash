package y0;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.m;

/* JADX INFO: loaded from: classes.dex */
public class b implements f<Bitmap, com.bumptech.glide.load.resource.drawable.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f40577a;

    public b(Context context) {
        this(new e(context));
    }

    @Override // y0.f
    public String a() {
        return this.f40577a.a();
    }

    @Override // y0.f
    public m<com.bumptech.glide.load.resource.drawable.b> b(m<Bitmap> mVar) {
        return this.f40577a.b(mVar);
    }

    public b(e eVar) {
        this.f40577a = eVar;
    }
}
