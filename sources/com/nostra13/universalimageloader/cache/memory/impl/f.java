package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class f implements com.nostra13.universalimageloader.cache.memory.c<String, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<String, Bitmap> f32621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f32622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f32623c;

    public f(int i7) {
        if (i7 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f32622b = i7;
        this.f32621a = new LinkedHashMap<>(0, 0.75f, true);
    }

    private int d(String str, Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    private void e(int i7) {
        while (true) {
            synchronized (this) {
                if (this.f32623c < 0 || (this.f32621a.isEmpty() && this.f32623c != 0)) {
                    break;
                }
                if (this.f32623c > i7 && !this.f32621a.isEmpty()) {
                    Map.Entry<String, Bitmap> next = this.f32621a.entrySet().iterator().next();
                    if (next == null) {
                        return;
                    }
                    String key = next.getKey();
                    Bitmap value = next.getValue();
                    this.f32621a.remove(key);
                    this.f32623c -= d(key, value);
                }
                return;
            }
        }
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
    }

    @Override // com.nostra13.universalimageloader.cache.memory.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Bitmap get(String str) {
        Bitmap bitmap;
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            bitmap = this.f32621a.get(str);
        }
        return bitmap;
    }

    @Override // com.nostra13.universalimageloader.cache.memory.c
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final boolean put(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f32623c += d(str, bitmap);
            Bitmap bitmapPut = this.f32621a.put(str, bitmap);
            if (bitmapPut != null) {
                this.f32623c -= d(str, bitmapPut);
            }
        }
        e(this.f32622b);
        return true;
    }

    @Override // com.nostra13.universalimageloader.cache.memory.c
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final void remove(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            Bitmap bitmapRemove = this.f32621a.remove(str);
            if (bitmapRemove != null) {
                this.f32623c -= d(str, bitmapRemove);
            }
        }
    }

    @Override // com.nostra13.universalimageloader.cache.memory.c
    public void clear() {
        e(-1);
    }

    @Override // com.nostra13.universalimageloader.cache.memory.c
    public Collection<String> keys() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f32621a.keySet());
        }
        return hashSet;
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", Integer.valueOf(this.f32622b));
    }
}
