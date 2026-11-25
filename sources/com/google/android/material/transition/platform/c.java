package com.google.android.material.transition.platform;

import c.t0;

/* JADX INFO: loaded from: classes.dex */
@t0(21)
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f19004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f19005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f19006c;

    private c(int i7, int i8, boolean z7) {
        this.f19004a = i7;
        this.f19005b = i8;
        this.f19006c = z7;
    }

    static c a(int i7, int i8) {
        return new c(i7, i8, true);
    }

    static c b(int i7, int i8) {
        return new c(i7, i8, false);
    }
}
