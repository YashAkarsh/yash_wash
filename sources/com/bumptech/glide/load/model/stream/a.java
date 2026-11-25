package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.text.TextUtils;
import com.bumptech.glide.load.model.k;
import com.bumptech.glide.load.model.l;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T> implements f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l<com.bumptech.glide.load.model.d, InputStream> f14513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k<T, com.bumptech.glide.load.model.d> f14514b;

    public a(Context context) {
        this(context, (k) null);
    }

    @Override // com.bumptech.glide.load.model.l
    public com.bumptech.glide.load.data.c<InputStream> a(T t7, int i7, int i8) {
        k<T, com.bumptech.glide.load.model.d> kVar = this.f14514b;
        com.bumptech.glide.load.model.d dVarA = kVar != null ? kVar.a(t7, i7, i8) : null;
        if (dVarA == null) {
            String strC = c(t7, i7, i8);
            if (TextUtils.isEmpty(strC)) {
                return null;
            }
            com.bumptech.glide.load.model.d dVar = new com.bumptech.glide.load.model.d(strC, b(t7, i7, i8));
            k<T, com.bumptech.glide.load.model.d> kVar2 = this.f14514b;
            if (kVar2 != null) {
                kVar2.b(t7, i7, i8, dVar);
            }
            dVarA = dVar;
        }
        return this.f14513a.a(dVarA, i7, i8);
    }

    protected com.bumptech.glide.load.model.e b(T t7, int i7, int i8) {
        return com.bumptech.glide.load.model.e.f14475b;
    }

    protected abstract String c(T t7, int i7, int i8);

    public a(Context context, k<T, com.bumptech.glide.load.model.d> kVar) {
        this((l<com.bumptech.glide.load.model.d, InputStream>) com.bumptech.glide.l.e(com.bumptech.glide.load.model.d.class, InputStream.class, context), kVar);
    }

    public a(l<com.bumptech.glide.load.model.d, InputStream> lVar) {
        this(lVar, (k) null);
    }

    public a(l<com.bumptech.glide.load.model.d, InputStream> lVar, k<T, com.bumptech.glide.load.model.d> kVar) {
        this.f14513a = lVar;
        this.f14514b = kVar;
    }
}
