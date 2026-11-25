package q4;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import d4.f;
import f4.g;
import java.util.HashMap;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static int f40117n = 240;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final UUID f40118o = UUID.fromString("00001827-0000-1000-8000-00805f9b34fb");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final UUID f40119p = UUID.fromString("00002adb-0000-1000-8000-00805f9b34fb");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final UUID f40120q = UUID.fromString("00002adc-0000-1000-8000-00805f9b34fb");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final UUID f40121r = UUID.fromString("00001828-0000-1000-8000-00805f9b34fb");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final UUID f40122s = UUID.fromString("00002add-0000-1000-8000-00805f9b34fb");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final UUID f40123t = UUID.fromString("00002ade-0000-1000-8000-00805f9b34fb");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f40124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f40125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f40126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BluetoothGatt f40127d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f40128e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f40129f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f f40130g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HashMap<String, BluetoothGattCharacteristic> f40132i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public HashMap<String, BluetoothGattCharacteristic> f40133j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public HashMap<String, BluetoothGattCharacteristic> f40134k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public HashMap<String, BluetoothGattCharacteristic> f40135l;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f40131h = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final BluetoothGattCallback f40136m = new C0543a();

    /* JADX INFO: renamed from: q4.a$a, reason: collision with other inner class name */
    public class C0543a extends BluetoothGattCallback {
        public C0543a() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            String address = bluetoothGatt.getDevice().getAddress();
            k4.b.k("<<-- get message from " + address);
            k4.b.k("onCharacteristicChanged mBluetoothDeviceConnectedAddress" + a.this.f40129f);
            if (a.this.f40129f != null) {
                if (!a.this.f40129f.equals(address)) {
                    k4.b.k("<<-- get message from delay, jump this message ");
                    return;
                }
                byte[] value = bluetoothGattCharacteristic.getValue();
                k4.b.e("<<-- olength: " + bluetoothGattCharacteristic.getValue().length + ", data: " + m4.a.b(value));
                if (a.f40120q.equals(bluetoothGattCharacteristic.getUuid())) {
                    a.this.f40126c.b(value);
                } else if (a.f40123t.equals(bluetoothGattCharacteristic.getUuid())) {
                    a.this.f40126c.d(value);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i7) {
            k4.b.e("<<<--- status: " + i7 + " value: " + m4.a.a(bluetoothGattCharacteristic.getValue()));
            String stringValue = bluetoothGattCharacteristic.getStringValue(0);
            if (i7 == 0) {
                k4.b.e("onCharacteristicRead mCallback = " + a.this.f40125b);
                a.this.f40125b.g(stringValue);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i7) {
            String address = bluetoothGatt.getDevice().getAddress();
            k4.b.k("<<-- get message from " + address + " status = " + i7);
            if (!a.this.f40129f.equals(address)) {
                k4.b.k("<<-- get message from delay, jump this message ");
                return;
            }
            if (a.f40119p.equals(bluetoothGattCharacteristic.getUuid())) {
                a.this.f40126c.c(i7 == 0);
            } else if (a.f40122s.equals(bluetoothGattCharacteristic.getUuid())) {
                a.this.f40126c.e(i7 == 0);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i7, int i8) {
            k4.b.k("onConnectionStateChange");
            if (a.this.f40131h) {
                return;
            }
            if (i7 == 0) {
                if (i8 == 2) {
                    a.this.f40127d = bluetoothGatt;
                    k4.b.k("Connected to GATT server");
                    k4.b.k("Attempting to request mtu size, expect mtu size is: " + String.valueOf(a.f40117n));
                    a.this.f40127d.requestMtu(a.f40117n);
                    return;
                }
                if (i8 == 0) {
                    k4.b.k("Disconnected from GATT server connectedDeviceSize() = " + a.this.p());
                    a.this.k();
                    return;
                }
                return;
            }
            k4.b.h("error: status " + i7 + " newState: " + i8 + " connectedDeviceSize() = " + a.this.p());
            String address = bluetoothGatt.getDevice().getAddress();
            StringBuilder sb = new StringBuilder();
            sb.append("gattAddress = ");
            sb.append(address);
            k4.b.e(sb.toString());
            a.this.m(address);
            if (a.this.p() == 0) {
                k4.b.k("connectedDeviceSize() == 0 mCallback = " + a.this.f40125b);
                if (a.this.f40125b != null && p4.b.c(a.this.f40124a) != null) {
                    a.this.f40125b.a(p4.b.c(a.this.f40124a), false);
                }
                p4.b.f(a.this.f40124a, null);
                a.this.f40129f = null;
                n4.b.F().y((byte) 0);
                return;
            }
            k4.b.k("current mBluetoothDeviceConnectedAddress is" + a.this.f40129f);
            a aVar = a.this;
            aVar.f40129f = aVar.f40130g.u().get(0).getAddress();
            p4.b.f(a.this.f40124a, a.this.f40129f);
            k4.b.k("current proxy addr is" + a.this.f40129f);
            if (a.this.f40135l.get(a.this.f40129f) == null || a.this.f40133j.get(a.this.f40129f) == null || a.this.f40132i.get(a.this.f40129f) == null || a.this.f40134k.get(a.this.f40129f) == null) {
                k4.b.k("Attempting to request mtu size, expect mtu size is: " + String.valueOf(a.f40117n));
                a.this.f40127d.requestMtu(a.f40117n);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i7) {
            k4.b.e("onDescriptorWrite status = " + i7);
            if (a.this.f40131h) {
                return;
            }
            if (i7 != 0) {
                k4.b.h("Descriptor write error: " + i7);
                a.this.s();
                a.this.l();
                return;
            }
            if (!(bluetoothGattDescriptor.getValue()[0] == 1)) {
                k4.b.h("Notification  not enabled!!!");
                a.this.s();
                a.this.l();
                return;
            }
            BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) a.this.f40132i.get(a.this.f40128e);
            BluetoothGattCharacteristic bluetoothGattCharacteristic2 = (BluetoothGattCharacteristic) a.this.f40134k.get(a.this.f40128e);
            if (bluetoothGattCharacteristic == null || bluetoothGattCharacteristic2 == null) {
                return;
            }
            if (bluetoothGattDescriptor.getCharacteristic().getUuid().equals(bluetoothGattCharacteristic.getUuid())) {
                k4.b.e("Prov Notification enabled");
                a.this.f40130g.L(a.this.f40128e, bluetoothGattCharacteristic2, true);
                return;
            }
            if (bluetoothGattDescriptor.getCharacteristic().getUuid().equals(bluetoothGattCharacteristic2.getUuid())) {
                k4.b.e("Proxy Notification enabled mBluetoothDeviceAddress = " + a.this.f40128e);
                a aVar = a.this;
                aVar.f40129f = aVar.f40128e;
                k4.b.e("Proxy Notification enabled mCallback = " + a.this.f40125b);
                if (a.this.f40125b != null) {
                    a.this.f40125b.a(a.this.f40129f, true);
                }
                n4.b.F().v((byte) 0);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i7, int i8) {
            k4.b.k("onMtuChanged  status = " + i8);
            if (a.this.f40131h) {
                return;
            }
            if (i8 == 0) {
                a.this.f40126c.a(i7);
            }
            k4.b.k("Attempting to start service discovery: " + a.this.f40127d.discoverServices());
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i7) {
            k4.b.k("onServicesDiscovered status = " + i7);
            g.h(bluetoothGatt);
            if (a.this.f40131h) {
                return;
            }
            if (i7 != 0) {
                a.this.s();
                a.this.l();
                return;
            }
            BluetoothGattService service = bluetoothGatt.getService(a.f40118o);
            if (service == null) {
                k4.b.s("SERVICE_MESH_PROV_UUID not supported");
                a.this.s();
                a.this.l();
                return;
            }
            BluetoothGattCharacteristic characteristic = service.getCharacteristic(a.f40120q);
            if (characteristic == null) {
                k4.b.s("CHAR_MESH_PROV_DATA_IN_UUID not supported");
                a.this.s();
                a.this.l();
                return;
            }
            a.this.f40132i.put(a.this.f40128e, characteristic);
            a.this.f40130g.L(a.this.f40128e, characteristic, true);
            BluetoothGattCharacteristic characteristic2 = service.getCharacteristic(a.f40119p);
            if (characteristic2 == null) {
                k4.b.s("CHAR_MESH_PROV_DATA_OUT_UUID not supported");
                a.this.s();
                a.this.l();
                return;
            }
            a.this.f40133j.put(a.this.f40128e, characteristic2);
            BluetoothGattService service2 = bluetoothGatt.getService(a.f40121r);
            if (service2 == null) {
                k4.b.s("SERVICE_MESH_PROXY_UUID not supported");
                a.this.s();
                a.this.l();
                return;
            }
            BluetoothGattCharacteristic characteristic3 = service2.getCharacteristic(a.f40123t);
            if (characteristic3 == null) {
                k4.b.s("CHAR_MESH_PROXY_DATA_IN_UUID not supported");
                a.this.s();
                a.this.l();
                return;
            }
            a.this.f40134k.put(a.this.f40128e, characteristic3);
            BluetoothGattCharacteristic characteristic4 = service2.getCharacteristic(a.f40122s);
            if (characteristic4 != null) {
                a.this.f40135l.put(a.this.f40128e, characteristic4);
                return;
            }
            k4.b.s("CHAR_MESH_PROXY_DATA_OUT_UUID not supported");
            a.this.s();
            a.this.l();
        }
    }

    public a(Context context, b bVar) {
        k4.b.e("initial.");
        this.f40124a = context;
        this.f40125b = bVar;
        this.f40130g = f.y();
        this.f40132i = new HashMap<>();
        this.f40133j = new HashMap<>();
        this.f40134k = new HashMap<>();
        this.f40135l = new HashMap<>();
    }

    public void E(boolean z7) {
        this.f40131h = z7;
    }

    public void F(c cVar) {
        this.f40126c = cVar;
    }

    public boolean a(byte[] bArr) {
        k4.b.e("ProvOut()");
        if (this.f40133j == null) {
            k4.b.s("CHAR_MESH_PROV_DATA_OUT_UUID not supported");
            return false;
        }
        if (!this.f40130g.D(this.f40129f)) {
            k4.b.s("disconnected, addr=" + this.f40129f);
            return false;
        }
        k4.b.e("-->> " + m4.a.b(bArr));
        k4.b.s("ProvOut, mBluetoothDeviceConnectedAddress = " + this.f40129f);
        if (this.f40133j.get(this.f40129f) == null) {
            k4.b.e("mProvOutCharacteristic.get(mBluetoothDeviceConnectedAddress) == null");
            return false;
        }
        this.f40133j.get(this.f40129f).setWriteType(1);
        this.f40133j.get(this.f40129f).setValue(bArr);
        f fVar = this.f40130g;
        String str = this.f40129f;
        return fVar.P(str, this.f40133j.get(str));
    }

    public boolean b(byte[] bArr) {
        k4.b.e("ProxyOut()");
        if (this.f40135l == null) {
            k4.b.s("CHAR_MESH_PROXY_DATA_OUT_UUID not supported");
            return false;
        }
        if (!this.f40130g.D(this.f40129f)) {
            k4.b.s("disconnected, addr=" + this.f40129f);
            return false;
        }
        k4.b.e("-->> " + m4.a.b(bArr));
        k4.b.s("ProxyOut, mBluetoothDeviceConnectedAddress = " + this.f40129f);
        if (this.f40135l.get(this.f40129f) == null) {
            k4.b.e("mProxyOutCharacteristic.get(mBluetoothDeviceConnectedAddress) == null");
            return false;
        }
        this.f40135l.get(this.f40129f).setWriteType(1);
        this.f40135l.get(this.f40129f).setValue(bArr);
        f fVar = this.f40130g;
        String str = this.f40129f;
        return fVar.P(str, this.f40135l.get(str));
    }

    public void k() {
        if (p() == 0) {
            k4.b.k("connectedDeviceSize() == 0 mCallback = " + this.f40125b);
            b bVar = this.f40125b;
            if (bVar != null) {
                bVar.a(this.f40129f, false);
            }
            p4.b.f(this.f40124a, null);
            this.f40129f = null;
            n4.b.F().y((byte) 0);
            return;
        }
        if (this.f40125b != null && p4.b.b(this.f40124a) != null) {
            this.f40125b.a(p4.b.b(this.f40124a), false);
        }
        k4.b.k("changeGattConnect  mBluetoothDeviceConnectedAddress is " + this.f40129f);
        String address = this.f40130g.u().get(0).getAddress();
        this.f40129f = address;
        p4.b.f(this.f40124a, address);
        k4.b.k("current proxy addr is" + this.f40129f);
    }

    public void l() {
        k4.b.e("closeGatt() mBluetoothDeviceConnectedAddress = " + this.f40129f);
        try {
            this.f40130g.h(this.f40129f);
        } catch (Exception e8) {
            e8.printStackTrace();
        }
    }

    public void m(String str) {
        k4.b.e("closeGatt() deviceAddress = " + str);
        try {
            this.f40130g.h(str);
        } catch (Exception e8) {
            e8.printStackTrace();
        }
    }

    public boolean n(String str) {
        k4.b.e("address: " + str);
        this.f40128e = str;
        return this.f40130g.l(str, this.f40136m);
    }

    public boolean o(String str, b bVar) {
        k4.b.e("address: " + str);
        this.f40128e = str;
        this.f40125b = bVar;
        k4.b.e("address: mCallback" + this.f40125b);
        return this.f40130g.l(str, this.f40136m);
    }

    public int p() {
        return this.f40130g.u().size();
    }

    public void s() {
        k4.b.e("gatt disconnectGatt() mBluetoothDeviceConnectedAddress = " + this.f40129f);
        try {
            this.f40130g.o(this.f40129f);
        } catch (Exception e8) {
            e8.printStackTrace();
        }
    }

    public void t(String str) {
        k4.b.e("gatt disconnectGatt() deviceAddress = " + str);
        try {
            this.f40130g.o(str);
        } catch (Exception e8) {
            e8.printStackTrace();
        }
    }

    public BluetoothDevice y(String str) {
        return this.f40130g.q().getRemoteDevice(str);
    }

    public a(Context context) {
        k4.b.e("initial.");
        this.f40124a = context;
        this.f40130g = f.y();
        this.f40132i = new HashMap<>();
        this.f40133j = new HashMap<>();
        this.f40134k = new HashMap<>();
        this.f40135l = new HashMap<>();
    }
}
