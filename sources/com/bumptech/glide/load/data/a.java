package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.p;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T> implements c<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f14187d = "AssetUriFetcher";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AssetManager f14189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private T f14190c;

    public a(AssetManager assetManager, String str) {
        this.f14189b = assetManager;
        this.f14188a = str;
    }

    @Override // com.bumptech.glide.load.data.c
    public String a() {
        return this.f14188a;
    }

    @Override // com.bumptech.glide.load.data.c
    public void b() {
        T t7 = this.f14190c;
        if (t7 == null) {
            return;
        }
        try {
            d(t7);
        } catch (IOException e8) {
            if (Log.isLoggable(f14187d, 2)) {
                Log.v(f14187d, "Failed to close data", e8);
            }
        }
    }

    @Override // com.bumptech.glide.load.data.c
    public T c(p pVar) throws Exception {
        T tE = e(this.f14189b, this.f14188a);
        this.f14190c = tE;
        return tE;
    }

    @Override // com.bumptech.glide.load.data.c
    public void cancel() {
    }

    protected abstract void d(T t7) throws IOException;

    protected abstract T e(AssetManager assetManager, String str) throws IOException;
}
