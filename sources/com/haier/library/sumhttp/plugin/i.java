package com.haier.library.sumhttp.plugin;

import com.haier.library.common.thread.m;

/* JADX INFO: loaded from: classes2.dex */
public class i implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f27952c = 15000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f27953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l f27954b;

    private i(l lVar, long j7) {
        this.f27954b = lVar;
        this.f27953a = j7;
    }

    public static void a(l lVar) {
        b(lVar, f27952c);
    }

    public static void b(l lVar, long j7) {
        m.execute(new i(lVar, j7));
    }

    public static void c(l lVar, long j7) {
        lVar.start();
        try {
            lVar.join(j7);
        } catch (InterruptedException e8) {
            e8.printStackTrace();
        }
        lVar.a(false);
        lVar.interrupt();
    }

    @Override // java.lang.Runnable
    public void run() {
        c(this.f27954b, this.f27953a);
    }
}
