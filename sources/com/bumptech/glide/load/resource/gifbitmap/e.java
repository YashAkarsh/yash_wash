package com.bumptech.glide.load.resource.gifbitmap;

import com.bumptech.glide.load.engine.m;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class e implements w0.e<InputStream, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w0.e<com.bumptech.glide.load.model.g, a> f14699a;

    public e(w0.e<com.bumptech.glide.load.model.g, a> eVar) {
        this.f14699a = eVar;
    }

    @Override // w0.e
    public String a() {
        return this.f14699a.a();
    }

    @Override // w0.e
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public m<a> b(InputStream inputStream, int i7, int i8) throws IOException {
        return this.f14699a.b(new com.bumptech.glide.load.model.g(inputStream, null), i7, i8);
    }
}
