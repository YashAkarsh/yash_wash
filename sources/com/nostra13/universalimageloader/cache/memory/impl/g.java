package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class g extends com.nostra13.universalimageloader.cache.memory.b<String, Bitmap> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<Bitmap, Integer> f32624g;

    public g(int i7) {
        super(i7);
        this.f32624g = Collections.synchronizedMap(new HashMap());
    }

    @Override // com.nostra13.universalimageloader.cache.memory.b, com.nostra13.universalimageloader.cache.memory.a, com.nostra13.universalimageloader.cache.memory.c
    public void clear() {
        this.f32624g.clear();
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
        Integer num;
        Bitmap bitmap = (Bitmap) super.get(str);
        if (bitmap != null && (num = this.f32624g.get(bitmap)) != null) {
            this.f32624g.put(bitmap, Integer.valueOf(num.intValue() + 1));
        }
        return bitmap;
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
        this.f32624g.put(bitmap, 0);
        return true;
    }

    @Override // com.nostra13.universalimageloader.cache.memory.b, com.nostra13.universalimageloader.cache.memory.a, com.nostra13.universalimageloader.cache.memory.c
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public void remove(String str) {
        Bitmap bitmap = (Bitmap) super.get(str);
        if (bitmap != null) {
            this.f32624g.remove(bitmap);
        }
        super.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nostra13.universalimageloader.cache.memory.b
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public Bitmap d() {
        Bitmap key;
        Set<Map.Entry<Bitmap, Integer>> setEntrySet = this.f32624g.entrySet();
        synchronized (this.f32624g) {
            key = null;
            Integer value = null;
            for (Map.Entry<Bitmap, Integer> entry : setEntrySet) {
                if (key == null) {
                    key = entry.getKey();
                    value = entry.getValue();
                } else {
                    Integer value2 = entry.getValue();
                    if (value2.intValue() < value.intValue()) {
                        key = entry.getKey();
                        value = value2;
                    }
                }
            }
        }
        this.f32624g.remove(key);
        return key;
    }
}
