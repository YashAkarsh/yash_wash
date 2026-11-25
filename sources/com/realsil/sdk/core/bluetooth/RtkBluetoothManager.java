package com.realsil.sdk.core.bluetooth;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import b4.d;
import com.haier.uhome.mesh.bridge.RtkCoreMeshWrapper;
import d4.h;
import f4.c;
import f4.f;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import k4.b;

/* JADX INFO: loaded from: classes2.dex */
public class RtkBluetoothManager {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static RtkBluetoothManager f33140m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f33141n = 255;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f33142o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f33143p = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f33144q = 4;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f33145r = "android.bluetooth.device.extra.REASON";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f33146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f33147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<h> f33148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BluetoothManager f33149d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BluetoothAdapter f33150e;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Handler f33156k;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BluetoothBroadcastReceiver f33151f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f33152g = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f33153h = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f33154i = 255;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f33155j = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Runnable f33157l = new a();

    public class BluetoothBroadcastReceiver extends BroadcastReceiver {
        public BluetoothBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        @TargetApi(19)
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            action.hashCode();
            switch (action) {
                case "android.bluetooth.adapter.action.STATE_CHANGED":
                    RtkBluetoothManager.this.o(intent);
                    break;
                case "android.bluetooth.device.action.PAIRING_REQUEST":
                    RtkBluetoothManager.this.r(intent);
                    break;
                case "android.bluetooth.adapter.action.BLE_ACL_CONNECTED":
                    RtkBluetoothManager.this.a(intent);
                    break;
                case "android.bluetooth.adapter.action.BLE_ACL_DISCONNECTED":
                    RtkBluetoothManager.this.g(intent);
                    break;
                case "android.bluetooth.device.action.BOND_STATE_CHANGED":
                    RtkBluetoothManager.this.i(intent);
                    break;
                default:
                    b.e("action:" + action);
                    break;
            }
        }
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.e("scan delay time reached");
            RtkBluetoothManager.this.k();
        }
    }

    public RtkBluetoothManager(Context context) {
        this.f33146a = false;
        this.f33147b = context.getApplicationContext();
        this.f33146a = d.f11317b;
        c();
    }

    public static RtkBluetoothManager u() {
        return f33140m;
    }

    public static void v(Context context) {
        if (f33140m == null) {
            synchronized (RtkBluetoothManager.class) {
                if (f33140m == null) {
                    f33140m = new RtkBluetoothManager(context);
                }
            }
        }
    }

    public boolean A() {
        k();
        F();
        BluetoothAdapter bluetoothAdapter = this.f33150e;
        if (bluetoothAdapter == null) {
            b.s("BT is not initialized");
            return false;
        }
        if (!bluetoothAdapter.isEnabled()) {
            return t();
        }
        this.f33155j = true;
        if (this.f33146a) {
            b.p("isNeedAutoEnableBt=" + this.f33155j);
        }
        q();
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e8) {
            e8.printStackTrace();
        }
        if (this.f33150e.isEnabled()) {
            if (this.f33146a) {
                b.e("BT already enabled");
            }
            return true;
        }
        boolean zT = t();
        if (this.f33146a) {
            b.e("enableBT: " + zT);
        }
        return zT;
    }

    public void B(boolean z7) {
    }

    public boolean C(int i7, int i8) {
        if (i7 == 20 || i7 == 21) {
            b.e("SCAN_MODE_NONE or SCAN_MODE_CONNECTABLE");
            return c.b(this.f33150e, i7, 0);
        }
        if (i7 != 23) {
            return true;
        }
        b.e("SCAN_MODE_CONNECTABLE_DISCOVERABLE");
        return c.b(this.f33150e, i7, i8);
    }

    public boolean D(int i7) {
        return E(i7, null);
    }

    public boolean E(int i7, String str) {
        Handler handler = this.f33156k;
        if (handler != null) {
            handler.removeCallbacks(this.f33157l);
        }
        BluetoothAdapter bluetoothAdapter = this.f33150e;
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            b.s("bluetooth is not supported or disabled");
            return false;
        }
        if (this.f33150e.isDiscovering()) {
            this.f33150e.cancelDiscovery();
        }
        if (this.f33146a) {
            b.e("address=" + str + " , timeout=" + i7);
        }
        Handler handler2 = this.f33156k;
        if (handler2 != null) {
            handler2.postDelayed(this.f33157l, i7 * 1000);
        }
        this.f33150e.startDiscovery();
        return true;
    }

    public boolean F() {
        BluetoothAdapter bluetoothAdapter = this.f33150e;
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            b.s("bluetooth is not enabled");
            return false;
        }
        Set<BluetoothDevice> bondedDevices = this.f33150e.getBondedDevices();
        if (bondedDevices == null || bondedDevices.size() <= 0) {
            b.e("no bond device exist");
            return true;
        }
        for (BluetoothDevice bluetoothDevice : bondedDevices) {
            for (int i7 = 0; i7 < 10; i7++) {
                int bondState = bluetoothDevice.getBondState();
                if (bondState == 10) {
                    b.e("already unbond: " + bluetoothDevice.getName());
                    break;
                }
                if (bondState == 11) {
                    boolean zA = f.a(bluetoothDevice);
                    if (this.f33146a) {
                        b.p(String.format(Locale.US, "cancelBondProcess(%d): %s/%s, ret=%b", Integer.valueOf(i7), bluetoothDevice.getName(), bluetoothDevice.getAddress(), Boolean.valueOf(zA)));
                    }
                    if (zA) {
                        break;
                    }
                } else {
                    if (bondState == 12) {
                        boolean zH = f.h(bluetoothDevice);
                        if (this.f33146a) {
                            b.p(String.format(Locale.US, "removeBond(%d): %s/%s, ret=%b", Integer.valueOf(i7), bluetoothDevice.getName(), bluetoothDevice.getAddress(), Boolean.valueOf(zH)));
                        }
                        if (zH) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return true;
    }

    public boolean G(byte[] bArr) {
        BluetoothAdapter bluetoothAdapter = this.f33150e;
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            if (!this.f33146a) {
                return false;
            }
            b.e("bluetooth is not enabled");
            return false;
        }
        String strB = d4.a.b(bArr);
        if (this.f33146a) {
            b.e("unBondDevice: " + strB);
        }
        Set<BluetoothDevice> bondedDevices = this.f33150e.getBondedDevices();
        if (bondedDevices == null || bondedDevices.size() <= 0) {
            return true;
        }
        for (BluetoothDevice bluetoothDevice : bondedDevices) {
            if (this.f33146a) {
                b.e("unBondDevice(): before " + bluetoothDevice.getName() + " mac= " + bluetoothDevice.getAddress());
            }
            if (strB.compareToIgnoreCase(bluetoothDevice.getAddress()) == 0) {
                while (true) {
                    int bondState = bluetoothDevice.getBondState();
                    if (bondState == 10) {
                        b.e("removeBond finished");
                        return true;
                    }
                    if (bondState == 11) {
                        f.a(bluetoothDevice);
                    }
                    f.h(bluetoothDevice);
                }
            }
        }
        return true;
    }

    public final void a(Intent intent) {
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (this.f33146a) {
            b.e(String.format(Locale.US, "[%s(%s)", bluetoothDevice.getAddress(), bluetoothDevice.getName()));
        }
        List<h> list = this.f33148c;
        if (list != null) {
            Iterator<h> it = list.iterator();
            while (it.hasNext()) {
                it.next().a(bluetoothDevice, true);
            }
        }
    }

    public final boolean c() {
        Context context = this.f33147b;
        if (context == null) {
            b.s("not intialized");
            return false;
        }
        if (this.f33150e == null) {
            BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth");
            this.f33149d = bluetoothManager;
            if (bluetoothManager == null) {
                b.s("Unable to initialize BluetoothManager.");
                return false;
            }
            BluetoothAdapter adapter = bluetoothManager.getAdapter();
            this.f33150e = adapter;
            if (adapter == null) {
                b.s("Unable to obtain a BluetoothAdapter.");
                return false;
            }
        }
        f();
        return true;
    }

    public void e(h hVar) {
        if (this.f33148c == null) {
            this.f33148c = new CopyOnWriteArrayList();
        }
        if (this.f33148c.contains(hVar)) {
            return;
        }
        this.f33148c.add(hVar);
    }

    public final void f() {
        if (this.f33150e == null) {
            b.s("mBluetoothAdapter == null");
            return;
        }
        this.f33151f = new BluetoothBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        if ((this.f33154i & 1) == 1) {
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        }
        if ((this.f33154i & 2) == 2) {
            intentFilter.addAction(c.f33909a);
            intentFilter.addAction(c.f33910b);
        }
        if ((this.f33154i & 4) == 4) {
            intentFilter.addAction("android.bluetooth.device.action.PAIRING_REQUEST");
            intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        }
        this.f33147b.registerReceiver(this.f33151f, intentFilter);
    }

    public final void g(Intent intent) {
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (this.f33146a) {
            b.e(String.format(Locale.US, "[%s(%s)", bluetoothDevice.getAddress(), bluetoothDevice.getName()));
        }
        List<h> list = this.f33148c;
        if (list != null) {
            Iterator<h> it = list.iterator();
            while (it.hasNext()) {
                it.next().a(bluetoothDevice, false);
            }
        }
    }

    public final void i(Intent intent) {
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        int intExtra = intent.getIntExtra("android.bluetooth.device.extra.PREVIOUS_BOND_STATE", -1);
        int intExtra2 = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", Integer.MIN_VALUE);
        int intExtra3 = intent.getIntExtra(f33145r, -1);
        if (bluetoothDevice == null) {
            return;
        }
        if (this.f33146a) {
            b.e(String.format(Locale.US, "action=%s, [%s(%s), state:%d->%d, reason=%d", intent.getAction(), bluetoothDevice.getAddress(), bluetoothDevice.getName(), Integer.valueOf(intExtra), Integer.valueOf(intExtra2), Integer.valueOf(intExtra3)));
        } else {
            b.p(String.format(Locale.US, "action=%s, [%s, state:%d->%d, reason=%d", intent.getAction(), bluetoothDevice.getName(), Integer.valueOf(intExtra), Integer.valueOf(intExtra2), Integer.valueOf(intExtra3)));
        }
        List<h> list = this.f33148c;
        if (list != null) {
            Iterator<h> it = list.iterator();
            while (it.hasNext()) {
                it.next().c(bluetoothDevice, intExtra2);
            }
        }
    }

    public final boolean k() {
        Handler handler = this.f33156k;
        if (handler != null) {
            handler.removeCallbacks(this.f33157l);
        }
        BluetoothAdapter bluetoothAdapter = this.f33150e;
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            b.s("bluetooth is not supported or disabled");
        }
        if (!this.f33150e.isDiscovering()) {
            return true;
        }
        if (this.f33146a) {
            b.e("stopInquiry()");
        }
        return this.f33150e.cancelDiscovery();
    }

    public void l() {
        b.p("close()");
        Context context = this.f33147b;
        if (context != null) {
            try {
                context.unregisterReceiver(this.f33151f);
            } catch (Exception e8) {
                b.h(e8.toString());
            }
        }
    }

    public boolean m(String str) {
        BluetoothAdapter bluetoothAdapter = this.f33150e;
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            if (this.f33146a) {
                b.e("bluetooth is not enabled");
            }
            return false;
        }
        if (str == null) {
            if (this.f33146a) {
                b.e("mac cannot be null");
            }
            return false;
        }
        if (this.f33146a) {
            b.e("createBondMac=" + str);
        }
        BluetoothDevice remoteDevice = this.f33150e.getRemoteDevice(str);
        int bondState = remoteDevice.getBondState();
        if (bondState == 12) {
            b.e("device already bonded: " + bondState);
            return true;
        }
        if (this.f33146a) {
            b.e("attempt to createBond, state=" + Integer.toString(bondState));
        }
        return f.c(remoteDevice);
    }

    public boolean n(byte[] bArr) {
        return m(d4.a.b(bArr));
    }

    public final void o(Intent intent) {
        String action = intent.getAction();
        int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
        b.e(String.format(Locale.US, "action=%s, state: %d->%d", action, Integer.valueOf(intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", -1)), Integer.valueOf(intExtra)));
        switch (intExtra) {
            case 10:
                if (this.f33146a) {
                    b.p("ACTION_STATE_CHANGED: STATE_OFF");
                }
                synchronized (this.f33153h) {
                    this.f33153h.notifyAll();
                    break;
                }
                break;
            case 11:
                if (this.f33146a) {
                    b.p("ACTION_STATE_CHANGED: STATE_TURNING_ON");
                }
                break;
            case 12:
                if (this.f33146a) {
                    b.p("ACTION_STATE_CHANGED: STATE_ON");
                }
                synchronized (this.f33152g) {
                    this.f33152g.notifyAll();
                    break;
                }
                break;
            case 13:
                if (this.f33146a) {
                    b.p("ACTION_STATE_CHANGED: STATE_TURNING_OFF");
                }
                break;
            default:
                if (this.f33146a) {
                    b.p("ACTION_STATE_CHANGED: " + intExtra);
                }
                break;
        }
        List<h> list = this.f33148c;
        if (list != null) {
            Iterator<h> it = list.iterator();
            while (it.hasNext()) {
                it.next().b(null, intExtra);
            }
        }
    }

    public boolean q() {
        BluetoothAdapter bluetoothAdapter = this.f33150e;
        if (bluetoothAdapter == null) {
            b.s("BT is not initialized..!");
            return false;
        }
        if (bluetoothAdapter.getState() == 10) {
            b.s("BT already OFF");
            return true;
        }
        boolean zDisable = this.f33150e.disable();
        if (this.f33146a) {
            b.p("disable BT " + zDisable);
        }
        if (zDisable) {
            synchronized (this.f33153h) {
                try {
                    if (this.f33146a) {
                        b.e("wait BT disable...");
                    }
                    this.f33153h.wait(RtkCoreMeshWrapper.RTK_PROV_CONNECT_TIMEOUT);
                } catch (InterruptedException e8) {
                    e8.printStackTrace();
                    b.h(e8.toString());
                }
            }
        }
        if (this.f33150e.isEnabled()) {
            b.s("BT disable failed");
            return false;
        }
        if (this.f33146a) {
            b.e("BT disable success");
        }
        return true;
    }

    public final void r(Intent intent) {
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (bluetoothDevice == null) {
            return;
        }
        if (this.f33146a) {
            b.e(String.format(Locale.US, "action=%s, %s(%s)", intent.getAction(), bluetoothDevice.getAddress(), bluetoothDevice.getName()));
        } else {
            b.e(String.format(Locale.US, "action=%s, %s", intent.getAction(), bluetoothDevice.getName()));
        }
        int intExtra = intent.getIntExtra("android.bluetooth.device.extra.PAIRING_VARIANT", 0);
        b.p("android.bluetooth.device.extra.PAIRING_VARIANT>> " + f.f(intExtra) + " (" + intExtra + ")");
        if (bluetoothDevice.getBondState() == 12) {
            b.e("device already bonded: " + bluetoothDevice.getAddress());
        }
    }

    public boolean t() {
        BluetoothAdapter bluetoothAdapter = this.f33150e;
        if (bluetoothAdapter == null) {
            b.s("mBluetoothAdapter == null");
            return false;
        }
        if (bluetoothAdapter.getState() == 12) {
            if (this.f33146a) {
                b.e("BT already on");
            }
            return true;
        }
        this.f33155j = false;
        if (this.f33146a) {
            b.p("isNeedAutoEnableBt=" + this.f33155j);
        }
        boolean zEnable = this.f33150e.enable();
        if (this.f33146a) {
            b.p("enable BT " + zEnable);
        }
        if (zEnable) {
            synchronized (this.f33152g) {
                try {
                    if (this.f33146a) {
                        b.p("wait BT enable...");
                    }
                    this.f33152g.wait(RtkCoreMeshWrapper.RTK_PROV_CONNECT_TIMEOUT);
                } catch (InterruptedException e8) {
                    e8.printStackTrace();
                    b.h(e8.toString());
                }
            }
        }
        if (!this.f33150e.isEnabled()) {
            b.s("BT enable fail");
            return false;
        }
        if (this.f33146a) {
            b.e("BT enable success");
        }
        return true;
    }

    public boolean w() {
        BluetoothManager bluetoothManager = this.f33149d;
        BluetoothAdapter adapter = bluetoothManager != null ? bluetoothManager.getAdapter() : null;
        return adapter != null && adapter.isEnabled();
    }

    public boolean x() {
        return this.f33147b.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    @TargetApi(19)
    public boolean y(byte[] bArr) {
        if (this.f33150e == null) {
            return false;
        }
        byte[] bArr2 = {bArr[5], bArr[4], bArr[3], bArr[2], bArr[1], bArr[0]};
        if (this.f33146a) {
            b.e("createBondMac=" + d4.a.b(bArr));
        }
        BluetoothDevice remoteDevice = this.f33150e.getRemoteDevice(bArr2);
        int bondState = remoteDevice.getBondState();
        if (this.f33146a) {
            b.e("attempt to createBond, state=" + Integer.toString(bondState));
        }
        return remoteDevice.createBond();
    }

    public void z(h hVar) {
        List<h> list = this.f33148c;
        if (list != null) {
            list.remove(hVar);
        }
    }
}
