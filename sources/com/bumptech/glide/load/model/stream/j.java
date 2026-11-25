package com.bumptech.glide.load.model.stream;

import android.content.Context;
import com.bumptech.glide.load.model.l;
import com.bumptech.glide.load.model.m;
import com.bumptech.glide.load.model.r;
import java.io.InputStream;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public class j extends r<InputStream> {

    public static class a implements m<URL, InputStream> {
        @Override // com.bumptech.glide.load.model.m
        public void a() {
        }

        @Override // com.bumptech.glide.load.model.m
        public l<URL, InputStream> b(Context context, com.bumptech.glide.load.model.c cVar) {
            return new j(cVar.a(com.bumptech.glide.load.model.d.class, InputStream.class));
        }
    }

    public j(l<com.bumptech.glide.load.model.d, InputStream> lVar) {
        super(lVar);
    }
}
