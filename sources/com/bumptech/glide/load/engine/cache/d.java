package com.bumptech.glide.load.engine.cache;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class d implements com.bumptech.glide.load.engine.cache.a.InterfaceC0164a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f14313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f14314d;

    class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f14315a;

        a(String str) {
            this.f14315a = str;
        }

        @Override // com.bumptech.glide.load.engine.cache.d.c
        public File a() {
            return new File(this.f14315a);
        }
    }

    class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f14316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f14317b;

        b(String str, String str2) {
            this.f14316a = str;
            this.f14317b = str2;
        }

        @Override // com.bumptech.glide.load.engine.cache.d.c
        public File a() {
            return new File(this.f14316a, this.f14317b);
        }
    }

    public interface c {
        File a();
    }

    public d(String str, int i7) {
        this(new a(str), i7);
    }

    @Override // com.bumptech.glide.load.engine.cache.a.InterfaceC0164a
    public com.bumptech.glide.load.engine.cache.a build() {
        File fileA = this.f14314d.a();
        if (fileA == null) {
            return null;
        }
        if (fileA.mkdirs() || (fileA.exists() && fileA.isDirectory())) {
            return e.d(fileA, this.f14313c);
        }
        return null;
    }

    public d(String str, String str2, int i7) {
        this(new b(str, str2), i7);
    }

    public d(c cVar, int i7) {
        this.f14313c = i7;
        this.f14314d = cVar;
    }
}
