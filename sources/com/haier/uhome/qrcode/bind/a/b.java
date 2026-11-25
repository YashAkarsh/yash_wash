package com.haier.uhome.qrcode.bind.a;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.haier.uhome.qrcode.bind.api.g;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.lang3.time.DateUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f29548a = 500;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f29549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f29550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ExecutorService f29551d = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f29552e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Handler f29553f = new Handler(Looper.getMainLooper());

    public b(long j7, long j8) {
        this.f29549b = j7 + System.currentTimeMillis();
        this.f29550c = j8;
    }

    private void c(final g gVar, final T t7) {
        this.f29552e.set(false);
        this.f29553f.post(new Runnable() { // from class: com.haier.uhome.qrcode.bind.a.b.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                b.this.a(gVar, t7);
            }
        });
    }

    public void a() {
        if (this.f29552e.compareAndSet(false, true)) {
            a(this.f29549b - System.currentTimeMillis(), 0L);
        } else {
            Log.d("Retry", "duplicate start Retry task!!");
        }
    }

    public abstract void a(long j7);

    public abstract void a(g gVar, T t7);

    public void b() {
        synchronized (this.f29552e) {
            this.f29553f.removeCallbacksAndMessages(null);
            this.f29552e.set(false);
        }
    }

    public static long c() {
        return (Long.MAX_VALUE - System.currentTimeMillis()) - DateUtils.MILLIS_PER_MINUTE;
    }

    private void a(final long j7, long j8) {
        this.f29553f.postDelayed(new Runnable() { // from class: com.haier.uhome.qrcode.bind.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.a(j7);
            }
        }, j8);
    }

    public void b(g gVar, T t7) {
        if (this.f29552e.get()) {
            if ("00000".equals(gVar.a())) {
                c(gVar, t7);
                return;
            }
            long jCurrentTimeMillis = this.f29549b - System.currentTimeMillis();
            long j7 = f29548a;
            if (jCurrentTimeMillis < f29548a) {
                c(gVar, t7);
                return;
            }
            long j8 = this.f29550c;
            if (jCurrentTimeMillis >= j8) {
                j7 = j8;
            }
            a(jCurrentTimeMillis, j7);
        }
    }
}
