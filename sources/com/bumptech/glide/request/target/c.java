package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class c extends f<Bitmap> {
    public c(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.target.f
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void m(Bitmap bitmap) {
        ((ImageView) this.f14895b).setImageBitmap(bitmap);
    }
}
