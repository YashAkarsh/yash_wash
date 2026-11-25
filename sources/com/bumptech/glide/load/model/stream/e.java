package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.model.l;
import com.bumptech.glide.load.model.m;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class e extends com.bumptech.glide.load.model.b<InputStream> implements f<File> {

    public static class a implements m<File, InputStream> {
        @Override // com.bumptech.glide.load.model.m
        public void a() {
        }

        @Override // com.bumptech.glide.load.model.m
        public l<File, InputStream> b(Context context, com.bumptech.glide.load.model.c cVar) {
            return new e((l<Uri, InputStream>) cVar.a(Uri.class, InputStream.class));
        }
    }

    public e(Context context) {
        this((l<Uri, InputStream>) com.bumptech.glide.l.g(Uri.class, context));
    }

    public e(l<Uri, InputStream> lVar) {
        super(lVar);
    }
}
