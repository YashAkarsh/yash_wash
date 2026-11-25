package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.data.k;
import com.bumptech.glide.load.model.l;
import com.bumptech.glide.load.model.m;
import com.bumptech.glide.load.model.q;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class i extends q<InputStream> implements f<Uri> {

    public static class a implements m<Uri, InputStream> {
        @Override // com.bumptech.glide.load.model.m
        public void a() {
        }

        @Override // com.bumptech.glide.load.model.m
        public l<Uri, InputStream> b(Context context, com.bumptech.glide.load.model.c cVar) {
            return new i(context, cVar.a(com.bumptech.glide.load.model.d.class, InputStream.class));
        }
    }

    public i(Context context) {
        this(context, com.bumptech.glide.l.g(com.bumptech.glide.load.model.d.class, context));
    }

    @Override // com.bumptech.glide.load.model.q
    protected com.bumptech.glide.load.data.c<InputStream> b(Context context, String str) {
        return new com.bumptech.glide.load.data.j(context.getApplicationContext().getAssets(), str);
    }

    @Override // com.bumptech.glide.load.model.q
    protected com.bumptech.glide.load.data.c<InputStream> c(Context context, Uri uri) {
        return new k(context, uri);
    }

    public i(Context context, l<com.bumptech.glide.load.model.d, InputStream> lVar) {
        super(context, lVar);
    }
}
