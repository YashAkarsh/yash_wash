package com.bumptech.glide.request.animation;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;

/* JADX INFO: loaded from: classes.dex */
public class d<T extends Drawable> implements e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e<T> f14807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f14808b;

    public d(e<T> eVar, int i7) {
        this.f14807a = eVar;
        this.f14808b = i7;
    }

    @Override // com.bumptech.glide.request.animation.e
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean a(T t7, e.a aVar) {
        Drawable drawableJ = aVar.J();
        if (drawableJ == null) {
            this.f14807a.a(t7, aVar);
            return false;
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{drawableJ, t7});
        transitionDrawable.setCrossFadeEnabled(true);
        transitionDrawable.startTransition(this.f14808b);
        aVar.I(transitionDrawable);
        return true;
    }
}
