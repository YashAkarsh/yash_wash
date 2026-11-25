package com.google.android.gms.internal.base;

import android.graphics.drawable.Drawable;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
final class h extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f16071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f16072b;

    h(@o0 h hVar) {
        if (hVar != null) {
            this.f16071a = hVar.f16071a;
            this.f16072b = hVar.f16072b;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return this.f16071a;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new i(this);
    }
}
