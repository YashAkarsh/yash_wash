package com.haier.globalwasher.mvp_api.volley;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
public class h extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BlockingQueue<n<?>> f24836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f24837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f24838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final q f24839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f24840e = false;

    public h(BlockingQueue<n<?>> blockingQueue, g gVar, b bVar, q qVar) {
        this.f24836a = blockingQueue;
        this.f24837b = gVar;
        this.f24838c = bVar;
        this.f24839d = qVar;
    }

    @TargetApi(14)
    private void a(n<?> nVar) {
        TrafficStats.setThreadStatsTag(nVar.E());
    }

    private void b(n<?> nVar, u uVar) {
        this.f24839d.c(nVar, nVar.K(uVar));
    }

    public void c() {
        this.f24840e = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            try {
                n<?> nVarTake = this.f24836a.take();
                try {
                    nVarTake.b("network-queue-take");
                    if (nVarTake.H()) {
                        nVarTake.j("network-discard-cancelled");
                    } else {
                        a(nVarTake);
                        j jVarA = this.f24837b.a(nVarTake);
                        nVarTake.b("network-http-complete");
                        if (jVarA.f24845d && nVarTake.G()) {
                            nVarTake.j("not-modified");
                        } else {
                            p<?> pVarL = nVarTake.L(jVarA);
                            nVarTake.b("network-parse-complete");
                            if (nVarTake.T() && pVarL.f24944b != null) {
                                this.f24838c.b(nVarTake.n(), pVarL.f24944b);
                                nVarTake.b("network-cache-written");
                            }
                            nVarTake.I();
                            this.f24839d.b(nVarTake, pVarL);
                        }
                    }
                } catch (u e8) {
                    e8.b(SystemClock.elapsedRealtime() - jElapsedRealtime);
                    b(nVarTake, e8);
                } catch (Exception e9) {
                    v.d(e9, "Unhandled exception %s", e9.toString());
                    u uVar = new u(e9);
                    uVar.b(SystemClock.elapsedRealtime() - jElapsedRealtime);
                    this.f24839d.c(nVarTake, uVar);
                }
            } catch (InterruptedException unused) {
                if (this.f24840e) {
                    return;
                }
            }
        }
    }
}
