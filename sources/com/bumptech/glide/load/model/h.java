package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class h implements w0.b<g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w0.b<InputStream> f14483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final w0.b<ParcelFileDescriptor> f14484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f14485c;

    public h(w0.b<InputStream> bVar, w0.b<ParcelFileDescriptor> bVar2) {
        this.f14483a = bVar;
        this.f14484b = bVar2;
    }

    @Override // w0.b
    public String a() {
        if (this.f14485c == null) {
            this.f14485c = this.f14483a.a() + this.f14484b.a();
        }
        return this.f14485c;
    }

    @Override // w0.b
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean b(g gVar, OutputStream outputStream) {
        return gVar.b() != null ? this.f14483a.b(gVar.b(), outputStream) : this.f14484b.b(gVar.a(), outputStream);
    }
}
