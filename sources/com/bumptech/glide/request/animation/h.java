package com.bumptech.glide.request.animation;

import android.view.View;
import android.view.animation.Animation;

/* JADX INFO: loaded from: classes.dex */
public class h<R> implements e<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f14811a;

    interface a {
        Animation build();
    }

    h(a aVar) {
        this.f14811a = aVar;
    }

    @Override // com.bumptech.glide.request.animation.e
    public boolean a(R r7, e.a aVar) {
        View viewH = aVar.H();
        if (viewH == null) {
            return false;
        }
        viewH.clearAnimation();
        viewH.startAnimation(this.f14811a.build());
        return false;
    }
}
