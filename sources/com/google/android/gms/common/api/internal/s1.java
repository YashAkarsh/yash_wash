package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
final class s1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f15401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ v1 f15402b;

    s1(v1 v1Var, int i7) {
        this.f15402b = v1Var;
        this.f15401a = i7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f15402b.h(this.f15401a);
    }
}
