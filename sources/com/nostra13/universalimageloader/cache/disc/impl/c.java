package com.nostra13.universalimageloader.cache.disc.impl;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class c extends com.nostra13.universalimageloader.cache.disc.c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f32603h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f32604i = 2097152;

    public c(File file, int i7) {
        this(file, com.nostra13.universalimageloader.core.a.d(), i7);
    }

    @Override // com.nostra13.universalimageloader.cache.disc.c
    protected int f(File file) {
        return (int) file.length();
    }

    public c(File file, x3.a aVar, int i7) {
        super(file, aVar, i7);
        if (i7 < 2097152) {
            com.nostra13.universalimageloader.utils.d.i("You set too small disc cache size (less than %1$d Mb)", 2);
        }
    }
}
