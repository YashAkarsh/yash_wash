package d4;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Build;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(18)
public class f {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f33487k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f33488l = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static f f33489m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f33490n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f33491o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f33492p = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f33495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BluetoothManager f33496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BluetoothAdapter f33497c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f33502h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Context f33504j;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f33494r = "00002902-0000-1000-8000-00805f9b34fb";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final UUID f33493q = UUID.fromString(f33494r);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f33503i = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HashMap<String, BluetoothGatt> f33499e = new HashMap<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HashMap<String, Integer> f33501g = new HashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HashMap<String, List<BluetoothGattCallback>> f33500f = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<String> f33498d = new CopyOnWriteArrayList();

    public class b extends BluetoothGattCallback {
        public b() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            String address = bluetoothGatt.getDevice().getAddress();
            byte[] value = bluetoothGattCharacteristic.getValue();
            if (f.this.f33495a) {
                if (value != null) {
                    k4.b.e(String.format(Locale.US, "<< %s\n(%d)%s", bluetoothGattCharacteristic.getUuid(), Integer.valueOf(value.length), m4.a.a(value)));
                } else {
                    k4.b.e(String.format(Locale.US, "<< %s", bluetoothGattCharacteristic.getUuid()));
                }
            }
            List list = (List) f.this.f33500f.get(address);
            if (list == null || list.size() <= 0) {
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((BluetoothGattCallback) it.next()).onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i7) {
            byte[] value = bluetoothGattCharacteristic.getValue();
            if (f.this.f33495a) {
                if (value != null) {
                    k4.b.e(String.format(Locale.US, "%s << %s\n:\t(%d)%s", d.a(i7), bluetoothGattCharacteristic.getUuid(), Integer.valueOf(value.length), m4.a.a(value)));
                } else {
                    k4.b.e(String.format(Locale.US, "%s << %s", d.a(i7), bluetoothGattCharacteristic.getUuid()));
                }
            } else if (value != null) {
                k4.b.e(String.format(Locale.US, "%s << (%d)", d.a(i7), Integer.valueOf(value.length)));
            } else {
                k4.b.e(String.format(Locale.US, "%s <<", d.a(i7)));
            }
            synchronized (f.this.f33503i) {
                f.this.f33502h = true;
                f.this.f33503i.notifyAll();
            }
            List list = (List) f.this.f33500f.get(bluetoothGatt.getDevice().getAddress());
            if (list == null || list.size() <= 0) {
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((BluetoothGattCallback) it.next()).onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i7);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i7) {
            String address = bluetoothGatt.getDevice().getAddress();
            byte[] value = bluetoothGattCharacteristic.getValue();
            if (f.this.f33495a) {
                if (value != null) {
                    k4.b.e(String.format(Locale.US, "%s << %s\n(%d)%s", d.a(i7), bluetoothGattCharacteristic.getUuid(), Integer.valueOf(value.length), m4.a.a(value)));
                } else {
                    k4.b.e(String.format(Locale.US, "%s << %s", d.a(i7), bluetoothGattCharacteristic.getUuid()));
                }
            }
            synchronized (f.this.f33503i) {
                f.this.f33502h = true;
                f.this.f33503i.notifyAll();
            }
            List list = (List) f.this.f33500f.get(address);
            if (list == null || list.size() <= 0) {
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((BluetoothGattCallback) it.next()).onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i7);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i7, int i8) {
            BluetoothDevice device = bluetoothGatt.getDevice();
            if (device == null) {
                return;
            }
            String address = device.getAddress();
            if (f.this.f33495a) {
                k4.b.p(String.format(Locale.US, "%s, status: %s , newState: %s", address, d.b(i7), d4.a.q(i8)));
            } else {
                k4.b.p(String.format(Locale.US, "status: %s , newState: %s", d.b(i7), d4.a.q(i8)));
            }
            if (i7 != 0) {
                f.this.f33501g.put(address, 0);
            } else if (i8 == 2) {
                if (f.this.f33495a) {
                    k4.b.p("Connected to GATT server.");
                }
                f.this.f33501g.put(address, 2);
                f.this.f33499e.put(address, bluetoothGatt);
            } else {
                if (f.this.f33495a) {
                    k4.b.p("Disconnected from GATT server.");
                }
                f.this.f33501g.put(address, 0);
            }
            List list = (List) f.this.f33500f.get(address);
            if (list == null || list.size() <= 0) {
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((BluetoothGattCallback) it.next()).onConnectionStateChange(bluetoothGatt, i7, i8);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i7) {
            String address = bluetoothGatt.getDevice().getAddress();
            UUID uuid = bluetoothGattDescriptor.getCharacteristic().getUuid();
            byte[] value = bluetoothGattDescriptor.getValue();
            if (f.this.f33495a) {
                if (value != null) {
                    k4.b.e(String.format(Locale.US, "%s>> {\nCharacteristic:%s\nDescriptor:%s\nvalue:(%d)%s\n}", d.a(i7), uuid, bluetoothGattDescriptor.getUuid(), Integer.valueOf(value.length), m4.a.a(value)));
                } else {
                    k4.b.e(String.format(Locale.US, "%s>> {\nCharacteristic:%s\nDescriptor:%s}", d.a(i7), uuid, bluetoothGattDescriptor.getUuid()));
                }
            }
            synchronized (f.this.f33503i) {
                f.this.f33502h = true;
                f.this.f33503i.notifyAll();
            }
            List list = (List) f.this.f33500f.get(address);
            if (list == null || list.size() <= 0) {
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((BluetoothGattCallback) it.next()).onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i7);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        @TargetApi(21)
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i7, int i8) {
            String address = bluetoothGatt.getDevice().getAddress();
            if (f.this.f33495a) {
                k4.b.e(String.format(Locale.US, "%s << mtu= %d, addr=%s", d.a(i8), Integer.valueOf(i7), address));
            } else {
                k4.b.e(String.format(Locale.US, "%s << mtu= %d", d.a(i8), Integer.valueOf(i7)));
            }
            List list = (List) f.this.f33500f.get(address);
            if (list == null || list.size() <= 0) {
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((BluetoothGattCallback) it.next()).onMtuChanged(bluetoothGatt, i7, i8);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i7) {
            String address = bluetoothGatt.getDevice().getAddress();
            if (f.this.f33495a) {
                k4.b.e(String.format(Locale.US, "%s << addr=%s", d.a(i7), address));
            } else {
                k4.b.p(String.format(Locale.US, "%s", d.a(i7)));
            }
            if (f.f33487k) {
                for (BluetoothGattService bluetoothGattService : bluetoothGatt.getServices()) {
                    k4.b.e(String.format(Locale.US, "service: type=%d, %d/%s", Integer.valueOf(bluetoothGattService.getType()), Integer.valueOf(bluetoothGattService.getInstanceId()), bluetoothGattService.getUuid().toString()));
                    for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                        k4.b.p(String.format(Locale.US, "\tcharacteristic: %d/%s", Integer.valueOf(bluetoothGattCharacteristic.getInstanceId()), bluetoothGattCharacteristic.getUuid().toString()));
                    }
                }
            }
            List list = (List) f.this.f33500f.get(address);
            if (list == null || list.size() <= 0) {
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((BluetoothGattCallback) it.next()).onServicesDiscovered(bluetoothGatt, i7);
            }
        }
    }

    public f(Context context) {
        this.f33495a = false;
        this.f33504j = context;
        this.f33495a = b4.d.f11317b;
        a();
    }

    public static synchronized void A(Context context) {
        if (f33489m == null) {
            synchronized (f.class) {
                if (f33489m == null) {
                    f33489m = new f(context.getApplicationContext());
                }
            }
        }
    }

    public static f y() {
        return f33489m;
    }

    public boolean B() {
        return this.f33497c != null || a();
    }

    public boolean C(String str, BluetoothGattCallback bluetoothGattCallback) {
        List<BluetoothGattCallback> listT = t(str);
        return listT != null && listT.contains(bluetoothGattCallback);
    }

    public boolean D(String str) {
        Integer num = this.f33501g.get(str);
        return num != null && num.intValue() == 2;
    }

    public boolean E(String str) {
        BluetoothManager bluetoothManager = this.f33496b;
        if (bluetoothManager == null) {
            if (this.f33495a) {
                k4.b.s("addr: " + str + ", mBluetoothManager == null");
            }
            return false;
        }
        List<BluetoothDevice> connectedDevices = bluetoothManager.getConnectedDevices(7);
        if (connectedDevices != null) {
            Iterator<BluetoothDevice> it = connectedDevices.iterator();
            while (it.hasNext()) {
                if (it.next().getAddress().equals(str)) {
                    if (!this.f33495a) {
                        return true;
                    }
                    k4.b.e("addr: " + str + ", Connected.");
                    return true;
                }
            }
        }
        if (this.f33495a) {
            k4.b.e("addr: " + str + ", Disconnected.");
        }
        return false;
    }

    public boolean F(String str, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (this.f33497c == null) {
            k4.b.s("BluetoothAdapter not initialized");
            return false;
        }
        BluetoothGatt bluetoothGatt = this.f33499e.get(str);
        if (bluetoothGatt == null) {
            k4.b.s("unspecified address.");
            return false;
        }
        if (this.f33495a) {
            k4.b.e("raddr: " + str);
        }
        return bluetoothGatt.readCharacteristic(bluetoothGattCharacteristic);
    }

    public boolean G(String str, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.f33502h = false;
        if (!F(str, bluetoothGattCharacteristic)) {
            return false;
        }
        synchronized (this.f33503i) {
            try {
                if (!this.f33502h) {
                    if (this.f33495a) {
                        k4.b.p("wait for 3000ms");
                    }
                    this.f33503i.wait(3000L);
                    if (this.f33495a) {
                        k4.b.p("wait time reached");
                    }
                }
            } catch (InterruptedException e8) {
                k4.b.h(e8.toString());
            }
        }
        return true;
    }

    public synchronized void H(String str, BluetoothGattCallback bluetoothGattCallback) {
        List<BluetoothGattCallback> listT = t(str);
        if (listT == null) {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            copyOnWriteArrayList.add(bluetoothGattCallback);
            this.f33500f.put(str, copyOnWriteArrayList);
        } else {
            if (!listT.contains(bluetoothGattCallback)) {
                listT.add(bluetoothGattCallback);
                this.f33500f.put(str, listT);
            }
        }
    }

    public boolean I(String str, BluetoothGattCharacteristic bluetoothGattCharacteristic, UUID uuid, boolean z7) {
        if (this.f33497c == null) {
            k4.b.s("BluetoothAdapter not initialized");
            return false;
        }
        BluetoothGatt bluetoothGatt = this.f33499e.get(str);
        if (bluetoothGatt == null) {
            k4.b.s("BluetoothGatt can not be null, addr=" + str);
            return false;
        }
        if (bluetoothGattCharacteristic == null) {
            k4.b.s("characteristic is null");
            return false;
        }
        if (this.f33495a) {
            k4.b.e("addr:=" + str + ", enabled=" + z7);
        }
        bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z7);
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(uuid);
        if (descriptor == null) {
            k4.b.s("descriptor not found, uuid=" + uuid.toString());
            return false;
        }
        if (z7) {
            descriptor.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
        } else {
            descriptor.setValue(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
        }
        bluetoothGatt.writeDescriptor(descriptor);
        return true;
    }

    public boolean J(String str, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z7) {
        return I(str, bluetoothGattCharacteristic, f33493q, z7);
    }

    public boolean K(String str, BluetoothGattCharacteristic bluetoothGattCharacteristic, UUID uuid, boolean z7) {
        if (this.f33497c == null) {
            k4.b.s("BluetoothAdapter not initialized");
            return false;
        }
        BluetoothGatt bluetoothGatt = this.f33499e.get(str);
        if (bluetoothGatt == null) {
            k4.b.s("BluetoothGatt can not be null, addr=" + str);
            return false;
        }
        if (this.f33495a) {
            k4.b.e("addr:=" + str + ", enabled=" + z7);
        }
        bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z7);
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(uuid);
        if (descriptor == null) {
            k4.b.s("descriptor not found, uuid=" + uuid.toString());
            return false;
        }
        if (z7) {
            descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        } else {
            descriptor.setValue(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
        }
        bluetoothGatt.writeDescriptor(descriptor);
        return true;
    }

    public boolean L(String str, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z7) {
        return K(str, bluetoothGattCharacteristic, f33493q, z7);
    }

    public boolean M(String str, BluetoothGattCharacteristic bluetoothGattCharacteristic, UUID uuid, boolean z7) {
        this.f33502h = false;
        if (!K(str, bluetoothGattCharacteristic, uuid, z7)) {
            return false;
        }
        synchronized (this.f33503i) {
            try {
                if (!this.f33502h) {
                    if (this.f33495a) {
                        k4.b.p("wait for 3000ms");
                    }
                    this.f33503i.wait(3000L);
                    if (this.f33495a) {
                        k4.b.p("wait time reached");
                    }
                }
            } catch (InterruptedException e8) {
                k4.b.h(e8.toString());
            }
        }
        return true;
    }

    public void N(String str) {
        if (this.f33500f.get(str) == null) {
            if (this.f33495a) {
                k4.b.e("mCallbacks.get(addr) == null");
            }
        } else {
            if (this.f33495a) {
                k4.b.p("addr: " + str);
            }
            this.f33500f.remove(str);
        }
    }

    public synchronized void O(String str, BluetoothGattCallback bluetoothGattCallback) {
        List<BluetoothGattCallback> listT = t(str);
        if (listT != null) {
            if (listT.contains(bluetoothGattCallback)) {
                listT.remove(bluetoothGattCallback);
                this.f33500f.put(str, listT);
            }
        } else {
            if (this.f33495a) {
                k4.b.p("callback not registered, addr= " + str);
            }
        }
    }

    public boolean P(String str, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (this.f33497c == null) {
            k4.b.s("BluetoothAdapter not initialized");
            return false;
        }
        BluetoothGatt bluetoothGatt = this.f33499e.get(str);
        if (bluetoothGatt == null) {
            k4.b.s("unspecified address.");
            return false;
        }
        k4.b.p("addr: " + str);
        return bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
    }

    public synchronized boolean Q(String str, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.f33502h = false;
        if (!P(str, bluetoothGattCharacteristic)) {
            return false;
        }
        synchronized (this.f33503i) {
            try {
                if (!this.f33502h) {
                    if (this.f33495a) {
                        k4.b.p("wait for 3000ms");
                    }
                    this.f33503i.wait(3000L);
                    if (this.f33495a) {
                        k4.b.p("wait time reached");
                    }
                }
            } catch (InterruptedException e8) {
                k4.b.h(e8.toString());
            }
        }
        return true;
    }

    public final boolean a() {
        if (this.f33496b == null) {
            BluetoothManager bluetoothManager = (BluetoothManager) this.f33504j.getSystemService("bluetooth");
            this.f33496b = bluetoothManager;
            if (bluetoothManager == null) {
                k4.b.s("BLUETOOTH_SERVICE not supported.");
                return false;
            }
        }
        if (this.f33497c == null) {
            BluetoothAdapter adapter = this.f33496b.getAdapter();
            this.f33497c = adapter;
            if (adapter == null) {
                k4.b.s("BluetoothAdapter is not supported");
                return false;
            }
        }
        k4.b.e("initialize success");
        return true;
    }

    public void f(String str) {
        if (str == null) {
            return;
        }
        BluetoothGatt bluetoothGatt = this.f33499e.get(str);
        if (bluetoothGatt != null) {
            if (D(str)) {
                if (this.f33495a) {
                    k4.b.p("disconnect : " + str);
                }
                bluetoothGatt.disconnect();
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e8) {
                    e8.printStackTrace();
                }
            }
            if (f33488l) {
                if (this.f33495a) {
                    k4.b.p("closeGatt, addr:=" + str);
                }
                bluetoothGatt.close();
            }
            this.f33499e.remove(str);
        }
        HashMap<String, List<BluetoothGattCallback>> map = this.f33500f;
        if (map != null) {
            map.remove(str);
        }
        List<String> list = this.f33498d;
        if (list == null || !list.contains(str)) {
            return;
        }
        this.f33498d.remove(str);
    }

    public void g() {
        List<String> list = this.f33498d;
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<String> it = this.f33498d.iterator();
        while (it.hasNext()) {
            f(it.next());
        }
    }

    public synchronized void h(String str) {
        i(str, f33488l);
    }

    public synchronized void i(String str, boolean z7) {
        try {
            if (str == null) {
                k4.b.e("Invalid address");
                return;
            }
            if (this.f33499e != null) {
                k4.b.p("closeClient =" + z7);
                BluetoothGatt bluetoothGatt = this.f33499e.get(str);
                if (z7 && bluetoothGatt != null) {
                    if (this.f33495a) {
                        k4.b.p("closeGatt, addr:=" + str);
                    }
                    bluetoothGatt.close();
                }
                this.f33499e.remove(str);
            }
            HashMap<String, List<BluetoothGattCallback>> map = this.f33500f;
            if (map != null) {
                map.remove(str);
            }
            List<String> list = this.f33498d;
            if (list != null && list.contains(str)) {
                this.f33498d.remove(str);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean j(String str, int i7, int i8, BluetoothGattCallback bluetoothGattCallback) {
        return m(str, false, i7, i8, bluetoothGattCallback);
    }

    public boolean k(String str, int i7, BluetoothGattCallback bluetoothGattCallback) {
        return Build.VERSION.SDK_INT >= 26 ? m(str, false, i7, 1, bluetoothGattCallback) : m(str, false, i7, 1, bluetoothGattCallback);
    }

    public boolean l(String str, BluetoothGattCallback bluetoothGattCallback) {
        return k(str, 2, bluetoothGattCallback);
    }

    public boolean m(String str, boolean z7, int i7, int i8, BluetoothGattCallback bluetoothGattCallback) {
        BluetoothGatt bluetoothGatt;
        BluetoothAdapter bluetoothAdapter = this.f33497c;
        if (bluetoothAdapter == null) {
            k4.b.s("BluetoothAdapter not initialized");
            return false;
        }
        if (str == null) {
            k4.b.s("unspecified address.");
            return false;
        }
        BluetoothDevice remoteDevice = bluetoothAdapter.getRemoteDevice(str);
        if (remoteDevice == null) {
            k4.b.s("Device not found.  Unable to connect.");
            return false;
        }
        if (this.f33498d.contains(str) && (bluetoothGatt = this.f33499e.get(str)) != null) {
            if (D(str)) {
                if (this.f33495a) {
                    k4.b.p("already connected, addr=" + str);
                }
                H(str, bluetoothGattCallback);
                if (bluetoothGattCallback != null) {
                    bluetoothGattCallback.onConnectionStateChange(bluetoothGatt, 0, 2);
                }
                return true;
            }
            H(str, bluetoothGattCallback);
            if (z7) {
                H(str, bluetoothGattCallback);
                if (this.f33495a) {
                    k4.b.p("re-connect previous device: " + str);
                }
                if (bluetoothGatt.connect()) {
                    this.f33501g.put(str, 1);
                    return true;
                }
                k4.b.e("reconnect failed.");
                h(str);
                return false;
            }
            h(str);
        }
        if (this.f33495a) {
            k4.b.p("create connection to " + str);
        }
        H(str, bluetoothGattCallback);
        this.f33501g.put(str, 1);
        BluetoothGatt bluetoothGattConnectGatt = Build.VERSION.SDK_INT >= 26 ? remoteDevice.connectGatt(this.f33504j, z7, new b(), i7, i8) : remoteDevice.connectGatt(this.f33504j, z7, new b(), i7);
        if (bluetoothGattConnectGatt == null) {
            k4.b.s("BluetoothGatt not exist.  Unable to connect.");
            this.f33501g.put(str, 0);
            h(str);
            return false;
        }
        this.f33499e.put(str, bluetoothGattConnectGatt);
        if (!this.f33498d.contains(str)) {
            this.f33498d.add(str);
        }
        return true;
    }

    public boolean o(String str) {
        BluetoothGatt bluetoothGatt = this.f33499e.get(str);
        List<BluetoothGattCallback> list = this.f33500f.get(str);
        if (bluetoothGatt == null) {
            return false;
        }
        if (!D(str)) {
            if (list == null || list.size() <= 0) {
                return true;
            }
            Iterator<BluetoothGattCallback> it = list.iterator();
            while (it.hasNext()) {
                it.next().onConnectionStateChange(bluetoothGatt, 0, 0);
            }
            return true;
        }
        if (this.f33495a) {
            k4.b.p("disconnect : " + str);
        }
        bluetoothGatt.disconnect();
        try {
            Thread.sleep(500L);
            return true;
        } catch (InterruptedException e8) {
            e8.printStackTrace();
            return true;
        }
    }

    public BluetoothAdapter q() {
        return this.f33497c;
    }

    public List<String> r() {
        return this.f33498d;
    }

    public BluetoothGatt s(String str) {
        return this.f33499e.get(str);
    }

    public List<BluetoothGattCallback> t(String str) {
        HashMap<String, List<BluetoothGattCallback>> map = this.f33500f;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public ArrayList<BluetoothDevice> u() {
        ArrayList<BluetoothDevice> arrayList = new ArrayList<>();
        for (String str : this.f33498d) {
            if (D(str)) {
                arrayList.add(s(str).getDevice());
            }
        }
        return arrayList;
    }

    public BluetoothDevice v() {
        for (String str : this.f33498d) {
            if (D(str)) {
                return s(str).getDevice();
            }
        }
        return null;
    }

    public ArrayList<BluetoothDevice> w() {
        ArrayList<BluetoothDevice> arrayList = new ArrayList<>();
        for (String str : this.f33498d) {
            if (D(str)) {
                arrayList.add(s(str).getDevice());
            }
        }
        return arrayList;
    }

    public String x(String str) {
        BluetoothGatt bluetoothGatt = this.f33499e.get(str);
        if (bluetoothGatt != null) {
            return bluetoothGatt.getDevice().getName();
        }
        if (!this.f33495a) {
            return null;
        }
        k4.b.s("no bluetoothGatt exist, addr=" + str);
        return null;
    }

    public List<BluetoothGattService> z(String str) {
        if (this.f33499e.get(str) == null) {
            return null;
        }
        return this.f33499e.get(str).getServices();
    }
}
