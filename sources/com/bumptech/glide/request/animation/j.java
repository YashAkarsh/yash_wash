package com.bumptech.glide.request.animation;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class j<R> implements e<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f14817a;

    public interface a {
        void a(View view);
    }

    public j(a aVar) {
        this.f14817a = aVar;
    }

    @Override // com.bumptech.glide.request.animation.e
    public boolean a(R r7, e.a aVar) {
        if (aVar.H() == null) {
            return false;
        }
        this.f14817a.a(aVar.H());
        return false;
    }
}
