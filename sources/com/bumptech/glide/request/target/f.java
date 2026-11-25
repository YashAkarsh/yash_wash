package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public abstract class f<Z> extends n<ImageView, Z> implements com.bumptech.glide.request.animation.e.a {
    public f(ImageView imageView) {
        super(imageView);
    }

    @Override // com.bumptech.glide.request.animation.e.a
    public void I(Drawable drawable) {
        ((ImageView) this.f14895b).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.request.animation.e.a
    public Drawable J() {
        return ((ImageView) this.f14895b).getDrawable();
    }

    @Override // com.bumptech.glide.request.target.m
    public void b(Z z7, com.bumptech.glide.request.animation.e<? super Z> eVar) {
        if (eVar == null || !eVar.a(z7, this)) {
            m(z7);
        }
    }

    @Override // com.bumptech.glide.request.target.b, com.bumptech.glide.request.target.m
    public void c(Exception exc, Drawable drawable) {
        ((ImageView) this.f14895b).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.request.target.b, com.bumptech.glide.request.target.m
    public void d(Drawable drawable) {
        ((ImageView) this.f14895b).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.request.target.b, com.bumptech.glide.request.target.m
    public void f(Drawable drawable) {
        ((ImageView) this.f14895b).setImageDrawable(drawable);
    }

    protected abstract void m(Z z7);
}
