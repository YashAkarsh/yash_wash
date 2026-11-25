package com.google.android.material.transition;

/* JADX INFO: loaded from: classes.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f18911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f18912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f18913c;

    private c(int i7, int i8, boolean z7) {
        this.f18911a = i7;
        this.f18912b = i8;
        this.f18913c = z7;
    }

    static c a(int i7, int i8) {
        return new c(i7, i8, true);
    }

    static c b(int i7, int i8) {
        return new c(i7, i8, false);
    }
}
