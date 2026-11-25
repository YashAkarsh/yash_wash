package f3;

import android.os.Looper;
import com.haier.library.common.thread.b;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public class a<E> implements b<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicReference<E> f33902a = new AtomicReference<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CountDownLatch f33903b = new CountDownLatch(1);

    private a() {
    }

    public static <R> b<R> c() {
        return new a();
    }

    @Override // com.haier.library.common.thread.b
    public void a(E e8) {
        if (com.facebook.internal.a.a(this.f33902a, null, e8)) {
            this.f33903b.countDown();
        }
    }

    @Override // com.haier.library.common.thread.b
    public E b(Runnable runnable, E e8, long j7) {
        return a(runnable, e8, j7, TimeUnit.SECONDS);
    }

    @Override // com.haier.library.common.thread.b
    public E a() {
        return this.f33902a.get();
    }

    @Override // com.haier.library.common.thread.b
    public E a(Runnable runnable, E e8, long j7, TimeUnit timeUnit) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            throw new IllegalThreadStateException("Actuator call run LinearActuator on main thread!");
        }
        if (runnable == null) {
            throw new IllegalArgumentException("Actuator runnable can not be null!");
        }
        if (j7 >= 0) {
            runnable.run();
            try {
                if (!this.f33903b.await(j7, timeUnit)) {
                    com.facebook.internal.a.a(this.f33902a, null, e8);
                }
            } catch (InterruptedException e9) {
                e3.a.g("LinearActuator2 thread interrupted", e9);
                Thread.currentThread().interrupt();
            }
            return a();
        }
        throw new IllegalArgumentException("Actuator timeout illegal");
    }
}
