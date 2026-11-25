package com.bumptech.glide.load.model;

import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public class r<T> implements l<URL, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l<d, T> f14512a;

    public r(l<d, T> lVar) {
        this.f14512a = lVar;
    }

    @Override // com.bumptech.glide.load.model.l
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.data.c<T> a(URL url, int i7, int i8) {
        return this.f14512a.a(new d(url), i7, i8);
    }
}
