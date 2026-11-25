package com.google.common.util.concurrent;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
final class k2<V> extends s0.a<V> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private l1<V> f22809i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ScheduledFuture<?> f22810j;

    private static final class b<V> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        k2<V> f22811a;

        b(k2<V> k2Var) {
            this.f22811a = k2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            l1<? extends V> l1Var;
            k2<V> k2Var = this.f22811a;
            if (k2Var == null || (l1Var = ((k2) k2Var).f22809i) == null) {
                return;
            }
            this.f22811a = null;
            if (l1Var.isDone()) {
                k2Var.C(l1Var);
                return;
            }
            try {
                ScheduledFuture scheduledFuture = ((k2) k2Var).f22810j;
                String str = "Timed out";
                if (scheduledFuture != null) {
                    long jAbs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                    if (jAbs > 10) {
                        str = "Timed out (timeout delayed by " + jAbs + " ms after scheduled time)";
                    }
                }
                ((k2) k2Var).f22810j = null;
                k2Var.B(new c(str + ": " + l1Var));
            } finally {
                l1Var.cancel(true);
            }
        }
    }

    private static final class c extends TimeoutException {
        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            setStackTrace(new StackTraceElement[0]);
            return this;
        }

        private c(String str) {
            super(str);
        }
    }

    private k2(l1<V> l1Var) {
        this.f22809i = (l1) com.google.common.base.e0.E(l1Var);
    }

    static <V> l1<V> R(l1<V> l1Var, long j7, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        k2 k2Var = new k2(l1Var);
        b bVar = new b(k2Var);
        k2Var.f22810j = scheduledExecutorService.schedule(bVar, j7, timeUnit);
        l1Var.I(bVar, v1.c());
        return k2Var;
    }

    @Override // com.google.common.util.concurrent.d
    protected void m() {
        v(this.f22809i);
        ScheduledFuture<?> scheduledFuture = this.f22810j;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f22809i = null;
        this.f22810j = null;
    }

    @Override // com.google.common.util.concurrent.d
    protected String x() {
        l1<V> l1Var = this.f22809i;
        ScheduledFuture<?> scheduledFuture = this.f22810j;
        if (l1Var == null) {
            return null;
        }
        String str = "inputFuture=[" + l1Var + "]";
        if (scheduledFuture == null) {
            return str;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return str;
        }
        return str + ", remaining delay=[" + delay + " ms]";
    }
}
