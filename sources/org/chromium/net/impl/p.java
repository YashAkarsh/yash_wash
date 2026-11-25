package org.chromium.net.impl;

import org.chromium.net.h0;

/* JADX INFO: loaded from: classes3.dex */
public class p extends h0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f39396l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final n f39397m;

    public p(String str, int i7, int i8, int i9) {
        super(str, null);
        this.f39397m = new n(str, i7, i8);
        this.f39396l = i9;
    }

    @Override // org.chromium.net.z
    public int a() {
        return this.f39397m.a();
    }

    @Override // org.chromium.net.z
    public int b() {
        return this.f39397m.b();
    }

    @Override // org.chromium.net.z
    public boolean c() {
        return this.f39397m.c();
    }

    @Override // org.chromium.net.h0
    public int d() {
        return this.f39396l;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f39397m.getMessage() + ", QuicDetailedErrorCode=" + this.f39396l;
    }
}
