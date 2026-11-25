package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.recyclerview.widget.m;
import c.o0;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.internal.base.zaj;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class f extends h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WeakReference<ImageView> f15613c;

    public f(ImageView imageView, int i7) {
        super(Uri.EMPTY, i7);
        com.google.android.gms.common.internal.d.c(imageView);
        this.f15613c = new WeakReference<>(imageView);
    }

    @Override // com.google.android.gms.common.images.h
    protected final void a(@o0 Drawable drawable, boolean z7, boolean z8, boolean z9) {
        ImageView imageView = this.f15613c.get();
        if (imageView != null) {
            if (!z8 && !z9 && (imageView instanceof zaj)) {
                throw null;
            }
            boolean z10 = false;
            if (!z8 && !z7) {
                z10 = true;
            }
            if (z10) {
                Drawable drawable2 = imageView.getDrawable();
                if (drawable2 == null) {
                    drawable2 = null;
                } else if (drawable2 instanceof com.google.android.gms.internal.base.i) {
                    drawable2 = ((com.google.android.gms.internal.base.i) drawable2).a();
                }
                drawable = new com.google.android.gms.internal.base.i(drawable2, drawable);
            }
            imageView.setImageDrawable(drawable);
            if (imageView instanceof zaj) {
                throw null;
            }
            if (drawable == null || !z10) {
                return;
            }
            ((com.google.android.gms.internal.base.i) drawable).b(m.f.f9644c);
        }
    }

    public final boolean equals(@o0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        ImageView imageView = this.f15613c.get();
        ImageView imageView2 = ((f) obj).f15613c.get();
        return (imageView2 == null || imageView == null || !s.b(imageView2, imageView)) ? false : true;
    }

    public final int hashCode() {
        return 0;
    }

    public f(ImageView imageView, Uri uri) {
        super(uri, 0);
        com.google.android.gms.common.internal.d.c(imageView);
        this.f15613c = new WeakReference<>(imageView);
    }
}
