package com.haier.uhome.usdk.c;

import android.os.Looper;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Executor f31997a = new b();

    private static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Runnable f31998a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        b f31999b;

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f31998a.run();
            } finally {
                this.f31999b.a();
            }
        }

        private a(Runnable runnable, b bVar) {
            this.f31998a = runnable;
            this.f31999b = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(Runnable runnable) {
        f31997a.execute(runnable);
    }

    public void a(final Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.usdk.c.n
                @Override // java.lang.Runnable
                public final void run() {
                    e.b(runnable);
                }
            });
        } else {
            f31997a.execute(runnable);
        }
    }

    private static class b implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ArrayDeque<a> f32000a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        a f32001b;

        private b() {
            this.f32000a = new ArrayDeque<>();
        }

        synchronized void a() {
            a aVarPoll = this.f32000a.poll();
            this.f32001b = aVarPoll;
            if (aVarPoll != null) {
                com.haier.library.common.thread.m.execute(aVarPoll);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            if (a(runnable)) {
                return;
            }
            this.f32000a.offer(new a(runnable, this));
            if (this.f32001b == null) {
                a();
            }
        }

        boolean a(Runnable runnable) {
            Iterator<a> it = this.f32000a.iterator();
            while (it.hasNext()) {
                if (it.next().f31998a == runnable) {
                    return true;
                }
            }
            return false;
        }
    }
}
