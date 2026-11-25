package com.haier.globalwasher.modle.utils.bluetoothutil;

import android.app.AppOpsManager;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanResult;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.view.View;
import c.a1;
import c.m0;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.utils.e0;
import com.haier.globalwasher.modle.utils.i0;
import com.haier.globalwasher.modle.utils.j0;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.modle.utils.v;
import com.haier.globalwasher.modle.utils.v.e;
import com.haier.globalwasher.modle.utils.z;
import com.haier.globalwasher.presenter.u;
import com.haier.globalwasher.view.activity.order.OrderIsPaidToRunActivity;
import com.haier.globalwasher.view.activity.order.SubscriptSuccessfulActivity;
import com.haier.uhome.usdk.api.interfaces.IuSDKCallback;
import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.api.uSDKErrorConst;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BaseActivity f24547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private v3.c f24548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.haier.globalwasher.modle.utils.phone_util.a f24549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ContentObserver f24550d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private g f24552f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    i f24553g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    h f24554h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f24551e = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f24555i = "BlueActivity";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f24556j = com.haier.library.sumhttp.plugin.h.f27944a;

    /* JADX INFO: renamed from: com.haier.globalwasher.modle.utils.bluetoothutil.a$a, reason: collision with other inner class name */
    class C0320a implements com.haier.globalwasher.modle.utils.phone_util.a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n2.a f24557a;

        C0320a(n2.a aVar) {
            this.f24557a = aVar;
        }

        @Override // com.haier.globalwasher.modle.utils.phone_util.a.c
        public void a() {
            if (a.this.l().d()) {
                a.this.i(this.f24557a);
            } else {
                this.f24557a.e(true);
                a.this.l().c(a.this.f24547a);
            }
        }

        @Override // com.haier.globalwasher.modle.utils.phone_util.a.c
        public void cancel() {
            this.f24557a.e(true);
        }
    }

    class b extends ContentObserver {
        b(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z7) {
            super.onChange(z7);
            q.c(a.this.f24555i, "selfChange=" + z7);
            if (a.this.f24554h == null) {
                HandlerThread handlerThread = new HandlerThread("handler_thread");
                handlerThread.start();
                a.this.f24554h = new h(a.this, handlerThread.getLooper());
            }
            boolean zSendEmptyMessage = a.this.f24554h.sendEmptyMessage(1);
            q.c(a.this.f24555i, "isOk=" + zSendEmptyMessage);
        }
    }

    class c implements IuSDKCallback {
        c() {
        }

        @Override // com.haier.uhome.usdk.api.interfaces.IuSDKCallback
        public void onCallback(uSDKErrorConst usdkerrorconst) {
            q.c(OrderIsPaidToRunActivity.Q, "etPresenter().disConnentSDK");
            j0.f().e().clear();
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseActivity f24562a;

        e(BaseActivity baseActivity) {
            this.f24562a = baseActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            q.c(a.this.f24555i, "权限权限权限权限权限权限权限权限权限权限权限权限333");
            this.f24562a.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 1013);
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            q.c(a.this.f24555i, "权限权限权限");
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", a.this.f24547a.getPackageName(), null));
            a.this.f24547a.startActivityForResult(intent, 1007);
        }
    }

    public abstract class g implements n2.a, n2.b, t3.a, v3.a {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        v3.b f24565l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private boolean f24567n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private com.jiao.project.bluetoothofabroadwasherapp.enums.c f24568o;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private boolean f24566m = false;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private boolean f24569p = false;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private com.jiao.project.bluetoothofabroadwasherapp.enums.c f24570q = com.jiao.project.bluetoothofabroadwasherapp.enums.c.NOT_COMMAND;

        /* JADX INFO: renamed from: com.haier.globalwasher.modle.utils.bluetoothutil.a$g$a, reason: collision with other inner class name */
        class RunnableC0321a implements Runnable {
            RunnableC0321a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.d();
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ t3.c f24573a;

            b(t3.c cVar) {
                this.f24573a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                g gVar = g.this;
                gVar.t(gVar.f24570q == com.jiao.project.bluetoothofabroadwasherapp.enums.c.START_COMMAND);
                if (this.f24573a instanceof w3.c) {
                    g gVar2 = g.this;
                    gVar2.g(gVar2.f24570q, 3);
                } else {
                    g gVar3 = g.this;
                    gVar3.g(gVar3.f24570q, g.this.f24570q.b());
                }
            }
        }

        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.k(11, new Object[0]);
                g.this.f24566m = false;
            }
        }

        public g(boolean z7, v3.b bVar) {
            this.f24567n = z7;
            this.f24565l = bVar;
        }

        private void x() {
            String str = a.this.f24555i;
            StringBuilder sb = new StringBuilder();
            sb.append("START_SDK");
            sb.append(a.this.f24547a != null);
            sb.append(!a.this.f24547a.isFinishing());
            q.c(str, sb.toString());
            if (a.this.f24547a == null || a.this.f24547a.isFinishing()) {
                return;
            }
            if (this.f24565l == null) {
                e(true);
                i0.d(a.this.f24547a, "Parameter error,Please check moduleType");
            } else {
                q.c(a.this.f24555i, "START_SDK");
                if (this.f24565l != null) {
                    a.this.f24548b.f(a.this.f24547a, this.f24565l, this);
                }
            }
        }

        @Override // n2.b
        public <uSDKDevice> void a(uSDKDevice usdkdevice) {
            e(true);
        }

        @Override // t3.a
        public void b(BluetoothDevice bluetoothDevice) {
            if (a.this.f24547a == null || a.this.f24547a.isFinishing()) {
                return;
            }
            a.this.f24547a.runOnUiThread(new RunnableC0321a());
        }

        @Override // n2.b
        public com.jiao.project.bluetoothofabroadwasherapp.enums.c c() {
            return this.f24568o;
        }

        @Override // n2.b
        public void d() {
            this.f24566m = true;
            a.this.f24548b.b().b();
        }

        @Override // n2.a
        public void f(boolean z7) {
            q.c("OrderStatuManager", "phoneIsReady" + z7);
            if (z7) {
                x();
            } else {
                a.this.g(this);
            }
        }

        @Override // t3.a
        public void h() {
            i(com.jiao.project.bluetoothofabroadwasherapp.enums.a.CONNET_FAIL);
        }

        @Override // t3.a
        public void i(com.jiao.project.bluetoothofabroadwasherapp.enums.a aVar) {
            q.a(a.this.f24555i, "commandEexProgress  " + aVar.d());
            if (aVar == com.jiao.project.bluetoothofabroadwasherapp.enums.a.CUSTOM || aVar == com.jiao.project.bluetoothofabroadwasherapp.enums.a.FAIL_BLUETOOTH || aVar == com.jiao.project.bluetoothofabroadwasherapp.enums.a.FAIL_MY || aVar == com.jiao.project.bluetoothofabroadwasherapp.enums.a.NOT_THIS_ADDRESS_FAIL || aVar == com.jiao.project.bluetoothofabroadwasherapp.enums.a.CONNET_FAIL) {
                a.this.f24547a.runOnUiThread(new c());
            } else if (aVar == com.jiao.project.bluetoothofabroadwasherapp.enums.a.NOT_RESULT_FAIL) {
                g(this.f24570q, 3);
            } else if (aVar == com.jiao.project.bluetoothofabroadwasherapp.enums.a.DISCONNET_FAIL) {
                this.f24566m = false;
            }
        }

        @Override // t3.a
        public void j(List<ScanResult> list) {
            if (a.this.f24547a == null || a.this.f24547a.isFinishing()) {
                return;
            }
            for (ScanResult scanResult : list) {
                if (Build.VERSION.SDK_INT >= 31 && androidx.core.content.d.a(a.this.f24547a, "android.permission.BLUETOOTH_CONNECT") != 0) {
                    androidx.core.app.b.G(a.this.f24547a, new String[]{"android.permission.BLUETOOTH_CONNECT"}, 1);
                    return;
                }
                q.c(a.this.f24555i, "iBluetoothBean.getBluetoothMac()=" + this.f24565l.getBluetoothMac() + " scanResult.getDevice().getName()=" + scanResult.getDevice().getName());
                String str = a.this.f24555i;
                StringBuilder sb = new StringBuilder();
                sb.append("iBluetoothBean.getBluetoothMac().equals(scanResult.getDevice().getName()");
                sb.append(this.f24565l.getBluetoothMac().equals(scanResult.getDevice().getName()));
                q.c(str, sb.toString());
                if (this.f24565l.getBluetoothMac() != null && this.f24565l.getBluetoothMac().equals(scanResult.getDevice().getName())) {
                    a.this.f24548b.d();
                    a.this.f24548b.a(scanResult.getDevice().getAddress());
                    return;
                }
            }
        }

        @Override // n2.b
        public <T> void k(int i7, T... tArr) {
            try {
                e(true);
                if (i7 == 1) {
                    u(false);
                    x();
                } else if (i7 == 4) {
                    a.this.f24548b.j(null);
                } else if (i7 == 6) {
                    i0.d(a.this.f24547a, a.this.o(R.string.usdk_device_token_has_expired));
                } else if (i7 == 8) {
                    i0.d(a.this.f24547a, a.this.o(R.string.usdk_class_error));
                } else if (i7 == 11) {
                    i0.d(a.this.f24547a, a.this.o(R.string.bluetooth_connection_failed));
                }
            } catch (Exception unused) {
            }
        }

        @Override // t3.a
        public void l(t3.c cVar) {
            q.c("CustomBluetoothUtil", "commandEexResult=" + cVar.c());
            if (a.this.f24547a != null && !a.this.f24547a.isFinishing()) {
                a.this.f24547a.runOnUiThread(new b(cVar));
            }
            a.this.f24548b.j(null);
        }

        @Override // n2.b
        public void m(Object obj) {
            e(false);
        }

        public boolean p() {
            return this.f24569p;
        }

        public boolean q() {
            return this.f24566m;
        }

        public boolean r() {
            return this.f24567n;
        }

        public void s(com.jiao.project.bluetoothofabroadwasherapp.enums.c cVar) {
            this.f24568o = cVar;
        }

        public void t(boolean z7) {
            this.f24569p = z7;
        }

        public void u(boolean z7) {
            this.f24567n = z7;
        }

        public void v(v3.b bVar) {
            this.f24565l = bVar;
        }

        public void w(v3.b bVar, v3.a aVar) {
            if (bVar == null) {
                return;
            }
            com.jiao.project.bluetoothofabroadwasherapp.enums.c cVar = com.jiao.project.bluetoothofabroadwasherapp.enums.c.START_COMMAND;
            this.f24570q = cVar;
            int iBluetoothType = bVar.bluetoothType();
            if (iBluetoothType == 1) {
                a.this.f24548b.e(bVar.getBluetoothMac(), bVar.getStartCommand(), aVar);
                return;
            }
            if (iBluetoothType != 2) {
                return;
            }
            BluetoothDevice bluetoothDevice = (BluetoothDevice) a.this.f24548b.c();
            if (Build.VERSION.SDK_INT >= 31 && androidx.core.content.d.a(a.this.f24547a, "android.permission.BLUETOOTH_CONNECT") != 0) {
                androidx.core.app.b.G(a.this.f24547a, new String[]{"android.permission.BLUETOOTH_CONNECT"}, 1);
                return;
            }
            if (bluetoothDevice != null && bVar.getBluetoothMac().equals(bluetoothDevice.getName())) {
                a.this.f24548b.e(bVar.getBluetoothMac(), bVar.getStartCommand(), aVar);
                return;
            }
            v(bVar);
            u(true);
            s(cVar);
            a.this.u(this);
        }

        public void y(v3.b bVar, v3.a aVar) {
            com.jiao.project.bluetoothofabroadwasherapp.enums.c cVar = com.jiao.project.bluetoothofabroadwasherapp.enums.c.END_COMMAND;
            this.f24570q = cVar;
            if (bVar != null) {
                int iBluetoothType = bVar.bluetoothType();
                if (iBluetoothType == 1) {
                    a.this.f24548b.g(bVar.getBluetoothMac(), aVar);
                    return;
                }
                if (iBluetoothType != 2) {
                    return;
                }
                BluetoothDevice bluetoothDevice = (BluetoothDevice) a.this.f24548b.c();
                if (Build.VERSION.SDK_INT >= 31 && androidx.core.content.d.a(a.this.f24547a, "android.permission.BLUETOOTH_CONNECT") != 0) {
                    androidx.core.app.b.G(a.this.f24547a, new String[]{"android.permission.BLUETOOTH_CONNECT"}, 1);
                    return;
                }
                if (bluetoothDevice != null && bVar.getBluetoothMac().equals(bluetoothDevice.getName())) {
                    a.this.f24548b.g(bVar.getBluetoothMac(), aVar);
                    return;
                }
                v(bVar);
                u(true);
                s(cVar);
                a.this.u(this);
            }
        }
    }

    private static class h extends Handler {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final int f24576b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int f24577c = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        SoftReference<a> f24578a;

        public h(a aVar, Looper looper) {
            super(looper);
            this.f24578a = new SoftReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i7 = message.what;
            if (i7 != 0) {
                if (i7 != 1) {
                    return;
                }
                sendEmptyMessageDelayed(0, 500L);
            } else {
                if (com.haier.globalwasher.modle.utils.i.b(100L)) {
                    return;
                }
                q.c(this.f24578a.get().f24555i, "LocationUtil.gpsIsOpen()=" + com.haier.globalwasher.modle.utils.phone_util.b.a());
                if (this.f24578a.get().f24552f != null) {
                    this.f24578a.get().f24552f.f(com.haier.globalwasher.modle.utils.phone_util.b.a() != 0);
                }
            }
        }
    }

    @Deprecated
    private class i extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            q.a(a.this.f24555i, action);
            if (action == null) {
                return;
            }
            if (!action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                if (action.equals("android.location.MODE_CHANGED")) {
                    if (!intent.getBooleanExtra("android.location.extra.LOCATION_ENABLED", false)) {
                        a.this.f24552f.e(true);
                        return;
                    } else {
                        a aVar = a.this;
                        aVar.i(aVar.f24552f);
                        return;
                    }
                }
                return;
            }
            int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
            if (intExtra == 10) {
                a.this.f24552f.e(true);
            } else {
                if (intExtra != 12) {
                    return;
                }
                a aVar2 = a.this;
                aVar2.i(aVar2.f24552f);
            }
        }

        private i() {
        }
    }

    public a(BaseActivity baseActivity, int i7) {
        this.f24547a = baseActivity;
        if (i7 == 1) {
            this.f24548b = new u(baseActivity);
        } else {
            if (i7 != 2) {
                return;
            }
            this.f24548b = com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.h.r(baseActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(n2.a aVar) {
        this.f24548b.b().d();
        if (l().b()) {
            i(aVar);
            return;
        }
        q.c("OrderStatuManager", "getBluetoothUtil. showOpenWindow ");
        this.f24548b.b().b();
        l().e(this.f24547a, new C0320a(aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(n2.a aVar) {
        int i7 = e0.f()[0];
        q.c("OrderStatuManager", "checkLoaction version=" + i7);
        this.f24548b.b().b();
        if (i7 < 10) {
            aVar.f(true);
        } else if (com.haier.globalwasher.modle.utils.phone_util.b.a() != 0) {
            j(aVar);
        } else {
            v(this.f24547a, aVar);
        }
    }

    private void j(n2.a aVar) {
        if (com.haier.globalwasher.modle.a.b(this.f24547a, "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION") < 2) {
            if (l().b()) {
                aVar.f(true);
                return;
            } else {
                aVar.e(true);
                return;
            }
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.f24547a.getSystemService("appops");
        int iCheckOpNoThrow = appOpsManager.checkOpNoThrow("android:fine_location", Binder.getCallingUid(), this.f24547a.getPackageName());
        int iCheckOpNoThrow2 = appOpsManager.checkOpNoThrow("android:coarse_location", Binder.getCallingUid(), this.f24547a.getPackageName());
        if (iCheckOpNoThrow == 0 || iCheckOpNoThrow2 == 0) {
            if (l().b()) {
                aVar.f(true);
                return;
            } else {
                aVar.e(true);
                return;
            }
        }
        if (iCheckOpNoThrow == 1 || iCheckOpNoThrow2 == 1) {
            this.f24547a.requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, 1);
            return;
        }
        aVar.e(true);
        q.c(this.f24555i, "coarseLocation=" + iCheckOpNoThrow2 + "   fineLocation=" + iCheckOpNoThrow);
        n();
    }

    private void q() {
        int[] iArrF = e0.f();
        if (iArrF.length >= 1 && iArrF[0] >= 10) {
            this.f24553g = new i();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.location.MODE_CHANGED");
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            if (Build.VERSION.SDK_INT >= 33) {
                this.f24547a.registerReceiver(this.f24553g, intentFilter, 4);
            } else {
                this.f24547a.registerReceiver(this.f24553g, intentFilter);
            }
        }
        this.f24550d = new b(null);
        this.f24547a.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("location_providers_allowed"), false, this.f24550d);
    }

    public com.jiao.project.bluetoothofabroadwasherapp.enums.d h(String str) {
        v3.c cVar = this.f24548b;
        return cVar != null ? cVar.h(str) : com.jiao.project.bluetoothofabroadwasherapp.enums.d.STATUS_UNCONNECT;
    }

    public void k() {
        v3.c cVar = this.f24548b;
        if (cVar != null) {
            cVar.j(new c());
        }
    }

    public com.haier.globalwasher.modle.utils.phone_util.a l() {
        if (this.f24549c == null) {
            this.f24549c = new com.haier.globalwasher.modle.utils.phone_util.a();
        }
        return this.f24549c;
    }

    public void m() {
        v vVar = new v();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(this.f24547a.getResources().getString(R.string.cancel));
        arrayList.add(this.f24547a.getResources().getString(R.string.to_setting));
        q.c(this.f24555i, "权限权限权限权限权限权限权限权限权限权限权限权限1");
        BaseActivity baseActivity = this.f24547a;
        vVar.l(baseActivity, baseActivity.getResources().getString(R.string.pop_title), arrayList, null, new f());
    }

    public void n() {
        v vVar = new v();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(this.f24547a.getResources().getString(R.string.cancel));
        arrayList.add(this.f24547a.getResources().getString(R.string.to_setting));
        v.e eVar = vVar.new e();
        eVar.b(this.f24547a);
        q.c(this.f24555i, "权限权限权限权限权限权限权限权限权限权限权限权限");
        BaseActivity baseActivity = this.f24547a;
        vVar.l(baseActivity, baseActivity.getResources().getString(R.string.pop_title), arrayList, null, eVar);
    }

    public String o(@a1 int i7) {
        BaseActivity baseActivity = this.f24547a;
        return (baseActivity == null || baseActivity.getResources() == null) ? "" : this.f24547a.getResources().getString(i7);
    }

    public void p() {
        v3.c cVar = this.f24548b;
        if (cVar != null) {
            cVar.b().b();
        }
    }

    public void r(int i7, @m0 String[] strArr, @m0 int[] iArr) {
        if (i7 != 10001) {
            return;
        }
        try {
            if (iArr.length > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i8 = 0; i8 < iArr.length; i8++) {
                    if (v3.c.f40430a[0].matches(strArr[i8]) && iArr[i8] == 0) {
                        g gVar = this.f24552f;
                        if (gVar != null) {
                            g(gVar);
                            return;
                        }
                        return;
                    }
                    arrayList.add(strArr[i8]);
                }
                g gVar2 = this.f24552f;
                if (gVar2 != null) {
                    gVar2.e(true);
                }
            }
        } catch (Exception e8) {
            e8.printStackTrace();
        }
    }

    public void s() {
        int[] iArrF = e0.f();
        if (iArrF.length >= 1 && iArrF[0] >= 10) {
            if (this.f24550d != null) {
                this.f24547a.getContentResolver().unregisterContentObserver(this.f24550d);
            }
            i iVar = this.f24553g;
            if (iVar != null) {
                this.f24547a.unregisterReceiver(iVar);
            }
        }
        k();
    }

    public void t() {
        v3.c cVar = this.f24548b;
        if (cVar != null) {
            cVar.j(null);
        }
    }

    public void u(g gVar) {
        if (this.f24548b == null) {
            gVar.e(true);
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 31) {
            arrayList.add("android.permission.BLUETOOTH_CONNECT");
            arrayList.add("android.permission.BLUETOOTH_SCAN");
            arrayList.add("android.permission.BLUETOOTH_ADVERTISE");
        } else {
            arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
            arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        }
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        Map<String, Integer> mapC = com.haier.globalwasher.modle.a.c(this.f24547a, strArr);
        boolean zA = false;
        if (mapC.size() > 0) {
            boolean zM = true;
            for (String str : mapC.keySet()) {
                if (!zA) {
                    zA = u2.a.a(str);
                }
                u2.a.f(str);
                if (zA && zM) {
                    zM = androidx.core.app.b.M(this.f24547a, str);
                }
            }
            q.c(SubscriptSuccessfulActivity.D, "isDenyAuthorization=" + zA);
            q.c(SubscriptSuccessfulActivity.D, "shouldShow=" + zM);
            if (zM) {
                com.haier.globalwasher.modle.a.d(this.f24547a, 1, strArr);
            } else {
                m();
            }
            gVar.e(true);
            return;
        }
        q.c(SubscriptSuccessfulActivity.D, "showLoading");
        this.f24548b.b().d();
        this.f24552f = gVar;
        gVar.e(false);
        if (!gVar.q() || gVar.f24565l == null) {
            q.c("OrderStatuManager", "checkBluetoothStatue ");
            g(gVar);
            return;
        }
        q.c(SubscriptSuccessfulActivity.D, "checkPhoneParamentInterface.iBluetoothBean.bluetoothType()=" + gVar.f24565l.bluetoothType());
        int iBluetoothType = gVar.f24565l.bluetoothType();
        if (iBluetoothType != 1) {
            if (iBluetoothType == 2) {
            }
            g(gVar);
        } else {
            this.f24548b.b().b();
            if (this.f24548b.c() != null && gVar.f24565l.getBluetoothMac().equals(((uSDKDevice) this.f24548b.c()).getDeviceId())) {
                gVar.d();
                return;
            }
        }
        if (i7 >= 31 && androidx.core.content.d.a(this.f24547a, "android.permission.BLUETOOTH_CONNECT") != 0) {
            this.f24548b.b().b();
            gVar.e(true);
            return;
        }
        q.c(SubscriptSuccessfulActivity.D, "CUSTOM");
        if (this.f24548b.c() != null && gVar.f24565l.getBluetoothMac().equals(((BluetoothDevice) this.f24548b.c()).getName())) {
            gVar.d();
            return;
        }
        g(gVar);
    }

    public void v(BaseActivity baseActivity, n2.a aVar) {
        aVar.e(true);
        z.f(baseActivity, baseActivity.getResources().getString(R.string.open_location_switch_popup_title), baseActivity.getResources().getString(R.string.open_location_switch_popup_content), baseActivity.getResources().getString(R.string.open_location_switch_popup_button_cancel), baseActivity.getResources().getString(R.string.open_location_switch_popup_right_away_start), new d(), new e(baseActivity));
    }
}
