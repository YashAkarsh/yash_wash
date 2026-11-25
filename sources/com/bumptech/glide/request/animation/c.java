package com.bumptech.glide.request.animation;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

/* JADX INFO: loaded from: classes.dex */
public class c<T extends Drawable> implements f<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f14801e = 300;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i<T> f14802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f14803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d<T> f14804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d<T> f14805d;

    private static class a implements h.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f14806a;

        a(int i7) {
            this.f14806a = i7;
        }

        @Override // com.bumptech.glide.request.animation.h.a
        public Animation build() {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(this.f14806a);
            return alphaAnimation;
        }
    }

    public c() {
        this(300);
    }

    private e<T> b() {
        if (this.f14804c == null) {
            this.f14804c = new d<>(this.f14802a.a(false, true), this.f14803b);
        }
        return this.f14804c;
    }

    private e<T> c() {
        if (this.f14805d == null) {
            this.f14805d = new d<>(this.f14802a.a(false, false), this.f14803b);
        }
        return this.f14805d;
    }

    @Override // com.bumptech.glide.request.animation.f
    public e<T> a(boolean z7, boolean z8) {
        if (z7) {
            return g.c();
        }
        return z8 ? b() : c();
    }

    public c(int i7) {
        this(new i(new a(i7)), i7);
    }

    public c(Context context, int i7, int i8) {
        this(new i(context, i7), i8);
    }

    public c(Animation animation, int i7) {
        this(new i(animation), i7);
    }

    c(i<T> iVar, int i7) {
        this.f14802a = iVar;
        this.f14803b = i7;
    }
}
