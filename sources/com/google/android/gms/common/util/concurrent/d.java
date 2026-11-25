package com.google.android.gms.common.util.concurrent;

import android.os.Process;

/* JADX INFO: loaded from: classes.dex */
final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Runnable f15994a;

    public d(Runnable runnable, int i7) {
        this.f15994a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(0);
        this.f15994a.run();
    }
}
