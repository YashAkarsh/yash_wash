package com.nostra13.universalimageloader.cache.disc.impl;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b extends com.nostra13.universalimageloader.cache.disc.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f32601d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<File, Long> f32602e;

    public b(File file, long j7) {
        this(file, com.nostra13.universalimageloader.core.a.d(), j7);
    }

    @Override // com.nostra13.universalimageloader.cache.disc.b
    public void a(String str, File file) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        file.setLastModified(jCurrentTimeMillis);
        this.f32602e.put(file, Long.valueOf(jCurrentTimeMillis));
    }

    @Override // com.nostra13.universalimageloader.cache.disc.a, com.nostra13.universalimageloader.cache.disc.b
    public File c(String str) {
        boolean z7;
        File fileC = super.c(str);
        if (fileC.exists()) {
            Long lValueOf = this.f32602e.get(fileC);
            if (lValueOf == null) {
                lValueOf = Long.valueOf(fileC.lastModified());
                z7 = false;
            } else {
                z7 = true;
            }
            if (System.currentTimeMillis() - lValueOf.longValue() > this.f32601d) {
                fileC.delete();
                this.f32602e.remove(fileC);
            } else if (!z7) {
                this.f32602e.put(fileC, lValueOf);
            }
        }
        return fileC;
    }

    public b(File file, x3.a aVar, long j7) {
        super(file, aVar);
        this.f32602e = Collections.synchronizedMap(new HashMap());
        this.f32601d = j7 * 1000;
    }
}
