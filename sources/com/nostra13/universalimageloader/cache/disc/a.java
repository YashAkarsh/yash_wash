package com.nostra13.universalimageloader.cache.disc;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f32593c = "\"%s\" argument must be not null";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected File f32594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private x3.a f32595b;

    public a(File file) {
        this(file, com.nostra13.universalimageloader.core.a.d());
    }

    @Override // com.nostra13.universalimageloader.cache.disc.b
    public File c(String str) {
        return new File(this.f32594a, this.f32595b.a(str));
    }

    @Override // com.nostra13.universalimageloader.cache.disc.b
    public void clear() {
        File[] fileArrListFiles = this.f32594a.listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                file.delete();
            }
        }
    }

    public a(File file, x3.a aVar) {
        if (file == null) {
            throw new IllegalArgumentException(String.format(f32593c, "cacheDir"));
        }
        if (aVar == null) {
            throw new IllegalArgumentException(String.format(f32593c, "fileNameGenerator"));
        }
        this.f32594a = file;
        this.f32595b = aVar;
    }
}
