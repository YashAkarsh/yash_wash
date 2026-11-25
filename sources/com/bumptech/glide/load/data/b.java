package com.bumptech.glide.load.data;

import com.bumptech.glide.p;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class b implements c<InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f14191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14192b;

    public b(byte[] bArr, String str) {
        this.f14191a = bArr;
        this.f14192b = str;
    }

    @Override // com.bumptech.glide.load.data.c
    public String a() {
        return this.f14192b;
    }

    @Override // com.bumptech.glide.load.data.c
    public void b() {
    }

    @Override // com.bumptech.glide.load.data.c
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.c
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public InputStream c(p pVar) {
        return new ByteArrayInputStream(this.f14191a);
    }
}
