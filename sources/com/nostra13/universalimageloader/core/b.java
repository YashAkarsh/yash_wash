package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes2.dex */
final class b implements Runnable {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f32680j = "Display image in ImageAware (loaded from %1$s) [%2$s]";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f32681k = "ImageAware is reused for another image. Task is cancelled. [%s]";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f32682l = "ImageAware was collected by GC. Task is cancelled. [%s]";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bitmap f32683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f32684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.nostra13.universalimageloader.core.imageaware.a f32685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f32686d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.nostra13.universalimageloader.core.display.a f32687e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final y3.a f32688f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final f f32689g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.nostra13.universalimageloader.core.assist.f f32690h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f32691i;

    public b(Bitmap bitmap, g gVar, f fVar, com.nostra13.universalimageloader.core.assist.f fVar2) {
        this.f32683a = bitmap;
        this.f32684b = gVar.f32859a;
        this.f32685c = gVar.f32861c;
        this.f32686d = gVar.f32860b;
        this.f32687e = gVar.f32863e.w();
        this.f32688f = gVar.f32864f;
        this.f32689g = fVar;
        this.f32690h = fVar2;
    }

    private boolean a() {
        return !this.f32686d.equals(this.f32689g.g(this.f32685c));
    }

    void b(boolean z7) {
        this.f32691i = z7;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f32685c.f()) {
            if (this.f32691i) {
                com.nostra13.universalimageloader.utils.d.a(f32682l, this.f32686d);
            }
            this.f32688f.d(this.f32684b, this.f32685c.d());
        } else if (a()) {
            if (this.f32691i) {
                com.nostra13.universalimageloader.utils.d.a(f32681k, this.f32686d);
            }
            this.f32688f.d(this.f32684b, this.f32685c.d());
        } else {
            if (this.f32691i) {
                com.nostra13.universalimageloader.utils.d.a(f32680j, this.f32690h, this.f32686d);
            }
            this.f32687e.a(this.f32683a, this.f32685c, this.f32690h);
            this.f32688f.b(this.f32684b, this.f32685c.d(), this.f32683a);
            this.f32689g.d(this.f32685c);
        }
    }
}
