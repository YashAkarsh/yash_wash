package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class b implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f15521a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BlockingQueue<IBinder> f15522b = new LinkedBlockingQueue();

    @c1.a
    @c.m0
    public IBinder a() throws InterruptedException {
        com.google.android.gms.common.internal.u.j("BlockingServiceConnection.getService() called on main thread");
        if (this.f15521a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f15521a = true;
        return this.f15522b.take();
    }

    @c1.a
    @c.m0
    public IBinder b(long j7, @c.m0 TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        com.google.android.gms.common.internal.u.j("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f15521a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f15521a = true;
        IBinder iBinderPoll = this.f15522b.poll(j7, timeUnit);
        if (iBinderPoll != null) {
            return iBinderPoll;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(@c.m0 ComponentName componentName, @c.m0 IBinder iBinder) {
        this.f15522b.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(@c.m0 ComponentName componentName) {
    }
}
