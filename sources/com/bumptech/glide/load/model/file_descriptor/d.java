package com.bumptech.glide.load.model.file_descriptor;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.model.l;
import com.bumptech.glide.load.model.m;
import com.bumptech.glide.load.model.p;

/* JADX INFO: loaded from: classes.dex */
public class d extends p<ParcelFileDescriptor> implements b<String> {

    public static class a implements m<String, ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.model.m
        public void a() {
        }

        @Override // com.bumptech.glide.load.model.m
        public l<String, ParcelFileDescriptor> b(Context context, com.bumptech.glide.load.model.c cVar) {
            return new d((l<Uri, ParcelFileDescriptor>) cVar.a(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public d(Context context) {
        this((l<Uri, ParcelFileDescriptor>) com.bumptech.glide.l.b(Uri.class, context));
    }

    public d(l<Uri, ParcelFileDescriptor> lVar) {
        super(lVar);
    }
}
