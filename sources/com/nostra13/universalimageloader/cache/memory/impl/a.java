package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.nostra13.universalimageloader.cache.memory.b<String, Bitmap> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<Bitmap> f32611g;

    public a(int i7) {
        super(i7);
        this.f32611g = Collections.synchronizedList(new LinkedList());
    }

    @Override // com.nostra13.universalimageloader.cache.memory.b, com.nostra13.universalimageloader.cache.memory.a, com.nostra13.universalimageloader.cache.memory.c
    public void clear() {
        this.f32611g.clear();
        super.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nostra13.universalimageloader.cache.memory.a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Reference<Bitmap> a(Bitmap bitmap) {
        return new WeakReference(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nostra13.universalimageloader.cache.memory.b
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public int b(Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    @Override // com.nostra13.universalimageloader.cache.memory.b, com.nostra13.universalimageloader.cache.memory.a, com.nostra13.universalimageloader.cache.memory.c
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public boolean put(String str, Bitmap bitmap) {
        if (!super.put(str, bitmap)) {
            return false;
        }
        this.f32611g.add(bitmap);
        return true;
    }

    @Override // com.nostra13.universalimageloader.cache.memory.b, com.nostra13.universalimageloader.cache.memory.a, com.nostra13.universalimageloader.cache.memory.c
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void remove(String str) {
        Bitmap bitmap = (Bitmap) super.get(str);
        if (bitmap != null) {
            this.f32611g.remove(bitmap);
        }
        super.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nostra13.universalimageloader.cache.memory.b
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public Bitmap d() {
        return this.f32611g.remove(0);
    }
}
