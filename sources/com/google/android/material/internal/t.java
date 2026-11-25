package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import c.m0;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
@t0(18)
class t implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewOverlay f17896a;

    t(@m0 View view) {
        this.f17896a = view.getOverlay();
    }

    @Override // com.google.android.material.internal.u
    public void a(@m0 Drawable drawable) {
        this.f17896a.add(drawable);
    }

    @Override // com.google.android.material.internal.u
    public void b(@m0 Drawable drawable) {
        this.f17896a.remove(drawable);
    }
}
