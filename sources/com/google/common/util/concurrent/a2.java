package com.google.common.util.concurrent;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
final class a2 implements Executor {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Logger f22533f = Logger.getLogger(a2.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f22534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @v1.a("queue")
    private final Deque<Runnable> f22535b = new ArrayDeque();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @v1.a("queue")
    private c f22536c = c.IDLE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @v1.a("queue")
    private long f22537d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f22538e = new b(this, null);

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f22539a;

        a(Runnable runnable) {
            this.f22539a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f22539a.run();
        }
    }

    private final class b implements Runnable {
        private b() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0041, code lost:
        
            if (r1 == false) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0043, code lost:
        
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0050, code lost:
        
            r1 = r1 | java.lang.Thread.interrupted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0051, code lost:
        
            r3.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0055, code lost:
        
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0056, code lost:
        
            com.google.common.util.concurrent.a2.f22533f.log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + r3, (java.lang.Throwable) r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void a() {
            /*
                r8 = this;
                r0 = 0
                r1 = r0
            L2:
                com.google.common.util.concurrent.a2 r2 = com.google.common.util.concurrent.a2.this     // Catch: java.lang.Throwable -> L74
                java.util.Deque r2 = com.google.common.util.concurrent.a2.a(r2)     // Catch: java.lang.Throwable -> L74
                monitor-enter(r2)     // Catch: java.lang.Throwable -> L74
                if (r0 != 0) goto L2b
                com.google.common.util.concurrent.a2 r0 = com.google.common.util.concurrent.a2.this     // Catch: java.lang.Throwable -> L71
                com.google.common.util.concurrent.a2$c r0 = com.google.common.util.concurrent.a2.b(r0)     // Catch: java.lang.Throwable -> L71
                com.google.common.util.concurrent.a2$c r3 = com.google.common.util.concurrent.a2.c.RUNNING     // Catch: java.lang.Throwable -> L71
                if (r0 != r3) goto L20
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L71
                if (r1 == 0) goto L1f
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L1f:
                return
            L20:
                com.google.common.util.concurrent.a2 r0 = com.google.common.util.concurrent.a2.this     // Catch: java.lang.Throwable -> L71
                com.google.common.util.concurrent.a2.d(r0)     // Catch: java.lang.Throwable -> L71
                com.google.common.util.concurrent.a2 r0 = com.google.common.util.concurrent.a2.this     // Catch: java.lang.Throwable -> L71
                com.google.common.util.concurrent.a2.c(r0, r3)     // Catch: java.lang.Throwable -> L71
                r0 = 1
            L2b:
                com.google.common.util.concurrent.a2 r3 = com.google.common.util.concurrent.a2.this     // Catch: java.lang.Throwable -> L71
                java.util.Deque r3 = com.google.common.util.concurrent.a2.a(r3)     // Catch: java.lang.Throwable -> L71
                java.lang.Object r3 = r3.poll()     // Catch: java.lang.Throwable -> L71
                java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch: java.lang.Throwable -> L71
                if (r3 != 0) goto L4b
                com.google.common.util.concurrent.a2 r0 = com.google.common.util.concurrent.a2.this     // Catch: java.lang.Throwable -> L71
                com.google.common.util.concurrent.a2$c r3 = com.google.common.util.concurrent.a2.c.IDLE     // Catch: java.lang.Throwable -> L71
                com.google.common.util.concurrent.a2.c(r0, r3)     // Catch: java.lang.Throwable -> L71
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L71
                if (r1 == 0) goto L4a
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L4a:
                return
            L4b:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L71
                boolean r2 = java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L74
                r1 = r1 | r2
                r3.run()     // Catch: java.lang.RuntimeException -> L55 java.lang.Throwable -> L74
                goto L2
            L55:
                r2 = move-exception
                java.util.logging.Logger r4 = com.google.common.util.concurrent.a2.e()     // Catch: java.lang.Throwable -> L74
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L74
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L74
                r6.<init>()     // Catch: java.lang.Throwable -> L74
                java.lang.String r7 = "Exception while executing runnable "
                r6.append(r7)     // Catch: java.lang.Throwable -> L74
                r6.append(r3)     // Catch: java.lang.Throwable -> L74
                java.lang.String r3 = r6.toString()     // Catch: java.lang.Throwable -> L74
                r4.log(r5, r3, r2)     // Catch: java.lang.Throwable -> L74
                goto L2
            L71:
                r0 = move-exception
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L71
                throw r0     // Catch: java.lang.Throwable -> L74
            L74:
                r0 = move-exception
                if (r1 == 0) goto L7e
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                r1.interrupt()
            L7e:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.a2.b.a():void");
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a();
            } catch (Error e8) {
                synchronized (a2.this.f22535b) {
                    a2.this.f22536c = c.IDLE;
                    throw e8;
                }
            }
        }

        /* synthetic */ b(a2 a2Var, a aVar) {
            this();
        }
    }

    enum c {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    a2(Executor executor) {
        this.f22534a = (Executor) com.google.common.base.e0.E(executor);
    }

    static /* synthetic */ long d(a2 a2Var) {
        long j7 = a2Var.f22537d;
        a2Var.f22537d = 1 + j7;
        return j7;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        c cVar;
        com.google.common.base.e0.E(runnable);
        synchronized (this.f22535b) {
            c cVar2 = this.f22536c;
            if (cVar2 != c.RUNNING && cVar2 != (cVar = c.QUEUED)) {
                long j7 = this.f22537d;
                a aVar = new a(runnable);
                this.f22535b.add(aVar);
                c cVar3 = c.QUEUING;
                this.f22536c = cVar3;
                boolean z7 = true;
                try {
                    this.f22534a.execute(this.f22538e);
                    if (this.f22536c != cVar3) {
                        return;
                    }
                    synchronized (this.f22535b) {
                        if (this.f22537d == j7 && this.f22536c == cVar3) {
                            this.f22536c = cVar;
                        }
                    }
                    return;
                } catch (Error | RuntimeException e8) {
                    synchronized (this.f22535b) {
                        c cVar4 = this.f22536c;
                        if ((cVar4 != c.IDLE && cVar4 != c.QUEUING) || !this.f22535b.removeLastOccurrence(aVar)) {
                            z7 = false;
                        }
                        if (!(e8 instanceof RejectedExecutionException) || z7) {
                            throw e8;
                        }
                    }
                    return;
                }
            }
            this.f22535b.add(runnable);
        }
    }
}
