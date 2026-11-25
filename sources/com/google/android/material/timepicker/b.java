package com.google.android.material.timepicker;

import android.content.Context;
import android.view.View;
import androidx.core.view.accessibility.l0;

/* JADX INFO: loaded from: classes.dex */
class b extends androidx.core.view.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final l0.a f18803d;

    public b(Context context, int i7) {
        this.f18803d = new l0.a(16, context.getString(i7));
    }

    @Override // androidx.core.view.a
    public void g(View view, l0 l0Var) {
        super.g(view, l0Var);
        l0Var.b(this.f18803d);
    }
}
