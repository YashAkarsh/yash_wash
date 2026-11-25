package com.google.android.material.progressindicator;

import android.animation.Animator;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
abstract class h<T extends Animator> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected i f18094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final float[] f18095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final int[] f18096c;

    protected h(int i7) {
        this.f18095b = new float[i7 * 2];
        this.f18096c = new int[i7];
    }

    abstract void a();

    protected float b(int i7, int i8, int i9) {
        return (i7 - i8) / i9;
    }

    public abstract void c();

    public abstract void d(@m0 androidx.vectordrawable.graphics.drawable.b.a aVar);

    protected void e(@m0 i iVar) {
        this.f18094a = iVar;
    }

    abstract void f();

    abstract void g();

    public abstract void h();
}
