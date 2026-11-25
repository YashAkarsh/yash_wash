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
public class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final UUID f34266g = UUID.fromString("0000180f-0000-1000-8000-00805f9b34fb");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final UUID f34267h = UUID.fromString("00002a19-0000-1000-8000-00805f9b34fb");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final UUID f34268i = UUID.fromString("00002904-0000-1000-8000-00805f9b34fb");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final UUID f34269j = UUID.fromString(d4.f.f33494r);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BluetoothGattService f34270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BluetoothGattCharacteristic f34271b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f34273d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f34274e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f34272c = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BluetoothGattCallback f34275f = new C0417a();

    /* JADX INFO: renamed from: j4.a$a, reason: collision with other inner class name */
    public class C0417a extends BluetoothGattCallback {
        public C0417a() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            byte[] value = bluetoothGattCharacteristic.getValue();
            if (a.this.f34271b != null && a.f34267h.equals(bluetoothGattCharacteristic.getUuid())) {
                a.this.f34272c = value[0];
                k4.b.p("mBatteryValue=" + a.this.f34272c);
                if (a.this.f34273d != null) {
                    a.this.f34273d.a(a.this.f34272c, true);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i7) {
            byte[] value = bluetoothGattCharacteristic.getValue();
            if (i7 != 0) {
                k4.b.s("Characteristic read error: " + i7);
                return;
            }
            if (a.f34267h.equals(bluetoothGattCharacteristic.getUuid())) {
                a.this.f34272c = value[0];
                k4.b.p("mBatteryValue=" + a.this.f34272c);
                if (a.this.f34273d != null) {
                    a.this.f34273d.a(a.this.f34272c, false);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i7) {
            if (i7 == 0) {
                if (a.f34267h.equals(bluetoothGattDescriptor.getCharacteristic().getUuid()) && a.f34269j.equals(bluetoothGattDescriptor.getUuid())) {
                    k4.b.e("CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR write OK.");
                    return;
                }
                return;
            }
            k4.b.s("Descriptor write error: " + i7);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i7) {
            if (i7 == 0) {
                a.this.f34270a = bluetoothGatt.getService(a.f34266g);
                if (a.this.f34270a == null) {
                    k4.b.s("BATTERY_SERVICE not supported");
                    return;
                }
                a aVar = a.this;
                aVar.f34271b = aVar.f34270a.getCharacteristic(a.f34267h);
                if (a.this.f34271b == null) {
                    k4.b.s("BATTERY_LEVEL_CHARACTERISTIC not supported");
                    return;
                }
                k4.b.p("find BATTERY_LEVEL_CHARACTERISTIC: " + a.f34267h);
                List<BluetoothGattDescriptor> descriptors = a.this.f34271b.getDescriptors();
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
        void a(int i7, boolean z7);
    }

    public a(String str, b bVar) {
        this.f34273d = bVar;
        this.f34274e = str;
        e();
    }

    public static boolean m(byte[] bArr, byte[] bArr2, int i7) {
        if (bArr == null && bArr2 == null) {
            return true;
        }
        if (bArr == null || bArr2 == null) {
            return false;
        }
        if (bArr == bArr2) {
            return true;
        }
        for (int i8 = 0; i8 < bArr.length && i8 < bArr2.length && i8 < i7; i8++) {
            if (bArr[i8] != bArr2[i8]) {
                return false;
            }
        }
        return true;
    }

    public final void e() {
        d4.f.y().H(this.f34274e, this.f34275f);
    }

    public void j() {
        d4.f.y().O(this.f34274e, this.f34275f);
    }

    public int l() {
        return this.f34272c;
    }

    public boolean n() {
        if (this.f34271b != null) {
            return d4.f.y().G(this.f34274e, this.f34271b);
        }
        k4.b.e("BATTERY_LEVEL_CHARACTERISTIC not supported");
        return false;
    }

    public boolean o(boolean z7) {
        if (this.f34271b != null) {
            return d4.f.y().M(this.f34274e, this.f34271b, f34269j, z7);
        }
        k4.b.t(true, "BATTERY_LEVEL_CHARACTERISTIC not supported");
        return false;
    }
}
