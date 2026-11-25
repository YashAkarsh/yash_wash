package com.bumptech.glide.load.model;

import android.content.Context;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public abstract class q<T> implements l<Uri, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f14510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l<d, T> f14511b;

    public q(Context context, l<d, T> lVar) {
        this.f14510a = context;
        this.f14511b = lVar;
    }

    private static boolean e(String str) {
        return "file".equals(str) || "content".equals(str) || "android.resource".equals(str);
    }

    protected abstract com.bumptech.glide.load.data.c<T> b(Context context, String str);

    protected abstract com.bumptech.glide.load.data.c<T> c(Context context, Uri uri);

    @Override // com.bumptech.glide.load.model.l
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final com.bumptech.glide.load.data.c<T> a(Uri uri, int i7, int i8) {
        String scheme = uri.getScheme();
        if (e(scheme)) {
            if (!a.a(uri)) {
                return c(this.f14510a, uri);
            }
            return b(this.f14510a, a.b(uri));
        }
        if (this.f14511b == null || !(com.haier.uhome.usdk.base.a.av.equals(scheme) || j0.b.f34226a.equals(scheme))) {
            return null;
        }
        return this.f14511b.a(new d(uri.toString()), i7, i8);
    }
}
