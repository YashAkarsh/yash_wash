package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputStream f14481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ParcelFileDescriptor f14482b;

    public g(InputStream inputStream, ParcelFileDescriptor parcelFileDescriptor) {
        this.f14481a = inputStream;
        this.f14482b = parcelFileDescriptor;
    }

    public ParcelFileDescriptor a() {
        return this.f14482b;
    }

    public InputStream b() {
        return this.f14481a;
    }
}
