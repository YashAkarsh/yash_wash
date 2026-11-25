package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class h extends com.nostra13.universalimageloader.cache.memory.a<String, Bitmap> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nostra13.universalimageloader.cache.memory.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Reference<Bitmap> a(Bitmap bitmap) {
        return new WeakReference(bitmap);
    }
}
