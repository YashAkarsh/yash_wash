package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepName;

/* JADX INFO: loaded from: classes.dex */
@KeepName
public class GooglePlayServicesManifestException extends IllegalStateException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f15025a;

    public GooglePlayServicesManifestException(int i7, @c.m0 String str) {
        super(str);
        this.f15025a = i7;
    }

    public int a() {
        return this.f15025a;
    }

    public int b() {
        return h.f15574a;
    }
}
