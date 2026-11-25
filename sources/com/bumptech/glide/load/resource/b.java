package com.bumptech.glide.load.resource;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class b<T> implements w0.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b<?> f14521a = new b<>();

    public static <T> w0.b<T> c() {
        return f14521a;
    }

    @Override // w0.b
    public String a() {
        return "";
    }

    @Override // w0.b
    public boolean b(T t7, OutputStream outputStream) {
        return false;
    }
}
