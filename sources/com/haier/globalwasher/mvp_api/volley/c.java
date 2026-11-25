package com.haier.globalwasher.mvp_api.volley;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
public class c extends Thread {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final boolean f24813f = v.f25046b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BlockingQueue<n<?>> f24814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BlockingQueue<n<?>> f24815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f24816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final q f24817d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f24818e = false;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n f24819a;

        a(n nVar) {
            this.f24819a = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                c.this.f24815b.put(this.f24819a);
            } catch (InterruptedException unused) {
            }
        }
    }

    public c(BlockingQueue<n<?>> blockingQueue, BlockingQueue<n<?>> blockingQueue2, b bVar, q qVar) {
        this.f24814a = blockingQueue;
        this.f24815b = blockingQueue2;
        this.f24816c = bVar;
        this.f24817d = qVar;
    }

    public void b() {
        this.f24818e = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (f24813f) {
            v.f("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f24816c.a();
        while (true) {
            try {
                n<?> nVarTake = this.f24814a.take();
                try {
                    nVarTake.b("cache-queue-take");
                    if (nVarTake.H()) {
                        nVarTake.j("cache-discard-canceled");
                    } else {
                        b.a aVarC = this.f24816c.c(nVarTake.n());
                        if (aVarC == null) {
                            nVarTake.b("cache-miss");
                            this.f24815b.put(nVarTake);
                        } else if (aVarC.a()) {
                            nVarTake.b("cache-hit-expired");
                            nVarTake.M(aVarC);
                            this.f24815b.put(nVarTake);
                        } else {
                            nVarTake.b("cache-hit");
                            p<?> pVarL = nVarTake.L(new j(aVarC.f24806a, aVarC.f24812g));
                            nVarTake.b("cache-hit-parsed");
                            if (aVarC.b()) {
                                nVarTake.b("cache-hit-refresh-needed");
                                nVarTake.M(aVarC);
                                pVarL.f24946d = true;
                                this.f24817d.a(nVarTake, pVarL, new a(nVarTake));
                            } else {
                                this.f24817d.b(nVarTake, pVarL);
                            }
                        }
                    }
                } catch (Exception e8) {
                    v.d(e8, "Unhandled exception %s", e8.toString());
                }
            } catch (InterruptedException unused) {
                if (this.f24818e) {
                    return;
                }
            }
        }
    }
}
