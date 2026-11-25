package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
interface g {
    String a(int i7, int i8, Bitmap.Config config);

    void b(Bitmap bitmap);

    int c(Bitmap bitmap);

    Bitmap d(int i7, int i8, Bitmap.Config config);

    String e(Bitmap bitmap);

    Bitmap removeLast();
}
