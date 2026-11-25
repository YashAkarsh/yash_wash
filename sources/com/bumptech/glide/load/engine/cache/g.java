package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class g extends d {

    class a implements d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f14329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f14330b;

        a(Context context, String str) {
            this.f14329a = context;
            this.f14330b = str;
        }

        @Override // com.bumptech.glide.load.engine.cache.d.c
        public File a() {
            File cacheDir = this.f14329a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.f14330b != null ? new File(cacheDir, this.f14330b) : cacheDir;
        }
    }

    public g(Context context) {
        this(context, com.bumptech.glide.load.engine.cache.a.InterfaceC0164a.f14306b, com.bumptech.glide.load.engine.cache.a.InterfaceC0164a.f14305a);
    }

    public g(Context context, int i7) {
        this(context, com.bumptech.glide.load.engine.cache.a.InterfaceC0164a.f14306b, i7);
    }

    public g(Context context, String str, int i7) {
        super(new a(context, str), i7);
    }
}
