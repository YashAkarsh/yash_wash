package org.junit.experimental;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.runner.l;
import org.junit.runners.f;
import org.junit.runners.model.e;
import org.junit.runners.model.h;
import org.junit.runners.model.i;

/* JADX INFO: loaded from: classes3.dex */
public class a extends org.junit.runner.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f39764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f39765b;

    /* JADX INFO: renamed from: org.junit.experimental.a$a, reason: collision with other inner class name */
    static class C0528a implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ExecutorService f39766a = Executors.newCachedThreadPool();

        C0528a() {
        }

        @Override // org.junit.runners.model.i
        public void a(Runnable runnable) {
            this.f39766a.submit(runnable);
        }

        @Override // org.junit.runners.model.i
        public void b() {
            try {
                this.f39766a.shutdown();
                this.f39766a.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            } catch (InterruptedException e8) {
                e8.printStackTrace(System.err);
            }
        }
    }

    public a(boolean z7, boolean z8) {
        this.f39764a = z7;
        this.f39765b = z8;
    }

    public static org.junit.runner.a d() {
        return new a(true, false);
    }

    public static org.junit.runner.a e() {
        return new a(false, true);
    }

    private static l f(l lVar) {
        if (lVar instanceof f) {
            ((f) lVar).y(new C0528a());
        }
        return lVar;
    }

    @Override // org.junit.runner.a
    protected l a(h hVar, Class<?> cls) throws Throwable {
        l lVarA = super.a(hVar, cls);
        return this.f39765b ? f(lVarA) : lVarA;
    }

    @Override // org.junit.runner.a
    public l b(h hVar, Class<?>[] clsArr) throws e {
        l lVarB = super.b(hVar, clsArr);
        return this.f39764a ? f(lVarB) : lVarB;
    }
}
