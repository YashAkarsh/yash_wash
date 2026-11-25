package androidx.core.provider;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import c.g1;
import c.x0;
import c.z;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
@Deprecated
public class l {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f6193i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f6194j = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @z("mLock")
    private HandlerThread f6196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @z("mLock")
    private Handler f6197c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f6200f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f6201g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f6202h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f6195a = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler.Callback f6199e = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @z("mLock")
    private int f6198d = 0;

    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i7 = message.what;
            if (i7 == 0) {
                l.this.c();
                return true;
            }
            if (i7 != 1) {
                return true;
            }
            l.this.d((Runnable) message.obj);
            return true;
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Callable f6204a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Handler f6205b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f6206c;

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Object f6208a;

            a(Object obj) {
                this.f6208a = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f6206c.a(this.f6208a);
            }
        }

        b(Callable callable, Handler handler, d dVar) {
            this.f6204a = callable;
            this.f6205b = handler;
            this.f6206c = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object objCall;
            try {
                objCall = this.f6204a.call();
            } catch (Exception unused) {
                objCall = null;
            }
            this.f6205b.post(new a(objCall));
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicReference f6210a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Callable f6211b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ReentrantLock f6212c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f6213d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Condition f6214e;

        c(AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
            this.f6210a = atomicReference;
            this.f6211b = callable;
            this.f6212c = reentrantLock;
            this.f6213d = atomicBoolean;
            this.f6214e = condition;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f6210a.set(this.f6211b.call());
            } catch (Exception unused) {
            }
            this.f6212c.lock();
            try {
                this.f6213d.set(false);
                this.f6214e.signal();
            } finally {
                this.f6212c.unlock();
            }
        }
    }

    public interface d<T> {
        void a(T t7);
    }

    public l(String str, int i7, int i8) {
        this.f6202h = str;
        this.f6201g = i7;
        this.f6200f = i8;
    }

    private void e(Runnable runnable) {
        synchronized (this.f6195a) {
            if (this.f6196b == null) {
                HandlerThread handlerThread = new HandlerThread(this.f6202h, this.f6201g);
                this.f6196b = handlerThread;
                handlerThread.start();
                this.f6197c = new Handler(this.f6196b.getLooper(), this.f6199e);
                this.f6198d++;
            }
            this.f6197c.removeMessages(0);
            Handler handler = this.f6197c;
            handler.sendMessage(handler.obtainMessage(1, runnable));
        }
    }

    @g1
    public int a() {
        int i7;
        synchronized (this.f6195a) {
            i7 = this.f6198d;
        }
        return i7;
    }

    @g1
    public boolean b() {
        boolean z7;
        synchronized (this.f6195a) {
            z7 = this.f6196b != null;
        }
        return z7;
    }

    void c() {
        synchronized (this.f6195a) {
            if (this.f6197c.hasMessages(1)) {
                return;
            }
            this.f6196b.quit();
            this.f6196b = null;
            this.f6197c = null;
        }
    }

    void d(Runnable runnable) {
        runnable.run();
        synchronized (this.f6195a) {
            this.f6197c.removeMessages(0);
            Handler handler = this.f6197c;
            handler.sendMessageDelayed(handler.obtainMessage(0), this.f6200f);
        }
    }

    public <T> void f(Callable<T> callable, d<T> dVar) {
        e(new b(callable, androidx.core.provider.b.a(), dVar));
    }

    public <T> T g(Callable<T> callable, int i7) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition conditionNewCondition = reentrantLock.newCondition();
        AtomicReference atomicReference = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        e(new c(atomicReference, callable, reentrantLock, atomicBoolean, conditionNewCondition));
        reentrantLock.lock();
        try {
            if (!atomicBoolean.get()) {
                T t7 = (T) atomicReference.get();
                reentrantLock.unlock();
                return t7;
            }
            long nanos = TimeUnit.MILLISECONDS.toNanos(i7);
            do {
                try {
                    nanos = conditionNewCondition.awaitNanos(nanos);
                } catch (InterruptedException unused) {
                }
                if (!atomicBoolean.get()) {
                    T t8 = (T) atomicReference.get();
                    reentrantLock.unlock();
                    return t8;
                }
            } while (nanos > 0);
            throw new InterruptedException(com.alipay.sdk.data.a.f13674p);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
