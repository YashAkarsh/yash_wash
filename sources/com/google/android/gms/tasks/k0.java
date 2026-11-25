package com.google.android.gms.tasks;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class k0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f16802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ l0 f16803b;

    k0(l0 l0Var, m mVar) {
        this.f16803b = l0Var;
        this.f16802a = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            m mVarA = this.f16803b.f16805b.a(this.f16802a.r());
            if (mVarA == null) {
                this.f16803b.c(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = o.f16812b;
            mVarA.l(executor, this.f16803b);
            mVarA.i(executor, this.f16803b);
            mVarA.c(executor, this.f16803b);
        } catch (k e8) {
            if (e8.getCause() instanceof Exception) {
                this.f16803b.c((Exception) e8.getCause());
            } else {
                this.f16803b.c(e8);
            }
        } catch (CancellationException unused) {
            this.f16803b.a();
        } catch (Exception e9) {
            this.f16803b.c(e9);
        }
    }
}
