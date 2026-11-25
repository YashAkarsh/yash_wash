package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import com.bumptech.glide.load.model.o;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class c implements a1.b<InputStream, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f14645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j f14646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final o f14647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.resource.file.c<b> f14648d;

    public c(Context context, com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        i iVar = new i(context, cVar);
        this.f14645a = iVar;
        this.f14648d = new com.bumptech.glide.load.resource.file.c<>(iVar);
        this.f14646b = new j(cVar);
        this.f14647c = new o();
    }

    @Override // a1.b
    public w0.b<InputStream> e() {
        return this.f14647c;
    }

    @Override // a1.b
    public w0.f<b> i() {
        return this.f14646b;
    }

    @Override // a1.b
    public w0.e<InputStream, b> j() {
        return this.f14645a;
    }

    @Override // a1.b
    public w0.e<File, b> k() {
        return this.f14648d;
    }
}
