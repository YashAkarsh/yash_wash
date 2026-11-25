package com.bumptech.glide.load.engine;

import android.util.Log;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f14234b = "CacheLoader";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.cache.a f14235a;

    public a(com.bumptech.glide.load.engine.cache.a aVar) {
        this.f14235a = aVar;
    }

    public <Z> m<Z> a(w0.c cVar, w0.e<File, Z> eVar, int i7, int i8) {
        File fileA = this.f14235a.a(cVar);
        m<Z> mVarB = null;
        if (fileA == null) {
            return null;
        }
        try {
            mVarB = eVar.b(fileA, i7, i8);
        } catch (IOException e8) {
            if (Log.isLoggable(f14234b, 3)) {
                Log.d(f14234b, "Exception decoding image from cache", e8);
            }
        }
        if (mVarB == null) {
            if (Log.isLoggable(f14234b, 3)) {
                Log.d(f14234b, "Failed to decode image from cache or not present in cache");
            }
            this.f14235a.b(cVar);
        }
        return mVarB;
    }
}
