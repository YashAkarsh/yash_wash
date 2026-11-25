package j4;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final UUID f34305g = UUID.fromString("00001803-0000-1000-8000-00805f9b34fb");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final UUID f34306h = UUID.fromString("00002a06-0000-1000-8000-00805f9b34fb");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte f34307i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final byte f34308j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final byte f34309k = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BluetoothGattService f34311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BluetoothGattCharacteristic f34312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f34313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f34314e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f34310a = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BluetoothGattCallback f34315f = new a();

    public class a extends BluetoothGattCallback {
        public a() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i7) {
            byte[] value = bluetoothGattCharacteristic.getValue();
            if (i7 != 0) {
                k4.b.s("Characteristic read error: " + i7);
                return;
            }
            if (f.this.f34312c == null || !f.f34306h.equals(bluetoothGattCharacteristic.getUuid())) {
                return;
            }
            f.this.f34310a = value[0];
            k4.b.p("mAlertLevel=" + ((int) f.this.f34310a));
            if (f.this.f34313d != null) {
                f.this.f34313d.a(f.this.f34310a);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i7) {
            if (i7 == 0) {
                f.this.f34311b = bluetoothGatt.getService(f.f34305g);
                if (f.this.f34311b == null) {
                    k4.b.h("LINK_LOSS_SERVICE not supported");
                    return;
                }
                f fVar = f.this;
                fVar.f34312c = fVar.f34311b.getCharacteristic(f.f34306h);
                if (f.this.f34312c == null) {
                    k4.b.h("ALERT_LEVEL_CHARACTERISTIC_UUID not supported");
                    return;
                }
                k4.b.e("ALERT_LEVEL_CHARACTERISTIC_UUID: " + f.this.f34312c.getUuid());
                f.this.f34312c.setWriteType(2);
                List<BluetoothGattDescriptor> descriptors = f.this.f34312c.getDescriptors();
                if (descriptors == null || descriptors.size() <= 0) {
                    return;
                }
                Iterator<BluetoothGattDescriptor> it = descriptors.iterator();
                while (it.hasNext()) {
                    k4.b.e("descriptor : " + it.next().getUuid().toString());
                }
            }
        }
    }

    public interface b {
        void a(byte b8);
    }

    public f(String str, b bVar) {
        this.f34313d = bVar;
        this.f34314e = str;
        e();
    }

    public final void e() {
        d4.f.y().H(this.f34314e, this.f34315f);
    }

    public void j() {
        d4.f.y().O(this.f34314e, this.f34315f);
    }

    public byte l() {
        return this.f34310a;
    }

    public boolean m() {
        return (this.f34311b == null || this.f34312c == null || this.f34310a == 0) ? false : true;
    }

    public boolean n() {
        return (this.f34311b == null || this.f34312c == null || this.f34310a != 2) ? false : true;
    }

    public boolean o() {
        return (this.f34311b == null || this.f34312c == null || this.f34310a != 1) ? false : true;
    }

    public boolean p() {
        if (this.f34312c == null) {
            k4.b.s("ALERT_LEVEL_CHARACTERISTIC_UUID not supported");
            return false;
        }
        k4.b.e("read alert info.");
        return d4.f.y().F(this.f34314e, this.f34312c);
    }

    public boolean q(boolean z7) {
        k4.b.e("enable: " + z7);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.f34312c;
        if (bluetoothGattCharacteristic == null) {
            k4.b.s("ALERT_LEVEL_CHARACTERISTIC_UUID not supported");
            return false;
        }
        if (z7) {
            bluetoothGattCharacteristic.setValue(new byte[]{2});
        } else {
            bluetoothGattCharacteristic.setValue(new byte[]{0});
        }
        return d4.f.y().Q(this.f34314e, this.f34312c);
    }

    public boolean r(byte b8) {
        return s(this.f34314e, b8);
    }

    public boolean s(String str, byte b8) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.f34312c;
        if (bluetoothGattCharacteristic == null) {
            k4.b.h("ALERT_LEVEL_CHARACTERISTIC not supported");
            return false;
        }
        bluetoothGattCharacteristic.setValue(new byte[]{b8});
        this.f34310a = b8;
        return d4.f.y().Q(str, this.f34312c);
    }
}
