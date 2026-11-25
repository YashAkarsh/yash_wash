package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import c.m0;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
@t0(18)
class q implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewGroupOverlay f17888a;

    q(@m0 ViewGroup viewGroup) {
        this.f17888a = viewGroup.getOverlay();
    }

    @Override // com.google.android.material.internal.u
    public void a(@m0 Drawable drawable) {
        this.f17888a.add(drawable);
    }

    @Override // com.google.android.material.internal.u
    public void b(@m0 Drawable drawable) {
        this.f17888a.remove(drawable);
    }

    @Override // com.google.android.material.internal.r
    public void c(@m0 View view) {
        this.f17888a.add(view);
    }

    @Override // com.google.android.material.internal.r
    public void d(@m0 View view) {
        this.f17888a.remove(view);
    }
}
