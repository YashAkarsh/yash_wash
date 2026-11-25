package com.bumptech.glide.load.model.file_descriptor;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.data.f;
import com.bumptech.glide.load.model.l;
import com.bumptech.glide.load.model.m;
import com.bumptech.glide.load.model.q;

/* JADX INFO: loaded from: classes.dex */
public class e extends q<ParcelFileDescriptor> implements b<Uri> {

    public static class a implements m<Uri, ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.model.m
        public void a() {
        }

        @Override // com.bumptech.glide.load.model.m
        public l<Uri, ParcelFileDescriptor> b(Context context, com.bumptech.glide.load.model.c cVar) {
            return new e(context, cVar.a(com.bumptech.glide.load.model.d.class, ParcelFileDescriptor.class));
        }
    }

    public e(Context context) {
        this(context, com.bumptech.glide.l.b(com.bumptech.glide.load.model.d.class, context));
    }

    @Override // com.bumptech.glide.load.model.q
    protected com.bumptech.glide.load.data.c<ParcelFileDescriptor> b(Context context, String str) {
        return new com.bumptech.glide.load.data.e(context.getApplicationContext().getAssets(), str);
    }

    @Override // com.bumptech.glide.load.model.q
    protected com.bumptech.glide.load.data.c<ParcelFileDescriptor> c(Context context, Uri uri) {
        return new f(context, uri);
    }

    public e(Context context, l<com.bumptech.glide.load.model.d, ParcelFileDescriptor> lVar) {
        super(context, lVar);
    }
}
