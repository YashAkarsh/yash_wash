package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class d extends f<Drawable> {
    public d(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.target.f
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void m(Drawable drawable) {
        ((ImageView) this.f14895b).setImageDrawable(drawable);
    }
}
