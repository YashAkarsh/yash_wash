package com.google.android.material.textfield;

import android.content.Context;
import c.m0;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: loaded from: classes.dex */
abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    TextInputLayout f18714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Context f18715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    CheckableImageButton f18716c;

    e(@m0 TextInputLayout textInputLayout) {
        this.f18714a = textInputLayout;
        this.f18715b = textInputLayout.getContext();
        this.f18716c = textInputLayout.getEndIconView();
    }

    abstract void a();

    boolean b(int i7) {
        return true;
    }

    void c(boolean z7) {
    }

    boolean d() {
        return false;
    }
}
