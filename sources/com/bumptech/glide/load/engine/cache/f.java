package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class f extends d {

    class a implements d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f14327a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f14328b;

        a(Context context, String str) {
            this.f14327a = context;
            this.f14328b = str;
        }

        @Override // com.bumptech.glide.load.engine.cache.d.c
        public File a() {
            File externalCacheDir = this.f14327a.getExternalCacheDir();
            if (externalCacheDir == null) {
                return null;
            }
            return this.f14328b != null ? new File(externalCacheDir, this.f14328b) : externalCacheDir;
        }
    }

    public f(Context context) {
        this(context, com.bumptech.glide.load.engine.cache.a.InterfaceC0164a.f14306b, com.bumptech.glide.load.engine.cache.a.InterfaceC0164a.f14305a);
    }

    public f(Context context, int i7) {
        this(context, com.bumptech.glide.load.engine.cache.a.InterfaceC0164a.f14306b, i7);
    }

    public f(Context context, String str, int i7) {
        super(new a(context, str), i7);
    }
}
