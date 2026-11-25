package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.model.l;
import com.bumptech.glide.load.model.m;
import com.bumptech.glide.load.model.n;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class g extends n<InputStream> implements f<Integer> {

    public static class a implements m<Integer, InputStream> {
        @Override // com.bumptech.glide.load.model.m
        public void a() {
        }

        @Override // com.bumptech.glide.load.model.m
        public l<Integer, InputStream> b(Context context, com.bumptech.glide.load.model.c cVar) {
            return new g(context, cVar.a(Uri.class, InputStream.class));
        }
    }

    public g(Context context) {
        this(context, com.bumptech.glide.l.g(Uri.class, context));
    }

    public g(Context context, l<Uri, InputStream> lVar) {
        super(context, lVar);
    }
}
