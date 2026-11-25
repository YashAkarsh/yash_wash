package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class p<T> implements l<String, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l<Uri, T> f14509a;

    public p(l<Uri, T> lVar) {
        this.f14509a = lVar;
    }

    private static Uri c(String str) {
        return Uri.fromFile(new File(str));
    }

    @Override // com.bumptech.glide.load.model.l
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.data.c<T> a(String str, int i7, int i8) {
        Uri uriC;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("/")) {
            uriC = c(str);
        } else {
            Uri uri = Uri.parse(str);
            uriC = uri.getScheme() == null ? c(str) : uri;
        }
        return this.f14509a.a(uriC, i7, i8);
    }
}
