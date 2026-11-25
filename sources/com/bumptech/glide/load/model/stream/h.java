package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.model.l;
import com.bumptech.glide.load.model.m;
import com.bumptech.glide.load.model.p;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class h extends p<InputStream> implements f<String> {

    public static class a implements m<String, InputStream> {
        @Override // com.bumptech.glide.load.model.m
        public void a() {
        }

        @Override // com.bumptech.glide.load.model.m
        public l<String, InputStream> b(Context context, com.bumptech.glide.load.model.c cVar) {
            return new h((l<Uri, InputStream>) cVar.a(Uri.class, InputStream.class));
        }
    }

    public h(Context context) {
        this((l<Uri, InputStream>) com.bumptech.glide.l.g(Uri.class, context));
    }

    public h(l<Uri, InputStream> lVar) {
        super(lVar);
    }
}
