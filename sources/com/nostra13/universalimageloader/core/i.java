package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;

/* JADX INFO: loaded from: classes2.dex */
class i implements Runnable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f32902e = "PostProcess image before displaying [%s]";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f32903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Bitmap f32904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g f32905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f32906d;

    public i(f fVar, Bitmap bitmap, g gVar, Handler handler) {
        this.f32903a = fVar;
        this.f32904b = bitmap;
        this.f32905c = gVar;
        this.f32906d = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f32903a.f32847a.f32817u) {
            com.nostra13.universalimageloader.utils.d.a(f32902e, this.f32905c.f32860b);
        }
        b bVar = new b(this.f32905c.f32863e.D().a(this.f32904b), this.f32905c, this.f32903a, com.nostra13.universalimageloader.core.assist.f.MEMORY_CACHE);
        bVar.b(this.f32903a.f32847a.f32817u);
        h.w(bVar, this.f32905c.f32863e.J(), this.f32906d);
    }
}
