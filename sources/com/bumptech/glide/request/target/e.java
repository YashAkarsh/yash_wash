package com.bumptech.glide.request.target;

import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class e extends f<com.bumptech.glide.load.resource.drawable.b> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f14876i = 0.05f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f14877g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.bumptech.glide.load.resource.drawable.b f14878h;

    public e(ImageView imageView) {
        this(imageView, -1);
    }

    @Override // com.bumptech.glide.request.target.b, com.bumptech.glide.manager.h
    public void g() {
        com.bumptech.glide.load.resource.drawable.b bVar = this.f14878h;
        if (bVar != null) {
            bVar.stop();
        }
    }

    @Override // com.bumptech.glide.request.target.f, com.bumptech.glide.request.target.m
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void b(com.bumptech.glide.load.resource.drawable.b bVar, com.bumptech.glide.request.animation.e<? super com.bumptech.glide.load.resource.drawable.b> eVar) {
        if (!bVar.e()) {
            float width = ((ImageView) this.f14895b).getWidth() / ((ImageView) this.f14895b).getHeight();
            float intrinsicWidth = bVar.getIntrinsicWidth() / bVar.getIntrinsicHeight();
            if (Math.abs(width - 1.0f) <= f14876i && Math.abs(intrinsicWidth - 1.0f) <= f14876i) {
                bVar = new l(bVar, ((ImageView) this.f14895b).getWidth());
            }
        }
        super.b(bVar, eVar);
        this.f14878h = bVar;
        bVar.f(this.f14877g);
        bVar.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.target.f
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void m(com.bumptech.glide.load.resource.drawable.b bVar) {
        ((ImageView) this.f14895b).setImageDrawable(bVar);
    }

    @Override // com.bumptech.glide.request.target.b, com.bumptech.glide.manager.h
    public void onStart() {
        com.bumptech.glide.load.resource.drawable.b bVar = this.f14878h;
        if (bVar != null) {
            bVar.start();
        }
    }

    public e(ImageView imageView, int i7) {
        super(imageView);
        this.f14877g = i7;
    }
}
