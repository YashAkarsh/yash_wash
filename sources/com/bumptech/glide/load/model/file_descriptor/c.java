package com.bumptech.glide.load.model.file_descriptor;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.model.l;
import com.bumptech.glide.load.model.m;
import com.bumptech.glide.load.model.n;

/* JADX INFO: loaded from: classes.dex */
public class c extends n<ParcelFileDescriptor> implements b<Integer> {

    public static class a implements m<Integer, ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.model.m
        public void a() {
        }

        @Override // com.bumptech.glide.load.model.m
        public l<Integer, ParcelFileDescriptor> b(Context context, com.bumptech.glide.load.model.c cVar) {
            return new c(context, cVar.a(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public c(Context context) {
        this(context, com.bumptech.glide.l.b(Uri.class, context));
    }

    public c(Context context, l<Uri, ParcelFileDescriptor> lVar) {
        super(context, lVar);
    }
}
