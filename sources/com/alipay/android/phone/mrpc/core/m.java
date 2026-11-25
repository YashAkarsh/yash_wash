package com.alipay.android.phone.mrpc.core;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
final class m extends FutureTask<u> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ q f13455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ l f13456b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    m(l lVar, Callable callable, q qVar) {
        super(callable);
        this.f13456b = lVar;
        this.f13455a = qVar;
    }

    @Override // java.util.concurrent.FutureTask
    protected final void done() {
        o oVarA = this.f13455a.a();
        if (oVarA.f() == null) {
            super.done();
            return;
        }
        try {
            get();
            if (isCancelled() || oVarA.h()) {
                oVarA.g();
                if (isCancelled() && isDone()) {
                    return;
                }
                cancel(false);
            }
        } catch (InterruptedException e8) {
            e8.toString();
        } catch (CancellationException unused) {
            oVarA.g();
        } catch (ExecutionException e9) {
            if (e9.getCause() == null || !(e9.getCause() instanceof HttpException)) {
                e9.toString();
                return;
            }
            HttpException httpException = (HttpException) e9.getCause();
            httpException.getCode();
            httpException.getMsg();
        } catch (Throwable th) {
            throw new RuntimeException("An error occured while executing http request", th);
        }
    }
}
