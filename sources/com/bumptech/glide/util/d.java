package com.bumptech.glide.util;

import com.bumptech.glide.n;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class d<T> implements n.d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f14922a;

    public d(int i7, int i8) {
        this.f14922a = new int[]{i7, i8};
    }

    @Override // com.bumptech.glide.n.d
    public int[] a(T t7, int i7, int i8) {
        int[] iArr = this.f14922a;
        return Arrays.copyOf(iArr, iArr.length);
    }
}
