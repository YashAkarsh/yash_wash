package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.m;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T extends Drawable> implements m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final T f14612a;

    public a(T t7) {
        if (t7 == null) {
            throw new NullPointerException("Drawable must not be null!");
        }
        this.f14612a = t7;
    }

    @Override // com.bumptech.glide.load.engine.m
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final T get() {
        return (T) this.f14612a.getConstantState().newDrawable();
    }
}
