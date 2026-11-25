package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.engine.cache.i;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f14442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.c f14443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final w0.a f14444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f14445d = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f14446e;

    public b(i iVar, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, w0.a aVar) {
        this.f14442a = iVar;
        this.f14443b = cVar;
        this.f14444c = aVar;
    }

    private static int b(d dVar) {
        return com.bumptech.glide.util.i.e(dVar.d(), dVar.b(), dVar.a());
    }

    c a(d[] dVarArr) {
        int iC = (this.f14442a.c() - this.f14442a.b()) + this.f14443b.c();
        int iC2 = 0;
        for (d dVar : dVarArr) {
            iC2 += dVar.c();
        }
        float f8 = iC / iC2;
        HashMap map = new HashMap();
        for (d dVar2 : dVarArr) {
            map.put(dVar2, Integer.valueOf(Math.round(dVar2.c() * f8) / b(dVar2)));
        }
        return new c(map);
    }

    public void c(d.a... aVarArr) {
        a aVar = this.f14446e;
        if (aVar != null) {
            aVar.c();
        }
        d[] dVarArr = new d[aVarArr.length];
        for (int i7 = 0; i7 < aVarArr.length; i7++) {
            d.a aVar2 = aVarArr[i7];
            if (aVar2.b() == null) {
                w0.a aVar3 = this.f14444c;
                aVar2.c((aVar3 == w0.a.ALWAYS_ARGB_8888 || aVar3 == w0.a.PREFER_ARGB_8888) ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            }
            dVarArr[i7] = aVar2.a();
        }
        a aVar4 = new a(this.f14443b, this.f14442a, a(dVarArr));
        this.f14446e = aVar4;
        this.f14445d.post(aVar4);
    }
}
