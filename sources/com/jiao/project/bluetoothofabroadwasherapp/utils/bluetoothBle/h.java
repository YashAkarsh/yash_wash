package com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import c.t0;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements v3.c {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static h f32413n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static boolean f32414o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f32415p = "CustomBluetoothUtil";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.c f32416q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static long f32417r;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f32418b = "0000FE63-0000-1000-8000-00805F9B34FB";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f32419c = "0000FE60-0000-1000-8000-00805F9B34FB";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f32420d = "0000FE61-0000-1000-8000-00805F9B34FB";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f32421e = "0000FE62-0000-1000-8000-00805F9B34FB";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public com.haier.hailicommontlib.mvp.model.utils.loading.a f32422f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f32423g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Activity f32424h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private c f32425i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.jiao.project.bluetoothofabroadwasherapp.enums.c f32426j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    t3.a f32427k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    BlueToothStateReceiver f32428l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private b f32429m;

    class a implements BlueToothStateReceiver.a {
        a() {
        }

        @Override // com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.BlueToothStateReceiver.a
        public void a() {
        }

        @Override // com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.BlueToothStateReceiver.a
        public void b() {
        }

        @Override // com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.BlueToothStateReceiver.a
        public void c() {
            try {
                h.f32416q.H();
                com.haier.hailicommontlib.mvp.model.utils.loading.a aVar = h.this.f32422f;
                if (aVar != null) {
                    aVar.b();
                }
            } catch (Exception unused) {
            }
        }

        @Override // com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.BlueToothStateReceiver.a
        @t0(api = 21)
        public void d() {
            com.haier.hailicommontlib.mvp.model.utils.loading.a aVar = h.this.f32422f;
            if (aVar != null) {
                aVar.b();
                h.this.f32422f = null;
            }
            h.this.j(null);
        }
    }

    public static class b extends Handler {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f32431c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f32432d = 3;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f32433e = "TOAST_CONTENT";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f32434f = 6;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f32435g = 7;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WeakReference<h> f32436a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f32437b = 5;

        public b(h hVar) {
            this.f32436a = new WeakReference<>(hVar);
        }

        public void a(String str) {
            Message message = new Message();
            message.what = 2;
            Bundle bundle = new Bundle();
            bundle.putString(f32433e, str);
            message.setData(bundle);
            sendMessage(message);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.f32436a.get() == null) {
                return;
            }
            int i7 = message.what;
            if (i7 == 3) {
                if (this.f32436a.get().f32422f != null) {
                    this.f32436a.get().f32422f.d();
                }
                this.f32437b = 5;
                sendEmptyMessageDelayed(7, 1000L);
                return;
            }
            if (i7 == 6) {
                if (this.f32436a.get().f32427k != null) {
                    this.f32436a.get().f32427k.i(com.jiao.project.bluetoothofabroadwasherapp.enums.a.DATA_RESULT_SUCCESS);
                }
                removeMessages(7);
                removeMessages(3);
                return;
            }
            if (i7 != 7) {
                return;
            }
            int i8 = this.f32437b;
            if (i8 > 0) {
                this.f32437b = i8 - 1;
                sendEmptyMessageDelayed(7, 1000L);
                return;
            }
            if (this.f32436a.get().f32422f != null) {
                this.f32436a.get().f32422f.b();
            }
            if (this.f32436a.get().f32427k != null) {
                this.f32436a.get().f32427k.i(com.jiao.project.bluetoothofabroadwasherapp.enums.a.NOT_RESULT_FAIL);
            }
            this.f32436a.get().u();
        }
    }

    private class c implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakReference<Context> f32438a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private SoftReference<h> f32439b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List<ScanResult> f32440c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private byte[] f32442e;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f32441d = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final byte[] f32443f = {0, com.haier.hailicommontlib.mvp.model.utils.c.l(160), 0};

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f32445a;

            a(int i7) {
                this.f32445a = i7;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e8) {
                    e8.printStackTrace();
                }
                int i7 = this.f32445a;
                if (i7 == 1) {
                    h.this.p();
                    return;
                }
                if (i7 == 2) {
                    c.this.f32441d = 6;
                    h hVar = h.this;
                    t3.a aVar = hVar.f32427k;
                    if (aVar != null) {
                        aVar.b(hVar.c());
                    }
                }
            }
        }

        public c(Context context, h hVar) {
            this.f32438a = new WeakReference<>(context);
            this.f32439b = new SoftReference<>(hVar);
        }

        private void j(byte[] bArr) {
            if (bArr.length > 3) {
                if (this.f32443f[2] == bArr[2] && bArr.length == 19) {
                    byte[] bytes = h.this.f32423g.getBytes();
                    byte[] bArr2 = new byte[16];
                    System.arraycopy(bArr, 3, bArr2, 0, 16);
                    h.this.v(bArr2, bytes);
                    return;
                }
                return;
            }
            if (bArr.length == 3) {
                if (this.f32443f[2] != bArr[2]) {
                    h.this.f32427k.h();
                    return;
                }
                com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.c cVar = h.f32416q;
                if (cVar != null) {
                    cVar.B(2, h.this.f32420d, h.this.f32421e);
                }
            }
        }

        @Override // com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.d
        public void a(int i7) {
            com.haier.hailicommontlib.mvp.model.utils.b.c("CustomBluetoothUtil", "onSuccessOfConnentService   通道类型=" + i7);
            new Thread(new a(i7)).start();
        }

        @Override // com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.d
        public void b(List<ScanResult> list) {
            com.haier.hailicommontlib.mvp.model.utils.b.c("CustomBluetoothUtil", "onBleScanResult");
            this.f32440c = list;
            t3.a aVar = h.this.f32427k;
            if (aVar != null) {
                aVar.j(list);
            }
        }

        @Override // com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.d
        @t0(api = 26)
        public void c(byte[] bArr) {
            com.haier.hailicommontlib.mvp.model.utils.b.c("CustomBluetoothUtil", "onWriteDataSucceed  设备接受到命令" + com.haier.hailicommontlib.mvp.model.utils.h.r(bArr));
            if (this.f32439b.get().f32429m == null) {
                this.f32439b.get().f32429m = new b(this.f32439b.get());
            }
            this.f32439b.get().f32429m.sendEmptyMessage(3);
        }

        @Override // com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.d
        public void d(byte[] bArr) {
            com.haier.hailicommontlib.mvp.model.utils.b.c("CustomBluetoothUtil", "onBleWriteResult  设备返回信息" + com.haier.hailicommontlib.mvp.model.utils.h.r(bArr));
            if (this.f32439b.get().f32429m == null) {
                this.f32439b.get().f32429m = new b(this.f32439b.get());
            }
            this.f32439b.get().f32429m.sendEmptyMessage(6);
            if (this.f32439b.get().f32422f != null) {
                this.f32439b.get().f32422f.b();
            }
            byte[] bArr2 = this.f32443f;
            if (bArr2[0] == bArr[0] && bArr2[1] == bArr[1]) {
                j(bArr);
                return;
            }
            if (i(bArr) && h.this.f32427k != null) {
                if (!com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.b.a(this.f32442e)) {
                    h.this.f32427k.i(com.jiao.project.bluetoothofabroadwasherapp.enums.a.FAIL_BLUETOOTH);
                    return;
                }
                com.haier.hailicommontlib.mvp.model.utils.b.c("CustomBluetoothUtil", "onBleWriteResult  设备返回信息" + com.haier.hailicommontlib.mvp.model.utils.h.r(this.f32442e));
                h.this.f32427k.l(f.a(this.f32442e));
            }
        }

        @Override // com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.d
        public void e(int i7) {
            com.haier.hailicommontlib.mvp.model.utils.b.c("CustomBluetoothUtil", "onCurrentState.state=" + i7);
            this.f32441d = i7;
            if (i7 == 0) {
                h.f32414o = false;
                com.haier.hailicommontlib.mvp.model.utils.b.c("CustomBluetoothUtil", "蓝牙连接断开");
                if (this.f32439b.get().f32422f != null) {
                    this.f32439b.get().f32422f.b();
                }
                if (this.f32439b.get().f32427k != null) {
                    this.f32439b.get().f32427k.i(com.jiao.project.bluetoothofabroadwasherapp.enums.a.DISCONNET_FAIL);
                    return;
                }
                return;
            }
            if (i7 == 1) {
                if (this.f32439b.get().f32422f != null) {
                    this.f32439b.get().f32422f.d();
                }
                if (this.f32439b.get().f32427k != null) {
                    this.f32439b.get().f32427k.i(com.jiao.project.bluetoothofabroadwasherapp.enums.a.SEARCH);
                }
                com.haier.hailicommontlib.mvp.model.utils.b.c("CustomBluetoothUtil", "蓝牙扫描中");
                return;
            }
            if (i7 == 2) {
                com.haier.hailicommontlib.mvp.model.utils.b.c("CustomBluetoothUtil", "蓝牙扫描结束");
                if (this.f32439b.get().f32422f != null) {
                    this.f32439b.get().f32422f.b();
                }
                if (this.f32439b.get().f32427k != null) {
                    List<ScanResult> list = this.f32440c;
                    if (list == null || list.size() == 0) {
                        com.haier.hailicommontlib.mvp.model.utils.b.c("CustomBluetoothUtil", "未搜索到设备");
                        this.f32439b.get().f32427k.i(com.jiao.project.bluetoothofabroadwasherapp.enums.a.NOT_THIS_ADDRESS_FAIL);
                        return;
                    } else {
                        com.haier.hailicommontlib.mvp.model.utils.b.c("CustomBluetoothUtil", "扫描结束");
                        this.f32439b.get().f32427k.i(com.jiao.project.bluetoothofabroadwasherapp.enums.a.SEARCH_END);
                        return;
                    }
                }
                return;
            }
            if (i7 == 3) {
                if (this.f32439b.get().f32422f != null) {
                    this.f32439b.get().f32422f.d();
                }
                com.haier.hailicommontlib.mvp.model.utils.b.c("CustomBluetoothUtil", "设备正在连接");
            } else {
                if (i7 != 4) {
                    if (i7 != 5) {
                        return;
                    }
                    if (this.f32439b.get().f32422f != null) {
                        this.f32439b.get().f32422f.d();
                    }
                    com.haier.hailicommontlib.mvp.model.utils.b.c("CustomBluetoothUtil", "蓝牙尝试重连");
                    return;
                }
                com.haier.hailicommontlib.mvp.model.utils.b.c("CustomBluetoothUtil", "蓝牙连接");
                if (this.f32439b.get().f32422f != null) {
                    this.f32439b.get().f32422f.d();
                }
                if (this.f32439b.get().f32427k != null) {
                    this.f32439b.get().f32427k.i(com.jiao.project.bluetoothofabroadwasherapp.enums.a.CONNECTION_SUCCESS);
                }
            }
        }

        public int g() {
            return this.f32441d;
        }

        public boolean h(byte[] bArr, byte[] bArr2) {
            int i7 = 0;
            for (int i8 = 2; i8 < bArr2.length; i8++) {
                if (bArr2[i8] == 85) {
                    i7++;
                }
            }
            this.f32442e = bArr;
            return com.haier.hailicommontlib.mvp.model.utils.c.e(bArr2[2]) == (bArr2.length - i7) + (-3);
        }

        public boolean i(byte[] bArr) {
            byte[] bArr2 = this.f32442e;
            if (bArr2 == null) {
                return h(bArr, bArr);
            }
            byte[] bArr3 = new byte[bArr2.length + bArr.length];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
            System.arraycopy(bArr, 0, bArr3, this.f32442e.length, bArr.length);
            return h(bArr3, bArr);
        }
    }

    private h(Activity activity) {
        this.f32424h = activity;
        b();
    }

    public static h r(Activity activity) {
        SoftReference softReference = new SoftReference(activity);
        if (f32413n == null) {
            f32413n = new h((Activity) softReference.get());
        }
        return f32413n;
    }

    public static boolean s() {
        return r3.a.f40143b.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    @Override // v3.c
    public boolean a(String str) {
        com.haier.hailicommontlib.mvp.model.utils.b.c("CustomBluetoothUtil", com.google.common.net.c.f22160o);
        com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.c cVar = f32416q;
        if (cVar != null) {
            return cVar.c(str);
        }
        return false;
    }

    @Override // v3.c
    public com.haier.hailicommontlib.mvp.model.utils.loading.a b() {
        com.haier.hailicommontlib.mvp.model.utils.loading.a aVar = this.f32422f;
        if (aVar == null || this.f32424h != aVar.a()) {
            com.haier.hailicommontlib.mvp.model.utils.loading.a aVar2 = this.f32422f;
            if (aVar2 != null) {
                aVar2.b();
            }
            this.f32422f = new com.haier.hailicommontlib.mvp.model.utils.loading.a(this.f32424h, 1, false);
        }
        return this.f32422f;
    }

    @Override // v3.c
    public void d() {
        com.haier.hailicommontlib.mvp.model.utils.b.c("CustomBluetoothUtil", "stopScanDevices");
        com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.c cVar = f32416q;
        if (cVar != null) {
            cVar.m();
        }
    }

    @Override // v3.c
    public void e(String str, String str2, v3.a aVar) {
        this.f32426j = com.jiao.project.bluetoothofabroadwasherapp.enums.c.START_COMMAND;
        x(2, com.haier.hailicommontlib.mvp.model.utils.h.n(str2));
    }

    @Override // v3.c
    @t0(api = 21)
    public void f(Activity activity, v3.b bVar, t3.b bVar2) {
        this.f32424h = activity;
        this.f32427k = (t3.a) bVar2;
        this.f32423g = ((w3.a) bVar).a();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j7 = f32417r;
        if (jCurrentTimeMillis - j7 <= 0 || jCurrentTimeMillis - j7 >= com.haier.uhome.ble.hal.a.b.a.f28246a) {
            b();
            this.f32422f.d();
            com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.c cVarB = com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.c.E(activity, this.f32419c, this.f32421e, this.f32420d, this.f32418b).k(com.haier.library.sumhttp.plugin.h.f27948e).i(false).b(false);
            f32416q = cVarB;
            if (cVarB == null) {
                this.f32427k.i(com.jiao.project.bluetoothofabroadwasherapp.enums.a.OTHER_FAIL);
                return;
            }
            if (!cVarB.g()) {
                Intent intent = new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE");
                if (activity != null) {
                    activity.startActivityForResult(intent, s3.c.f40326a);
                    return;
                }
                return;
            }
            if (new com.jiao.project.bluetoothofabroadwasherapp.utils.a().b(activity, 1000, "android.permission.ACCESS_COARSE_LOCATION")) {
                return;
            }
            c cVar = new c(activity, this);
            this.f32425i = cVar;
            f32416q.f(cVar);
            f32416q.l(true);
        }
    }

    @Override // v3.c
    public void g(String str, v3.a aVar) {
        this.f32426j = com.jiao.project.bluetoothofabroadwasherapp.enums.c.END_COMMAND;
        com.jiao.project.bluetoothofabroadwasherapp.enums.b bVar = com.jiao.project.bluetoothofabroadwasherapp.enums.b.RERSET;
        byte[] bArrB = com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.b.b(bVar.b(), bVar.d());
        com.haier.hailicommontlib.mvp.model.utils.b.a("CustomBluetoothUtil", com.haier.hailicommontlib.mvp.model.utils.h.r(bArrB));
        x(2, bArrB);
    }

    @Override // v3.c
    public com.jiao.project.bluetoothofabroadwasherapp.enums.d h(String str) {
        int iD = f32416q.D();
        if (iD != 0) {
            if (iD == 1) {
                return com.jiao.project.bluetoothofabroadwasherapp.enums.d.STATUS_CONNECTING;
            }
            if (iD == 2) {
                c cVar = this.f32425i;
                return (cVar == null || cVar.g() != 6) ? com.jiao.project.bluetoothofabroadwasherapp.enums.d.STATUS_CONNECTING : com.jiao.project.bluetoothofabroadwasherapp.enums.d.STATUS_READY;
            }
            if (iD != 3) {
                return null;
            }
        }
        return com.jiao.project.bluetoothofabroadwasherapp.enums.d.STATUS_UNCONNECT;
    }

    @Override // v3.c
    public void i() {
        com.haier.hailicommontlib.mvp.model.utils.loading.a aVar = this.f32422f;
        if (aVar != null) {
            aVar.b();
            this.f32422f = null;
            this.f32424h = null;
        }
    }

    @Override // v3.c
    public <Void> void j(Void r7) {
        com.haier.hailicommontlib.mvp.model.utils.b.c("CustomBluetoothUtil", "stopConnection");
        com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.c cVar = f32416q;
        if (cVar != null) {
            cVar.m();
            f32416q.a();
        }
    }

    public void p() {
        x(1, com.haier.hailicommontlib.mvp.model.utils.c.k(new int[]{0, 160}));
    }

    @Override // v3.c
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public BluetoothDevice c() {
        com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.c cVar = f32416q;
        if (cVar != null) {
            return cVar.C();
        }
        return null;
    }

    public void t(Context context) {
        this.f32428l = new BlueToothStateReceiver();
        IntentFilter intentFilter = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        if (Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(this.f32428l, intentFilter, 4);
        } else {
            context.registerReceiver(this.f32428l, intentFilter);
        }
        this.f32428l.a(new a());
    }

    public void u() {
        j(null);
    }

    public void v(byte[] bArr, byte[] bArr2) {
        try {
            byte[] bArrB = s3.a.b(bArr, bArr2);
            byte[] bArr3 = new byte[18];
            bArr3[0] = 0;
            bArr3[1] = com.haier.hailicommontlib.mvp.model.utils.c.l(160);
            if (bArrB == null) {
                return;
            }
            System.arraycopy(bArrB, 0, bArr3, 2, 16);
            x(1, bArr3);
        } catch (Exception e8) {
            e8.printStackTrace();
        }
    }

    public void w(Context context) {
        BlueToothStateReceiver blueToothStateReceiver = this.f32428l;
        if (blueToothStateReceiver != null) {
            context.unregisterReceiver(blueToothStateReceiver);
        }
    }

    public void x(int i7, byte[] bArr) {
        com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.c cVar = f32416q;
        if (cVar != null) {
            cVar.n(i7, bArr);
        }
    }
}
