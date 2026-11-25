package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import c.o0;
import com.google.android.gms.common.internal.s;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class g extends h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WeakReference<ImageManager.a> f15614c;

    public g(ImageManager.a aVar, Uri uri) {
        super(uri, 0);
        com.google.android.gms.common.internal.d.c(aVar);
        this.f15614c = new WeakReference<>(aVar);
    }

    @Override // com.google.android.gms.common.images.h
    protected final void a(@o0 Drawable drawable, boolean z7, boolean z8, boolean z9) {
        ImageManager.a aVar;
        if (z8 || (aVar = this.f15614c.get()) == null) {
            return;
        }
        aVar.a(this.f15615a.f15612a, drawable, z9);
    }

    public final boolean equals(@o0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        ImageManager.a aVar = this.f15614c.get();
        ImageManager.a aVar2 = gVar.f15614c.get();
        return aVar2 != null && aVar != null && s.b(aVar2, aVar) && s.b(gVar.f15615a, this.f15615a);
    }

    public final int hashCode() {
        return s.c(this.f15615a);
    }
}
