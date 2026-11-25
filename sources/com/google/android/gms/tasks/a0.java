package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class a0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f16777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ b0 f16778b;

    a0(b0 b0Var, m mVar) {
        this.f16778b = b0Var;
        this.f16777a = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            m mVar = (m) this.f16778b.f16781b.a(this.f16777a);
            if (mVar == null) {
                this.f16778b.c(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = o.f16812b;
            mVar.l(executor, this.f16778b);
            mVar.i(executor, this.f16778b);
            mVar.c(executor, this.f16778b);
        } catch (k e8) {
            if (e8.getCause() instanceof Exception) {
                this.f16778b.f16782c.y((Exception) e8.getCause());
            } else {
                this.f16778b.f16782c.y(e8);
            }
        } catch (Exception e9) {
            this.f16778b.f16782c.y(e9);
        }
    }
}
