package com.bumptech.glide.load.model.file_descriptor;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.model.l;
import com.bumptech.glide.load.model.m;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.bumptech.glide.load.model.b<ParcelFileDescriptor> implements b<File> {

    /* JADX INFO: renamed from: com.bumptech.glide.load.model.file_descriptor.a$a, reason: collision with other inner class name */
    public static class C0171a implements m<File, ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.model.m
        public void a() {
        }

        @Override // com.bumptech.glide.load.model.m
        public l<File, ParcelFileDescriptor> b(Context context, com.bumptech.glide.load.model.c cVar) {
            return new a((l<Uri, ParcelFileDescriptor>) cVar.a(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public a(Context context) {
        this((l<Uri, ParcelFileDescriptor>) com.bumptech.glide.l.b(Uri.class, context));
    }

    public a(l<Uri, ParcelFileDescriptor> lVar) {
        super(lVar);
    }
}
