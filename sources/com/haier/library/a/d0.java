package com.haier.library.a;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class d0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d0 f26246d = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f26247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f26248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f26249c;

    static class a extends d0 {
        a() {
        }

        @Override // com.haier.library.a.d0
        public d0 a(long j7) {
            return this;
        }

        @Override // com.haier.library.a.d0
        public d0 b(long j7, TimeUnit timeUnit) {
            return this;
        }

        @Override // com.haier.library.a.d0
        public void j() throws IOException {
        }
    }

    public d0 a(long j7) {
        this.f26247a = true;
        this.f26248b = j7;
        return this;
    }

    public d0 b(long j7, TimeUnit timeUnit) {
        if (j7 >= 0) {
            if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            }
            this.f26249c = timeUnit.toNanos(j7);
            return this;
        }
        throw new IllegalArgumentException("timeout < 0: " + j7);
    }

    public final void c(Object obj) throws InterruptedIOException {
        try {
            boolean zE = e();
            long jH = h();
            long jNanoTime = 0;
            if (!zE && jH == 0) {
                obj.wait();
                return;
            }
            long jNanoTime2 = System.nanoTime();
            if (zE && jH != 0) {
                jH = Math.min(jH, g() - jNanoTime2);
            } else if (zE) {
                jH = g() - jNanoTime2;
            }
            if (jH > 0) {
                long j7 = jH / 1000000;
                Long.signum(j7);
                obj.wait(j7, (int) (jH - (1000000 * j7)));
                jNanoTime = System.nanoTime() - jNanoTime2;
            }
            if (jNanoTime >= jH) {
                throw new InterruptedIOException(com.alipay.sdk.data.a.f13674p);
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public final d0 d(long j7, TimeUnit timeUnit) {
        if (j7 > 0) {
            if (timeUnit != null) {
                return a(System.nanoTime() + timeUnit.toNanos(j7));
            }
            throw new IllegalArgumentException("unit == null");
        }
        throw new IllegalArgumentException("duration <= 0: " + j7);
    }

    public boolean e() {
        return this.f26247a;
    }

    public d0 f() {
        this.f26249c = 0L;
        return this;
    }

    public long g() {
        if (this.f26247a) {
            return this.f26248b;
        }
        throw new IllegalStateException("No deadline");
    }

    public long h() {
        return this.f26249c;
    }

    public d0 i() {
        this.f26247a = false;
        return this;
    }

    public void j() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.f26247a && this.f26248b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
