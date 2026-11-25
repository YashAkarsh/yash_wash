package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class g {
    public <Z> m<Z> a(ImageView imageView, Class<Z> cls) {
        if (com.bumptech.glide.load.resource.drawable.b.class.isAssignableFrom(cls)) {
            return new e(imageView);
        }
        if (Bitmap.class.equals(cls)) {
            return new c(imageView);
        }
        if (Drawable.class.isAssignableFrom(cls)) {
            return new d(imageView);
        }
        throw new IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
    }
}
