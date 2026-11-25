package com.google.common.util.concurrent;

import com.google.common.collect.wd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
final class o1<L> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Logger f22867b = Logger.getLogger(o1.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<b<L>> f22868a = Collections.synchronizedList(new ArrayList());

    interface a<L> {
        void a(L l7);
    }

    private static final class b<L> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final L f22869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Executor f22870b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @v1.a("this")
        final Queue<a<L>> f22871c = wd.d();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @v1.a("this")
        final Queue<Object> f22872d = wd.d();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @v1.a("this")
        boolean f22873e;

        b(L l7, Executor executor) {
            this.f22869a = (L) com.google.common.base.e0.E(l7);
            this.f22870b = (Executor) com.google.common.base.e0.E(executor);
        }

        synchronized void a(a<L> aVar, Object obj) {
            this.f22871c.add(aVar);
            this.f22872d.add(obj);
        }

        void b() {
            boolean z7;
            synchronized (this) {
                if (this.f22873e) {
                    z7 = false;
                } else {
                    z7 = true;
                    this.f22873e = true;
                }
            }
            if (z7) {
                try {
                    this.f22870b.execute(this);
                } catch (RuntimeException e8) {
                    synchronized (this) {
                        this.f22873e = false;
                        o1.f22867b.log(Level.SEVERE, "Exception while running callbacks for " + this.f22869a + " on " + this.f22870b, (Throwable) e8);
                        throw e8;
                    }
                }
            }
        }

        /* JADX WARN: Bottom block not found for handler: all -> 0x0057 */
        /* JADX WARN: Code duplicated, block: B:27:0x005c  */
        /* JADX WARN: Code duplicated, block: B:37:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
        
            r2.a(r9.f22869a);
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
        
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
        
            com.google.common.util.concurrent.o1.f22867b.log(java.util.logging.Level.SEVERE, "Exception while executing callback: " + r9.f22869a + " " + r3, (java.lang.Throwable) r2);
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() throws java.lang.Throwable {
            /*
                r9 = this;
            L0:
                r0 = 0
                r1 = 1
                monitor-enter(r9)     // Catch: java.lang.Throwable -> L59
                boolean r2 = r9.f22873e     // Catch: java.lang.Throwable -> L4c
                com.google.common.base.e0.g0(r2)     // Catch: java.lang.Throwable -> L4c
                java.util.Queue<com.google.common.util.concurrent.o1$a<L>> r2 = r9.f22871c     // Catch: java.lang.Throwable -> L4c
                java.lang.Object r2 = r2.poll()     // Catch: java.lang.Throwable -> L4c
                com.google.common.util.concurrent.o1$a r2 = (com.google.common.util.concurrent.o1.a) r2     // Catch: java.lang.Throwable -> L4c
                java.util.Queue<java.lang.Object> r3 = r9.f22872d     // Catch: java.lang.Throwable -> L4c
                java.lang.Object r3 = r3.poll()     // Catch: java.lang.Throwable -> L4c
                if (r2 != 0) goto L1f
                r9.f22873e = r0     // Catch: java.lang.Throwable -> L4c
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L1c
                return
            L1c:
                r1 = move-exception
                r2 = r0
                goto L50
            L1f:
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L4c
                L r4 = r9.f22869a     // Catch: java.lang.RuntimeException -> L26 java.lang.Throwable -> L59
                r2.a(r4)     // Catch: java.lang.RuntimeException -> L26 java.lang.Throwable -> L59
                goto L0
            L26:
                r2 = move-exception
                java.util.logging.Logger r4 = com.google.common.util.concurrent.o1.a()     // Catch: java.lang.Throwable -> L59
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L59
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L59
                r6.<init>()     // Catch: java.lang.Throwable -> L59
                java.lang.String r7 = "Exception while executing callback: "
                r6.append(r7)     // Catch: java.lang.Throwable -> L59
                L r7 = r9.f22869a     // Catch: java.lang.Throwable -> L59
                r6.append(r7)     // Catch: java.lang.Throwable -> L59
                java.lang.String r7 = " "
                r6.append(r7)     // Catch: java.lang.Throwable -> L59
                r6.append(r3)     // Catch: java.lang.Throwable -> L59
                java.lang.String r3 = r6.toString()     // Catch: java.lang.Throwable -> L59
                r4.log(r5, r3, r2)     // Catch: java.lang.Throwable -> L59
                goto L0
            L4c:
                r2 = move-exception
                r8 = r2
                r2 = r1
                r1 = r8
            L50:
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L57
                throw r1     // Catch: java.lang.Throwable -> L52
            L52:
                r1 = move-exception
                r8 = r2
                r2 = r1
                r1 = r8
                goto L5a
            L57:
                r1 = move-exception
                goto L50
            L59:
                r2 = move-exception
            L5a:
                if (r1 == 0) goto L64
                monitor-enter(r9)
                r9.f22873e = r0     // Catch: java.lang.Throwable -> L61
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L61
                goto L64
            L61:
                r0 = move-exception
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L61
                throw r0
            L64:
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.o1.b.run():void");
        }
    }

    o1() {
    }

    private void f(a<L> aVar, Object obj) {
        com.google.common.base.e0.F(aVar, androidx.core.app.l2.f5216t0);
        com.google.common.base.e0.F(obj, "label");
        synchronized (this.f22868a) {
            Iterator<b<L>> it = this.f22868a.iterator();
            while (it.hasNext()) {
                it.next().a(aVar, obj);
            }
        }
    }

    public void b(L l7, Executor executor) {
        com.google.common.base.e0.F(l7, com.google.android.gms.common.internal.x.a.f15818a);
        com.google.common.base.e0.F(executor, "executor");
        this.f22868a.add(new b<>(l7, executor));
    }

    public void c() {
        for (int i7 = 0; i7 < this.f22868a.size(); i7++) {
            this.f22868a.get(i7).b();
        }
    }

    public void d(a<L> aVar) {
        f(aVar, aVar);
    }

    public void e(a<L> aVar, String str) {
        f(aVar, str);
    }
}
