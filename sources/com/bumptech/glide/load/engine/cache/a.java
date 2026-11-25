package com.bumptech.glide.load.engine.cache;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public interface a {

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.cache.a$a, reason: collision with other inner class name */
    public interface InterfaceC0164a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f14305a = 262144000;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f14306b = "image_manager_disk_cache";

        a build();
    }

    public interface b {
        boolean a(File file);
    }

    File a(w0.c cVar);

    void b(w0.c cVar);

    void c(w0.c cVar, b bVar);

    void clear();
}
