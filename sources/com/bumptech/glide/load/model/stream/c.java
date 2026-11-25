package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.model.l;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class c implements f<Uri> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f14517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l<Uri, InputStream> f14518b;

    public c(Context context, l<Uri, InputStream> lVar) {
        this.f14517a = context;
        this.f14518b = lVar;
    }

    @Override // com.bumptech.glide.load.model.l
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.data.c<InputStream> a(Uri uri, int i7, int i8) {
        return new com.bumptech.glide.load.data.i(this.f14517a, uri, this.f14518b.a(uri, i7, i8), i7, i8);
    }
}
