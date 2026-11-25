package com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.os.Handler;
import android.os.ParcelUuid;
import android.util.Log;
import c.t0;
import com.alipay.sdk.widget.j;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import org.chromium.base.ThreadUtils;

/* JADX INFO: loaded from: classes2.dex */
@t0(api = 18)
public class c extends com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.a {
    static final int A = 1;
    static final int B = 2;
    static final int C = 3;
    static final int D = 4;
    static final int E = 5;
    public static final int F = 6;
    private static boolean G = false;
    private static boolean H = false;
    private static Context I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static boolean f32377J = false;
    private static String K = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f32378p = "00002902-0000-1000-8000-00805f9b34fb";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static c f32379q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f32380r = "CustomBluetoothUtil";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static String f32381s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static String f32382t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static String f32383u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static String f32384v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static BluetoothManager f32385w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static BluetoothAdapter f32386x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static long f32387y = 10000;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    static final int f32388z = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f32389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BluetoothGatt f32390b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Timer f32394f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private BluetoothGattCharacteristic f32395g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.d f32398j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f32399k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private BluetoothGattCharacteristic f32400l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f32401m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public BluetoothDevice f32403o;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f32391c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handler f32392d = new Handler();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f32393e = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Map<String, ScanResult> f32396h = new HashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<ScanResult> f32397i = new ArrayList();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final BluetoothGattCallback f32402n = new a();

    class a extends BluetoothGattCallback {

        /* JADX INFO: renamed from: com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.c$a$a, reason: collision with other inner class name */
        class RunnableC0388a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BluetoothGattCharacteristic f32405a;

            RunnableC0388a(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                this.f32405a = bluetoothGattCharacteristic;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f32405a == null) {
                    c.this.f32398j.c(null);
                } else {
                    c.this.f32398j.c(this.f32405a.getValue());
                }
            }
        }

        a() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            com.haier.hailicommontlib.mvp.model.utils.b.c("CustomBluetoothUtil", "onCharacteristicChanged  收到ble返回数据");
            if (c.this.f32398j == null || bluetoothGattCharacteristic == null) {
                return;
            }
            c.this.f32398j.d(bluetoothGattCharacteristic.getValue());
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i7) {
            com.haier.hailicommontlib.mvp.model.utils.b.c("CustomBluetoothUtil", "onCharacteristicChanged  2  收到ble返回数据");
            super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i7);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i7) {
            com.haier.hailicommontlib.mvp.model.utils.b.c("CustomBluetoothUtil", "onCharacteristicWrite  写入数据成功回调");
            if (c.this.f32398j != null) {
                ThreadUtils.k(new RunnableC0388a(bluetoothGattCharacteristic));
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i7, int i8) {
            com.haier.hailicommontlib.mvp.model.utils.b.c("CustomBluetoothUtil", "onConnectionStateChange。status=" + i7);
            if (i7 == 0) {
                if (i8 == 2) {
                    bluetoothGatt.requestMtu(128);
                    return;
                } else {
                    if (i8 == 0) {
                        c.this.G();
                        return;
                    }
                    return;
                }
            }
            Log.d("CustomBluetoothUtil", "onConnectionStateChange received: " + i7);
            c.this.a();
            c cVar = c.this;
            cVar.c(cVar.f32389a);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i7, int i8) {
            super.onMtuChanged(bluetoothGatt, i7, i8);
            com.haier.hailicommontlib.mvp.model.utils.b.c("CustomBluetoothUtil", "onMtuChanged。status=" + i8 + "  mtu=" + i7);
            c.this.F(bluetoothGatt);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i7) {
            com.haier.hailicommontlib.mvp.model.utils.b.c("CustomBluetoothUtil", "onServicesDiscovered。status=" + i7);
            if (i7 != 0) {
                com.haier.hailicommontlib.mvp.model.utils.b.c("CustomBluetoothUtil", "error.status=" + i7);
                return;
            }
            com.haier.hailicommontlib.mvp.model.utils.b.c("CustomBluetoothUtil", "success.status=" + i7);
            c.this.B(1, c.f32384v, c.f32384v);
        }
    }

    class b extends TimerTask {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                cVar.c(cVar.f32389a);
            }
        }

        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (!c.H) {
                c.this.I(5);
                com.haier.hailicommontlib.mvp.model.utils.b.a("CustomBluetoothUtil", "run : 正在尝试重连");
                ThreadUtils.k(new a());
            } else if (c.this.f32394f != null) {
                c.this.f32394f.cancel();
                c.this.f32394f = null;
            }
        }
    }

    /* JADX INFO: renamed from: com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.c$c, reason: collision with other inner class name */
    class RunnableC0389c implements Runnable {

        /* JADX INFO: renamed from: com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.c$c$a */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.K();
            }
        }

        RunnableC0389c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f32391c = false;
            c.f32386x.getBluetoothLeScanner().stopScan(c.this);
            ThreadUtils.k(new a());
            Log.d("CustomBluetoothUtil", "停止扫描");
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f32411a;

        d(int i7) {
            this.f32411a = i7;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.J(this.f32411a);
        }
    }

    private c(Context context) {
        I = context;
    }

    @t0(api = 21)
    public static c E(Context context, String str, String str2, String str3, String str4) {
        if (f32379q == null) {
            I = context;
            f32379q = new c(context);
            f32381s = str;
            f32382t = str2;
            f32383u = str3;
            f32384v = str4;
            if (!I.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
                Log.d("CustomBluetoothUtil", "该设备不支持ble");
                return null;
            }
            if (f32385w == null) {
                f32385w = (BluetoothManager) I.getSystemService("bluetooth");
            }
            f32386x = f32385w.getAdapter();
        }
        return f32379q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(BluetoothGatt bluetoothGatt) {
        bluetoothGatt.discoverServices();
        H = true;
        I(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        H = false;
        I(0);
        if (f32377J) {
            h();
        }
        if (!G || H) {
            return;
        }
        if (this.f32394f == null) {
            this.f32394f = new Timer();
        }
        this.f32394f.schedule(new b(), 20L, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i7) {
        ThreadUtils.k(new d(i7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(int i7) {
        this.f32393e = i7;
        com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.d dVar = this.f32398j;
        if (dVar != null) {
            dVar.e(i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        J(2);
    }

    public void B(int i7, String str, String str2) {
        com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.d dVar;
        String str3 = f32381s;
        if (str3 == null || str2 == null || str == null) {
            return;
        }
        BluetoothGattService service = this.f32390b.getService(UUID.fromString(str3));
        if (service == null) {
            com.haier.hailicommontlib.mvp.model.utils.b.c("CustomBluetoothUtil", "服务特征未找到");
            return;
        }
        com.haier.hailicommontlib.mvp.model.utils.b.c("CustomBluetoothUtil", "type=" + service.getType() + "");
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(UUID.fromString(str2));
        this.f32400l = characteristic;
        if (characteristic == null) {
            com.haier.hailicommontlib.mvp.model.utils.b.c("CustomBluetoothUtil", "通知特征未找到");
            return;
        }
        this.f32390b.setCharacteristicNotification(characteristic, true);
        if (this.f32400l.getDescriptor(UUID.fromString("00002902-0000-1000-8000-00805f9b34fb")) == null) {
            BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(UUID.fromString("00002902-0000-1000-8000-00805f9b34fb"), 16);
            bluetoothGattDescriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
            this.f32390b.writeDescriptor(bluetoothGattDescriptor);
        }
        BluetoothGattCharacteristic characteristic2 = service.getCharacteristic(UUID.fromString(str));
        this.f32395g = characteristic2;
        if (this.f32400l == null || characteristic2 == null || (dVar = this.f32398j) == null) {
            return;
        }
        dVar.a(i7);
    }

    public BluetoothDevice C() {
        BluetoothGatt bluetoothGatt = this.f32390b;
        if (bluetoothGatt != null) {
            return bluetoothGatt.getDevice();
        }
        return null;
    }

    public int D() {
        BluetoothDevice bluetoothDevice;
        BluetoothManager bluetoothManager = f32385w;
        if (bluetoothManager == null || (bluetoothDevice = this.f32403o) == null) {
            return 0;
        }
        return bluetoothManager.getConnectionState(bluetoothDevice, 7);
    }

    public void H() {
        if (f32386x != null) {
            f32386x = f32385w.getAdapter();
        }
    }

    @Override // com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.a
    public void a() {
        G = false;
        H = false;
        if (this.f32394f != null) {
            Log.d("CustomBluetoothUtil", "close : 应用销毁 停止计时器");
            this.f32394f.cancel();
            this.f32394f = null;
        }
        BluetoothGatt bluetoothGatt = this.f32390b;
        if (bluetoothGatt == null) {
            return;
        }
        bluetoothGatt.close();
        this.f32390b = null;
    }

    @Override // com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.a
    public c b(boolean z7) {
        f32377J = z7;
        return f32379q;
    }

    @Override // com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.a
    public boolean c(String str) {
        BluetoothGatt bluetoothGatt;
        if (f32386x == null || str == null) {
            return false;
        }
        m();
        J(3);
        if (str.equals(this.f32389a) && (bluetoothGatt = this.f32390b) != null) {
            try {
                return bluetoothGatt.connect();
            } catch (Exception e8) {
                com.haier.hailicommontlib.mvp.model.utils.b.c("CustomBluetoothUtil", "BluetoothBLeClass连接发生异常" + e8.toString());
                BluetoothGatt bluetoothGattConnectGatt = this.f32403o.connectGatt(I, false, this.f32402n);
                this.f32390b = bluetoothGattConnectGatt;
                bluetoothGattConnectGatt.connect();
            }
        }
        BluetoothDevice remoteDevice = f32386x.getRemoteDevice(str);
        this.f32403o = remoteDevice;
        if (remoteDevice == null) {
            return false;
        }
        this.f32390b = remoteDevice.connectGatt(I, false, this.f32402n);
        this.f32389a = str;
        return true;
    }

    @Override // com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.a
    public void d() {
        BluetoothGatt bluetoothGatt;
        if (f32386x == null || (bluetoothGatt = this.f32390b) == null) {
            return;
        }
        bluetoothGatt.disconnect();
    }

    @Override // com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.a
    public int e() {
        return this.f32393e;
    }

    @Override // com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.a
    public void f(com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.d dVar) {
        this.f32398j = dVar;
    }

    @Override // com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.a
    public boolean g() {
        return f32386x.isEnabled();
    }

    @Override // com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.a
    public boolean h() {
        BluetoothGatt bluetoothGatt = this.f32390b;
        if (bluetoothGatt != null) {
            try {
                Method method = bluetoothGatt.getClass().getMethod(j.f13873s, new Class[0]);
                if (method != null) {
                    return ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue();
                }
            } catch (Exception e8) {
                Log.i("CustomBluetoothUtil", "Exception localException:" + e8.getMessage());
            }
        }
        return false;
    }

    @Override // com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.a
    public c i(boolean z7) {
        G = z7;
        return f32379q;
    }

    @Override // com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.a
    public c j(String str) {
        K = str;
        return f32379q;
    }

    @Override // com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.a
    public c k(int i7) {
        f32387y = i7;
        return f32379q;
    }

    @Override // com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.a
    public void l(boolean z7) {
        Log.d("CustomBluetoothUtil", "startScanDevices");
        if (!z7) {
            f32386x.getBluetoothLeScanner().stopScan(this);
            this.f32392d.removeCallbacksAndMessages(null);
            this.f32391c = false;
            K();
            return;
        }
        this.f32396h.clear();
        m();
        this.f32392d.postDelayed(new RunnableC0389c(), f32387y);
        this.f32391c = true;
        BluetoothLeScanner bluetoothLeScanner = f32386x.getBluetoothLeScanner();
        ScanSettings scanSettingsBuild = new ScanSettings.Builder().setScanMode(0).build();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ScanFilter.Builder().setServiceUuid(ParcelUuid.fromString(f32381s)).build());
        bluetoothLeScanner.startScan(arrayList, scanSettingsBuild, this);
        J(1);
    }

    @Override // com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.a
    public void m() {
        d();
        if (this.f32391c) {
            BluetoothAdapter bluetoothAdapter = f32386x;
            if (bluetoothAdapter != null && bluetoothAdapter.getBluetoothLeScanner() != null) {
                f32386x.getBluetoothLeScanner().stopScan(this);
                f32386x.cancelDiscovery();
            }
            this.f32391c = false;
            K();
            this.f32392d.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.a
    public boolean n(int i7, byte[] bArr) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic;
        Log.d("CustomBluetoothUtil", "writeCharacteristic");
        if (bArr == null || (bluetoothGattCharacteristic = this.f32395g) == null || this.f32390b == null) {
            Log.d("CustomBluetoothUtil", "不满足写数据条件,写入失败");
            return false;
        }
        if (i7 == 1) {
            bluetoothGattCharacteristic.setWriteType(1);
        }
        this.f32395g.setValue(bArr);
        return this.f32390b.writeCharacteristic(this.f32395g);
    }

    @Override // android.bluetooth.le.ScanCallback
    public void onScanResult(int i7, ScanResult scanResult) {
        com.haier.hailicommontlib.mvp.model.utils.b.c("CustomBluetoothUtil", "onScanResult=" + i7);
        this.f32396h.put(scanResult.getDevice().getAddress(), scanResult);
        Iterator<Map.Entry<String, ScanResult>> it = this.f32396h.entrySet().iterator();
        this.f32397i.clear();
        while (it.hasNext()) {
            this.f32397i.add(it.next().getValue());
        }
        com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle.d dVar = this.f32398j;
        if (dVar != null) {
            dVar.b(this.f32397i);
        }
    }
}
