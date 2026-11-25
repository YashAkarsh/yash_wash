package com.bumptech.glide.request.animation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T> implements f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f<Drawable> f14798a;

    /* JADX INFO: renamed from: com.bumptech.glide.request.animation.a$a, reason: collision with other inner class name */
    private class C0172a implements e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e<Drawable> f14799a;

        public C0172a(e<Drawable> eVar) {
            this.f14799a = eVar;
        }

        @Override // com.bumptech.glide.request.animation.e
        public boolean a(T t7, e.a aVar) {
            return this.f14799a.a(new BitmapDrawable(aVar.H().getResources(), a.this.b(t7)), aVar);
        }
    }

    public a() {
        this(new c());
    }

    @Override // com.bumptech.glide.request.animation.f
    public e<T> a(boolean z7, boolean z8) {
        return new C0172a(this.f14798a.a(z7, z8));
    }

    protected abstract Bitmap b(T t7);

    public a(int i7) {
        this(new c(i7));
    }

    public a(Context context, int i7, int i8) {
        this(new c(context, i7, i8));
    }

    public a(Animation animation, int i7) {
        this(new c(animation, i7));
    }

    public a(f<Drawable> fVar) {
        this.f14798a = fVar;
    }
}
