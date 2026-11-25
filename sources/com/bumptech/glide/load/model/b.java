package com.bumptech.glide.load.model;

import android.net.Uri;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class b<T> implements l<File, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l<Uri, T> f14463a;

    public b(l<Uri, T> lVar) {
        this.f14463a = lVar;
    }

    @Override // com.bumptech.glide.load.model.l
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.data.c<T> a(File file, int i7, int i8) {
        return this.f14463a.a(Uri.fromFile(file), i7, i8);
    }
}
