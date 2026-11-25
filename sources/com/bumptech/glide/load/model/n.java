package com.bumptech.glide.load.model;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class n<T> implements l<Integer, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f14505c = "ResourceLoader";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l<Uri, T> f14506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Resources f14507b;

    public n(Context context, l<Uri, T> lVar) {
        this(context.getResources(), lVar);
    }

    @Override // com.bumptech.glide.load.model.l
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.data.c<T> a(Integer num, int i7, int i8) {
        Uri uri;
        try {
            uri = Uri.parse("android.resource://" + this.f14507b.getResourcePackageName(num.intValue()) + '/' + this.f14507b.getResourceTypeName(num.intValue()) + '/' + this.f14507b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e8) {
            if (Log.isLoggable(f14505c, 5)) {
                Log.w(f14505c, "Received invalid resource id: " + num, e8);
            }
            uri = null;
        }
        if (uri != null) {
            return this.f14506a.a(uri, i7, i8);
        }
        return null;
    }

    public n(Resources resources, l<Uri, T> lVar) {
        this.f14507b = resources;
        this.f14506a = lVar;
    }
}
