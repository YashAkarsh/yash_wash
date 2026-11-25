package androidx.concurrent.futures;

import c.m0;
import c.o0;
import com.google.common.util.concurrent.l1;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f2356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        d<T> f2357b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private e<Void> f2358c = e.u();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f2359d;

        a() {
        }

        private void e() {
            this.f2356a = null;
            this.f2357b = null;
            this.f2358c = null;
        }

        public void a(@m0 Runnable runnable, @m0 Executor executor) {
            e<Void> eVar = this.f2358c;
            if (eVar != null) {
                eVar.I(runnable, executor);
            }
        }

        void b() {
            this.f2356a = null;
            this.f2357b = null;
            this.f2358c.p(null);
        }

        public boolean c(T t7) {
            this.f2359d = true;
            d<T> dVar = this.f2357b;
            boolean z7 = dVar != null && dVar.b(t7);
            if (z7) {
                e();
            }
            return z7;
        }

        public boolean d() {
            this.f2359d = true;
            d<T> dVar = this.f2357b;
            boolean z7 = dVar != null && dVar.a(true);
            if (z7) {
                e();
            }
            return z7;
        }

        public boolean f(@m0 Throwable th) {
            this.f2359d = true;
            d<T> dVar = this.f2357b;
            boolean z7 = dVar != null && dVar.c(th);
            if (z7) {
                e();
            }
            return z7;
        }

        protected void finalize() {
            e<Void> eVar;
            d<T> dVar = this.f2357b;
            if (dVar != null && !dVar.isDone()) {
                dVar.c(new b("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f2356a));
            }
            if (this.f2359d || (eVar = this.f2358c) == null) {
                return;
            }
            eVar.p(null);
        }
    }

    static final class b extends Throwable {
        b(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    /* JADX INFO: renamed from: androidx.concurrent.futures.c$c, reason: collision with other inner class name */
    public interface InterfaceC0036c<T> {
        @o0
        Object a(@m0 a<T> aVar) throws Exception;
    }

    private static final class d<T> implements l1<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final WeakReference<a<T>> f2360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final androidx.concurrent.futures.a<T> f2361b = new a();

        class a extends androidx.concurrent.futures.a<T> {
            a() {
            }

            @Override // androidx.concurrent.futures.a
            protected String m() {
                a<T> aVar = d.this.f2360a.get();
                if (aVar == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                return "tag=[" + aVar.f2356a + "]";
            }
        }

        d(a<T> aVar) {
            this.f2360a = new WeakReference<>(aVar);
        }

        @Override // com.google.common.util.concurrent.l1
        public void I(@m0 Runnable runnable, @m0 Executor executor) {
            this.f2361b.I(runnable, executor);
        }

        boolean a(boolean z7) {
            return this.f2361b.cancel(z7);
        }

        boolean b(T t7) {
            return this.f2361b.p(t7);
        }

        boolean c(Throwable th) {
            return this.f2361b.q(th);
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z7) {
            a<T> aVar = this.f2360a.get();
            boolean zCancel = this.f2361b.cancel(z7);
            if (zCancel && aVar != null) {
                aVar.b();
            }
            return zCancel;
        }

        @Override // java.util.concurrent.Future
        public T get() throws ExecutionException, InterruptedException {
            return this.f2361b.get();
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.f2361b.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.f2361b.isDone();
        }

        public String toString() {
            return this.f2361b.toString();
        }

        @Override // java.util.concurrent.Future
        public T get(long j7, @m0 TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            return this.f2361b.get(j7, timeUnit);
        }
    }

    private c() {
    }

    @m0
    public static <T> l1<T> a(@m0 InterfaceC0036c<T> interfaceC0036c) {
        a<T> aVar = new a<>();
        d<T> dVar = new d<>(aVar);
        aVar.f2357b = dVar;
        aVar.f2356a = interfaceC0036c.getClass();
        try {
            Object objA = interfaceC0036c.a(aVar);
            if (objA != null) {
                aVar.f2356a = objA;
            }
        } catch (Exception e8) {
            dVar.c(e8);
        }
        return dVar;
    }
}
