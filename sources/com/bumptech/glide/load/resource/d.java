package com.bumptech.glide.load.resource;

import com.bumptech.glide.load.engine.m;

/* JADX INFO: loaded from: classes.dex */
public class d<T> implements m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final T f14611a;

    public d(T t7) {
        if (t7 == null) {
            throw new NullPointerException("Data must not be null");
        }
        this.f14611a = t7;
    }

    @Override // com.bumptech.glide.load.engine.m
    public void a() {
    }

    @Override // com.bumptech.glide.load.engine.m
    public final int b() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.m
    public final T get() {
        return this.f14611a;
    }
}
