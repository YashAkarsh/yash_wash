package androidx.test.rule;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import androidx.test.annotation.Beta;
import androidx.test.internal.util.Checks;
import androidx.test.platform.app.InstrumentationRegistry;
import c.g1;
import c.m0;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.rules.l;
import org.junit.runner.c;
import org.junit.runners.model.j;

/* JADX INFO: loaded from: classes.dex */
@Beta
public class ServiceTestRule implements l {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f10367h = "ServiceTestRule";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final long f10368i = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBinder f10369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Intent f10370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ServiceConnection f10371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f10372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TimeUnit f10373e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f10374f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f10375g;

    class ProxyServiceConnection implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ServiceConnection f10376a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CountDownLatch f10377b;

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            ServiceTestRule.this.f10369a = service;
            ServiceConnection serviceConnection = this.f10376a;
            if (serviceConnection != null) {
                serviceConnection.onServiceConnected(name, service);
            }
            this.f10377b.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            Log.e(ServiceTestRule.f10367h, "Connection to the Service has been lost!");
            ServiceTestRule.this.f10369a = null;
            ServiceConnection serviceConnection = this.f10376a;
            if (serviceConnection != null) {
                serviceConnection.onServiceDisconnected(name);
            }
        }

        private ProxyServiceConnection(ServiceConnection connection) {
            this.f10377b = new CountDownLatch(1);
            this.f10376a = connection;
        }
    }

    private class ServiceStatement extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final j f10379a;

        public ServiceStatement(j base) {
            this.f10379a = base;
        }

        @Override // org.junit.runners.model.j
        public void a() throws Throwable {
            try {
                ServiceTestRule.this.d();
                this.f10379a.a();
            } finally {
                ServiceTestRule.this.h();
                ServiceTestRule.this.c();
            }
        }
    }

    public ServiceTestRule() {
        this(5L, TimeUnit.SECONDS);
    }

    private void k(CountDownLatch latch, String actionName) throws TimeoutException {
        try {
            if (latch.await(this.f10372d, this.f10373e)) {
                return;
            }
            long j7 = this.f10372d;
            String strName = this.f10373e.name();
            StringBuilder sb = new StringBuilder(String.valueOf(strName).length() + 56 + String.valueOf(actionName).length());
            sb.append("Waited for ");
            sb.append(j7);
            sb.append(" ");
            sb.append(strName);
            sb.append(", but service was never ");
            sb.append(actionName);
            throw new TimeoutException(sb.toString());
        } catch (InterruptedException e8) {
            Thread.currentThread().interrupt();
            String strValueOf = String.valueOf(actionName);
            throw new RuntimeException(strValueOf.length() != 0 ? "Interrupted while waiting for service to be ".concat(strValueOf) : new String("Interrupted while waiting for service to be "), e8);
        }
    }

    public static ServiceTestRule l(long timeout, TimeUnit timeUnit) {
        return new ServiceTestRule(timeout, timeUnit);
    }

    @Override // org.junit.rules.l
    public j a(final j base, c description) {
        return new ServiceStatement(base);
    }

    protected void c() {
    }

    protected void d() {
    }

    public IBinder e(@m0 Intent intent) throws TimeoutException {
        this.f10370b = ((Intent) Checks.g(intent, "intent can't be null")).cloneFilter();
        this.f10375g = g(intent, null, 1);
        return this.f10369a;
    }

    public IBinder f(@m0 Intent intent, @m0 ServiceConnection connection, int flags) throws TimeoutException {
        this.f10370b = ((Intent) Checks.g(intent, "intent can't be null")).cloneFilter();
        this.f10375g = g(this.f10370b, (ServiceConnection) Checks.g(connection, "connection can't be null"), flags);
        return this.f10369a;
    }

    @g1
    boolean g(Intent intent, final ServiceConnection conn, int flags) throws TimeoutException {
        ProxyServiceConnection proxyServiceConnection = new ProxyServiceConnection(conn);
        boolean zBindService = InstrumentationRegistry.b().getTargetContext().bindService(intent, proxyServiceConnection, flags);
        if (zBindService) {
            k(proxyServiceConnection.f10377b, "connected");
            this.f10371c = proxyServiceConnection;
        } else {
            Log.e(f10367h, "Failed to bind to service! Is your service declared in the manifest?");
        }
        return zBindService;
    }

    @g1
    void h() throws TimeoutException {
        if (this.f10374f) {
            InstrumentationRegistry.b().getTargetContext().stopService(this.f10370b);
            this.f10374f = false;
        }
        j();
    }

    public void i(@m0 Intent intent) throws TimeoutException {
        this.f10370b = (Intent) Checks.g(intent, "intent can't be null");
        InstrumentationRegistry.b().getTargetContext().startService(this.f10370b);
        this.f10374f = true;
        this.f10375g = g(this.f10370b, null, 1);
    }

    public void j() {
        if (this.f10375g) {
            InstrumentationRegistry.b().getTargetContext().unbindService(this.f10371c);
            this.f10369a = null;
            this.f10375g = false;
        }
    }

    protected ServiceTestRule(long timeout, TimeUnit timeUnit) {
        this.f10374f = false;
        this.f10375g = false;
        this.f10372d = timeout;
        this.f10373e = timeUnit;
    }
}
