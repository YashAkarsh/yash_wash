package com.bumptech.glide.request.animation;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/* JADX INFO: loaded from: classes.dex */
public class i<R> implements f<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h.a f14812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private e<R> f14813b;

    private static class a implements h.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Animation f14814a;

        public a(Animation animation) {
            this.f14814a = animation;
        }

        @Override // com.bumptech.glide.request.animation.h.a
        public Animation build() {
            return this.f14814a;
        }
    }

    private static class b implements h.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f14815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f14816b;

        public b(Context context, int i7) {
            this.f14815a = context.getApplicationContext();
            this.f14816b = i7;
        }

        @Override // com.bumptech.glide.request.animation.h.a
        public Animation build() {
            return AnimationUtils.loadAnimation(this.f14815a, this.f14816b);
        }
    }

    public i(Animation animation) {
        this(new a(animation));
    }

    @Override // com.bumptech.glide.request.animation.f
    public e<R> a(boolean z7, boolean z8) {
        if (z7 || !z8) {
            return g.c();
        }
        if (this.f14813b == null) {
            this.f14813b = new h(this.f14812a);
        }
        return this.f14813b;
    }

    public i(Context context, int i7) {
        this(new b(context, i7));
    }

    i(h.a aVar) {
        this.f14812a = aVar;
    }
}
