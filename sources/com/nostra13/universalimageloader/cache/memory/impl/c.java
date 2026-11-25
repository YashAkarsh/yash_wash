package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c extends com.nostra13.universalimageloader.cache.memory.b<String, Bitmap> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f32614h = 10;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f32615i = 1.1f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<String, Bitmap> f32616g;

    public c(int i7) {
        super(i7);
        this.f32616g = Collections.synchronizedMap(new LinkedHashMap(10, f32615i, true));
    }

    @Override // com.nostra13.universalimageloader.cache.memory.b, com.nostra13.universalimageloader.cache.memory.a, com.nostra13.universalimageloader.cache.memory.c
    public void clear() {
        this.f32616g.clear();
        super.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nostra13.universalimageloader.cache.memory.a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Reference<Bitmap> a(Bitmap bitmap) {
        return new WeakReference(bitmap);
    }

    @Override // com.nostra13.universalimageloader.cache.memory.a, com.nostra13.universalimageloader.cache.memory.c
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Bitmap get(String str) {
        this.f32616g.get(str);
        return (Bitmap) super.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nostra13.universalimageloader.cache.memory.b
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public int b(Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    @Override // com.nostra13.universalimageloader.cache.memory.b, com.nostra13.universalimageloader.cache.memory.a, com.nostra13.universalimageloader.cache.memory.c
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public boolean put(String str, Bitmap bitmap) {
        if (!super.put(str, bitmap)) {
            return false;
        }
        this.f32616g.put(str, bitmap);
        return true;
    }

    @Override // com.nostra13.universalimageloader.cache.memory.b, com.nostra13.universalimageloader.cache.memory.a, com.nostra13.universalimageloader.cache.memory.c
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public void remove(String str) {
        this.f32616g.remove(str);
        super.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nostra13.universalimageloader.cache.memory.b
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public Bitmap d() {
        Bitmap value;
        synchronized (this.f32616g) {
            Iterator<Map.Entry<String, Bitmap>> it = this.f32616g.entrySet().iterator();
            if (it.hasNext()) {
                value = it.next().getValue();
                it.remove();
            } else {
                value = null;
            }
        }
        return value;
    }
}
