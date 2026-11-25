package com.bumptech.glide.load.engine.cache;

import android.annotation.SuppressLint;
import com.bumptech.glide.load.engine.m;

/* JADX INFO: loaded from: classes.dex */
public class h extends com.bumptech.glide.util.f<w0.c, m<?>> implements i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private i.a f14331e;

    public h(int i7) {
        super(i7);
    }

    @Override // com.bumptech.glide.load.engine.cache.i
    public /* bridge */ /* synthetic */ m d(w0.c cVar, m mVar) {
        return (m) super.n(cVar, mVar);
    }

    @Override // com.bumptech.glide.load.engine.cache.i
    @SuppressLint({"InlinedApi"})
    public void e(int i7) {
        if (i7 >= 60) {
            f();
        } else if (i7 >= 40) {
            p(b() / 2);
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.i
    public /* bridge */ /* synthetic */ m g(w0.c cVar) {
        return (m) super.o(cVar);
    }

    @Override // com.bumptech.glide.load.engine.cache.i
    public void h(i.a aVar) {
        this.f14331e = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.util.f
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public int l(m<?> mVar) {
        return mVar.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.util.f
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public void m(w0.c cVar, m<?> mVar) {
        i.a aVar = this.f14331e;
        if (aVar != null) {
            aVar.a(mVar);
        }
    }
}
