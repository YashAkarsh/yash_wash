package com.haier.uhome.ble.hal;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f28278a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f28279b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f28280c = "b";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<String, HashMap<String, e<Void>>> f28281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConcurrentHashMap<String, c> f28282e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private g f28283f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private BleServiceImpl f28284g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private CountDownLatch f28285h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f28286i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final BroadcastReceiver f28287j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ServiceConnection f28288k;

    /* JADX INFO: renamed from: com.haier.uhome.ble.hal.b$1, reason: invalid class name */
    class AnonymousClass1 extends BroadcastReceiver {
        AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "onReceive %s", intent.getAction());
            com.haier.uhome.usdk.base.d.c.a().a(new Runnable() { // from class: com.haier.uhome.ble.hal.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f28371a.a(intent);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(Intent intent) {
            b.this.a(intent);
        }
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f28329a = new b(null);

        private a() {
        }
    }

    /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    private void c() {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "registerBluetoothReceiver", new Object[0]);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        Context contextB = com.haier.uhome.usdk.base.service.e.a().b();
        if (contextB == null) {
            e3.a.f("BLE", com.haier.uhome.ble.a.f28128b, "registerBluetoothReceiver failed", new Object[0]);
        } else {
            this.f28286i.set(true);
            contextB.registerReceiver(this.f28287j, intentFilter);
        }
    }

    private void d() {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "unregisterBluetoothReceiver", new Object[0]);
        Context contextB = com.haier.uhome.usdk.base.service.e.a().b();
        if (contextB != null) {
            contextB.unregisterReceiver(this.f28287j);
        } else {
            e3.a.f("BLE", com.haier.uhome.ble.a.f28128b, "unregisterBluetoothReceiver failed", new Object[0]);
        }
    }

    private void e() {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "unregisterLocalReceiver", new Object[0]);
        com.haier.uhome.usdk.base.d.c.a().b(this);
    }

    private void f() {
        try {
            CountDownLatch countDownLatch = this.f28285h;
            if (countDownLatch != null) {
                countDownLatch.await();
            }
        } catch (InterruptedException unused) {
            e3.a.f("BLE", com.haier.uhome.ble.a.f28128b, "waitServiceReady interrupt!", new Object[0]);
            Thread.currentThread().interrupt();
        }
    }

    private void g() {
        this.f28285h = new CountDownLatch(1);
        Context contextB = com.haier.uhome.usdk.base.service.e.a().b();
        if (contextB == null) {
            this.f28284g = BleServiceImpl.a();
        } else if (contextB.bindService(new Intent(contextB, (Class<?>) BleServiceImpl.class), this.f28288k, 1)) {
            f();
        } else {
            contextB.unbindService(this.f28288k);
        }
    }

    private BleServiceImpl h() {
        if (this.f28284g == null) {
            g();
        }
        return this.f28284g;
    }

    private b() {
        this.f28287j = new AnonymousClass1();
        this.f28288k = new ServiceConnection() { // from class: com.haier.uhome.ble.hal.b.8
            private void a() {
                if (b.this.f28285h != null) {
                    b.this.f28285h.countDown();
                    b.this.f28285h = null;
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                if (iBinder == null) {
                    e3.a.h("onServiceConnected with null service", new Object[0]);
                    return;
                }
                if (iBinder instanceof BleServiceImpl.a) {
                    b.this.f28284g = ((BleServiceImpl.a) iBinder).a();
                    a();
                    e3.a.e("onServiceConnected with BleServiceImpl", new Object[0]);
                    return;
                }
                e3.a.h("onServiceConnected with illegal type:" + iBinder.getClass().getSimpleName(), new Object[0]);
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                b.this.f28284g = null;
            }
        };
        com.haier.uhome.usdk.base.d.c.a().a(this);
        this.f28281d = new ConcurrentHashMap<>();
        this.f28282e = new ConcurrentHashMap<>();
        this.f28286i = new AtomicBoolean(false);
        com.haier.uhome.usdk.base.d.c.a().c(new com.haier.uhome.usdk.base.d.d(f28280c, 1));
    }

    public void b() {
        if (this.f28286i.get()) {
            d();
            e();
        }
    }

    public void b(String str, final ICallback<Void> iCallback) {
        a(com.haier.uhome.ble.hal.a.a.a.f.b(str, new ICallback<Bundle>() { // from class: com.haier.uhome.ble.hal.b.12
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Bundle bundle) {
                ICallback iCallback2 = iCallback;
                if (iCallback2 != null) {
                    iCallback2.onSuccess(null);
                }
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                ICallback iCallback2 = iCallback;
                if (iCallback2 == null || usdkerror == null) {
                    return;
                }
                iCallback2.onFailure(usdkerror);
            }
        }));
    }

    public static b a() {
        return a.f28329a;
    }

    public void b(String str, String str2, String str3, byte[] bArr, final ICallback<Void> iCallback) {
        a(com.haier.uhome.ble.hal.a.a.a.f.b(str, str2, str3, bArr, new ICallback<Bundle>() { // from class: com.haier.uhome.ble.hal.b.15
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Bundle bundle) {
                ICallback iCallback2 = iCallback;
                if (iCallback2 != null) {
                    iCallback2.onSuccess(null);
                }
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                ICallback iCallback2 = iCallback;
                if (iCallback2 == null || usdkerror == null) {
                    return;
                }
                iCallback2.onFailure(usdkerror);
            }
        }));
    }

    private void a(String str) {
        this.f28281d.remove(str);
        this.f28282e.remove(str);
    }

    public void b(final String str, final String str2, final String str3, final ICallback<Void> iCallback) {
        a(com.haier.uhome.ble.hal.a.a.a.f.d(str, str2, str3, new ICallback<Bundle>() { // from class: com.haier.uhome.ble.hal.b.5
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Bundle bundle) {
                ICallback iCallback2 = iCallback;
                if (iCallback2 != null) {
                    iCallback2.onSuccess(null);
                }
                HashMap map = (HashMap) b.this.f28281d.get(str);
                if (map == null) {
                    return;
                }
                map.remove(b.this.a(str2, str3));
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                ICallback iCallback2 = iCallback;
                if (iCallback2 == null || usdkerror == null) {
                    return;
                }
                iCallback2.onFailure(usdkerror);
            }
        }));
    }

    public void b(final String str, final String str2, final String str3, final e<Void> eVar) {
        a(com.haier.uhome.ble.hal.a.a.a.f.c(str, str2, str3, new ICallback<Bundle>() { // from class: com.haier.uhome.ble.hal.b.6
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Bundle bundle) {
                e eVar2 = eVar;
                if (eVar2 != null) {
                    eVar2.onSuccess(null);
                }
                HashMap map = (HashMap) b.this.f28281d.get(str);
                if (map == null) {
                    map = new HashMap();
                    b.this.f28281d.put(str, map);
                }
                map.put(b.this.a(str2, str3), eVar);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                e eVar2 = eVar;
                if (eVar2 == null || usdkerror == null) {
                    return;
                }
                eVar2.onFailure(usdkerror);
            }
        }));
    }

    public void c(final String str, final String str2, final String str3, final ICallback<Void> iCallback) {
        a(com.haier.uhome.ble.hal.a.a.a.f.e(str, str2, str3, new ICallback<Bundle>() { // from class: com.haier.uhome.ble.hal.b.7
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Bundle bundle) {
                ICallback iCallback2 = iCallback;
                if (iCallback2 != null) {
                    iCallback2.onSuccess(null);
                }
                HashMap map = (HashMap) b.this.f28281d.get(str);
                if (map == null) {
                    return;
                }
                map.remove(b.this.a(str2, str3));
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                ICallback iCallback2 = iCallback;
                if (iCallback2 == null || usdkerror == null) {
                    return;
                }
                iCallback2.onFailure(usdkerror);
            }
        }));
    }

    @com.haier.uhome.usdk.base.annotation.d
    public void a(com.haier.uhome.usdk.base.d.d dVar) {
        if (dVar == null || !f28280c.equals(dVar.f31262a)) {
            return;
        }
        int i7 = dVar.f31263b;
        if (1 == i7) {
            c();
        } else if (2 == i7) {
            Object obj = dVar.f31264c;
            if (obj instanceof Intent) {
                a((Intent) obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent) {
        HashMap<String, e<Void>> map;
        e<Void> eVar;
        if (com.haier.uhome.ble.a.f28139m.equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra(com.haier.uhome.ble.a.f28144r);
            String stringExtra2 = intent.getStringExtra(com.haier.uhome.ble.a.f28145s);
            String stringExtra3 = intent.getStringExtra(com.haier.uhome.ble.a.f28146t);
            byte[] byteArrayExtra = intent.getByteArrayExtra(com.haier.uhome.ble.a.f28147u);
            if (stringExtra == null || (map = this.f28281d.get(stringExtra)) == null || map.isEmpty() || (eVar = map.get(a(stringExtra2, stringExtra3))) == null) {
                return;
            }
            eVar.a(stringExtra, stringExtra2, stringExtra3, byteArrayExtra);
            return;
        }
        if (com.haier.uhome.ble.a.f28138l.equals(intent.getAction())) {
            String stringExtra4 = intent.getStringExtra(com.haier.uhome.ble.a.f28144r);
            int intExtra = intent.getIntExtra(com.haier.uhome.ble.a.f28148v, 0);
            if (stringExtra4 == null) {
                e3.a.u("BLE", com.haier.uhome.ble.a.f28128b, "Connect state received address is null state = %d", Integer.valueOf(intExtra));
                return;
            }
            c cVar = this.f28282e.get(stringExtra4);
            e3.a.u("BLE", com.haier.uhome.ble.a.f28128b, "Connect state listener = %s", com.haier.library.common.util.c.n(cVar));
            if (cVar != null) {
                cVar.a(stringExtra4, intExtra);
                return;
            }
            return;
        }
        if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) {
            int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0);
            int intExtra3 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 0);
            g gVar = this.f28283f;
            if (gVar != null) {
                gVar.a(intExtra3, intExtra2);
            }
        }
    }

    public void a(final f fVar) {
        a(com.haier.uhome.ble.hal.a.a.a.f.a(new ICallback<Bundle>() { // from class: com.haier.uhome.ble.hal.b.9
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Bundle bundle) {
                if (fVar == null || bundle == null) {
                    return;
                }
                bundle.setClassLoader(getClass().getClassLoader());
                fVar.onResp(bundle.getInt(com.haier.uhome.ble.a.f28140n, -1), bundle.getString(com.haier.uhome.ble.a.f28144r, ""), bundle.getString(com.haier.uhome.ble.a.f28141o, ""), bundle.getInt(com.haier.uhome.ble.a.f28142p, -1), bundle.getByteArray(com.haier.uhome.ble.a.f28143q));
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                f fVar2 = fVar;
                if (fVar2 == null || usdkerror == null) {
                    return;
                }
                fVar2.onResp(usdkerror.getCode(), null, null, -1, null);
            }
        }));
    }

    public void a(final ICallback<Void> iCallback) {
        a(com.haier.uhome.ble.hal.a.a.a.f.b(new ICallback<Bundle>() { // from class: com.haier.uhome.ble.hal.b.10
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Bundle bundle) {
                ICallback iCallback2 = iCallback;
                if (iCallback2 != null) {
                    iCallback2.onSuccess(null);
                }
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                ICallback iCallback2 = iCallback;
                if (iCallback2 == null || usdkerror == null) {
                    return;
                }
                iCallback2.onFailure(usdkerror);
            }
        }));
    }

    public void a(String str, final ICallback<String> iCallback) {
        a(com.haier.uhome.ble.hal.a.a.a.f.a(str, new ICallback<Bundle>() { // from class: com.haier.uhome.ble.hal.b.11
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Bundle bundle) {
                if (iCallback == null || bundle == null) {
                    return;
                }
                bundle.setClassLoader(getClass().getClassLoader());
                iCallback.onSuccess(bundle.getString(com.haier.uhome.ble.a.f28149w));
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                ICallback iCallback2 = iCallback;
                if (iCallback2 == null || usdkerror == null) {
                    return;
                }
                iCallback2.onFailure(usdkerror);
            }
        }));
    }

    public void a(String str, String str2, String str3, final ICallback<byte[]> iCallback) {
        a(com.haier.uhome.ble.hal.a.a.a.f.a(str, str2, str3, new ICallback<Bundle>() { // from class: com.haier.uhome.ble.hal.b.13
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Bundle bundle) {
                if (iCallback == null || bundle == null) {
                    return;
                }
                bundle.setClassLoader(getClass().getClassLoader());
                iCallback.onSuccess(bundle.getByteArray(com.haier.uhome.ble.a.f28147u));
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                ICallback iCallback2 = iCallback;
                if (iCallback2 == null || usdkerror == null) {
                    return;
                }
                iCallback2.onFailure(usdkerror);
            }
        }));
    }

    public void a(String str, String str2, String str3, byte[] bArr, final ICallback<Void> iCallback) {
        a(com.haier.uhome.ble.hal.a.a.a.f.a(str, str2, str3, bArr, new ICallback<Bundle>() { // from class: com.haier.uhome.ble.hal.b.14
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Bundle bundle) {
                ICallback iCallback2 = iCallback;
                if (iCallback2 != null) {
                    iCallback2.onSuccess(null);
                }
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                ICallback iCallback2 = iCallback;
                if (iCallback2 == null || usdkerror == null) {
                    return;
                }
                iCallback2.onFailure(usdkerror);
            }
        }));
    }

    public void a(String str, String str2, String str3, String str4, final ICallback<byte[]> iCallback) {
        a(com.haier.uhome.ble.hal.a.a.a.f.a(str, str2, str3, str4, new ICallback<Bundle>() { // from class: com.haier.uhome.ble.hal.b.2
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Bundle bundle) {
                if (iCallback == null || bundle == null) {
                    return;
                }
                bundle.setClassLoader(getClass().getClassLoader());
                iCallback.onSuccess(bundle.getByteArray(com.haier.uhome.ble.a.f28147u));
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                ICallback iCallback2 = iCallback;
                if (iCallback2 == null || usdkerror == null) {
                    return;
                }
                iCallback2.onFailure(usdkerror);
            }
        }));
    }

    public void a(String str, String str2, String str3, String str4, byte[] bArr, final ICallback<byte[]> iCallback) {
        a(com.haier.uhome.ble.hal.a.a.a.f.a(str, str2, str3, str4, bArr, new ICallback<Bundle>() { // from class: com.haier.uhome.ble.hal.b.3
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Bundle bundle) {
                ICallback iCallback2 = iCallback;
                if (iCallback2 != null) {
                    iCallback2.onSuccess(null);
                }
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                ICallback iCallback2 = iCallback;
                if (iCallback2 == null || usdkerror == null) {
                    return;
                }
                iCallback2.onFailure(usdkerror);
            }
        }));
    }

    public void a(final String str, final String str2, final String str3, final e<Void> eVar) {
        a(com.haier.uhome.ble.hal.a.a.a.f.b(str, str2, str3, new ICallback<Bundle>() { // from class: com.haier.uhome.ble.hal.b.4
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Bundle bundle) {
                e eVar2 = eVar;
                if (eVar2 != null) {
                    eVar2.onSuccess(null);
                }
                HashMap map = (HashMap) b.this.f28281d.get(str);
                if (map == null) {
                    map = new HashMap();
                    b.this.f28281d.put(str, map);
                }
                map.put(b.this.a(str2, str3), eVar);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                e eVar2 = eVar;
                if (eVar2 == null || usdkerror == null) {
                    return;
                }
                eVar2.onFailure(usdkerror);
            }
        }));
    }

    public void a(String str, c cVar) {
        if (cVar != null) {
            this.f28282e.put(str, cVar);
        } else {
            this.f28282e.remove(str);
        }
    }

    public void a(g gVar) {
        this.f28283f = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String... strArr) {
        return Arrays.toString(strArr);
    }

    private void a(com.haier.uhome.ble.hal.a.a.a.f fVar) {
        try {
            BleServiceImpl bleServiceImplH = h();
            if (bleServiceImplH != null) {
                bleServiceImplH.a(fVar);
            } else {
                ICallback<Bundle> iCallbackG = fVar.g();
                if (iCallbackG != null) {
                    iCallbackG.onFailure(ErrorConst.ERR_INTERNAL.toError());
                }
            }
        } catch (Exception e8) {
            e3.a.f("BLE", com.haier.uhome.ble.a.f28128b, "callService exception: %s ", e8);
        }
    }
}
