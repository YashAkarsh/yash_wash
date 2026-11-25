package com.haier.globalwasher.mvp_api.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class e implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f24828a;

    class a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Handler f24829a;

        a(Handler handler) {
            this.f24829a = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f24829a.post(runnable);
        }
    }

    private class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final n f24831a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final p f24832b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Runnable f24833c;

        public b(n nVar, p pVar, Runnable runnable) {
            this.f24831a = nVar;
            this.f24832b = pVar;
            this.f24833c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f24831a.H()) {
                this.f24831a.j("canceled-at-delivery");
                return;
            }
            if (this.f24832b.b()) {
                this.f24831a.g(this.f24832b.f24943a);
            } else {
                this.f24831a.f(this.f24832b.f24945c);
            }
            if (this.f24832b.f24946d) {
                this.f24831a.b("intermediate-response");
            } else {
                this.f24831a.j("done");
            }
            Runnable runnable = this.f24833c;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public e(Handler handler) {
        this.f24828a = new a(handler);
    }

    @Override // com.haier.globalwasher.mvp_api.volley.q
    public void a(n<?> nVar, p<?> pVar, Runnable runnable) {
        nVar.I();
        nVar.b("post-response");
        this.f24828a.execute(new b(nVar, pVar, runnable));
    }

    @Override // com.haier.globalwasher.mvp_api.volley.q
    public void b(n<?> nVar, p<?> pVar) {
        a(nVar, pVar, null);
    }

    @Override // com.haier.globalwasher.mvp_api.volley.q
    public void c(n<?> nVar, u uVar) {
        nVar.b("post-error");
        this.f24828a.execute(new b(nVar, p.a(uVar), null));
    }

    public e(Executor executor) {
        this.f24828a = executor;
    }
}
