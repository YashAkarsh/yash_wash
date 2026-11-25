package okhttp3;

import a7.d;
import java.util.concurrent.TimeUnit;
import kotlin.i0;
import kotlin.jvm.internal.l0;
import okhttp3.internal.connection.h;

/* JADX INFO: loaded from: classes3.dex */
@i0(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rB!\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\f\u0010\u0013B\t\b\u0016¢\u0006\u0004\b\f\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005R\u001a\u0010\b\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lokhttp3/ConnectionPool;", "", "", "idleConnectionCount", "connectionCount", "Lkotlin/l2;", "evictAll", "Lokhttp3/internal/connection/h;", "delegate", "Lokhttp3/internal/connection/h;", "getDelegate$okhttp", "()Lokhttp3/internal/connection/h;", "<init>", "(Lokhttp3/internal/connection/h;)V", "maxIdleConnections", "", "keepAliveDuration", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "(IJLjava/util/concurrent/TimeUnit;)V", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class ConnectionPool {

    @d
    private final h delegate;

    public ConnectionPool(@d h delegate) {
        l0.p(delegate, "delegate");
        this.delegate = delegate;
    }

    public final int connectionCount() {
        return this.delegate.d();
    }

    public final void evictAll() {
        this.delegate.e();
    }

    @d
    public final h getDelegate$okhttp() {
        return this.delegate;
    }

    public final int idleConnectionCount() {
        return this.delegate.f();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConnectionPool(int i7, long j7, @d TimeUnit timeUnit) {
        this(new h(okhttp3.internal.concurrent.d.f37734h, i7, j7, timeUnit));
        l0.p(timeUnit, "timeUnit");
    }

    public ConnectionPool() {
        this(5, 5L, TimeUnit.MINUTES);
    }
}
