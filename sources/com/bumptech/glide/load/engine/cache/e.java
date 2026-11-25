package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class e implements a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f14318f = "DiskLruCacheWrapper";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f14319g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f14320h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static e f14321i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f14322a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l f14323b = new l();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f14324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f14325d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bumptech.glide.disklrucache.a f14326e;

    protected e(File file, int i7) {
        this.f14324c = file;
        this.f14325d = i7;
    }

    public static synchronized a d(File file, int i7) {
        if (f14321i == null) {
            f14321i = new e(file, i7);
        }
        return f14321i;
    }

    private synchronized com.bumptech.glide.disklrucache.a e() throws IOException {
        if (this.f14326e == null) {
            this.f14326e = com.bumptech.glide.disklrucache.a.p0(this.f14324c, 1, 1, this.f14325d);
        }
        return this.f14326e;
    }

    private synchronized void f() {
        this.f14326e = null;
    }

    @Override // com.bumptech.glide.load.engine.cache.a
    public File a(w0.c cVar) {
        try {
            com.bumptech.glide.disklrucache.a.d dVarQ = e().Q(this.f14323b.a(cVar));
            if (dVarQ != null) {
                return dVarQ.b(0);
            }
            return null;
        } catch (IOException e8) {
            if (!Log.isLoggable(f14318f, 5)) {
                return null;
            }
            Log.w(f14318f, "Unable to get from disk cache", e8);
            return null;
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.a
    public void b(w0.c cVar) {
        try {
            e().G0(this.f14323b.a(cVar));
        } catch (IOException e8) {
            if (Log.isLoggable(f14318f, 5)) {
                Log.w(f14318f, "Unable to delete from disk cache", e8);
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.a
    public void c(w0.c cVar, a.b bVar) {
        String strA = this.f14323b.a(cVar);
        this.f14322a.a(cVar);
        try {
            try {
                com.bumptech.glide.disklrucache.a.b bVarH = e().H(strA);
                if (bVarH != null) {
                    try {
                        if (bVar.a(bVarH.f(0))) {
                            bVarH.e();
                        }
                        bVarH.b();
                    } catch (Throwable th) {
                        bVarH.b();
                        throw th;
                    }
                }
            } catch (IOException e8) {
                if (Log.isLoggable(f14318f, 5)) {
                    Log.w(f14318f, "Unable to put to disk cache", e8);
                }
            }
            this.f14322a.b(cVar);
        } catch (Throwable th2) {
            this.f14322a.b(cVar);
            throw th2;
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.a
    public synchronized void clear() {
        try {
            e().F();
            f();
        } catch (IOException e8) {
            if (Log.isLoggable(f14318f, 5)) {
                Log.w(f14318f, "Unable to clear disk cache", e8);
            }
        }
    }
}
