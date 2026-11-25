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
public class e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final UUID f34295e = UUID.fromString("00001802-0000-1000-8000-00805f9b34fb");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final UUID f34296f = UUID.fromString("00002a06-0000-1000-8000-00805f9b34fb");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte f34297g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte f34298h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte f34299i = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BluetoothGattService f34300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BluetoothGattCharacteristic f34301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f34302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BluetoothGattCallback f34303d = new a();

    public class a extends BluetoothGattCallback {
        public a() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i7) {
            if (i7 == 0) {
                e.this.f34300a = bluetoothGatt.getService(e.f34295e);
                if (e.this.f34300a == null) {
                    k4.b.s("IMMEDIATE_ALERT_SERVICE not supported");
                    return;
                }
                e eVar = e.this;
                eVar.f34301b = eVar.f34300a.getCharacteristic(e.f34296f);
                if (e.this.f34301b == null) {
                    k4.b.s("ALERT_LEVEL_CHARACTERISTIC not supported");
                    return;
                }
                k4.b.e("find ALERT_LEVEL_CHARACTERISTIC : " + e.f34296f);
                e.this.f34301b.setWriteType(1);
                List<BluetoothGattDescriptor> descriptors = e.this.f34301b.getDescriptors();
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

    public e(String str) {
        this.f34302c = str;
        d();
    }

    public final void d() {
        d4.f.y().H(this.f34302c, this.f34303d);
    }

    public void h() {
        d4.f.y().O(this.f34302c, this.f34303d);
    }

    public boolean i(byte b8) {
        return j(this.f34302c, b8);
    }

    public boolean j(String str, byte b8) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.f34301b;
        if (bluetoothGattCharacteristic == null) {
            k4.b.s("ALERT_LEVEL_CHARACTERISTIC not supported");
            return false;
        }
        bluetoothGattCharacteristic.setValue(new byte[]{b8});
        return d4.f.y().Q(str, this.f34301b);
    }

    public boolean k(String str, boolean z7) {
        k4.b.e("enabled=" + z7);
        return j(str, z7 ? (byte) 2 : (byte) 0);
    }

    public boolean l(boolean z7) {
        return k(this.f34302c, z7);
    }
}
