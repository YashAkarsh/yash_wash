package com.haier.uhome.ble.hal.a.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f28246a = 2000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f28247b = 1000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f28248c = 8000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static a f28249f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ICallback<Bundle> f28252g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f28253h = new AtomicBoolean(false);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f28254i = new AtomicBoolean(false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f28251e = new AtomicBoolean(true);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicLong f28250d = new AtomicLong(0);

    /* JADX INFO: renamed from: com.haier.uhome.ble.hal.a.b.a$a, reason: collision with other inner class name */
    enum EnumC0365a {
        STARTED,
        STOPPED,
        CANCELED,
        FOUNDED,
        START_FAIL;

        public int a() {
            return ordinal() + 1;
        }
    }

    a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:12:0x0038  */
    public boolean g() {
        boolean zB;
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "tryStartScan", new Object[0]);
        if (!this.f28254i.get()) {
            if (this.f28253h.get()) {
                e3.a.n("BLE", com.haier.uhome.ble.a.f28128b, "tryStartScan in scanning,so return", new Object[0]);
            } else {
                zB = b();
            }
            this.f28253h.compareAndSet(false, zB);
            if (!zB) {
                h();
            }
            return zB;
        }
        e3.a.n("BLE", com.haier.uhome.ble.a.f28128b, "tryStartScan configuring, so return", new Object[0]);
        zB = false;
        this.f28253h.compareAndSet(false, zB);
        if (!zB) {
            h();
        }
        return zB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "tryStopScan", new Object[0]);
        boolean zC = c();
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "tryStopScan ret = %s", Boolean.valueOf(zC));
        this.f28253h.compareAndSet(true, !zC);
        return zC;
    }

    private boolean i() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j7 = this.f28250d.get();
        boolean z7 = jCurrentTimeMillis > f28248c + j7;
        if (z7) {
            e3.a.e("check timeout N = %d,L = %d", Long.valueOf(jCurrentTimeMillis), Long.valueOf(j7));
        }
        return z7 && j();
    }

    private boolean j() {
        boolean zB = com.haier.uhome.usdk.base.service.a.a().b();
        boolean zB2 = com.haier.uhome.usdk.base.service.a.a().b();
        e3.a.e("foreground = %s ,screenOn = %s", Boolean.valueOf(zB), Boolean.valueOf(zB2));
        return zB && zB2;
    }

    private void k() {
        com.haier.uhome.usdk.base.d.c.a().a(new Runnable() { // from class: com.haier.uhome.ble.hal.a.b.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f28274a.p();
            }
        }, f28246a);
    }

    private void l() {
        this.f28250d.set(0L);
        this.f28251e.compareAndSet(true, false);
    }

    private void m() {
        h();
        com.haier.uhome.usdk.base.d.c.a().a(new Runnable() { // from class: com.haier.uhome.ble.hal.a.b.k
            @Override // java.lang.Runnable
            public final void run() {
                this.f28277a.o();
            }
        }, 1000L);
    }

    private void n() {
        this.f28250d.set(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o() {
        g();
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p() {
        if (this.f28251e.get()) {
            if (i()) {
                m();
            } else if (!j() && this.f28253h.get()) {
                h();
            }
            k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q() {
        e3.a.e("startScan ret %s", Boolean.valueOf(g()));
    }

    public static synchronized a a() {
        a aVar = f28249f;
        if (aVar != null) {
            return aVar;
        }
        b bVar = new b();
        f28249f = bVar;
        return bVar;
    }

    private void d() {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "postStarted", new Object[0]);
        this.f28251e.compareAndSet(false, true);
        n();
        k();
        Bundle bundle = new Bundle();
        bundle.setClassLoader(getClass().getClassLoader());
        bundle.putInt(com.haier.uhome.ble.a.f28140n, EnumC0365a.STARTED.a());
        ICallback<Bundle> iCallback = this.f28252g;
        if (iCallback != null) {
            iCallback.onSuccess(bundle);
        }
    }

    private void e() {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "postStopped", new Object[0]);
        l();
        Bundle bundle = new Bundle();
        bundle.setClassLoader(getClass().getClassLoader());
        bundle.putInt(com.haier.uhome.ble.a.f28140n, EnumC0365a.STOPPED.a());
        ICallback<Bundle> iCallback = this.f28252g;
        if (iCallback != null) {
            iCallback.onSuccess(bundle);
        }
    }

    private void f() {
        this.f28252g = null;
    }

    boolean b() {
        return false;
    }

    boolean c() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(ICallback iCallback) {
        if (h()) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
        } else {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, ErrorConst.ERR_INTERNAL.toError());
        }
    }

    public void b(final ICallback<Bundle> iCallback) {
        if (this.f28252g == null) {
            e3.a.u("BLE", com.haier.uhome.ble.a.f28128b, "startScan callback duplicate", new Object[0]);
        }
        e();
        f();
        com.haier.uhome.usdk.base.d.c.a().a(new Runnable() { // from class: com.haier.uhome.ble.hal.a.b.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f28275a.c(iCallback);
            }
        });
    }

    protected void a(ICallback<Bundle> iCallback) {
        if (this.f28252g != null) {
            e3.a.u("BLE", com.haier.uhome.ble.a.f28128b, "startScan callback duplicate", new Object[0]);
        }
        this.f28252g = iCallback;
        d();
        com.haier.uhome.usdk.base.d.c.a().a(new Runnable() { // from class: com.haier.uhome.ble.hal.a.b.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f28273a.q();
            }
        });
    }

    public void a(boolean z7) {
        this.f28254i.set(z7);
        if (z7) {
            e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "stop ble scanning when configuring", new Object[0]);
            com.haier.uhome.usdk.base.d.c.a().a(new Runnable() { // from class: com.haier.uhome.ble.hal.a.b.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f28271a.h();
                }
            });
        } else if (this.f28253h.get()) {
            e3.a.f("BLE", com.haier.uhome.ble.a.f28128b, "end ble configuring,but inScanning is doing !!", new Object[0]);
        } else if (this.f28252g != null) {
            e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "end ble configuring,start ble scanning !!", new Object[0]);
            com.haier.uhome.usdk.base.d.c.a().a(new Runnable() { // from class: com.haier.uhome.ble.hal.a.b.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f28272a.g();
                }
            });
        } else {
            e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "end ble configuring,and cae already call stop", new Object[0]);
        }
    }

    void a(String str, String str2, int i7, byte[] bArr) {
        n();
        if (str == null) {
            return;
        }
        String upperCase = str.toUpperCase();
        if (TextUtils.isEmpty(str2)) {
            str2 = "Unknow";
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        Bundle bundle = new Bundle();
        bundle.setClassLoader(getClass().getClassLoader());
        bundle.putInt(com.haier.uhome.ble.a.f28140n, EnumC0365a.FOUNDED.a());
        bundle.putString(com.haier.uhome.ble.a.f28144r, upperCase);
        bundle.putString(com.haier.uhome.ble.a.f28141o, str2);
        bundle.putInt(com.haier.uhome.ble.a.f28142p, i7);
        bundle.putByteArray(com.haier.uhome.ble.a.f28143q, bArr);
        ICallback<Bundle> iCallback = this.f28252g;
        if (iCallback != null) {
            iCallback.onSuccess(bundle);
        }
    }

    void a(int i7) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "postStartFail %d", Integer.valueOf(i7));
        Bundle bundle = new Bundle();
        bundle.setClassLoader(getClass().getClassLoader());
        bundle.putInt(com.haier.uhome.ble.a.f28140n, EnumC0365a.START_FAIL.a());
        ICallback<Bundle> iCallback = this.f28252g;
        if (iCallback != null) {
            iCallback.onSuccess(bundle);
        }
    }
}
