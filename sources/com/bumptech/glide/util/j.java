package com.bumptech.glide.util;

import android.view.View;
import com.bumptech.glide.n;
import com.bumptech.glide.request.target.k;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class j<T> implements n.d<T>, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f14937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f14938b;

    private static final class a extends com.bumptech.glide.request.target.n<View, Object> {
        public a(View view, k kVar) {
            super(view);
            h(kVar);
        }

        @Override // com.bumptech.glide.request.target.m
        public void b(Object obj, com.bumptech.glide.request.animation.e eVar) {
        }
    }

    public j() {
    }

    @Override // com.bumptech.glide.n.d
    public int[] a(T t7, int i7, int i8) {
        int[] iArr = this.f14937a;
        if (iArr == null) {
            return null;
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    public void b(View view) {
        if (this.f14937a == null && this.f14938b == null) {
            this.f14938b = new a(view, this);
        }
    }

    @Override // com.bumptech.glide.request.target.k
    public void e(int i7, int i8) {
        this.f14937a = new int[]{i7, i8};
        this.f14938b = null;
    }

    public j(View view) {
        b(view);
    }
}
