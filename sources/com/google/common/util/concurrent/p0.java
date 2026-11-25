package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
public final class p0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Logger f22877c = Logger.getLogger(p0.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @v1.a("this")
    private a f22878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @v1.a("this")
    private boolean f22879b;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Runnable f22880a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Executor f22881b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        a f22882c;

        a(Runnable runnable, Executor executor, a aVar) {
            this.f22880a = runnable;
            this.f22881b = executor;
            this.f22882c = aVar;
        }
    }

    private static void c(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e8) {
            f22877c.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e8);
        }
    }

    public void a(Runnable runnable, Executor executor) {
        com.google.common.base.e0.F(runnable, "Runnable was null.");
        com.google.common.base.e0.F(executor, "Executor was null.");
        synchronized (this) {
            if (this.f22879b) {
                c(runnable, executor);
            } else {
                this.f22878a = new a(runnable, executor, this.f22878a);
            }
        }
    }

    public void b() {
        synchronized (this) {
            if (this.f22879b) {
                return;
            }
            this.f22879b = true;
            a aVar = this.f22878a;
            a aVar2 = null;
            this.f22878a = null;
            while (aVar != null) {
                a aVar3 = aVar.f22882c;
                aVar.f22882c = aVar2;
                aVar2 = aVar;
                aVar = aVar3;
            }
            while (aVar2 != null) {
                c(aVar2.f22880a, aVar2.f22881b);
                aVar2 = aVar2.f22882c;
            }
        }
    }
}
